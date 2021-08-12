package com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ERTemplateConstants;
import com.integranova.spring.expensereportdemo.persistence.ERTemplate;
import com.integranova.spring.expensereportdemo.persistence.oid.ERTemplateOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.ClearNameRequest")
public class ClearNameRequest {

    @ApiModelProperty(name = "Expense Report Template")
    @JsonProperty("p_thisertemplate_oid")
    private ERTemplateOid eRTemplateclearNamepthisERTemplate;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ERTemplate eRTemplateclearNamepthisERTemplateInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkERTemplateclearNamepthisERTemplate();
    }

    @JsonIgnore
    public ERTemplateOid getERTemplateclearNamepthisERTemplate() {
        return this.eRTemplateclearNamepthisERTemplate;
    }
    
    public void setERTemplateclearNamepthisERTemplate(ERTemplateOid eRTemplateclearNamepthisERTemplate) {
        this.eRTemplateclearNamepthisERTemplate = eRTemplateclearNamepthisERTemplate;
    }

    @JsonIgnore
    public ERTemplate getERTemplateclearNamepthisERTemplateInstance() {
        return this.eRTemplateclearNamepthisERTemplateInstance;
    }
    
    public void setERTemplateclearNamepthisERTemplateInstance(ERTemplate eRTemplateclearNamepthisERTemplate) {
        this.eRTemplateclearNamepthisERTemplateInstance = eRTemplateclearNamepthisERTemplate;
    }

    private void checkERTemplateclearNamepthisERTemplate() throws NotNullArgumentException {
        if(this.getERTemplateclearNamepthisERTemplateInstance() == null || this.getERTemplateclearNamepthisERTemplateInstance().isNull()) {
            throw new NotNullArgumentException(ERTemplateConstants.SERV_ID_CLEARNAME, ERTemplateConstants.CLASS_ID, ERTemplateConstants.ARG_ID_CLEARNAME_ERTEMPLATECLEARNAMEPTHISERTEMPLATE, ERTemplateConstants.SERV_ALIAS_CLEARNAME, ERTemplateConstants.CLASS_ALIAS, ERTemplateConstants.ARG_ALIAS_CLEARNAME_ERTEMPLATECLEARNAMEPTHISERTEMPLATE);
        }
    }
}
