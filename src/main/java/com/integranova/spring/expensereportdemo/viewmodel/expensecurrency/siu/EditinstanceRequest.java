package com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ExpenseCurrencyConstants;
import com.integranova.spring.expensereportdemo.persistence.ExpenseCurrency;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseCurrencyOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.EditinstanceRequest")
public class EditinstanceRequest {

    @ApiModelProperty(name = "Expense Currency")
    @JsonProperty("p_thisexpensecurrency_oid")
    private ExpenseCurrencyOid expenseCurrencyeditinstancepthisExpenseCurrency;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ExpenseCurrency expenseCurrencyeditinstancepthisExpenseCurrencyInstance;

    @ApiModelProperty(name = "Name")
    @JsonProperty("p_currencyname")
    private String expenseCurrencyeditinstancepCurrencyName;

    @ApiModelProperty(name = "Acronym")
    @JsonProperty("p_curacronym")
    private String expenseCurrencyeditinstancepCurAcronym;

    @ApiModelProperty(name = "Exchange")
    @JsonProperty("p_exchange")
    private Double expenseCurrencyeditinstancepExchange;

    public void checkArguments() throws NotNullArgumentException {
        checkExpenseCurrencyeditinstancepthisExpenseCurrency();
        checkExpenseCurrencyeditinstancepCurrencyName();
        checkExpenseCurrencyeditinstancepCurAcronym();
        checkExpenseCurrencyeditinstancepExchange();
    }

    @JsonIgnore
    public ExpenseCurrencyOid getExpenseCurrencyeditinstancepthisExpenseCurrency() {
        return this.expenseCurrencyeditinstancepthisExpenseCurrency;
    }
    
    public void setExpenseCurrencyeditinstancepthisExpenseCurrency(ExpenseCurrencyOid expenseCurrencyeditinstancepthisExpenseCurrency) {
        this.expenseCurrencyeditinstancepthisExpenseCurrency = expenseCurrencyeditinstancepthisExpenseCurrency;
    }

    @JsonIgnore
    public ExpenseCurrency getExpenseCurrencyeditinstancepthisExpenseCurrencyInstance() {
        return this.expenseCurrencyeditinstancepthisExpenseCurrencyInstance;
    }
    
    public void setExpenseCurrencyeditinstancepthisExpenseCurrencyInstance(ExpenseCurrency expenseCurrencyeditinstancepthisExpenseCurrency) {
        this.expenseCurrencyeditinstancepthisExpenseCurrencyInstance = expenseCurrencyeditinstancepthisExpenseCurrency;
    }

    private void checkExpenseCurrencyeditinstancepthisExpenseCurrency() throws NotNullArgumentException {
        if(this.getExpenseCurrencyeditinstancepthisExpenseCurrencyInstance() == null || this.getExpenseCurrencyeditinstancepthisExpenseCurrencyInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseCurrencyConstants.SERV_ID_EDITINSTANCE, ExpenseCurrencyConstants.CLASS_ID, ExpenseCurrencyConstants.ARG_ID_EDITINSTANCE_EXPENSECURRENCYEDITINSTANCEPTHISEXPENSECURRENCY, ExpenseCurrencyConstants.SERV_ALIAS_EDITINSTANCE, ExpenseCurrencyConstants.CLASS_ALIAS, ExpenseCurrencyConstants.ARG_ALIAS_EDITINSTANCE_EXPENSECURRENCYEDITINSTANCEPTHISEXPENSECURRENCY);
        }
    }

    @JsonIgnore
    public String getExpenseCurrencyeditinstancepCurrencyName() {
        return this.expenseCurrencyeditinstancepCurrencyName;
    }
    
    public void setExpenseCurrencyeditinstancepCurrencyName(String expenseCurrencyeditinstancepCurrencyName) {
        this.expenseCurrencyeditinstancepCurrencyName = expenseCurrencyeditinstancepCurrencyName;
    }

    private void checkExpenseCurrencyeditinstancepCurrencyName() throws NotNullArgumentException {
        if(this.getExpenseCurrencyeditinstancepCurrencyName() == null) {
            throw new NotNullArgumentException(ExpenseCurrencyConstants.SERV_ID_EDITINSTANCE, ExpenseCurrencyConstants.CLASS_ID, ExpenseCurrencyConstants.ARG_ID_EDITINSTANCE_EXPENSECURRENCYEDITINSTANCEPCURRENCYNAME, ExpenseCurrencyConstants.SERV_ALIAS_EDITINSTANCE, ExpenseCurrencyConstants.CLASS_ALIAS, ExpenseCurrencyConstants.ARG_ALIAS_EDITINSTANCE_EXPENSECURRENCYEDITINSTANCEPCURRENCYNAME);
        }
    }

    @JsonIgnore
    public String getExpenseCurrencyeditinstancepCurAcronym() {
        return this.expenseCurrencyeditinstancepCurAcronym;
    }
    
    public void setExpenseCurrencyeditinstancepCurAcronym(String expenseCurrencyeditinstancepCurAcronym) {
        this.expenseCurrencyeditinstancepCurAcronym = expenseCurrencyeditinstancepCurAcronym;
    }

    private void checkExpenseCurrencyeditinstancepCurAcronym() throws NotNullArgumentException {
        if(this.getExpenseCurrencyeditinstancepCurAcronym() == null) {
            throw new NotNullArgumentException(ExpenseCurrencyConstants.SERV_ID_EDITINSTANCE, ExpenseCurrencyConstants.CLASS_ID, ExpenseCurrencyConstants.ARG_ID_EDITINSTANCE_EXPENSECURRENCYEDITINSTANCEPCURACRONYM, ExpenseCurrencyConstants.SERV_ALIAS_EDITINSTANCE, ExpenseCurrencyConstants.CLASS_ALIAS, ExpenseCurrencyConstants.ARG_ALIAS_EDITINSTANCE_EXPENSECURRENCYEDITINSTANCEPCURACRONYM);
        }
    }

    @JsonIgnore
    public Double getExpenseCurrencyeditinstancepExchange() {
        return this.expenseCurrencyeditinstancepExchange;
    }
    
    public void setExpenseCurrencyeditinstancepExchange(Double expenseCurrencyeditinstancepExchange) {
        this.expenseCurrencyeditinstancepExchange = expenseCurrencyeditinstancepExchange;
    }

    private void checkExpenseCurrencyeditinstancepExchange() throws NotNullArgumentException {
        if(this.getExpenseCurrencyeditinstancepExchange() == null) {
            throw new NotNullArgumentException(ExpenseCurrencyConstants.SERV_ID_EDITINSTANCE, ExpenseCurrencyConstants.CLASS_ID, ExpenseCurrencyConstants.ARG_ID_EDITINSTANCE_EXPENSECURRENCYEDITINSTANCEPEXCHANGE, ExpenseCurrencyConstants.SERV_ALIAS_EDITINSTANCE, ExpenseCurrencyConstants.CLASS_ALIAS, ExpenseCurrencyConstants.ARG_ALIAS_EDITINSTANCE_EXPENSECURRENCYEDITINSTANCEPEXCHANGE);
        }
    }
}
