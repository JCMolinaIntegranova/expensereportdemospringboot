package com.integranova.spring.expensereportdemo.api.paymenttype;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.api.paymenttype.PaymentTypeApi;
import com.integranova.spring.expensereportdemo.persistence.oid.PaymentTypeOid;
import com.integranova.spring.expensereportdemo.persistence.PaymentType;
import com.integranova.spring.expensereportdemo.service.PaymentTypeService;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.paymenttype.ds.DSPaymentType;
import com.integranova.spring.expensereportdemo.viewmodel.paymenttype.ds.DSPaymentTypeSup;
import com.integranova.spring.expensereportdemo.viewmodel.paymenttype.piu.PIUPaymentTypeResponse;
import com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu.CreateinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu.DeleteinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu.EditinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.paymenttype.siu.InsPaymentTypeRequest;
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
public class PaymentTypeApiTest {

    @Mock
    private PaymentTypeService mockPaymentTypeService;

    @InjectMocks
    private PaymentTypeApi instancePaymentTypeApi;

    // testGetDSPaymentType
    private static String testGetDSPaymentTypeArg1;
    private static String testGetDSPaymentTypeArg2;
    private static String testGetDSPaymentTypeArg3;
    private static DSPaymentType testGetDSPaymentTypeResult;

    // testGetDSPaymentType2
    private static String testGetDSPaymentType2Arg1;
    private static String testGetDSPaymentType2Arg2;
    private static String testGetDSPaymentType2Arg3;
    private static DSPaymentType testGetDSPaymentType2Result;

    // testGetDSPaymentType3
    private static String testGetDSPaymentType3Arg1;
    private static String testGetDSPaymentType3Arg2;
    private static String testGetDSPaymentType3Arg3;
    private static DSPaymentType testGetDSPaymentType3Result;

    // testGetDSPaymentType4
    private static String testGetDSPaymentType4Arg1;
    private static String testGetDSPaymentType4Arg2;
    private static String testGetDSPaymentType4Arg3;
    private static DSPaymentType testGetDSPaymentType4Result;

    // testGetDSPaymentTypeSup
    private static String testGetDSPaymentTypeSupArg1;
    private static String testGetDSPaymentTypeSupArg2;
    private static String testGetDSPaymentTypeSupArg3;
    private static DSPaymentTypeSup testGetDSPaymentTypeSupResult;

    // testGetDSPaymentTypeSup2
    private static String testGetDSPaymentTypeSup2Arg1;
    private static String testGetDSPaymentTypeSup2Arg2;
    private static String testGetDSPaymentTypeSup2Arg3;
    private static DSPaymentTypeSup testGetDSPaymentTypeSup2Result;

    // testGetDSPaymentTypeSup3
    private static String testGetDSPaymentTypeSup3Arg1;
    private static String testGetDSPaymentTypeSup3Arg2;
    private static String testGetDSPaymentTypeSup3Arg3;
    private static DSPaymentTypeSup testGetDSPaymentTypeSup3Result;

    // testGetDSPaymentTypeSup4
    private static String testGetDSPaymentTypeSup4Arg1;
    private static String testGetDSPaymentTypeSup4Arg2;
    private static String testGetDSPaymentTypeSup4Arg3;
    private static DSPaymentTypeSup testGetDSPaymentTypeSup4Result;

    // testGetPaymentType
    private static String testGetPaymentTypeArg1;
    private static PaymentType testGetPaymentTypeResult;

    // testGetPaymentTypeDynamic
    private static QueryRequest testGetPaymentTypeDynamicArg1;
    private static PaymentTypeOid mockGetPaymentTypeDynamicArg1;
    private static String mockGetPaymentTypeDynamicArg2;
    private static InstanceResponseViewModel testGetPaymentTypeDynamicResult;

    // testGetPaymentTypePreload
    private static QueryRequest testGetPaymentTypePreloadArg1;
    private static List<PreloadViewModel> testGetPaymentTypePreloadResult;

    // testGetPaymentTypeWithDisplaySetDynamic
    private static QueryRequest testGetPaymentTypeWithDisplaySetDynamicArg1;
    private static PreloadResponseViewModel testGetPaymentTypeWithDisplaySetDynamicResult;

    // testGetPaymentTypePopulationDynamic
    private static QueryRequest testGetPaymentTypePopulationDynamicArg1;
    private static PopulationResponseViewModel testGetPaymentTypePopulationDynamicResult;

    // testPaymentTypeCreateinstance
    private static CreateinstanceRequest testPaymentTypeCreateinstanceArg1;
    private static ServiceResponse testPaymentTypeCreateinstanceResult;

    // testPaymentTypeDeleteinstance
    private static DeleteinstanceRequest testPaymentTypeDeleteinstanceArg1;
    private static ServiceResponse testPaymentTypeDeleteinstanceResult;

    // testPaymentTypeEditinstance
    private static EditinstanceRequest testPaymentTypeEditinstanceArg1;
    private static ServiceResponse testPaymentTypeEditinstanceResult;

    // testPaymentTypeInsPaymentType
    private static InsPaymentTypeRequest testPaymentTypeInsPaymentTypeArg1;
    private static ServiceResponse testPaymentTypeInsPaymentTypeResult;

    // testiiuIIUPaymentType
    private static PaymentTypeOid testiiuIIUPaymentTypeArg1;
    private static DSPaymentType testiiuIIUPaymentTypeResult;

    // testpiuPIUPaymentType
    private static PopulationRequestViewModel testpiuPIUPaymentTypeArg1;
    private static QueryRequest testpiuPIUPaymentTypeMockArg1;
    private static List<DSPaymentType> testpiuPIUPaymentTypeMockResult;
    private static PIUPaymentTypeResponse testpiuPIUPaymentTypeResult;

    // testpiuPIUPaymentType2
    private static PopulationRequestViewModel testpiuPIUPaymentType2Arg1;
    private static QueryRequest testpiuPIUPaymentType2MockArg1;
    private static List<DSPaymentType> testpiuPIUPaymentType2MockResult;
    private static PIUPaymentTypeResponse testpiuPIUPaymentType2Result;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testGetDSPaymentType();
        setUpMockData4testGetDSPaymentType2();
        setUpMockData4testGetDSPaymentType3();
        setUpMockData4testGetDSPaymentType4();
        setUpMockData4testGetDSPaymentTypeSup();
        setUpMockData4testGetDSPaymentTypeSup2();
        setUpMockData4testGetDSPaymentTypeSup3();
        setUpMockData4testGetDSPaymentTypeSup4();
        setUpMockData4testGetPaymentType();
        setUpMockData4testGetPaymentTypeDynamic();
        setUpMockData4testGetPaymentTypePreload();
        setUpMockData4testGetPaymentTypeWithDisplaySetDynamic();
        setUpMockData4testGetPaymentTypePopulationDynamic();
        setUpMockData4testPaymentTypeCreateinstance();
        setUpMockData4testPaymentTypeDeleteinstance();
        setUpMockData4testPaymentTypeEditinstance();
        setUpMockData4testPaymentTypeInsPaymentType();
        setUpMockData4testiiuIIUPaymentType();
        setUpMockData4testpiuPIUPaymentType();
        setUpMockData4testpiuPIUPaymentType2();
    }

    private static void setUpMockData4testGetDSPaymentType() {
        testGetDSPaymentTypeArg1 = "";
        testGetDSPaymentTypeArg2 = "";
        testGetDSPaymentTypeArg3 = "";
        testGetDSPaymentTypeResult = new DSPaymentType();
    }

    private static void setUpMockData4testGetDSPaymentType2() {
        testGetDSPaymentType2Arg1 = "";
        testGetDSPaymentType2Arg2 = null;
        testGetDSPaymentType2Arg3 = null;
        testGetDSPaymentType2Result = testGetDSPaymentTypeResult;
    }

    private static void setUpMockData4testGetDSPaymentType3() {
        testGetDSPaymentType3Arg1 = "";
        testGetDSPaymentType3Arg2 = null;
        testGetDSPaymentType3Arg3 = "";
        testGetDSPaymentType3Result = testGetDSPaymentTypeResult;
    }

    private static void setUpMockData4testGetDSPaymentType4() {
        testGetDSPaymentType4Arg1 = "";
        testGetDSPaymentType4Arg2 = "";
        testGetDSPaymentType4Arg3 = null;
        testGetDSPaymentType4Result = testGetDSPaymentTypeResult;
    }

    private static void setUpMockData4testGetDSPaymentTypeSup() {
        testGetDSPaymentTypeSupArg1 = "";
        testGetDSPaymentTypeSupArg2 = "";
        testGetDSPaymentTypeSupArg3 = "";
        testGetDSPaymentTypeSupResult = new DSPaymentTypeSup();
    }

    private static void setUpMockData4testGetDSPaymentTypeSup2() {
        testGetDSPaymentTypeSup2Arg1 = "";
        testGetDSPaymentTypeSup2Arg2 = null;
        testGetDSPaymentTypeSup2Arg3 = null;
        testGetDSPaymentTypeSup2Result = testGetDSPaymentTypeSupResult;
    }

    private static void setUpMockData4testGetDSPaymentTypeSup3() {
        testGetDSPaymentTypeSup3Arg1 = "";
        testGetDSPaymentTypeSup3Arg2 = null;
        testGetDSPaymentTypeSup3Arg3 = "";
        testGetDSPaymentTypeSup3Result = testGetDSPaymentTypeSupResult;
    }

    private static void setUpMockData4testGetDSPaymentTypeSup4() {
        testGetDSPaymentTypeSup4Arg1 = "";
        testGetDSPaymentTypeSup4Arg2 = "";
        testGetDSPaymentTypeSup4Arg3 = null;
        testGetDSPaymentTypeSup4Result = testGetDSPaymentTypeSupResult;
    }

    private static void setUpMockData4testGetPaymentType() {
        testGetPaymentTypeArg1 = "";
        testGetPaymentTypeResult = new PaymentType();
    }

    private static void setUpMockData4testGetPaymentTypeDynamic() {
        mockGetPaymentTypeDynamicArg1 = new PaymentTypeOid();
        mockGetPaymentTypeDynamicArg2 = "";
        testGetPaymentTypeDynamicArg1 = new QueryRequest();
        testGetPaymentTypeDynamicResult = new InstanceResponseViewModel();
    }

    private static void setUpMockData4testGetPaymentTypePreload() {
        testGetPaymentTypePreloadArg1 = new QueryRequest();
        testGetPaymentTypePreloadResult = new ArrayList<>();
    }

    private static void setUpMockData4testGetPaymentTypeWithDisplaySetDynamic() {
        testGetPaymentTypeWithDisplaySetDynamicArg1 = new QueryRequest();
        testGetPaymentTypeWithDisplaySetDynamicArg1.setDisplaySetName("testGetPaymentTypeWithDisplaySetDynamicArg1");
        testGetPaymentTypeWithDisplaySetDynamicResult = new PreloadResponseViewModel();
    }

    private static void setUpMockData4testGetPaymentTypePopulationDynamic() {
        testGetPaymentTypePopulationDynamicArg1 = new QueryRequest();
        testGetPaymentTypePopulationDynamicArg1.setDisplaySetName("testGetPaymentTypePopulationDynamicArg1");
        testGetPaymentTypePopulationDynamicResult = new PopulationResponseViewModel();
    }

    private static void setUpMockData4testPaymentTypeCreateinstance() {
        testPaymentTypeCreateinstanceArg1 = new CreateinstanceRequest();
        testPaymentTypeCreateinstanceResult = new ServiceResponse();
    }

    private static void setUpMockData4testPaymentTypeDeleteinstance() {
        testPaymentTypeDeleteinstanceArg1 = new DeleteinstanceRequest();
        testPaymentTypeDeleteinstanceResult = new ServiceResponse();
    }

    private static void setUpMockData4testPaymentTypeEditinstance() {
        testPaymentTypeEditinstanceArg1 = new EditinstanceRequest();
        testPaymentTypeEditinstanceResult = new ServiceResponse();
    }

    private static void setUpMockData4testPaymentTypeInsPaymentType() {
        testPaymentTypeInsPaymentTypeArg1 = new InsPaymentTypeRequest();
        testPaymentTypeInsPaymentTypeResult = new ServiceResponse();
    }

    private static void setUpMockData4testiiuIIUPaymentType() {
        testiiuIIUPaymentTypeArg1 = new PaymentTypeOid();
        testiiuIIUPaymentTypeResult = new DSPaymentType();
    }

    private static void setUpMockData4testpiuPIUPaymentType() {
        testpiuPIUPaymentTypeMockArg1 = new QueryRequest();
        testpiuPIUPaymentTypeMockArg1.setPageSize(0);
        testpiuPIUPaymentTypeMockResult = new ArrayList<>();
        testpiuPIUPaymentTypeArg1 = mock(PopulationRequestViewModel.class);
        testpiuPIUPaymentTypeResult = new PIUPaymentTypeResponse();
    }

    private static void setUpMockData4testpiuPIUPaymentType2() {
        testpiuPIUPaymentType2MockArg1 = new QueryRequest();
        testpiuPIUPaymentType2MockArg1.setPageSize(1);
        testpiuPIUPaymentType2MockResult = new ArrayList<>();
        testpiuPIUPaymentType2MockResult.add(new DSPaymentType());
        testpiuPIUPaymentType2Arg1 = mock(PopulationRequestViewModel.class);
        testpiuPIUPaymentType2Arg1.setPageSize(1);
        testpiuPIUPaymentType2Result = new PIUPaymentTypeResponse();
        testpiuPIUPaymentType2Result.setTotalItems(1);
    }

    @Before
    public void setUp() {

        when(mockPaymentTypeService.getDSPaymentType(testGetDSPaymentTypeArg1, testGetDSPaymentTypeArg2, testGetDSPaymentTypeArg3)).thenReturn(testGetDSPaymentTypeResult);

        when(mockPaymentTypeService.getDSPaymentTypeSup(testGetDSPaymentTypeSupArg1, testGetDSPaymentTypeSupArg2, testGetDSPaymentTypeSupArg3)).thenReturn(testGetDSPaymentTypeSupResult);

        when(mockPaymentTypeService.getById(testGetPaymentTypeArg1)).thenReturn(testGetPaymentTypeResult);

        when(mockPaymentTypeService.getPaymentTypeDynamic(mockGetPaymentTypeDynamicArg1, mockGetPaymentTypeDynamicArg2)).thenReturn(testGetPaymentTypeDynamicResult);

        when(mockPaymentTypeService.getPreload(testGetPaymentTypePreloadArg1)).thenReturn(testGetPaymentTypePreloadResult);

        when(mockPaymentTypeService.getDynamic(testGetPaymentTypeWithDisplaySetDynamicArg1)).thenReturn(testGetPaymentTypeWithDisplaySetDynamicResult);

        when(mockPaymentTypeService.getDynamic(testGetPaymentTypePopulationDynamicArg1)).thenReturn(testGetPaymentTypePopulationDynamicResult);

        when(mockPaymentTypeService.createinstance(testPaymentTypeCreateinstanceArg1)).thenReturn(testPaymentTypeCreateinstanceResult);

        when(mockPaymentTypeService.deleteinstance(testPaymentTypeDeleteinstanceArg1)).thenReturn(testPaymentTypeDeleteinstanceResult);

        when(mockPaymentTypeService.editinstance(testPaymentTypeEditinstanceArg1)).thenReturn(testPaymentTypeEditinstanceResult);

        when(mockPaymentTypeService.insPaymentType(testPaymentTypeInsPaymentTypeArg1)).thenReturn(testPaymentTypeInsPaymentTypeResult);

        when(mockPaymentTypeService.iIUPaymentType(testiiuIIUPaymentTypeArg1)).thenReturn(testiiuIIUPaymentTypeResult);

        when(testpiuPIUPaymentTypeArg1.buildQueryRequest()).thenReturn(testpiuPIUPaymentTypeMockArg1);

        when(mockPaymentTypeService.piuPIUPaymentType(testpiuPIUPaymentTypeMockArg1)).thenReturn(testpiuPIUPaymentTypeMockResult);

        when(testpiuPIUPaymentType2Arg1.buildQueryRequest()).thenReturn(testpiuPIUPaymentType2MockArg1);

        when(mockPaymentTypeService.piuPIUPaymentType(testpiuPIUPaymentType2MockArg1)).thenReturn(testpiuPIUPaymentType2MockResult);

        when(mockPaymentTypeService.getCount4PIUPaymentType(testpiuPIUPaymentType2MockArg1)).thenReturn(1);
    }

    @Test
    public void testGetDSPaymentType() {
        assertEquals(testGetDSPaymentTypeResult, instancePaymentTypeApi.getDSPaymentType(testGetDSPaymentTypeArg1, testGetDSPaymentTypeArg2, testGetDSPaymentTypeArg3));
    }

    @Test
    public void testGetDSPaymentType2() {
        assertEquals(testGetDSPaymentType2Result, instancePaymentTypeApi.getDSPaymentType(testGetDSPaymentType2Arg1, testGetDSPaymentType2Arg2, testGetDSPaymentType2Arg3));
    }

    @Test
    public void testGetDSPaymentType3() {
        assertEquals(testGetDSPaymentType3Result, instancePaymentTypeApi.getDSPaymentType(testGetDSPaymentType3Arg1, testGetDSPaymentType3Arg2, testGetDSPaymentType3Arg3));
    }

    @Test
    public void testGetDSPaymentType4() {
        assertEquals(testGetDSPaymentType4Result, instancePaymentTypeApi.getDSPaymentType(testGetDSPaymentType4Arg1, testGetDSPaymentType4Arg2, testGetDSPaymentType4Arg3));
    }

    @Test
    public void testGetDSPaymentTypeSup() {
        assertEquals(testGetDSPaymentTypeSupResult, instancePaymentTypeApi.getDSPaymentTypeSup(testGetDSPaymentTypeSupArg1, testGetDSPaymentTypeSupArg2, testGetDSPaymentTypeSupArg3));
    }

    @Test
    public void testGetDSPaymentTypeSup2() {
        assertEquals(testGetDSPaymentTypeSup2Result, instancePaymentTypeApi.getDSPaymentTypeSup(testGetDSPaymentTypeSup2Arg1, testGetDSPaymentTypeSup2Arg2, testGetDSPaymentTypeSup2Arg3));
    }

    @Test
    public void testGetDSPaymentTypeSup3() {
        assertEquals(testGetDSPaymentTypeSup3Result, instancePaymentTypeApi.getDSPaymentTypeSup(testGetDSPaymentTypeSup3Arg1, testGetDSPaymentTypeSup3Arg2, testGetDSPaymentTypeSup3Arg3));
    }

    @Test
    public void testGetDSPaymentTypeSup4() {
        assertEquals(testGetDSPaymentTypeSup4Result, instancePaymentTypeApi.getDSPaymentTypeSup(testGetDSPaymentTypeSup4Arg1, testGetDSPaymentTypeSup4Arg2, testGetDSPaymentTypeSup4Arg3));
    }

    @Test
    public void testGetPaymentType() {
        assertEquals(testGetPaymentTypeResult, instancePaymentTypeApi.getPaymentType(testGetPaymentTypeArg1));
    }

    @Test
    public void testGetPaymentTypeDynamic() {
        assertEquals(testGetPaymentTypeDynamicResult, instancePaymentTypeApi.getPaymentTypeDynamic(testGetPaymentTypeDynamicArg1));
    }

    @Test
    public void testGetPaymentTypePreload() {
        assertEquals(testGetPaymentTypePreloadResult, instancePaymentTypeApi.getPaymentTypePreload(testGetPaymentTypePreloadArg1));
    }

    @Test
    public void testGetPaymentTypeWithDisplaySetDynamic() {
        assertEquals(testGetPaymentTypeWithDisplaySetDynamicResult, instancePaymentTypeApi.getPaymentTypeWithDisplaySetDynamic(testGetPaymentTypeWithDisplaySetDynamicArg1));
    }

    @Test
    public void testGetPaymentTypePopulationDynamic() {
        assertEquals(testGetPaymentTypePopulationDynamicResult, instancePaymentTypeApi.getPaymentTypePopulationDynamic(testGetPaymentTypePopulationDynamicArg1));
    }

    @Test
    public void testPaymentTypeCreateinstance() {
        assertEquals(testPaymentTypeCreateinstanceResult, instancePaymentTypeApi.paymentTypeCreateinstance(testPaymentTypeCreateinstanceArg1));
    }

    @Test
    public void testPaymentTypeDeleteinstance() {
        assertEquals(testPaymentTypeDeleteinstanceResult, instancePaymentTypeApi.paymentTypeDeleteinstance(testPaymentTypeDeleteinstanceArg1));
    }

    @Test
    public void testPaymentTypeEditinstance() {
        assertEquals(testPaymentTypeEditinstanceResult, instancePaymentTypeApi.paymentTypeEditinstance(testPaymentTypeEditinstanceArg1));
    }

    @Test
    public void testPaymentTypeInsPaymentType() {
        assertEquals(testPaymentTypeInsPaymentTypeResult, instancePaymentTypeApi.paymentTypeInsPaymentType(testPaymentTypeInsPaymentTypeArg1));
    }

    @Test
    public void testiiuIIUPaymentType() {
        assertEquals(testiiuIIUPaymentTypeResult, instancePaymentTypeApi.iiuIIUPaymentType(testiiuIIUPaymentTypeArg1));
    }

    @Test
    public void testpiuPIUPaymentType() {
        assertEquals(testpiuPIUPaymentTypeResult.getTotalItems(), instancePaymentTypeApi.piuPIUPaymentType(testpiuPIUPaymentTypeArg1).getTotalItems());
    }

    @Test
    public void testpiuPIUPaymentType2() {
        assertEquals(testpiuPIUPaymentType2Result.getTotalItems(), instancePaymentTypeApi.piuPIUPaymentType(testpiuPIUPaymentType2Arg1).getTotalItems());
    }
}
