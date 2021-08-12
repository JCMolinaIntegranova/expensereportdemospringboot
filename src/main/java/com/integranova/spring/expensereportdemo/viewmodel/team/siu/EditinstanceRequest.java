package com.integranova.spring.expensereportdemo.viewmodel.team.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.TeamConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.TeamOid;
import com.integranova.spring.expensereportdemo.persistence.Team;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.team.siu.EditinstanceRequest")
public class EditinstanceRequest {

    @ApiModelProperty(name = "Team")
    @JsonProperty("p_thisteam_oid")
    private TeamOid teameditinstancepthisTeam;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Team teameditinstancepthisTeamInstance;

    @ApiModelProperty(name = "Name")
    @JsonProperty("p_name")
    private String teameditinstancepname;

    @ApiModelProperty(name = "Max Employees")
    @JsonProperty("p_maxemployees")
    private Long teameditinstancepmaxEmployees;

    public void checkArguments() throws NotNullArgumentException {
        checkTeameditinstancepthisTeam();
        checkTeameditinstancepname();
        checkTeameditinstancepmaxEmployees();
    }

    @JsonIgnore
    public TeamOid getTeameditinstancepthisTeam() {
        return this.teameditinstancepthisTeam;
    }
    
    public void setTeameditinstancepthisTeam(TeamOid teameditinstancepthisTeam) {
        this.teameditinstancepthisTeam = teameditinstancepthisTeam;
    }

    @JsonIgnore
    public Team getTeameditinstancepthisTeamInstance() {
        return this.teameditinstancepthisTeamInstance;
    }
    
    public void setTeameditinstancepthisTeamInstance(Team teameditinstancepthisTeam) {
        this.teameditinstancepthisTeamInstance = teameditinstancepthisTeam;
    }

    private void checkTeameditinstancepthisTeam() throws NotNullArgumentException {
        if(this.getTeameditinstancepthisTeamInstance() == null || this.getTeameditinstancepthisTeamInstance().isNull()) {
            throw new NotNullArgumentException(TeamConstants.SERV_ID_EDITINSTANCE, TeamConstants.CLASS_ID, TeamConstants.ARG_ID_EDITINSTANCE_TEAMEDITINSTANCEPTHISTEAM, TeamConstants.SERV_ALIAS_EDITINSTANCE, TeamConstants.CLASS_ALIAS, TeamConstants.ARG_ALIAS_EDITINSTANCE_TEAMEDITINSTANCEPTHISTEAM);
        }
    }

    @JsonIgnore
    public String getTeameditinstancepname() {
        return this.teameditinstancepname;
    }
    
    public void setTeameditinstancepname(String teameditinstancepname) {
        this.teameditinstancepname = teameditinstancepname;
    }

    private void checkTeameditinstancepname() throws NotNullArgumentException {
        if(this.getTeameditinstancepname() == null) {
            throw new NotNullArgumentException(TeamConstants.SERV_ID_EDITINSTANCE, TeamConstants.CLASS_ID, TeamConstants.ARG_ID_EDITINSTANCE_TEAMEDITINSTANCEPNAME, TeamConstants.SERV_ALIAS_EDITINSTANCE, TeamConstants.CLASS_ALIAS, TeamConstants.ARG_ALIAS_EDITINSTANCE_TEAMEDITINSTANCEPNAME);
        }
    }

    @JsonIgnore
    public Long getTeameditinstancepmaxEmployees() {
        return this.teameditinstancepmaxEmployees;
    }
    
    public void setTeameditinstancepmaxEmployees(Long teameditinstancepmaxEmployees) {
        this.teameditinstancepmaxEmployees = teameditinstancepmaxEmployees;
    }

    private void checkTeameditinstancepmaxEmployees() throws NotNullArgumentException {
        if(this.getTeameditinstancepmaxEmployees() == null) {
            throw new NotNullArgumentException(TeamConstants.SERV_ID_EDITINSTANCE, TeamConstants.CLASS_ID, TeamConstants.ARG_ID_EDITINSTANCE_TEAMEDITINSTANCEPMAXEMPLOYEES, TeamConstants.SERV_ALIAS_EDITINSTANCE, TeamConstants.CLASS_ALIAS, TeamConstants.ARG_ALIAS_EDITINSTANCE_TEAMEDITINSTANCEPMAXEMPLOYEES);
        }
    }
}
