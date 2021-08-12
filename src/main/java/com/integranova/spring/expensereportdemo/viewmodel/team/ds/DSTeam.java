package com.integranova.spring.expensereportdemo.viewmodel.team.ds;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.persistence.Team;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.team.ds.DSTeam")
public class DSTeam {

    @ApiModelProperty(name = "Team ID")
    @JsonProperty("id")
    private Long dSTeamId;

    @ApiModelProperty(name = "Name")
    @JsonProperty("name")
    private String dSTeamName;

    @ApiModelProperty(name = "Max Employees")
    @JsonProperty("maxemployees")
    private Long dSTeamMaxEmployees;

    @ApiModelProperty(name = "# employees")
    @JsonProperty("countemployees")
    private Long dSTeamCountEmployees;

    @ApiModelProperty(name = "Total expenses")
    @JsonProperty("totalexpenses")
    private Double dSTeamTotalExpenses;

    public DSTeam() {
    
    }
    
    public DSTeam(Team instance) {
        if (instance != null) {
            try {
                this.dSTeamId = instance.getTeamid();
                this.dSTeamName = instance.getTeamname();
                this.dSTeamMaxEmployees = instance.getTeammaxEmployees();
                this.dSTeamCountEmployees = instance.getTeamcountEmployees();
                this.dSTeamTotalExpenses = instance.getTeamtotalExpenses();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    public Long getDSTeamId() {
        return this.dSTeamId;
    }
    
    public void setDSTeamId(Long dSTeamId) {
        this.dSTeamId = dSTeamId;
    }

    public String getDSTeamName() {
        return this.dSTeamName;
    }
    
    public void setDSTeamName(String dSTeamName) {
        this.dSTeamName = dSTeamName;
    }

    public Long getDSTeamMaxEmployees() {
        return this.dSTeamMaxEmployees;
    }
    
    public void setDSTeamMaxEmployees(Long dSTeamMaxEmployees) {
        this.dSTeamMaxEmployees = dSTeamMaxEmployees;
    }

    public Long getDSTeamCountEmployees() {
        return this.dSTeamCountEmployees;
    }
    
    public void setDSTeamCountEmployees(Long dSTeamCountEmployees) {
        this.dSTeamCountEmployees = dSTeamCountEmployees;
    }

    public Double getDSTeamTotalExpenses() {
        return this.dSTeamTotalExpenses;
    }
    
    public void setDSTeamTotalExpenses(Double dSTeamTotalExpenses) {
        this.dSTeamTotalExpenses = dSTeamTotalExpenses;
    }
}
