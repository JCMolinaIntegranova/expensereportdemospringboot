package com.integranova.spring.expensereportdemo.viewmodel.appuser.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.AppUserConstants;
import com.integranova.spring.expensereportdemo.persistence.AppUser;
import com.integranova.spring.expensereportdemo.persistence.oid.AppUserOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.DeleteUserRequest")
public class DeleteUserRequest {

    @ApiModelProperty(name = "User")
    @JsonProperty("p_thisappuser_oid")
    private AppUserOid appUserdeleteUserpthisAppUser;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private AppUser appUserdeleteUserpthisAppUserInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkAppUserdeleteUserpthisAppUser();
    }

    @JsonIgnore
    public AppUserOid getAppUserdeleteUserpthisAppUser() {
        return this.appUserdeleteUserpthisAppUser;
    }
    
    public void setAppUserdeleteUserpthisAppUser(AppUserOid appUserdeleteUserpthisAppUser) {
        this.appUserdeleteUserpthisAppUser = appUserdeleteUserpthisAppUser;
    }

    @JsonIgnore
    public AppUser getAppUserdeleteUserpthisAppUserInstance() {
        return this.appUserdeleteUserpthisAppUserInstance;
    }
    
    public void setAppUserdeleteUserpthisAppUserInstance(AppUser appUserdeleteUserpthisAppUser) {
        this.appUserdeleteUserpthisAppUserInstance = appUserdeleteUserpthisAppUser;
    }

    private void checkAppUserdeleteUserpthisAppUser() throws NotNullArgumentException {
        if(this.getAppUserdeleteUserpthisAppUserInstance() == null || this.getAppUserdeleteUserpthisAppUserInstance().isNull()) {
            throw new NotNullArgumentException(AppUserConstants.SERV_ID_DELETEUSER, AppUserConstants.CLASS_ID, AppUserConstants.ARG_ID_DELETEUSER_APPUSERDELETEUSERPTHISAPPUSER, AppUserConstants.SERV_ALIAS_DELETEUSER, AppUserConstants.CLASS_ALIAS, AppUserConstants.ARG_ALIAS_DELETEUSER_APPUSERDELETEUSERPTHISAPPUSER);
        }
    }
}
