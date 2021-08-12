package com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ERLTemplateConstants;
import com.integranova.spring.expensereportdemo.persistence.ERLTemplate;
import com.integranova.spring.expensereportdemo.persistence.oid.ERLTemplateOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.ClearUnitsRequest")
public class ClearUnitsRequest {

    @ApiModelProperty(name = "Expense Report Line Template")
    @JsonProperty("p_thiserltemplate_oid")
    private ERLTemplateOid eRLTemplateclearUnitspthisERLTemplate;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ERLTemplate eRLTemplateclearUnitspthisERLTemplateInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkERLTemplateclearUnitspthisERLTemplate();
    }

    @JsonIgnore
    public ERLTemplateOid getERLTemplateclearUnitspthisERLTemplate() {
        return this.eRLTemplateclearUnitspthisERLTemplate;
    }
    
    public void setERLTemplateclearUnitspthisERLTemplate(ERLTemplateOid eRLTemplateclearUnitspthisERLTemplate) {
        this.eRLTemplateclearUnitspthisERLTemplate = eRLTemplateclearUnitspthisERLTemplate;
    }

    @JsonIgnore
    public ERLTemplate getERLTemplateclearUnitspthisERLTemplateInstance() {
        return this.eRLTemplateclearUnitspthisERLTemplateInstance;
    }
    
    public void setERLTemplateclearUnitspthisERLTemplateInstance(ERLTemplate eRLTemplateclearUnitspthisERLTemplate) {
        this.eRLTemplateclearUnitspthisERLTemplateInstance = eRLTemplateclearUnitspthisERLTemplate;
    }

    private void checkERLTemplateclearUnitspthisERLTemplate() throws NotNullArgumentException {
        if(this.getERLTemplateclearUnitspthisERLTemplateInstance() == null || this.getERLTemplateclearUnitspthisERLTemplateInstance().isNull()) {
            throw new NotNullArgumentException(ERLTemplateConstants.SERV_ID_CLEARUNITS, ERLTemplateConstants.CLASS_ID, ERLTemplateConstants.ARG_ID_CLEARUNITS_ERLTEMPLATECLEARUNITSPTHISERLTEMPLATE, ERLTemplateConstants.SERV_ALIAS_CLEARUNITS, ERLTemplateConstants.CLASS_ALIAS, ERLTemplateConstants.ARG_ALIAS_CLEARUNITS_ERLTEMPLATECLEARUNITSPTHISERLTEMPLATE);
        }
    }
}
