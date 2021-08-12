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
import java.sql.Date;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TPAYRequest")
public class TPAYRequest {

    @ApiModelProperty(name = "Payment Date")
    @JsonProperty("pt_pe_date")
    private Date expenseReportTPAYptpeDate;

    @ApiModelProperty(name = "Payment Type")
    @JsonProperty("ps_paytype_oid")
    private PaymentTypeOid expenseReportTPAYpsPayType;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private PaymentType expenseReportTPAYpsPayTypeInstance;

    @ApiModelProperty(name = "Expense Report")
    @JsonProperty("pt_p_thisexpensereport_oid")
    private ExpenseReportOid expenseReportTPAYptpthisExpenseReport;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ExpenseReport expenseReportTPAYptpthisExpenseReportInstance;

    @ApiModelProperty(name = "Comments")
    @JsonProperty("ps_comments")
    private String expenseReportTPAYpsComments;

    public void checkArguments() throws NotNullArgumentException {
        checkExpenseReportTPAYptpeDate();
        checkExpenseReportTPAYpsPayType();
        checkExpenseReportTPAYptpthisExpenseReport();
        checkExpenseReportTPAYpsComments();
    }

    @JsonIgnore
    public Date getExpenseReportTPAYptpeDate() {
        return this.expenseReportTPAYptpeDate;
    }
    
    public void setExpenseReportTPAYptpeDate(Date expenseReportTPAYptpeDate) {
        this.expenseReportTPAYptpeDate = expenseReportTPAYptpeDate;
    }

    private void checkExpenseReportTPAYptpeDate() throws NotNullArgumentException {
        if(this.getExpenseReportTPAYptpeDate() == null) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_TPAY, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_TPAY_EXPENSEREPORTTPAYPTPEDATE, ExpenseReportConstants.SERV_ALIAS_TPAY, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_TPAY_EXPENSEREPORTTPAYPTPEDATE);
        }
    }

    @JsonIgnore
    public PaymentTypeOid getExpenseReportTPAYpsPayType() {
        return this.expenseReportTPAYpsPayType;
    }
    
    public void setExpenseReportTPAYpsPayType(PaymentTypeOid expenseReportTPAYpsPayType) {
        this.expenseReportTPAYpsPayType = expenseReportTPAYpsPayType;
    }

    @JsonIgnore
    public PaymentType getExpenseReportTPAYpsPayTypeInstance() {
        return this.expenseReportTPAYpsPayTypeInstance;
    }
    
    public void setExpenseReportTPAYpsPayTypeInstance(PaymentType expenseReportTPAYpsPayType) {
        this.expenseReportTPAYpsPayTypeInstance = expenseReportTPAYpsPayType;
    }

    private void checkExpenseReportTPAYpsPayType() throws NotNullArgumentException {
        if(this.getExpenseReportTPAYpsPayTypeInstance() == null || this.getExpenseReportTPAYpsPayTypeInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_TPAY, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_TPAY_EXPENSEREPORTTPAYPSPAYTYPE, ExpenseReportConstants.SERV_ALIAS_TPAY, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_TPAY_EXPENSEREPORTTPAYPSPAYTYPE);
        }
    }

    @JsonIgnore
    public ExpenseReportOid getExpenseReportTPAYptpthisExpenseReport() {
        return this.expenseReportTPAYptpthisExpenseReport;
    }
    
    public void setExpenseReportTPAYptpthisExpenseReport(ExpenseReportOid expenseReportTPAYptpthisExpenseReport) {
        this.expenseReportTPAYptpthisExpenseReport = expenseReportTPAYptpthisExpenseReport;
    }

    @JsonIgnore
    public ExpenseReport getExpenseReportTPAYptpthisExpenseReportInstance() {
        return this.expenseReportTPAYptpthisExpenseReportInstance;
    }
    
    public void setExpenseReportTPAYptpthisExpenseReportInstance(ExpenseReport expenseReportTPAYptpthisExpenseReport) {
        this.expenseReportTPAYptpthisExpenseReportInstance = expenseReportTPAYptpthisExpenseReport;
    }

    private void checkExpenseReportTPAYptpthisExpenseReport() throws NotNullArgumentException {
        if(this.getExpenseReportTPAYptpthisExpenseReportInstance() == null || this.getExpenseReportTPAYptpthisExpenseReportInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_TPAY, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_TPAY_EXPENSEREPORTTPAYPTPTHISEXPENSEREPORT, ExpenseReportConstants.SERV_ALIAS_TPAY, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_TPAY_EXPENSEREPORTTPAYPTPTHISEXPENSEREPORT);
        }
    }

    @JsonIgnore
    public String getExpenseReportTPAYpsComments() {
        return this.expenseReportTPAYpsComments;
    }
    
    public void setExpenseReportTPAYpsComments(String expenseReportTPAYpsComments) {
        this.expenseReportTPAYpsComments = expenseReportTPAYpsComments;
    }

    private void checkExpenseReportTPAYpsComments() throws NotNullArgumentException {
        if(this.getExpenseReportTPAYpsComments() == null) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_TPAY, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_TPAY_EXPENSEREPORTTPAYPSCOMMENTS, ExpenseReportConstants.SERV_ALIAS_TPAY, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_TPAY_EXPENSEREPORTTPAYPSCOMMENTS);
        }
    }
}
