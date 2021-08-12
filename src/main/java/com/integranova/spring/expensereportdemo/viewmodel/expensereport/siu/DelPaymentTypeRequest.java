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

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DelPaymentTypeRequest")
public class DelPaymentTypeRequest {

    @ApiModelProperty(name = "Expense Report")
    @JsonProperty("p_thisexpensereport_oid")
    private ExpenseReportOid expenseReportDelPaymentTypepthisExpenseReport;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ExpenseReport expenseReportDelPaymentTypepthisExpenseReportInstance;

    @ApiModelProperty(name = "Payment Type")
    @JsonProperty("p_evcpaymenttype_oid")
    private PaymentTypeOid expenseReportDelPaymentTypepevcPaymentType;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private PaymentType expenseReportDelPaymentTypepevcPaymentTypeInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkExpenseReportDelPaymentTypepthisExpenseReport();
        checkExpenseReportDelPaymentTypepevcPaymentType();
    }

    @JsonIgnore
    public ExpenseReportOid getExpenseReportDelPaymentTypepthisExpenseReport() {
        return this.expenseReportDelPaymentTypepthisExpenseReport;
    }
    
    public void setExpenseReportDelPaymentTypepthisExpenseReport(ExpenseReportOid expenseReportDelPaymentTypepthisExpenseReport) {
        this.expenseReportDelPaymentTypepthisExpenseReport = expenseReportDelPaymentTypepthisExpenseReport;
    }

    @JsonIgnore
    public ExpenseReport getExpenseReportDelPaymentTypepthisExpenseReportInstance() {
        return this.expenseReportDelPaymentTypepthisExpenseReportInstance;
    }
    
    public void setExpenseReportDelPaymentTypepthisExpenseReportInstance(ExpenseReport expenseReportDelPaymentTypepthisExpenseReport) {
        this.expenseReportDelPaymentTypepthisExpenseReportInstance = expenseReportDelPaymentTypepthisExpenseReport;
    }

    private void checkExpenseReportDelPaymentTypepthisExpenseReport() throws NotNullArgumentException {
        if(this.getExpenseReportDelPaymentTypepthisExpenseReportInstance() == null || this.getExpenseReportDelPaymentTypepthisExpenseReportInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_DELPAYMENTTYPE, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_DELPAYMENTTYPE_EXPENSEREPORTDELPAYMENTTYPEPTHISEXPENSEREPORT, ExpenseReportConstants.SERV_ALIAS_DELPAYMENTTYPE, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_DELPAYMENTTYPE_EXPENSEREPORTDELPAYMENTTYPEPTHISEXPENSEREPORT);
        }
    }

    @JsonIgnore
    public PaymentTypeOid getExpenseReportDelPaymentTypepevcPaymentType() {
        return this.expenseReportDelPaymentTypepevcPaymentType;
    }
    
    public void setExpenseReportDelPaymentTypepevcPaymentType(PaymentTypeOid expenseReportDelPaymentTypepevcPaymentType) {
        this.expenseReportDelPaymentTypepevcPaymentType = expenseReportDelPaymentTypepevcPaymentType;
    }

    @JsonIgnore
    public PaymentType getExpenseReportDelPaymentTypepevcPaymentTypeInstance() {
        return this.expenseReportDelPaymentTypepevcPaymentTypeInstance;
    }
    
    public void setExpenseReportDelPaymentTypepevcPaymentTypeInstance(PaymentType expenseReportDelPaymentTypepevcPaymentType) {
        this.expenseReportDelPaymentTypepevcPaymentTypeInstance = expenseReportDelPaymentTypepevcPaymentType;
    }

    private void checkExpenseReportDelPaymentTypepevcPaymentType() throws NotNullArgumentException {
        if(this.getExpenseReportDelPaymentTypepevcPaymentTypeInstance() == null || this.getExpenseReportDelPaymentTypepevcPaymentTypeInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_DELPAYMENTTYPE, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_DELPAYMENTTYPE_EXPENSEREPORTDELPAYMENTTYPEPEVCPAYMENTTYPE, ExpenseReportConstants.SERV_ALIAS_DELPAYMENTTYPE, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_DELPAYMENTTYPE_EXPENSEREPORTDELPAYMENTTYPEPEVCPAYMENTTYPE);
        }
    }
}
