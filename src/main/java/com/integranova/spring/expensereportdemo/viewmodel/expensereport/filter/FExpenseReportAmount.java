package com.integranova.spring.expensereportdemo.viewmodel.expensereport.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.integranova.spring.expensereportdemo.global.ExpenseReportConstants;
import com.integranova.spring.expensereportdemo.viewmodel.FilterRequest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensereport.filter.FExpenseReportAmount")
public class FExpenseReportAmount {

    @ApiModelProperty(name = "Amount")
    @JsonProperty("v_amount")
    private Double vAmount;

    public FExpenseReportAmount() {
        // Default constructor
    }

    @JsonIgnore
    public Double getVAmount() {
        return this.vAmount;
    }
    
    public void setVAmount(Double vAmount) {
        this.vAmount = vAmount;
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(ExpenseReportConstants.FILTER_NAME_FEXPENSEREPORTAMOUNT);
        filterRequest.addFilterVariable(ExpenseReportConstants.VAR_NAME_FEXPENSEREPORTAMOUNT_VAMOUNT, vAmount);
        return filterRequest;
    }
}
