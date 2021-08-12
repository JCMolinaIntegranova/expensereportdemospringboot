package com.integranova.spring.expensereportdemo.viewmodel.expensereport.ds;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensereport.ds.DSExpenseReport4HAT")
public class DSExpenseReport4HAT {

    @ApiModelProperty(name = "ID")
    @JsonProperty("idexpenserepor")
    private Long dSExpenseReport4HATIdExpenseRepor;

    @ApiModelProperty(name = "Presentation Date")
    @JsonProperty("presentdate")
    private Date dSExpenseReport4HATPresentDate;

    @ApiModelProperty(name = "Project")
    @JsonProperty("project_projectname")
    private String dSExpenseReport4HATProjectDotProjectName;

    @ApiModelProperty(name = "Employee")
    @JsonProperty("employee_empname")
    private String dSExpenseReport4HATEmployeeDotEmpName;

    @ApiModelProperty(name = "Cause")
    @JsonProperty("cause")
    private String dSExpenseReport4HATCause;

    @ApiModelProperty(name = "Currency")
    @JsonProperty("expensecurrency_currencyname")
    private String dSExpenseReport4HATExpenseCurrencyDotCurrencyName;

    @ApiModelProperty(name = "Exchange")
    @JsonProperty("exchange")
    private Double dSExpenseReport4HATExchange;

    @ApiModelProperty(name = "Balance in Currency")
    @JsonProperty("balancecur")
    private Double dSExpenseReport4HATBalanceCur;

    @ApiModelProperty(name = "Status")
    @JsonProperty("status")
    private Long dSExpenseReport4HATStatus;

    public DSExpenseReport4HAT() {
    
    }
    
    public DSExpenseReport4HAT(ExpenseReport instance) {
        if (instance != null) {
            try {
                this.dSExpenseReport4HATIdExpenseRepor = instance.getExpenseReportidExpenseRepor();
                this.dSExpenseReport4HATPresentDate = instance.getExpenseReportPresentDate();
                this.dSExpenseReport4HATProjectDotProjectName = instance.getProject().getProjectProjectName();
                this.dSExpenseReport4HATEmployeeDotEmpName = instance.getEmployee().getEmployeeEmpName();
                this.dSExpenseReport4HATCause = instance.getExpenseReportCause();
                this.dSExpenseReport4HATExpenseCurrencyDotCurrencyName = instance.getExpenseCurrency().getExpenseCurrencyCurrencyName();
                this.dSExpenseReport4HATExchange = instance.getExpenseReportExchange();
                this.dSExpenseReport4HATBalanceCur = instance.getExpenseReportBalanceCur();
                this.dSExpenseReport4HATStatus = instance.getExpenseReportStatus();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    public Long getDSExpenseReport4HATIdExpenseRepor() {
        return this.dSExpenseReport4HATIdExpenseRepor;
    }
    
    public void setDSExpenseReport4HATIdExpenseRepor(Long dSExpenseReport4HATIdExpenseRepor) {
        this.dSExpenseReport4HATIdExpenseRepor = dSExpenseReport4HATIdExpenseRepor;
    }

    public Date getDSExpenseReport4HATPresentDate() {
        return this.dSExpenseReport4HATPresentDate;
    }
    
    public void setDSExpenseReport4HATPresentDate(Date dSExpenseReport4HATPresentDate) {
        this.dSExpenseReport4HATPresentDate = dSExpenseReport4HATPresentDate;
    }

    public String getDSExpenseReport4HATProjectDotProjectName() {
        return this.dSExpenseReport4HATProjectDotProjectName;
    }
    
    public void setDSExpenseReport4HATProjectDotProjectName(String dSExpenseReport4HATProjectDotProjectName) {
        this.dSExpenseReport4HATProjectDotProjectName = dSExpenseReport4HATProjectDotProjectName;
    }

    public String getDSExpenseReport4HATEmployeeDotEmpName() {
        return this.dSExpenseReport4HATEmployeeDotEmpName;
    }
    
    public void setDSExpenseReport4HATEmployeeDotEmpName(String dSExpenseReport4HATEmployeeDotEmpName) {
        this.dSExpenseReport4HATEmployeeDotEmpName = dSExpenseReport4HATEmployeeDotEmpName;
    }

    public String getDSExpenseReport4HATCause() {
        return this.dSExpenseReport4HATCause;
    }
    
    public void setDSExpenseReport4HATCause(String dSExpenseReport4HATCause) {
        this.dSExpenseReport4HATCause = dSExpenseReport4HATCause;
    }

    public String getDSExpenseReport4HATExpenseCurrencyDotCurrencyName() {
        return this.dSExpenseReport4HATExpenseCurrencyDotCurrencyName;
    }
    
    public void setDSExpenseReport4HATExpenseCurrencyDotCurrencyName(String dSExpenseReport4HATExpenseCurrencyDotCurrencyName) {
        this.dSExpenseReport4HATExpenseCurrencyDotCurrencyName = dSExpenseReport4HATExpenseCurrencyDotCurrencyName;
    }

    public Double getDSExpenseReport4HATExchange() {
        return this.dSExpenseReport4HATExchange;
    }
    
    public void setDSExpenseReport4HATExchange(Double dSExpenseReport4HATExchange) {
        this.dSExpenseReport4HATExchange = dSExpenseReport4HATExchange;
    }

    public Double getDSExpenseReport4HATBalanceCur() {
        return this.dSExpenseReport4HATBalanceCur;
    }
    
    public void setDSExpenseReport4HATBalanceCur(Double dSExpenseReport4HATBalanceCur) {
        this.dSExpenseReport4HATBalanceCur = dSExpenseReport4HATBalanceCur;
    }

    public Long getDSExpenseReport4HATStatus() {
        return this.dSExpenseReport4HATStatus;
    }
    
    public void setDSExpenseReport4HATStatus(Long dSExpenseReport4HATStatus) {
        this.dSExpenseReport4HATStatus = dSExpenseReport4HATStatus;
    }
}
