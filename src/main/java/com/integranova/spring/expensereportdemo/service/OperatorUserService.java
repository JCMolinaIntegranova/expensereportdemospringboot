package com.integranova.spring.expensereportdemo.service;

import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.AppUserConstants;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.OperatorUserConstants;
import com.integranova.spring.expensereportdemo.persistence.AppUser;
import com.integranova.spring.expensereportdemo.persistence.oid.OperatorUserOid;
import com.integranova.spring.expensereportdemo.persistence.OperatorUser;
import com.integranova.spring.expensereportdemo.repository.OperatorUserJpaRepository;
import com.integranova.spring.expensereportdemo.service.AppUserService;
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
public class OperatorUserService extends AbstractService {

    @Autowired
    private OperatorUserJpaRepository repository;

    @Autowired
    private AppUserService appUserSrv;

    public void delete(String appUserLogin) throws ModelException {
        if (!repository.existsById(appUserLogin)) throw new ModelException("Not found-Delete");
        repository.deleteById(appUserLogin);
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, OperatorUserConstants.CLASS_NAME);
    }

    private List<OperatorUser> solveOperatorUserTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, OperatorUserConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveOperatorUserTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, OperatorUserConstants.CLASS_NAME));
    }
    
    /*
     * Returns the population of class OperatorUser
     *
     * @return Population of class OperatorUser
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<OperatorUser> get() {
        return repository.findAll();
    }

    /*
     * Returns the population of class OperatorUser that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class OperatorUser matching the search criteria
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<OperatorUser> get(QueryRequest queryRequest) {
        return solveOperatorUserTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveOperatorUserTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveOperatorUserTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel();
        }
    }

    /*
     * Returns an instance of OperatorUser by ID
     *
     * @param appUserLogin Identification field appUserLogin
     *
     * @return Instance of OperatorUser
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public OperatorUser getById(String appUserLogin) {
        return getByOID(new OperatorUserOid(appUserLogin));
    }
    
    /*
     * Returns an instance of OperatorUser by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of OperatorUser
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public OperatorUser getByOID(OperatorUserOid oid) {
        Optional<OperatorUser> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of OperatorUser by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of OperatorUser
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public OperatorUser getByOIDWithHV(OperatorUserOid oid) {
        Optional<OperatorUser> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<OperatorUser> getInstanceByOid(OperatorUserOid oid) {
        return oid != null && oid.getAppUserLogin() != null
               ? repository.findById(oid.getAppUserLogin())
               : Optional.empty();
    }
    
    /*
     * Returns an instance of OperatorUser by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of OperatorUser
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public OperatorUser getByJsonOid(String jsonOid) {
        OperatorUserOid oid = new OperatorUserOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns a set of displayset items for an instance of OperatorUser
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of OperatorUser
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public InstanceResponseViewModel getOperatorUserDynamic(OperatorUserOid oid, String displaySetItems) {
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
    public String getSuppInfo(OperatorUserOid oid, String dsName) {
        OperatorUser instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(OperatorUser instance, String dsName) {
        return instance != null && dsName.isEmpty() ? instance.getOid().toJson() : "";
    }




    // IIU Methods



    // Service: makeOperator

    /*
     * Implements service makeOperator
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse makeOperatorImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.MakeOperatorRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        AppUser appUsermakeOperatorpthisAppUser = request.getAppUsermakeOperatorpthisAppUserInstance();

        request.checkArguments();
        OperatorUser instance = new OperatorUser();

        instance.setAppUserLogin(appUsermakeOperatorpthisAppUser.getAppUserLogin());

        instance.setParentAppUser(appUsermakeOperatorpthisAppUser);
        instance.setPassWord(appUsermakeOperatorpthisAppUser.getPassWord());


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: cancelOperator

    /*
     * Implements service cancelOperator
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse cancelOperatorImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.CancelOperatorRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        AppUser appUsercancelOperatorpthisAppUser = request.getAppUsercancelOperatorpthisAppUserInstance();

        request.checkArguments();
        OperatorUser instance = appUsercancelOperatorpthisAppUser.getChildOperatorUser();
        appUsercancelOperatorpthisAppUser.setChildOperatorUser(null);

        repository.delete(instance);
        
        response.setInstance(instance);

        return response;
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            OperatorUserOid oid = new OperatorUserOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(AppUserConstants.ATTR_FIELD_APPUSERLOGIN, Constants.Type.STRING.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getAppUserLogin(), Constants.Type.STRING.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(OperatorUserService.class).error(e.getMessage());
        }
    }

}
