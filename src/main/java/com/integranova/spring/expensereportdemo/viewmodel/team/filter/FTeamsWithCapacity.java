package com.integranova.spring.expensereportdemo.viewmodel.team.filter;


import com.integranova.spring.expensereportdemo.global.TeamConstants;
import com.integranova.spring.expensereportdemo.viewmodel.FilterRequest;

import io.swagger.annotations.ApiModel;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.team.filter.FTeamsWithCapacity")
public class FTeamsWithCapacity {

    public FTeamsWithCapacity() {
        // Default constructor
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(TeamConstants.FILTER_NAME_FTEAMSWITHCAPACITY);
        return filterRequest;
    }
}
