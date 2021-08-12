package com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ERLTemplateConstants;
import com.integranova.spring.expensereportdemo.persistence.ERLTemplate;
import com.integranova.spring.expensereportdemo.persistence.oid.ERLTemplateOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.ClearPriceRequest")
public class ClearPriceRequest {

    @ApiModelProperty(name = "Expense Report Line Template")
    @JsonProperty("p_thiserltemplate_oid")
    private ERLTemplateOid eRLTemplateclearPricepthisERLTemplate;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ERLTemplate eRLTemplateclearPricepthisERLTemplateInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkERLTemplateclearPricepthisERLTemplate();
    }

    @JsonIgnore
    public ERLTemplateOid getERLTemplateclearPricepthisERLTemplate() {
        return this.eRLTemplateclearPricepthisERLTemplate;
    }
    
    public void setERLTemplateclearPricepthisERLTemplate(ERLTemplateOid eRLTemplateclearPricepthisERLTemplate) {
        this.eRLTemplateclearPricepthisERLTemplate = eRLTemplateclearPricepthisERLTemplate;
    }

    @JsonIgnore
    public ERLTemplate getERLTemplateclearPricepthisERLTemplateInstance() {
        return this.eRLTemplateclearPricepthisERLTemplateInstance;
    }
    
    public void setERLTemplateclearPricepthisERLTemplateInstance(ERLTemplate eRLTemplateclearPricepthisERLTemplate) {
        this.eRLTemplateclearPricepthisERLTemplateInstance = eRLTemplateclearPricepthisERLTemplate;
    }

    private void checkERLTemplateclearPricepthisERLTemplate() throws NotNullArgumentException {
        if(this.getERLTemplateclearPricepthisERLTemplateInstance() == null || this.getERLTemplateclearPricepthisERLTemplateInstance().isNull()) {
            throw new NotNullArgumentException(ERLTemplateConstants.SERV_ID_CLEARPRICE, ERLTemplateConstants.CLASS_ID, ERLTemplateConstants.ARG_ID_CLEARPRICE_ERLTEMPLATECLEARPRICEPTHISERLTEMPLATE, ERLTemplateConstants.SERV_ALIAS_CLEARPRICE, ERLTemplateConstants.CLASS_ALIAS, ERLTemplateConstants.ARG_ALIAS_CLEARPRICE_ERLTEMPLATECLEARPRICEPTHISERLTEMPLATE);
        }
    }
}
