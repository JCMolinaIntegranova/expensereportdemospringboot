package com.integranova.spring.expensereportdemo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.ERLTemplateConstants;
import com.integranova.spring.expensereportdemo.global.ERTemplateConstants;
import com.integranova.spring.expensereportdemo.persistence.AbstractAppEntity;
import com.integranova.spring.expensereportdemo.persistence.ERLTemplate;
import com.integranova.spring.expensereportdemo.persistence.ERTemplate;
import com.integranova.spring.expensereportdemo.persistence.ExpenseType;
import com.integranova.spring.expensereportdemo.persistence.oid.ERLTemplateOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ERTemplateOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseTypeOid;
import com.integranova.spring.expensereportdemo.repository.ERLTemplateJpaRepository;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereComparison;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandLiteral;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandPathAttribute;
import com.integranova.spring.expensereportdemo.utils.Utilities;
import com.integranova.spring.expensereportdemo.viewmodel.erltemplate.crud.ERLTemplatePostViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.erltemplate.crud.ERLTemplatePutViewModel;
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
public class ERLTemplateService extends AbstractService {

    @Autowired
    private ERLTemplateJpaRepository repository;

    @Autowired
    private ERLTemplateService eRLTemplateSrv;

    @Autowired
    private ERTemplateService eRTemplateSrv;

    @Autowired
    private ExpenseTypeService expenseTypeSrv;
    
    public ERLTemplate post(ERLTemplatePostViewModel payload) {
        ERLTemplate instance = new ERLTemplate();
        instance.setERLTemplateunits(payload.getERLTemplateunits());
        instance.setERLTemplateprice(payload.getERLTemplateprice());
        instance.setERLTemplatedescription(payload.getERLTemplatedescription());
        return repository.save(instance);
    }

    public ERLTemplate put(Long eRTemplateTemplateid, Long eRLTemplateid, ERLTemplatePutViewModel payload) throws ModelException {
        if (!repository.existsById(new ERLTemplateOid(eRTemplateTemplateid, eRLTemplateid))) throw new ModelException("Not found-Put");
        ERLTemplate instance = new ERLTemplate(new ERLTemplateOid(eRTemplateTemplateid, eRLTemplateid));
        instance.setERLTemplateunits(payload.getERLTemplateunits());
        instance.setERLTemplateprice(payload.getERLTemplateprice());
        instance.setERLTemplatedescription(payload.getERLTemplatedescription());
        return repository.save(instance);
    }

    public void delete(Long eRTemplateTemplateid, Long eRLTemplateid) throws ModelException {
        if (!repository.existsById(new ERLTemplateOid(eRTemplateTemplateid, eRLTemplateid))) throw new ModelException("Not found-Delete");
        repository.deleteById(new ERLTemplateOid(eRTemplateTemplateid, eRLTemplateid));
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, ERLTemplateConstants.CLASS_NAME);
    }

    private List<ERLTemplate> solveERLTemplateTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, ERLTemplateConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveERLTemplateTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, ERLTemplateConstants.CLASS_NAME));
    }
    
    /*
     * Returns the population of class ERLTemplate
     *
     * @return Population of class ERLTemplate
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<ERLTemplate> get() {
        return repository.findAll();
    }

    /*
     * Gets the properties of DisplaySet DSTemplateLines for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet DSTemplateLines for a given instance
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public com.integranova.spring.expensereportdemo.viewmodel.erltemplate.ds.DSTemplateLines getDSTemplateLines(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        ERLTemplate instance = (relatedInstancePath.isEmpty() ? 
                getByJsonOid(instanceOid):
                getByRelated(buildRelatedInstance(instanceOid, relatedInstancePath), relatedInstancePath).get(0));
        return new com.integranova.spring.expensereportdemo.viewmodel.erltemplate.ds.DSTemplateLines(instance);
    }

    /*
     * Returns the population of class ERLTemplate that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class ERLTemplate matching the search criteria
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<ERLTemplate> get(QueryRequest queryRequest) {
        return solveERLTemplateTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveERLTemplateTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveERLTemplateTypedCountQuery(queryRequest) : 0);
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
        return new PopulationResponseViewModel(solveERLTemplateTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of ERLTemplate by ID
     *
     * @param eRTemplateTemplateid Identification field eRTemplateTemplateid
     *
     * @param eRLTemplateid Identification field eRLTemplateid
     *
     * @return Instance of ERLTemplate
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public ERLTemplate getById(Long eRTemplateTemplateid, Long eRLTemplateid) {
        return getByOID(new ERLTemplateOid(eRTemplateTemplateid, eRLTemplateid));
    }
    
    /*
     * Returns an instance of ERLTemplate by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ERLTemplate
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public ERLTemplate getByOID(ERLTemplateOid oid) {
        Optional<ERLTemplate> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of ERLTemplate by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ERLTemplate
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public ERLTemplate getByOIDWithHV(ERLTemplateOid oid) {
        Optional<ERLTemplate> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<ERLTemplate> getInstanceByOid(ERLTemplateOid oid) {
        return oid != null && oid.getERTemplateTemplateid() != null
               ? repository.findById(oid)
               : Optional.empty();
    }
    
    /*
     * Returns an instance of ERLTemplate by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of ERLTemplate
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public ERLTemplate getByJsonOid(String jsonOid) {
        ERLTemplateOid oid = new ERLTemplateOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of ERLTemplate related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of ERLTemplate
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<ERLTemplate> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveERLTemplateTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of ERLTemplate related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of ERLTemplate
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<ERLTemplate> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of ERLTemplate
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of ERLTemplate
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public InstanceResponseViewModel getERLTemplateDynamic(ERLTemplateOid oid, String displaySetItems) {
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
    public String getSuppInfo(ERLTemplateOid oid, String dsName) {
        ERLTemplate instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(ERLTemplate instance, String dsName) {
        return instance != null && dsName.isEmpty() ? instance.getOid().toJson() : "";
    }




    // IIU Methods


    /*
     * Solves the query needed for PIUTemplateLines
     *
     * @param queryRequest Query request
     * @return List of viewmodels for ERLTemplate using displayset DSTemplateLines that 
     * match the search criteria
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<com.integranova.spring.expensereportdemo.viewmodel.erltemplate.ds.DSTemplateLines> piuPIUTemplateLines(QueryRequest queryRequest) {
        return solveERLTemplateTypedQuery(queryRequest).stream()
                .map(com.integranova.spring.expensereportdemo.viewmodel.erltemplate.ds.DSTemplateLines::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUTemplateLines
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUTemplateLines
     */
    public int getCount4PIUTemplateLines(QueryRequest queryRequest) {
        return solveERLTemplateTypedQuery(queryRequest).size();
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
            com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.CreateinstanceRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = eRLTemplateSrv.createinstanceTxn(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.CreateinstanceRequest request) throws ModelException {
        request.setERLTemplatecreateinstancepagrTemplateInstance(eRTemplateSrv.getByOIDWithHV(request.getERLTemplatecreateinstancepagrTemplate()));
        request.setERLTemplatecreateinstancepagrExpenseTypeInstance(expenseTypeSrv.getByOIDWithHV(request.getERLTemplatecreateinstancepagrExpenseType()));
        return eRLTemplateSrv.createinstanceImplementation(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.CreateinstanceRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ERTemplate eRLTemplatecreateinstancepagrTemplate = request.getERLTemplatecreateinstancepagrTemplateInstance();
        ExpenseType eRLTemplatecreateinstancepagrExpenseType = request.getERLTemplatecreateinstancepagrExpenseTypeInstance();
        Double eRLTemplatecreateinstancepatrunits = request.getERLTemplatecreateinstancepatrunits();
        Double eRLTemplatecreateinstancepatrprice = request.getERLTemplatecreateinstancepatrprice();
        String eRLTemplatecreateinstancepatrdescription = request.getERLTemplatecreateinstancepatrdescription();

        request.checkArguments();
        ERLTemplate instance = new ERLTemplate();
        instance.add2Template(eRLTemplatecreateinstancepagrTemplate);

        instance.add2ExpenseType(eRLTemplatecreateinstancepagrExpenseType);

        instance.setERLTemplateid(Long.valueOf(0));
        instance.setERLTemplateid(repository.nextERLTemplateid(instance.getERTemplateTemplateid()));
        instance.setERLTemplateunits(eRLTemplatecreateinstancepatrunits);
        instance.setERLTemplateprice(eRLTemplatecreateinstancepatrprice);
        instance.setERLTemplatedescription(eRLTemplatecreateinstancepatrdescription);
        
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
            com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.DeleteinstanceRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = eRLTemplateSrv.deleteinstanceTxn(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.DeleteinstanceRequest request) throws ModelException {
        request.setERLTemplatedeleteinstancepthisERLTemplateInstance(eRLTemplateSrv.getByOIDWithHV(request.getERLTemplatedeleteinstancepthisERLTemplate()));
        return eRLTemplateSrv.deleteinstanceImplementation(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.DeleteinstanceRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ERLTemplate eRLTemplatedeleteinstancepthisERLTemplate = request.getERLTemplatedeleteinstancepthisERLTemplateInstance();

        request.checkArguments();
        ERLTemplate instance = eRLTemplatedeleteinstancepthisERLTemplate;

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
            com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.EditinstanceRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = eRLTemplateSrv.editinstanceTxn(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.EditinstanceRequest request) throws ModelException {
        request.setERLTemplateeditinstancepthisERLTemplateInstance(eRLTemplateSrv.getByOIDWithHV(request.getERLTemplateeditinstancepthisERLTemplate()));
        return eRLTemplateSrv.editinstanceImplementation(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.EditinstanceRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ERLTemplate eRLTemplateeditinstancepthisERLTemplate = request.getERLTemplateeditinstancepthisERLTemplateInstance();
        Double eRLTemplateeditinstancepunits = request.getERLTemplateeditinstancepunits();
        Double eRLTemplateeditinstancepprice = request.getERLTemplateeditinstancepprice();
        String eRLTemplateeditinstancepdescription = request.getERLTemplateeditinstancepdescription();

        request.checkArguments();
        ERLTemplate instance = eRLTemplateeditinstancepthisERLTemplate;
        instance.setERLTemplateunits(eRLTemplateeditinstancepunits);
        instance.setERLTemplateprice(eRLTemplateeditinstancepprice);
        instance.setERLTemplatedescription(eRLTemplateeditinstancepdescription);


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: editUnits

    /*
     * Entry point for service editUnits
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse editUnits(
            com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.EditUnitsRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = eRLTemplateSrv.editUnitsTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service editUnits
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse editUnitsTxn(
            com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.EditUnitsRequest request) throws ModelException {
        request.setERLTemplateeditUnitspthisERLTemplateInstance(eRLTemplateSrv.getByOIDWithHV(request.getERLTemplateeditUnitspthisERLTemplate()));
        return eRLTemplateSrv.editUnitsImplementation(request);
    }

    /*
     * Implements service editUnits
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse editUnitsImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.EditUnitsRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ERLTemplate eRLTemplateeditUnitspthisERLTemplate = request.getERLTemplateeditUnitspthisERLTemplateInstance();
        Double eRLTemplateeditUnitspUnits = request.getERLTemplateeditUnitspUnits();

        request.checkArguments();
        ERLTemplate instance = eRLTemplateeditUnitspthisERLTemplate;
        instance.setERLTemplateunits(eRLTemplateeditUnitspUnits);


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: editPrice

    /*
     * Entry point for service editPrice
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse editPrice(
            com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.EditPriceRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = eRLTemplateSrv.editPriceTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service editPrice
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse editPriceTxn(
            com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.EditPriceRequest request) throws ModelException {
        request.setERLTemplateeditPricepthisERLTemplateInstance(eRLTemplateSrv.getByOIDWithHV(request.getERLTemplateeditPricepthisERLTemplate()));
        return eRLTemplateSrv.editPriceImplementation(request);
    }

    /*
     * Implements service editPrice
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse editPriceImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.EditPriceRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ERLTemplate eRLTemplateeditPricepthisERLTemplate = request.getERLTemplateeditPricepthisERLTemplateInstance();
        Double eRLTemplateeditPricepPrice = request.getERLTemplateeditPricepPrice();

        request.checkArguments();
        ERLTemplate instance = eRLTemplateeditPricepthisERLTemplate;
        instance.setERLTemplateprice(eRLTemplateeditPricepPrice);


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
            com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.EditDescriptionRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = eRLTemplateSrv.editDescriptionTxn(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.EditDescriptionRequest request) throws ModelException {
        request.setERLTemplateeditDescriptionpthisERLTemplateInstance(eRLTemplateSrv.getByOIDWithHV(request.getERLTemplateeditDescriptionpthisERLTemplate()));
        return eRLTemplateSrv.editDescriptionImplementation(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.EditDescriptionRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ERLTemplate eRLTemplateeditDescriptionpthisERLTemplate = request.getERLTemplateeditDescriptionpthisERLTemplateInstance();
        String eRLTemplateeditDescriptionpDescription = request.getERLTemplateeditDescriptionpDescription();

        request.checkArguments();
        ERLTemplate instance = eRLTemplateeditDescriptionpthisERLTemplate;
        instance.setERLTemplatedescription(eRLTemplateeditDescriptionpDescription);


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: clearUnits

    /*
     * Entry point for service clearUnits
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse clearUnits(
            com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.ClearUnitsRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = eRLTemplateSrv.clearUnitsTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service clearUnits
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse clearUnitsTxn(
            com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.ClearUnitsRequest request) throws ModelException {
        request.setERLTemplateclearUnitspthisERLTemplateInstance(eRLTemplateSrv.getByOIDWithHV(request.getERLTemplateclearUnitspthisERLTemplate()));
        return eRLTemplateSrv.clearUnitsImplementation(request);
    }

    /*
     * Implements service clearUnits
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse clearUnitsImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.ClearUnitsRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ERLTemplate eRLTemplateclearUnitspthisERLTemplate = request.getERLTemplateclearUnitspthisERLTemplateInstance();

        request.checkArguments();
        ERLTemplate instance = eRLTemplateclearUnitspthisERLTemplate;
        instance.setERLTemplateunits(Utilities.convertToDouble(Long.valueOf(0)));


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: clearPrice

    /*
     * Entry point for service clearPrice
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse clearPrice(
            com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.ClearPriceRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = eRLTemplateSrv.clearPriceTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service clearPrice
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse clearPriceTxn(
            com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.ClearPriceRequest request) throws ModelException {
        request.setERLTemplateclearPricepthisERLTemplateInstance(eRLTemplateSrv.getByOIDWithHV(request.getERLTemplateclearPricepthisERLTemplate()));
        return eRLTemplateSrv.clearPriceImplementation(request);
    }

    /*
     * Implements service clearPrice
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse clearPriceImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.ClearPriceRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ERLTemplate eRLTemplateclearPricepthisERLTemplate = request.getERLTemplateclearPricepthisERLTemplateInstance();

        request.checkArguments();
        ERLTemplate instance = eRLTemplateclearPricepthisERLTemplate;
        instance.setERLTemplateprice(Utilities.convertToDouble(Long.valueOf(0)));


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
            com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.ClearDescriptionRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = eRLTemplateSrv.clearDescriptionTxn(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.ClearDescriptionRequest request) throws ModelException {
        request.setERLTemplateclearDescriptionpthisERLTemplateInstance(eRLTemplateSrv.getByOIDWithHV(request.getERLTemplateclearDescriptionpthisERLTemplate()));
        return eRLTemplateSrv.clearDescriptionImplementation(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.erltemplate.siu.ClearDescriptionRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ERLTemplate eRLTemplateclearDescriptionpthisERLTemplate = request.getERLTemplateclearDescriptionpthisERLTemplateInstance();

        request.checkArguments();
        ERLTemplate instance = eRLTemplateclearDescriptionpthisERLTemplate;
        instance.setERLTemplatedescription("");


        response.setInstance(repository.save(instance));

        return response;
    }

    @Override
    protected void applyOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        applyOCOCTemplateLines(queryRequest, select);
        applyDSItemSort(queryRequest, select);
    }
    

    private void applyOCOCTemplateLines(QueryRequest queryRequest, SQLSelect select) {
        if ("OCTemplateLines".equalsIgnoreCase(queryRequest.getOrderCriteriaName())) {
            select.getOrderByPart().addItem(Constants.normalizePath(ERLTemplateConstants.CLASS_NAME, ERLTemplateConstants.ATTR_NAME_ERLTEMPLATEID, false), true);
        }
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildERLTemplateRelatedInstance(relatedInstanceJsonOid);
        }
        if (ERLTemplateConstants.ROLE_NAME_TEMPLATE.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildERLTemplateRelatedInstance4ERTemplate(relatedInstanceJsonOid, remainingPath);
        }
        if (ERLTemplateConstants.ROLE_NAME_EXPENSETYPE.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildERLTemplateRelatedInstance4ExpenseType(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildERLTemplateRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new ERLTemplate(mapper.readValue(relatedInstanceJsonOid, ERLTemplateOid.class));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildERLTemplateRelatedInstance4ERTemplate(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ERTemplate(mapper.readValue(relatedInstanceJsonOid, ERTemplateOid.class)): eRTemplateSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    private AbstractAppEntity buildERLTemplateRelatedInstance4ExpenseType(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ExpenseType(mapper.readValue(relatedInstanceJsonOid, ExpenseTypeOid.class)): expenseTypeSrv.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            ERLTemplateOid oid = new ERLTemplateOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(ERLTemplateConstants.ROLE_NAME_TEMPLATE + "." + ERTemplateConstants.ATTR_FIELD_ERTEMPLATEID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getERTemplateTemplateid(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("=");
            comparison2.setFirstOperand(new SQLWhereOperandPathAttribute(ERLTemplateConstants.ATTR_FIELD_ERLTEMPLATEID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison2.setSecondOperand(new SQLWhereOperandLiteral(oid.getERLTemplateid(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison2);
        } catch (Exception e) {
            LoggerFactory.getLogger(ERLTemplateService.class).error(e.getMessage());
        }
    }

}
