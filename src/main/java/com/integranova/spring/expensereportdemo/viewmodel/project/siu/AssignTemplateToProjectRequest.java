package com.integranova.spring.expensereportdemo.viewmodel.project.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ProjectConstants;
import com.integranova.spring.expensereportdemo.persistence.ERTemplate;
import com.integranova.spring.expensereportdemo.persistence.oid.ERTemplateOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ProjectOid;
import com.integranova.spring.expensereportdemo.persistence.Project;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.project.siu.AssignTemplateToProjectRequest")
public class AssignTemplateToProjectRequest {

    @ApiModelProperty(name = "Projects")
    @JsonProperty("p_thisproject_oid")
    private ProjectOid projectassignTemplateToProjectpthisProject;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Project projectassignTemplateToProjectpthisProjectInstance;

    @ApiModelProperty(name = "ERTemplates")
    @JsonProperty("p_evcertemplate_oid")
    private ERTemplateOid projectassignTemplateToProjectpevcERTemplate;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ERTemplate projectassignTemplateToProjectpevcERTemplateInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkProjectassignTemplateToProjectpthisProject();
        checkProjectassignTemplateToProjectpevcERTemplate();
    }

    @JsonIgnore
    public ProjectOid getProjectassignTemplateToProjectpthisProject() {
        return this.projectassignTemplateToProjectpthisProject;
    }
    
    public void setProjectassignTemplateToProjectpthisProject(ProjectOid projectassignTemplateToProjectpthisProject) {
        this.projectassignTemplateToProjectpthisProject = projectassignTemplateToProjectpthisProject;
    }

    @JsonIgnore
    public Project getProjectassignTemplateToProjectpthisProjectInstance() {
        return this.projectassignTemplateToProjectpthisProjectInstance;
    }
    
    public void setProjectassignTemplateToProjectpthisProjectInstance(Project projectassignTemplateToProjectpthisProject) {
        this.projectassignTemplateToProjectpthisProjectInstance = projectassignTemplateToProjectpthisProject;
    }

    private void checkProjectassignTemplateToProjectpthisProject() throws NotNullArgumentException {
        if(this.getProjectassignTemplateToProjectpthisProjectInstance() == null || this.getProjectassignTemplateToProjectpthisProjectInstance().isNull()) {
            throw new NotNullArgumentException(ProjectConstants.SERV_ID_ASSIGNTEMPLATETOPROJECT, ProjectConstants.CLASS_ID, ProjectConstants.ARG_ID_ASSIGNTEMPLATETOPROJECT_PROJECTASSIGNTEMPLATETOPROJECTPTHISPROJECT, ProjectConstants.SERV_ALIAS_ASSIGNTEMPLATETOPROJECT, ProjectConstants.CLASS_ALIAS, ProjectConstants.ARG_ALIAS_ASSIGNTEMPLATETOPROJECT_PROJECTASSIGNTEMPLATETOPROJECTPTHISPROJECT);
        }
    }

    @JsonIgnore
    public ERTemplateOid getProjectassignTemplateToProjectpevcERTemplate() {
        return this.projectassignTemplateToProjectpevcERTemplate;
    }
    
    public void setProjectassignTemplateToProjectpevcERTemplate(ERTemplateOid projectassignTemplateToProjectpevcERTemplate) {
        this.projectassignTemplateToProjectpevcERTemplate = projectassignTemplateToProjectpevcERTemplate;
    }

    @JsonIgnore
    public ERTemplate getProjectassignTemplateToProjectpevcERTemplateInstance() {
        return this.projectassignTemplateToProjectpevcERTemplateInstance;
    }
    
    public void setProjectassignTemplateToProjectpevcERTemplateInstance(ERTemplate projectassignTemplateToProjectpevcERTemplate) {
        this.projectassignTemplateToProjectpevcERTemplateInstance = projectassignTemplateToProjectpevcERTemplate;
    }

    private void checkProjectassignTemplateToProjectpevcERTemplate() throws NotNullArgumentException {
        if(this.getProjectassignTemplateToProjectpevcERTemplateInstance() == null || this.getProjectassignTemplateToProjectpevcERTemplateInstance().isNull()) {
            throw new NotNullArgumentException(ProjectConstants.SERV_ID_ASSIGNTEMPLATETOPROJECT, ProjectConstants.CLASS_ID, ProjectConstants.ARG_ID_ASSIGNTEMPLATETOPROJECT_PROJECTASSIGNTEMPLATETOPROJECTPEVCERTEMPLATE, ProjectConstants.SERV_ALIAS_ASSIGNTEMPLATETOPROJECT, ProjectConstants.CLASS_ALIAS, ProjectConstants.ARG_ALIAS_ASSIGNTEMPLATETOPROJECT_PROJECTASSIGNTEMPLATETOPROJECTPEVCERTEMPLATE);
        }
    }
}
