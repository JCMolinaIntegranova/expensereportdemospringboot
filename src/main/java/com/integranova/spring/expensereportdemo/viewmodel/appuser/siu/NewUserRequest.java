package com.integranova.spring.expensereportdemo.viewmodel.appuser.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.AppUserConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.NewUserRequest")
public class NewUserRequest {

    @ApiModelProperty(name = "Login")
    @JsonProperty("p_atrlogin")
    private String appUsernewUserpatrLogin;

    @ApiModelProperty(name = "Name")
    @JsonProperty("p_atrusername")
    private String appUsernewUserpatrUserName;

    @ApiModelProperty(name = "Surname")
    @JsonProperty("p_atrusersurname")
    private String appUsernewUserpatrUserSurname;

    @ApiModelProperty(name = "Type")
    @JsonProperty("p_atrusertype")
    private String appUsernewUserpatrUserType;

    @ApiModelProperty(name = "password")
    @JsonProperty("p_password")
    private String appUsernewUserppassword;

    public void checkArguments() throws NotNullArgumentException {
        checkAppUsernewUserpatrLogin();
        checkAppUsernewUserpatrUserName();
        checkAppUsernewUserpatrUserSurname();
        checkAppUsernewUserpatrUserType();
        checkAppUsernewUserppassword();
    }

    @JsonIgnore
    public String getAppUsernewUserpatrLogin() {
        return this.appUsernewUserpatrLogin;
    }
    
    public void setAppUsernewUserpatrLogin(String appUsernewUserpatrLogin) {
        this.appUsernewUserpatrLogin = appUsernewUserpatrLogin;
    }

    private void checkAppUsernewUserpatrLogin() throws NotNullArgumentException {
        if(this.getAppUsernewUserpatrLogin() == null) {
            throw new NotNullArgumentException(AppUserConstants.SERV_ID_NEWUSER, AppUserConstants.CLASS_ID, AppUserConstants.ARG_ID_NEWUSER_APPUSERNEWUSERPATRLOGIN, AppUserConstants.SERV_ALIAS_NEWUSER, AppUserConstants.CLASS_ALIAS, AppUserConstants.ARG_ALIAS_NEWUSER_APPUSERNEWUSERPATRLOGIN);
        }
    }

    @JsonIgnore
    public String getAppUsernewUserpatrUserName() {
        return this.appUsernewUserpatrUserName;
    }
    
    public void setAppUsernewUserpatrUserName(String appUsernewUserpatrUserName) {
        this.appUsernewUserpatrUserName = appUsernewUserpatrUserName;
    }

    private void checkAppUsernewUserpatrUserName() throws NotNullArgumentException {
        if(this.getAppUsernewUserpatrUserName() == null) {
            throw new NotNullArgumentException(AppUserConstants.SERV_ID_NEWUSER, AppUserConstants.CLASS_ID, AppUserConstants.ARG_ID_NEWUSER_APPUSERNEWUSERPATRUSERNAME, AppUserConstants.SERV_ALIAS_NEWUSER, AppUserConstants.CLASS_ALIAS, AppUserConstants.ARG_ALIAS_NEWUSER_APPUSERNEWUSERPATRUSERNAME);
        }
    }

    @JsonIgnore
    public String getAppUsernewUserpatrUserSurname() {
        return this.appUsernewUserpatrUserSurname;
    }
    
    public void setAppUsernewUserpatrUserSurname(String appUsernewUserpatrUserSurname) {
        this.appUsernewUserpatrUserSurname = appUsernewUserpatrUserSurname;
    }

    private void checkAppUsernewUserpatrUserSurname() throws NotNullArgumentException {
        if(this.getAppUsernewUserpatrUserSurname() == null) {
            throw new NotNullArgumentException(AppUserConstants.SERV_ID_NEWUSER, AppUserConstants.CLASS_ID, AppUserConstants.ARG_ID_NEWUSER_APPUSERNEWUSERPATRUSERSURNAME, AppUserConstants.SERV_ALIAS_NEWUSER, AppUserConstants.CLASS_ALIAS, AppUserConstants.ARG_ALIAS_NEWUSER_APPUSERNEWUSERPATRUSERSURNAME);
        }
    }

    @JsonIgnore
    public String getAppUsernewUserpatrUserType() {
        return this.appUsernewUserpatrUserType;
    }
    
    public void setAppUsernewUserpatrUserType(String appUsernewUserpatrUserType) {
        this.appUsernewUserpatrUserType = appUsernewUserpatrUserType;
    }

    private void checkAppUsernewUserpatrUserType() throws NotNullArgumentException {
        if(this.getAppUsernewUserpatrUserType() == null) {
            throw new NotNullArgumentException(AppUserConstants.SERV_ID_NEWUSER, AppUserConstants.CLASS_ID, AppUserConstants.ARG_ID_NEWUSER_APPUSERNEWUSERPATRUSERTYPE, AppUserConstants.SERV_ALIAS_NEWUSER, AppUserConstants.CLASS_ALIAS, AppUserConstants.ARG_ALIAS_NEWUSER_APPUSERNEWUSERPATRUSERTYPE);
        }
    }

    @JsonIgnore
    public String getAppUsernewUserppassword() {
        return this.appUsernewUserppassword;
    }
    
    public void setAppUsernewUserppassword(String appUsernewUserppassword) {
        this.appUsernewUserppassword = appUsernewUserppassword;
    }

    private void checkAppUsernewUserppassword() throws NotNullArgumentException {
        if(this.getAppUsernewUserppassword() == null) {
            throw new NotNullArgumentException(AppUserConstants.SERV_ID_NEWUSER, AppUserConstants.CLASS_ID, AppUserConstants.ARG_ID_NEWUSER_APPUSERNEWUSERPP4SSW0RD, AppUserConstants.SERV_ALIAS_NEWUSER, AppUserConstants.CLASS_ALIAS, AppUserConstants.ARG_ALIAS_NEWUSER_APPUSERNEWUSERPP4SSW0RD);
        }
    }
}
