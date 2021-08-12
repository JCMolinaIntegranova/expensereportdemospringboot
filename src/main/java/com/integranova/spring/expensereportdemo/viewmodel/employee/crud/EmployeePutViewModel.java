package com.integranova.spring.expensereportdemo.viewmodel.employee.crud;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeePutViewModel {

    @JsonProperty(value="EmpName")
    private String employeeEmpName;

    @JsonProperty(value="EmpSurname")
    private String employeeEmpSurname;

    @JsonProperty(value="Site")
    private String employeeSite;

    @JsonProperty(value="PhoneNumbers")
    private String employeePhoneNumbers;

    @JsonProperty(value="email")
    private String employeeemail;

    @JsonProperty(value="Picture")
    private byte[] employeePicture;

    public String getEmployeeEmpName() {
        return employeeEmpName;
    }
    
    public void setEmployeeEmpName(String employeeEmpName) {
        this.employeeEmpName = employeeEmpName;
    }

    public String getEmployeeEmpSurname() {
        return employeeEmpSurname;
    }
    
    public void setEmployeeEmpSurname(String employeeEmpSurname) {
        this.employeeEmpSurname = employeeEmpSurname;
    }

    public String getEmployeeSite() {
        return employeeSite;
    }
    
    public void setEmployeeSite(String employeeSite) {
        this.employeeSite = employeeSite;
    }

    public String getEmployeePhoneNumbers() {
        return employeePhoneNumbers;
    }
    
    public void setEmployeePhoneNumbers(String employeePhoneNumbers) {
        this.employeePhoneNumbers = employeePhoneNumbers;
    }

    public String getEmployeeemail() {
        return employeeemail;
    }
    
    public void setEmployeeemail(String employeeemail) {
        this.employeeemail = employeeemail;
    }

    public byte[] getEmployeePicture() {
        return employeePicture;
    }
    
    public void setEmployeePicture(byte[] employeePicture) {
        this.employeePicture = employeePicture;
    }
}
