package com.integranova.spring.expensereportdemo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.ExpenseTypeConstants;
import com.integranova.spring.expensereportdemo.persistence.AbstractAppEntity;
import com.integranova.spring.expensereportdemo.persistence.ERLTemplate;
import com.integranova.spring.expensereportdemo.persistence.ExpenseLine;
import com.integranova.spring.expensereportdemo.persistence.ExpenseType;
import com.integranova.spring.expensereportdemo.persistence.oid.ERLTemplateOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseLineOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseTypeOid;
import com.integranova.spring.expensereportdemo.repository.ExpenseTypeJpaRepository;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereComparison;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereDisjunction;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandLiteral;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandPathAttribute;
import com.integranova.spring.expensereportdemo.viewmodel.expensetype.crud.ExpenseTypePostViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.expensetype.crud.ExpenseTypePutViewModel;
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
public class ExpenseTypeService extends AbstractService {

    @Autowired
    private ExpenseTypeJpaRepository repository;

    @Autowired
    private ExpenseTypeService expenseTypeSrv;

    @Autowired
    private ExpenseLineService expenseLineSrv;

    @Autowired
    private ERLTemplateService eRLTemplateSrv;
    
    public ExpenseType post(ExpenseTypePostViewModel payload) {
        ExpenseType instance = new ExpenseType();
        instance.setExpenseTypeTypeCode(payload.getExpenseTypeTypeCode());
        instance.setExpenseTypeTyDescription(payload.getExpenseTypeTyDescription());
        instance.setExpenseTypePrice(payload.getExpenseTypePrice());
        instance.setExpenseTypeFixedPrice(payload.getExpenseTypeFixedPrice());
        return repository.save(instance);
    }

    public ExpenseType put(String expenseTypeTypeCode, ExpenseTypePutViewModel payload) throws ModelException {
        if (!repository.existsById(expenseTypeTypeCode)) throw new ModelException("Not found-Put");
        ExpenseType instance = new ExpenseType(new ExpenseTypeOid(expenseTypeTypeCode));
        instance.setExpenseTypeTyDescription(payload.getExpenseTypeTyDescription());
        instance.setExpenseTypePrice(payload.getExpenseTypePrice());
        instance.setExpenseTypeFixedPrice(payload.getExpenseTypeFixedPrice());
        return repository.save(instance);
    }

    public void delete(String expenseTypeTypeCode) throws ModelException {
        if (!repository.existsById(expenseTypeTypeCode)) throw new ModelException("Not found-Delete");
        repository.deleteById(expenseTypeTypeCode);
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, ExpenseTypeConstants.CLASS_NAME);
    }

    private List<ExpenseType> solveExpenseTypeTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, ExpenseTypeConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveExpenseTypeTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, ExpenseTypeConstants.CLASS_NAME));
    }
    
    /*
     * Returns the population of class ExpenseType
     *
     * @return Population of class ExpenseType
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<ExpenseType> get() {
        return repository.findAll();
    }
    
    /*
     * Gets the preloaded list of objects of class ExpenseType
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return Preloaded list of objects of class ExpenseType
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<PreloadViewModel> getPreload(QueryRequest queryRequest) {
        List<PreloadViewModel> results = new ArrayList<>();
        List<ExpenseType> instances = get(queryRequest);
        if(ExpenseTypeConstants.DSDSEXPENSETYPE.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSExpenseType())).collect(Collectors.toList());
        }
        if(ExpenseTypeConstants.DSDSEXPENSETYPESUP.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSExpenseTypeSup())).collect(Collectors.toList());
        }
        return results;
    }

    /*
     * Gets the properties of DisplaySet DSExpenseType for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet DSExpenseType for a given instance
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public com.integranova.spring.expensereportdemo.viewmodel.expensetype.ds.DSExpenseType getDSExpenseType(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        ExpenseType instance = (relatedInstancePath.isEmpty() ? 
                getByJsonOid(instanceOid):
                getByRelated(buildRelatedInstance(instanceOid, relatedInstancePath), relatedInstancePath).get(0));
        return new com.integranova.spring.expensereportdemo.viewmodel.expensetype.ds.DSExpenseType(instance);
    }

    /*
     * Gets the properties of DisplaySet DSExpenseTypeSup for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet DSExpenseTypeSup for a given instance
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public com.integranova.spring.expensereportdemo.viewmodel.expensetype.ds.DSExpenseTypeSup getDSExpenseTypeSup(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        ExpenseType instance = (relatedInstancePath.isEmpty() ? 
                getByJsonOid(instanceOid):
                getByRelated(buildRelatedInstance(instanceOid, relatedInstancePath), relatedInstancePath).get(0));
        return new com.integranova.spring.expensereportdemo.viewmodel.expensetype.ds.DSExpenseTypeSup(instance);
    }

    /*
     * Returns the population of class ExpenseType that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class ExpenseType matching the search criteria
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<ExpenseType> get(QueryRequest queryRequest) {
        return solveExpenseTypeTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveExpenseTypeTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveExpenseTypeTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel(solveExpenseTypeTypedQuery(queryRequest).stream()
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
        return new PopulationResponseViewModel(solveExpenseTypeTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of ExpenseType by ID
     *
     * @param expenseTypeTypeCode Identification field expenseTypeTypeCode
     *
     * @return Instance of ExpenseType
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public ExpenseType getById(String expenseTypeTypeCode) {
        return getByOID(new ExpenseTypeOid(expenseTypeTypeCode));
    }
    
    /*
     * Returns an instance of ExpenseType by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ExpenseType
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public ExpenseType getByOID(ExpenseTypeOid oid) {
        Optional<ExpenseType> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of ExpenseType by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ExpenseType
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public ExpenseType getByOIDWithHV(ExpenseTypeOid oid) {
        Optional<ExpenseType> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<ExpenseType> getInstanceByOid(ExpenseTypeOid oid) {
        return oid != null && oid.getExpenseTypeTypeCode() != null
               ? repository.findById(oid.getExpenseTypeTypeCode())
               : Optional.empty();
    }
    
    /*
     * Returns an instance of ExpenseType by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of ExpenseType
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public ExpenseType getByJsonOid(String jsonOid) {
        ExpenseTypeOid oid = new ExpenseTypeOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of ExpenseType related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of ExpenseType
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<ExpenseType> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveExpenseTypeTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of ExpenseType related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of ExpenseType
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<ExpenseType> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of ExpenseType
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of ExpenseType
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public InstanceResponseViewModel getExpenseTypeDynamic(ExpenseTypeOid oid, String displaySetItems) {
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
    public String getSuppInfo(ExpenseTypeOid oid, String dsName) {
        ExpenseType instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(ExpenseType instance, String dsName) {
        if (ExpenseTypeConstants.DSDSEXPENSETYPESUP.equals(dsName))
            return instance.buildDSExpenseTypeSup();
        return instance != null && dsName.isEmpty() ? instance.getOid().toJson() : "";
    }

    public static PreloadViewModel buildPreloadViewModel(ExpenseType instance, String dsName) {
        if (ExpenseTypeConstants.DSDSEXPENSETYPE.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSExpenseType());
        if (ExpenseTypeConstants.DSDSEXPENSETYPESUP.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSExpenseTypeSup());
        return new PreloadViewModel(instance.getOid().toJson(), "");
    }


    @Override
    protected void applyServiceSIFilters(FilterRequest filterRequest, SQLSelect sql) {
        if ("SuppInfo_DS_ExpenseTypeSup".equals(filterRequest.getName()))
            suppInfo4DSExpenseTypeSup(filterRequest.getFilterVariable("searchText").toString(), sql);
    }



    // IIU Methods

    /*
     * Returns a viewmodel for class ExpenseType with displayset DSExpenseType for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class ExpenseType with displayset DSExpenseType
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public com.integranova.spring.expensereportdemo.viewmodel.expensetype.ds.DSExpenseType iIUExpenseType(ExpenseTypeOid oid) {
        return new com.integranova.spring.expensereportdemo.viewmodel.expensetype.ds.DSExpenseType(getByOIDWithHV(oid));
    }


    /*
     * Solves the query needed for PIUExpenseType
     *
     * @param queryRequest Query request
     * @return List of viewmodels for ExpenseType using displayset DSExpenseType that 
     * match the search criteria
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<com.integranova.spring.expensereportdemo.viewmodel.expensetype.ds.DSExpenseType> piuPIUExpenseType(QueryRequest queryRequest) {
        return solveExpenseTypeTypedQuery(queryRequest).stream()
                .map(com.integranova.spring.expensereportdemo.viewmodel.expensetype.ds.DSExpenseType::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUExpenseType
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUExpenseType
     */
    public int getCount4PIUExpenseType(QueryRequest queryRequest) {
        return solveExpenseTypeTypedQuery(queryRequest).size();
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
            com.integranova.spring.expensereportdemo.viewmodel.expensetype.siu.CreateinstanceRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = expenseTypeSrv.createinstanceTxn(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.expensetype.siu.CreateinstanceRequest request) throws ModelException {
        return expenseTypeSrv.createinstanceImplementation(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.expensetype.siu.CreateinstanceRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        String expenseTypecreateinstancepatrTypeCode = request.getExpenseTypecreateinstancepatrTypeCode();
        String expenseTypecreateinstancepatrTyDescription = request.getExpenseTypecreateinstancepatrTyDescription();
        Double expenseTypecreateinstancepatrPrice = request.getExpenseTypecreateinstancepatrPrice();
        Boolean expenseTypecreateinstancepatrFixedPrice = request.getExpenseTypecreateinstancepatrFixedPrice();

        request.checkArguments();
        ExpenseType instance = new ExpenseType();
        instance.setExpenseTypeTypeCode(expenseTypecreateinstancepatrTypeCode);
        instance.setExpenseTypeTyDescription(expenseTypecreateinstancepatrTyDescription);
        instance.setExpenseTypePrice(expenseTypecreateinstancepatrPrice);
        instance.setExpenseTypeFixedPrice(expenseTypecreateinstancepatrFixedPrice);
        
        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildDSExpenseTypeSup());

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
            com.integranova.spring.expensereportdemo.viewmodel.expensetype.siu.DeleteinstanceRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = expenseTypeSrv.deleteinstanceTxn(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.expensetype.siu.DeleteinstanceRequest request) throws ModelException {
        request.setExpenseTypedeleteinstancepthisExpenseTypeInstance(expenseTypeSrv.getByOIDWithHV(request.getExpenseTypedeleteinstancepthisExpenseType()));
        return expenseTypeSrv.deleteinstanceImplementation(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.expensetype.siu.DeleteinstanceRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ExpenseType expenseTypedeleteinstancepthisExpenseType = request.getExpenseTypedeleteinstancepthisExpenseTypeInstance();

        request.checkArguments();
        ExpenseType instance = expenseTypedeleteinstancepthisExpenseType;

        repository.delete(instance);
        
        response.setInstance(instance);
        response.setInstanceSuppInfo(instance.buildDSExpenseTypeSup());

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
            com.integranova.spring.expensereportdemo.viewmodel.expensetype.siu.EditinstanceRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = expenseTypeSrv.editinstanceTxn(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.expensetype.siu.EditinstanceRequest request) throws ModelException {
        request.setExpenseTypeeditinstancepthisExpenseTypeInstance(expenseTypeSrv.getByOIDWithHV(request.getExpenseTypeeditinstancepthisExpenseType()));
        return expenseTypeSrv.editinstanceImplementation(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.expensetype.siu.EditinstanceRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ExpenseType expenseTypeeditinstancepthisExpenseType = request.getExpenseTypeeditinstancepthisExpenseTypeInstance();
        String expenseTypeeditinstancepTyDescription = request.getExpenseTypeeditinstancepTyDescription();
        Double expenseTypeeditinstancepPrice = request.getExpenseTypeeditinstancepPrice();
        Boolean expenseTypeeditinstancepFixedPrice = request.getExpenseTypeeditinstancepFixedPrice();

        request.checkArguments();
        ExpenseType instance = expenseTypeeditinstancepthisExpenseType;
        instance.setExpenseTypeTyDescription(expenseTypeeditinstancepTyDescription);
        instance.setExpenseTypePrice(expenseTypeeditinstancepPrice);
        instance.setExpenseTypeFixedPrice(expenseTypeeditinstancepFixedPrice);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildDSExpenseTypeSup());

        return response;
    }


    private void suppInfo4DSExpenseTypeSup(String searchText, SQLSelect select) {
        try {
            SQLWhereDisjunction disjunction = new SQLWhereDisjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(select);
            comparison1.setOperator("LIKE");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(ExpenseTypeConstants.ATTR_NAME_EXPENSETYPETYDESCRIPTION, Constants.Type.STRING.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(searchText, Constants.Type.STRING.getTypeName()));
            disjunction.addComparison(comparison1);

            select.addDisjunction(disjunction);
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
    }

    @Override
    protected void applyOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        applyOCOCExpenseType(queryRequest, select);
        applyDSItemSort(queryRequest, select);
    }
    

    private void applyOCOCExpenseType(QueryRequest queryRequest, SQLSelect select) {
        if ("OC_ExpenseType".equalsIgnoreCase(queryRequest.getOrderCriteriaName())) {
            select.getOrderByPart().addItem(Constants.normalizePath(ExpenseTypeConstants.CLASS_NAME, ExpenseTypeConstants.ATTR_NAME_EXPENSETYPETYDESCRIPTION, false), true);
        }
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildExpenseTypeRelatedInstance(relatedInstanceJsonOid);
        }
        if (ExpenseTypeConstants.ROLE_NAME_EXPENSELINES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildExpenseTypeRelatedInstance4ExpenseLine(relatedInstanceJsonOid, remainingPath);
        }
        if (ExpenseTypeConstants.ROLE_NAME_TEMPLATELINES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildExpenseTypeRelatedInstance4ERLTemplate(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildExpenseTypeRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new ExpenseType(mapper.readValue(relatedInstanceJsonOid, ExpenseTypeOid.class));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildExpenseTypeRelatedInstance4ExpenseLine(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ExpenseLine(mapper.readValue(relatedInstanceJsonOid, ExpenseLineOid.class)): expenseLineSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildExpenseTypeRelatedInstance4ERLTemplate(String relatedInstanceJsonOid, String remainingPath) {
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
            ExpenseTypeOid oid = new ExpenseTypeOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(ExpenseTypeConstants.ATTR_FIELD_EXPENSETYPETYPECODE, Constants.Type.STRING.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getExpenseTypeTypeCode(), Constants.Type.STRING.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(ExpenseTypeService.class).error(e.getMessage());
        }
    }

}
