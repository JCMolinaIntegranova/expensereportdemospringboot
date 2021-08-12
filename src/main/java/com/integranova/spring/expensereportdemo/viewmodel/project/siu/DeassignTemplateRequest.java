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

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.project.siu.DeassignTemplateRequest")
public class DeassignTemplateRequest {

    @ApiModelProperty(name = "Projects")
    @JsonProperty("p_thisproject_oid")
    private ProjectOid projectdeassignTemplatepthisProject;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Project projectdeassignTemplatepthisProjectInstance;

    @ApiModelProperty(name = "ERTemplates")
    @JsonProperty("p_evcertemplate_oid")
    private ERTemplateOid projectdeassignTemplatepevcERTemplate;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ERTemplate projectdeassignTemplatepevcERTemplateInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkProjectdeassignTemplatepthisProject();
        checkProjectdeassignTemplatepevcERTemplate();
    }

    @JsonIgnore
    public ProjectOid getProjectdeassignTemplatepthisProject() {
        return this.projectdeassignTemplatepthisProject;
    }
    
    public void setProjectdeassignTemplatepthisProject(ProjectOid projectdeassignTemplatepthisProject) {
        this.projectdeassignTemplatepthisProject = projectdeassignTemplatepthisProject;
    }

    @JsonIgnore
    public Project getProjectdeassignTemplatepthisProjectInstance() {
        return this.projectdeassignTemplatepthisProjectInstance;
    }
    
    public void setProjectdeassignTemplatepthisProjectInstance(Project projectdeassignTemplatepthisProject) {
        this.projectdeassignTemplatepthisProjectInstance = projectdeassignTemplatepthisProject;
    }

    private void checkProjectdeassignTemplatepthisProject() throws NotNullArgumentException {
        if(this.getProjectdeassignTemplatepthisProjectInstance() == null || this.getProjectdeassignTemplatepthisProjectInstance().isNull()) {
            throw new NotNullArgumentException(ProjectConstants.SERV_ID_DEASSIGNTEMPLATE, ProjectConstants.CLASS_ID, ProjectConstants.ARG_ID_DEASSIGNTEMPLATE_PROJECTDEASSIGNTEMPLATEPTHISPROJECT, ProjectConstants.SERV_ALIAS_DEASSIGNTEMPLATE, ProjectConstants.CLASS_ALIAS, ProjectConstants.ARG_ALIAS_DEASSIGNTEMPLATE_PROJECTDEASSIGNTEMPLATEPTHISPROJECT);
        }
    }

    @JsonIgnore
    public ERTemplateOid getProjectdeassignTemplatepevcERTemplate() {
        return this.projectdeassignTemplatepevcERTemplate;
    }
    
    public void setProjectdeassignTemplatepevcERTemplate(ERTemplateOid projectdeassignTemplatepevcERTemplate) {
        this.projectdeassignTemplatepevcERTemplate = projectdeassignTemplatepevcERTemplate;
    }

    @JsonIgnore
    public ERTemplate getProjectdeassignTemplatepevcERTemplateInstance() {
        return this.projectdeassignTemplatepevcERTemplateInstance;
    }
    
    public void setProjectdeassignTemplatepevcERTemplateInstance(ERTemplate projectdeassignTemplatepevcERTemplate) {
        this.projectdeassignTemplatepevcERTemplateInstance = projectdeassignTemplatepevcERTemplate;
    }

    private void checkProjectdeassignTemplatepevcERTemplate() throws NotNullArgumentException {
        if(this.getProjectdeassignTemplatepevcERTemplateInstance() == null || this.getProjectdeassignTemplatepevcERTemplateInstance().isNull()) {
            throw new NotNullArgumentException(ProjectConstants.SERV_ID_DEASSIGNTEMPLATE, ProjectConstants.CLASS_ID, ProjectConstants.ARG_ID_DEASSIGNTEMPLATE_PROJECTDEASSIGNTEMPLATEPEVCERTEMPLATE, ProjectConstants.SERV_ALIAS_DEASSIGNTEMPLATE, ProjectConstants.CLASS_ALIAS, ProjectConstants.ARG_ALIAS_DEASSIGNTEMPLATE_PROJECTDEASSIGNTEMPLATEPEVCERTEMPLATE);
        }
    }
}
