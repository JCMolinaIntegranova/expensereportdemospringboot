package com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ERTemplateConstants;
import com.integranova.spring.expensereportdemo.persistence.ERTemplate;
import com.integranova.spring.expensereportdemo.persistence.oid.ERTemplateOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.DisableRequest")
public class DisableRequest {

    @ApiModelProperty(name = "Expense Report Template")
    @JsonProperty("p_thisertemplate_oid")
    private ERTemplateOid eRTemplatedisablepthisERTemplate;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ERTemplate eRTemplatedisablepthisERTemplateInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkERTemplatedisablepthisERTemplate();
    }

    @JsonIgnore
    public ERTemplateOid getERTemplatedisablepthisERTemplate() {
        return this.eRTemplatedisablepthisERTemplate;
    }
    
    public void setERTemplatedisablepthisERTemplate(ERTemplateOid eRTemplatedisablepthisERTemplate) {
        this.eRTemplatedisablepthisERTemplate = eRTemplatedisablepthisERTemplate;
    }

    @JsonIgnore
    public ERTemplate getERTemplatedisablepthisERTemplateInstance() {
        return this.eRTemplatedisablepthisERTemplateInstance;
    }
    
    public void setERTemplatedisablepthisERTemplateInstance(ERTemplate eRTemplatedisablepthisERTemplate) {
        this.eRTemplatedisablepthisERTemplateInstance = eRTemplatedisablepthisERTemplate;
    }

    private void checkERTemplatedisablepthisERTemplate() throws NotNullArgumentException {
        if(this.getERTemplatedisablepthisERTemplateInstance() == null || this.getERTemplatedisablepthisERTemplateInstance().isNull()) {
            throw new NotNullArgumentException(ERTemplateConstants.SERV_ID_DISABLE, ERTemplateConstants.CLASS_ID, ERTemplateConstants.ARG_ID_DISABLE_ERTEMPLATEDISABLEPTHISERTEMPLATE, ERTemplateConstants.SERV_ALIAS_DISABLE, ERTemplateConstants.CLASS_ALIAS, ERTemplateConstants.ARG_ALIAS_DISABLE_ERTEMPLATEDISABLEPTHISERTEMPLATE);
        }
    }
}
