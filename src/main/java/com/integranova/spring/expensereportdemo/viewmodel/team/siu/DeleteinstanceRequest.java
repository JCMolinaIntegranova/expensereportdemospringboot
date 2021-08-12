package com.integranova.spring.expensereportdemo.viewmodel.team.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.TeamConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.TeamOid;
import com.integranova.spring.expensereportdemo.persistence.Team;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.team.siu.DeleteinstanceRequest")
public class DeleteinstanceRequest {

    @ApiModelProperty(name = "Team")
    @JsonProperty("p_thisteam_oid")
    private TeamOid teamdeleteinstancepthisTeam;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Team teamdeleteinstancepthisTeamInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkTeamdeleteinstancepthisTeam();
    }

    @JsonIgnore
    public TeamOid getTeamdeleteinstancepthisTeam() {
        return this.teamdeleteinstancepthisTeam;
    }
    
    public void setTeamdeleteinstancepthisTeam(TeamOid teamdeleteinstancepthisTeam) {
        this.teamdeleteinstancepthisTeam = teamdeleteinstancepthisTeam;
    }

    @JsonIgnore
    public Team getTeamdeleteinstancepthisTeamInstance() {
        return this.teamdeleteinstancepthisTeamInstance;
    }
    
    public void setTeamdeleteinstancepthisTeamInstance(Team teamdeleteinstancepthisTeam) {
        this.teamdeleteinstancepthisTeamInstance = teamdeleteinstancepthisTeam;
    }

    private void checkTeamdeleteinstancepthisTeam() throws NotNullArgumentException {
        if(this.getTeamdeleteinstancepthisTeamInstance() == null || this.getTeamdeleteinstancepthisTeamInstance().isNull()) {
            throw new NotNullArgumentException(TeamConstants.SERV_ID_DELETEINSTANCE, TeamConstants.CLASS_ID, TeamConstants.ARG_ID_DELETEINSTANCE_TEAMDELETEINSTANCEPTHISTEAM, TeamConstants.SERV_ALIAS_DELETEINSTANCE, TeamConstants.CLASS_ALIAS, TeamConstants.ARG_ALIAS_DELETEINSTANCE_TEAMDELETEINSTANCEPTHISTEAM);
        }
    }
}
