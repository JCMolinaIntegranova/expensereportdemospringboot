package com.integranova.spring.expensereportdemo.viewmodel.project.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ProjectConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.ProjectOid;
import com.integranova.spring.expensereportdemo.persistence.Project;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.project.siu.DeleteinstanceRequest")
public class DeleteinstanceRequest {

    @ApiModelProperty(name = "Project")
    @JsonProperty("p_thisproject_oid")
    private ProjectOid projectdeleteinstancepthisProject;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Project projectdeleteinstancepthisProjectInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkProjectdeleteinstancepthisProject();
    }

    @JsonIgnore
    public ProjectOid getProjectdeleteinstancepthisProject() {
        return this.projectdeleteinstancepthisProject;
    }
    
    public void setProjectdeleteinstancepthisProject(ProjectOid projectdeleteinstancepthisProject) {
        this.projectdeleteinstancepthisProject = projectdeleteinstancepthisProject;
    }

    @JsonIgnore
    public Project getProjectdeleteinstancepthisProjectInstance() {
        return this.projectdeleteinstancepthisProjectInstance;
    }
    
    public void setProjectdeleteinstancepthisProjectInstance(Project projectdeleteinstancepthisProject) {
        this.projectdeleteinstancepthisProjectInstance = projectdeleteinstancepthisProject;
    }

    private void checkProjectdeleteinstancepthisProject() throws NotNullArgumentException {
        if(this.getProjectdeleteinstancepthisProjectInstance() == null || this.getProjectdeleteinstancepthisProjectInstance().isNull()) {
            throw new NotNullArgumentException(ProjectConstants.SERV_ID_DELETEINSTANCE, ProjectConstants.CLASS_ID, ProjectConstants.ARG_ID_DELETEINSTANCE_PROJECTDELETEINSTANCEPTHISPROJECT, ProjectConstants.SERV_ALIAS_DELETEINSTANCE, ProjectConstants.CLASS_ALIAS, ProjectConstants.ARG_ALIAS_DELETEINSTANCE_PROJECTDELETEINSTANCEPTHISPROJECT);
        }
    }
}
