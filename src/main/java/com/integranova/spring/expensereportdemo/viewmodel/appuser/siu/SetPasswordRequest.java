package com.integranova.spring.expensereportdemo.viewmodel.appuser.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.AppUserConstants;
import com.integranova.spring.expensereportdemo.persistence.AppUser;
import com.integranova.spring.expensereportdemo.persistence.oid.AppUserOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.SetPasswordRequest")
public class SetPasswordRequest {

    @ApiModelProperty(name = "User")
    @JsonProperty("p_thisappuser_oid")
    private AppUserOid appUsersetPasswordpthisAppUser;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private AppUser appUsersetPasswordpthisAppUserInstance;

    @ApiModelProperty(name = "New password")
    @JsonProperty("p_newpassword")
    private String appUsersetPasswordpNewPassword;

    public void checkArguments() throws NotNullArgumentException {
        checkAppUsersetPasswordpthisAppUser();
        checkAppUsersetPasswordpNewPassword();
    }

    @JsonIgnore
    public AppUserOid getAppUsersetPasswordpthisAppUser() {
        return this.appUsersetPasswordpthisAppUser;
    }
    
    public void setAppUsersetPasswordpthisAppUser(AppUserOid appUsersetPasswordpthisAppUser) {
        this.appUsersetPasswordpthisAppUser = appUsersetPasswordpthisAppUser;
    }

    @JsonIgnore
    public AppUser getAppUsersetPasswordpthisAppUserInstance() {
        return this.appUsersetPasswordpthisAppUserInstance;
    }
    
    public void setAppUsersetPasswordpthisAppUserInstance(AppUser appUsersetPasswordpthisAppUser) {
        this.appUsersetPasswordpthisAppUserInstance = appUsersetPasswordpthisAppUser;
    }

    private void checkAppUsersetPasswordpthisAppUser() throws NotNullArgumentException {
        if(this.getAppUsersetPasswordpthisAppUserInstance() == null || this.getAppUsersetPasswordpthisAppUserInstance().isNull()) {
            throw new NotNullArgumentException(AppUserConstants.SERV_ID_SETP4SSW0RD, AppUserConstants.CLASS_ID, AppUserConstants.ARG_ID_SETP4SSW0RD_APPUSERSETP4SSW0RDPTHISAPPUSER, AppUserConstants.SERV_ALIAS_SETP4SSW0RD, AppUserConstants.CLASS_ALIAS, AppUserConstants.ARG_ALIAS_SETP4SSW0RD_APPUSERSETP4SSW0RDPTHISAPPUSER);
        }
    }

    @JsonIgnore
    public String getAppUsersetPasswordpNewPassword() {
        return this.appUsersetPasswordpNewPassword;
    }
    
    public void setAppUsersetPasswordpNewPassword(String appUsersetPasswordpNewPassword) {
        this.appUsersetPasswordpNewPassword = appUsersetPasswordpNewPassword;
    }

    private void checkAppUsersetPasswordpNewPassword() throws NotNullArgumentException {
        if(this.getAppUsersetPasswordpNewPassword() == null) {
            throw new NotNullArgumentException(AppUserConstants.SERV_ID_SETP4SSW0RD, AppUserConstants.CLASS_ID, AppUserConstants.ARG_ID_SETP4SSW0RD_APPUSERSETP4SSW0RDPNEWP4SSW0RD, AppUserConstants.SERV_ALIAS_SETP4SSW0RD, AppUserConstants.CLASS_ALIAS, AppUserConstants.ARG_ALIAS_SETP4SSW0RD_APPUSERSETP4SSW0RDPNEWP4SSW0RD);
        }
    }
}
