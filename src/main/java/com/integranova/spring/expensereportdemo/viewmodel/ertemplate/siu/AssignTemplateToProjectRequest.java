package com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ERTemplateConstants;
import com.integranova.spring.expensereportdemo.persistence.ERTemplate;
import com.integranova.spring.expensereportdemo.persistence.oid.ERTemplateOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ProjectOid;
import com.integranova.spring.expensereportdemo.persistence.Project;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.AssignTemplateToProjectRequest")
public class AssignTemplateToProjectRequest {

    @ApiModelProperty(name = "ERTemplates")
    @JsonProperty("p_thisertemplate_oid")
    private ERTemplateOid eRTemplateassignTemplateToProjectpthisERTemplate;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ERTemplate eRTemplateassignTemplateToProjectpthisERTemplateInstance;

    @ApiModelProperty(name = "Projects")
    @JsonProperty("p_evcproject_oid")
    private ProjectOid eRTemplateassignTemplateToProjectpevcProject;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Project eRTemplateassignTemplateToProjectpevcProjectInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkERTemplateassignTemplateToProjectpthisERTemplate();
        checkERTemplateassignTemplateToProjectpevcProject();
    }

    @JsonIgnore
    public ERTemplateOid getERTemplateassignTemplateToProjectpthisERTemplate() {
        return this.eRTemplateassignTemplateToProjectpthisERTemplate;
    }
    
    public void setERTemplateassignTemplateToProjectpthisERTemplate(ERTemplateOid eRTemplateassignTemplateToProjectpthisERTemplate) {
        this.eRTemplateassignTemplateToProjectpthisERTemplate = eRTemplateassignTemplateToProjectpthisERTemplate;
    }

    @JsonIgnore
    public ERTemplate getERTemplateassignTemplateToProjectpthisERTemplateInstance() {
        return this.eRTemplateassignTemplateToProjectpthisERTemplateInstance;
    }
    
    public void setERTemplateassignTemplateToProjectpthisERTemplateInstance(ERTemplate eRTemplateassignTemplateToProjectpthisERTemplate) {
        this.eRTemplateassignTemplateToProjectpthisERTemplateInstance = eRTemplateassignTemplateToProjectpthisERTemplate;
    }

    private void checkERTemplateassignTemplateToProjectpthisERTemplate() throws NotNullArgumentException {
        if(this.getERTemplateassignTemplateToProjectpthisERTemplateInstance() == null || this.getERTemplateassignTemplateToProjectpthisERTemplateInstance().isNull()) {
            throw new NotNullArgumentException(ERTemplateConstants.SERV_ID_ASSIGNTEMPLATETOPROJECT, ERTemplateConstants.CLASS_ID, ERTemplateConstants.ARG_ID_ASSIGNTEMPLATETOPROJECT_ERTEMPLATEASSIGNTEMPLATETOPROJECTPTHISERTEMPLATE, ERTemplateConstants.SERV_ALIAS_ASSIGNTEMPLATETOPROJECT, ERTemplateConstants.CLASS_ALIAS, ERTemplateConstants.ARG_ALIAS_ASSIGNTEMPLATETOPROJECT_ERTEMPLATEASSIGNTEMPLATETOPROJECTPTHISERTEMPLATE);
        }
    }

    @JsonIgnore
    public ProjectOid getERTemplateassignTemplateToProjectpevcProject() {
        return this.eRTemplateassignTemplateToProjectpevcProject;
    }
    
    public void setERTemplateassignTemplateToProjectpevcProject(ProjectOid eRTemplateassignTemplateToProjectpevcProject) {
        this.eRTemplateassignTemplateToProjectpevcProject = eRTemplateassignTemplateToProjectpevcProject;
    }

    @JsonIgnore
    public Project getERTemplateassignTemplateToProjectpevcProjectInstance() {
        return this.eRTemplateassignTemplateToProjectpevcProjectInstance;
    }
    
    public void setERTemplateassignTemplateToProjectpevcProjectInstance(Project eRTemplateassignTemplateToProjectpevcProject) {
        this.eRTemplateassignTemplateToProjectpevcProjectInstance = eRTemplateassignTemplateToProjectpevcProject;
    }

    private void checkERTemplateassignTemplateToProjectpevcProject() throws NotNullArgumentException {
        if(this.getERTemplateassignTemplateToProjectpevcProjectInstance() == null || this.getERTemplateassignTemplateToProjectpevcProjectInstance().isNull()) {
            throw new NotNullArgumentException(ERTemplateConstants.SERV_ID_ASSIGNTEMPLATETOPROJECT, ERTemplateConstants.CLASS_ID, ERTemplateConstants.ARG_ID_ASSIGNTEMPLATETOPROJECT_ERTEMPLATEASSIGNTEMPLATETOPROJECTPEVCPROJECT, ERTemplateConstants.SERV_ALIAS_ASSIGNTEMPLATETOPROJECT, ERTemplateConstants.CLASS_ALIAS, ERTemplateConstants.ARG_ALIAS_ASSIGNTEMPLATETOPROJECT_ERTEMPLATEASSIGNTEMPLATETOPROJECTPEVCPROJECT);
        }
    }
}
