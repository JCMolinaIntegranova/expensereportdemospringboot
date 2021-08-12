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

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu.InsPaymentTypeRequest")
public class InsPaymentTypeRequest {

    @ApiModelProperty(name = "Payment Type")
    @JsonProperty("p_thispaymenttype_oid")
    private PaymentTypeOid paymentTypeInsPaymentTypepthisPaymentType;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private PaymentType paymentTypeInsPaymentTypepthisPaymentTypeInstance;

    @ApiModelProperty(name = "Expense Report")
    @JsonProperty("p_evcexpensereport_oid")
    private ExpenseReportOid paymentTypeInsPaymentTypepevcExpenseReport;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ExpenseReport paymentTypeInsPaymentTypepevcExpenseReportInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPaymentTypeInsPaymentTypepthisPaymentType();
        checkPaymentTypeInsPaymentTypepevcExpenseReport();
    }

    @JsonIgnore
    public PaymentTypeOid getPaymentTypeInsPaymentTypepthisPaymentType() {
        return this.paymentTypeInsPaymentTypepthisPaymentType;
    }
    
    public void setPaymentTypeInsPaymentTypepthisPaymentType(PaymentTypeOid paymentTypeInsPaymentTypepthisPaymentType) {
        this.paymentTypeInsPaymentTypepthisPaymentType = paymentTypeInsPaymentTypepthisPaymentType;
    }

    @JsonIgnore
    public PaymentType getPaymentTypeInsPaymentTypepthisPaymentTypeInstance() {
        return this.paymentTypeInsPaymentTypepthisPaymentTypeInstance;
    }
    
    public void setPaymentTypeInsPaymentTypepthisPaymentTypeInstance(PaymentType paymentTypeInsPaymentTypepthisPaymentType) {
        this.paymentTypeInsPaymentTypepthisPaymentTypeInstance = paymentTypeInsPaymentTypepthisPaymentType;
    }

    private void checkPaymentTypeInsPaymentTypepthisPaymentType() throws NotNullArgumentException {
        if(this.getPaymentTypeInsPaymentTypepthisPaymentTypeInstance() == null || this.getPaymentTypeInsPaymentTypepthisPaymentTypeInstance().isNull()) {
            throw new NotNullArgumentException(PaymentTypeConstants.SERV_ID_INSPAYMENTTYPE, PaymentTypeConstants.CLASS_ID, PaymentTypeConstants.ARG_ID_INSPAYMENTTYPE_PAYMENTTYPEINSPAYMENTTYPEPTHISPAYMENTTYPE, PaymentTypeConstants.SERV_ALIAS_INSPAYMENTTYPE, PaymentTypeConstants.CLASS_ALIAS, PaymentTypeConstants.ARG_ALIAS_INSPAYMENTTYPE_PAYMENTTYPEINSPAYMENTTYPEPTHISPAYMENTTYPE);
        }
    }

    @JsonIgnore
    public ExpenseReportOid getPaymentTypeInsPaymentTypepevcExpenseReport() {
        return this.paymentTypeInsPaymentTypepevcExpenseReport;
    }
    
    public void setPaymentTypeInsPaymentTypepevcExpenseReport(ExpenseReportOid paymentTypeInsPaymentTypepevcExpenseReport) {
        this.paymentTypeInsPaymentTypepevcExpenseReport = paymentTypeInsPaymentTypepevcExpenseReport;
    }

    @JsonIgnore
    public ExpenseReport getPaymentTypeInsPaymentTypepevcExpenseReportInstance() {
        return this.paymentTypeInsPaymentTypepevcExpenseReportInstance;
    }
    
    public void setPaymentTypeInsPaymentTypepevcExpenseReportInstance(ExpenseReport paymentTypeInsPaymentTypepevcExpenseReport) {
        this.paymentTypeInsPaymentTypepevcExpenseReportInstance = paymentTypeInsPaymentTypepevcExpenseReport;
    }

    private void checkPaymentTypeInsPaymentTypepevcExpenseReport() throws NotNullArgumentException {
        if(this.getPaymentTypeInsPaymentTypepevcExpenseReportInstance() == null || this.getPaymentTypeInsPaymentTypepevcExpenseReportInstance().isNull()) {
            throw new NotNullArgumentException(PaymentTypeConstants.SERV_ID_INSPAYMENTTYPE, PaymentTypeConstants.CLASS_ID, PaymentTypeConstants.ARG_ID_INSPAYMENTTYPE_PAYMENTTYPEINSPAYMENTTYPEPEVCEXPENSEREPORT, PaymentTypeConstants.SERV_ALIAS_INSPAYMENTTYPE, PaymentTypeConstants.CLASS_ALIAS, PaymentTypeConstants.ARG_ALIAS_INSPAYMENTTYPE_PAYMENTTYPEINSPAYMENTTYPEPEVCEXPENSEREPORT);
        }
    }
}
