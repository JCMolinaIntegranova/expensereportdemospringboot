package com.integranova.spring.expensereportdemo.viewmodel.expensereport.piu;

import io.swagger.annotations.ApiModel;

import java.util.ArrayList;
import java.util.List;

import com.integranova.spring.expensereportdemo.viewmodel.QueryResponse;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.ds.DSExpenseReport4HAT;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensereport.piu.PIUExpenseReportResponse")
public class PIUExpenseReportResponse extends QueryResponse {

    private List<DSExpenseReport4HAT> results;

    public PIUExpenseReportResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUExpenseReportResponse(List<DSExpenseReport4HAT> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSExpenseReport4HAT> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSExpenseReport4HAT> results) {
        this.results = results;
    }
}
