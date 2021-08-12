package com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ERLTemplateConstants;
import com.integranova.spring.expensereportdemo.persistence.ERLTemplate;
import com.integranova.spring.expensereportdemo.persistence.oid.ERLTemplateOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.ClearDescriptionRequest")
public class ClearDescriptionRequest {

    @ApiModelProperty(name = "Expense Report Line Template")
    @JsonProperty("p_thiserltemplate_oid")
    private ERLTemplateOid eRLTemplateclearDescriptionpthisERLTemplate;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ERLTemplate eRLTemplateclearDescriptionpthisERLTemplateInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkERLTemplateclearDescriptionpthisERLTemplate();
    }

    @JsonIgnore
    public ERLTemplateOid getERLTemplateclearDescriptionpthisERLTemplate() {
        return this.eRLTemplateclearDescriptionpthisERLTemplate;
    }
    
    public void setERLTemplateclearDescriptionpthisERLTemplate(ERLTemplateOid eRLTemplateclearDescriptionpthisERLTemplate) {
        this.eRLTemplateclearDescriptionpthisERLTemplate = eRLTemplateclearDescriptionpthisERLTemplate;
    }

    @JsonIgnore
    public ERLTemplate getERLTemplateclearDescriptionpthisERLTemplateInstance() {
        return this.eRLTemplateclearDescriptionpthisERLTemplateInstance;
    }
    
    public void setERLTemplateclearDescriptionpthisERLTemplateInstance(ERLTemplate eRLTemplateclearDescriptionpthisERLTemplate) {
        this.eRLTemplateclearDescriptionpthisERLTemplateInstance = eRLTemplateclearDescriptionpthisERLTemplate;
    }

    private void checkERLTemplateclearDescriptionpthisERLTemplate() throws NotNullArgumentException {
        if(this.getERLTemplateclearDescriptionpthisERLTemplateInstance() == null || this.getERLTemplateclearDescriptionpthisERLTemplateInstance().isNull()) {
            throw new NotNullArgumentException(ERLTemplateConstants.SERV_ID_CLEARDESCRIPTION, ERLTemplateConstants.CLASS_ID, ERLTemplateConstants.ARG_ID_CLEARDESCRIPTION_ERLTEMPLATECLEARDESCRIPTIONPTHISERLTEMPLATE, ERLTemplateConstants.SERV_ALIAS_CLEARDESCRIPTION, ERLTemplateConstants.CLASS_ALIAS, ERLTemplateConstants.ARG_ALIAS_CLEARDESCRIPTION_ERLTEMPLATECLEARDESCRIPTIONPTHISERLTEMPLATE);
        }
    }
}
