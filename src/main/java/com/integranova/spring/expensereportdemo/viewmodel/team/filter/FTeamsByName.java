package com.integranova.spring.expensereportdemo.viewmodel.team.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.integranova.spring.expensereportdemo.global.TeamConstants;
import com.integranova.spring.expensereportdemo.viewmodel.FilterRequest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.team.filter.FTeamsByName")
public class FTeamsByName {

    @ApiModelProperty(name = "Name")
    @JsonProperty("vname")
    private String vName;

    @ApiModelProperty(name = "Capacity")
    @JsonProperty("vcapacity")
    private Long vCapacity;

    public FTeamsByName() {
        // Default constructor
    }

    @JsonIgnore
    public String getVName() {
        return this.vName;
    }
    
    public void setVName(String vName) {
        this.vName = vName;
    }

    @JsonIgnore
    public Long getVCapacity() {
        return this.vCapacity;
    }
    
    public void setVCapacity(Long vCapacity) {
        this.vCapacity = vCapacity;
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(TeamConstants.FILTER_NAME_FTEAMSBYNAME);
        filterRequest.addFilterVariable(TeamConstants.VAR_NAME_FTEAMSBYNAME_VNAME, vName);
        filterRequest.addFilterVariable(TeamConstants.VAR_NAME_FTEAMSBYNAME_VCAPACITY, vCapacity);
        return filterRequest;
    }
}
