package com.integranova.spring.expensereportdemo.viewmodel.employee.piu;

import io.swagger.annotations.ApiModel;

import com.integranova.spring.expensereportdemo.viewmodel.PopulationRequestViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.QueryRequest;
import com.integranova.spring.expensereportdemo.viewmodel.employee.filter.FEmployeeName;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.employee.piu.PIUEmployeeRequest")
public class PIUEmployeeRequest extends PopulationRequestViewModel{

    private FEmployeeName fEmployeeName;
    
    public void setFEmployeeName(FEmployeeName fEmployeeName) {
        this.fEmployeeName = fEmployeeName;
    }
    
    public FEmployeeName getFEmployeeName() {
        return fEmployeeName;
    }

    @Override
    public QueryRequest buildQueryRequest() {
        QueryRequest queryRequest = super.buildQueryRequest();

        if (fEmployeeName != null)
            queryRequest.addFilterRequest(fEmployeeName.buildFilterRequest());
        return queryRequest;
    }
}
