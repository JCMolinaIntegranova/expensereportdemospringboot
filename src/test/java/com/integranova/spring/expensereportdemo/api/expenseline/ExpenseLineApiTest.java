package com.integranova.spring.expensereportdemo.api.expenseline;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.api.expenseline.ExpenseLineApi;
import com.integranova.spring.expensereportdemo.persistence.ExpenseLine;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.ExpenseType;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseLineOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseReportOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseTypeOid;
import com.integranova.spring.expensereportdemo.service.ExpenseLineService;
import com.integranova.spring.expensereportdemo.viewmodel.expenseline.ds.DSExpenseLine;
import com.integranova.spring.expensereportdemo.viewmodel.expenseline.ds.DSExpenseLineSup;
import com.integranova.spring.expensereportdemo.viewmodel.expenseline.piu.PIUExpenseLineResponse;
import com.integranova.spring.expensereportdemo.viewmodel.expenseline.piu.PIUExpenseLineToReportsResponse;
import com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.DeletelineRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.EditinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.NewlineRequest;
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
public class ExpenseLineApiTest {

    @Mock
    private ExpenseLineService mockExpenseLineService;

    @InjectMocks
    private ExpenseLineApi instanceExpenseLineApi;

    // testGetDSExpenseLine
    private static String testGetDSExpenseLineArg1;
    private static String testGetDSExpenseLineArg2;
    private static String testGetDSExpenseLineArg3;
    private static DSExpenseLine testGetDSExpenseLineResult;

    // testGetDSExpenseLine2
    private static String testGetDSExpenseLine2Arg1;
    private static String testGetDSExpenseLine2Arg2;
    private static String testGetDSExpenseLine2Arg3;
    private static DSExpenseLine testGetDSExpenseLine2Result;

    // testGetDSExpenseLine3
    private static String testGetDSExpenseLine3Arg1;
    private static String testGetDSExpenseLine3Arg2;
    private static String testGetDSExpenseLine3Arg3;
    private static DSExpenseLine testGetDSExpenseLine3Result;

    // testGetDSExpenseLine4
    private static String testGetDSExpenseLine4Arg1;
    private static String testGetDSExpenseLine4Arg2;
    private static String testGetDSExpenseLine4Arg3;
    private static DSExpenseLine testGetDSExpenseLine4Result;

    // testGetDSExpenseLineSup
    private static String testGetDSExpenseLineSupArg1;
    private static String testGetDSExpenseLineSupArg2;
    private static String testGetDSExpenseLineSupArg3;
    private static DSExpenseLineSup testGetDSExpenseLineSupResult;

    // testGetDSExpenseLineSup2
    private static String testGetDSExpenseLineSup2Arg1;
    private static String testGetDSExpenseLineSup2Arg2;
    private static String testGetDSExpenseLineSup2Arg3;
    private static DSExpenseLineSup testGetDSExpenseLineSup2Result;

    // testGetDSExpenseLineSup3
    private static String testGetDSExpenseLineSup3Arg1;
    private static String testGetDSExpenseLineSup3Arg2;
    private static String testGetDSExpenseLineSup3Arg3;
    private static DSExpenseLineSup testGetDSExpenseLineSup3Result;

    // testGetDSExpenseLineSup4
    private static String testGetDSExpenseLineSup4Arg1;
    private static String testGetDSExpenseLineSup4Arg2;
    private static String testGetDSExpenseLineSup4Arg3;
    private static DSExpenseLineSup testGetDSExpenseLineSup4Result;

    // testGetExpenseLine
    private static Long testGetExpenseLineArg1;
    private static Long testGetExpenseLineArg2;
    private static ExpenseLine testGetExpenseLineResult;

    // testGetExpenseLineDynamic
    private static QueryRequest testGetExpenseLineDynamicArg1;
    private static ExpenseLineOid mockGetExpenseLineDynamicArg1;
    private static String mockGetExpenseLineDynamicArg2;
    private static InstanceResponseViewModel testGetExpenseLineDynamicResult;

    // testGetExpenseLinePreload
    private static QueryRequest testGetExpenseLinePreloadArg1;
    private static List<PreloadViewModel> testGetExpenseLinePreloadResult;

    // testGetExpenseLineWithDisplaySetDynamic
    private static QueryRequest testGetExpenseLineWithDisplaySetDynamicArg1;
    private static PreloadResponseViewModel testGetExpenseLineWithDisplaySetDynamicResult;

    // testGetExpenseLinePopulationDynamic
    private static QueryRequest testGetExpenseLinePopulationDynamicArg1;
    private static PopulationResponseViewModel testGetExpenseLinePopulationDynamicResult;

    // testGetExpenseLineByExpenseType
    private static ExpenseTypeOid testGetExpenseLineByExpenseTypeArg1;
    private static List<ExpenseLine> testGetExpenseLineByExpenseTypeResult;

    // testGetExpenseLineByExpenseReport
    private static ExpenseReportOid testGetExpenseLineByExpenseReportArg1;
    private static List<ExpenseLine> testGetExpenseLineByExpenseReportResult;

    // testExpenseLineNewline
    private static NewlineRequest testExpenseLineNewlineArg1;
    private static ServiceResponse testExpenseLineNewlineResult;

    // testExpenseLineNewlineCheckPreconditions
    private static NewlineRequest testExpenseLineNewlineCheckPreconditionsArg1;
    private static ServiceResponse testExpenseLineNewlineCheckPreconditionsResult;

    // testExpenseLineDeleteline
    private static DeletelineRequest testExpenseLineDeletelineArg1;
    private static ServiceResponse testExpenseLineDeletelineResult;

    // testExpenseLineDeletelineCheckPreconditions
    private static DeletelineRequest testExpenseLineDeletelineCheckPreconditionsArg1;
    private static ServiceResponse testExpenseLineDeletelineCheckPreconditionsResult;

    // testExpenseLineEditinstance
    private static EditinstanceRequest testExpenseLineEditinstanceArg1;
    private static ServiceResponse testExpenseLineEditinstanceResult;

    // testExpenseLineEditinstanceCheckPreconditions
    private static EditinstanceRequest testExpenseLineEditinstanceCheckPreconditionsArg1;
    private static ServiceResponse testExpenseLineEditinstanceCheckPreconditionsResult;

    // testiiuIIUExpenseLine
    private static ExpenseLineOid testiiuIIUExpenseLineArg1;
    private static DSExpenseLine testiiuIIUExpenseLineResult;

    // testpiuPIUExpenseLine
    private static PopulationRequestViewModel testpiuPIUExpenseLineArg1;
    private static QueryRequest testpiuPIUExpenseLineMockArg1;
    private static List<DSExpenseLine> testpiuPIUExpenseLineMockResult;
    private static PIUExpenseLineResponse testpiuPIUExpenseLineResult;

    // testpiuPIUExpenseLine2
    private static PopulationRequestViewModel testpiuPIUExpenseLine2Arg1;
    private static QueryRequest testpiuPIUExpenseLine2MockArg1;
    private static List<DSExpenseLine> testpiuPIUExpenseLine2MockResult;
    private static PIUExpenseLineResponse testpiuPIUExpenseLine2Result;

    // testpiuPIUExpenseLineToReports
    private static PopulationRequestViewModel testpiuPIUExpenseLineToReportsArg1;
    private static QueryRequest testpiuPIUExpenseLineToReportsMockArg1;
    private static List<DSExpenseLine> testpiuPIUExpenseLineToReportsMockResult;
    private static PIUExpenseLineToReportsResponse testpiuPIUExpenseLineToReportsResult;

    // testpiuPIUExpenseLineToReports2
    private static PopulationRequestViewModel testpiuPIUExpenseLineToReports2Arg1;
    private static QueryRequest testpiuPIUExpenseLineToReports2MockArg1;
    private static List<DSExpenseLine> testpiuPIUExpenseLineToReports2MockResult;
    private static PIUExpenseLineToReportsResponse testpiuPIUExpenseLineToReports2Result;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testGetDSExpenseLine();
        setUpMockData4testGetDSExpenseLine2();
        setUpMockData4testGetDSExpenseLine3();
        setUpMockData4testGetDSExpenseLine4();
        setUpMockData4testGetDSExpenseLineSup();
        setUpMockData4testGetDSExpenseLineSup2();
        setUpMockData4testGetDSExpenseLineSup3();
        setUpMockData4testGetDSExpenseLineSup4();
        setUpMockData4testGetExpenseLine();
        setUpMockData4testGetExpenseLineDynamic();
        setUpMockData4testGetExpenseLinePreload();
        setUpMockData4testGetExpenseLineWithDisplaySetDynamic();
        setUpMockData4testGetExpenseLinePopulationDynamic();
        setUpMockData4testGetExpenseLineByExpenseType();
        setUpMockData4testGetExpenseLineByExpenseReport();
        setUpMockData4testExpenseLineNewline();
        setUpMockData4testExpenseLineNewlineCheckPreconditions();
        setUpMockData4testExpenseLineDeleteline();
        setUpMockData4testExpenseLineDeletelineCheckPreconditions();
        setUpMockData4testExpenseLineEditinstance();
        setUpMockData4testExpenseLineEditinstanceCheckPreconditions();
        setUpMockData4testiiuIIUExpenseLine();
        setUpMockData4testpiuPIUExpenseLine();
        setUpMockData4testpiuPIUExpenseLine2();
        setUpMockData4testpiuPIUExpenseLineToReports();
        setUpMockData4testpiuPIUExpenseLineToReports2();
    }

    private static void setUpMockData4testGetDSExpenseLine() {
        testGetDSExpenseLineArg1 = "";
        testGetDSExpenseLineArg2 = "";
        testGetDSExpenseLineArg3 = "";
        testGetDSExpenseLineResult = new DSExpenseLine();
    }

    private static void setUpMockData4testGetDSExpenseLine2() {
        testGetDSExpenseLine2Arg1 = "";
        testGetDSExpenseLine2Arg2 = null;
        testGetDSExpenseLine2Arg3 = null;
        testGetDSExpenseLine2Result = testGetDSExpenseLineResult;
    }

    private static void setUpMockData4testGetDSExpenseLine3() {
        testGetDSExpenseLine3Arg1 = "";
        testGetDSExpenseLine3Arg2 = null;
        testGetDSExpenseLine3Arg3 = "";
        testGetDSExpenseLine3Result = testGetDSExpenseLineResult;
    }

    private static void setUpMockData4testGetDSExpenseLine4() {
        testGetDSExpenseLine4Arg1 = "";
        testGetDSExpenseLine4Arg2 = "";
        testGetDSExpenseLine4Arg3 = null;
        testGetDSExpenseLine4Result = testGetDSExpenseLineResult;
    }

    private static void setUpMockData4testGetDSExpenseLineSup() {
        testGetDSExpenseLineSupArg1 = "";
        testGetDSExpenseLineSupArg2 = "";
        testGetDSExpenseLineSupArg3 = "";
        testGetDSExpenseLineSupResult = new DSExpenseLineSup();
    }

    private static void setUpMockData4testGetDSExpenseLineSup2() {
        testGetDSExpenseLineSup2Arg1 = "";
        testGetDSExpenseLineSup2Arg2 = null;
        testGetDSExpenseLineSup2Arg3 = null;
        testGetDSExpenseLineSup2Result = testGetDSExpenseLineSupResult;
    }

    private static void setUpMockData4testGetDSExpenseLineSup3() {
        testGetDSExpenseLineSup3Arg1 = "";
        testGetDSExpenseLineSup3Arg2 = null;
        testGetDSExpenseLineSup3Arg3 = "";
        testGetDSExpenseLineSup3Result = testGetDSExpenseLineSupResult;
    }

    private static void setUpMockData4testGetDSExpenseLineSup4() {
        testGetDSExpenseLineSup4Arg1 = "";
        testGetDSExpenseLineSup4Arg2 = "";
        testGetDSExpenseLineSup4Arg3 = null;
        testGetDSExpenseLineSup4Result = testGetDSExpenseLineSupResult;
    }

    private static void setUpMockData4testGetExpenseLine() {
        testGetExpenseLineArg1 = Long.valueOf(0);
        testGetExpenseLineArg2 = Long.valueOf(0);
        testGetExpenseLineResult = new ExpenseLine();
    }

    private static void setUpMockData4testGetExpenseLineDynamic() {
        mockGetExpenseLineDynamicArg1 = new ExpenseLineOid();
        mockGetExpenseLineDynamicArg2 = "";
        testGetExpenseLineDynamicArg1 = new QueryRequest();
        testGetExpenseLineDynamicResult = new InstanceResponseViewModel();
    }

    private static void setUpMockData4testGetExpenseLinePreload() {
        testGetExpenseLinePreloadArg1 = new QueryRequest();
        testGetExpenseLinePreloadResult = new ArrayList<>();
    }

    private static void setUpMockData4testGetExpenseLineWithDisplaySetDynamic() {
        testGetExpenseLineWithDisplaySetDynamicArg1 = new QueryRequest();
        testGetExpenseLineWithDisplaySetDynamicArg1.setDisplaySetName("testGetExpenseLineWithDisplaySetDynamicArg1");
        testGetExpenseLineWithDisplaySetDynamicResult = new PreloadResponseViewModel();
    }

    private static void setUpMockData4testGetExpenseLinePopulationDynamic() {
        testGetExpenseLinePopulationDynamicArg1 = new QueryRequest();
        testGetExpenseLinePopulationDynamicArg1.setDisplaySetName("testGetExpenseLinePopulationDynamicArg1");
        testGetExpenseLinePopulationDynamicResult = new PopulationResponseViewModel();
    }

    private static void setUpMockData4testGetExpenseLineByExpenseType() {
        testGetExpenseLineByExpenseTypeArg1 = new ExpenseTypeOid();
        testGetExpenseLineByExpenseTypeResult = new ArrayList<>();
    }

    private static void setUpMockData4testGetExpenseLineByExpenseReport() {
        testGetExpenseLineByExpenseReportArg1 = new ExpenseReportOid();
        testGetExpenseLineByExpenseReportResult = new ArrayList<>();
    }

    private static void setUpMockData4testExpenseLineNewline() {
        testExpenseLineNewlineArg1 = new NewlineRequest();
        testExpenseLineNewlineResult = new ServiceResponse();
    }

    private static void setUpMockData4testExpenseLineNewlineCheckPreconditions() {
        testExpenseLineNewlineCheckPreconditionsArg1 = new NewlineRequest();
        testExpenseLineNewlineCheckPreconditionsResult = new ServiceResponse();
    }

    private static void setUpMockData4testExpenseLineDeleteline() {
        testExpenseLineDeletelineArg1 = new DeletelineRequest();
        testExpenseLineDeletelineResult = new ServiceResponse();
    }

    private static void setUpMockData4testExpenseLineDeletelineCheckPreconditions() {
        testExpenseLineDeletelineCheckPreconditionsArg1 = new DeletelineRequest();
        testExpenseLineDeletelineCheckPreconditionsResult = new ServiceResponse();
    }

    private static void setUpMockData4testExpenseLineEditinstance() {
        testExpenseLineEditinstanceArg1 = new EditinstanceRequest();
        testExpenseLineEditinstanceResult = new ServiceResponse();
    }

    private static void setUpMockData4testExpenseLineEditinstanceCheckPreconditions() {
        testExpenseLineEditinstanceCheckPreconditionsArg1 = new EditinstanceRequest();
        testExpenseLineEditinstanceCheckPreconditionsResult = new ServiceResponse();
    }

    private static void setUpMockData4testiiuIIUExpenseLine() {
        testiiuIIUExpenseLineArg1 = new ExpenseLineOid();
        testiiuIIUExpenseLineResult = new DSExpenseLine();
    }

    private static void setUpMockData4testpiuPIUExpenseLine() {
        testpiuPIUExpenseLineMockArg1 = new QueryRequest();
        testpiuPIUExpenseLineMockArg1.setPageSize(0);
        testpiuPIUExpenseLineMockResult = new ArrayList<>();
        testpiuPIUExpenseLineArg1 = mock(PopulationRequestViewModel.class);
        testpiuPIUExpenseLineResult = new PIUExpenseLineResponse();
    }

    private static void setUpMockData4testpiuPIUExpenseLine2() {
        testpiuPIUExpenseLine2MockArg1 = new QueryRequest();
        testpiuPIUExpenseLine2MockArg1.setPageSize(1);
        testpiuPIUExpenseLine2MockResult = new ArrayList<>();
        testpiuPIUExpenseLine2MockResult.add(new DSExpenseLine());
        testpiuPIUExpenseLine2Arg1 = mock(PopulationRequestViewModel.class);
        testpiuPIUExpenseLine2Arg1.setPageSize(1);
        testpiuPIUExpenseLine2Result = new PIUExpenseLineResponse();
        testpiuPIUExpenseLine2Result.setTotalItems(1);
    }

    private static void setUpMockData4testpiuPIUExpenseLineToReports() {
        testpiuPIUExpenseLineToReportsMockArg1 = new QueryRequest();
        testpiuPIUExpenseLineToReportsMockArg1.setPageSize(0);
        testpiuPIUExpenseLineToReportsMockResult = new ArrayList<>();
        testpiuPIUExpenseLineToReportsArg1 = mock(PopulationRequestViewModel.class);
        testpiuPIUExpenseLineToReportsResult = new PIUExpenseLineToReportsResponse();
    }

    private static void setUpMockData4testpiuPIUExpenseLineToReports2() {
        testpiuPIUExpenseLineToReports2MockArg1 = new QueryRequest();
        testpiuPIUExpenseLineToReports2MockArg1.setPageSize(1);
        testpiuPIUExpenseLineToReports2MockResult = new ArrayList<>();
        testpiuPIUExpenseLineToReports2MockResult.add(new DSExpenseLine());
        testpiuPIUExpenseLineToReports2Arg1 = mock(PopulationRequestViewModel.class);
        testpiuPIUExpenseLineToReports2Arg1.setPageSize(1);
        testpiuPIUExpenseLineToReports2Result = new PIUExpenseLineToReportsResponse();
        testpiuPIUExpenseLineToReports2Result.setTotalItems(1);
    }

    @Before
    public void setUp() {

        when(mockExpenseLineService.getDSExpenseLine(testGetDSExpenseLineArg1, testGetDSExpenseLineArg2, testGetDSExpenseLineArg3)).thenReturn(testGetDSExpenseLineResult);

        when(mockExpenseLineService.getDSExpenseLineSup(testGetDSExpenseLineSupArg1, testGetDSExpenseLineSupArg2, testGetDSExpenseLineSupArg3)).thenReturn(testGetDSExpenseLineSupResult);

        when(mockExpenseLineService.getById(testGetExpenseLineArg1, testGetExpenseLineArg2)).thenReturn(testGetExpenseLineResult);

        when(mockExpenseLineService.getExpenseLineDynamic(mockGetExpenseLineDynamicArg1, mockGetExpenseLineDynamicArg2)).thenReturn(testGetExpenseLineDynamicResult);

        when(mockExpenseLineService.getPreload(testGetExpenseLinePreloadArg1)).thenReturn(testGetExpenseLinePreloadResult);

        when(mockExpenseLineService.getDynamic(testGetExpenseLineWithDisplaySetDynamicArg1)).thenReturn(testGetExpenseLineWithDisplaySetDynamicResult);

        when(mockExpenseLineService.getDynamic(testGetExpenseLinePopulationDynamicArg1)).thenReturn(testGetExpenseLinePopulationDynamicResult);

        when(mockExpenseLineService.getInstancesByRelated(any(ExpenseType.class), eq("ExpenseType"))).thenReturn(testGetExpenseLineByExpenseTypeResult);

        when(mockExpenseLineService.getInstancesByRelated(any(ExpenseReport.class), eq("ExpenseReport"))).thenReturn(testGetExpenseLineByExpenseReportResult);

        when(mockExpenseLineService.newline(testExpenseLineNewlineArg1)).thenReturn(testExpenseLineNewlineResult);

        when(mockExpenseLineService.newlineCheckPreconditions(testExpenseLineNewlineCheckPreconditionsArg1)).thenReturn(testExpenseLineNewlineCheckPreconditionsResult);

        when(mockExpenseLineService.deleteline(testExpenseLineDeletelineArg1)).thenReturn(testExpenseLineDeletelineResult);

        when(mockExpenseLineService.deletelineCheckPreconditions(testExpenseLineDeletelineCheckPreconditionsArg1)).thenReturn(testExpenseLineDeletelineCheckPreconditionsResult);

        when(mockExpenseLineService.editinstance(testExpenseLineEditinstanceArg1)).thenReturn(testExpenseLineEditinstanceResult);

        when(mockExpenseLineService.editinstanceCheckPreconditions(testExpenseLineEditinstanceCheckPreconditionsArg1)).thenReturn(testExpenseLineEditinstanceCheckPreconditionsResult);

        when(mockExpenseLineService.iIUExpenseLine(testiiuIIUExpenseLineArg1)).thenReturn(testiiuIIUExpenseLineResult);

        when(testpiuPIUExpenseLineArg1.buildQueryRequest()).thenReturn(testpiuPIUExpenseLineMockArg1);

        when(mockExpenseLineService.piuPIUExpenseLine(testpiuPIUExpenseLineMockArg1)).thenReturn(testpiuPIUExpenseLineMockResult);

        when(testpiuPIUExpenseLine2Arg1.buildQueryRequest()).thenReturn(testpiuPIUExpenseLine2MockArg1);

        when(mockExpenseLineService.piuPIUExpenseLine(testpiuPIUExpenseLine2MockArg1)).thenReturn(testpiuPIUExpenseLine2MockResult);

        when(mockExpenseLineService.getCount4PIUExpenseLine(testpiuPIUExpenseLine2MockArg1)).thenReturn(1);

        when(testpiuPIUExpenseLineToReportsArg1.buildQueryRequest()).thenReturn(testpiuPIUExpenseLineToReportsMockArg1);

        when(mockExpenseLineService.piuPIUExpenseLineToReports(testpiuPIUExpenseLineToReportsMockArg1)).thenReturn(testpiuPIUExpenseLineToReportsMockResult);

        when(testpiuPIUExpenseLineToReports2Arg1.buildQueryRequest()).thenReturn(testpiuPIUExpenseLineToReports2MockArg1);

        when(mockExpenseLineService.piuPIUExpenseLineToReports(testpiuPIUExpenseLineToReports2MockArg1)).thenReturn(testpiuPIUExpenseLineToReports2MockResult);

        when(mockExpenseLineService.getCount4PIUExpenseLineToReports(testpiuPIUExpenseLineToReports2MockArg1)).thenReturn(1);
    }

    @Test
    public void testGetDSExpenseLine() {
        assertEquals(testGetDSExpenseLineResult, instanceExpenseLineApi.getDSExpenseLine(testGetDSExpenseLineArg1, testGetDSExpenseLineArg2, testGetDSExpenseLineArg3));
    }

    @Test
    public void testGetDSExpenseLine2() {
        assertEquals(testGetDSExpenseLine2Result, instanceExpenseLineApi.getDSExpenseLine(testGetDSExpenseLine2Arg1, testGetDSExpenseLine2Arg2, testGetDSExpenseLine2Arg3));
    }

    @Test
    public void testGetDSExpenseLine3() {
        assertEquals(testGetDSExpenseLine3Result, instanceExpenseLineApi.getDSExpenseLine(testGetDSExpenseLine3Arg1, testGetDSExpenseLine3Arg2, testGetDSExpenseLine3Arg3));
    }

    @Test
    public void testGetDSExpenseLine4() {
        assertEquals(testGetDSExpenseLine4Result, instanceExpenseLineApi.getDSExpenseLine(testGetDSExpenseLine4Arg1, testGetDSExpenseLine4Arg2, testGetDSExpenseLine4Arg3));
    }

    @Test
    public void testGetDSExpenseLineSup() {
        assertEquals(testGetDSExpenseLineSupResult, instanceExpenseLineApi.getDSExpenseLineSup(testGetDSExpenseLineSupArg1, testGetDSExpenseLineSupArg2, testGetDSExpenseLineSupArg3));
    }

    @Test
    public void testGetDSExpenseLineSup2() {
        assertEquals(testGetDSExpenseLineSup2Result, instanceExpenseLineApi.getDSExpenseLineSup(testGetDSExpenseLineSup2Arg1, testGetDSExpenseLineSup2Arg2, testGetDSExpenseLineSup2Arg3));
    }

    @Test
    public void testGetDSExpenseLineSup3() {
        assertEquals(testGetDSExpenseLineSup3Result, instanceExpenseLineApi.getDSExpenseLineSup(testGetDSExpenseLineSup3Arg1, testGetDSExpenseLineSup3Arg2, testGetDSExpenseLineSup3Arg3));
    }

    @Test
    public void testGetDSExpenseLineSup4() {
        assertEquals(testGetDSExpenseLineSup4Result, instanceExpenseLineApi.getDSExpenseLineSup(testGetDSExpenseLineSup4Arg1, testGetDSExpenseLineSup4Arg2, testGetDSExpenseLineSup4Arg3));
    }

    @Test
    public void testGetExpenseLine() {
        assertEquals(testGetExpenseLineResult, instanceExpenseLineApi.getExpenseLine(testGetExpenseLineArg1, testGetExpenseLineArg2));
    }

    @Test
    public void testGetExpenseLineDynamic() {
        assertEquals(testGetExpenseLineDynamicResult, instanceExpenseLineApi.getExpenseLineDynamic(testGetExpenseLineDynamicArg1));
    }

    @Test
    public void testGetExpenseLinePreload() {
        assertEquals(testGetExpenseLinePreloadResult, instanceExpenseLineApi.getExpenseLinePreload(testGetExpenseLinePreloadArg1));
    }

    @Test
    public void testGetExpenseLineWithDisplaySetDynamic() {
        assertEquals(testGetExpenseLineWithDisplaySetDynamicResult, instanceExpenseLineApi.getExpenseLineWithDisplaySetDynamic(testGetExpenseLineWithDisplaySetDynamicArg1));
    }

    @Test
    public void testGetExpenseLinePopulationDynamic() {
        assertEquals(testGetExpenseLinePopulationDynamicResult, instanceExpenseLineApi.getExpenseLinePopulationDynamic(testGetExpenseLinePopulationDynamicArg1));
    }

    @Test
    public void testGetExpenseLineByExpenseType() {
        assertEquals(testGetExpenseLineByExpenseTypeResult, instanceExpenseLineApi.getExpenseLineByExpenseType(testGetExpenseLineByExpenseTypeArg1));
    }

    @Test
    public void testGetExpenseLineByExpenseReport() {
        assertEquals(testGetExpenseLineByExpenseReportResult, instanceExpenseLineApi.getExpenseLineByExpenseReport(testGetExpenseLineByExpenseReportArg1));
    }

    @Test
    public void testExpenseLineNewline() {
        assertEquals(testExpenseLineNewlineResult, instanceExpenseLineApi.expenseLineNewline(testExpenseLineNewlineArg1));
    }

    @Test
    public void testExpenseLineNewlineCheckPreconditions() {
        assertEquals(testExpenseLineNewlineCheckPreconditionsResult, instanceExpenseLineApi.expenseLineNewlineCheckPreconditions(testExpenseLineNewlineCheckPreconditionsArg1));
    }

    @Test
    public void testExpenseLineDeleteline() {
        assertEquals(testExpenseLineDeletelineResult, instanceExpenseLineApi.expenseLineDeleteline(testExpenseLineDeletelineArg1));
    }

    @Test
    public void testExpenseLineDeletelineCheckPreconditions() {
        assertEquals(testExpenseLineDeletelineCheckPreconditionsResult, instanceExpenseLineApi.expenseLineDeletelineCheckPreconditions(testExpenseLineDeletelineCheckPreconditionsArg1));
    }

    @Test
    public void testExpenseLineEditinstance() {
        assertEquals(testExpenseLineEditinstanceResult, instanceExpenseLineApi.expenseLineEditinstance(testExpenseLineEditinstanceArg1));
    }

    @Test
    public void testExpenseLineEditinstanceCheckPreconditions() {
        assertEquals(testExpenseLineEditinstanceCheckPreconditionsResult, instanceExpenseLineApi.expenseLineEditinstanceCheckPreconditions(testExpenseLineEditinstanceCheckPreconditionsArg1));
    }

    @Test
    public void testiiuIIUExpenseLine() {
        assertEquals(testiiuIIUExpenseLineResult, instanceExpenseLineApi.iiuIIUExpenseLine(testiiuIIUExpenseLineArg1));
    }

    @Test
    public void testpiuPIUExpenseLine() {
        assertEquals(testpiuPIUExpenseLineResult.getTotalItems(), instanceExpenseLineApi.piuPIUExpenseLine(testpiuPIUExpenseLineArg1).getTotalItems());
    }

    @Test
    public void testpiuPIUExpenseLine2() {
        assertEquals(testpiuPIUExpenseLine2Result.getTotalItems(), instanceExpenseLineApi.piuPIUExpenseLine(testpiuPIUExpenseLine2Arg1).getTotalItems());
    }

    @Test
    public void testpiuPIUExpenseLineToReports() {
        assertEquals(testpiuPIUExpenseLineToReportsResult.getTotalItems(), instanceExpenseLineApi.piuPIUExpenseLineToReports(testpiuPIUExpenseLineToReportsArg1).getTotalItems());
    }

    @Test
    public void testpiuPIUExpenseLineToReports2() {
        assertEquals(testpiuPIUExpenseLineToReports2Result.getTotalItems(), instanceExpenseLineApi.piuPIUExpenseLineToReports(testpiuPIUExpenseLineToReports2Arg1).getTotalItems());
    }
}
