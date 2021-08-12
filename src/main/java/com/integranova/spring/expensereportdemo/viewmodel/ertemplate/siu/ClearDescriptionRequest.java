package com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ERTemplateConstants;
import com.integranova.spring.expensereportdemo.persistence.ERTemplate;
import com.integranova.spring.expensereportdemo.persistence.oid.ERTemplateOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.ClearDescriptionRequest")
public class ClearDescriptionRequest {

    @ApiModelProperty(name = "Expense Report Template")
    @JsonProperty("p_thisertemplate_oid")
    private ERTemplateOid eRTemplateclearDescriptionpthisERTemplate;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ERTemplate eRTemplateclearDescriptionpthisERTemplateInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkERTemplateclearDescriptionpthisERTemplate();
    }

    @JsonIgnore
    public ERTemplateOid getERTemplateclearDescriptionpthisERTemplate() {
        return this.eRTemplateclearDescriptionpthisERTemplate;
    }
    
    public void setERTemplateclearDescriptionpthisERTemplate(ERTemplateOid eRTemplateclearDescriptionpthisERTemplate) {
        this.eRTemplateclearDescriptionpthisERTemplate = eRTemplateclearDescriptionpthisERTemplate;
    }

    @JsonIgnore
    public ERTemplate getERTemplateclearDescriptionpthisERTemplateInstance() {
        return this.eRTemplateclearDescriptionpthisERTemplateInstance;
    }
    
    public void setERTemplateclearDescriptionpthisERTemplateInstance(ERTemplate eRTemplateclearDescriptionpthisERTemplate) {
        this.eRTemplateclearDescriptionpthisERTemplateInstance = eRTemplateclearDescriptionpthisERTemplate;
    }

    private void checkERTemplateclearDescriptionpthisERTemplate() throws NotNullArgumentException {
        if(this.getERTemplateclearDescriptionpthisERTemplateInstance() == null || this.getERTemplateclearDescriptionpthisERTemplateInstance().isNull()) {
            throw new NotNullArgumentException(ERTemplateConstants.SERV_ID_CLEARDESCRIPTION, ERTemplateConstants.CLASS_ID, ERTemplateConstants.ARG_ID_CLEARDESCRIPTION_ERTEMPLATECLEARDESCRIPTIONPTHISERTEMPLATE, ERTemplateConstants.SERV_ALIAS_CLEARDESCRIPTION, ERTemplateConstants.CLASS_ALIAS, ERTemplateConstants.ARG_ALIAS_CLEARDESCRIPTION_ERTEMPLATECLEARDESCRIPTIONPTHISERTEMPLATE);
        }
    }
}
