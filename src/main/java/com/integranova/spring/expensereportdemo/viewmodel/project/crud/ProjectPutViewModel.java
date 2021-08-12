package com.integranova.spring.expensereportdemo.viewmodel.project.crud;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Date;

public class ProjectPutViewModel {

    @JsonProperty(value="ProjectName")
    private String projectProjectName;

    @JsonProperty(value="ProDescription")
    private String projectProDescription;

    @JsonProperty(value="CompletionDate")
    private Date projectCompletionDate;

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

    public Date getProjectCompletionDate() {
        return projectCompletionDate;
    }
    
    public void setProjectCompletionDate(Date projectCompletionDate) {
        this.projectCompletionDate = projectCompletionDate;
    }
}
