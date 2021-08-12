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

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.assignment.siu.TerminateAssignmentRequest")
public class TerminateAssignmentRequest {

    @ApiModelProperty(name = "Assignment")
    @JsonProperty("p_thisassignment_oid")
    private AssignmentOid assignmentterminateAssignmentpthisAssignment;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Assignment assignmentterminateAssignmentpthisAssignmentInstance;

    @ApiModelProperty(name = "Termination date")
    @JsonProperty("pterminationdate")
    private Date assignmentterminateAssignmentpTerminationDate;

    public void checkArguments() throws NotNullArgumentException {
        checkAssignmentterminateAssignmentpthisAssignment();
        checkAssignmentterminateAssignmentpTerminationDate();
    }

    @JsonIgnore
    public AssignmentOid getAssignmentterminateAssignmentpthisAssignment() {
        return this.assignmentterminateAssignmentpthisAssignment;
    }
    
    public void setAssignmentterminateAssignmentpthisAssignment(AssignmentOid assignmentterminateAssignmentpthisAssignment) {
        this.assignmentterminateAssignmentpthisAssignment = assignmentterminateAssignmentpthisAssignment;
    }

    @JsonIgnore
    public Assignment getAssignmentterminateAssignmentpthisAssignmentInstance() {
        return this.assignmentterminateAssignmentpthisAssignmentInstance;
    }
    
    public void setAssignmentterminateAssignmentpthisAssignmentInstance(Assignment assignmentterminateAssignmentpthisAssignment) {
        this.assignmentterminateAssignmentpthisAssignmentInstance = assignmentterminateAssignmentpthisAssignment;
    }

    private void checkAssignmentterminateAssignmentpthisAssignment() throws NotNullArgumentException {
        if(this.getAssignmentterminateAssignmentpthisAssignmentInstance() == null || this.getAssignmentterminateAssignmentpthisAssignmentInstance().isNull()) {
            throw new NotNullArgumentException(AssignmentConstants.SERV_ID_TERMINATEASSIGNMENT, AssignmentConstants.CLASS_ID, AssignmentConstants.ARG_ID_TERMINATEASSIGNMENT_ASSIGNMENTTERMINATEASSIGNMENTPTHISASSIGNMENT, AssignmentConstants.SERV_ALIAS_TERMINATEASSIGNMENT, AssignmentConstants.CLASS_ALIAS, AssignmentConstants.ARG_ALIAS_TERMINATEASSIGNMENT_ASSIGNMENTTERMINATEASSIGNMENTPTHISASSIGNMENT);
        }
    }

    @JsonIgnore
    public Date getAssignmentterminateAssignmentpTerminationDate() {
        return this.assignmentterminateAssignmentpTerminationDate;
    }
    
    public void setAssignmentterminateAssignmentpTerminationDate(Date assignmentterminateAssignmentpTerminationDate) {
        this.assignmentterminateAssignmentpTerminationDate = assignmentterminateAssignmentpTerminationDate;
    }

    private void checkAssignmentterminateAssignmentpTerminationDate() throws NotNullArgumentException {
        if(this.getAssignmentterminateAssignmentpTerminationDate() == null) {
            throw new NotNullArgumentException(AssignmentConstants.SERV_ID_TERMINATEASSIGNMENT, AssignmentConstants.CLASS_ID, AssignmentConstants.ARG_ID_TERMINATEASSIGNMENT_ASSIGNMENTTERMINATEASSIGNMENTPTERMINATIONDATE, AssignmentConstants.SERV_ALIAS_TERMINATEASSIGNMENT, AssignmentConstants.CLASS_ALIAS, AssignmentConstants.ARG_ALIAS_TERMINATEASSIGNMENT_ASSIGNMENTTERMINATEASSIGNMENTPTERMINATIONDATE);
        }
    }
}
