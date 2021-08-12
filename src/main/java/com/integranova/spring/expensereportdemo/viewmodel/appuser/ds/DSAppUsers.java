package com.integranova.spring.expensereportdemo.viewmodel.appuser.ds;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.persistence.AppUser;
import com.integranova.spring.expensereportdemo.persistence.AdminUser;
import com.integranova.spring.expensereportdemo.persistence.OperatorUser;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.appuser.ds.DSAppUsers")
public class DSAppUsers {

    @ApiModelProperty(name = "Login")
    @JsonProperty("login")
    private String dSAppUsersLogin;

    @ApiModelProperty(name = "Surname")
    @JsonProperty("usersurname")
    private String dSAppUsersUserSurname;

    @ApiModelProperty(name = "Name")
    @JsonProperty("username")
    private String dSAppUsersUserName;

    @ApiModelProperty(name = "Type")
    @JsonProperty("usertype")
    private String dSAppUsersUserType;

    public DSAppUsers() {
    
    }
    
    public DSAppUsers(AppUser instance) {
        if (instance != null) {
            this.dSAppUsersLogin = instance.getAppUserLogin();
            this.dSAppUsersUserSurname = instance.getAppUserUserSurname();
            this.dSAppUsersUserName = instance.getAppUserUserName();
            this.dSAppUsersUserType = instance.getAppUserUserType();
        }
    }

    public DSAppUsers(AdminUser instance) {
        if (instance != null) {
            this.dSAppUsersLogin = instance.getAppUserLogin();
            this.dSAppUsersUserSurname = instance.getAppUserUserSurname();
            this.dSAppUsersUserName = instance.getAppUserUserName();
            this.dSAppUsersUserType = instance.getAppUserUserType();
        }
    }

    public DSAppUsers(OperatorUser instance) {
        if (instance != null) {
            this.dSAppUsersLogin = instance.getAppUserLogin();
            this.dSAppUsersUserSurname = instance.getAppUserUserSurname();
            this.dSAppUsersUserName = instance.getAppUserUserName();
            this.dSAppUsersUserType = instance.getAppUserUserType();
        }
    }

    public String getDSAppUsersLogin() {
        return this.dSAppUsersLogin;
    }
    
    public void setDSAppUsersLogin(String dSAppUsersLogin) {
        this.dSAppUsersLogin = dSAppUsersLogin;
    }

    public String getDSAppUsersUserSurname() {
        return this.dSAppUsersUserSurname;
    }
    
    public void setDSAppUsersUserSurname(String dSAppUsersUserSurname) {
        this.dSAppUsersUserSurname = dSAppUsersUserSurname;
    }

    public String getDSAppUsersUserName() {
        return this.dSAppUsersUserName;
    }
    
    public void setDSAppUsersUserName(String dSAppUsersUserName) {
        this.dSAppUsersUserName = dSAppUsersUserName;
    }

    public String getDSAppUsersUserType() {
        return this.dSAppUsersUserType;
    }
    
    public void setDSAppUsersUserType(String dSAppUsersUserType) {
        this.dSAppUsersUserType = dSAppUsersUserType;
    }
}
