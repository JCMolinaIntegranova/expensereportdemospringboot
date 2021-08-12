package com.integranova.spring.expensereportdemo.viewmodel.assignment.ds;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.persistence.Assignment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.assignment.ds.DSAssignmentDetails")
public class DSAssignmentDetails {

    @ApiModelProperty(name = "Project")
    @JsonProperty("project_projectname")
    private String dSAssignmentDetailsProjectDotProjectName;

    @ApiModelProperty(name = "Project Description")
    @JsonProperty("project_prodescription")
    private String dSAssignmentDetailsProjectDotProDescription;

    @ApiModelProperty(name = "Employee")
    @JsonProperty("employee_empfullname")
    private String dSAssignmentDetailsEmployeeDotEmpFullName;

    @ApiModelProperty(name = "From")
    @JsonProperty("fromdate")
    private Date dSAssignmentDetailsFromDate;

    @ApiModelProperty(name = "To")
    @JsonProperty("todate")
    private Date dSAssignmentDetailsToDate;

    public DSAssignmentDetails() {
    
    }
    
    public DSAssignmentDetails(Assignment instance) {
        if (instance != null) {
            try {
                this.dSAssignmentDetailsProjectDotProjectName = instance.getProject().getProjectProjectName();
                this.dSAssignmentDetailsProjectDotProDescription = instance.getProject().getProjectProDescription();
                this.dSAssignmentDetailsEmployeeDotEmpFullName = instance.getEmployee().getEmployeeEmpFullName();
                this.dSAssignmentDetailsFromDate = instance.getAssignmentFromDate();
                this.dSAssignmentDetailsToDate = instance.getAssignmentToDate();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    public String getDSAssignmentDetailsProjectDotProjectName() {
        return this.dSAssignmentDetailsProjectDotProjectName;
    }
    
    public void setDSAssignmentDetailsProjectDotProjectName(String dSAssignmentDetailsProjectDotProjectName) {
        this.dSAssignmentDetailsProjectDotProjectName = dSAssignmentDetailsProjectDotProjectName;
    }

    public String getDSAssignmentDetailsProjectDotProDescription() {
        return this.dSAssignmentDetailsProjectDotProDescription;
    }
    
    public void setDSAssignmentDetailsProjectDotProDescription(String dSAssignmentDetailsProjectDotProDescription) {
        this.dSAssignmentDetailsProjectDotProDescription = dSAssignmentDetailsProjectDotProDescription;
    }

    public String getDSAssignmentDetailsEmployeeDotEmpFullName() {
        return this.dSAssignmentDetailsEmployeeDotEmpFullName;
    }
    
    public void setDSAssignmentDetailsEmployeeDotEmpFullName(String dSAssignmentDetailsEmployeeDotEmpFullName) {
        this.dSAssignmentDetailsEmployeeDotEmpFullName = dSAssignmentDetailsEmployeeDotEmpFullName;
    }

    public Date getDSAssignmentDetailsFromDate() {
        return this.dSAssignmentDetailsFromDate;
    }
    
    public void setDSAssignmentDetailsFromDate(Date dSAssignmentDetailsFromDate) {
        this.dSAssignmentDetailsFromDate = dSAssignmentDetailsFromDate;
    }

    public Date getDSAssignmentDetailsToDate() {
        return this.dSAssignmentDetailsToDate;
    }
    
    public void setDSAssignmentDetailsToDate(Date dSAssignmentDetailsToDate) {
        this.dSAssignmentDetailsToDate = dSAssignmentDetailsToDate;
    }
}
