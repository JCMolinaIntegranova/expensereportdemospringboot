package com.integranova.spring.expensereportdemo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.ExchangeHistoryConstants;
import com.integranova.spring.expensereportdemo.global.ExpenseCurrencyConstants;
import com.integranova.spring.expensereportdemo.global.STDFunctions;
import com.integranova.spring.expensereportdemo.persistence.AbstractAppEntity;
import com.integranova.spring.expensereportdemo.persistence.ExchangeHistory;
import com.integranova.spring.expensereportdemo.persistence.ExpenseCurrency;
import com.integranova.spring.expensereportdemo.persistence.oid.ExchangeHistoryOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseCurrencyOid;
import com.integranova.spring.expensereportdemo.repository.ExchangeHistoryJpaRepository;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereComparison;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandLiteral;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandPathAttribute;
import com.integranova.spring.expensereportdemo.viewmodel.exchangehistory.crud.ExchangeHistoryPostViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.exchangehistory.crud.ExchangeHistoryPutViewModel;
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
public class ExchangeHistoryService extends AbstractService {

    @Autowired
    private ExchangeHistoryJpaRepository repository;

    @Autowired
    private ExchangeHistoryService exchangeHistorySrv;

    @Autowired
    private ExpenseCurrencyService expenseCurrencySrv;
    
    public ExchangeHistory post(ExchangeHistoryPostViewModel payload) {
        ExchangeHistory instance = new ExchangeHistory();
        instance.setExchangeHistoryoldValue(payload.getExchangeHistoryoldValue());
        instance.setExchangeHistorynewValue(payload.getExchangeHistorynewValue());
        return repository.save(instance);
    }

    public ExchangeHistory put(String expenseCurrencyCurrencyCode, Date exchangeHistoryentryDate, ExchangeHistoryPutViewModel payload) throws ModelException {
        if (!repository.existsById(new ExchangeHistoryOid(expenseCurrencyCurrencyCode, exchangeHistoryentryDate))) throw new ModelException("Not found-Put");
        ExchangeHistory instance = new ExchangeHistory(new ExchangeHistoryOid(expenseCurrencyCurrencyCode, exchangeHistoryentryDate));
        instance.setExchangeHistoryoldValue(payload.getExchangeHistoryoldValue());
        instance.setExchangeHistorynewValue(payload.getExchangeHistorynewValue());
        return repository.save(instance);
    }

    public void delete(String expenseCurrencyCurrencyCode, Date exchangeHistoryentryDate) throws ModelException {
        if (!repository.existsById(new ExchangeHistoryOid(expenseCurrencyCurrencyCode, exchangeHistoryentryDate))) throw new ModelException("Not found-Delete");
        repository.deleteById(new ExchangeHistoryOid(expenseCurrencyCurrencyCode, exchangeHistoryentryDate));
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, ExchangeHistoryConstants.CLASS_NAME);
    }

    private List<ExchangeHistory> solveExchangeHistoryTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, ExchangeHistoryConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveExchangeHistoryTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, ExchangeHistoryConstants.CLASS_NAME));
    }
    
    /*
     * Returns the population of class ExchangeHistory
     *
     * @return Population of class ExchangeHistory
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<ExchangeHistory> get() {
        return repository.findAll();
    }

    /*
     * Returns the population of class ExchangeHistory that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class ExchangeHistory matching the search criteria
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<ExchangeHistory> get(QueryRequest queryRequest) {
        return solveExchangeHistoryTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveExchangeHistoryTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveExchangeHistoryTypedCountQuery(queryRequest) : 0);
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
        return new PopulationResponseViewModel(solveExchangeHistoryTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of ExchangeHistory by ID
     *
     * @param expenseCurrencyCurrencyCode Identification field expenseCurrencyCurrencyCode
     *
     * @param exchangeHistoryentryDate Identification field exchangeHistoryentryDate
     *
     * @return Instance of ExchangeHistory
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public ExchangeHistory getById(String expenseCurrencyCurrencyCode, Date exchangeHistoryentryDate) {
        return getByOID(new ExchangeHistoryOid(expenseCurrencyCurrencyCode, exchangeHistoryentryDate));
    }
    
    /*
     * Returns an instance of ExchangeHistory by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ExchangeHistory
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public ExchangeHistory getByOID(ExchangeHistoryOid oid) {
        Optional<ExchangeHistory> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of ExchangeHistory by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ExchangeHistory
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public ExchangeHistory getByOIDWithHV(ExchangeHistoryOid oid) {
        Optional<ExchangeHistory> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<ExchangeHistory> getInstanceByOid(ExchangeHistoryOid oid) {
        return oid != null && oid.getExpenseCurrencyCurrencyCode() != null
               ? repository.findById(oid)
               : Optional.empty();
    }
    
    /*
     * Returns an instance of ExchangeHistory by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of ExchangeHistory
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public ExchangeHistory getByJsonOid(String jsonOid) {
        ExchangeHistoryOid oid = new ExchangeHistoryOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of ExchangeHistory related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of ExchangeHistory
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<ExchangeHistory> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveExchangeHistoryTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of ExchangeHistory related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of ExchangeHistory
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<ExchangeHistory> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of ExchangeHistory
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of ExchangeHistory
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public InstanceResponseViewModel getExchangeHistoryDynamic(ExchangeHistoryOid oid, String displaySetItems) {
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
    public String getSuppInfo(ExchangeHistoryOid oid, String dsName) {
        ExchangeHistory instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(ExchangeHistory instance, String dsName) {
        return instance != null && dsName.isEmpty() ? instance.getOid().toJson() : "";
    }




    // IIU Methods



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
            com.integranova.spring.expensereportdemo.viewmodel.exchangehistory.siu.CreateinstanceRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = exchangeHistorySrv.createinstanceTxn(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.exchangehistory.siu.CreateinstanceRequest request) throws ModelException {
        request.setExchangeHistorycreateinstancepagrExpenseCurrencyInstance(expenseCurrencySrv.getByOIDWithHV(request.getExchangeHistorycreateinstancepagrExpenseCurrency()));
        return exchangeHistorySrv.createinstanceImplementation(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.exchangehistory.siu.CreateinstanceRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ExpenseCurrency exchangeHistorycreateinstancepagrExpenseCurrency = request.getExchangeHistorycreateinstancepagrExpenseCurrencyInstance();
        Double exchangeHistorycreateinstancepatroldValue = request.getExchangeHistorycreateinstancepatroldValue();
        Double exchangeHistorycreateinstancepatrnewValue = request.getExchangeHistorycreateinstancepatrnewValue();

        request.checkArguments();
        ExchangeHistory instance = new ExchangeHistory();
        instance.add2ExpenseCurrency(exchangeHistorycreateinstancepagrExpenseCurrency);

        instance.setExchangeHistoryentryDate(STDFunctions.systemDateFun());
        instance.setExchangeHistoryoldValue(exchangeHistorycreateinstancepatroldValue);
        instance.setExchangeHistorynewValue(exchangeHistorycreateinstancepatrnewValue);
        
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
            com.integranova.spring.expensereportdemo.viewmodel.exchangehistory.siu.DeleteinstanceRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = exchangeHistorySrv.deleteinstanceTxn(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.exchangehistory.siu.DeleteinstanceRequest request) throws ModelException {
        request.setExchangeHistorydeleteinstancepthisExchangeHistoryInstance(exchangeHistorySrv.getByOIDWithHV(request.getExchangeHistorydeleteinstancepthisExchangeHistory()));
        return exchangeHistorySrv.deleteinstanceImplementation(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.exchangehistory.siu.DeleteinstanceRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ExchangeHistory exchangeHistorydeleteinstancepthisExchangeHistory = request.getExchangeHistorydeleteinstancepthisExchangeHistoryInstance();

        request.checkArguments();
        ExchangeHistory instance = exchangeHistorydeleteinstancepthisExchangeHistory;

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
            com.integranova.spring.expensereportdemo.viewmodel.exchangehistory.siu.EditinstanceRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = exchangeHistorySrv.editinstanceTxn(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.exchangehistory.siu.EditinstanceRequest request) throws ModelException {
        request.setExchangeHistoryeditinstancepthisExchangeHistoryInstance(exchangeHistorySrv.getByOIDWithHV(request.getExchangeHistoryeditinstancepthisExchangeHistory()));
        return exchangeHistorySrv.editinstanceImplementation(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.exchangehistory.siu.EditinstanceRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ExchangeHistory exchangeHistoryeditinstancepthisExchangeHistory = request.getExchangeHistoryeditinstancepthisExchangeHistoryInstance();
        Double exchangeHistoryeditinstancepoldValue = request.getExchangeHistoryeditinstancepoldValue();
        Double exchangeHistoryeditinstancepnewValue = request.getExchangeHistoryeditinstancepnewValue();

        request.checkArguments();
        ExchangeHistory instance = exchangeHistoryeditinstancepthisExchangeHistory;
        instance.setExchangeHistoryoldValue(exchangeHistoryeditinstancepoldValue);
        instance.setExchangeHistorynewValue(exchangeHistoryeditinstancepnewValue);


        response.setInstance(repository.save(instance));

        return response;
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildExchangeHistoryRelatedInstance(relatedInstanceJsonOid);
        }
        if (ExchangeHistoryConstants.ROLE_NAME_EXPENSECURRENCY.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildExchangeHistoryRelatedInstance4ExpenseCurrency(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildExchangeHistoryRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new ExchangeHistory(mapper.readValue(relatedInstanceJsonOid, ExchangeHistoryOid.class));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildExchangeHistoryRelatedInstance4ExpenseCurrency(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ExpenseCurrency(mapper.readValue(relatedInstanceJsonOid, ExpenseCurrencyOid.class)): expenseCurrencySrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            ExchangeHistoryOid oid = new ExchangeHistoryOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(ExchangeHistoryConstants.ROLE_NAME_EXPENSECURRENCY + "." + ExpenseCurrencyConstants.ATTR_FIELD_EXPENSECURRENCYCURRENCYCODE, Constants.Type.STRING.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getExpenseCurrencyCurrencyCode(), Constants.Type.STRING.getTypeName()));
            sql.addComparison(comparison1);
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("=");
            comparison2.setFirstOperand(new SQLWhereOperandPathAttribute(ExchangeHistoryConstants.ATTR_FIELD_EXCHANGEHISTORYENTRYDATE, Constants.Type.DATE.getTypeName()));
            comparison2.setSecondOperand(new SQLWhereOperandLiteral(oid.getExchangeHistoryentryDate(), Constants.Type.DATE.getTypeName()));
            sql.addComparison(comparison2);
        } catch (Exception e) {
            LoggerFactory.getLogger(ExchangeHistoryService.class).error(e.getMessage());
        }
    }

}
