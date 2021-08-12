package com.integranova.spring.expensereportdemo.viewmodel.appuser.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.AppUserConstants;
import com.integranova.spring.expensereportdemo.persistence.AppUser;
import com.integranova.spring.expensereportdemo.persistence.oid.AppUserOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.MakeOperatorRequest")
public class MakeOperatorRequest {

    @ApiModelProperty(name = "User")
    @JsonProperty("p_thisappuser_oid")
    private AppUserOid appUsermakeOperatorpthisAppUser;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private AppUser appUsermakeOperatorpthisAppUserInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkAppUsermakeOperatorpthisAppUser();
    }

    @JsonIgnore
    public AppUserOid getAppUsermakeOperatorpthisAppUser() {
        return this.appUsermakeOperatorpthisAppUser;
    }
    
    public void setAppUsermakeOperatorpthisAppUser(AppUserOid appUsermakeOperatorpthisAppUser) {
        this.appUsermakeOperatorpthisAppUser = appUsermakeOperatorpthisAppUser;
    }

    @JsonIgnore
    public AppUser getAppUsermakeOperatorpthisAppUserInstance() {
        return this.appUsermakeOperatorpthisAppUserInstance;
    }
    
    public void setAppUsermakeOperatorpthisAppUserInstance(AppUser appUsermakeOperatorpthisAppUser) {
        this.appUsermakeOperatorpthisAppUserInstance = appUsermakeOperatorpthisAppUser;
    }

    private void checkAppUsermakeOperatorpthisAppUser() throws NotNullArgumentException {
        if(this.getAppUsermakeOperatorpthisAppUserInstance() == null || this.getAppUsermakeOperatorpthisAppUserInstance().isNull()) {
            throw new NotNullArgumentException(AppUserConstants.SERV_ID_MAKEOPERATOR, AppUserConstants.CLASS_ID, AppUserConstants.ARG_ID_MAKEOPERATOR_APPUSERMAKEOPERATORPTHISAPPUSER, AppUserConstants.SERV_ALIAS_MAKEOPERATOR, AppUserConstants.CLASS_ALIAS, AppUserConstants.ARG_ALIAS_MAKEOPERATOR_APPUSERMAKEOPERATORPTHISAPPUSER);
        }
    }
}
