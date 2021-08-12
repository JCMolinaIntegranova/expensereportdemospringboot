package com.integranova.spring.expensereportdemo.service;

import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.AdminUserConstants;
import com.integranova.spring.expensereportdemo.global.AppUserConstants;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.persistence.AdminUser;
import com.integranova.spring.expensereportdemo.persistence.AppUser;
import com.integranova.spring.expensereportdemo.persistence.oid.AdminUserOid;
import com.integranova.spring.expensereportdemo.repository.AdminUserJpaRepository;
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
public class AdminUserService extends AbstractService {

    @Autowired
    private AdminUserJpaRepository repository;

    @Autowired
    private AppUserService appUserSrv;

    public void delete(String appUserLogin) throws ModelException {
        if (!repository.existsById(appUserLogin)) throw new ModelException("Not found-Delete");
        repository.deleteById(appUserLogin);
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, AdminUserConstants.CLASS_NAME);
    }

    private List<AdminUser> solveAdminUserTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, AdminUserConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveAdminUserTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, AdminUserConstants.CLASS_NAME));
    }
    
    /*
     * Returns the population of class AdminUser
     *
     * @return Population of class AdminUser
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<AdminUser> get() {
        return repository.findAll();
    }

    /*
     * Returns the population of class AdminUser that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class AdminUser matching the search criteria
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<AdminUser> get(QueryRequest queryRequest) {
        return solveAdminUserTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveAdminUserTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveAdminUserTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel();
        }
    }

    /*
     * Returns an instance of AdminUser by ID
     *
     * @param appUserLogin Identification field appUserLogin
     *
     * @return Instance of AdminUser
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public AdminUser getById(String appUserLogin) {
        return getByOID(new AdminUserOid(appUserLogin));
    }
    
    /*
     * Returns an instance of AdminUser by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of AdminUser
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public AdminUser getByOID(AdminUserOid oid) {
        Optional<AdminUser> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of AdminUser by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of AdminUser
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public AdminUser getByOIDWithHV(AdminUserOid oid) {
        Optional<AdminUser> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<AdminUser> getInstanceByOid(AdminUserOid oid) {
        return oid != null && oid.getAppUserLogin() != null
               ? repository.findById(oid.getAppUserLogin())
               : Optional.empty();
    }
    
    /*
     * Returns an instance of AdminUser by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of AdminUser
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public AdminUser getByJsonOid(String jsonOid) {
        AdminUserOid oid = new AdminUserOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns a set of displayset items for an instance of AdminUser
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of AdminUser
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public InstanceResponseViewModel getAdminUserDynamic(AdminUserOid oid, String displaySetItems) {
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
    public String getSuppInfo(AdminUserOid oid, String dsName) {
        AdminUser instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(AdminUser instance, String dsName) {
        return instance != null && dsName.isEmpty() ? instance.getOid().toJson() : "";
    }




    // IIU Methods



    // Service: makeAdmin

    /*
     * Implements service makeAdmin
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse makeAdminImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.MakeAdminRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        AppUser appUsermakeAdminpthisAppUser = request.getAppUsermakeAdminpthisAppUserInstance();

        request.checkArguments();
        AdminUser instance = new AdminUser();

        instance.setAppUserLogin(appUsermakeAdminpthisAppUser.getAppUserLogin());

        instance.setParentAppUser(appUsermakeAdminpthisAppUser);
        instance.setPassWord(appUsermakeAdminpthisAppUser.getPassWord());


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: cancelAdmin

    /*
     * Implements service cancelAdmin
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse cancelAdminImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.CancelAdminRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        AppUser appUsercancelAdminpthisAppUser = request.getAppUsercancelAdminpthisAppUserInstance();

        request.checkArguments();
        AdminUser instance = appUsercancelAdminpthisAppUser.getChildAdminUser();
        appUsercancelAdminpthisAppUser.setChildAdminUser(null);

        repository.delete(instance);
        
        response.setInstance(instance);

        return response;
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            AdminUserOid oid = new AdminUserOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(AppUserConstants.ATTR_FIELD_APPUSERLOGIN, Constants.Type.STRING.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getAppUserLogin(), Constants.Type.STRING.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(AdminUserService.class).error(e.getMessage());
        }
    }

}
