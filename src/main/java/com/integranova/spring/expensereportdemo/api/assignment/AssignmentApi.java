package com.integranova.spring.expensereportdemo.api.assignment;

import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.persistence.Assignment;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.oid.AssignmentOid;
import com.integranova.spring.expensereportdemo.persistence.oid.EmployeeOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ProjectOid;
import com.integranova.spring.expensereportdemo.persistence.Project;
import com.integranova.spring.expensereportdemo.service.AssignmentService;
import com.integranova.spring.expensereportdemo.viewmodel.assignment.crud.AssignmentPostViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.assignment.crud.AssignmentPutViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.assignment.ds.DSAssignmentDetails;
import com.integranova.spring.expensereportdemo.viewmodel.assignment.ds.DSAssignments;
import com.integranova.spring.expensereportdemo.viewmodel.assignment.piu.PIUAssignmentsRequest;
import com.integranova.spring.expensereportdemo.viewmodel.assignment.piu.PIUAssignmentsResponse;
import com.integranova.spring.expensereportdemo.viewmodel.assignment.siu.DeleteAssignmentRequest;
import com.integranova.spring.expensereportdemo.viewmodel.assignment.siu.EditAssignmentRequest;
import com.integranova.spring.expensereportdemo.viewmodel.assignment.siu.NewAssignmentRequest;
import com.integranova.spring.expensereportdemo.viewmodel.assignment.siu.TerminateAssignmentRequest;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.QueryRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ServiceResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/AssignmentApi")
@Api(value = "Represents the assignment of Employees to Projects")
public class AssignmentApi {

    @Autowired
    AssignmentService service;

    @GetMapping(value="/")
    public List<Assignment> getPopulation(){
    	return service.get();
    }
    
    @GetMapping(value="/{assignmentAssignmentID}")
    public Assignment getInstance(Long assignmentAssignmentID) {
    	return service.getById(assignmentAssignmentID);
    }

    @PostMapping(value="/")
    public Assignment postInstance(@RequestBody AssignmentPostViewModel payload) {
    	return service.post(payload);
    }

    @PutMapping(value="/{assignmentAssignmentID}")
    public Assignment putInstance(Long assignmentAssignmentID, @RequestBody AssignmentPutViewModel payload) throws ModelException {
    	return service.put(assignmentAssignmentID, payload);
    }
    
    @DeleteMapping(value="/{assignmentAssignmentID}")
    public void deleteInstance(Long assignmentAssignmentID) throws ModelException {
    	service.delete(assignmentAssignmentID);
    }

    @PostMapping(value = "/GetDSAssignmentDetails")
    @ApiOperation(value = "Returns displayset DSAssignmentDetails for an instance of Assignment")
    public DSAssignmentDetails getDSAssignmentDetails(String instanceOID, String relatedInstancePath, String relatedInstanceDomain) {
        return service.getDSAssignmentDetails(instanceOID, (relatedInstancePath != null ? relatedInstancePath : ""), (relatedInstanceDomain != null ? relatedInstanceDomain : ""));
    }

    @PostMapping(value = "/GetDSAssignments")
    @ApiOperation(value = "Returns displayset DSAssignments for an instance of Assignment")
    public DSAssignments getDSAssignments(String instanceOID, String relatedInstancePath, String relatedInstanceDomain) {
        return service.getDSAssignments(instanceOID, (relatedInstancePath != null ? relatedInstancePath : ""), (relatedInstanceDomain != null ? relatedInstanceDomain : ""));
    }

    @GetMapping(value = "/GetAssignment")
    @ApiOperation(value = "Returns an instance of Assignment", hidden = true)
    public Assignment getAssignment(Long assignmentAssignmentID) {
        return service.getById(assignmentAssignmentID);
    }
    
    @PostMapping(value = "/GetAssignmentDynamic")
    @ApiOperation(value = "Gets a dynamic set of properties for an instance of the class", hidden = true)
    public InstanceResponseViewModel getAssignmentDynamic(@RequestBody QueryRequest request) {
        AssignmentOid oid = new AssignmentOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getAssignmentDynamic(oid, request.getDisplaySetItems());
    }
    
    @PostMapping(value = "/GetWithDisplaySetDynamic")
    @ApiOperation(value = "Gets a dynamic displayset of properties for an instance of the class", hidden = true)
    public PreloadResponseViewModel getAssignmentWithDisplaySetDynamic(@RequestBody QueryRequest request) {
        return (PreloadResponseViewModel) service.getDynamic(request);
    }
    
    @PostMapping(value = "/GetPopulationDynamic")
    @ApiOperation(value = "Gets a set of instances and properties thereof who match a dynamically specified criteria", hidden = true)
    public PopulationResponseViewModel getAssignmentPopulationDynamic(@RequestBody QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }

    @PostMapping(value = "/GetByEmployee")
    @ApiOperation(value = "Returns instances related with another one through Employee")
    public List<Assignment> getAssignmentByEmployee(EmployeeOid relatedInstanceOid) {
        Employee relatedInstance = new Employee(relatedInstanceOid);
        return service.getInstancesByRelated(relatedInstance, "Employee");
    }

    @PostMapping(value = "/GetByProject")
    @ApiOperation(value = "Returns instances related with another one through Project")
    public List<Assignment> getAssignmentByProject(ProjectOid relatedInstanceOid) {
        Project relatedInstance = new Project(relatedInstanceOid);
        return service.getInstancesByRelated(relatedInstance, "Project");
    }

    @PostMapping(value = "/newAssignment")
    @ApiOperation(value = "Assignment's creation event")
    public ServiceResponse assignmentNewAssignment(@RequestBody NewAssignmentRequest request) {
        return service.newAssignment(request);
    }
    

    @PostMapping(value = "/newAssignmentCheckPreconditions")
    @ApiOperation(value = "Checks preconditions for newAssignment")
    public ServiceResponse assignmentNewAssignmentCheckPreconditions(@RequestBody NewAssignmentRequest request) {
        return service.newAssignmentCheckPreconditions(request);
    }

    @PostMapping(value = "/deleteAssignment")
    @ApiOperation(value = "Assignment's destruction event")
    public ServiceResponse assignmentDeleteAssignment(@RequestBody DeleteAssignmentRequest request) {
        return service.deleteAssignment(request);
    }
    

    @PostMapping(value = "/editAssignment")
    @ApiOperation(value = "Assignment's change event")
    public ServiceResponse assignmentEditAssignment(@RequestBody EditAssignmentRequest request) {
        return service.editAssignment(request);
    }
    

    @PostMapping(value = "/terminateAssignment")
    @ApiOperation(value = "Terminate")
    public ServiceResponse assignmentTerminateAssignment(@RequestBody TerminateAssignmentRequest request) {
        return service.terminateAssignment(request);
    }
    

    @PostMapping(value = "/IIU_Assignment")
    @ApiOperation(value = "Assignment Details")
    public DSAssignmentDetails iiuIIUAssignment(@RequestBody AssignmentOid oid) {
        return service.iIUAssignment(oid);
    }

    @PostMapping(value = "/PIU_Assignments")
    @ApiOperation(value = "Assignments")
    public PIUAssignmentsResponse piuPIUAssignments(@RequestBody PIUAssignmentsRequest request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUAssignmentsResponse response;
        try
        {
            response = new PIUAssignmentsResponse(service.piuPIUAssignments(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUAssignments(queryRequest));
            }
        } catch (Exception e) {
            response = new PIUAssignmentsResponse();
            response.setException(e);
        }
        return response;
    }

}
