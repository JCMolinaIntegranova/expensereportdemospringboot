package com.integranova.spring.expensereportdemo.viewmodel.employee.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.EmployeeConstants;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.oid.EmployeeOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.employee.siu.EditinstanceRequest")
public class EditinstanceRequest {

    @ApiModelProperty(name = "Employee")
    @JsonProperty("p_thisemployee_oid")
    private EmployeeOid employeeeditinstancepthisEmployee;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Employee employeeeditinstancepthisEmployeeInstance;

    @ApiModelProperty(name = "Name")
    @JsonProperty("p_empname")
    private String employeeeditinstancepEmpName;

    @ApiModelProperty(name = "Surname")
    @JsonProperty("p_empsurname")
    private String employeeeditinstancepEmpSurname;

    @ApiModelProperty(name = "Site")
    @JsonProperty("p_site")
    private String employeeeditinstancepSite;

    @ApiModelProperty(name = "Phone Numbers")
    @JsonProperty("p_phonenumbers")
    private String employeeeditinstancepPhoneNumbers;

    @ApiModelProperty(name = "E-mail")
    @JsonProperty("p_email")
    private String employeeeditinstancepemail;

    public void checkArguments() throws NotNullArgumentException {
        checkEmployeeeditinstancepthisEmployee();
        checkEmployeeeditinstancepEmpName();
        checkEmployeeeditinstancepEmpSurname();
        checkEmployeeeditinstancepSite();
        checkEmployeeeditinstancepemail();
    }

    @JsonIgnore
    public EmployeeOid getEmployeeeditinstancepthisEmployee() {
        return this.employeeeditinstancepthisEmployee;
    }
    
    public void setEmployeeeditinstancepthisEmployee(EmployeeOid employeeeditinstancepthisEmployee) {
        this.employeeeditinstancepthisEmployee = employeeeditinstancepthisEmployee;
    }

    @JsonIgnore
    public Employee getEmployeeeditinstancepthisEmployeeInstance() {
        return this.employeeeditinstancepthisEmployeeInstance;
    }
    
    public void setEmployeeeditinstancepthisEmployeeInstance(Employee employeeeditinstancepthisEmployee) {
        this.employeeeditinstancepthisEmployeeInstance = employeeeditinstancepthisEmployee;
    }

    private void checkEmployeeeditinstancepthisEmployee() throws NotNullArgumentException {
        if(this.getEmployeeeditinstancepthisEmployeeInstance() == null || this.getEmployeeeditinstancepthisEmployeeInstance().isNull()) {
            throw new NotNullArgumentException(EmployeeConstants.SERV_ID_EDITINSTANCE, EmployeeConstants.CLASS_ID, EmployeeConstants.ARG_ID_EDITINSTANCE_EMPLOYEEEDITINSTANCEPTHISEMPLOYEE, EmployeeConstants.SERV_ALIAS_EDITINSTANCE, EmployeeConstants.CLASS_ALIAS, EmployeeConstants.ARG_ALIAS_EDITINSTANCE_EMPLOYEEEDITINSTANCEPTHISEMPLOYEE);
        }
    }

    @JsonIgnore
    public String getEmployeeeditinstancepEmpName() {
        return this.employeeeditinstancepEmpName;
    }
    
    public void setEmployeeeditinstancepEmpName(String employeeeditinstancepEmpName) {
        this.employeeeditinstancepEmpName = employeeeditinstancepEmpName;
    }

    private void checkEmployeeeditinstancepEmpName() throws NotNullArgumentException {
        if(this.getEmployeeeditinstancepEmpName() == null) {
            throw new NotNullArgumentException(EmployeeConstants.SERV_ID_EDITINSTANCE, EmployeeConstants.CLASS_ID, EmployeeConstants.ARG_ID_EDITINSTANCE_EMPLOYEEEDITINSTANCEPEMPNAME, EmployeeConstants.SERV_ALIAS_EDITINSTANCE, EmployeeConstants.CLASS_ALIAS, EmployeeConstants.ARG_ALIAS_EDITINSTANCE_EMPLOYEEEDITINSTANCEPEMPNAME);
        }
    }

    @JsonIgnore
    public String getEmployeeeditinstancepEmpSurname() {
        return this.employeeeditinstancepEmpSurname;
    }
    
    public void setEmployeeeditinstancepEmpSurname(String employeeeditinstancepEmpSurname) {
        this.employeeeditinstancepEmpSurname = employeeeditinstancepEmpSurname;
    }

    private void checkEmployeeeditinstancepEmpSurname() throws NotNullArgumentException {
        if(this.getEmployeeeditinstancepEmpSurname() == null) {
            throw new NotNullArgumentException(EmployeeConstants.SERV_ID_EDITINSTANCE, EmployeeConstants.CLASS_ID, EmployeeConstants.ARG_ID_EDITINSTANCE_EMPLOYEEEDITINSTANCEPEMPSURNAME, EmployeeConstants.SERV_ALIAS_EDITINSTANCE, EmployeeConstants.CLASS_ALIAS, EmployeeConstants.ARG_ALIAS_EDITINSTANCE_EMPLOYEEEDITINSTANCEPEMPSURNAME);
        }
    }

    @JsonIgnore
    public String getEmployeeeditinstancepSite() {
        return this.employeeeditinstancepSite;
    }
    
    public void setEmployeeeditinstancepSite(String employeeeditinstancepSite) {
        this.employeeeditinstancepSite = employeeeditinstancepSite;
    }

    private void checkEmployeeeditinstancepSite() throws NotNullArgumentException {
        if(this.getEmployeeeditinstancepSite() == null) {
            throw new NotNullArgumentException(EmployeeConstants.SERV_ID_EDITINSTANCE, EmployeeConstants.CLASS_ID, EmployeeConstants.ARG_ID_EDITINSTANCE_EMPLOYEEEDITINSTANCEPSITE, EmployeeConstants.SERV_ALIAS_EDITINSTANCE, EmployeeConstants.CLASS_ALIAS, EmployeeConstants.ARG_ALIAS_EDITINSTANCE_EMPLOYEEEDITINSTANCEPSITE);
        }
    }

    @JsonIgnore
    public String getEmployeeeditinstancepPhoneNumbers() {
        return this.employeeeditinstancepPhoneNumbers;
    }
    
    public void setEmployeeeditinstancepPhoneNumbers(String employeeeditinstancepPhoneNumbers) {
        this.employeeeditinstancepPhoneNumbers = employeeeditinstancepPhoneNumbers;
    }

    @JsonIgnore
    public String getEmployeeeditinstancepemail() {
        return this.employeeeditinstancepemail;
    }
    
    public void setEmployeeeditinstancepemail(String employeeeditinstancepemail) {
        this.employeeeditinstancepemail = employeeeditinstancepemail;
    }

    private void checkEmployeeeditinstancepemail() throws NotNullArgumentException {
        if(this.getEmployeeeditinstancepemail() == null) {
            throw new NotNullArgumentException(EmployeeConstants.SERV_ID_EDITINSTANCE, EmployeeConstants.CLASS_ID, EmployeeConstants.ARG_ID_EDITINSTANCE_EMPLOYEEEDITINSTANCEPEMAIL, EmployeeConstants.SERV_ALIAS_EDITINSTANCE, EmployeeConstants.CLASS_ALIAS, EmployeeConstants.ARG_ALIAS_EDITINSTANCE_EMPLOYEEEDITINSTANCEPEMAIL);
        }
    }
}
