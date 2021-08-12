package com.integranova.spring.expensereportdemo.viewmodel.expensetype.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ExpenseTypeConstants;
import com.integranova.spring.expensereportdemo.persistence.ExpenseType;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseTypeOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensetype.siu.DeleteinstanceRequest")
public class DeleteinstanceRequest {

    @ApiModelProperty(name = "Expense Type")
    @JsonProperty("p_thisexpensetype_oid")
    private ExpenseTypeOid expenseTypedeleteinstancepthisExpenseType;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ExpenseType expenseTypedeleteinstancepthisExpenseTypeInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkExpenseTypedeleteinstancepthisExpenseType();
    }

    @JsonIgnore
    public ExpenseTypeOid getExpenseTypedeleteinstancepthisExpenseType() {
        return this.expenseTypedeleteinstancepthisExpenseType;
    }
    
    public void setExpenseTypedeleteinstancepthisExpenseType(ExpenseTypeOid expenseTypedeleteinstancepthisExpenseType) {
        this.expenseTypedeleteinstancepthisExpenseType = expenseTypedeleteinstancepthisExpenseType;
    }

    @JsonIgnore
    public ExpenseType getExpenseTypedeleteinstancepthisExpenseTypeInstance() {
        return this.expenseTypedeleteinstancepthisExpenseTypeInstance;
    }
    
    public void setExpenseTypedeleteinstancepthisExpenseTypeInstance(ExpenseType expenseTypedeleteinstancepthisExpenseType) {
        this.expenseTypedeleteinstancepthisExpenseTypeInstance = expenseTypedeleteinstancepthisExpenseType;
    }

    private void checkExpenseTypedeleteinstancepthisExpenseType() throws NotNullArgumentException {
        if(this.getExpenseTypedeleteinstancepthisExpenseTypeInstance() == null || this.getExpenseTypedeleteinstancepthisExpenseTypeInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseTypeConstants.SERV_ID_DELETEINSTANCE, ExpenseTypeConstants.CLASS_ID, ExpenseTypeConstants.ARG_ID_DELETEINSTANCE_EXPENSETYPEDELETEINSTANCEPTHISEXPENSETYPE, ExpenseTypeConstants.SERV_ALIAS_DELETEINSTANCE, ExpenseTypeConstants.CLASS_ALIAS, ExpenseTypeConstants.ARG_ALIAS_DELETEINSTANCE_EXPENSETYPEDELETEINSTANCEPTHISEXPENSETYPE);
        }
    }
}
