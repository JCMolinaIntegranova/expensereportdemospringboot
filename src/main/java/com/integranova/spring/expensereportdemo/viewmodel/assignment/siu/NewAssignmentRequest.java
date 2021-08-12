package com.integranova.spring.expensereportdemo.viewmodel.assignment.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.AssignmentConstants;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.oid.EmployeeOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ProjectOid;
import com.integranova.spring.expensereportdemo.persistence.Project;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.sql.Date;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.assignment.siu.NewAssignmentRequest")
public class NewAssignmentRequest {

    @ApiModelProperty(name = "Project")
    @JsonProperty("p_agrproject_oid")
    private ProjectOid assignmentnewAssignmentpagrProject;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Project assignmentnewAssignmentpagrProjectInstance;

    @ApiModelProperty(name = "Employee")
    @JsonProperty("p_agremployee_oid")
    private EmployeeOid assignmentnewAssignmentpagrEmployee;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Employee assignmentnewAssignmentpagrEmployeeInstance;

    @ApiModelProperty(name = "From")
    @JsonProperty("p_atrfromdate")
    private Date assignmentnewAssignmentpatrFromDate;

    @JsonProperty("preconditionId")
    @ApiModelProperty(hidden = true)
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkAssignmentnewAssignmentpagrProject();
        checkAssignmentnewAssignmentpagrEmployee();
        checkAssignmentnewAssignmentpatrFromDate();
    }

    @JsonIgnore
    public ProjectOid getAssignmentnewAssignmentpagrProject() {
        return this.assignmentnewAssignmentpagrProject;
    }
    
    public void setAssignmentnewAssignmentpagrProject(ProjectOid assignmentnewAssignmentpagrProject) {
        this.assignmentnewAssignmentpagrProject = assignmentnewAssignmentpagrProject;
    }

    @JsonIgnore
    public Project getAssignmentnewAssignmentpagrProjectInstance() {
        return this.assignmentnewAssignmentpagrProjectInstance;
    }
    
    public void setAssignmentnewAssignmentpagrProjectInstance(Project assignmentnewAssignmentpagrProject) {
        this.assignmentnewAssignmentpagrProjectInstance = assignmentnewAssignmentpagrProject;
    }

    private void checkAssignmentnewAssignmentpagrProject() throws NotNullArgumentException {
        if(this.getAssignmentnewAssignmentpagrProjectInstance() == null || this.getAssignmentnewAssignmentpagrProjectInstance().isNull()) {
            throw new NotNullArgumentException(AssignmentConstants.SERV_ID_NEWASSIGNMENT, AssignmentConstants.CLASS_ID, AssignmentConstants.ARG_ID_NEWASSIGNMENT_ASSIGNMENTNEWASSIGNMENTPAGRPROJECT, AssignmentConstants.SERV_ALIAS_NEWASSIGNMENT, AssignmentConstants.CLASS_ALIAS, AssignmentConstants.ARG_ALIAS_NEWASSIGNMENT_ASSIGNMENTNEWASSIGNMENTPAGRPROJECT);
        }
    }

    @JsonIgnore
    public EmployeeOid getAssignmentnewAssignmentpagrEmployee() {
        return this.assignmentnewAssignmentpagrEmployee;
    }
    
    public void setAssignmentnewAssignmentpagrEmployee(EmployeeOid assignmentnewAssignmentpagrEmployee) {
        this.assignmentnewAssignmentpagrEmployee = assignmentnewAssignmentpagrEmployee;
    }

    @JsonIgnore
    public Employee getAssignmentnewAssignmentpagrEmployeeInstance() {
        return this.assignmentnewAssignmentpagrEmployeeInstance;
    }
    
    public void setAssignmentnewAssignmentpagrEmployeeInstance(Employee assignmentnewAssignmentpagrEmployee) {
        this.assignmentnewAssignmentpagrEmployeeInstance = assignmentnewAssignmentpagrEmployee;
    }

    private void checkAssignmentnewAssignmentpagrEmployee() throws NotNullArgumentException {
        if(this.getAssignmentnewAssignmentpagrEmployeeInstance() == null || this.getAssignmentnewAssignmentpagrEmployeeInstance().isNull()) {
            throw new NotNullArgumentException(AssignmentConstants.SERV_ID_NEWASSIGNMENT, AssignmentConstants.CLASS_ID, AssignmentConstants.ARG_ID_NEWASSIGNMENT_ASSIGNMENTNEWASSIGNMENTPAGREMPLOYEE, AssignmentConstants.SERV_ALIAS_NEWASSIGNMENT, AssignmentConstants.CLASS_ALIAS, AssignmentConstants.ARG_ALIAS_NEWASSIGNMENT_ASSIGNMENTNEWASSIGNMENTPAGREMPLOYEE);
        }
    }

    @JsonIgnore
    public Date getAssignmentnewAssignmentpatrFromDate() {
        return this.assignmentnewAssignmentpatrFromDate;
    }
    
    public void setAssignmentnewAssignmentpatrFromDate(Date assignmentnewAssignmentpatrFromDate) {
        this.assignmentnewAssignmentpatrFromDate = assignmentnewAssignmentpatrFromDate;
    }

    private void checkAssignmentnewAssignmentpatrFromDate() throws NotNullArgumentException {
        if(this.getAssignmentnewAssignmentpatrFromDate() == null) {
            throw new NotNullArgumentException(AssignmentConstants.SERV_ID_NEWASSIGNMENT, AssignmentConstants.CLASS_ID, AssignmentConstants.ARG_ID_NEWASSIGNMENT_ASSIGNMENTNEWASSIGNMENTPATRFROMDATE, AssignmentConstants.SERV_ALIAS_NEWASSIGNMENT, AssignmentConstants.CLASS_ALIAS, AssignmentConstants.ARG_ALIAS_NEWASSIGNMENT_ASSIGNMENTNEWASSIGNMENTPATRFROMDATE);
        }
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
