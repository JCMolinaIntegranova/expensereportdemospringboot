package com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ExpenseReportConstants;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseReportOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.sql.Date;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.PayRequest")
public class PayRequest {

    @ApiModelProperty(name = "Expense Report")
    @JsonProperty("p_thisexpensereport_oid")
    private ExpenseReportOid expenseReportpaypthisExpenseReport;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ExpenseReport expenseReportpaypthisExpenseReportInstance;

    @ApiModelProperty(name = "Payment Date")
    @JsonProperty("pe_date")
    private Date expenseReportpaypeDate;

    @ApiModelProperty(name = "Comments")
    @JsonProperty("ps_comments")
    private String expenseReportpaypsComments;

    public void checkArguments() throws NotNullArgumentException {
        checkExpenseReportpaypthisExpenseReport();
        checkExpenseReportpaypeDate();
    }

    @JsonIgnore
    public ExpenseReportOid getExpenseReportpaypthisExpenseReport() {
        return this.expenseReportpaypthisExpenseReport;
    }
    
    public void setExpenseReportpaypthisExpenseReport(ExpenseReportOid expenseReportpaypthisExpenseReport) {
        this.expenseReportpaypthisExpenseReport = expenseReportpaypthisExpenseReport;
    }

    @JsonIgnore
    public ExpenseReport getExpenseReportpaypthisExpenseReportInstance() {
        return this.expenseReportpaypthisExpenseReportInstance;
    }
    
    public void setExpenseReportpaypthisExpenseReportInstance(ExpenseReport expenseReportpaypthisExpenseReport) {
        this.expenseReportpaypthisExpenseReportInstance = expenseReportpaypthisExpenseReport;
    }

    private void checkExpenseReportpaypthisExpenseReport() throws NotNullArgumentException {
        if(this.getExpenseReportpaypthisExpenseReportInstance() == null || this.getExpenseReportpaypthisExpenseReportInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_PAY, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_PAY_EXPENSEREPORTPAYPTHISEXPENSEREPORT, ExpenseReportConstants.SERV_ALIAS_PAY, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_PAY_EXPENSEREPORTPAYPTHISEXPENSEREPORT);
        }
    }

    @JsonIgnore
    public Date getExpenseReportpaypeDate() {
        return this.expenseReportpaypeDate;
    }
    
    public void setExpenseReportpaypeDate(Date expenseReportpaypeDate) {
        this.expenseReportpaypeDate = expenseReportpaypeDate;
    }

    private void checkExpenseReportpaypeDate() throws NotNullArgumentException {
        if(this.getExpenseReportpaypeDate() == null) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_PAY, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_PAY_EXPENSEREPORTPAYPEDATE, ExpenseReportConstants.SERV_ALIAS_PAY, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_PAY_EXPENSEREPORTPAYPEDATE);
        }
    }

    @JsonIgnore
    public String getExpenseReportpaypsComments() {
        return this.expenseReportpaypsComments;
    }
    
    public void setExpenseReportpaypsComments(String expenseReportpaypsComments) {
        this.expenseReportpaypsComments = expenseReportpaypsComments;
    }
}
