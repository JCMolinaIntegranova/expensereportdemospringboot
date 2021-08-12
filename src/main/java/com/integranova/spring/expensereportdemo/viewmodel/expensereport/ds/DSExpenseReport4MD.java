package com.integranova.spring.expensereportdemo.viewmodel.expensereport.ds;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensereport.ds.DSExpenseReport4MD")
public class DSExpenseReport4MD {

    @ApiModelProperty(name = "ID")
    @JsonProperty("idexpenserepor")
    private Long dSExpenseReport4MDIdExpenseRepor;

    @ApiModelProperty(name = "Presentation Date")
    @JsonProperty("presentdate")
    private Date dSExpenseReport4MDPresentDate;

    @ApiModelProperty(name = "Project")
    @JsonProperty("project_projectname")
    private String dSExpenseReport4MDProjectDotProjectName;

    @ApiModelProperty(name = "Cause")
    @JsonProperty("cause")
    private String dSExpenseReport4MDCause;

    @ApiModelProperty(name = "Currency")
    @JsonProperty("expensecurrency_currencyname")
    private String dSExpenseReport4MDExpenseCurrencyDotCurrencyName;

    @ApiModelProperty(name = "Exchange")
    @JsonProperty("exchange")
    private Double dSExpenseReport4MDExchange;

    @ApiModelProperty(name = "Balance in Currency")
    @JsonProperty("balancecur")
    private Double dSExpenseReport4MDBalanceCur;

    @ApiModelProperty(name = "Status")
    @JsonProperty("status")
    private Long dSExpenseReport4MDStatus;

    public DSExpenseReport4MD() {
    
    }
    
    public DSExpenseReport4MD(ExpenseReport instance) {
        if (instance != null) {
            try {
                this.dSExpenseReport4MDIdExpenseRepor = instance.getExpenseReportidExpenseRepor();
                this.dSExpenseReport4MDPresentDate = instance.getExpenseReportPresentDate();
                this.dSExpenseReport4MDProjectDotProjectName = instance.getProject().getProjectProjectName();
                this.dSExpenseReport4MDCause = instance.getExpenseReportCause();
                this.dSExpenseReport4MDExpenseCurrencyDotCurrencyName = instance.getExpenseCurrency().getExpenseCurrencyCurrencyName();
                this.dSExpenseReport4MDExchange = instance.getExpenseReportExchange();
                this.dSExpenseReport4MDBalanceCur = instance.getExpenseReportBalanceCur();
                this.dSExpenseReport4MDStatus = instance.getExpenseReportStatus();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    public Long getDSExpenseReport4MDIdExpenseRepor() {
        return this.dSExpenseReport4MDIdExpenseRepor;
    }
    
    public void setDSExpenseReport4MDIdExpenseRepor(Long dSExpenseReport4MDIdExpenseRepor) {
        this.dSExpenseReport4MDIdExpenseRepor = dSExpenseReport4MDIdExpenseRepor;
    }

    public Date getDSExpenseReport4MDPresentDate() {
        return this.dSExpenseReport4MDPresentDate;
    }
    
    public void setDSExpenseReport4MDPresentDate(Date dSExpenseReport4MDPresentDate) {
        this.dSExpenseReport4MDPresentDate = dSExpenseReport4MDPresentDate;
    }

    public String getDSExpenseReport4MDProjectDotProjectName() {
        return this.dSExpenseReport4MDProjectDotProjectName;
    }
    
    public void setDSExpenseReport4MDProjectDotProjectName(String dSExpenseReport4MDProjectDotProjectName) {
        this.dSExpenseReport4MDProjectDotProjectName = dSExpenseReport4MDProjectDotProjectName;
    }

    public String getDSExpenseReport4MDCause() {
        return this.dSExpenseReport4MDCause;
    }
    
    public void setDSExpenseReport4MDCause(String dSExpenseReport4MDCause) {
        this.dSExpenseReport4MDCause = dSExpenseReport4MDCause;
    }

    public String getDSExpenseReport4MDExpenseCurrencyDotCurrencyName() {
        return this.dSExpenseReport4MDExpenseCurrencyDotCurrencyName;
    }
    
    public void setDSExpenseReport4MDExpenseCurrencyDotCurrencyName(String dSExpenseReport4MDExpenseCurrencyDotCurrencyName) {
        this.dSExpenseReport4MDExpenseCurrencyDotCurrencyName = dSExpenseReport4MDExpenseCurrencyDotCurrencyName;
    }

    public Double getDSExpenseReport4MDExchange() {
        return this.dSExpenseReport4MDExchange;
    }
    
    public void setDSExpenseReport4MDExchange(Double dSExpenseReport4MDExchange) {
        this.dSExpenseReport4MDExchange = dSExpenseReport4MDExchange;
    }

    public Double getDSExpenseReport4MDBalanceCur() {
        return this.dSExpenseReport4MDBalanceCur;
    }
    
    public void setDSExpenseReport4MDBalanceCur(Double dSExpenseReport4MDBalanceCur) {
        this.dSExpenseReport4MDBalanceCur = dSExpenseReport4MDBalanceCur;
    }

    public Long getDSExpenseReport4MDStatus() {
        return this.dSExpenseReport4MDStatus;
    }
    
    public void setDSExpenseReport4MDStatus(Long dSExpenseReport4MDStatus) {
        this.dSExpenseReport4MDStatus = dSExpenseReport4MDStatus;
    }
}
