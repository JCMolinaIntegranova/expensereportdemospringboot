package com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.ExpenseReportConstants;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.ERTemplate;
import com.integranova.spring.expensereportdemo.persistence.ExpenseCurrency;
import com.integranova.spring.expensereportdemo.persistence.oid.EmployeeOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ERTemplateOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ProjectOid;
import com.integranova.spring.expensereportdemo.persistence.Project;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.sql.Date;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWFROMTEMPLATERequest")
public class TNEWFROMTEMPLATERequest {

    @ApiModelProperty(name = "Employee")
    @JsonProperty("pt_p_agremployee_oid")
    private EmployeeOid expenseReportTNEWFROMTEMPLATEptpagrEmployee;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Employee expenseReportTNEWFROMTEMPLATEptpagrEmployeeInstance;

    @ApiModelProperty(name = "Expense Currency")
    @JsonProperty("pt_p_agrexpensecurrency_json")
    private String expenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ExpenseCurrency expenseReportTNEWFROMTEMPLATEptpagrExpenseCurrencyInstance;

    @ApiModelProperty(name = "Project")
    @JsonProperty("pt_p_agrproject_oid")
    private ProjectOid expenseReportTNEWFROMTEMPLATEptpagrProject;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Project expenseReportTNEWFROMTEMPLATEptpagrProjectInstance;

    @ApiModelProperty(name = "Presentation Date")
    @JsonProperty("pt_p_atrpresentdate")
    private Date expenseReportTNEWFROMTEMPLATEptpatrPresentDate;

    @ApiModelProperty(name = "Cause")
    @JsonProperty("pt_p_atrcause")
    private String expenseReportTNEWFROMTEMPLATEptpatrCause;

    @ApiModelProperty(name = "Advance")
    @JsonProperty("pt_p_atradvances")
    private Double expenseReportTNEWFROMTEMPLATEptpatrAdvances;

    @ApiModelProperty(name = "Expense Report Template")
    @JsonProperty("ptemplate_oid")
    private ERTemplateOid expenseReportTNEWFROMTEMPLATEpTemplate;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private ERTemplate expenseReportTNEWFROMTEMPLATEpTemplateInstance;

    @JsonProperty("preconditionId")
    @ApiModelProperty(hidden = true)
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkExpenseReportTNEWFROMTEMPLATEptpagrEmployee();
        checkExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency();
        checkExpenseReportTNEWFROMTEMPLATEptpagrProject();
        checkExpenseReportTNEWFROMTEMPLATEptpatrPresentDate();
        checkExpenseReportTNEWFROMTEMPLATEptpatrCause();
        checkExpenseReportTNEWFROMTEMPLATEptpatrAdvances();
        checkExpenseReportTNEWFROMTEMPLATEpTemplate();
    }

    @JsonIgnore
    public EmployeeOid getExpenseReportTNEWFROMTEMPLATEptpagrEmployee() {
        return this.expenseReportTNEWFROMTEMPLATEptpagrEmployee;
    }
    
    public void setExpenseReportTNEWFROMTEMPLATEptpagrEmployee(EmployeeOid expenseReportTNEWFROMTEMPLATEptpagrEmployee) {
        this.expenseReportTNEWFROMTEMPLATEptpagrEmployee = expenseReportTNEWFROMTEMPLATEptpagrEmployee;
    }

    @JsonIgnore
    public Employee getExpenseReportTNEWFROMTEMPLATEptpagrEmployeeInstance() {
        return this.expenseReportTNEWFROMTEMPLATEptpagrEmployeeInstance;
    }
    
    public void setExpenseReportTNEWFROMTEMPLATEptpagrEmployeeInstance(Employee expenseReportTNEWFROMTEMPLATEptpagrEmployee) {
        this.expenseReportTNEWFROMTEMPLATEptpagrEmployeeInstance = expenseReportTNEWFROMTEMPLATEptpagrEmployee;
    }

    private void checkExpenseReportTNEWFROMTEMPLATEptpagrEmployee() throws NotNullArgumentException {
        if(this.getExpenseReportTNEWFROMTEMPLATEptpagrEmployeeInstance() == null || this.getExpenseReportTNEWFROMTEMPLATEptpagrEmployeeInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_TNEWFROMTEMPLATE, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGREMPLOYEE, ExpenseReportConstants.SERV_ALIAS_TNEWFROMTEMPLATE, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGREMPLOYEE);
        }
    }

    @JsonIgnore
    public String getExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency() {
        return this.expenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency;
    }
    
    public void setExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency(String expenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency) {
        this.expenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency = expenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency;
    }

    @JsonIgnore
    public ExpenseCurrency getExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrencyInstance() {
        return this.expenseReportTNEWFROMTEMPLATEptpagrExpenseCurrencyInstance;
    }
    
    public void setExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrencyInstance(ExpenseCurrency expenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency) {
        this.expenseReportTNEWFROMTEMPLATEptpagrExpenseCurrencyInstance = expenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency;
    }

    private void checkExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency() throws NotNullArgumentException {
        if(this.getExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrencyInstance() == null || this.getExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrencyInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_TNEWFROMTEMPLATE, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGREXPENSECURRENCY, ExpenseReportConstants.SERV_ALIAS_TNEWFROMTEMPLATE, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGREXPENSECURRENCY);
        }
    }

    @JsonIgnore
    public ProjectOid getExpenseReportTNEWFROMTEMPLATEptpagrProject() {
        return this.expenseReportTNEWFROMTEMPLATEptpagrProject;
    }
    
    public void setExpenseReportTNEWFROMTEMPLATEptpagrProject(ProjectOid expenseReportTNEWFROMTEMPLATEptpagrProject) {
        this.expenseReportTNEWFROMTEMPLATEptpagrProject = expenseReportTNEWFROMTEMPLATEptpagrProject;
    }

    @JsonIgnore
    public Project getExpenseReportTNEWFROMTEMPLATEptpagrProjectInstance() {
        return this.expenseReportTNEWFROMTEMPLATEptpagrProjectInstance;
    }
    
    public void setExpenseReportTNEWFROMTEMPLATEptpagrProjectInstance(Project expenseReportTNEWFROMTEMPLATEptpagrProject) {
        this.expenseReportTNEWFROMTEMPLATEptpagrProjectInstance = expenseReportTNEWFROMTEMPLATEptpagrProject;
    }

    private void checkExpenseReportTNEWFROMTEMPLATEptpagrProject() throws NotNullArgumentException {
        if(this.getExpenseReportTNEWFROMTEMPLATEptpagrProjectInstance() == null || this.getExpenseReportTNEWFROMTEMPLATEptpagrProjectInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_TNEWFROMTEMPLATE, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGRPROJECT, ExpenseReportConstants.SERV_ALIAS_TNEWFROMTEMPLATE, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGRPROJECT);
        }
    }

    @JsonIgnore
    public Date getExpenseReportTNEWFROMTEMPLATEptpatrPresentDate() {
        return this.expenseReportTNEWFROMTEMPLATEptpatrPresentDate;
    }
    
    public void setExpenseReportTNEWFROMTEMPLATEptpatrPresentDate(Date expenseReportTNEWFROMTEMPLATEptpatrPresentDate) {
        this.expenseReportTNEWFROMTEMPLATEptpatrPresentDate = expenseReportTNEWFROMTEMPLATEptpatrPresentDate;
    }

    private void checkExpenseReportTNEWFROMTEMPLATEptpatrPresentDate() throws NotNullArgumentException {
        if(this.getExpenseReportTNEWFROMTEMPLATEptpatrPresentDate() == null) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_TNEWFROMTEMPLATE, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPATRPRESENTDATE, ExpenseReportConstants.SERV_ALIAS_TNEWFROMTEMPLATE, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPATRPRESENTDATE);
        }
    }

    @JsonIgnore
    public String getExpenseReportTNEWFROMTEMPLATEptpatrCause() {
        return this.expenseReportTNEWFROMTEMPLATEptpatrCause;
    }
    
    public void setExpenseReportTNEWFROMTEMPLATEptpatrCause(String expenseReportTNEWFROMTEMPLATEptpatrCause) {
        this.expenseReportTNEWFROMTEMPLATEptpatrCause = expenseReportTNEWFROMTEMPLATEptpatrCause;
    }

    private void checkExpenseReportTNEWFROMTEMPLATEptpatrCause() throws NotNullArgumentException {
        if(this.getExpenseReportTNEWFROMTEMPLATEptpatrCause() == null) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_TNEWFROMTEMPLATE, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPATRCAUSE, ExpenseReportConstants.SERV_ALIAS_TNEWFROMTEMPLATE, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPATRCAUSE);
        }
    }

    @JsonIgnore
    public Double getExpenseReportTNEWFROMTEMPLATEptpatrAdvances() {
        return this.expenseReportTNEWFROMTEMPLATEptpatrAdvances;
    }
    
    public void setExpenseReportTNEWFROMTEMPLATEptpatrAdvances(Double expenseReportTNEWFROMTEMPLATEptpatrAdvances) {
        this.expenseReportTNEWFROMTEMPLATEptpatrAdvances = expenseReportTNEWFROMTEMPLATEptpatrAdvances;
    }

    private void checkExpenseReportTNEWFROMTEMPLATEptpatrAdvances() throws NotNullArgumentException {
        if(this.getExpenseReportTNEWFROMTEMPLATEptpatrAdvances() == null) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_TNEWFROMTEMPLATE, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPATRADVANCES, ExpenseReportConstants.SERV_ALIAS_TNEWFROMTEMPLATE, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPATRADVANCES);
        }
    }

    @JsonIgnore
    public ERTemplateOid getExpenseReportTNEWFROMTEMPLATEpTemplate() {
        return this.expenseReportTNEWFROMTEMPLATEpTemplate;
    }
    
    public void setExpenseReportTNEWFROMTEMPLATEpTemplate(ERTemplateOid expenseReportTNEWFROMTEMPLATEpTemplate) {
        this.expenseReportTNEWFROMTEMPLATEpTemplate = expenseReportTNEWFROMTEMPLATEpTemplate;
    }

    @JsonIgnore
    public ERTemplate getExpenseReportTNEWFROMTEMPLATEpTemplateInstance() {
        return this.expenseReportTNEWFROMTEMPLATEpTemplateInstance;
    }
    
    public void setExpenseReportTNEWFROMTEMPLATEpTemplateInstance(ERTemplate expenseReportTNEWFROMTEMPLATEpTemplate) {
        this.expenseReportTNEWFROMTEMPLATEpTemplateInstance = expenseReportTNEWFROMTEMPLATEpTemplate;
    }

    private void checkExpenseReportTNEWFROMTEMPLATEpTemplate() throws NotNullArgumentException {
        if(this.getExpenseReportTNEWFROMTEMPLATEpTemplateInstance() == null || this.getExpenseReportTNEWFROMTEMPLATEpTemplateInstance().isNull()) {
            throw new NotNullArgumentException(ExpenseReportConstants.SERV_ID_TNEWFROMTEMPLATE, ExpenseReportConstants.CLASS_ID, ExpenseReportConstants.ARG_ID_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTEMPLATE, ExpenseReportConstants.SERV_ALIAS_TNEWFROMTEMPLATE, ExpenseReportConstants.CLASS_ALIAS, ExpenseReportConstants.ARG_ALIAS_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTEMPLATE);
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
