package com.integranova.spring.expensereportdemo.viewmodel.appuser.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.AppUserConstants;
import com.integranova.spring.expensereportdemo.persistence.AppUser;
import com.integranova.spring.expensereportdemo.persistence.oid.AppUserOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.TDELETERequest")
public class TDELETERequest {

    @ApiModelProperty(name = "User")
    @JsonProperty("p_thisappuser_oid")
    private AppUserOid appUserTDELETEpthisAppUser;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private AppUser appUserTDELETEpthisAppUserInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkAppUserTDELETEpthisAppUser();
    }

    @JsonIgnore
    public AppUserOid getAppUserTDELETEpthisAppUser() {
        return this.appUserTDELETEpthisAppUser;
    }
    
    public void setAppUserTDELETEpthisAppUser(AppUserOid appUserTDELETEpthisAppUser) {
        this.appUserTDELETEpthisAppUser = appUserTDELETEpthisAppUser;
    }

    @JsonIgnore
    public AppUser getAppUserTDELETEpthisAppUserInstance() {
        return this.appUserTDELETEpthisAppUserInstance;
    }
    
    public void setAppUserTDELETEpthisAppUserInstance(AppUser appUserTDELETEpthisAppUser) {
        this.appUserTDELETEpthisAppUserInstance = appUserTDELETEpthisAppUser;
    }

    private void checkAppUserTDELETEpthisAppUser() throws NotNullArgumentException {
        if(this.getAppUserTDELETEpthisAppUserInstance() == null || this.getAppUserTDELETEpthisAppUserInstance().isNull()) {
            throw new NotNullArgumentException(AppUserConstants.SERV_ID_TDELETE, AppUserConstants.CLASS_ID, AppUserConstants.ARG_ID_TDELETE_APPUSERTDELETEPTHISAPPUSER, AppUserConstants.SERV_ALIAS_TDELETE, AppUserConstants.CLASS_ALIAS, AppUserConstants.ARG_ALIAS_TDELETE_APPUSERTDELETEPTHISAPPUSER);
        }
    }
}
