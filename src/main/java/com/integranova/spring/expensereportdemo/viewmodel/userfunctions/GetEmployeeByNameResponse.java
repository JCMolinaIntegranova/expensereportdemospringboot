package com.integranova.spring.expensereportdemo.viewmodel.userfunctions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.persistence.oid.EmployeeOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Map;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.userfunctions.GetEmployeeByNameResponse")
public class GetEmployeeByNameResponse {

    private EmployeeOid functionResult;


    @ApiModelProperty(name = "out_Found")
    @JsonProperty("out_found")
    private Boolean outFound;

    public GetEmployeeByNameResponse() {
    
    }
    
    public GetEmployeeByNameResponse(EmployeeOid functionResult, Map<String, Object> outArgs) {
        this.functionResult = functionResult;
        this.outFound = (Boolean) outArgs.get("outFound");
    }
    
    public EmployeeOid getFunctionResult() {
        return functionResult;
    }
    
    public void setFunctionResult(EmployeeOid functionResult) {
        this.functionResult = functionResult;
    }
    

    @JsonIgnore
    public Boolean getOutFound() {
        return this.outFound;
    }
    
    public void setOutFound(Boolean outFound) {
        this.outFound = outFound;
    }
}
