package com.integranova.spring.expensereportdemo.viewmodel.paymenttype.piu;

import io.swagger.annotations.ApiModel;

import java.util.ArrayList;
import java.util.List;

import com.integranova.spring.expensereportdemo.viewmodel.QueryResponse;
import com.integranova.spring.expensereportdemo.viewmodel.paymenttype.ds.DSPaymentType;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.paymenttype.piu.PIUPaymentTypeResponse")
public class PIUPaymentTypeResponse extends QueryResponse {

    private List<DSPaymentType> results;

    public PIUPaymentTypeResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUPaymentTypeResponse(List<DSPaymentType> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSPaymentType> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSPaymentType> results) {
        this.results = results;
    }
}
