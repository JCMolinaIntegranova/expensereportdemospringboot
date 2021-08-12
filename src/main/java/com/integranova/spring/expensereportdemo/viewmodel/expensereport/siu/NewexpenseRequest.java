package com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ExpenseReportConstants;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.ExpenseCurrency;
import com.integranova.spring.expensereportdemo.persistence.oid.EmployeeOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseCurrencyOid;
import com.integranova.spring.expensereportdemo.persistence.oid.PaymentTypeOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ProjectOid;
import com.integranova.spring.expensereportdemo.persistence.PaymentType;
import com.integranova.spring.expensereportdemo.persistence.Project;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.sql.Date;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.NewexpenseRequest")
public class NewexpenseRequest {

    @ApiModelProperty(name = "Expense Currency")
    @JsonProperty("p_agrexpensecurrency_oid")
    private ExpenseCurrencyOid expenseReportnewexpensepagrExpenseCurrency;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ExpenseCurrency expenseReportnewexpensepagrExpenseCurrencyInstance;

    @ApiModelProperty(name = "Payment Type")
    @JsonProperty("p_agrpaymenttype_oid")
    private PaymentTypeOid expenseReportnewexpensepagrPaymentType;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private PaymentType expenseReportnewexpensepagrPaymentTypeInstance;

    @ApiModelProperty(name = "Project")
    @JsonProperty("p_agrproject_oid")
    private ProjectOid expenseReportnewexpensepagrProject;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Project expenseReportnewexpensepagrProjectInstance;

    @ApiModelProperty(name = "Employee")
    @JsonProperty("p_agremployee_oid")
    private EmployeeOid expenseReportnewexpensepagrEmployee;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Employee expenseReportnewexpensepagrEmployeeInstance;

    @ApiModelProperty(name = "Presentation Date")
    @JsonProperty("p_atrpresentdate")
    private Date expenseReportnewexpensepatrPresentDate;

    @ApiModelProperty(name = "Cause")
    @JsonProperty("p_atrcause")
    private String expenseReportnewexpensepatrCause;

    @ApiModelProperty(name = "Advances")
    @JsonProperty("p_atradvances")
    private Double expenseReportnewexpensepatrAdvances;

    @ApiModelProperty(name = "Exchange")
    @JsonProperty("p_atrexchange")
    private Double expenseReportnewexpensepatrExchange;

    public void checkArguments() throws NotNullArgumentException {
        checkExpenseReportnewexpensepagrExpenseCurrency();
        checkExpenseReportnewexpensepagrProject();
        checkExpenseReportnewexpensepagrEmployee();
        checkExpenseReportnewexpensepatrPresentDate();
        checkExpenseReportnewexpensepatrCause();
        checkExpenseReportnewexpensepatrAdvances();
        checkExpenseReportnewexpensepatrExchange();
    }

    @JsonIgnore
    public ExpenseCurrencyOid getExpenseReportnewexpensepagrExpenseCurrency() {
        return this.expenseReportnewexpensepagrExpenseCurrency;
    }
    
    public void setExpenseReportnewexpensepagrExpenseCurrency(ExpenseCurrencyOid expenseReportnewexpensepagrExpenseCurrency) {
        this.expenseReportnewexpensepagrExpenseCurrency = expenseReportnewexpensepagrExpenseCurrency;
    }

    @JsonIgnore
    public ExpenseCurrency getExpenseReportnewexpensepagrExpenseCurrencyInstance() {
        return this.expenseReportnewexpensepagrExpenseCurrencyInstance;
    }
    
    public void setExpenseReportnewexpensepagrExpenseCurrencyInstance(ExpenseCurrency expenseReportnewexpensepagrExpenseCurrency) {
        this.expenseReportnewexpensepagrExpenseCurrencyInstance = expenseReportnewexpensepagrExpenseCurrency;
    }

    private void checkExpenseReportnewexpensepagrExpenseCurrency() throws NotNullArgumentException {
        if(this.getExpenseReportnewexpensepagrExpenseCurrencyInstance() == null || this.getExpenseReportnewexpensepagrExpenseCurrencyInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_NEWEXPENSE, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_NEWEXPENSE_EXPENSEREPORTNEWEXPENSEPAGREXPENSECURRENCY, ExpenseReportConstants.SERV_ALIAS_NEWEXPENSE, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_NEWEXPENSE_EXPENSEREPORTNEWEXPENSEPAGREXPENSECURRENCY);
        }
    }

    @JsonIgnore
    public PaymentTypeOid getExpenseReportnewexpensepagrPaymentType() {
        return this.expenseReportnewexpensepagrPaymentType;
    }
    
    public void setExpenseReportnewexpensepagrPaymentType(PaymentTypeOid expenseReportnewexpensepagrPaymentType) {
        this.expenseReportnewexpensepagrPaymentType = expenseReportnewexpensepagrPaymentType;
    }

    @JsonIgnore
    public PaymentType getExpenseReportnewexpensepagrPaymentTypeInstance() {
        return this.expenseReportnewexpensepagrPaymentTypeInstance;
    }
    
    public void setExpenseReportnewexpensepagrPaymentTypeInstance(PaymentType expenseReportnewexpensepagrPaymentType) {
        this.expenseReportnewexpensepagrPaymentTypeInstance = expenseReportnewexpensepagrPaymentType;
    }

    @JsonIgnore
    public ProjectOid getExpenseReportnewexpensepagrProject() {
        return this.expenseReportnewexpensepagrProject;
    }
    
    public void setExpenseReportnewexpensepagrProject(ProjectOid expenseReportnewexpensepagrProject) {
        this.expenseReportnewexpensepagrProject = expenseReportnewexpensepagrProject;
    }

    @JsonIgnore
    public Project getExpenseReportnewexpensepagrProjectInstance() {
        return this.expenseReportnewexpensepagrProjectInstance;
    }
    
    public void setExpenseReportnewexpensepagrProjectInstance(Project expenseReportnewexpensepagrProject) {
        this.expenseReportnewexpensepagrProjectInstance = expenseReportnewexpensepagrProject;
    }

    private void checkExpenseReportnewexpensepagrProject() throws NotNullArgumentException {
        if(this.getExpenseReportnewexpensepagrProjectInstance() == null || this.getExpenseReportnewexpensepagrProjectInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_NEWEXPENSE, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_NEWEXPENSE_EXPENSEREPORTNEWEXPENSEPAGRPROJECT, ExpenseReportConstants.SERV_ALIAS_NEWEXPENSE, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_NEWEXPENSE_EXPENSEREPORTNEWEXPENSEPAGRPROJECT);
        }
    }

    @JsonIgnore
    public EmployeeOid getExpenseReportnewexpensepagrEmployee() {
        return this.expenseReportnewexpensepagrEmployee;
    }
    
    public void setExpenseReportnewexpensepagrEmployee(EmployeeOid expenseReportnewexpensepagrEmployee) {
        this.expenseReportnewexpensepagrEmployee = expenseReportnewexpensepagrEmployee;
    }

    @JsonIgnore
    public Employee getExpenseReportnewexpensepagrEmployeeInstance() {
        return this.expenseReportnewexpensepagrEmployeeInstance;
    }
    
    public void setExpenseReportnewexpensepagrEmployeeInstance(Employee expenseReportnewexpensepagrEmployee) {
        this.expenseReportnewexpensepagrEmployeeInstance = expenseReportnewexpensepagrEmployee;
    }

    private void checkExpenseReportnewexpensepagrEmployee() throws NotNullArgumentException {
        if(this.getExpenseReportnewexpensepagrEmployeeInstance() == null || this.getExpenseReportnewexpensepagrEmployeeInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_NEWEXPENSE, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_NEWEXPENSE_EXPENSEREPORTNEWEXPENSEPAGREMPLOYEE, ExpenseReportConstants.SERV_ALIAS_NEWEXPENSE, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_NEWEXPENSE_EXPENSEREPORTNEWEXPENSEPAGREMPLOYEE);
        }
    }

    @JsonIgnore
    public Date getExpenseReportnewexpensepatrPresentDate() {
        return this.expenseReportnewexpensepatrPresentDate;
    }
    
    public void setExpenseReportnewexpensepatrPresentDate(Date expenseReportnewexpensepatrPresentDate) {
        this.expenseReportnewexpensepatrPresentDate = expenseReportnewexpensepatrPresentDate;
    }

    private void checkExpenseReportnewexpensepatrPresentDate() throws NotNullArgumentException {
        if(this.getExpenseReportnewexpensepatrPresentDate() == null) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_NEWEXPENSE, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_NEWEXPENSE_EXPENSEREPORTNEWEXPENSEPATRPRESENTDATE, ExpenseReportConstants.SERV_ALIAS_NEWEXPENSE, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_NEWEXPENSE_EXPENSEREPORTNEWEXPENSEPATRPRESENTDATE);
        }
    }

    @JsonIgnore
    public String getExpenseReportnewexpensepatrCause() {
        return this.expenseReportnewexpensepatrCause;
    }
    
    public void setExpenseReportnewexpensepatrCause(String expenseReportnewexpensepatrCause) {
        this.expenseReportnewexpensepatrCause = expenseReportnewexpensepatrCause;
    }

    private void checkExpenseReportnewexpensepatrCause() throws NotNullArgumentException {
        if(this.getExpenseReportnewexpensepatrCause() == null) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_NEWEXPENSE, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_NEWEXPENSE_EXPENSEREPORTNEWEXPENSEPATRCAUSE, ExpenseReportConstants.SERV_ALIAS_NEWEXPENSE, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_NEWEXPENSE_EXPENSEREPORTNEWEXPENSEPATRCAUSE);
        }
    }

    @JsonIgnore
    public Double getExpenseReportnewexpensepatrAdvances() {
        return this.expenseReportnewexpensepatrAdvances;
    }
    
    public void setExpenseReportnewexpensepatrAdvances(Double expenseReportnewexpensepatrAdvances) {
        this.expenseReportnewexpensepatrAdvances = expenseReportnewexpensepatrAdvances;
    }

    private void checkExpenseReportnewexpensepatrAdvances() throws NotNullArgumentException {
        if(this.getExpenseReportnewexpensepatrAdvances() == null) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_NEWEXPENSE, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_NEWEXPENSE_EXPENSEREPORTNEWEXPENSEPATRADVANCES, ExpenseReportConstants.SERV_ALIAS_NEWEXPENSE, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_NEWEXPENSE_EXPENSEREPORTNEWEXPENSEPATRADVANCES);
        }
    }

    @JsonIgnore
    public Double getExpenseReportnewexpensepatrExchange() {
        return this.expenseReportnewexpensepatrExchange;
    }
    
    public void setExpenseReportnewexpensepatrExchange(Double expenseReportnewexpensepatrExchange) {
        this.expenseReportnewexpensepatrExchange = expenseReportnewexpensepatrExchange;
    }

    private void checkExpenseReportnewexpensepatrExchange() throws NotNullArgumentException {
        if(this.getExpenseReportnewexpensepatrExchange() == null) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_NEWEXPENSE, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_NEWEXPENSE_EXPENSEREPORTNEWEXPENSEPATREXCHANGE, ExpenseReportConstants.SERV_ALIAS_NEWEXPENSE, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_NEWEXPENSE_EXPENSEREPORTNEWEXPENSEPATREXCHANGE);
        }
    }
}
