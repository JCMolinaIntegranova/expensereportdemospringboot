package com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ExpenseCurrencyConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.CreateinstanceRequest")
public class CreateinstanceRequest {

    @ApiModelProperty(name = "Name")
    @JsonProperty("p_atrcurrencyname")
    private String expenseCurrencycreateinstancepatrCurrencyName;

    @ApiModelProperty(name = "Currency Code")
    @JsonProperty("p_atrcurrencycode")
    private String expenseCurrencycreateinstancepatrCurrencyCode;

    @ApiModelProperty(name = "Acronym")
    @JsonProperty("p_atrcuracronym")
    private String expenseCurrencycreateinstancepatrCurAcronym;

    @ApiModelProperty(name = "Exchange")
    @JsonProperty("p_atrexchange")
    private Double expenseCurrencycreateinstancepatrExchange;

    public void checkArguments() throws NotNullArgumentException {
        checkExpenseCurrencycreateinstancepatrCurrencyName();
        checkExpenseCurrencycreateinstancepatrCurrencyCode();
        checkExpenseCurrencycreateinstancepatrCurAcronym();
        checkExpenseCurrencycreateinstancepatrExchange();
    }

    @JsonIgnore
    public String getExpenseCurrencycreateinstancepatrCurrencyName() {
        return this.expenseCurrencycreateinstancepatrCurrencyName;
    }
    
    public void setExpenseCurrencycreateinstancepatrCurrencyName(String expenseCurrencycreateinstancepatrCurrencyName) {
        this.expenseCurrencycreateinstancepatrCurrencyName = expenseCurrencycreateinstancepatrCurrencyName;
    }

    private void checkExpenseCurrencycreateinstancepatrCurrencyName() throws NotNullArgumentException {
        if(this.getExpenseCurrencycreateinstancepatrCurrencyName() == null) {
            throw new NotNullArgumentException(ExpenseCurrencyConstants.SERV_ID_CREATEINSTANCE, ExpenseCurrencyConstants.CLASS_ID, ExpenseCurrencyConstants.ARG_ID_CREATEINSTANCE_EXPENSECURRENCYCREATEINSTANCEPATRCURRENCYNAME, ExpenseCurrencyConstants.SERV_ALIAS_CREATEINSTANCE, ExpenseCurrencyConstants.CLASS_ALIAS, ExpenseCurrencyConstants.ARG_ALIAS_CREATEINSTANCE_EXPENSECURRENCYCREATEINSTANCEPATRCURRENCYNAME);
        }
    }

    @JsonIgnore
    public String getExpenseCurrencycreateinstancepatrCurrencyCode() {
        return this.expenseCurrencycreateinstancepatrCurrencyCode;
    }
    
    public void setExpenseCurrencycreateinstancepatrCurrencyCode(String expenseCurrencycreateinstancepatrCurrencyCode) {
        this.expenseCurrencycreateinstancepatrCurrencyCode = expenseCurrencycreateinstancepatrCurrencyCode;
    }

    private void checkExpenseCurrencycreateinstancepatrCurrencyCode() throws NotNullArgumentException {
        if(this.getExpenseCurrencycreateinstancepatrCurrencyCode() == null) {
            throw new NotNullArgumentException(ExpenseCurrencyConstants.SERV_ID_CREATEINSTANCE, ExpenseCurrencyConstants.CLASS_ID, ExpenseCurrencyConstants.ARG_ID_CREATEINSTANCE_EXPENSECURRENCYCREATEINSTANCEPATRCURRENCYCODE, ExpenseCurrencyConstants.SERV_ALIAS_CREATEINSTANCE, ExpenseCurrencyConstants.CLASS_ALIAS, ExpenseCurrencyConstants.ARG_ALIAS_CREATEINSTANCE_EXPENSECURRENCYCREATEINSTANCEPATRCURRENCYCODE);
        }
    }

    @JsonIgnore
    public String getExpenseCurrencycreateinstancepatrCurAcronym() {
        return this.expenseCurrencycreateinstancepatrCurAcronym;
    }
    
    public void setExpenseCurrencycreateinstancepatrCurAcronym(String expenseCurrencycreateinstancepatrCurAcronym) {
        this.expenseCurrencycreateinstancepatrCurAcronym = expenseCurrencycreateinstancepatrCurAcronym;
    }

    private void checkExpenseCurrencycreateinstancepatrCurAcronym() throws NotNullArgumentException {
        if(this.getExpenseCurrencycreateinstancepatrCurAcronym() == null) {
            throw new NotNullArgumentException(ExpenseCurrencyConstants.SERV_ID_CREATEINSTANCE, ExpenseCurrencyConstants.CLASS_ID, ExpenseCurrencyConstants.ARG_ID_CREATEINSTANCE_EXPENSECURRENCYCREATEINSTANCEPATRCURACRONYM, ExpenseCurrencyConstants.SERV_ALIAS_CREATEINSTANCE, ExpenseCurrencyConstants.CLASS_ALIAS, ExpenseCurrencyConstants.ARG_ALIAS_CREATEINSTANCE_EXPENSECURRENCYCREATEINSTANCEPATRCURACRONYM);
        }
    }

    @JsonIgnore
    public Double getExpenseCurrencycreateinstancepatrExchange() {
        return this.expenseCurrencycreateinstancepatrExchange;
    }
    
    public void setExpenseCurrencycreateinstancepatrExchange(Double expenseCurrencycreateinstancepatrExchange) {
        this.expenseCurrencycreateinstancepatrExchange = expenseCurrencycreateinstancepatrExchange;
    }

    private void checkExpenseCurrencycreateinstancepatrExchange() throws NotNullArgumentException {
        if(this.getExpenseCurrencycreateinstancepatrExchange() == null) {
            throw new NotNullArgumentException(ExpenseCurrencyConstants.SERV_ID_CREATEINSTANCE, ExpenseCurrencyConstants.CLASS_ID, ExpenseCurrencyConstants.ARG_ID_CREATEINSTANCE_EXPENSECURRENCYCREATEINSTANCEPATREXCHANGE, ExpenseCurrencyConstants.SERV_ALIAS_CREATEINSTANCE, ExpenseCurrencyConstants.CLASS_ALIAS, ExpenseCurrencyConstants.ARG_ALIAS_CREATEINSTANCE_EXPENSECURRENCYCREATEINSTANCEPATREXCHANGE);
        }
    }
}
