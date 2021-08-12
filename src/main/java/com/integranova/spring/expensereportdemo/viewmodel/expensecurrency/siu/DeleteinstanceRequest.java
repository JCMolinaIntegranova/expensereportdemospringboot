package com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ExpenseCurrencyConstants;
import com.integranova.spring.expensereportdemo.persistence.ExpenseCurrency;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseCurrencyOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.DeleteinstanceRequest")
public class DeleteinstanceRequest {

    @ApiModelProperty(name = "Expense Currency")
    @JsonProperty("p_thisexpensecurrency_oid")
    private ExpenseCurrencyOid expenseCurrencydeleteinstancepthisExpenseCurrency;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ExpenseCurrency expenseCurrencydeleteinstancepthisExpenseCurrencyInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkExpenseCurrencydeleteinstancepthisExpenseCurrency();
    }

    @JsonIgnore
    public ExpenseCurrencyOid getExpenseCurrencydeleteinstancepthisExpenseCurrency() {
        return this.expenseCurrencydeleteinstancepthisExpenseCurrency;
    }
    
    public void setExpenseCurrencydeleteinstancepthisExpenseCurrency(ExpenseCurrencyOid expenseCurrencydeleteinstancepthisExpenseCurrency) {
        this.expenseCurrencydeleteinstancepthisExpenseCurrency = expenseCurrencydeleteinstancepthisExpenseCurrency;
    }

    @JsonIgnore
    public ExpenseCurrency getExpenseCurrencydeleteinstancepthisExpenseCurrencyInstance() {
        return this.expenseCurrencydeleteinstancepthisExpenseCurrencyInstance;
    }
    
    public void setExpenseCurrencydeleteinstancepthisExpenseCurrencyInstance(ExpenseCurrency expenseCurrencydeleteinstancepthisExpenseCurrency) {
        this.expenseCurrencydeleteinstancepthisExpenseCurrencyInstance = expenseCurrencydeleteinstancepthisExpenseCurrency;
    }

    private void checkExpenseCurrencydeleteinstancepthisExpenseCurrency() throws NotNullArgumentException {
        if(this.getExpenseCurrencydeleteinstancepthisExpenseCurrencyInstance() == null || this.getExpenseCurrencydeleteinstancepthisExpenseCurrencyInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseCurrencyConstants.SERV_ID_DELETEINSTANCE, ExpenseCurrencyConstants.CLASS_ID, ExpenseCurrencyConstants.ARG_ID_DELETEINSTANCE_EXPENSECURRENCYDELETEINSTANCEPTHISEXPENSECURRENCY, ExpenseCurrencyConstants.SERV_ALIAS_DELETEINSTANCE, ExpenseCurrencyConstants.CLASS_ALIAS, ExpenseCurrencyConstants.ARG_ALIAS_DELETEINSTANCE_EXPENSECURRENCYDELETEINSTANCEPTHISEXPENSECURRENCY);
        }
    }
}
