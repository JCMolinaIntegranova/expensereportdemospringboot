package com.integranova.spring.expensereportdemo.viewmodel.project.piu;

import io.swagger.annotations.ApiModel;

import com.integranova.spring.expensereportdemo.viewmodel.PopulationRequestViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.QueryRequest;
import com.integranova.spring.expensereportdemo.viewmodel.project.filter.FProjects;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.project.piu.PIUProjectRequest")
public class PIUProjectRequest extends PopulationRequestViewModel{

    private FProjects fProjects;
    
    public void setFProjects(FProjects fProjects) {
        this.fProjects = fProjects;
    }
    
    public FProjects getFProjects() {
        return fProjects;
    }

    @Override
    public QueryRequest buildQueryRequest() {
        QueryRequest queryRequest = super.buildQueryRequest();

        if (fProjects != null)
            queryRequest.addFilterRequest(fProjects.buildFilterRequest());
        return queryRequest;
    }
}
