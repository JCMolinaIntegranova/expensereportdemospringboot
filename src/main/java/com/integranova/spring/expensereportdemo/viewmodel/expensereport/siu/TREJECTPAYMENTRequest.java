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

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TREJECTPAYMENTRequest")
public class TREJECTPAYMENTRequest {

    @ApiModelProperty(name = "Expense Report")
    @JsonProperty("pt_thisexpensereport_oid")
    private ExpenseReportOid expenseReportTREJECTPAYMENTptthisExpenseReport;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ExpenseReport expenseReportTREJECTPAYMENTptthisExpenseReportInstance;

    @ApiModelProperty(name = "Payment Type")
    @JsonProperty("pt_paymenttype_oid")
    private PaymentTypeOid expenseReportTREJECTPAYMENTptPaymentType;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private PaymentType expenseReportTREJECTPAYMENTptPaymentTypeInstance;

    @ApiModelProperty(name = "Comments")
    @JsonProperty("pt_comments")
    private String expenseReportTREJECTPAYMENTptComments;

    public void checkArguments() throws NotNullArgumentException {
        checkExpenseReportTREJECTPAYMENTptthisExpenseReport();
        checkExpenseReportTREJECTPAYMENTptPaymentType();
        checkExpenseReportTREJECTPAYMENTptComments();
    }

    @JsonIgnore
    public ExpenseReportOid getExpenseReportTREJECTPAYMENTptthisExpenseReport() {
        return this.expenseReportTREJECTPAYMENTptthisExpenseReport;
    }
    
    public void setExpenseReportTREJECTPAYMENTptthisExpenseReport(ExpenseReportOid expenseReportTREJECTPAYMENTptthisExpenseReport) {
        this.expenseReportTREJECTPAYMENTptthisExpenseReport = expenseReportTREJECTPAYMENTptthisExpenseReport;
    }

    @JsonIgnore
    public ExpenseReport getExpenseReportTREJECTPAYMENTptthisExpenseReportInstance() {
        return this.expenseReportTREJECTPAYMENTptthisExpenseReportInstance;
    }
    
    public void setExpenseReportTREJECTPAYMENTptthisExpenseReportInstance(ExpenseReport expenseReportTREJECTPAYMENTptthisExpenseReport) {
        this.expenseReportTREJECTPAYMENTptthisExpenseReportInstance = expenseReportTREJECTPAYMENTptthisExpenseReport;
    }

    private void checkExpenseReportTREJECTPAYMENTptthisExpenseReport() throws NotNullArgumentException {
        if(this.getExpenseReportTREJECTPAYMENTptthisExpenseReportInstance() == null || this.getExpenseReportTREJECTPAYMENTptthisExpenseReportInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_TREJECTPAYMENT, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_TREJECTPAYMENT_EXPENSEREPORTTREJECTPAYMENTPTTHISEXPENSEREPORT, ExpenseReportConstants.SERV_ALIAS_TREJECTPAYMENT, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_TREJECTPAYMENT_EXPENSEREPORTTREJECTPAYMENTPTTHISEXPENSEREPORT);
        }
    }

    @JsonIgnore
    public PaymentTypeOid getExpenseReportTREJECTPAYMENTptPaymentType() {
        return this.expenseReportTREJECTPAYMENTptPaymentType;
    }
    
    public void setExpenseReportTREJECTPAYMENTptPaymentType(PaymentTypeOid expenseReportTREJECTPAYMENTptPaymentType) {
        this.expenseReportTREJECTPAYMENTptPaymentType = expenseReportTREJECTPAYMENTptPaymentType;
    }

    @JsonIgnore
    public PaymentType getExpenseReportTREJECTPAYMENTptPaymentTypeInstance() {
        return this.expenseReportTREJECTPAYMENTptPaymentTypeInstance;
    }
    
    public void setExpenseReportTREJECTPAYMENTptPaymentTypeInstance(PaymentType expenseReportTREJECTPAYMENTptPaymentType) {
        this.expenseReportTREJECTPAYMENTptPaymentTypeInstance = expenseReportTREJECTPAYMENTptPaymentType;
    }

    private void checkExpenseReportTREJECTPAYMENTptPaymentType() throws NotNullArgumentException {
        if(this.getExpenseReportTREJECTPAYMENTptPaymentTypeInstance() == null || this.getExpenseReportTREJECTPAYMENTptPaymentTypeInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_TREJECTPAYMENT, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_TREJECTPAYMENT_EXPENSEREPORTTREJECTPAYMENTPTPAYMENTTYPE, ExpenseReportConstants.SERV_ALIAS_TREJECTPAYMENT, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_TREJECTPAYMENT_EXPENSEREPORTTREJECTPAYMENTPTPAYMENTTYPE);
        }
    }

    @JsonIgnore
    public String getExpenseReportTREJECTPAYMENTptComments() {
        return this.expenseReportTREJECTPAYMENTptComments;
    }
    
    public void setExpenseReportTREJECTPAYMENTptComments(String expenseReportTREJECTPAYMENTptComments) {
        this.expenseReportTREJECTPAYMENTptComments = expenseReportTREJECTPAYMENTptComments;
    }

    private void checkExpenseReportTREJECTPAYMENTptComments() throws NotNullArgumentException {
        if(this.getExpenseReportTREJECTPAYMENTptComments() == null) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_TREJECTPAYMENT, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_TREJECTPAYMENT_EXPENSEREPORTTREJECTPAYMENTPTCOMMENTS, ExpenseReportConstants.SERV_ALIAS_TREJECTPAYMENT, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_TREJECTPAYMENT_EXPENSEREPORTTREJECTPAYMENTPTCOMMENTS);
        }
    }
}
