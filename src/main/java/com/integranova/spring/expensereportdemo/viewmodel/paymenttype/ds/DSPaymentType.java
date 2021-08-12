package com.integranova.spring.expensereportdemo.viewmodel.paymenttype.ds;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.persistence.PaymentType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.paymenttype.ds.DSPaymentType")
public class DSPaymentType {

    @ApiModelProperty(name = "Payment Type")
    @JsonProperty("idpaymenttype")
    private String dSPaymentTypeIdPaymentType;

    @ApiModelProperty(name = "Description")
    @JsonProperty("paydescription")
    private String dSPaymentTypePayDescription;

    public DSPaymentType() {
    
    }
    
    public DSPaymentType(PaymentType instance) {
        if (instance != null) {
            this.dSPaymentTypeIdPaymentType = instance.getPaymentTypeidPaymentType();
            this.dSPaymentTypePayDescription = instance.getPaymentTypePayDescription();
        }
    }

    public String getDSPaymentTypeIdPaymentType() {
        return this.dSPaymentTypeIdPaymentType;
    }
    
    public void setDSPaymentTypeIdPaymentType(String dSPaymentTypeIdPaymentType) {
        this.dSPaymentTypeIdPaymentType = dSPaymentTypeIdPaymentType;
    }

    public String getDSPaymentTypePayDescription() {
        return this.dSPaymentTypePayDescription;
    }
    
    public void setDSPaymentTypePayDescription(String dSPaymentTypePayDescription) {
        this.dSPaymentTypePayDescription = dSPaymentTypePayDescription;
    }
}
