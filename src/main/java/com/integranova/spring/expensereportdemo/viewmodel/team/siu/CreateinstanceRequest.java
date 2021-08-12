package com.integranova.spring.expensereportdemo.viewmodel.team.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.TeamConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.team.siu.CreateinstanceRequest")
public class CreateinstanceRequest {

    @ApiModelProperty(name = "Name")
    @JsonProperty("p_atrname")
    private String teamcreateinstancepatrname;

    @ApiModelProperty(name = "Max Employees")
    @JsonProperty("p_atrmaxemployees")
    private Long teamcreateinstancepatrmaxEmployees;

    public void checkArguments() throws NotNullArgumentException {
        checkTeamcreateinstancepatrname();
        checkTeamcreateinstancepatrmaxEmployees();
    }

    @JsonIgnore
    public String getTeamcreateinstancepatrname() {
        return this.teamcreateinstancepatrname;
    }
    
    public void setTeamcreateinstancepatrname(String teamcreateinstancepatrname) {
        this.teamcreateinstancepatrname = teamcreateinstancepatrname;
    }

    private void checkTeamcreateinstancepatrname() throws NotNullArgumentException {
        if(this.getTeamcreateinstancepatrname() == null) {
            throw new NotNullArgumentException(TeamConstants.SERV_ID_CREATEINSTANCE, TeamConstants.CLASS_ID, TeamConstants.ARG_ID_CREATEINSTANCE_TEAMCREATEINSTANCEPATRNAME, TeamConstants.SERV_ALIAS_CREATEINSTANCE, TeamConstants.CLASS_ALIAS, TeamConstants.ARG_ALIAS_CREATEINSTANCE_TEAMCREATEINSTANCEPATRNAME);
        }
    }

    @JsonIgnore
    public Long getTeamcreateinstancepatrmaxEmployees() {
        return this.teamcreateinstancepatrmaxEmployees;
    }
    
    public void setTeamcreateinstancepatrmaxEmployees(Long teamcreateinstancepatrmaxEmployees) {
        this.teamcreateinstancepatrmaxEmployees = teamcreateinstancepatrmaxEmployees;
    }

    private void checkTeamcreateinstancepatrmaxEmployees() throws NotNullArgumentException {
        if(this.getTeamcreateinstancepatrmaxEmployees() == null) {
            throw new NotNullArgumentException(TeamConstants.SERV_ID_CREATEINSTANCE, TeamConstants.CLASS_ID, TeamConstants.ARG_ID_CREATEINSTANCE_TEAMCREATEINSTANCEPATRMAXEMPLOYEES, TeamConstants.SERV_ALIAS_CREATEINSTANCE, TeamConstants.CLASS_ALIAS, TeamConstants.ARG_ALIAS_CREATEINSTANCE_TEAMCREATEINSTANCEPATRMAXEMPLOYEES);
        }
    }
}
