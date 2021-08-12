package com.integranova.spring.expensereportdemo.api.expensecurrency;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.api.expensecurrency.ExpenseCurrencyApi;
import com.integranova.spring.expensereportdemo.persistence.ExpenseCurrency;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseCurrencyOid;
import com.integranova.spring.expensereportdemo.service.ExpenseCurrencyService;
import com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.ds.DSExpenseCurrency;
import com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.ds.DSExpenseCurrencySup;
import com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.piu.PIUExpenseCurrencyResponse;
import com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.CreateinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.DeleteinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.EditExchangeRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.EditinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.ResetExchangeRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.TEDITEXCHANGERequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.TNEWRequest;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationRequestViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.QueryRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ServiceResponse;
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
public class ExpenseCurrencyApiTest {

    @Mock
    private ExpenseCurrencyService mockExpenseCurrencyService;

    @InjectMocks
    private ExpenseCurrencyApi instanceExpenseCurrencyApi;

    // testGetDSExpenseCurrency
    private static String testGetDSExpenseCurrencyArg1;
    private static String testGetDSExpenseCurrencyArg2;
    private static String testGetDSExpenseCurrencyArg3;
    private static DSExpenseCurrency testGetDSExpenseCurrencyResult;

    // testGetDSExpenseCurrency2
    private static String testGetDSExpenseCurrency2Arg1;
    private static String testGetDSExpenseCurrency2Arg2;
    private static String testGetDSExpenseCurrency2Arg3;
    private static DSExpenseCurrency testGetDSExpenseCurrency2Result;

    // testGetDSExpenseCurrency3
    private static String testGetDSExpenseCurrency3Arg1;
    private static String testGetDSExpenseCurrency3Arg2;
    private static String testGetDSExpenseCurrency3Arg3;
    private static DSExpenseCurrency testGetDSExpenseCurrency3Result;

    // testGetDSExpenseCurrency4
    private static String testGetDSExpenseCurrency4Arg1;
    private static String testGetDSExpenseCurrency4Arg2;
    private static String testGetDSExpenseCurrency4Arg3;
    private static DSExpenseCurrency testGetDSExpenseCurrency4Result;

    // testGetDSExpenseCurrencySup
    private static String testGetDSExpenseCurrencySupArg1;
    private static String testGetDSExpenseCurrencySupArg2;
    private static String testGetDSExpenseCurrencySupArg3;
    private static DSExpenseCurrencySup testGetDSExpenseCurrencySupResult;

    // testGetDSExpenseCurrencySup2
    private static String testGetDSExpenseCurrencySup2Arg1;
    private static String testGetDSExpenseCurrencySup2Arg2;
    private static String testGetDSExpenseCurrencySup2Arg3;
    private static DSExpenseCurrencySup testGetDSExpenseCurrencySup2Result;

    // testGetDSExpenseCurrencySup3
    private static String testGetDSExpenseCurrencySup3Arg1;
    private static String testGetDSExpenseCurrencySup3Arg2;
    private static String testGetDSExpenseCurrencySup3Arg3;
    private static DSExpenseCurrencySup testGetDSExpenseCurrencySup3Result;

    // testGetDSExpenseCurrencySup4
    private static String testGetDSExpenseCurrencySup4Arg1;
    private static String testGetDSExpenseCurrencySup4Arg2;
    private static String testGetDSExpenseCurrencySup4Arg3;
    private static DSExpenseCurrencySup testGetDSExpenseCurrencySup4Result;

    // testGetExpenseCurrency
    private static String testGetExpenseCurrencyArg1;
    private static ExpenseCurrency testGetExpenseCurrencyResult;

    // testGetExpenseCurrencyDynamic
    private static QueryRequest testGetExpenseCurrencyDynamicArg1;
    private static ExpenseCurrencyOid mockGetExpenseCurrencyDynamicArg1;
    private static String mockGetExpenseCurrencyDynamicArg2;
    private static InstanceResponseViewModel testGetExpenseCurrencyDynamicResult;

    // testGetExpenseCurrencyPreload
    private static QueryRequest testGetExpenseCurrencyPreloadArg1;
    private static List<PreloadViewModel> testGetExpenseCurrencyPreloadResult;

    // testGetExpenseCurrencyWithDisplaySetDynamic
    private static QueryRequest testGetExpenseCurrencyWithDisplaySetDynamicArg1;
    private static PreloadResponseViewModel testGetExpenseCurrencyWithDisplaySetDynamicResult;

    // testGetExpenseCurrencyPopulationDynamic
    private static QueryRequest testGetExpenseCurrencyPopulationDynamicArg1;
    private static PopulationResponseViewModel testGetExpenseCurrencyPopulationDynamicResult;

    // testExpenseCurrencyCreateinstance
    private static CreateinstanceRequest testExpenseCurrencyCreateinstanceArg1;
    private static ServiceResponse testExpenseCurrencyCreateinstanceResult;

    // testExpenseCurrencyDeleteinstance
    private static DeleteinstanceRequest testExpenseCurrencyDeleteinstanceArg1;
    private static ServiceResponse testExpenseCurrencyDeleteinstanceResult;

    // testExpenseCurrencyEditinstance
    private static EditinstanceRequest testExpenseCurrencyEditinstanceArg1;
    private static ServiceResponse testExpenseCurrencyEditinstanceResult;

    // testExpenseCurrencyResetExchange
    private static ResetExchangeRequest testExpenseCurrencyResetExchangeArg1;
    private static ServiceResponse testExpenseCurrencyResetExchangeResult;

    // testExpenseCurrencyEditExchange
    private static EditExchangeRequest testExpenseCurrencyEditExchangeArg1;
    private static ServiceResponse testExpenseCurrencyEditExchangeResult;

    // testExpenseCurrencyTNEW
    private static TNEWRequest testExpenseCurrencyTNEWArg1;
    private static ServiceResponse testExpenseCurrencyTNEWResult;

    // testExpenseCurrencyTEDITEXCHANGE
    private static TEDITEXCHANGERequest testExpenseCurrencyTEDITEXCHANGEArg1;
    private static ServiceResponse testExpenseCurrencyTEDITEXCHANGEResult;

    // testiiuIIUExpenseCurrency
    private static ExpenseCurrencyOid testiiuIIUExpenseCurrencyArg1;
    private static DSExpenseCurrency testiiuIIUExpenseCurrencyResult;

    // testpiuPIUExpenseCurrency
    private static PopulationRequestViewModel testpiuPIUExpenseCurrencyArg1;
    private static QueryRequest testpiuPIUExpenseCurrencyMockArg1;
    private static List<DSExpenseCurrency> testpiuPIUExpenseCurrencyMockResult;
    private static PIUExpenseCurrencyResponse testpiuPIUExpenseCurrencyResult;

    // testpiuPIUExpenseCurrency2
    private static PopulationRequestViewModel testpiuPIUExpenseCurrency2Arg1;
    private static QueryRequest testpiuPIUExpenseCurrency2MockArg1;
    private static List<DSExpenseCurrency> testpiuPIUExpenseCurrency2MockResult;
    private static PIUExpenseCurrencyResponse testpiuPIUExpenseCurrency2Result;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testGetDSExpenseCurrency();
        setUpMockData4testGetDSExpenseCurrency2();
        setUpMockData4testGetDSExpenseCurrency3();
        setUpMockData4testGetDSExpenseCurrency4();
        setUpMockData4testGetDSExpenseCurrencySup();
        setUpMockData4testGetDSExpenseCurrencySup2();
        setUpMockData4testGetDSExpenseCurrencySup3();
        setUpMockData4testGetDSExpenseCurrencySup4();
        setUpMockData4testGetExpenseCurrency();
        setUpMockData4testGetExpenseCurrencyDynamic();
        setUpMockData4testGetExpenseCurrencyPreload();
        setUpMockData4testGetExpenseCurrencyWithDisplaySetDynamic();
        setUpMockData4testGetExpenseCurrencyPopulationDynamic();
        setUpMockData4testExpenseCurrencyCreateinstance();
        setUpMockData4testExpenseCurrencyDeleteinstance();
        setUpMockData4testExpenseCurrencyEditinstance();
        setUpMockData4testExpenseCurrencyResetExchange();
        setUpMockData4testExpenseCurrencyEditExchange();
        setUpMockData4testExpenseCurrencyTNEW();
        setUpMockData4testExpenseCurrencyTEDITEXCHANGE();
        setUpMockData4testiiuIIUExpenseCurrency();
        setUpMockData4testpiuPIUExpenseCurrency();
        setUpMockData4testpiuPIUExpenseCurrency2();
    }

    private static void setUpMockData4testGetDSExpenseCurrency() {
        testGetDSExpenseCurrencyArg1 = "";
        testGetDSExpenseCurrencyArg2 = "";
        testGetDSExpenseCurrencyArg3 = "";
        testGetDSExpenseCurrencyResult = new DSExpenseCurrency();
    }

    private static void setUpMockData4testGetDSExpenseCurrency2() {
        testGetDSExpenseCurrency2Arg1 = "";
        testGetDSExpenseCurrency2Arg2 = null;
        testGetDSExpenseCurrency2Arg3 = null;
        testGetDSExpenseCurrency2Result = testGetDSExpenseCurrencyResult;
    }

    private static void setUpMockData4testGetDSExpenseCurrency3() {
        testGetDSExpenseCurrency3Arg1 = "";
        testGetDSExpenseCurrency3Arg2 = null;
        testGetDSExpenseCurrency3Arg3 = "";
        testGetDSExpenseCurrency3Result = testGetDSExpenseCurrencyResult;
    }

    private static void setUpMockData4testGetDSExpenseCurrency4() {
        testGetDSExpenseCurrency4Arg1 = "";
        testGetDSExpenseCurrency4Arg2 = "";
        testGetDSExpenseCurrency4Arg3 = null;
        testGetDSExpenseCurrency4Result = testGetDSExpenseCurrencyResult;
    }

    private static void setUpMockData4testGetDSExpenseCurrencySup() {
        testGetDSExpenseCurrencySupArg1 = "";
        testGetDSExpenseCurrencySupArg2 = "";
        testGetDSExpenseCurrencySupArg3 = "";
        testGetDSExpenseCurrencySupResult = new DSExpenseCurrencySup();
    }

    private static void setUpMockData4testGetDSExpenseCurrencySup2() {
        testGetDSExpenseCurrencySup2Arg1 = "";
        testGetDSExpenseCurrencySup2Arg2 = null;
        testGetDSExpenseCurrencySup2Arg3 = null;
        testGetDSExpenseCurrencySup2Result = testGetDSExpenseCurrencySupResult;
    }

    private static void setUpMockData4testGetDSExpenseCurrencySup3() {
        testGetDSExpenseCurrencySup3Arg1 = "";
        testGetDSExpenseCurrencySup3Arg2 = null;
        testGetDSExpenseCurrencySup3Arg3 = "";
        testGetDSExpenseCurrencySup3Result = testGetDSExpenseCurrencySupResult;
    }

    private static void setUpMockData4testGetDSExpenseCurrencySup4() {
        testGetDSExpenseCurrencySup4Arg1 = "";
        testGetDSExpenseCurrencySup4Arg2 = "";
        testGetDSExpenseCurrencySup4Arg3 = null;
        testGetDSExpenseCurrencySup4Result = testGetDSExpenseCurrencySupResult;
    }

    private static void setUpMockData4testGetExpenseCurrency() {
        testGetExpenseCurrencyArg1 = "";
        testGetExpenseCurrencyResult = new ExpenseCurrency();
    }

    private static void setUpMockData4testGetExpenseCurrencyDynamic() {
        mockGetExpenseCurrencyDynamicArg1 = new ExpenseCurrencyOid();
        mockGetExpenseCurrencyDynamicArg2 = "";
        testGetExpenseCurrencyDynamicArg1 = new QueryRequest();
        testGetExpenseCurrencyDynamicResult = new InstanceResponseViewModel();
    }

    private static void setUpMockData4testGetExpenseCurrencyPreload() {
        testGetExpenseCurrencyPreloadArg1 = new QueryRequest();
        testGetExpenseCurrencyPreloadResult = new ArrayList<>();
    }

    private static void setUpMockData4testGetExpenseCurrencyWithDisplaySetDynamic() {
        testGetExpenseCurrencyWithDisplaySetDynamicArg1 = new QueryRequest();
        testGetExpenseCurrencyWithDisplaySetDynamicArg1.setDisplaySetName("testGetExpenseCurrencyWithDisplaySetDynamicArg1");
        testGetExpenseCurrencyWithDisplaySetDynamicResult = new PreloadResponseViewModel();
    }

    private static void setUpMockData4testGetExpenseCurrencyPopulationDynamic() {
        testGetExpenseCurrencyPopulationDynamicArg1 = new QueryRequest();
        testGetExpenseCurrencyPopulationDynamicArg1.setDisplaySetName("testGetExpenseCurrencyPopulationDynamicArg1");
        testGetExpenseCurrencyPopulationDynamicResult = new PopulationResponseViewModel();
    }

    private static void setUpMockData4testExpenseCurrencyCreateinstance() {
        testExpenseCurrencyCreateinstanceArg1 = new CreateinstanceRequest();
        testExpenseCurrencyCreateinstanceResult = new ServiceResponse();
    }

    private static void setUpMockData4testExpenseCurrencyDeleteinstance() {
        testExpenseCurrencyDeleteinstanceArg1 = new DeleteinstanceRequest();
        testExpenseCurrencyDeleteinstanceResult = new ServiceResponse();
    }

    private static void setUpMockData4testExpenseCurrencyEditinstance() {
        testExpenseCurrencyEditinstanceArg1 = new EditinstanceRequest();
        testExpenseCurrencyEditinstanceResult = new ServiceResponse();
    }

    private static void setUpMockData4testExpenseCurrencyResetExchange() {
        testExpenseCurrencyResetExchangeArg1 = new ResetExchangeRequest();
        testExpenseCurrencyResetExchangeResult = new ServiceResponse();
    }

    private static void setUpMockData4testExpenseCurrencyEditExchange() {
        testExpenseCurrencyEditExchangeArg1 = new EditExchangeRequest();
        testExpenseCurrencyEditExchangeResult = new ServiceResponse();
    }

    private static void setUpMockData4testExpenseCurrencyTNEW() {
        testExpenseCurrencyTNEWArg1 = new TNEWRequest();
        testExpenseCurrencyTNEWResult = new ServiceResponse();
    }

    private static void setUpMockData4testExpenseCurrencyTEDITEXCHANGE() {
        testExpenseCurrencyTEDITEXCHANGEArg1 = new TEDITEXCHANGERequest();
        testExpenseCurrencyTEDITEXCHANGEResult = new ServiceResponse();
    }

    private static void setUpMockData4testiiuIIUExpenseCurrency() {
        testiiuIIUExpenseCurrencyArg1 = new ExpenseCurrencyOid();
        testiiuIIUExpenseCurrencyResult = new DSExpenseCurrency();
    }

    private static void setUpMockData4testpiuPIUExpenseCurrency() {
        testpiuPIUExpenseCurrencyMockArg1 = new QueryRequest();
        testpiuPIUExpenseCurrencyMockArg1.setPageSize(0);
        testpiuPIUExpenseCurrencyMockResult = new ArrayList<>();
        testpiuPIUExpenseCurrencyArg1 = mock(PopulationRequestViewModel.class);
        testpiuPIUExpenseCurrencyResult = new PIUExpenseCurrencyResponse();
    }

    private static void setUpMockData4testpiuPIUExpenseCurrency2() {
        testpiuPIUExpenseCurrency2MockArg1 = new QueryRequest();
        testpiuPIUExpenseCurrency2MockArg1.setPageSize(1);
        testpiuPIUExpenseCurrency2MockResult = new ArrayList<>();
        testpiuPIUExpenseCurrency2MockResult.add(new DSExpenseCurrency());
        testpiuPIUExpenseCurrency2Arg1 = mock(PopulationRequestViewModel.class);
        testpiuPIUExpenseCurrency2Arg1.setPageSize(1);
        testpiuPIUExpenseCurrency2Result = new PIUExpenseCurrencyResponse();
        testpiuPIUExpenseCurrency2Result.setTotalItems(1);
    }

    @Before
    public void setUp() {

        when(mockExpenseCurrencyService.getDSExpenseCurrency(testGetDSExpenseCurrencyArg1, testGetDSExpenseCurrencyArg2, testGetDSExpenseCurrencyArg3)).thenReturn(testGetDSExpenseCurrencyResult);

        when(mockExpenseCurrencyService.getDSExpenseCurrencySup(testGetDSExpenseCurrencySupArg1, testGetDSExpenseCurrencySupArg2, testGetDSExpenseCurrencySupArg3)).thenReturn(testGetDSExpenseCurrencySupResult);

        when(mockExpenseCurrencyService.getById(testGetExpenseCurrencyArg1)).thenReturn(testGetExpenseCurrencyResult);

        when(mockExpenseCurrencyService.getExpenseCurrencyDynamic(mockGetExpenseCurrencyDynamicArg1, mockGetExpenseCurrencyDynamicArg2)).thenReturn(testGetExpenseCurrencyDynamicResult);

        when(mockExpenseCurrencyService.getPreload(testGetExpenseCurrencyPreloadArg1)).thenReturn(testGetExpenseCurrencyPreloadResult);

        when(mockExpenseCurrencyService.getDynamic(testGetExpenseCurrencyWithDisplaySetDynamicArg1)).thenReturn(testGetExpenseCurrencyWithDisplaySetDynamicResult);

        when(mockExpenseCurrencyService.getDynamic(testGetExpenseCurrencyPopulationDynamicArg1)).thenReturn(testGetExpenseCurrencyPopulationDynamicResult);

        when(mockExpenseCurrencyService.createinstance(testExpenseCurrencyCreateinstanceArg1)).thenReturn(testExpenseCurrencyCreateinstanceResult);

        when(mockExpenseCurrencyService.deleteinstance(testExpenseCurrencyDeleteinstanceArg1)).thenReturn(testExpenseCurrencyDeleteinstanceResult);

        when(mockExpenseCurrencyService.editinstance(testExpenseCurrencyEditinstanceArg1)).thenReturn(testExpenseCurrencyEditinstanceResult);

        when(mockExpenseCurrencyService.resetExchange(testExpenseCurrencyResetExchangeArg1)).thenReturn(testExpenseCurrencyResetExchangeResult);

        when(mockExpenseCurrencyService.editExchange(testExpenseCurrencyEditExchangeArg1)).thenReturn(testExpenseCurrencyEditExchangeResult);

        when(mockExpenseCurrencyService.tNEW(testExpenseCurrencyTNEWArg1)).thenReturn(testExpenseCurrencyTNEWResult);

        when(mockExpenseCurrencyService.tEDITEXCHANGE(testExpenseCurrencyTEDITEXCHANGEArg1)).thenReturn(testExpenseCurrencyTEDITEXCHANGEResult);

        when(mockExpenseCurrencyService.iIUExpenseCurrency(testiiuIIUExpenseCurrencyArg1)).thenReturn(testiiuIIUExpenseCurrencyResult);

        when(testpiuPIUExpenseCurrencyArg1.buildQueryRequest()).thenReturn(testpiuPIUExpenseCurrencyMockArg1);

        when(mockExpenseCurrencyService.piuPIUExpenseCurrency(testpiuPIUExpenseCurrencyMockArg1)).thenReturn(testpiuPIUExpenseCurrencyMockResult);

        when(testpiuPIUExpenseCurrency2Arg1.buildQueryRequest()).thenReturn(testpiuPIUExpenseCurrency2MockArg1);

        when(mockExpenseCurrencyService.piuPIUExpenseCurrency(testpiuPIUExpenseCurrency2MockArg1)).thenReturn(testpiuPIUExpenseCurrency2MockResult);

        when(mockExpenseCurrencyService.getCount4PIUExpenseCurrency(testpiuPIUExpenseCurrency2MockArg1)).thenReturn(1);
    }

    @Test
    public void testGetDSExpenseCurrency() {
        assertEquals(testGetDSExpenseCurrencyResult, instanceExpenseCurrencyApi.getDSExpenseCurrency(testGetDSExpenseCurrencyArg1, testGetDSExpenseCurrencyArg2, testGetDSExpenseCurrencyArg3));
    }

    @Test
    public void testGetDSExpenseCurrency2() {
        assertEquals(testGetDSExpenseCurrency2Result, instanceExpenseCurrencyApi.getDSExpenseCurrency(testGetDSExpenseCurrency2Arg1, testGetDSExpenseCurrency2Arg2, testGetDSExpenseCurrency2Arg3));
    }

    @Test
    public void testGetDSExpenseCurrency3() {
        assertEquals(testGetDSExpenseCurrency3Result, instanceExpenseCurrencyApi.getDSExpenseCurrency(testGetDSExpenseCurrency3Arg1, testGetDSExpenseCurrency3Arg2, testGetDSExpenseCurrency3Arg3));
    }

    @Test
    public void testGetDSExpenseCurrency4() {
        assertEquals(testGetDSExpenseCurrency4Result, instanceExpenseCurrencyApi.getDSExpenseCurrency(testGetDSExpenseCurrency4Arg1, testGetDSExpenseCurrency4Arg2, testGetDSExpenseCurrency4Arg3));
    }

    @Test
    public void testGetDSExpenseCurrencySup() {
        assertEquals(testGetDSExpenseCurrencySupResult, instanceExpenseCurrencyApi.getDSExpenseCurrencySup(testGetDSExpenseCurrencySupArg1, testGetDSExpenseCurrencySupArg2, testGetDSExpenseCurrencySupArg3));
    }

    @Test
    public void testGetDSExpenseCurrencySup2() {
        assertEquals(testGetDSExpenseCurrencySup2Result, instanceExpenseCurrencyApi.getDSExpenseCurrencySup(testGetDSExpenseCurrencySup2Arg1, testGetDSExpenseCurrencySup2Arg2, testGetDSExpenseCurrencySup2Arg3));
    }

    @Test
    public void testGetDSExpenseCurrencySup3() {
        assertEquals(testGetDSExpenseCurrencySup3Result, instanceExpenseCurrencyApi.getDSExpenseCurrencySup(testGetDSExpenseCurrencySup3Arg1, testGetDSExpenseCurrencySup3Arg2, testGetDSExpenseCurrencySup3Arg3));
    }

    @Test
    public void testGetDSExpenseCurrencySup4() {
        assertEquals(testGetDSExpenseCurrencySup4Result, instanceExpenseCurrencyApi.getDSExpenseCurrencySup(testGetDSExpenseCurrencySup4Arg1, testGetDSExpenseCurrencySup4Arg2, testGetDSExpenseCurrencySup4Arg3));
    }

    @Test
    public void testGetExpenseCurrency() {
        assertEquals(testGetExpenseCurrencyResult, instanceExpenseCurrencyApi.getExpenseCurrency(testGetExpenseCurrencyArg1));
    }

    @Test
    public void testGetExpenseCurrencyDynamic() {
        assertEquals(testGetExpenseCurrencyDynamicResult, instanceExpenseCurrencyApi.getExpenseCurrencyDynamic(testGetExpenseCurrencyDynamicArg1));
    }

    @Test
    public void testGetExpenseCurrencyPreload() {
        assertEquals(testGetExpenseCurrencyPreloadResult, instanceExpenseCurrencyApi.getExpenseCurrencyPreload(testGetExpenseCurrencyPreloadArg1));
    }

    @Test
    public void testGetExpenseCurrencyWithDisplaySetDynamic() {
        assertEquals(testGetExpenseCurrencyWithDisplaySetDynamicResult, instanceExpenseCurrencyApi.getExpenseCurrencyWithDisplaySetDynamic(testGetExpenseCurrencyWithDisplaySetDynamicArg1));
    }

    @Test
    public void testGetExpenseCurrencyPopulationDynamic() {
        assertEquals(testGetExpenseCurrencyPopulationDynamicResult, instanceExpenseCurrencyApi.getExpenseCurrencyPopulationDynamic(testGetExpenseCurrencyPopulationDynamicArg1));
    }

    @Test
    public void testExpenseCurrencyCreateinstance() {
        assertEquals(testExpenseCurrencyCreateinstanceResult, instanceExpenseCurrencyApi.expenseCurrencyCreateinstance(testExpenseCurrencyCreateinstanceArg1));
    }

    @Test
    public void testExpenseCurrencyDeleteinstance() {
        assertEquals(testExpenseCurrencyDeleteinstanceResult, instanceExpenseCurrencyApi.expenseCurrencyDeleteinstance(testExpenseCurrencyDeleteinstanceArg1));
    }

    @Test
    public void testExpenseCurrencyEditinstance() {
        assertEquals(testExpenseCurrencyEditinstanceResult, instanceExpenseCurrencyApi.expenseCurrencyEditinstance(testExpenseCurrencyEditinstanceArg1));
    }

    @Test
    public void testExpenseCurrencyResetExchange() {
        assertEquals(testExpenseCurrencyResetExchangeResult, instanceExpenseCurrencyApi.expenseCurrencyResetExchange(testExpenseCurrencyResetExchangeArg1));
    }

    @Test
    public void testExpenseCurrencyEditExchange() {
        assertEquals(testExpenseCurrencyEditExchangeResult, instanceExpenseCurrencyApi.expenseCurrencyEditExchange(testExpenseCurrencyEditExchangeArg1));
    }

    @Test
    public void testExpenseCurrencyTNEW() {
        assertEquals(testExpenseCurrencyTNEWResult, instanceExpenseCurrencyApi.expenseCurrencyTNEW(testExpenseCurrencyTNEWArg1));
    }

    @Test
    public void testExpenseCurrencyTEDITEXCHANGE() {
        assertEquals(testExpenseCurrencyTEDITEXCHANGEResult, instanceExpenseCurrencyApi.expenseCurrencyTEDITEXCHANGE(testExpenseCurrencyTEDITEXCHANGEArg1));
    }

    @Test
    public void testiiuIIUExpenseCurrency() {
        assertEquals(testiiuIIUExpenseCurrencyResult, instanceExpenseCurrencyApi.iiuIIUExpenseCurrency(testiiuIIUExpenseCurrencyArg1));
    }

    @Test
    public void testpiuPIUExpenseCurrency() {
        assertEquals(testpiuPIUExpenseCurrencyResult.getTotalItems(), instanceExpenseCurrencyApi.piuPIUExpenseCurrency(testpiuPIUExpenseCurrencyArg1).getTotalItems());
    }

    @Test
    public void testpiuPIUExpenseCurrency2() {
        assertEquals(testpiuPIUExpenseCurrency2Result.getTotalItems(), instanceExpenseCurrencyApi.piuPIUExpenseCurrency(testpiuPIUExpenseCurrency2Arg1).getTotalItems());
    }
}
