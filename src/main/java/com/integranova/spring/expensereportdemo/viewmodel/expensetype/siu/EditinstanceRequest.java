package com.integranova.spring.expensereportdemo.viewmodel.expensetype.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ExpenseTypeConstants;
import com.integranova.spring.expensereportdemo.persistence.ExpenseType;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseTypeOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensetype.siu.EditinstanceRequest")
public class EditinstanceRequest {

    @ApiModelProperty(name = "Expense Type")
    @JsonProperty("p_thisexpensetype_oid")
    private ExpenseTypeOid expenseTypeeditinstancepthisExpenseType;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ExpenseType expenseTypeeditinstancepthisExpenseTypeInstance;

    @ApiModelProperty(name = "Unit Price")
    @JsonProperty("p_price")
    private Double expenseTypeeditinstancepPrice;

    @ApiModelProperty(name = "Description")
    @JsonProperty("p_tydescription")
    private String expenseTypeeditinstancepTyDescription;

    @ApiModelProperty(name = "Fixed Price")
    @JsonProperty("p_fixedprice")
    private Boolean expenseTypeeditinstancepFixedPrice;

    public void checkArguments() throws NotNullArgumentException {
        checkExpenseTypeeditinstancepthisExpenseType();
        checkExpenseTypeeditinstancepPrice();
        checkExpenseTypeeditinstancepTyDescription();
        checkExpenseTypeeditinstancepFixedPrice();
    }

    @JsonIgnore
    public ExpenseTypeOid getExpenseTypeeditinstancepthisExpenseType() {
        return this.expenseTypeeditinstancepthisExpenseType;
    }
    
    public void setExpenseTypeeditinstancepthisExpenseType(ExpenseTypeOid expenseTypeeditinstancepthisExpenseType) {
        this.expenseTypeeditinstancepthisExpenseType = expenseTypeeditinstancepthisExpenseType;
    }

    @JsonIgnore
    public ExpenseType getExpenseTypeeditinstancepthisExpenseTypeInstance() {
        return this.expenseTypeeditinstancepthisExpenseTypeInstance;
    }
    
    public void setExpenseTypeeditinstancepthisExpenseTypeInstance(ExpenseType expenseTypeeditinstancepthisExpenseType) {
        this.expenseTypeeditinstancepthisExpenseTypeInstance = expenseTypeeditinstancepthisExpenseType;
    }

    private void checkExpenseTypeeditinstancepthisExpenseType() throws NotNullArgumentException {
        if(this.getExpenseTypeeditinstancepthisExpenseTypeInstance() == null || this.getExpenseTypeeditinstancepthisExpenseTypeInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseTypeConstants.SERV_ID_EDITINSTANCE, ExpenseTypeConstants.CLASS_ID, ExpenseTypeConstants.ARG_ID_EDITINSTANCE_EXPENSETYPEEDITINSTANCEPTHISEXPENSETYPE, ExpenseTypeConstants.SERV_ALIAS_EDITINSTANCE, ExpenseTypeConstants.CLASS_ALIAS, ExpenseTypeConstants.ARG_ALIAS_EDITINSTANCE_EXPENSETYPEEDITINSTANCEPTHISEXPENSETYPE);
        }
    }

    @JsonIgnore
    public Double getExpenseTypeeditinstancepPrice() {
        return this.expenseTypeeditinstancepPrice;
    }
    
    public void setExpenseTypeeditinstancepPrice(Double expenseTypeeditinstancepPrice) {
        this.expenseTypeeditinstancepPrice = expenseTypeeditinstancepPrice;
    }

    private void checkExpenseTypeeditinstancepPrice() throws NotNullArgumentException {
        if(this.getExpenseTypeeditinstancepPrice() == null) {
            throw new NotNullArgumentException(ExpenseTypeConstants.SERV_ID_EDITINSTANCE, ExpenseTypeConstants.CLASS_ID, ExpenseTypeConstants.ARG_ID_EDITINSTANCE_EXPENSETYPEEDITINSTANCEPPRICE, ExpenseTypeConstants.SERV_ALIAS_EDITINSTANCE, ExpenseTypeConstants.CLASS_ALIAS, ExpenseTypeConstants.ARG_ALIAS_EDITINSTANCE_EXPENSETYPEEDITINSTANCEPPRICE);
        }
    }

    @JsonIgnore
    public String getExpenseTypeeditinstancepTyDescription() {
        return this.expenseTypeeditinstancepTyDescription;
    }
    
    public void setExpenseTypeeditinstancepTyDescription(String expenseTypeeditinstancepTyDescription) {
        this.expenseTypeeditinstancepTyDescription = expenseTypeeditinstancepTyDescription;
    }

    private void checkExpenseTypeeditinstancepTyDescription() throws NotNullArgumentException {
        if(this.getExpenseTypeeditinstancepTyDescription() == null) {
            throw new NotNullArgumentException(ExpenseTypeConstants.SERV_ID_EDITINSTANCE, ExpenseTypeConstants.CLASS_ID, ExpenseTypeConstants.ARG_ID_EDITINSTANCE_EXPENSETYPEEDITINSTANCEPTYDESCRIPTION, ExpenseTypeConstants.SERV_ALIAS_EDITINSTANCE, ExpenseTypeConstants.CLASS_ALIAS, ExpenseTypeConstants.ARG_ALIAS_EDITINSTANCE_EXPENSETYPEEDITINSTANCEPTYDESCRIPTION);
        }
    }

    @JsonIgnore
    public Boolean getExpenseTypeeditinstancepFixedPrice() {
        return this.expenseTypeeditinstancepFixedPrice;
    }
    
    public void setExpenseTypeeditinstancepFixedPrice(Boolean expenseTypeeditinstancepFixedPrice) {
        this.expenseTypeeditinstancepFixedPrice = expenseTypeeditinstancepFixedPrice;
    }

    private void checkExpenseTypeeditinstancepFixedPrice() throws NotNullArgumentException {
        if(this.getExpenseTypeeditinstancepFixedPrice() == null) {
            throw new NotNullArgumentException(ExpenseTypeConstants.SERV_ID_EDITINSTANCE, ExpenseTypeConstants.CLASS_ID, ExpenseTypeConstants.ARG_ID_EDITINSTANCE_EXPENSETYPEEDITINSTANCEPFIXEDPRICE, ExpenseTypeConstants.SERV_ALIAS_EDITINSTANCE, ExpenseTypeConstants.CLASS_ALIAS, ExpenseTypeConstants.ARG_ALIAS_EDITINSTANCE_EXPENSETYPEEDITINSTANCEPFIXEDPRICE);
        }
    }
}
