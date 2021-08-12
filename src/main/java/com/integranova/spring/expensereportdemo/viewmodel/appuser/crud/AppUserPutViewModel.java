package com.integranova.spring.expensereportdemo.viewmodel.appuser.crud;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AppUserPutViewModel {

    @JsonProperty(value="UserName")
    private String appUserUserName;

    @JsonProperty(value="UserSurname")
    private String appUserUserSurname;

    @JsonProperty(value="UserType")
    private String appUserUserType;

    public String getAppUserUserName() {
        return appUserUserName;
    }
    
    public void setAppUserUserName(String appUserUserName) {
        this.appUserUserName = appUserUserName;
    }

    public String getAppUserUserSurname() {
        return appUserUserSurname;
    }
    
    public void setAppUserUserSurname(String appUserUserSurname) {
        this.appUserUserSurname = appUserUserSurname;
    }

    public String getAppUserUserType() {
        return appUserUserType;
    }
    
    public void setAppUserUserType(String appUserUserType) {
        this.appUserUserType = appUserUserType;
    }
}
