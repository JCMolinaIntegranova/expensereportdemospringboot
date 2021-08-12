package com.integranova.spring.expensereportdemo.viewmodel.team.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.TeamConstants;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.oid.EmployeeOid;
import com.integranova.spring.expensereportdemo.persistence.oid.TeamOid;
import com.integranova.spring.expensereportdemo.persistence.Team;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.team.siu.AddEmployeeToTeamRequest")
public class AddEmployeeToTeamRequest {

    @ApiModelProperty(name = "Teams")
    @JsonProperty("p_thisteam_oid")
    private TeamOid teamaddEmployeeToTeampthisTeam;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Team teamaddEmployeeToTeampthisTeamInstance;

    @ApiModelProperty(name = "Employees")
    @JsonProperty("p_evcemployee_oid")
    private EmployeeOid teamaddEmployeeToTeampevcEmployee;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Employee teamaddEmployeeToTeampevcEmployeeInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkTeamaddEmployeeToTeampthisTeam();
        checkTeamaddEmployeeToTeampevcEmployee();
    }

    @JsonIgnore
    public TeamOid getTeamaddEmployeeToTeampthisTeam() {
        return this.teamaddEmployeeToTeampthisTeam;
    }
    
    public void setTeamaddEmployeeToTeampthisTeam(TeamOid teamaddEmployeeToTeampthisTeam) {
        this.teamaddEmployeeToTeampthisTeam = teamaddEmployeeToTeampthisTeam;
    }

    @JsonIgnore
    public Team getTeamaddEmployeeToTeampthisTeamInstance() {
        return this.teamaddEmployeeToTeampthisTeamInstance;
    }
    
    public void setTeamaddEmployeeToTeampthisTeamInstance(Team teamaddEmployeeToTeampthisTeam) {
        this.teamaddEmployeeToTeampthisTeamInstance = teamaddEmployeeToTeampthisTeam;
    }

    private void checkTeamaddEmployeeToTeampthisTeam() throws NotNullArgumentException {
        if(this.getTeamaddEmployeeToTeampthisTeamInstance() == null || this.getTeamaddEmployeeToTeampthisTeamInstance().isNull()) {
            throw new NotNullArgumentException(TeamConstants.SERV_ID_ADDEMPLOYEETOTEAM, TeamConstants.CLASS_ID, TeamConstants.ARG_ID_ADDEMPLOYEETOTEAM_TEAMADDEMPLOYEETOTEAMPTHISTEAM, TeamConstants.SERV_ALIAS_ADDEMPLOYEETOTEAM, TeamConstants.CLASS_ALIAS, TeamConstants.ARG_ALIAS_ADDEMPLOYEETOTEAM_TEAMADDEMPLOYEETOTEAMPTHISTEAM);
        }
    }

    @JsonIgnore
    public EmployeeOid getTeamaddEmployeeToTeampevcEmployee() {
        return this.teamaddEmployeeToTeampevcEmployee;
    }
    
    public void setTeamaddEmployeeToTeampevcEmployee(EmployeeOid teamaddEmployeeToTeampevcEmployee) {
        this.teamaddEmployeeToTeampevcEmployee = teamaddEmployeeToTeampevcEmployee;
    }

    @JsonIgnore
    public Employee getTeamaddEmployeeToTeampevcEmployeeInstance() {
        return this.teamaddEmployeeToTeampevcEmployeeInstance;
    }
    
    public void setTeamaddEmployeeToTeampevcEmployeeInstance(Employee teamaddEmployeeToTeampevcEmployee) {
        this.teamaddEmployeeToTeampevcEmployeeInstance = teamaddEmployeeToTeampevcEmployee;
    }

    private void checkTeamaddEmployeeToTeampevcEmployee() throws NotNullArgumentException {
        if(this.getTeamaddEmployeeToTeampevcEmployeeInstance() == null || this.getTeamaddEmployeeToTeampevcEmployeeInstance().isNull()) {
            throw new NotNullArgumentException(TeamConstants.SERV_ID_ADDEMPLOYEETOTEAM, TeamConstants.CLASS_ID, TeamConstants.ARG_ID_ADDEMPLOYEETOTEAM_TEAMADDEMPLOYEETOTEAMPEVCEMPLOYEE, TeamConstants.SERV_ALIAS_ADDEMPLOYEETOTEAM, TeamConstants.CLASS_ALIAS, TeamConstants.ARG_ALIAS_ADDEMPLOYEETOTEAM_TEAMADDEMPLOYEETOTEAMPEVCEMPLOYEE);
        }
    }
}
