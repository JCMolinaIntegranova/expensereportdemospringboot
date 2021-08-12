package com.integranova.spring.expensereportdemo.viewmodel.appuser.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.AppUserConstants;
import com.integranova.spring.expensereportdemo.persistence.AppUser;
import com.integranova.spring.expensereportdemo.persistence.oid.AppUserOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.CancelAdminRequest")
public class CancelAdminRequest {

    @ApiModelProperty(name = "User")
    @JsonProperty("p_thisappuser_oid")
    private AppUserOid appUsercancelAdminpthisAppUser;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private AppUser appUsercancelAdminpthisAppUserInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkAppUsercancelAdminpthisAppUser();
    }

    @JsonIgnore
    public AppUserOid getAppUsercancelAdminpthisAppUser() {
        return this.appUsercancelAdminpthisAppUser;
    }
    
    public void setAppUsercancelAdminpthisAppUser(AppUserOid appUsercancelAdminpthisAppUser) {
        this.appUsercancelAdminpthisAppUser = appUsercancelAdminpthisAppUser;
    }

    @JsonIgnore
    public AppUser getAppUsercancelAdminpthisAppUserInstance() {
        return this.appUsercancelAdminpthisAppUserInstance;
    }
    
    public void setAppUsercancelAdminpthisAppUserInstance(AppUser appUsercancelAdminpthisAppUser) {
        this.appUsercancelAdminpthisAppUserInstance = appUsercancelAdminpthisAppUser;
    }

    private void checkAppUsercancelAdminpthisAppUser() throws NotNullArgumentException {
        if(this.getAppUsercancelAdminpthisAppUserInstance() == null || this.getAppUsercancelAdminpthisAppUserInstance().isNull()) {
            throw new NotNullArgumentException(AppUserConstants.SERV_ID_CANCELADMIN, AppUserConstants.CLASS_ID, AppUserConstants.ARG_ID_CANCELADMIN_APPUSERCANCELADMINPTHISAPPUSER, AppUserConstants.SERV_ALIAS_CANCELADMIN, AppUserConstants.CLASS_ALIAS, AppUserConstants.ARG_ALIAS_CANCELADMIN_APPUSERCANCELADMINPTHISAPPUSER);
        }
    }
}
