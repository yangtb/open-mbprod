package com.sm.open.mbprod.model.dto.test;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class MbTestDto implements Serializable {

    private static final long serialVersionUID = 2800997001211216293L;

    @JSONField(name = "test_id")
    private Long    testId;
    @JSONField(name = "test_name")
    private String  testName;

    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MbTestDto{");
        sb.append("testId=").append(testId);
        sb.append(", testName='").append(testName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
