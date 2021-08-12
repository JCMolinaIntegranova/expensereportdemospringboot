package com.integranova.spring.expensereportdemo.viewmodel.employee.ds;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.persistence.Employee;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.employee.ds.DSEmployeeSup")
public class DSEmployeeSup {

    @ApiModelProperty(name = "Name")
    @JsonProperty("empname")
    private String dSEmployeeSupEmpName;

    @ApiModelProperty(name = "Surname")
    @JsonProperty("empsurname")
    private String dSEmployeeSupEmpSurname;

    public DSEmployeeSup() {
    
    }
    
    public DSEmployeeSup(Employee instance) {
        if (instance != null) {
            this.dSEmployeeSupEmpName = instance.getEmployeeEmpName();
            this.dSEmployeeSupEmpSurname = instance.getEmployeeEmpSurname();
        }
    }

    public String getDSEmployeeSupEmpName() {
        return this.dSEmployeeSupEmpName;
    }
    
    public void setDSEmployeeSupEmpName(String dSEmployeeSupEmpName) {
        this.dSEmployeeSupEmpName = dSEmployeeSupEmpName;
    }

    public String getDSEmployeeSupEmpSurname() {
        return this.dSEmployeeSupEmpSurname;
    }
    
    public void setDSEmployeeSupEmpSurname(String dSEmployeeSupEmpSurname) {
        this.dSEmployeeSupEmpSurname = dSEmployeeSupEmpSurname;
    }
}
