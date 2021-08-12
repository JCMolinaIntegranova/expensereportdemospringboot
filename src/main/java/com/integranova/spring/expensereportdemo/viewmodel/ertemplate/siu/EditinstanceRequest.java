package com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ERTemplateConstants;
import com.integranova.spring.expensereportdemo.persistence.ERTemplate;
import com.integranova.spring.expensereportdemo.persistence.oid.ERTemplateOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.EditinstanceRequest")
public class EditinstanceRequest {

    @ApiModelProperty(name = "Expense Report Template")
    @JsonProperty("p_thisertemplate_oid")
    private ERTemplateOid eRTemplateeditinstancepthisERTemplate;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ERTemplate eRTemplateeditinstancepthisERTemplateInstance;

    @ApiModelProperty(name = "Name")
    @JsonProperty("p_name")
    private String eRTemplateeditinstancepname;

    @ApiModelProperty(name = "Description")
    @JsonProperty("p_description")
    private String eRTemplateeditinstancepdescription;

    public void checkArguments() throws NotNullArgumentException {
        checkERTemplateeditinstancepthisERTemplate();
        checkERTemplateeditinstancepname();
    }

    @JsonIgnore
    public ERTemplateOid getERTemplateeditinstancepthisERTemplate() {
        return this.eRTemplateeditinstancepthisERTemplate;
    }
    
    public void setERTemplateeditinstancepthisERTemplate(ERTemplateOid eRTemplateeditinstancepthisERTemplate) {
        this.eRTemplateeditinstancepthisERTemplate = eRTemplateeditinstancepthisERTemplate;
    }

    @JsonIgnore
    public ERTemplate getERTemplateeditinstancepthisERTemplateInstance() {
        return this.eRTemplateeditinstancepthisERTemplateInstance;
    }
    
    public void setERTemplateeditinstancepthisERTemplateInstance(ERTemplate eRTemplateeditinstancepthisERTemplate) {
        this.eRTemplateeditinstancepthisERTemplateInstance = eRTemplateeditinstancepthisERTemplate;
    }

    private void checkERTemplateeditinstancepthisERTemplate() throws NotNullArgumentException {
        if(this.getERTemplateeditinstancepthisERTemplateInstance() == null || this.getERTemplateeditinstancepthisERTemplateInstance().isNull()) {
            throw new NotNullArgumentException(ERTemplateConstants.SERV_ID_EDITINSTANCE, ERTemplateConstants.CLASS_ID, ERTemplateConstants.ARG_ID_EDITINSTANCE_ERTEMPLATEEDITINSTANCEPTHISERTEMPLATE, ERTemplateConstants.SERV_ALIAS_EDITINSTANCE, ERTemplateConstants.CLASS_ALIAS, ERTemplateConstants.ARG_ALIAS_EDITINSTANCE_ERTEMPLATEEDITINSTANCEPTHISERTEMPLATE);
        }
    }

    @JsonIgnore
    public String getERTemplateeditinstancepname() {
        return this.eRTemplateeditinstancepname;
    }
    
    public void setERTemplateeditinstancepname(String eRTemplateeditinstancepname) {
        this.eRTemplateeditinstancepname = eRTemplateeditinstancepname;
    }

    private void checkERTemplateeditinstancepname() throws NotNullArgumentException {
        if(this.getERTemplateeditinstancepname() == null) {
            throw new NotNullArgumentException(ERTemplateConstants.SERV_ID_EDITINSTANCE, ERTemplateConstants.CLASS_ID, ERTemplateConstants.ARG_ID_EDITINSTANCE_ERTEMPLATEEDITINSTANCEPNAME, ERTemplateConstants.SERV_ALIAS_EDITINSTANCE, ERTemplateConstants.CLASS_ALIAS, ERTemplateConstants.ARG_ALIAS_EDITINSTANCE_ERTEMPLATEEDITINSTANCEPNAME);
        }
    }

    @JsonIgnore
    public String getERTemplateeditinstancepdescription() {
        return this.eRTemplateeditinstancepdescription;
    }
    
    public void setERTemplateeditinstancepdescription(String eRTemplateeditinstancepdescription) {
        this.eRTemplateeditinstancepdescription = eRTemplateeditinstancepdescription;
    }
}
