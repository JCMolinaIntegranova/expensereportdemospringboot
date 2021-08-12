package com.integranova.spring.expensereportdemo.viewmodel.expensetype.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ExpenseTypeConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensetype.siu.CreateinstanceRequest")
public class CreateinstanceRequest {

    @ApiModelProperty(name = "Expense Type Code")
    @JsonProperty("p_atrtypecode")
    private String expenseTypecreateinstancepatrTypeCode;

    @ApiModelProperty(name = "Description")
    @JsonProperty("p_atrtydescription")
    private String expenseTypecreateinstancepatrTyDescription;

    @ApiModelProperty(name = "Unit Price")
    @JsonProperty("p_atrprice")
    private Double expenseTypecreateinstancepatrPrice;

    @ApiModelProperty(name = "Fixed Price")
    @JsonProperty("p_atrfixedprice")
    private Boolean expenseTypecreateinstancepatrFixedPrice;

    public void checkArguments() throws NotNullArgumentException {
        checkExpenseTypecreateinstancepatrTypeCode();
        checkExpenseTypecreateinstancepatrTyDescription();
        checkExpenseTypecreateinstancepatrPrice();
        checkExpenseTypecreateinstancepatrFixedPrice();
    }

    @JsonIgnore
    public String getExpenseTypecreateinstancepatrTypeCode() {
        return this.expenseTypecreateinstancepatrTypeCode;
    }
    
    public void setExpenseTypecreateinstancepatrTypeCode(String expenseTypecreateinstancepatrTypeCode) {
        this.expenseTypecreateinstancepatrTypeCode = expenseTypecreateinstancepatrTypeCode;
    }

    private void checkExpenseTypecreateinstancepatrTypeCode() throws NotNullArgumentException {
        if(this.getExpenseTypecreateinstancepatrTypeCode() == null) {
            throw new NotNullArgumentException(ExpenseTypeConstants.SERV_ID_CREATEINSTANCE, ExpenseTypeConstants.CLASS_ID, ExpenseTypeConstants.ARG_ID_CREATEINSTANCE_EXPENSETYPECREATEINSTANCEPATRTYPECODE, ExpenseTypeConstants.SERV_ALIAS_CREATEINSTANCE, ExpenseTypeConstants.CLASS_ALIAS, ExpenseTypeConstants.ARG_ALIAS_CREATEINSTANCE_EXPENSETYPECREATEINSTANCEPATRTYPECODE);
        }
    }

    @JsonIgnore
    public String getExpenseTypecreateinstancepatrTyDescription() {
        return this.expenseTypecreateinstancepatrTyDescription;
    }
    
    public void setExpenseTypecreateinstancepatrTyDescription(String expenseTypecreateinstancepatrTyDescription) {
        this.expenseTypecreateinstancepatrTyDescription = expenseTypecreateinstancepatrTyDescription;
    }

    private void checkExpenseTypecreateinstancepatrTyDescription() throws NotNullArgumentException {
        if(this.getExpenseTypecreateinstancepatrTyDescription() == null) {
            throw new NotNullArgumentException(ExpenseTypeConstants.SERV_ID_CREATEINSTANCE, ExpenseTypeConstants.CLASS_ID, ExpenseTypeConstants.ARG_ID_CREATEINSTANCE_EXPENSETYPECREATEINSTANCEPATRTYDESCRIPTION, ExpenseTypeConstants.SERV_ALIAS_CREATEINSTANCE, ExpenseTypeConstants.CLASS_ALIAS, ExpenseTypeConstants.ARG_ALIAS_CREATEINSTANCE_EXPENSETYPECREATEINSTANCEPATRTYDESCRIPTION);
        }
    }

    @JsonIgnore
    public Double getExpenseTypecreateinstancepatrPrice() {
        return this.expenseTypecreateinstancepatrPrice;
    }
    
    public void setExpenseTypecreateinstancepatrPrice(Double expenseTypecreateinstancepatrPrice) {
        this.expenseTypecreateinstancepatrPrice = expenseTypecreateinstancepatrPrice;
    }

    private void checkExpenseTypecreateinstancepatrPrice() throws NotNullArgumentException {
        if(this.getExpenseTypecreateinstancepatrPrice() == null) {
            throw new NotNullArgumentException(ExpenseTypeConstants.SERV_ID_CREATEINSTANCE, ExpenseTypeConstants.CLASS_ID, ExpenseTypeConstants.ARG_ID_CREATEINSTANCE_EXPENSETYPECREATEINSTANCEPATRPRICE, ExpenseTypeConstants.SERV_ALIAS_CREATEINSTANCE, ExpenseTypeConstants.CLASS_ALIAS, ExpenseTypeConstants.ARG_ALIAS_CREATEINSTANCE_EXPENSETYPECREATEINSTANCEPATRPRICE);
        }
    }

    @JsonIgnore
    public Boolean getExpenseTypecreateinstancepatrFixedPrice() {
        return this.expenseTypecreateinstancepatrFixedPrice;
    }
    
    public void setExpenseTypecreateinstancepatrFixedPrice(Boolean expenseTypecreateinstancepatrFixedPrice) {
        this.expenseTypecreateinstancepatrFixedPrice = expenseTypecreateinstancepatrFixedPrice;
    }

    private void checkExpenseTypecreateinstancepatrFixedPrice() throws NotNullArgumentException {
        if(this.getExpenseTypecreateinstancepatrFixedPrice() == null) {
            throw new NotNullArgumentException(ExpenseTypeConstants.SERV_ID_CREATEINSTANCE, ExpenseTypeConstants.CLASS_ID, ExpenseTypeConstants.ARG_ID_CREATEINSTANCE_EXPENSETYPECREATEINSTANCEPATRFIXEDPRICE, ExpenseTypeConstants.SERV_ALIAS_CREATEINSTANCE, ExpenseTypeConstants.CLASS_ALIAS, ExpenseTypeConstants.ARG_ALIAS_CREATEINSTANCE_EXPENSETYPECREATEINSTANCEPATRFIXEDPRICE);
        }
    }
}
