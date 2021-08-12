package com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ExpenseReportConstants;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseReportOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DelexpenseRequest")
public class DelexpenseRequest {

    @ApiModelProperty(name = "Expense Report")
    @JsonProperty("p_thisexpensereport_oid")
    private ExpenseReportOid expenseReportdelexpensepthisExpenseReport;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ExpenseReport expenseReportdelexpensepthisExpenseReportInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkExpenseReportdelexpensepthisExpenseReport();
    }

    @JsonIgnore
    public ExpenseReportOid getExpenseReportdelexpensepthisExpenseReport() {
        return this.expenseReportdelexpensepthisExpenseReport;
    }
    
    public void setExpenseReportdelexpensepthisExpenseReport(ExpenseReportOid expenseReportdelexpensepthisExpenseReport) {
        this.expenseReportdelexpensepthisExpenseReport = expenseReportdelexpensepthisExpenseReport;
    }

    @JsonIgnore
    public ExpenseReport getExpenseReportdelexpensepthisExpenseReportInstance() {
        return this.expenseReportdelexpensepthisExpenseReportInstance;
    }
    
    public void setExpenseReportdelexpensepthisExpenseReportInstance(ExpenseReport expenseReportdelexpensepthisExpenseReport) {
        this.expenseReportdelexpensepthisExpenseReportInstance = expenseReportdelexpensepthisExpenseReport;
    }

    private void checkExpenseReportdelexpensepthisExpenseReport() throws NotNullArgumentException {
        if(this.getExpenseReportdelexpensepthisExpenseReportInstance() == null || this.getExpenseReportdelexpensepthisExpenseReportInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_DELEXPENSE, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_DELEXPENSE_EXPENSEREPORTDELEXPENSEPTHISEXPENSEREPORT, ExpenseReportConstants.SERV_ALIAS_DELEXPENSE, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_DELEXPENSE_EXPENSEREPORTDELEXPENSEPTHISEXPENSEREPORT);
        }
    }
}
