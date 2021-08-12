package com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ERLTemplateConstants;
import com.integranova.spring.expensereportdemo.persistence.ERLTemplate;
import com.integranova.spring.expensereportdemo.persistence.oid.ERLTemplateOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.EditUnitsRequest")
public class EditUnitsRequest {

    @ApiModelProperty(name = "Expense Report Line Template")
    @JsonProperty("p_thiserltemplate_oid")
    private ERLTemplateOid eRLTemplateeditUnitspthisERLTemplate;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ERLTemplate eRLTemplateeditUnitspthisERLTemplateInstance;

    @ApiModelProperty(name = "Units")
    @JsonProperty("punits")
    private Double eRLTemplateeditUnitspUnits;

    public void checkArguments() throws NotNullArgumentException {
        checkERLTemplateeditUnitspthisERLTemplate();
        checkERLTemplateeditUnitspUnits();
    }

    @JsonIgnore
    public ERLTemplateOid getERLTemplateeditUnitspthisERLTemplate() {
        return this.eRLTemplateeditUnitspthisERLTemplate;
    }
    
    public void setERLTemplateeditUnitspthisERLTemplate(ERLTemplateOid eRLTemplateeditUnitspthisERLTemplate) {
        this.eRLTemplateeditUnitspthisERLTemplate = eRLTemplateeditUnitspthisERLTemplate;
    }

    @JsonIgnore
    public ERLTemplate getERLTemplateeditUnitspthisERLTemplateInstance() {
        return this.eRLTemplateeditUnitspthisERLTemplateInstance;
    }
    
    public void setERLTemplateeditUnitspthisERLTemplateInstance(ERLTemplate eRLTemplateeditUnitspthisERLTemplate) {
        this.eRLTemplateeditUnitspthisERLTemplateInstance = eRLTemplateeditUnitspthisERLTemplate;
    }

    private void checkERLTemplateeditUnitspthisERLTemplate() throws NotNullArgumentException {
        if(this.getERLTemplateeditUnitspthisERLTemplateInstance() == null || this.getERLTemplateeditUnitspthisERLTemplateInstance().isNull()) {
            throw new NotNullArgumentException(ERLTemplateConstants.SERV_ID_EDITUNITS, ERLTemplateConstants.CLASS_ID, ERLTemplateConstants.ARG_ID_EDITUNITS_ERLTEMPLATEEDITUNITSPTHISERLTEMPLATE, ERLTemplateConstants.SERV_ALIAS_EDITUNITS, ERLTemplateConstants.CLASS_ALIAS, ERLTemplateConstants.ARG_ALIAS_EDITUNITS_ERLTEMPLATEEDITUNITSPTHISERLTEMPLATE);
        }
    }

    @JsonIgnore
    public Double getERLTemplateeditUnitspUnits() {
        return this.eRLTemplateeditUnitspUnits;
    }
    
    public void setERLTemplateeditUnitspUnits(Double eRLTemplateeditUnitspUnits) {
        this.eRLTemplateeditUnitspUnits = eRLTemplateeditUnitspUnits;
    }

    private void checkERLTemplateeditUnitspUnits() throws NotNullArgumentException {
        if(this.getERLTemplateeditUnitspUnits() == null) {
            throw new NotNullArgumentException(ERLTemplateConstants.SERV_ID_EDITUNITS, ERLTemplateConstants.CLASS_ID, ERLTemplateConstants.ARG_ID_EDITUNITS_ERLTEMPLATEEDITUNITSPUNITS, ERLTemplateConstants.SERV_ALIAS_EDITUNITS, ERLTemplateConstants.CLASS_ALIAS, ERLTemplateConstants.ARG_ALIAS_EDITUNITS_ERLTEMPLATEEDITUNITSPUNITS);
        }
    }
}
