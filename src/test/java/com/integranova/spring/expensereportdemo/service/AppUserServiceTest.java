package com.integranova.spring.expensereportdemo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.AppUserConstants;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.persistence.AppUser;
import com.integranova.spring.expensereportdemo.persistence.oid.AppUserOid;
import com.integranova.spring.expensereportdemo.repository.AppUserJpaRepository;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.ds.DSAppUsers;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.CancelAdminRequest;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.CancelOperatorRequest;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.ChangeUserTypeRequest;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.DeleteUserRequest;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.EditUserRequest;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.MakeAdminRequest;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.MakeOperatorRequest;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.NewUserRequest;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.SetPasswordRequest;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.TDELETERequest;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.TEDITUSERRequest;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.TNEWUSERRequest;
import com.integranova.spring.expensereportdemo.viewmodel.FilterRequest;
import com.integranova.spring.expensereportdemo.viewmodel.FilterVariableRequest;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.QueryRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ServiceResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(MockitoJUnitRunner.Silent.class)
public class AppUserServiceTest extends ClassTest {

    @InjectMocks
    private AppUserService instanceAppUserService;
    
    @Mock
    private static AppUserJpaRepository mockRepository;
    
    @Mock
    private static AppUserService mockAppUserService;
    
    @Mock
    private static AdminUserService mockAdminUserService;
    
    @Mock
    private static OperatorUserService mockOperatorUserService;

    private static AppUser mockInstance1;
    
    private static AppUser mockInstance2;

    private static List<AppUser> mockPopulation;

    private static String mockappUserLogin;

    private static Optional<AppUser> mockAppUser; 

    // test4solveQuery
    private static QueryRequest test4solveQueryArg1;
    private static List<Map<String, Object>> test4solveQueryResult;

    // test4get
    private static List<AppUser> test4getResult;

    // test4getQueryRequest
    private static QueryRequest test4getQueryRequestArg1;
    private static List<AppUser> test4getQueryRequestResult;

    // test4getDynamicPopulation
    private static QueryRequest test4getDynamicPopulationArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationResult;

    // test4getDynamicPopulationByFilterFAppUsers_NoFVars
    private static QueryRequest test4getDynamicPopulationByFilterFAppUsers_NoFVarsArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationByFilterFAppUsers_NoFVarsResult;

    // test4getDynamicPopulationByFilterFAppUsers_WithFVars
    private static QueryRequest test4getDynamicPopulationByFilterFAppUsers_WithFVarsArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationByFilterFAppUsers_WithFVarsResult;

    // test4getDynamicPopulationByOrderCriteriaOCAppUser
    private static QueryRequest test4getDynamicPopulationByOrderCriteriaOCAppUserArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationByOrderCriteriaOCAppUserResult;

    // test4getDynamicPopulationFilterByOID
    private static QueryRequest test4getDynamicPopulationFilterByOIDArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationFilterByOIDResult;

    // test4getById
    private static String test4getByIdArg1;
    private static AppUser test4getByIdResult;

    // test4getAppUserDynamic
    private static AppUserOid test4getAppUserDynamicArg1;
    private static String test4getAppUserDynamicArg2;
    private static InstanceResponseViewModel test4getAppUserDynamicResult;

    // test4getSuppInfoWithoutInstance
    private static AppUserOid test4getSuppInfoWithoutInstanceArg1;
    private static String test4getSuppInfoWithoutInstanceArg2;
    private static String test4getSuppInfoWithoutInstanceResult;

    // test4getSuppInfoWithInstance
    private static AppUserOid test4getSuppInfoWithInstanceArg1;
    private static String test4getSuppInfoWithInstanceArg2;

    // test4getDSAppUsers
    private static String test4getDSAppUsersArg1;
    private static String test4getDSAppUsersArg2;
    private static String test4getDSAppUsersArg3;
    private static DSAppUsers test4getDSAppUsersResult;

    // test4piuPIUAppUsers
    private static QueryRequest test4piuPIUAppUsersArg1;
    private static List<DSAppUsers> test4piuPIUAppUsersResult;

    // test4getCount4PIUAppUsers
    private static QueryRequest test4getCount4PIUAppUsersArg1;
    private static int test4getCount4PIUAppUsersResult;

    // test4piuPIUAppUsersWithFilterFAppUsers_NoFVars
    private static QueryRequest test4piuPIUAppUsersWithFilterFAppUsers_NoFVarsArg1;
    private static List<DSAppUsers> test4piuPIUAppUsersWithFilterFAppUsers_NoFVarsResult;

    // test4piuPIUAppUsersWithFilterFAppUsers_WithFVars
    private static QueryRequest test4piuPIUAppUsersWithFilterFAppUsers_WithFVarsArg1;
    private static List<DSAppUsers> test4piuPIUAppUsersWithFilterFAppUsers_WithFVarsResult;

    // test4newUserDefault
    private static NewUserRequest test4newUserDefaultArg1;

    // test4newUserInitializedArguments
    private static NewUserRequest test4newUserInitializedArgumentsArg1;

    // test4newUserTxnDefault
    private static NewUserRequest test4newUserTxnDefaultArg1;
    private static ServiceResponse test4newUserTxnDefaultResult;

    // test4newUserTxnInitializedArguments
    private static NewUserRequest test4newUserTxnInitializedArgumentsArg1;
    private static ServiceResponse test4newUserTxnInitializedArgumentsResult;

    // test4newUserImplementationDefault
    private static NewUserRequest test4newUserImplementationDefaultArg1;
    private static ServiceResponse test4newUserImplementationDefaultResult;

    // test4newUserImplementationInitializedArguments
    private static NewUserRequest test4newUserImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4newUserImplementationInitializedArgumentsResult;

    // test4deleteUserDefault
    private static DeleteUserRequest test4deleteUserDefaultArg1;

    // test4deleteUserInitializedArguments
    private static DeleteUserRequest test4deleteUserInitializedArgumentsArg1;

    // test4deleteUserTxnDefault
    private static DeleteUserRequest test4deleteUserTxnDefaultArg1;
    private static ServiceResponse test4deleteUserTxnDefaultResult;

    // test4deleteUserTxnInitializedArguments
    private static DeleteUserRequest test4deleteUserTxnInitializedArgumentsArg1;
    private static ServiceResponse test4deleteUserTxnInitializedArgumentsResult;

    // test4deleteUserImplementationDefault
    private static DeleteUserRequest test4deleteUserImplementationDefaultArg1;
    private static ServiceResponse test4deleteUserImplementationDefaultResult;

    // test4deleteUserImplementationInitializedArguments
    private static DeleteUserRequest test4deleteUserImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4deleteUserImplementationInitializedArgumentsResult;

    // test4editUserDefault
    private static EditUserRequest test4editUserDefaultArg1;

    // test4editUserInitializedArguments
    private static EditUserRequest test4editUserInitializedArgumentsArg1;

    // test4editUserTxnDefault
    private static EditUserRequest test4editUserTxnDefaultArg1;
    private static ServiceResponse test4editUserTxnDefaultResult;

    // test4editUserTxnInitializedArguments
    private static EditUserRequest test4editUserTxnInitializedArgumentsArg1;
    private static ServiceResponse test4editUserTxnInitializedArgumentsResult;

    // test4editUserImplementationDefault
    private static EditUserRequest test4editUserImplementationDefaultArg1;
    private static ServiceResponse test4editUserImplementationDefaultResult;

    // test4editUserImplementationInitializedArguments
    private static EditUserRequest test4editUserImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4editUserImplementationInitializedArgumentsResult;

    // test4setPasswordDefault
    private static SetPasswordRequest test4setPasswordDefaultArg1;

    // test4setPasswordInitializedArguments
    private static SetPasswordRequest test4setPasswordInitializedArgumentsArg1;

    // test4setPasswordTxnDefault
    private static SetPasswordRequest test4setPasswordTxnDefaultArg1;
    private static ServiceResponse test4setPasswordTxnDefaultResult;

    // test4setPasswordTxnInitializedArguments
    private static SetPasswordRequest test4setPasswordTxnInitializedArgumentsArg1;
    private static ServiceResponse test4setPasswordTxnInitializedArgumentsResult;

    // test4setPasswordImplementationDefault
    private static SetPasswordRequest test4setPasswordImplementationDefaultArg1;
    private static ServiceResponse test4setPasswordImplementationDefaultResult;

    // test4setPasswordImplementationInitializedArguments
    private static SetPasswordRequest test4setPasswordImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4setPasswordImplementationInitializedArgumentsResult;

    // test4makeAdminDefault
    private static MakeAdminRequest test4makeAdminDefaultArg1;

    // test4makeAdminInitializedArguments
    private static MakeAdminRequest test4makeAdminInitializedArgumentsArg1;

    // test4makeAdminTxnDefault
    private static MakeAdminRequest test4makeAdminTxnDefaultArg1;
    private static ServiceResponse test4makeAdminTxnDefaultResult;

    // test4makeAdminTxnInitializedArguments
    private static MakeAdminRequest test4makeAdminTxnInitializedArgumentsArg1;
    private static ServiceResponse test4makeAdminTxnInitializedArgumentsResult;

    // test4makeAdminImplementationDefault
    private static MakeAdminRequest test4makeAdminImplementationDefaultArg1;
    private static ServiceResponse test4makeAdminImplementationDefaultResult;

    // test4makeAdminImplementationInitializedArguments
    private static MakeAdminRequest test4makeAdminImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4makeAdminImplementationInitializedArgumentsResult;

    // test4makeOperatorDefault
    private static MakeOperatorRequest test4makeOperatorDefaultArg1;

    // test4makeOperatorInitializedArguments
    private static MakeOperatorRequest test4makeOperatorInitializedArgumentsArg1;

    // test4makeOperatorTxnDefault
    private static MakeOperatorRequest test4makeOperatorTxnDefaultArg1;
    private static ServiceResponse test4makeOperatorTxnDefaultResult;

    // test4makeOperatorTxnInitializedArguments
    private static MakeOperatorRequest test4makeOperatorTxnInitializedArgumentsArg1;
    private static ServiceResponse test4makeOperatorTxnInitializedArgumentsResult;

    // test4makeOperatorImplementationDefault
    private static MakeOperatorRequest test4makeOperatorImplementationDefaultArg1;
    private static ServiceResponse test4makeOperatorImplementationDefaultResult;

    // test4makeOperatorImplementationInitializedArguments
    private static MakeOperatorRequest test4makeOperatorImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4makeOperatorImplementationInitializedArgumentsResult;

    // test4changeUserTypeDefault
    private static ChangeUserTypeRequest test4changeUserTypeDefaultArg1;

    // test4changeUserTypeInitializedArguments
    private static ChangeUserTypeRequest test4changeUserTypeInitializedArgumentsArg1;

    // test4changeUserTypeTxnDefault
    private static ChangeUserTypeRequest test4changeUserTypeTxnDefaultArg1;
    private static ServiceResponse test4changeUserTypeTxnDefaultResult;

    // test4changeUserTypeTxnInitializedArguments
    private static ChangeUserTypeRequest test4changeUserTypeTxnInitializedArgumentsArg1;
    private static ServiceResponse test4changeUserTypeTxnInitializedArgumentsResult;

    // test4changeUserTypeImplementationDefault
    private static ChangeUserTypeRequest test4changeUserTypeImplementationDefaultArg1;
    private static ServiceResponse test4changeUserTypeImplementationDefaultResult;

    // test4changeUserTypeImplementationInitializedArguments
    private static ChangeUserTypeRequest test4changeUserTypeImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4changeUserTypeImplementationInitializedArgumentsResult;

    // test4cancelAdminDefault
    private static CancelAdminRequest test4cancelAdminDefaultArg1;

    // test4cancelAdminInitializedArguments
    private static CancelAdminRequest test4cancelAdminInitializedArgumentsArg1;

    // test4cancelAdminTxnDefault
    private static CancelAdminRequest test4cancelAdminTxnDefaultArg1;
    private static ServiceResponse test4cancelAdminTxnDefaultResult;

    // test4cancelAdminTxnInitializedArguments
    private static CancelAdminRequest test4cancelAdminTxnInitializedArgumentsArg1;
    private static ServiceResponse test4cancelAdminTxnInitializedArgumentsResult;

    // test4cancelAdminImplementationDefault
    private static CancelAdminRequest test4cancelAdminImplementationDefaultArg1;
    private static ServiceResponse test4cancelAdminImplementationDefaultResult;

    // test4cancelAdminImplementationInitializedArguments
    private static CancelAdminRequest test4cancelAdminImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4cancelAdminImplementationInitializedArgumentsResult;

    // test4cancelOperatorDefault
    private static CancelOperatorRequest test4cancelOperatorDefaultArg1;

    // test4cancelOperatorInitializedArguments
    private static CancelOperatorRequest test4cancelOperatorInitializedArgumentsArg1;

    // test4cancelOperatorTxnDefault
    private static CancelOperatorRequest test4cancelOperatorTxnDefaultArg1;
    private static ServiceResponse test4cancelOperatorTxnDefaultResult;

    // test4cancelOperatorTxnInitializedArguments
    private static CancelOperatorRequest test4cancelOperatorTxnInitializedArgumentsArg1;
    private static ServiceResponse test4cancelOperatorTxnInitializedArgumentsResult;

    // test4cancelOperatorImplementationDefault
    private static CancelOperatorRequest test4cancelOperatorImplementationDefaultArg1;
    private static ServiceResponse test4cancelOperatorImplementationDefaultResult;

    // test4cancelOperatorImplementationInitializedArguments
    private static CancelOperatorRequest test4cancelOperatorImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4cancelOperatorImplementationInitializedArgumentsResult;

    // test4tNEWUSERDefault
    private static TNEWUSERRequest test4tNEWUSERDefaultArg1;

    // test4tNEWUSERInitializedArguments
    private static TNEWUSERRequest test4tNEWUSERInitializedArgumentsArg1;

    // test4tNEWUSERTxnDefault
    private static TNEWUSERRequest test4tNEWUSERTxnDefaultArg1;
    private static ServiceResponse test4tNEWUSERTxnDefaultResult;

    // test4tNEWUSERTxnInitializedArguments
    private static TNEWUSERRequest test4tNEWUSERTxnInitializedArgumentsArg1;
    private static ServiceResponse test4tNEWUSERTxnInitializedArgumentsResult;

    // test4tNEWUSERImplementationDefault
    private static TNEWUSERRequest test4tNEWUSERImplementationDefaultArg1;
    private static ServiceResponse test4tNEWUSERImplementationDefaultResult;

    // test4tNEWUSERImplementationInitializedArguments
    private static TNEWUSERRequest test4tNEWUSERImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4tNEWUSERImplementationInitializedArgumentsResult;

    // test4tEDITUSERDefault
    private static TEDITUSERRequest test4tEDITUSERDefaultArg1;

    // test4tEDITUSERInitializedArguments
    private static TEDITUSERRequest test4tEDITUSERInitializedArgumentsArg1;

    // test4tEDITUSERTxnDefault
    private static TEDITUSERRequest test4tEDITUSERTxnDefaultArg1;
    private static ServiceResponse test4tEDITUSERTxnDefaultResult;

    // test4tEDITUSERTxnInitializedArguments
    private static TEDITUSERRequest test4tEDITUSERTxnInitializedArgumentsArg1;
    private static ServiceResponse test4tEDITUSERTxnInitializedArgumentsResult;

    // test4tEDITUSERImplementationDefault
    private static TEDITUSERRequest test4tEDITUSERImplementationDefaultArg1;
    private static ServiceResponse test4tEDITUSERImplementationDefaultResult;

    // test4tEDITUSERImplementationInitializedArguments
    private static TEDITUSERRequest test4tEDITUSERImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4tEDITUSERImplementationInitializedArgumentsResult;

    // test4tDELETEDefault
    private static TDELETERequest test4tDELETEDefaultArg1;

    // test4tDELETEInitializedArguments
    private static TDELETERequest test4tDELETEInitializedArgumentsArg1;

    // test4tDELETETxnDefault
    private static TDELETERequest test4tDELETETxnDefaultArg1;
    private static ServiceResponse test4tDELETETxnDefaultResult;

    // test4tDELETETxnInitializedArguments
    private static TDELETERequest test4tDELETETxnInitializedArgumentsArg1;
    private static ServiceResponse test4tDELETETxnInitializedArgumentsResult;

    // test4tDELETEImplementationDefault
    private static TDELETERequest test4tDELETEImplementationDefaultArg1;
    private static ServiceResponse test4tDELETEImplementationDefaultResult;

    // test4tDELETEImplementationInitializedArguments
    private static TDELETERequest test4tDELETEImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4tDELETEImplementationInitializedArgumentsResult;

    @BeforeClass
    public static void setUpClass() throws SystemException {
        setUpMockData();
    }

    private static void setUpMockData() throws SystemException {
        mockappUserLogin = "";
        mockInstance1 = new AppUser();
        mockInstance2 = new AppUser();
        mockPopulation = new ArrayList<>(Arrays.asList(mockInstance1, mockInstance2));
        mockAppUser = Optional.of(new AppUser(new AppUserOid(mockappUserLogin)));
        setUpMockData4test4solveQuery();
        setUpMockData4test4get();
        setUpMockData4test4getQueryRequest();
        setUpMockData4test4getDynamicPopulation();
        setUpMockData4test4getDynamicPopulationByFilterFAppUsers_NoFVars();
        setUpMockData4test4getDynamicPopulationByFilterFAppUsers_WithFVars();
        setUpMockData4test4getDynamicPopulationByOrderCriteriaOCAppUser();
        setUpMockData4test4getDynamicPopulationFilterByOID();
        setUpMockData4test4getById();
        setUpMockData4test4getAppUserDynamic();
        setUpMockData4test4getSuppInfoWithoutInstance();
        setUpMockData4test4getSuppInfoWithInstance();
        setUpMockData4test4getDSAppUsers();
        setUpMockData4test4piuPIUAppUsers();
        setUpMockData4test4getCount4PIUAppUsers();
        setUpMockData4test4piuPIUAppUsersWithFilterFAppUsers_NoFVars();
        setUpMockData4test4piuPIUAppUsersWithFilterFAppUsers_WithFVars();
        setUpMockData4test4newUserDefault();
        setUpMockData4test4newUserInitializedArguments();
        setUpMockData4test4newUserTxnDefault();
        setUpMockData4test4newUserTxnInitializedArguments();
        setUpMockData4test4newUserImplementationDefault();
        setUpMockData4test4newUserImplementationInitializedArguments();
        setUpMockData4test4deleteUserDefault();
        setUpMockData4test4deleteUserInitializedArguments();
        setUpMockData4test4deleteUserTxnDefault();
        setUpMockData4test4deleteUserTxnInitializedArguments();
        setUpMockData4test4deleteUserImplementationDefault();
        setUpMockData4test4deleteUserImplementationInitializedArguments();
        setUpMockData4test4editUserDefault();
        setUpMockData4test4editUserInitializedArguments();
        setUpMockData4test4editUserTxnDefault();
        setUpMockData4test4editUserTxnInitializedArguments();
        setUpMockData4test4editUserImplementationDefault();
        setUpMockData4test4editUserImplementationInitializedArguments();
        setUpMockData4test4setPasswordDefault();
        setUpMockData4test4setPasswordInitializedArguments();
        setUpMockData4test4setPasswordTxnDefault();
        setUpMockData4test4setPasswordTxnInitializedArguments();
        setUpMockData4test4setPasswordImplementationDefault();
        setUpMockData4test4setPasswordImplementationInitializedArguments();
        setUpMockData4test4makeAdminDefault();
        setUpMockData4test4makeAdminInitializedArguments();
        setUpMockData4test4makeAdminTxnDefault();
        setUpMockData4test4makeAdminTxnInitializedArguments();
        setUpMockData4test4makeAdminImplementationDefault();
        setUpMockData4test4makeAdminImplementationInitializedArguments();
        setUpMockData4test4makeOperatorDefault();
        setUpMockData4test4makeOperatorInitializedArguments();
        setUpMockData4test4makeOperatorTxnDefault();
        setUpMockData4test4makeOperatorTxnInitializedArguments();
        setUpMockData4test4makeOperatorImplementationDefault();
        setUpMockData4test4makeOperatorImplementationInitializedArguments();
        setUpMockData4test4changeUserTypeDefault();
        setUpMockData4test4changeUserTypeInitializedArguments();
        setUpMockData4test4changeUserTypeTxnDefault();
        setUpMockData4test4changeUserTypeTxnInitializedArguments();
        setUpMockData4test4changeUserTypeImplementationDefault();
        setUpMockData4test4changeUserTypeImplementationInitializedArguments();
        setUpMockData4test4cancelAdminDefault();
        setUpMockData4test4cancelAdminInitializedArguments();
        setUpMockData4test4cancelAdminTxnDefault();
        setUpMockData4test4cancelAdminTxnInitializedArguments();
        setUpMockData4test4cancelAdminImplementationDefault();
        setUpMockData4test4cancelAdminImplementationInitializedArguments();
        setUpMockData4test4cancelOperatorDefault();
        setUpMockData4test4cancelOperatorInitializedArguments();
        setUpMockData4test4cancelOperatorTxnDefault();
        setUpMockData4test4cancelOperatorTxnInitializedArguments();
        setUpMockData4test4cancelOperatorImplementationDefault();
        setUpMockData4test4cancelOperatorImplementationInitializedArguments();
        setUpMockData4test4tNEWUSERDefault();
        setUpMockData4test4tNEWUSERInitializedArguments();
        setUpMockData4test4tNEWUSERTxnDefault();
        setUpMockData4test4tNEWUSERTxnInitializedArguments();
        setUpMockData4test4tNEWUSERImplementationDefault();
        setUpMockData4test4tNEWUSERImplementationInitializedArguments();
        setUpMockData4test4tEDITUSERDefault();
        setUpMockData4test4tEDITUSERInitializedArguments();
        setUpMockData4test4tEDITUSERTxnDefault();
        setUpMockData4test4tEDITUSERTxnInitializedArguments();
        setUpMockData4test4tEDITUSERImplementationDefault();
        setUpMockData4test4tEDITUSERImplementationInitializedArguments();
        setUpMockData4test4tDELETEDefault();
        setUpMockData4test4tDELETEInitializedArguments();
        setUpMockData4test4tDELETETxnDefault();
        setUpMockData4test4tDELETETxnInitializedArguments();
        setUpMockData4test4tDELETEImplementationDefault();
        setUpMockData4test4tDELETEImplementationInitializedArguments();
    }

    private static void setUpMockData4test4solveQuery() {
        test4solveQueryArg1 = new QueryRequest();
        test4solveQueryResult = new ArrayList<>();
    }

    private static void setUpMockData4test4get() {
        test4getResult = new ArrayList<>();
    }

    private static void setUpMockData4test4getQueryRequest() {
        test4getQueryRequestArg1 = new QueryRequest();
        test4getQueryRequestResult = mockPopulation;
    }

    private static void setUpMockData4test4getDynamicPopulation() {
        test4getDynamicPopulationArg1 = new QueryRequest();
        test4getDynamicPopulationArg1.setDisplaySetItems("appUserLogin");
        test4getDynamicPopulationResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationByFilterFAppUsers_NoFVars() {
        test4getDynamicPopulationByFilterFAppUsers_NoFVarsArg1 = new QueryRequest();
        test4getDynamicPopulationByFilterFAppUsers_NoFVarsArg1.setDisplaySetItems("appUserLogin");
        test4getDynamicPopulationByFilterFAppUsers_NoFVarsArg1.addFilterRequest(new FilterRequest(AppUserConstants.FILTER_NAME_FAPPUSERS,new ArrayList<>()));
        test4getDynamicPopulationByFilterFAppUsers_NoFVarsResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationByFilterFAppUsers_WithFVars() {
        test4getDynamicPopulationByFilterFAppUsers_WithFVarsArg1 = new QueryRequest();
        test4getDynamicPopulationByFilterFAppUsers_WithFVarsArg1.setDisplaySetItems("appUserLogin");
        test4getDynamicPopulationByFilterFAppUsers_WithFVarsArg1.addFilterRequest(new FilterRequest(AppUserConstants.FILTER_NAME_FAPPUSERS,new ArrayList<>(Arrays.asList(new FilterVariableRequest(AppUserConstants.VAR_NAME_FAPPUSERS_VNAME, ""), new FilterVariableRequest(AppUserConstants.VAR_NAME_FAPPUSERS_VSURNAME, ""), new FilterVariableRequest(AppUserConstants.VAR_NAME_FAPPUSERS_VTYPE, "")))));
        test4getDynamicPopulationByFilterFAppUsers_WithFVarsResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationByOrderCriteriaOCAppUser() {
        test4getDynamicPopulationByOrderCriteriaOCAppUserArg1 = new QueryRequest();
        test4getDynamicPopulationByOrderCriteriaOCAppUserArg1.setDisplaySetItems("appUserLogin");
        test4getDynamicPopulationByOrderCriteriaOCAppUserArg1.setOrderCriteriaName("OCAppUser");
        test4getDynamicPopulationByOrderCriteriaOCAppUserResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationFilterByOID() {
        test4getDynamicPopulationFilterByOIDArg1 = new QueryRequest();
        test4getDynamicPopulationFilterByOIDArg1.setDisplaySetItems("appUserLogin");
        test4getDynamicPopulationFilterByOIDArg1.addFilterRequest(new FilterRequest(Constants.FILTER_BY_OID,new ArrayList<>(Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_OID_FVAR_OID, new AppUserOid(""))))));
        test4getDynamicPopulationFilterByOIDResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getById() {
        test4getByIdArg1 = "";
        test4getByIdResult = mockAppUser.get();
    }

    private static void setUpMockData4test4getAppUserDynamic() {
        test4getAppUserDynamicArg1 = new AppUserOid();
        test4getAppUserDynamicArg2 = "";
        test4getAppUserDynamicResult = new InstanceResponseViewModel();
    }

    private static void setUpMockData4test4getSuppInfoWithoutInstance() {
        test4getSuppInfoWithoutInstanceArg1 = new AppUserOid();
        test4getSuppInfoWithoutInstanceArg2 = "";
        test4getSuppInfoWithoutInstanceResult = "";
    }

    private static void setUpMockData4test4getSuppInfoWithInstance() {
        test4getSuppInfoWithInstanceArg1 = new AppUserOid("");
        test4getSuppInfoWithInstanceArg2 = "";
    }

    private static void setUpMockData4test4getDSAppUsers() {
        test4getDSAppUsersArg1 = "";
        test4getDSAppUsersArg2 = "";
        test4getDSAppUsersArg3 = "";
        test4getDSAppUsersResult = new DSAppUsers();
    }

    private static void setUpMockData4test4piuPIUAppUsers() {
        test4piuPIUAppUsersArg1 = new QueryRequest();
        test4piuPIUAppUsersResult = mockPopulation.stream().map(i -> new DSAppUsers(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4getCount4PIUAppUsers() {
        test4getCount4PIUAppUsersArg1 = new QueryRequest();
        test4getCount4PIUAppUsersResult = mockPopulation.size();
    }

    private static void setUpMockData4test4piuPIUAppUsersWithFilterFAppUsers_NoFVars() {
        test4piuPIUAppUsersWithFilterFAppUsers_NoFVarsArg1 = new QueryRequest();
        test4piuPIUAppUsersWithFilterFAppUsers_NoFVarsArg1.addFilterRequest(new FilterRequest(AppUserConstants.FILTER_NAME_FAPPUSERS,new ArrayList<>()));
        test4piuPIUAppUsersWithFilterFAppUsers_NoFVarsResult = mockPopulation.stream().map(i -> new DSAppUsers(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4piuPIUAppUsersWithFilterFAppUsers_WithFVars() {
        test4piuPIUAppUsersWithFilterFAppUsers_WithFVarsArg1 = new QueryRequest();
        test4piuPIUAppUsersWithFilterFAppUsers_WithFVarsArg1.addFilterRequest(new FilterRequest(AppUserConstants.FILTER_NAME_FAPPUSERS,new ArrayList<>(Arrays.asList(new FilterVariableRequest(AppUserConstants.VAR_NAME_FAPPUSERS_VNAME, ""), new FilterVariableRequest(AppUserConstants.VAR_NAME_FAPPUSERS_VSURNAME, ""), new FilterVariableRequest(AppUserConstants.VAR_NAME_FAPPUSERS_VTYPE, "")))));
        test4piuPIUAppUsersWithFilterFAppUsers_WithFVarsResult = mockPopulation.stream().map(i -> new DSAppUsers(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4newUserDefault() {
        test4newUserDefaultArg1 = new NewUserRequest();
    }

    private static void setUpMockData4test4newUserInitializedArguments() {
        test4newUserInitializedArgumentsArg1 = new NewUserRequest();
        test4newUserInitializedArgumentsArg1.setAppUsernewUserpatrLogin("");
        test4newUserInitializedArgumentsArg1.setAppUsernewUserpatrUserName("");
        test4newUserInitializedArgumentsArg1.setAppUsernewUserpatrUserSurname("");
        test4newUserInitializedArgumentsArg1.setAppUsernewUserpatrUserType("");
        test4newUserInitializedArgumentsArg1.setAppUsernewUserppassword("");
    }

    private static void setUpMockData4test4newUserTxnDefault() {
        test4newUserTxnDefaultArg1 = new NewUserRequest();
        test4newUserTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4newUserTxnInitializedArguments() {
        test4newUserTxnInitializedArgumentsArg1 = new NewUserRequest();
        test4newUserTxnInitializedArgumentsArg1.setAppUsernewUserpatrLogin("");
        test4newUserTxnInitializedArgumentsArg1.setAppUsernewUserpatrUserName("");
        test4newUserTxnInitializedArgumentsArg1.setAppUsernewUserpatrUserSurname("");
        test4newUserTxnInitializedArgumentsArg1.setAppUsernewUserpatrUserType("");
        test4newUserTxnInitializedArgumentsArg1.setAppUsernewUserppassword("");
        test4newUserTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4newUserImplementationDefault() {
        test4newUserImplementationDefaultArg1 = new NewUserRequest();
        test4newUserImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4newUserImplementationInitializedArguments() {
        test4newUserImplementationInitializedArgumentsArg1 = new NewUserRequest();
        test4newUserImplementationInitializedArgumentsArg1.setAppUsernewUserpatrLogin("");
        test4newUserImplementationInitializedArgumentsArg1.setAppUsernewUserpatrUserName("");
        test4newUserImplementationInitializedArgumentsArg1.setAppUsernewUserpatrUserSurname("");
        test4newUserImplementationInitializedArgumentsArg1.setAppUsernewUserpatrUserType("");
        test4newUserImplementationInitializedArgumentsArg1.setAppUsernewUserppassword("");
        test4newUserImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteUserDefault() {
        test4deleteUserDefaultArg1 = new DeleteUserRequest();
    }

    private static void setUpMockData4test4deleteUserInitializedArguments() {
        test4deleteUserInitializedArgumentsArg1 = new DeleteUserRequest();
        test4deleteUserInitializedArgumentsArg1.setAppUserdeleteUserpthisAppUser(new AppUserOid(""));
        test4deleteUserInitializedArgumentsArg1.setAppUserdeleteUserpthisAppUserInstance(new AppUser(test4deleteUserInitializedArgumentsArg1.getAppUserdeleteUserpthisAppUser()));
    }

    private static void setUpMockData4test4deleteUserTxnDefault() {
        test4deleteUserTxnDefaultArg1 = new DeleteUserRequest();
        test4deleteUserTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteUserTxnInitializedArguments() {
        test4deleteUserTxnInitializedArgumentsArg1 = new DeleteUserRequest();
        test4deleteUserTxnInitializedArgumentsArg1.setAppUserdeleteUserpthisAppUser(new AppUserOid(""));
        test4deleteUserTxnInitializedArgumentsArg1.setAppUserdeleteUserpthisAppUserInstance(new AppUser(test4deleteUserTxnInitializedArgumentsArg1.getAppUserdeleteUserpthisAppUser()));
        test4deleteUserTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteUserImplementationDefault() {
        test4deleteUserImplementationDefaultArg1 = new DeleteUserRequest();
        test4deleteUserImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteUserImplementationInitializedArguments() {
        test4deleteUserImplementationInitializedArgumentsArg1 = new DeleteUserRequest();
        test4deleteUserImplementationInitializedArgumentsArg1.setAppUserdeleteUserpthisAppUser(new AppUserOid(""));
        test4deleteUserImplementationInitializedArgumentsArg1.setAppUserdeleteUserpthisAppUserInstance(new AppUser(test4deleteUserImplementationInitializedArgumentsArg1.getAppUserdeleteUserpthisAppUser()));
        test4deleteUserImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editUserDefault() {
        test4editUserDefaultArg1 = new EditUserRequest();
    }

    private static void setUpMockData4test4editUserInitializedArguments() {
        test4editUserInitializedArgumentsArg1 = new EditUserRequest();
        test4editUserInitializedArgumentsArg1.setAppUsereditUserpthisAppUser(new AppUserOid(""));
        test4editUserInitializedArgumentsArg1.setAppUsereditUserpthisAppUserInstance(new AppUser(test4editUserInitializedArgumentsArg1.getAppUsereditUserpthisAppUser()));
        test4editUserInitializedArgumentsArg1.setAppUsereditUserpUserName("");
        test4editUserInitializedArgumentsArg1.setAppUsereditUserpUserSurname("");
    }

    private static void setUpMockData4test4editUserTxnDefault() {
        test4editUserTxnDefaultArg1 = new EditUserRequest();
        test4editUserTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editUserTxnInitializedArguments() {
        test4editUserTxnInitializedArgumentsArg1 = new EditUserRequest();
        test4editUserTxnInitializedArgumentsArg1.setAppUsereditUserpthisAppUser(new AppUserOid(""));
        test4editUserTxnInitializedArgumentsArg1.setAppUsereditUserpthisAppUserInstance(new AppUser(test4editUserTxnInitializedArgumentsArg1.getAppUsereditUserpthisAppUser()));
        test4editUserTxnInitializedArgumentsArg1.setAppUsereditUserpUserName("");
        test4editUserTxnInitializedArgumentsArg1.setAppUsereditUserpUserSurname("");
        test4editUserTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editUserImplementationDefault() {
        test4editUserImplementationDefaultArg1 = new EditUserRequest();
        test4editUserImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editUserImplementationInitializedArguments() {
        test4editUserImplementationInitializedArgumentsArg1 = new EditUserRequest();
        test4editUserImplementationInitializedArgumentsArg1.setAppUsereditUserpthisAppUser(new AppUserOid(""));
        test4editUserImplementationInitializedArgumentsArg1.setAppUsereditUserpthisAppUserInstance(new AppUser(test4editUserImplementationInitializedArgumentsArg1.getAppUsereditUserpthisAppUser()));
        test4editUserImplementationInitializedArgumentsArg1.setAppUsereditUserpUserName("");
        test4editUserImplementationInitializedArgumentsArg1.setAppUsereditUserpUserSurname("");
        test4editUserImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4setPasswordDefault() {
        test4setPasswordDefaultArg1 = new SetPasswordRequest();
    }

    private static void setUpMockData4test4setPasswordInitializedArguments() {
        test4setPasswordInitializedArgumentsArg1 = new SetPasswordRequest();
        test4setPasswordInitializedArgumentsArg1.setAppUsersetPasswordpthisAppUser(new AppUserOid(""));
        test4setPasswordInitializedArgumentsArg1.setAppUsersetPasswordpthisAppUserInstance(new AppUser(test4setPasswordInitializedArgumentsArg1.getAppUsersetPasswordpthisAppUser()));
        test4setPasswordInitializedArgumentsArg1.setAppUsersetPasswordpNewPassword("");
    }

    private static void setUpMockData4test4setPasswordTxnDefault() {
        test4setPasswordTxnDefaultArg1 = new SetPasswordRequest();
        test4setPasswordTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4setPasswordTxnInitializedArguments() {
        test4setPasswordTxnInitializedArgumentsArg1 = new SetPasswordRequest();
        test4setPasswordTxnInitializedArgumentsArg1.setAppUsersetPasswordpthisAppUser(new AppUserOid(""));
        test4setPasswordTxnInitializedArgumentsArg1.setAppUsersetPasswordpthisAppUserInstance(new AppUser(test4setPasswordTxnInitializedArgumentsArg1.getAppUsersetPasswordpthisAppUser()));
        test4setPasswordTxnInitializedArgumentsArg1.setAppUsersetPasswordpNewPassword("");
        test4setPasswordTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4setPasswordImplementationDefault() {
        test4setPasswordImplementationDefaultArg1 = new SetPasswordRequest();
        test4setPasswordImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4setPasswordImplementationInitializedArguments() {
        test4setPasswordImplementationInitializedArgumentsArg1 = new SetPasswordRequest();
        test4setPasswordImplementationInitializedArgumentsArg1.setAppUsersetPasswordpthisAppUser(new AppUserOid(""));
        test4setPasswordImplementationInitializedArgumentsArg1.setAppUsersetPasswordpthisAppUserInstance(new AppUser(test4setPasswordImplementationInitializedArgumentsArg1.getAppUsersetPasswordpthisAppUser()));
        test4setPasswordImplementationInitializedArgumentsArg1.setAppUsersetPasswordpNewPassword("");
        test4setPasswordImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4makeAdminDefault() {
        test4makeAdminDefaultArg1 = new MakeAdminRequest();
    }

    private static void setUpMockData4test4makeAdminInitializedArguments() {
        test4makeAdminInitializedArgumentsArg1 = new MakeAdminRequest();
        test4makeAdminInitializedArgumentsArg1.setAppUsermakeAdminpthisAppUser(new AppUserOid(""));
        test4makeAdminInitializedArgumentsArg1.setAppUsermakeAdminpthisAppUserInstance(new AppUser(test4makeAdminInitializedArgumentsArg1.getAppUsermakeAdminpthisAppUser()));
    }

    private static void setUpMockData4test4makeAdminTxnDefault() {
        test4makeAdminTxnDefaultArg1 = new MakeAdminRequest();
        test4makeAdminTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4makeAdminTxnInitializedArguments() {
        test4makeAdminTxnInitializedArgumentsArg1 = new MakeAdminRequest();
        test4makeAdminTxnInitializedArgumentsArg1.setAppUsermakeAdminpthisAppUser(new AppUserOid(""));
        test4makeAdminTxnInitializedArgumentsArg1.setAppUsermakeAdminpthisAppUserInstance(new AppUser(test4makeAdminTxnInitializedArgumentsArg1.getAppUsermakeAdminpthisAppUser()));
        test4makeAdminTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4makeAdminImplementationDefault() {
        test4makeAdminImplementationDefaultArg1 = new MakeAdminRequest();
        test4makeAdminImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4makeAdminImplementationInitializedArguments() {
        test4makeAdminImplementationInitializedArgumentsArg1 = new MakeAdminRequest();
        test4makeAdminImplementationInitializedArgumentsArg1.setAppUsermakeAdminpthisAppUser(new AppUserOid(""));
        test4makeAdminImplementationInitializedArgumentsArg1.setAppUsermakeAdminpthisAppUserInstance(new AppUser(test4makeAdminImplementationInitializedArgumentsArg1.getAppUsermakeAdminpthisAppUser()));
        test4makeAdminImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4makeOperatorDefault() {
        test4makeOperatorDefaultArg1 = new MakeOperatorRequest();
    }

    private static void setUpMockData4test4makeOperatorInitializedArguments() {
        test4makeOperatorInitializedArgumentsArg1 = new MakeOperatorRequest();
        test4makeOperatorInitializedArgumentsArg1.setAppUsermakeOperatorpthisAppUser(new AppUserOid(""));
        test4makeOperatorInitializedArgumentsArg1.setAppUsermakeOperatorpthisAppUserInstance(new AppUser(test4makeOperatorInitializedArgumentsArg1.getAppUsermakeOperatorpthisAppUser()));
    }

    private static void setUpMockData4test4makeOperatorTxnDefault() {
        test4makeOperatorTxnDefaultArg1 = new MakeOperatorRequest();
        test4makeOperatorTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4makeOperatorTxnInitializedArguments() {
        test4makeOperatorTxnInitializedArgumentsArg1 = new MakeOperatorRequest();
        test4makeOperatorTxnInitializedArgumentsArg1.setAppUsermakeOperatorpthisAppUser(new AppUserOid(""));
        test4makeOperatorTxnInitializedArgumentsArg1.setAppUsermakeOperatorpthisAppUserInstance(new AppUser(test4makeOperatorTxnInitializedArgumentsArg1.getAppUsermakeOperatorpthisAppUser()));
        test4makeOperatorTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4makeOperatorImplementationDefault() {
        test4makeOperatorImplementationDefaultArg1 = new MakeOperatorRequest();
        test4makeOperatorImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4makeOperatorImplementationInitializedArguments() {
        test4makeOperatorImplementationInitializedArgumentsArg1 = new MakeOperatorRequest();
        test4makeOperatorImplementationInitializedArgumentsArg1.setAppUsermakeOperatorpthisAppUser(new AppUserOid(""));
        test4makeOperatorImplementationInitializedArgumentsArg1.setAppUsermakeOperatorpthisAppUserInstance(new AppUser(test4makeOperatorImplementationInitializedArgumentsArg1.getAppUsermakeOperatorpthisAppUser()));
        test4makeOperatorImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4changeUserTypeDefault() {
        test4changeUserTypeDefaultArg1 = new ChangeUserTypeRequest();
    }

    private static void setUpMockData4test4changeUserTypeInitializedArguments() {
        test4changeUserTypeInitializedArgumentsArg1 = new ChangeUserTypeRequest();
        test4changeUserTypeInitializedArgumentsArg1.setAppUserchangeUserTypepthisAppUser(new AppUserOid(""));
        test4changeUserTypeInitializedArgumentsArg1.setAppUserchangeUserTypepthisAppUserInstance(new AppUser(test4changeUserTypeInitializedArgumentsArg1.getAppUserchangeUserTypepthisAppUser()));
        test4changeUserTypeInitializedArgumentsArg1.setAppUserchangeUserTypepNewType("");
    }

    private static void setUpMockData4test4changeUserTypeTxnDefault() {
        test4changeUserTypeTxnDefaultArg1 = new ChangeUserTypeRequest();
        test4changeUserTypeTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4changeUserTypeTxnInitializedArguments() {
        test4changeUserTypeTxnInitializedArgumentsArg1 = new ChangeUserTypeRequest();
        test4changeUserTypeTxnInitializedArgumentsArg1.setAppUserchangeUserTypepthisAppUser(new AppUserOid(""));
        test4changeUserTypeTxnInitializedArgumentsArg1.setAppUserchangeUserTypepthisAppUserInstance(new AppUser(test4changeUserTypeTxnInitializedArgumentsArg1.getAppUserchangeUserTypepthisAppUser()));
        test4changeUserTypeTxnInitializedArgumentsArg1.setAppUserchangeUserTypepNewType("");
        test4changeUserTypeTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4changeUserTypeImplementationDefault() {
        test4changeUserTypeImplementationDefaultArg1 = new ChangeUserTypeRequest();
        test4changeUserTypeImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4changeUserTypeImplementationInitializedArguments() {
        test4changeUserTypeImplementationInitializedArgumentsArg1 = new ChangeUserTypeRequest();
        test4changeUserTypeImplementationInitializedArgumentsArg1.setAppUserchangeUserTypepthisAppUser(new AppUserOid(""));
        test4changeUserTypeImplementationInitializedArgumentsArg1.setAppUserchangeUserTypepthisAppUserInstance(new AppUser(test4changeUserTypeImplementationInitializedArgumentsArg1.getAppUserchangeUserTypepthisAppUser()));
        test4changeUserTypeImplementationInitializedArgumentsArg1.setAppUserchangeUserTypepNewType("");
        test4changeUserTypeImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4cancelAdminDefault() {
        test4cancelAdminDefaultArg1 = new CancelAdminRequest();
    }

    private static void setUpMockData4test4cancelAdminInitializedArguments() {
        test4cancelAdminInitializedArgumentsArg1 = new CancelAdminRequest();
        test4cancelAdminInitializedArgumentsArg1.setAppUsercancelAdminpthisAppUser(new AppUserOid(""));
        test4cancelAdminInitializedArgumentsArg1.setAppUsercancelAdminpthisAppUserInstance(new AppUser(test4cancelAdminInitializedArgumentsArg1.getAppUsercancelAdminpthisAppUser()));
    }

    private static void setUpMockData4test4cancelAdminTxnDefault() {
        test4cancelAdminTxnDefaultArg1 = new CancelAdminRequest();
        test4cancelAdminTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4cancelAdminTxnInitializedArguments() {
        test4cancelAdminTxnInitializedArgumentsArg1 = new CancelAdminRequest();
        test4cancelAdminTxnInitializedArgumentsArg1.setAppUsercancelAdminpthisAppUser(new AppUserOid(""));
        test4cancelAdminTxnInitializedArgumentsArg1.setAppUsercancelAdminpthisAppUserInstance(new AppUser(test4cancelAdminTxnInitializedArgumentsArg1.getAppUsercancelAdminpthisAppUser()));
        test4cancelAdminTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4cancelAdminImplementationDefault() {
        test4cancelAdminImplementationDefaultArg1 = new CancelAdminRequest();
        test4cancelAdminImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4cancelAdminImplementationInitializedArguments() {
        test4cancelAdminImplementationInitializedArgumentsArg1 = new CancelAdminRequest();
        test4cancelAdminImplementationInitializedArgumentsArg1.setAppUsercancelAdminpthisAppUser(new AppUserOid(""));
        test4cancelAdminImplementationInitializedArgumentsArg1.setAppUsercancelAdminpthisAppUserInstance(new AppUser(test4cancelAdminImplementationInitializedArgumentsArg1.getAppUsercancelAdminpthisAppUser()));
        test4cancelAdminImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4cancelOperatorDefault() {
        test4cancelOperatorDefaultArg1 = new CancelOperatorRequest();
    }

    private static void setUpMockData4test4cancelOperatorInitializedArguments() {
        test4cancelOperatorInitializedArgumentsArg1 = new CancelOperatorRequest();
        test4cancelOperatorInitializedArgumentsArg1.setAppUsercancelOperatorpthisAppUser(new AppUserOid(""));
        test4cancelOperatorInitializedArgumentsArg1.setAppUsercancelOperatorpthisAppUserInstance(new AppUser(test4cancelOperatorInitializedArgumentsArg1.getAppUsercancelOperatorpthisAppUser()));
    }

    private static void setUpMockData4test4cancelOperatorTxnDefault() {
        test4cancelOperatorTxnDefaultArg1 = new CancelOperatorRequest();
        test4cancelOperatorTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4cancelOperatorTxnInitializedArguments() {
        test4cancelOperatorTxnInitializedArgumentsArg1 = new CancelOperatorRequest();
        test4cancelOperatorTxnInitializedArgumentsArg1.setAppUsercancelOperatorpthisAppUser(new AppUserOid(""));
        test4cancelOperatorTxnInitializedArgumentsArg1.setAppUsercancelOperatorpthisAppUserInstance(new AppUser(test4cancelOperatorTxnInitializedArgumentsArg1.getAppUsercancelOperatorpthisAppUser()));
        test4cancelOperatorTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4cancelOperatorImplementationDefault() {
        test4cancelOperatorImplementationDefaultArg1 = new CancelOperatorRequest();
        test4cancelOperatorImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4cancelOperatorImplementationInitializedArguments() {
        test4cancelOperatorImplementationInitializedArgumentsArg1 = new CancelOperatorRequest();
        test4cancelOperatorImplementationInitializedArgumentsArg1.setAppUsercancelOperatorpthisAppUser(new AppUserOid(""));
        test4cancelOperatorImplementationInitializedArgumentsArg1.setAppUsercancelOperatorpthisAppUserInstance(new AppUser(test4cancelOperatorImplementationInitializedArgumentsArg1.getAppUsercancelOperatorpthisAppUser()));
        test4cancelOperatorImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4tNEWUSERDefault() {
        test4tNEWUSERDefaultArg1 = new TNEWUSERRequest();
    }

    private static void setUpMockData4test4tNEWUSERInitializedArguments() {
        test4tNEWUSERInitializedArgumentsArg1 = new TNEWUSERRequest();
        test4tNEWUSERInitializedArgumentsArg1.setAppUserTNEWUSERpLogin("");
        test4tNEWUSERInitializedArgumentsArg1.setAppUserTNEWUSERpName("");
        test4tNEWUSERInitializedArgumentsArg1.setAppUserTNEWUSERpSurname("");
        test4tNEWUSERInitializedArgumentsArg1.setAppUserTNEWUSERpType("");
        test4tNEWUSERInitializedArgumentsArg1.setAppUserTNEWUSERpPassword("");
    }

    private static void setUpMockData4test4tNEWUSERTxnDefault() {
        test4tNEWUSERTxnDefaultArg1 = new TNEWUSERRequest();
        test4tNEWUSERTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4tNEWUSERTxnInitializedArguments() {
        test4tNEWUSERTxnInitializedArgumentsArg1 = new TNEWUSERRequest();
        test4tNEWUSERTxnInitializedArgumentsArg1.setAppUserTNEWUSERpLogin("");
        test4tNEWUSERTxnInitializedArgumentsArg1.setAppUserTNEWUSERpName("");
        test4tNEWUSERTxnInitializedArgumentsArg1.setAppUserTNEWUSERpSurname("");
        test4tNEWUSERTxnInitializedArgumentsArg1.setAppUserTNEWUSERpType("");
        test4tNEWUSERTxnInitializedArgumentsArg1.setAppUserTNEWUSERpPassword("");
        test4tNEWUSERTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4tNEWUSERImplementationDefault() {
        test4tNEWUSERImplementationDefaultArg1 = new TNEWUSERRequest();
        test4tNEWUSERImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4tNEWUSERImplementationInitializedArguments() {
        test4tNEWUSERImplementationInitializedArgumentsArg1 = new TNEWUSERRequest();
        test4tNEWUSERImplementationInitializedArgumentsArg1.setAppUserTNEWUSERpLogin("");
        test4tNEWUSERImplementationInitializedArgumentsArg1.setAppUserTNEWUSERpName("");
        test4tNEWUSERImplementationInitializedArgumentsArg1.setAppUserTNEWUSERpSurname("");
        test4tNEWUSERImplementationInitializedArgumentsArg1.setAppUserTNEWUSERpType("");
        test4tNEWUSERImplementationInitializedArgumentsArg1.setAppUserTNEWUSERpPassword("");
        test4tNEWUSERImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4tEDITUSERDefault() {
        test4tEDITUSERDefaultArg1 = new TEDITUSERRequest();
    }

    private static void setUpMockData4test4tEDITUSERInitializedArguments() {
        test4tEDITUSERInitializedArgumentsArg1 = new TEDITUSERRequest();
        test4tEDITUSERInitializedArgumentsArg1.setAppUserTEDITUSERpthisAppUser(new AppUserOid(""));
        test4tEDITUSERInitializedArgumentsArg1.setAppUserTEDITUSERpthisAppUserInstance(new AppUser(test4tEDITUSERInitializedArgumentsArg1.getAppUserTEDITUSERpthisAppUser()));
        test4tEDITUSERInitializedArgumentsArg1.setAppUserTEDITUSERpName("");
        test4tEDITUSERInitializedArgumentsArg1.setAppUserTEDITUSERpSurname("");
        test4tEDITUSERInitializedArgumentsArg1.setAppUserTEDITUSERpType("");
    }

    private static void setUpMockData4test4tEDITUSERTxnDefault() {
        test4tEDITUSERTxnDefaultArg1 = new TEDITUSERRequest();
        test4tEDITUSERTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4tEDITUSERTxnInitializedArguments() {
        test4tEDITUSERTxnInitializedArgumentsArg1 = new TEDITUSERRequest();
        test4tEDITUSERTxnInitializedArgumentsArg1.setAppUserTEDITUSERpthisAppUser(new AppUserOid(""));
        test4tEDITUSERTxnInitializedArgumentsArg1.setAppUserTEDITUSERpthisAppUserInstance(new AppUser(test4tEDITUSERTxnInitializedArgumentsArg1.getAppUserTEDITUSERpthisAppUser()));
        test4tEDITUSERTxnInitializedArgumentsArg1.setAppUserTEDITUSERpName("");
        test4tEDITUSERTxnInitializedArgumentsArg1.setAppUserTEDITUSERpSurname("");
        test4tEDITUSERTxnInitializedArgumentsArg1.setAppUserTEDITUSERpType("");
        test4tEDITUSERTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4tEDITUSERImplementationDefault() {
        test4tEDITUSERImplementationDefaultArg1 = new TEDITUSERRequest();
        test4tEDITUSERImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4tEDITUSERImplementationInitializedArguments() {
        test4tEDITUSERImplementationInitializedArgumentsArg1 = new TEDITUSERRequest();
        test4tEDITUSERImplementationInitializedArgumentsArg1.setAppUserTEDITUSERpthisAppUser(new AppUserOid(""));
        test4tEDITUSERImplementationInitializedArgumentsArg1.setAppUserTEDITUSERpthisAppUserInstance(new AppUser(test4tEDITUSERImplementationInitializedArgumentsArg1.getAppUserTEDITUSERpthisAppUser()));
        test4tEDITUSERImplementationInitializedArgumentsArg1.setAppUserTEDITUSERpName("");
        test4tEDITUSERImplementationInitializedArgumentsArg1.setAppUserTEDITUSERpSurname("");
        test4tEDITUSERImplementationInitializedArgumentsArg1.setAppUserTEDITUSERpType("");
        test4tEDITUSERImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4tDELETEDefault() {
        test4tDELETEDefaultArg1 = new TDELETERequest();
    }

    private static void setUpMockData4test4tDELETEInitializedArguments() {
        test4tDELETEInitializedArgumentsArg1 = new TDELETERequest();
        test4tDELETEInitializedArgumentsArg1.setAppUserTDELETEpthisAppUser(new AppUserOid(""));
        test4tDELETEInitializedArgumentsArg1.setAppUserTDELETEpthisAppUserInstance(new AppUser(test4tDELETEInitializedArgumentsArg1.getAppUserTDELETEpthisAppUser()));
    }

    private static void setUpMockData4test4tDELETETxnDefault() {
        test4tDELETETxnDefaultArg1 = new TDELETERequest();
        test4tDELETETxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4tDELETETxnInitializedArguments() {
        test4tDELETETxnInitializedArgumentsArg1 = new TDELETERequest();
        test4tDELETETxnInitializedArgumentsArg1.setAppUserTDELETEpthisAppUser(new AppUserOid(""));
        test4tDELETETxnInitializedArgumentsArg1.setAppUserTDELETEpthisAppUserInstance(new AppUser(test4tDELETETxnInitializedArgumentsArg1.getAppUserTDELETEpthisAppUser()));
        test4tDELETETxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4tDELETEImplementationDefault() {
        test4tDELETEImplementationDefaultArg1 = new TDELETERequest();
        test4tDELETEImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4tDELETEImplementationInitializedArguments() {
        test4tDELETEImplementationInitializedArgumentsArg1 = new TDELETERequest();
        test4tDELETEImplementationInitializedArgumentsArg1.setAppUserTDELETEpthisAppUser(new AppUserOid(""));
        test4tDELETEImplementationInitializedArgumentsArg1.setAppUserTDELETEpthisAppUserInstance(new AppUser(test4tDELETEImplementationInitializedArgumentsArg1.getAppUserTDELETEpthisAppUser()));
        test4tDELETEImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(instanceAppUserService, "appUserSrv", instanceAppUserService);

        when(mockAppUserService.getByOIDWithHV(test4deleteUserInitializedArgumentsArg1.getAppUserdeleteUserpthisAppUser())).thenReturn(test4deleteUserInitializedArgumentsArg1.getAppUserdeleteUserpthisAppUserInstance());

        when(mockAppUserService.getByOIDWithHV(test4deleteUserTxnInitializedArgumentsArg1.getAppUserdeleteUserpthisAppUser())).thenReturn(test4deleteUserTxnInitializedArgumentsArg1.getAppUserdeleteUserpthisAppUserInstance());

        when(mockAppUserService.getByOIDWithHV(test4editUserInitializedArgumentsArg1.getAppUsereditUserpthisAppUser())).thenReturn(test4editUserInitializedArgumentsArg1.getAppUsereditUserpthisAppUserInstance());

        when(mockAppUserService.getByOIDWithHV(test4editUserTxnInitializedArgumentsArg1.getAppUsereditUserpthisAppUser())).thenReturn(test4editUserTxnInitializedArgumentsArg1.getAppUsereditUserpthisAppUserInstance());

        when(mockAppUserService.getByOIDWithHV(test4setPasswordInitializedArgumentsArg1.getAppUsersetPasswordpthisAppUser())).thenReturn(test4setPasswordInitializedArgumentsArg1.getAppUsersetPasswordpthisAppUserInstance());

        when(mockAppUserService.getByOIDWithHV(test4setPasswordTxnInitializedArgumentsArg1.getAppUsersetPasswordpthisAppUser())).thenReturn(test4setPasswordTxnInitializedArgumentsArg1.getAppUsersetPasswordpthisAppUserInstance());

        when(mockAppUserService.getByOIDWithHV(test4makeAdminInitializedArgumentsArg1.getAppUsermakeAdminpthisAppUser())).thenReturn(test4makeAdminInitializedArgumentsArg1.getAppUsermakeAdminpthisAppUserInstance());

        when(mockAppUserService.getByOIDWithHV(test4makeAdminTxnInitializedArgumentsArg1.getAppUsermakeAdminpthisAppUser())).thenReturn(test4makeAdminTxnInitializedArgumentsArg1.getAppUsermakeAdminpthisAppUserInstance());

        when(mockAppUserService.getByOIDWithHV(test4makeOperatorInitializedArgumentsArg1.getAppUsermakeOperatorpthisAppUser())).thenReturn(test4makeOperatorInitializedArgumentsArg1.getAppUsermakeOperatorpthisAppUserInstance());

        when(mockAppUserService.getByOIDWithHV(test4makeOperatorTxnInitializedArgumentsArg1.getAppUsermakeOperatorpthisAppUser())).thenReturn(test4makeOperatorTxnInitializedArgumentsArg1.getAppUsermakeOperatorpthisAppUserInstance());

        when(mockAppUserService.getByOIDWithHV(test4changeUserTypeInitializedArgumentsArg1.getAppUserchangeUserTypepthisAppUser())).thenReturn(test4changeUserTypeInitializedArgumentsArg1.getAppUserchangeUserTypepthisAppUserInstance());

        when(mockAppUserService.getByOIDWithHV(test4changeUserTypeTxnInitializedArgumentsArg1.getAppUserchangeUserTypepthisAppUser())).thenReturn(test4changeUserTypeTxnInitializedArgumentsArg1.getAppUserchangeUserTypepthisAppUserInstance());

        when(mockAppUserService.getByOIDWithHV(test4cancelAdminInitializedArgumentsArg1.getAppUsercancelAdminpthisAppUser())).thenReturn(test4cancelAdminInitializedArgumentsArg1.getAppUsercancelAdminpthisAppUserInstance());

        when(mockAppUserService.getByOIDWithHV(test4cancelAdminTxnInitializedArgumentsArg1.getAppUsercancelAdminpthisAppUser())).thenReturn(test4cancelAdminTxnInitializedArgumentsArg1.getAppUsercancelAdminpthisAppUserInstance());

        when(mockAppUserService.getByOIDWithHV(test4cancelOperatorInitializedArgumentsArg1.getAppUsercancelOperatorpthisAppUser())).thenReturn(test4cancelOperatorInitializedArgumentsArg1.getAppUsercancelOperatorpthisAppUserInstance());

        when(mockAppUserService.getByOIDWithHV(test4cancelOperatorTxnInitializedArgumentsArg1.getAppUsercancelOperatorpthisAppUser())).thenReturn(test4cancelOperatorTxnInitializedArgumentsArg1.getAppUsercancelOperatorpthisAppUserInstance());

        when(mockAppUserService.getByOIDWithHV(test4tEDITUSERInitializedArgumentsArg1.getAppUserTEDITUSERpthisAppUser())).thenReturn(test4tEDITUSERInitializedArgumentsArg1.getAppUserTEDITUSERpthisAppUserInstance());

        when(mockAppUserService.getByOIDWithHV(test4tEDITUSERTxnInitializedArgumentsArg1.getAppUserTEDITUSERpthisAppUser())).thenReturn(test4tEDITUSERTxnInitializedArgumentsArg1.getAppUserTEDITUSERpthisAppUserInstance());

        when(mockAppUserService.getByOIDWithHV(test4tDELETEInitializedArgumentsArg1.getAppUserTDELETEpthisAppUser())).thenReturn(test4tDELETEInitializedArgumentsArg1.getAppUserTDELETEpthisAppUserInstance());

        when(mockAppUserService.getByOIDWithHV(test4tDELETETxnInitializedArgumentsArg1.getAppUserTDELETEpthisAppUser())).thenReturn(test4tDELETETxnInitializedArgumentsArg1.getAppUserTDELETEpthisAppUserInstance());

        when(mockRepository.findById(mockappUserLogin)).thenAnswer(new Answer<Optional<AppUser>>(){
        	public Optional<AppUser> answer(InvocationOnMock invocation) {
        		if (invocation.getArgument(0).equals(mockappUserLogin)) {
        			return mockAppUser;
                }
        		return Optional.empty();
        	}
        });
        when(mockRepository.save(any(AppUser.class))).thenReturn(mockInstance1);
        when(mockRepository.solveQuery(any(SQLSelect.class))).thenReturn(mockPopulation);
        when(mockRepository.solveQuery(any(SQLSelect.class), anyInt(), anyInt())).thenReturn(mockPopulation);
    }
    
    @After
    public void tearDown() {
        instanceAppUserService = null;
    }

    @Test
    public void test4solveQuery() {
        assertEquals(test4solveQueryResult, instanceAppUserService.solveQuery(test4solveQueryArg1));
    }

    @Test
    public void test4get() {
        assertEquals(test4getResult, instanceAppUserService.get());
    }

    @Test
    public void test4getQueryRequest() {
        assertEquals(test4getQueryRequestResult, instanceAppUserService.get(test4getQueryRequestArg1));
    }

    @Test
    public void test4getDynamicPopulation() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationResult), getResult(TOTALITEMS, instanceAppUserService.getDynamic(test4getDynamicPopulationArg1)));
    }

    @Test
    public void test4getDynamicPopulationByFilterFAppUsers_NoFVars() {
        assertEquals(getResult(RESULTCODE, test4getDynamicPopulationByFilterFAppUsers_NoFVarsResult), getResult(RESULTCODE, instanceAppUserService.getDynamic(test4getDynamicPopulationByFilterFAppUsers_NoFVarsArg1)));
    }

    @Test
    public void test4getDynamicPopulationByFilterFAppUsers_WithFVars() {
        assertEquals(getResult(RESULTCODE, test4getDynamicPopulationByFilterFAppUsers_WithFVarsResult), getResult(RESULTCODE, instanceAppUserService.getDynamic(test4getDynamicPopulationByFilterFAppUsers_WithFVarsArg1)));
    }

    @Test
    public void test4getDynamicPopulationByOrderCriteriaOCAppUser() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationByOrderCriteriaOCAppUserResult), getResult(TOTALITEMS, instanceAppUserService.getDynamic(test4getDynamicPopulationByOrderCriteriaOCAppUserArg1)));
    }

    @Test
    public void test4getDynamicPopulationFilterByOID() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationFilterByOIDResult), getResult(TOTALITEMS, instanceAppUserService.getDynamic(test4getDynamicPopulationFilterByOIDArg1)));
    }

    @Test
    public void test4getById() {
        assertEquals(test4getByIdResult, instanceAppUserService.getById(test4getByIdArg1));
    }

    @Test
    public void test4getAppUserDynamic() {
        assertEquals(test4getAppUserDynamicResult.getResultCode(), instanceAppUserService.getAppUserDynamic(test4getAppUserDynamicArg1, test4getAppUserDynamicArg2).getResultCode());
    }

    @Test
    public void test4getSuppInfoWithoutInstance() {
        assertEquals(test4getSuppInfoWithoutInstanceResult, instanceAppUserService.getSuppInfo(test4getSuppInfoWithoutInstanceArg1, test4getSuppInfoWithoutInstanceArg2));
    }

    @Test
    public void test4getSuppInfoWithInstance() {
        instanceAppUserService.getSuppInfo(test4getSuppInfoWithInstanceArg1, test4getSuppInfoWithInstanceArg2);
        assertNotNull(instanceAppUserService);
    }

    @Test
    public void test4getDSAppUsers() {
        assertEquals(test4getDSAppUsersResult.getClass(), instanceAppUserService.getDSAppUsers(test4getDSAppUsersArg1, test4getDSAppUsersArg2, test4getDSAppUsersArg3).getClass());
    }

    @Test
    public void test4piuPIUAppUsers() {
        instanceAppUserService.piuPIUAppUsers(test4piuPIUAppUsersArg1);
        assertNotNull(instanceAppUserService);
    }

    @Test
    public void test4getCount4PIUAppUsers() {
        instanceAppUserService.getCount4PIUAppUsers(test4getCount4PIUAppUsersArg1);
        assertNotNull(instanceAppUserService);
    }

    @Test
    public void test4piuPIUAppUsersWithFilterFAppUsers_NoFVars() {
        instanceAppUserService.piuPIUAppUsers(test4piuPIUAppUsersWithFilterFAppUsers_NoFVarsArg1);
        assertNotNull(instanceAppUserService);
    }

    @Test
    public void test4piuPIUAppUsersWithFilterFAppUsers_WithFVars() {
        instanceAppUserService.piuPIUAppUsers(test4piuPIUAppUsersWithFilterFAppUsers_WithFVarsArg1);
        assertNotNull(instanceAppUserService);
    }

    @Test
    public void test4newUserDefault() {
        instanceAppUserService.newUser(test4newUserDefaultArg1);
        assertNotNull(instanceAppUserService);
    }

    @Test
    public void test4newUserInitializedArguments() {
        instanceAppUserService.newUser(test4newUserInitializedArgumentsArg1);
        assertNotNull(instanceAppUserService);
    }

    @Test
    public void test4newUserTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.newUserTxn(test4newUserTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4newUserTxnDefaultResult;
        }
        assertEquals(test4newUserTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4newUserTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.newUserTxn(test4newUserTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4newUserTxnInitializedArgumentsResult;
        }
        assertEquals(test4newUserTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4newUserImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.newUserImplementation(test4newUserImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4newUserImplementationDefaultResult;
        }
        assertEquals(test4newUserImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4newUserImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.newUserImplementation(test4newUserImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4newUserImplementationInitializedArgumentsResult;
        }
        assertEquals(test4newUserImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteUserDefault() {
        instanceAppUserService.deleteUser(test4deleteUserDefaultArg1);
        assertNotNull(instanceAppUserService);
    }

    @Test
    public void test4deleteUserInitializedArguments() {
        instanceAppUserService.deleteUser(test4deleteUserInitializedArgumentsArg1);
        assertNotNull(instanceAppUserService);
    }

    @Test
    public void test4deleteUserTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.deleteUserTxn(test4deleteUserTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4deleteUserTxnDefaultResult;
        }
        assertEquals(test4deleteUserTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteUserTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.deleteUserTxn(test4deleteUserTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4deleteUserTxnInitializedArgumentsResult;
        }
        assertEquals(test4deleteUserTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteUserImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.deleteUserImplementation(test4deleteUserImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4deleteUserImplementationDefaultResult;
        }
        assertEquals(test4deleteUserImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteUserImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.deleteUserImplementation(test4deleteUserImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4deleteUserImplementationInitializedArgumentsResult;
        }
        assertEquals(test4deleteUserImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editUserDefault() {
        instanceAppUserService.editUser(test4editUserDefaultArg1);
        assertNotNull(instanceAppUserService);
    }

    @Test
    public void test4editUserInitializedArguments() {
        instanceAppUserService.editUser(test4editUserInitializedArgumentsArg1);
        assertNotNull(instanceAppUserService);
    }

    @Test
    public void test4editUserTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.editUserTxn(test4editUserTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4editUserTxnDefaultResult;
        }
        assertEquals(test4editUserTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editUserTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.editUserTxn(test4editUserTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editUserTxnInitializedArgumentsResult;
        }
        assertEquals(test4editUserTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editUserImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.editUserImplementation(test4editUserImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4editUserImplementationDefaultResult;
        }
        assertEquals(test4editUserImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editUserImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.editUserImplementation(test4editUserImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editUserImplementationInitializedArgumentsResult;
        }
        assertEquals(test4editUserImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4setPasswordDefault() {
        instanceAppUserService.setPassword(test4setPasswordDefaultArg1);
        assertNotNull(instanceAppUserService);
    }

    @Test
    public void test4setPasswordInitializedArguments() {
        instanceAppUserService.setPassword(test4setPasswordInitializedArgumentsArg1);
        assertNotNull(instanceAppUserService);
    }

    @Test
    public void test4setPasswordTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.setPasswordTxn(test4setPasswordTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4setPasswordTxnDefaultResult;
        }
        assertEquals(test4setPasswordTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4setPasswordTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.setPasswordTxn(test4setPasswordTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4setPasswordTxnInitializedArgumentsResult;
        }
        assertEquals(test4setPasswordTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4setPasswordImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.setPasswordImplementation(test4setPasswordImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4setPasswordImplementationDefaultResult;
        }
        assertEquals(test4setPasswordImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4setPasswordImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.setPasswordImplementation(test4setPasswordImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4setPasswordImplementationInitializedArgumentsResult;
        }
        assertEquals(test4setPasswordImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4makeAdminDefault() {
        instanceAppUserService.makeAdmin(test4makeAdminDefaultArg1);
        assertNotNull(instanceAppUserService);
    }

    @Test
    public void test4makeAdminInitializedArguments() {
        instanceAppUserService.makeAdmin(test4makeAdminInitializedArgumentsArg1);
        assertNotNull(instanceAppUserService);
    }

    @Test
    public void test4makeAdminTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.makeAdminTxn(test4makeAdminTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4makeAdminTxnDefaultResult;
        }
        assertEquals(test4makeAdminTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4makeAdminTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.makeAdminTxn(test4makeAdminTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4makeAdminTxnInitializedArgumentsResult;
        }
        assertEquals(test4makeAdminTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4makeAdminImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.makeAdminImplementation(test4makeAdminImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4makeAdminImplementationDefaultResult;
        }
        assertEquals(test4makeAdminImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4makeAdminImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.makeAdminImplementation(test4makeAdminImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4makeAdminImplementationInitializedArgumentsResult;
        }
        assertEquals(test4makeAdminImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4makeOperatorDefault() {
        instanceAppUserService.makeOperator(test4makeOperatorDefaultArg1);
        assertNotNull(instanceAppUserService);
    }

    @Test
    public void test4makeOperatorInitializedArguments() {
        instanceAppUserService.makeOperator(test4makeOperatorInitializedArgumentsArg1);
        assertNotNull(instanceAppUserService);
    }

    @Test
    public void test4makeOperatorTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.makeOperatorTxn(test4makeOperatorTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4makeOperatorTxnDefaultResult;
        }
        assertEquals(test4makeOperatorTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4makeOperatorTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.makeOperatorTxn(test4makeOperatorTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4makeOperatorTxnInitializedArgumentsResult;
        }
        assertEquals(test4makeOperatorTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4makeOperatorImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.makeOperatorImplementation(test4makeOperatorImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4makeOperatorImplementationDefaultResult;
        }
        assertEquals(test4makeOperatorImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4makeOperatorImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.makeOperatorImplementation(test4makeOperatorImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4makeOperatorImplementationInitializedArgumentsResult;
        }
        assertEquals(test4makeOperatorImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4changeUserTypeDefault() {
        instanceAppUserService.changeUserType(test4changeUserTypeDefaultArg1);
        assertNotNull(instanceAppUserService);
    }

    @Test
    public void test4changeUserTypeInitializedArguments() {
        instanceAppUserService.changeUserType(test4changeUserTypeInitializedArgumentsArg1);
        assertNotNull(instanceAppUserService);
    }

    @Test
    public void test4changeUserTypeTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.changeUserTypeTxn(test4changeUserTypeTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4changeUserTypeTxnDefaultResult;
        }
        assertEquals(test4changeUserTypeTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4changeUserTypeTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.changeUserTypeTxn(test4changeUserTypeTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4changeUserTypeTxnInitializedArgumentsResult;
        }
        assertEquals(test4changeUserTypeTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4changeUserTypeImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.changeUserTypeImplementation(test4changeUserTypeImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4changeUserTypeImplementationDefaultResult;
        }
        assertEquals(test4changeUserTypeImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4changeUserTypeImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.changeUserTypeImplementation(test4changeUserTypeImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4changeUserTypeImplementationInitializedArgumentsResult;
        }
        assertEquals(test4changeUserTypeImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4cancelAdminDefault() {
        instanceAppUserService.cancelAdmin(test4cancelAdminDefaultArg1);
        assertNotNull(instanceAppUserService);
    }

    @Test
    public void test4cancelAdminInitializedArguments() {
        instanceAppUserService.cancelAdmin(test4cancelAdminInitializedArgumentsArg1);
        assertNotNull(instanceAppUserService);
    }

    @Test
    public void test4cancelAdminTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.cancelAdminTxn(test4cancelAdminTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4cancelAdminTxnDefaultResult;
        }
        assertEquals(test4cancelAdminTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4cancelAdminTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.cancelAdminTxn(test4cancelAdminTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4cancelAdminTxnInitializedArgumentsResult;
        }
        assertEquals(test4cancelAdminTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4cancelAdminImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.cancelAdminImplementation(test4cancelAdminImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4cancelAdminImplementationDefaultResult;
        }
        assertEquals(test4cancelAdminImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4cancelAdminImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.cancelAdminImplementation(test4cancelAdminImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4cancelAdminImplementationInitializedArgumentsResult;
        }
        assertEquals(test4cancelAdminImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4cancelOperatorDefault() {
        instanceAppUserService.cancelOperator(test4cancelOperatorDefaultArg1);
        assertNotNull(instanceAppUserService);
    }

    @Test
    public void test4cancelOperatorInitializedArguments() {
        instanceAppUserService.cancelOperator(test4cancelOperatorInitializedArgumentsArg1);
        assertNotNull(instanceAppUserService);
    }

    @Test
    public void test4cancelOperatorTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.cancelOperatorTxn(test4cancelOperatorTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4cancelOperatorTxnDefaultResult;
        }
        assertEquals(test4cancelOperatorTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4cancelOperatorTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.cancelOperatorTxn(test4cancelOperatorTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4cancelOperatorTxnInitializedArgumentsResult;
        }
        assertEquals(test4cancelOperatorTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4cancelOperatorImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.cancelOperatorImplementation(test4cancelOperatorImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4cancelOperatorImplementationDefaultResult;
        }
        assertEquals(test4cancelOperatorImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4cancelOperatorImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.cancelOperatorImplementation(test4cancelOperatorImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4cancelOperatorImplementationInitializedArgumentsResult;
        }
        assertEquals(test4cancelOperatorImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tNEWUSERDefault() {
        instanceAppUserService.tNEWUSER(test4tNEWUSERDefaultArg1);
        assertNotNull(instanceAppUserService);
    }

    @Test
    public void test4tNEWUSERInitializedArguments() {
        instanceAppUserService.tNEWUSER(test4tNEWUSERInitializedArgumentsArg1);
        assertNotNull(instanceAppUserService);
    }

    @Test
    public void test4tNEWUSERTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.tNEWUSERTxn(test4tNEWUSERTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4tNEWUSERTxnDefaultResult;
        }
        assertEquals(test4tNEWUSERTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tNEWUSERTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.tNEWUSERTxn(test4tNEWUSERTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4tNEWUSERTxnInitializedArgumentsResult;
        }
        assertEquals(test4tNEWUSERTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tNEWUSERImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.tNEWUSERImplementation(test4tNEWUSERImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4tNEWUSERImplementationDefaultResult;
        }
        assertEquals(test4tNEWUSERImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tNEWUSERImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.tNEWUSERImplementation(test4tNEWUSERImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4tNEWUSERImplementationInitializedArgumentsResult;
        }
        assertEquals(test4tNEWUSERImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tEDITUSERDefault() {
        instanceAppUserService.tEDITUSER(test4tEDITUSERDefaultArg1);
        assertNotNull(instanceAppUserService);
    }

    @Test
    public void test4tEDITUSERInitializedArguments() {
        instanceAppUserService.tEDITUSER(test4tEDITUSERInitializedArgumentsArg1);
        assertNotNull(instanceAppUserService);
    }

    @Test
    public void test4tEDITUSERTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.tEDITUSERTxn(test4tEDITUSERTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4tEDITUSERTxnDefaultResult;
        }
        assertEquals(test4tEDITUSERTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tEDITUSERTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.tEDITUSERTxn(test4tEDITUSERTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4tEDITUSERTxnInitializedArgumentsResult;
        }
        assertEquals(test4tEDITUSERTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tEDITUSERImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.tEDITUSERImplementation(test4tEDITUSERImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4tEDITUSERImplementationDefaultResult;
        }
        assertEquals(test4tEDITUSERImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tEDITUSERImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.tEDITUSERImplementation(test4tEDITUSERImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4tEDITUSERImplementationInitializedArgumentsResult;
        }
        assertEquals(test4tEDITUSERImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tDELETEDefault() {
        instanceAppUserService.tDELETE(test4tDELETEDefaultArg1);
        assertNotNull(instanceAppUserService);
    }

    @Test
    public void test4tDELETEInitializedArguments() {
        instanceAppUserService.tDELETE(test4tDELETEInitializedArgumentsArg1);
        assertNotNull(instanceAppUserService);
    }

    @Test
    public void test4tDELETETxnDefault() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.tDELETETxn(test4tDELETETxnDefaultArg1);
        } catch (ModelException e) {
            result = test4tDELETETxnDefaultResult;
        }
        assertEquals(test4tDELETETxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tDELETETxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.tDELETETxn(test4tDELETETxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4tDELETETxnInitializedArgumentsResult;
        }
        assertEquals(test4tDELETETxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tDELETEImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.tDELETEImplementation(test4tDELETEImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4tDELETEImplementationDefaultResult;
        }
        assertEquals(test4tDELETEImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tDELETEImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceAppUserService.tDELETEImplementation(test4tDELETEImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4tDELETEImplementationInitializedArgumentsResult;
        }
        assertEquals(test4tDELETEImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }
}
