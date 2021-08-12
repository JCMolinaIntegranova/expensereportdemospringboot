package com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ERTemplateConstants;
import com.integranova.spring.expensereportdemo.persistence.ERTemplate;
import com.integranova.spring.expensereportdemo.persistence.oid.ERTemplateOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.EditNameRequest")
public class EditNameRequest {

    @ApiModelProperty(name = "Expense Report Template")
    @JsonProperty("p_thisertemplate_oid")
    private ERTemplateOid eRTemplateeditNamepthisERTemplate;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ERTemplate eRTemplateeditNamepthisERTemplateInstance;

    @ApiModelProperty(name = "Name")
    @JsonProperty("pname")
    private String eRTemplateeditNamepName;

    public void checkArguments() throws NotNullArgumentException {
        checkERTemplateeditNamepthisERTemplate();
        checkERTemplateeditNamepName();
    }

    @JsonIgnore
    public ERTemplateOid getERTemplateeditNamepthisERTemplate() {
        return this.eRTemplateeditNamepthisERTemplate;
    }
    
    public void setERTemplateeditNamepthisERTemplate(ERTemplateOid eRTemplateeditNamepthisERTemplate) {
        this.eRTemplateeditNamepthisERTemplate = eRTemplateeditNamepthisERTemplate;
    }

    @JsonIgnore
    public ERTemplate getERTemplateeditNamepthisERTemplateInstance() {
        return this.eRTemplateeditNamepthisERTemplateInstance;
    }
    
    public void setERTemplateeditNamepthisERTemplateInstance(ERTemplate eRTemplateeditNamepthisERTemplate) {
        this.eRTemplateeditNamepthisERTemplateInstance = eRTemplateeditNamepthisERTemplate;
    }

    private void checkERTemplateeditNamepthisERTemplate() throws NotNullArgumentException {
        if(this.getERTemplateeditNamepthisERTemplateInstance() == null || this.getERTemplateeditNamepthisERTemplateInstance().isNull()) {
            throw new NotNullArgumentException(ERTemplateConstants.SERV_ID_EDITNAME, ERTemplateConstants.CLASS_ID, ERTemplateConstants.ARG_ID_EDITNAME_ERTEMPLATEEDITNAMEPTHISERTEMPLATE, ERTemplateConstants.SERV_ALIAS_EDITNAME, ERTemplateConstants.CLASS_ALIAS, ERTemplateConstants.ARG_ALIAS_EDITNAME_ERTEMPLATEEDITNAMEPTHISERTEMPLATE);
        }
    }

    @JsonIgnore
    public String getERTemplateeditNamepName() {
        return this.eRTemplateeditNamepName;
    }
    
    public void setERTemplateeditNamepName(String eRTemplateeditNamepName) {
        this.eRTemplateeditNamepName = eRTemplateeditNamepName;
    }

    private void checkERTemplateeditNamepName() throws NotNullArgumentException {
        if(this.getERTemplateeditNamepName() == null) {
            throw new NotNullArgumentException(ERTemplateConstants.SERV_ID_EDITNAME, ERTemplateConstants.CLASS_ID, ERTemplateConstants.ARG_ID_EDITNAME_ERTEMPLATEEDITNAMEPNAME, ERTemplateConstants.SERV_ALIAS_EDITNAME, ERTemplateConstants.CLASS_ALIAS, ERTemplateConstants.ARG_ALIAS_EDITNAME_ERTEMPLATEEDITNAMEPNAME);
        }
    }
}
