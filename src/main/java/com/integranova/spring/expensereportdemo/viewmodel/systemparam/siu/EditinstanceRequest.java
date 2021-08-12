package com.integranova.spring.expensereportdemo.viewmodel.systemparam.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.SystemParamConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.SystemParamOid;
import com.integranova.spring.expensereportdemo.persistence.SystemParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.systemparam.siu.EditinstanceRequest")
public class EditinstanceRequest {

    @ApiModelProperty(name = "System Parameter")
    @JsonProperty("p_thissystemparam_oid")
    private SystemParamOid systemParameditinstancepthisSystemParam;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private SystemParam systemParameditinstancepthisSystemParamInstance;

    @ApiModelProperty(name = "Name")
    @JsonProperty("p_name")
    private String systemParameditinstancepname;

    @ApiModelProperty(name = "Description")
    @JsonProperty("p_description")
    private String systemParameditinstancepdescription;

    @ApiModelProperty(name = "Type")
    @JsonProperty("p_typename")
    private String systemParameditinstanceptypeName;

    @ApiModelProperty(name = "Value")
    @JsonProperty("p_paramvalue")
    private String systemParameditinstancepparamValue;

    public void checkArguments() throws NotNullArgumentException {
        checkSystemParameditinstancepthisSystemParam();
        checkSystemParameditinstancepname();
        checkSystemParameditinstancepdescription();
        checkSystemParameditinstanceptypeName();
        checkSystemParameditinstancepparamValue();
    }

    @JsonIgnore
    public SystemParamOid getSystemParameditinstancepthisSystemParam() {
        return this.systemParameditinstancepthisSystemParam;
    }
    
    public void setSystemParameditinstancepthisSystemParam(SystemParamOid systemParameditinstancepthisSystemParam) {
        this.systemParameditinstancepthisSystemParam = systemParameditinstancepthisSystemParam;
    }

    @JsonIgnore
    public SystemParam getSystemParameditinstancepthisSystemParamInstance() {
        return this.systemParameditinstancepthisSystemParamInstance;
    }
    
    public void setSystemParameditinstancepthisSystemParamInstance(SystemParam systemParameditinstancepthisSystemParam) {
        this.systemParameditinstancepthisSystemParamInstance = systemParameditinstancepthisSystemParam;
    }

    private void checkSystemParameditinstancepthisSystemParam() throws NotNullArgumentException {
        if(this.getSystemParameditinstancepthisSystemParamInstance() == null || this.getSystemParameditinstancepthisSystemParamInstance().isNull()) {
            throw new NotNullArgumentException(SystemParamConstants.SERV_ID_EDITINSTANCE, SystemParamConstants.CLASS_ID, SystemParamConstants.ARG_ID_EDITINSTANCE_SYSTEMPARAMEDITINSTANCEPTHISSYSTEMPARAM, SystemParamConstants.SERV_ALIAS_EDITINSTANCE, SystemParamConstants.CLASS_ALIAS, SystemParamConstants.ARG_ALIAS_EDITINSTANCE_SYSTEMPARAMEDITINSTANCEPTHISSYSTEMPARAM);
        }
    }

    @JsonIgnore
    public String getSystemParameditinstancepname() {
        return this.systemParameditinstancepname;
    }
    
    public void setSystemParameditinstancepname(String systemParameditinstancepname) {
        this.systemParameditinstancepname = systemParameditinstancepname;
    }

    private void checkSystemParameditinstancepname() throws NotNullArgumentException {
        if(this.getSystemParameditinstancepname() == null) {
            throw new NotNullArgumentException(SystemParamConstants.SERV_ID_EDITINSTANCE, SystemParamConstants.CLASS_ID, SystemParamConstants.ARG_ID_EDITINSTANCE_SYSTEMPARAMEDITINSTANCEPNAME, SystemParamConstants.SERV_ALIAS_EDITINSTANCE, SystemParamConstants.CLASS_ALIAS, SystemParamConstants.ARG_ALIAS_EDITINSTANCE_SYSTEMPARAMEDITINSTANCEPNAME);
        }
    }

    @JsonIgnore
    public String getSystemParameditinstancepdescription() {
        return this.systemParameditinstancepdescription;
    }
    
    public void setSystemParameditinstancepdescription(String systemParameditinstancepdescription) {
        this.systemParameditinstancepdescription = systemParameditinstancepdescription;
    }

    private void checkSystemParameditinstancepdescription() throws NotNullArgumentException {
        if(this.getSystemParameditinstancepdescription() == null) {
            throw new NotNullArgumentException(SystemParamConstants.SERV_ID_EDITINSTANCE, SystemParamConstants.CLASS_ID, SystemParamConstants.ARG_ID_EDITINSTANCE_SYSTEMPARAMEDITINSTANCEPDESCRIPTION, SystemParamConstants.SERV_ALIAS_EDITINSTANCE, SystemParamConstants.CLASS_ALIAS, SystemParamConstants.ARG_ALIAS_EDITINSTANCE_SYSTEMPARAMEDITINSTANCEPDESCRIPTION);
        }
    }

    @JsonIgnore
    public String getSystemParameditinstanceptypeName() {
        return this.systemParameditinstanceptypeName;
    }
    
    public void setSystemParameditinstanceptypeName(String systemParameditinstanceptypeName) {
        this.systemParameditinstanceptypeName = systemParameditinstanceptypeName;
    }

    private void checkSystemParameditinstanceptypeName() throws NotNullArgumentException {
        if(this.getSystemParameditinstanceptypeName() == null) {
            throw new NotNullArgumentException(SystemParamConstants.SERV_ID_EDITINSTANCE, SystemParamConstants.CLASS_ID, SystemParamConstants.ARG_ID_EDITINSTANCE_SYSTEMPARAMEDITINSTANCEPTYPENAME, SystemParamConstants.SERV_ALIAS_EDITINSTANCE, SystemParamConstants.CLASS_ALIAS, SystemParamConstants.ARG_ALIAS_EDITINSTANCE_SYSTEMPARAMEDITINSTANCEPTYPENAME);
        }
    }

    @JsonIgnore
    public String getSystemParameditinstancepparamValue() {
        return this.systemParameditinstancepparamValue;
    }
    
    public void setSystemParameditinstancepparamValue(String systemParameditinstancepparamValue) {
        this.systemParameditinstancepparamValue = systemParameditinstancepparamValue;
    }

    private void checkSystemParameditinstancepparamValue() throws NotNullArgumentException {
        if(this.getSystemParameditinstancepparamValue() == null) {
            throw new NotNullArgumentException(SystemParamConstants.SERV_ID_EDITINSTANCE, SystemParamConstants.CLASS_ID, SystemParamConstants.ARG_ID_EDITINSTANCE_SYSTEMPARAMEDITINSTANCEPPARAMVALUE, SystemParamConstants.SERV_ALIAS_EDITINSTANCE, SystemParamConstants.CLASS_ALIAS, SystemParamConstants.ARG_ALIAS_EDITINSTANCE_SYSTEMPARAMEDITINSTANCEPPARAMVALUE);
        }
    }
}
