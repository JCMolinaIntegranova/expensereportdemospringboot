package com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ERLTemplateConstants;
import com.integranova.spring.expensereportdemo.persistence.ERLTemplate;
import com.integranova.spring.expensereportdemo.persistence.oid.ERLTemplateOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.DeleteinstanceRequest")
public class DeleteinstanceRequest {

    @ApiModelProperty(name = "Expense Report Line Template")
    @JsonProperty("p_thiserltemplate_oid")
    private ERLTemplateOid eRLTemplatedeleteinstancepthisERLTemplate;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ERLTemplate eRLTemplatedeleteinstancepthisERLTemplateInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkERLTemplatedeleteinstancepthisERLTemplate();
    }

    @JsonIgnore
    public ERLTemplateOid getERLTemplatedeleteinstancepthisERLTemplate() {
        return this.eRLTemplatedeleteinstancepthisERLTemplate;
    }
    
    public void setERLTemplatedeleteinstancepthisERLTemplate(ERLTemplateOid eRLTemplatedeleteinstancepthisERLTemplate) {
        this.eRLTemplatedeleteinstancepthisERLTemplate = eRLTemplatedeleteinstancepthisERLTemplate;
    }

    @JsonIgnore
    public ERLTemplate getERLTemplatedeleteinstancepthisERLTemplateInstance() {
        return this.eRLTemplatedeleteinstancepthisERLTemplateInstance;
    }
    
    public void setERLTemplatedeleteinstancepthisERLTemplateInstance(ERLTemplate eRLTemplatedeleteinstancepthisERLTemplate) {
        this.eRLTemplatedeleteinstancepthisERLTemplateInstance = eRLTemplatedeleteinstancepthisERLTemplate;
    }

    private void checkERLTemplatedeleteinstancepthisERLTemplate() throws NotNullArgumentException {
        if(this.getERLTemplatedeleteinstancepthisERLTemplateInstance() == null || this.getERLTemplatedeleteinstancepthisERLTemplateInstance().isNull()) {
            throw new NotNullArgumentException(ERLTemplateConstants.SERV_ID_DELETEINSTANCE, ERLTemplateConstants.CLASS_ID, ERLTemplateConstants.ARG_ID_DELETEINSTANCE_ERLTEMPLATEDELETEINSTANCEPTHISERLTEMPLATE, ERLTemplateConstants.SERV_ALIAS_DELETEINSTANCE, ERLTemplateConstants.CLASS_ALIAS, ERLTemplateConstants.ARG_ALIAS_DELETEINSTANCE_ERLTEMPLATEDELETEINSTANCEPTHISERLTEMPLATE);
        }
    }
}
