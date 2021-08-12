package com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ExpenseReportConstants;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseReportOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.RejectpaymentRequest")
public class RejectpaymentRequest {

    @ApiModelProperty(name = "Expense Report")
    @JsonProperty("p_thisexpensereport_oid")
    private ExpenseReportOid expenseReportrejectpaymentpthisExpenseReport;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ExpenseReport expenseReportrejectpaymentpthisExpenseReportInstance;

    @ApiModelProperty(name = "Comments")
    @JsonProperty("pe_comments")
    private String expenseReportrejectpaymentpeComments;

    @JsonProperty("preconditionId")
    @ApiModelProperty(hidden = true)
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkExpenseReportrejectpaymentpthisExpenseReport();
        checkExpenseReportrejectpaymentpeComments();
    }

    @JsonIgnore
    public ExpenseReportOid getExpenseReportrejectpaymentpthisExpenseReport() {
        return this.expenseReportrejectpaymentpthisExpenseReport;
    }
    
    public void setExpenseReportrejectpaymentpthisExpenseReport(ExpenseReportOid expenseReportrejectpaymentpthisExpenseReport) {
        this.expenseReportrejectpaymentpthisExpenseReport = expenseReportrejectpaymentpthisExpenseReport;
    }

    @JsonIgnore
    public ExpenseReport getExpenseReportrejectpaymentpthisExpenseReportInstance() {
        return this.expenseReportrejectpaymentpthisExpenseReportInstance;
    }
    
    public void setExpenseReportrejectpaymentpthisExpenseReportInstance(ExpenseReport expenseReportrejectpaymentpthisExpenseReport) {
        this.expenseReportrejectpaymentpthisExpenseReportInstance = expenseReportrejectpaymentpthisExpenseReport;
    }

    private void checkExpenseReportrejectpaymentpthisExpenseReport() throws NotNullArgumentException {
        if(this.getExpenseReportrejectpaymentpthisExpenseReportInstance() == null || this.getExpenseReportrejectpaymentpthisExpenseReportInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_REJECTPAYMENT, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_REJECTPAYMENT_EXPENSEREPORTREJECTPAYMENTPTHISEXPENSEREPORT, ExpenseReportConstants.SERV_ALIAS_REJECTPAYMENT, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_REJECTPAYMENT_EXPENSEREPORTREJECTPAYMENTPTHISEXPENSEREPORT);
        }
    }

    @JsonIgnore
    public String getExpenseReportrejectpaymentpeComments() {
        return this.expenseReportrejectpaymentpeComments;
    }
    
    public void setExpenseReportrejectpaymentpeComments(String expenseReportrejectpaymentpeComments) {
        this.expenseReportrejectpaymentpeComments = expenseReportrejectpaymentpeComments;
    }

    private void checkExpenseReportrejectpaymentpeComments() throws NotNullArgumentException {
        if(this.getExpenseReportrejectpaymentpeComments() == null) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_REJECTPAYMENT, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_REJECTPAYMENT_EXPENSEREPORTREJECTPAYMENTPECOMMENTS, ExpenseReportConstants.SERV_ALIAS_REJECTPAYMENT, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_REJECTPAYMENT_EXPENSEREPORTREJECTPAYMENTPECOMMENTS);
        }
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
