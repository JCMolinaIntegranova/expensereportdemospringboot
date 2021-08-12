package com.integranova.spring.expensereportdemo.viewmodel.employee.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.EmployeeConstants;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.oid.EmployeeOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.employee.siu.ChangePictureRequest")
public class ChangePictureRequest {

    @ApiModelProperty(name = "Employee")
    @JsonProperty("p_thisemployee_oid")
    private EmployeeOid employeechangePicturepthisEmployee;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Employee employeechangePicturepthisEmployeeInstance;

    @ApiModelProperty(name = "Picture")
    @JsonProperty("p_picture")
    private byte[] employeechangePicturepPicture;

    public void checkArguments() throws NotNullArgumentException {
        checkEmployeechangePicturepthisEmployee();
    }

    @JsonIgnore
    public EmployeeOid getEmployeechangePicturepthisEmployee() {
        return this.employeechangePicturepthisEmployee;
    }
    
    public void setEmployeechangePicturepthisEmployee(EmployeeOid employeechangePicturepthisEmployee) {
        this.employeechangePicturepthisEmployee = employeechangePicturepthisEmployee;
    }

    @JsonIgnore
    public Employee getEmployeechangePicturepthisEmployeeInstance() {
        return this.employeechangePicturepthisEmployeeInstance;
    }
    
    public void setEmployeechangePicturepthisEmployeeInstance(Employee employeechangePicturepthisEmployee) {
        this.employeechangePicturepthisEmployeeInstance = employeechangePicturepthisEmployee;
    }

    private void checkEmployeechangePicturepthisEmployee() throws NotNullArgumentException {
        if(this.getEmployeechangePicturepthisEmployeeInstance() == null || this.getEmployeechangePicturepthisEmployeeInstance().isNull()) {
            throw new NotNullArgumentException(EmployeeConstants.SERV_ID_CHANGEPICTURE, EmployeeConstants.CLASS_ID, EmployeeConstants.ARG_ID_CHANGEPICTURE_EMPLOYEECHANGEPICTUREPTHISEMPLOYEE, EmployeeConstants.SERV_ALIAS_CHANGEPICTURE, EmployeeConstants.CLASS_ALIAS, EmployeeConstants.ARG_ALIAS_CHANGEPICTURE_EMPLOYEECHANGEPICTUREPTHISEMPLOYEE);
        }
    }

    @JsonIgnore
    public byte[] getEmployeechangePicturepPicture() {
        return this.employeechangePicturepPicture;
    }
    
    public void setEmployeechangePicturepPicture(byte[] employeechangePicturepPicture) {
        this.employeechangePicturepPicture = employeechangePicturepPicture;
    }
}
