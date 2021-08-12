package com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.PaymentTypeConstants;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseReportOid;
import com.integranova.spring.expensereportdemo.persistence.oid.PaymentTypeOid;
import com.integranova.spring.expensereportdemo.persistence.PaymentType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu.DelPaymentTypeRequest")
public class DelPaymentTypeRequest {

    @ApiModelProperty(name = "Payment Type")
    @JsonProperty("p_thispaymenttype_oid")
    private PaymentTypeOid paymentTypeDelPaymentTypepthisPaymentType;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private PaymentType paymentTypeDelPaymentTypepthisPaymentTypeInstance;

    @ApiModelProperty(name = "Expense Report")
    @JsonProperty("p_evcexpensereport_oid")
    private ExpenseReportOid paymentTypeDelPaymentTypepevcExpenseReport;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ExpenseReport paymentTypeDelPaymentTypepevcExpenseReportInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPaymentTypeDelPaymentTypepthisPaymentType();
        checkPaymentTypeDelPaymentTypepevcExpenseReport();
    }

    @JsonIgnore
    public PaymentTypeOid getPaymentTypeDelPaymentTypepthisPaymentType() {
        return this.paymentTypeDelPaymentTypepthisPaymentType;
    }
    
    public void setPaymentTypeDelPaymentTypepthisPaymentType(PaymentTypeOid paymentTypeDelPaymentTypepthisPaymentType) {
        this.paymentTypeDelPaymentTypepthisPaymentType = paymentTypeDelPaymentTypepthisPaymentType;
    }

    @JsonIgnore
    public PaymentType getPaymentTypeDelPaymentTypepthisPaymentTypeInstance() {
        return this.paymentTypeDelPaymentTypepthisPaymentTypeInstance;
    }
    
    public void setPaymentTypeDelPaymentTypepthisPaymentTypeInstance(PaymentType paymentTypeDelPaymentTypepthisPaymentType) {
        this.paymentTypeDelPaymentTypepthisPaymentTypeInstance = paymentTypeDelPaymentTypepthisPaymentType;
    }

    private void checkPaymentTypeDelPaymentTypepthisPaymentType() throws NotNullArgumentException {
        if(this.getPaymentTypeDelPaymentTypepthisPaymentTypeInstance() == null || this.getPaymentTypeDelPaymentTypepthisPaymentTypeInstance().isNull()) {
            throw new NotNullArgumentException(PaymentTypeConstants.SERV_ID_DELPAYMENTTYPE, PaymentTypeConstants.CLASS_ID, PaymentTypeConstants.ARG_ID_DELPAYMENTTYPE_PAYMENTTYPEDELPAYMENTTYPEPTHISPAYMENTTYPE, PaymentTypeConstants.SERV_ALIAS_DELPAYMENTTYPE, PaymentTypeConstants.CLASS_ALIAS, PaymentTypeConstants.ARG_ALIAS_DELPAYMENTTYPE_PAYMENTTYPEDELPAYMENTTYPEPTHISPAYMENTTYPE);
        }
    }

    @JsonIgnore
    public ExpenseReportOid getPaymentTypeDelPaymentTypepevcExpenseReport() {
        return this.paymentTypeDelPaymentTypepevcExpenseReport;
    }
    
    public void setPaymentTypeDelPaymentTypepevcExpenseReport(ExpenseReportOid paymentTypeDelPaymentTypepevcExpenseReport) {
        this.paymentTypeDelPaymentTypepevcExpenseReport = paymentTypeDelPaymentTypepevcExpenseReport;
    }

    @JsonIgnore
    public ExpenseReport getPaymentTypeDelPaymentTypepevcExpenseReportInstance() {
        return this.paymentTypeDelPaymentTypepevcExpenseReportInstance;
    }
    
    public void setPaymentTypeDelPaymentTypepevcExpenseReportInstance(ExpenseReport paymentTypeDelPaymentTypepevcExpenseReport) {
        this.paymentTypeDelPaymentTypepevcExpenseReportInstance = paymentTypeDelPaymentTypepevcExpenseReport;
    }

    private void checkPaymentTypeDelPaymentTypepevcExpenseReport() throws NotNullArgumentException {
        if(this.getPaymentTypeDelPaymentTypepevcExpenseReportInstance() == null || this.getPaymentTypeDelPaymentTypepevcExpenseReportInstance().isNull()) {
            throw new NotNullArgumentException(PaymentTypeConstants.SERV_ID_DELPAYMENTTYPE, PaymentTypeConstants.CLASS_ID, PaymentTypeConstants.ARG_ID_DELPAYMENTTYPE_PAYMENTTYPEDELPAYMENTTYPEPEVCEXPENSEREPORT, PaymentTypeConstants.SERV_ALIAS_DELPAYMENTTYPE, PaymentTypeConstants.CLASS_ALIAS, PaymentTypeConstants.ARG_ALIAS_DELPAYMENTTYPE_PAYMENTTYPEDELPAYMENTTYPEPEVCEXPENSEREPORT);
        }
    }
}
