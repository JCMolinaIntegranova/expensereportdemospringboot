package com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ExpenseLineConstants;
import com.integranova.spring.expensereportdemo.persistence.ExpenseLine;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseLineOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.DeletelineRequest")
public class DeletelineRequest {

    @ApiModelProperty(name = "Expense Line")
    @JsonProperty("p_thisexpenseline_oid")
    private ExpenseLineOid expenseLinedeletelinepthisExpenseLine;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ExpenseLine expenseLinedeletelinepthisExpenseLineInstance;

    @JsonProperty("preconditionId")
    @ApiModelProperty(hidden = true)
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkExpenseLinedeletelinepthisExpenseLine();
    }

    @JsonIgnore
    public ExpenseLineOid getExpenseLinedeletelinepthisExpenseLine() {
        return this.expenseLinedeletelinepthisExpenseLine;
    }
    
    public void setExpenseLinedeletelinepthisExpenseLine(ExpenseLineOid expenseLinedeletelinepthisExpenseLine) {
        this.expenseLinedeletelinepthisExpenseLine = expenseLinedeletelinepthisExpenseLine;
    }

    @JsonIgnore
    public ExpenseLine getExpenseLinedeletelinepthisExpenseLineInstance() {
        return this.expenseLinedeletelinepthisExpenseLineInstance;
    }
    
    public void setExpenseLinedeletelinepthisExpenseLineInstance(ExpenseLine expenseLinedeletelinepthisExpenseLine) {
        this.expenseLinedeletelinepthisExpenseLineInstance = expenseLinedeletelinepthisExpenseLine;
    }

    private void checkExpenseLinedeletelinepthisExpenseLine() throws NotNullArgumentException {
        if(this.getExpenseLinedeletelinepthisExpenseLineInstance() == null || this.getExpenseLinedeletelinepthisExpenseLineInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseLineConstants.SERV_ID_DELETELINE, ExpenseLineConstants.CLASS_ID, ExpenseLineConstants.ARG_ID_DELETELINE_EXPENSELINEDELETELINEPTHISEXPENSELINE, ExpenseLineConstants.SERV_ALIAS_DELETELINE, ExpenseLineConstants.CLASS_ALIAS, ExpenseLineConstants.ARG_ALIAS_DELETELINE_EXPENSELINEDELETELINEPTHISEXPENSELINE);
        }
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
