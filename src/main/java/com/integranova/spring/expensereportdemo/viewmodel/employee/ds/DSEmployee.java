package com.integranova.spring.expensereportdemo.viewmodel.employee.ds;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.persistence.Employee;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.employee.ds.DSEmployee")
public class DSEmployee {

    @ApiModelProperty(name = "Employee Code")
    @JsonProperty("idemployee")
    private String dSEmployeeIdEmployee;

    @ApiModelProperty(name = "Picture")
    @JsonProperty("picture")
    private byte[] dSEmployeePicture;

    @ApiModelProperty(name = "Name")
    @JsonProperty("empname")
    private String dSEmployeeEmpName;

    @ApiModelProperty(name = "Surname")
    @JsonProperty("empsurname")
    private String dSEmployeeEmpSurname;

    @ApiModelProperty(name = "Phone Numbers")
    @JsonProperty("phonenumbers")
    private String dSEmployeePhoneNumbers;

    @ApiModelProperty(name = "Site")
    @JsonProperty("site")
    private String dSEmployeeSite;

    @ApiModelProperty(name = "E-mail")
    @JsonProperty("email")
    private String dSEmployeeEmail;

    @ApiModelProperty(name = "# Exp.Reports")
    @JsonProperty("numofexpreports")
    private Long dSEmployeeNumOfExpReports;

    public DSEmployee() {
    
    }
    
    public DSEmployee(Employee instance) {
        if (instance != null) {
            try {
                this.dSEmployeeIdEmployee = instance.getEmployeeidEmployee();
                this.dSEmployeePicture = instance.getEmployeePicture();
                this.dSEmployeeEmpName = instance.getEmployeeEmpName();
                this.dSEmployeeEmpSurname = instance.getEmployeeEmpSurname();
                this.dSEmployeePhoneNumbers = instance.getEmployeePhoneNumbers();
                this.dSEmployeeSite = instance.getEmployeeSite();
                this.dSEmployeeEmail = instance.getEmployeeemail();
                this.dSEmployeeNumOfExpReports = instance.getEmployeeNumOfExpReports();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    public String getDSEmployeeIdEmployee() {
        return this.dSEmployeeIdEmployee;
    }
    
    public void setDSEmployeeIdEmployee(String dSEmployeeIdEmployee) {
        this.dSEmployeeIdEmployee = dSEmployeeIdEmployee;
    }

    public byte[] getDSEmployeePicture() {
        return this.dSEmployeePicture;
    }
    
    public void setDSEmployeePicture(byte[] dSEmployeePicture) {
        this.dSEmployeePicture = dSEmployeePicture;
    }

    public String getDSEmployeeEmpName() {
        return this.dSEmployeeEmpName;
    }
    
    public void setDSEmployeeEmpName(String dSEmployeeEmpName) {
        this.dSEmployeeEmpName = dSEmployeeEmpName;
    }

    public String getDSEmployeeEmpSurname() {
        return this.dSEmployeeEmpSurname;
    }
    
    public void setDSEmployeeEmpSurname(String dSEmployeeEmpSurname) {
        this.dSEmployeeEmpSurname = dSEmployeeEmpSurname;
    }

    public String getDSEmployeePhoneNumbers() {
        return this.dSEmployeePhoneNumbers;
    }
    
    public void setDSEmployeePhoneNumbers(String dSEmployeePhoneNumbers) {
        this.dSEmployeePhoneNumbers = dSEmployeePhoneNumbers;
    }

    public String getDSEmployeeSite() {
        return this.dSEmployeeSite;
    }
    
    public void setDSEmployeeSite(String dSEmployeeSite) {
        this.dSEmployeeSite = dSEmployeeSite;
    }

    public String getDSEmployeeEmail() {
        return this.dSEmployeeEmail;
    }
    
    public void setDSEmployeeEmail(String dSEmployeeEmail) {
        this.dSEmployeeEmail = dSEmployeeEmail;
    }

    public Long getDSEmployeeNumOfExpReports() {
        return this.dSEmployeeNumOfExpReports;
    }
    
    public void setDSEmployeeNumOfExpReports(Long dSEmployeeNumOfExpReports) {
        this.dSEmployeeNumOfExpReports = dSEmployeeNumOfExpReports;
    }
}
