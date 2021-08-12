package com.integranova.spring.expensereportdemo.viewmodel.expensereport.piu;

import io.swagger.annotations.ApiModel;

import com.integranova.spring.expensereportdemo.viewmodel.PopulationRequestViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.QueryRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.filter.FByProject;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.filter.FExpenseReportAmount;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.filter.FExpenseReportStatus;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensereport.piu.PIUExpenseReportRequest")
public class PIUExpenseReportRequest extends PopulationRequestViewModel{

    private FByProject fByProject;

    private FExpenseReportAmount fExpenseReportAmount;

    private FExpenseReportStatus fExpenseReportStatus;
    
    public void setFByProject(FByProject fByProject) {
        this.fByProject = fByProject;
    }
    
    public FByProject getFByProject() {
        return fByProject;
    }
    
    public void setFExpenseReportAmount(FExpenseReportAmount fExpenseReportAmount) {
        this.fExpenseReportAmount = fExpenseReportAmount;
    }
    
    public FExpenseReportAmount getFExpenseReportAmount() {
        return fExpenseReportAmount;
    }
    
    public void setFExpenseReportStatus(FExpenseReportStatus fExpenseReportStatus) {
        this.fExpenseReportStatus = fExpenseReportStatus;
    }
    
    public FExpenseReportStatus getFExpenseReportStatus() {
        return fExpenseReportStatus;
    }

    @Override
    public QueryRequest buildQueryRequest() {
        QueryRequest queryRequest = super.buildQueryRequest();

        if (fByProject != null)
            queryRequest.addFilterRequest(fByProject.buildFilterRequest());

        if (fExpenseReportAmount != null)
            queryRequest.addFilterRequest(fExpenseReportAmount.buildFilterRequest());

        if (fExpenseReportStatus != null)
            queryRequest.addFilterRequest(fExpenseReportStatus.buildFilterRequest());
        return queryRequest;
    }
}
