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

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.DeassignTemplateRequest")
public class DeassignTemplateRequest {

    @ApiModelProperty(name = "ERTemplates")
    @JsonProperty("p_thisertemplate_oid")
    private ERTemplateOid eRTemplatedeassignTemplatepthisERTemplate;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ERTemplate eRTemplatedeassignTemplatepthisERTemplateInstance;

    @ApiModelProperty(name = "Projects")
    @JsonProperty("p_evcproject_oid")
    private ProjectOid eRTemplatedeassignTemplatepevcProject;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Project eRTemplatedeassignTemplatepevcProjectInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkERTemplatedeassignTemplatepthisERTemplate();
        checkERTemplatedeassignTemplatepevcProject();
    }

    @JsonIgnore
    public ERTemplateOid getERTemplatedeassignTemplatepthisERTemplate() {
        return this.eRTemplatedeassignTemplatepthisERTemplate;
    }
    
    public void setERTemplatedeassignTemplatepthisERTemplate(ERTemplateOid eRTemplatedeassignTemplatepthisERTemplate) {
        this.eRTemplatedeassignTemplatepthisERTemplate = eRTemplatedeassignTemplatepthisERTemplate;
    }

    @JsonIgnore
    public ERTemplate getERTemplatedeassignTemplatepthisERTemplateInstance() {
        return this.eRTemplatedeassignTemplatepthisERTemplateInstance;
    }
    
    public void setERTemplatedeassignTemplatepthisERTemplateInstance(ERTemplate eRTemplatedeassignTemplatepthisERTemplate) {
        this.eRTemplatedeassignTemplatepthisERTemplateInstance = eRTemplatedeassignTemplatepthisERTemplate;
    }

    private void checkERTemplatedeassignTemplatepthisERTemplate() throws NotNullArgumentException {
        if(this.getERTemplatedeassignTemplatepthisERTemplateInstance() == null || this.getERTemplatedeassignTemplatepthisERTemplateInstance().isNull()) {
            throw new NotNullArgumentException(ERTemplateConstants.SERV_ID_DEASSIGNTEMPLATE, ERTemplateConstants.CLASS_ID, ERTemplateConstants.ARG_ID_DEASSIGNTEMPLATE_ERTEMPLATEDEASSIGNTEMPLATEPTHISERTEMPLATE, ERTemplateConstants.SERV_ALIAS_DEASSIGNTEMPLATE, ERTemplateConstants.CLASS_ALIAS, ERTemplateConstants.ARG_ALIAS_DEASSIGNTEMPLATE_ERTEMPLATEDEASSIGNTEMPLATEPTHISERTEMPLATE);
        }
    }

    @JsonIgnore
    public ProjectOid getERTemplatedeassignTemplatepevcProject() {
        return this.eRTemplatedeassignTemplatepevcProject;
    }
    
    public void setERTemplatedeassignTemplatepevcProject(ProjectOid eRTemplatedeassignTemplatepevcProject) {
        this.eRTemplatedeassignTemplatepevcProject = eRTemplatedeassignTemplatepevcProject;
    }

    @JsonIgnore
    public Project getERTemplatedeassignTemplatepevcProjectInstance() {
        return this.eRTemplatedeassignTemplatepevcProjectInstance;
    }
    
    public void setERTemplatedeassignTemplatepevcProjectInstance(Project eRTemplatedeassignTemplatepevcProject) {
        this.eRTemplatedeassignTemplatepevcProjectInstance = eRTemplatedeassignTemplatepevcProject;
    }

    private void checkERTemplatedeassignTemplatepevcProject() throws NotNullArgumentException {
        if(this.getERTemplatedeassignTemplatepevcProjectInstance() == null || this.getERTemplatedeassignTemplatepevcProjectInstance().isNull()) {
            throw new NotNullArgumentException(ERTemplateConstants.SERV_ID_DEASSIGNTEMPLATE, ERTemplateConstants.CLASS_ID, ERTemplateConstants.ARG_ID_DEASSIGNTEMPLATE_ERTEMPLATEDEASSIGNTEMPLATEPEVCPROJECT, ERTemplateConstants.SERV_ALIAS_DEASSIGNTEMPLATE, ERTemplateConstants.CLASS_ALIAS, ERTemplateConstants.ARG_ALIAS_DEASSIGNTEMPLATE_ERTEMPLATEDEASSIGNTEMPLATEPEVCPROJECT);
        }
    }
}
