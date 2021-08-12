package com.integranova.spring.expensereportdemo.viewmodel.project.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.integranova.spring.expensereportdemo.global.ProjectConstants;
import com.integranova.spring.expensereportdemo.viewmodel.FilterRequest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.project.filter.FProjects")
public class FProjects {

    @ApiModelProperty(name = "Name")
    @JsonProperty("vname")
    private String vName;

    @ApiModelProperty(name = "Completed?")
    @JsonProperty("vcompleted")
    private Boolean vCompleted;

    public FProjects() {
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
    public Boolean getVCompleted() {
        return this.vCompleted;
    }
    
    public void setVCompleted(Boolean vCompleted) {
        this.vCompleted = vCompleted;
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(ProjectConstants.FILTER_NAME_FPROJECTS);
        filterRequest.addFilterVariable(ProjectConstants.VAR_NAME_FPROJECTS_VNAME, vName);
        filterRequest.addFilterVariable(ProjectConstants.VAR_NAME_FPROJECTS_VCOMPLETED, vCompleted);
        return filterRequest;
    }
}
