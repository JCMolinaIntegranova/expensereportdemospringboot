package com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.ds;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.persistence.ExpenseCurrency;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.ds.DSExpenseCurrencySup")
public class DSExpenseCurrencySup {

    @ApiModelProperty(name = "Acronym")
    @JsonProperty("curacronym")
    private String dSExpenseCurrencySupCurAcronym;

    public DSExpenseCurrencySup() {
    
    }
    
    public DSExpenseCurrencySup(ExpenseCurrency instance) {
        if (instance != null) {
            this.dSExpenseCurrencySupCurAcronym = instance.getExpenseCurrencyCurAcronym();
        }
    }

    public String getDSExpenseCurrencySupCurAcronym() {
        return this.dSExpenseCurrencySupCurAcronym;
    }
    
    public void setDSExpenseCurrencySupCurAcronym(String dSExpenseCurrencySupCurAcronym) {
        this.dSExpenseCurrencySupCurAcronym = dSExpenseCurrencySupCurAcronym;
    }
}
