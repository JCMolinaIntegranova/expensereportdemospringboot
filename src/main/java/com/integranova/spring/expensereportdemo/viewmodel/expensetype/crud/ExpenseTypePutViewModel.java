package com.integranova.spring.expensereportdemo.viewmodel.expensetype.crud;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExpenseTypePutViewModel {

    @JsonProperty(value="TyDescription")
    private String expenseTypeTyDescription;

    @JsonProperty(value="Price")
    private Double expenseTypePrice;

    @JsonProperty(value="FixedPrice")
    private Boolean expenseTypeFixedPrice;

    public String getExpenseTypeTyDescription() {
        return expenseTypeTyDescription;
    }
    
    public void setExpenseTypeTyDescription(String expenseTypeTyDescription) {
        this.expenseTypeTyDescription = expenseTypeTyDescription;
    }

    public Double getExpenseTypePrice() {
        return expenseTypePrice;
    }
    
    public void setExpenseTypePrice(Double expenseTypePrice) {
        this.expenseTypePrice = expenseTypePrice;
    }

    public Boolean getExpenseTypeFixedPrice() {
        return expenseTypeFixedPrice;
    }
    
    public void setExpenseTypeFixedPrice(Boolean expenseTypeFixedPrice) {
        this.expenseTypeFixedPrice = expenseTypeFixedPrice;
    }
}
