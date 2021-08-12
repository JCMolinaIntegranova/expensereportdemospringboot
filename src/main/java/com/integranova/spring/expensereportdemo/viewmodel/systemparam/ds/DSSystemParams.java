package com.integranova.spring.expensereportdemo.viewmodel.systemparam.ds;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.persistence.SystemParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.systemparam.ds.DSSystemParams")
public class DSSystemParams {

    @ApiModelProperty(name = "Code")
    @JsonProperty("paramcode")
    private String dSSystemParamsParamCode;

    @ApiModelProperty(name = "Name")
    @JsonProperty("name")
    private String dSSystemParamsName;

    @ApiModelProperty(name = "Type")
    @JsonProperty("typename")
    private String dSSystemParamsTypeName;

    @ApiModelProperty(name = "Value")
    @JsonProperty("paramvalue")
    private String dSSystemParamsParamValue;

    @ApiModelProperty(name = "Description")
    @JsonProperty("description")
    private String dSSystemParamsDescription;

    public DSSystemParams() {
    
    }
    
    public DSSystemParams(SystemParam instance) {
        if (instance != null) {
            this.dSSystemParamsParamCode = instance.getSystemParamparamCode();
            this.dSSystemParamsName = instance.getSystemParamname();
            this.dSSystemParamsTypeName = instance.getSystemParamtypeName();
            this.dSSystemParamsParamValue = instance.getSystemParamparamValue();
            this.dSSystemParamsDescription = instance.getSystemParamdescription();
        }
    }

    public String getDSSystemParamsParamCode() {
        return this.dSSystemParamsParamCode;
    }
    
    public void setDSSystemParamsParamCode(String dSSystemParamsParamCode) {
        this.dSSystemParamsParamCode = dSSystemParamsParamCode;
    }

    public String getDSSystemParamsName() {
        return this.dSSystemParamsName;
    }
    
    public void setDSSystemParamsName(String dSSystemParamsName) {
        this.dSSystemParamsName = dSSystemParamsName;
    }

    public String getDSSystemParamsTypeName() {
        return this.dSSystemParamsTypeName;
    }
    
    public void setDSSystemParamsTypeName(String dSSystemParamsTypeName) {
        this.dSSystemParamsTypeName = dSSystemParamsTypeName;
    }

    public String getDSSystemParamsParamValue() {
        return this.dSSystemParamsParamValue;
    }
    
    public void setDSSystemParamsParamValue(String dSSystemParamsParamValue) {
        this.dSSystemParamsParamValue = dSSystemParamsParamValue;
    }

    public String getDSSystemParamsDescription() {
        return this.dSSystemParamsDescription;
    }
    
    public void setDSSystemParamsDescription(String dSSystemParamsDescription) {
        this.dSSystemParamsDescription = dSSystemParamsDescription;
    }
}
