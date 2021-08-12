package com.integranova.spring.expensereportdemo.viewmodel.employee.piu;

import io.swagger.annotations.ApiModel;

import java.util.ArrayList;
import java.util.List;

import com.integranova.spring.expensereportdemo.viewmodel.QueryResponse;
import com.integranova.spring.expensereportdemo.viewmodel.employee.ds.DSEmployee;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.employee.piu.PIUEmployeeResponse")
public class PIUEmployeeResponse extends QueryResponse {

    private List<DSEmployee> results;

    public PIUEmployeeResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUEmployeeResponse(List<DSEmployee> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSEmployee> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSEmployee> results) {
        this.results = results;
    }
}
