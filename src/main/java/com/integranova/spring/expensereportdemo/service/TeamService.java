package com.integranova.spring.expensereportdemo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.exception.PreconditionException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.EmployeeConstants;
import com.integranova.spring.expensereportdemo.global.TeamConstants;
import com.integranova.spring.expensereportdemo.persistence.AbstractAppEntity;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.oid.EmployeeOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ProjectOid;
import com.integranova.spring.expensereportdemo.persistence.oid.TeamOid;
import com.integranova.spring.expensereportdemo.persistence.Project;
import com.integranova.spring.expensereportdemo.persistence.Team;
import com.integranova.spring.expensereportdemo.repository.TeamJpaRepository;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereComparison;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereConjunction;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereNegation;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandLiteral;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandPathAttribute;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandSubQuery;
import com.integranova.spring.expensereportdemo.viewmodel.FilterRequest;
import com.integranova.spring.expensereportdemo.viewmodel.FilterVariableRequest;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.QueryRequest;
import com.integranova.spring.expensereportdemo.viewmodel.QueryResponse;
import com.integranova.spring.expensereportdemo.viewmodel.ServiceResponse;
import com.integranova.spring.expensereportdemo.viewmodel.team.crud.TeamPostViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.team.crud.TeamPutViewModel;
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
public class TeamService extends AbstractService {

    @Autowired
    private TeamJpaRepository repository;

    @Autowired
    private TeamService teamSrv;

    @Autowired
    private EmployeeService employeeSrv;

    @Autowired
    private ProjectService projectSrv;
    
    public Team post(TeamPostViewModel payload) {
        Team instance = new Team();
        instance.setTeamname(payload.getTeamname());
        instance.setTeammaxEmployees(payload.getTeammaxEmployees());
        return repository.save(instance);
    }

    public Team put(Long teamid, TeamPutViewModel payload) throws ModelException {
        if (!repository.existsById(teamid)) throw new ModelException("Not found-Put");
        Team instance = new Team(new TeamOid(teamid));
        instance.setTeamname(payload.getTeamname());
        instance.setTeammaxEmployees(payload.getTeammaxEmployees());
        return repository.save(instance);
    }

    public void delete(Long teamid) throws ModelException {
        if (!repository.existsById(teamid)) throw new ModelException("Not found-Delete");
        repository.deleteById(teamid);
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, TeamConstants.CLASS_NAME);
    }

    private List<Team> solveTeamTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, TeamConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber()).stream()
                .filter(instance -> applyMemoryFilters(request, instance)).collect(Collectors.toList());
    }
    
    private int solveTeamTypedCountQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, TeamConstants.CLASS_NAME)).stream()
                .filter(instance -> applyMemoryFilters(request, instance)).collect(Collectors.toList()).size();
    }
    
    /*
     * Returns the population of class Team
     *
     * @return Population of class Team
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<Team> get() {
        return repository.findAll();
    }

    /*
     * Gets the properties of DisplaySet DSTeams for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet DSTeams for a given instance
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public com.integranova.spring.expensereportdemo.viewmodel.team.ds.DSTeams getDSTeams(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        Team instance = (relatedInstancePath.isEmpty() ? 
                getByJsonOid(instanceOid):
                getByRelated(buildRelatedInstance(instanceOid, relatedInstancePath), relatedInstancePath).get(0));
        return new com.integranova.spring.expensereportdemo.viewmodel.team.ds.DSTeams(instance);
    }

    /*
     * Gets the properties of DisplaySet DSTeam for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet DSTeam for a given instance
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public com.integranova.spring.expensereportdemo.viewmodel.team.ds.DSTeam getDSTeam(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        Team instance = (relatedInstancePath.isEmpty() ? 
                getByJsonOid(instanceOid):
                getByRelated(buildRelatedInstance(instanceOid, relatedInstancePath), relatedInstancePath).get(0));
        return new com.integranova.spring.expensereportdemo.viewmodel.team.ds.DSTeam(instance);
    }

    /*
     * Returns the population of class Team that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class Team matching the search criteria
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<Team> get(QueryRequest queryRequest) {
        return solveTeamTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveTeamTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveTeamTypedCountQuery(queryRequest) : 0);
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
        return new PopulationResponseViewModel(solveTeamTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of Team by ID
     *
     * @param teamid Identification field teamid
     *
     * @return Instance of Team
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Team getById(Long teamid) {
        return getByOID(new TeamOid(teamid));
    }
    
    /*
     * Returns an instance of Team by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Team
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Team getByOID(TeamOid oid) {
        Optional<Team> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of Team by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Team
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Team getByOIDWithHV(TeamOid oid) {
        Optional<Team> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<Team> getInstanceByOid(TeamOid oid) {
        return oid != null && oid.getTeamid() != null
               ? repository.findById(oid.getTeamid())
               : Optional.empty();
    }
    
    /*
     * Returns an instance of Team by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of Team
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public Team getByJsonOid(String jsonOid) {
        TeamOid oid = new TeamOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of Team related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of Team
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<Team> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveTeamTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of Team related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of Team
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<Team> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of Team
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of Team
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public InstanceResponseViewModel getTeamDynamic(TeamOid oid, String displaySetItems) {
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
    public String getSuppInfo(TeamOid oid, String dsName) {
        Team instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(Team instance, String dsName) {
        return instance != null && dsName.isEmpty() ? instance.getOid().toJson() : "";
    }


    @Override
    protected void applyQueryFilters(FilterRequest filterRequest, SQLSelect sql) {
        if (TeamConstants.FILTER_NAME_FTEAMSBYNAME.equalsIgnoreCase(filterRequest.getName()))
            fTeamsByName(filterRequest, sql);
    }

    @Override
    protected void applyNavigationalFilters(FilterRequest filterRequest, SQLSelect sql) {
        if ("Employee_addEmployeeToTeam_p_evcTeam_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            clas1057569177600607FiltNav1(filterRequest, sql);
        if ("Employee_removeEmployeeFromTeam_p_evcTeam_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            clas1057569177600607FiltNav2(filterRequest, sql);
    }

    private boolean applyMemoryFilters(QueryRequest queryRequest, Team instance) {
        for (FilterRequest filterRequest : queryRequest.getFilters()) {
            if (!applyMemoryFilter(filterRequest, instance))
                return false;
        }
        return true;
    }
    
    private boolean applyMemoryFilter(FilterRequest filterRequest, Team instance) {
        return applyMemoryQueryFilter(filterRequest, instance);
    }

    private boolean applyMemoryQueryFilter(FilterRequest filterRequest, Team entity) {
        if (TeamConstants.FILTER_NAME_FTEAMSBYNAME.equalsIgnoreCase(filterRequest.getName()))
            return inMemoryFTeamsByName(filterRequest,  entity);
        if (TeamConstants.FILTER_NAME_FTEAMSWITHCAPACITY.equalsIgnoreCase(filterRequest.getName()))
            return inMemoryFTeamsWithCapacity(entity);
        return true;
    }


    private void fTeamsByName(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        String vName = filterRequest.hasFilterVariable(TeamConstants.VAR_NAME_FTEAMSBYNAME_VNAME) ? (String) filterRequest.getFilterVariable(TeamConstants.VAR_NAME_FTEAMSBYNAME_VNAME, FilterVariableRequest.STRING) : null;

        // name LIKE vName
        if (vName != null) {
            // 'like' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(TeamConstants.ATTR_NAME_TEAMNAME, Constants.Type.STRING.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(vName, Constants.Type.STRING.getTypeName());
            comparison1.setSecondOperand(operand223);
            conjunction.addOperand(comparison1);

        }        

        sql.addConjunction(conjunction);
    }

    private boolean inMemoryFTeamsByName(FilterRequest filterRequest, Team entity) {
        boolean result = true;
        Long vCapacity = filterRequest.hasFilterVariable(TeamConstants.VAR_NAME_FTEAMSBYNAME_VCAPACITY) ? (Long) filterRequest.getFilterVariable(TeamConstants.VAR_NAME_FTEAMSBYNAME_VCAPACITY, FilterVariableRequest.INT) : null;

        // vCapacity >= (maxEmployees - countEmployees)
        try {
            if (vCapacity != null) {
                result = vCapacity >= (entity.getTeammaxEmployees() - entity.getTeamcountEmployees());
            }
        } catch(Exception e) {
           LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
        return result;
    }

    private boolean inMemoryFTeamsWithCapacity(Team entity) {
        boolean result = true;

        // countEmployees < maxEmployees
        try {
            result = entity.getTeamcountEmployees() < entity.getTeammaxEmployees();
        } catch(Exception e) {
           LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
        return result;
    }

    private void clas1057569177600607FiltNav1(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Employee employeeaddEmployeeToTeampthisEmployee = filterRequest.hasFilterVariable(EmployeeConstants.ARG_NAME_ADDEMPLOYEETOTEAM_EMPLOYEEADDEMPLOYEETOTEAMPTHISEMPLOYEE) ? new Employee(new EmployeeOid().fromJsonString(toJson(filterRequest.getFilterVariable(EmployeeConstants.ARG_NAME_ADDEMPLOYEETOTEAM_EMPLOYEEADDEMPLOYEETOTEAMPTHISEMPLOYEE)))) : null;

        // EXIST (Employees) WHERE (Employees = pthisEmployee) = false
        if (employeeaddEmployeeToTeampthisEmployee != null) {
        {
            // 'not' Logical operator
            SQLWhereNegation comparison1 = new SQLWhereNegation(sql);
        
            // Operand 1
            // 'exist' Association operator
            SQLWhereOperandSubQuery operandSubQueryAssocOperator000 = new SQLWhereOperandSubQuery(repository.assocOperator000Range1Query(employeeaddEmployeeToTeampthisEmployee, sql));
            comparison1.addOperand(operandSubQueryAssocOperator000);
            
            conjunction.addOperand(comparison1);
        }

        }        
        sql.addConjunction(conjunction);
    }

    private void clas1057569177600607FiltNav2(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Employee employeeremoveEmployeeFromTeampthisEmployee = filterRequest.hasFilterVariable(EmployeeConstants.ARG_NAME_REMOVEEMPLOYEEFROMTEAM_EMPLOYEEREMOVEEMPLOYEEFROMTEAMPTHISEMPLOYEE) ? new Employee(new EmployeeOid().fromJsonString(toJson(filterRequest.getFilterVariable(EmployeeConstants.ARG_NAME_REMOVEEMPLOYEEFROMTEAM_EMPLOYEEREMOVEEMPLOYEEFROMTEAMPTHISEMPLOYEE)))) : null;

        // EXIST (Employees) WHERE (Employees = pthisEmployee) = true
        if (employeeremoveEmployeeFromTeampthisEmployee != null) {
    // 'exist' Association operator
    SQLWhereOperandSubQuery operandSubQueryAssocOperator001 = new SQLWhereOperandSubQuery(repository.assocOperator001Range1Query(employeeremoveEmployeeFromTeampthisEmployee, sql));
    conjunction.addOperand(operandSubQueryAssocOperator001);

        }        
        sql.addConjunction(conjunction);
    }

    // IIU Methods

    /*
     * Returns a viewmodel for class Team with displayset DSTeam for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class Team with displayset DSTeam
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public com.integranova.spring.expensereportdemo.viewmodel.team.ds.DSTeam iIUTeam(TeamOid oid) {
        return new com.integranova.spring.expensereportdemo.viewmodel.team.ds.DSTeam(getByOIDWithHV(oid));
    }


    /*
     * Solves the query needed for PIUTeams
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Team using displayset DSTeams that 
     * match the search criteria
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<com.integranova.spring.expensereportdemo.viewmodel.team.ds.DSTeams> piuPIUTeams(QueryRequest queryRequest) {
        return solveTeamTypedQuery(queryRequest).stream()
                .map(com.integranova.spring.expensereportdemo.viewmodel.team.ds.DSTeams::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUTeams
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUTeams
     */
    public int getCount4PIUTeams(QueryRequest queryRequest) {
        return solveTeamTypedQuery(queryRequest).size();
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
            com.integranova.spring.expensereportdemo.viewmodel.team.siu.CreateinstanceRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = teamSrv.createinstanceTxn(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.team.siu.CreateinstanceRequest request) throws ModelException {
        return teamSrv.createinstanceImplementation(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.team.siu.CreateinstanceRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        String teamcreateinstancepatrname = request.getTeamcreateinstancepatrname();
        Long teamcreateinstancepatrmaxEmployees = request.getTeamcreateinstancepatrmaxEmployees();

        request.checkArguments();
        Team instance = new Team();
        instance.setTeamid(Long.valueOf(0));
        instance.setTeamname(teamcreateinstancepatrname);
        instance.setTeammaxEmployees(teamcreateinstancepatrmaxEmployees);
        
        response.setInstance(repository.save(instance));

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
            com.integranova.spring.expensereportdemo.viewmodel.team.siu.DeleteinstanceRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = teamSrv.deleteinstanceTxn(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.team.siu.DeleteinstanceRequest request) throws ModelException {
        request.setTeamdeleteinstancepthisTeamInstance(teamSrv.getByOIDWithHV(request.getTeamdeleteinstancepthisTeam()));
        return teamSrv.deleteinstanceImplementation(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.team.siu.DeleteinstanceRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Team teamdeleteinstancepthisTeam = request.getTeamdeleteinstancepthisTeamInstance();

        request.checkArguments();
        Team instance = teamdeleteinstancepthisTeam;

        repository.delete(instance);
        
        response.setInstance(instance);

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
            com.integranova.spring.expensereportdemo.viewmodel.team.siu.EditinstanceRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = teamSrv.editinstanceTxn(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.team.siu.EditinstanceRequest request) throws ModelException {
        request.setTeameditinstancepthisTeamInstance(teamSrv.getByOIDWithHV(request.getTeameditinstancepthisTeam()));
        return teamSrv.editinstanceImplementation(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.team.siu.EditinstanceRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Team teameditinstancepthisTeam = request.getTeameditinstancepthisTeamInstance();
        String teameditinstancepname = request.getTeameditinstancepname();
        Long teameditinstancepmaxEmployees = request.getTeameditinstancepmaxEmployees();

        request.checkArguments();
        Team instance = teameditinstancepthisTeam;
        instance.setTeamname(teameditinstancepname);
        instance.setTeammaxEmployees(teameditinstancepmaxEmployees);


        response.setInstance(repository.save(instance));

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
            com.integranova.spring.expensereportdemo.viewmodel.team.siu.AddEmployeeToTeamRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = teamSrv.addEmployeeToTeamTxn(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.team.siu.AddEmployeeToTeamRequest request) throws ModelException {
        request.setTeamaddEmployeeToTeampthisTeamInstance(teamSrv.getByOIDWithHV(request.getTeamaddEmployeeToTeampthisTeam()));
        request.setTeamaddEmployeeToTeampevcEmployeeInstance(employeeSrv.getByOIDWithHV(request.getTeamaddEmployeeToTeampevcEmployee()));
        return teamSrv.addEmployeeToTeamImplementation(request, true);
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
            com.integranova.spring.expensereportdemo.viewmodel.team.siu.AddEmployeeToTeamRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Team teamaddEmployeeToTeampthisTeam = request.getTeamaddEmployeeToTeampthisTeamInstance();
        Employee teamaddEmployeeToTeampevcEmployee = request.getTeamaddEmployeeToTeampevcEmployeeInstance();

        request.checkArguments();
        Team instance = teamaddEmployeeToTeampthisTeam;

        instance.getEmployees().add(teamaddEmployeeToTeampevcEmployee);
        if (isEntryPoint) {
            com.integranova.spring.expensereportdemo.viewmodel.employee.siu.AddEmployeeToTeamRequest relatedRequest = new com.integranova.spring.expensereportdemo.viewmodel.employee.siu.AddEmployeeToTeamRequest();
            relatedRequest.setEmployeeaddEmployeeToTeampthisEmployeeInstance(teamaddEmployeeToTeampevcEmployee);
            relatedRequest.setEmployeeaddEmployeeToTeampevcTeamInstance(teamaddEmployeeToTeampthisTeam);
            employeeSrv.addEmployeeToTeamImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
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
            com.integranova.spring.expensereportdemo.viewmodel.team.siu.RemoveEmployeeFromTeamRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = teamSrv.removeEmployeeFromTeamTxn(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.team.siu.RemoveEmployeeFromTeamRequest request) throws ModelException {
        request.setTeamremoveEmployeeFromTeampthisTeamInstance(teamSrv.getByOIDWithHV(request.getTeamremoveEmployeeFromTeampthisTeam()));
        request.setTeamremoveEmployeeFromTeampevcEmployeeInstance(employeeSrv.getByOIDWithHV(request.getTeamremoveEmployeeFromTeampevcEmployee()));
        return teamSrv.removeEmployeeFromTeamImplementation(request, true);
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
            com.integranova.spring.expensereportdemo.viewmodel.team.siu.RemoveEmployeeFromTeamRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Team teamremoveEmployeeFromTeampthisTeam = request.getTeamremoveEmployeeFromTeampthisTeamInstance();
        Employee teamremoveEmployeeFromTeampevcEmployee = request.getTeamremoveEmployeeFromTeampevcEmployeeInstance();

        request.checkArguments();
        Team instance = teamremoveEmployeeFromTeampthisTeam;

        if (isEntryPoint) {
            com.integranova.spring.expensereportdemo.viewmodel.employee.siu.RemoveEmployeeFromTeamRequest relatedRequest = new com.integranova.spring.expensereportdemo.viewmodel.employee.siu.RemoveEmployeeFromTeamRequest();
            relatedRequest.setEmployeeremoveEmployeeFromTeampthisEmployeeInstance(teamremoveEmployeeFromTeampevcEmployee);
            relatedRequest.setEmployeeremoveEmployeeFromTeampevcTeamInstance(teamremoveEmployeeFromTeampthisTeam);
            employeeSrv.removeEmployeeFromTeamImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: validate

    /*
     * Entry point for service validate
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse validate(
            com.integranova.spring.expensereportdemo.viewmodel.team.siu.ValidateRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = teamSrv.validateTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service validate
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse validateTxn(
            com.integranova.spring.expensereportdemo.viewmodel.team.siu.ValidateRequest request) throws ModelException {
        request.setTeamvalidatepthisTeamInstance(teamSrv.getByOIDWithHV(request.getTeamvalidatepthisTeam()));
        return teamSrv.validateImplementation(request);
    }

    /*
     * Implements service validate
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse validateImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.team.siu.ValidateRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Team teamvalidatepthisTeam = request.getTeamvalidatepthisTeamInstance();

        request.checkArguments();

        validatePreconditions(request);
        Team instance = teamvalidatepthisTeam;
        instance.setTeamname(teamvalidatepthisTeam.getTeamname());


        response.setInstance(repository.save(instance));

        return response;
    }

    private void validatePreconditions(
            com.integranova.spring.expensereportdemo.viewmodel.team.siu.ValidateRequest request) 
            throws ModelException {
        checkClas1622453649408348Pre1(request);
    }

    private void checkClas1622453649408348Pre1 (
            com.integranova.spring.expensereportdemo.viewmodel.team.siu.ValidateRequest request) 
            throws ModelException {
        // FOR ALL Employees DISTINCT( Employees.idEmployee )

        Team teamvalidatepthisTeam = request.getTeamvalidatepthisTeamInstance();
        try {
            boolean preconditionHolds = repository.assocOperator005(teamvalidatepthisTeam);
            if (!preconditionHolds) throw new PreconditionException("Team cannot have duplicated employees");
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildTeamRelatedInstance(relatedInstanceJsonOid);
        }
        if (TeamConstants.ROLE_NAME_EMPLOYEES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildTeamRelatedInstance4Employee(relatedInstanceJsonOid, remainingPath);
        }
        if (TeamConstants.ROLE_NAME_PROJECTS.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildTeamRelatedInstance4Project(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildTeamRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new Team(mapper.readValue(relatedInstanceJsonOid, TeamOid.class));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildTeamRelatedInstance4Employee(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Employee(mapper.readValue(relatedInstanceJsonOid, EmployeeOid.class)): employeeSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildTeamRelatedInstance4Project(String relatedInstanceJsonOid, String remainingPath) {
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
            TeamOid oid = new TeamOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(TeamConstants.ATTR_FIELD_TEAMID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getTeamid(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(TeamService.class).error(e.getMessage());
        }
    }

}
