package com.integranova.spring.expensereportdemo.viewmodel.systemparam.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.SystemParamConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.systemparam.siu.CreateinstanceRequest")
public class CreateinstanceRequest {

    @ApiModelProperty(name = "Code")
    @JsonProperty("p_atrparamcode")
    private String systemParamcreateinstancepatrparamCode;

    @ApiModelProperty(name = "Name")
    @JsonProperty("p_atrname")
    private String systemParamcreateinstancepatrname;

    @ApiModelProperty(name = "Description")
    @JsonProperty("p_atrdescription")
    private String systemParamcreateinstancepatrdescription;

    @ApiModelProperty(name = "Type")
    @JsonProperty("p_atrtypename")
    private String systemParamcreateinstancepatrtypeName;

    @ApiModelProperty(name = "Value")
    @JsonProperty("p_atrparamvalue")
    private String systemParamcreateinstancepatrparamValue;

    public void checkArguments() throws NotNullArgumentException {
        checkSystemParamcreateinstancepatrparamCode();
        checkSystemParamcreateinstancepatrname();
        checkSystemParamcreateinstancepatrdescription();
        checkSystemParamcreateinstancepatrtypeName();
        checkSystemParamcreateinstancepatrparamValue();
    }

    @JsonIgnore
    public String getSystemParamcreateinstancepatrparamCode() {
        return this.systemParamcreateinstancepatrparamCode;
    }
    
    public void setSystemParamcreateinstancepatrparamCode(String systemParamcreateinstancepatrparamCode) {
        this.systemParamcreateinstancepatrparamCode = systemParamcreateinstancepatrparamCode;
    }

    private void checkSystemParamcreateinstancepatrparamCode() throws NotNullArgumentException {
        if(this.getSystemParamcreateinstancepatrparamCode() == null) {
            throw new NotNullArgumentException(SystemParamConstants.SERV_ID_CREATEINSTANCE, SystemParamConstants.CLASS_ID, SystemParamConstants.ARG_ID_CREATEINSTANCE_SYSTEMPARAMCREATEINSTANCEPATRPARAMCODE, SystemParamConstants.SERV_ALIAS_CREATEINSTANCE, SystemParamConstants.CLASS_ALIAS, SystemParamConstants.ARG_ALIAS_CREATEINSTANCE_SYSTEMPARAMCREATEINSTANCEPATRPARAMCODE);
        }
    }

    @JsonIgnore
    public String getSystemParamcreateinstancepatrname() {
        return this.systemParamcreateinstancepatrname;
    }
    
    public void setSystemParamcreateinstancepatrname(String systemParamcreateinstancepatrname) {
        this.systemParamcreateinstancepatrname = systemParamcreateinstancepatrname;
    }

    private void checkSystemParamcreateinstancepatrname() throws NotNullArgumentException {
        if(this.getSystemParamcreateinstancepatrname() == null) {
            throw new NotNullArgumentException(SystemParamConstants.SERV_ID_CREATEINSTANCE, SystemParamConstants.CLASS_ID, SystemParamConstants.ARG_ID_CREATEINSTANCE_SYSTEMPARAMCREATEINSTANCEPATRNAME, SystemParamConstants.SERV_ALIAS_CREATEINSTANCE, SystemParamConstants.CLASS_ALIAS, SystemParamConstants.ARG_ALIAS_CREATEINSTANCE_SYSTEMPARAMCREATEINSTANCEPATRNAME);
        }
    }

    @JsonIgnore
    public String getSystemParamcreateinstancepatrdescription() {
        return this.systemParamcreateinstancepatrdescription;
    }
    
    public void setSystemParamcreateinstancepatrdescription(String systemParamcreateinstancepatrdescription) {
        this.systemParamcreateinstancepatrdescription = systemParamcreateinstancepatrdescription;
    }

    private void checkSystemParamcreateinstancepatrdescription() throws NotNullArgumentException {
        if(this.getSystemParamcreateinstancepatrdescription() == null) {
            throw new NotNullArgumentException(SystemParamConstants.SERV_ID_CREATEINSTANCE, SystemParamConstants.CLASS_ID, SystemParamConstants.ARG_ID_CREATEINSTANCE_SYSTEMPARAMCREATEINSTANCEPATRDESCRIPTION, SystemParamConstants.SERV_ALIAS_CREATEINSTANCE, SystemParamConstants.CLASS_ALIAS, SystemParamConstants.ARG_ALIAS_CREATEINSTANCE_SYSTEMPARAMCREATEINSTANCEPATRDESCRIPTION);
        }
    }

    @JsonIgnore
    public String getSystemParamcreateinstancepatrtypeName() {
        return this.systemParamcreateinstancepatrtypeName;
    }
    
    public void setSystemParamcreateinstancepatrtypeName(String systemParamcreateinstancepatrtypeName) {
        this.systemParamcreateinstancepatrtypeName = systemParamcreateinstancepatrtypeName;
    }

    private void checkSystemParamcreateinstancepatrtypeName() throws NotNullArgumentException {
        if(this.getSystemParamcreateinstancepatrtypeName() == null) {
            throw new NotNullArgumentException(SystemParamConstants.SERV_ID_CREATEINSTANCE, SystemParamConstants.CLASS_ID, SystemParamConstants.ARG_ID_CREATEINSTANCE_SYSTEMPARAMCREATEINSTANCEPATRTYPENAME, SystemParamConstants.SERV_ALIAS_CREATEINSTANCE, SystemParamConstants.CLASS_ALIAS, SystemParamConstants.ARG_ALIAS_CREATEINSTANCE_SYSTEMPARAMCREATEINSTANCEPATRTYPENAME);
        }
    }

    @JsonIgnore
    public String getSystemParamcreateinstancepatrparamValue() {
        return this.systemParamcreateinstancepatrparamValue;
    }
    
    public void setSystemParamcreateinstancepatrparamValue(String systemParamcreateinstancepatrparamValue) {
        this.systemParamcreateinstancepatrparamValue = systemParamcreateinstancepatrparamValue;
    }

    private void checkSystemParamcreateinstancepatrparamValue() throws NotNullArgumentException {
        if(this.getSystemParamcreateinstancepatrparamValue() == null) {
            throw new NotNullArgumentException(SystemParamConstants.SERV_ID_CREATEINSTANCE, SystemParamConstants.CLASS_ID, SystemParamConstants.ARG_ID_CREATEINSTANCE_SYSTEMPARAMCREATEINSTANCEPATRPARAMVALUE, SystemParamConstants.SERV_ALIAS_CREATEINSTANCE, SystemParamConstants.CLASS_ALIAS, SystemParamConstants.ARG_ALIAS_CREATEINSTANCE_SYSTEMPARAMCREATEINSTANCEPATRPARAMVALUE);
        }
    }
}
