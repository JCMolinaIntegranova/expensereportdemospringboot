package com.integranova.spring.expensereportdemo.viewmodel.globalservices.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.GlobalServiceConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.globalservices.siu.GLOBALTESTRequest")
public class GLOBALTESTRequest {

    @ApiModelProperty(name = "Total expenses")
    @JsonProperty("ptotexpenses")
    private Double gLOBALTESTpTotExpenses;

    @ApiModelProperty(name = "Project name")
    @JsonProperty("pprojectname")
    private String gLOBALTESTpProjectName;

    @JsonProperty("preconditionId")
    @ApiModelProperty(hidden = true)
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkGLOBALTESTpTotExpenses();
        checkGLOBALTESTpProjectName();
    }

    @JsonIgnore
    public Double getGLOBALTESTpTotExpenses() {
        return this.gLOBALTESTpTotExpenses;
    }
    
    public void setGLOBALTESTpTotExpenses(Double gLOBALTESTpTotExpenses) {
        this.gLOBALTESTpTotExpenses = gLOBALTESTpTotExpenses;
    }

    private void checkGLOBALTESTpTotExpenses() throws NotNullArgumentException {
        if(this.getGLOBALTESTpTotExpenses() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_GLOBALTEST, GlobalServiceConstants.GS_ARG_ID_GLOBALTEST_GLOBALTESTPTOTEXPENSES, GlobalServiceConstants.G_SERV_ALIAS_GLOBALTEST, GlobalServiceConstants.GS_ARG_ALIAS_GLOBALTEST_GLOBALTESTPTOTEXPENSES);
        }
    }

    @JsonIgnore
    public String getGLOBALTESTpProjectName() {
        return this.gLOBALTESTpProjectName;
    }
    
    public void setGLOBALTESTpProjectName(String gLOBALTESTpProjectName) {
        this.gLOBALTESTpProjectName = gLOBALTESTpProjectName;
    }

    private void checkGLOBALTESTpProjectName() throws NotNullArgumentException {
        if(this.getGLOBALTESTpProjectName() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_GLOBALTEST, GlobalServiceConstants.GS_ARG_ID_GLOBALTEST_GLOBALTESTPPROJECTNAME, GlobalServiceConstants.G_SERV_ALIAS_GLOBALTEST, GlobalServiceConstants.GS_ARG_ALIAS_GLOBALTEST_GLOBALTESTPPROJECTNAME);
        }
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
