package com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ERLTemplateConstants;
import com.integranova.spring.expensereportdemo.persistence.ERLTemplate;
import com.integranova.spring.expensereportdemo.persistence.oid.ERLTemplateOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.EditPriceRequest")
public class EditPriceRequest {

    @ApiModelProperty(name = "Expense Report Line Template")
    @JsonProperty("p_thiserltemplate_oid")
    private ERLTemplateOid eRLTemplateeditPricepthisERLTemplate;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ERLTemplate eRLTemplateeditPricepthisERLTemplateInstance;

    @ApiModelProperty(name = "Price")
    @JsonProperty("pprice")
    private Double eRLTemplateeditPricepPrice;

    public void checkArguments() throws NotNullArgumentException {
        checkERLTemplateeditPricepthisERLTemplate();
        checkERLTemplateeditPricepPrice();
    }

    @JsonIgnore
    public ERLTemplateOid getERLTemplateeditPricepthisERLTemplate() {
        return this.eRLTemplateeditPricepthisERLTemplate;
    }
    
    public void setERLTemplateeditPricepthisERLTemplate(ERLTemplateOid eRLTemplateeditPricepthisERLTemplate) {
        this.eRLTemplateeditPricepthisERLTemplate = eRLTemplateeditPricepthisERLTemplate;
    }

    @JsonIgnore
    public ERLTemplate getERLTemplateeditPricepthisERLTemplateInstance() {
        return this.eRLTemplateeditPricepthisERLTemplateInstance;
    }
    
    public void setERLTemplateeditPricepthisERLTemplateInstance(ERLTemplate eRLTemplateeditPricepthisERLTemplate) {
        this.eRLTemplateeditPricepthisERLTemplateInstance = eRLTemplateeditPricepthisERLTemplate;
    }

    private void checkERLTemplateeditPricepthisERLTemplate() throws NotNullArgumentException {
        if(this.getERLTemplateeditPricepthisERLTemplateInstance() == null || this.getERLTemplateeditPricepthisERLTemplateInstance().isNull()) {
            throw new NotNullArgumentException(ERLTemplateConstants.SERV_ID_EDITPRICE, ERLTemplateConstants.CLASS_ID, ERLTemplateConstants.ARG_ID_EDITPRICE_ERLTEMPLATEEDITPRICEPTHISERLTEMPLATE, ERLTemplateConstants.SERV_ALIAS_EDITPRICE, ERLTemplateConstants.CLASS_ALIAS, ERLTemplateConstants.ARG_ALIAS_EDITPRICE_ERLTEMPLATEEDITPRICEPTHISERLTEMPLATE);
        }
    }

    @JsonIgnore
    public Double getERLTemplateeditPricepPrice() {
        return this.eRLTemplateeditPricepPrice;
    }
    
    public void setERLTemplateeditPricepPrice(Double eRLTemplateeditPricepPrice) {
        this.eRLTemplateeditPricepPrice = eRLTemplateeditPricepPrice;
    }

    private void checkERLTemplateeditPricepPrice() throws NotNullArgumentException {
        if(this.getERLTemplateeditPricepPrice() == null) {
            throw new NotNullArgumentException(ERLTemplateConstants.SERV_ID_EDITPRICE, ERLTemplateConstants.CLASS_ID, ERLTemplateConstants.ARG_ID_EDITPRICE_ERLTEMPLATEEDITPRICEPPRICE, ERLTemplateConstants.SERV_ALIAS_EDITPRICE, ERLTemplateConstants.CLASS_ALIAS, ERLTemplateConstants.ARG_ALIAS_EDITPRICE_ERLTEMPLATEEDITPRICEPPRICE);
        }
    }
}
