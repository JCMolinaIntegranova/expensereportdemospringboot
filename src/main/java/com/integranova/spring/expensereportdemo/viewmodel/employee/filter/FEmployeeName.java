package com.integranova.spring.expensereportdemo.viewmodel.employee.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.integranova.spring.expensereportdemo.global.EmployeeConstants;
import com.integranova.spring.expensereportdemo.viewmodel.FilterRequest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.employee.filter.FEmployeeName")
public class FEmployeeName {

    @ApiModelProperty(name = "Full Name")
    @JsonProperty("v_fullname")
    private String vFullName;

    public FEmployeeName() {
        // Default constructor
    }

    @JsonIgnore
    public String getVFullName() {
        return this.vFullName;
    }
    
    public void setVFullName(String vFullName) {
        this.vFullName = vFullName;
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(EmployeeConstants.FILTER_NAME_FEMPLOYEENAME);
        filterRequest.addFilterVariable(EmployeeConstants.VAR_NAME_FEMPLOYEENAME_VFULLNAME, vFullName);
        return filterRequest;
    }
}
