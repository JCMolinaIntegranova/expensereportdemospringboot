package com.integranova.spring.expensereportdemo.viewmodel.paymenttype.ds;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.persistence.PaymentType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.paymenttype.ds.DSPaymentTypeSup")
public class DSPaymentTypeSup {

    @ApiModelProperty(name = "Description")
    @JsonProperty("paydescription")
    private String dSPaymentTypeSupPayDescription;

    public DSPaymentTypeSup() {
    
    }
    
    public DSPaymentTypeSup(PaymentType instance) {
        if (instance != null) {
            this.dSPaymentTypeSupPayDescription = instance.getPaymentTypePayDescription();
        }
    }

    public String getDSPaymentTypeSupPayDescription() {
        return this.dSPaymentTypeSupPayDescription;
    }
    
    public void setDSPaymentTypeSupPayDescription(String dSPaymentTypeSupPayDescription) {
        this.dSPaymentTypeSupPayDescription = dSPaymentTypeSupPayDescription;
    }
}
