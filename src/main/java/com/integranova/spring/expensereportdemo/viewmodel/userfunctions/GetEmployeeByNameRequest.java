package com.integranova.spring.expensereportdemo.viewmodel.userfunctions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.userfunctions.GetEmployeeByNameRequest")
public class GetEmployeeByNameRequest {

    @ApiModelProperty(name = "pf_Name")
    @JsonProperty("pf_name")
    private String pfName;

    public GetEmployeeByNameRequest() {
        // Default constructor
    }
    
    @JsonIgnore
    public String getPfName() {
        return this.pfName;
    }
    
    public void setPfName(String pfName) {
        this.pfName = pfName;
    }
}
