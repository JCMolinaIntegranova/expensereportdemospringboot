package com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.viewmodel.ServiceResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.Map;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DummyResponse")
public class DummyResponse extends ServiceResponse {

    @ApiModelProperty(name = "Result Code")
    @JsonProperty("psresultcode")
    private String expenseReportdummypsResultCode;

    public DummyResponse() {
        super();
    }

    public String getExpenseReportdummypsResultCode() {
        return this.expenseReportdummypsResultCode;
    }
    
    public void setExpenseReportdummypsResultCode(String expenseReportdummypsResultCode) {
        this.expenseReportdummypsResultCode = expenseReportdummypsResultCode;
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("expenseReportdummypsResultCode", expenseReportdummypsResultCode);
        return outArgs;
    }
}
