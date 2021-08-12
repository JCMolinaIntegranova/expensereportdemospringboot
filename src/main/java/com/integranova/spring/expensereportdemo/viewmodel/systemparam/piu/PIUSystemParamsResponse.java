package com.integranova.spring.expensereportdemo.viewmodel.systemparam.piu;

import io.swagger.annotations.ApiModel;

import java.util.ArrayList;
import java.util.List;

import com.integranova.spring.expensereportdemo.viewmodel.QueryResponse;
import com.integranova.spring.expensereportdemo.viewmodel.systemparam.ds.DSSystemParams;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.systemparam.piu.PIUSystemParamsResponse")
public class PIUSystemParamsResponse extends QueryResponse {

    private List<DSSystemParams> results;

    public PIUSystemParamsResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUSystemParamsResponse(List<DSSystemParams> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSSystemParams> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSSystemParams> results) {
        this.results = results;
    }
}
