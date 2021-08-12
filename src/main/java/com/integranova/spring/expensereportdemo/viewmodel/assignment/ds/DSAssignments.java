package com.integranova.spring.expensereportdemo.viewmodel.assignment.ds;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.persistence.Assignment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.assignment.ds.DSAssignments")
public class DSAssignments {

    @ApiModelProperty(name = "Project")
    @JsonProperty("project_projectname")
    private String dSAssignmentsProjectDotProjectName;

    @ApiModelProperty(name = "Employee")
    @JsonProperty("employee_empfullname")
    private String dSAssignmentsEmployeeDotEmpFullName;

    @ApiModelProperty(name = "Active?")
    @JsonProperty("isactive")
    private Boolean dSAssignmentsIsActive;

    @ApiModelProperty(name = "Details")
    @JsonProperty("details")
    private String dSAssignmentsDetails;

    public DSAssignments() {
    
    }
    
    public DSAssignments(Assignment instance) {
        if (instance != null) {
            try {
                this.dSAssignmentsProjectDotProjectName = instance.getProject().getProjectProjectName();
                this.dSAssignmentsEmployeeDotEmpFullName = instance.getEmployee().getEmployeeEmpFullName();
                this.dSAssignmentsIsActive = instance.getAssignmentIsActive();
                this.dSAssignmentsDetails = instance.getAssignmentDetails();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    public String getDSAssignmentsProjectDotProjectName() {
        return this.dSAssignmentsProjectDotProjectName;
    }
    
    public void setDSAssignmentsProjectDotProjectName(String dSAssignmentsProjectDotProjectName) {
        this.dSAssignmentsProjectDotProjectName = dSAssignmentsProjectDotProjectName;
    }

    public String getDSAssignmentsEmployeeDotEmpFullName() {
        return this.dSAssignmentsEmployeeDotEmpFullName;
    }
    
    public void setDSAssignmentsEmployeeDotEmpFullName(String dSAssignmentsEmployeeDotEmpFullName) {
        this.dSAssignmentsEmployeeDotEmpFullName = dSAssignmentsEmployeeDotEmpFullName;
    }

    public Boolean getDSAssignmentsIsActive() {
        return this.dSAssignmentsIsActive;
    }
    
    public void setDSAssignmentsIsActive(Boolean dSAssignmentsIsActive) {
        this.dSAssignmentsIsActive = dSAssignmentsIsActive;
    }

    public String getDSAssignmentsDetails() {
        return this.dSAssignmentsDetails;
    }
    
    public void setDSAssignmentsDetails(String dSAssignmentsDetails) {
        this.dSAssignmentsDetails = dSAssignmentsDetails;
    }
}
