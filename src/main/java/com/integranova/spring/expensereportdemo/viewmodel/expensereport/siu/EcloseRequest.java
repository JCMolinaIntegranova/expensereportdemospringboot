package com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ExpenseReportConstants;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseReportOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.EcloseRequest")
public class EcloseRequest {

    @ApiModelProperty(name = "Expense Report")
    @JsonProperty("p_thisexpensereport_oid")
    private ExpenseReportOid expenseReporteclosepthisExpenseReport;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ExpenseReport expenseReporteclosepthisExpenseReportInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkExpenseReporteclosepthisExpenseReport();
    }

    @JsonIgnore
    public ExpenseReportOid getExpenseReporteclosepthisExpenseReport() {
        return this.expenseReporteclosepthisExpenseReport;
    }
    
    public void setExpenseReporteclosepthisExpenseReport(ExpenseReportOid expenseReporteclosepthisExpenseReport) {
        this.expenseReporteclosepthisExpenseReport = expenseReporteclosepthisExpenseReport;
    }

    @JsonIgnore
    public ExpenseReport getExpenseReporteclosepthisExpenseReportInstance() {
        return this.expenseReporteclosepthisExpenseReportInstance;
    }
    
    public void setExpenseReporteclosepthisExpenseReportInstance(ExpenseReport expenseReporteclosepthisExpenseReport) {
        this.expenseReporteclosepthisExpenseReportInstance = expenseReporteclosepthisExpenseReport;
    }

    private void checkExpenseReporteclosepthisExpenseReport() throws NotNullArgumentException {
        if(this.getExpenseReporteclosepthisExpenseReportInstance() == null || this.getExpenseReporteclosepthisExpenseReportInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_ECLOSE, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_ECLOSE_EXPENSEREPORTECLOSEPTHISEXPENSEREPORT, ExpenseReportConstants.SERV_ALIAS_ECLOSE, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_ECLOSE_EXPENSEREPORTECLOSEPTHISEXPENSEREPORT);
        }
    }
}
