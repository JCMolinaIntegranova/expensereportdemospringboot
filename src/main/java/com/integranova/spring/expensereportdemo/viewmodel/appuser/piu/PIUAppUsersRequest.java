package com.integranova.spring.expensereportdemo.viewmodel.appuser.piu;

import io.swagger.annotations.ApiModel;

import com.integranova.spring.expensereportdemo.viewmodel.PopulationRequestViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.QueryRequest;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.filter.FAppUsers;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.appuser.piu.PIUAppUsersRequest")
public class PIUAppUsersRequest extends PopulationRequestViewModel{

    private FAppUsers fAppUsers;
    
    public void setFAppUsers(FAppUsers fAppUsers) {
        this.fAppUsers = fAppUsers;
    }
    
    public FAppUsers getFAppUsers() {
        return fAppUsers;
    }

    @Override
    public QueryRequest buildQueryRequest() {
        QueryRequest queryRequest = super.buildQueryRequest();

        if (fAppUsers != null)
            queryRequest.addFilterRequest(fAppUsers.buildFilterRequest());
        return queryRequest;
    }
}
