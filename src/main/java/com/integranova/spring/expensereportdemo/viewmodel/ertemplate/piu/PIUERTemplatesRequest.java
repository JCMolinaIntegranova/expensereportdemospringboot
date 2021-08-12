package com.integranova.spring.expensereportdemo.viewmodel.ertemplate.piu;

import io.swagger.annotations.ApiModel;

import com.integranova.spring.expensereportdemo.viewmodel.PopulationRequestViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.QueryRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.filter.FERTemplates;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.ertemplate.piu.PIUERTemplatesRequest")
public class PIUERTemplatesRequest extends PopulationRequestViewModel{

    private FERTemplates fERTemplates;
    
    public void setFERTemplates(FERTemplates fERTemplates) {
        this.fERTemplates = fERTemplates;
    }
    
    public FERTemplates getFERTemplates() {
        return fERTemplates;
    }

    @Override
    public QueryRequest buildQueryRequest() {
        QueryRequest queryRequest = super.buildQueryRequest();

        if (fERTemplates != null)
            queryRequest.addFilterRequest(fERTemplates.buildFilterRequest());
        return queryRequest;
    }
}
