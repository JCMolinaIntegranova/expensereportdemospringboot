package com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ERTemplateConstants;
import com.integranova.spring.expensereportdemo.persistence.ERTemplate;
import com.integranova.spring.expensereportdemo.persistence.oid.ERTemplateOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.EnableRequest")
public class EnableRequest {

    @ApiModelProperty(name = "Expense Report Template")
    @JsonProperty("p_thisertemplate_oid")
    private ERTemplateOid eRTemplateenablepthisERTemplate;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ERTemplate eRTemplateenablepthisERTemplateInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkERTemplateenablepthisERTemplate();
    }

    @JsonIgnore
    public ERTemplateOid getERTemplateenablepthisERTemplate() {
        return this.eRTemplateenablepthisERTemplate;
    }
    
    public void setERTemplateenablepthisERTemplate(ERTemplateOid eRTemplateenablepthisERTemplate) {
        this.eRTemplateenablepthisERTemplate = eRTemplateenablepthisERTemplate;
    }

    @JsonIgnore
    public ERTemplate getERTemplateenablepthisERTemplateInstance() {
        return this.eRTemplateenablepthisERTemplateInstance;
    }
    
    public void setERTemplateenablepthisERTemplateInstance(ERTemplate eRTemplateenablepthisERTemplate) {
        this.eRTemplateenablepthisERTemplateInstance = eRTemplateenablepthisERTemplate;
    }

    private void checkERTemplateenablepthisERTemplate() throws NotNullArgumentException {
        if(this.getERTemplateenablepthisERTemplateInstance() == null || this.getERTemplateenablepthisERTemplateInstance().isNull()) {
            throw new NotNullArgumentException(ERTemplateConstants.SERV_ID_ENABLE, ERTemplateConstants.CLASS_ID, ERTemplateConstants.ARG_ID_ENABLE_ERTEMPLATEENABLEPTHISERTEMPLATE, ERTemplateConstants.SERV_ALIAS_ENABLE, ERTemplateConstants.CLASS_ALIAS, ERTemplateConstants.ARG_ALIAS_ENABLE_ERTEMPLATEENABLEPTHISERTEMPLATE);
        }
    }
}
