package com.integranova.spring.expensereportdemo.viewmodel.project.ds;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.persistence.Project;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.project.ds.DSProject")
public class DSProject {

    @ApiModelProperty(name = "Project Code")
    @JsonProperty("idproject")
    private Long dSProjectIdProject;

    @ApiModelProperty(name = "Name")
    @JsonProperty("projectname")
    private String dSProjectProjectName;

    @ApiModelProperty(name = "Team")
    @JsonProperty("team_name")
    private String dSProjectTeamDotName;

    @ApiModelProperty(name = "Description")
    @JsonProperty("prodescription")
    private String dSProjectProDescription;

    @ApiModelProperty(name = "Total Expenses")
    @JsonProperty("totexpenses")
    private Double dSProjectTotExpenses;

    @ApiModelProperty(name = "Max Expense")
    @JsonProperty("maxexpense")
    private Double dSProjectMaxExpense;

    @ApiModelProperty(name = "Min Expense")
    @JsonProperty("minexpense")
    private Double dSProjectMinExpense;

    @ApiModelProperty(name = "Avg Expense")
    @JsonProperty("avgexpense")
    private Double dSProjectAvgExpense;

    public DSProject() {
    
    }
    
    public DSProject(Project instance) {
        if (instance != null) {
            try {
                this.dSProjectIdProject = instance.getProjectidProject();
                this.dSProjectProjectName = instance.getProjectProjectName();
                this.dSProjectTeamDotName = instance.getTeam().getTeamname();
                this.dSProjectProDescription = instance.getProjectProDescription();
                this.dSProjectTotExpenses = instance.getProjectTotExpenses();
                this.dSProjectMaxExpense = instance.getProjectMaxExpense();
                this.dSProjectMinExpense = instance.getProjectMinExpense();
                this.dSProjectAvgExpense = instance.getProjectAvgExpense();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    public Long getDSProjectIdProject() {
        return this.dSProjectIdProject;
    }
    
    public void setDSProjectIdProject(Long dSProjectIdProject) {
        this.dSProjectIdProject = dSProjectIdProject;
    }

    public String getDSProjectProjectName() {
        return this.dSProjectProjectName;
    }
    
    public void setDSProjectProjectName(String dSProjectProjectName) {
        this.dSProjectProjectName = dSProjectProjectName;
    }

    public String getDSProjectTeamDotName() {
        return this.dSProjectTeamDotName;
    }
    
    public void setDSProjectTeamDotName(String dSProjectTeamDotName) {
        this.dSProjectTeamDotName = dSProjectTeamDotName;
    }

    public String getDSProjectProDescription() {
        return this.dSProjectProDescription;
    }
    
    public void setDSProjectProDescription(String dSProjectProDescription) {
        this.dSProjectProDescription = dSProjectProDescription;
    }

    public Double getDSProjectTotExpenses() {
        return this.dSProjectTotExpenses;
    }
    
    public void setDSProjectTotExpenses(Double dSProjectTotExpenses) {
        this.dSProjectTotExpenses = dSProjectTotExpenses;
    }

    public Double getDSProjectMaxExpense() {
        return this.dSProjectMaxExpense;
    }
    
    public void setDSProjectMaxExpense(Double dSProjectMaxExpense) {
        this.dSProjectMaxExpense = dSProjectMaxExpense;
    }

    public Double getDSProjectMinExpense() {
        return this.dSProjectMinExpense;
    }
    
    public void setDSProjectMinExpense(Double dSProjectMinExpense) {
        this.dSProjectMinExpense = dSProjectMinExpense;
    }

    public Double getDSProjectAvgExpense() {
        return this.dSProjectAvgExpense;
    }
    
    public void setDSProjectAvgExpense(Double dSProjectAvgExpense) {
        this.dSProjectAvgExpense = dSProjectAvgExpense;
    }
}
