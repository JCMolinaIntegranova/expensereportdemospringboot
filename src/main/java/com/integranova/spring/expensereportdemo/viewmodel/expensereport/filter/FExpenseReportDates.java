package com.integranova.spring.expensereportdemo.viewmodel.expensereport.filter;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.integranova.spring.expensereportdemo.global.ExpenseReportConstants;
import com.integranova.spring.expensereportdemo.viewmodel.FilterRequest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensereport.filter.FExpenseReportDates")
public class FExpenseReportDates {

    @ApiModelProperty(name = "Initial date")
    @JsonProperty("v_inidate")
    private Date vIniDate;

    @ApiModelProperty(name = "Final date")
    @JsonProperty("v_finaldate")
    private Date vFinalDate;

    public FExpenseReportDates() {
        // Default constructor
    }

    @JsonIgnore
    public Date getVIniDate() {
        return this.vIniDate;
    }
    
    public void setVIniDate(Date vIniDate) {
        this.vIniDate = vIniDate;
    }

    @JsonIgnore
    public Date getVFinalDate() {
        return this.vFinalDate;
    }
    
    public void setVFinalDate(Date vFinalDate) {
        this.vFinalDate = vFinalDate;
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(ExpenseReportConstants.FILTER_NAME_FEXPENSEREPORTDATES);
        filterRequest.addFilterVariable(ExpenseReportConstants.VAR_NAME_FEXPENSEREPORTDATES_VINIDATE, vIniDate);
        filterRequest.addFilterVariable(ExpenseReportConstants.VAR_NAME_FEXPENSEREPORTDATES_VFINALDATE, vFinalDate);
        return filterRequest;
    }
}
