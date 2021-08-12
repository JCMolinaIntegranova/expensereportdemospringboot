package com.integranova.spring.expensereportdemo.viewmodel.project.piu;

import io.swagger.annotations.ApiModel;

import java.util.ArrayList;
import java.util.List;

import com.integranova.spring.expensereportdemo.viewmodel.QueryResponse;
import com.integranova.spring.expensereportdemo.viewmodel.project.ds.DSProject;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.project.piu.PIUProjectResponse")
public class PIUProjectResponse extends QueryResponse {

    private List<DSProject> results;

    public PIUProjectResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUProjectResponse(List<DSProject> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSProject> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSProject> results) {
        this.results = results;
    }
}
