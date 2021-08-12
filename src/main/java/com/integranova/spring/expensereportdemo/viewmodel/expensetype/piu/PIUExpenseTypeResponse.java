package com.integranova.spring.expensereportdemo.viewmodel.expensetype.piu;

import io.swagger.annotations.ApiModel;

import java.util.ArrayList;
import java.util.List;

import com.integranova.spring.expensereportdemo.viewmodel.QueryResponse;
import com.integranova.spring.expensereportdemo.viewmodel.expensetype.ds.DSExpenseType;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensetype.piu.PIUExpenseTypeResponse")
public class PIUExpenseTypeResponse extends QueryResponse {

    private List<DSExpenseType> results;

    public PIUExpenseTypeResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUExpenseTypeResponse(List<DSExpenseType> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSExpenseType> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSExpenseType> results) {
        this.results = results;
    }
}
