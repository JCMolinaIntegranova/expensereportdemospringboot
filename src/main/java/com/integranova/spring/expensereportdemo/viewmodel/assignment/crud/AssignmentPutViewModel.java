package com.integranova.spring.expensereportdemo.viewmodel.assignment.crud;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Date;

public class AssignmentPutViewModel {

    @JsonProperty(value="FromDate")
    private Date assignmentFromDate;

    @JsonProperty(value="ToDate")
    private Date assignmentToDate;

    public Date getAssignmentFromDate() {
        return assignmentFromDate;
    }
    
    public void setAssignmentFromDate(Date assignmentFromDate) {
        this.assignmentFromDate = assignmentFromDate;
    }

    public Date getAssignmentToDate() {
        return assignmentToDate;
    }
    
    public void setAssignmentToDate(Date assignmentToDate) {
        this.assignmentToDate = assignmentToDate;
    }
}
