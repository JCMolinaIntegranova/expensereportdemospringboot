package com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ExpenseReportConstants;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.ExpenseCurrency;
import com.integranova.spring.expensereportdemo.persistence.oid.EmployeeOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ProjectOid;
import com.integranova.spring.expensereportdemo.persistence.Project;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.sql.Date;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWRequest")
public class TNEWRequest {

    @ApiModelProperty(name = "Employee")
    @JsonProperty("pt_p_agremployee_oid")
    private EmployeeOid expenseReportTNEWptpagrEmployee;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Employee expenseReportTNEWptpagrEmployeeInstance;

    @ApiModelProperty(name = "Expense Currency")
    @JsonProperty("pt_p_agrexpensecurrency_json")
    private String expenseReportTNEWptpagrExpenseCurrency;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ExpenseCurrency expenseReportTNEWptpagrExpenseCurrencyInstance;

    @ApiModelProperty(name = "Project")
    @JsonProperty("pt_p_agrproject_oid")
    private ProjectOid expenseReportTNEWptpagrProject;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Project expenseReportTNEWptpagrProjectInstance;

    @ApiModelProperty(name = "Presentation Date")
    @JsonProperty("pt_p_atrpresentdate")
    private Date expenseReportTNEWptpatrPresentDate;

    @ApiModelProperty(name = "Cause")
    @JsonProperty("pt_p_atrcause")
    private String expenseReportTNEWptpatrCause;

    @ApiModelProperty(name = "Advance")
    @JsonProperty("pt_p_atradvances")
    private Double expenseReportTNEWptpatrAdvances;

    @JsonProperty("preconditionId")
    @ApiModelProperty(hidden = true)
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkExpenseReportTNEWptpagrEmployee();
        checkExpenseReportTNEWptpagrExpenseCurrency();
        checkExpenseReportTNEWptpagrProject();
        checkExpenseReportTNEWptpatrPresentDate();
        checkExpenseReportTNEWptpatrCause();
        checkExpenseReportTNEWptpatrAdvances();
    }

    @JsonIgnore
    public EmployeeOid getExpenseReportTNEWptpagrEmployee() {
        return this.expenseReportTNEWptpagrEmployee;
    }
    
    public void setExpenseReportTNEWptpagrEmployee(EmployeeOid expenseReportTNEWptpagrEmployee) {
        this.expenseReportTNEWptpagrEmployee = expenseReportTNEWptpagrEmployee;
    }

    @JsonIgnore
    public Employee getExpenseReportTNEWptpagrEmployeeInstance() {
        return this.expenseReportTNEWptpagrEmployeeInstance;
    }
    
    public void setExpenseReportTNEWptpagrEmployeeInstance(Employee expenseReportTNEWptpagrEmployee) {
        this.expenseReportTNEWptpagrEmployeeInstance = expenseReportTNEWptpagrEmployee;
    }

    private void checkExpenseReportTNEWptpagrEmployee() throws NotNullArgumentException {
        if(this.getExpenseReportTNEWptpagrEmployeeInstance() == null || this.getExpenseReportTNEWptpagrEmployeeInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_TNEW, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_TNEW_EXPENSEREPORTTNEWPTPAGREMPLOYEE, ExpenseReportConstants.SERV_ALIAS_TNEW, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_TNEW_EXPENSEREPORTTNEWPTPAGREMPLOYEE);
        }
    }

    @JsonIgnore
    public String getExpenseReportTNEWptpagrExpenseCurrency() {
        return this.expenseReportTNEWptpagrExpenseCurrency;
    }
    
    public void setExpenseReportTNEWptpagrExpenseCurrency(String expenseReportTNEWptpagrExpenseCurrency) {
        this.expenseReportTNEWptpagrExpenseCurrency = expenseReportTNEWptpagrExpenseCurrency;
    }

    @JsonIgnore
    public ExpenseCurrency getExpenseReportTNEWptpagrExpenseCurrencyInstance() {
        return this.expenseReportTNEWptpagrExpenseCurrencyInstance;
    }
    
    public void setExpenseReportTNEWptpagrExpenseCurrencyInstance(ExpenseCurrency expenseReportTNEWptpagrExpenseCurrency) {
        this.expenseReportTNEWptpagrExpenseCurrencyInstance = expenseReportTNEWptpagrExpenseCurrency;
    }

    private void checkExpenseReportTNEWptpagrExpenseCurrency() throws NotNullArgumentException {
        if(this.getExpenseReportTNEWptpagrExpenseCurrencyInstance() == null || this.getExpenseReportTNEWptpagrExpenseCurrencyInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_TNEW, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_TNEW_EXPENSEREPORTTNEWPTPAGREXPENSECURRENCY, ExpenseReportConstants.SERV_ALIAS_TNEW, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_TNEW_EXPENSEREPORTTNEWPTPAGREXPENSECURRENCY);
        }
    }

    @JsonIgnore
    public ProjectOid getExpenseReportTNEWptpagrProject() {
        return this.expenseReportTNEWptpagrProject;
    }
    
    public void setExpenseReportTNEWptpagrProject(ProjectOid expenseReportTNEWptpagrProject) {
        this.expenseReportTNEWptpagrProject = expenseReportTNEWptpagrProject;
    }

    @JsonIgnore
    public Project getExpenseReportTNEWptpagrProjectInstance() {
        return this.expenseReportTNEWptpagrProjectInstance;
    }
    
    public void setExpenseReportTNEWptpagrProjectInstance(Project expenseReportTNEWptpagrProject) {
        this.expenseReportTNEWptpagrProjectInstance = expenseReportTNEWptpagrProject;
    }

    private void checkExpenseReportTNEWptpagrProject() throws NotNullArgumentException {
        if(this.getExpenseReportTNEWptpagrProjectInstance() == null || this.getExpenseReportTNEWptpagrProjectInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_TNEW, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_TNEW_EXPENSEREPORTTNEWPTPAGRPROJECT, ExpenseReportConstants.SERV_ALIAS_TNEW, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_TNEW_EXPENSEREPORTTNEWPTPAGRPROJECT);
        }
    }

    @JsonIgnore
    public Date getExpenseReportTNEWptpatrPresentDate() {
        return this.expenseReportTNEWptpatrPresentDate;
    }
    
    public void setExpenseReportTNEWptpatrPresentDate(Date expenseReportTNEWptpatrPresentDate) {
        this.expenseReportTNEWptpatrPresentDate = expenseReportTNEWptpatrPresentDate;
    }

    private void checkExpenseReportTNEWptpatrPresentDate() throws NotNullArgumentException {
        if(this.getExpenseReportTNEWptpatrPresentDate() == null) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_TNEW, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_TNEW_EXPENSEREPORTTNEWPTPATRPRESENTDATE, ExpenseReportConstants.SERV_ALIAS_TNEW, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_TNEW_EXPENSEREPORTTNEWPTPATRPRESENTDATE);
        }
    }

    @JsonIgnore
    public String getExpenseReportTNEWptpatrCause() {
        return this.expenseReportTNEWptpatrCause;
    }
    
    public void setExpenseReportTNEWptpatrCause(String expenseReportTNEWptpatrCause) {
        this.expenseReportTNEWptpatrCause = expenseReportTNEWptpatrCause;
    }

    private void checkExpenseReportTNEWptpatrCause() throws NotNullArgumentException {
        if(this.getExpenseReportTNEWptpatrCause() == null) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_TNEW, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_TNEW_EXPENSEREPORTTNEWPTPATRCAUSE, ExpenseReportConstants.SERV_ALIAS_TNEW, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_TNEW_EXPENSEREPORTTNEWPTPATRCAUSE);
        }
    }

    @JsonIgnore
    public Double getExpenseReportTNEWptpatrAdvances() {
        return this.expenseReportTNEWptpatrAdvances;
    }
    
    public void setExpenseReportTNEWptpatrAdvances(Double expenseReportTNEWptpatrAdvances) {
        this.expenseReportTNEWptpatrAdvances = expenseReportTNEWptpatrAdvances;
    }

    private void checkExpenseReportTNEWptpatrAdvances() throws NotNullArgumentException {
        if(this.getExpenseReportTNEWptpatrAdvances() == null) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_TNEW, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_TNEW_EXPENSEREPORTTNEWPTPATRADVANCES, ExpenseReportConstants.SERV_ALIAS_TNEW, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_TNEW_EXPENSEREPORTTNEWPTPATRADVANCES);
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
