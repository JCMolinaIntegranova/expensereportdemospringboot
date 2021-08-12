package com.integranova.spring.expensereportdemo.viewmodel.employee.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.EmployeeConstants;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.oid.EmployeeOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.employee.siu.DeleteinstanceRequest")
public class DeleteinstanceRequest {

    @ApiModelProperty(name = "Employee")
    @JsonProperty("p_thisemployee_oid")
    private EmployeeOid employeedeleteinstancepthisEmployee;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Employee employeedeleteinstancepthisEmployeeInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkEmployeedeleteinstancepthisEmployee();
    }

    @JsonIgnore
    public EmployeeOid getEmployeedeleteinstancepthisEmployee() {
        return this.employeedeleteinstancepthisEmployee;
    }
    
    public void setEmployeedeleteinstancepthisEmployee(EmployeeOid employeedeleteinstancepthisEmployee) {
        this.employeedeleteinstancepthisEmployee = employeedeleteinstancepthisEmployee;
    }

    @JsonIgnore
    public Employee getEmployeedeleteinstancepthisEmployeeInstance() {
        return this.employeedeleteinstancepthisEmployeeInstance;
    }
    
    public void setEmployeedeleteinstancepthisEmployeeInstance(Employee employeedeleteinstancepthisEmployee) {
        this.employeedeleteinstancepthisEmployeeInstance = employeedeleteinstancepthisEmployee;
    }

    private void checkEmployeedeleteinstancepthisEmployee() throws NotNullArgumentException {
        if(this.getEmployeedeleteinstancepthisEmployeeInstance() == null || this.getEmployeedeleteinstancepthisEmployeeInstance().isNull()) {
            throw new NotNullArgumentException(EmployeeConstants.SERV_ID_DELETEINSTANCE, EmployeeConstants.CLASS_ID, EmployeeConstants.ARG_ID_DELETEINSTANCE_EMPLOYEEDELETEINSTANCEPTHISEMPLOYEE, EmployeeConstants.SERV_ALIAS_DELETEINSTANCE, EmployeeConstants.CLASS_ALIAS, EmployeeConstants.ARG_ALIAS_DELETEINSTANCE_EMPLOYEEDELETEINSTANCEPTHISEMPLOYEE);
        }
    }
}
