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

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.AuthorizeRequest")
public class AuthorizeRequest {

    @ApiModelProperty(name = "Expense Report")
    @JsonProperty("p_thisexpensereport_oid")
    private ExpenseReportOid expenseReportauthorizepthisExpenseReport;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ExpenseReport expenseReportauthorizepthisExpenseReportInstance;

    @ApiModelProperty(name = "Date")
    @JsonProperty("ps_date")
    private Date expenseReportauthorizepsDate;

    @ApiModelProperty(name = "Comments")
    @JsonProperty("ps_comments")
    private String expenseReportauthorizepsComments;

    public void checkArguments() throws NotNullArgumentException {
        checkExpenseReportauthorizepthisExpenseReport();
        checkExpenseReportauthorizepsDate();
    }

    @JsonIgnore
    public ExpenseReportOid getExpenseReportauthorizepthisExpenseReport() {
        return this.expenseReportauthorizepthisExpenseReport;
    }
    
    public void setExpenseReportauthorizepthisExpenseReport(ExpenseReportOid expenseReportauthorizepthisExpenseReport) {
        this.expenseReportauthorizepthisExpenseReport = expenseReportauthorizepthisExpenseReport;
    }

    @JsonIgnore
    public ExpenseReport getExpenseReportauthorizepthisExpenseReportInstance() {
        return this.expenseReportauthorizepthisExpenseReportInstance;
    }
    
    public void setExpenseReportauthorizepthisExpenseReportInstance(ExpenseReport expenseReportauthorizepthisExpenseReport) {
        this.expenseReportauthorizepthisExpenseReportInstance = expenseReportauthorizepthisExpenseReport;
    }

    private void checkExpenseReportauthorizepthisExpenseReport() throws NotNullArgumentException {
        if(this.getExpenseReportauthorizepthisExpenseReportInstance() == null || this.getExpenseReportauthorizepthisExpenseReportInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_AUTHORIZE, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_AUTHORIZE_EXPENSEREPORTAUTHORIZEPTHISEXPENSEREPORT, ExpenseReportConstants.SERV_ALIAS_AUTHORIZE, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_AUTHORIZE_EXPENSEREPORTAUTHORIZEPTHISEXPENSEREPORT);
        }
    }

    @JsonIgnore
    public Date getExpenseReportauthorizepsDate() {
        return this.expenseReportauthorizepsDate;
    }
    
    public void setExpenseReportauthorizepsDate(Date expenseReportauthorizepsDate) {
        this.expenseReportauthorizepsDate = expenseReportauthorizepsDate;
    }

    private void checkExpenseReportauthorizepsDate() throws NotNullArgumentException {
        if(this.getExpenseReportauthorizepsDate() == null) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_AUTHORIZE, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_AUTHORIZE_EXPENSEREPORTAUTHORIZEPSDATE, ExpenseReportConstants.SERV_ALIAS_AUTHORIZE, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_AUTHORIZE_EXPENSEREPORTAUTHORIZEPSDATE);
        }
    }

    @JsonIgnore
    public String getExpenseReportauthorizepsComments() {
        return this.expenseReportauthorizepsComments;
    }
    
    public void setExpenseReportauthorizepsComments(String expenseReportauthorizepsComments) {
        this.expenseReportauthorizepsComments = expenseReportauthorizepsComments;
    }
}
