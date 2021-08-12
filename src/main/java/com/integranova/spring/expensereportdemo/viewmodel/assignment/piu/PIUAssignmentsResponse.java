package com.integranova.spring.expensereportdemo.viewmodel.assignment.piu;

import io.swagger.annotations.ApiModel;

import java.util.ArrayList;
import java.util.List;

import com.integranova.spring.expensereportdemo.viewmodel.QueryResponse;
import com.integranova.spring.expensereportdemo.viewmodel.assignment.ds.DSAssignments;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.assignment.piu.PIUAssignmentsResponse")
public class PIUAssignmentsResponse extends QueryResponse {

    private List<DSAssignments> results;

    public PIUAssignmentsResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUAssignmentsResponse(List<DSAssignments> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSAssignments> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSAssignments> results) {
        this.results = results;
    }
}
