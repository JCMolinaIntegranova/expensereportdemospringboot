package com.integranova.spring.expensereportdemo.viewmodel.assignment.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.AssignmentConstants;
import com.integranova.spring.expensereportdemo.persistence.Assignment;
import com.integranova.spring.expensereportdemo.persistence.oid.AssignmentOid;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("com.integranova.spring.expensereportdemo.viewmodel.assignment.siu.DeleteAssignmentRequest")
public class DeleteAssignmentRequest {

    @ApiModelProperty(name = "Assignment")
    @JsonProperty("p_thisassignment_oid")
    private AssignmentOid assignmentdeleteAssignmentpthisAssignment;
    
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    private Assignment assignmentdeleteAssignmentpthisAssignmentInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkAssignmentdeleteAssignmentpthisAssignment();
    }

    @JsonIgnore
    public AssignmentOid getAssignmentdeleteAssignmentpthisAssignment() {
        return this.assignmentdeleteAssignmentpthisAssignment;
    }
    
    public void setAssignmentdeleteAssignmentpthisAssignment(AssignmentOid assignmentdeleteAssignmentpthisAssignment) {
        this.assignmentdeleteAssignmentpthisAssignment = assignmentdeleteAssignmentpthisAssignment;
    }

    @JsonIgnore
    public Assignment getAssignmentdeleteAssignmentpthisAssignmentInstance() {
        return this.assignmentdeleteAssignmentpthisAssignmentInstance;
    }
    
    public void setAssignmentdeleteAssignmentpthisAssignmentInstance(Assignment assignmentdeleteAssignmentpthisAssignment) {
        this.assignmentdeleteAssignmentpthisAssignmentInstance = assignmentdeleteAssignmentpthisAssignment;
    }

    private void checkAssignmentdeleteAssignmentpthisAssignment() throws NotNullArgumentException {
        if(this.getAssignmentdeleteAssignmentpthisAssignmentInstance() == null || this.getAssignmentdeleteAssignmentpthisAssignmentInstance().isNull()) {
            throw new NotNullArgumentException(AssignmentConstants.SERV_ID_DELETEASSIGNMENT, AssignmentConstants.CLASS_ID, AssignmentConstants.ARG_ID_DELETEASSIGNMENT_ASSIGNMENTDELETEASSIGNMENTPTHISASSIGNMENT, AssignmentConstants.SERV_ALIAS_DELETEASSIGNMENT, AssignmentConstants.CLASS_ALIAS, AssignmentConstants.ARG_ALIAS_DELETEASSIGNMENT_ASSIGNMENTDELETEASSIGNMENTPTHISASSIGNMENT);
        }
    }
}
