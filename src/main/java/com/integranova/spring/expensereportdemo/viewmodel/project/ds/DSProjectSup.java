package com.integranova.spring.expensereportdemo.viewmodel.project.ds;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.persistence.Project;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.project.ds.DSProjectSup")
public class DSProjectSup {

    @ApiModelProperty(name = "Name")
    @JsonProperty("projectname")
    private String dSProjectSupProjectName;

    public DSProjectSup() {
    
    }
    
    public DSProjectSup(Project instance) {
        if (instance != null) {
            this.dSProjectSupProjectName = instance.getProjectProjectName();
        }
    }

    public String getDSProjectSupProjectName() {
        return this.dSProjectSupProjectName;
    }
    
    public void setDSProjectSupProjectName(String dSProjectSupProjectName) {
        this.dSProjectSupProjectName = dSProjectSupProjectName;
    }
}
