package com.integranova.spring.expensereportdemo.viewmodel.expensereport.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.integranova.spring.expensereportdemo.persistence.oid.ProjectOid;
import com.integranova.spring.expensereportdemo.global.ExpenseReportConstants;
import com.integranova.spring.expensereportdemo.viewmodel.FilterRequest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensereport.filter.FByProject")
public class FByProject {

    @ApiModelProperty(name = "Project")
    @JsonProperty("vf_project")
    private ProjectOid vfProject;

    public FByProject() {
        // Default constructor
    }

    @JsonIgnore
    public ProjectOid getVfProject() {
        return this.vfProject;
    }
    
    public void setVfProject(ProjectOid vfProject) {
        this.vfProject = vfProject;
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(ExpenseReportConstants.FILTER_NAME_FBYPROJECT);
        filterRequest.addFilterVariable(ExpenseReportConstants.VAR_NAME_FBYPROJECT_VFPROJECT, vfProject);
        return filterRequest;
    }
}
