package com.sm.open.mbprod.integration.test;

import com.sm.open.core.facade.mb.test.MbTestFacade;
import com.sm.open.core.facade.model.param.mb.test.MbTestParam;
import com.sm.open.core.facade.model.rpc.CommonResult;
import com.sm.open.mbprod.integration.common.log.Loggable;
import com.sm.open.mbprod.integration.common.retry.Retryable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class MbTestClient {

    @Resource
    private MbTestFacade mbTestFacade;

    @Loggable(bizType = "MbTestClient-testOpen")
    @Retryable
    public CommonResult<Integer> testOpen(MbTestParam mbTestParam) {
        return mbTestFacade.testOpen(mbTestParam);
    }
}
