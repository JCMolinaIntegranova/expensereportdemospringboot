package com.integranova.spring.expensereportdemo.viewmodel.ertemplate.piu;

import io.swagger.annotations.ApiModel;

import java.util.ArrayList;
import java.util.List;

import com.integranova.spring.expensereportdemo.viewmodel.QueryResponse;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.ds.DSERTemplates;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.ertemplate.piu.PIUERTemplatesResponse")
public class PIUERTemplatesResponse extends QueryResponse {

    private List<DSERTemplates> results;

    public PIUERTemplatesResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUERTemplatesResponse(List<DSERTemplates> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSERTemplates> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSERTemplates> results) {
        this.results = results;
    }
}
