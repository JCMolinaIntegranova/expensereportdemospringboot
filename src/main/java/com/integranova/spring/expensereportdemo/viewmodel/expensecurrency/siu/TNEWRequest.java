package com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ExpenseCurrencyConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.TNEWRequest")
public class TNEWRequest {

    @ApiModelProperty(name = "Name")
    @JsonProperty("pcurrencyname")
    private String expenseCurrencyTNEWpCurrencyName;

    @ApiModelProperty(name = "Currency Code")
    @JsonProperty("pcurrencycode")
    private String expenseCurrencyTNEWpCurrencyCode;

    @ApiModelProperty(name = "Acronym")
    @JsonProperty("pcuracronym")
    private String expenseCurrencyTNEWpCurAcronym;

    @ApiModelProperty(name = "Exchange")
    @JsonProperty("pexchange")
    private Double expenseCurrencyTNEWpExchange;

    public void checkArguments() throws NotNullArgumentException {
        checkExpenseCurrencyTNEWpCurrencyName();
        checkExpenseCurrencyTNEWpCurrencyCode();
        checkExpenseCurrencyTNEWpCurAcronym();
        checkExpenseCurrencyTNEWpExchange();
    }

    @JsonIgnore
    public String getExpenseCurrencyTNEWpCurrencyName() {
        return this.expenseCurrencyTNEWpCurrencyName;
    }
    
    public void setExpenseCurrencyTNEWpCurrencyName(String expenseCurrencyTNEWpCurrencyName) {
        this.expenseCurrencyTNEWpCurrencyName = expenseCurrencyTNEWpCurrencyName;
    }

    private void checkExpenseCurrencyTNEWpCurrencyName() throws NotNullArgumentException {
        if(this.getExpenseCurrencyTNEWpCurrencyName() == null) {
            throw new NotNullArgumentException(ExpenseCurrencyConstants.SERV_ID_TNEW, ExpenseCurrencyConstants.CLASS_ID, ExpenseCurrencyConstants.ARG_ID_TNEW_EXPENSECURRENCYTNEWPCURRENCYNAME, ExpenseCurrencyConstants.SERV_ALIAS_TNEW, ExpenseCurrencyConstants.CLASS_ALIAS, ExpenseCurrencyConstants.ARG_ALIAS_TNEW_EXPENSECURRENCYTNEWPCURRENCYNAME);
        }
    }

    @JsonIgnore
    public String getExpenseCurrencyTNEWpCurrencyCode() {
        return this.expenseCurrencyTNEWpCurrencyCode;
    }
    
    public void setExpenseCurrencyTNEWpCurrencyCode(String expenseCurrencyTNEWpCurrencyCode) {
        this.expenseCurrencyTNEWpCurrencyCode = expenseCurrencyTNEWpCurrencyCode;
    }

    private void checkExpenseCurrencyTNEWpCurrencyCode() throws NotNullArgumentException {
        if(this.getExpenseCurrencyTNEWpCurrencyCode() == null) {
            throw new NotNullArgumentException(ExpenseCurrencyConstants.SERV_ID_TNEW, ExpenseCurrencyConstants.CLASS_ID, ExpenseCurrencyConstants.ARG_ID_TNEW_EXPENSECURRENCYTNEWPCURRENCYCODE, ExpenseCurrencyConstants.SERV_ALIAS_TNEW, ExpenseCurrencyConstants.CLASS_ALIAS, ExpenseCurrencyConstants.ARG_ALIAS_TNEW_EXPENSECURRENCYTNEWPCURRENCYCODE);
        }
    }

    @JsonIgnore
    public String getExpenseCurrencyTNEWpCurAcronym() {
        return this.expenseCurrencyTNEWpCurAcronym;
    }
    
    public void setExpenseCurrencyTNEWpCurAcronym(String expenseCurrencyTNEWpCurAcronym) {
        this.expenseCurrencyTNEWpCurAcronym = expenseCurrencyTNEWpCurAcronym;
    }

    private void checkExpenseCurrencyTNEWpCurAcronym() throws NotNullArgumentException {
        if(this.getExpenseCurrencyTNEWpCurAcronym() == null) {
            throw new NotNullArgumentException(ExpenseCurrencyConstants.SERV_ID_TNEW, ExpenseCurrencyConstants.CLASS_ID, ExpenseCurrencyConstants.ARG_ID_TNEW_EXPENSECURRENCYTNEWPCURACRONYM, ExpenseCurrencyConstants.SERV_ALIAS_TNEW, ExpenseCurrencyConstants.CLASS_ALIAS, ExpenseCurrencyConstants.ARG_ALIAS_TNEW_EXPENSECURRENCYTNEWPCURACRONYM);
        }
    }

    @JsonIgnore
    public Double getExpenseCurrencyTNEWpExchange() {
        return this.expenseCurrencyTNEWpExchange;
    }
    
    public void setExpenseCurrencyTNEWpExchange(Double expenseCurrencyTNEWpExchange) {
        this.expenseCurrencyTNEWpExchange = expenseCurrencyTNEWpExchange;
    }

    private void checkExpenseCurrencyTNEWpExchange() throws NotNullArgumentException {
        if(this.getExpenseCurrencyTNEWpExchange() == null) {
            throw new NotNullArgumentException(ExpenseCurrencyConstants.SERV_ID_TNEW, ExpenseCurrencyConstants.CLASS_ID, ExpenseCurrencyConstants.ARG_ID_TNEW_EXPENSECURRENCYTNEWPEXCHANGE, ExpenseCurrencyConstants.SERV_ALIAS_TNEW, ExpenseCurrencyConstants.CLASS_ALIAS, ExpenseCurrencyConstants.ARG_ALIAS_TNEW_EXPENSECURRENCYTNEWPEXCHANGE);
        }
    }
}
