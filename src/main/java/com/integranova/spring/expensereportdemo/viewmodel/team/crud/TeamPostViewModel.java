package com.integranova.spring.expensereportdemo.viewmodel.team.crud;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamPostViewModel {

    @JsonProperty(value="name")
    private String teamname;

    @JsonProperty(value="maxEmployees")
    private Long teammaxEmployees;

    public String getTeamname() {
        return teamname;
    }
    
    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public Long getTeammaxEmployees() {
        return teammaxEmployees;
    }
    
    public void setTeammaxEmployees(Long teammaxEmployees) {
        this.teammaxEmployees = teammaxEmployees;
    }
}
