package com.integranova.spring.expensereportdemo.viewmodel.expenseline.piu;

import io.swagger.annotations.ApiModel;

import java.util.ArrayList;
import java.util.List;

import com.integranova.spring.expensereportdemo.viewmodel.QueryResponse;
import com.integranova.spring.expensereportdemo.viewmodel.expenseline.ds.DSExpenseLine;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expenseline.piu.PIUExpenseLineResponse")
public class PIUExpenseLineResponse extends QueryResponse {

    private List<DSExpenseLine> results;

    public PIUExpenseLineResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUExpenseLineResponse(List<DSExpenseLine> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSExpenseLine> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSExpenseLine> results) {
        this.results = results;
    }
}
