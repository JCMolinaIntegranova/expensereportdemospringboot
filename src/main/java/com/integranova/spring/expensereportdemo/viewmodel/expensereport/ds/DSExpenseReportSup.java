package com.integranova.spring.expensereportdemo.viewmodel.expensereport.ds;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensereport.ds.DSExpenseReportSup")
public class DSExpenseReportSup {

    @ApiModelProperty(name = "Presentation Date")
    @JsonProperty("presentdate")
    private Date dSExpenseReportSupPresentDate;

    @ApiModelProperty(name = "Status")
    @JsonProperty("status")
    private Long dSExpenseReportSupStatus;

    public DSExpenseReportSup() {
    
    }
    
    public DSExpenseReportSup(ExpenseReport instance) {
        if (instance != null) {
            this.dSExpenseReportSupPresentDate = instance.getExpenseReportPresentDate();
            this.dSExpenseReportSupStatus = instance.getExpenseReportStatus();
        }
    }

    public Date getDSExpenseReportSupPresentDate() {
        return this.dSExpenseReportSupPresentDate;
    }
    
    public void setDSExpenseReportSupPresentDate(Date dSExpenseReportSupPresentDate) {
        this.dSExpenseReportSupPresentDate = dSExpenseReportSupPresentDate;
    }

    public Long getDSExpenseReportSupStatus() {
        return this.dSExpenseReportSupStatus;
    }
    
    public void setDSExpenseReportSupStatus(Long dSExpenseReportSupStatus) {
        this.dSExpenseReportSupStatus = dSExpenseReportSupStatus;
    }
}
