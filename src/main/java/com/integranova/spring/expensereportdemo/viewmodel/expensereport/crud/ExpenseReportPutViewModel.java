package com.integranova.spring.expensereportdemo.viewmodel.expensereport.crud;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Date;

public class ExpenseReportPutViewModel {

    @JsonProperty(value="Status")
    private Long expenseReportStatus;

    @JsonProperty(value="Cause")
    private String expenseReportCause;

    @JsonProperty(value="AuthoDate")
    private Date expenseReportAuthoDate;

    @JsonProperty(value="AuthoComments")
    private String expenseReportAuthoComments;

    @JsonProperty(value="PaymentDate")
    private Date expenseReportPaymentDate;

    @JsonProperty(value="PayComments")
    private String expenseReportPayComments;

    @JsonProperty(value="Advances")
    private Double expenseReportAdvances;

    @JsonProperty(value="Exchange")
    private Double expenseReportExchange;

    public Long getExpenseReportStatus() {
        return expenseReportStatus;
    }
    
    public void setExpenseReportStatus(Long expenseReportStatus) {
        this.expenseReportStatus = expenseReportStatus;
    }

    public String getExpenseReportCause() {
        return expenseReportCause;
    }
    
    public void setExpenseReportCause(String expenseReportCause) {
        this.expenseReportCause = expenseReportCause;
    }

    public Date getExpenseReportAuthoDate() {
        return expenseReportAuthoDate;
    }
    
    public void setExpenseReportAuthoDate(Date expenseReportAuthoDate) {
        this.expenseReportAuthoDate = expenseReportAuthoDate;
    }

    public String getExpenseReportAuthoComments() {
        return expenseReportAuthoComments;
    }
    
    public void setExpenseReportAuthoComments(String expenseReportAuthoComments) {
        this.expenseReportAuthoComments = expenseReportAuthoComments;
    }

    public Date getExpenseReportPaymentDate() {
        return expenseReportPaymentDate;
    }
    
    public void setExpenseReportPaymentDate(Date expenseReportPaymentDate) {
        this.expenseReportPaymentDate = expenseReportPaymentDate;
    }

    public String getExpenseReportPayComments() {
        return expenseReportPayComments;
    }
    
    public void setExpenseReportPayComments(String expenseReportPayComments) {
        this.expenseReportPayComments = expenseReportPayComments;
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
