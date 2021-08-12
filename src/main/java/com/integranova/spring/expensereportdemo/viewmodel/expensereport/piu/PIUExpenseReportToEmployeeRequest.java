package com.integranova.spring.expensereportdemo.viewmodel.expensereport.piu;

import io.swagger.annotations.ApiModel;

import com.integranova.spring.expensereportdemo.viewmodel.PopulationRequestViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.QueryRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.filter.FExpenseReportDates;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensereport.piu.PIUExpenseReportToEmployeeRequest")
public class PIUExpenseReportToEmployeeRequest extends PopulationRequestViewModel{

    private FExpenseReportDates fExpenseReportDates;
    
    public void setFExpenseReportDates(FExpenseReportDates fExpenseReportDates) {
        this.fExpenseReportDates = fExpenseReportDates;
    }
    
    public FExpenseReportDates getFExpenseReportDates() {
        return fExpenseReportDates;
    }

    @Override
    public QueryRequest buildQueryRequest() {
        QueryRequest queryRequest = super.buildQueryRequest();

        if (fExpenseReportDates != null)
            queryRequest.addFilterRequest(fExpenseReportDates.buildFilterRequest());
        return queryRequest;
    }
}
