package com.sm.open.mbprod.web.rest.test;

import com.sm.open.care.core.ResultObject;
import com.sm.open.mbprod.model.dto.test.MbTestDto;
import com.sm.open.mbprod.service.test.MbTestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 测试Controller
 */
@Controller
@RequestMapping(value = "/r/test")
public class MbTestController {

    @Resource
    private MbTestService mbTestService;

    /**
     * 测试rest服务
     * @param request
     * @return
     */
    @RequestMapping(value = "/test")
    @ResponseBody
    public ResultObject testOpen(HttpServletRequest request, @RequestBody MbTestDto mbTestDto) {
        return ResultObject.create("testOpen", ResultObject.SUCCESS_CODE, ResultObject.MSG_SUCCESS,
                ResultObject.DATA_TYPE_OBJECT, mbTestService.testOpen(mbTestDto));
    }
}
