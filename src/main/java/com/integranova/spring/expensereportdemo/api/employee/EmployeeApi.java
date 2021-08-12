package com.integranova.spring.expensereportdemo.api.employee;

import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.oid.EmployeeOid;
import com.integranova.spring.expensereportdemo.service.EmployeeService;
import com.integranova.spring.expensereportdemo.viewmodel.employee.crud.EmployeePostViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.employee.crud.EmployeePutViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.employee.ds.DSEmployee;
import com.integranova.spring.expensereportdemo.viewmodel.employee.ds.DSEmployeeSup;
import com.integranova.spring.expensereportdemo.viewmodel.employee.piu.PIUEmployeeRequest;
import com.integranova.spring.expensereportdemo.viewmodel.employee.piu.PIUEmployeeResponse;
import com.integranova.spring.expensereportdemo.viewmodel.employee.siu.AddEmployeeToTeamRequest;
import com.integranova.spring.expensereportdemo.viewmodel.employee.siu.ChangePictureRequest;
import com.integranova.spring.expensereportdemo.viewmodel.employee.siu.CreateinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.employee.siu.DeleteinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.employee.siu.EditinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.employee.siu.RemoveEmployeeFromTeamRequest;
import com.integranova.spring.expensereportdemo.viewmodel.employee.siu.TDELETERequest;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadViewModel;
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
@RequestMapping("/api/EmployeeApi")
@Api(value = "Employee")
public class EmployeeApi {

    @Autowired
    EmployeeService service;

    @GetMapping(value="/")
    public List<Employee> getPopulation(){
    	return service.get();
    }
    
    @GetMapping(value="/{employeeidEmployee}")
    public Employee getInstance(String employeeidEmployee) {
    	return service.getById(employeeidEmployee);
    }

    @PostMapping(value="/")
    public Employee postInstance(@RequestBody EmployeePostViewModel payload) {
    	return service.post(payload);
    }

    @PutMapping(value="/{employeeidEmployee}")
    public Employee putInstance(String employeeidEmployee, @RequestBody EmployeePutViewModel payload) throws ModelException {
    	return service.put(employeeidEmployee, payload);
    }
    
    @DeleteMapping(value="/{employeeidEmployee}")
    public void deleteInstance(String employeeidEmployee) throws ModelException {
    	service.delete(employeeidEmployee);
    }

    @PostMapping(value = "/GetPreload")
    @ApiOperation(value = "Provides value for a preload")
    public List<PreloadViewModel> getEmployeePreload(@RequestBody QueryRequest queryRequest) {
        return service.getPreload(queryRequest);
    }

    @PostMapping(value = "/GetDSEmployee")
    @ApiOperation(value = "Returns displayset DSEmployee for an instance of Employee")
    public DSEmployee getDSEmployee(String instanceOID, String relatedInstancePath, String relatedInstanceDomain) {
        return service.getDSEmployee(instanceOID, (relatedInstancePath != null ? relatedInstancePath : ""), (relatedInstanceDomain != null ? relatedInstanceDomain : ""));
    }

    @PostMapping(value = "/GetDSEmployeeSup")
    @ApiOperation(value = "Returns displayset DSEmployeeSup for an instance of Employee")
    public DSEmployeeSup getDSEmployeeSup(String instanceOID, String relatedInstancePath, String relatedInstanceDomain) {
        return service.getDSEmployeeSup(instanceOID, (relatedInstancePath != null ? relatedInstancePath : ""), (relatedInstanceDomain != null ? relatedInstanceDomain : ""));
    }

    @GetMapping(value = "/GetEmployee")
    @ApiOperation(value = "Returns an instance of Employee", hidden = true)
    public Employee getEmployee(String employeeidEmployee) {
        return service.getById(employeeidEmployee);
    }
    
    @PostMapping(value = "/GetEmployeeDynamic")
    @ApiOperation(value = "Gets a dynamic set of properties for an instance of the class", hidden = true)
    public InstanceResponseViewModel getEmployeeDynamic(@RequestBody QueryRequest request) {
        EmployeeOid oid = new EmployeeOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getEmployeeDynamic(oid, request.getDisplaySetItems());
    }
    
    @PostMapping(value = "/GetWithDisplaySetDynamic")
    @ApiOperation(value = "Gets a dynamic displayset of properties for an instance of the class", hidden = true)
    public PreloadResponseViewModel getEmployeeWithDisplaySetDynamic(@RequestBody QueryRequest request) {
        return (PreloadResponseViewModel) service.getDynamic(request);
    }
    
    @PostMapping(value = "/GetPopulationDynamic")
    @ApiOperation(value = "Gets a set of instances and properties thereof who match a dynamically specified criteria", hidden = true)
    public PopulationResponseViewModel getEmployeePopulationDynamic(@RequestBody QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }

    @PostMapping(value = "/create_instance")
    @ApiOperation(value = "Employee's creation event")
    public ServiceResponse employeeCreateinstance(@RequestBody CreateinstanceRequest request) {
        return service.createinstance(request);
    }
    

    @PostMapping(value = "/delete_instance")
    @ApiOperation(value = "Employee's destruction event")
    public ServiceResponse employeeDeleteinstance(@RequestBody DeleteinstanceRequest request) {
        return service.deleteinstance(request);
    }
    

    @PostMapping(value = "/edit_instance")
    @ApiOperation(value = "Employee's change event")
    public ServiceResponse employeeEditinstance(@RequestBody EditinstanceRequest request) {
        return service.editinstance(request);
    }
    

    @PostMapping(value = "/changePicture")
    @ApiOperation(value = "Change Picture")
    public ServiceResponse employeeChangePicture(@RequestBody ChangePictureRequest request) {
        return service.changePicture(request);
    }
    

    @PostMapping(value = "/addEmployeeToTeam")
    @ApiOperation(value = "addEmployeeToTeam")
    public ServiceResponse employeeAddEmployeeToTeam(@RequestBody AddEmployeeToTeamRequest request) {
        return service.addEmployeeToTeam(request);
    }
    

    @PostMapping(value = "/addEmployeeToTeamCheckPreconditions")
    @ApiOperation(value = "Checks preconditions for addEmployeeToTeam")
    public ServiceResponse employeeAddEmployeeToTeamCheckPreconditions(@RequestBody AddEmployeeToTeamRequest request) {
        return service.addEmployeeToTeamCheckPreconditions(request);
    }

    @PostMapping(value = "/removeEmployeeFromTeam")
    @ApiOperation(value = "removeEmployeeFromTeam")
    public ServiceResponse employeeRemoveEmployeeFromTeam(@RequestBody RemoveEmployeeFromTeamRequest request) {
        return service.removeEmployeeFromTeam(request);
    }
    

    @PostMapping(value = "/TDELETE")
    @ApiOperation(value = "Delete")
    public ServiceResponse employeeTDELETE(@RequestBody TDELETERequest request) {
        return service.tDELETE(request);
    }
    

    @PostMapping(value = "/IIU_Employee")
    @ApiOperation(value = "Employee")
    public DSEmployee iiuIIUEmployee(@RequestBody EmployeeOid oid) {
        return service.iIUEmployee(oid);
    }

    @PostMapping(value = "/IIU_EmployeeReports")
    @ApiOperation(value = "Reports of Employee")
    public DSEmployee iiuIIUEmployeeReports(@RequestBody EmployeeOid oid) {
        return service.iIUEmployeeReports(oid);
    }

    @PostMapping(value = "/PIU_Employee")
    @ApiOperation(value = "Employees")
    public PIUEmployeeResponse piuPIUEmployee(@RequestBody PIUEmployeeRequest request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUEmployeeResponse response;
        try
        {
            response = new PIUEmployeeResponse(service.piuPIUEmployee(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUEmployee(queryRequest));
            }
        } catch (Exception e) {
            response = new PIUEmployeeResponse();
            response.setException(e);
        }
        return response;
    }

}
