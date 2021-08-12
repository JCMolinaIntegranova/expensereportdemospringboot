package com.integranova.spring.expensereportdemo.viewmodel.assignment.piu;

import io.swagger.annotations.ApiModel;

import com.integranova.spring.expensereportdemo.viewmodel.PopulationRequestViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.QueryRequest;
import com.integranova.spring.expensereportdemo.viewmodel.assignment.filter.FAssignments;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.assignment.piu.PIUAssignmentsRequest")
public class PIUAssignmentsRequest extends PopulationRequestViewModel{

    private FAssignments fAssignments;
    
    public void setFAssignments(FAssignments fAssignments) {
        this.fAssignments = fAssignments;
    }
    
    public FAssignments getFAssignments() {
        return fAssignments;
    }

    @Override
    public QueryRequest buildQueryRequest() {
        QueryRequest queryRequest = super.buildQueryRequest();

        if (fAssignments != null)
            queryRequest.addFilterRequest(fAssignments.buildFilterRequest());
        return queryRequest;
    }
}
