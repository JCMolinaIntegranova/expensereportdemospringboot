package com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ExpenseReportConstants;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseReportOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.EditinstanceRequest")
public class EditinstanceRequest {

    @ApiModelProperty(name = "Expense Report")
    @JsonProperty("p_thisexpensereport_oid")
    private ExpenseReportOid expenseReporteditinstancepthisExpenseReport;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ExpenseReport expenseReporteditinstancepthisExpenseReportInstance;

    @ApiModelProperty(name = "Cause")
    @JsonProperty("p_cause")
    private String expenseReporteditinstancepCause;

    @ApiModelProperty(name = "Advances")
    @JsonProperty("p_advances")
    private Double expenseReporteditinstancepAdvances;

    @ApiModelProperty(name = "Exchange")
    @JsonProperty("p_exchange")
    private Double expenseReporteditinstancepExchange;

    public void checkArguments() throws NotNullArgumentException {
        checkExpenseReporteditinstancepthisExpenseReport();
        checkExpenseReporteditinstancepCause();
        checkExpenseReporteditinstancepAdvances();
        checkExpenseReporteditinstancepExchange();
    }

    @JsonIgnore
    public ExpenseReportOid getExpenseReporteditinstancepthisExpenseReport() {
        return this.expenseReporteditinstancepthisExpenseReport;
    }
    
    public void setExpenseReporteditinstancepthisExpenseReport(ExpenseReportOid expenseReporteditinstancepthisExpenseReport) {
        this.expenseReporteditinstancepthisExpenseReport = expenseReporteditinstancepthisExpenseReport;
    }

    @JsonIgnore
    public ExpenseReport getExpenseReporteditinstancepthisExpenseReportInstance() {
        return this.expenseReporteditinstancepthisExpenseReportInstance;
    }
    
    public void setExpenseReporteditinstancepthisExpenseReportInstance(ExpenseReport expenseReporteditinstancepthisExpenseReport) {
        this.expenseReporteditinstancepthisExpenseReportInstance = expenseReporteditinstancepthisExpenseReport;
    }

    private void checkExpenseReporteditinstancepthisExpenseReport() throws NotNullArgumentException {
        if(this.getExpenseReporteditinstancepthisExpenseReportInstance() == null || this.getExpenseReporteditinstancepthisExpenseReportInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_EDITINSTANCE, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_EDITINSTANCE_EXPENSEREPORTEDITINSTANCEPTHISEXPENSEREPORT, ExpenseReportConstants.SERV_ALIAS_EDITINSTANCE, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_EDITINSTANCE_EXPENSEREPORTEDITINSTANCEPTHISEXPENSEREPORT);
        }
    }

    @JsonIgnore
    public String getExpenseReporteditinstancepCause() {
        return this.expenseReporteditinstancepCause;
    }
    
    public void setExpenseReporteditinstancepCause(String expenseReporteditinstancepCause) {
        this.expenseReporteditinstancepCause = expenseReporteditinstancepCause;
    }

    private void checkExpenseReporteditinstancepCause() throws NotNullArgumentException {
        if(this.getExpenseReporteditinstancepCause() == null) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_EDITINSTANCE, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_EDITINSTANCE_EXPENSEREPORTEDITINSTANCEPCAUSE, ExpenseReportConstants.SERV_ALIAS_EDITINSTANCE, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_EDITINSTANCE_EXPENSEREPORTEDITINSTANCEPCAUSE);
        }
    }

    @JsonIgnore
    public Double getExpenseReporteditinstancepAdvances() {
        return this.expenseReporteditinstancepAdvances;
    }
    
    public void setExpenseReporteditinstancepAdvances(Double expenseReporteditinstancepAdvances) {
        this.expenseReporteditinstancepAdvances = expenseReporteditinstancepAdvances;
    }

    private void checkExpenseReporteditinstancepAdvances() throws NotNullArgumentException {
        if(this.getExpenseReporteditinstancepAdvances() == null) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_EDITINSTANCE, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_EDITINSTANCE_EXPENSEREPORTEDITINSTANCEPADVANCES, ExpenseReportConstants.SERV_ALIAS_EDITINSTANCE, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_EDITINSTANCE_EXPENSEREPORTEDITINSTANCEPADVANCES);
        }
    }

    @JsonIgnore
    public Double getExpenseReporteditinstancepExchange() {
        return this.expenseReporteditinstancepExchange;
    }
    
    public void setExpenseReporteditinstancepExchange(Double expenseReporteditinstancepExchange) {
        this.expenseReporteditinstancepExchange = expenseReporteditinstancepExchange;
    }

    private void checkExpenseReporteditinstancepExchange() throws NotNullArgumentException {
        if(this.getExpenseReporteditinstancepExchange() == null) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_EDITINSTANCE, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_EDITINSTANCE_EXPENSEREPORTEDITINSTANCEPEXCHANGE, ExpenseReportConstants.SERV_ALIAS_EDITINSTANCE, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_EDITINSTANCE_EXPENSEREPORTEDITINSTANCEPEXCHANGE);
        }
    }
}
