package com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.PaymentTypeConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.PaymentTypeOid;
import com.integranova.spring.expensereportdemo.persistence.PaymentType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu.EditinstanceRequest")
public class EditinstanceRequest {

    @ApiModelProperty(name = "Payment Type")
    @JsonProperty("p_thispaymenttype_oid")
    private PaymentTypeOid paymentTypeeditinstancepthisPaymentType;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private PaymentType paymentTypeeditinstancepthisPaymentTypeInstance;

    @ApiModelProperty(name = "Description")
    @JsonProperty("p_paydescription")
    private String paymentTypeeditinstancepPayDescription;

    public void checkArguments() throws NotNullArgumentException {
        checkPaymentTypeeditinstancepthisPaymentType();
        checkPaymentTypeeditinstancepPayDescription();
    }

    @JsonIgnore
    public PaymentTypeOid getPaymentTypeeditinstancepthisPaymentType() {
        return this.paymentTypeeditinstancepthisPaymentType;
    }
    
    public void setPaymentTypeeditinstancepthisPaymentType(PaymentTypeOid paymentTypeeditinstancepthisPaymentType) {
        this.paymentTypeeditinstancepthisPaymentType = paymentTypeeditinstancepthisPaymentType;
    }

    @JsonIgnore
    public PaymentType getPaymentTypeeditinstancepthisPaymentTypeInstance() {
        return this.paymentTypeeditinstancepthisPaymentTypeInstance;
    }
    
    public void setPaymentTypeeditinstancepthisPaymentTypeInstance(PaymentType paymentTypeeditinstancepthisPaymentType) {
        this.paymentTypeeditinstancepthisPaymentTypeInstance = paymentTypeeditinstancepthisPaymentType;
    }

    private void checkPaymentTypeeditinstancepthisPaymentType() throws NotNullArgumentException {
        if(this.getPaymentTypeeditinstancepthisPaymentTypeInstance() == null || this.getPaymentTypeeditinstancepthisPaymentTypeInstance().isNull()) {
            throw new NotNullArgumentException(PaymentTypeConstants.SERV_ID_EDITINSTANCE, PaymentTypeConstants.CLASS_ID, PaymentTypeConstants.ARG_ID_EDITINSTANCE_PAYMENTTYPEEDITINSTANCEPTHISPAYMENTTYPE, PaymentTypeConstants.SERV_ALIAS_EDITINSTANCE, PaymentTypeConstants.CLASS_ALIAS, PaymentTypeConstants.ARG_ALIAS_EDITINSTANCE_PAYMENTTYPEEDITINSTANCEPTHISPAYMENTTYPE);
        }
    }

    @JsonIgnore
    public String getPaymentTypeeditinstancepPayDescription() {
        return this.paymentTypeeditinstancepPayDescription;
    }
    
    public void setPaymentTypeeditinstancepPayDescription(String paymentTypeeditinstancepPayDescription) {
        this.paymentTypeeditinstancepPayDescription = paymentTypeeditinstancepPayDescription;
    }

    private void checkPaymentTypeeditinstancepPayDescription() throws NotNullArgumentException {
        if(this.getPaymentTypeeditinstancepPayDescription() == null) {
            throw new NotNullArgumentException(PaymentTypeConstants.SERV_ID_EDITINSTANCE, PaymentTypeConstants.CLASS_ID, PaymentTypeConstants.ARG_ID_EDITINSTANCE_PAYMENTTYPEEDITINSTANCEPPAYDESCRIPTION, PaymentTypeConstants.SERV_ALIAS_EDITINSTANCE, PaymentTypeConstants.CLASS_ALIAS, PaymentTypeConstants.ARG_ALIAS_EDITINSTANCE_PAYMENTTYPEEDITINSTANCEPPAYDESCRIPTION);
        }
    }
}
