package com.integranova.spring.expensereportdemo.viewmodel.expensereport.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.integranova.spring.expensereportdemo.global.ExpenseReportConstants;
import com.integranova.spring.expensereportdemo.viewmodel.FilterRequest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensereport.filter.FByID")
public class FByID {

    @ApiModelProperty(name = "Id. Project")
    @JsonProperty("v_id")
    private Long vID;

    public FByID() {
        // Default constructor
    }

    @JsonIgnore
    public Long getVID() {
        return this.vID;
    }
    
    public void setVID(Long vID) {
        this.vID = vID;
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(ExpenseReportConstants.FILTER_NAME_FBYID);
        filterRequest.addFilterVariable(ExpenseReportConstants.VAR_NAME_FBYID_VID, vID);
        return filterRequest;
    }
}
