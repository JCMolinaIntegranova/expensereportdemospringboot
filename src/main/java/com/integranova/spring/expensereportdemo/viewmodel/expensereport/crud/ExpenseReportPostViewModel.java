package com.integranova.spring.expensereportdemo.viewmodel.expensereport.crud;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Date;

public class ExpenseReportPostViewModel {

    @JsonProperty(value="PresentDate")
    private Date expenseReportPresentDate;

    @JsonProperty(value="Cause")
    private String expenseReportCause;

    @JsonProperty(value="Advances")
    private Double expenseReportAdvances;

    @JsonProperty(value="Exchange")
    private Double expenseReportExchange;

    public Date getExpenseReportPresentDate() {
        return expenseReportPresentDate;
    }
    
    public void setExpenseReportPresentDate(Date expenseReportPresentDate) {
        this.expenseReportPresentDate = expenseReportPresentDate;
    }

    public String getExpenseReportCause() {
        return expenseReportCause;
    }
    
    public void setExpenseReportCause(String expenseReportCause) {
        this.expenseReportCause = expenseReportCause;
    }

    public Double getExpenseReportAdvances() {
        return expenseReportAdvances;
    }
    
    public void setExpenseReportAdvances(Double expenseReportAdvances) {
        this.expenseReportAdvances = expenseReportAdvances;
    }

    public Double getExpenseReportExchange() {
        return expenseReportExchange;
    }
    
    public void setExpenseReportExchange(Double expenseReportExchange) {
        this.expenseReportExchange = expenseReportExchange;
    }
}
