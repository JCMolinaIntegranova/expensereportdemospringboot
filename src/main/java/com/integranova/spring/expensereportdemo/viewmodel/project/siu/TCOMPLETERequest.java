package com.integranova.spring.expensereportdemo.viewmodel.project.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ProjectConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.ProjectOid;
import com.integranova.spring.expensereportdemo.persistence.Project;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.sql.Date;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.project.siu.TCOMPLETERequest")
public class TCOMPLETERequest {

    @ApiModelProperty(name = "Project")
    @JsonProperty("p_thisproject_oid")
    private ProjectOid projectTCOMPLETEpthisProject;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Project projectTCOMPLETEpthisProjectInstance;

    @ApiModelProperty(name = "Completion Date")
    @JsonProperty("pcompletiondate")
    private Date projectTCOMPLETEpCompletionDate;

    public void checkArguments() throws NotNullArgumentException {
        checkProjectTCOMPLETEpthisProject();
        checkProjectTCOMPLETEpCompletionDate();
    }

    @JsonIgnore
    public ProjectOid getProjectTCOMPLETEpthisProject() {
        return this.projectTCOMPLETEpthisProject;
    }
    
    public void setProjectTCOMPLETEpthisProject(ProjectOid projectTCOMPLETEpthisProject) {
        this.projectTCOMPLETEpthisProject = projectTCOMPLETEpthisProject;
    }

    @JsonIgnore
    public Project getProjectTCOMPLETEpthisProjectInstance() {
        return this.projectTCOMPLETEpthisProjectInstance;
    }
    
    public void setProjectTCOMPLETEpthisProjectInstance(Project projectTCOMPLETEpthisProject) {
        this.projectTCOMPLETEpthisProjectInstance = projectTCOMPLETEpthisProject;
    }

    private void checkProjectTCOMPLETEpthisProject() throws NotNullArgumentException {
        if(this.getProjectTCOMPLETEpthisProjectInstance() == null || this.getProjectTCOMPLETEpthisProjectInstance().isNull()) {
            throw new NotNullArgumentException(ProjectConstants.SERV_ID_TCOMPLETE, ProjectConstants.CLASS_ID, ProjectConstants.ARG_ID_TCOMPLETE_PROJECTTCOMPLETEPTHISPROJECT, ProjectConstants.SERV_ALIAS_TCOMPLETE, ProjectConstants.CLASS_ALIAS, ProjectConstants.ARG_ALIAS_TCOMPLETE_PROJECTTCOMPLETEPTHISPROJECT);
        }
    }

    @JsonIgnore
    public Date getProjectTCOMPLETEpCompletionDate() {
        return this.projectTCOMPLETEpCompletionDate;
    }
    
    public void setProjectTCOMPLETEpCompletionDate(Date projectTCOMPLETEpCompletionDate) {
        this.projectTCOMPLETEpCompletionDate = projectTCOMPLETEpCompletionDate;
    }

    private void checkProjectTCOMPLETEpCompletionDate() throws NotNullArgumentException {
        if(this.getProjectTCOMPLETEpCompletionDate() == null) {
            throw new NotNullArgumentException(ProjectConstants.SERV_ID_TCOMPLETE, ProjectConstants.CLASS_ID, ProjectConstants.ARG_ID_TCOMPLETE_PROJECTTCOMPLETEPCOMPLETIONDATE, ProjectConstants.SERV_ALIAS_TCOMPLETE, ProjectConstants.CLASS_ALIAS, ProjectConstants.ARG_ALIAS_TCOMPLETE_PROJECTTCOMPLETEPCOMPLETIONDATE);
        }
    }
}
