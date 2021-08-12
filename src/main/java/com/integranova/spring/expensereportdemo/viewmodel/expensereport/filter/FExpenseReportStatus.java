package com.integranova.spring.expensereportdemo.viewmodel.expensereport.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.integranova.spring.expensereportdemo.global.ExpenseReportConstants;
import com.integranova.spring.expensereportdemo.viewmodel.FilterRequest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensereport.filter.FExpenseReportStatus")
public class FExpenseReportStatus {

    @ApiModelProperty(name = "Status")
    @JsonProperty("v_status")
    private Long vStatus;

    public FExpenseReportStatus() {
        // Default constructor
    }

    @JsonIgnore
    public Long getVStatus() {
        return this.vStatus;
    }
    
    public void setVStatus(Long vStatus) {
        this.vStatus = vStatus;
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(ExpenseReportConstants.FILTER_NAME_FEXPENSEREPORTSTATUS);
        filterRequest.addFilterVariable(ExpenseReportConstants.VAR_NAME_FEXPENSEREPORTSTATUS_VSTATUS, vStatus);
        return filterRequest;
    }
}
