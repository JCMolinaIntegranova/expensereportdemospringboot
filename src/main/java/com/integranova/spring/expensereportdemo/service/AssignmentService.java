package com.integranova.spring.expensereportdemo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.exception.PreconditionException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.AssignmentConstants;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.EmployeeConstants;
import com.integranova.spring.expensereportdemo.global.ProjectConstants;
import com.integranova.spring.expensereportdemo.persistence.AbstractAppEntity;
import com.integranova.spring.expensereportdemo.persistence.Assignment;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.oid.AssignmentOid;
import com.integranova.spring.expensereportdemo.persistence.oid.EmployeeOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ProjectOid;
import com.integranova.spring.expensereportdemo.persistence.Project;
import com.integranova.spring.expensereportdemo.repository.AssignmentJpaRepository;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereComparison;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereConjunction;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandLiteral;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandOVParameter;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandPathAttribute;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandPathInstance;
import com.integranova.spring.expensereportdemo.viewmodel.assignment.crud.AssignmentPostViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.assignment.crud.AssignmentPutViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.FilterRequest;
import com.integranova.spring.expensereportdemo.viewmodel.FilterVariableRequest;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.QueryRequest;
import com.integranova.spring.expensereportdemo.viewmodel.QueryResponse;
import com.integranova.spring.expensereportdemo.viewmodel.ServiceResponse;
import java.sql.Date;
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
public class AssignmentService extends AbstractService {

    @Autowired
    private AssignmentJpaRepository repository;

    @Autowired
    private AssignmentService assignmentSrv;

    @Autowired
    private ProjectService projectSrv;

    @Autowired
    private EmployeeService employeeSrv;
    
    public Assignment post(AssignmentPostViewModel payload) {
        Assignment instance = new Assignment();
        instance.setAssignmentFromDate(payload.getAssignmentFromDate());
        return repository.save(instance);
    }

    public Assignment put(Long assignmentAssignmentID, AssignmentPutViewModel payload) throws ModelException {
        if (!repository.existsById(assignmentAssignmentID)) throw new ModelException("Not found-Put");
        Assignment instance = new Assignment(new AssignmentOid(assignmentAssignmentID));
        instance.setAssignmentFromDate(payload.getAssignmentFromDate());
        instance.setAssignmentToDate(payload.getAssignmentToDate());
        return repository.save(instance);
    }

    public void delete(Long assignmentAssignmentID) throws ModelException {
        if (!repository.existsById(assignmentAssignmentID)) throw new ModelException("Not found-Delete");
        repository.deleteById(assignmentAssignmentID);
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, AssignmentConstants.CLASS_NAME);
    }

    private List<Assignment> solveAssignmentTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, AssignmentConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber()).stream()
                .filter(instance -> applyMemoryFilters(request, instance)).collect(Collectors.toList());
    }
    
    private int solveAssignmentTypedCountQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, AssignmentConstants.CLASS_NAME)).stream()
                .filter(instance -> applyMemoryFilters(request, instance)).collect(Collectors.toList()).size();
    }
    
    /*
     * Returns the population of class Assignment
     *
     * @return Population of class Assignment
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<Assignment> get() {
        return repository.findAll();
    }

    /*
     * Gets the properties of DisplaySet DSAssignmentDetails for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet DSAssignmentDetails for a given instance
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public com.integranova.spring.expensereportdemo.viewmodel.assignment.ds.DSAssignmentDetails getDSAssignmentDetails(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        Assignment instance = (relatedInstancePath.isEmpty() ? 
                getByJsonOid(instanceOid):
                getByRelated(buildRelatedInstance(instanceOid, relatedInstancePath), relatedInstancePath).get(0));
        return new com.integranova.spring.expensereportdemo.viewmodel.assignment.ds.DSAssignmentDetails(instance);
    }

    /*
     * Gets the properties of DisplaySet DSAssignments for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet DSAssignments for a given instance
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public com.integranova.spring.expensereportdemo.viewmodel.assignment.ds.DSAssignments getDSAssignments(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        Assignment instance = (relatedInstancePath.isEmpty() ? 
                getByJsonOid(instanceOid):
                getByRelated(buildRelatedInstance(instanceOid, relatedInstancePath), relatedInstancePath).get(0));
        return new com.integranova.spring.expensereportdemo.viewmodel.assignment.ds.DSAssignments(instance);
    }

    /*
     * Returns the population of class Assignment that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class Assignment matching the search criteria
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<Assignment> get(QueryRequest queryRequest) {
        return solveAssignmentTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveAssignmentTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveAssignmentTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel();
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
        return new PopulationResponseViewModel(solveAssignmentTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of Assignment by ID
     *
     * @param assignmentAssignmentID Identification field assignmentAssignmentID
     *
     * @return Instance of Assignment
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Assignment getById(Long assignmentAssignmentID) {
        return getByOID(new AssignmentOid(assignmentAssignmentID));
    }
    
    /*
     * Returns an instance of Assignment by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Assignment
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Assignment getByOID(AssignmentOid oid) {
        Optional<Assignment> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of Assignment by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Assignment
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Assignment getByOIDWithHV(AssignmentOid oid) {
        Optional<Assignment> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<Assignment> getInstanceByOid(AssignmentOid oid) {
        return oid != null && oid.getAssignmentAssignmentID() != null
               ? repository.findById(oid.getAssignmentAssignmentID())
               : Optional.empty();
    }
    
    /*
     * Returns an instance of Assignment by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of Assignment
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Assignment getByJsonOid(String jsonOid) {
        AssignmentOid oid = new AssignmentOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of Assignment related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of Assignment
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<Assignment> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveAssignmentTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of Assignment related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of Assignment
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<Assignment> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of Assignment
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of Assignment
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public InstanceResponseViewModel getAssignmentDynamic(AssignmentOid oid, String displaySetItems) {
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
    public String getSuppInfo(AssignmentOid oid, String dsName) {
        Assignment instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(Assignment instance, String dsName) {
        return instance != null && dsName.isEmpty() ? instance.getOid().toJson() : "";
    }


    @Override
    protected void applyQueryFilters(FilterRequest filterRequest, SQLSelect sql) {
        if (AssignmentConstants.FILTER_NAME_FASSIGNMENTS.equalsIgnoreCase(filterRequest.getName()))
            fAssignments(filterRequest, sql);
    }

    private boolean applyMemoryFilters(QueryRequest queryRequest, Assignment instance) {
        for (FilterRequest filterRequest : queryRequest.getFilters()) {
            if (!applyMemoryFilter(filterRequest, instance))
                return false;
        }
        return true;
    }
    
    private boolean applyMemoryFilter(FilterRequest filterRequest, Assignment instance) {
        return applyMemoryQueryFilter(filterRequest, instance);
    }

    private boolean applyMemoryQueryFilter(FilterRequest filterRequest, Assignment entity) {
        if (AssignmentConstants.FILTER_NAME_FASSIGNMENTS.equalsIgnoreCase(filterRequest.getName()))
            return inMemoryFAssignments(filterRequest,  entity);
        return true;
    }


    private void fAssignments(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        List<String> vProjectList = filterRequest.hasFilterVariable(AssignmentConstants.VAR_NAME_FASSIGNMENTS_VPROJECT) ? toJsonArray(filterRequest.getFilterVariable(AssignmentConstants.VAR_NAME_FASSIGNMENTS_VPROJECT)) : null;
        Project vProject = vProjectList != null ? new Project(new ProjectOid().fromJsonString(vProjectList.get(0))) : null;
        String vName = filterRequest.hasFilterVariable(AssignmentConstants.VAR_NAME_FASSIGNMENTS_VNAME) ? (String) filterRequest.getFilterVariable(AssignmentConstants.VAR_NAME_FASSIGNMENTS_VNAME, FilterVariableRequest.STRING) : null;
        String vSurname = filterRequest.hasFilterVariable(AssignmentConstants.VAR_NAME_FASSIGNMENTS_VSURNAME) ? (String) filterRequest.getFilterVariable(AssignmentConstants.VAR_NAME_FASSIGNMENTS_VSURNAME, FilterVariableRequest.STRING) : null;

        // Project = vProject
        if (vProjectList != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(AssignmentConstants.ROLE_NAME_PROJECT, ProjectConstants.CLASS_NAME);
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(AssignmentConstants.VAR_NAME_FASSIGNMENTS_VPROJECT, ProjectConstants.CLASS_NAME, ProjectConstants.CLASS_NAME, vProject.getOid(), AssignmentConstants.VAR_NAME_FASSIGNMENTS_VPROJECT);
            comparison1.setSecondOperand(operand223);
            conjunction.addOperand(comparison1);

        }        

        // Employee.EmpName LIKE vName
        if (vName != null) {
            // 'like' Comparison
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(AssignmentConstants.ROLE_NAME_EMPLOYEE + "." + EmployeeConstants.ATTR_NAME_EMPLOYEEEMPNAME, Constants.Type.STRING.getTypeName());
            comparison2.setFirstOperand(operand113);
            
            // Operand 2
            SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(vName, Constants.Type.STRING.getTypeName());
            comparison2.setSecondOperand(operand224);
            conjunction.addOperand(comparison2);

        }        

        // Employee.EmpSurname LIKE vSurname
        if (vSurname != null) {
            // 'like' Comparison
            SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
            comparison3.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(AssignmentConstants.ROLE_NAME_EMPLOYEE + "." + EmployeeConstants.ATTR_NAME_EMPLOYEEEMPSURNAME, Constants.Type.STRING.getTypeName());
            comparison3.setFirstOperand(operand114);
            
            // Operand 2
            SQLWhereOperandLiteral operand225 = new SQLWhereOperandLiteral(vSurname, Constants.Type.STRING.getTypeName());
            comparison3.setSecondOperand(operand225);
            conjunction.addOperand(comparison3);

        }        

        sql.addConjunction(conjunction);
    }

    private boolean inMemoryFAssignments(FilterRequest filterRequest, Assignment entity) {
        boolean result = true;
        Boolean vActive = filterRequest.hasFilterVariable(AssignmentConstants.VAR_NAME_FASSIGNMENTS_VACTIVE) ? (Boolean) filterRequest.getFilterVariable(AssignmentConstants.VAR_NAME_FASSIGNMENTS_VACTIVE, FilterVariableRequest.BOOL) : null;

        // IsActive = vActive
        try {
            if (vActive != null) {
                result = (entity.getAssignmentIsActive()).equals(vActive);
            }
        } catch(Exception e) {
           LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
        return result;
    }

    // IIU Methods

    /*
     * Returns a viewmodel for class Assignment with displayset DSAssignmentDetails for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class Assignment with displayset DSAssignmentDetails
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public com.integranova.spring.expensereportdemo.viewmodel.assignment.ds.DSAssignmentDetails iIUAssignment(AssignmentOid oid) {
        return new com.integranova.spring.expensereportdemo.viewmodel.assignment.ds.DSAssignmentDetails(getByOIDWithHV(oid));
    }


    /*
     * Solves the query needed for PIUAssignments
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Assignment using displayset DSAssignments that 
     * match the search criteria
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<com.integranova.spring.expensereportdemo.viewmodel.assignment.ds.DSAssignments> piuPIUAssignments(QueryRequest queryRequest) {
        return solveAssignmentTypedQuery(queryRequest).stream()
                .map(com.integranova.spring.expensereportdemo.viewmodel.assignment.ds.DSAssignments::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUAssignments
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUAssignments
     */
    public int getCount4PIUAssignments(QueryRequest queryRequest) {
        return solveAssignmentTypedQuery(queryRequest).size();
    }

    // Service: newAssignment

    /*
     * Entry point for service newAssignment
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse newAssignment(
            com.integranova.spring.expensereportdemo.viewmodel.assignment.siu.NewAssignmentRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = assignmentSrv.newAssignmentTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service newAssignment
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse newAssignmentTxn(
            com.integranova.spring.expensereportdemo.viewmodel.assignment.siu.NewAssignmentRequest request) throws ModelException {
        request.setAssignmentnewAssignmentpagrProjectInstance(projectSrv.getByOIDWithHV(request.getAssignmentnewAssignmentpagrProject()));
        request.setAssignmentnewAssignmentpagrEmployeeInstance(employeeSrv.getByOIDWithHV(request.getAssignmentnewAssignmentpagrEmployee()));
        return assignmentSrv.newAssignmentImplementation(request);
    }

    /*
     * Implements service newAssignment
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse newAssignmentImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.assignment.siu.NewAssignmentRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Project assignmentnewAssignmentpagrProject = request.getAssignmentnewAssignmentpagrProjectInstance();
        Employee assignmentnewAssignmentpagrEmployee = request.getAssignmentnewAssignmentpagrEmployeeInstance();
        Date assignmentnewAssignmentpatrFromDate = request.getAssignmentnewAssignmentpatrFromDate();

        request.checkArguments();

        newAssignmentPreconditions(request);
        Assignment instance = new Assignment();
        instance.add2Project(assignmentnewAssignmentpagrProject);

        instance.add2Employee(assignmentnewAssignmentpagrEmployee);

        instance.setAssignmentAssignmentID(Long.valueOf(0));
        instance.setAssignmentToDate(null);
        instance.setAssignmentFromDate(assignmentnewAssignmentpatrFromDate);
        
        response.setInstance(repository.save(instance));

        return response;
    }

    /*
     * Checks service newAssignment preconditions individually
     *
     * @param request Service request viewmodel
     *
     * @return Service preconditions evaluation result
     */
    public ServiceResponse newAssignmentCheckPreconditions(com.integranova.spring.expensereportdemo.viewmodel.assignment.siu.NewAssignmentRequest request) {
        ServiceResponse response = new ServiceResponse();
        request.setAssignmentnewAssignmentpagrProjectInstance(projectSrv.getByOIDWithHV(request.getAssignmentnewAssignmentpagrProject()));
        request.setAssignmentnewAssignmentpagrEmployeeInstance(employeeSrv.getByOIDWithHV(request.getAssignmentnewAssignmentpagrEmployee()));
        try {
            if("Clas_1468338274304118Pre_1".equals(request.getPreconditionId()))
                checkClas1468338274304118Pre1(request);
            if("Clas_1468338274304118Pre_2".equals(request.getPreconditionId()))
                checkClas1468338274304118Pre2(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void newAssignmentPreconditions(
            com.integranova.spring.expensereportdemo.viewmodel.assignment.siu.NewAssignmentRequest request) 
            throws ModelException {
        checkClas1468338274304118Pre1(request);
        checkClas1468338274304118Pre2(request);
    }

    private void checkClas1468338274304118Pre1 (
            com.integranova.spring.expensereportdemo.viewmodel.assignment.siu.NewAssignmentRequest request) 
            throws ModelException {
        // EXIST( pagrEmployee.Assignments ) WHERE (pagrEmployee.Assignments.Employee = pagrEmployee AND pagrEmployee.Assignments.IsActive = true) = false

        Employee assignmentnewAssignmentpagrEmployee = request.getAssignmentnewAssignmentpagrEmployeeInstance();
        try {
            boolean preconditionHolds = repository.assocOperator000(assignmentnewAssignmentpagrEmployee).equals(false);
            if (!preconditionHolds) throw new PreconditionException("Employee is already actively assigned to this project");
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
    }

    private void checkClas1468338274304118Pre2 (
            com.integranova.spring.expensereportdemo.viewmodel.assignment.siu.NewAssignmentRequest request) 
            throws ModelException {
        // EXIST( pagrProject.Team.Employees ) WHERE (pagrProject.Team.Employees = pagrEmployee) = true

        Project assignmentnewAssignmentpagrProject = request.getAssignmentnewAssignmentpagrProjectInstance();
        Employee assignmentnewAssignmentpagrEmployee = request.getAssignmentnewAssignmentpagrEmployeeInstance();
        try {
            boolean preconditionHolds = repository.assocOperator001(assignmentnewAssignmentpagrProject, assignmentnewAssignmentpagrEmployee).equals(true);
            if (!preconditionHolds) throw new PreconditionException("Employee must belong to the team this project is assigned to");
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
    }

    // Service: deleteAssignment

    /*
     * Entry point for service deleteAssignment
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse deleteAssignment(
            com.integranova.spring.expensereportdemo.viewmodel.assignment.siu.DeleteAssignmentRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = assignmentSrv.deleteAssignmentTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service deleteAssignment
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse deleteAssignmentTxn(
            com.integranova.spring.expensereportdemo.viewmodel.assignment.siu.DeleteAssignmentRequest request) throws ModelException {
        request.setAssignmentdeleteAssignmentpthisAssignmentInstance(assignmentSrv.getByOIDWithHV(request.getAssignmentdeleteAssignmentpthisAssignment()));
        return assignmentSrv.deleteAssignmentImplementation(request);
    }

    /*
     * Implements service deleteAssignment
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse deleteAssignmentImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.assignment.siu.DeleteAssignmentRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Assignment assignmentdeleteAssignmentpthisAssignment = request.getAssignmentdeleteAssignmentpthisAssignmentInstance();

        request.checkArguments();
        Assignment instance = assignmentdeleteAssignmentpthisAssignment;

        repository.delete(instance);
        
        response.setInstance(instance);

        return response;
    }

    // Service: editAssignment

    /*
     * Entry point for service editAssignment
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse editAssignment(
            com.integranova.spring.expensereportdemo.viewmodel.assignment.siu.EditAssignmentRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = assignmentSrv.editAssignmentTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service editAssignment
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse editAssignmentTxn(
            com.integranova.spring.expensereportdemo.viewmodel.assignment.siu.EditAssignmentRequest request) throws ModelException {
        request.setAssignmenteditAssignmentpthisAssignmentInstance(assignmentSrv.getByOIDWithHV(request.getAssignmenteditAssignmentpthisAssignment()));
        return assignmentSrv.editAssignmentImplementation(request);
    }

    /*
     * Implements service editAssignment
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse editAssignmentImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.assignment.siu.EditAssignmentRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Assignment assignmenteditAssignmentpthisAssignment = request.getAssignmenteditAssignmentpthisAssignmentInstance();
        Date assignmenteditAssignmentpFromDate = request.getAssignmenteditAssignmentpFromDate();

        request.checkArguments();
        Assignment instance = assignmenteditAssignmentpthisAssignment;
        instance.setAssignmentFromDate(assignmenteditAssignmentpFromDate);


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: terminateAssignment

    /*
     * Entry point for service terminateAssignment
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse terminateAssignment(
            com.integranova.spring.expensereportdemo.viewmodel.assignment.siu.TerminateAssignmentRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = assignmentSrv.terminateAssignmentTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service terminateAssignment
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse terminateAssignmentTxn(
            com.integranova.spring.expensereportdemo.viewmodel.assignment.siu.TerminateAssignmentRequest request) throws ModelException {
        request.setAssignmentterminateAssignmentpthisAssignmentInstance(assignmentSrv.getByOIDWithHV(request.getAssignmentterminateAssignmentpthisAssignment()));
        return assignmentSrv.terminateAssignmentImplementation(request);
    }

    /*
     * Implements service terminateAssignment
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse terminateAssignmentImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.assignment.siu.TerminateAssignmentRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Assignment assignmentterminateAssignmentpthisAssignment = request.getAssignmentterminateAssignmentpthisAssignmentInstance();
        Date assignmentterminateAssignmentpTerminationDate = request.getAssignmentterminateAssignmentpTerminationDate();

        request.checkArguments();
        Assignment instance = assignmentterminateAssignmentpthisAssignment;
        instance.setAssignmentToDate(assignmentterminateAssignmentpTerminationDate);


        response.setInstance(repository.save(instance));

        return response;
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildAssignmentRelatedInstance(relatedInstanceJsonOid);
        }
        if (AssignmentConstants.ROLE_NAME_EMPLOYEE.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAssignmentRelatedInstance4Employee(relatedInstanceJsonOid, remainingPath);
        }
        if (AssignmentConstants.ROLE_NAME_PROJECT.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAssignmentRelatedInstance4Project(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildAssignmentRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new Assignment(mapper.readValue(relatedInstanceJsonOid, AssignmentOid.class));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildAssignmentRelatedInstance4Employee(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Employee(mapper.readValue(relatedInstanceJsonOid, EmployeeOid.class)): employeeSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildAssignmentRelatedInstance4Project(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Project(mapper.readValue(relatedInstanceJsonOid, ProjectOid.class)): projectSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            AssignmentOid oid = new AssignmentOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(AssignmentConstants.ATTR_FIELD_ASSIGNMENTASSIGNMENTID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getAssignmentAssignmentID(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(AssignmentService.class).error(e.getMessage());
        }
    }

}
