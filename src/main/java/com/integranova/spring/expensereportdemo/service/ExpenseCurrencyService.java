package com.integranova.spring.expensereportdemo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.ExpenseCurrencyConstants;
import com.integranova.spring.expensereportdemo.persistence.AbstractAppEntity;
import com.integranova.spring.expensereportdemo.persistence.ExchangeHistory;
import com.integranova.spring.expensereportdemo.persistence.ExpenseCurrency;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.oid.ExchangeHistoryOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseCurrencyOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseReportOid;
import com.integranova.spring.expensereportdemo.repository.ExpenseCurrencyJpaRepository;
import com.integranova.spring.expensereportdemo.service.ExchangeHistoryService;
import com.integranova.spring.expensereportdemo.service.ExpenseCurrencyService;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereComparison;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereDisjunction;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandLiteral;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandPathAttribute;
import com.integranova.spring.expensereportdemo.utils.Utilities;
import com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.crud.ExpenseCurrencyPostViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.crud.ExpenseCurrencyPutViewModel;
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
public class ExpenseCurrencyService extends AbstractService {

    @Autowired
    private ExpenseCurrencyJpaRepository repository;

    @Autowired
    private ExpenseCurrencyService expenseCurrencySrv;

    @Autowired
    private ExchangeHistoryService exchangeHistorySrv;

    @Autowired
    private ExpenseReportService expenseReportSrv;
    
    public ExpenseCurrency post(ExpenseCurrencyPostViewModel payload) {
        ExpenseCurrency instance = new ExpenseCurrency();
        instance.setExpenseCurrencyCurrencyCode(payload.getExpenseCurrencyCurrencyCode());
        instance.setExpenseCurrencyCurrencyName(payload.getExpenseCurrencyCurrencyName());
        instance.setExpenseCurrencyCurAcronym(payload.getExpenseCurrencyCurAcronym());
        instance.setExpenseCurrencyExchange(payload.getExpenseCurrencyExchange());
        return repository.save(instance);
    }

    public ExpenseCurrency put(String expenseCurrencyCurrencyCode, ExpenseCurrencyPutViewModel payload) throws ModelException {
        if (!repository.existsById(expenseCurrencyCurrencyCode)) throw new ModelException("Not found-Put");
        ExpenseCurrency instance = new ExpenseCurrency(new ExpenseCurrencyOid(expenseCurrencyCurrencyCode));
        instance.setExpenseCurrencyCurrencyName(payload.getExpenseCurrencyCurrencyName());
        instance.setExpenseCurrencyCurAcronym(payload.getExpenseCurrencyCurAcronym());
        instance.setExpenseCurrencyExchange(payload.getExpenseCurrencyExchange());
        return repository.save(instance);
    }

    public void delete(String expenseCurrencyCurrencyCode) throws ModelException {
        if (!repository.existsById(expenseCurrencyCurrencyCode)) throw new ModelException("Not found-Delete");
        repository.deleteById(expenseCurrencyCurrencyCode);
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, ExpenseCurrencyConstants.CLASS_NAME);
    }

    private List<ExpenseCurrency> solveExpenseCurrencyTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, ExpenseCurrencyConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveExpenseCurrencyTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, ExpenseCurrencyConstants.CLASS_NAME));
    }
    
    /*
     * Returns the population of class ExpenseCurrency
     *
     * @return Population of class ExpenseCurrency
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<ExpenseCurrency> get() {
        return repository.findAll();
    }
    
    /*
     * Gets the preloaded list of objects of class ExpenseCurrency
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return Preloaded list of objects of class ExpenseCurrency
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<PreloadViewModel> getPreload(QueryRequest queryRequest) {
        List<PreloadViewModel> results = new ArrayList<>();
        List<ExpenseCurrency> instances = get(queryRequest);
        if(ExpenseCurrencyConstants.DSDSEXPENSECURRENCY.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSExpenseCurrency())).collect(Collectors.toList());
        }
        if(ExpenseCurrencyConstants.DSDSEXPENSECURRENCYSUP.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSExpenseCurrencySup())).collect(Collectors.toList());
        }
        return results;
    }

    /*
     * Gets the properties of DisplaySet DSExpenseCurrency for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet DSExpenseCurrency for a given instance
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.ds.DSExpenseCurrency getDSExpenseCurrency(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        ExpenseCurrency instance = (relatedInstancePath.isEmpty() ? 
                getByJsonOid(instanceOid):
                getByRelated(buildRelatedInstance(instanceOid, relatedInstancePath), relatedInstancePath).get(0));
        return new com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.ds.DSExpenseCurrency(instance);
    }

    /*
     * Gets the properties of DisplaySet DSExpenseCurrencySup for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet DSExpenseCurrencySup for a given instance
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.ds.DSExpenseCurrencySup getDSExpenseCurrencySup(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        ExpenseCurrency instance = (relatedInstancePath.isEmpty() ? 
                getByJsonOid(instanceOid):
                getByRelated(buildRelatedInstance(instanceOid, relatedInstancePath), relatedInstancePath).get(0));
        return new com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.ds.DSExpenseCurrencySup(instance);
    }

    /*
     * Returns the population of class ExpenseCurrency that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class ExpenseCurrency matching the search criteria
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<ExpenseCurrency> get(QueryRequest queryRequest) {
        return solveExpenseCurrencyTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveExpenseCurrencyTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveExpenseCurrencyTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel(solveExpenseCurrencyTypedQuery(queryRequest).stream()
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
        return new PopulationResponseViewModel(solveExpenseCurrencyTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of ExpenseCurrency by ID
     *
     * @param expenseCurrencyCurrencyCode Identification field expenseCurrencyCurrencyCode
     *
     * @return Instance of ExpenseCurrency
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public ExpenseCurrency getById(String expenseCurrencyCurrencyCode) {
        return getByOID(new ExpenseCurrencyOid(expenseCurrencyCurrencyCode));
    }
    
    /*
     * Returns an instance of ExpenseCurrency by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ExpenseCurrency
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public ExpenseCurrency getByOID(ExpenseCurrencyOid oid) {
        Optional<ExpenseCurrency> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of ExpenseCurrency by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ExpenseCurrency
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public ExpenseCurrency getByOIDWithHV(ExpenseCurrencyOid oid) {
        Optional<ExpenseCurrency> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<ExpenseCurrency> getInstanceByOid(ExpenseCurrencyOid oid) {
        return oid != null && oid.getExpenseCurrencyCurrencyCode() != null
               ? repository.findById(oid.getExpenseCurrencyCurrencyCode())
               : Optional.empty();
    }
    
    /*
     * Returns an instance of ExpenseCurrency by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of ExpenseCurrency
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public ExpenseCurrency getByJsonOid(String jsonOid) {
        ExpenseCurrencyOid oid = new ExpenseCurrencyOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of ExpenseCurrency related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of ExpenseCurrency
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<ExpenseCurrency> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveExpenseCurrencyTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of ExpenseCurrency related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of ExpenseCurrency
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<ExpenseCurrency> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of ExpenseCurrency
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of ExpenseCurrency
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public InstanceResponseViewModel getExpenseCurrencyDynamic(ExpenseCurrencyOid oid, String displaySetItems) {
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
    public String getSuppInfo(ExpenseCurrencyOid oid, String dsName) {
        ExpenseCurrency instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(ExpenseCurrency instance, String dsName) {
        if (ExpenseCurrencyConstants.DSDSEXPENSECURRENCYSUP.equals(dsName))
            return instance.buildDSExpenseCurrencySup();
        return instance != null && dsName.isEmpty() ? instance.getOid().toJson() : "";
    }

    public static PreloadViewModel buildPreloadViewModel(ExpenseCurrency instance, String dsName) {
        if (ExpenseCurrencyConstants.DSDSEXPENSECURRENCY.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSExpenseCurrency());
        if (ExpenseCurrencyConstants.DSDSEXPENSECURRENCYSUP.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSExpenseCurrencySup());
        return new PreloadViewModel(instance.getOid().toJson(), "");
    }


    @Override
    protected void applyServiceSIFilters(FilterRequest filterRequest, SQLSelect sql) {
        if ("SuppInfo_DS_ExpenseCurrencySup".equals(filterRequest.getName()))
            suppInfo4DSExpenseCurrencySup(filterRequest.getFilterVariable("searchText").toString(), sql);
    }



    // IIU Methods

    /*
     * Returns a viewmodel for class ExpenseCurrency with displayset DSExpenseCurrency for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class ExpenseCurrency with displayset DSExpenseCurrency
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.ds.DSExpenseCurrency iIUExpenseCurrency(ExpenseCurrencyOid oid) {
        return new com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.ds.DSExpenseCurrency(getByOIDWithHV(oid));
    }


    /*
     * Solves the query needed for PIUExpenseCurrency
     *
     * @param queryRequest Query request
     * @return List of viewmodels for ExpenseCurrency using displayset DSExpenseCurrency that 
     * match the search criteria
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.ds.DSExpenseCurrency> piuPIUExpenseCurrency(QueryRequest queryRequest) {
        return solveExpenseCurrencyTypedQuery(queryRequest).stream()
                .map(com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.ds.DSExpenseCurrency::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUExpenseCurrency
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUExpenseCurrency
     */
    public int getCount4PIUExpenseCurrency(QueryRequest queryRequest) {
        return solveExpenseCurrencyTypedQuery(queryRequest).size();
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
            com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.CreateinstanceRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = expenseCurrencySrv.createinstanceTxn(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.CreateinstanceRequest request) throws ModelException {
        return expenseCurrencySrv.createinstanceImplementation(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.CreateinstanceRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        String expenseCurrencycreateinstancepatrCurrencyName = request.getExpenseCurrencycreateinstancepatrCurrencyName();
        String expenseCurrencycreateinstancepatrCurrencyCode = request.getExpenseCurrencycreateinstancepatrCurrencyCode();
        String expenseCurrencycreateinstancepatrCurAcronym = request.getExpenseCurrencycreateinstancepatrCurAcronym();
        Double expenseCurrencycreateinstancepatrExchange = request.getExpenseCurrencycreateinstancepatrExchange();

        request.checkArguments();
        ExpenseCurrency instance = new ExpenseCurrency();
        instance.setExpenseCurrencyCurrencyName(expenseCurrencycreateinstancepatrCurrencyName);
        instance.setExpenseCurrencyCurrencyCode(expenseCurrencycreateinstancepatrCurrencyCode);
        instance.setExpenseCurrencyCurAcronym(expenseCurrencycreateinstancepatrCurAcronym);
        instance.setExpenseCurrencyExchange(expenseCurrencycreateinstancepatrExchange);
        
        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildDSExpenseCurrencySup());

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
            com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.DeleteinstanceRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = expenseCurrencySrv.deleteinstanceTxn(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.DeleteinstanceRequest request) throws ModelException {
        request.setExpenseCurrencydeleteinstancepthisExpenseCurrencyInstance(expenseCurrencySrv.getByOIDWithHV(request.getExpenseCurrencydeleteinstancepthisExpenseCurrency()));
        return expenseCurrencySrv.deleteinstanceImplementation(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.DeleteinstanceRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ExpenseCurrency expenseCurrencydeleteinstancepthisExpenseCurrency = request.getExpenseCurrencydeleteinstancepthisExpenseCurrencyInstance();

        request.checkArguments();
        ExpenseCurrency instance = expenseCurrencydeleteinstancepthisExpenseCurrency;

        repository.delete(instance);
        
        response.setInstance(instance);
        response.setInstanceSuppInfo(instance.buildDSExpenseCurrencySup());

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
            com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.EditinstanceRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = expenseCurrencySrv.editinstanceTxn(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.EditinstanceRequest request) throws ModelException {
        request.setExpenseCurrencyeditinstancepthisExpenseCurrencyInstance(expenseCurrencySrv.getByOIDWithHV(request.getExpenseCurrencyeditinstancepthisExpenseCurrency()));
        return expenseCurrencySrv.editinstanceImplementation(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.EditinstanceRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ExpenseCurrency expenseCurrencyeditinstancepthisExpenseCurrency = request.getExpenseCurrencyeditinstancepthisExpenseCurrencyInstance();
        String expenseCurrencyeditinstancepCurrencyName = request.getExpenseCurrencyeditinstancepCurrencyName();
        String expenseCurrencyeditinstancepCurAcronym = request.getExpenseCurrencyeditinstancepCurAcronym();
        Double expenseCurrencyeditinstancepExchange = request.getExpenseCurrencyeditinstancepExchange();

        request.checkArguments();
        ExpenseCurrency instance = expenseCurrencyeditinstancepthisExpenseCurrency;
        instance.setExpenseCurrencyCurrencyName(expenseCurrencyeditinstancepCurrencyName);
        instance.setExpenseCurrencyCurAcronym(expenseCurrencyeditinstancepCurAcronym);
        instance.setExpenseCurrencyExchange(expenseCurrencyeditinstancepExchange);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildDSExpenseCurrencySup());

        return response;
    }

    // Service: resetExchange

    /*
     * Entry point for service resetExchange
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse resetExchange(
            com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.ResetExchangeRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = expenseCurrencySrv.resetExchangeTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service resetExchange
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse resetExchangeTxn(
            com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.ResetExchangeRequest request) throws ModelException {
        request.setExpenseCurrencyresetExchangepthisExpenseCurrencyInstance(expenseCurrencySrv.getByOIDWithHV(request.getExpenseCurrencyresetExchangepthisExpenseCurrency()));
        return expenseCurrencySrv.resetExchangeImplementation(request);
    }

    /*
     * Implements service resetExchange
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse resetExchangeImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.ResetExchangeRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ExpenseCurrency expenseCurrencyresetExchangepthisExpenseCurrency = request.getExpenseCurrencyresetExchangepthisExpenseCurrencyInstance();

        request.checkArguments();
        ExpenseCurrency instance = expenseCurrencyresetExchangepthisExpenseCurrency;
        instance.setExpenseCurrencyExchange(Utilities.convertToDouble(Long.valueOf(1)));


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildDSExpenseCurrencySup());

        return response;
    }

    // Service: editExchange

    /*
     * Entry point for service editExchange
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse editExchange(
            com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.EditExchangeRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = expenseCurrencySrv.editExchangeTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service editExchange
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse editExchangeTxn(
            com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.EditExchangeRequest request) throws ModelException {
        request.setExpenseCurrencyeditExchangepthisExpenseCurrencyInstance(expenseCurrencySrv.getByOIDWithHV(request.getExpenseCurrencyeditExchangepthisExpenseCurrency()));
        return expenseCurrencySrv.editExchangeImplementation(request);
    }

    /*
     * Implements service editExchange
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse editExchangeImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.EditExchangeRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ExpenseCurrency expenseCurrencyeditExchangepthisExpenseCurrency = request.getExpenseCurrencyeditExchangepthisExpenseCurrencyInstance();
        Double expenseCurrencyeditExchangepExchange = request.getExpenseCurrencyeditExchangepExchange();

        request.checkArguments();
        ExpenseCurrency instance = expenseCurrencyeditExchangepthisExpenseCurrency;
        instance.setExpenseCurrencyExchange(expenseCurrencyeditExchangepExchange);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildDSExpenseCurrencySup());

        return response;
    }

    // Service: TNEW

    /*
     * Entry point for service TNEW
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse tNEW(
            com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.TNEWRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = expenseCurrencySrv.tNEWTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TNEW
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse tNEWTxn(
            com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.TNEWRequest request) throws ModelException {
        return expenseCurrencySrv.tNEWImplementation(request);
    }

    /*
     * Implements service TNEW
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse tNEWImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.TNEWRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        String expenseCurrencyTNEWpCurrencyName = request.getExpenseCurrencyTNEWpCurrencyName();
        String expenseCurrencyTNEWpCurrencyCode = request.getExpenseCurrencyTNEWpCurrencyCode();
        String expenseCurrencyTNEWpCurAcronym = request.getExpenseCurrencyTNEWpCurAcronym();
        Double expenseCurrencyTNEWpExchange = request.getExpenseCurrencyTNEWpExchange();

        request.checkArguments();
        ExpenseCurrency instance;

        com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.CreateinstanceRequest step1Request = new com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.CreateinstanceRequest();
        step1Request.setExpenseCurrencycreateinstancepatrCurrencyName(expenseCurrencyTNEWpCurrencyName);
        step1Request.setExpenseCurrencycreateinstancepatrCurrencyCode(expenseCurrencyTNEWpCurrencyCode);
        step1Request.setExpenseCurrencycreateinstancepatrCurAcronym(expenseCurrencyTNEWpCurAcronym);
        step1Request.setExpenseCurrencycreateinstancepatrExchange(expenseCurrencyTNEWpExchange);
        instance = (ExpenseCurrency) expenseCurrencySrv.createinstanceImplementation(step1Request).getInstance();

        com.integranova.spring.expensereportdemo.viewmodel.exchangehistory.siu.CreateinstanceRequest step2Request = new com.integranova.spring.expensereportdemo.viewmodel.exchangehistory.siu.CreateinstanceRequest();
        step2Request.setExchangeHistorycreateinstancepagrExpenseCurrencyInstance(instance);
        step2Request.setExchangeHistorycreateinstancepatroldValue(expenseCurrencyTNEWpExchange);
        step2Request.setExchangeHistorycreateinstancepatrnewValue(expenseCurrencyTNEWpExchange);
        exchangeHistorySrv.createinstanceImplementation(step2Request);

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildDSExpenseCurrencySup());

        return response;
    }

    // Service: TEDITEXCHANGE

    /*
     * Entry point for service TEDITEXCHANGE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse tEDITEXCHANGE(
            com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.TEDITEXCHANGERequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = expenseCurrencySrv.tEDITEXCHANGETxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TEDITEXCHANGE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse tEDITEXCHANGETxn(
            com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.TEDITEXCHANGERequest request) throws ModelException {
        request.setExpenseCurrencyTEDITEXCHANGEpthisExpenseCurrencyInstance(expenseCurrencySrv.getByOIDWithHV(request.getExpenseCurrencyTEDITEXCHANGEpthisExpenseCurrency()));
        return expenseCurrencySrv.tEDITEXCHANGEImplementation(request);
    }

    /*
     * Implements service TEDITEXCHANGE
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse tEDITEXCHANGEImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.TEDITEXCHANGERequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Double expenseCurrencyTEDITEXCHANGEpExchange = request.getExpenseCurrencyTEDITEXCHANGEpExchange();
        ExpenseCurrency expenseCurrencyTEDITEXCHANGEpthisExpenseCurrency = request.getExpenseCurrencyTEDITEXCHANGEpthisExpenseCurrencyInstance();

        request.checkArguments();
        ExpenseCurrency instance = expenseCurrencyTEDITEXCHANGEpthisExpenseCurrency;

        com.integranova.spring.expensereportdemo.viewmodel.exchangehistory.siu.CreateinstanceRequest step1Request = new com.integranova.spring.expensereportdemo.viewmodel.exchangehistory.siu.CreateinstanceRequest();
        step1Request.setExchangeHistorycreateinstancepagrExpenseCurrencyInstance(expenseCurrencyTEDITEXCHANGEpthisExpenseCurrency);
        step1Request.setExchangeHistorycreateinstancepatroldValue(expenseCurrencyTEDITEXCHANGEpthisExpenseCurrency.getExpenseCurrencyExchange());
        step1Request.setExchangeHistorycreateinstancepatrnewValue(expenseCurrencyTEDITEXCHANGEpExchange);
        exchangeHistorySrv.createinstanceImplementation(step1Request);

        com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.EditExchangeRequest step2Request = new com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.EditExchangeRequest();
        step2Request.setExpenseCurrencyeditExchangepthisExpenseCurrencyInstance(expenseCurrencyTEDITEXCHANGEpthisExpenseCurrency);
        step2Request.setExpenseCurrencyeditExchangepExchange(expenseCurrencyTEDITEXCHANGEpExchange);
        expenseCurrencySrv.editExchangeImplementation(step2Request);

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildDSExpenseCurrencySup());

        return response;
    }


    private void suppInfo4DSExpenseCurrencySup(String searchText, SQLSelect select) {
        try {
            SQLWhereDisjunction disjunction = new SQLWhereDisjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(select);
            comparison1.setOperator("LIKE");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(ExpenseCurrencyConstants.ATTR_NAME_EXPENSECURRENCYCURACRONYM, Constants.Type.STRING.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(searchText, Constants.Type.STRING.getTypeName()));
            disjunction.addComparison(comparison1);

            select.addDisjunction(disjunction);
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
    }

    @Override
    protected void applyOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        applyOCOCExpenseCurrency(queryRequest, select);
        applyDSItemSort(queryRequest, select);
    }
    

    private void applyOCOCExpenseCurrency(QueryRequest queryRequest, SQLSelect select) {
        if ("OC_ExpenseCurrency".equalsIgnoreCase(queryRequest.getOrderCriteriaName())) {
            select.getOrderByPart().addItem(Constants.normalizePath(ExpenseCurrencyConstants.CLASS_NAME, ExpenseCurrencyConstants.ATTR_NAME_EXPENSECURRENCYCURACRONYM, false), true);
        }
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildExpenseCurrencyRelatedInstance(relatedInstanceJsonOid);
        }
        if (ExpenseCurrencyConstants.ROLE_NAME_EXPENSEREPORTS.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildExpenseCurrencyRelatedInstance4ExpenseReport(relatedInstanceJsonOid, remainingPath);
        }
        if (ExpenseCurrencyConstants.ROLE_NAME_EXCHANGEHISTORYITEMS.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildExpenseCurrencyRelatedInstance4ExchangeHistory(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildExpenseCurrencyRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new ExpenseCurrency(mapper.readValue(relatedInstanceJsonOid, ExpenseCurrencyOid.class));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildExpenseCurrencyRelatedInstance4ExpenseReport(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ExpenseReport(mapper.readValue(relatedInstanceJsonOid, ExpenseReportOid.class)): expenseReportSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildExpenseCurrencyRelatedInstance4ExchangeHistory(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ExchangeHistory(mapper.readValue(relatedInstanceJsonOid, ExchangeHistoryOid.class)): exchangeHistorySrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            ExpenseCurrencyOid oid = new ExpenseCurrencyOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(ExpenseCurrencyConstants.ATTR_FIELD_EXPENSECURRENCYCURRENCYCODE, Constants.Type.STRING.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getExpenseCurrencyCurrencyCode(), Constants.Type.STRING.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(ExpenseCurrencyService.class).error(e.getMessage());
        }
    }

}
