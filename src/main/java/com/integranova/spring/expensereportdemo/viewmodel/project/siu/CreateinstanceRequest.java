package com.integranova.spring.expensereportdemo.viewmodel.project.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ProjectConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.TeamOid;
import com.integranova.spring.expensereportdemo.persistence.Team;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.project.siu.CreateinstanceRequest")
public class CreateinstanceRequest {

    @ApiModelProperty(name = "Team")
    @JsonProperty("p_agrteam_oid")
    private TeamOid projectcreateinstancepagrTeam;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Team projectcreateinstancepagrTeamInstance;

    @ApiModelProperty(name = "Name")
    @JsonProperty("p_atrprojectname")
    private String projectcreateinstancepatrProjectName;

    @ApiModelProperty(name = "Description")
    @JsonProperty("p_atrprodescription")
    private String projectcreateinstancepatrProDescription;

    public void checkArguments() throws NotNullArgumentException {
        checkProjectcreateinstancepagrTeam();
        checkProjectcreateinstancepatrProjectName();
        checkProjectcreateinstancepatrProDescription();
    }

    @JsonIgnore
    public TeamOid getProjectcreateinstancepagrTeam() {
        return this.projectcreateinstancepagrTeam;
    }
    
    public void setProjectcreateinstancepagrTeam(TeamOid projectcreateinstancepagrTeam) {
        this.projectcreateinstancepagrTeam = projectcreateinstancepagrTeam;
    }

    @JsonIgnore
    public Team getProjectcreateinstancepagrTeamInstance() {
        return this.projectcreateinstancepagrTeamInstance;
    }
    
    public void setProjectcreateinstancepagrTeamInstance(Team projectcreateinstancepagrTeam) {
        this.projectcreateinstancepagrTeamInstance = projectcreateinstancepagrTeam;
    }

    private void checkProjectcreateinstancepagrTeam() throws NotNullArgumentException {
        if(this.getProjectcreateinstancepagrTeamInstance() == null || this.getProjectcreateinstancepagrTeamInstance().isNull()) {
            throw new NotNullArgumentException(ProjectConstants.SERV_ID_CREATEINSTANCE, ProjectConstants.CLASS_ID, ProjectConstants.ARG_ID_CREATEINSTANCE_PROJECTCREATEINSTANCEPAGRTEAM, ProjectConstants.SERV_ALIAS_CREATEINSTANCE, ProjectConstants.CLASS_ALIAS, ProjectConstants.ARG_ALIAS_CREATEINSTANCE_PROJECTCREATEINSTANCEPAGRTEAM);
        }
    }

    @JsonIgnore
    public String getProjectcreateinstancepatrProjectName() {
        return this.projectcreateinstancepatrProjectName;
    }
    
    public void setProjectcreateinstancepatrProjectName(String projectcreateinstancepatrProjectName) {
        this.projectcreateinstancepatrProjectName = projectcreateinstancepatrProjectName;
    }

    private void checkProjectcreateinstancepatrProjectName() throws NotNullArgumentException {
        if(this.getProjectcreateinstancepatrProjectName() == null) {
            throw new NotNullArgumentException(ProjectConstants.SERV_ID_CREATEINSTANCE, ProjectConstants.CLASS_ID, ProjectConstants.ARG_ID_CREATEINSTANCE_PROJECTCREATEINSTANCEPATRPROJECTNAME, ProjectConstants.SERV_ALIAS_CREATEINSTANCE, ProjectConstants.CLASS_ALIAS, ProjectConstants.ARG_ALIAS_CREATEINSTANCE_PROJECTCREATEINSTANCEPATRPROJECTNAME);
        }
    }

    @JsonIgnore
    public String getProjectcreateinstancepatrProDescription() {
        return this.projectcreateinstancepatrProDescription;
    }
    
    public void setProjectcreateinstancepatrProDescription(String projectcreateinstancepatrProDescription) {
        this.projectcreateinstancepatrProDescription = projectcreateinstancepatrProDescription;
    }

    private void checkProjectcreateinstancepatrProDescription() throws NotNullArgumentException {
        if(this.getProjectcreateinstancepatrProDescription() == null) {
            throw new NotNullArgumentException(ProjectConstants.SERV_ID_CREATEINSTANCE, ProjectConstants.CLASS_ID, ProjectConstants.ARG_ID_CREATEINSTANCE_PROJECTCREATEINSTANCEPATRPRODESCRIPTION, ProjectConstants.SERV_ALIAS_CREATEINSTANCE, ProjectConstants.CLASS_ALIAS, ProjectConstants.ARG_ALIAS_CREATEINSTANCE_PROJECTCREATEINSTANCEPATRPRODESCRIPTION);
        }
    }
}
