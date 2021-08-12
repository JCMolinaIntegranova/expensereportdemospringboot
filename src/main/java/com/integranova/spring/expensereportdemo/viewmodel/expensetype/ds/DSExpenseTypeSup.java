package com.integranova.spring.expensereportdemo.viewmodel.expensetype.ds;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.persistence.ExpenseType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensetype.ds.DSExpenseTypeSup")
public class DSExpenseTypeSup {

    @ApiModelProperty(name = "Description")
    @JsonProperty("tydescription")
    private String dSExpenseTypeSupTyDescription;

    public DSExpenseTypeSup() {
    
    }
    
    public DSExpenseTypeSup(ExpenseType instance) {
        if (instance != null) {
            this.dSExpenseTypeSupTyDescription = instance.getExpenseTypeTyDescription();
        }
    }

    public String getDSExpenseTypeSupTyDescription() {
        return this.dSExpenseTypeSupTyDescription;
    }
    
    public void setDSExpenseTypeSupTyDescription(String dSExpenseTypeSupTyDescription) {
        this.dSExpenseTypeSupTyDescription = dSExpenseTypeSupTyDescription;
    }
}
