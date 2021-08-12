package com.integranova.spring.expensereportdemo.viewmodel.systemparam.crud;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SystemParamPutViewModel {

    @JsonProperty(value="name")
    private String systemParamname;

    @JsonProperty(value="description")
    private String systemParamdescription;

    @JsonProperty(value="typeName")
    private String systemParamtypeName;

    @JsonProperty(value="paramValue")
    private String systemParamparamValue;

    public String getSystemParamname() {
        return systemParamname;
    }
    
    public void setSystemParamname(String systemParamname) {
        this.systemParamname = systemParamname;
    }

    public String getSystemParamdescription() {
        return systemParamdescription;
    }
    
    public void setSystemParamdescription(String systemParamdescription) {
        this.systemParamdescription = systemParamdescription;
    }

    public String getSystemParamtypeName() {
        return systemParamtypeName;
    }
    
    public void setSystemParamtypeName(String systemParamtypeName) {
        this.systemParamtypeName = systemParamtypeName;
    }

    public String getSystemParamparamValue() {
        return systemParamparamValue;
    }
    
    public void setSystemParamparamValue(String systemParamparamValue) {
        this.systemParamparamValue = systemParamparamValue;
    }
}
