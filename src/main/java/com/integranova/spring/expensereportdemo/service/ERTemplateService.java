package com.integranova.spring.expensereportdemo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.ERTemplateConstants;
import com.integranova.spring.expensereportdemo.global.ExpenseReportConstants;
import com.integranova.spring.expensereportdemo.persistence.AbstractAppEntity;
import com.integranova.spring.expensereportdemo.persistence.ERLTemplate;
import com.integranova.spring.expensereportdemo.persistence.ERTemplate;
import com.integranova.spring.expensereportdemo.persistence.oid.ERLTemplateOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ERTemplateOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ProjectOid;
import com.integranova.spring.expensereportdemo.persistence.Project;
import com.integranova.spring.expensereportdemo.repository.ERTemplateJpaRepository;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereComparison;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereConjunction;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandLiteral;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandPathAttribute;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandSubQuery;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.crud.ERTemplatePostViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.ertemplate.crud.ERTemplatePutViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.FilterRequest;
import com.integranova.spring.expensereportdemo.viewmodel.FilterVariableRequest;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.QueryRequest;
import com.integranova.spring.expensereportdemo.viewmodel.QueryResponse;
import com.integranova.spring.expensereportdemo.viewmodel.ServiceResponse;
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
public class ERTemplateService extends AbstractService {

    @Autowired
    private ERTemplateJpaRepository repository;

    @Autowired
    private ERTemplateService eRTemplateSrv;

    @Autowired
    private ProjectService projectSrv;

    @Autowired
    private EmployeeService employeeSrv;

    @Autowired
    private ExpenseCurrencyService expenseCurrencySrv;

    @Autowired
    private ERLTemplateService eRLTemplateSrv;
    
    public ERTemplate post(ERTemplatePostViewModel payload) {
        ERTemplate instance = new ERTemplate();
        instance.setERTemplatename(payload.getERTemplatename());
        instance.setERTemplatedescription(payload.getERTemplatedescription());
        return repository.save(instance);
    }

    public ERTemplate put(Long eRTemplateid, ERTemplatePutViewModel payload) throws ModelException {
        if (!repository.existsById(eRTemplateid)) throw new ModelException("Not found-Put");
        ERTemplate instance = new ERTemplate(new ERTemplateOid(eRTemplateid));
        instance.setERTemplatename(payload.getERTemplatename());
        instance.setERTemplatedescription(payload.getERTemplatedescription());
        instance.setERTemplateenabled(payload.getERTemplateenabled());
        return repository.save(instance);
    }

    public void delete(Long eRTemplateid) throws ModelException {
        if (!repository.existsById(eRTemplateid)) throw new ModelException("Not found-Delete");
        repository.deleteById(eRTemplateid);
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, ERTemplateConstants.CLASS_NAME);
    }

    private List<ERTemplate> solveERTemplateTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, ERTemplateConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveERTemplateTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, ERTemplateConstants.CLASS_NAME));
    }
    
    /*
     * Returns the population of class ERTemplate
     *
     * @return Population of class ERTemplate
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<ERTemplate> get() {
        return repository.findAll();
    }

    /*
     * Gets the properties of DisplaySet DSERTemplates for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet DSERTemplates for a given instance
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public com.integranova.spring.expensereportdemo.viewmodel.ertemplate.ds.DSERTemplates getDSERTemplates(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        ERTemplate instance = (relatedInstancePath.isEmpty() ? 
                getByJsonOid(instanceOid):
                getByRelated(buildRelatedInstance(instanceOid, relatedInstancePath), relatedInstancePath).get(0));
        return new com.integranova.spring.expensereportdemo.viewmodel.ertemplate.ds.DSERTemplates(instance);
    }

    /*
     * Returns the population of class ERTemplate that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class ERTemplate matching the search criteria
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<ERTemplate> get(QueryRequest queryRequest) {
        return solveERTemplateTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveERTemplateTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveERTemplateTypedCountQuery(queryRequest) : 0);
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
        return new PopulationResponseViewModel(solveERTemplateTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of ERTemplate by ID
     *
     * @param eRTemplateid Identification field eRTemplateid
     *
     * @return Instance of ERTemplate
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public ERTemplate getById(Long eRTemplateid) {
        return getByOID(new ERTemplateOid(eRTemplateid));
    }
    
    /*
     * Returns an instance of ERTemplate by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ERTemplate
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public ERTemplate getByOID(ERTemplateOid oid) {
        Optional<ERTemplate> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of ERTemplate by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ERTemplate
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public ERTemplate getByOIDWithHV(ERTemplateOid oid) {
        Optional<ERTemplate> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<ERTemplate> getInstanceByOid(ERTemplateOid oid) {
        return oid != null && oid.getERTemplateid() != null
               ? repository.findById(oid.getERTemplateid())
               : Optional.empty();
    }
    
    /*
     * Returns an instance of ERTemplate by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of ERTemplate
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public ERTemplate getByJsonOid(String jsonOid) {
        ERTemplateOid oid = new ERTemplateOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of ERTemplate related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of ERTemplate
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<ERTemplate> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveERTemplateTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of ERTemplate related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of ERTemplate
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<ERTemplate> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of ERTemplate
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of ERTemplate
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public InstanceResponseViewModel getERTemplateDynamic(ERTemplateOid oid, String displaySetItems) {
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
    public String getSuppInfo(ERTemplateOid oid, String dsName) {
        ERTemplate instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(ERTemplate instance, String dsName) {
        return instance != null && dsName.isEmpty() ? instance.getOid().toJson() : "";
    }


    @Override
    protected void applyQueryFilters(FilterRequest filterRequest, SQLSelect sql) {
        if (ERTemplateConstants.FILTER_NAME_FERTEMPLATES.equalsIgnoreCase(filterRequest.getName()))
            fERTemplates(filterRequest, sql);
    }

    @Override
    protected void applyNavigationalFilters(FilterRequest filterRequest, SQLSelect sql) {
        if ("ExpenseReport_TNEWFROMTEMPLATE_pTemplate_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            clas1057569177600553FiltNav4(filterRequest, sql);
        if ("Clas_1057569177600719FiltNav_1".equalsIgnoreCase(filterRequest.getName()))
            clas1057569177600719FiltNav1(sql);
    }


    private void fERTemplates(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        String vName = filterRequest.hasFilterVariable(ERTemplateConstants.VAR_NAME_FERTEMPLATES_VNAME) ? (String) filterRequest.getFilterVariable(ERTemplateConstants.VAR_NAME_FERTEMPLATES_VNAME, FilterVariableRequest.STRING) : null;
        String vDescription = filterRequest.hasFilterVariable(ERTemplateConstants.VAR_NAME_FERTEMPLATES_VDESCRIPTION) ? (String) filterRequest.getFilterVariable(ERTemplateConstants.VAR_NAME_FERTEMPLATES_VDESCRIPTION, FilterVariableRequest.STRING) : null;
        Boolean vEnabled = filterRequest.hasFilterVariable(ERTemplateConstants.VAR_NAME_FERTEMPLATES_VENABLED) ? (Boolean) filterRequest.getFilterVariable(ERTemplateConstants.VAR_NAME_FERTEMPLATES_VENABLED, FilterVariableRequest.BOOL) : null;

        // name LIKE vName
        if (vName != null) {
            // 'like' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(ERTemplateConstants.ATTR_NAME_ERTEMPLATENAME, Constants.Type.STRING.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(vName, Constants.Type.STRING.getTypeName());
            comparison1.setSecondOperand(operand223);
            conjunction.addOperand(comparison1);

        }        

        // description LIKE vDescription
        if (vDescription != null) {
            // 'like' Comparison
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(ERTemplateConstants.ATTR_NAME_ERTEMPLATEDESCRIPTION, Constants.Type.TEXT.getTypeName());
            comparison2.setFirstOperand(operand113);
            
            // Operand 2
            SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(vDescription, Constants.Type.STRING.getTypeName());
            comparison2.setSecondOperand(operand224);
            conjunction.addOperand(comparison2);

        }        

        // enabled = vEnabled
        if (vEnabled != null) {
            // '=' Comparison
            SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
            comparison3.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(ERTemplateConstants.ATTR_NAME_ERTEMPLATEENABLED, Constants.Type.BOOL.getTypeName());
            comparison3.setFirstOperand(operand114);
            
            // Operand 2
            SQLWhereOperandLiteral operand225 = new SQLWhereOperandLiteral(vEnabled, Constants.Type.BOOL.getTypeName());
            comparison3.setSecondOperand(operand225);
            conjunction.addOperand(comparison3);

        }        

        sql.addConjunction(conjunction);
    }

    private void clas1057569177600553FiltNav4(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Project expenseReportTNEWFROMTEMPLATEptpagrProject = filterRequest.hasFilterVariable(ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGRPROJECT) ? new Project(new ProjectOid().fromJsonString(toJson(filterRequest.getFilterVariable(ExpenseReportConstants.ARG_NAME_TNEWFROMTEMPLATE_EXPENSEREPORTTNEWFROMTEMPLATEPTPAGRPROJECT)))) : null;

        // enabled = true
        // '=' Comparison
        SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
        comparison1.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(ERTemplateConstants.ATTR_NAME_ERTEMPLATEENABLED, Constants.Type.BOOL.getTypeName());
        comparison1.setFirstOperand(operand112);
        
        // Operand 2
        SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
        comparison1.setSecondOperand(operand223);
        conjunction.addOperand(comparison1);


        // EXIST (ptpagrProject.ERTemplates) WHERE (ptpagrProject.ERTemplates.id = id) = true
        if (expenseReportTNEWFROMTEMPLATEptpagrProject != null) {
    // 'exist' Association operator
    SQLWhereOperandSubQuery operandSubQueryAssocOperator000 = new SQLWhereOperandSubQuery(repository.assocOperator000Range1Query(expenseReportTNEWFROMTEMPLATEptpagrProject, sql));
    conjunction.addOperand(operandSubQueryAssocOperator000);

        }        
        sql.addConjunction(conjunction);
    }

    private void clas1057569177600719FiltNav1(SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();

        // enabled = true
        // '=' Comparison
        SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
        comparison1.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(ERTemplateConstants.ATTR_NAME_ERTEMPLATEENABLED, Constants.Type.BOOL.getTypeName());
        comparison1.setFirstOperand(operand112);
        
        // Operand 2
        SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName());
        comparison1.setSecondOperand(operand223);
        conjunction.addOperand(comparison1);

        sql.addConjunction(conjunction);
    }

    // IIU Methods


    /*
     * Solves the query needed for PIUERTemplates
     *
     * @param queryRequest Query request
     * @return List of viewmodels for ERTemplate using displayset DSERTemplates that 
     * match the search criteria
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<com.integranova.spring.expensereportdemo.viewmodel.ertemplate.ds.DSERTemplates> piuPIUERTemplates(QueryRequest queryRequest) {
        return solveERTemplateTypedQuery(queryRequest).stream()
                .map(com.integranova.spring.expensereportdemo.viewmodel.ertemplate.ds.DSERTemplates::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUERTemplates
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUERTemplates
     */
    public int getCount4PIUERTemplates(QueryRequest queryRequest) {
        return solveERTemplateTypedQuery(queryRequest).size();
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
            com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.CreateinstanceRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = eRTemplateSrv.createinstanceTxn(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.CreateinstanceRequest request) throws ModelException {
        return eRTemplateSrv.createinstanceImplementation(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.CreateinstanceRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        String eRTemplatecreateinstancepatrname = request.getERTemplatecreateinstancepatrname();
        String eRTemplatecreateinstancepatrdescription = request.getERTemplatecreateinstancepatrdescription();

        request.checkArguments();
        ERTemplate instance = new ERTemplate();
        instance.setERTemplateid(Long.valueOf(0));
        instance.setERTemplateenabled(Boolean.TRUE);
        instance.setERTemplatename(eRTemplatecreateinstancepatrname);
        instance.setERTemplatedescription(eRTemplatecreateinstancepatrdescription);
        
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
            com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.DeleteinstanceRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = eRTemplateSrv.deleteinstanceTxn(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.DeleteinstanceRequest request) throws ModelException {
        request.setERTemplatedeleteinstancepthisERTemplateInstance(eRTemplateSrv.getByOIDWithHV(request.getERTemplatedeleteinstancepthisERTemplate()));
        return eRTemplateSrv.deleteinstanceImplementation(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.DeleteinstanceRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ERTemplate eRTemplatedeleteinstancepthisERTemplate = request.getERTemplatedeleteinstancepthisERTemplateInstance();

        request.checkArguments();
        ERTemplate instance = eRTemplatedeleteinstancepthisERTemplate;

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
            com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.EditinstanceRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = eRTemplateSrv.editinstanceTxn(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.EditinstanceRequest request) throws ModelException {
        request.setERTemplateeditinstancepthisERTemplateInstance(eRTemplateSrv.getByOIDWithHV(request.getERTemplateeditinstancepthisERTemplate()));
        return eRTemplateSrv.editinstanceImplementation(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.EditinstanceRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ERTemplate eRTemplateeditinstancepthisERTemplate = request.getERTemplateeditinstancepthisERTemplateInstance();
        String eRTemplateeditinstancepname = request.getERTemplateeditinstancepname();
        String eRTemplateeditinstancepdescription = request.getERTemplateeditinstancepdescription();

        request.checkArguments();
        ERTemplate instance = eRTemplateeditinstancepthisERTemplate;
        instance.setERTemplatename(eRTemplateeditinstancepname);
        instance.setERTemplatedescription(eRTemplateeditinstancepdescription);


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: editName

    /*
     * Entry point for service editName
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse editName(
            com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.EditNameRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = eRTemplateSrv.editNameTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service editName
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse editNameTxn(
            com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.EditNameRequest request) throws ModelException {
        request.setERTemplateeditNamepthisERTemplateInstance(eRTemplateSrv.getByOIDWithHV(request.getERTemplateeditNamepthisERTemplate()));
        return eRTemplateSrv.editNameImplementation(request);
    }

    /*
     * Implements service editName
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse editNameImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.EditNameRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ERTemplate eRTemplateeditNamepthisERTemplate = request.getERTemplateeditNamepthisERTemplateInstance();
        String eRTemplateeditNamepName = request.getERTemplateeditNamepName();

        request.checkArguments();
        ERTemplate instance = eRTemplateeditNamepthisERTemplate;
        instance.setERTemplatename(eRTemplateeditNamepName);


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: editDescription

    /*
     * Entry point for service editDescription
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse editDescription(
            com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.EditDescriptionRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = eRTemplateSrv.editDescriptionTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service editDescription
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse editDescriptionTxn(
            com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.EditDescriptionRequest request) throws ModelException {
        request.setERTemplateeditDescriptionpthisERTemplateInstance(eRTemplateSrv.getByOIDWithHV(request.getERTemplateeditDescriptionpthisERTemplate()));
        return eRTemplateSrv.editDescriptionImplementation(request);
    }

    /*
     * Implements service editDescription
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse editDescriptionImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.EditDescriptionRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ERTemplate eRTemplateeditDescriptionpthisERTemplate = request.getERTemplateeditDescriptionpthisERTemplateInstance();
        String eRTemplateeditDescriptionpDescription = request.getERTemplateeditDescriptionpDescription();

        request.checkArguments();
        ERTemplate instance = eRTemplateeditDescriptionpthisERTemplate;
        instance.setERTemplatedescription(eRTemplateeditDescriptionpDescription);


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: clearName

    /*
     * Entry point for service clearName
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse clearName(
            com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.ClearNameRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = eRTemplateSrv.clearNameTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service clearName
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse clearNameTxn(
            com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.ClearNameRequest request) throws ModelException {
        request.setERTemplateclearNamepthisERTemplateInstance(eRTemplateSrv.getByOIDWithHV(request.getERTemplateclearNamepthisERTemplate()));
        return eRTemplateSrv.clearNameImplementation(request);
    }

    /*
     * Implements service clearName
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse clearNameImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.ClearNameRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ERTemplate eRTemplateclearNamepthisERTemplate = request.getERTemplateclearNamepthisERTemplateInstance();

        request.checkArguments();
        ERTemplate instance = eRTemplateclearNamepthisERTemplate;
        instance.setERTemplatename("");


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: clearDescription

    /*
     * Entry point for service clearDescription
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse clearDescription(
            com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.ClearDescriptionRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = eRTemplateSrv.clearDescriptionTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service clearDescription
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse clearDescriptionTxn(
            com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.ClearDescriptionRequest request) throws ModelException {
        request.setERTemplateclearDescriptionpthisERTemplateInstance(eRTemplateSrv.getByOIDWithHV(request.getERTemplateclearDescriptionpthisERTemplate()));
        return eRTemplateSrv.clearDescriptionImplementation(request);
    }

    /*
     * Implements service clearDescription
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse clearDescriptionImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.ClearDescriptionRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ERTemplate eRTemplateclearDescriptionpthisERTemplate = request.getERTemplateclearDescriptionpthisERTemplateInstance();

        request.checkArguments();
        ERTemplate instance = eRTemplateclearDescriptionpthisERTemplate;
        instance.setERTemplatedescription(null);


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: enable

    /*
     * Entry point for service enable
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse enable(
            com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.EnableRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = eRTemplateSrv.enableTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service enable
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse enableTxn(
            com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.EnableRequest request) throws ModelException {
        request.setERTemplateenablepthisERTemplateInstance(eRTemplateSrv.getByOIDWithHV(request.getERTemplateenablepthisERTemplate()));
        return eRTemplateSrv.enableImplementation(request);
    }

    /*
     * Implements service enable
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse enableImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.EnableRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ERTemplate eRTemplateenablepthisERTemplate = request.getERTemplateenablepthisERTemplateInstance();

        request.checkArguments();
        ERTemplate instance = eRTemplateenablepthisERTemplate;
        instance.setERTemplateenabled(Boolean.TRUE);


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: disable

    /*
     * Entry point for service disable
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse disable(
            com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.DisableRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = eRTemplateSrv.disableTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service disable
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse disableTxn(
            com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.DisableRequest request) throws ModelException {
        request.setERTemplatedisablepthisERTemplateInstance(eRTemplateSrv.getByOIDWithHV(request.getERTemplatedisablepthisERTemplate()));
        return eRTemplateSrv.disableImplementation(request);
    }

    /*
     * Implements service disable
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse disableImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.DisableRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ERTemplate eRTemplatedisablepthisERTemplate = request.getERTemplatedisablepthisERTemplateInstance();

        request.checkArguments();
        ERTemplate instance = eRTemplatedisablepthisERTemplate;
        instance.setERTemplateenabled(Boolean.FALSE);


        response.setInstance(repository.save(instance));

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
            com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.AssignTemplateToProjectRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = eRTemplateSrv.assignTemplateToProjectTxn(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.AssignTemplateToProjectRequest request) throws ModelException {
        request.setERTemplateassignTemplateToProjectpthisERTemplateInstance(eRTemplateSrv.getByOIDWithHV(request.getERTemplateassignTemplateToProjectpthisERTemplate()));
        request.setERTemplateassignTemplateToProjectpevcProjectInstance(projectSrv.getByOIDWithHV(request.getERTemplateassignTemplateToProjectpevcProject()));
        return eRTemplateSrv.assignTemplateToProjectImplementation(request, true);
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
            com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.AssignTemplateToProjectRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ERTemplate eRTemplateassignTemplateToProjectpthisERTemplate = request.getERTemplateassignTemplateToProjectpthisERTemplateInstance();
        Project eRTemplateassignTemplateToProjectpevcProject = request.getERTemplateassignTemplateToProjectpevcProjectInstance();

        request.checkArguments();
        ERTemplate instance = eRTemplateassignTemplateToProjectpthisERTemplate;

        instance.getProjects().add(eRTemplateassignTemplateToProjectpevcProject);
        if (isEntryPoint) {
            com.integranova.spring.expensereportdemo.viewmodel.project.siu.AssignTemplateToProjectRequest relatedRequest = new com.integranova.spring.expensereportdemo.viewmodel.project.siu.AssignTemplateToProjectRequest();
            relatedRequest.setProjectassignTemplateToProjectpthisProjectInstance(eRTemplateassignTemplateToProjectpevcProject);
            relatedRequest.setProjectassignTemplateToProjectpevcERTemplateInstance(eRTemplateassignTemplateToProjectpthisERTemplate);
            projectSrv.assignTemplateToProjectImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

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
            com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.DeassignTemplateRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = eRTemplateSrv.deassignTemplateTxn(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.DeassignTemplateRequest request) throws ModelException {
        request.setERTemplatedeassignTemplatepthisERTemplateInstance(eRTemplateSrv.getByOIDWithHV(request.getERTemplatedeassignTemplatepthisERTemplate()));
        request.setERTemplatedeassignTemplatepevcProjectInstance(projectSrv.getByOIDWithHV(request.getERTemplatedeassignTemplatepevcProject()));
        return eRTemplateSrv.deassignTemplateImplementation(request, true);
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
            com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu.DeassignTemplateRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ERTemplate eRTemplatedeassignTemplatepthisERTemplate = request.getERTemplatedeassignTemplatepthisERTemplateInstance();
        Project eRTemplatedeassignTemplatepevcProject = request.getERTemplatedeassignTemplatepevcProjectInstance();

        request.checkArguments();
        ERTemplate instance = eRTemplatedeassignTemplatepthisERTemplate;

        if (isEntryPoint) {
            com.integranova.spring.expensereportdemo.viewmodel.project.siu.DeassignTemplateRequest relatedRequest = new com.integranova.spring.expensereportdemo.viewmodel.project.siu.DeassignTemplateRequest();
            relatedRequest.setProjectdeassignTemplatepthisProjectInstance(eRTemplatedeassignTemplatepevcProject);
            relatedRequest.setProjectdeassignTemplatepevcERTemplateInstance(eRTemplatedeassignTemplatepthisERTemplate);
            projectSrv.deassignTemplateImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildERTemplateRelatedInstance(relatedInstanceJsonOid);
        }
        if (ERTemplateConstants.ROLE_NAME_PROJECTS.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildERTemplateRelatedInstance4Project(relatedInstanceJsonOid, remainingPath);
        }
        if (ERTemplateConstants.ROLE_NAME_TEMPLATELINES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildERTemplateRelatedInstance4ERLTemplate(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildERTemplateRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new ERTemplate(mapper.readValue(relatedInstanceJsonOid, ERTemplateOid.class));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildERTemplateRelatedInstance4Project(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Project(mapper.readValue(relatedInstanceJsonOid, ProjectOid.class)): projectSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildERTemplateRelatedInstance4ERLTemplate(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ERLTemplate(mapper.readValue(relatedInstanceJsonOid, ERLTemplateOid.class)): eRLTemplateSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            ERTemplateOid oid = new ERTemplateOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(ERTemplateConstants.ATTR_FIELD_ERTEMPLATEID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getERTemplateid(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(ERTemplateService.class).error(e.getMessage());
        }
    }

}
