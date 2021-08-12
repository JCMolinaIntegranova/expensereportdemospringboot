package com.integranova.spring.expensereportdemo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.OperatorUserConstants;
import com.integranova.spring.expensereportdemo.persistence.AppUser;
import com.integranova.spring.expensereportdemo.persistence.oid.AppUserOid;
import com.integranova.spring.expensereportdemo.persistence.oid.OperatorUserOid;
import com.integranova.spring.expensereportdemo.persistence.OperatorUser;
import com.integranova.spring.expensereportdemo.repository.OperatorUserJpaRepository;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.CancelOperatorRequest;
import com.integranova.spring.expensereportdemo.viewmodel.appuser.siu.MakeOperatorRequest;
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
public class OperatorUserServiceTest extends ClassTest {

    @InjectMocks
    private OperatorUserService instanceOperatorUserService;
    
    @Mock
    private static OperatorUserJpaRepository mockRepository;
    
    @Mock
    private static AppUserService mockAppUserService;

    private static OperatorUser mockInstance1;
    
    private static OperatorUser mockInstance2;

    private static List<OperatorUser> mockPopulation;

    private static String mockappUserLogin;

    private static Optional<OperatorUser> mockOperatorUser; 

    // test4solveQuery
    private static QueryRequest test4solveQueryArg1;
    private static List<Map<String, Object>> test4solveQueryResult;

    // test4get
    private static List<OperatorUser> test4getResult;

    // test4getQueryRequest
    private static QueryRequest test4getQueryRequestArg1;
    private static List<OperatorUser> test4getQueryRequestResult;

    // test4getDynamicPopulation
    private static QueryRequest test4getDynamicPopulationArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationResult;

    // test4getDynamicPopulationFilterByOID
    private static QueryRequest test4getDynamicPopulationFilterByOIDArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationFilterByOIDResult;

    // test4getById
    private static String test4getByIdArg1;
    private static OperatorUser test4getByIdResult;

    // test4getOperatorUserDynamic
    private static OperatorUserOid test4getOperatorUserDynamicArg1;
    private static String test4getOperatorUserDynamicArg2;
    private static InstanceResponseViewModel test4getOperatorUserDynamicResult;

    // test4getSuppInfoWithoutInstance
    private static OperatorUserOid test4getSuppInfoWithoutInstanceArg1;
    private static String test4getSuppInfoWithoutInstanceArg2;
    private static String test4getSuppInfoWithoutInstanceResult;

    // test4getSuppInfoWithInstance
    private static OperatorUserOid test4getSuppInfoWithInstanceArg1;
    private static String test4getSuppInfoWithInstanceArg2;

    // test4makeOperatorImplementationDefault
    private static MakeOperatorRequest test4makeOperatorImplementationDefaultArg1;
    private static ServiceResponse test4makeOperatorImplementationDefaultResult;

    // test4makeOperatorImplementationInitializedArguments
    private static MakeOperatorRequest test4makeOperatorImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4makeOperatorImplementationInitializedArgumentsResult;

    // test4cancelOperatorImplementationDefault
    private static CancelOperatorRequest test4cancelOperatorImplementationDefaultArg1;
    private static ServiceResponse test4cancelOperatorImplementationDefaultResult;

    // test4cancelOperatorImplementationInitializedArguments
    private static CancelOperatorRequest test4cancelOperatorImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4cancelOperatorImplementationInitializedArgumentsResult;

    @BeforeClass
    public static void setUpClass() throws SystemException {
        setUpMockData();
    }

    private static void setUpMockData() throws SystemException {
        mockappUserLogin = "";
        mockInstance1 = new OperatorUser();
        mockInstance2 = new OperatorUser();
        mockPopulation = new ArrayList<>(Arrays.asList(mockInstance1, mockInstance2));
        mockOperatorUser = Optional.of(new OperatorUser(new OperatorUserOid(mockappUserLogin)));
        setUpMockData4test4solveQuery();
        setUpMockData4test4get();
        setUpMockData4test4getQueryRequest();
        setUpMockData4test4getDynamicPopulation();
        setUpMockData4test4getDynamicPopulationFilterByOID();
        setUpMockData4test4getById();
        setUpMockData4test4getOperatorUserDynamic();
        setUpMockData4test4getSuppInfoWithoutInstance();
        setUpMockData4test4getSuppInfoWithInstance();
        setUpMockData4test4makeOperatorImplementationDefault();
        setUpMockData4test4makeOperatorImplementationInitializedArguments();
        setUpMockData4test4cancelOperatorImplementationDefault();
        setUpMockData4test4cancelOperatorImplementationInitializedArguments();
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
        test4getDynamicPopulationFilterByOIDArg1.addFilterRequest(new FilterRequest(Constants.FILTER_BY_OID,new ArrayList<>(Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_OID_FVAR_OID, new OperatorUserOid(""))))));
        test4getDynamicPopulationFilterByOIDResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getById() {
        test4getByIdArg1 = "";
        test4getByIdResult = mockOperatorUser.get();
    }

    private static void setUpMockData4test4getOperatorUserDynamic() {
        test4getOperatorUserDynamicArg1 = new OperatorUserOid();
        test4getOperatorUserDynamicArg2 = "";
        test4getOperatorUserDynamicResult = new InstanceResponseViewModel();
    }

    private static void setUpMockData4test4getSuppInfoWithoutInstance() {
        test4getSuppInfoWithoutInstanceArg1 = new OperatorUserOid();
        test4getSuppInfoWithoutInstanceArg2 = "";
        test4getSuppInfoWithoutInstanceResult = "";
    }

    private static void setUpMockData4test4getSuppInfoWithInstance() {
        test4getSuppInfoWithInstanceArg1 = new OperatorUserOid("");
        test4getSuppInfoWithInstanceArg2 = "";
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

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        when(mockRepository.findById(mockappUserLogin)).thenAnswer(new Answer<Optional<OperatorUser>>(){
        	public Optional<OperatorUser> answer(InvocationOnMock invocation) {
        		if (invocation.getArgument(0).equals(mockappUserLogin)) {
        			return mockOperatorUser;
                }
        		return Optional.empty();
        	}
        });
        when(mockRepository.save(any(OperatorUser.class))).thenReturn(mockInstance1);
        when(mockRepository.solveQuery(any(SQLSelect.class))).thenReturn(mockPopulation);
        when(mockRepository.solveQuery(any(SQLSelect.class), anyInt(), anyInt())).thenReturn(mockPopulation);
    }
    
    @After
    public void tearDown() {
        instanceOperatorUserService = null;
    }

    @Test
    public void test4solveQuery() {
        assertEquals(test4solveQueryResult, instanceOperatorUserService.solveQuery(test4solveQueryArg1));
    }

    @Test
    public void test4get() {
        assertEquals(test4getResult, instanceOperatorUserService.get());
    }

    @Test
    public void test4getQueryRequest() {
        assertEquals(test4getQueryRequestResult, instanceOperatorUserService.get(test4getQueryRequestArg1));
    }

    @Test
    public void test4getDynamicPopulation() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationResult), getResult(TOTALITEMS, instanceOperatorUserService.getDynamic(test4getDynamicPopulationArg1)));
    }

    @Test
    public void test4getDynamicPopulationFilterByOID() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationFilterByOIDResult), getResult(TOTALITEMS, instanceOperatorUserService.getDynamic(test4getDynamicPopulationFilterByOIDArg1)));
    }

    @Test
    public void test4getById() {
        assertEquals(test4getByIdResult, instanceOperatorUserService.getById(test4getByIdArg1));
    }

    @Test
    public void test4getOperatorUserDynamic() {
        assertEquals(test4getOperatorUserDynamicResult.getResultCode(), instanceOperatorUserService.getOperatorUserDynamic(test4getOperatorUserDynamicArg1, test4getOperatorUserDynamicArg2).getResultCode());
    }

    @Test
    public void test4getSuppInfoWithoutInstance() {
        assertEquals(test4getSuppInfoWithoutInstanceResult, instanceOperatorUserService.getSuppInfo(test4getSuppInfoWithoutInstanceArg1, test4getSuppInfoWithoutInstanceArg2));
    }

    @Test
    public void test4getSuppInfoWithInstance() {
        instanceOperatorUserService.getSuppInfo(test4getSuppInfoWithInstanceArg1, test4getSuppInfoWithInstanceArg2);
        assertNotNull(instanceOperatorUserService);
    }

    @Test
    public void test4makeOperatorImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceOperatorUserService.makeOperatorImplementation(test4makeOperatorImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4makeOperatorImplementationDefaultResult;
        }
        assertEquals(test4makeOperatorImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4makeOperatorImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceOperatorUserService.makeOperatorImplementation(test4makeOperatorImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4makeOperatorImplementationInitializedArgumentsResult;
        }
        assertEquals(test4makeOperatorImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4cancelOperatorImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceOperatorUserService.cancelOperatorImplementation(test4cancelOperatorImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4cancelOperatorImplementationDefaultResult;
        }
        assertEquals(test4cancelOperatorImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4cancelOperatorImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceOperatorUserService.cancelOperatorImplementation(test4cancelOperatorImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4cancelOperatorImplementationInitializedArgumentsResult;
        }
        assertEquals(test4cancelOperatorImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }
}
