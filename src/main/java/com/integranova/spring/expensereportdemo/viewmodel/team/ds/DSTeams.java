package com.integranova.spring.expensereportdemo.viewmodel.team.ds;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.persistence.Team;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.team.ds.DSTeams")
public class DSTeams {

    @ApiModelProperty(name = "Team ID")
    @JsonProperty("id")
    private Long dSTeamsId;

    @ApiModelProperty(name = "Name")
    @JsonProperty("name")
    private String dSTeamsName;

    @ApiModelProperty(name = "Max Employees")
    @JsonProperty("maxemployees")
    private Long dSTeamsMaxEmployees;

    @ApiModelProperty(name = "# employees")
    @JsonProperty("countemployees")
    private Long dSTeamsCountEmployees;

    @ApiModelProperty(name = "Total expenses")
    @JsonProperty("totalexpenses")
    private Double dSTeamsTotalExpenses;

    public DSTeams() {
    
    }
    
    public DSTeams(Team instance) {
        if (instance != null) {
            try {
                this.dSTeamsId = instance.getTeamid();
                this.dSTeamsName = instance.getTeamname();
                this.dSTeamsMaxEmployees = instance.getTeammaxEmployees();
                this.dSTeamsCountEmployees = instance.getTeamcountEmployees();
                this.dSTeamsTotalExpenses = instance.getTeamtotalExpenses();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    public Long getDSTeamsId() {
        return this.dSTeamsId;
    }
    
    public void setDSTeamsId(Long dSTeamsId) {
        this.dSTeamsId = dSTeamsId;
    }

    public String getDSTeamsName() {
        return this.dSTeamsName;
    }
    
    public void setDSTeamsName(String dSTeamsName) {
        this.dSTeamsName = dSTeamsName;
    }

    public Long getDSTeamsMaxEmployees() {
        return this.dSTeamsMaxEmployees;
    }
    
    public void setDSTeamsMaxEmployees(Long dSTeamsMaxEmployees) {
        this.dSTeamsMaxEmployees = dSTeamsMaxEmployees;
    }

    public Long getDSTeamsCountEmployees() {
        return this.dSTeamsCountEmployees;
    }
    
    public void setDSTeamsCountEmployees(Long dSTeamsCountEmployees) {
        this.dSTeamsCountEmployees = dSTeamsCountEmployees;
    }

    public Double getDSTeamsTotalExpenses() {
        return this.dSTeamsTotalExpenses;
    }
    
    public void setDSTeamsTotalExpenses(Double dSTeamsTotalExpenses) {
        this.dSTeamsTotalExpenses = dSTeamsTotalExpenses;
    }
}
