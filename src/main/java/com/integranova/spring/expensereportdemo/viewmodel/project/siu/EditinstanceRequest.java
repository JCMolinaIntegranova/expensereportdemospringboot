package com.integranova.spring.expensereportdemo.viewmodel.project.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ProjectConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.ProjectOid;
import com.integranova.spring.expensereportdemo.persistence.Project;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.project.siu.EditinstanceRequest")
public class EditinstanceRequest {

    @ApiModelProperty(name = "Project")
    @JsonProperty("p_thisproject_oid")
    private ProjectOid projecteditinstancepthisProject;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Project projecteditinstancepthisProjectInstance;

    @ApiModelProperty(name = "Name")
    @JsonProperty("p_projectname")
    private String projecteditinstancepProjectName;

    @ApiModelProperty(name = "Description")
    @JsonProperty("p_prodescription")
    private String projecteditinstancepProDescription;

    public void checkArguments() throws NotNullArgumentException {
        checkProjecteditinstancepthisProject();
        checkProjecteditinstancepProjectName();
        checkProjecteditinstancepProDescription();
    }

    @JsonIgnore
    public ProjectOid getProjecteditinstancepthisProject() {
        return this.projecteditinstancepthisProject;
    }
    
    public void setProjecteditinstancepthisProject(ProjectOid projecteditinstancepthisProject) {
        this.projecteditinstancepthisProject = projecteditinstancepthisProject;
    }

    @JsonIgnore
    public Project getProjecteditinstancepthisProjectInstance() {
        return this.projecteditinstancepthisProjectInstance;
    }
    
    public void setProjecteditinstancepthisProjectInstance(Project projecteditinstancepthisProject) {
        this.projecteditinstancepthisProjectInstance = projecteditinstancepthisProject;
    }

    private void checkProjecteditinstancepthisProject() throws NotNullArgumentException {
        if(this.getProjecteditinstancepthisProjectInstance() == null || this.getProjecteditinstancepthisProjectInstance().isNull()) {
            throw new NotNullArgumentException(ProjectConstants.SERV_ID_EDITINSTANCE, ProjectConstants.CLASS_ID, ProjectConstants.ARG_ID_EDITINSTANCE_PROJECTEDITINSTANCEPTHISPROJECT, ProjectConstants.SERV_ALIAS_EDITINSTANCE, ProjectConstants.CLASS_ALIAS, ProjectConstants.ARG_ALIAS_EDITINSTANCE_PROJECTEDITINSTANCEPTHISPROJECT);
        }
    }

    @JsonIgnore
    public String getProjecteditinstancepProjectName() {
        return this.projecteditinstancepProjectName;
    }
    
    public void setProjecteditinstancepProjectName(String projecteditinstancepProjectName) {
        this.projecteditinstancepProjectName = projecteditinstancepProjectName;
    }

    private void checkProjecteditinstancepProjectName() throws NotNullArgumentException {
        if(this.getProjecteditinstancepProjectName() == null) {
            throw new NotNullArgumentException(ProjectConstants.SERV_ID_EDITINSTANCE, ProjectConstants.CLASS_ID, ProjectConstants.ARG_ID_EDITINSTANCE_PROJECTEDITINSTANCEPPROJECTNAME, ProjectConstants.SERV_ALIAS_EDITINSTANCE, ProjectConstants.CLASS_ALIAS, ProjectConstants.ARG_ALIAS_EDITINSTANCE_PROJECTEDITINSTANCEPPROJECTNAME);
        }
    }

    @JsonIgnore
    public String getProjecteditinstancepProDescription() {
        return this.projecteditinstancepProDescription;
    }
    
    public void setProjecteditinstancepProDescription(String projecteditinstancepProDescription) {
        this.projecteditinstancepProDescription = projecteditinstancepProDescription;
    }

    private void checkProjecteditinstancepProDescription() throws NotNullArgumentException {
        if(this.getProjecteditinstancepProDescription() == null) {
            throw new NotNullArgumentException(ProjectConstants.SERV_ID_EDITINSTANCE, ProjectConstants.CLASS_ID, ProjectConstants.ARG_ID_EDITINSTANCE_PROJECTEDITINSTANCEPPRODESCRIPTION, ProjectConstants.SERV_ALIAS_EDITINSTANCE, ProjectConstants.CLASS_ALIAS, ProjectConstants.ARG_ALIAS_EDITINSTANCE_PROJECTEDITINSTANCEPPRODESCRIPTION);
        }
    }
}
