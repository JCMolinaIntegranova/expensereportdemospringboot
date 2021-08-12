package com.integranova.spring.expensereportdemo.viewmodel.employee.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.EmployeeConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.employee.siu.CreateinstanceRequest")
public class CreateinstanceRequest {

    @ApiModelProperty(name = "Employee Code")
    @JsonProperty("p_atrid_employee")
    private String employeecreateinstancepatridEmployee;

    @ApiModelProperty(name = "Name")
    @JsonProperty("p_atrempname")
    private String employeecreateinstancepatrEmpName;

    @ApiModelProperty(name = "Surname")
    @JsonProperty("p_atrempsurname")
    private String employeecreateinstancepatrEmpSurname;

    @ApiModelProperty(name = "Site")
    @JsonProperty("p_atrsite")
    private String employeecreateinstancepatrSite;

    @ApiModelProperty(name = "Phone Numbers")
    @JsonProperty("p_atrphonenumbers")
    private String employeecreateinstancepatrPhoneNumbers;

    @ApiModelProperty(name = "E-mail")
    @JsonProperty("p_atremail")
    private String employeecreateinstancepatremail;

    @ApiModelProperty(name = "Picture")
    @JsonProperty("p_atrpicture")
    private byte[] employeecreateinstancepatrPicture;

    public void checkArguments() throws NotNullArgumentException {
        checkEmployeecreateinstancepatridEmployee();
        checkEmployeecreateinstancepatrEmpName();
        checkEmployeecreateinstancepatrEmpSurname();
        checkEmployeecreateinstancepatrSite();
        checkEmployeecreateinstancepatremail();
    }

    @JsonIgnore
    public String getEmployeecreateinstancepatridEmployee() {
        return this.employeecreateinstancepatridEmployee;
    }
    
    public void setEmployeecreateinstancepatridEmployee(String employeecreateinstancepatridEmployee) {
        this.employeecreateinstancepatridEmployee = employeecreateinstancepatridEmployee;
    }

    private void checkEmployeecreateinstancepatridEmployee() throws NotNullArgumentException {
        if(this.getEmployeecreateinstancepatridEmployee() == null) {
            throw new NotNullArgumentException(EmployeeConstants.SERV_ID_CREATEINSTANCE, EmployeeConstants.CLASS_ID, EmployeeConstants.ARG_ID_CREATEINSTANCE_EMPLOYEECREATEINSTANCEPATRIDEMPLOYEE, EmployeeConstants.SERV_ALIAS_CREATEINSTANCE, EmployeeConstants.CLASS_ALIAS, EmployeeConstants.ARG_ALIAS_CREATEINSTANCE_EMPLOYEECREATEINSTANCEPATRIDEMPLOYEE);
        }
    }

    @JsonIgnore
    public String getEmployeecreateinstancepatrEmpName() {
        return this.employeecreateinstancepatrEmpName;
    }
    
    public void setEmployeecreateinstancepatrEmpName(String employeecreateinstancepatrEmpName) {
        this.employeecreateinstancepatrEmpName = employeecreateinstancepatrEmpName;
    }

    private void checkEmployeecreateinstancepatrEmpName() throws NotNullArgumentException {
        if(this.getEmployeecreateinstancepatrEmpName() == null) {
            throw new NotNullArgumentException(EmployeeConstants.SERV_ID_CREATEINSTANCE, EmployeeConstants.CLASS_ID, EmployeeConstants.ARG_ID_CREATEINSTANCE_EMPLOYEECREATEINSTANCEPATREMPNAME, EmployeeConstants.SERV_ALIAS_CREATEINSTANCE, EmployeeConstants.CLASS_ALIAS, EmployeeConstants.ARG_ALIAS_CREATEINSTANCE_EMPLOYEECREATEINSTANCEPATREMPNAME);
        }
    }

    @JsonIgnore
    public String getEmployeecreateinstancepatrEmpSurname() {
        return this.employeecreateinstancepatrEmpSurname;
    }
    
    public void setEmployeecreateinstancepatrEmpSurname(String employeecreateinstancepatrEmpSurname) {
        this.employeecreateinstancepatrEmpSurname = employeecreateinstancepatrEmpSurname;
    }

    private void checkEmployeecreateinstancepatrEmpSurname() throws NotNullArgumentException {
        if(this.getEmployeecreateinstancepatrEmpSurname() == null) {
            throw new NotNullArgumentException(EmployeeConstants.SERV_ID_CREATEINSTANCE, EmployeeConstants.CLASS_ID, EmployeeConstants.ARG_ID_CREATEINSTANCE_EMPLOYEECREATEINSTANCEPATREMPSURNAME, EmployeeConstants.SERV_ALIAS_CREATEINSTANCE, EmployeeConstants.CLASS_ALIAS, EmployeeConstants.ARG_ALIAS_CREATEINSTANCE_EMPLOYEECREATEINSTANCEPATREMPSURNAME);
        }
    }

    @JsonIgnore
    public String getEmployeecreateinstancepatrSite() {
        return this.employeecreateinstancepatrSite;
    }
    
    public void setEmployeecreateinstancepatrSite(String employeecreateinstancepatrSite) {
        this.employeecreateinstancepatrSite = employeecreateinstancepatrSite;
    }

    private void checkEmployeecreateinstancepatrSite() throws NotNullArgumentException {
        if(this.getEmployeecreateinstancepatrSite() == null) {
            throw new NotNullArgumentException(EmployeeConstants.SERV_ID_CREATEINSTANCE, EmployeeConstants.CLASS_ID, EmployeeConstants.ARG_ID_CREATEINSTANCE_EMPLOYEECREATEINSTANCEPATRSITE, EmployeeConstants.SERV_ALIAS_CREATEINSTANCE, EmployeeConstants.CLASS_ALIAS, EmployeeConstants.ARG_ALIAS_CREATEINSTANCE_EMPLOYEECREATEINSTANCEPATRSITE);
        }
    }

    @JsonIgnore
    public String getEmployeecreateinstancepatrPhoneNumbers() {
        return this.employeecreateinstancepatrPhoneNumbers;
    }
    
    public void setEmployeecreateinstancepatrPhoneNumbers(String employeecreateinstancepatrPhoneNumbers) {
        this.employeecreateinstancepatrPhoneNumbers = employeecreateinstancepatrPhoneNumbers;
    }

    @JsonIgnore
    public String getEmployeecreateinstancepatremail() {
        return this.employeecreateinstancepatremail;
    }
    
    public void setEmployeecreateinstancepatremail(String employeecreateinstancepatremail) {
        this.employeecreateinstancepatremail = employeecreateinstancepatremail;
    }

    private void checkEmployeecreateinstancepatremail() throws NotNullArgumentException {
        if(this.getEmployeecreateinstancepatremail() == null) {
            throw new NotNullArgumentException(EmployeeConstants.SERV_ID_CREATEINSTANCE, EmployeeConstants.CLASS_ID, EmployeeConstants.ARG_ID_CREATEINSTANCE_EMPLOYEECREATEINSTANCEPATREMAIL, EmployeeConstants.SERV_ALIAS_CREATEINSTANCE, EmployeeConstants.CLASS_ALIAS, EmployeeConstants.ARG_ALIAS_CREATEINSTANCE_EMPLOYEECREATEINSTANCEPATREMAIL);
        }
    }

    @JsonIgnore
    public byte[] getEmployeecreateinstancepatrPicture() {
        return this.employeecreateinstancepatrPicture;
    }
    
    public void setEmployeecreateinstancepatrPicture(byte[] employeecreateinstancepatrPicture) {
        this.employeecreateinstancepatrPicture = employeecreateinstancepatrPicture;
    }
}
