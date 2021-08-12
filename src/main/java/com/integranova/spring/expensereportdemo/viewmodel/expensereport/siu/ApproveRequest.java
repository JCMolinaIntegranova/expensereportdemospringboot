package com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ExpenseReportConstants;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseReportOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.ApproveRequest")
public class ApproveRequest {

    @ApiModelProperty(name = "Expense Report")
    @JsonProperty("p_thisexpensereport_oid")
    private ExpenseReportOid expenseReportapprovepthisExpenseReport;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ExpenseReport expenseReportapprovepthisExpenseReportInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkExpenseReportapprovepthisExpenseReport();
    }

    @JsonIgnore
    public ExpenseReportOid getExpenseReportapprovepthisExpenseReport() {
        return this.expenseReportapprovepthisExpenseReport;
    }
    
    public void setExpenseReportapprovepthisExpenseReport(ExpenseReportOid expenseReportapprovepthisExpenseReport) {
        this.expenseReportapprovepthisExpenseReport = expenseReportapprovepthisExpenseReport;
    }

    @JsonIgnore
    public ExpenseReport getExpenseReportapprovepthisExpenseReportInstance() {
        return this.expenseReportapprovepthisExpenseReportInstance;
    }
    
    public void setExpenseReportapprovepthisExpenseReportInstance(ExpenseReport expenseReportapprovepthisExpenseReport) {
        this.expenseReportapprovepthisExpenseReportInstance = expenseReportapprovepthisExpenseReport;
    }

    private void checkExpenseReportapprovepthisExpenseReport() throws NotNullArgumentException {
        if(this.getExpenseReportapprovepthisExpenseReportInstance() == null || this.getExpenseReportapprovepthisExpenseReportInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_APPROVE, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_APPROVE_EXPENSEREPORTAPPROVEPTHISEXPENSEREPORT, ExpenseReportConstants.SERV_ALIAS_APPROVE, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_APPROVE_EXPENSEREPORTAPPROVEPTHISEXPENSEREPORT);
        }
    }
}
