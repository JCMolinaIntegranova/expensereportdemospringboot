package com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ExpenseCurrencyConstants;
import com.integranova.spring.expensereportdemo.persistence.ExpenseCurrency;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseCurrencyOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.TEDITEXCHANGERequest")
public class TEDITEXCHANGERequest {

    @ApiModelProperty(name = "Expense Currency")
    @JsonProperty("p_thisexpensecurrency_oid")
    private ExpenseCurrencyOid expenseCurrencyTEDITEXCHANGEpthisExpenseCurrency;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ExpenseCurrency expenseCurrencyTEDITEXCHANGEpthisExpenseCurrencyInstance;

    @ApiModelProperty(name = "New Exchange")
    @JsonProperty("pexchange")
    private Double expenseCurrencyTEDITEXCHANGEpExchange;

    public void checkArguments() throws NotNullArgumentException {
        checkExpenseCurrencyTEDITEXCHANGEpthisExpenseCurrency();
        checkExpenseCurrencyTEDITEXCHANGEpExchange();
    }

    @JsonIgnore
    public ExpenseCurrencyOid getExpenseCurrencyTEDITEXCHANGEpthisExpenseCurrency() {
        return this.expenseCurrencyTEDITEXCHANGEpthisExpenseCurrency;
    }
    
    public void setExpenseCurrencyTEDITEXCHANGEpthisExpenseCurrency(ExpenseCurrencyOid expenseCurrencyTEDITEXCHANGEpthisExpenseCurrency) {
        this.expenseCurrencyTEDITEXCHANGEpthisExpenseCurrency = expenseCurrencyTEDITEXCHANGEpthisExpenseCurrency;
    }

    @JsonIgnore
    public ExpenseCurrency getExpenseCurrencyTEDITEXCHANGEpthisExpenseCurrencyInstance() {
        return this.expenseCurrencyTEDITEXCHANGEpthisExpenseCurrencyInstance;
    }
    
    public void setExpenseCurrencyTEDITEXCHANGEpthisExpenseCurrencyInstance(ExpenseCurrency expenseCurrencyTEDITEXCHANGEpthisExpenseCurrency) {
        this.expenseCurrencyTEDITEXCHANGEpthisExpenseCurrencyInstance = expenseCurrencyTEDITEXCHANGEpthisExpenseCurrency;
    }

    private void checkExpenseCurrencyTEDITEXCHANGEpthisExpenseCurrency() throws NotNullArgumentException {
        if(this.getExpenseCurrencyTEDITEXCHANGEpthisExpenseCurrencyInstance() == null || this.getExpenseCurrencyTEDITEXCHANGEpthisExpenseCurrencyInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseCurrencyConstants.SERV_ID_TEDITEXCHANGE, ExpenseCurrencyConstants.CLASS_ID, ExpenseCurrencyConstants.ARG_ID_TEDITEXCHANGE_EXPENSECURRENCYTEDITEXCHANGEPTHISEXPENSECURRENCY, ExpenseCurrencyConstants.SERV_ALIAS_TEDITEXCHANGE, ExpenseCurrencyConstants.CLASS_ALIAS, ExpenseCurrencyConstants.ARG_ALIAS_TEDITEXCHANGE_EXPENSECURRENCYTEDITEXCHANGEPTHISEXPENSECURRENCY);
        }
    }

    @JsonIgnore
    public Double getExpenseCurrencyTEDITEXCHANGEpExchange() {
        return this.expenseCurrencyTEDITEXCHANGEpExchange;
    }
    
    public void setExpenseCurrencyTEDITEXCHANGEpExchange(Double expenseCurrencyTEDITEXCHANGEpExchange) {
        this.expenseCurrencyTEDITEXCHANGEpExchange = expenseCurrencyTEDITEXCHANGEpExchange;
    }

    private void checkExpenseCurrencyTEDITEXCHANGEpExchange() throws NotNullArgumentException {
        if(this.getExpenseCurrencyTEDITEXCHANGEpExchange() == null) {
            throw new NotNullArgumentException(ExpenseCurrencyConstants.SERV_ID_TEDITEXCHANGE, ExpenseCurrencyConstants.CLASS_ID, ExpenseCurrencyConstants.ARG_ID_TEDITEXCHANGE_EXPENSECURRENCYTEDITEXCHANGEPEXCHANGE, ExpenseCurrencyConstants.SERV_ALIAS_TEDITEXCHANGE, ExpenseCurrencyConstants.CLASS_ALIAS, ExpenseCurrencyConstants.ARG_ALIAS_TEDITEXCHANGE_EXPENSECURRENCYTEDITEXCHANGEPEXCHANGE);
        }
    }
}
