package com.integranova.spring.expensereportdemo.viewmodel.employee.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.EmployeeConstants;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.oid.EmployeeOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.employee.siu.TDELETERequest")
public class TDELETERequest {

    @ApiModelProperty(name = "Employee")
    @JsonProperty("p_thisemployee_oid")
    private EmployeeOid employeeTDELETEpthisEmployee;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Employee employeeTDELETEpthisEmployeeInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkEmployeeTDELETEpthisEmployee();
    }

    @JsonIgnore
    public EmployeeOid getEmployeeTDELETEpthisEmployee() {
        return this.employeeTDELETEpthisEmployee;
    }
    
    public void setEmployeeTDELETEpthisEmployee(EmployeeOid employeeTDELETEpthisEmployee) {
        this.employeeTDELETEpthisEmployee = employeeTDELETEpthisEmployee;
    }

    @JsonIgnore
    public Employee getEmployeeTDELETEpthisEmployeeInstance() {
        return this.employeeTDELETEpthisEmployeeInstance;
    }
    
    public void setEmployeeTDELETEpthisEmployeeInstance(Employee employeeTDELETEpthisEmployee) {
        this.employeeTDELETEpthisEmployeeInstance = employeeTDELETEpthisEmployee;
    }

    private void checkEmployeeTDELETEpthisEmployee() throws NotNullArgumentException {
        if(this.getEmployeeTDELETEpthisEmployeeInstance() == null || this.getEmployeeTDELETEpthisEmployeeInstance().isNull()) {
            throw new NotNullArgumentException(EmployeeConstants.SERV_ID_TDELETE, EmployeeConstants.CLASS_ID, EmployeeConstants.ARG_ID_TDELETE_EMPLOYEETDELETEPTHISEMPLOYEE, EmployeeConstants.SERV_ALIAS_TDELETE, EmployeeConstants.CLASS_ALIAS, EmployeeConstants.ARG_ALIAS_TDELETE_EMPLOYEETDELETEPTHISEMPLOYEE);
        }
    }
}
