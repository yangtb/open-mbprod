package com.sm.open.mbprod.model.dto.test;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class MbTestDto implements Serializable {

    private static final long serialVersionUID = 2800997001211216293L;

    @JSONField(name = "test_id")
    private Long    testId;
    @JSONField(name = "testName")
    private String  test_name;

    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    public String getTest_name() {
        return test_name;
    }

    public void setTest_name(String test_name) {
        this.test_name = test_name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MbTestDto{");
        sb.append("testId=").append(testId);
        sb.append(", test_name='").append(test_name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
