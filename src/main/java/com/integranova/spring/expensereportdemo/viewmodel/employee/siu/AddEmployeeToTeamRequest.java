package com.integranova.spring.expensereportdemo.viewmodel.employee.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.EmployeeConstants;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.oid.EmployeeOid;
import com.integranova.spring.expensereportdemo.persistence.oid.TeamOid;
import com.integranova.spring.expensereportdemo.persistence.Team;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.employee.siu.AddEmployeeToTeamRequest")
public class AddEmployeeToTeamRequest {

    @ApiModelProperty(name = "Employees")
    @JsonProperty("p_thisemployee_oid")
    private EmployeeOid employeeaddEmployeeToTeampthisEmployee;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Employee employeeaddEmployeeToTeampthisEmployeeInstance;

    @ApiModelProperty(name = "Teams")
    @JsonProperty("p_evcteam_oid")
    private TeamOid employeeaddEmployeeToTeampevcTeam;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Team employeeaddEmployeeToTeampevcTeamInstance;

    @JsonProperty("preconditionId")
    @ApiModelProperty(hidden = true)
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkEmployeeaddEmployeeToTeampthisEmployee();
        checkEmployeeaddEmployeeToTeampevcTeam();
    }

    @JsonIgnore
    public EmployeeOid getEmployeeaddEmployeeToTeampthisEmployee() {
        return this.employeeaddEmployeeToTeampthisEmployee;
    }
    
    public void setEmployeeaddEmployeeToTeampthisEmployee(EmployeeOid employeeaddEmployeeToTeampthisEmployee) {
        this.employeeaddEmployeeToTeampthisEmployee = employeeaddEmployeeToTeampthisEmployee;
    }

    @JsonIgnore
    public Employee getEmployeeaddEmployeeToTeampthisEmployeeInstance() {
        return this.employeeaddEmployeeToTeampthisEmployeeInstance;
    }
    
    public void setEmployeeaddEmployeeToTeampthisEmployeeInstance(Employee employeeaddEmployeeToTeampthisEmployee) {
        this.employeeaddEmployeeToTeampthisEmployeeInstance = employeeaddEmployeeToTeampthisEmployee;
    }

    private void checkEmployeeaddEmployeeToTeampthisEmployee() throws NotNullArgumentException {
        if(this.getEmployeeaddEmployeeToTeampthisEmployeeInstance() == null || this.getEmployeeaddEmployeeToTeampthisEmployeeInstance().isNull()) {
            throw new NotNullArgumentException(EmployeeConstants.SERV_ID_ADDEMPLOYEETOTEAM, EmployeeConstants.CLASS_ID, EmployeeConstants.ARG_ID_ADDEMPLOYEETOTEAM_EMPLOYEEADDEMPLOYEETOTEAMPTHISEMPLOYEE, EmployeeConstants.SERV_ALIAS_ADDEMPLOYEETOTEAM, EmployeeConstants.CLASS_ALIAS, EmployeeConstants.ARG_ALIAS_ADDEMPLOYEETOTEAM_EMPLOYEEADDEMPLOYEETOTEAMPTHISEMPLOYEE);
        }
    }

    @JsonIgnore
    public TeamOid getEmployeeaddEmployeeToTeampevcTeam() {
        return this.employeeaddEmployeeToTeampevcTeam;
    }
    
    public void setEmployeeaddEmployeeToTeampevcTeam(TeamOid employeeaddEmployeeToTeampevcTeam) {
        this.employeeaddEmployeeToTeampevcTeam = employeeaddEmployeeToTeampevcTeam;
    }

    @JsonIgnore
    public Team getEmployeeaddEmployeeToTeampevcTeamInstance() {
        return this.employeeaddEmployeeToTeampevcTeamInstance;
    }
    
    public void setEmployeeaddEmployeeToTeampevcTeamInstance(Team employeeaddEmployeeToTeampevcTeam) {
        this.employeeaddEmployeeToTeampevcTeamInstance = employeeaddEmployeeToTeampevcTeam;
    }

    private void checkEmployeeaddEmployeeToTeampevcTeam() throws NotNullArgumentException {
        if(this.getEmployeeaddEmployeeToTeampevcTeamInstance() == null || this.getEmployeeaddEmployeeToTeampevcTeamInstance().isNull()) {
            throw new NotNullArgumentException(EmployeeConstants.SERV_ID_ADDEMPLOYEETOTEAM, EmployeeConstants.CLASS_ID, EmployeeConstants.ARG_ID_ADDEMPLOYEETOTEAM_EMPLOYEEADDEMPLOYEETOTEAMPEVCTEAM, EmployeeConstants.SERV_ALIAS_ADDEMPLOYEETOTEAM, EmployeeConstants.CLASS_ALIAS, EmployeeConstants.ARG_ALIAS_ADDEMPLOYEETOTEAM_EMPLOYEEADDEMPLOYEETOTEAMPEVCTEAM);
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
