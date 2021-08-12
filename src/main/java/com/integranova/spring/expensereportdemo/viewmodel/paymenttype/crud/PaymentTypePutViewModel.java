package com.integranova.spring.expensereportdemo.viewmodel.paymenttype.crud;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentTypePutViewModel {

    @JsonProperty(value="PayDescription")
    private String paymentTypePayDescription;

    public String getPaymentTypePayDescription() {
        return paymentTypePayDescription;
    }
    
    public void setPaymentTypePayDescription(String paymentTypePayDescription) {
        this.paymentTypePayDescription = paymentTypePayDescription;
    }
}
