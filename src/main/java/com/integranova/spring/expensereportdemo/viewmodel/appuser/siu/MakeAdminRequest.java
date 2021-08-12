package com.integranova.spring.expensereportdemo.viewmodel.appuser.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.AppUserConstants;
import com.integranova.spring.expensereportdemo.persistence.AppUser;
import com.integranova.spring.expensereportdemo.persistence.oid.AppUserOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.MakeAdminRequest")
public class MakeAdminRequest {

    @ApiModelProperty(name = "User")
    @JsonProperty("p_thisappuser_oid")
    private AppUserOid appUsermakeAdminpthisAppUser;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private AppUser appUsermakeAdminpthisAppUserInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkAppUsermakeAdminpthisAppUser();
    }

    @JsonIgnore
    public AppUserOid getAppUsermakeAdminpthisAppUser() {
        return this.appUsermakeAdminpthisAppUser;
    }
    
    public void setAppUsermakeAdminpthisAppUser(AppUserOid appUsermakeAdminpthisAppUser) {
        this.appUsermakeAdminpthisAppUser = appUsermakeAdminpthisAppUser;
    }

    @JsonIgnore
    public AppUser getAppUsermakeAdminpthisAppUserInstance() {
        return this.appUsermakeAdminpthisAppUserInstance;
    }
    
    public void setAppUsermakeAdminpthisAppUserInstance(AppUser appUsermakeAdminpthisAppUser) {
        this.appUsermakeAdminpthisAppUserInstance = appUsermakeAdminpthisAppUser;
    }

    private void checkAppUsermakeAdminpthisAppUser() throws NotNullArgumentException {
        if(this.getAppUsermakeAdminpthisAppUserInstance() == null || this.getAppUsermakeAdminpthisAppUserInstance().isNull()) {
            throw new NotNullArgumentException(AppUserConstants.SERV_ID_MAKEADMIN, AppUserConstants.CLASS_ID, AppUserConstants.ARG_ID_MAKEADMIN_APPUSERMAKEADMINPTHISAPPUSER, AppUserConstants.SERV_ALIAS_MAKEADMIN, AppUserConstants.CLASS_ALIAS, AppUserConstants.ARG_ALIAS_MAKEADMIN_APPUSERMAKEADMINPTHISAPPUSER);
        }
    }
}
