package com.integranova.spring.expensereportdemo.api.systemparam;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.api.systemparam.SystemParamApi;
import com.integranova.spring.expensereportdemo.persistence.oid.SystemParamOid;
import com.integranova.spring.expensereportdemo.persistence.SystemParam;
import com.integranova.spring.expensereportdemo.service.SystemParamService;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationRequestViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.QueryRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ServiceResponse;
import com.integranova.spring.expensereportdemo.viewmodel.systemparam.ds.DSSystemParams;
import com.integranova.spring.expensereportdemo.viewmodel.systemparam.piu.PIUSystemParamsResponse;
import com.integranova.spring.expensereportdemo.viewmodel.systemparam.siu.CreateinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.systemparam.siu.DeleteinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.systemparam.siu.EditinstanceRequest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mock;

@RunWith(MockitoJUnitRunner.class)
public class SystemParamApiTest {

    @Mock
    private SystemParamService mockSystemParamService;

    @InjectMocks
    private SystemParamApi instanceSystemParamApi;

    // testGetDSSystemParams
    private static String testGetDSSystemParamsArg1;
    private static String testGetDSSystemParamsArg2;
    private static String testGetDSSystemParamsArg3;
    private static DSSystemParams testGetDSSystemParamsResult;

    // testGetDSSystemParams2
    private static String testGetDSSystemParams2Arg1;
    private static String testGetDSSystemParams2Arg2;
    private static String testGetDSSystemParams2Arg3;
    private static DSSystemParams testGetDSSystemParams2Result;

    // testGetDSSystemParams3
    private static String testGetDSSystemParams3Arg1;
    private static String testGetDSSystemParams3Arg2;
    private static String testGetDSSystemParams3Arg3;
    private static DSSystemParams testGetDSSystemParams3Result;

    // testGetDSSystemParams4
    private static String testGetDSSystemParams4Arg1;
    private static String testGetDSSystemParams4Arg2;
    private static String testGetDSSystemParams4Arg3;
    private static DSSystemParams testGetDSSystemParams4Result;

    // testGetSystemParam
    private static String testGetSystemParamArg1;
    private static SystemParam testGetSystemParamResult;

    // testGetSystemParamDynamic
    private static QueryRequest testGetSystemParamDynamicArg1;
    private static SystemParamOid mockGetSystemParamDynamicArg1;
    private static String mockGetSystemParamDynamicArg2;
    private static InstanceResponseViewModel testGetSystemParamDynamicResult;

    // testGetSystemParamWithDisplaySetDynamic
    private static QueryRequest testGetSystemParamWithDisplaySetDynamicArg1;
    private static PreloadResponseViewModel testGetSystemParamWithDisplaySetDynamicResult;

    // testGetSystemParamPopulationDynamic
    private static QueryRequest testGetSystemParamPopulationDynamicArg1;
    private static PopulationResponseViewModel testGetSystemParamPopulationDynamicResult;

    // testSystemParamCreateinstance
    private static CreateinstanceRequest testSystemParamCreateinstanceArg1;
    private static ServiceResponse testSystemParamCreateinstanceResult;

    // testSystemParamDeleteinstance
    private static DeleteinstanceRequest testSystemParamDeleteinstanceArg1;
    private static ServiceResponse testSystemParamDeleteinstanceResult;

    // testSystemParamEditinstance
    private static EditinstanceRequest testSystemParamEditinstanceArg1;
    private static ServiceResponse testSystemParamEditinstanceResult;

    // testpiuPIUSystemParams
    private static PopulationRequestViewModel testpiuPIUSystemParamsArg1;
    private static QueryRequest testpiuPIUSystemParamsMockArg1;
    private static List<DSSystemParams> testpiuPIUSystemParamsMockResult;
    private static PIUSystemParamsResponse testpiuPIUSystemParamsResult;

    // testpiuPIUSystemParams2
    private static PopulationRequestViewModel testpiuPIUSystemParams2Arg1;
    private static QueryRequest testpiuPIUSystemParams2MockArg1;
    private static List<DSSystemParams> testpiuPIUSystemParams2MockResult;
    private static PIUSystemParamsResponse testpiuPIUSystemParams2Result;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testGetDSSystemParams();
        setUpMockData4testGetDSSystemParams2();
        setUpMockData4testGetDSSystemParams3();
        setUpMockData4testGetDSSystemParams4();
        setUpMockData4testGetSystemParam();
        setUpMockData4testGetSystemParamDynamic();
        setUpMockData4testGetSystemParamWithDisplaySetDynamic();
        setUpMockData4testGetSystemParamPopulationDynamic();
        setUpMockData4testSystemParamCreateinstance();
        setUpMockData4testSystemParamDeleteinstance();
        setUpMockData4testSystemParamEditinstance();
        setUpMockData4testpiuPIUSystemParams();
        setUpMockData4testpiuPIUSystemParams2();
    }

    private static void setUpMockData4testGetDSSystemParams() {
        testGetDSSystemParamsArg1 = "";
        testGetDSSystemParamsArg2 = "";
        testGetDSSystemParamsArg3 = "";
        testGetDSSystemParamsResult = new DSSystemParams();
    }

    private static void setUpMockData4testGetDSSystemParams2() {
        testGetDSSystemParams2Arg1 = "";
        testGetDSSystemParams2Arg2 = null;
        testGetDSSystemParams2Arg3 = null;
        testGetDSSystemParams2Result = testGetDSSystemParamsResult;
    }

    private static void setUpMockData4testGetDSSystemParams3() {
        testGetDSSystemParams3Arg1 = "";
        testGetDSSystemParams3Arg2 = null;
        testGetDSSystemParams3Arg3 = "";
        testGetDSSystemParams3Result = testGetDSSystemParamsResult;
    }

    private static void setUpMockData4testGetDSSystemParams4() {
        testGetDSSystemParams4Arg1 = "";
        testGetDSSystemParams4Arg2 = "";
        testGetDSSystemParams4Arg3 = null;
        testGetDSSystemParams4Result = testGetDSSystemParamsResult;
    }

    private static void setUpMockData4testGetSystemParam() {
        testGetSystemParamArg1 = "";
        testGetSystemParamResult = new SystemParam();
    }

    private static void setUpMockData4testGetSystemParamDynamic() {
        mockGetSystemParamDynamicArg1 = new SystemParamOid();
        mockGetSystemParamDynamicArg2 = "";
        testGetSystemParamDynamicArg1 = new QueryRequest();
        testGetSystemParamDynamicResult = new InstanceResponseViewModel();
    }

    private static void setUpMockData4testGetSystemParamWithDisplaySetDynamic() {
        testGetSystemParamWithDisplaySetDynamicArg1 = new QueryRequest();
        testGetSystemParamWithDisplaySetDynamicArg1.setDisplaySetName("testGetSystemParamWithDisplaySetDynamicArg1");
        testGetSystemParamWithDisplaySetDynamicResult = new PreloadResponseViewModel();
    }

    private static void setUpMockData4testGetSystemParamPopulationDynamic() {
        testGetSystemParamPopulationDynamicArg1 = new QueryRequest();
        testGetSystemParamPopulationDynamicArg1.setDisplaySetName("testGetSystemParamPopulationDynamicArg1");
        testGetSystemParamPopulationDynamicResult = new PopulationResponseViewModel();
    }

    private static void setUpMockData4testSystemParamCreateinstance() {
        testSystemParamCreateinstanceArg1 = new CreateinstanceRequest();
        testSystemParamCreateinstanceResult = new ServiceResponse();
    }

    private static void setUpMockData4testSystemParamDeleteinstance() {
        testSystemParamDeleteinstanceArg1 = new DeleteinstanceRequest();
        testSystemParamDeleteinstanceResult = new ServiceResponse();
    }

    private static void setUpMockData4testSystemParamEditinstance() {
        testSystemParamEditinstanceArg1 = new EditinstanceRequest();
        testSystemParamEditinstanceResult = new ServiceResponse();
    }

    private static void setUpMockData4testpiuPIUSystemParams() {
        testpiuPIUSystemParamsMockArg1 = new QueryRequest();
        testpiuPIUSystemParamsMockArg1.setPageSize(0);
        testpiuPIUSystemParamsMockResult = new ArrayList<>();
        testpiuPIUSystemParamsArg1 = mock(PopulationRequestViewModel.class);
        testpiuPIUSystemParamsResult = new PIUSystemParamsResponse();
    }

    private static void setUpMockData4testpiuPIUSystemParams2() {
        testpiuPIUSystemParams2MockArg1 = new QueryRequest();
        testpiuPIUSystemParams2MockArg1.setPageSize(1);
        testpiuPIUSystemParams2MockResult = new ArrayList<>();
        testpiuPIUSystemParams2MockResult.add(new DSSystemParams());
        testpiuPIUSystemParams2Arg1 = mock(PopulationRequestViewModel.class);
        testpiuPIUSystemParams2Arg1.setPageSize(1);
        testpiuPIUSystemParams2Result = new PIUSystemParamsResponse();
        testpiuPIUSystemParams2Result.setTotalItems(1);
    }

    @Before
    public void setUp() {

        when(mockSystemParamService.getDSSystemParams(testGetDSSystemParamsArg1, testGetDSSystemParamsArg2, testGetDSSystemParamsArg3)).thenReturn(testGetDSSystemParamsResult);

        when(mockSystemParamService.getById(testGetSystemParamArg1)).thenReturn(testGetSystemParamResult);

        when(mockSystemParamService.getSystemParamDynamic(mockGetSystemParamDynamicArg1, mockGetSystemParamDynamicArg2)).thenReturn(testGetSystemParamDynamicResult);

        when(mockSystemParamService.getDynamic(testGetSystemParamWithDisplaySetDynamicArg1)).thenReturn(testGetSystemParamWithDisplaySetDynamicResult);

        when(mockSystemParamService.getDynamic(testGetSystemParamPopulationDynamicArg1)).thenReturn(testGetSystemParamPopulationDynamicResult);

        when(mockSystemParamService.createinstance(testSystemParamCreateinstanceArg1)).thenReturn(testSystemParamCreateinstanceResult);

        when(mockSystemParamService.deleteinstance(testSystemParamDeleteinstanceArg1)).thenReturn(testSystemParamDeleteinstanceResult);

        when(mockSystemParamService.editinstance(testSystemParamEditinstanceArg1)).thenReturn(testSystemParamEditinstanceResult);

        when(testpiuPIUSystemParamsArg1.buildQueryRequest()).thenReturn(testpiuPIUSystemParamsMockArg1);

        when(mockSystemParamService.piuPIUSystemParams(testpiuPIUSystemParamsMockArg1)).thenReturn(testpiuPIUSystemParamsMockResult);

        when(testpiuPIUSystemParams2Arg1.buildQueryRequest()).thenReturn(testpiuPIUSystemParams2MockArg1);

        when(mockSystemParamService.piuPIUSystemParams(testpiuPIUSystemParams2MockArg1)).thenReturn(testpiuPIUSystemParams2MockResult);

        when(mockSystemParamService.getCount4PIUSystemParams(testpiuPIUSystemParams2MockArg1)).thenReturn(1);
    }

    @Test
    public void testGetDSSystemParams() {
        assertEquals(testGetDSSystemParamsResult, instanceSystemParamApi.getDSSystemParams(testGetDSSystemParamsArg1, testGetDSSystemParamsArg2, testGetDSSystemParamsArg3));
    }

    @Test
    public void testGetDSSystemParams2() {
        assertEquals(testGetDSSystemParams2Result, instanceSystemParamApi.getDSSystemParams(testGetDSSystemParams2Arg1, testGetDSSystemParams2Arg2, testGetDSSystemParams2Arg3));
    }

    @Test
    public void testGetDSSystemParams3() {
        assertEquals(testGetDSSystemParams3Result, instanceSystemParamApi.getDSSystemParams(testGetDSSystemParams3Arg1, testGetDSSystemParams3Arg2, testGetDSSystemParams3Arg3));
    }

    @Test
    public void testGetDSSystemParams4() {
        assertEquals(testGetDSSystemParams4Result, instanceSystemParamApi.getDSSystemParams(testGetDSSystemParams4Arg1, testGetDSSystemParams4Arg2, testGetDSSystemParams4Arg3));
    }

    @Test
    public void testGetSystemParam() {
        assertEquals(testGetSystemParamResult, instanceSystemParamApi.getSystemParam(testGetSystemParamArg1));
    }

    @Test
    public void testGetSystemParamDynamic() {
        assertEquals(testGetSystemParamDynamicResult, instanceSystemParamApi.getSystemParamDynamic(testGetSystemParamDynamicArg1));
    }

    @Test
    public void testGetSystemParamWithDisplaySetDynamic() {
        assertEquals(testGetSystemParamWithDisplaySetDynamicResult, instanceSystemParamApi.getSystemParamWithDisplaySetDynamic(testGetSystemParamWithDisplaySetDynamicArg1));
    }

    @Test
    public void testGetSystemParamPopulationDynamic() {
        assertEquals(testGetSystemParamPopulationDynamicResult, instanceSystemParamApi.getSystemParamPopulationDynamic(testGetSystemParamPopulationDynamicArg1));
    }

    @Test
    public void testSystemParamCreateinstance() {
        assertEquals(testSystemParamCreateinstanceResult, instanceSystemParamApi.systemParamCreateinstance(testSystemParamCreateinstanceArg1));
    }

    @Test
    public void testSystemParamDeleteinstance() {
        assertEquals(testSystemParamDeleteinstanceResult, instanceSystemParamApi.systemParamDeleteinstance(testSystemParamDeleteinstanceArg1));
    }

    @Test
    public void testSystemParamEditinstance() {
        assertEquals(testSystemParamEditinstanceResult, instanceSystemParamApi.systemParamEditinstance(testSystemParamEditinstanceArg1));
    }

    @Test
    public void testpiuPIUSystemParams() {
        assertEquals(testpiuPIUSystemParamsResult.getTotalItems(), instanceSystemParamApi.piuPIUSystemParams(testpiuPIUSystemParamsArg1).getTotalItems());
    }

    @Test
    public void testpiuPIUSystemParams2() {
        assertEquals(testpiuPIUSystemParams2Result.getTotalItems(), instanceSystemParamApi.piuPIUSystemParams(testpiuPIUSystemParams2Arg1).getTotalItems());
    }
}
