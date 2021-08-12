package com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseReportOid;
import com.integranova.spring.expensereportdemo.viewmodel.ServiceResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.HashMap;
import java.util.Map;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWResponse")
public class TNEWResponse extends ServiceResponse {

    @ApiModelProperty(name = "Expense Report")
    @JsonProperty("newexpensereport")
    private ExpenseReportOid expenseReportTNEWnewExpenseReport;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ExpenseReport expenseReportTNEWnewExpenseReportInstance;

    public TNEWResponse() {
        super();
    }

    public ExpenseReportOid getExpenseReportTNEWnewExpenseReport() {
        return this.expenseReportTNEWnewExpenseReport;
    }
    
    public void setExpenseReportTNEWnewExpenseReport(ExpenseReportOid expenseReportTNEWnewExpenseReport) {
        this.expenseReportTNEWnewExpenseReport = expenseReportTNEWnewExpenseReport;
    }
    @JsonIgnore
    public ExpenseReport getExpenseReportTNEWnewExpenseReportInstance() {
        return this.expenseReportTNEWnewExpenseReportInstance;
    }
    
    public void setExpenseReportTNEWnewExpenseReportInstance(ExpenseReport expenseReportTNEWnewExpenseReport) {
        this.expenseReportTNEWnewExpenseReportInstance = expenseReportTNEWnewExpenseReport;
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("expenseReportTNEWnewExpenseReport", expenseReportTNEWnewExpenseReport);
        return outArgs;
    }
}
