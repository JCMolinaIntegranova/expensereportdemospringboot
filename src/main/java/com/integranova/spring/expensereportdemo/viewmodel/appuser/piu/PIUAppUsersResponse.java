package com.integranova.spring.expensereportdemo.viewmodel.appuser.piu;

import io.swagger.annotations.ApiModel;

import java.util.ArrayList;
import java.util.List;

import com.integranova.spring.expensereportdemo.viewmodel.QueryResponse;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.ds.DSAppUsers;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.appuser.piu.PIUAppUsersResponse")
public class PIUAppUsersResponse extends QueryResponse {

    private List<DSAppUsers> results;

    public PIUAppUsersResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUAppUsersResponse(List<DSAppUsers> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSAppUsers> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSAppUsers> results) {
        this.results = results;
    }
}
