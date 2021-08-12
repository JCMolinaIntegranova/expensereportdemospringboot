package com.integranova.spring.expensereportdemo.viewmodel.project.crud;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProjectPostViewModel {

    @JsonProperty(value="ProjectName")
    private String projectProjectName;

    @JsonProperty(value="ProDescription")
    private String projectProDescription;

    public String getProjectProjectName() {
        return projectProjectName;
    }
    
    public void setProjectProjectName(String projectProjectName) {
        this.projectProjectName = projectProjectName;
    }

    public String getProjectProDescription() {
        return projectProDescription;
    }
    
    public void setProjectProDescription(String projectProDescription) {
        this.projectProDescription = projectProDescription;
    }
}
