package com.integranova.spring.expensereportdemo.viewmodel.team.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.TeamConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.TeamOid;
import com.integranova.spring.expensereportdemo.persistence.Team;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.team.siu.ValidateRequest")
public class ValidateRequest {

    @ApiModelProperty(name = "Team")
    @JsonProperty("p_thisteam_oid")
    private TeamOid teamvalidatepthisTeam;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Team teamvalidatepthisTeamInstance;

    @JsonProperty("preconditionId")
    @ApiModelProperty(hidden = true)
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkTeamvalidatepthisTeam();
    }

    @JsonIgnore
    public TeamOid getTeamvalidatepthisTeam() {
        return this.teamvalidatepthisTeam;
    }
    
    public void setTeamvalidatepthisTeam(TeamOid teamvalidatepthisTeam) {
        this.teamvalidatepthisTeam = teamvalidatepthisTeam;
    }

    @JsonIgnore
    public Team getTeamvalidatepthisTeamInstance() {
        return this.teamvalidatepthisTeamInstance;
    }
    
    public void setTeamvalidatepthisTeamInstance(Team teamvalidatepthisTeam) {
        this.teamvalidatepthisTeamInstance = teamvalidatepthisTeam;
    }

    private void checkTeamvalidatepthisTeam() throws NotNullArgumentException {
        if(this.getTeamvalidatepthisTeamInstance() == null || this.getTeamvalidatepthisTeamInstance().isNull()) {
            throw new NotNullArgumentException(TeamConstants.SERV_ID_VALIDATE, TeamConstants.CLASS_ID, TeamConstants.ARG_ID_VALIDATE_TEAMVALIDATEPTHISTEAM, TeamConstants.SERV_ALIAS_VALIDATE, TeamConstants.CLASS_ALIAS, TeamConstants.ARG_ALIAS_VALIDATE_TEAMVALIDATEPTHISTEAM);
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
