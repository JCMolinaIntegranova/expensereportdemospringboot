package com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ExpenseReportConstants;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseReportOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DELETEALLRequest")
public class DELETEALLRequest {

    @ApiModelProperty(name = "Expense Report")
    @JsonProperty("pt_p_thisexpensereport_oid")
    private ExpenseReportOid expenseReportDELETEALLptpthisExpenseReport;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ExpenseReport expenseReportDELETEALLptpthisExpenseReportInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkExpenseReportDELETEALLptpthisExpenseReport();
    }

    @JsonIgnore
    public ExpenseReportOid getExpenseReportDELETEALLptpthisExpenseReport() {
        return this.expenseReportDELETEALLptpthisExpenseReport;
    }
    
    public void setExpenseReportDELETEALLptpthisExpenseReport(ExpenseReportOid expenseReportDELETEALLptpthisExpenseReport) {
        this.expenseReportDELETEALLptpthisExpenseReport = expenseReportDELETEALLptpthisExpenseReport;
    }

    @JsonIgnore
    public ExpenseReport getExpenseReportDELETEALLptpthisExpenseReportInstance() {
        return this.expenseReportDELETEALLptpthisExpenseReportInstance;
    }
    
    public void setExpenseReportDELETEALLptpthisExpenseReportInstance(ExpenseReport expenseReportDELETEALLptpthisExpenseReport) {
        this.expenseReportDELETEALLptpthisExpenseReportInstance = expenseReportDELETEALLptpthisExpenseReport;
    }

    private void checkExpenseReportDELETEALLptpthisExpenseReport() throws NotNullArgumentException {
        if(this.getExpenseReportDELETEALLptpthisExpenseReportInstance() == null || this.getExpenseReportDELETEALLptpthisExpenseReportInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_DELETEALL, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_DELETEALL_EXPENSEREPORTDELETEALLPTPTHISEXPENSEREPORT, ExpenseReportConstants.SERV_ALIAS_DELETEALL, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_DELETEALL_EXPENSEREPORTDELETEALLPTPTHISEXPENSEREPORT);
        }
    }
}
