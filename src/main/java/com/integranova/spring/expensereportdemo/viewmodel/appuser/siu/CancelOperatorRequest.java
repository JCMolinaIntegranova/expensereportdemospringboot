package com.integranova.spring.expensereportdemo.viewmodel.appuser.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.AppUserConstants;
import com.integranova.spring.expensereportdemo.persistence.AppUser;
import com.integranova.spring.expensereportdemo.persistence.oid.AppUserOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.CancelOperatorRequest")
public class CancelOperatorRequest {

    @ApiModelProperty(name = "User")
    @JsonProperty("p_thisappuser_oid")
    private AppUserOid appUsercancelOperatorpthisAppUser;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private AppUser appUsercancelOperatorpthisAppUserInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkAppUsercancelOperatorpthisAppUser();
    }

    @JsonIgnore
    public AppUserOid getAppUsercancelOperatorpthisAppUser() {
        return this.appUsercancelOperatorpthisAppUser;
    }
    
    public void setAppUsercancelOperatorpthisAppUser(AppUserOid appUsercancelOperatorpthisAppUser) {
        this.appUsercancelOperatorpthisAppUser = appUsercancelOperatorpthisAppUser;
    }

    @JsonIgnore
    public AppUser getAppUsercancelOperatorpthisAppUserInstance() {
        return this.appUsercancelOperatorpthisAppUserInstance;
    }
    
    public void setAppUsercancelOperatorpthisAppUserInstance(AppUser appUsercancelOperatorpthisAppUser) {
        this.appUsercancelOperatorpthisAppUserInstance = appUsercancelOperatorpthisAppUser;
    }

    private void checkAppUsercancelOperatorpthisAppUser() throws NotNullArgumentException {
        if(this.getAppUsercancelOperatorpthisAppUserInstance() == null || this.getAppUsercancelOperatorpthisAppUserInstance().isNull()) {
            throw new NotNullArgumentException(AppUserConstants.SERV_ID_CANCELOPERATOR, AppUserConstants.CLASS_ID, AppUserConstants.ARG_ID_CANCELOPERATOR_APPUSERCANCELOPERATORPTHISAPPUSER, AppUserConstants.SERV_ALIAS_CANCELOPERATOR, AppUserConstants.CLASS_ALIAS, AppUserConstants.ARG_ALIAS_CANCELOPERATOR_APPUSERCANCELOPERATORPTHISAPPUSER);
        }
    }
}
