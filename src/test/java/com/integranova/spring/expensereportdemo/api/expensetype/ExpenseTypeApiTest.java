package com.integranova.spring.expensereportdemo.api.expensetype;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.api.expensetype.ExpenseTypeApi;
import com.integranova.spring.expensereportdemo.persistence.ExpenseType;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseTypeOid;
import com.integranova.spring.expensereportdemo.service.ExpenseTypeService;
import com.integranova.spring.expensereportdemo.viewmodel.expensetype.ds.DSExpenseType;
import com.integranova.spring.expensereportdemo.viewmodel.expensetype.ds.DSExpenseTypeSup;
import com.integranova.spring.expensereportdemo.viewmodel.expensetype.piu.PIUExpenseTypeResponse;
import com.integranova.spring.expensereportdemo.viewmodel.expensetype.siu.CreateinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensetype.siu.DeleteinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensetype.siu.EditinstanceRequest;
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
public class ExpenseTypeApiTest {

    @Mock
    private ExpenseTypeService mockExpenseTypeService;

    @InjectMocks
    private ExpenseTypeApi instanceExpenseTypeApi;

    // testGetDSExpenseType
    private static String testGetDSExpenseTypeArg1;
    private static String testGetDSExpenseTypeArg2;
    private static String testGetDSExpenseTypeArg3;
    private static DSExpenseType testGetDSExpenseTypeResult;

    // testGetDSExpenseType2
    private static String testGetDSExpenseType2Arg1;
    private static String testGetDSExpenseType2Arg2;
    private static String testGetDSExpenseType2Arg3;
    private static DSExpenseType testGetDSExpenseType2Result;

    // testGetDSExpenseType3
    private static String testGetDSExpenseType3Arg1;
    private static String testGetDSExpenseType3Arg2;
    private static String testGetDSExpenseType3Arg3;
    private static DSExpenseType testGetDSExpenseType3Result;

    // testGetDSExpenseType4
    private static String testGetDSExpenseType4Arg1;
    private static String testGetDSExpenseType4Arg2;
    private static String testGetDSExpenseType4Arg3;
    private static DSExpenseType testGetDSExpenseType4Result;

    // testGetDSExpenseTypeSup
    private static String testGetDSExpenseTypeSupArg1;
    private static String testGetDSExpenseTypeSupArg2;
    private static String testGetDSExpenseTypeSupArg3;
    private static DSExpenseTypeSup testGetDSExpenseTypeSupResult;

    // testGetDSExpenseTypeSup2
    private static String testGetDSExpenseTypeSup2Arg1;
    private static String testGetDSExpenseTypeSup2Arg2;
    private static String testGetDSExpenseTypeSup2Arg3;
    private static DSExpenseTypeSup testGetDSExpenseTypeSup2Result;

    // testGetDSExpenseTypeSup3
    private static String testGetDSExpenseTypeSup3Arg1;
    private static String testGetDSExpenseTypeSup3Arg2;
    private static String testGetDSExpenseTypeSup3Arg3;
    private static DSExpenseTypeSup testGetDSExpenseTypeSup3Result;

    // testGetDSExpenseTypeSup4
    private static String testGetDSExpenseTypeSup4Arg1;
    private static String testGetDSExpenseTypeSup4Arg2;
    private static String testGetDSExpenseTypeSup4Arg3;
    private static DSExpenseTypeSup testGetDSExpenseTypeSup4Result;

    // testGetExpenseType
    private static String testGetExpenseTypeArg1;
    private static ExpenseType testGetExpenseTypeResult;

    // testGetExpenseTypeDynamic
    private static QueryRequest testGetExpenseTypeDynamicArg1;
    private static ExpenseTypeOid mockGetExpenseTypeDynamicArg1;
    private static String mockGetExpenseTypeDynamicArg2;
    private static InstanceResponseViewModel testGetExpenseTypeDynamicResult;

    // testGetExpenseTypePreload
    private static QueryRequest testGetExpenseTypePreloadArg1;
    private static List<PreloadViewModel> testGetExpenseTypePreloadResult;

    // testGetExpenseTypeWithDisplaySetDynamic
    private static QueryRequest testGetExpenseTypeWithDisplaySetDynamicArg1;
    private static PreloadResponseViewModel testGetExpenseTypeWithDisplaySetDynamicResult;

    // testGetExpenseTypePopulationDynamic
    private static QueryRequest testGetExpenseTypePopulationDynamicArg1;
    private static PopulationResponseViewModel testGetExpenseTypePopulationDynamicResult;

    // testExpenseTypeCreateinstance
    private static CreateinstanceRequest testExpenseTypeCreateinstanceArg1;
    private static ServiceResponse testExpenseTypeCreateinstanceResult;

    // testExpenseTypeDeleteinstance
    private static DeleteinstanceRequest testExpenseTypeDeleteinstanceArg1;
    private static ServiceResponse testExpenseTypeDeleteinstanceResult;

    // testExpenseTypeEditinstance
    private static EditinstanceRequest testExpenseTypeEditinstanceArg1;
    private static ServiceResponse testExpenseTypeEditinstanceResult;

    // testiiuIIUExpenseType
    private static ExpenseTypeOid testiiuIIUExpenseTypeArg1;
    private static DSExpenseType testiiuIIUExpenseTypeResult;

    // testpiuPIUExpenseType
    private static PopulationRequestViewModel testpiuPIUExpenseTypeArg1;
    private static QueryRequest testpiuPIUExpenseTypeMockArg1;
    private static List<DSExpenseType> testpiuPIUExpenseTypeMockResult;
    private static PIUExpenseTypeResponse testpiuPIUExpenseTypeResult;

    // testpiuPIUExpenseType2
    private static PopulationRequestViewModel testpiuPIUExpenseType2Arg1;
    private static QueryRequest testpiuPIUExpenseType2MockArg1;
    private static List<DSExpenseType> testpiuPIUExpenseType2MockResult;
    private static PIUExpenseTypeResponse testpiuPIUExpenseType2Result;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testGetDSExpenseType();
        setUpMockData4testGetDSExpenseType2();
        setUpMockData4testGetDSExpenseType3();
        setUpMockData4testGetDSExpenseType4();
        setUpMockData4testGetDSExpenseTypeSup();
        setUpMockData4testGetDSExpenseTypeSup2();
        setUpMockData4testGetDSExpenseTypeSup3();
        setUpMockData4testGetDSExpenseTypeSup4();
        setUpMockData4testGetExpenseType();
        setUpMockData4testGetExpenseTypeDynamic();
        setUpMockData4testGetExpenseTypePreload();
        setUpMockData4testGetExpenseTypeWithDisplaySetDynamic();
        setUpMockData4testGetExpenseTypePopulationDynamic();
        setUpMockData4testExpenseTypeCreateinstance();
        setUpMockData4testExpenseTypeDeleteinstance();
        setUpMockData4testExpenseTypeEditinstance();
        setUpMockData4testiiuIIUExpenseType();
        setUpMockData4testpiuPIUExpenseType();
        setUpMockData4testpiuPIUExpenseType2();
    }

    private static void setUpMockData4testGetDSExpenseType() {
        testGetDSExpenseTypeArg1 = "";
        testGetDSExpenseTypeArg2 = "";
        testGetDSExpenseTypeArg3 = "";
        testGetDSExpenseTypeResult = new DSExpenseType();
    }

    private static void setUpMockData4testGetDSExpenseType2() {
        testGetDSExpenseType2Arg1 = "";
        testGetDSExpenseType2Arg2 = null;
        testGetDSExpenseType2Arg3 = null;
        testGetDSExpenseType2Result = testGetDSExpenseTypeResult;
    }

    private static void setUpMockData4testGetDSExpenseType3() {
        testGetDSExpenseType3Arg1 = "";
        testGetDSExpenseType3Arg2 = null;
        testGetDSExpenseType3Arg3 = "";
        testGetDSExpenseType3Result = testGetDSExpenseTypeResult;
    }

    private static void setUpMockData4testGetDSExpenseType4() {
        testGetDSExpenseType4Arg1 = "";
        testGetDSExpenseType4Arg2 = "";
        testGetDSExpenseType4Arg3 = null;
        testGetDSExpenseType4Result = testGetDSExpenseTypeResult;
    }

    private static void setUpMockData4testGetDSExpenseTypeSup() {
        testGetDSExpenseTypeSupArg1 = "";
        testGetDSExpenseTypeSupArg2 = "";
        testGetDSExpenseTypeSupArg3 = "";
        testGetDSExpenseTypeSupResult = new DSExpenseTypeSup();
    }

    private static void setUpMockData4testGetDSExpenseTypeSup2() {
        testGetDSExpenseTypeSup2Arg1 = "";
        testGetDSExpenseTypeSup2Arg2 = null;
        testGetDSExpenseTypeSup2Arg3 = null;
        testGetDSExpenseTypeSup2Result = testGetDSExpenseTypeSupResult;
    }

    private static void setUpMockData4testGetDSExpenseTypeSup3() {
        testGetDSExpenseTypeSup3Arg1 = "";
        testGetDSExpenseTypeSup3Arg2 = null;
        testGetDSExpenseTypeSup3Arg3 = "";
        testGetDSExpenseTypeSup3Result = testGetDSExpenseTypeSupResult;
    }

    private static void setUpMockData4testGetDSExpenseTypeSup4() {
        testGetDSExpenseTypeSup4Arg1 = "";
        testGetDSExpenseTypeSup4Arg2 = "";
        testGetDSExpenseTypeSup4Arg3 = null;
        testGetDSExpenseTypeSup4Result = testGetDSExpenseTypeSupResult;
    }

    private static void setUpMockData4testGetExpenseType() {
        testGetExpenseTypeArg1 = "";
        testGetExpenseTypeResult = new ExpenseType();
    }

    private static void setUpMockData4testGetExpenseTypeDynamic() {
        mockGetExpenseTypeDynamicArg1 = new ExpenseTypeOid();
        mockGetExpenseTypeDynamicArg2 = "";
        testGetExpenseTypeDynamicArg1 = new QueryRequest();
        testGetExpenseTypeDynamicResult = new InstanceResponseViewModel();
    }

    private static void setUpMockData4testGetExpenseTypePreload() {
        testGetExpenseTypePreloadArg1 = new QueryRequest();
        testGetExpenseTypePreloadResult = new ArrayList<>();
    }

    private static void setUpMockData4testGetExpenseTypeWithDisplaySetDynamic() {
        testGetExpenseTypeWithDisplaySetDynamicArg1 = new QueryRequest();
        testGetExpenseTypeWithDisplaySetDynamicArg1.setDisplaySetName("testGetExpenseTypeWithDisplaySetDynamicArg1");
        testGetExpenseTypeWithDisplaySetDynamicResult = new PreloadResponseViewModel();
    }

    private static void setUpMockData4testGetExpenseTypePopulationDynamic() {
        testGetExpenseTypePopulationDynamicArg1 = new QueryRequest();
        testGetExpenseTypePopulationDynamicArg1.setDisplaySetName("testGetExpenseTypePopulationDynamicArg1");
        testGetExpenseTypePopulationDynamicResult = new PopulationResponseViewModel();
    }

    private static void setUpMockData4testExpenseTypeCreateinstance() {
        testExpenseTypeCreateinstanceArg1 = new CreateinstanceRequest();
        testExpenseTypeCreateinstanceResult = new ServiceResponse();
    }

    private static void setUpMockData4testExpenseTypeDeleteinstance() {
        testExpenseTypeDeleteinstanceArg1 = new DeleteinstanceRequest();
        testExpenseTypeDeleteinstanceResult = new ServiceResponse();
    }

    private static void setUpMockData4testExpenseTypeEditinstance() {
        testExpenseTypeEditinstanceArg1 = new EditinstanceRequest();
        testExpenseTypeEditinstanceResult = new ServiceResponse();
    }

    private static void setUpMockData4testiiuIIUExpenseType() {
        testiiuIIUExpenseTypeArg1 = new ExpenseTypeOid();
        testiiuIIUExpenseTypeResult = new DSExpenseType();
    }

    private static void setUpMockData4testpiuPIUExpenseType() {
        testpiuPIUExpenseTypeMockArg1 = new QueryRequest();
        testpiuPIUExpenseTypeMockArg1.setPageSize(0);
        testpiuPIUExpenseTypeMockResult = new ArrayList<>();
        testpiuPIUExpenseTypeArg1 = mock(PopulationRequestViewModel.class);
        testpiuPIUExpenseTypeResult = new PIUExpenseTypeResponse();
    }

    private static void setUpMockData4testpiuPIUExpenseType2() {
        testpiuPIUExpenseType2MockArg1 = new QueryRequest();
        testpiuPIUExpenseType2MockArg1.setPageSize(1);
        testpiuPIUExpenseType2MockResult = new ArrayList<>();
        testpiuPIUExpenseType2MockResult.add(new DSExpenseType());
        testpiuPIUExpenseType2Arg1 = mock(PopulationRequestViewModel.class);
        testpiuPIUExpenseType2Arg1.setPageSize(1);
        testpiuPIUExpenseType2Result = new PIUExpenseTypeResponse();
        testpiuPIUExpenseType2Result.setTotalItems(1);
    }

    @Before
    public void setUp() {

        when(mockExpenseTypeService.getDSExpenseType(testGetDSExpenseTypeArg1, testGetDSExpenseTypeArg2, testGetDSExpenseTypeArg3)).thenReturn(testGetDSExpenseTypeResult);

        when(mockExpenseTypeService.getDSExpenseTypeSup(testGetDSExpenseTypeSupArg1, testGetDSExpenseTypeSupArg2, testGetDSExpenseTypeSupArg3)).thenReturn(testGetDSExpenseTypeSupResult);

        when(mockExpenseTypeService.getById(testGetExpenseTypeArg1)).thenReturn(testGetExpenseTypeResult);

        when(mockExpenseTypeService.getExpenseTypeDynamic(mockGetExpenseTypeDynamicArg1, mockGetExpenseTypeDynamicArg2)).thenReturn(testGetExpenseTypeDynamicResult);

        when(mockExpenseTypeService.getPreload(testGetExpenseTypePreloadArg1)).thenReturn(testGetExpenseTypePreloadResult);

        when(mockExpenseTypeService.getDynamic(testGetExpenseTypeWithDisplaySetDynamicArg1)).thenReturn(testGetExpenseTypeWithDisplaySetDynamicResult);

        when(mockExpenseTypeService.getDynamic(testGetExpenseTypePopulationDynamicArg1)).thenReturn(testGetExpenseTypePopulationDynamicResult);

        when(mockExpenseTypeService.createinstance(testExpenseTypeCreateinstanceArg1)).thenReturn(testExpenseTypeCreateinstanceResult);

        when(mockExpenseTypeService.deleteinstance(testExpenseTypeDeleteinstanceArg1)).thenReturn(testExpenseTypeDeleteinstanceResult);

        when(mockExpenseTypeService.editinstance(testExpenseTypeEditinstanceArg1)).thenReturn(testExpenseTypeEditinstanceResult);

        when(mockExpenseTypeService.iIUExpenseType(testiiuIIUExpenseTypeArg1)).thenReturn(testiiuIIUExpenseTypeResult);

        when(testpiuPIUExpenseTypeArg1.buildQueryRequest()).thenReturn(testpiuPIUExpenseTypeMockArg1);

        when(mockExpenseTypeService.piuPIUExpenseType(testpiuPIUExpenseTypeMockArg1)).thenReturn(testpiuPIUExpenseTypeMockResult);

        when(testpiuPIUExpenseType2Arg1.buildQueryRequest()).thenReturn(testpiuPIUExpenseType2MockArg1);

        when(mockExpenseTypeService.piuPIUExpenseType(testpiuPIUExpenseType2MockArg1)).thenReturn(testpiuPIUExpenseType2MockResult);

        when(mockExpenseTypeService.getCount4PIUExpenseType(testpiuPIUExpenseType2MockArg1)).thenReturn(1);
    }

    @Test
    public void testGetDSExpenseType() {
        assertEquals(testGetDSExpenseTypeResult, instanceExpenseTypeApi.getDSExpenseType(testGetDSExpenseTypeArg1, testGetDSExpenseTypeArg2, testGetDSExpenseTypeArg3));
    }

    @Test
    public void testGetDSExpenseType2() {
        assertEquals(testGetDSExpenseType2Result, instanceExpenseTypeApi.getDSExpenseType(testGetDSExpenseType2Arg1, testGetDSExpenseType2Arg2, testGetDSExpenseType2Arg3));
    }

    @Test
    public void testGetDSExpenseType3() {
        assertEquals(testGetDSExpenseType3Result, instanceExpenseTypeApi.getDSExpenseType(testGetDSExpenseType3Arg1, testGetDSExpenseType3Arg2, testGetDSExpenseType3Arg3));
    }

    @Test
    public void testGetDSExpenseType4() {
        assertEquals(testGetDSExpenseType4Result, instanceExpenseTypeApi.getDSExpenseType(testGetDSExpenseType4Arg1, testGetDSExpenseType4Arg2, testGetDSExpenseType4Arg3));
    }

    @Test
    public void testGetDSExpenseTypeSup() {
        assertEquals(testGetDSExpenseTypeSupResult, instanceExpenseTypeApi.getDSExpenseTypeSup(testGetDSExpenseTypeSupArg1, testGetDSExpenseTypeSupArg2, testGetDSExpenseTypeSupArg3));
    }

    @Test
    public void testGetDSExpenseTypeSup2() {
        assertEquals(testGetDSExpenseTypeSup2Result, instanceExpenseTypeApi.getDSExpenseTypeSup(testGetDSExpenseTypeSup2Arg1, testGetDSExpenseTypeSup2Arg2, testGetDSExpenseTypeSup2Arg3));
    }

    @Test
    public void testGetDSExpenseTypeSup3() {
        assertEquals(testGetDSExpenseTypeSup3Result, instanceExpenseTypeApi.getDSExpenseTypeSup(testGetDSExpenseTypeSup3Arg1, testGetDSExpenseTypeSup3Arg2, testGetDSExpenseTypeSup3Arg3));
    }

    @Test
    public void testGetDSExpenseTypeSup4() {
        assertEquals(testGetDSExpenseTypeSup4Result, instanceExpenseTypeApi.getDSExpenseTypeSup(testGetDSExpenseTypeSup4Arg1, testGetDSExpenseTypeSup4Arg2, testGetDSExpenseTypeSup4Arg3));
    }

    @Test
    public void testGetExpenseType() {
        assertEquals(testGetExpenseTypeResult, instanceExpenseTypeApi.getExpenseType(testGetExpenseTypeArg1));
    }

    @Test
    public void testGetExpenseTypeDynamic() {
        assertEquals(testGetExpenseTypeDynamicResult, instanceExpenseTypeApi.getExpenseTypeDynamic(testGetExpenseTypeDynamicArg1));
    }

    @Test
    public void testGetExpenseTypePreload() {
        assertEquals(testGetExpenseTypePreloadResult, instanceExpenseTypeApi.getExpenseTypePreload(testGetExpenseTypePreloadArg1));
    }

    @Test
    public void testGetExpenseTypeWithDisplaySetDynamic() {
        assertEquals(testGetExpenseTypeWithDisplaySetDynamicResult, instanceExpenseTypeApi.getExpenseTypeWithDisplaySetDynamic(testGetExpenseTypeWithDisplaySetDynamicArg1));
    }

    @Test
    public void testGetExpenseTypePopulationDynamic() {
        assertEquals(testGetExpenseTypePopulationDynamicResult, instanceExpenseTypeApi.getExpenseTypePopulationDynamic(testGetExpenseTypePopulationDynamicArg1));
    }

    @Test
    public void testExpenseTypeCreateinstance() {
        assertEquals(testExpenseTypeCreateinstanceResult, instanceExpenseTypeApi.expenseTypeCreateinstance(testExpenseTypeCreateinstanceArg1));
    }

    @Test
    public void testExpenseTypeDeleteinstance() {
        assertEquals(testExpenseTypeDeleteinstanceResult, instanceExpenseTypeApi.expenseTypeDeleteinstance(testExpenseTypeDeleteinstanceArg1));
    }

    @Test
    public void testExpenseTypeEditinstance() {
        assertEquals(testExpenseTypeEditinstanceResult, instanceExpenseTypeApi.expenseTypeEditinstance(testExpenseTypeEditinstanceArg1));
    }

    @Test
    public void testiiuIIUExpenseType() {
        assertEquals(testiiuIIUExpenseTypeResult, instanceExpenseTypeApi.iiuIIUExpenseType(testiiuIIUExpenseTypeArg1));
    }

    @Test
    public void testpiuPIUExpenseType() {
        assertEquals(testpiuPIUExpenseTypeResult.getTotalItems(), instanceExpenseTypeApi.piuPIUExpenseType(testpiuPIUExpenseTypeArg1).getTotalItems());
    }

    @Test
    public void testpiuPIUExpenseType2() {
        assertEquals(testpiuPIUExpenseType2Result.getTotalItems(), instanceExpenseTypeApi.piuPIUExpenseType(testpiuPIUExpenseType2Arg1).getTotalItems());
    }
}
