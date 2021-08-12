package com.integranova.spring.expensereportdemo.service;

import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.AppUserConstants;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.OperatorUserConstants;
import com.integranova.spring.expensereportdemo.persistence.AdminUser;
import com.integranova.spring.expensereportdemo.persistence.AppUser;
import com.integranova.spring.expensereportdemo.persistence.oid.AppUserOid;
import com.integranova.spring.expensereportdemo.persistence.OperatorUser;
import com.integranova.spring.expensereportdemo.repository.AppUserJpaRepository;
import com.integranova.spring.expensereportdemo.service.AppUserService;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereComparison;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereConjunction;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereDisjunction;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandLiteral;
import com.integranova.spring.expensereportdemo.sqlutils.SQLWhereOperandPathAttribute;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.crud.AppUserPostViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.crud.AppUserPutViewModel;
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
public class AppUserService extends AbstractService {

    @Autowired
    private AppUserJpaRepository repository;

    @Autowired
    private AppUserService appUserSrv;

    @Autowired
    private AdminUserService adminUserSrv;

    @Autowired
    private OperatorUserService operatorUserSrv;
    
    public AppUser post(AppUserPostViewModel payload) {
        AppUser instance = new AppUser();
        instance.setAppUserLogin(payload.getAppUserLogin());
        instance.setAppUserUserName(payload.getAppUserUserName());
        instance.setAppUserUserSurname(payload.getAppUserUserSurname());
        instance.setAppUserUserType(payload.getAppUserUserType());
        return repository.save(instance);
    }

    public AppUser put(String appUserLogin, AppUserPutViewModel payload) throws ModelException {
        if (!repository.existsById(appUserLogin)) throw new ModelException("Not found-Put");
        AppUser instance = new AppUser(new AppUserOid(appUserLogin));
        instance.setAppUserUserName(payload.getAppUserUserName());
        instance.setAppUserUserSurname(payload.getAppUserUserSurname());
        instance.setAppUserUserType(payload.getAppUserUserType());
        return repository.save(instance);
    }

    public void delete(String appUserLogin) throws ModelException {
        if (!repository.existsById(appUserLogin)) throw new ModelException("Not found-Delete");
        repository.deleteById(appUserLogin);
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, AppUserConstants.CLASS_NAME);
    }

    private List<AppUser> solveAppUserTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, AppUserConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveAppUserTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, AppUserConstants.CLASS_NAME));
    }
    
    /*
     * Returns the population of class AppUser
     *
     * @return Population of class AppUser
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<AppUser> get() {
        return repository.findAll();
    }

    /*
     * Gets the properties of DisplaySet DSAppUsers for a given instance
     *
     * @param instanceOid Instance OID in JSON format. Related instance OID in JSON
     * format if relatedInstancePath is provided
     *
     * @param relatedInstancePath Inverse navigation path to a related instance
     *
     * @param relatedInstanceDomain Domain of the related instance
     *
     * @return Properties of DisplaySet DSAppUsers for a given instance
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public com.integranova.spring.expensereportdemo.viewmodel.appuser.ds.DSAppUsers getDSAppUsers(String instanceOid, String relatedInstancePath, String relatedInstanceDomain) {
        AppUser instance = getByJsonOid(instanceOid);
        return new com.integranova.spring.expensereportdemo.viewmodel.appuser.ds.DSAppUsers(instance);
    }

    /*
     * Returns the population of class AppUser that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class AppUser matching the search criteria
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<AppUser> get(QueryRequest queryRequest) {
        return solveAppUserTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveAppUserTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveAppUserTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel();
        }
    }

    /*
     * Returns an instance of AppUser by ID
     *
     * @param appUserLogin Identification field appUserLogin
     *
     * @return Instance of AppUser
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public AppUser getById(String appUserLogin) {
        return getByOID(new AppUserOid(appUserLogin));
    }
    
    /*
     * Returns an instance of AppUser by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of AppUser
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public AppUser getByOID(AppUserOid oid) {
        Optional<AppUser> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of AppUser by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of AppUser
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public AppUser getByOIDWithHV(AppUserOid oid) {
        Optional<AppUser> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<AppUser> getInstanceByOid(AppUserOid oid) {
        return oid != null && oid.getAppUserLogin() != null
               ? repository.findById(oid.getAppUserLogin())
               : Optional.empty();
    }
    
    /*
     * Returns an instance of AppUser by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of AppUser
     */
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public AppUser getByJsonOid(String jsonOid) {
        AppUserOid oid = new AppUserOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns a set of displayset items for an instance of AppUser
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of AppUser
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public InstanceResponseViewModel getAppUserDynamic(AppUserOid oid, String displaySetItems) {
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
    public String getSuppInfo(AppUserOid oid, String dsName) {
        AppUser instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(AppUser instance, String dsName) {
        return instance != null && dsName.isEmpty() ? instance.getOid().toJson() : "";
    }


    @Override
    protected void applyQueryFilters(FilterRequest filterRequest, SQLSelect sql) {
        if (AppUserConstants.FILTER_NAME_FAPPUSERS.equalsIgnoreCase(filterRequest.getName()))
            fAppUsers(filterRequest, sql);
    }


    private void fAppUsers(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        String vName = filterRequest.hasFilterVariable(AppUserConstants.VAR_NAME_FAPPUSERS_VNAME) ? (String) filterRequest.getFilterVariable(AppUserConstants.VAR_NAME_FAPPUSERS_VNAME, FilterVariableRequest.STRING) : null;
        String vSurname = filterRequest.hasFilterVariable(AppUserConstants.VAR_NAME_FAPPUSERS_VSURNAME) ? (String) filterRequest.getFilterVariable(AppUserConstants.VAR_NAME_FAPPUSERS_VSURNAME, FilterVariableRequest.STRING) : null;
        String vType = filterRequest.hasFilterVariable(AppUserConstants.VAR_NAME_FAPPUSERS_VTYPE) ? (String) filterRequest.getFilterVariable(AppUserConstants.VAR_NAME_FAPPUSERS_VTYPE, FilterVariableRequest.STRING) : null;

        // UserName LIKE vName
        if (vName != null) {
            // 'like' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(AppUserConstants.ATTR_NAME_APPUSERUSERNAME, Constants.Type.STRING.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            SQLWhereOperandLiteral operand223 = new SQLWhereOperandLiteral(vName, Constants.Type.STRING.getTypeName());
            comparison1.setSecondOperand(operand223);
            conjunction.addOperand(comparison1);

        }        

        // UserSurname LIKE vSurname
        if (vSurname != null) {
            // 'like' Comparison
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(AppUserConstants.ATTR_NAME_APPUSERUSERSURNAME, Constants.Type.STRING.getTypeName());
            comparison2.setFirstOperand(operand113);
            
            // Operand 2
            SQLWhereOperandLiteral operand224 = new SQLWhereOperandLiteral(vSurname, Constants.Type.STRING.getTypeName());
            comparison2.setSecondOperand(operand224);
            conjunction.addOperand(comparison2);

        }        

        // UserType = vType
        if (vType != null) {
            // '=' Comparison
            SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
            comparison3.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(AppUserConstants.ATTR_NAME_APPUSERUSERTYPE, Constants.Type.STRING.getTypeName());
            comparison3.setFirstOperand(operand114);
            
            // Operand 2
            SQLWhereOperandLiteral operand225 = new SQLWhereOperandLiteral(vType, Constants.Type.STRING.getTypeName());
            comparison3.setSecondOperand(operand225);
            conjunction.addOperand(comparison3);

        }        

        sql.addConjunction(conjunction);
    }

    // IIU Methods


    /*
     * Solves the query needed for PIUAppUsers
     *
     * @param queryRequest Query request
     * @return List of viewmodels for AppUser using displayset DSAppUsers that 
     * match the search criteria
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public List<com.integranova.spring.expensereportdemo.viewmodel.appuser.ds.DSAppUsers> piuPIUAppUsers(QueryRequest queryRequest) {
        return solveAppUserTypedQuery(queryRequest).stream()
                .map(com.integranova.spring.expensereportdemo.viewmodel.appuser.ds.DSAppUsers::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUAppUsers
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUAppUsers
     */
    public int getCount4PIUAppUsers(QueryRequest queryRequest) {
        return solveAppUserTypedQuery(queryRequest).size();
    }

    // Service: newUser

    /*
     * Entry point for service newUser
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse newUser(
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.NewUserRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = appUserSrv.newUserTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service newUser
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse newUserTxn(
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.NewUserRequest request) throws ModelException {
        return appUserSrv.newUserImplementation(request);
    }

    /*
     * Implements service newUser
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse newUserImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.NewUserRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        String appUsernewUserpatrLogin = request.getAppUsernewUserpatrLogin();
        String appUsernewUserpatrUserName = request.getAppUsernewUserpatrUserName();
        String appUsernewUserpatrUserSurname = request.getAppUsernewUserpatrUserSurname();
        String appUsernewUserpatrUserType = request.getAppUsernewUserpatrUserType();
        String appUsernewUserppassword = request.getAppUsernewUserppassword();

        request.checkArguments();
        AppUser instance = new AppUser();
        instance.setAppUserLogin(appUsernewUserpatrLogin);
        instance.setAppUserUserName(appUsernewUserpatrUserName);
        instance.setAppUserUserSurname(appUsernewUserpatrUserSurname);
        instance.setAppUserUserType(appUsernewUserpatrUserType);
        instance.setPassWord(encrypt(appUsernewUserppassword));
        
        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: deleteUser

    /*
     * Entry point for service deleteUser
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse deleteUser(
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.DeleteUserRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = appUserSrv.deleteUserTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service deleteUser
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse deleteUserTxn(
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.DeleteUserRequest request) throws ModelException {
        request.setAppUserdeleteUserpthisAppUserInstance(appUserSrv.getByOIDWithHV(request.getAppUserdeleteUserpthisAppUser()));
        return appUserSrv.deleteUserImplementation(request);
    }

    /*
     * Implements service deleteUser
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse deleteUserImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.DeleteUserRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        AppUser appUserdeleteUserpthisAppUser = request.getAppUserdeleteUserpthisAppUserInstance();

        request.checkArguments();
        AppUser instance = appUserdeleteUserpthisAppUser;

        repository.delete(instance);
        
        response.setInstance(instance);

        return response;
    }

    // Service: editUser

    /*
     * Entry point for service editUser
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse editUser(
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.EditUserRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = appUserSrv.editUserTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service editUser
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse editUserTxn(
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.EditUserRequest request) throws ModelException {
        request.setAppUsereditUserpthisAppUserInstance(appUserSrv.getByOIDWithHV(request.getAppUsereditUserpthisAppUser()));
        return appUserSrv.editUserImplementation(request);
    }

    /*
     * Implements service editUser
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse editUserImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.EditUserRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        AppUser appUsereditUserpthisAppUser = request.getAppUsereditUserpthisAppUserInstance();
        String appUsereditUserpUserName = request.getAppUsereditUserpUserName();
        String appUsereditUserpUserSurname = request.getAppUsereditUserpUserSurname();

        request.checkArguments();
        AppUser instance = appUsereditUserpthisAppUser;
        instance.setAppUserUserName(appUsereditUserpUserName);
        instance.setAppUserUserSurname(appUsereditUserpUserSurname);


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: setPassword

    /*
     * Entry point for service setPassword
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse setPassword(
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.SetPasswordRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = appUserSrv.setPasswordTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service setPassword
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse setPasswordTxn(
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.SetPasswordRequest request) throws ModelException {
        request.setAppUsersetPasswordpthisAppUserInstance(appUserSrv.getByOIDWithHV(request.getAppUsersetPasswordpthisAppUser()));
        return appUserSrv.setPasswordImplementation(request);
    }

    /*
     * Implements service setPassword
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse setPasswordImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.SetPasswordRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        AppUser appUsersetPasswordpthisAppUser = request.getAppUsersetPasswordpthisAppUserInstance();
        String appUsersetPasswordpNewPassword = request.getAppUsersetPasswordpNewPassword();

        request.checkArguments();
        AppUser instance = appUsersetPasswordpthisAppUser;
        instance.setPassWord(encrypt(appUsersetPasswordpNewPassword));


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: makeAdmin

    /*
     * Entry point for service makeAdmin
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse makeAdmin(
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.MakeAdminRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = appUserSrv.makeAdminTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service makeAdmin
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse makeAdminTxn(
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.MakeAdminRequest request) throws ModelException {
        request.setAppUsermakeAdminpthisAppUserInstance(appUserSrv.getByOIDWithHV(request.getAppUsermakeAdminpthisAppUser()));
        return appUserSrv.makeAdminImplementation(request);
    }

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
        AppUser instance = appUsermakeAdminpthisAppUser;

        instance.setChildAdminUser((AdminUser) adminUserSrv.makeAdminImplementation(request).getInstance());

        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: makeOperator

    /*
     * Entry point for service makeOperator
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse makeOperator(
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.MakeOperatorRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = appUserSrv.makeOperatorTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service makeOperator
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse makeOperatorTxn(
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.MakeOperatorRequest request) throws ModelException {
        request.setAppUsermakeOperatorpthisAppUserInstance(appUserSrv.getByOIDWithHV(request.getAppUsermakeOperatorpthisAppUser()));
        return appUserSrv.makeOperatorImplementation(request);
    }

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
        AppUser instance = appUsermakeOperatorpthisAppUser;

        instance.setChildOperatorUser((OperatorUser) operatorUserSrv.makeOperatorImplementation(request).getInstance());

        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: changeUserType

    /*
     * Entry point for service changeUserType
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse changeUserType(
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.ChangeUserTypeRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = appUserSrv.changeUserTypeTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service changeUserType
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse changeUserTypeTxn(
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.ChangeUserTypeRequest request) throws ModelException {
        request.setAppUserchangeUserTypepthisAppUserInstance(appUserSrv.getByOIDWithHV(request.getAppUserchangeUserTypepthisAppUser()));
        return appUserSrv.changeUserTypeImplementation(request);
    }

    /*
     * Implements service changeUserType
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse changeUserTypeImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.ChangeUserTypeRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        AppUser appUserchangeUserTypepthisAppUser = request.getAppUserchangeUserTypepthisAppUserInstance();
        String appUserchangeUserTypepNewType = request.getAppUserchangeUserTypepNewType();

        request.checkArguments();
        AppUser instance = appUserchangeUserTypepthisAppUser;
        instance.setAppUserUserType(appUserchangeUserTypepNewType);


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: cancelAdmin

    /*
     * Entry point for service cancelAdmin
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse cancelAdmin(
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.CancelAdminRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = appUserSrv.cancelAdminTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service cancelAdmin
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse cancelAdminTxn(
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.CancelAdminRequest request) throws ModelException {
        request.setAppUsercancelAdminpthisAppUserInstance(appUserSrv.getByOIDWithHV(request.getAppUsercancelAdminpthisAppUser()));
        return appUserSrv.cancelAdminImplementation(request);
    }

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
        AppUser instance = appUsercancelAdminpthisAppUser;

        adminUserSrv.cancelAdminImplementation(request);

        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: cancelOperator

    /*
     * Entry point for service cancelOperator
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse cancelOperator(
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.CancelOperatorRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = appUserSrv.cancelOperatorTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service cancelOperator
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse cancelOperatorTxn(
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.CancelOperatorRequest request) throws ModelException {
        request.setAppUsercancelOperatorpthisAppUserInstance(appUserSrv.getByOIDWithHV(request.getAppUsercancelOperatorpthisAppUser()));
        return appUserSrv.cancelOperatorImplementation(request);
    }

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
        AppUser instance = appUsercancelOperatorpthisAppUser;

        operatorUserSrv.cancelOperatorImplementation(request);

        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: TNEWUSER

    /*
     * Entry point for service TNEWUSER
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse tNEWUSER(
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.TNEWUSERRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = appUserSrv.tNEWUSERTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TNEWUSER
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse tNEWUSERTxn(
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.TNEWUSERRequest request) throws ModelException {
        return appUserSrv.tNEWUSERImplementation(request);
    }

    /*
     * Implements service TNEWUSER
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse tNEWUSERImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.TNEWUSERRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        String appUserTNEWUSERpLogin = request.getAppUserTNEWUSERpLogin();
        String appUserTNEWUSERpName = request.getAppUserTNEWUSERpName();
        String appUserTNEWUSERpSurname = request.getAppUserTNEWUSERpSurname();
        String appUserTNEWUSERpType = request.getAppUserTNEWUSERpType();
        String appUserTNEWUSERpPassword = request.getAppUserTNEWUSERpPassword();

        request.checkArguments();
        AppUser instance;

        com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.NewUserRequest step1Request = new com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.NewUserRequest();
        step1Request.setAppUsernewUserpatrLogin(appUserTNEWUSERpLogin);
        step1Request.setAppUsernewUserpatrUserName(appUserTNEWUSERpName);
        step1Request.setAppUsernewUserpatrUserSurname(appUserTNEWUSERpSurname);
        step1Request.setAppUsernewUserpatrUserType(appUserTNEWUSERpType);
        step1Request.setAppUsernewUserppassword(appUserTNEWUSERpPassword);
        instance = (AppUser) appUserSrv.newUserImplementation(step1Request).getInstance();

        /* Action 2: IF (UserType = "ADM") */
        boolean ifCondition2 = (instance.getAppUserUserType()).equals("ADM");
        if (ifCondition2) {
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.MakeAdminRequest step20Request = new com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.MakeAdminRequest();
            step20Request.setAppUsermakeAdminpthisAppUserInstance(instance);
            appUserSrv.makeAdminImplementation(step20Request);
        } else {
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.MakeOperatorRequest step21Request = new com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.MakeOperatorRequest();
            step21Request.setAppUsermakeOperatorpthisAppUserInstance(instance);
            appUserSrv.makeOperatorImplementation(step21Request);
        }

        response.setInstance(getByOID(instance.getOid()));

        return response;
    }

    // Service: TEDITUSER

    /*
     * Entry point for service TEDITUSER
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse tEDITUSER(
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.TEDITUSERRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = appUserSrv.tEDITUSERTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TEDITUSER
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse tEDITUSERTxn(
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.TEDITUSERRequest request) throws ModelException {
        request.setAppUserTEDITUSERpthisAppUserInstance(appUserSrv.getByOIDWithHV(request.getAppUserTEDITUSERpthisAppUser()));
        return appUserSrv.tEDITUSERImplementation(request);
    }

    /*
     * Implements service TEDITUSER
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse tEDITUSERImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.TEDITUSERRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        String appUserTEDITUSERpName = request.getAppUserTEDITUSERpName();
        String appUserTEDITUSERpSurname = request.getAppUserTEDITUSERpSurname();
        String appUserTEDITUSERpType = request.getAppUserTEDITUSERpType();
        AppUser appUserTEDITUSERpthisAppUser = request.getAppUserTEDITUSERpthisAppUserInstance();

        request.checkArguments();
        AppUser instance = appUserTEDITUSERpthisAppUser;

        com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.EditUserRequest step1Request = new com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.EditUserRequest();
        step1Request.setAppUsereditUserpthisAppUserInstance(appUserTEDITUSERpthisAppUser);
        step1Request.setAppUsereditUserpUserName(appUserTEDITUSERpName);
        step1Request.setAppUsereditUserpUserSurname(appUserTEDITUSERpSurname);
        appUserSrv.editUserImplementation(step1Request);

        /* Action 2: IF (UserType <> pType) */
        boolean ifCondition2 = !(appUserTEDITUSERpthisAppUser.getAppUserUserType()).equals(appUserTEDITUSERpType);
        if (ifCondition2) {
            /* Action 20: IF (UserType = "ADM") */
            boolean ifCondition20 = (appUserTEDITUSERpthisAppUser.getAppUserUserType()).equals("ADM");
            if (ifCondition20) {
                com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.CancelAdminRequest step200Request = new com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.CancelAdminRequest();
                step200Request.setAppUsercancelAdminpthisAppUserInstance(appUserTEDITUSERpthisAppUser);
                appUserSrv.cancelAdminImplementation(step200Request);
                com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.MakeOperatorRequest step201Request = new com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.MakeOperatorRequest();
                step201Request.setAppUsermakeOperatorpthisAppUserInstance(appUserTEDITUSERpthisAppUser);
                appUserSrv.makeOperatorImplementation(step201Request);
            }
            /* Action 21: IF (UserType = "OPR") */
            boolean ifCondition21 = (appUserTEDITUSERpthisAppUser.getAppUserUserType()).equals("OPR");
            if (ifCondition21) {
                com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.CancelOperatorRequest step210Request = new com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.CancelOperatorRequest();
                step210Request.setAppUsercancelOperatorpthisAppUserInstance(appUserTEDITUSERpthisAppUser);
                appUserSrv.cancelOperatorImplementation(step210Request);
                com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.MakeAdminRequest step211Request = new com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.MakeAdminRequest();
                step211Request.setAppUsermakeAdminpthisAppUserInstance(appUserTEDITUSERpthisAppUser);
                appUserSrv.makeAdminImplementation(step211Request);
            }
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.ChangeUserTypeRequest step22Request = new com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.ChangeUserTypeRequest();
            step22Request.setAppUserchangeUserTypepthisAppUserInstance(appUserTEDITUSERpthisAppUser);
            step22Request.setAppUserchangeUserTypepNewType(appUserTEDITUSERpType);
            appUserSrv.changeUserTypeImplementation(step22Request);
        }

        response.setInstance(getByOID(instance.getOid()));

        return response;
    }

    // Service: TDELETE

    /*
     * Entry point for service TDELETE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.NOT_SUPPORTED)
    public ServiceResponse tDELETE(
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.TDELETERequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = appUserSrv.tDELETETxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TDELETE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW, rollbackFor = {
            ModelException.class, SystemException.class })
    public ServiceResponse tDELETETxn(
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.TDELETERequest request) throws ModelException {
        request.setAppUserTDELETEpthisAppUserInstance(appUserSrv.getByOIDWithHV(request.getAppUserTDELETEpthisAppUser()));
        return appUserSrv.tDELETEImplementation(request);
    }

    /*
     * Implements service TDELETE
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.MANDATORY)
    public ServiceResponse tDELETEImplementation(
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.TDELETERequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        AppUser appUserTDELETEpthisAppUser = request.getAppUserTDELETEpthisAppUserInstance();

        request.checkArguments();
        AppUser instance = appUserTDELETEpthisAppUser;

        /* Action 1: IF (UserType = "ADM") */
        boolean ifCondition1 = (appUserTDELETEpthisAppUser.getAppUserUserType()).equals("ADM");
        if (ifCondition1) {
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.CancelAdminRequest step10Request = new com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.CancelAdminRequest();
            step10Request.setAppUsercancelAdminpthisAppUserInstance(appUserTDELETEpthisAppUser);
            appUserSrv.cancelAdminImplementation(step10Request);
        }

        /* Action 2: IF (UserType = "OPR") */
        boolean ifCondition2 = (appUserTDELETEpthisAppUser.getAppUserUserType()).equals("OPR");
        if (ifCondition2) {
            com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.CancelOperatorRequest step20Request = new com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.CancelOperatorRequest();
            step20Request.setAppUsercancelOperatorpthisAppUserInstance(appUserTDELETEpthisAppUser);
            appUserSrv.cancelOperatorImplementation(step20Request);
        }

        com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.DeleteUserRequest step3Request = new com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.DeleteUserRequest();
        step3Request.setAppUserdeleteUserpthisAppUserInstance(appUserTDELETEpthisAppUser);
        appUserSrv.deleteUserImplementation(step3Request);

        response.setInstance(getByOID(instance.getOid()));

        return response;
    }


    @Override
    protected void applyHVFilter(SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        SQLWhereDisjunction disjunction = new SQLWhereDisjunction();
        if (getAgentRoles().contains(OperatorUserConstants.CLASS_NAME)) applyHVFilter4OperatorUser(sql, disjunction);
        conjunction.addDisjunction(disjunction);
        sql.addConjunction(conjunction);
    }

    private void applyHVFilter4OperatorUser(SQLSelect sql, SQLWhereDisjunction disjunction) {
        // Agent.UserType = UserType
        OperatorUser agentInstance = getAgentOperatorUser();
        // '=' Comparison
        SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
        comparison1.setOperator("=");
        
        // Operand 1
        SQLWhereOperandLiteral operand112 = new SQLWhereOperandLiteral(agentInstance.getAppUserUserType(), Constants.Type.STRING.getTypeName());
        comparison1.setFirstOperand(operand112);
        
        // Operand 2
        SQLWhereOperandPathAttribute operand223 = new SQLWhereOperandPathAttribute(AppUserConstants.ATTR_NAME_APPUSERUSERTYPE, Constants.Type.STRING.getTypeName());
        comparison1.setSecondOperand(operand223);
        disjunction.addOperand(comparison1);

    }

    @Override
    protected void applyOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        applyOCOCAppUser(queryRequest, select);
        applyDSItemSort(queryRequest, select);
    }
    

    private void applyOCOCAppUser(QueryRequest queryRequest, SQLSelect select) {
        if ("OC_AppUser".equalsIgnoreCase(queryRequest.getOrderCriteriaName())) {
            select.getOrderByPart().addItem(Constants.normalizePath(AppUserConstants.CLASS_NAME, AppUserConstants.ATTR_NAME_APPUSERUSERSURNAME, false), true);
            select.getOrderByPart().addItem(Constants.normalizePath(AppUserConstants.CLASS_NAME, AppUserConstants.ATTR_NAME_APPUSERUSERNAME, false), true);
        }
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            AppUserOid oid = new AppUserOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(AppUserConstants.ATTR_FIELD_APPUSERLOGIN, Constants.Type.STRING.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getAppUserLogin(), Constants.Type.STRING.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(AppUserService.class).error(e.getMessage());
        }
    }

}
