package com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ExpenseLineConstants;
import com.integranova.spring.expensereportdemo.persistence.ExpenseLine;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseLineOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.DeletepaidlineRequest")
public class DeletepaidlineRequest {

    @ApiModelProperty(name = "Expense Line")
    @JsonProperty("p_thisexpenseline_oid")
    private ExpenseLineOid expenseLinedeletepaidlinepthisExpenseLine;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ExpenseLine expenseLinedeletepaidlinepthisExpenseLineInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkExpenseLinedeletepaidlinepthisExpenseLine();
    }

    @JsonIgnore
    public ExpenseLineOid getExpenseLinedeletepaidlinepthisExpenseLine() {
        return this.expenseLinedeletepaidlinepthisExpenseLine;
    }
    
    public void setExpenseLinedeletepaidlinepthisExpenseLine(ExpenseLineOid expenseLinedeletepaidlinepthisExpenseLine) {
        this.expenseLinedeletepaidlinepthisExpenseLine = expenseLinedeletepaidlinepthisExpenseLine;
    }

    @JsonIgnore
    public ExpenseLine getExpenseLinedeletepaidlinepthisExpenseLineInstance() {
        return this.expenseLinedeletepaidlinepthisExpenseLineInstance;
    }
    
    public void setExpenseLinedeletepaidlinepthisExpenseLineInstance(ExpenseLine expenseLinedeletepaidlinepthisExpenseLine) {
        this.expenseLinedeletepaidlinepthisExpenseLineInstance = expenseLinedeletepaidlinepthisExpenseLine;
    }

    private void checkExpenseLinedeletepaidlinepthisExpenseLine() throws NotNullArgumentException {
        if(this.getExpenseLinedeletepaidlinepthisExpenseLineInstance() == null || this.getExpenseLinedeletepaidlinepthisExpenseLineInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseLineConstants.SERV_ID_DELETEPAIDLINE, ExpenseLineConstants.CLASS_ID, ExpenseLineConstants.ARG_ID_DELETEPAIDLINE_EXPENSELINEDELETEPAIDLINEPTHISEXPENSELINE, ExpenseLineConstants.SERV_ALIAS_DELETEPAIDLINE, ExpenseLineConstants.CLASS_ALIAS, ExpenseLineConstants.ARG_ALIAS_DELETEPAIDLINE_EXPENSELINEDELETEPAIDLINEPTHISEXPENSELINE);
        }
    }
}
