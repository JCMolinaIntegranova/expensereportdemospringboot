package com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.crud;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExpenseCurrencyPostViewModel {

    @JsonProperty(value="CurrencyCode")
    private String expenseCurrencyCurrencyCode;

    @JsonProperty(value="CurrencyName")
    private String expenseCurrencyCurrencyName;

    @JsonProperty(value="CurAcronym")
    private String expenseCurrencyCurAcronym;

    @JsonProperty(value="Exchange")
    private Double expenseCurrencyExchange;

    public String getExpenseCurrencyCurrencyCode() {
        return expenseCurrencyCurrencyCode;
    }
    
    public void setExpenseCurrencyCurrencyCode(String expenseCurrencyCurrencyCode) {
        this.expenseCurrencyCurrencyCode = expenseCurrencyCurrencyCode;
    }

    public String getExpenseCurrencyCurrencyName() {
        return expenseCurrencyCurrencyName;
    }
    
    public void setExpenseCurrencyCurrencyName(String expenseCurrencyCurrencyName) {
        this.expenseCurrencyCurrencyName = expenseCurrencyCurrencyName;
    }

    public String getExpenseCurrencyCurAcronym() {
        return expenseCurrencyCurAcronym;
    }
    
    public void setExpenseCurrencyCurAcronym(String expenseCurrencyCurAcronym) {
        this.expenseCurrencyCurAcronym = expenseCurrencyCurAcronym;
    }

    public Double getExpenseCurrencyExchange() {
        return expenseCurrencyExchange;
    }
    
    public void setExpenseCurrencyExchange(Double expenseCurrencyExchange) {
        this.expenseCurrencyExchange = expenseCurrencyExchange;
    }
}
