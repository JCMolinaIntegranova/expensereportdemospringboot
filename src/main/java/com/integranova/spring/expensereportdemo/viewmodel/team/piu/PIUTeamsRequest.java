package com.integranova.spring.expensereportdemo.viewmodel.team.piu;

import io.swagger.annotations.ApiModel;

import com.integranova.spring.expensereportdemo.viewmodel.PopulationRequestViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.QueryRequest;
import com.integranova.spring.expensereportdemo.viewmodel.team.filter.FTeamsByName;
import com.integranova.spring.expensereportdemo.viewmodel.team.filter.FTeamsWithCapacity;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.team.piu.PIUTeamsRequest")
public class PIUTeamsRequest extends PopulationRequestViewModel{

    private FTeamsByName fTeamsByName;

    private FTeamsWithCapacity fTeamsWithCapacity;
    
    public void setFTeamsByName(FTeamsByName fTeamsByName) {
        this.fTeamsByName = fTeamsByName;
    }
    
    public FTeamsByName getFTeamsByName() {
        return fTeamsByName;
    }
    
    public void setFTeamsWithCapacity(FTeamsWithCapacity fTeamsWithCapacity) {
        this.fTeamsWithCapacity = fTeamsWithCapacity;
    }
    
    public FTeamsWithCapacity getFTeamsWithCapacity() {
        return fTeamsWithCapacity;
    }

    @Override
    public QueryRequest buildQueryRequest() {
        QueryRequest queryRequest = super.buildQueryRequest();

        if (fTeamsByName != null)
            queryRequest.addFilterRequest(fTeamsByName.buildFilterRequest());

        if (fTeamsWithCapacity != null)
            queryRequest.addFilterRequest(fTeamsWithCapacity.buildFilterRequest());
        return queryRequest;
    }
}
