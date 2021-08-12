package com.integranova.spring.expensereportdemo.viewmodel.team.piu;

import io.swagger.annotations.ApiModel;

import java.util.ArrayList;
import java.util.List;

import com.integranova.spring.expensereportdemo.viewmodel.QueryResponse;
import com.integranova.spring.expensereportdemo.viewmodel.team.ds.DSTeams;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.team.piu.PIUTeamsResponse")
public class PIUTeamsResponse extends QueryResponse {

    private List<DSTeams> results;

    public PIUTeamsResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUTeamsResponse(List<DSTeams> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSTeams> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSTeams> results) {
        this.results = results;
    }
}
