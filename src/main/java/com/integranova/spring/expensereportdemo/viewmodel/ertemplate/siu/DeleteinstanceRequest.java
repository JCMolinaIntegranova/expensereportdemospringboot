package com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ERTemplateConstants;
import com.integranova.spring.expensereportdemo.persistence.ERTemplate;
import com.integranova.spring.expensereportdemo.persistence.oid.ERTemplateOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.DeleteinstanceRequest")
public class DeleteinstanceRequest {

    @ApiModelProperty(name = "Expense Report Template")
    @JsonProperty("p_thisertemplate_oid")
    private ERTemplateOid eRTemplatedeleteinstancepthisERTemplate;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ERTemplate eRTemplatedeleteinstancepthisERTemplateInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkERTemplatedeleteinstancepthisERTemplate();
    }

    @JsonIgnore
    public ERTemplateOid getERTemplatedeleteinstancepthisERTemplate() {
        return this.eRTemplatedeleteinstancepthisERTemplate;
    }
    
    public void setERTemplatedeleteinstancepthisERTemplate(ERTemplateOid eRTemplatedeleteinstancepthisERTemplate) {
        this.eRTemplatedeleteinstancepthisERTemplate = eRTemplatedeleteinstancepthisERTemplate;
    }

    @JsonIgnore
    public ERTemplate getERTemplatedeleteinstancepthisERTemplateInstance() {
        return this.eRTemplatedeleteinstancepthisERTemplateInstance;
    }
    
    public void setERTemplatedeleteinstancepthisERTemplateInstance(ERTemplate eRTemplatedeleteinstancepthisERTemplate) {
        this.eRTemplatedeleteinstancepthisERTemplateInstance = eRTemplatedeleteinstancepthisERTemplate;
    }

    private void checkERTemplatedeleteinstancepthisERTemplate() throws NotNullArgumentException {
        if(this.getERTemplatedeleteinstancepthisERTemplateInstance() == null || this.getERTemplatedeleteinstancepthisERTemplateInstance().isNull()) {
            throw new NotNullArgumentException(ERTemplateConstants.SERV_ID_DELETEINSTANCE, ERTemplateConstants.CLASS_ID, ERTemplateConstants.ARG_ID_DELETEINSTANCE_ERTEMPLATEDELETEINSTANCEPTHISERTEMPLATE, ERTemplateConstants.SERV_ALIAS_DELETEINSTANCE, ERTemplateConstants.CLASS_ALIAS, ERTemplateConstants.ARG_ALIAS_DELETEINSTANCE_ERTEMPLATEDELETEINSTANCEPTHISERTEMPLATE);
        }
    }
}
