package com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.piu;

import io.swagger.annotations.ApiModel;

import java.util.ArrayList;
import java.util.List;

import com.integranova.spring.expensereportdemo.viewmodel.QueryResponse;
import com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.ds.DSExpenseCurrency;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.piu.PIUExpenseCurrencyResponse")
public class PIUExpenseCurrencyResponse extends QueryResponse {

    private List<DSExpenseCurrency> results;

    public PIUExpenseCurrencyResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUExpenseCurrencyResponse(List<DSExpenseCurrency> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSExpenseCurrency> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSExpenseCurrency> results) {
        this.results = results;
    }
}
