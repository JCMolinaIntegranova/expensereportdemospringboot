package com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ExpenseLineConstants;
import com.integranova.spring.expensereportdemo.persistence.ExpenseLine;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseLineOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.sql.Date;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.EditinstanceRequest")
public class EditinstanceRequest {

    @ApiModelProperty(name = "Expense Line")
    @JsonProperty("p_thisexpenseline_oid")
    private ExpenseLineOid expenseLineeditinstancepthisExpenseLine;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ExpenseLine expenseLineeditinstancepthisExpenseLineInstance;

    @ApiModelProperty(name = "Date")
    @JsonProperty("p_expensedate")
    private Date expenseLineeditinstancepExpenseDate;

    @ApiModelProperty(name = "Quantity")
    @JsonProperty("p_units")
    private Double expenseLineeditinstancepUnits;

    @ApiModelProperty(name = "Price")
    @JsonProperty("p_price")
    private Double expenseLineeditinstancepPrice;

    @ApiModelProperty(name = "LnDescription")
    @JsonProperty("p_lndescription")
    private String expenseLineeditinstancepLnDescription;

    @JsonProperty("preconditionId")
    @ApiModelProperty(hidden = true)
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkExpenseLineeditinstancepthisExpenseLine();
        checkExpenseLineeditinstancepExpenseDate();
        checkExpenseLineeditinstancepUnits();
        checkExpenseLineeditinstancepPrice();
        checkExpenseLineeditinstancepLnDescription();
    }

    @JsonIgnore
    public ExpenseLineOid getExpenseLineeditinstancepthisExpenseLine() {
        return this.expenseLineeditinstancepthisExpenseLine;
    }
    
    public void setExpenseLineeditinstancepthisExpenseLine(ExpenseLineOid expenseLineeditinstancepthisExpenseLine) {
        this.expenseLineeditinstancepthisExpenseLine = expenseLineeditinstancepthisExpenseLine;
    }

    @JsonIgnore
    public ExpenseLine getExpenseLineeditinstancepthisExpenseLineInstance() {
        return this.expenseLineeditinstancepthisExpenseLineInstance;
    }
    
    public void setExpenseLineeditinstancepthisExpenseLineInstance(ExpenseLine expenseLineeditinstancepthisExpenseLine) {
        this.expenseLineeditinstancepthisExpenseLineInstance = expenseLineeditinstancepthisExpenseLine;
    }

    private void checkExpenseLineeditinstancepthisExpenseLine() throws NotNullArgumentException {
        if(this.getExpenseLineeditinstancepthisExpenseLineInstance() == null || this.getExpenseLineeditinstancepthisExpenseLineInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseLineConstants.SERV_ID_EDITINSTANCE, ExpenseLineConstants.CLASS_ID, ExpenseLineConstants.ARG_ID_EDITINSTANCE_EXPENSELINEEDITINSTANCEPTHISEXPENSELINE, ExpenseLineConstants.SERV_ALIAS_EDITINSTANCE, ExpenseLineConstants.CLASS_ALIAS, ExpenseLineConstants.ARG_ALIAS_EDITINSTANCE_EXPENSELINEEDITINSTANCEPTHISEXPENSELINE);
        }
    }

    @JsonIgnore
    public Date getExpenseLineeditinstancepExpenseDate() {
        return this.expenseLineeditinstancepExpenseDate;
    }
    
    public void setExpenseLineeditinstancepExpenseDate(Date expenseLineeditinstancepExpenseDate) {
        this.expenseLineeditinstancepExpenseDate = expenseLineeditinstancepExpenseDate;
    }

    private void checkExpenseLineeditinstancepExpenseDate() throws NotNullArgumentException {
        if(this.getExpenseLineeditinstancepExpenseDate() == null) {
            throw new NotNullArgumentException(ExpenseLineConstants.SERV_ID_EDITINSTANCE, ExpenseLineConstants.CLASS_ID, ExpenseLineConstants.ARG_ID_EDITINSTANCE_EXPENSELINEEDITINSTANCEPEXPENSEDATE, ExpenseLineConstants.SERV_ALIAS_EDITINSTANCE, ExpenseLineConstants.CLASS_ALIAS, ExpenseLineConstants.ARG_ALIAS_EDITINSTANCE_EXPENSELINEEDITINSTANCEPEXPENSEDATE);
        }
    }

    @JsonIgnore
    public Double getExpenseLineeditinstancepUnits() {
        return this.expenseLineeditinstancepUnits;
    }
    
    public void setExpenseLineeditinstancepUnits(Double expenseLineeditinstancepUnits) {
        this.expenseLineeditinstancepUnits = expenseLineeditinstancepUnits;
    }

    private void checkExpenseLineeditinstancepUnits() throws NotNullArgumentException {
        if(this.getExpenseLineeditinstancepUnits() == null) {
            throw new NotNullArgumentException(ExpenseLineConstants.SERV_ID_EDITINSTANCE, ExpenseLineConstants.CLASS_ID, ExpenseLineConstants.ARG_ID_EDITINSTANCE_EXPENSELINEEDITINSTANCEPUNITS, ExpenseLineConstants.SERV_ALIAS_EDITINSTANCE, ExpenseLineConstants.CLASS_ALIAS, ExpenseLineConstants.ARG_ALIAS_EDITINSTANCE_EXPENSELINEEDITINSTANCEPUNITS);
        }
    }

    @JsonIgnore
    public Double getExpenseLineeditinstancepPrice() {
        return this.expenseLineeditinstancepPrice;
    }
    
    public void setExpenseLineeditinstancepPrice(Double expenseLineeditinstancepPrice) {
        this.expenseLineeditinstancepPrice = expenseLineeditinstancepPrice;
    }

    private void checkExpenseLineeditinstancepPrice() throws NotNullArgumentException {
        if(this.getExpenseLineeditinstancepPrice() == null) {
            throw new NotNullArgumentException(ExpenseLineConstants.SERV_ID_EDITINSTANCE, ExpenseLineConstants.CLASS_ID, ExpenseLineConstants.ARG_ID_EDITINSTANCE_EXPENSELINEEDITINSTANCEPPRICE, ExpenseLineConstants.SERV_ALIAS_EDITINSTANCE, ExpenseLineConstants.CLASS_ALIAS, ExpenseLineConstants.ARG_ALIAS_EDITINSTANCE_EXPENSELINEEDITINSTANCEPPRICE);
        }
    }

    @JsonIgnore
    public String getExpenseLineeditinstancepLnDescription() {
        return this.expenseLineeditinstancepLnDescription;
    }
    
    public void setExpenseLineeditinstancepLnDescription(String expenseLineeditinstancepLnDescription) {
        this.expenseLineeditinstancepLnDescription = expenseLineeditinstancepLnDescription;
    }

    private void checkExpenseLineeditinstancepLnDescription() throws NotNullArgumentException {
        if(this.getExpenseLineeditinstancepLnDescription() == null) {
            throw new NotNullArgumentException(ExpenseLineConstants.SERV_ID_EDITINSTANCE, ExpenseLineConstants.CLASS_ID, ExpenseLineConstants.ARG_ID_EDITINSTANCE_EXPENSELINEEDITINSTANCEPLNDESCRIPTION, ExpenseLineConstants.SERV_ALIAS_EDITINSTANCE, ExpenseLineConstants.CLASS_ALIAS, ExpenseLineConstants.ARG_ALIAS_EDITINSTANCE_EXPENSELINEEDITINSTANCEPLNDESCRIPTION);
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
