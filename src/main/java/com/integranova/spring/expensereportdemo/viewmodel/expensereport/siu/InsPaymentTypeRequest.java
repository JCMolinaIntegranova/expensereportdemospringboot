package com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ExpenseReportConstants;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseReportOid;
import com.integranova.spring.expensereportdemo.persistence.oid.PaymentTypeOid;
import com.integranova.spring.expensereportdemo.persistence.PaymentType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.InsPaymentTypeRequest")
public class InsPaymentTypeRequest {

    @ApiModelProperty(name = "Expense Report")
    @JsonProperty("p_thisexpensereport_oid")
    private ExpenseReportOid expenseReportInsPaymentTypepthisExpenseReport;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ExpenseReport expenseReportInsPaymentTypepthisExpenseReportInstance;

    @ApiModelProperty(name = "Payment Type")
    @JsonProperty("p_evcpaymenttype_oid")
    private PaymentTypeOid expenseReportInsPaymentTypepevcPaymentType;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private PaymentType expenseReportInsPaymentTypepevcPaymentTypeInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkExpenseReportInsPaymentTypepthisExpenseReport();
        checkExpenseReportInsPaymentTypepevcPaymentType();
    }

    @JsonIgnore
    public ExpenseReportOid getExpenseReportInsPaymentTypepthisExpenseReport() {
        return this.expenseReportInsPaymentTypepthisExpenseReport;
    }
    
    public void setExpenseReportInsPaymentTypepthisExpenseReport(ExpenseReportOid expenseReportInsPaymentTypepthisExpenseReport) {
        this.expenseReportInsPaymentTypepthisExpenseReport = expenseReportInsPaymentTypepthisExpenseReport;
    }

    @JsonIgnore
    public ExpenseReport getExpenseReportInsPaymentTypepthisExpenseReportInstance() {
        return this.expenseReportInsPaymentTypepthisExpenseReportInstance;
    }
    
    public void setExpenseReportInsPaymentTypepthisExpenseReportInstance(ExpenseReport expenseReportInsPaymentTypepthisExpenseReport) {
        this.expenseReportInsPaymentTypepthisExpenseReportInstance = expenseReportInsPaymentTypepthisExpenseReport;
    }

    private void checkExpenseReportInsPaymentTypepthisExpenseReport() throws NotNullArgumentException {
        if(this.getExpenseReportInsPaymentTypepthisExpenseReportInstance() == null || this.getExpenseReportInsPaymentTypepthisExpenseReportInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_INSPAYMENTTYPE, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_INSPAYMENTTYPE_EXPENSEREPORTINSPAYMENTTYPEPTHISEXPENSEREPORT, ExpenseReportConstants.SERV_ALIAS_INSPAYMENTTYPE, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_INSPAYMENTTYPE_EXPENSEREPORTINSPAYMENTTYPEPTHISEXPENSEREPORT);
        }
    }

    @JsonIgnore
    public PaymentTypeOid getExpenseReportInsPaymentTypepevcPaymentType() {
        return this.expenseReportInsPaymentTypepevcPaymentType;
    }
    
    public void setExpenseReportInsPaymentTypepevcPaymentType(PaymentTypeOid expenseReportInsPaymentTypepevcPaymentType) {
        this.expenseReportInsPaymentTypepevcPaymentType = expenseReportInsPaymentTypepevcPaymentType;
    }

    @JsonIgnore
    public PaymentType getExpenseReportInsPaymentTypepevcPaymentTypeInstance() {
        return this.expenseReportInsPaymentTypepevcPaymentTypeInstance;
    }
    
    public void setExpenseReportInsPaymentTypepevcPaymentTypeInstance(PaymentType expenseReportInsPaymentTypepevcPaymentType) {
        this.expenseReportInsPaymentTypepevcPaymentTypeInstance = expenseReportInsPaymentTypepevcPaymentType;
    }

    private void checkExpenseReportInsPaymentTypepevcPaymentType() throws NotNullArgumentException {
        if(this.getExpenseReportInsPaymentTypepevcPaymentTypeInstance() == null || this.getExpenseReportInsPaymentTypepevcPaymentTypeInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_INSPAYMENTTYPE, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_INSPAYMENTTYPE_EXPENSEREPORTINSPAYMENTTYPEPEVCPAYMENTTYPE, ExpenseReportConstants.SERV_ALIAS_INSPAYMENTTYPE, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_INSPAYMENTTYPE_EXPENSEREPORTINSPAYMENTTYPEPEVCPAYMENTTYPE);
        }
    }
}
