package com.integranova.spring.expensereportdemo.viewmodel.expensereport.piu;

import io.swagger.annotations.ApiModel;

import java.util.ArrayList;
import java.util.List;

import com.integranova.spring.expensereportdemo.viewmodel.QueryResponse;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.ds.DSExpenseReport4MD;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensereport.piu.PIUExpenseReportToEmployeeResponse")
public class PIUExpenseReportToEmployeeResponse extends QueryResponse {

    private List<DSExpenseReport4MD> results;

    public PIUExpenseReportToEmployeeResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUExpenseReportToEmployeeResponse(List<DSExpenseReport4MD> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSExpenseReport4MD> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSExpenseReport4MD> results) {
        this.results = results;
    }
}
