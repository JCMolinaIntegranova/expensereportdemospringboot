package com.integranova.spring.expensereportdemo.viewmodel.assignment.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.AssignmentConstants;
import com.integranova.spring.expensereportdemo.persistence.Assignment;
import com.integranova.spring.expensereportdemo.persistence.oid.AssignmentOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.sql.Date;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.assignment.siu.EditAssignmentRequest")
public class EditAssignmentRequest {

    @ApiModelProperty(name = "Assignment")
    @JsonProperty("p_thisassignment_oid")
    private AssignmentOid assignmenteditAssignmentpthisAssignment;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Assignment assignmenteditAssignmentpthisAssignmentInstance;

    @ApiModelProperty(name = "From")
    @JsonProperty("p_fromdate")
    private Date assignmenteditAssignmentpFromDate;

    public void checkArguments() throws NotNullArgumentException {
        checkAssignmenteditAssignmentpthisAssignment();
        checkAssignmenteditAssignmentpFromDate();
    }

    @JsonIgnore
    public AssignmentOid getAssignmenteditAssignmentpthisAssignment() {
        return this.assignmenteditAssignmentpthisAssignment;
    }
    
    public void setAssignmenteditAssignmentpthisAssignment(AssignmentOid assignmenteditAssignmentpthisAssignment) {
        this.assignmenteditAssignmentpthisAssignment = assignmenteditAssignmentpthisAssignment;
    }

    @JsonIgnore
    public Assignment getAssignmenteditAssignmentpthisAssignmentInstance() {
        return this.assignmenteditAssignmentpthisAssignmentInstance;
    }
    
    public void setAssignmenteditAssignmentpthisAssignmentInstance(Assignment assignmenteditAssignmentpthisAssignment) {
        this.assignmenteditAssignmentpthisAssignmentInstance = assignmenteditAssignmentpthisAssignment;
    }

    private void checkAssignmenteditAssignmentpthisAssignment() throws NotNullArgumentException {
        if(this.getAssignmenteditAssignmentpthisAssignmentInstance() == null || this.getAssignmenteditAssignmentpthisAssignmentInstance().isNull()) {
            throw new NotNullArgumentException(AssignmentConstants.SERV_ID_EDITASSIGNMENT, AssignmentConstants.CLASS_ID, AssignmentConstants.ARG_ID_EDITASSIGNMENT_ASSIGNMENTEDITASSIGNMENTPTHISASSIGNMENT, AssignmentConstants.SERV_ALIAS_EDITASSIGNMENT, AssignmentConstants.CLASS_ALIAS, AssignmentConstants.ARG_ALIAS_EDITASSIGNMENT_ASSIGNMENTEDITASSIGNMENTPTHISASSIGNMENT);
        }
    }

    @JsonIgnore
    public Date getAssignmenteditAssignmentpFromDate() {
        return this.assignmenteditAssignmentpFromDate;
    }
    
    public void setAssignmenteditAssignmentpFromDate(Date assignmenteditAssignmentpFromDate) {
        this.assignmenteditAssignmentpFromDate = assignmenteditAssignmentpFromDate;
    }

    private void checkAssignmenteditAssignmentpFromDate() throws NotNullArgumentException {
        if(this.getAssignmenteditAssignmentpFromDate() == null) {
            throw new NotNullArgumentException(AssignmentConstants.SERV_ID_EDITASSIGNMENT, AssignmentConstants.CLASS_ID, AssignmentConstants.ARG_ID_EDITASSIGNMENT_ASSIGNMENTEDITASSIGNMENTPFROMDATE, AssignmentConstants.SERV_ALIAS_EDITASSIGNMENT, AssignmentConstants.CLASS_ALIAS, AssignmentConstants.ARG_ALIAS_EDITASSIGNMENT_ASSIGNMENTEDITASSIGNMENTPFROMDATE);
        }
    }
}
