package com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ExpenseCurrencyConstants;
import com.integranova.spring.expensereportdemo.persistence.ExpenseCurrency;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseCurrencyOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.ResetExchangeRequest")
public class ResetExchangeRequest {

    @ApiModelProperty(name = "Expense Currency")
    @JsonProperty("p_thisexpensecurrency_oid")
    private ExpenseCurrencyOid expenseCurrencyresetExchangepthisExpenseCurrency;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ExpenseCurrency expenseCurrencyresetExchangepthisExpenseCurrencyInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkExpenseCurrencyresetExchangepthisExpenseCurrency();
    }

    @JsonIgnore
    public ExpenseCurrencyOid getExpenseCurrencyresetExchangepthisExpenseCurrency() {
        return this.expenseCurrencyresetExchangepthisExpenseCurrency;
    }
    
    public void setExpenseCurrencyresetExchangepthisExpenseCurrency(ExpenseCurrencyOid expenseCurrencyresetExchangepthisExpenseCurrency) {
        this.expenseCurrencyresetExchangepthisExpenseCurrency = expenseCurrencyresetExchangepthisExpenseCurrency;
    }

    @JsonIgnore
    public ExpenseCurrency getExpenseCurrencyresetExchangepthisExpenseCurrencyInstance() {
        return this.expenseCurrencyresetExchangepthisExpenseCurrencyInstance;
    }
    
    public void setExpenseCurrencyresetExchangepthisExpenseCurrencyInstance(ExpenseCurrency expenseCurrencyresetExchangepthisExpenseCurrency) {
        this.expenseCurrencyresetExchangepthisExpenseCurrencyInstance = expenseCurrencyresetExchangepthisExpenseCurrency;
    }

    private void checkExpenseCurrencyresetExchangepthisExpenseCurrency() throws NotNullArgumentException {
        if(this.getExpenseCurrencyresetExchangepthisExpenseCurrencyInstance() == null || this.getExpenseCurrencyresetExchangepthisExpenseCurrencyInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseCurrencyConstants.SERV_ID_RESETEXCHANGE, ExpenseCurrencyConstants.CLASS_ID, ExpenseCurrencyConstants.ARG_ID_RESETEXCHANGE_EXPENSECURRENCYRESETEXCHANGEPTHISEXPENSECURRENCY, ExpenseCurrencyConstants.SERV_ALIAS_RESETEXCHANGE, ExpenseCurrencyConstants.CLASS_ALIAS, ExpenseCurrencyConstants.ARG_ALIAS_RESETEXCHANGE_EXPENSECURRENCYRESETEXCHANGEPTHISEXPENSECURRENCY);
        }
    }
}
