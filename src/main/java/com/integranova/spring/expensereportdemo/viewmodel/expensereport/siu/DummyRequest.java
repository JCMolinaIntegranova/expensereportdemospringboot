package com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ExpenseReportConstants;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseReportOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DummyRequest")
public class DummyRequest {

    @ApiModelProperty(name = "Expense Report")
    @JsonProperty("p_thisexpensereport_oid")
    private ExpenseReportOid expenseReportdummypthisExpenseReport;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ExpenseReport expenseReportdummypthisExpenseReportInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkExpenseReportdummypthisExpenseReport();
    }

    @JsonIgnore
    public ExpenseReportOid getExpenseReportdummypthisExpenseReport() {
        return this.expenseReportdummypthisExpenseReport;
    }
    
    public void setExpenseReportdummypthisExpenseReport(ExpenseReportOid expenseReportdummypthisExpenseReport) {
        this.expenseReportdummypthisExpenseReport = expenseReportdummypthisExpenseReport;
    }

    @JsonIgnore
    public ExpenseReport getExpenseReportdummypthisExpenseReportInstance() {
        return this.expenseReportdummypthisExpenseReportInstance;
    }
    
    public void setExpenseReportdummypthisExpenseReportInstance(ExpenseReport expenseReportdummypthisExpenseReport) {
        this.expenseReportdummypthisExpenseReportInstance = expenseReportdummypthisExpenseReport;
    }

    private void checkExpenseReportdummypthisExpenseReport() throws NotNullArgumentException {
        if(this.getExpenseReportdummypthisExpenseReportInstance() == null || this.getExpenseReportdummypthisExpenseReportInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_DUMMY, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_DUMMY_EXPENSEREPORTDUMMYPTHISEXPENSEREPORT, ExpenseReportConstants.SERV_ALIAS_DUMMY, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_DUMMY_EXPENSEREPORTDUMMYPTHISEXPENSEREPORT);
        }
    }
}
