package com.integranova.spring.expensereportdemo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.ExpenseLineConstants;
import com.integranova.spring.expensereportdemo.persistence.ExpenseLine;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.ExpenseType;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseLineOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseReportOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseTypeOid;
import com.integranova.spring.expensereportdemo.repository.ExpenseLineJpaRepository;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.viewmodel.expenseline.ds.DSExpenseLine;
import com.integranova.spring.expensereportdemo.viewmodel.expenseline.ds.DSExpenseLineSup;
import com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.DeletelineRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.DeletepaidlineRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.EditinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu.NewlineRequest;
import com.integranova.spring.expensereportdemo.viewmodel.FilterRequest;
import com.integranova.spring.expensereportdemo.viewmodel.FilterVariableRequest;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.QueryRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ServiceResponse;
import java.sql.Date;
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
public class ExpenseLineServiceTest extends ClassTest {

    @InjectMocks
    private ExpenseLineService instanceExpenseLineService;
    
    @Mock
    private static ExpenseLineJpaRepository mockRepository;
    
    @Mock
    private static ExpenseLineService mockExpenseLineService;
    
    @Mock
    private static ExpenseTypeService mockExpenseTypeService;
    
    @Mock
    private static ExpenseReportService mockExpenseReportService;

    private static ExpenseLine mockInstance1;
    
    private static ExpenseLine mockInstance2;

    private static List<ExpenseLine> mockPopulation;

    private static Long mockexpenseReportidExpenseRepor;

    private static Long mockexpenseLineidExpenseLine;

    private static ExpenseLineOid mockExpenseLineOid;

    private static Optional<ExpenseLine> mockExpenseLine; 

    // test4solveQuery
    private static QueryRequest test4solveQueryArg1;
    private static List<Map<String, Object>> test4solveQueryResult;

    // test4get
    private static List<ExpenseLine> test4getResult;

    // test4getQueryRequest
    private static QueryRequest test4getQueryRequestArg1;
    private static List<ExpenseLine> test4getQueryRequestResult;

    // test4getDynamicPopulation
    private static QueryRequest test4getDynamicPopulationArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationResult;

    // test4getDynamicPopulationByOrderCriteriaOCExpenseLine
    private static QueryRequest test4getDynamicPopulationByOrderCriteriaOCExpenseLineArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationByOrderCriteriaOCExpenseLineResult;

    // test4getDynamicPopulationFilterByOID
    private static QueryRequest test4getDynamicPopulationFilterByOIDArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationFilterByOIDResult;

    // test4getDynamicPreload4DSExpenseLine
    private static QueryRequest test4getDynamicPreload4DSExpenseLineArg1;
    private static PreloadResponseViewModel test4getDynamicPreload4DSExpenseLineResult;

    // test4getDynamicPreload4DSExpenseLineSup
    private static QueryRequest test4getDynamicPreload4DSExpenseLineSupArg1;
    private static PreloadResponseViewModel test4getDynamicPreload4DSExpenseLineSupResult;

    // test4getByRelatedDynamic
    private static String test4getByRelatedDynamicArg1;
    private static String test4getByRelatedDynamicArg2;
    private static String test4getByRelatedDynamicArg3;
    private static PopulationResponseViewModel test4getByRelatedDynamicResult;

    // test4getById
    private static Long test4getByIdArg1;
    private static Long test4getByIdArg2;
    private static ExpenseLine test4getByIdResult;

    // test4getByRelated
    private static ExpenseLine test4getByRelatedArg1;
    private static String test4getByRelatedArg2;
    private static List<ExpenseLine> test4getByRelatedResult;

    // test4getInstancesByRelated
    private static ExpenseLine test4getInstancesByRelatedArg1;
    private static String test4getInstancesByRelatedArg2;
    private static List<ExpenseLine> test4getInstancesByRelatedResult;

    // test4getExpenseLineDynamic
    private static ExpenseLineOid test4getExpenseLineDynamicArg1;
    private static String test4getExpenseLineDynamicArg2;
    private static InstanceResponseViewModel test4getExpenseLineDynamicResult;

    // test4getSuppInfoWithoutInstance
    private static ExpenseLineOid test4getSuppInfoWithoutInstanceArg1;
    private static String test4getSuppInfoWithoutInstanceArg2;
    private static String test4getSuppInfoWithoutInstanceResult;

    // test4getSuppInfoWithInstance
    private static ExpenseLineOid test4getSuppInfoWithInstanceArg1;
    private static String test4getSuppInfoWithInstanceArg2;

    // test4getSuppInfoWithDSDSExpenseLineSup
    private static ExpenseLineOid test4getSuppInfoWithDSDSExpenseLineSupArg1;
    private static String test4getSuppInfoWithDSDSExpenseLineSupArg2;

    // test4buildRelatedInstance4RoleExpenseTypeWithoutRemainingPath
    private static String test4buildRelatedInstance4RoleExpenseTypeWithoutRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleExpenseTypeWithoutRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleExpenseTypeWithoutRemainingPathArg3;

    // test4buildRelatedInstance4RoleExpenseTypeWithRemainingPath
    private static String test4buildRelatedInstance4RoleExpenseTypeWithRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleExpenseTypeWithRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleExpenseTypeWithRemainingPathArg3;

    // test4buildRelatedInstance4RoleExpenseReportWithoutRemainingPath
    private static String test4buildRelatedInstance4RoleExpenseReportWithoutRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleExpenseReportWithoutRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleExpenseReportWithoutRemainingPathArg3;

    // test4buildRelatedInstance4RoleExpenseReportWithRemainingPath
    private static String test4buildRelatedInstance4RoleExpenseReportWithRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleExpenseReportWithRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleExpenseReportWithRemainingPathArg3;

    // test4getDSExpenseLine
    private static String test4getDSExpenseLineArg1;
    private static String test4getDSExpenseLineArg2;
    private static String test4getDSExpenseLineArg3;
    private static DSExpenseLine test4getDSExpenseLineResult;

    // test4getPreloadDSExpenseLine
    private static QueryRequest test4getPreloadDSExpenseLineArg1;
    private static List<PreloadViewModel> test4getPreloadDSExpenseLineResult;

    // test4getDSExpenseLineSup
    private static String test4getDSExpenseLineSupArg1;
    private static String test4getDSExpenseLineSupArg2;
    private static String test4getDSExpenseLineSupArg3;
    private static DSExpenseLineSup test4getDSExpenseLineSupResult;

    // test4getPreloadDSExpenseLineSup
    private static QueryRequest test4getPreloadDSExpenseLineSupArg1;
    private static List<PreloadViewModel> test4getPreloadDSExpenseLineSupResult;

    // test4iIUExpenseLine
    private static ExpenseLineOid test4iIUExpenseLineArg1;
    private static DSExpenseLine test4iIUExpenseLineResult;

    // test4piuPIUExpenseLine
    private static QueryRequest test4piuPIUExpenseLineArg1;
    private static List<DSExpenseLine> test4piuPIUExpenseLineResult;

    // test4getCount4PIUExpenseLine
    private static QueryRequest test4getCount4PIUExpenseLineArg1;
    private static int test4getCount4PIUExpenseLineResult;

    // test4piuPIUExpenseLineToReports
    private static QueryRequest test4piuPIUExpenseLineToReportsArg1;
    private static List<DSExpenseLine> test4piuPIUExpenseLineToReportsResult;

    // test4getCount4PIUExpenseLineToReports
    private static QueryRequest test4getCount4PIUExpenseLineToReportsArg1;
    private static int test4getCount4PIUExpenseLineToReportsResult;

    // test4newlineDefault
    private static NewlineRequest test4newlineDefaultArg1;

    // test4newlineInitializedArguments
    private static NewlineRequest test4newlineInitializedArgumentsArg1;

    // test4newlineTxnDefault
    private static NewlineRequest test4newlineTxnDefaultArg1;
    private static ServiceResponse test4newlineTxnDefaultResult;

    // test4newlineTxnInitializedArguments
    private static NewlineRequest test4newlineTxnInitializedArgumentsArg1;
    private static ServiceResponse test4newlineTxnInitializedArgumentsResult;

    // test4newlineImplementationDefault
    private static NewlineRequest test4newlineImplementationDefaultArg1;
    private static ServiceResponse test4newlineImplementationDefaultResult;

    // test4newlineImplementationInitializedArguments
    private static NewlineRequest test4newlineImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4newlineImplementationInitializedArgumentsResult;

    // test4newlineCheckPreconditions
    private static NewlineRequest newlineCheckPreconditionsArg1;
    private static ServiceResponse newlineCheckPreconditionsResult;

    // test4deletelineDefault
    private static DeletelineRequest test4deletelineDefaultArg1;

    // test4deletelineInitializedArguments
    private static DeletelineRequest test4deletelineInitializedArgumentsArg1;

    // test4deletelineTxnDefault
    private static DeletelineRequest test4deletelineTxnDefaultArg1;
    private static ServiceResponse test4deletelineTxnDefaultResult;

    // test4deletelineTxnInitializedArguments
    private static DeletelineRequest test4deletelineTxnInitializedArgumentsArg1;
    private static ServiceResponse test4deletelineTxnInitializedArgumentsResult;

    // test4deletelineImplementationDefault
    private static DeletelineRequest test4deletelineImplementationDefaultArg1;
    private static ServiceResponse test4deletelineImplementationDefaultResult;

    // test4deletelineImplementationInitializedArguments
    private static DeletelineRequest test4deletelineImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4deletelineImplementationInitializedArgumentsResult;

    // test4deletelineCheckPreconditions
    private static DeletelineRequest deletelineCheckPreconditionsArg1;
    private static ServiceResponse deletelineCheckPreconditionsResult;

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

    // test4editinstanceCheckPreconditions
    private static EditinstanceRequest editinstanceCheckPreconditionsArg1;
    private static ServiceResponse editinstanceCheckPreconditionsResult;

    // test4deletepaidlineDefault
    private static DeletepaidlineRequest test4deletepaidlineDefaultArg1;

    // test4deletepaidlineInitializedArguments
    private static DeletepaidlineRequest test4deletepaidlineInitializedArgumentsArg1;

    // test4deletepaidlineTxnDefault
    private static DeletepaidlineRequest test4deletepaidlineTxnDefaultArg1;
    private static ServiceResponse test4deletepaidlineTxnDefaultResult;

    // test4deletepaidlineTxnInitializedArguments
    private static DeletepaidlineRequest test4deletepaidlineTxnInitializedArgumentsArg1;
    private static ServiceResponse test4deletepaidlineTxnInitializedArgumentsResult;

    // test4deletepaidlineImplementationDefault
    private static DeletepaidlineRequest test4deletepaidlineImplementationDefaultArg1;
    private static ServiceResponse test4deletepaidlineImplementationDefaultResult;

    // test4deletepaidlineImplementationInitializedArguments
    private static DeletepaidlineRequest test4deletepaidlineImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4deletepaidlineImplementationInitializedArgumentsResult;

    @BeforeClass
    public static void setUpClass() throws SystemException {
        setUpMockData();
    }

    private static void setUpMockData() throws SystemException {
        mockexpenseReportidExpenseRepor = Long.valueOf(0);
        mockexpenseLineidExpenseLine = Long.valueOf(0);
        mockInstance1 = new ExpenseLine();
        mockInstance2 = new ExpenseLine();
        mockPopulation = new ArrayList<>(Arrays.asList(mockInstance1, mockInstance2));
        mockExpenseLineOid = new ExpenseLineOid(mockexpenseReportidExpenseRepor, mockexpenseLineidExpenseLine);
        mockExpenseLine = Optional.of(new ExpenseLine(new ExpenseLineOid(mockexpenseReportidExpenseRepor,mockexpenseLineidExpenseLine)));
        setUpMockData4test4solveQuery();
        setUpMockData4test4get();
        setUpMockData4test4getQueryRequest();
        setUpMockData4test4getDynamicPopulation();
        setUpMockData4test4getDynamicPopulationByOrderCriteriaOCExpenseLine();
        setUpMockData4test4getDynamicPopulationFilterByOID();
        setUpMockData4test4getDynamicPreload4DSExpenseLine();
        setUpMockData4test4getDynamicPreload4DSExpenseLineSup();
        setUpMockData4test4getByRelatedDynamic();
        setUpMockData4test4getById();
        setUpMockData4test4getByRelated();
        setUpMockData4test4getInstancesByRelated();
        setUpMockData4test4getExpenseLineDynamic();
        setUpMockData4test4getSuppInfoWithoutInstance();
        setUpMockData4test4getSuppInfoWithInstance();
        setUpMockData4test4getSuppInfoWithDSDSExpenseLineSup();
        setUpMockData4test4buildRelatedInstance4RoleExpenseTypeWithoutRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleExpenseTypeWithRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleExpenseReportWithoutRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleExpenseReportWithRemainingPath();
        setUpMockData4test4getDSExpenseLine();
        setUpMockData4test4getPreloadDSExpenseLine();
        setUpMockData4test4getDSExpenseLineSup();
        setUpMockData4test4getPreloadDSExpenseLineSup();
        setUpMockData4test4iIUExpenseLine();
        setUpMockData4test4piuPIUExpenseLine();
        setUpMockData4test4getCount4PIUExpenseLine();
        setUpMockData4test4piuPIUExpenseLineToReports();
        setUpMockData4test4getCount4PIUExpenseLineToReports();
        setUpMockData4test4newlineDefault();
        setUpMockData4test4newlineInitializedArguments();
        setUpMockData4test4newlineTxnDefault();
        setUpMockData4test4newlineTxnInitializedArguments();
        setUpMockData4test4newlineImplementationDefault();
        setUpMockData4test4newlineImplementationInitializedArguments();
        setUpMockData4test4newlineCheckPreconditions();
        setUpMockData4test4deletelineDefault();
        setUpMockData4test4deletelineInitializedArguments();
        setUpMockData4test4deletelineTxnDefault();
        setUpMockData4test4deletelineTxnInitializedArguments();
        setUpMockData4test4deletelineImplementationDefault();
        setUpMockData4test4deletelineImplementationInitializedArguments();
        setUpMockData4test4deletelineCheckPreconditions();
        setUpMockData4test4editinstanceDefault();
        setUpMockData4test4editinstanceInitializedArguments();
        setUpMockData4test4editinstanceTxnDefault();
        setUpMockData4test4editinstanceTxnInitializedArguments();
        setUpMockData4test4editinstanceImplementationDefault();
        setUpMockData4test4editinstanceImplementationInitializedArguments();
        setUpMockData4test4editinstanceCheckPreconditions();
        setUpMockData4test4deletepaidlineDefault();
        setUpMockData4test4deletepaidlineInitializedArguments();
        setUpMockData4test4deletepaidlineTxnDefault();
        setUpMockData4test4deletepaidlineTxnInitializedArguments();
        setUpMockData4test4deletepaidlineImplementationDefault();
        setUpMockData4test4deletepaidlineImplementationInitializedArguments();
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
        test4getDynamicPopulationArg1.setDisplaySetItems("expenseReportidExpenseRepor");
        test4getDynamicPopulationResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationByOrderCriteriaOCExpenseLine() {
        test4getDynamicPopulationByOrderCriteriaOCExpenseLineArg1 = new QueryRequest();
        test4getDynamicPopulationByOrderCriteriaOCExpenseLineArg1.setDisplaySetItems("expenseReportidExpenseRepor");
        test4getDynamicPopulationByOrderCriteriaOCExpenseLineArg1.setOrderCriteriaName("OCExpenseLine");
        test4getDynamicPopulationByOrderCriteriaOCExpenseLineResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationFilterByOID() {
        test4getDynamicPopulationFilterByOIDArg1 = new QueryRequest();
        test4getDynamicPopulationFilterByOIDArg1.setDisplaySetItems("expenseReportidExpenseRepor");
        test4getDynamicPopulationFilterByOIDArg1.addFilterRequest(new FilterRequest(Constants.FILTER_BY_OID,new ArrayList<>(Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_OID_FVAR_OID, new ExpenseLineOid(Long.valueOf(0), Long.valueOf(0)))))));
        test4getDynamicPopulationFilterByOIDResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPreload4DSExpenseLine() {
        test4getDynamicPreload4DSExpenseLineArg1 = new QueryRequest();
        test4getDynamicPreload4DSExpenseLineArg1.setDisplaySetName(ExpenseLineConstants.DSDSEXPENSELINE);
        test4getDynamicPreload4DSExpenseLineResult = new PreloadResponseViewModel(mockPopulation.stream().map(i -> ExpenseLineService.buildPreloadViewModel(i, test4getDynamicPreload4DSExpenseLineArg1.getDisplaySetName())).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPreload4DSExpenseLineSup() {
        test4getDynamicPreload4DSExpenseLineSupArg1 = new QueryRequest();
        test4getDynamicPreload4DSExpenseLineSupArg1.setDisplaySetName(ExpenseLineConstants.DSDSEXPENSELINESUP);
        test4getDynamicPreload4DSExpenseLineSupResult = new PreloadResponseViewModel(mockPopulation.stream().map(i -> ExpenseLineService.buildPreloadViewModel(i, test4getDynamicPreload4DSExpenseLineSupArg1.getDisplaySetName())).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getByRelatedDynamic() {
        test4getByRelatedDynamicArg1 = "";
        test4getByRelatedDynamicArg2 = "";
        test4getByRelatedDynamicArg3 = "";
        test4getByRelatedDynamicResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getById() {
        test4getByIdArg1 = Long.valueOf(0);
        test4getByIdArg2 = Long.valueOf(0);
        test4getByIdResult = mockExpenseLine.get();
    }

    private static void setUpMockData4test4getByRelated() {
        test4getByRelatedArg1 = new ExpenseLine();
        test4getByRelatedArg2 = "";
        test4getByRelatedResult = mockPopulation;
    }

    private static void setUpMockData4test4getInstancesByRelated() {
        test4getInstancesByRelatedArg1 = new ExpenseLine();
        test4getInstancesByRelatedArg2 = "";
        test4getInstancesByRelatedResult = mockPopulation;
    }

    private static void setUpMockData4test4getExpenseLineDynamic() {
        test4getExpenseLineDynamicArg1 = new ExpenseLineOid();
        test4getExpenseLineDynamicArg2 = "";
        test4getExpenseLineDynamicResult = new InstanceResponseViewModel();
    }

    private static void setUpMockData4test4getSuppInfoWithoutInstance() {
        test4getSuppInfoWithoutInstanceArg1 = new ExpenseLineOid();
        test4getSuppInfoWithoutInstanceArg2 = "";
        test4getSuppInfoWithoutInstanceResult = "";
    }

    private static void setUpMockData4test4getSuppInfoWithInstance() {
        test4getSuppInfoWithInstanceArg1 = new ExpenseLineOid(Long.valueOf(0), Long.valueOf(0));
        test4getSuppInfoWithInstanceArg2 = "";
    }

    private static void setUpMockData4test4getSuppInfoWithDSDSExpenseLineSup() {
        test4getSuppInfoWithDSDSExpenseLineSupArg1 = new ExpenseLineOid(Long.valueOf(0), Long.valueOf(0));
        test4getSuppInfoWithDSDSExpenseLineSupArg2 = ExpenseLineConstants.DSDSEXPENSELINESUP;
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleExpenseTypeWithoutRemainingPath() {
        test4buildRelatedInstance4RoleExpenseTypeWithoutRemainingPathArg1 = new ExpenseTypeOid("").toJson();
        test4buildRelatedInstance4RoleExpenseTypeWithoutRemainingPathArg2 = ExpenseLineConstants.ROLE_NAME_EXPENSETYPE;
        test4buildRelatedInstance4RoleExpenseTypeWithoutRemainingPathArg3 = "";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleExpenseTypeWithRemainingPath() {
        test4buildRelatedInstance4RoleExpenseTypeWithRemainingPathArg1 = new ExpenseTypeOid("").toJson();
        test4buildRelatedInstance4RoleExpenseTypeWithRemainingPathArg2 = ExpenseLineConstants.ROLE_NAME_EXPENSETYPE;
        test4buildRelatedInstance4RoleExpenseTypeWithRemainingPathArg3 = "dummy";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleExpenseReportWithoutRemainingPath() {
        test4buildRelatedInstance4RoleExpenseReportWithoutRemainingPathArg1 = new ExpenseReportOid(Long.valueOf(0)).toJson();
        test4buildRelatedInstance4RoleExpenseReportWithoutRemainingPathArg2 = ExpenseLineConstants.ROLE_NAME_EXPENSEREPORT;
        test4buildRelatedInstance4RoleExpenseReportWithoutRemainingPathArg3 = "";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleExpenseReportWithRemainingPath() {
        test4buildRelatedInstance4RoleExpenseReportWithRemainingPathArg1 = new ExpenseReportOid(Long.valueOf(0)).toJson();
        test4buildRelatedInstance4RoleExpenseReportWithRemainingPathArg2 = ExpenseLineConstants.ROLE_NAME_EXPENSEREPORT;
        test4buildRelatedInstance4RoleExpenseReportWithRemainingPathArg3 = "dummy";
    }

    private static void setUpMockData4test4getDSExpenseLine() {
        test4getDSExpenseLineArg1 = "";
        test4getDSExpenseLineArg2 = "";
        test4getDSExpenseLineArg3 = "";
        test4getDSExpenseLineResult = new DSExpenseLine();
    }

    private static void setUpMockData4test4getPreloadDSExpenseLine() {
        test4getPreloadDSExpenseLineArg1 = new QueryRequest();
        test4getPreloadDSExpenseLineArg1.setDisplaySetName(ExpenseLineConstants.DSDSEXPENSELINE);
        test4getPreloadDSExpenseLineResult = mockPopulation.stream().map(i -> ExpenseLineService.buildPreloadViewModel(i, test4getPreloadDSExpenseLineArg1.getDisplaySetName())).collect(Collectors.toList());
    }

    private static void setUpMockData4test4getDSExpenseLineSup() {
        test4getDSExpenseLineSupArg1 = "";
        test4getDSExpenseLineSupArg2 = "";
        test4getDSExpenseLineSupArg3 = "";
        test4getDSExpenseLineSupResult = new DSExpenseLineSup();
    }

    private static void setUpMockData4test4getPreloadDSExpenseLineSup() {
        test4getPreloadDSExpenseLineSupArg1 = new QueryRequest();
        test4getPreloadDSExpenseLineSupArg1.setDisplaySetName(ExpenseLineConstants.DSDSEXPENSELINESUP);
        test4getPreloadDSExpenseLineSupResult = mockPopulation.stream().map(i -> ExpenseLineService.buildPreloadViewModel(i, test4getPreloadDSExpenseLineSupArg1.getDisplaySetName())).collect(Collectors.toList());
    }

    private static void setUpMockData4test4iIUExpenseLine() {
        test4iIUExpenseLineArg1 = new ExpenseLineOid();
        test4iIUExpenseLineResult = new DSExpenseLine();
    }

    private static void setUpMockData4test4piuPIUExpenseLine() {
        test4piuPIUExpenseLineArg1 = new QueryRequest();
        test4piuPIUExpenseLineResult = mockPopulation.stream().map(i -> new DSExpenseLine(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4getCount4PIUExpenseLine() {
        test4getCount4PIUExpenseLineArg1 = new QueryRequest();
        test4getCount4PIUExpenseLineResult = mockPopulation.size();
    }

    private static void setUpMockData4test4piuPIUExpenseLineToReports() {
        test4piuPIUExpenseLineToReportsArg1 = new QueryRequest();
        test4piuPIUExpenseLineToReportsResult = mockPopulation.stream().map(i -> new DSExpenseLine(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4getCount4PIUExpenseLineToReports() {
        test4getCount4PIUExpenseLineToReportsArg1 = new QueryRequest();
        test4getCount4PIUExpenseLineToReportsResult = mockPopulation.size();
    }

    private static void setUpMockData4test4newlineDefault() {
        test4newlineDefaultArg1 = new NewlineRequest();
    }

    private static void setUpMockData4test4newlineInitializedArguments() {
        test4newlineInitializedArgumentsArg1 = new NewlineRequest();
        test4newlineInitializedArgumentsArg1.setExpenseLinenewlinepagrExpenseType(new ExpenseTypeOid("").toJson());
        test4newlineInitializedArgumentsArg1.setExpenseLinenewlinepagrExpenseTypeInstance(new ExpenseType(new ExpenseTypeOid().fromJsonString(test4newlineInitializedArgumentsArg1.getExpenseLinenewlinepagrExpenseType())));
        test4newlineInitializedArgumentsArg1.setExpenseLinenewlinepagrExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4newlineInitializedArgumentsArg1.setExpenseLinenewlinepagrExpenseReportInstance(new ExpenseReport(test4newlineInitializedArgumentsArg1.getExpenseLinenewlinepagrExpenseReport()));
        test4newlineInitializedArgumentsArg1.setExpenseLinenewlinepatrUnits(Double.valueOf(0));
        test4newlineInitializedArgumentsArg1.setExpenseLinenewlinepatrPrice(Double.valueOf(0));
        test4newlineInitializedArgumentsArg1.setExpenseLinenewlinepatrExpenseDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        test4newlineInitializedArgumentsArg1.setExpenseLinenewlinepatrLnDescription("");
    }

    private static void setUpMockData4test4newlineTxnDefault() {
        test4newlineTxnDefaultArg1 = new NewlineRequest();
        test4newlineTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4newlineTxnInitializedArguments() {
        test4newlineTxnInitializedArgumentsArg1 = new NewlineRequest();
        test4newlineTxnInitializedArgumentsArg1.setExpenseLinenewlinepagrExpenseType(new ExpenseTypeOid("").toJson());
        test4newlineTxnInitializedArgumentsArg1.setExpenseLinenewlinepagrExpenseTypeInstance(new ExpenseType(new ExpenseTypeOid().fromJsonString(test4newlineTxnInitializedArgumentsArg1.getExpenseLinenewlinepagrExpenseType())));
        test4newlineTxnInitializedArgumentsArg1.setExpenseLinenewlinepagrExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4newlineTxnInitializedArgumentsArg1.setExpenseLinenewlinepagrExpenseReportInstance(new ExpenseReport(test4newlineTxnInitializedArgumentsArg1.getExpenseLinenewlinepagrExpenseReport()));
        test4newlineTxnInitializedArgumentsArg1.setExpenseLinenewlinepatrUnits(Double.valueOf(0));
        test4newlineTxnInitializedArgumentsArg1.setExpenseLinenewlinepatrPrice(Double.valueOf(0));
        test4newlineTxnInitializedArgumentsArg1.setExpenseLinenewlinepatrExpenseDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        test4newlineTxnInitializedArgumentsArg1.setExpenseLinenewlinepatrLnDescription("");
        test4newlineTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4newlineImplementationDefault() {
        test4newlineImplementationDefaultArg1 = new NewlineRequest();
        test4newlineImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4newlineImplementationInitializedArguments() {
        test4newlineImplementationInitializedArgumentsArg1 = new NewlineRequest();
        test4newlineImplementationInitializedArgumentsArg1.setExpenseLinenewlinepagrExpenseType(new ExpenseTypeOid("").toJson());
        test4newlineImplementationInitializedArgumentsArg1.setExpenseLinenewlinepagrExpenseTypeInstance(new ExpenseType(new ExpenseTypeOid().fromJsonString(test4newlineImplementationInitializedArgumentsArg1.getExpenseLinenewlinepagrExpenseType())));
        test4newlineImplementationInitializedArgumentsArg1.setExpenseLinenewlinepagrExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4newlineImplementationInitializedArgumentsArg1.setExpenseLinenewlinepagrExpenseReportInstance(new ExpenseReport(test4newlineImplementationInitializedArgumentsArg1.getExpenseLinenewlinepagrExpenseReport()));
        test4newlineImplementationInitializedArgumentsArg1.setExpenseLinenewlinepatrUnits(Double.valueOf(0));
        test4newlineImplementationInitializedArgumentsArg1.setExpenseLinenewlinepatrPrice(Double.valueOf(0));
        test4newlineImplementationInitializedArgumentsArg1.setExpenseLinenewlinepatrExpenseDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        test4newlineImplementationInitializedArgumentsArg1.setExpenseLinenewlinepatrLnDescription("");
        test4newlineImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4newlineCheckPreconditions() {
        newlineCheckPreconditionsArg1 = new NewlineRequest();
        newlineCheckPreconditionsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deletelineDefault() {
        test4deletelineDefaultArg1 = new DeletelineRequest();
    }

    private static void setUpMockData4test4deletelineInitializedArguments() {
        test4deletelineInitializedArgumentsArg1 = new DeletelineRequest();
        test4deletelineInitializedArgumentsArg1.setExpenseLinedeletelinepthisExpenseLine(new ExpenseLineOid(Long.valueOf(0), Long.valueOf(0)));
        test4deletelineInitializedArgumentsArg1.setExpenseLinedeletelinepthisExpenseLineInstance(new ExpenseLine(test4deletelineInitializedArgumentsArg1.getExpenseLinedeletelinepthisExpenseLine()));
    }

    private static void setUpMockData4test4deletelineTxnDefault() {
        test4deletelineTxnDefaultArg1 = new DeletelineRequest();
        test4deletelineTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deletelineTxnInitializedArguments() {
        test4deletelineTxnInitializedArgumentsArg1 = new DeletelineRequest();
        test4deletelineTxnInitializedArgumentsArg1.setExpenseLinedeletelinepthisExpenseLine(new ExpenseLineOid(Long.valueOf(0), Long.valueOf(0)));
        test4deletelineTxnInitializedArgumentsArg1.setExpenseLinedeletelinepthisExpenseLineInstance(new ExpenseLine(test4deletelineTxnInitializedArgumentsArg1.getExpenseLinedeletelinepthisExpenseLine()));
        test4deletelineTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deletelineImplementationDefault() {
        test4deletelineImplementationDefaultArg1 = new DeletelineRequest();
        test4deletelineImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deletelineImplementationInitializedArguments() {
        test4deletelineImplementationInitializedArgumentsArg1 = new DeletelineRequest();
        test4deletelineImplementationInitializedArgumentsArg1.setExpenseLinedeletelinepthisExpenseLine(new ExpenseLineOid(Long.valueOf(0), Long.valueOf(0)));
        test4deletelineImplementationInitializedArgumentsArg1.setExpenseLinedeletelinepthisExpenseLineInstance(new ExpenseLine(test4deletelineImplementationInitializedArgumentsArg1.getExpenseLinedeletelinepthisExpenseLine()));
        test4deletelineImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deletelineCheckPreconditions() {
        deletelineCheckPreconditionsArg1 = new DeletelineRequest();
        deletelineCheckPreconditionsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceDefault() {
        test4editinstanceDefaultArg1 = new EditinstanceRequest();
    }

    private static void setUpMockData4test4editinstanceInitializedArguments() {
        test4editinstanceInitializedArgumentsArg1 = new EditinstanceRequest();
        test4editinstanceInitializedArgumentsArg1.setExpenseLineeditinstancepthisExpenseLine(new ExpenseLineOid(Long.valueOf(0), Long.valueOf(0)));
        test4editinstanceInitializedArgumentsArg1.setExpenseLineeditinstancepthisExpenseLineInstance(new ExpenseLine(test4editinstanceInitializedArgumentsArg1.getExpenseLineeditinstancepthisExpenseLine()));
        test4editinstanceInitializedArgumentsArg1.setExpenseLineeditinstancepExpenseDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        test4editinstanceInitializedArgumentsArg1.setExpenseLineeditinstancepUnits(Double.valueOf(0));
        test4editinstanceInitializedArgumentsArg1.setExpenseLineeditinstancepPrice(Double.valueOf(0));
        test4editinstanceInitializedArgumentsArg1.setExpenseLineeditinstancepLnDescription("");
    }

    private static void setUpMockData4test4editinstanceTxnDefault() {
        test4editinstanceTxnDefaultArg1 = new EditinstanceRequest();
        test4editinstanceTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceTxnInitializedArguments() {
        test4editinstanceTxnInitializedArgumentsArg1 = new EditinstanceRequest();
        test4editinstanceTxnInitializedArgumentsArg1.setExpenseLineeditinstancepthisExpenseLine(new ExpenseLineOid(Long.valueOf(0), Long.valueOf(0)));
        test4editinstanceTxnInitializedArgumentsArg1.setExpenseLineeditinstancepthisExpenseLineInstance(new ExpenseLine(test4editinstanceTxnInitializedArgumentsArg1.getExpenseLineeditinstancepthisExpenseLine()));
        test4editinstanceTxnInitializedArgumentsArg1.setExpenseLineeditinstancepExpenseDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        test4editinstanceTxnInitializedArgumentsArg1.setExpenseLineeditinstancepUnits(Double.valueOf(0));
        test4editinstanceTxnInitializedArgumentsArg1.setExpenseLineeditinstancepPrice(Double.valueOf(0));
        test4editinstanceTxnInitializedArgumentsArg1.setExpenseLineeditinstancepLnDescription("");
        test4editinstanceTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceImplementationDefault() {
        test4editinstanceImplementationDefaultArg1 = new EditinstanceRequest();
        test4editinstanceImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceImplementationInitializedArguments() {
        test4editinstanceImplementationInitializedArgumentsArg1 = new EditinstanceRequest();
        test4editinstanceImplementationInitializedArgumentsArg1.setExpenseLineeditinstancepthisExpenseLine(new ExpenseLineOid(Long.valueOf(0), Long.valueOf(0)));
        test4editinstanceImplementationInitializedArgumentsArg1.setExpenseLineeditinstancepthisExpenseLineInstance(new ExpenseLine(test4editinstanceImplementationInitializedArgumentsArg1.getExpenseLineeditinstancepthisExpenseLine()));
        test4editinstanceImplementationInitializedArgumentsArg1.setExpenseLineeditinstancepExpenseDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        test4editinstanceImplementationInitializedArgumentsArg1.setExpenseLineeditinstancepUnits(Double.valueOf(0));
        test4editinstanceImplementationInitializedArgumentsArg1.setExpenseLineeditinstancepPrice(Double.valueOf(0));
        test4editinstanceImplementationInitializedArgumentsArg1.setExpenseLineeditinstancepLnDescription("");
        test4editinstanceImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceCheckPreconditions() {
        editinstanceCheckPreconditionsArg1 = new EditinstanceRequest();
        editinstanceCheckPreconditionsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deletepaidlineDefault() {
        test4deletepaidlineDefaultArg1 = new DeletepaidlineRequest();
    }

    private static void setUpMockData4test4deletepaidlineInitializedArguments() {
        test4deletepaidlineInitializedArgumentsArg1 = new DeletepaidlineRequest();
        test4deletepaidlineInitializedArgumentsArg1.setExpenseLinedeletepaidlinepthisExpenseLine(new ExpenseLineOid(Long.valueOf(0), Long.valueOf(0)));
        test4deletepaidlineInitializedArgumentsArg1.setExpenseLinedeletepaidlinepthisExpenseLineInstance(new ExpenseLine(test4deletepaidlineInitializedArgumentsArg1.getExpenseLinedeletepaidlinepthisExpenseLine()));
    }

    private static void setUpMockData4test4deletepaidlineTxnDefault() {
        test4deletepaidlineTxnDefaultArg1 = new DeletepaidlineRequest();
        test4deletepaidlineTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deletepaidlineTxnInitializedArguments() {
        test4deletepaidlineTxnInitializedArgumentsArg1 = new DeletepaidlineRequest();
        test4deletepaidlineTxnInitializedArgumentsArg1.setExpenseLinedeletepaidlinepthisExpenseLine(new ExpenseLineOid(Long.valueOf(0), Long.valueOf(0)));
        test4deletepaidlineTxnInitializedArgumentsArg1.setExpenseLinedeletepaidlinepthisExpenseLineInstance(new ExpenseLine(test4deletepaidlineTxnInitializedArgumentsArg1.getExpenseLinedeletepaidlinepthisExpenseLine()));
        test4deletepaidlineTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deletepaidlineImplementationDefault() {
        test4deletepaidlineImplementationDefaultArg1 = new DeletepaidlineRequest();
        test4deletepaidlineImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deletepaidlineImplementationInitializedArguments() {
        test4deletepaidlineImplementationInitializedArgumentsArg1 = new DeletepaidlineRequest();
        test4deletepaidlineImplementationInitializedArgumentsArg1.setExpenseLinedeletepaidlinepthisExpenseLine(new ExpenseLineOid(Long.valueOf(0), Long.valueOf(0)));
        test4deletepaidlineImplementationInitializedArgumentsArg1.setExpenseLinedeletepaidlinepthisExpenseLineInstance(new ExpenseLine(test4deletepaidlineImplementationInitializedArgumentsArg1.getExpenseLinedeletepaidlinepthisExpenseLine()));
        test4deletepaidlineImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(instanceExpenseLineService, "expenseLineSrv", instanceExpenseLineService);

        when(mockExpenseTypeService.getByOIDWithHV(new ExpenseTypeOid().fromJsonString(test4newlineInitializedArgumentsArg1.getExpenseLinenewlinepagrExpenseType()))).thenReturn(test4newlineInitializedArgumentsArg1.getExpenseLinenewlinepagrExpenseTypeInstance());

        when(mockExpenseReportService.getByOIDWithHV(test4newlineInitializedArgumentsArg1.getExpenseLinenewlinepagrExpenseReport())).thenReturn(test4newlineInitializedArgumentsArg1.getExpenseLinenewlinepagrExpenseReportInstance());

        when(mockExpenseTypeService.getByOIDWithHV(new ExpenseTypeOid().fromJsonString(test4newlineTxnInitializedArgumentsArg1.getExpenseLinenewlinepagrExpenseType()))).thenReturn(test4newlineTxnInitializedArgumentsArg1.getExpenseLinenewlinepagrExpenseTypeInstance());

        when(mockExpenseReportService.getByOIDWithHV(test4newlineTxnInitializedArgumentsArg1.getExpenseLinenewlinepagrExpenseReport())).thenReturn(test4newlineTxnInitializedArgumentsArg1.getExpenseLinenewlinepagrExpenseReportInstance());

        when(mockExpenseLineService.getByOIDWithHV(test4deletelineInitializedArgumentsArg1.getExpenseLinedeletelinepthisExpenseLine())).thenReturn(test4deletelineInitializedArgumentsArg1.getExpenseLinedeletelinepthisExpenseLineInstance());

        when(mockExpenseLineService.getByOIDWithHV(test4deletelineTxnInitializedArgumentsArg1.getExpenseLinedeletelinepthisExpenseLine())).thenReturn(test4deletelineTxnInitializedArgumentsArg1.getExpenseLinedeletelinepthisExpenseLineInstance());

        when(mockExpenseLineService.getByOIDWithHV(test4editinstanceInitializedArgumentsArg1.getExpenseLineeditinstancepthisExpenseLine())).thenReturn(test4editinstanceInitializedArgumentsArg1.getExpenseLineeditinstancepthisExpenseLineInstance());

        when(mockExpenseLineService.getByOIDWithHV(test4editinstanceTxnInitializedArgumentsArg1.getExpenseLineeditinstancepthisExpenseLine())).thenReturn(test4editinstanceTxnInitializedArgumentsArg1.getExpenseLineeditinstancepthisExpenseLineInstance());

        when(mockExpenseLineService.getByOIDWithHV(test4deletepaidlineInitializedArgumentsArg1.getExpenseLinedeletepaidlinepthisExpenseLine())).thenReturn(test4deletepaidlineInitializedArgumentsArg1.getExpenseLinedeletepaidlinepthisExpenseLineInstance());

        when(mockExpenseLineService.getByOIDWithHV(test4deletepaidlineTxnInitializedArgumentsArg1.getExpenseLinedeletepaidlinepthisExpenseLine())).thenReturn(test4deletepaidlineTxnInitializedArgumentsArg1.getExpenseLinedeletepaidlinepthisExpenseLineInstance());

        when(mockRepository.findById(mockExpenseLineOid)).thenAnswer(new Answer<Optional<ExpenseLine>>(){
        	public Optional<ExpenseLine> answer(InvocationOnMock invocation) {
        		if (invocation.getArgument(0).equals(mockExpenseLineOid)) {
        			return mockExpenseLine;
                }
        		return Optional.empty();
        	}
        });
        when(mockRepository.save(any(ExpenseLine.class))).thenReturn(mockInstance1);
        when(mockRepository.solveQuery(any(SQLSelect.class))).thenReturn(mockPopulation);
        when(mockRepository.solveQuery(any(SQLSelect.class), anyInt(), anyInt())).thenReturn(mockPopulation);
    }
    
    @After
    public void tearDown() {
        instanceExpenseLineService = null;
    }

    @Test
    public void test4solveQuery() {
        assertEquals(test4solveQueryResult, instanceExpenseLineService.solveQuery(test4solveQueryArg1));
    }

    @Test
    public void test4get() {
        assertEquals(test4getResult, instanceExpenseLineService.get());
    }

    @Test
    public void test4getQueryRequest() {
        assertEquals(test4getQueryRequestResult, instanceExpenseLineService.get(test4getQueryRequestArg1));
    }

    @Test
    public void test4getDynamicPopulation() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationResult), getResult(TOTALITEMS, instanceExpenseLineService.getDynamic(test4getDynamicPopulationArg1)));
    }

    @Test
    public void test4getDynamicPopulationByOrderCriteriaOCExpenseLine() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationByOrderCriteriaOCExpenseLineResult), getResult(TOTALITEMS, instanceExpenseLineService.getDynamic(test4getDynamicPopulationByOrderCriteriaOCExpenseLineArg1)));
    }

    @Test
    public void test4getDynamicPopulationFilterByOID() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationFilterByOIDResult), getResult(TOTALITEMS, instanceExpenseLineService.getDynamic(test4getDynamicPopulationFilterByOIDArg1)));
    }

    @Test
    public void test4getDynamicPreload4DSExpenseLine() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPreload4DSExpenseLineResult), getResult(TOTALITEMS, instanceExpenseLineService.getDynamic(test4getDynamicPreload4DSExpenseLineArg1)));
    }

    @Test
    public void test4getDynamicPreload4DSExpenseLineSup() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPreload4DSExpenseLineSupResult), getResult(TOTALITEMS, instanceExpenseLineService.getDynamic(test4getDynamicPreload4DSExpenseLineSupArg1)));
    }

    @Test
    public void test4getByRelatedDynamic() {
        assertEquals(getResult(RESULTS_SIZE, test4getByRelatedDynamicResult), getResult(RESULTS_SIZE, instanceExpenseLineService.getByRelatedDynamic(test4getByRelatedDynamicArg1, test4getByRelatedDynamicArg2, test4getByRelatedDynamicArg3)));
    }

    @Test
    public void test4getById() {
        assertEquals(test4getByIdResult, instanceExpenseLineService.getById(test4getByIdArg1, test4getByIdArg2));
    }

    @Test
    public void test4getByRelated() {
        assertEquals(test4getByRelatedResult, instanceExpenseLineService.getByRelated(test4getByRelatedArg1, test4getByRelatedArg2));
    }

    @Test
    public void test4getInstancesByRelated() {
        assertEquals(test4getInstancesByRelatedResult, instanceExpenseLineService.getInstancesByRelated(test4getInstancesByRelatedArg1, test4getInstancesByRelatedArg2));
    }

    @Test
    public void test4getExpenseLineDynamic() {
        assertEquals(test4getExpenseLineDynamicResult.getResultCode(), instanceExpenseLineService.getExpenseLineDynamic(test4getExpenseLineDynamicArg1, test4getExpenseLineDynamicArg2).getResultCode());
    }

    @Test
    public void test4getSuppInfoWithoutInstance() {
        assertEquals(test4getSuppInfoWithoutInstanceResult, instanceExpenseLineService.getSuppInfo(test4getSuppInfoWithoutInstanceArg1, test4getSuppInfoWithoutInstanceArg2));
    }

    @Test
    public void test4getSuppInfoWithInstance() {
        instanceExpenseLineService.getSuppInfo(test4getSuppInfoWithInstanceArg1, test4getSuppInfoWithInstanceArg2);
        assertNotNull(instanceExpenseLineService);
    }

    @Test
    public void test4getSuppInfoWithDSDSExpenseLineSup() {
        instanceExpenseLineService.getSuppInfo(test4getSuppInfoWithDSDSExpenseLineSupArg1, test4getSuppInfoWithDSDSExpenseLineSupArg2);
        assertNotNull(instanceExpenseLineService);
    }

    @Test
    public void test4buildRelatedInstance4RoleExpenseTypeWithoutRemainingPath() {
        instanceExpenseLineService.buildRelatedInstance(test4buildRelatedInstance4RoleExpenseTypeWithoutRemainingPathArg1, test4buildRelatedInstance4RoleExpenseTypeWithoutRemainingPathArg2, test4buildRelatedInstance4RoleExpenseTypeWithoutRemainingPathArg3);
        assertNotNull(instanceExpenseLineService);
    }

    @Test
    public void test4buildRelatedInstance4RoleExpenseTypeWithRemainingPath() {
        instanceExpenseLineService.buildRelatedInstance(test4buildRelatedInstance4RoleExpenseTypeWithRemainingPathArg1, test4buildRelatedInstance4RoleExpenseTypeWithRemainingPathArg2, test4buildRelatedInstance4RoleExpenseTypeWithRemainingPathArg3);
        assertNotNull(instanceExpenseLineService);
    }

    @Test
    public void test4buildRelatedInstance4RoleExpenseReportWithoutRemainingPath() {
        instanceExpenseLineService.buildRelatedInstance(test4buildRelatedInstance4RoleExpenseReportWithoutRemainingPathArg1, test4buildRelatedInstance4RoleExpenseReportWithoutRemainingPathArg2, test4buildRelatedInstance4RoleExpenseReportWithoutRemainingPathArg3);
        assertNotNull(instanceExpenseLineService);
    }

    @Test
    public void test4buildRelatedInstance4RoleExpenseReportWithRemainingPath() {
        instanceExpenseLineService.buildRelatedInstance(test4buildRelatedInstance4RoleExpenseReportWithRemainingPathArg1, test4buildRelatedInstance4RoleExpenseReportWithRemainingPathArg2, test4buildRelatedInstance4RoleExpenseReportWithRemainingPathArg3);
        assertNotNull(instanceExpenseLineService);
    }

    @Test
    public void test4getDSExpenseLine() {
        assertEquals(test4getDSExpenseLineResult.getClass(), instanceExpenseLineService.getDSExpenseLine(test4getDSExpenseLineArg1, test4getDSExpenseLineArg2, test4getDSExpenseLineArg3).getClass());
    }

    @Test
    public void test4getPreloadDSExpenseLine() {
        instanceExpenseLineService.getPreload(test4getPreloadDSExpenseLineArg1);
        assertNotNull(instanceExpenseLineService);
    }

    @Test
    public void test4getDSExpenseLineSup() {
        assertEquals(test4getDSExpenseLineSupResult.getClass(), instanceExpenseLineService.getDSExpenseLineSup(test4getDSExpenseLineSupArg1, test4getDSExpenseLineSupArg2, test4getDSExpenseLineSupArg3).getClass());
    }

    @Test
    public void test4getPreloadDSExpenseLineSup() {
        instanceExpenseLineService.getPreload(test4getPreloadDSExpenseLineSupArg1);
        assertNotNull(instanceExpenseLineService);
    }

    @Test
    public void test4iIUExpenseLine() {
        assertEquals(test4iIUExpenseLineResult.getDSExpenseLineIdExpenseLine(), instanceExpenseLineService.iIUExpenseLine(test4iIUExpenseLineArg1).getDSExpenseLineIdExpenseLine());
    }

    @Test
    public void test4piuPIUExpenseLine() {
        instanceExpenseLineService.piuPIUExpenseLine(test4piuPIUExpenseLineArg1);
        assertNotNull(instanceExpenseLineService);
    }

    @Test
    public void test4getCount4PIUExpenseLine() {
        instanceExpenseLineService.getCount4PIUExpenseLine(test4getCount4PIUExpenseLineArg1);
        assertNotNull(instanceExpenseLineService);
    }

    @Test
    public void test4piuPIUExpenseLineToReports() {
        instanceExpenseLineService.piuPIUExpenseLineToReports(test4piuPIUExpenseLineToReportsArg1);
        assertNotNull(instanceExpenseLineService);
    }

    @Test
    public void test4getCount4PIUExpenseLineToReports() {
        instanceExpenseLineService.getCount4PIUExpenseLineToReports(test4getCount4PIUExpenseLineToReportsArg1);
        assertNotNull(instanceExpenseLineService);
    }

    @Test
    public void test4newlineDefault() {
        instanceExpenseLineService.newline(test4newlineDefaultArg1);
        assertNotNull(instanceExpenseLineService);
    }

    @Test
    public void test4newlineInitializedArguments() {
        instanceExpenseLineService.newline(test4newlineInitializedArgumentsArg1);
        assertNotNull(instanceExpenseLineService);
    }

    @Test
    public void test4newlineTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseLineService.newlineTxn(test4newlineTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4newlineTxnDefaultResult;
        }
        assertEquals(test4newlineTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4newlineTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseLineService.newlineTxn(test4newlineTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4newlineTxnInitializedArgumentsResult;
        }
        assertEquals(test4newlineTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4newlineImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseLineService.newlineImplementation(test4newlineImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4newlineImplementationDefaultResult;
        }
        assertEquals(test4newlineImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4newlineImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseLineService.newlineImplementation(test4newlineImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4newlineImplementationInitializedArgumentsResult;
        }
        assertEquals(test4newlineImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4newlineCheckPreconditions() {
        assertEquals(newlineCheckPreconditionsResult.getResultCode(), instanceExpenseLineService.newlineCheckPreconditions(newlineCheckPreconditionsArg1).getResultCode());
    }

    @Test
    public void test4deletelineDefault() {
        instanceExpenseLineService.deleteline(test4deletelineDefaultArg1);
        assertNotNull(instanceExpenseLineService);
    }

    @Test
    public void test4deletelineInitializedArguments() {
        instanceExpenseLineService.deleteline(test4deletelineInitializedArgumentsArg1);
        assertNotNull(instanceExpenseLineService);
    }

    @Test
    public void test4deletelineTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseLineService.deletelineTxn(test4deletelineTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4deletelineTxnDefaultResult;
        }
        assertEquals(test4deletelineTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deletelineTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseLineService.deletelineTxn(test4deletelineTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4deletelineTxnInitializedArgumentsResult;
        }
        assertEquals(test4deletelineTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deletelineImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseLineService.deletelineImplementation(test4deletelineImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4deletelineImplementationDefaultResult;
        }
        assertEquals(test4deletelineImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deletelineImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseLineService.deletelineImplementation(test4deletelineImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4deletelineImplementationInitializedArgumentsResult;
        }
        assertEquals(test4deletelineImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deletelineCheckPreconditions() {
        assertEquals(deletelineCheckPreconditionsResult.getResultCode(), instanceExpenseLineService.deletelineCheckPreconditions(deletelineCheckPreconditionsArg1).getResultCode());
    }

    @Test
    public void test4editinstanceDefault() {
        instanceExpenseLineService.editinstance(test4editinstanceDefaultArg1);
        assertNotNull(instanceExpenseLineService);
    }

    @Test
    public void test4editinstanceInitializedArguments() {
        instanceExpenseLineService.editinstance(test4editinstanceInitializedArgumentsArg1);
        assertNotNull(instanceExpenseLineService);
    }

    @Test
    public void test4editinstanceTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseLineService.editinstanceTxn(test4editinstanceTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4editinstanceTxnDefaultResult;
        }
        assertEquals(test4editinstanceTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseLineService.editinstanceTxn(test4editinstanceTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editinstanceTxnInitializedArgumentsResult;
        }
        assertEquals(test4editinstanceTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseLineService.editinstanceImplementation(test4editinstanceImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4editinstanceImplementationDefaultResult;
        }
        assertEquals(test4editinstanceImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseLineService.editinstanceImplementation(test4editinstanceImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editinstanceImplementationInitializedArgumentsResult;
        }
        assertEquals(test4editinstanceImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceCheckPreconditions() {
        assertEquals(editinstanceCheckPreconditionsResult.getResultCode(), instanceExpenseLineService.editinstanceCheckPreconditions(editinstanceCheckPreconditionsArg1).getResultCode());
    }

    @Test
    public void test4deletepaidlineDefault() {
        instanceExpenseLineService.deletepaidline(test4deletepaidlineDefaultArg1);
        assertNotNull(instanceExpenseLineService);
    }

    @Test
    public void test4deletepaidlineInitializedArguments() {
        instanceExpenseLineService.deletepaidline(test4deletepaidlineInitializedArgumentsArg1);
        assertNotNull(instanceExpenseLineService);
    }

    @Test
    public void test4deletepaidlineTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseLineService.deletepaidlineTxn(test4deletepaidlineTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4deletepaidlineTxnDefaultResult;
        }
        assertEquals(test4deletepaidlineTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deletepaidlineTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseLineService.deletepaidlineTxn(test4deletepaidlineTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4deletepaidlineTxnInitializedArgumentsResult;
        }
        assertEquals(test4deletepaidlineTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deletepaidlineImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseLineService.deletepaidlineImplementation(test4deletepaidlineImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4deletepaidlineImplementationDefaultResult;
        }
        assertEquals(test4deletepaidlineImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deletepaidlineImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseLineService.deletepaidlineImplementation(test4deletepaidlineImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4deletepaidlineImplementationInitializedArgumentsResult;
        }
        assertEquals(test4deletepaidlineImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }
}
