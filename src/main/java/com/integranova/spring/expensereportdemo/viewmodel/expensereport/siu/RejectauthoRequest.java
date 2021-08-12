package com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ExpenseReportConstants;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseReportOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.RejectauthoRequest")
public class RejectauthoRequest {

    @ApiModelProperty(name = "Expense Report")
    @JsonProperty("p_thisexpensereport_oid")
    private ExpenseReportOid expenseReportrejectauthopthisExpenseReport;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ExpenseReport expenseReportrejectauthopthisExpenseReportInstance;

    @ApiModelProperty(name = "Comments")
    @JsonProperty("pe_comments")
    private String expenseReportrejectauthopeComments;

    @JsonProperty("preconditionId")
    @ApiModelProperty(hidden = true)
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkExpenseReportrejectauthopthisExpenseReport();
        checkExpenseReportrejectauthopeComments();
    }

    @JsonIgnore
    public ExpenseReportOid getExpenseReportrejectauthopthisExpenseReport() {
        return this.expenseReportrejectauthopthisExpenseReport;
    }
    
    public void setExpenseReportrejectauthopthisExpenseReport(ExpenseReportOid expenseReportrejectauthopthisExpenseReport) {
        this.expenseReportrejectauthopthisExpenseReport = expenseReportrejectauthopthisExpenseReport;
    }

    @JsonIgnore
    public ExpenseReport getExpenseReportrejectauthopthisExpenseReportInstance() {
        return this.expenseReportrejectauthopthisExpenseReportInstance;
    }
    
    public void setExpenseReportrejectauthopthisExpenseReportInstance(ExpenseReport expenseReportrejectauthopthisExpenseReport) {
        this.expenseReportrejectauthopthisExpenseReportInstance = expenseReportrejectauthopthisExpenseReport;
    }

    private void checkExpenseReportrejectauthopthisExpenseReport() throws NotNullArgumentException {
        if(this.getExpenseReportrejectauthopthisExpenseReportInstance() == null || this.getExpenseReportrejectauthopthisExpenseReportInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_REJECTAUTHO, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_REJECTAUTHO_EXPENSEREPORTREJECTAUTHOPTHISEXPENSEREPORT, ExpenseReportConstants.SERV_ALIAS_REJECTAUTHO, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_REJECTAUTHO_EXPENSEREPORTREJECTAUTHOPTHISEXPENSEREPORT);
        }
    }

    @JsonIgnore
    public String getExpenseReportrejectauthopeComments() {
        return this.expenseReportrejectauthopeComments;
    }
    
    public void setExpenseReportrejectauthopeComments(String expenseReportrejectauthopeComments) {
        this.expenseReportrejectauthopeComments = expenseReportrejectauthopeComments;
    }

    private void checkExpenseReportrejectauthopeComments() throws NotNullArgumentException {
        if(this.getExpenseReportrejectauthopeComments() == null) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_REJECTAUTHO, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_REJECTAUTHO_EXPENSEREPORTREJECTAUTHOPECOMMENTS, ExpenseReportConstants.SERV_ALIAS_REJECTAUTHO, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_REJECTAUTHO_EXPENSEREPORTREJECTAUTHOPECOMMENTS);
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
