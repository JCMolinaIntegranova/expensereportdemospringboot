package com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ERTemplateConstants;
import com.integranova.spring.expensereportdemo.persistence.ERTemplate;
import com.integranova.spring.expensereportdemo.persistence.oid.ERTemplateOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.EditDescriptionRequest")
public class EditDescriptionRequest {

    @ApiModelProperty(name = "Expense Report Template")
    @JsonProperty("p_thisertemplate_oid")
    private ERTemplateOid eRTemplateeditDescriptionpthisERTemplate;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ERTemplate eRTemplateeditDescriptionpthisERTemplateInstance;

    @ApiModelProperty(name = "Description")
    @JsonProperty("pdescription")
    private String eRTemplateeditDescriptionpDescription;

    public void checkArguments() throws NotNullArgumentException {
        checkERTemplateeditDescriptionpthisERTemplate();
        checkERTemplateeditDescriptionpDescription();
    }

    @JsonIgnore
    public ERTemplateOid getERTemplateeditDescriptionpthisERTemplate() {
        return this.eRTemplateeditDescriptionpthisERTemplate;
    }
    
    public void setERTemplateeditDescriptionpthisERTemplate(ERTemplateOid eRTemplateeditDescriptionpthisERTemplate) {
        this.eRTemplateeditDescriptionpthisERTemplate = eRTemplateeditDescriptionpthisERTemplate;
    }

    @JsonIgnore
    public ERTemplate getERTemplateeditDescriptionpthisERTemplateInstance() {
        return this.eRTemplateeditDescriptionpthisERTemplateInstance;
    }
    
    public void setERTemplateeditDescriptionpthisERTemplateInstance(ERTemplate eRTemplateeditDescriptionpthisERTemplate) {
        this.eRTemplateeditDescriptionpthisERTemplateInstance = eRTemplateeditDescriptionpthisERTemplate;
    }

    private void checkERTemplateeditDescriptionpthisERTemplate() throws NotNullArgumentException {
        if(this.getERTemplateeditDescriptionpthisERTemplateInstance() == null || this.getERTemplateeditDescriptionpthisERTemplateInstance().isNull()) {
            throw new NotNullArgumentException(ERTemplateConstants.SERV_ID_EDITDESCRIPTION, ERTemplateConstants.CLASS_ID, ERTemplateConstants.ARG_ID_EDITDESCRIPTION_ERTEMPLATEEDITDESCRIPTIONPTHISERTEMPLATE, ERTemplateConstants.SERV_ALIAS_EDITDESCRIPTION, ERTemplateConstants.CLASS_ALIAS, ERTemplateConstants.ARG_ALIAS_EDITDESCRIPTION_ERTEMPLATEEDITDESCRIPTIONPTHISERTEMPLATE);
        }
    }

    @JsonIgnore
    public String getERTemplateeditDescriptionpDescription() {
        return this.eRTemplateeditDescriptionpDescription;
    }
    
    public void setERTemplateeditDescriptionpDescription(String eRTemplateeditDescriptionpDescription) {
        this.eRTemplateeditDescriptionpDescription = eRTemplateeditDescriptionpDescription;
    }

    private void checkERTemplateeditDescriptionpDescription() throws NotNullArgumentException {
        if(this.getERTemplateeditDescriptionpDescription() == null) {
            throw new NotNullArgumentException(ERTemplateConstants.SERV_ID_EDITDESCRIPTION, ERTemplateConstants.CLASS_ID, ERTemplateConstants.ARG_ID_EDITDESCRIPTION_ERTEMPLATEEDITDESCRIPTIONPDESCRIPTION, ERTemplateConstants.SERV_ALIAS_EDITDESCRIPTION, ERTemplateConstants.CLASS_ALIAS, ERTemplateConstants.ARG_ALIAS_EDITDESCRIPTION_ERTEMPLATEEDITDESCRIPTIONPDESCRIPTION);
        }
    }
}
