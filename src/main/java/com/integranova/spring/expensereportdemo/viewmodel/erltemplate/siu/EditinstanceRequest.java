package com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ERLTemplateConstants;
import com.integranova.spring.expensereportdemo.persistence.ERLTemplate;
import com.integranova.spring.expensereportdemo.persistence.oid.ERLTemplateOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.EditinstanceRequest")
public class EditinstanceRequest {

    @ApiModelProperty(name = "Expense Report Line Template")
    @JsonProperty("p_thiserltemplate_oid")
    private ERLTemplateOid eRLTemplateeditinstancepthisERLTemplate;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ERLTemplate eRLTemplateeditinstancepthisERLTemplateInstance;

    @ApiModelProperty(name = "Units")
    @JsonProperty("p_units")
    private Double eRLTemplateeditinstancepunits;

    @ApiModelProperty(name = "Price")
    @JsonProperty("p_price")
    private Double eRLTemplateeditinstancepprice;

    @ApiModelProperty(name = "Description")
    @JsonProperty("p_description")
    private String eRLTemplateeditinstancepdescription;

    public void checkArguments() throws NotNullArgumentException {
        checkERLTemplateeditinstancepthisERLTemplate();
        checkERLTemplateeditinstancepunits();
        checkERLTemplateeditinstancepprice();
        checkERLTemplateeditinstancepdescription();
    }

    @JsonIgnore
    public ERLTemplateOid getERLTemplateeditinstancepthisERLTemplate() {
        return this.eRLTemplateeditinstancepthisERLTemplate;
    }
    
    public void setERLTemplateeditinstancepthisERLTemplate(ERLTemplateOid eRLTemplateeditinstancepthisERLTemplate) {
        this.eRLTemplateeditinstancepthisERLTemplate = eRLTemplateeditinstancepthisERLTemplate;
    }

    @JsonIgnore
    public ERLTemplate getERLTemplateeditinstancepthisERLTemplateInstance() {
        return this.eRLTemplateeditinstancepthisERLTemplateInstance;
    }
    
    public void setERLTemplateeditinstancepthisERLTemplateInstance(ERLTemplate eRLTemplateeditinstancepthisERLTemplate) {
        this.eRLTemplateeditinstancepthisERLTemplateInstance = eRLTemplateeditinstancepthisERLTemplate;
    }

    private void checkERLTemplateeditinstancepthisERLTemplate() throws NotNullArgumentException {
        if(this.getERLTemplateeditinstancepthisERLTemplateInstance() == null || this.getERLTemplateeditinstancepthisERLTemplateInstance().isNull()) {
            throw new NotNullArgumentException(ERLTemplateConstants.SERV_ID_EDITINSTANCE, ERLTemplateConstants.CLASS_ID, ERLTemplateConstants.ARG_ID_EDITINSTANCE_ERLTEMPLATEEDITINSTANCEPTHISERLTEMPLATE, ERLTemplateConstants.SERV_ALIAS_EDITINSTANCE, ERLTemplateConstants.CLASS_ALIAS, ERLTemplateConstants.ARG_ALIAS_EDITINSTANCE_ERLTEMPLATEEDITINSTANCEPTHISERLTEMPLATE);
        }
    }

    @JsonIgnore
    public Double getERLTemplateeditinstancepunits() {
        return this.eRLTemplateeditinstancepunits;
    }
    
    public void setERLTemplateeditinstancepunits(Double eRLTemplateeditinstancepunits) {
        this.eRLTemplateeditinstancepunits = eRLTemplateeditinstancepunits;
    }

    private void checkERLTemplateeditinstancepunits() throws NotNullArgumentException {
        if(this.getERLTemplateeditinstancepunits() == null) {
            throw new NotNullArgumentException(ERLTemplateConstants.SERV_ID_EDITINSTANCE, ERLTemplateConstants.CLASS_ID, ERLTemplateConstants.ARG_ID_EDITINSTANCE_ERLTEMPLATEEDITINSTANCEPUNITS, ERLTemplateConstants.SERV_ALIAS_EDITINSTANCE, ERLTemplateConstants.CLASS_ALIAS, ERLTemplateConstants.ARG_ALIAS_EDITINSTANCE_ERLTEMPLATEEDITINSTANCEPUNITS);
        }
    }

    @JsonIgnore
    public Double getERLTemplateeditinstancepprice() {
        return this.eRLTemplateeditinstancepprice;
    }
    
    public void setERLTemplateeditinstancepprice(Double eRLTemplateeditinstancepprice) {
        this.eRLTemplateeditinstancepprice = eRLTemplateeditinstancepprice;
    }

    private void checkERLTemplateeditinstancepprice() throws NotNullArgumentException {
        if(this.getERLTemplateeditinstancepprice() == null) {
            throw new NotNullArgumentException(ERLTemplateConstants.SERV_ID_EDITINSTANCE, ERLTemplateConstants.CLASS_ID, ERLTemplateConstants.ARG_ID_EDITINSTANCE_ERLTEMPLATEEDITINSTANCEPPRICE, ERLTemplateConstants.SERV_ALIAS_EDITINSTANCE, ERLTemplateConstants.CLASS_ALIAS, ERLTemplateConstants.ARG_ALIAS_EDITINSTANCE_ERLTEMPLATEEDITINSTANCEPPRICE);
        }
    }

    @JsonIgnore
    public String getERLTemplateeditinstancepdescription() {
        return this.eRLTemplateeditinstancepdescription;
    }
    
    public void setERLTemplateeditinstancepdescription(String eRLTemplateeditinstancepdescription) {
        this.eRLTemplateeditinstancepdescription = eRLTemplateeditinstancepdescription;
    }

    private void checkERLTemplateeditinstancepdescription() throws NotNullArgumentException {
        if(this.getERLTemplateeditinstancepdescription() == null) {
            throw new NotNullArgumentException(ERLTemplateConstants.SERV_ID_EDITINSTANCE, ERLTemplateConstants.CLASS_ID, ERLTemplateConstants.ARG_ID_EDITINSTANCE_ERLTEMPLATEEDITINSTANCEPDESCRIPTION, ERLTemplateConstants.SERV_ALIAS_EDITINSTANCE, ERLTemplateConstants.CLASS_ALIAS, ERLTemplateConstants.ARG_ALIAS_EDITINSTANCE_ERLTEMPLATEEDITINSTANCEPDESCRIPTION);
        }
    }
}
