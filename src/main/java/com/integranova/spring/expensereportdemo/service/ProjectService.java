package com.integranova.spring.expensereportdemo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.ExpenseReportConstants;
import com.integranova.spring.expensereportdemo.global.ProjectConstants;
import com.integranova.spring.expensereportdemo.persistence.AbstractAppEntity;
import com.integranova.spring.expensereportdemo.persistence.Assignment;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.ERTemplate;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.oid.AssignmentOid;
import com.integranova.spring.expensereportdemo.persistence.oid.EmployeeOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ERTemplateOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseReportOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ProjectOid;
import com.integranova.spring.expensereportdemo.persistence.oid.TeamOid;
import com.integranova.spring.expensereportdemo.persistence.Project;
import com.integranova.spring.expensereportdemo.persistence.Team;
import com.integranova.spring.expensereportdemo.repository.ProjectJpaRepository;
import com.integranova.spring.expensereportdemo.service.AssignmentService;
import com.integranova.spring.expensereportdemo.service.ProjectService;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereComparison;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereConjunction;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereDisjunction;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandLiteral;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandPathAttribute;
import com.integranova.spring.expensereportdemo.viewmodel.FilterRequest;
import com.integranova.spring.expensereportdemo.viewmodel.FilterVariableRequest;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.project.crud.ProjectPostViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.project.crud.ProjectPutViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.QueryRequest;
import com.integranova.spring.expensereportdemo.viewmodel.QueryResponse;
import com.integranova.spring.expensereportdemo.viewmodel.ServiceResponse;
import java.sql.Date;
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
public class ProjectService extends AbstractService {

    @Autowired
    private ProjectJpaRepository repository;

    @Autowired
    private ProjectService projectSrv;

    @Autowired
    private TeamService teamSrv;

    @Autowired
    private ERTemplateService eRTemplateSrv;

    @Autowired
    private AssignmentService assignmentSrv;

    @Autowired
    private EmployeeService employeeSrv;

    @Autowired
    private ExpenseCurrencyService expenseCurrencySrv;

    @Autowired
    private ExpenseReportService expenseReportSrv;
    
    public Project post(ProjectPostViewModel payload) {
        Project instance = new Project();
        instance.setProjectProjectName(payload.getProjectProjectName());
        instance.setProjectProDescription(payload.getProjectProDescription());
        return repository.save(instance);
    }

    public Project put(Long projectidProject, ProjectPutViewModel payload) throws ModelException {
        if (!repository.existsById(projectidProject)) throw new ModelException("Not found-Put");
        Project instance = new Project(new ProjectOid(projectidProject));
        instance.setProjectProjectName(payload.getProjectProjectName());
        instance.setProjectProDescription(payload.getProjectProDescription());
        instance.setProjectCompletionDate(payload.getProjectCompletionDate());
        return repository.save(instance);
    }

    public void delete(Long projectidProject) throws ModelException {
        if (!repository.existsById(projectidProject)) throw new ModelException("Not found-Delete");
        repository.deleteById(projectidProject);
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, ProjectConstants.CLASS_NAME);
    }

    private List<Project> solveProjectTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, ProjectConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber()).stream()
                .filter(instance -> applyMemoryFilters(request, instance)).collect(Collectors.toList());
    }
    
    private int solveProjectTypedCountQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, ProjectConstants.CLASS_NAME)).stream()
                .filter(instance -> applyMemoryFilters(request, instance)).collect(Collectors.toList()).size();
    }
    
    /*
     * Returns the population of class Project
     *
     * @return Population of class Project
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<Project> get() {
        return repository.findAll();
    }
    
    /*
     * Gets the preloaded list of objects of class Project
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return Preloaded list of objects of class Project
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<PreloadViewModel> getPreload(QueryRequest queryRequest) {
        List<PreloadViewModel> results = new ArrayList<>();
        List<Project> instances = get(queryRequest);
        if(ProjectConstants.DSDSPROJECT.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSProject())).collect(Collectors.toList());
        }
        if(ProjectConstants.DSDSPROJECTSUP.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSProjectSup())).collect(Collectors.toList());
        }
        return results;
    }

    /*
     * Gets the properties of DisplaySet DSProject for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet DSProject for a given instance
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public com.integranova.spring.expensereportdemo.viewmodel.project.ds.DSProject getDSProject(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        Project instance = (relatedInstancePath.isEmpty() ? 
                getByJsonOid(instanceOid):
                getByRelated(buildRelatedInstance(instanceOid, relatedInstancePath), relatedInstancePath).get(0));
        return new com.integranova.spring.expensereportdemo.viewmodel.project.ds.DSProject(instance);
    }

    /*
     * Gets the properties of DisplaySet DSProjectSup for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet DSProjectSup for a given instance
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public com.integranova.spring.expensereportdemo.viewmodel.project.ds.DSProjectSup getDSProjectSup(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        Project instance = (relatedInstancePath.isEmpty() ? 
                getByJsonOid(instanceOid):
                getByRelated(buildRelatedInstance(instanceOid, relatedInstancePath), relatedInstancePath).get(0));
        return new com.integranova.spring.expensereportdemo.viewmodel.project.ds.DSProjectSup(instance);
    }

    /*
     * Returns the population of class Project that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class Project matching the search criteria
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<Project> get(QueryRequest queryRequest) {
        return solveProjectTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveProjectTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveProjectTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel(solveProjectTypedQuery(queryRequest).stream()
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
        return new PopulationResponseViewModel(solveProjectTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of Project by ID
     *
     * @param projectidProject Identification field projectidProject
     *
     * @return Instance of Project
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Project getById(Long projectidProject) {
        return getByOID(new ProjectOid(projectidProject));
    }
    
    /*
     * Returns an instance of Project by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Project
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Project getByOID(ProjectOid oid) {
        Optional<Project> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of Project by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Project
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Project getByOIDWithHV(ProjectOid oid) {
        Optional<Project> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<Project> getInstanceByOid(ProjectOid oid) {
        return oid != null && oid.getProjectidProject() != null
               ? repository.findById(oid.getProjectidProject())
               : Optional.empty();
    }
    
    /*
     * Returns an instance of Project by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of Project
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Project getByJsonOid(String jsonOid) {
        ProjectOid oid = new ProjectOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of Project related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of Project
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<Project> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveProjectTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of Project related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of Project
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<Project> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of Project
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of Project
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public InstanceResponseViewModel getProjectDynamic(ProjectOid oid, String displaySetItems) {
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
    public String getSuppInfo(ProjectOid oid, String dsName) {
        Project instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(Project instance, String dsName) {
        if (ProjectConstants.DSDSPROJECTSUP.equals(dsName))
            return instance.buildDSProjectSup();
        return instance != null && dsName.isEmpty() ? instance.getOid().toJson() : "";
    }

    public static PreloadViewModel buildPreloadViewModel(Project instance, String dsName) {
        if (ProjectConstants.DSDSPROJECT.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSProject());
        if (ProjectConstants.DSDSPROJECTSUP.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSProjectSup());
        return new PreloadViewModel(instance.getOid().toJson(), "");
    }


    @Override
    protected void applyQueryFilters(FilterRequest filterRequest, SQLSelect sql) {
        if (ProjectConstants.FILTER_NAME_FPROJECTS.equalsIgnoreCase(filterRequest.getName()))
            fProjects(filterRequest, sql);
    }

    @Override
    protected void applyServiceSIFilters(FilterRequest filterRequest, SQLSelect sql) {
        if ("SuppInfo_DS_ProjectSup".equals(filterRequest.getName()))
            suppInfo4DSProjectSup(filterRequest.getFilterVariable("searchText").toString(), sql);
    }

    private boolean applyMemoryFilters(QueryRequest queryRequest, Project instance) {
        for (FilterRequest filterRequest : queryRequest.getFilters()) {
            if (!applyMemoryFilter(filterRequest, instance))
                return false;
        }
        return true;
    }
    
    private boolean applyMemoryFilter(FilterRequest filterRequest, Project instance) {
        return applyMemoryQueryFilter(filterRequest, instance) && applyMemoryNavigationalFilter(filterRequest, instance);
    }

    private boolean applyMemoryQueryFilter(FilterRequest filterRequest, Project entity) {
        if (ProjectConstants.FILTER_NAME_FPROJECTS.equalsIgnoreCase(filterRequest.getName()))
            return inMemoryFProjects(filterRequest,  entity);
        return true;
    }

    private boolean applyMemoryNavigationalFilter(FilterRequest filterRequest, Project entity) {
        if ("ExpenseReport_TNEW_pt_p_agrProject_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            return inMemoryClas1057569177600553FiltNav2(filterRequest, entity);
        return true;
    }


    private void fProjects(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        String vName = filterRequest.hasFilterVariable(ProjectConstants.VAR_NAME_FPROJECTS_VNAME) ? (String) filterRequest.getFilterVariable(ProjectConstants.VAR_NAME_FPROJECTS_VNAME, FilterVariableRequest.STRING) : null;

        // ProjectName LIKE vName
        if (vName != null) {
            // 'like' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(ProjectConstants.ATTR_NAME_PROJECTPROJECTNAME, Constants.Type.STRING.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(vName, Constants.Type.STRING.getTypeName());
            comparison1.setSecondOperand(operand223);
            conjunction.addOperand(comparison1);

        }        

        sql.addConjunction(conjunction);
    }

    private boolean inMemoryFProjects(FilterRequest filterRequest, Project entity) {
        boolean result = true;
        Boolean vCompleted = filterRequest.hasFilterVariable(ProjectConstants.VAR_NAME_FPROJECTS_VCOMPLETED) ? (Boolean) filterRequest.getFilterVariable(ProjectConstants.VAR_NAME_FPROJECTS_VCOMPLETED, FilterVariableRequest.BOOL) : null;

        // Completed = vCompleted
        try {
            if (vCompleted != null) {
                result = (entity.getProjectCompleted()).equals(vCompleted);
            }
        } catch(Exception e) {
           LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
        return result;
    }

    private boolean inMemoryClas1057569177600553FiltNav2(FilterRequest filterRequest, Project entity) {
        boolean result = true;
        Employee expenseReportTNEWptpagrEmployee = filterRequest.hasFilterVariable(ExpenseReportConstants.ARG_NAME_TNEW_EXPENSEREPORTTNEWPTPAGREMPLOYEE) ? new Employee(new EmployeeOid().fromJsonString(toJson(filterRequest.getFilterVariable(ExpenseReportConstants.ARG_NAME_TNEW_EXPENSEREPORTTNEWPTPAGREMPLOYEE)))) : null;
        Date expenseReportTNEWptpatrPresentDate = filterRequest.hasFilterVariable(ExpenseReportConstants.ARG_NAME_TNEW_EXPENSEREPORTTNEWPTPATRPRESENTDATE) ? (Date) filterRequest.getFilterVariable(ExpenseReportConstants.ARG_NAME_TNEW_EXPENSEREPORTTNEWPTPATRPRESENTDATE, FilterVariableRequest.DATE) : null;

        // EXIST (Assignments) WHERE (Assignments.Employee = ptpagrEmployee AND Assignments.IsActive = true AND Assignments.FromDate <= ptpatrPresentDate) = true
        if (expenseReportTNEWptpagrEmployee != null && expenseReportTNEWptpatrPresentDate != null) {
            try {
                result = repository.assocOperator000(entity, expenseReportTNEWptpagrEmployee, expenseReportTNEWptpatrPresentDate).equals(true);
            } catch (Exception e) {
                LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
        return result;
    }

    // IIU Methods

    /*
     * Returns a viewmodel for class Project with displayset DSProject for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class Project with displayset DSProject
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public com.integranova.spring.expensereportdemo.viewmodel.project.ds.DSProject iIUProject(ProjectOid oid) {
        return new com.integranova.spring.expensereportdemo.viewmodel.project.ds.DSProject(getByOIDWithHV(oid));
    }

    /*
     * Returns a viewmodel for class Project with displayset DSProject for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class Project with displayset DSProject
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public com.integranova.spring.expensereportdemo.viewmodel.project.ds.DSProject iIUProjectReports(ProjectOid oid) {
        return new com.integranova.spring.expensereportdemo.viewmodel.project.ds.DSProject(getByOIDWithHV(oid));
    }


    /*
     * Solves the query needed for PIUProject
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Project using displayset DSProject that 
     * match the search criteria
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<com.integranova.spring.expensereportdemo.viewmodel.project.ds.DSProject> piuPIUProject(QueryRequest queryRequest) {
        return solveProjectTypedQuery(queryRequest).stream()
                .map(com.integranova.spring.expensereportdemo.viewmodel.project.ds.DSProject::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUProject
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUProject
     */
    public int getCount4PIUProject(QueryRequest queryRequest) {
        return solveProjectTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for SELProject
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Project using displayset DSProject that 
     * match the search criteria
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<com.integranova.spring.expensereportdemo.viewmodel.project.ds.DSProject> piuSELProject(QueryRequest queryRequest) {
        return solveProjectTypedQuery(queryRequest).stream()
                .map(com.integranova.spring.expensereportdemo.viewmodel.project.ds.DSProject::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for SELProject
     *
     * @param queryRequest Query request
     * @returns Count of instances for SELProject
     */
    public int getCount4SELProject(QueryRequest queryRequest) {
        return solveProjectTypedQuery(queryRequest).size();
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
            com.integranova.spring.expensereportdemo.viewmodel.project.siu.CreateinstanceRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = projectSrv.createinstanceTxn(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.project.siu.CreateinstanceRequest request) throws ModelException {
        request.setProjectcreateinstancepagrTeamInstance(teamSrv.getByOIDWithHV(request.getProjectcreateinstancepagrTeam()));
        return projectSrv.createinstanceImplementation(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.project.siu.CreateinstanceRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Team projectcreateinstancepagrTeam = request.getProjectcreateinstancepagrTeamInstance();
        String projectcreateinstancepatrProjectName = request.getProjectcreateinstancepatrProjectName();
        String projectcreateinstancepatrProDescription = request.getProjectcreateinstancepatrProDescription();

        request.checkArguments();
        Project instance = new Project();
        instance.add2Team(projectcreateinstancepagrTeam);

        instance.setProjectidProject(Long.valueOf(0));
        instance.setProjectCompletionDate(null);
        instance.setProjectProjectName(projectcreateinstancepatrProjectName);
        instance.setProjectProDescription(projectcreateinstancepatrProDescription);
        
        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildDSProjectSup());

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
            com.integranova.spring.expensereportdemo.viewmodel.project.siu.DeleteinstanceRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = projectSrv.deleteinstanceTxn(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.project.siu.DeleteinstanceRequest request) throws ModelException {
        request.setProjectdeleteinstancepthisProjectInstance(projectSrv.getByOIDWithHV(request.getProjectdeleteinstancepthisProject()));
        return projectSrv.deleteinstanceImplementation(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.project.siu.DeleteinstanceRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Project projectdeleteinstancepthisProject = request.getProjectdeleteinstancepthisProjectInstance();

        request.checkArguments();
        Project instance = projectdeleteinstancepthisProject;

        repository.delete(instance);
        
        response.setInstance(instance);
        response.setInstanceSuppInfo(instance.buildDSProjectSup());

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
            com.integranova.spring.expensereportdemo.viewmodel.project.siu.EditinstanceRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = projectSrv.editinstanceTxn(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.project.siu.EditinstanceRequest request) throws ModelException {
        request.setProjecteditinstancepthisProjectInstance(projectSrv.getByOIDWithHV(request.getProjecteditinstancepthisProject()));
        return projectSrv.editinstanceImplementation(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.project.siu.EditinstanceRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Project projecteditinstancepthisProject = request.getProjecteditinstancepthisProjectInstance();
        String projecteditinstancepProjectName = request.getProjecteditinstancepProjectName();
        String projecteditinstancepProDescription = request.getProjecteditinstancepProDescription();

        request.checkArguments();
        Project instance = projecteditinstancepthisProject;
        instance.setProjectProjectName(projecteditinstancepProjectName);
        instance.setProjectProDescription(projecteditinstancepProDescription);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildDSProjectSup());

        return response;
    }

    // Service: markAsCompleted

    /*
     * Entry point for service markAsCompleted
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse markAsCompleted(
            com.integranova.spring.expensereportdemo.viewmodel.project.siu.MarkAsCompletedRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = projectSrv.markAsCompletedTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service markAsCompleted
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse markAsCompletedTxn(
            com.integranova.spring.expensereportdemo.viewmodel.project.siu.MarkAsCompletedRequest request) throws ModelException {
        request.setProjectmarkAsCompletedpthisProjectInstance(projectSrv.getByOIDWithHV(request.getProjectmarkAsCompletedpthisProject()));
        return projectSrv.markAsCompletedImplementation(request);
    }

    /*
     * Implements service markAsCompleted
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse markAsCompletedImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.project.siu.MarkAsCompletedRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Project projectmarkAsCompletedpthisProject = request.getProjectmarkAsCompletedpthisProjectInstance();
        Date projectmarkAsCompletedpCompletionDate = request.getProjectmarkAsCompletedpCompletionDate();

        request.checkArguments();
        Project instance = projectmarkAsCompletedpthisProject;
        instance.setProjectCompletionDate(projectmarkAsCompletedpCompletionDate);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildDSProjectSup());

        return response;
    }

    // Service: assignTemplateToProject

    /*
     * Entry point for service assignTemplateToProject
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse assignTemplateToProject(
            com.integranova.spring.expensereportdemo.viewmodel.project.siu.AssignTemplateToProjectRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = projectSrv.assignTemplateToProjectTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service assignTemplateToProject
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse assignTemplateToProjectTxn(
            com.integranova.spring.expensereportdemo.viewmodel.project.siu.AssignTemplateToProjectRequest request) throws ModelException {
        request.setProjectassignTemplateToProjectpthisProjectInstance(projectSrv.getByOIDWithHV(request.getProjectassignTemplateToProjectpthisProject()));
        request.setProjectassignTemplateToProjectpevcERTemplateInstance(eRTemplateSrv.getByOIDWithHV(request.getProjectassignTemplateToProjectpevcERTemplate()));
        return projectSrv.assignTemplateToProjectImplementation(request, true);
    }

    /*
     * Implements service assignTemplateToProject
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse assignTemplateToProjectImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.project.siu.AssignTemplateToProjectRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Project projectassignTemplateToProjectpthisProject = request.getProjectassignTemplateToProjectpthisProjectInstance();
        ERTemplate projectassignTemplateToProjectpevcERTemplate = request.getProjectassignTemplateToProjectpevcERTemplateInstance();

        request.checkArguments();
        Project instance = projectassignTemplateToProjectpthisProject;

        instance.getERTemplates().add(projectassignTemplateToProjectpevcERTemplate);
        if (isEntryPoint) {
            com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.AssignTemplateToProjectRequest relatedRequest = new com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.AssignTemplateToProjectRequest();
            relatedRequest.setERTemplateassignTemplateToProjectpthisERTemplateInstance(projectassignTemplateToProjectpevcERTemplate);
            relatedRequest.setERTemplateassignTemplateToProjectpevcProjectInstance(projectassignTemplateToProjectpthisProject);
            eRTemplateSrv.assignTemplateToProjectImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildDSProjectSup());

        return response;
    }

    // Service: deassignTemplate

    /*
     * Entry point for service deassignTemplate
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse deassignTemplate(
            com.integranova.spring.expensereportdemo.viewmodel.project.siu.DeassignTemplateRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = projectSrv.deassignTemplateTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service deassignTemplate
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse deassignTemplateTxn(
            com.integranova.spring.expensereportdemo.viewmodel.project.siu.DeassignTemplateRequest request) throws ModelException {
        request.setProjectdeassignTemplatepthisProjectInstance(projectSrv.getByOIDWithHV(request.getProjectdeassignTemplatepthisProject()));
        request.setProjectdeassignTemplatepevcERTemplateInstance(eRTemplateSrv.getByOIDWithHV(request.getProjectdeassignTemplatepevcERTemplate()));
        return projectSrv.deassignTemplateImplementation(request, true);
    }

    /*
     * Implements service deassignTemplate
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse deassignTemplateImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.project.siu.DeassignTemplateRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Project projectdeassignTemplatepthisProject = request.getProjectdeassignTemplatepthisProjectInstance();
        ERTemplate projectdeassignTemplatepevcERTemplate = request.getProjectdeassignTemplatepevcERTemplateInstance();

        request.checkArguments();
        Project instance = projectdeassignTemplatepthisProject;

        instance.getERTemplates().remove(projectdeassignTemplatepevcERTemplate);
        projectdeassignTemplatepevcERTemplate.getProjects().remove(instance);
        if (isEntryPoint) {
            com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.DeassignTemplateRequest relatedRequest = new com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.DeassignTemplateRequest();
            relatedRequest.setERTemplatedeassignTemplatepthisERTemplateInstance(projectdeassignTemplatepevcERTemplate);
            relatedRequest.setERTemplatedeassignTemplatepevcProjectInstance(projectdeassignTemplatepthisProject);
            eRTemplateSrv.deassignTemplateImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildDSProjectSup());

        return response;
    }

    // Service: TCOMPLETE

    /*
     * Entry point for service TCOMPLETE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse tCOMPLETE(
            com.integranova.spring.expensereportdemo.viewmodel.project.siu.TCOMPLETERequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = projectSrv.tCOMPLETETxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TCOMPLETE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse tCOMPLETETxn(
            com.integranova.spring.expensereportdemo.viewmodel.project.siu.TCOMPLETERequest request) throws ModelException, SystemException {
        request.setProjectTCOMPLETEpthisProjectInstance(projectSrv.getByOIDWithHV(request.getProjectTCOMPLETEpthisProject()));
        return projectSrv.tCOMPLETEImplementation(request);
    }

    /*
     * Implements service TCOMPLETE
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse tCOMPLETEImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.project.siu.TCOMPLETERequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        Date projectTCOMPLETEpCompletionDate = request.getProjectTCOMPLETEpCompletionDate();
        Project projectTCOMPLETEpthisProject = request.getProjectTCOMPLETEpthisProjectInstance();

        request.checkArguments();
        Project instance = projectTCOMPLETEpthisProject;

        for(Assignment step1Entity : repository.assocOperator005(projectTCOMPLETEpthisProject)) {
            com.integranova.spring.expensereportdemo.viewmodel.assignment.siu.TerminateAssignmentRequest step1Request = new com.integranova.spring.expensereportdemo.viewmodel.assignment.siu.TerminateAssignmentRequest();
            step1Request.setAssignmentterminateAssignmentpthisAssignmentInstance(step1Entity);
            step1Request.setAssignmentterminateAssignmentpTerminationDate(projectTCOMPLETEpCompletionDate);
            assignmentSrv.terminateAssignmentImplementation(step1Request);
        }

        com.integranova.spring.expensereportdemo.viewmodel.project.siu.MarkAsCompletedRequest step2Request = new com.integranova.spring.expensereportdemo.viewmodel.project.siu.MarkAsCompletedRequest();
        step2Request.setProjectmarkAsCompletedpthisProjectInstance(projectTCOMPLETEpthisProject);
        step2Request.setProjectmarkAsCompletedpCompletionDate(projectTCOMPLETEpCompletionDate);
        projectSrv.markAsCompletedImplementation(step2Request);

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildDSProjectSup());

        return response;
    }


    private void suppInfo4DSProjectSup(String searchText, SQLSelect select) {
        try {
            SQLWhereDisjunction disjunction = new SQLWhereDisjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(select);
            comparison1.setOperator("LIKE");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(ProjectConstants.ATTR_NAME_PROJECTPROJECTNAME, Constants.Type.STRING.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(searchText, Constants.Type.STRING.getTypeName()));
            disjunction.addComparison(comparison1);

            select.addDisjunction(disjunction);
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
    }

    @Override
    protected void applyOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        applyOCOCProject(queryRequest, select);
        applyDSItemSort(queryRequest, select);
    }
    

    private void applyOCOCProject(QueryRequest queryRequest, SQLSelect select) {
        if ("OC_Project".equalsIgnoreCase(queryRequest.getOrderCriteriaName())) {
            select.getOrderByPart().addItem(Constants.normalizePath(ProjectConstants.CLASS_NAME, ProjectConstants.ATTR_NAME_PROJECTPROJECTNAME, false), true);
        }
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildProjectRelatedInstance(relatedInstanceJsonOid);
        }
        if (ProjectConstants.ROLE_NAME_EXPENSEREPORT.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildProjectRelatedInstance4ExpenseReport(relatedInstanceJsonOid, remainingPath);
        }
        if (ProjectConstants.ROLE_NAME_ASSIGNMENTS.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildProjectRelatedInstance4Assignment(relatedInstanceJsonOid, remainingPath);
        }
        if (ProjectConstants.ROLE_NAME_TEAM.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildProjectRelatedInstance4Team(relatedInstanceJsonOid, remainingPath);
        }
        if (ProjectConstants.ROLE_NAME_ERTEMPLATES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildProjectRelatedInstance4ERTemplate(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildProjectRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new Project(mapper.readValue(relatedInstanceJsonOid, ProjectOid.class));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildProjectRelatedInstance4ExpenseReport(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ExpenseReport(mapper.readValue(relatedInstanceJsonOid, ExpenseReportOid.class)): expenseReportSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildProjectRelatedInstance4Assignment(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Assignment(mapper.readValue(relatedInstanceJsonOid, AssignmentOid.class)): assignmentSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildProjectRelatedInstance4Team(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Team(mapper.readValue(relatedInstanceJsonOid, TeamOid.class)): teamSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildProjectRelatedInstance4ERTemplate(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ERTemplate(mapper.readValue(relatedInstanceJsonOid, ERTemplateOid.class)): eRTemplateSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            ProjectOid oid = new ProjectOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(ProjectConstants.ATTR_FIELD_PROJECTIDPROJECT, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getProjectidProject(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(ProjectService.class).error(e.getMessage());
        }
    }

}
