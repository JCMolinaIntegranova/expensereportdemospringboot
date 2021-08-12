package com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ExpenseReportConstants;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseReportOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.CancelapproveRequest")
public class CancelapproveRequest {

    @ApiModelProperty(name = "Expense Report")
    @JsonProperty("p_thisexpensereport_oid")
    private ExpenseReportOid expenseReportcancelapprovepthisExpenseReport;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ExpenseReport expenseReportcancelapprovepthisExpenseReportInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkExpenseReportcancelapprovepthisExpenseReport();
    }

    @JsonIgnore
    public ExpenseReportOid getExpenseReportcancelapprovepthisExpenseReport() {
        return this.expenseReportcancelapprovepthisExpenseReport;
    }
    
    public void setExpenseReportcancelapprovepthisExpenseReport(ExpenseReportOid expenseReportcancelapprovepthisExpenseReport) {
        this.expenseReportcancelapprovepthisExpenseReport = expenseReportcancelapprovepthisExpenseReport;
    }

    @JsonIgnore
    public ExpenseReport getExpenseReportcancelapprovepthisExpenseReportInstance() {
        return this.expenseReportcancelapprovepthisExpenseReportInstance;
    }
    
    public void setExpenseReportcancelapprovepthisExpenseReportInstance(ExpenseReport expenseReportcancelapprovepthisExpenseReport) {
        this.expenseReportcancelapprovepthisExpenseReportInstance = expenseReportcancelapprovepthisExpenseReport;
    }

    private void checkExpenseReportcancelapprovepthisExpenseReport() throws NotNullArgumentException {
        if(this.getExpenseReportcancelapprovepthisExpenseReportInstance() == null || this.getExpenseReportcancelapprovepthisExpenseReportInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_CANCELAPPROVE, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_CANCELAPPROVE_EXPENSEREPORTCANCELAPPROVEPTHISEXPENSEREPORT, ExpenseReportConstants.SERV_ALIAS_CANCELAPPROVE, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_CANCELAPPROVE_EXPENSEREPORTCANCELAPPROVEPTHISEXPENSEREPORT);
        }
    }
}
