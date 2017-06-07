package com.sm.open.mbprod.service.test.impl;

import com.sm.open.care.core.utils.MedicalBeanUtil;
import com.sm.open.core.facade.model.param.mb.test.MbTestParam;
import com.sm.open.core.facade.model.rpc.CommonResult;
import com.sm.open.mbprod.integration.test.MbTestClient;
import com.sm.open.mbprod.model.dto.test.MbTestDto;
import com.sm.open.mbprod.service.test.MbTestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("mbTestService")
public class MbTestServiceImpl implements MbTestService {

    @Resource
    private MbTestClient mbTestClient;

    @Override
    public Integer testOpen(MbTestDto mbTestDto) {
        MbTestParam mbTestParam = MedicalBeanUtil.convert(mbTestDto, MbTestParam.class);
        CommonResult<Integer> result = mbTestClient.testOpen(mbTestParam);
        if (result == null || !result.getIsSuccess()) {
            return null;
        }
        return result.getContent();
    }
}
