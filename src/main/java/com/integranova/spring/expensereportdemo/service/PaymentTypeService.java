package com.integranova.spring.expensereportdemo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.PaymentTypeConstants;
import com.integranova.spring.expensereportdemo.persistence.AbstractAppEntity;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseReportOid;
import com.integranova.spring.expensereportdemo.persistence.oid.PaymentTypeOid;
import com.integranova.spring.expensereportdemo.persistence.PaymentType;
import com.integranova.spring.expensereportdemo.repository.PaymentTypeJpaRepository;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereComparison;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereDisjunction;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandLiteral;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandPathAttribute;
import com.integranova.spring.expensereportdemo.viewmodel.FilterRequest;
import com.integranova.spring.expensereportdemo.viewmodel.FilterVariableRequest;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.paymenttype.crud.PaymentTypePostViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.paymenttype.crud.PaymentTypePutViewModel;
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
public class PaymentTypeService extends AbstractService {

    @Autowired
    private PaymentTypeJpaRepository repository;

    @Autowired
    private PaymentTypeService paymentTypeSrv;

    @Autowired
    private ExpenseReportService expenseReportSrv;
    
    public PaymentType post(PaymentTypePostViewModel payload) {
        PaymentType instance = new PaymentType();
        instance.setPaymentTypeidPaymentType(payload.getPaymentTypeidPaymentType());
        instance.setPaymentTypePayDescription(payload.getPaymentTypePayDescription());
        return repository.save(instance);
    }

    public PaymentType put(String paymentTypeidPaymentType, PaymentTypePutViewModel payload) throws ModelException {
        if (!repository.existsById(paymentTypeidPaymentType)) throw new ModelException("Not found-Put");
        PaymentType instance = new PaymentType(new PaymentTypeOid(paymentTypeidPaymentType));
        instance.setPaymentTypePayDescription(payload.getPaymentTypePayDescription());
        return repository.save(instance);
    }

    public void delete(String paymentTypeidPaymentType) throws ModelException {
        if (!repository.existsById(paymentTypeidPaymentType)) throw new ModelException("Not found-Delete");
        repository.deleteById(paymentTypeidPaymentType);
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, PaymentTypeConstants.CLASS_NAME);
    }

    private List<PaymentType> solvePaymentTypeTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, PaymentTypeConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solvePaymentTypeTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, PaymentTypeConstants.CLASS_NAME));
    }
    
    /*
     * Returns the population of class PaymentType
     *
     * @return Population of class PaymentType
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<PaymentType> get() {
        return repository.findAll();
    }
    
    /*
     * Gets the preloaded list of objects of class PaymentType
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return Preloaded list of objects of class PaymentType
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<PreloadViewModel> getPreload(QueryRequest queryRequest) {
        List<PreloadViewModel> results = new ArrayList<>();
        List<PaymentType> instances = get(queryRequest);
        if(PaymentTypeConstants.DSDSPAYMENTTYPE.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSPaymentType())).collect(Collectors.toList());
        }
        if(PaymentTypeConstants.DSDSPAYMENTTYPESUP.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSPaymentTypeSup())).collect(Collectors.toList());
        }
        return results;
    }

    /*
     * Gets the properties of DisplaySet DSPaymentType for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet DSPaymentType for a given instance
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public com.integranova.spring.expensereportdemo.viewmodel.paymenttype.ds.DSPaymentType getDSPaymentType(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        PaymentType instance = (relatedInstancePath.isEmpty() ? 
                getByJsonOid(instanceOid):
                getByRelated(buildRelatedInstance(instanceOid, relatedInstancePath), relatedInstancePath).get(0));
        return new com.integranova.spring.expensereportdemo.viewmodel.paymenttype.ds.DSPaymentType(instance);
    }

    /*
     * Gets the properties of DisplaySet DSPaymentTypeSup for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet DSPaymentTypeSup for a given instance
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public com.integranova.spring.expensereportdemo.viewmodel.paymenttype.ds.DSPaymentTypeSup getDSPaymentTypeSup(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        PaymentType instance = (relatedInstancePath.isEmpty() ? 
                getByJsonOid(instanceOid):
                getByRelated(buildRelatedInstance(instanceOid, relatedInstancePath), relatedInstancePath).get(0));
        return new com.integranova.spring.expensereportdemo.viewmodel.paymenttype.ds.DSPaymentTypeSup(instance);
    }

    /*
     * Returns the population of class PaymentType that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class PaymentType matching the search criteria
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<PaymentType> get(QueryRequest queryRequest) {
        return solvePaymentTypeTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solvePaymentTypeTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solvePaymentTypeTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel(solvePaymentTypeTypedQuery(queryRequest).stream()
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
        return new PopulationResponseViewModel(solvePaymentTypeTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of PaymentType by ID
     *
     * @param paymentTypeidPaymentType Identification field paymentTypeidPaymentType
     *
     * @return Instance of PaymentType
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public PaymentType getById(String paymentTypeidPaymentType) {
        return getByOID(new PaymentTypeOid(paymentTypeidPaymentType));
    }
    
    /*
     * Returns an instance of PaymentType by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of PaymentType
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public PaymentType getByOID(PaymentTypeOid oid) {
        Optional<PaymentType> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of PaymentType by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of PaymentType
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public PaymentType getByOIDWithHV(PaymentTypeOid oid) {
        Optional<PaymentType> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<PaymentType> getInstanceByOid(PaymentTypeOid oid) {
        return oid != null && oid.getPaymentTypeidPaymentType() != null
               ? repository.findById(oid.getPaymentTypeidPaymentType())
               : Optional.empty();
    }
    
    /*
     * Returns an instance of PaymentType by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of PaymentType
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public PaymentType getByJsonOid(String jsonOid) {
        PaymentTypeOid oid = new PaymentTypeOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of PaymentType related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of PaymentType
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<PaymentType> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solvePaymentTypeTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of PaymentType related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of PaymentType
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<PaymentType> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of PaymentType
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of PaymentType
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public InstanceResponseViewModel getPaymentTypeDynamic(PaymentTypeOid oid, String displaySetItems) {
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
    public String getSuppInfo(PaymentTypeOid oid, String dsName) {
        PaymentType instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(PaymentType instance, String dsName) {
        if (PaymentTypeConstants.DSDSPAYMENTTYPESUP.equals(dsName))
            return instance.buildDSPaymentTypeSup();
        return instance != null && dsName.isEmpty() ? instance.getOid().toJson() : "";
    }

    public static PreloadViewModel buildPreloadViewModel(PaymentType instance, String dsName) {
        if (PaymentTypeConstants.DSDSPAYMENTTYPE.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSPaymentType());
        if (PaymentTypeConstants.DSDSPAYMENTTYPESUP.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSPaymentTypeSup());
        return new PreloadViewModel(instance.getOid().toJson(), "");
    }


    @Override
    protected void applyServiceSIFilters(FilterRequest filterRequest, SQLSelect sql) {
        if ("SuppInfo_DS_PaymentTypeSup".equals(filterRequest.getName()))
            suppInfo4DSPaymentTypeSup(filterRequest.getFilterVariable("searchText").toString(), sql);
    }



    // IIU Methods

    /*
     * Returns a viewmodel for class PaymentType with displayset DSPaymentType for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class PaymentType with displayset DSPaymentType
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public com.integranova.spring.expensereportdemo.viewmodel.paymenttype.ds.DSPaymentType iIUPaymentType(PaymentTypeOid oid) {
        return new com.integranova.spring.expensereportdemo.viewmodel.paymenttype.ds.DSPaymentType(getByOIDWithHV(oid));
    }


    /*
     * Solves the query needed for PIUPaymentType
     *
     * @param queryRequest Query request
     * @return List of viewmodels for PaymentType using displayset DSPaymentType that 
     * match the search criteria
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<com.integranova.spring.expensereportdemo.viewmodel.paymenttype.ds.DSPaymentType> piuPIUPaymentType(QueryRequest queryRequest) {
        return solvePaymentTypeTypedQuery(queryRequest).stream()
                .map(com.integranova.spring.expensereportdemo.viewmodel.paymenttype.ds.DSPaymentType::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUPaymentType
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUPaymentType
     */
    public int getCount4PIUPaymentType(QueryRequest queryRequest) {
        return solvePaymentTypeTypedQuery(queryRequest).size();
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
            com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu.CreateinstanceRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = paymentTypeSrv.createinstanceTxn(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu.CreateinstanceRequest request) throws ModelException {
        return paymentTypeSrv.createinstanceImplementation(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu.CreateinstanceRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        String paymentTypecreateinstancepatridPaymentType = request.getPaymentTypecreateinstancepatridPaymentType();
        String paymentTypecreateinstancepatrPayDescription = request.getPaymentTypecreateinstancepatrPayDescription();

        request.checkArguments();
        PaymentType instance = new PaymentType();
        instance.setPaymentTypeidPaymentType(paymentTypecreateinstancepatridPaymentType);
        instance.setPaymentTypePayDescription(paymentTypecreateinstancepatrPayDescription);
        
        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildDSPaymentTypeSup());

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
            com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu.DeleteinstanceRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = paymentTypeSrv.deleteinstanceTxn(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu.DeleteinstanceRequest request) throws ModelException {
        request.setPaymentTypedeleteinstancepthisPaymentTypeInstance(paymentTypeSrv.getByOIDWithHV(request.getPaymentTypedeleteinstancepthisPaymentType()));
        return paymentTypeSrv.deleteinstanceImplementation(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu.DeleteinstanceRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        PaymentType paymentTypedeleteinstancepthisPaymentType = request.getPaymentTypedeleteinstancepthisPaymentTypeInstance();

        request.checkArguments();
        PaymentType instance = paymentTypedeleteinstancepthisPaymentType;

        repository.delete(instance);
        
        response.setInstance(instance);
        response.setInstanceSuppInfo(instance.buildDSPaymentTypeSup());

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
            com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu.EditinstanceRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = paymentTypeSrv.editinstanceTxn(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu.EditinstanceRequest request) throws ModelException {
        request.setPaymentTypeeditinstancepthisPaymentTypeInstance(paymentTypeSrv.getByOIDWithHV(request.getPaymentTypeeditinstancepthisPaymentType()));
        return paymentTypeSrv.editinstanceImplementation(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu.EditinstanceRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        PaymentType paymentTypeeditinstancepthisPaymentType = request.getPaymentTypeeditinstancepthisPaymentTypeInstance();
        String paymentTypeeditinstancepPayDescription = request.getPaymentTypeeditinstancepPayDescription();

        request.checkArguments();
        PaymentType instance = paymentTypeeditinstancepthisPaymentType;
        instance.setPaymentTypePayDescription(paymentTypeeditinstancepPayDescription);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildDSPaymentTypeSup());

        return response;
    }

    // Service: InsPaymentType

    /*
     * Entry point for service InsPaymentType
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse insPaymentType(
            com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu.InsPaymentTypeRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = paymentTypeSrv.insPaymentTypeTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsPaymentType
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse insPaymentTypeTxn(
            com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu.InsPaymentTypeRequest request) throws ModelException {
        request.setPaymentTypeInsPaymentTypepthisPaymentTypeInstance(paymentTypeSrv.getByOIDWithHV(request.getPaymentTypeInsPaymentTypepthisPaymentType()));
        request.setPaymentTypeInsPaymentTypepevcExpenseReportInstance(expenseReportSrv.getByOIDWithHV(request.getPaymentTypeInsPaymentTypepevcExpenseReport()));
        return paymentTypeSrv.insPaymentTypeImplementation(request, true);
    }

    /*
     * Implements service InsPaymentType
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse insPaymentTypeImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu.InsPaymentTypeRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        PaymentType paymentTypeInsPaymentTypepthisPaymentType = request.getPaymentTypeInsPaymentTypepthisPaymentTypeInstance();
        ExpenseReport paymentTypeInsPaymentTypepevcExpenseReport = request.getPaymentTypeInsPaymentTypepevcExpenseReportInstance();

        request.checkArguments();
        PaymentType instance = paymentTypeInsPaymentTypepthisPaymentType;

        instance.getExpenseReport().add(paymentTypeInsPaymentTypepevcExpenseReport);
        if (isEntryPoint) {
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.InsPaymentTypeRequest relatedRequest = new com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.InsPaymentTypeRequest();
            relatedRequest.setExpenseReportInsPaymentTypepthisExpenseReportInstance(paymentTypeInsPaymentTypepevcExpenseReport);
            relatedRequest.setExpenseReportInsPaymentTypepevcPaymentTypeInstance(paymentTypeInsPaymentTypepthisPaymentType);
            expenseReportSrv.insPaymentTypeImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildDSPaymentTypeSup());

        return response;
    }

    // Service: DelPaymentType

    /*
     * Entry point for service DelPaymentType
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse delPaymentType(
            com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu.DelPaymentTypeRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = paymentTypeSrv.delPaymentTypeTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelPaymentType
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse delPaymentTypeTxn(
            com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu.DelPaymentTypeRequest request) throws ModelException {
        request.setPaymentTypeDelPaymentTypepthisPaymentTypeInstance(paymentTypeSrv.getByOIDWithHV(request.getPaymentTypeDelPaymentTypepthisPaymentType()));
        request.setPaymentTypeDelPaymentTypepevcExpenseReportInstance(expenseReportSrv.getByOIDWithHV(request.getPaymentTypeDelPaymentTypepevcExpenseReport()));
        return paymentTypeSrv.delPaymentTypeImplementation(request, true);
    }

    /*
     * Implements service DelPaymentType
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse delPaymentTypeImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu.DelPaymentTypeRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        PaymentType paymentTypeDelPaymentTypepthisPaymentType = request.getPaymentTypeDelPaymentTypepthisPaymentTypeInstance();
        ExpenseReport paymentTypeDelPaymentTypepevcExpenseReport = request.getPaymentTypeDelPaymentTypepevcExpenseReportInstance();

        request.checkArguments();
        PaymentType instance = paymentTypeDelPaymentTypepthisPaymentType;

        if (isEntryPoint) {
            com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DelPaymentTypeRequest relatedRequest = new com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DelPaymentTypeRequest();
            relatedRequest.setExpenseReportDelPaymentTypepthisExpenseReportInstance(paymentTypeDelPaymentTypepevcExpenseReport);
            relatedRequest.setExpenseReportDelPaymentTypepevcPaymentTypeInstance(paymentTypeDelPaymentTypepthisPaymentType);
            expenseReportSrv.delPaymentTypeImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildDSPaymentTypeSup());

        return response;
    }


    private void suppInfo4DSPaymentTypeSup(String searchText, SQLSelect select) {
        try {
            SQLWhereDisjunction disjunction = new SQLWhereDisjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(select);
            comparison1.setOperator("LIKE");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(PaymentTypeConstants.ATTR_NAME_PAYMENTTYPEPAYDESCRIPTION, Constants.Type.STRING.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(searchText, Constants.Type.STRING.getTypeName()));
            disjunction.addComparison(comparison1);

            select.addDisjunction(disjunction);
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
    }

    @Override
    protected void applyOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        applyOCOCPaymentType(queryRequest, select);
        applyDSItemSort(queryRequest, select);
    }
    

    private void applyOCOCPaymentType(QueryRequest queryRequest, SQLSelect select) {
        if ("OC_PaymentType".equalsIgnoreCase(queryRequest.getOrderCriteriaName())) {
            select.getOrderByPart().addItem(Constants.normalizePath(PaymentTypeConstants.CLASS_NAME, PaymentTypeConstants.ATTR_NAME_PAYMENTTYPEPAYDESCRIPTION, false), true);
        }
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildPaymentTypeRelatedInstance(relatedInstanceJsonOid);
        }
        if (PaymentTypeConstants.ROLE_NAME_EXPENSEREPORT.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildPaymentTypeRelatedInstance4ExpenseReport(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildPaymentTypeRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new PaymentType(mapper.readValue(relatedInstanceJsonOid, PaymentTypeOid.class));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildPaymentTypeRelatedInstance4ExpenseReport(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ExpenseReport(mapper.readValue(relatedInstanceJsonOid, ExpenseReportOid.class)): expenseReportSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            PaymentTypeOid oid = new PaymentTypeOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(PaymentTypeConstants.ATTR_FIELD_PAYMENTTYPEIDPAYMENTTYPE, Constants.Type.STRING.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getPaymentTypeidPaymentType(), Constants.Type.STRING.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(PaymentTypeService.class).error(e.getMessage());
        }
    }

}
