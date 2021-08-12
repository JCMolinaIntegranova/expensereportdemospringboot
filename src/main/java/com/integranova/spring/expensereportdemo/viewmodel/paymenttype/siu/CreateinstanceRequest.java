package com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.PaymentTypeConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu.CreateinstanceRequest")
public class CreateinstanceRequest {

    @ApiModelProperty(name = "Payment Type")
    @JsonProperty("p_atrid_paymenttype")
    private String paymentTypecreateinstancepatridPaymentType;

    @ApiModelProperty(name = "Description")
    @JsonProperty("p_atrpaydescription")
    private String paymentTypecreateinstancepatrPayDescription;

    public void checkArguments() throws NotNullArgumentException {
        checkPaymentTypecreateinstancepatridPaymentType();
        checkPaymentTypecreateinstancepatrPayDescription();
    }

    @JsonIgnore
    public String getPaymentTypecreateinstancepatridPaymentType() {
        return this.paymentTypecreateinstancepatridPaymentType;
    }
    
    public void setPaymentTypecreateinstancepatridPaymentType(String paymentTypecreateinstancepatridPaymentType) {
        this.paymentTypecreateinstancepatridPaymentType = paymentTypecreateinstancepatridPaymentType;
    }

    private void checkPaymentTypecreateinstancepatridPaymentType() throws NotNullArgumentException {
        if(this.getPaymentTypecreateinstancepatridPaymentType() == null) {
            throw new NotNullArgumentException(PaymentTypeConstants.SERV_ID_CREATEINSTANCE, PaymentTypeConstants.CLASS_ID, PaymentTypeConstants.ARG_ID_CREATEINSTANCE_PAYMENTTYPECREATEINSTANCEPATRIDPAYMENTTYPE, PaymentTypeConstants.SERV_ALIAS_CREATEINSTANCE, PaymentTypeConstants.CLASS_ALIAS, PaymentTypeConstants.ARG_ALIAS_CREATEINSTANCE_PAYMENTTYPECREATEINSTANCEPATRIDPAYMENTTYPE);
        }
    }

    @JsonIgnore
    public String getPaymentTypecreateinstancepatrPayDescription() {
        return this.paymentTypecreateinstancepatrPayDescription;
    }
    
    public void setPaymentTypecreateinstancepatrPayDescription(String paymentTypecreateinstancepatrPayDescription) {
        this.paymentTypecreateinstancepatrPayDescription = paymentTypecreateinstancepatrPayDescription;
    }

    private void checkPaymentTypecreateinstancepatrPayDescription() throws NotNullArgumentException {
        if(this.getPaymentTypecreateinstancepatrPayDescription() == null) {
            throw new NotNullArgumentException(PaymentTypeConstants.SERV_ID_CREATEINSTANCE, PaymentTypeConstants.CLASS_ID, PaymentTypeConstants.ARG_ID_CREATEINSTANCE_PAYMENTTYPECREATEINSTANCEPATRPAYDESCRIPTION, PaymentTypeConstants.SERV_ALIAS_CREATEINSTANCE, PaymentTypeConstants.CLASS_ALIAS, PaymentTypeConstants.ARG_ALIAS_CREATEINSTANCE_PAYMENTTYPECREATEINSTANCEPATRPAYDESCRIPTION);
        }
    }
}
