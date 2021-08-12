package com.integranova.spring.expensereportdemo.service;

import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.SystemParamConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.SystemParamOid;
import com.integranova.spring.expensereportdemo.persistence.SystemParam;
import com.integranova.spring.expensereportdemo.repository.SystemParamJpaRepository;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereComparison;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandLiteral;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandPathAttribute;
import com.integranova.spring.expensereportdemo.viewmodel.FilterRequest;
import com.integranova.spring.expensereportdemo.viewmodel.FilterVariableRequest;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.QueryRequest;
import com.integranova.spring.expensereportdemo.viewmodel.QueryResponse;
import com.integranova.spring.expensereportdemo.viewmodel.ServiceResponse;
import com.integranova.spring.expensereportdemo.viewmodel.systemparam.crud.SystemParamPostViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.systemparam.crud.SystemParamPutViewModel;
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
public class SystemParamService extends AbstractService {

    @Autowired
    private SystemParamJpaRepository repository;

    @Autowired
    private SystemParamService systemParamSrv;
    
    public SystemParam post(SystemParamPostViewModel payload) {
        SystemParam instance = new SystemParam();
        instance.setSystemParamparamCode(payload.getSystemParamparamCode());
        instance.setSystemParamname(payload.getSystemParamname());
        instance.setSystemParamdescription(payload.getSystemParamdescription());
        instance.setSystemParamtypeName(payload.getSystemParamtypeName());
        instance.setSystemParamparamValue(payload.getSystemParamparamValue());
        return repository.save(instance);
    }

    public SystemParam put(String systemParamparamCode, SystemParamPutViewModel payload) throws ModelException {
        if (!repository.existsById(systemParamparamCode)) throw new ModelException("Not found-Put");
        SystemParam instance = new SystemParam(new SystemParamOid(systemParamparamCode));
        instance.setSystemParamname(payload.getSystemParamname());
        instance.setSystemParamdescription(payload.getSystemParamdescription());
        instance.setSystemParamtypeName(payload.getSystemParamtypeName());
        instance.setSystemParamparamValue(payload.getSystemParamparamValue());
        return repository.save(instance);
    }

    public void delete(String systemParamparamCode) throws ModelException {
        if (!repository.existsById(systemParamparamCode)) throw new ModelException("Not found-Delete");
        repository.deleteById(systemParamparamCode);
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, SystemParamConstants.CLASS_NAME);
    }

    private List<SystemParam> solveSystemParamTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, SystemParamConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveSystemParamTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, SystemParamConstants.CLASS_NAME));
    }
    
    /*
     * Returns the population of class SystemParam
     *
     * @return Population of class SystemParam
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<SystemParam> get() {
        return repository.findAll();
    }

    /*
     * Gets the properties of DisplaySet DSSystemParams for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet DSSystemParams for a given instance
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public com.integranova.spring.expensereportdemo.viewmodel.systemparam.ds.DSSystemParams getDSSystemParams(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        SystemParam instance = getByJsonOid(instanceOid);
        return new com.integranova.spring.expensereportdemo.viewmodel.systemparam.ds.DSSystemParams(instance);
    }

    /*
     * Returns the population of class SystemParam that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class SystemParam matching the search criteria
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<SystemParam> get(QueryRequest queryRequest) {
        return solveSystemParamTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveSystemParamTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveSystemParamTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel();
        }
    }

    /*
     * Returns an instance of SystemParam by ID
     *
     * @param systemParamparamCode Identification field systemParamparamCode
     *
     * @return Instance of SystemParam
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public SystemParam getById(String systemParamparamCode) {
        return getByOID(new SystemParamOid(systemParamparamCode));
    }
    
    /*
     * Returns an instance of SystemParam by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of SystemParam
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public SystemParam getByOID(SystemParamOid oid) {
        Optional<SystemParam> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of SystemParam by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of SystemParam
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public SystemParam getByOIDWithHV(SystemParamOid oid) {
        Optional<SystemParam> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<SystemParam> getInstanceByOid(SystemParamOid oid) {
        return oid != null && oid.getSystemParamparamCode() != null
               ? repository.findById(oid.getSystemParamparamCode())
               : Optional.empty();
    }
    
    /*
     * Returns an instance of SystemParam by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of SystemParam
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public SystemParam getByJsonOid(String jsonOid) {
        SystemParamOid oid = new SystemParamOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns a set of displayset items for an instance of SystemParam
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of SystemParam
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public InstanceResponseViewModel getSystemParamDynamic(SystemParamOid oid, String displaySetItems) {
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
    public String getSuppInfo(SystemParamOid oid, String dsName) {
        SystemParam instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(SystemParam instance, String dsName) {
        return instance != null && dsName.isEmpty() ? instance.getOid().toJson() : "";
    }




    // IIU Methods


    /*
     * Solves the query needed for PIUSystemParams
     *
     * @param queryRequest Query request
     * @return List of viewmodels for SystemParam using displayset DSSystemParams that 
     * match the search criteria
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<com.integranova.spring.expensereportdemo.viewmodel.systemparam.ds.DSSystemParams> piuPIUSystemParams(QueryRequest queryRequest) {
        return solveSystemParamTypedQuery(queryRequest).stream()
                .map(com.integranova.spring.expensereportdemo.viewmodel.systemparam.ds.DSSystemParams::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUSystemParams
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUSystemParams
     */
    public int getCount4PIUSystemParams(QueryRequest queryRequest) {
        return solveSystemParamTypedQuery(queryRequest).size();
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
            com.integranova.spring.expensereportdemo.viewmodel.systemparam.siu.CreateinstanceRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = systemParamSrv.createinstanceTxn(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.systemparam.siu.CreateinstanceRequest request) throws ModelException {
        return systemParamSrv.createinstanceImplementation(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.systemparam.siu.CreateinstanceRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        String systemParamcreateinstancepatrparamCode = request.getSystemParamcreateinstancepatrparamCode();
        String systemParamcreateinstancepatrname = request.getSystemParamcreateinstancepatrname();
        String systemParamcreateinstancepatrdescription = request.getSystemParamcreateinstancepatrdescription();
        String systemParamcreateinstancepatrtypeName = request.getSystemParamcreateinstancepatrtypeName();
        String systemParamcreateinstancepatrparamValue = request.getSystemParamcreateinstancepatrparamValue();

        request.checkArguments();
        SystemParam instance = new SystemParam();
        instance.setSystemParamparamCode(systemParamcreateinstancepatrparamCode);
        instance.setSystemParamname(systemParamcreateinstancepatrname);
        instance.setSystemParamdescription(systemParamcreateinstancepatrdescription);
        instance.setSystemParamtypeName(systemParamcreateinstancepatrtypeName);
        instance.setSystemParamparamValue(systemParamcreateinstancepatrparamValue);
        
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
            com.integranova.spring.expensereportdemo.viewmodel.systemparam.siu.DeleteinstanceRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = systemParamSrv.deleteinstanceTxn(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.systemparam.siu.DeleteinstanceRequest request) throws ModelException {
        request.setSystemParamdeleteinstancepthisSystemParamInstance(systemParamSrv.getByOIDWithHV(request.getSystemParamdeleteinstancepthisSystemParam()));
        return systemParamSrv.deleteinstanceImplementation(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.systemparam.siu.DeleteinstanceRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SystemParam systemParamdeleteinstancepthisSystemParam = request.getSystemParamdeleteinstancepthisSystemParamInstance();

        request.checkArguments();
        SystemParam instance = systemParamdeleteinstancepthisSystemParam;

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
            com.integranova.spring.expensereportdemo.viewmodel.systemparam.siu.EditinstanceRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = systemParamSrv.editinstanceTxn(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.systemparam.siu.EditinstanceRequest request) throws ModelException {
        request.setSystemParameditinstancepthisSystemParamInstance(systemParamSrv.getByOIDWithHV(request.getSystemParameditinstancepthisSystemParam()));
        return systemParamSrv.editinstanceImplementation(request);
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
            com.integranova.spring.expensereportdemo.viewmodel.systemparam.siu.EditinstanceRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SystemParam systemParameditinstancepthisSystemParam = request.getSystemParameditinstancepthisSystemParamInstance();
        String systemParameditinstancepname = request.getSystemParameditinstancepname();
        String systemParameditinstancepdescription = request.getSystemParameditinstancepdescription();
        String systemParameditinstanceptypeName = request.getSystemParameditinstanceptypeName();
        String systemParameditinstancepparamValue = request.getSystemParameditinstancepparamValue();

        request.checkArguments();
        SystemParam instance = systemParameditinstancepthisSystemParam;
        instance.setSystemParamname(systemParameditinstancepname);
        instance.setSystemParamdescription(systemParameditinstancepdescription);
        instance.setSystemParamtypeName(systemParameditinstanceptypeName);
        instance.setSystemParamparamValue(systemParameditinstancepparamValue);


        response.setInstance(repository.save(instance));

        return response;
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            SystemParamOid oid = new SystemParamOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(SystemParamConstants.ATTR_FIELD_SYSTEMPARAMPARAMCODE, Constants.Type.STRING.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getSystemParamparamCode(), Constants.Type.STRING.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(SystemParamService.class).error(e.getMessage());
        }
    }

}
