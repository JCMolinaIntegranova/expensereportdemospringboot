package com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ERLTemplateConstants;
import com.integranova.spring.expensereportdemo.persistence.ERLTemplate;
import com.integranova.spring.expensereportdemo.persistence.oid.ERLTemplateOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.EditDescriptionRequest")
public class EditDescriptionRequest {

    @ApiModelProperty(name = "Expense Report Line Template")
    @JsonProperty("p_thiserltemplate_oid")
    private ERLTemplateOid eRLTemplateeditDescriptionpthisERLTemplate;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ERLTemplate eRLTemplateeditDescriptionpthisERLTemplateInstance;

    @ApiModelProperty(name = "Description")
    @JsonProperty("pdescription")
    private String eRLTemplateeditDescriptionpDescription;

    public void checkArguments() throws NotNullArgumentException {
        checkERLTemplateeditDescriptionpthisERLTemplate();
        checkERLTemplateeditDescriptionpDescription();
    }

    @JsonIgnore
    public ERLTemplateOid getERLTemplateeditDescriptionpthisERLTemplate() {
        return this.eRLTemplateeditDescriptionpthisERLTemplate;
    }
    
    public void setERLTemplateeditDescriptionpthisERLTemplate(ERLTemplateOid eRLTemplateeditDescriptionpthisERLTemplate) {
        this.eRLTemplateeditDescriptionpthisERLTemplate = eRLTemplateeditDescriptionpthisERLTemplate;
    }

    @JsonIgnore
    public ERLTemplate getERLTemplateeditDescriptionpthisERLTemplateInstance() {
        return this.eRLTemplateeditDescriptionpthisERLTemplateInstance;
    }
    
    public void setERLTemplateeditDescriptionpthisERLTemplateInstance(ERLTemplate eRLTemplateeditDescriptionpthisERLTemplate) {
        this.eRLTemplateeditDescriptionpthisERLTemplateInstance = eRLTemplateeditDescriptionpthisERLTemplate;
    }

    private void checkERLTemplateeditDescriptionpthisERLTemplate() throws NotNullArgumentException {
        if(this.getERLTemplateeditDescriptionpthisERLTemplateInstance() == null || this.getERLTemplateeditDescriptionpthisERLTemplateInstance().isNull()) {
            throw new NotNullArgumentException(ERLTemplateConstants.SERV_ID_EDITDESCRIPTION, ERLTemplateConstants.CLASS_ID, ERLTemplateConstants.ARG_ID_EDITDESCRIPTION_ERLTEMPLATEEDITDESCRIPTIONPTHISERLTEMPLATE, ERLTemplateConstants.SERV_ALIAS_EDITDESCRIPTION, ERLTemplateConstants.CLASS_ALIAS, ERLTemplateConstants.ARG_ALIAS_EDITDESCRIPTION_ERLTEMPLATEEDITDESCRIPTIONPTHISERLTEMPLATE);
        }
    }

    @JsonIgnore
    public String getERLTemplateeditDescriptionpDescription() {
        return this.eRLTemplateeditDescriptionpDescription;
    }
    
    public void setERLTemplateeditDescriptionpDescription(String eRLTemplateeditDescriptionpDescription) {
        this.eRLTemplateeditDescriptionpDescription = eRLTemplateeditDescriptionpDescription;
    }

    private void checkERLTemplateeditDescriptionpDescription() throws NotNullArgumentException {
        if(this.getERLTemplateeditDescriptionpDescription() == null) {
            throw new NotNullArgumentException(ERLTemplateConstants.SERV_ID_EDITDESCRIPTION, ERLTemplateConstants.CLASS_ID, ERLTemplateConstants.ARG_ID_EDITDESCRIPTION_ERLTEMPLATEEDITDESCRIPTIONPDESCRIPTION, ERLTemplateConstants.SERV_ALIAS_EDITDESCRIPTION, ERLTemplateConstants.CLASS_ALIAS, ERLTemplateConstants.ARG_ALIAS_EDITDESCRIPTION_ERLTEMPLATEEDITDESCRIPTIONPDESCRIPTION);
        }
    }
}
