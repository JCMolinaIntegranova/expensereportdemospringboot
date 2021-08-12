package com.integranova.spring.expensereportdemo.viewmodel.assignment.crud;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Date;

public class AssignmentPostViewModel {

    @JsonProperty(value="FromDate")
    private Date assignmentFromDate;

    public Date getAssignmentFromDate() {
        return assignmentFromDate;
    }
    
    public void setAssignmentFromDate(Date assignmentFromDate) {
        this.assignmentFromDate = assignmentFromDate;
    }
}
