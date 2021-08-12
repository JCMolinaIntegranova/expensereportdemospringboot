package com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ExpenseCurrencyConstants;
import com.integranova.spring.expensereportdemo.persistence.ExpenseCurrency;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseCurrencyOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.EditExchangeRequest")
public class EditExchangeRequest {

    @ApiModelProperty(name = "Expense Currency")
    @JsonProperty("p_thisexpensecurrency_oid")
    private ExpenseCurrencyOid expenseCurrencyeditExchangepthisExpenseCurrency;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ExpenseCurrency expenseCurrencyeditExchangepthisExpenseCurrencyInstance;

    @ApiModelProperty(name = "New Exchange")
    @JsonProperty("pexchange")
    private Double expenseCurrencyeditExchangepExchange;

    public void checkArguments() throws NotNullArgumentException {
        checkExpenseCurrencyeditExchangepthisExpenseCurrency();
        checkExpenseCurrencyeditExchangepExchange();
    }

    @JsonIgnore
    public ExpenseCurrencyOid getExpenseCurrencyeditExchangepthisExpenseCurrency() {
        return this.expenseCurrencyeditExchangepthisExpenseCurrency;
    }
    
    public void setExpenseCurrencyeditExchangepthisExpenseCurrency(ExpenseCurrencyOid expenseCurrencyeditExchangepthisExpenseCurrency) {
        this.expenseCurrencyeditExchangepthisExpenseCurrency = expenseCurrencyeditExchangepthisExpenseCurrency;
    }

    @JsonIgnore
    public ExpenseCurrency getExpenseCurrencyeditExchangepthisExpenseCurrencyInstance() {
        return this.expenseCurrencyeditExchangepthisExpenseCurrencyInstance;
    }
    
    public void setExpenseCurrencyeditExchangepthisExpenseCurrencyInstance(ExpenseCurrency expenseCurrencyeditExchangepthisExpenseCurrency) {
        this.expenseCurrencyeditExchangepthisExpenseCurrencyInstance = expenseCurrencyeditExchangepthisExpenseCurrency;
    }

    private void checkExpenseCurrencyeditExchangepthisExpenseCurrency() throws NotNullArgumentException {
        if(this.getExpenseCurrencyeditExchangepthisExpenseCurrencyInstance() == null || this.getExpenseCurrencyeditExchangepthisExpenseCurrencyInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseCurrencyConstants.SERV_ID_EDITEXCHANGE, ExpenseCurrencyConstants.CLASS_ID, ExpenseCurrencyConstants.ARG_ID_EDITEXCHANGE_EXPENSECURRENCYEDITEXCHANGEPTHISEXPENSECURRENCY, ExpenseCurrencyConstants.SERV_ALIAS_EDITEXCHANGE, ExpenseCurrencyConstants.CLASS_ALIAS, ExpenseCurrencyConstants.ARG_ALIAS_EDITEXCHANGE_EXPENSECURRENCYEDITEXCHANGEPTHISEXPENSECURRENCY);
        }
    }

    @JsonIgnore
    public Double getExpenseCurrencyeditExchangepExchange() {
        return this.expenseCurrencyeditExchangepExchange;
    }
    
    public void setExpenseCurrencyeditExchangepExchange(Double expenseCurrencyeditExchangepExchange) {
        this.expenseCurrencyeditExchangepExchange = expenseCurrencyeditExchangepExchange;
    }

    private void checkExpenseCurrencyeditExchangepExchange() throws NotNullArgumentException {
        if(this.getExpenseCurrencyeditExchangepExchange() == null) {
            throw new NotNullArgumentException(ExpenseCurrencyConstants.SERV_ID_EDITEXCHANGE, ExpenseCurrencyConstants.CLASS_ID, ExpenseCurrencyConstants.ARG_ID_EDITEXCHANGE_EXPENSECURRENCYEDITEXCHANGEPEXCHANGE, ExpenseCurrencyConstants.SERV_ALIAS_EDITEXCHANGE, ExpenseCurrencyConstants.CLASS_ALIAS, ExpenseCurrencyConstants.ARG_ALIAS_EDITEXCHANGE_EXPENSECURRENCYEDITEXCHANGEPEXCHANGE);
        }
    }
}
