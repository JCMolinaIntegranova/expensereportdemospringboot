package com.integranova.spring.expensereportdemo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.exception.PreconditionException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.EmployeeConstants;
import com.integranova.spring.expensereportdemo.global.STDFunctions;
import com.integranova.spring.expensereportdemo.persistence.AbstractAppEntity;
import com.integranova.spring.expensereportdemo.persistence.Assignment;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.oid.AssignmentOid;
import com.integranova.spring.expensereportdemo.persistence.oid.EmployeeOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseReportOid;
import com.integranova.spring.expensereportdemo.persistence.oid.TeamOid;
import com.integranova.spring.expensereportdemo.persistence.Team;
import com.integranova.spring.expensereportdemo.repository.EmployeeJpaRepository;
import com.integranova.spring.expensereportdemo.service.AssignmentService;
import com.integranova.spring.expensereportdemo.service.EmployeeService;
import com.integranova.spring.expensereportdemo.service.ExpenseReportService;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereComparison;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereDisjunction;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandLiteral;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandPathAttribute;
import com.integranova.spring.expensereportdemo.utils.Utilities;
import com.integranova.spring.expensereportdemo.viewmodel.employee.crud.EmployeePostViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.employee.crud.EmployeePutViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.FilterRequest;
import com.integranova.spring.expensereportdemo.viewmodel.FilterVariableRequest;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.QueryRequest;
import com.integranova.spring.expensereportdemo.viewmodel.QueryResponse;
import com.integranova.spring.expensereportdemo.viewmodel.ServiceResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeService extends AbstractService {

    @Autowired
    private EmployeeJpaRepository repository;

    @Autowired
    private EmployeeService employeeSrv;

    @Autowired
    private TeamService teamSrv;

    @Autowired
    private AssignmentService assignmentSrv;

    @Autowired
    private ExpenseReportService expenseReportSrv;
    
    public Employee post(EmployeePostViewModel payload) {
        Employee instance = new Employee();
        instance.setEmployeeidEmployee(payload.getEmployeeidEmployee());
        instance.setEmployeeEmpName(payload.getEmployeeEmpName());
        instance.setEmployeeEmpSurname(payload.getEmployeeEmpSurname());
        instance.setEmployeeSite(payload.getEmployeeSite());
        instance.setEmployeePhoneNumbers(payload.getEmployeePhoneNumbers());
        instance.setEmployeeemail(payload.getEmployeeemail());
        instance.setEmployeePicture(payload.getEmployeePicture());
        return repository.save(instance);
    }

    public Employee put(String employeeidEmployee, EmployeePutViewModel payload) throws ModelException {
        if (!repository.existsById(employeeidEmployee)) throw new ModelException("Not found-Put");
        Employee instance = new Employee(new EmployeeOid(employeeidEmployee));
        instance.setEmployeeEmpName(payload.getEmployeeEmpName());
        instance.setEmployeeEmpSurname(payload.getEmployeeEmpSurname());
        instance.setEmployeeSite(payload.getEmployeeSite());
        instance.setEmployeePhoneNumbers(payload.getEmployeePhoneNumbers());
        instance.setEmployeeemail(payload.getEmployeeemail());
        instance.setEmployeePicture(payload.getEmployeePicture());
        return repository.save(instance);
    }

    public void delete(String employeeidEmployee) throws ModelException {
        if (!repository.existsById(employeeidEmployee)) throw new ModelException("Not found-Delete");
        repository.deleteById(employeeidEmployee);
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, EmployeeConstants.CLASS_NAME);
    }

    private List<Employee> solveEmployeeTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, EmployeeConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber()).stream()
                .filter(instance -> applyMemoryFilters(request, instance)).collect(Collectors.toList());
    }
    
    private int solveEmployeeTypedCountQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, EmployeeConstants.CLASS_NAME)).stream()
                .filter(instance -> applyMemoryFilters(request, instance)).collect(Collectors.toList()).size();
    }
    
    /*
     * Returns the population of class Employee
     *
     * @return Population of class Employee
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<Employee> get() {
        return repository.findAll();
    }
    
    /*
     * Gets the preloaded list of objects of class Employee
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return Preloaded list of objects of class Employee
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<PreloadViewModel> getPreload(QueryRequest queryRequest) {
        List<PreloadViewModel> results = new ArrayList<>();
        List<Employee> instances = get(queryRequest);
        if(EmployeeConstants.DSDSEMPLOYEE.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSEmployee())).collect(Collectors.toList());
        }
        if(EmployeeConstants.DSDSEMPLOYEESUP.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSEmployeeSup())).collect(Collectors.toList());
        }
        return results;
    }

    /*
     * Gets the properties of DisplaySet DSEmployee for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet DSEmployee for a given instance
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public com.integranova.spring.expensereportdemo.viewmodel.employee.ds.DSEmployee getDSEmployee(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        Employee instance = (relatedInstancePath.isEmpty() ? 
                getByJsonOid(instanceOid):
                getByRelated(buildRelatedInstance(instanceOid, relatedInstancePath), relatedInstancePath).get(0));
        return new com.integranova.spring.expensereportdemo.viewmodel.employee.ds.DSEmployee(instance);
    }

    /*
     * Gets the properties of DisplaySet DSEmployeeSup for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet DSEmployeeSup for a given instance
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public com.integranova.spring.expensereportdemo.viewmodel.employee.ds.DSEmployeeSup getDSEmployeeSup(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        Employee instance = (relatedInstancePath.isEmpty() ? 
                getByJsonOid(instanceOid):
                getByRelated(buildRelatedInstance(instanceOid, relatedInstancePath), relatedInstancePath).get(0));
        return new com.integranova.spring.expensereportdemo.viewmodel.employee.ds.DSEmployeeSup(instance);
    }

    /*
     * Returns the population of class Employee that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class Employee matching the search criteria
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<Employee> get(QueryRequest queryRequest) {
        return solveEmployeeTypedQuery(queryRequest);
    }
    
    /*
     * Returns the list of instances that matches certain search criteria
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return List of instances that matches certain search criteria
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public QueryResponse getDynamic(QueryRequest queryRequest) {
        if (queryRequest.getDisplaySetName() == null || queryRequest.getDisplaySetName().isEmpty()) {
            return new PopulationResponseViewModel(solveEmployeeTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveEmployeeTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel(solveEmployeeTypedQuery(queryRequest).stream()
                    .map(instance -> buildPreloadViewModel(instance, queryRequest.getDisplaySetName()))
                    .collect(Collectors.toList()));
        }
    }

    /*
     * Returns the population of a class with a certain structure
     *
     * @param relatedInstanceJsonOid Json Oid of the related instance
     *
     * @param relatedInstancePath Path to the related instance
     *
     * @param displaySetItems DisplaySet items for each returned instance
     *
     * @return List of instances
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public PopulationResponseViewModel getByRelatedDynamic(String relatedInstanceJsonOid, String relatedInstancePath, String displaySetItems) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstanceJsonOid))));
        return new PopulationResponseViewModel(solveEmployeeTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of Employee by ID
     *
     * @param employeeidEmployee Identification field employeeidEmployee
     *
     * @return Instance of Employee
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Employee getById(String employeeidEmployee) {
        return getByOID(new EmployeeOid(employeeidEmployee));
    }
    
    /*
     * Returns an instance of Employee by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Employee
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Employee getByOID(EmployeeOid oid) {
        Optional<Employee> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of Employee by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Employee
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Employee getByOIDWithHV(EmployeeOid oid) {
        Optional<Employee> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<Employee> getInstanceByOid(EmployeeOid oid) {
        return oid != null && oid.getEmployeeidEmployee() != null
               ? repository.findById(oid.getEmployeeidEmployee())
               : Optional.empty();
    }
    
    /*
     * Returns an instance of Employee by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of Employee
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Employee getByJsonOid(String jsonOid) {
        EmployeeOid oid = new EmployeeOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of Employee related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of Employee
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<Employee> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveEmployeeTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of Employee related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of Employee
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<Employee> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of Employee
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of Employee
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public InstanceResponseViewModel getEmployeeDynamic(EmployeeOid oid, String displaySetItems) {
        return new InstanceResponseViewModel(getByOIDWithHV(oid), displaySetItems);
    }

    /*
     * Returns the supplementary info for a given instance
     *
     * @param oid Instance OID
     *
     * @param dsName DisplaySet name
     *
     * @return Supplementary info for a given instance
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public String getSuppInfo(EmployeeOid oid, String dsName) {
        Employee instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(Employee instance, String dsName) {
        if (EmployeeConstants.DSDSEMPLOYEESUP.equals(dsName))
            return instance.buildDSEmployeeSup();
        return instance != null && dsName.isEmpty() ? instance.getOid().toJson() : "";
    }

    public static PreloadViewModel buildPreloadViewModel(Employee instance, String dsName) {
        if (EmployeeConstants.DSDSEMPLOYEE.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSEmployee());
        if (EmployeeConstants.DSDSEMPLOYEESUP.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSEmployeeSup());
        return new PreloadViewModel(instance.getOid().toJson(), "");
    }


    @Override
    protected void applyServiceSIFilters(FilterRequest filterRequest, SQLSelect sql) {
        if ("SuppInfo_DS_EmployeeSup".equals(filterRequest.getName()))
            suppInfo4DSEmployeeSup(filterRequest.getFilterVariable("searchText").toString(), sql);
    }

    private boolean applyMemoryFilters(QueryRequest queryRequest, Employee instance) {
        for (FilterRequest filterRequest : queryRequest.getFilters()) {
            if (!applyMemoryFilter(filterRequest, instance))
                return false;
        }
        return true;
    }
    
    private boolean applyMemoryFilter(FilterRequest filterRequest, Employee instance) {
        return applyMemoryQueryFilter(filterRequest, instance);
    }

    private boolean applyMemoryQueryFilter(FilterRequest filterRequest, Employee entity) {
        if (EmployeeConstants.FILTER_NAME_FEMPLOYEENAME.equalsIgnoreCase(filterRequest.getName()))
            return inMemoryFEmployeeName(filterRequest,  entity);
        return true;
    }


    private boolean inMemoryFEmployeeName(FilterRequest filterRequest, Employee entity) {
        boolean result = true;
        String vFullName = filterRequest.hasFilterVariable(EmployeeConstants.VAR_NAME_FEMPLOYEENAME_VFULLNAME) ? (String) filterRequest.getFilterVariable(EmployeeConstants.VAR_NAME_FEMPLOYEENAME_VFULLNAME, FilterVariableRequest.STRING) : null;

        // EmpFullName LIKE vFullName
        try {
            if (vFullName != null) {
                result = Utilities.like(entity.getEmployeeEmpFullName(), vFullName);
            }
        } catch(Exception e) {
           LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
        return result;
    }

    // IIU Methods

    /*
     * Returns a viewmodel for class Employee with displayset DSEmployee for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class Employee with displayset DSEmployee
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public com.integranova.spring.expensereportdemo.viewmodel.employee.ds.DSEmployee iIUEmployee(EmployeeOid oid) {
        return new com.integranova.spring.expensereportdemo.viewmodel.employee.ds.DSEmployee(getByOIDWithHV(oid));
    }

    /*
     * Returns a viewmodel for class Employee with displayset DSEmployee for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class Employee with displayset DSEmployee
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public com.integranova.spring.expensereportdemo.viewmodel.employee.ds.DSEmployee iIUEmployeeReports(EmployeeOid oid) {
        return new com.integranova.spring.expensereportdemo.viewmodel.employee.ds.DSEmployee(getByOIDWithHV(oid));
    }


    /*
     * Solves the query needed for PIUEmployee
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Employee using displayset DSEmployee that 
     * match the search criteria
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<com.integranova.spring.expensereportdemo.viewmodel.employee.ds.DSEmployee> piuPIUEmployee(QueryRequest queryRequest) {
        return solveEmployeeTypedQuery(queryRequest).stream()
                .map(com.integranova.spring.expensereportdemo.viewmodel.employee.ds.DSEmployee::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUEmployee
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUEmployee
     */
    public int getCount4PIUEmployee(QueryRequest queryRequest) {
        return solveEmployeeTypedQuery(queryRequest).size();
    }

    // Service: createinstance

    /*
     * Entry point for service createinstance
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse createinstance(
            com.integranova.spring.expensereportdemo.viewmodel.employee.siu.CreateinstanceRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = employeeSrv.createinstanceTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service createinstance
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse createinstanceTxn(
            com.integranova.spring.expensereportdemo.viewmodel.employee.siu.CreateinstanceRequest request) throws ModelException {
        return employeeSrv.createinstanceImplementation(request);
    }

    /*
     * Implements service createinstance
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse createinstanceImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.employee.siu.CreateinstanceRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        String employeecreateinstancepatridEmployee = request.getEmployeecreateinstancepatridEmployee();
        String employeecreateinstancepatrEmpName = request.getEmployeecreateinstancepatrEmpName();
        String employeecreateinstancepatrEmpSurname = request.getEmployeecreateinstancepatrEmpSurname();
        String employeecreateinstancepatrSite = request.getEmployeecreateinstancepatrSite();
        String employeecreateinstancepatrPhoneNumbers = request.getEmployeecreateinstancepatrPhoneNumbers();
        String employeecreateinstancepatremail = request.getEmployeecreateinstancepatremail();
        byte[] employeecreateinstancepatrPicture = request.getEmployeecreateinstancepatrPicture();

        request.checkArguments();
        Employee instance = new Employee();
        instance.setEmployeeidEmployee(employeecreateinstancepatridEmployee);
        instance.setEmployeeEmpName(employeecreateinstancepatrEmpName);
        instance.setEmployeeEmpSurname(employeecreateinstancepatrEmpSurname);
        instance.setEmployeeSite(employeecreateinstancepatrSite);
        instance.setEmployeePhoneNumbers(employeecreateinstancepatrPhoneNumbers);
        instance.setEmployeeemail(employeecreateinstancepatremail);
        instance.setEmployeePicture(employeecreateinstancepatrPicture);
        
        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildDSEmployeeSup());

        return response;
    }

    // Service: deleteinstance

    /*
     * Entry point for service deleteinstance
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse deleteinstance(
            com.integranova.spring.expensereportdemo.viewmodel.employee.siu.DeleteinstanceRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = employeeSrv.deleteinstanceTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service deleteinstance
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse deleteinstanceTxn(
            com.integranova.spring.expensereportdemo.viewmodel.employee.siu.DeleteinstanceRequest request) throws ModelException {
        request.setEmployeedeleteinstancepthisEmployeeInstance(employeeSrv.getByOIDWithHV(request.getEmployeedeleteinstancepthisEmployee()));
        return employeeSrv.deleteinstanceImplementation(request);
    }

    /*
     * Implements service deleteinstance
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse deleteinstanceImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.employee.siu.DeleteinstanceRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Employee employeedeleteinstancepthisEmployee = request.getEmployeedeleteinstancepthisEmployeeInstance();

        request.checkArguments();
        Employee instance = employeedeleteinstancepthisEmployee;

        repository.delete(instance);
        
        response.setInstance(instance);
        response.setInstanceSuppInfo(instance.buildDSEmployeeSup());

        return response;
    }

    // Service: editinstance

    /*
     * Entry point for service editinstance
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse editinstance(
            com.integranova.spring.expensereportdemo.viewmodel.employee.siu.EditinstanceRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = employeeSrv.editinstanceTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service editinstance
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse editinstanceTxn(
            com.integranova.spring.expensereportdemo.viewmodel.employee.siu.EditinstanceRequest request) throws ModelException {
        request.setEmployeeeditinstancepthisEmployeeInstance(employeeSrv.getByOIDWithHV(request.getEmployeeeditinstancepthisEmployee()));
        return employeeSrv.editinstanceImplementation(request);
    }

    /*
     * Implements service editinstance
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse editinstanceImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.employee.siu.EditinstanceRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Employee employeeeditinstancepthisEmployee = request.getEmployeeeditinstancepthisEmployeeInstance();
        String employeeeditinstancepEmpName = request.getEmployeeeditinstancepEmpName();
        String employeeeditinstancepEmpSurname = request.getEmployeeeditinstancepEmpSurname();
        String employeeeditinstancepSite = request.getEmployeeeditinstancepSite();
        String employeeeditinstancepPhoneNumbers = request.getEmployeeeditinstancepPhoneNumbers();
        String employeeeditinstancepemail = request.getEmployeeeditinstancepemail();

        request.checkArguments();
        Employee instance = employeeeditinstancepthisEmployee;
        instance.setEmployeeEmpName(employeeeditinstancepEmpName);
        instance.setEmployeeEmpSurname(employeeeditinstancepEmpSurname);
        instance.setEmployeeSite(employeeeditinstancepSite);
        instance.setEmployeePhoneNumbers(employeeeditinstancepPhoneNumbers);
        instance.setEmployeeemail(employeeeditinstancepemail);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildDSEmployeeSup());

        return response;
    }

    // Service: changePicture

    /*
     * Entry point for service changePicture
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse changePicture(
            com.integranova.spring.expensereportdemo.viewmodel.employee.siu.ChangePictureRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = employeeSrv.changePictureTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service changePicture
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse changePictureTxn(
            com.integranova.spring.expensereportdemo.viewmodel.employee.siu.ChangePictureRequest request) throws ModelException {
        request.setEmployeechangePicturepthisEmployeeInstance(employeeSrv.getByOIDWithHV(request.getEmployeechangePicturepthisEmployee()));
        return employeeSrv.changePictureImplementation(request);
    }

    /*
     * Implements service changePicture
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse changePictureImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.employee.siu.ChangePictureRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Employee employeechangePicturepthisEmployee = request.getEmployeechangePicturepthisEmployeeInstance();
        byte[] employeechangePicturepPicture = request.getEmployeechangePicturepPicture();

        request.checkArguments();
        Employee instance = employeechangePicturepthisEmployee;
        instance.setEmployeePicture(employeechangePicturepPicture);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildDSEmployeeSup());

        return response;
    }

    // Service: addEmployeeToTeam

    /*
     * Entry point for service addEmployeeToTeam
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse addEmployeeToTeam(
            com.integranova.spring.expensereportdemo.viewmodel.employee.siu.AddEmployeeToTeamRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = employeeSrv.addEmployeeToTeamTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service addEmployeeToTeam
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse addEmployeeToTeamTxn(
            com.integranova.spring.expensereportdemo.viewmodel.employee.siu.AddEmployeeToTeamRequest request) throws ModelException {
        request.setEmployeeaddEmployeeToTeampthisEmployeeInstance(employeeSrv.getByOIDWithHV(request.getEmployeeaddEmployeeToTeampthisEmployee()));
        request.setEmployeeaddEmployeeToTeampevcTeamInstance(teamSrv.getByOIDWithHV(request.getEmployeeaddEmployeeToTeampevcTeam()));
        return employeeSrv.addEmployeeToTeamImplementation(request, true);
    }

    /*
     * Implements service addEmployeeToTeam
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse addEmployeeToTeamImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.employee.siu.AddEmployeeToTeamRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Employee employeeaddEmployeeToTeampthisEmployee = request.getEmployeeaddEmployeeToTeampthisEmployeeInstance();
        Team employeeaddEmployeeToTeampevcTeam = request.getEmployeeaddEmployeeToTeampevcTeamInstance();

        request.checkArguments();

        addEmployeeToTeamPreconditions(request);
        Employee instance = employeeaddEmployeeToTeampthisEmployee;

        instance.getTeams().add(employeeaddEmployeeToTeampevcTeam);
        if (isEntryPoint) {
            com.integranova.spring.expensereportdemo.viewmodel.team.siu.AddEmployeeToTeamRequest relatedRequest = new com.integranova.spring.expensereportdemo.viewmodel.team.siu.AddEmployeeToTeamRequest();
            relatedRequest.setTeamaddEmployeeToTeampthisTeamInstance(employeeaddEmployeeToTeampevcTeam);
            relatedRequest.setTeamaddEmployeeToTeampevcEmployeeInstance(employeeaddEmployeeToTeampthisEmployee);
            teamSrv.addEmployeeToTeamImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildDSEmployeeSup());

        return response;
    }

    /*
     * Checks service addEmployeeToTeam preconditions individually
     *
     * @param request Service request viewmodel
     *
     * @return Service preconditions evaluation result
     */
    public ServiceResponse addEmployeeToTeamCheckPreconditions(com.integranova.spring.expensereportdemo.viewmodel.employee.siu.AddEmployeeToTeamRequest request) {
        ServiceResponse response = new ServiceResponse();
        request.setEmployeeaddEmployeeToTeampthisEmployeeInstance(employeeSrv.getByOIDWithHV(request.getEmployeeaddEmployeeToTeampthisEmployee()));
        request.setEmployeeaddEmployeeToTeampevcTeamInstance(teamSrv.getByOIDWithHV(request.getEmployeeaddEmployeeToTeampevcTeam()));
        try {
            if("Clas_1057569177600607Pre_1".equals(request.getPreconditionId()))
                checkClas1057569177600607Pre1(request);
            if("Clas_1057569177600607Pre_2".equals(request.getPreconditionId()))
                checkClas1057569177600607Pre2(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void addEmployeeToTeamPreconditions(
            com.integranova.spring.expensereportdemo.viewmodel.employee.siu.AddEmployeeToTeamRequest request) 
            throws ModelException {
        checkClas1057569177600607Pre1(request);
        checkClas1057569177600607Pre2(request);
    }

    private void checkClas1057569177600607Pre1 (
            com.integranova.spring.expensereportdemo.viewmodel.employee.siu.AddEmployeeToTeamRequest request) 
            throws ModelException {
        // EXIST( pevcTeam.Employees ) WHERE (pevcTeam.Employees = pthisEmployee) = false

        Team employeeaddEmployeeToTeampevcTeam = request.getEmployeeaddEmployeeToTeampevcTeamInstance();
        Employee employeeaddEmployeeToTeampthisEmployee = request.getEmployeeaddEmployeeToTeampthisEmployeeInstance();
        try {
            boolean preconditionHolds = repository.assocOperator001(employeeaddEmployeeToTeampevcTeam, employeeaddEmployeeToTeampthisEmployee).equals(false);
            if (!preconditionHolds) throw new PreconditionException("Employee already belongs to team");
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
    }

    private void checkClas1057569177600607Pre2 (
            com.integranova.spring.expensereportdemo.viewmodel.employee.siu.AddEmployeeToTeamRequest request) 
            throws ModelException {
        // COUNT( pevcTeam.Employees ) < pevcTeam.maxEmployees

        Team employeeaddEmployeeToTeampevcTeam = request.getEmployeeaddEmployeeToTeampevcTeamInstance();
        Employee employeeaddEmployeeToTeampthisEmployee = request.getEmployeeaddEmployeeToTeampthisEmployeeInstance();
        try {
            boolean preconditionHolds = repository.assocOperator002(employeeaddEmployeeToTeampevcTeam) < employeeaddEmployeeToTeampevcTeam.getTeammaxEmployees();
            if (!preconditionHolds) throw new PreconditionException("Team does not admit more employees");
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
    }

    // Service: removeEmployeeFromTeam

    /*
     * Entry point for service removeEmployeeFromTeam
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse removeEmployeeFromTeam(
            com.integranova.spring.expensereportdemo.viewmodel.employee.siu.RemoveEmployeeFromTeamRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = employeeSrv.removeEmployeeFromTeamTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service removeEmployeeFromTeam
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse removeEmployeeFromTeamTxn(
            com.integranova.spring.expensereportdemo.viewmodel.employee.siu.RemoveEmployeeFromTeamRequest request) throws ModelException {
        request.setEmployeeremoveEmployeeFromTeampthisEmployeeInstance(employeeSrv.getByOIDWithHV(request.getEmployeeremoveEmployeeFromTeampthisEmployee()));
        request.setEmployeeremoveEmployeeFromTeampevcTeamInstance(teamSrv.getByOIDWithHV(request.getEmployeeremoveEmployeeFromTeampevcTeam()));
        return employeeSrv.removeEmployeeFromTeamImplementation(request, true);
    }

    /*
     * Implements service removeEmployeeFromTeam
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse removeEmployeeFromTeamImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.employee.siu.RemoveEmployeeFromTeamRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Employee employeeremoveEmployeeFromTeampthisEmployee = request.getEmployeeremoveEmployeeFromTeampthisEmployeeInstance();
        Team employeeremoveEmployeeFromTeampevcTeam = request.getEmployeeremoveEmployeeFromTeampevcTeamInstance();

        request.checkArguments();
        Employee instance = employeeremoveEmployeeFromTeampthisEmployee;

        instance.getTeams().remove(employeeremoveEmployeeFromTeampevcTeam);
        employeeremoveEmployeeFromTeampevcTeam.getEmployees().remove(instance);
        if (isEntryPoint) {
            com.integranova.spring.expensereportdemo.viewmodel.team.siu.RemoveEmployeeFromTeamRequest relatedRequest = new com.integranova.spring.expensereportdemo.viewmodel.team.siu.RemoveEmployeeFromTeamRequest();
            relatedRequest.setTeamremoveEmployeeFromTeampthisTeamInstance(employeeremoveEmployeeFromTeampevcTeam);
            relatedRequest.setTeamremoveEmployeeFromTeampevcEmployeeInstance(employeeremoveEmployeeFromTeampthisEmployee);
            teamSrv.removeEmployeeFromTeamImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildDSEmployeeSup());

        return response;
    }

    // Service: TDELETE

    /*
     * Entry point for service TDELETE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse tDELETE(
            com.integranova.spring.expensereportdemo.viewmodel.employee.siu.TDELETERequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = employeeSrv.tDELETETxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TDELETE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse tDELETETxn(
            com.integranova.spring.expensereportdemo.viewmodel.employee.siu.TDELETERequest request) throws ModelException, SystemException {
        request.setEmployeeTDELETEpthisEmployeeInstance(employeeSrv.getByOIDWithHV(request.getEmployeeTDELETEpthisEmployee()));
        return employeeSrv.tDELETEImplementation(request);
    }

    /*
     * Implements service TDELETE
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse tDELETEImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.employee.siu.TDELETERequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        Employee employeeTDELETEpthisEmployee = request.getEmployeeTDELETEpthisEmployeeInstance();

        request.checkArguments();
        Employee instance = employeeTDELETEpthisEmployee;

        for(Assignment step1Entity : repository.assocOperator003(employeeTDELETEpthisEmployee)) {
            com.integranova.spring.expensereportdemo.viewmodel.assignment.siu.TerminateAssignmentRequest step1Request = new com.integranova.spring.expensereportdemo.viewmodel.assignment.siu.TerminateAssignmentRequest();
            step1Request.setAssignmentterminateAssignmentpthisAssignmentInstance(step1Entity);
            step1Request.setAssignmentterminateAssignmentpTerminationDate(STDFunctions.systemDateFun());
            assignmentSrv.terminateAssignmentImplementation(step1Request);
        }

        for(Assignment step2Entity : repository.assocOperator004(employeeTDELETEpthisEmployee)) {
            com.integranova.spring.expensereportdemo.viewmodel.assignment.siu.DeleteAssignmentRequest step2Request = new com.integranova.spring.expensereportdemo.viewmodel.assignment.siu.DeleteAssignmentRequest();
            step2Request.setAssignmentdeleteAssignmentpthisAssignmentInstance(step2Entity);
            assignmentSrv.deleteAssignmentImplementation(step2Request);
        }

        for(Team step3Entity : repository.assocOperator005(employeeTDELETEpthisEmployee, employeeTDELETEpthisEmployee)) {
            com.integranova.spring.expensereportdemo.viewmodel.employee.siu.RemoveEmployeeFromTeamRequest step3Request = new com.integranova.spring.expensereportdemo.viewmodel.employee.siu.RemoveEmployeeFromTeamRequest();
            step3Request.setEmployeeremoveEmployeeFromTeampthisEmployeeInstance(employeeTDELETEpthisEmployee);
            step3Request.setEmployeeremoveEmployeeFromTeampevcTeamInstance(step3Entity);
            employeeSrv.removeEmployeeFromTeamImplementation(step3Request, true);
        }

        for(ExpenseReport step4Entity : repository.assocOperator006(employeeTDELETEpthisEmployee)) {
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DELETEALLRequest step4Request = new com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DELETEALLRequest();
            step4Request.setExpenseReportDELETEALLptpthisExpenseReportInstance(step4Entity);
            expenseReportSrv.dELETEALLImplementation(step4Request);
        }

        com.integranova.spring.expensereportdemo.viewmodel.employee.siu.DeleteinstanceRequest step5Request = new com.integranova.spring.expensereportdemo.viewmodel.employee.siu.DeleteinstanceRequest();
        step5Request.setEmployeedeleteinstancepthisEmployeeInstance(employeeTDELETEpthisEmployee);
        employeeSrv.deleteinstanceImplementation(step5Request);

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildDSEmployeeSup());

        return response;
    }


    private void suppInfo4DSEmployeeSup(String searchText, SQLSelect select) {
        try {
            SQLWhereDisjunction disjunction = new SQLWhereDisjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(select);
            comparison1.setOperator("LIKE");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(EmployeeConstants.ATTR_NAME_EMPLOYEEEMPNAME, Constants.Type.STRING.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(searchText, Constants.Type.STRING.getTypeName()));
            disjunction.addComparison(comparison1);

            SQLWhereComparison comparison2 = new SQLWhereComparison(select);
            comparison2.setOperator("LIKE");
            comparison2.setFirstOperand(new SQLWhereOperandPathAttribute(EmployeeConstants.ATTR_NAME_EMPLOYEEEMPSURNAME, Constants.Type.STRING.getTypeName()));
            comparison2.setSecondOperand(new SQLWhereOperandLiteral(searchText, Constants.Type.STRING.getTypeName()));
            disjunction.addComparison(comparison2);

            select.addDisjunction(disjunction);
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
    }

    @Override
    protected void applyOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        applyOCOCEmployee(queryRequest, select);
        applyDSItemSort(queryRequest, select);
    }
    

    private void applyOCOCEmployee(QueryRequest queryRequest, SQLSelect select) {
        if ("OC_Employee".equalsIgnoreCase(queryRequest.getOrderCriteriaName())) {
            select.getOrderByPart().addItem(Constants.normalizePath(EmployeeConstants.CLASS_NAME, EmployeeConstants.ATTR_NAME_EMPLOYEEEMPSURNAME, false), true);
            select.getOrderByPart().addItem(Constants.normalizePath(EmployeeConstants.CLASS_NAME, EmployeeConstants.ATTR_NAME_EMPLOYEEEMPNAME, false), true);
        }
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildEmployeeRelatedInstance(relatedInstanceJsonOid);
        }
        if (EmployeeConstants.ROLE_NAME_EXPENSEREPORTS.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildEmployeeRelatedInstance4ExpenseReport(relatedInstanceJsonOid, remainingPath);
        }
        if (EmployeeConstants.ROLE_NAME_ASSIGNMENTS.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildEmployeeRelatedInstance4Assignment(relatedInstanceJsonOid, remainingPath);
        }
        if (EmployeeConstants.ROLE_NAME_TEAMS.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildEmployeeRelatedInstance4Team(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildEmployeeRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new Employee(mapper.readValue(relatedInstanceJsonOid, EmployeeOid.class));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildEmployeeRelatedInstance4ExpenseReport(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ExpenseReport(mapper.readValue(relatedInstanceJsonOid, ExpenseReportOid.class)): expenseReportSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildEmployeeRelatedInstance4Assignment(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Assignment(mapper.readValue(relatedInstanceJsonOid, AssignmentOid.class)): assignmentSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildEmployeeRelatedInstance4Team(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Team(mapper.readValue(relatedInstanceJsonOid, TeamOid.class)): teamSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            EmployeeOid oid = new EmployeeOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(EmployeeConstants.ATTR_FIELD_EMPLOYEEIDEMPLOYEE, Constants.Type.STRING.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getEmployeeidEmployee(), Constants.Type.STRING.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(EmployeeService.class).error(e.getMessage());
        }
    }

}
