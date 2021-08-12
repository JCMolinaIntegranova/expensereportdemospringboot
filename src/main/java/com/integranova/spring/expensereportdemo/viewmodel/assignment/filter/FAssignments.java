package com.integranova.spring.expensereportdemo.viewmodel.assignment.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.integranova.spring.expensereportdemo.persistence.oid.ProjectOid;
import com.integranova.spring.expensereportdemo.global.AssignmentConstants;
import com.integranova.spring.expensereportdemo.viewmodel.FilterRequest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.assignment.filter.FAssignments")
public class FAssignments {

    @ApiModelProperty(name = "Project")
    @JsonProperty("v_project")
    private ProjectOid vProject;

    @ApiModelProperty(name = "Name")
    @JsonProperty("v_name")
    private String vName;

    @ApiModelProperty(name = "Surname")
    @JsonProperty("v_surname")
    private String vSurname;

    @ApiModelProperty(name = "Active")
    @JsonProperty("v_active")
    private Boolean vActive;

    public FAssignments() {
        // Default constructor
    }

    @JsonIgnore
    public ProjectOid getVProject() {
        return this.vProject;
    }
    
    public void setVProject(ProjectOid vProject) {
        this.vProject = vProject;
    }

    @JsonIgnore
    public String getVName() {
        return this.vName;
    }
    
    public void setVName(String vName) {
        this.vName = vName;
    }

    @JsonIgnore
    public String getVSurname() {
        return this.vSurname;
    }
    
    public void setVSurname(String vSurname) {
        this.vSurname = vSurname;
    }

    @JsonIgnore
    public Boolean getVActive() {
        return this.vActive;
    }
    
    public void setVActive(Boolean vActive) {
        this.vActive = vActive;
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(AssignmentConstants.FILTER_NAME_FASSIGNMENTS);
        filterRequest.addFilterVariable(AssignmentConstants.VAR_NAME_FASSIGNMENTS_VPROJECT, vProject);
        filterRequest.addFilterVariable(AssignmentConstants.VAR_NAME_FASSIGNMENTS_VNAME, vName);
        filterRequest.addFilterVariable(AssignmentConstants.VAR_NAME_FASSIGNMENTS_VSURNAME, vSurname);
        filterRequest.addFilterVariable(AssignmentConstants.VAR_NAME_FASSIGNMENTS_VACTIVE, vActive);
        return filterRequest;
    }
}
