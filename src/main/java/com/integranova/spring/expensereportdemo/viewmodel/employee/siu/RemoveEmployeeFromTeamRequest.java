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

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.employee.siu.RemoveEmployeeFromTeamRequest")
public class RemoveEmployeeFromTeamRequest {

    @ApiModelProperty(name = "Employees")
    @JsonProperty("p_thisemployee_oid")
    private EmployeeOid employeeremoveEmployeeFromTeampthisEmployee;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Employee employeeremoveEmployeeFromTeampthisEmployeeInstance;

    @ApiModelProperty(name = "Teams")
    @JsonProperty("p_evcteam_oid")
    private TeamOid employeeremoveEmployeeFromTeampevcTeam;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Team employeeremoveEmployeeFromTeampevcTeamInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkEmployeeremoveEmployeeFromTeampthisEmployee();
        checkEmployeeremoveEmployeeFromTeampevcTeam();
    }

    @JsonIgnore
    public EmployeeOid getEmployeeremoveEmployeeFromTeampthisEmployee() {
        return this.employeeremoveEmployeeFromTeampthisEmployee;
    }
    
    public void setEmployeeremoveEmployeeFromTeampthisEmployee(EmployeeOid employeeremoveEmployeeFromTeampthisEmployee) {
        this.employeeremoveEmployeeFromTeampthisEmployee = employeeremoveEmployeeFromTeampthisEmployee;
    }

    @JsonIgnore
    public Employee getEmployeeremoveEmployeeFromTeampthisEmployeeInstance() {
        return this.employeeremoveEmployeeFromTeampthisEmployeeInstance;
    }
    
    public void setEmployeeremoveEmployeeFromTeampthisEmployeeInstance(Employee employeeremoveEmployeeFromTeampthisEmployee) {
        this.employeeremoveEmployeeFromTeampthisEmployeeInstance = employeeremoveEmployeeFromTeampthisEmployee;
    }

    private void checkEmployeeremoveEmployeeFromTeampthisEmployee() throws NotNullArgumentException {
        if(this.getEmployeeremoveEmployeeFromTeampthisEmployeeInstance() == null || this.getEmployeeremoveEmployeeFromTeampthisEmployeeInstance().isNull()) {
            throw new NotNullArgumentException(EmployeeConstants.SERV_ID_REMOVEEMPLOYEEFROMTEAM, EmployeeConstants.CLASS_ID, EmployeeConstants.ARG_ID_REMOVEEMPLOYEEFROMTEAM_EMPLOYEEREMOVEEMPLOYEEFROMTEAMPTHISEMPLOYEE, EmployeeConstants.SERV_ALIAS_REMOVEEMPLOYEEFROMTEAM, EmployeeConstants.CLASS_ALIAS, EmployeeConstants.ARG_ALIAS_REMOVEEMPLOYEEFROMTEAM_EMPLOYEEREMOVEEMPLOYEEFROMTEAMPTHISEMPLOYEE);
        }
    }

    @JsonIgnore
    public TeamOid getEmployeeremoveEmployeeFromTeampevcTeam() {
        return this.employeeremoveEmployeeFromTeampevcTeam;
    }
    
    public void setEmployeeremoveEmployeeFromTeampevcTeam(TeamOid employeeremoveEmployeeFromTeampevcTeam) {
        this.employeeremoveEmployeeFromTeampevcTeam = employeeremoveEmployeeFromTeampevcTeam;
    }

    @JsonIgnore
    public Team getEmployeeremoveEmployeeFromTeampevcTeamInstance() {
        return this.employeeremoveEmployeeFromTeampevcTeamInstance;
    }
    
    public void setEmployeeremoveEmployeeFromTeampevcTeamInstance(Team employeeremoveEmployeeFromTeampevcTeam) {
        this.employeeremoveEmployeeFromTeampevcTeamInstance = employeeremoveEmployeeFromTeampevcTeam;
    }

    private void checkEmployeeremoveEmployeeFromTeampevcTeam() throws NotNullArgumentException {
        if(this.getEmployeeremoveEmployeeFromTeampevcTeamInstance() == null || this.getEmployeeremoveEmployeeFromTeampevcTeamInstance().isNull()) {
            throw new NotNullArgumentException(EmployeeConstants.SERV_ID_REMOVEEMPLOYEEFROMTEAM, EmployeeConstants.CLASS_ID, EmployeeConstants.ARG_ID_REMOVEEMPLOYEEFROMTEAM_EMPLOYEEREMOVEEMPLOYEEFROMTEAMPEVCTEAM, EmployeeConstants.SERV_ALIAS_REMOVEEMPLOYEEFROMTEAM, EmployeeConstants.CLASS_ALIAS, EmployeeConstants.ARG_ALIAS_REMOVEEMPLOYEEFROMTEAM_EMPLOYEEREMOVEEMPLOYEEFROMTEAMPEVCTEAM);
        }
    }
}
