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

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.team.siu.RemoveEmployeeFromTeamRequest")
public class RemoveEmployeeFromTeamRequest {

    @ApiModelProperty(name = "Teams")
    @JsonProperty("p_thisteam_oid")
    private TeamOid teamremoveEmployeeFromTeampthisTeam;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Team teamremoveEmployeeFromTeampthisTeamInstance;

    @ApiModelProperty(name = "Employees")
    @JsonProperty("p_evcemployee_oid")
    private EmployeeOid teamremoveEmployeeFromTeampevcEmployee;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Employee teamremoveEmployeeFromTeampevcEmployeeInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkTeamremoveEmployeeFromTeampthisTeam();
        checkTeamremoveEmployeeFromTeampevcEmployee();
    }

    @JsonIgnore
    public TeamOid getTeamremoveEmployeeFromTeampthisTeam() {
        return this.teamremoveEmployeeFromTeampthisTeam;
    }
    
    public void setTeamremoveEmployeeFromTeampthisTeam(TeamOid teamremoveEmployeeFromTeampthisTeam) {
        this.teamremoveEmployeeFromTeampthisTeam = teamremoveEmployeeFromTeampthisTeam;
    }

    @JsonIgnore
    public Team getTeamremoveEmployeeFromTeampthisTeamInstance() {
        return this.teamremoveEmployeeFromTeampthisTeamInstance;
    }
    
    public void setTeamremoveEmployeeFromTeampthisTeamInstance(Team teamremoveEmployeeFromTeampthisTeam) {
        this.teamremoveEmployeeFromTeampthisTeamInstance = teamremoveEmployeeFromTeampthisTeam;
    }

    private void checkTeamremoveEmployeeFromTeampthisTeam() throws NotNullArgumentException {
        if(this.getTeamremoveEmployeeFromTeampthisTeamInstance() == null || this.getTeamremoveEmployeeFromTeampthisTeamInstance().isNull()) {
            throw new NotNullArgumentException(TeamConstants.SERV_ID_REMOVEEMPLOYEEFROMTEAM, TeamConstants.CLASS_ID, TeamConstants.ARG_ID_REMOVEEMPLOYEEFROMTEAM_TEAMREMOVEEMPLOYEEFROMTEAMPTHISTEAM, TeamConstants.SERV_ALIAS_REMOVEEMPLOYEEFROMTEAM, TeamConstants.CLASS_ALIAS, TeamConstants.ARG_ALIAS_REMOVEEMPLOYEEFROMTEAM_TEAMREMOVEEMPLOYEEFROMTEAMPTHISTEAM);
        }
    }

    @JsonIgnore
    public EmployeeOid getTeamremoveEmployeeFromTeampevcEmployee() {
        return this.teamremoveEmployeeFromTeampevcEmployee;
    }
    
    public void setTeamremoveEmployeeFromTeampevcEmployee(EmployeeOid teamremoveEmployeeFromTeampevcEmployee) {
        this.teamremoveEmployeeFromTeampevcEmployee = teamremoveEmployeeFromTeampevcEmployee;
    }

    @JsonIgnore
    public Employee getTeamremoveEmployeeFromTeampevcEmployeeInstance() {
        return this.teamremoveEmployeeFromTeampevcEmployeeInstance;
    }
    
    public void setTeamremoveEmployeeFromTeampevcEmployeeInstance(Employee teamremoveEmployeeFromTeampevcEmployee) {
        this.teamremoveEmployeeFromTeampevcEmployeeInstance = teamremoveEmployeeFromTeampevcEmployee;
    }

    private void checkTeamremoveEmployeeFromTeampevcEmployee() throws NotNullArgumentException {
        if(this.getTeamremoveEmployeeFromTeampevcEmployeeInstance() == null || this.getTeamremoveEmployeeFromTeampevcEmployeeInstance().isNull()) {
            throw new NotNullArgumentException(TeamConstants.SERV_ID_REMOVEEMPLOYEEFROMTEAM, TeamConstants.CLASS_ID, TeamConstants.ARG_ID_REMOVEEMPLOYEEFROMTEAM_TEAMREMOVEEMPLOYEEFROMTEAMPEVCEMPLOYEE, TeamConstants.SERV_ALIAS_REMOVEEMPLOYEEFROMTEAM, TeamConstants.CLASS_ALIAS, TeamConstants.ARG_ALIAS_REMOVEEMPLOYEEFROMTEAM_TEAMREMOVEEMPLOYEEFROMTEAMPEVCEMPLOYEE);
        }
    }
}
