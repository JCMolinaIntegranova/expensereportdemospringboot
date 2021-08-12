package com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.PaymentTypeConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.PaymentTypeOid;
import com.integranova.spring.expensereportdemo.persistence.PaymentType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu.DeleteinstanceRequest")
public class DeleteinstanceRequest {

    @ApiModelProperty(name = "Payment Type")
    @JsonProperty("p_thispaymenttype_oid")
    private PaymentTypeOid paymentTypedeleteinstancepthisPaymentType;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private PaymentType paymentTypedeleteinstancepthisPaymentTypeInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPaymentTypedeleteinstancepthisPaymentType();
    }

    @JsonIgnore
    public PaymentTypeOid getPaymentTypedeleteinstancepthisPaymentType() {
        return this.paymentTypedeleteinstancepthisPaymentType;
    }
    
    public void setPaymentTypedeleteinstancepthisPaymentType(PaymentTypeOid paymentTypedeleteinstancepthisPaymentType) {
        this.paymentTypedeleteinstancepthisPaymentType = paymentTypedeleteinstancepthisPaymentType;
    }

    @JsonIgnore
    public PaymentType getPaymentTypedeleteinstancepthisPaymentTypeInstance() {
        return this.paymentTypedeleteinstancepthisPaymentTypeInstance;
    }
    
    public void setPaymentTypedeleteinstancepthisPaymentTypeInstance(PaymentType paymentTypedeleteinstancepthisPaymentType) {
        this.paymentTypedeleteinstancepthisPaymentTypeInstance = paymentTypedeleteinstancepthisPaymentType;
    }

    private void checkPaymentTypedeleteinstancepthisPaymentType() throws NotNullArgumentException {
        if(this.getPaymentTypedeleteinstancepthisPaymentTypeInstance() == null || this.getPaymentTypedeleteinstancepthisPaymentTypeInstance().isNull()) {
            throw new NotNullArgumentException(PaymentTypeConstants.SERV_ID_DELETEINSTANCE, PaymentTypeConstants.CLASS_ID, PaymentTypeConstants.ARG_ID_DELETEINSTANCE_PAYMENTTYPEDELETEINSTANCEPTHISPAYMENTTYPE, PaymentTypeConstants.SERV_ALIAS_DELETEINSTANCE, PaymentTypeConstants.CLASS_ALIAS, PaymentTypeConstants.ARG_ALIAS_DELETEINSTANCE_PAYMENTTYPEDELETEINSTANCEPTHISPAYMENTTYPE);
        }
    }
}
