package com.integranova.spring.expensereportdemo.viewmodel.ertemplate.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.integranova.spring.expensereportdemo.global.ERTemplateConstants;
import com.integranova.spring.expensereportdemo.viewmodel.FilterRequest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.ertemplate.filter.FERTemplates")
public class FERTemplates {

    @ApiModelProperty(name = "Name")
    @JsonProperty("vname")
    private String vName;

    @ApiModelProperty(name = "Description")
    @JsonProperty("vdescription")
    private String vDescription;

    @ApiModelProperty(name = "Enabled")
    @JsonProperty("venabled")
    private Boolean vEnabled;

    public FERTemplates() {
        // Default constructor
    }

    @JsonIgnore
    public String getVName() {
        return this.vName;
    }
    
    public void setVName(String vName) {
        this.vName = vName;
    }

    @JsonIgnore
    public String getVDescription() {
        return this.vDescription;
    }
    
    public void setVDescription(String vDescription) {
        this.vDescription = vDescription;
    }

    @JsonIgnore
    public Boolean getVEnabled() {
        return this.vEnabled;
    }
    
    public void setVEnabled(Boolean vEnabled) {
        this.vEnabled = vEnabled;
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(ERTemplateConstants.FILTER_NAME_FERTEMPLATES);
        filterRequest.addFilterVariable(ERTemplateConstants.VAR_NAME_FERTEMPLATES_VNAME, vName);
        filterRequest.addFilterVariable(ERTemplateConstants.VAR_NAME_FERTEMPLATES_VDESCRIPTION, vDescription);
        filterRequest.addFilterVariable(ERTemplateConstants.VAR_NAME_FERTEMPLATES_VENABLED, vEnabled);
        return filterRequest;
    }
}
