package com.integranova.spring.expensereportdemo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.SystemParamConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.SystemParamOid;
import com.integranova.spring.expensereportdemo.persistence.SystemParam;
import com.integranova.spring.expensereportdemo.repository.SystemParamJpaRepository;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.viewmodel.FilterRequest;
import com.integranova.spring.expensereportdemo.viewmodel.FilterVariableRequest;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.QueryRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ServiceResponse;
import com.integranova.spring.expensereportdemo.viewmodel.systemparam.ds.DSSystemParams;
import com.integranova.spring.expensereportdemo.viewmodel.systemparam.siu.CreateinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.systemparam.siu.DeleteinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.systemparam.siu.EditinstanceRequest;
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
public class SystemParamServiceTest extends ClassTest {

    @InjectMocks
    private SystemParamService instanceSystemParamService;
    
    @Mock
    private static SystemParamJpaRepository mockRepository;
    
    @Mock
    private static SystemParamService mockSystemParamService;

    private static SystemParam mockInstance1;
    
    private static SystemParam mockInstance2;

    private static List<SystemParam> mockPopulation;

    private static String mocksystemParamparamCode;

    private static Optional<SystemParam> mockSystemParam; 

    // test4solveQuery
    private static QueryRequest test4solveQueryArg1;
    private static List<Map<String, Object>> test4solveQueryResult;

    // test4get
    private static List<SystemParam> test4getResult;

    // test4getQueryRequest
    private static QueryRequest test4getQueryRequestArg1;
    private static List<SystemParam> test4getQueryRequestResult;

    // test4getDynamicPopulation
    private static QueryRequest test4getDynamicPopulationArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationResult;

    // test4getDynamicPopulationFilterByOID
    private static QueryRequest test4getDynamicPopulationFilterByOIDArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationFilterByOIDResult;

    // test4getById
    private static String test4getByIdArg1;
    private static SystemParam test4getByIdResult;

    // test4getSystemParamDynamic
    private static SystemParamOid test4getSystemParamDynamicArg1;
    private static String test4getSystemParamDynamicArg2;
    private static InstanceResponseViewModel test4getSystemParamDynamicResult;

    // test4getSuppInfoWithoutInstance
    private static SystemParamOid test4getSuppInfoWithoutInstanceArg1;
    private static String test4getSuppInfoWithoutInstanceArg2;
    private static String test4getSuppInfoWithoutInstanceResult;

    // test4getSuppInfoWithInstance
    private static SystemParamOid test4getSuppInfoWithInstanceArg1;
    private static String test4getSuppInfoWithInstanceArg2;

    // test4getDSSystemParams
    private static String test4getDSSystemParamsArg1;
    private static String test4getDSSystemParamsArg2;
    private static String test4getDSSystemParamsArg3;
    private static DSSystemParams test4getDSSystemParamsResult;

    // test4piuPIUSystemParams
    private static QueryRequest test4piuPIUSystemParamsArg1;
    private static List<DSSystemParams> test4piuPIUSystemParamsResult;

    // test4getCount4PIUSystemParams
    private static QueryRequest test4getCount4PIUSystemParamsArg1;
    private static int test4getCount4PIUSystemParamsResult;

    // test4createinstanceDefault
    private static CreateinstanceRequest test4createinstanceDefaultArg1;

    // test4createinstanceInitializedArguments
    private static CreateinstanceRequest test4createinstanceInitializedArgumentsArg1;

    // test4createinstanceTxnDefault
    private static CreateinstanceRequest test4createinstanceTxnDefaultArg1;
    private static ServiceResponse test4createinstanceTxnDefaultResult;

    // test4createinstanceTxnInitializedArguments
    private static CreateinstanceRequest test4createinstanceTxnInitializedArgumentsArg1;
    private static ServiceResponse test4createinstanceTxnInitializedArgumentsResult;

    // test4createinstanceImplementationDefault
    private static CreateinstanceRequest test4createinstanceImplementationDefaultArg1;
    private static ServiceResponse test4createinstanceImplementationDefaultResult;

    // test4createinstanceImplementationInitializedArguments
    private static CreateinstanceRequest test4createinstanceImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4createinstanceImplementationInitializedArgumentsResult;

    // test4deleteinstanceDefault
    private static DeleteinstanceRequest test4deleteinstanceDefaultArg1;

    // test4deleteinstanceInitializedArguments
    private static DeleteinstanceRequest test4deleteinstanceInitializedArgumentsArg1;

    // test4deleteinstanceTxnDefault
    private static DeleteinstanceRequest test4deleteinstanceTxnDefaultArg1;
    private static ServiceResponse test4deleteinstanceTxnDefaultResult;

    // test4deleteinstanceTxnInitializedArguments
    private static DeleteinstanceRequest test4deleteinstanceTxnInitializedArgumentsArg1;
    private static ServiceResponse test4deleteinstanceTxnInitializedArgumentsResult;

    // test4deleteinstanceImplementationDefault
    private static DeleteinstanceRequest test4deleteinstanceImplementationDefaultArg1;
    private static ServiceResponse test4deleteinstanceImplementationDefaultResult;

    // test4deleteinstanceImplementationInitializedArguments
    private static DeleteinstanceRequest test4deleteinstanceImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4deleteinstanceImplementationInitializedArgumentsResult;

    // test4editinstanceDefault
    private static EditinstanceRequest test4editinstanceDefaultArg1;

    // test4editinstanceInitializedArguments
    private static EditinstanceRequest test4editinstanceInitializedArgumentsArg1;

    // test4editinstanceTxnDefault
    private static EditinstanceRequest test4editinstanceTxnDefaultArg1;
    private static ServiceResponse test4editinstanceTxnDefaultResult;

    // test4editinstanceTxnInitializedArguments
    private static EditinstanceRequest test4editinstanceTxnInitializedArgumentsArg1;
    private static ServiceResponse test4editinstanceTxnInitializedArgumentsResult;

    // test4editinstanceImplementationDefault
    private static EditinstanceRequest test4editinstanceImplementationDefaultArg1;
    private static ServiceResponse test4editinstanceImplementationDefaultResult;

    // test4editinstanceImplementationInitializedArguments
    private static EditinstanceRequest test4editinstanceImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4editinstanceImplementationInitializedArgumentsResult;

    @BeforeClass
    public static void setUpClass() throws SystemException {
        setUpMockData();
    }

    private static void setUpMockData() throws SystemException {
        mocksystemParamparamCode = "";
        mockInstance1 = new SystemParam();
        mockInstance2 = new SystemParam();
        mockPopulation = new ArrayList<>(Arrays.asList(mockInstance1, mockInstance2));
        mockSystemParam = Optional.of(new SystemParam(new SystemParamOid(mocksystemParamparamCode)));
        setUpMockData4test4solveQuery();
        setUpMockData4test4get();
        setUpMockData4test4getQueryRequest();
        setUpMockData4test4getDynamicPopulation();
        setUpMockData4test4getDynamicPopulationFilterByOID();
        setUpMockData4test4getById();
        setUpMockData4test4getSystemParamDynamic();
        setUpMockData4test4getSuppInfoWithoutInstance();
        setUpMockData4test4getSuppInfoWithInstance();
        setUpMockData4test4getDSSystemParams();
        setUpMockData4test4piuPIUSystemParams();
        setUpMockData4test4getCount4PIUSystemParams();
        setUpMockData4test4createinstanceDefault();
        setUpMockData4test4createinstanceInitializedArguments();
        setUpMockData4test4createinstanceTxnDefault();
        setUpMockData4test4createinstanceTxnInitializedArguments();
        setUpMockData4test4createinstanceImplementationDefault();
        setUpMockData4test4createinstanceImplementationInitializedArguments();
        setUpMockData4test4deleteinstanceDefault();
        setUpMockData4test4deleteinstanceInitializedArguments();
        setUpMockData4test4deleteinstanceTxnDefault();
        setUpMockData4test4deleteinstanceTxnInitializedArguments();
        setUpMockData4test4deleteinstanceImplementationDefault();
        setUpMockData4test4deleteinstanceImplementationInitializedArguments();
        setUpMockData4test4editinstanceDefault();
        setUpMockData4test4editinstanceInitializedArguments();
        setUpMockData4test4editinstanceTxnDefault();
        setUpMockData4test4editinstanceTxnInitializedArguments();
        setUpMockData4test4editinstanceImplementationDefault();
        setUpMockData4test4editinstanceImplementationInitializedArguments();
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
        test4getDynamicPopulationArg1.setDisplaySetItems("systemParamparamCode");
        test4getDynamicPopulationResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationFilterByOID() {
        test4getDynamicPopulationFilterByOIDArg1 = new QueryRequest();
        test4getDynamicPopulationFilterByOIDArg1.setDisplaySetItems("systemParamparamCode");
        test4getDynamicPopulationFilterByOIDArg1.addFilterRequest(new FilterRequest(Constants.FILTER_BY_OID,new ArrayList<>(Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_OID_FVAR_OID, new SystemParamOid(""))))));
        test4getDynamicPopulationFilterByOIDResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getById() {
        test4getByIdArg1 = "";
        test4getByIdResult = mockSystemParam.get();
    }

    private static void setUpMockData4test4getSystemParamDynamic() {
        test4getSystemParamDynamicArg1 = new SystemParamOid();
        test4getSystemParamDynamicArg2 = "";
        test4getSystemParamDynamicResult = new InstanceResponseViewModel();
    }

    private static void setUpMockData4test4getSuppInfoWithoutInstance() {
        test4getSuppInfoWithoutInstanceArg1 = new SystemParamOid();
        test4getSuppInfoWithoutInstanceArg2 = "";
        test4getSuppInfoWithoutInstanceResult = "";
    }

    private static void setUpMockData4test4getSuppInfoWithInstance() {
        test4getSuppInfoWithInstanceArg1 = new SystemParamOid("");
        test4getSuppInfoWithInstanceArg2 = "";
    }

    private static void setUpMockData4test4getDSSystemParams() {
        test4getDSSystemParamsArg1 = "";
        test4getDSSystemParamsArg2 = "";
        test4getDSSystemParamsArg3 = "";
        test4getDSSystemParamsResult = new DSSystemParams();
    }

    private static void setUpMockData4test4piuPIUSystemParams() {
        test4piuPIUSystemParamsArg1 = new QueryRequest();
        test4piuPIUSystemParamsResult = mockPopulation.stream().map(i -> new DSSystemParams(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4getCount4PIUSystemParams() {
        test4getCount4PIUSystemParamsArg1 = new QueryRequest();
        test4getCount4PIUSystemParamsResult = mockPopulation.size();
    }

    private static void setUpMockData4test4createinstanceDefault() {
        test4createinstanceDefaultArg1 = new CreateinstanceRequest();
    }

    private static void setUpMockData4test4createinstanceInitializedArguments() {
        test4createinstanceInitializedArgumentsArg1 = new CreateinstanceRequest();
        test4createinstanceInitializedArgumentsArg1.setSystemParamcreateinstancepatrparamCode("");
        test4createinstanceInitializedArgumentsArg1.setSystemParamcreateinstancepatrname("");
        test4createinstanceInitializedArgumentsArg1.setSystemParamcreateinstancepatrdescription("");
        test4createinstanceInitializedArgumentsArg1.setSystemParamcreateinstancepatrtypeName("");
        test4createinstanceInitializedArgumentsArg1.setSystemParamcreateinstancepatrparamValue("");
    }

    private static void setUpMockData4test4createinstanceTxnDefault() {
        test4createinstanceTxnDefaultArg1 = new CreateinstanceRequest();
        test4createinstanceTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4createinstanceTxnInitializedArguments() {
        test4createinstanceTxnInitializedArgumentsArg1 = new CreateinstanceRequest();
        test4createinstanceTxnInitializedArgumentsArg1.setSystemParamcreateinstancepatrparamCode("");
        test4createinstanceTxnInitializedArgumentsArg1.setSystemParamcreateinstancepatrname("");
        test4createinstanceTxnInitializedArgumentsArg1.setSystemParamcreateinstancepatrdescription("");
        test4createinstanceTxnInitializedArgumentsArg1.setSystemParamcreateinstancepatrtypeName("");
        test4createinstanceTxnInitializedArgumentsArg1.setSystemParamcreateinstancepatrparamValue("");
        test4createinstanceTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4createinstanceImplementationDefault() {
        test4createinstanceImplementationDefaultArg1 = new CreateinstanceRequest();
        test4createinstanceImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4createinstanceImplementationInitializedArguments() {
        test4createinstanceImplementationInitializedArgumentsArg1 = new CreateinstanceRequest();
        test4createinstanceImplementationInitializedArgumentsArg1.setSystemParamcreateinstancepatrparamCode("");
        test4createinstanceImplementationInitializedArgumentsArg1.setSystemParamcreateinstancepatrname("");
        test4createinstanceImplementationInitializedArgumentsArg1.setSystemParamcreateinstancepatrdescription("");
        test4createinstanceImplementationInitializedArgumentsArg1.setSystemParamcreateinstancepatrtypeName("");
        test4createinstanceImplementationInitializedArgumentsArg1.setSystemParamcreateinstancepatrparamValue("");
        test4createinstanceImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceDefault() {
        test4deleteinstanceDefaultArg1 = new DeleteinstanceRequest();
    }

    private static void setUpMockData4test4deleteinstanceInitializedArguments() {
        test4deleteinstanceInitializedArgumentsArg1 = new DeleteinstanceRequest();
        test4deleteinstanceInitializedArgumentsArg1.setSystemParamdeleteinstancepthisSystemParam(new SystemParamOid(""));
        test4deleteinstanceInitializedArgumentsArg1.setSystemParamdeleteinstancepthisSystemParamInstance(new SystemParam(test4deleteinstanceInitializedArgumentsArg1.getSystemParamdeleteinstancepthisSystemParam()));
    }

    private static void setUpMockData4test4deleteinstanceTxnDefault() {
        test4deleteinstanceTxnDefaultArg1 = new DeleteinstanceRequest();
        test4deleteinstanceTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceTxnInitializedArguments() {
        test4deleteinstanceTxnInitializedArgumentsArg1 = new DeleteinstanceRequest();
        test4deleteinstanceTxnInitializedArgumentsArg1.setSystemParamdeleteinstancepthisSystemParam(new SystemParamOid(""));
        test4deleteinstanceTxnInitializedArgumentsArg1.setSystemParamdeleteinstancepthisSystemParamInstance(new SystemParam(test4deleteinstanceTxnInitializedArgumentsArg1.getSystemParamdeleteinstancepthisSystemParam()));
        test4deleteinstanceTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceImplementationDefault() {
        test4deleteinstanceImplementationDefaultArg1 = new DeleteinstanceRequest();
        test4deleteinstanceImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceImplementationInitializedArguments() {
        test4deleteinstanceImplementationInitializedArgumentsArg1 = new DeleteinstanceRequest();
        test4deleteinstanceImplementationInitializedArgumentsArg1.setSystemParamdeleteinstancepthisSystemParam(new SystemParamOid(""));
        test4deleteinstanceImplementationInitializedArgumentsArg1.setSystemParamdeleteinstancepthisSystemParamInstance(new SystemParam(test4deleteinstanceImplementationInitializedArgumentsArg1.getSystemParamdeleteinstancepthisSystemParam()));
        test4deleteinstanceImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceDefault() {
        test4editinstanceDefaultArg1 = new EditinstanceRequest();
    }

    private static void setUpMockData4test4editinstanceInitializedArguments() {
        test4editinstanceInitializedArgumentsArg1 = new EditinstanceRequest();
        test4editinstanceInitializedArgumentsArg1.setSystemParameditinstancepthisSystemParam(new SystemParamOid(""));
        test4editinstanceInitializedArgumentsArg1.setSystemParameditinstancepthisSystemParamInstance(new SystemParam(test4editinstanceInitializedArgumentsArg1.getSystemParameditinstancepthisSystemParam()));
        test4editinstanceInitializedArgumentsArg1.setSystemParameditinstancepname("");
        test4editinstanceInitializedArgumentsArg1.setSystemParameditinstancepdescription("");
        test4editinstanceInitializedArgumentsArg1.setSystemParameditinstanceptypeName("");
        test4editinstanceInitializedArgumentsArg1.setSystemParameditinstancepparamValue("");
    }

    private static void setUpMockData4test4editinstanceTxnDefault() {
        test4editinstanceTxnDefaultArg1 = new EditinstanceRequest();
        test4editinstanceTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceTxnInitializedArguments() {
        test4editinstanceTxnInitializedArgumentsArg1 = new EditinstanceRequest();
        test4editinstanceTxnInitializedArgumentsArg1.setSystemParameditinstancepthisSystemParam(new SystemParamOid(""));
        test4editinstanceTxnInitializedArgumentsArg1.setSystemParameditinstancepthisSystemParamInstance(new SystemParam(test4editinstanceTxnInitializedArgumentsArg1.getSystemParameditinstancepthisSystemParam()));
        test4editinstanceTxnInitializedArgumentsArg1.setSystemParameditinstancepname("");
        test4editinstanceTxnInitializedArgumentsArg1.setSystemParameditinstancepdescription("");
        test4editinstanceTxnInitializedArgumentsArg1.setSystemParameditinstanceptypeName("");
        test4editinstanceTxnInitializedArgumentsArg1.setSystemParameditinstancepparamValue("");
        test4editinstanceTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceImplementationDefault() {
        test4editinstanceImplementationDefaultArg1 = new EditinstanceRequest();
        test4editinstanceImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceImplementationInitializedArguments() {
        test4editinstanceImplementationInitializedArgumentsArg1 = new EditinstanceRequest();
        test4editinstanceImplementationInitializedArgumentsArg1.setSystemParameditinstancepthisSystemParam(new SystemParamOid(""));
        test4editinstanceImplementationInitializedArgumentsArg1.setSystemParameditinstancepthisSystemParamInstance(new SystemParam(test4editinstanceImplementationInitializedArgumentsArg1.getSystemParameditinstancepthisSystemParam()));
        test4editinstanceImplementationInitializedArgumentsArg1.setSystemParameditinstancepname("");
        test4editinstanceImplementationInitializedArgumentsArg1.setSystemParameditinstancepdescription("");
        test4editinstanceImplementationInitializedArgumentsArg1.setSystemParameditinstanceptypeName("");
        test4editinstanceImplementationInitializedArgumentsArg1.setSystemParameditinstancepparamValue("");
        test4editinstanceImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(instanceSystemParamService, "systemParamSrv", instanceSystemParamService);

        when(mockSystemParamService.getByOIDWithHV(test4deleteinstanceInitializedArgumentsArg1.getSystemParamdeleteinstancepthisSystemParam())).thenReturn(test4deleteinstanceInitializedArgumentsArg1.getSystemParamdeleteinstancepthisSystemParamInstance());

        when(mockSystemParamService.getByOIDWithHV(test4deleteinstanceTxnInitializedArgumentsArg1.getSystemParamdeleteinstancepthisSystemParam())).thenReturn(test4deleteinstanceTxnInitializedArgumentsArg1.getSystemParamdeleteinstancepthisSystemParamInstance());

        when(mockSystemParamService.getByOIDWithHV(test4editinstanceInitializedArgumentsArg1.getSystemParameditinstancepthisSystemParam())).thenReturn(test4editinstanceInitializedArgumentsArg1.getSystemParameditinstancepthisSystemParamInstance());

        when(mockSystemParamService.getByOIDWithHV(test4editinstanceTxnInitializedArgumentsArg1.getSystemParameditinstancepthisSystemParam())).thenReturn(test4editinstanceTxnInitializedArgumentsArg1.getSystemParameditinstancepthisSystemParamInstance());

        when(mockRepository.findById(mocksystemParamparamCode)).thenAnswer(new Answer<Optional<SystemParam>>(){
        	public Optional<SystemParam> answer(InvocationOnMock invocation) {
        		if (invocation.getArgument(0).equals(mocksystemParamparamCode)) {
        			return mockSystemParam;
                }
        		return Optional.empty();
        	}
        });
        when(mockRepository.save(any(SystemParam.class))).thenReturn(mockInstance1);
        when(mockRepository.solveQuery(any(SQLSelect.class))).thenReturn(mockPopulation);
        when(mockRepository.solveQuery(any(SQLSelect.class), anyInt(), anyInt())).thenReturn(mockPopulation);
    }
    
    @After
    public void tearDown() {
        instanceSystemParamService = null;
    }

    @Test
    public void test4solveQuery() {
        assertEquals(test4solveQueryResult, instanceSystemParamService.solveQuery(test4solveQueryArg1));
    }

    @Test
    public void test4get() {
        assertEquals(test4getResult, instanceSystemParamService.get());
    }

    @Test
    public void test4getQueryRequest() {
        assertEquals(test4getQueryRequestResult, instanceSystemParamService.get(test4getQueryRequestArg1));
    }

    @Test
    public void test4getDynamicPopulation() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationResult), getResult(TOTALITEMS, instanceSystemParamService.getDynamic(test4getDynamicPopulationArg1)));
    }

    @Test
    public void test4getDynamicPopulationFilterByOID() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationFilterByOIDResult), getResult(TOTALITEMS, instanceSystemParamService.getDynamic(test4getDynamicPopulationFilterByOIDArg1)));
    }

    @Test
    public void test4getById() {
        assertEquals(test4getByIdResult, instanceSystemParamService.getById(test4getByIdArg1));
    }

    @Test
    public void test4getSystemParamDynamic() {
        assertEquals(test4getSystemParamDynamicResult.getResultCode(), instanceSystemParamService.getSystemParamDynamic(test4getSystemParamDynamicArg1, test4getSystemParamDynamicArg2).getResultCode());
    }

    @Test
    public void test4getSuppInfoWithoutInstance() {
        assertEquals(test4getSuppInfoWithoutInstanceResult, instanceSystemParamService.getSuppInfo(test4getSuppInfoWithoutInstanceArg1, test4getSuppInfoWithoutInstanceArg2));
    }

    @Test
    public void test4getSuppInfoWithInstance() {
        instanceSystemParamService.getSuppInfo(test4getSuppInfoWithInstanceArg1, test4getSuppInfoWithInstanceArg2);
        assertNotNull(instanceSystemParamService);
    }

    @Test
    public void test4getDSSystemParams() {
        assertEquals(test4getDSSystemParamsResult.getClass(), instanceSystemParamService.getDSSystemParams(test4getDSSystemParamsArg1, test4getDSSystemParamsArg2, test4getDSSystemParamsArg3).getClass());
    }

    @Test
    public void test4piuPIUSystemParams() {
        instanceSystemParamService.piuPIUSystemParams(test4piuPIUSystemParamsArg1);
        assertNotNull(instanceSystemParamService);
    }

    @Test
    public void test4getCount4PIUSystemParams() {
        instanceSystemParamService.getCount4PIUSystemParams(test4getCount4PIUSystemParamsArg1);
        assertNotNull(instanceSystemParamService);
    }

    @Test
    public void test4createinstanceDefault() {
        instanceSystemParamService.createinstance(test4createinstanceDefaultArg1);
        assertNotNull(instanceSystemParamService);
    }

    @Test
    public void test4createinstanceInitializedArguments() {
        instanceSystemParamService.createinstance(test4createinstanceInitializedArgumentsArg1);
        assertNotNull(instanceSystemParamService);
    }

    @Test
    public void test4createinstanceTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceSystemParamService.createinstanceTxn(test4createinstanceTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4createinstanceTxnDefaultResult;
        }
        assertEquals(test4createinstanceTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4createinstanceTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceSystemParamService.createinstanceTxn(test4createinstanceTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4createinstanceTxnInitializedArgumentsResult;
        }
        assertEquals(test4createinstanceTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4createinstanceImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceSystemParamService.createinstanceImplementation(test4createinstanceImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4createinstanceImplementationDefaultResult;
        }
        assertEquals(test4createinstanceImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4createinstanceImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceSystemParamService.createinstanceImplementation(test4createinstanceImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4createinstanceImplementationInitializedArgumentsResult;
        }
        assertEquals(test4createinstanceImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceDefault() {
        instanceSystemParamService.deleteinstance(test4deleteinstanceDefaultArg1);
        assertNotNull(instanceSystemParamService);
    }

    @Test
    public void test4deleteinstanceInitializedArguments() {
        instanceSystemParamService.deleteinstance(test4deleteinstanceInitializedArgumentsArg1);
        assertNotNull(instanceSystemParamService);
    }

    @Test
    public void test4deleteinstanceTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceSystemParamService.deleteinstanceTxn(test4deleteinstanceTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4deleteinstanceTxnDefaultResult;
        }
        assertEquals(test4deleteinstanceTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceSystemParamService.deleteinstanceTxn(test4deleteinstanceTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4deleteinstanceTxnInitializedArgumentsResult;
        }
        assertEquals(test4deleteinstanceTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceSystemParamService.deleteinstanceImplementation(test4deleteinstanceImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4deleteinstanceImplementationDefaultResult;
        }
        assertEquals(test4deleteinstanceImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceSystemParamService.deleteinstanceImplementation(test4deleteinstanceImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4deleteinstanceImplementationInitializedArgumentsResult;
        }
        assertEquals(test4deleteinstanceImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceDefault() {
        instanceSystemParamService.editinstance(test4editinstanceDefaultArg1);
        assertNotNull(instanceSystemParamService);
    }

    @Test
    public void test4editinstanceInitializedArguments() {
        instanceSystemParamService.editinstance(test4editinstanceInitializedArgumentsArg1);
        assertNotNull(instanceSystemParamService);
    }

    @Test
    public void test4editinstanceTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceSystemParamService.editinstanceTxn(test4editinstanceTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4editinstanceTxnDefaultResult;
        }
        assertEquals(test4editinstanceTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceSystemParamService.editinstanceTxn(test4editinstanceTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editinstanceTxnInitializedArgumentsResult;
        }
        assertEquals(test4editinstanceTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceSystemParamService.editinstanceImplementation(test4editinstanceImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4editinstanceImplementationDefaultResult;
        }
        assertEquals(test4editinstanceImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceSystemParamService.editinstanceImplementation(test4editinstanceImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editinstanceImplementationInitializedArgumentsResult;
        }
        assertEquals(test4editinstanceImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }
}
