package com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.ds;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.persistence.ExpenseCurrency;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.ds.DSExpenseCurrency")
public class DSExpenseCurrency {

    @ApiModelProperty(name = "Currency Code")
    @JsonProperty("currencycode")
    private String dSExpenseCurrencyCurrencyCode;

    @ApiModelProperty(name = "Acronym")
    @JsonProperty("curacronym")
    private String dSExpenseCurrencyCurAcronym;

    @ApiModelProperty(name = "Name")
    @JsonProperty("currencyname")
    private String dSExpenseCurrencyCurrencyName;

    @ApiModelProperty(name = "Exchange")
    @JsonProperty("exchange")
    private Double dSExpenseCurrencyExchange;

    public DSExpenseCurrency() {
    
    }
    
    public DSExpenseCurrency(ExpenseCurrency instance) {
        if (instance != null) {
            this.dSExpenseCurrencyCurrencyCode = instance.getExpenseCurrencyCurrencyCode();
            this.dSExpenseCurrencyCurAcronym = instance.getExpenseCurrencyCurAcronym();
            this.dSExpenseCurrencyCurrencyName = instance.getExpenseCurrencyCurrencyName();
            this.dSExpenseCurrencyExchange = instance.getExpenseCurrencyExchange();
        }
    }

    public String getDSExpenseCurrencyCurrencyCode() {
        return this.dSExpenseCurrencyCurrencyCode;
    }
    
    public void setDSExpenseCurrencyCurrencyCode(String dSExpenseCurrencyCurrencyCode) {
        this.dSExpenseCurrencyCurrencyCode = dSExpenseCurrencyCurrencyCode;
    }

    public String getDSExpenseCurrencyCurAcronym() {
        return this.dSExpenseCurrencyCurAcronym;
    }
    
    public void setDSExpenseCurrencyCurAcronym(String dSExpenseCurrencyCurAcronym) {
        this.dSExpenseCurrencyCurAcronym = dSExpenseCurrencyCurAcronym;
    }

    public String getDSExpenseCurrencyCurrencyName() {
        return this.dSExpenseCurrencyCurrencyName;
    }
    
    public void setDSExpenseCurrencyCurrencyName(String dSExpenseCurrencyCurrencyName) {
        this.dSExpenseCurrencyCurrencyName = dSExpenseCurrencyCurrencyName;
    }

    public Double getDSExpenseCurrencyExchange() {
        return this.dSExpenseCurrencyExchange;
    }
    
    public void setDSExpenseCurrencyExchange(Double dSExpenseCurrencyExchange) {
        this.dSExpenseCurrencyExchange = dSExpenseCurrencyExchange;
    }
}
