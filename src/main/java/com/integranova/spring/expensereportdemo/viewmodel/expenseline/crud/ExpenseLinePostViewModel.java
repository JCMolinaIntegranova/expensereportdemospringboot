package com.integranova.spring.expensereportdemo.viewmodel.expenseline.crud;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Date;

public class ExpenseLinePostViewModel {

    @JsonProperty(value="ExpenseDate")
    private Date expenseLineExpenseDate;

    @JsonProperty(value="Units")
    private Double expenseLineUnits;

    @JsonProperty(value="Price")
    private Double expenseLinePrice;

    @JsonProperty(value="LnDescription")
    private String expenseLineLnDescription;

    public Date getExpenseLineExpenseDate() {
        return expenseLineExpenseDate;
    }
    
    public void setExpenseLineExpenseDate(Date expenseLineExpenseDate) {
        this.expenseLineExpenseDate = expenseLineExpenseDate;
    }

    public Double getExpenseLineUnits() {
        return expenseLineUnits;
    }
    
    public void setExpenseLineUnits(Double expenseLineUnits) {
        this.expenseLineUnits = expenseLineUnits;
    }

    public Double getExpenseLinePrice() {
        return expenseLinePrice;
    }
    
    public void setExpenseLinePrice(Double expenseLinePrice) {
        this.expenseLinePrice = expenseLinePrice;
    }

    public String getExpenseLineLnDescription() {
        return expenseLineLnDescription;
    }
    
    public void setExpenseLineLnDescription(String expenseLineLnDescription) {
        this.expenseLineLnDescription = expenseLineLnDescription;
    }
}
