package com.integranova.spring.expensereportdemo.viewmodel.systemparam.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.SystemParamConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.SystemParamOid;
import com.integranova.spring.expensereportdemo.persistence.SystemParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.systemparam.siu.DeleteinstanceRequest")
public class DeleteinstanceRequest {

    @ApiModelProperty(name = "System Parameter")
    @JsonProperty("p_thissystemparam_oid")
    private SystemParamOid systemParamdeleteinstancepthisSystemParam;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private SystemParam systemParamdeleteinstancepthisSystemParamInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSystemParamdeleteinstancepthisSystemParam();
    }

    @JsonIgnore
    public SystemParamOid getSystemParamdeleteinstancepthisSystemParam() {
        return this.systemParamdeleteinstancepthisSystemParam;
    }
    
    public void setSystemParamdeleteinstancepthisSystemParam(SystemParamOid systemParamdeleteinstancepthisSystemParam) {
        this.systemParamdeleteinstancepthisSystemParam = systemParamdeleteinstancepthisSystemParam;
    }

    @JsonIgnore
    public SystemParam getSystemParamdeleteinstancepthisSystemParamInstance() {
        return this.systemParamdeleteinstancepthisSystemParamInstance;
    }
    
    public void setSystemParamdeleteinstancepthisSystemParamInstance(SystemParam systemParamdeleteinstancepthisSystemParam) {
        this.systemParamdeleteinstancepthisSystemParamInstance = systemParamdeleteinstancepthisSystemParam;
    }

    private void checkSystemParamdeleteinstancepthisSystemParam() throws NotNullArgumentException {
        if(this.getSystemParamdeleteinstancepthisSystemParamInstance() == null || this.getSystemParamdeleteinstancepthisSystemParamInstance().isNull()) {
            throw new NotNullArgumentException(SystemParamConstants.SERV_ID_DELETEINSTANCE, SystemParamConstants.CLASS_ID, SystemParamConstants.ARG_ID_DELETEINSTANCE_SYSTEMPARAMDELETEINSTANCEPTHISSYSTEMPARAM, SystemParamConstants.SERV_ALIAS_DELETEINSTANCE, SystemParamConstants.CLASS_ALIAS, SystemParamConstants.ARG_ALIAS_DELETEINSTANCE_SYSTEMPARAMDELETEINSTANCEPTHISSYSTEMPARAM);
        }
    }
}
