package com.integranova.spring.expensereportdemo.viewmodel.expensetype.ds;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.persistence.ExpenseType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensetype.ds.DSExpenseType")
public class DSExpenseType {

    @ApiModelProperty(name = "Expense Type Code")
    @JsonProperty("typecode")
    private String dSExpenseTypeTypeCode;

    @ApiModelProperty(name = "Unit Price")
    @JsonProperty("price")
    private Double dSExpenseTypePrice;

    @ApiModelProperty(name = "Description")
    @JsonProperty("tydescription")
    private String dSExpenseTypeTyDescription;

    @ApiModelProperty(name = "Fixed Price")
    @JsonProperty("fixedprice")
    private Boolean dSExpenseTypeFixedPrice;

    public DSExpenseType() {
    
    }
    
    public DSExpenseType(ExpenseType instance) {
        if (instance != null) {
            this.dSExpenseTypeTypeCode = instance.getExpenseTypeTypeCode();
            this.dSExpenseTypePrice = instance.getExpenseTypePrice();
            this.dSExpenseTypeTyDescription = instance.getExpenseTypeTyDescription();
            this.dSExpenseTypeFixedPrice = instance.getExpenseTypeFixedPrice();
        }
    }

    public String getDSExpenseTypeTypeCode() {
        return this.dSExpenseTypeTypeCode;
    }
    
    public void setDSExpenseTypeTypeCode(String dSExpenseTypeTypeCode) {
        this.dSExpenseTypeTypeCode = dSExpenseTypeTypeCode;
    }

    public Double getDSExpenseTypePrice() {
        return this.dSExpenseTypePrice;
    }
    
    public void setDSExpenseTypePrice(Double dSExpenseTypePrice) {
        this.dSExpenseTypePrice = dSExpenseTypePrice;
    }

    public String getDSExpenseTypeTyDescription() {
        return this.dSExpenseTypeTyDescription;
    }
    
    public void setDSExpenseTypeTyDescription(String dSExpenseTypeTyDescription) {
        this.dSExpenseTypeTyDescription = dSExpenseTypeTyDescription;
    }

    public Boolean getDSExpenseTypeFixedPrice() {
        return this.dSExpenseTypeFixedPrice;
    }
    
    public void setDSExpenseTypeFixedPrice(Boolean dSExpenseTypeFixedPrice) {
        this.dSExpenseTypeFixedPrice = dSExpenseTypeFixedPrice;
    }
}
