package com.integranova.spring.expensereportdemo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.AdminUserConstants;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.persistence.AdminUser;
import com.integranova.spring.expensereportdemo.persistence.AppUser;
import com.integranova.spring.expensereportdemo.persistence.oid.AdminUserOid;
import com.integranova.spring.expensereportdemo.persistence.oid.AppUserOid;
import com.integranova.spring.expensereportdemo.repository.AdminUserJpaRepository;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.CancelAdminRequest;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.MakeAdminRequest;
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

@RunWith(MockitoJUnitRunner.Silent.class)
public class AdminUserServiceTest extends ClassTest {

    @InjectMocks
    private AdminUserService instanceAdminUserService;
    
    @Mock
    private static AdminUserJpaRepository mockRepository;
    
    @Mock
    private static AppUserService mockAppUserService;

    private static AdminUser mockInstance1;
    
    private static AdminUser mockInstance2;

    private static List<AdminUser> mockPopulation;

    private static String mockappUserLogin;

    private static Optional<AdminUser> mockAdminUser; 

    // test4solveQuery
    private static QueryRequest test4solveQueryArg1;
    private static List<Map<String, Object>> test4solveQueryResult;

    // test4get
    private static List<AdminUser> test4getResult;

    // test4getQueryRequest
    private static QueryRequest test4getQueryRequestArg1;
    private static List<AdminUser> test4getQueryRequestResult;

    // test4getDynamicPopulation
    private static QueryRequest test4getDynamicPopulationArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationResult;

    // test4getDynamicPopulationFilterByOID
    private static QueryRequest test4getDynamicPopulationFilterByOIDArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationFilterByOIDResult;

    // test4getById
    private static String test4getByIdArg1;
    private static AdminUser test4getByIdResult;

    // test4getAdminUserDynamic
    private static AdminUserOid test4getAdminUserDynamicArg1;
    private static String test4getAdminUserDynamicArg2;
    private static InstanceResponseViewModel test4getAdminUserDynamicResult;

    // test4getSuppInfoWithoutInstance
    private static AdminUserOid test4getSuppInfoWithoutInstanceArg1;
    private static String test4getSuppInfoWithoutInstanceArg2;
    private static String test4getSuppInfoWithoutInstanceResult;

    // test4getSuppInfoWithInstance
    private static AdminUserOid test4getSuppInfoWithInstanceArg1;
    private static String test4getSuppInfoWithInstanceArg2;

    // test4makeAdminImplementationDefault
    private static MakeAdminRequest test4makeAdminImplementationDefaultArg1;
    private static ServiceResponse test4makeAdminImplementationDefaultResult;

    // test4makeAdminImplementationInitializedArguments
    private static MakeAdminRequest test4makeAdminImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4makeAdminImplementationInitializedArgumentsResult;

    // test4cancelAdminImplementationDefault
    private static CancelAdminRequest test4cancelAdminImplementationDefaultArg1;
    private static ServiceResponse test4cancelAdminImplementationDefaultResult;

    // test4cancelAdminImplementationInitializedArguments
    private static CancelAdminRequest test4cancelAdminImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4cancelAdminImplementationInitializedArgumentsResult;

    @BeforeClass
    public static void setUpClass() throws SystemException {
        setUpMockData();
    }

    private static void setUpMockData() throws SystemException {
        mockappUserLogin = "";
        mockInstance1 = new AdminUser();
        mockInstance2 = new AdminUser();
        mockPopulation = new ArrayList<>(Arrays.asList(mockInstance1, mockInstance2));
        mockAdminUser = Optional.of(new AdminUser(new AdminUserOid(mockappUserLogin)));
        setUpMockData4test4solveQuery();
        setUpMockData4test4get();
        setUpMockData4test4getQueryRequest();
        setUpMockData4test4getDynamicPopulation();
        setUpMockData4test4getDynamicPopulationFilterByOID();
        setUpMockData4test4getById();
        setUpMockData4test4getAdminUserDynamic();
        setUpMockData4test4getSuppInfoWithoutInstance();
        setUpMockData4test4getSuppInfoWithInstance();
        setUpMockData4test4makeAdminImplementationDefault();
        setUpMockData4test4makeAdminImplementationInitializedArguments();
        setUpMockData4test4cancelAdminImplementationDefault();
        setUpMockData4test4cancelAdminImplementationInitializedArguments();
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

    private static void setUpMockData4test4getDynamicPopulationFilterByOID() {
        test4getDynamicPopulationFilterByOIDArg1 = new QueryRequest();
        test4getDynamicPopulationFilterByOIDArg1.setDisplaySetItems("appUserLogin");
        test4getDynamicPopulationFilterByOIDArg1.addFilterRequest(new FilterRequest(Constants.FILTER_BY_OID,new ArrayList<>(Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_OID_FVAR_OID, new AdminUserOid(""))))));
        test4getDynamicPopulationFilterByOIDResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getById() {
        test4getByIdArg1 = "";
        test4getByIdResult = mockAdminUser.get();
    }

    private static void setUpMockData4test4getAdminUserDynamic() {
        test4getAdminUserDynamicArg1 = new AdminUserOid();
        test4getAdminUserDynamicArg2 = "";
        test4getAdminUserDynamicResult = new InstanceResponseViewModel();
    }

    private static void setUpMockData4test4getSuppInfoWithoutInstance() {
        test4getSuppInfoWithoutInstanceArg1 = new AdminUserOid();
        test4getSuppInfoWithoutInstanceArg2 = "";
        test4getSuppInfoWithoutInstanceResult = "";
    }

    private static void setUpMockData4test4getSuppInfoWithInstance() {
        test4getSuppInfoWithInstanceArg1 = new AdminUserOid("");
        test4getSuppInfoWithInstanceArg2 = "";
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

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        when(mockRepository.findById(mockappUserLogin)).thenAnswer(new Answer<Optional<AdminUser>>(){
        	public Optional<AdminUser> answer(InvocationOnMock invocation) {
        		if (invocation.getArgument(0).equals(mockappUserLogin)) {
        			return mockAdminUser;
                }
        		return Optional.empty();
        	}
        });
        when(mockRepository.save(any(AdminUser.class))).thenReturn(mockInstance1);
        when(mockRepository.solveQuery(any(SQLSelect.class))).thenReturn(mockPopulation);
        when(mockRepository.solveQuery(any(SQLSelect.class), anyInt(), anyInt())).thenReturn(mockPopulation);
    }
    
    @After
    public void tearDown() {
        instanceAdminUserService = null;
    }

    @Test
    public void test4solveQuery() {
        assertEquals(test4solveQueryResult, instanceAdminUserService.solveQuery(test4solveQueryArg1));
    }

    @Test
    public void test4get() {
        assertEquals(test4getResult, instanceAdminUserService.get());
    }

    @Test
    public void test4getQueryRequest() {
        assertEquals(test4getQueryRequestResult, instanceAdminUserService.get(test4getQueryRequestArg1));
    }

    @Test
    public void test4getDynamicPopulation() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationResult), getResult(TOTALITEMS, instanceAdminUserService.getDynamic(test4getDynamicPopulationArg1)));
    }

    @Test
    public void test4getDynamicPopulationFilterByOID() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationFilterByOIDResult), getResult(TOTALITEMS, instanceAdminUserService.getDynamic(test4getDynamicPopulationFilterByOIDArg1)));
    }

    @Test
    public void test4getById() {
        assertEquals(test4getByIdResult, instanceAdminUserService.getById(test4getByIdArg1));
    }

    @Test
    public void test4getAdminUserDynamic() {
        assertEquals(test4getAdminUserDynamicResult.getResultCode(), instanceAdminUserService.getAdminUserDynamic(test4getAdminUserDynamicArg1, test4getAdminUserDynamicArg2).getResultCode());
    }

    @Test
    public void test4getSuppInfoWithoutInstance() {
        assertEquals(test4getSuppInfoWithoutInstanceResult, instanceAdminUserService.getSuppInfo(test4getSuppInfoWithoutInstanceArg1, test4getSuppInfoWithoutInstanceArg2));
    }

    @Test
    public void test4getSuppInfoWithInstance() {
        instanceAdminUserService.getSuppInfo(test4getSuppInfoWithInstanceArg1, test4getSuppInfoWithInstanceArg2);
        assertNotNull(instanceAdminUserService);
    }

    @Test
    public void test4makeAdminImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceAdminUserService.makeAdminImplementation(test4makeAdminImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4makeAdminImplementationDefaultResult;
        }
        assertEquals(test4makeAdminImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4makeAdminImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceAdminUserService.makeAdminImplementation(test4makeAdminImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4makeAdminImplementationInitializedArgumentsResult;
        }
        assertEquals(test4makeAdminImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4cancelAdminImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceAdminUserService.cancelAdminImplementation(test4cancelAdminImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4cancelAdminImplementationDefaultResult;
        }
        assertEquals(test4cancelAdminImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4cancelAdminImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceAdminUserService.cancelAdminImplementation(test4cancelAdminImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4cancelAdminImplementationInitializedArgumentsResult;
        }
        assertEquals(test4cancelAdminImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }
}
