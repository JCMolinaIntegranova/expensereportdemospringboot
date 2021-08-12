package com.integranova.spring.expensereportdemo.viewmodel.appuser.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.AppUserConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.TNEWUSERRequest")
public class TNEWUSERRequest {

    @ApiModelProperty(name = "Login")
    @JsonProperty("plogin")
    private String appUserTNEWUSERpLogin;

    @ApiModelProperty(name = "Name")
    @JsonProperty("pname")
    private String appUserTNEWUSERpName;

    @ApiModelProperty(name = "Surname")
    @JsonProperty("psurname")
    private String appUserTNEWUSERpSurname;

    @ApiModelProperty(name = "Type")
    @JsonProperty("ptype")
    private String appUserTNEWUSERpType;

    @ApiModelProperty(name = "Password")
    @JsonProperty("ppassword")
    private String appUserTNEWUSERpPassword;

    public void checkArguments() throws NotNullArgumentException {
        checkAppUserTNEWUSERpLogin();
        checkAppUserTNEWUSERpName();
        checkAppUserTNEWUSERpSurname();
        checkAppUserTNEWUSERpType();
        checkAppUserTNEWUSERpPassword();
    }

    @JsonIgnore
    public String getAppUserTNEWUSERpLogin() {
        return this.appUserTNEWUSERpLogin;
    }
    
    public void setAppUserTNEWUSERpLogin(String appUserTNEWUSERpLogin) {
        this.appUserTNEWUSERpLogin = appUserTNEWUSERpLogin;
    }

    private void checkAppUserTNEWUSERpLogin() throws NotNullArgumentException {
        if(this.getAppUserTNEWUSERpLogin() == null) {
            throw new NotNullArgumentException(AppUserConstants.SERV_ID_TNEWUSER, AppUserConstants.CLASS_ID, AppUserConstants.ARG_ID_TNEWUSER_APPUSERTNEWUSERPLOGIN, AppUserConstants.SERV_ALIAS_TNEWUSER, AppUserConstants.CLASS_ALIAS, AppUserConstants.ARG_ALIAS_TNEWUSER_APPUSERTNEWUSERPLOGIN);
        }
    }

    @JsonIgnore
    public String getAppUserTNEWUSERpName() {
        return this.appUserTNEWUSERpName;
    }
    
    public void setAppUserTNEWUSERpName(String appUserTNEWUSERpName) {
        this.appUserTNEWUSERpName = appUserTNEWUSERpName;
    }

    private void checkAppUserTNEWUSERpName() throws NotNullArgumentException {
        if(this.getAppUserTNEWUSERpName() == null) {
            throw new NotNullArgumentException(AppUserConstants.SERV_ID_TNEWUSER, AppUserConstants.CLASS_ID, AppUserConstants.ARG_ID_TNEWUSER_APPUSERTNEWUSERPNAME, AppUserConstants.SERV_ALIAS_TNEWUSER, AppUserConstants.CLASS_ALIAS, AppUserConstants.ARG_ALIAS_TNEWUSER_APPUSERTNEWUSERPNAME);
        }
    }

    @JsonIgnore
    public String getAppUserTNEWUSERpSurname() {
        return this.appUserTNEWUSERpSurname;
    }
    
    public void setAppUserTNEWUSERpSurname(String appUserTNEWUSERpSurname) {
        this.appUserTNEWUSERpSurname = appUserTNEWUSERpSurname;
    }

    private void checkAppUserTNEWUSERpSurname() throws NotNullArgumentException {
        if(this.getAppUserTNEWUSERpSurname() == null) {
            throw new NotNullArgumentException(AppUserConstants.SERV_ID_TNEWUSER, AppUserConstants.CLASS_ID, AppUserConstants.ARG_ID_TNEWUSER_APPUSERTNEWUSERPSURNAME, AppUserConstants.SERV_ALIAS_TNEWUSER, AppUserConstants.CLASS_ALIAS, AppUserConstants.ARG_ALIAS_TNEWUSER_APPUSERTNEWUSERPSURNAME);
        }
    }

    @JsonIgnore
    public String getAppUserTNEWUSERpType() {
        return this.appUserTNEWUSERpType;
    }
    
    public void setAppUserTNEWUSERpType(String appUserTNEWUSERpType) {
        this.appUserTNEWUSERpType = appUserTNEWUSERpType;
    }

    private void checkAppUserTNEWUSERpType() throws NotNullArgumentException {
        if(this.getAppUserTNEWUSERpType() == null) {
            throw new NotNullArgumentException(AppUserConstants.SERV_ID_TNEWUSER, AppUserConstants.CLASS_ID, AppUserConstants.ARG_ID_TNEWUSER_APPUSERTNEWUSERPTYPE, AppUserConstants.SERV_ALIAS_TNEWUSER, AppUserConstants.CLASS_ALIAS, AppUserConstants.ARG_ALIAS_TNEWUSER_APPUSERTNEWUSERPTYPE);
        }
    }

    @JsonIgnore
    public String getAppUserTNEWUSERpPassword() {
        return this.appUserTNEWUSERpPassword;
    }
    
    public void setAppUserTNEWUSERpPassword(String appUserTNEWUSERpPassword) {
        this.appUserTNEWUSERpPassword = appUserTNEWUSERpPassword;
    }

    private void checkAppUserTNEWUSERpPassword() throws NotNullArgumentException {
        if(this.getAppUserTNEWUSERpPassword() == null) {
            throw new NotNullArgumentException(AppUserConstants.SERV_ID_TNEWUSER, AppUserConstants.CLASS_ID, AppUserConstants.ARG_ID_TNEWUSER_APPUSERTNEWUSERPP4SSW0RD, AppUserConstants.SERV_ALIAS_TNEWUSER, AppUserConstants.CLASS_ALIAS, AppUserConstants.ARG_ALIAS_TNEWUSER_APPUSERTNEWUSERPP4SSW0RD);
        }
    }
}
