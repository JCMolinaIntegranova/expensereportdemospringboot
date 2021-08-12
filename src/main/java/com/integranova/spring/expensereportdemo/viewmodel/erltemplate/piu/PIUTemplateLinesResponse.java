package com.integranova.spring.expensereportdemo.viewmodel.erltemplate.piu;

import io.swagger.annotations.ApiModel;

import java.util.ArrayList;
import java.util.List;

import com.integranova.spring.expensereportdemo.viewmodel.QueryResponse;
import com.integranova.spring.expensereportdemo.viewmodel.erltemplate.ds.DSTemplateLines;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.erltemplate.piu.PIUTemplateLinesResponse")
public class PIUTemplateLinesResponse extends QueryResponse {

    private List<DSTemplateLines> results;

    public PIUTemplateLinesResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUTemplateLinesResponse(List<DSTemplateLines> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSTemplateLines> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSTemplateLines> results) {
        this.results = results;
    }
}
