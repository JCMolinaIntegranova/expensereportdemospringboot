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

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWFROMTEMPLATEResponse")
public class TNEWFROMTEMPLATEResponse extends ServiceResponse {

    @ApiModelProperty(name = "Expense Report")
    @JsonProperty("newexpensereport")
    private ExpenseReportOid expenseReportTNEWFROMTEMPLATEnewExpenseReport;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ExpenseReport expenseReportTNEWFROMTEMPLATEnewExpenseReportInstance;

    @ApiModelProperty(name = "Number of Lines")
    @JsonProperty("psnumberoflines")
    private Long expenseReportTNEWFROMTEMPLATEpsNumberOfLines;

    public TNEWFROMTEMPLATEResponse() {
        super();
    }

    public ExpenseReportOid getExpenseReportTNEWFROMTEMPLATEnewExpenseReport() {
        return this.expenseReportTNEWFROMTEMPLATEnewExpenseReport;
    }
    
    public void setExpenseReportTNEWFROMTEMPLATEnewExpenseReport(ExpenseReportOid expenseReportTNEWFROMTEMPLATEnewExpenseReport) {
        this.expenseReportTNEWFROMTEMPLATEnewExpenseReport = expenseReportTNEWFROMTEMPLATEnewExpenseReport;
    }
    @JsonIgnore
    public ExpenseReport getExpenseReportTNEWFROMTEMPLATEnewExpenseReportInstance() {
        return this.expenseReportTNEWFROMTEMPLATEnewExpenseReportInstance;
    }
    
    public void setExpenseReportTNEWFROMTEMPLATEnewExpenseReportInstance(ExpenseReport expenseReportTNEWFROMTEMPLATEnewExpenseReport) {
        this.expenseReportTNEWFROMTEMPLATEnewExpenseReportInstance = expenseReportTNEWFROMTEMPLATEnewExpenseReport;
    }

    public Long getExpenseReportTNEWFROMTEMPLATEpsNumberOfLines() {
        return this.expenseReportTNEWFROMTEMPLATEpsNumberOfLines;
    }
    
    public void setExpenseReportTNEWFROMTEMPLATEpsNumberOfLines(Long expenseReportTNEWFROMTEMPLATEpsNumberOfLines) {
        this.expenseReportTNEWFROMTEMPLATEpsNumberOfLines = expenseReportTNEWFROMTEMPLATEpsNumberOfLines;
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("expenseReportTNEWFROMTEMPLATEnewExpenseReport", expenseReportTNEWFROMTEMPLATEnewExpenseReport);
        outArgs.put("expenseReportTNEWFROMTEMPLATEpsNumberOfLines", expenseReportTNEWFROMTEMPLATEpsNumberOfLines);
        return outArgs;
    }
}
