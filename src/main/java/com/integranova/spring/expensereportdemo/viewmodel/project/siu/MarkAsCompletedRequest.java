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

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.project.siu.MarkAsCompletedRequest")
public class MarkAsCompletedRequest {

    @ApiModelProperty(name = "Project")
    @JsonProperty("p_thisproject_oid")
    private ProjectOid projectmarkAsCompletedpthisProject;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Project projectmarkAsCompletedpthisProjectInstance;

    @ApiModelProperty(name = "Completion Date")
    @JsonProperty("pcompletiondate")
    private Date projectmarkAsCompletedpCompletionDate;

    public void checkArguments() throws NotNullArgumentException {
        checkProjectmarkAsCompletedpthisProject();
        checkProjectmarkAsCompletedpCompletionDate();
    }

    @JsonIgnore
    public ProjectOid getProjectmarkAsCompletedpthisProject() {
        return this.projectmarkAsCompletedpthisProject;
    }
    
    public void setProjectmarkAsCompletedpthisProject(ProjectOid projectmarkAsCompletedpthisProject) {
        this.projectmarkAsCompletedpthisProject = projectmarkAsCompletedpthisProject;
    }

    @JsonIgnore
    public Project getProjectmarkAsCompletedpthisProjectInstance() {
        return this.projectmarkAsCompletedpthisProjectInstance;
    }
    
    public void setProjectmarkAsCompletedpthisProjectInstance(Project projectmarkAsCompletedpthisProject) {
        this.projectmarkAsCompletedpthisProjectInstance = projectmarkAsCompletedpthisProject;
    }

    private void checkProjectmarkAsCompletedpthisProject() throws NotNullArgumentException {
        if(this.getProjectmarkAsCompletedpthisProjectInstance() == null || this.getProjectmarkAsCompletedpthisProjectInstance().isNull()) {
            throw new NotNullArgumentException(ProjectConstants.SERV_ID_MARKASCOMPLETED, ProjectConstants.CLASS_ID, ProjectConstants.ARG_ID_MARKASCOMPLETED_PROJECTMARKASCOMPLETEDPTHISPROJECT, ProjectConstants.SERV_ALIAS_MARKASCOMPLETED, ProjectConstants.CLASS_ALIAS, ProjectConstants.ARG_ALIAS_MARKASCOMPLETED_PROJECTMARKASCOMPLETEDPTHISPROJECT);
        }
    }

    @JsonIgnore
    public Date getProjectmarkAsCompletedpCompletionDate() {
        return this.projectmarkAsCompletedpCompletionDate;
    }
    
    public void setProjectmarkAsCompletedpCompletionDate(Date projectmarkAsCompletedpCompletionDate) {
        this.projectmarkAsCompletedpCompletionDate = projectmarkAsCompletedpCompletionDate;
    }

    private void checkProjectmarkAsCompletedpCompletionDate() throws NotNullArgumentException {
        if(this.getProjectmarkAsCompletedpCompletionDate() == null) {
            throw new NotNullArgumentException(ProjectConstants.SERV_ID_MARKASCOMPLETED, ProjectConstants.CLASS_ID, ProjectConstants.ARG_ID_MARKASCOMPLETED_PROJECTMARKASCOMPLETEDPCOMPLETIONDATE, ProjectConstants.SERV_ALIAS_MARKASCOMPLETED, ProjectConstants.CLASS_ALIAS, ProjectConstants.ARG_ALIAS_MARKASCOMPLETED_PROJECTMARKASCOMPLETEDPCOMPLETIONDATE);
        }
    }
}
