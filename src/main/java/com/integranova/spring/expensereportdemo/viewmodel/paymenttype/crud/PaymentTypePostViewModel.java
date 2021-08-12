package com.integranova.spring.expensereportdemo.viewmodel.paymenttype.crud;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentTypePostViewModel {

    @JsonProperty(value="id_PaymentType")
    private String paymentTypeidPaymentType;

    @JsonProperty(value="PayDescription")
    private String paymentTypePayDescription;

    public String getPaymentTypeidPaymentType() {
        return paymentTypeidPaymentType;
    }
    
    public void setPaymentTypeidPaymentType(String paymentTypeidPaymentType) {
        this.paymentTypeidPaymentType = paymentTypeidPaymentType;
    }

    public String getPaymentTypePayDescription() {
        return paymentTypePayDescription;
    }
    
    public void setPaymentTypePayDescription(String paymentTypePayDescription) {
        this.paymentTypePayDescription = paymentTypePayDescription;
    }
}
