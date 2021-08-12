package com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ERLTemplateConstants;
import com.integranova.spring.expensereportdemo.persistence.ERTemplate;
import com.integranova.spring.expensereportdemo.persistence.ExpenseType;
import com.integranova.spring.expensereportdemo.persistence.oid.ERTemplateOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseTypeOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.CreateinstanceRequest")
public class CreateinstanceRequest {

    @ApiModelProperty(name = "Template")
    @JsonProperty("p_agrtemplate_oid")
    private ERTemplateOid eRLTemplatecreateinstancepagrTemplate;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ERTemplate eRLTemplatecreateinstancepagrTemplateInstance;

    @ApiModelProperty(name = "ExpenseType")
    @JsonProperty("p_agrexpensetype_oid")
    private ExpenseTypeOid eRLTemplatecreateinstancepagrExpenseType;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ExpenseType eRLTemplatecreateinstancepagrExpenseTypeInstance;

    @ApiModelProperty(name = "Units")
    @JsonProperty("p_atrunits")
    private Double eRLTemplatecreateinstancepatrunits;

    @ApiModelProperty(name = "Price")
    @JsonProperty("p_atrprice")
    private Double eRLTemplatecreateinstancepatrprice;

    @ApiModelProperty(name = "Description")
    @JsonProperty("p_atrdescription")
    private String eRLTemplatecreateinstancepatrdescription;

    public void checkArguments() throws NotNullArgumentException {
        checkERLTemplatecreateinstancepagrTemplate();
        checkERLTemplatecreateinstancepagrExpenseType();
        checkERLTemplatecreateinstancepatrunits();
        checkERLTemplatecreateinstancepatrprice();
        checkERLTemplatecreateinstancepatrdescription();
    }

    @JsonIgnore
    public ERTemplateOid getERLTemplatecreateinstancepagrTemplate() {
        return this.eRLTemplatecreateinstancepagrTemplate;
    }
    
    public void setERLTemplatecreateinstancepagrTemplate(ERTemplateOid eRLTemplatecreateinstancepagrTemplate) {
        this.eRLTemplatecreateinstancepagrTemplate = eRLTemplatecreateinstancepagrTemplate;
    }

    @JsonIgnore
    public ERTemplate getERLTemplatecreateinstancepagrTemplateInstance() {
        return this.eRLTemplatecreateinstancepagrTemplateInstance;
    }
    
    public void setERLTemplatecreateinstancepagrTemplateInstance(ERTemplate eRLTemplatecreateinstancepagrTemplate) {
        this.eRLTemplatecreateinstancepagrTemplateInstance = eRLTemplatecreateinstancepagrTemplate;
    }

    private void checkERLTemplatecreateinstancepagrTemplate() throws NotNullArgumentException {
        if(this.getERLTemplatecreateinstancepagrTemplateInstance() == null || this.getERLTemplatecreateinstancepagrTemplateInstance().isNull()) {
            throw new NotNullArgumentException(ERLTemplateConstants.SERV_ID_CREATEINSTANCE, ERLTemplateConstants.CLASS_ID, ERLTemplateConstants.ARG_ID_CREATEINSTANCE_ERLTEMPLATECREATEINSTANCEPAGRTEMPLATE, ERLTemplateConstants.SERV_ALIAS_CREATEINSTANCE, ERLTemplateConstants.CLASS_ALIAS, ERLTemplateConstants.ARG_ALIAS_CREATEINSTANCE_ERLTEMPLATECREATEINSTANCEPAGRTEMPLATE);
        }
    }

    @JsonIgnore
    public ExpenseTypeOid getERLTemplatecreateinstancepagrExpenseType() {
        return this.eRLTemplatecreateinstancepagrExpenseType;
    }
    
    public void setERLTemplatecreateinstancepagrExpenseType(ExpenseTypeOid eRLTemplatecreateinstancepagrExpenseType) {
        this.eRLTemplatecreateinstancepagrExpenseType = eRLTemplatecreateinstancepagrExpenseType;
    }

    @JsonIgnore
    public ExpenseType getERLTemplatecreateinstancepagrExpenseTypeInstance() {
        return this.eRLTemplatecreateinstancepagrExpenseTypeInstance;
    }
    
    public void setERLTemplatecreateinstancepagrExpenseTypeInstance(ExpenseType eRLTemplatecreateinstancepagrExpenseType) {
        this.eRLTemplatecreateinstancepagrExpenseTypeInstance = eRLTemplatecreateinstancepagrExpenseType;
    }

    private void checkERLTemplatecreateinstancepagrExpenseType() throws NotNullArgumentException {
        if(this.getERLTemplatecreateinstancepagrExpenseTypeInstance() == null || this.getERLTemplatecreateinstancepagrExpenseTypeInstance().isNull()) {
            throw new NotNullArgumentException(ERLTemplateConstants.SERV_ID_CREATEINSTANCE, ERLTemplateConstants.CLASS_ID, ERLTemplateConstants.ARG_ID_CREATEINSTANCE_ERLTEMPLATECREATEINSTANCEPAGREXPENSETYPE, ERLTemplateConstants.SERV_ALIAS_CREATEINSTANCE, ERLTemplateConstants.CLASS_ALIAS, ERLTemplateConstants.ARG_ALIAS_CREATEINSTANCE_ERLTEMPLATECREATEINSTANCEPAGREXPENSETYPE);
        }
    }

    @JsonIgnore
    public Double getERLTemplatecreateinstancepatrunits() {
        return this.eRLTemplatecreateinstancepatrunits;
    }
    
    public void setERLTemplatecreateinstancepatrunits(Double eRLTemplatecreateinstancepatrunits) {
        this.eRLTemplatecreateinstancepatrunits = eRLTemplatecreateinstancepatrunits;
    }

    private void checkERLTemplatecreateinstancepatrunits() throws NotNullArgumentException {
        if(this.getERLTemplatecreateinstancepatrunits() == null) {
            throw new NotNullArgumentException(ERLTemplateConstants.SERV_ID_CREATEINSTANCE, ERLTemplateConstants.CLASS_ID, ERLTemplateConstants.ARG_ID_CREATEINSTANCE_ERLTEMPLATECREATEINSTANCEPATRUNITS, ERLTemplateConstants.SERV_ALIAS_CREATEINSTANCE, ERLTemplateConstants.CLASS_ALIAS, ERLTemplateConstants.ARG_ALIAS_CREATEINSTANCE_ERLTEMPLATECREATEINSTANCEPATRUNITS);
        }
    }

    @JsonIgnore
    public Double getERLTemplatecreateinstancepatrprice() {
        return this.eRLTemplatecreateinstancepatrprice;
    }
    
    public void setERLTemplatecreateinstancepatrprice(Double eRLTemplatecreateinstancepatrprice) {
        this.eRLTemplatecreateinstancepatrprice = eRLTemplatecreateinstancepatrprice;
    }

    private void checkERLTemplatecreateinstancepatrprice() throws NotNullArgumentException {
        if(this.getERLTemplatecreateinstancepatrprice() == null) {
            throw new NotNullArgumentException(ERLTemplateConstants.SERV_ID_CREATEINSTANCE, ERLTemplateConstants.CLASS_ID, ERLTemplateConstants.ARG_ID_CREATEINSTANCE_ERLTEMPLATECREATEINSTANCEPATRPRICE, ERLTemplateConstants.SERV_ALIAS_CREATEINSTANCE, ERLTemplateConstants.CLASS_ALIAS, ERLTemplateConstants.ARG_ALIAS_CREATEINSTANCE_ERLTEMPLATECREATEINSTANCEPATRPRICE);
        }
    }

    @JsonIgnore
    public String getERLTemplatecreateinstancepatrdescription() {
        return this.eRLTemplatecreateinstancepatrdescription;
    }
    
    public void setERLTemplatecreateinstancepatrdescription(String eRLTemplatecreateinstancepatrdescription) {
        this.eRLTemplatecreateinstancepatrdescription = eRLTemplatecreateinstancepatrdescription;
    }

    private void checkERLTemplatecreateinstancepatrdescription() throws NotNullArgumentException {
        if(this.getERLTemplatecreateinstancepatrdescription() == null) {
            throw new NotNullArgumentException(ERLTemplateConstants.SERV_ID_CREATEINSTANCE, ERLTemplateConstants.CLASS_ID, ERLTemplateConstants.ARG_ID_CREATEINSTANCE_ERLTEMPLATECREATEINSTANCEPATRDESCRIPTION, ERLTemplateConstants.SERV_ALIAS_CREATEINSTANCE, ERLTemplateConstants.CLASS_ALIAS, ERLTemplateConstants.ARG_ALIAS_CREATEINSTANCE_ERLTEMPLATECREATEINSTANCEPATRDESCRIPTION);
        }
    }
}
