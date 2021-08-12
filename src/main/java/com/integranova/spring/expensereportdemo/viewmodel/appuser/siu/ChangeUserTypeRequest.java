package com.integranova.spring.expensereportdemo.viewmodel.appuser.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.AppUserConstants;
import com.integranova.spring.expensereportdemo.persistence.AppUser;
import com.integranova.spring.expensereportdemo.persistence.oid.AppUserOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.ChangeUserTypeRequest")
public class ChangeUserTypeRequest {

    @ApiModelProperty(name = "User")
    @JsonProperty("p_thisappuser_oid")
    private AppUserOid appUserchangeUserTypepthisAppUser;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private AppUser appUserchangeUserTypepthisAppUserInstance;

    @ApiModelProperty(name = "New Type")
    @JsonProperty("pnewtype")
    private String appUserchangeUserTypepNewType;

    public void checkArguments() throws NotNullArgumentException {
        checkAppUserchangeUserTypepthisAppUser();
        checkAppUserchangeUserTypepNewType();
    }

    @JsonIgnore
    public AppUserOid getAppUserchangeUserTypepthisAppUser() {
        return this.appUserchangeUserTypepthisAppUser;
    }
    
    public void setAppUserchangeUserTypepthisAppUser(AppUserOid appUserchangeUserTypepthisAppUser) {
        this.appUserchangeUserTypepthisAppUser = appUserchangeUserTypepthisAppUser;
    }

    @JsonIgnore
    public AppUser getAppUserchangeUserTypepthisAppUserInstance() {
        return this.appUserchangeUserTypepthisAppUserInstance;
    }
    
    public void setAppUserchangeUserTypepthisAppUserInstance(AppUser appUserchangeUserTypepthisAppUser) {
        this.appUserchangeUserTypepthisAppUserInstance = appUserchangeUserTypepthisAppUser;
    }

    private void checkAppUserchangeUserTypepthisAppUser() throws NotNullArgumentException {
        if(this.getAppUserchangeUserTypepthisAppUserInstance() == null || this.getAppUserchangeUserTypepthisAppUserInstance().isNull()) {
            throw new NotNullArgumentException(AppUserConstants.SERV_ID_CHANGEUSERTYPE, AppUserConstants.CLASS_ID, AppUserConstants.ARG_ID_CHANGEUSERTYPE_APPUSERCHANGEUSERTYPEPTHISAPPUSER, AppUserConstants.SERV_ALIAS_CHANGEUSERTYPE, AppUserConstants.CLASS_ALIAS, AppUserConstants.ARG_ALIAS_CHANGEUSERTYPE_APPUSERCHANGEUSERTYPEPTHISAPPUSER);
        }
    }

    @JsonIgnore
    public String getAppUserchangeUserTypepNewType() {
        return this.appUserchangeUserTypepNewType;
    }
    
    public void setAppUserchangeUserTypepNewType(String appUserchangeUserTypepNewType) {
        this.appUserchangeUserTypepNewType = appUserchangeUserTypepNewType;
    }

    private void checkAppUserchangeUserTypepNewType() throws NotNullArgumentException {
        if(this.getAppUserchangeUserTypepNewType() == null) {
            throw new NotNullArgumentException(AppUserConstants.SERV_ID_CHANGEUSERTYPE, AppUserConstants.CLASS_ID, AppUserConstants.ARG_ID_CHANGEUSERTYPE_APPUSERCHANGEUSERTYPEPNEWTYPE, AppUserConstants.SERV_ALIAS_CHANGEUSERTYPE, AppUserConstants.CLASS_ALIAS, AppUserConstants.ARG_ALIAS_CHANGEUSERTYPE_APPUSERCHANGEUSERTYPEPNEWTYPE);
        }
    }
}
