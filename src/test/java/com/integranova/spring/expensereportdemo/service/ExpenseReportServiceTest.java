package com.integranova.spring.expensereportdemo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.ExpenseReportConstants;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.ERTemplate;
import com.integranova.spring.expensereportdemo.persistence.ExpenseCurrency;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.oid.EmployeeOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ERTemplateOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseCurrencyOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseLineOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseReportOid;
import com.integranova.spring.expensereportdemo.persistence.oid.PaymentTypeOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ProjectOid;
import com.integranova.spring.expensereportdemo.persistence.PaymentType;
import com.integranova.spring.expensereportdemo.persistence.Project;
import com.integranova.spring.expensereportdemo.repository.ExpenseReportJpaRepository;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.ds.DSExpenseReport4HAT;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.ds.DSExpenseReport4MD;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.ds.DSExpenseReportSup;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.ApproveRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.AuthorizeRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.CancelapproveRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DELETEALLRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DelexpenseRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DelPaymentTypeRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DummyRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.DummyResponse;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.EcloseRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.EditinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.InsPaymentTypeRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.NewexpenseRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.PayRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.RejectauthoRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.RejectpaymentRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWFROMTEMPLATERequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWFROMTEMPLATEResponse;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TNEWResponse;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TPAYRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu.TREJECTPAYMENTRequest;
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
public class ExpenseReportServiceTest extends ClassTest {

    @InjectMocks
    private ExpenseReportService instanceExpenseReportService;
    
    @Mock
    private static ExpenseReportJpaRepository mockRepository;
    
    @Mock
    private static ExpenseReportService mockExpenseReportService;
    
    @Mock
    private static ExpenseCurrencyService mockExpenseCurrencyService;
    
    @Mock
    private static PaymentTypeService mockPaymentTypeService;
    
    @Mock
    private static ProjectService mockProjectService;
    
    @Mock
    private static EmployeeService mockEmployeeService;
    
    @Mock
    private static ExpenseLineService mockExpenseLineService;
    
    @Mock
    private static ERTemplateService mockERTemplateService;
    
    @Mock
    private static ERLTemplateService mockERLTemplateService;
    
    @Mock
    private static ExpenseTypeService mockExpenseTypeService;

    private static ExpenseReport mockInstance1;
    
    private static ExpenseReport mockInstance2;

    private static List<ExpenseReport> mockPopulation;

    private static Long mockexpenseReportidExpenseRepor;

    private static Optional<ExpenseReport> mockExpenseReport; 

    // test4solveQuery
    private static QueryRequest test4solveQueryArg1;
    private static List<Map<String, Object>> test4solveQueryResult;

    // test4get
    private static List<ExpenseReport> test4getResult;

    // test4getQueryRequest
    private static QueryRequest test4getQueryRequestArg1;
    private static List<ExpenseReport> test4getQueryRequestResult;

    // test4getDynamicPopulation
    private static QueryRequest test4getDynamicPopulationArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationResult;

    // test4getDynamicPopulationByFilterFExpenseReportAmount_NoFVars
    private static QueryRequest test4getDynamicPopulationByFilterFExpenseReportAmount_NoFVarsArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationByFilterFExpenseReportAmount_NoFVarsResult;

    // test4getDynamicPopulationByFilterFExpenseReportAmount_WithFVars
    private static QueryRequest test4getDynamicPopulationByFilterFExpenseReportAmount_WithFVarsArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationByFilterFExpenseReportAmount_WithFVarsResult;

    // test4getDynamicPopulationByFilterFExpenseReportDates_NoFVars
    private static QueryRequest test4getDynamicPopulationByFilterFExpenseReportDates_NoFVarsArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationByFilterFExpenseReportDates_NoFVarsResult;

    // test4getDynamicPopulationByFilterFExpenseReportDates_WithFVars
    private static QueryRequest test4getDynamicPopulationByFilterFExpenseReportDates_WithFVarsArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationByFilterFExpenseReportDates_WithFVarsResult;

    // test4getDynamicPopulationByFilterFExpenseReportStatus_NoFVars
    private static QueryRequest test4getDynamicPopulationByFilterFExpenseReportStatus_NoFVarsArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationByFilterFExpenseReportStatus_NoFVarsResult;

    // test4getDynamicPopulationByFilterFExpenseReportStatus_WithFVars
    private static QueryRequest test4getDynamicPopulationByFilterFExpenseReportStatus_WithFVarsArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationByFilterFExpenseReportStatus_WithFVarsResult;

    // test4getDynamicPopulationByFilterFByProject_NoFVars
    private static QueryRequest test4getDynamicPopulationByFilterFByProject_NoFVarsArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationByFilterFByProject_NoFVarsResult;

    // test4getDynamicPopulationByFilterFByProject_WithFVars
    private static QueryRequest test4getDynamicPopulationByFilterFByProject_WithFVarsArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationByFilterFByProject_WithFVarsResult;

    // test4getDynamicPopulationByFilterFByID_NoFVars
    private static QueryRequest test4getDynamicPopulationByFilterFByID_NoFVarsArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationByFilterFByID_NoFVarsResult;

    // test4getDynamicPopulationByFilterFByID_WithFVars
    private static QueryRequest test4getDynamicPopulationByFilterFByID_WithFVarsArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationByFilterFByID_WithFVarsResult;

    // test4getDynamicPopulationByOrderCriteriaOCExpenseReportDate
    private static QueryRequest test4getDynamicPopulationByOrderCriteriaOCExpenseReportDateArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationByOrderCriteriaOCExpenseReportDateResult;

    // test4getDynamicPopulationByOrderCriteriaOCExpenseReportAmount
    private static QueryRequest test4getDynamicPopulationByOrderCriteriaOCExpenseReportAmountArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationByOrderCriteriaOCExpenseReportAmountResult;

    // test4getDynamicPopulationFilterByOID
    private static QueryRequest test4getDynamicPopulationFilterByOIDArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationFilterByOIDResult;

    // test4getDynamicPreload4DSExpenseReport4MD
    private static QueryRequest test4getDynamicPreload4DSExpenseReport4MDArg1;
    private static PreloadResponseViewModel test4getDynamicPreload4DSExpenseReport4MDResult;

    // test4getDynamicPreload4DSExpenseReportSup
    private static QueryRequest test4getDynamicPreload4DSExpenseReportSupArg1;
    private static PreloadResponseViewModel test4getDynamicPreload4DSExpenseReportSupResult;

    // test4getDynamicPreload4DSExpenseReport4HAT
    private static QueryRequest test4getDynamicPreload4DSExpenseReport4HATArg1;
    private static PreloadResponseViewModel test4getDynamicPreload4DSExpenseReport4HATResult;

    // test4getByRelatedDynamic
    private static String test4getByRelatedDynamicArg1;
    private static String test4getByRelatedDynamicArg2;
    private static String test4getByRelatedDynamicArg3;
    private static PopulationResponseViewModel test4getByRelatedDynamicResult;

    // test4getById
    private static Long test4getByIdArg1;
    private static ExpenseReport test4getByIdResult;

    // test4getByRelated
    private static ExpenseReport test4getByRelatedArg1;
    private static String test4getByRelatedArg2;
    private static List<ExpenseReport> test4getByRelatedResult;

    // test4getInstancesByRelated
    private static ExpenseReport test4getInstancesByRelatedArg1;
    private static String test4getInstancesByRelatedArg2;
    private static List<ExpenseReport> test4getInstancesByRelatedResult;

    // test4getExpenseReportDynamic
    private static ExpenseReportOid test4getExpenseReportDynamicArg1;
    private static String test4getExpenseReportDynamicArg2;
    private static InstanceResponseViewModel test4getExpenseReportDynamicResult;

    // test4getSuppInfoWithoutInstance
    private static ExpenseReportOid test4getSuppInfoWithoutInstanceArg1;
    private static String test4getSuppInfoWithoutInstanceArg2;
    private static String test4getSuppInfoWithoutInstanceResult;

    // test4getSuppInfoWithInstance
    private static ExpenseReportOid test4getSuppInfoWithInstanceArg1;
    private static String test4getSuppInfoWithInstanceArg2;

    // test4getSuppInfoWithDSDSExpenseReportSup
    private static ExpenseReportOid test4getSuppInfoWithDSDSExpenseReportSupArg1;
    private static String test4getSuppInfoWithDSDSExpenseReportSupArg2;

    // test4buildRelatedInstance4RoleExpenseLinesWithoutRemainingPath
    private static String test4buildRelatedInstance4RoleExpenseLinesWithoutRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleExpenseLinesWithoutRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleExpenseLinesWithoutRemainingPathArg3;

    // test4buildRelatedInstance4RoleExpenseLinesWithRemainingPath
    private static String test4buildRelatedInstance4RoleExpenseLinesWithRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleExpenseLinesWithRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleExpenseLinesWithRemainingPathArg3;

    // test4buildRelatedInstance4RoleEmployeeWithoutRemainingPath
    private static String test4buildRelatedInstance4RoleEmployeeWithoutRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleEmployeeWithoutRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleEmployeeWithoutRemainingPathArg3;

    // test4buildRelatedInstance4RoleEmployeeWithRemainingPath
    private static String test4buildRelatedInstance4RoleEmployeeWithRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleEmployeeWithRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleEmployeeWithRemainingPathArg3;

    // test4buildRelatedInstance4RoleExpenseCurrencyWithoutRemainingPath
    private static String test4buildRelatedInstance4RoleExpenseCurrencyWithoutRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleExpenseCurrencyWithoutRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleExpenseCurrencyWithoutRemainingPathArg3;

    // test4buildRelatedInstance4RoleExpenseCurrencyWithRemainingPath
    private static String test4buildRelatedInstance4RoleExpenseCurrencyWithRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleExpenseCurrencyWithRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleExpenseCurrencyWithRemainingPathArg3;

    // test4buildRelatedInstance4RolePaymentTypeWithoutRemainingPath
    private static String test4buildRelatedInstance4RolePaymentTypeWithoutRemainingPathArg1;
    private static String test4buildRelatedInstance4RolePaymentTypeWithoutRemainingPathArg2;
    private static String test4buildRelatedInstance4RolePaymentTypeWithoutRemainingPathArg3;

    // test4buildRelatedInstance4RolePaymentTypeWithRemainingPath
    private static String test4buildRelatedInstance4RolePaymentTypeWithRemainingPathArg1;
    private static String test4buildRelatedInstance4RolePaymentTypeWithRemainingPathArg2;
    private static String test4buildRelatedInstance4RolePaymentTypeWithRemainingPathArg3;

    // test4buildRelatedInstance4RoleProjectWithoutRemainingPath
    private static String test4buildRelatedInstance4RoleProjectWithoutRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleProjectWithoutRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleProjectWithoutRemainingPathArg3;

    // test4buildRelatedInstance4RoleProjectWithRemainingPath
    private static String test4buildRelatedInstance4RoleProjectWithRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleProjectWithRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleProjectWithRemainingPathArg3;

    // test4getDSExpenseReport4MD
    private static String test4getDSExpenseReport4MDArg1;
    private static String test4getDSExpenseReport4MDArg2;
    private static String test4getDSExpenseReport4MDArg3;
    private static DSExpenseReport4MD test4getDSExpenseReport4MDResult;

    // test4getPreloadDSExpenseReport4MD
    private static QueryRequest test4getPreloadDSExpenseReport4MDArg1;
    private static List<PreloadViewModel> test4getPreloadDSExpenseReport4MDResult;

    // test4getDSExpenseReportSup
    private static String test4getDSExpenseReportSupArg1;
    private static String test4getDSExpenseReportSupArg2;
    private static String test4getDSExpenseReportSupArg3;
    private static DSExpenseReportSup test4getDSExpenseReportSupResult;

    // test4getPreloadDSExpenseReportSup
    private static QueryRequest test4getPreloadDSExpenseReportSupArg1;
    private static List<PreloadViewModel> test4getPreloadDSExpenseReportSupResult;

    // test4getDSExpenseReport4HAT
    private static String test4getDSExpenseReport4HATArg1;
    private static String test4getDSExpenseReport4HATArg2;
    private static String test4getDSExpenseReport4HATArg3;
    private static DSExpenseReport4HAT test4getDSExpenseReport4HATResult;

    // test4getPreloadDSExpenseReport4HAT
    private static QueryRequest test4getPreloadDSExpenseReport4HATArg1;
    private static List<PreloadViewModel> test4getPreloadDSExpenseReport4HATResult;

    // test4iIUExpenseReport
    private static ExpenseReportOid test4iIUExpenseReportArg1;
    private static DSExpenseReport4MD test4iIUExpenseReportResult;

    // test4piuPIUExpenseReport
    private static QueryRequest test4piuPIUExpenseReportArg1;
    private static List<DSExpenseReport4HAT> test4piuPIUExpenseReportResult;

    // test4getCount4PIUExpenseReport
    private static QueryRequest test4getCount4PIUExpenseReportArg1;
    private static int test4getCount4PIUExpenseReportResult;

    // test4piuPIUExpenseReportWithFilterFByProject_NoFVars
    private static QueryRequest test4piuPIUExpenseReportWithFilterFByProject_NoFVarsArg1;
    private static List<DSExpenseReport4HAT> test4piuPIUExpenseReportWithFilterFByProject_NoFVarsResult;

    // test4piuPIUExpenseReportWithFilterFByProject_WithFVars
    private static QueryRequest test4piuPIUExpenseReportWithFilterFByProject_WithFVarsArg1;
    private static List<DSExpenseReport4HAT> test4piuPIUExpenseReportWithFilterFByProject_WithFVarsResult;

    // test4piuPIUExpenseReportWithFilterFExpenseReportAmount_NoFVars
    private static QueryRequest test4piuPIUExpenseReportWithFilterFExpenseReportAmount_NoFVarsArg1;
    private static List<DSExpenseReport4HAT> test4piuPIUExpenseReportWithFilterFExpenseReportAmount_NoFVarsResult;

    // test4piuPIUExpenseReportWithFilterFExpenseReportAmount_WithFVars
    private static QueryRequest test4piuPIUExpenseReportWithFilterFExpenseReportAmount_WithFVarsArg1;
    private static List<DSExpenseReport4HAT> test4piuPIUExpenseReportWithFilterFExpenseReportAmount_WithFVarsResult;

    // test4piuPIUExpenseReportWithFilterFExpenseReportStatus_NoFVars
    private static QueryRequest test4piuPIUExpenseReportWithFilterFExpenseReportStatus_NoFVarsArg1;
    private static List<DSExpenseReport4HAT> test4piuPIUExpenseReportWithFilterFExpenseReportStatus_NoFVarsResult;

    // test4piuPIUExpenseReportWithFilterFExpenseReportStatus_WithFVars
    private static QueryRequest test4piuPIUExpenseReportWithFilterFExpenseReportStatus_WithFVarsArg1;
    private static List<DSExpenseReport4HAT> test4piuPIUExpenseReportWithFilterFExpenseReportStatus_WithFVarsResult;

    // test4piuPIUExpenseReportToEmployee
    private static QueryRequest test4piuPIUExpenseReportToEmployeeArg1;
    private static List<DSExpenseReport4MD> test4piuPIUExpenseReportToEmployeeResult;

    // test4getCount4PIUExpenseReportToEmployee
    private static QueryRequest test4getCount4PIUExpenseReportToEmployeeArg1;
    private static int test4getCount4PIUExpenseReportToEmployeeResult;

    // test4piuPIUExpenseReportToEmployeeWithFilterFExpenseReportDates_NoFVars
    private static QueryRequest test4piuPIUExpenseReportToEmployeeWithFilterFExpenseReportDates_NoFVarsArg1;
    private static List<DSExpenseReport4MD> test4piuPIUExpenseReportToEmployeeWithFilterFExpenseReportDates_NoFVarsResult;

    // test4piuPIUExpenseReportToEmployeeWithFilterFExpenseReportDates_WithFVars
    private static QueryRequest test4piuPIUExpenseReportToEmployeeWithFilterFExpenseReportDates_WithFVarsArg1;
    private static List<DSExpenseReport4MD> test4piuPIUExpenseReportToEmployeeWithFilterFExpenseReportDates_WithFVarsResult;

    // test4piuPIUExpenseReportProject
    private static QueryRequest test4piuPIUExpenseReportProjectArg1;
    private static List<DSExpenseReport4MD> test4piuPIUExpenseReportProjectResult;

    // test4getCount4PIUExpenseReportProject
    private static QueryRequest test4getCount4PIUExpenseReportProjectArg1;
    private static int test4getCount4PIUExpenseReportProjectResult;

    // test4piuPIUExpenseReportProjectWithFilterFExpenseReportDates_NoFVars
    private static QueryRequest test4piuPIUExpenseReportProjectWithFilterFExpenseReportDates_NoFVarsArg1;
    private static List<DSExpenseReport4MD> test4piuPIUExpenseReportProjectWithFilterFExpenseReportDates_NoFVarsResult;

    // test4piuPIUExpenseReportProjectWithFilterFExpenseReportDates_WithFVars
    private static QueryRequest test4piuPIUExpenseReportProjectWithFilterFExpenseReportDates_WithFVarsArg1;
    private static List<DSExpenseReport4MD> test4piuPIUExpenseReportProjectWithFilterFExpenseReportDates_WithFVarsResult;

    // test4piuPIUExpenseReportProjectWithFilterFExpenseReportAmount_NoFVars
    private static QueryRequest test4piuPIUExpenseReportProjectWithFilterFExpenseReportAmount_NoFVarsArg1;
    private static List<DSExpenseReport4MD> test4piuPIUExpenseReportProjectWithFilterFExpenseReportAmount_NoFVarsResult;

    // test4piuPIUExpenseReportProjectWithFilterFExpenseReportAmount_WithFVars
    private static QueryRequest test4piuPIUExpenseReportProjectWithFilterFExpenseReportAmount_WithFVarsArg1;
    private static List<DSExpenseReport4MD> test4piuPIUExpenseReportProjectWithFilterFExpenseReportAmount_WithFVarsResult;

    // test4piuPIUExpenseReportProjectWithFilterFExpenseReportStatus_NoFVars
    private static QueryRequest test4piuPIUExpenseReportProjectWithFilterFExpenseReportStatus_NoFVarsArg1;
    private static List<DSExpenseReport4MD> test4piuPIUExpenseReportProjectWithFilterFExpenseReportStatus_NoFVarsResult;

    // test4piuPIUExpenseReportProjectWithFilterFExpenseReportStatus_WithFVars
    private static QueryRequest test4piuPIUExpenseReportProjectWithFilterFExpenseReportStatus_WithFVarsArg1;
    private static List<DSExpenseReport4MD> test4piuPIUExpenseReportProjectWithFilterFExpenseReportStatus_WithFVarsResult;

    // test4newexpenseDefault
    private static NewexpenseRequest test4newexpenseDefaultArg1;

    // test4newexpenseInitializedArguments
    private static NewexpenseRequest test4newexpenseInitializedArgumentsArg1;

    // test4newexpenseTxnDefault
    private static NewexpenseRequest test4newexpenseTxnDefaultArg1;
    private static ServiceResponse test4newexpenseTxnDefaultResult;

    // test4newexpenseTxnInitializedArguments
    private static NewexpenseRequest test4newexpenseTxnInitializedArgumentsArg1;
    private static ServiceResponse test4newexpenseTxnInitializedArgumentsResult;

    // test4newexpenseImplementationDefault
    private static NewexpenseRequest test4newexpenseImplementationDefaultArg1;
    private static ServiceResponse test4newexpenseImplementationDefaultResult;

    // test4newexpenseImplementationInitializedArguments
    private static NewexpenseRequest test4newexpenseImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4newexpenseImplementationInitializedArgumentsResult;

    // test4delexpenseDefault
    private static DelexpenseRequest test4delexpenseDefaultArg1;

    // test4delexpenseInitializedArguments
    private static DelexpenseRequest test4delexpenseInitializedArgumentsArg1;

    // test4delexpenseTxnDefault
    private static DelexpenseRequest test4delexpenseTxnDefaultArg1;
    private static ServiceResponse test4delexpenseTxnDefaultResult;

    // test4delexpenseTxnInitializedArguments
    private static DelexpenseRequest test4delexpenseTxnInitializedArgumentsArg1;
    private static ServiceResponse test4delexpenseTxnInitializedArgumentsResult;

    // test4delexpenseImplementationDefault
    private static DelexpenseRequest test4delexpenseImplementationDefaultArg1;
    private static ServiceResponse test4delexpenseImplementationDefaultResult;

    // test4delexpenseImplementationInitializedArguments
    private static DelexpenseRequest test4delexpenseImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4delexpenseImplementationInitializedArgumentsResult;

    // test4ecloseDefault
    private static EcloseRequest test4ecloseDefaultArg1;

    // test4ecloseInitializedArguments
    private static EcloseRequest test4ecloseInitializedArgumentsArg1;

    // test4ecloseTxnDefault
    private static EcloseRequest test4ecloseTxnDefaultArg1;
    private static ServiceResponse test4ecloseTxnDefaultResult;

    // test4ecloseTxnInitializedArguments
    private static EcloseRequest test4ecloseTxnInitializedArgumentsArg1;
    private static ServiceResponse test4ecloseTxnInitializedArgumentsResult;

    // test4ecloseImplementationDefault
    private static EcloseRequest test4ecloseImplementationDefaultArg1;
    private static ServiceResponse test4ecloseImplementationDefaultResult;

    // test4ecloseImplementationInitializedArguments
    private static EcloseRequest test4ecloseImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4ecloseImplementationInitializedArgumentsResult;

    // test4authorizeDefault
    private static AuthorizeRequest test4authorizeDefaultArg1;

    // test4authorizeInitializedArguments
    private static AuthorizeRequest test4authorizeInitializedArgumentsArg1;

    // test4authorizeTxnDefault
    private static AuthorizeRequest test4authorizeTxnDefaultArg1;
    private static ServiceResponse test4authorizeTxnDefaultResult;

    // test4authorizeTxnInitializedArguments
    private static AuthorizeRequest test4authorizeTxnInitializedArgumentsArg1;
    private static ServiceResponse test4authorizeTxnInitializedArgumentsResult;

    // test4authorizeImplementationDefault
    private static AuthorizeRequest test4authorizeImplementationDefaultArg1;
    private static ServiceResponse test4authorizeImplementationDefaultResult;

    // test4authorizeImplementationInitializedArguments
    private static AuthorizeRequest test4authorizeImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4authorizeImplementationInitializedArgumentsResult;

    // test4payDefault
    private static PayRequest test4payDefaultArg1;

    // test4payInitializedArguments
    private static PayRequest test4payInitializedArgumentsArg1;

    // test4payTxnDefault
    private static PayRequest test4payTxnDefaultArg1;
    private static ServiceResponse test4payTxnDefaultResult;

    // test4payTxnInitializedArguments
    private static PayRequest test4payTxnInitializedArgumentsArg1;
    private static ServiceResponse test4payTxnInitializedArgumentsResult;

    // test4payImplementationDefault
    private static PayRequest test4payImplementationDefaultArg1;
    private static ServiceResponse test4payImplementationDefaultResult;

    // test4payImplementationInitializedArguments
    private static PayRequest test4payImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4payImplementationInitializedArgumentsResult;

    // test4rejectauthoDefault
    private static RejectauthoRequest test4rejectauthoDefaultArg1;

    // test4rejectauthoInitializedArguments
    private static RejectauthoRequest test4rejectauthoInitializedArgumentsArg1;

    // test4rejectauthoTxnDefault
    private static RejectauthoRequest test4rejectauthoTxnDefaultArg1;
    private static ServiceResponse test4rejectauthoTxnDefaultResult;

    // test4rejectauthoTxnInitializedArguments
    private static RejectauthoRequest test4rejectauthoTxnInitializedArgumentsArg1;
    private static ServiceResponse test4rejectauthoTxnInitializedArgumentsResult;

    // test4rejectauthoImplementationDefault
    private static RejectauthoRequest test4rejectauthoImplementationDefaultArg1;
    private static ServiceResponse test4rejectauthoImplementationDefaultResult;

    // test4rejectauthoImplementationInitializedArguments
    private static RejectauthoRequest test4rejectauthoImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4rejectauthoImplementationInitializedArgumentsResult;

    // test4rejectauthoCheckPreconditions
    private static RejectauthoRequest rejectauthoCheckPreconditionsArg1;
    private static ServiceResponse rejectauthoCheckPreconditionsResult;

    // test4rejectpaymentDefault
    private static RejectpaymentRequest test4rejectpaymentDefaultArg1;

    // test4rejectpaymentInitializedArguments
    private static RejectpaymentRequest test4rejectpaymentInitializedArgumentsArg1;

    // test4rejectpaymentTxnDefault
    private static RejectpaymentRequest test4rejectpaymentTxnDefaultArg1;
    private static ServiceResponse test4rejectpaymentTxnDefaultResult;

    // test4rejectpaymentTxnInitializedArguments
    private static RejectpaymentRequest test4rejectpaymentTxnInitializedArgumentsArg1;
    private static ServiceResponse test4rejectpaymentTxnInitializedArgumentsResult;

    // test4rejectpaymentImplementationDefault
    private static RejectpaymentRequest test4rejectpaymentImplementationDefaultArg1;
    private static ServiceResponse test4rejectpaymentImplementationDefaultResult;

    // test4rejectpaymentImplementationInitializedArguments
    private static RejectpaymentRequest test4rejectpaymentImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4rejectpaymentImplementationInitializedArgumentsResult;

    // test4insPaymentTypeDefault
    private static InsPaymentTypeRequest test4insPaymentTypeDefaultArg1;

    // test4insPaymentTypeInitializedArguments
    private static InsPaymentTypeRequest test4insPaymentTypeInitializedArgumentsArg1;

    // test4insPaymentTypeTxnDefault
    private static InsPaymentTypeRequest test4insPaymentTypeTxnDefaultArg1;
    private static ServiceResponse test4insPaymentTypeTxnDefaultResult;

    // test4insPaymentTypeTxnInitializedArguments
    private static InsPaymentTypeRequest test4insPaymentTypeTxnInitializedArgumentsArg1;
    private static ServiceResponse test4insPaymentTypeTxnInitializedArgumentsResult;

    // test4insPaymentTypeImplementationDefault
    private static InsPaymentTypeRequest test4insPaymentTypeImplementationDefaultArg1;
    private static boolean test4insPaymentTypeImplementationDefaultArg2;
    private static ServiceResponse test4insPaymentTypeImplementationDefaultResult;

    // test4insPaymentTypeImplementationInitializedArguments
    private static InsPaymentTypeRequest test4insPaymentTypeImplementationInitializedArgumentsArg1;
    private static boolean test4insPaymentTypeImplementationInitializedArgumentsArg2;
    private static ServiceResponse test4insPaymentTypeImplementationInitializedArgumentsResult;

    // test4delPaymentTypeDefault
    private static DelPaymentTypeRequest test4delPaymentTypeDefaultArg1;

    // test4delPaymentTypeInitializedArguments
    private static DelPaymentTypeRequest test4delPaymentTypeInitializedArgumentsArg1;

    // test4delPaymentTypeTxnDefault
    private static DelPaymentTypeRequest test4delPaymentTypeTxnDefaultArg1;
    private static ServiceResponse test4delPaymentTypeTxnDefaultResult;

    // test4delPaymentTypeTxnInitializedArguments
    private static DelPaymentTypeRequest test4delPaymentTypeTxnInitializedArgumentsArg1;
    private static ServiceResponse test4delPaymentTypeTxnInitializedArgumentsResult;

    // test4delPaymentTypeImplementationDefault
    private static DelPaymentTypeRequest test4delPaymentTypeImplementationDefaultArg1;
    private static boolean test4delPaymentTypeImplementationDefaultArg2;
    private static ServiceResponse test4delPaymentTypeImplementationDefaultResult;

    // test4delPaymentTypeImplementationInitializedArguments
    private static DelPaymentTypeRequest test4delPaymentTypeImplementationInitializedArgumentsArg1;
    private static boolean test4delPaymentTypeImplementationInitializedArgumentsArg2;
    private static ServiceResponse test4delPaymentTypeImplementationInitializedArgumentsResult;

    // test4cancelapproveDefault
    private static CancelapproveRequest test4cancelapproveDefaultArg1;

    // test4cancelapproveInitializedArguments
    private static CancelapproveRequest test4cancelapproveInitializedArgumentsArg1;

    // test4cancelapproveTxnDefault
    private static CancelapproveRequest test4cancelapproveTxnDefaultArg1;
    private static ServiceResponse test4cancelapproveTxnDefaultResult;

    // test4cancelapproveTxnInitializedArguments
    private static CancelapproveRequest test4cancelapproveTxnInitializedArgumentsArg1;
    private static ServiceResponse test4cancelapproveTxnInitializedArgumentsResult;

    // test4cancelapproveImplementationDefault
    private static CancelapproveRequest test4cancelapproveImplementationDefaultArg1;
    private static ServiceResponse test4cancelapproveImplementationDefaultResult;

    // test4cancelapproveImplementationInitializedArguments
    private static CancelapproveRequest test4cancelapproveImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4cancelapproveImplementationInitializedArgumentsResult;

    // test4approveDefault
    private static ApproveRequest test4approveDefaultArg1;

    // test4approveInitializedArguments
    private static ApproveRequest test4approveInitializedArgumentsArg1;

    // test4approveTxnDefault
    private static ApproveRequest test4approveTxnDefaultArg1;
    private static ServiceResponse test4approveTxnDefaultResult;

    // test4approveTxnInitializedArguments
    private static ApproveRequest test4approveTxnInitializedArgumentsArg1;
    private static ServiceResponse test4approveTxnInitializedArgumentsResult;

    // test4approveImplementationDefault
    private static ApproveRequest test4approveImplementationDefaultArg1;
    private static ServiceResponse test4approveImplementationDefaultResult;

    // test4approveImplementationInitializedArguments
    private static ApproveRequest test4approveImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4approveImplementationInitializedArgumentsResult;

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

    // test4dummyDefault
    private static DummyRequest test4dummyDefaultArg1;

    // test4dummyInitializedArguments
    private static DummyRequest test4dummyInitializedArgumentsArg1;

    // test4dummyTxnDefault
    private static DummyRequest test4dummyTxnDefaultArg1;
    private static DummyResponse test4dummyTxnDefaultResult;

    // test4dummyTxnInitializedArguments
    private static DummyRequest test4dummyTxnInitializedArgumentsArg1;
    private static DummyResponse test4dummyTxnInitializedArgumentsResult;

    // test4dummyImplementationDefault
    private static DummyRequest test4dummyImplementationDefaultArg1;
    private static DummyResponse test4dummyImplementationDefaultResult;

    // test4dummyImplementationInitializedArguments
    private static DummyRequest test4dummyImplementationInitializedArgumentsArg1;
    private static DummyResponse test4dummyImplementationInitializedArgumentsResult;

    // test4dELETEALLDefault
    private static DELETEALLRequest test4dELETEALLDefaultArg1;

    // test4dELETEALLInitializedArguments
    private static DELETEALLRequest test4dELETEALLInitializedArgumentsArg1;

    // test4dELETEALLTxnDefault
    private static DELETEALLRequest test4dELETEALLTxnDefaultArg1;
    private static ServiceResponse test4dELETEALLTxnDefaultResult;

    // test4dELETEALLTxnInitializedArguments
    private static DELETEALLRequest test4dELETEALLTxnInitializedArgumentsArg1;
    private static ServiceResponse test4dELETEALLTxnInitializedArgumentsResult;

    // test4dELETEALLImplementationDefault
    private static DELETEALLRequest test4dELETEALLImplementationDefaultArg1;
    private static ServiceResponse test4dELETEALLImplementationDefaultResult;

    // test4dELETEALLImplementationInitializedArguments
    private static DELETEALLRequest test4dELETEALLImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4dELETEALLImplementationInitializedArgumentsResult;

    // test4tPAYDefault
    private static TPAYRequest test4tPAYDefaultArg1;

    // test4tPAYInitializedArguments
    private static TPAYRequest test4tPAYInitializedArgumentsArg1;

    // test4tPAYTxnDefault
    private static TPAYRequest test4tPAYTxnDefaultArg1;
    private static ServiceResponse test4tPAYTxnDefaultResult;

    // test4tPAYTxnInitializedArguments
    private static TPAYRequest test4tPAYTxnInitializedArgumentsArg1;
    private static ServiceResponse test4tPAYTxnInitializedArgumentsResult;

    // test4tPAYImplementationDefault
    private static TPAYRequest test4tPAYImplementationDefaultArg1;
    private static ServiceResponse test4tPAYImplementationDefaultResult;

    // test4tPAYImplementationInitializedArguments
    private static TPAYRequest test4tPAYImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4tPAYImplementationInitializedArgumentsResult;

    // test4tNEWDefault
    private static TNEWRequest test4tNEWDefaultArg1;

    // test4tNEWInitializedArguments
    private static TNEWRequest test4tNEWInitializedArgumentsArg1;

    // test4tNEWTxnDefault
    private static TNEWRequest test4tNEWTxnDefaultArg1;
    private static TNEWResponse test4tNEWTxnDefaultResult;

    // test4tNEWTxnInitializedArguments
    private static TNEWRequest test4tNEWTxnInitializedArgumentsArg1;
    private static TNEWResponse test4tNEWTxnInitializedArgumentsResult;

    // test4tNEWImplementationDefault
    private static TNEWRequest test4tNEWImplementationDefaultArg1;
    private static TNEWResponse test4tNEWImplementationDefaultResult;

    // test4tNEWImplementationInitializedArguments
    private static TNEWRequest test4tNEWImplementationInitializedArgumentsArg1;
    private static TNEWResponse test4tNEWImplementationInitializedArgumentsResult;

    // test4tNEWCheckPreconditions
    private static TNEWRequest tNEWCheckPreconditionsArg1;
    private static TNEWResponse tNEWCheckPreconditionsResult;

    // test4tREJECTPAYMENTDefault
    private static TREJECTPAYMENTRequest test4tREJECTPAYMENTDefaultArg1;

    // test4tREJECTPAYMENTInitializedArguments
    private static TREJECTPAYMENTRequest test4tREJECTPAYMENTInitializedArgumentsArg1;

    // test4tREJECTPAYMENTTxnDefault
    private static TREJECTPAYMENTRequest test4tREJECTPAYMENTTxnDefaultArg1;
    private static ServiceResponse test4tREJECTPAYMENTTxnDefaultResult;

    // test4tREJECTPAYMENTTxnInitializedArguments
    private static TREJECTPAYMENTRequest test4tREJECTPAYMENTTxnInitializedArgumentsArg1;
    private static ServiceResponse test4tREJECTPAYMENTTxnInitializedArgumentsResult;

    // test4tREJECTPAYMENTImplementationDefault
    private static TREJECTPAYMENTRequest test4tREJECTPAYMENTImplementationDefaultArg1;
    private static ServiceResponse test4tREJECTPAYMENTImplementationDefaultResult;

    // test4tREJECTPAYMENTImplementationInitializedArguments
    private static TREJECTPAYMENTRequest test4tREJECTPAYMENTImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4tREJECTPAYMENTImplementationInitializedArgumentsResult;

    // test4tNEWFROMTEMPLATEDefault
    private static TNEWFROMTEMPLATERequest test4tNEWFROMTEMPLATEDefaultArg1;

    // test4tNEWFROMTEMPLATEInitializedArguments
    private static TNEWFROMTEMPLATERequest test4tNEWFROMTEMPLATEInitializedArgumentsArg1;

    // test4tNEWFROMTEMPLATETxnDefault
    private static TNEWFROMTEMPLATERequest test4tNEWFROMTEMPLATETxnDefaultArg1;
    private static TNEWFROMTEMPLATEResponse test4tNEWFROMTEMPLATETxnDefaultResult;

    // test4tNEWFROMTEMPLATETxnInitializedArguments
    private static TNEWFROMTEMPLATERequest test4tNEWFROMTEMPLATETxnInitializedArgumentsArg1;
    private static TNEWFROMTEMPLATEResponse test4tNEWFROMTEMPLATETxnInitializedArgumentsResult;

    // test4tNEWFROMTEMPLATEImplementationDefault
    private static TNEWFROMTEMPLATERequest test4tNEWFROMTEMPLATEImplementationDefaultArg1;
    private static TNEWFROMTEMPLATEResponse test4tNEWFROMTEMPLATEImplementationDefaultResult;

    // test4tNEWFROMTEMPLATEImplementationInitializedArguments
    private static TNEWFROMTEMPLATERequest test4tNEWFROMTEMPLATEImplementationInitializedArgumentsArg1;
    private static TNEWFROMTEMPLATEResponse test4tNEWFROMTEMPLATEImplementationInitializedArgumentsResult;

    // test4tNEWFROMTEMPLATECheckPreconditions
    private static TNEWFROMTEMPLATERequest tNEWFROMTEMPLATECheckPreconditionsArg1;
    private static TNEWFROMTEMPLATEResponse tNEWFROMTEMPLATECheckPreconditionsResult;

    @BeforeClass
    public static void setUpClass() throws SystemException {
        setUpMockData();
    }

    private static void setUpMockData() throws SystemException {
        mockexpenseReportidExpenseRepor = Long.valueOf(0);
        mockInstance1 = new ExpenseReport();
        mockInstance2 = new ExpenseReport();
        mockPopulation = new ArrayList<>(Arrays.asList(mockInstance1, mockInstance2));
        mockExpenseReport = Optional.of(new ExpenseReport(new ExpenseReportOid(mockexpenseReportidExpenseRepor)));
        setUpMockData4test4solveQuery();
        setUpMockData4test4get();
        setUpMockData4test4getQueryRequest();
        setUpMockData4test4getDynamicPopulation();
        setUpMockData4test4getDynamicPopulationByFilterFExpenseReportAmount_NoFVars();
        setUpMockData4test4getDynamicPopulationByFilterFExpenseReportAmount_WithFVars();
        setUpMockData4test4getDynamicPopulationByFilterFExpenseReportDates_NoFVars();
        setUpMockData4test4getDynamicPopulationByFilterFExpenseReportDates_WithFVars();
        setUpMockData4test4getDynamicPopulationByFilterFExpenseReportStatus_NoFVars();
        setUpMockData4test4getDynamicPopulationByFilterFExpenseReportStatus_WithFVars();
        setUpMockData4test4getDynamicPopulationByFilterFByProject_NoFVars();
        setUpMockData4test4getDynamicPopulationByFilterFByProject_WithFVars();
        setUpMockData4test4getDynamicPopulationByFilterFByID_NoFVars();
        setUpMockData4test4getDynamicPopulationByFilterFByID_WithFVars();
        setUpMockData4test4getDynamicPopulationByOrderCriteriaOCExpenseReportDate();
        setUpMockData4test4getDynamicPopulationByOrderCriteriaOCExpenseReportAmount();
        setUpMockData4test4getDynamicPopulationFilterByOID();
        setUpMockData4test4getDynamicPreload4DSExpenseReport4MD();
        setUpMockData4test4getDynamicPreload4DSExpenseReportSup();
        setUpMockData4test4getDynamicPreload4DSExpenseReport4HAT();
        setUpMockData4test4getByRelatedDynamic();
        setUpMockData4test4getById();
        setUpMockData4test4getByRelated();
        setUpMockData4test4getInstancesByRelated();
        setUpMockData4test4getExpenseReportDynamic();
        setUpMockData4test4getSuppInfoWithoutInstance();
        setUpMockData4test4getSuppInfoWithInstance();
        setUpMockData4test4getSuppInfoWithDSDSExpenseReportSup();
        setUpMockData4test4buildRelatedInstance4RoleExpenseLinesWithoutRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleExpenseLinesWithRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleEmployeeWithoutRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleEmployeeWithRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleExpenseCurrencyWithoutRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleExpenseCurrencyWithRemainingPath();
        setUpMockData4test4buildRelatedInstance4RolePaymentTypeWithoutRemainingPath();
        setUpMockData4test4buildRelatedInstance4RolePaymentTypeWithRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleProjectWithoutRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleProjectWithRemainingPath();
        setUpMockData4test4getDSExpenseReport4MD();
        setUpMockData4test4getPreloadDSExpenseReport4MD();
        setUpMockData4test4getDSExpenseReportSup();
        setUpMockData4test4getPreloadDSExpenseReportSup();
        setUpMockData4test4getDSExpenseReport4HAT();
        setUpMockData4test4getPreloadDSExpenseReport4HAT();
        setUpMockData4test4iIUExpenseReport();
        setUpMockData4test4piuPIUExpenseReport();
        setUpMockData4test4getCount4PIUExpenseReport();
        setUpMockData4test4piuPIUExpenseReportWithFilterFByProject_NoFVars();
        setUpMockData4test4piuPIUExpenseReportWithFilterFByProject_WithFVars();
        setUpMockData4test4piuPIUExpenseReportWithFilterFExpenseReportAmount_NoFVars();
        setUpMockData4test4piuPIUExpenseReportWithFilterFExpenseReportAmount_WithFVars();
        setUpMockData4test4piuPIUExpenseReportWithFilterFExpenseReportStatus_NoFVars();
        setUpMockData4test4piuPIUExpenseReportWithFilterFExpenseReportStatus_WithFVars();
        setUpMockData4test4piuPIUExpenseReportToEmployee();
        setUpMockData4test4getCount4PIUExpenseReportToEmployee();
        setUpMockData4test4piuPIUExpenseReportToEmployeeWithFilterFExpenseReportDates_NoFVars();
        setUpMockData4test4piuPIUExpenseReportToEmployeeWithFilterFExpenseReportDates_WithFVars();
        setUpMockData4test4piuPIUExpenseReportProject();
        setUpMockData4test4getCount4PIUExpenseReportProject();
        setUpMockData4test4piuPIUExpenseReportProjectWithFilterFExpenseReportDates_NoFVars();
        setUpMockData4test4piuPIUExpenseReportProjectWithFilterFExpenseReportDates_WithFVars();
        setUpMockData4test4piuPIUExpenseReportProjectWithFilterFExpenseReportAmount_NoFVars();
        setUpMockData4test4piuPIUExpenseReportProjectWithFilterFExpenseReportAmount_WithFVars();
        setUpMockData4test4piuPIUExpenseReportProjectWithFilterFExpenseReportStatus_NoFVars();
        setUpMockData4test4piuPIUExpenseReportProjectWithFilterFExpenseReportStatus_WithFVars();
        setUpMockData4test4newexpenseDefault();
        setUpMockData4test4newexpenseInitializedArguments();
        setUpMockData4test4newexpenseTxnDefault();
        setUpMockData4test4newexpenseTxnInitializedArguments();
        setUpMockData4test4newexpenseImplementationDefault();
        setUpMockData4test4newexpenseImplementationInitializedArguments();
        setUpMockData4test4delexpenseDefault();
        setUpMockData4test4delexpenseInitializedArguments();
        setUpMockData4test4delexpenseTxnDefault();
        setUpMockData4test4delexpenseTxnInitializedArguments();
        setUpMockData4test4delexpenseImplementationDefault();
        setUpMockData4test4delexpenseImplementationInitializedArguments();
        setUpMockData4test4ecloseDefault();
        setUpMockData4test4ecloseInitializedArguments();
        setUpMockData4test4ecloseTxnDefault();
        setUpMockData4test4ecloseTxnInitializedArguments();
        setUpMockData4test4ecloseImplementationDefault();
        setUpMockData4test4ecloseImplementationInitializedArguments();
        setUpMockData4test4authorizeDefault();
        setUpMockData4test4authorizeInitializedArguments();
        setUpMockData4test4authorizeTxnDefault();
        setUpMockData4test4authorizeTxnInitializedArguments();
        setUpMockData4test4authorizeImplementationDefault();
        setUpMockData4test4authorizeImplementationInitializedArguments();
        setUpMockData4test4payDefault();
        setUpMockData4test4payInitializedArguments();
        setUpMockData4test4payTxnDefault();
        setUpMockData4test4payTxnInitializedArguments();
        setUpMockData4test4payImplementationDefault();
        setUpMockData4test4payImplementationInitializedArguments();
        setUpMockData4test4rejectauthoDefault();
        setUpMockData4test4rejectauthoInitializedArguments();
        setUpMockData4test4rejectauthoTxnDefault();
        setUpMockData4test4rejectauthoTxnInitializedArguments();
        setUpMockData4test4rejectauthoImplementationDefault();
        setUpMockData4test4rejectauthoImplementationInitializedArguments();
        setUpMockData4test4rejectauthoCheckPreconditions();
        setUpMockData4test4rejectpaymentDefault();
        setUpMockData4test4rejectpaymentInitializedArguments();
        setUpMockData4test4rejectpaymentTxnDefault();
        setUpMockData4test4rejectpaymentTxnInitializedArguments();
        setUpMockData4test4rejectpaymentImplementationDefault();
        setUpMockData4test4rejectpaymentImplementationInitializedArguments();
        setUpMockData4test4insPaymentTypeDefault();
        setUpMockData4test4insPaymentTypeInitializedArguments();
        setUpMockData4test4insPaymentTypeTxnDefault();
        setUpMockData4test4insPaymentTypeTxnInitializedArguments();
        setUpMockData4test4insPaymentTypeImplementationDefault();
        setUpMockData4test4insPaymentTypeImplementationInitializedArguments();
        setUpMockData4test4delPaymentTypeDefault();
        setUpMockData4test4delPaymentTypeInitializedArguments();
        setUpMockData4test4delPaymentTypeTxnDefault();
        setUpMockData4test4delPaymentTypeTxnInitializedArguments();
        setUpMockData4test4delPaymentTypeImplementationDefault();
        setUpMockData4test4delPaymentTypeImplementationInitializedArguments();
        setUpMockData4test4cancelapproveDefault();
        setUpMockData4test4cancelapproveInitializedArguments();
        setUpMockData4test4cancelapproveTxnDefault();
        setUpMockData4test4cancelapproveTxnInitializedArguments();
        setUpMockData4test4cancelapproveImplementationDefault();
        setUpMockData4test4cancelapproveImplementationInitializedArguments();
        setUpMockData4test4approveDefault();
        setUpMockData4test4approveInitializedArguments();
        setUpMockData4test4approveTxnDefault();
        setUpMockData4test4approveTxnInitializedArguments();
        setUpMockData4test4approveImplementationDefault();
        setUpMockData4test4approveImplementationInitializedArguments();
        setUpMockData4test4editinstanceDefault();
        setUpMockData4test4editinstanceInitializedArguments();
        setUpMockData4test4editinstanceTxnDefault();
        setUpMockData4test4editinstanceTxnInitializedArguments();
        setUpMockData4test4editinstanceImplementationDefault();
        setUpMockData4test4editinstanceImplementationInitializedArguments();
        setUpMockData4test4dummyDefault();
        setUpMockData4test4dummyInitializedArguments();
        setUpMockData4test4dummyTxnDefault();
        setUpMockData4test4dummyTxnInitializedArguments();
        setUpMockData4test4dummyImplementationDefault();
        setUpMockData4test4dummyImplementationInitializedArguments();
        setUpMockData4test4dELETEALLDefault();
        setUpMockData4test4dELETEALLInitializedArguments();
        setUpMockData4test4dELETEALLTxnDefault();
        setUpMockData4test4dELETEALLTxnInitializedArguments();
        setUpMockData4test4dELETEALLImplementationDefault();
        setUpMockData4test4dELETEALLImplementationInitializedArguments();
        setUpMockData4test4tPAYDefault();
        setUpMockData4test4tPAYInitializedArguments();
        setUpMockData4test4tPAYTxnDefault();
        setUpMockData4test4tPAYTxnInitializedArguments();
        setUpMockData4test4tPAYImplementationDefault();
        setUpMockData4test4tPAYImplementationInitializedArguments();
        setUpMockData4test4tNEWDefault();
        setUpMockData4test4tNEWInitializedArguments();
        setUpMockData4test4tNEWTxnDefault();
        setUpMockData4test4tNEWTxnInitializedArguments();
        setUpMockData4test4tNEWImplementationDefault();
        setUpMockData4test4tNEWImplementationInitializedArguments();
        setUpMockData4test4tNEWCheckPreconditions();
        setUpMockData4test4tREJECTPAYMENTDefault();
        setUpMockData4test4tREJECTPAYMENTInitializedArguments();
        setUpMockData4test4tREJECTPAYMENTTxnDefault();
        setUpMockData4test4tREJECTPAYMENTTxnInitializedArguments();
        setUpMockData4test4tREJECTPAYMENTImplementationDefault();
        setUpMockData4test4tREJECTPAYMENTImplementationInitializedArguments();
        setUpMockData4test4tNEWFROMTEMPLATEDefault();
        setUpMockData4test4tNEWFROMTEMPLATEInitializedArguments();
        setUpMockData4test4tNEWFROMTEMPLATETxnDefault();
        setUpMockData4test4tNEWFROMTEMPLATETxnInitializedArguments();
        setUpMockData4test4tNEWFROMTEMPLATEImplementationDefault();
        setUpMockData4test4tNEWFROMTEMPLATEImplementationInitializedArguments();
        setUpMockData4test4tNEWFROMTEMPLATECheckPreconditions();
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

    private static void setUpMockData4test4getDynamicPopulationByFilterFExpenseReportAmount_NoFVars() {
        test4getDynamicPopulationByFilterFExpenseReportAmount_NoFVarsArg1 = new QueryRequest();
        test4getDynamicPopulationByFilterFExpenseReportAmount_NoFVarsArg1.setDisplaySetItems("expenseReportidExpenseRepor");
        test4getDynamicPopulationByFilterFExpenseReportAmount_NoFVarsArg1.addFilterRequest(new FilterRequest(ExpenseReportConstants.FILTER_NAME_FEXPENSEREPORTAMOUNT,new ArrayList<>()));
        test4getDynamicPopulationByFilterFExpenseReportAmount_NoFVarsResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationByFilterFExpenseReportAmount_WithFVars() {
        test4getDynamicPopulationByFilterFExpenseReportAmount_WithFVarsArg1 = new QueryRequest();
        test4getDynamicPopulationByFilterFExpenseReportAmount_WithFVarsArg1.setDisplaySetItems("expenseReportidExpenseRepor");
        test4getDynamicPopulationByFilterFExpenseReportAmount_WithFVarsArg1.addFilterRequest(new FilterRequest(ExpenseReportConstants.FILTER_NAME_FEXPENSEREPORTAMOUNT,new ArrayList<>(Arrays.asList(new FilterVariableRequest(ExpenseReportConstants.VAR_NAME_FEXPENSEREPORTAMOUNT_VAMOUNT, Double.valueOf(0))))));
        test4getDynamicPopulationByFilterFExpenseReportAmount_WithFVarsResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationByFilterFExpenseReportDates_NoFVars() {
        test4getDynamicPopulationByFilterFExpenseReportDates_NoFVarsArg1 = new QueryRequest();
        test4getDynamicPopulationByFilterFExpenseReportDates_NoFVarsArg1.setDisplaySetItems("expenseReportidExpenseRepor");
        test4getDynamicPopulationByFilterFExpenseReportDates_NoFVarsArg1.addFilterRequest(new FilterRequest(ExpenseReportConstants.FILTER_NAME_FEXPENSEREPORTDATES,new ArrayList<>()));
        test4getDynamicPopulationByFilterFExpenseReportDates_NoFVarsResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationByFilterFExpenseReportDates_WithFVars() {
        test4getDynamicPopulationByFilterFExpenseReportDates_WithFVarsArg1 = new QueryRequest();
        test4getDynamicPopulationByFilterFExpenseReportDates_WithFVarsArg1.setDisplaySetItems("expenseReportidExpenseRepor");
        test4getDynamicPopulationByFilterFExpenseReportDates_WithFVarsArg1.addFilterRequest(new FilterRequest(ExpenseReportConstants.FILTER_NAME_FEXPENSEREPORTDATES,new ArrayList<>(Arrays.asList(new FilterVariableRequest(ExpenseReportConstants.VAR_NAME_FEXPENSEREPORTDATES_VINIDATE, Date.valueOf(Constants.DATE_DEFAULTVALUE)), new FilterVariableRequest(ExpenseReportConstants.VAR_NAME_FEXPENSEREPORTDATES_VFINALDATE, Date.valueOf(Constants.DATE_DEFAULTVALUE))))));
        test4getDynamicPopulationByFilterFExpenseReportDates_WithFVarsResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationByFilterFExpenseReportStatus_NoFVars() {
        test4getDynamicPopulationByFilterFExpenseReportStatus_NoFVarsArg1 = new QueryRequest();
        test4getDynamicPopulationByFilterFExpenseReportStatus_NoFVarsArg1.setDisplaySetItems("expenseReportidExpenseRepor");
        test4getDynamicPopulationByFilterFExpenseReportStatus_NoFVarsArg1.addFilterRequest(new FilterRequest(ExpenseReportConstants.FILTER_NAME_FEXPENSEREPORTSTATUS,new ArrayList<>()));
        test4getDynamicPopulationByFilterFExpenseReportStatus_NoFVarsResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationByFilterFExpenseReportStatus_WithFVars() {
        test4getDynamicPopulationByFilterFExpenseReportStatus_WithFVarsArg1 = new QueryRequest();
        test4getDynamicPopulationByFilterFExpenseReportStatus_WithFVarsArg1.setDisplaySetItems("expenseReportidExpenseRepor");
        test4getDynamicPopulationByFilterFExpenseReportStatus_WithFVarsArg1.addFilterRequest(new FilterRequest(ExpenseReportConstants.FILTER_NAME_FEXPENSEREPORTSTATUS,new ArrayList<>(Arrays.asList(new FilterVariableRequest(ExpenseReportConstants.VAR_NAME_FEXPENSEREPORTSTATUS_VSTATUS, Long.valueOf(0))))));
        test4getDynamicPopulationByFilterFExpenseReportStatus_WithFVarsResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationByFilterFByProject_NoFVars() {
        test4getDynamicPopulationByFilterFByProject_NoFVarsArg1 = new QueryRequest();
        test4getDynamicPopulationByFilterFByProject_NoFVarsArg1.setDisplaySetItems("expenseReportidExpenseRepor");
        test4getDynamicPopulationByFilterFByProject_NoFVarsArg1.addFilterRequest(new FilterRequest(ExpenseReportConstants.FILTER_NAME_FBYPROJECT,new ArrayList<>()));
        test4getDynamicPopulationByFilterFByProject_NoFVarsResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationByFilterFByProject_WithFVars() {
        test4getDynamicPopulationByFilterFByProject_WithFVarsArg1 = new QueryRequest();
        test4getDynamicPopulationByFilterFByProject_WithFVarsArg1.setDisplaySetItems("expenseReportidExpenseRepor");
        test4getDynamicPopulationByFilterFByProject_WithFVarsArg1.addFilterRequest(new FilterRequest(ExpenseReportConstants.FILTER_NAME_FBYPROJECT,new ArrayList<>(Arrays.asList(new FilterVariableRequest(ExpenseReportConstants.VAR_NAME_FBYPROJECT_VFPROJECT, new Project())))));
        test4getDynamicPopulationByFilterFByProject_WithFVarsResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationByFilterFByID_NoFVars() {
        test4getDynamicPopulationByFilterFByID_NoFVarsArg1 = new QueryRequest();
        test4getDynamicPopulationByFilterFByID_NoFVarsArg1.setDisplaySetItems("expenseReportidExpenseRepor");
        test4getDynamicPopulationByFilterFByID_NoFVarsArg1.addFilterRequest(new FilterRequest(ExpenseReportConstants.FILTER_NAME_FBYID,new ArrayList<>()));
        test4getDynamicPopulationByFilterFByID_NoFVarsResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationByFilterFByID_WithFVars() {
        test4getDynamicPopulationByFilterFByID_WithFVarsArg1 = new QueryRequest();
        test4getDynamicPopulationByFilterFByID_WithFVarsArg1.setDisplaySetItems("expenseReportidExpenseRepor");
        test4getDynamicPopulationByFilterFByID_WithFVarsArg1.addFilterRequest(new FilterRequest(ExpenseReportConstants.FILTER_NAME_FBYID,new ArrayList<>(Arrays.asList(new FilterVariableRequest(ExpenseReportConstants.VAR_NAME_FBYID_VID, Long.valueOf(0))))));
        test4getDynamicPopulationByFilterFByID_WithFVarsResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationByOrderCriteriaOCExpenseReportDate() {
        test4getDynamicPopulationByOrderCriteriaOCExpenseReportDateArg1 = new QueryRequest();
        test4getDynamicPopulationByOrderCriteriaOCExpenseReportDateArg1.setDisplaySetItems("expenseReportidExpenseRepor");
        test4getDynamicPopulationByOrderCriteriaOCExpenseReportDateArg1.setOrderCriteriaName("OCExpenseReportDate");
        test4getDynamicPopulationByOrderCriteriaOCExpenseReportDateResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationByOrderCriteriaOCExpenseReportAmount() {
        test4getDynamicPopulationByOrderCriteriaOCExpenseReportAmountArg1 = new QueryRequest();
        test4getDynamicPopulationByOrderCriteriaOCExpenseReportAmountArg1.setDisplaySetItems("expenseReportidExpenseRepor");
        test4getDynamicPopulationByOrderCriteriaOCExpenseReportAmountArg1.setOrderCriteriaName("OCExpenseReportAmount");
        test4getDynamicPopulationByOrderCriteriaOCExpenseReportAmountResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationFilterByOID() {
        test4getDynamicPopulationFilterByOIDArg1 = new QueryRequest();
        test4getDynamicPopulationFilterByOIDArg1.setDisplaySetItems("expenseReportidExpenseRepor");
        test4getDynamicPopulationFilterByOIDArg1.addFilterRequest(new FilterRequest(Constants.FILTER_BY_OID,new ArrayList<>(Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_OID_FVAR_OID, new ExpenseReportOid(Long.valueOf(0)))))));
        test4getDynamicPopulationFilterByOIDResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPreload4DSExpenseReport4MD() {
        test4getDynamicPreload4DSExpenseReport4MDArg1 = new QueryRequest();
        test4getDynamicPreload4DSExpenseReport4MDArg1.setDisplaySetName(ExpenseReportConstants.DSDSEXPENSEREPORT4MD);
        test4getDynamicPreload4DSExpenseReport4MDResult = new PreloadResponseViewModel(mockPopulation.stream().map(i -> ExpenseReportService.buildPreloadViewModel(i, test4getDynamicPreload4DSExpenseReport4MDArg1.getDisplaySetName())).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPreload4DSExpenseReportSup() {
        test4getDynamicPreload4DSExpenseReportSupArg1 = new QueryRequest();
        test4getDynamicPreload4DSExpenseReportSupArg1.setDisplaySetName(ExpenseReportConstants.DSDSEXPENSEREPORTSUP);
        test4getDynamicPreload4DSExpenseReportSupResult = new PreloadResponseViewModel(mockPopulation.stream().map(i -> ExpenseReportService.buildPreloadViewModel(i, test4getDynamicPreload4DSExpenseReportSupArg1.getDisplaySetName())).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPreload4DSExpenseReport4HAT() {
        test4getDynamicPreload4DSExpenseReport4HATArg1 = new QueryRequest();
        test4getDynamicPreload4DSExpenseReport4HATArg1.setDisplaySetName(ExpenseReportConstants.DSDSEXPENSEREPORT4HAT);
        test4getDynamicPreload4DSExpenseReport4HATResult = new PreloadResponseViewModel(mockPopulation.stream().map(i -> ExpenseReportService.buildPreloadViewModel(i, test4getDynamicPreload4DSExpenseReport4HATArg1.getDisplaySetName())).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getByRelatedDynamic() {
        test4getByRelatedDynamicArg1 = "";
        test4getByRelatedDynamicArg2 = "";
        test4getByRelatedDynamicArg3 = "";
        test4getByRelatedDynamicResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getById() {
        test4getByIdArg1 = Long.valueOf(0);
        test4getByIdResult = mockExpenseReport.get();
    }

    private static void setUpMockData4test4getByRelated() {
        test4getByRelatedArg1 = new ExpenseReport();
        test4getByRelatedArg2 = "";
        test4getByRelatedResult = mockPopulation;
    }

    private static void setUpMockData4test4getInstancesByRelated() {
        test4getInstancesByRelatedArg1 = new ExpenseReport();
        test4getInstancesByRelatedArg2 = "";
        test4getInstancesByRelatedResult = mockPopulation;
    }

    private static void setUpMockData4test4getExpenseReportDynamic() {
        test4getExpenseReportDynamicArg1 = new ExpenseReportOid();
        test4getExpenseReportDynamicArg2 = "";
        test4getExpenseReportDynamicResult = new InstanceResponseViewModel();
    }

    private static void setUpMockData4test4getSuppInfoWithoutInstance() {
        test4getSuppInfoWithoutInstanceArg1 = new ExpenseReportOid();
        test4getSuppInfoWithoutInstanceArg2 = "";
        test4getSuppInfoWithoutInstanceResult = "";
    }

    private static void setUpMockData4test4getSuppInfoWithInstance() {
        test4getSuppInfoWithInstanceArg1 = new ExpenseReportOid(Long.valueOf(0));
        test4getSuppInfoWithInstanceArg2 = "";
    }

    private static void setUpMockData4test4getSuppInfoWithDSDSExpenseReportSup() {
        test4getSuppInfoWithDSDSExpenseReportSupArg1 = new ExpenseReportOid(Long.valueOf(0));
        test4getSuppInfoWithDSDSExpenseReportSupArg2 = ExpenseReportConstants.DSDSEXPENSEREPORTSUP;
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleExpenseLinesWithoutRemainingPath() {
        test4buildRelatedInstance4RoleExpenseLinesWithoutRemainingPathArg1 = new ExpenseLineOid(Long.valueOf(0), Long.valueOf(0)).toJson();
        test4buildRelatedInstance4RoleExpenseLinesWithoutRemainingPathArg2 = ExpenseReportConstants.ROLE_NAME_EXPENSELINES;
        test4buildRelatedInstance4RoleExpenseLinesWithoutRemainingPathArg3 = "";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleExpenseLinesWithRemainingPath() {
        test4buildRelatedInstance4RoleExpenseLinesWithRemainingPathArg1 = new ExpenseLineOid(Long.valueOf(0), Long.valueOf(0)).toJson();
        test4buildRelatedInstance4RoleExpenseLinesWithRemainingPathArg2 = ExpenseReportConstants.ROLE_NAME_EXPENSELINES;
        test4buildRelatedInstance4RoleExpenseLinesWithRemainingPathArg3 = "dummy";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleEmployeeWithoutRemainingPath() {
        test4buildRelatedInstance4RoleEmployeeWithoutRemainingPathArg1 = new EmployeeOid("").toJson();
        test4buildRelatedInstance4RoleEmployeeWithoutRemainingPathArg2 = ExpenseReportConstants.ROLE_NAME_EMPLOYEE;
        test4buildRelatedInstance4RoleEmployeeWithoutRemainingPathArg3 = "";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleEmployeeWithRemainingPath() {
        test4buildRelatedInstance4RoleEmployeeWithRemainingPathArg1 = new EmployeeOid("").toJson();
        test4buildRelatedInstance4RoleEmployeeWithRemainingPathArg2 = ExpenseReportConstants.ROLE_NAME_EMPLOYEE;
        test4buildRelatedInstance4RoleEmployeeWithRemainingPathArg3 = "dummy";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleExpenseCurrencyWithoutRemainingPath() {
        test4buildRelatedInstance4RoleExpenseCurrencyWithoutRemainingPathArg1 = new ExpenseCurrencyOid("").toJson();
        test4buildRelatedInstance4RoleExpenseCurrencyWithoutRemainingPathArg2 = ExpenseReportConstants.ROLE_NAME_EXPENSECURRENCY;
        test4buildRelatedInstance4RoleExpenseCurrencyWithoutRemainingPathArg3 = "";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleExpenseCurrencyWithRemainingPath() {
        test4buildRelatedInstance4RoleExpenseCurrencyWithRemainingPathArg1 = new ExpenseCurrencyOid("").toJson();
        test4buildRelatedInstance4RoleExpenseCurrencyWithRemainingPathArg2 = ExpenseReportConstants.ROLE_NAME_EXPENSECURRENCY;
        test4buildRelatedInstance4RoleExpenseCurrencyWithRemainingPathArg3 = "dummy";
    }

    private static void setUpMockData4test4buildRelatedInstance4RolePaymentTypeWithoutRemainingPath() {
        test4buildRelatedInstance4RolePaymentTypeWithoutRemainingPathArg1 = new PaymentTypeOid("").toJson();
        test4buildRelatedInstance4RolePaymentTypeWithoutRemainingPathArg2 = ExpenseReportConstants.ROLE_NAME_PAYMENTTYPE;
        test4buildRelatedInstance4RolePaymentTypeWithoutRemainingPathArg3 = "";
    }

    private static void setUpMockData4test4buildRelatedInstance4RolePaymentTypeWithRemainingPath() {
        test4buildRelatedInstance4RolePaymentTypeWithRemainingPathArg1 = new PaymentTypeOid("").toJson();
        test4buildRelatedInstance4RolePaymentTypeWithRemainingPathArg2 = ExpenseReportConstants.ROLE_NAME_PAYMENTTYPE;
        test4buildRelatedInstance4RolePaymentTypeWithRemainingPathArg3 = "dummy";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleProjectWithoutRemainingPath() {
        test4buildRelatedInstance4RoleProjectWithoutRemainingPathArg1 = new ProjectOid(Long.valueOf(0)).toJson();
        test4buildRelatedInstance4RoleProjectWithoutRemainingPathArg2 = ExpenseReportConstants.ROLE_NAME_PROJECT;
        test4buildRelatedInstance4RoleProjectWithoutRemainingPathArg3 = "";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleProjectWithRemainingPath() {
        test4buildRelatedInstance4RoleProjectWithRemainingPathArg1 = new ProjectOid(Long.valueOf(0)).toJson();
        test4buildRelatedInstance4RoleProjectWithRemainingPathArg2 = ExpenseReportConstants.ROLE_NAME_PROJECT;
        test4buildRelatedInstance4RoleProjectWithRemainingPathArg3 = "dummy";
    }

    private static void setUpMockData4test4getDSExpenseReport4MD() {
        test4getDSExpenseReport4MDArg1 = "";
        test4getDSExpenseReport4MDArg2 = "";
        test4getDSExpenseReport4MDArg3 = "";
        test4getDSExpenseReport4MDResult = new DSExpenseReport4MD();
    }

    private static void setUpMockData4test4getPreloadDSExpenseReport4MD() {
        test4getPreloadDSExpenseReport4MDArg1 = new QueryRequest();
        test4getPreloadDSExpenseReport4MDArg1.setDisplaySetName(ExpenseReportConstants.DSDSEXPENSEREPORT4MD);
        test4getPreloadDSExpenseReport4MDResult = mockPopulation.stream().map(i -> ExpenseReportService.buildPreloadViewModel(i, test4getPreloadDSExpenseReport4MDArg1.getDisplaySetName())).collect(Collectors.toList());
    }

    private static void setUpMockData4test4getDSExpenseReportSup() {
        test4getDSExpenseReportSupArg1 = "";
        test4getDSExpenseReportSupArg2 = "";
        test4getDSExpenseReportSupArg3 = "";
        test4getDSExpenseReportSupResult = new DSExpenseReportSup();
    }

    private static void setUpMockData4test4getPreloadDSExpenseReportSup() {
        test4getPreloadDSExpenseReportSupArg1 = new QueryRequest();
        test4getPreloadDSExpenseReportSupArg1.setDisplaySetName(ExpenseReportConstants.DSDSEXPENSEREPORTSUP);
        test4getPreloadDSExpenseReportSupResult = mockPopulation.stream().map(i -> ExpenseReportService.buildPreloadViewModel(i, test4getPreloadDSExpenseReportSupArg1.getDisplaySetName())).collect(Collectors.toList());
    }

    private static void setUpMockData4test4getDSExpenseReport4HAT() {
        test4getDSExpenseReport4HATArg1 = "";
        test4getDSExpenseReport4HATArg2 = "";
        test4getDSExpenseReport4HATArg3 = "";
        test4getDSExpenseReport4HATResult = new DSExpenseReport4HAT();
    }

    private static void setUpMockData4test4getPreloadDSExpenseReport4HAT() {
        test4getPreloadDSExpenseReport4HATArg1 = new QueryRequest();
        test4getPreloadDSExpenseReport4HATArg1.setDisplaySetName(ExpenseReportConstants.DSDSEXPENSEREPORT4HAT);
        test4getPreloadDSExpenseReport4HATResult = mockPopulation.stream().map(i -> ExpenseReportService.buildPreloadViewModel(i, test4getPreloadDSExpenseReport4HATArg1.getDisplaySetName())).collect(Collectors.toList());
    }

    private static void setUpMockData4test4iIUExpenseReport() {
        test4iIUExpenseReportArg1 = new ExpenseReportOid();
        test4iIUExpenseReportResult = new DSExpenseReport4MD();
    }

    private static void setUpMockData4test4piuPIUExpenseReport() {
        test4piuPIUExpenseReportArg1 = new QueryRequest();
        test4piuPIUExpenseReportResult = mockPopulation.stream().map(i -> new DSExpenseReport4HAT(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4getCount4PIUExpenseReport() {
        test4getCount4PIUExpenseReportArg1 = new QueryRequest();
        test4getCount4PIUExpenseReportResult = mockPopulation.size();
    }

    private static void setUpMockData4test4piuPIUExpenseReportWithFilterFByProject_NoFVars() {
        test4piuPIUExpenseReportWithFilterFByProject_NoFVarsArg1 = new QueryRequest();
        test4piuPIUExpenseReportWithFilterFByProject_NoFVarsArg1.addFilterRequest(new FilterRequest(ExpenseReportConstants.FILTER_NAME_FBYPROJECT,new ArrayList<>()));
        test4piuPIUExpenseReportWithFilterFByProject_NoFVarsResult = mockPopulation.stream().map(i -> new DSExpenseReport4HAT(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4piuPIUExpenseReportWithFilterFByProject_WithFVars() {
        test4piuPIUExpenseReportWithFilterFByProject_WithFVarsArg1 = new QueryRequest();
        test4piuPIUExpenseReportWithFilterFByProject_WithFVarsArg1.addFilterRequest(new FilterRequest(ExpenseReportConstants.FILTER_NAME_FBYPROJECT,new ArrayList<>(Arrays.asList(new FilterVariableRequest(ExpenseReportConstants.VAR_NAME_FBYPROJECT_VFPROJECT, new Project())))));
        test4piuPIUExpenseReportWithFilterFByProject_WithFVarsResult = mockPopulation.stream().map(i -> new DSExpenseReport4HAT(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4piuPIUExpenseReportWithFilterFExpenseReportAmount_NoFVars() {
        test4piuPIUExpenseReportWithFilterFExpenseReportAmount_NoFVarsArg1 = new QueryRequest();
        test4piuPIUExpenseReportWithFilterFExpenseReportAmount_NoFVarsArg1.addFilterRequest(new FilterRequest(ExpenseReportConstants.FILTER_NAME_FEXPENSEREPORTAMOUNT,new ArrayList<>()));
        test4piuPIUExpenseReportWithFilterFExpenseReportAmount_NoFVarsResult = mockPopulation.stream().map(i -> new DSExpenseReport4HAT(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4piuPIUExpenseReportWithFilterFExpenseReportAmount_WithFVars() {
        test4piuPIUExpenseReportWithFilterFExpenseReportAmount_WithFVarsArg1 = new QueryRequest();
        test4piuPIUExpenseReportWithFilterFExpenseReportAmount_WithFVarsArg1.addFilterRequest(new FilterRequest(ExpenseReportConstants.FILTER_NAME_FEXPENSEREPORTAMOUNT,new ArrayList<>(Arrays.asList(new FilterVariableRequest(ExpenseReportConstants.VAR_NAME_FEXPENSEREPORTAMOUNT_VAMOUNT, Double.valueOf(0))))));
        test4piuPIUExpenseReportWithFilterFExpenseReportAmount_WithFVarsResult = mockPopulation.stream().map(i -> new DSExpenseReport4HAT(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4piuPIUExpenseReportWithFilterFExpenseReportStatus_NoFVars() {
        test4piuPIUExpenseReportWithFilterFExpenseReportStatus_NoFVarsArg1 = new QueryRequest();
        test4piuPIUExpenseReportWithFilterFExpenseReportStatus_NoFVarsArg1.addFilterRequest(new FilterRequest(ExpenseReportConstants.FILTER_NAME_FEXPENSEREPORTSTATUS,new ArrayList<>()));
        test4piuPIUExpenseReportWithFilterFExpenseReportStatus_NoFVarsResult = mockPopulation.stream().map(i -> new DSExpenseReport4HAT(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4piuPIUExpenseReportWithFilterFExpenseReportStatus_WithFVars() {
        test4piuPIUExpenseReportWithFilterFExpenseReportStatus_WithFVarsArg1 = new QueryRequest();
        test4piuPIUExpenseReportWithFilterFExpenseReportStatus_WithFVarsArg1.addFilterRequest(new FilterRequest(ExpenseReportConstants.FILTER_NAME_FEXPENSEREPORTSTATUS,new ArrayList<>(Arrays.asList(new FilterVariableRequest(ExpenseReportConstants.VAR_NAME_FEXPENSEREPORTSTATUS_VSTATUS, Long.valueOf(0))))));
        test4piuPIUExpenseReportWithFilterFExpenseReportStatus_WithFVarsResult = mockPopulation.stream().map(i -> new DSExpenseReport4HAT(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4piuPIUExpenseReportToEmployee() {
        test4piuPIUExpenseReportToEmployeeArg1 = new QueryRequest();
        test4piuPIUExpenseReportToEmployeeResult = mockPopulation.stream().map(i -> new DSExpenseReport4MD(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4getCount4PIUExpenseReportToEmployee() {
        test4getCount4PIUExpenseReportToEmployeeArg1 = new QueryRequest();
        test4getCount4PIUExpenseReportToEmployeeResult = mockPopulation.size();
    }

    private static void setUpMockData4test4piuPIUExpenseReportToEmployeeWithFilterFExpenseReportDates_NoFVars() {
        test4piuPIUExpenseReportToEmployeeWithFilterFExpenseReportDates_NoFVarsArg1 = new QueryRequest();
        test4piuPIUExpenseReportToEmployeeWithFilterFExpenseReportDates_NoFVarsArg1.addFilterRequest(new FilterRequest(ExpenseReportConstants.FILTER_NAME_FEXPENSEREPORTDATES,new ArrayList<>()));
        test4piuPIUExpenseReportToEmployeeWithFilterFExpenseReportDates_NoFVarsResult = mockPopulation.stream().map(i -> new DSExpenseReport4MD(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4piuPIUExpenseReportToEmployeeWithFilterFExpenseReportDates_WithFVars() {
        test4piuPIUExpenseReportToEmployeeWithFilterFExpenseReportDates_WithFVarsArg1 = new QueryRequest();
        test4piuPIUExpenseReportToEmployeeWithFilterFExpenseReportDates_WithFVarsArg1.addFilterRequest(new FilterRequest(ExpenseReportConstants.FILTER_NAME_FEXPENSEREPORTDATES,new ArrayList<>(Arrays.asList(new FilterVariableRequest(ExpenseReportConstants.VAR_NAME_FEXPENSEREPORTDATES_VINIDATE, Date.valueOf(Constants.DATE_DEFAULTVALUE)), new FilterVariableRequest(ExpenseReportConstants.VAR_NAME_FEXPENSEREPORTDATES_VFINALDATE, Date.valueOf(Constants.DATE_DEFAULTVALUE))))));
        test4piuPIUExpenseReportToEmployeeWithFilterFExpenseReportDates_WithFVarsResult = mockPopulation.stream().map(i -> new DSExpenseReport4MD(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4piuPIUExpenseReportProject() {
        test4piuPIUExpenseReportProjectArg1 = new QueryRequest();
        test4piuPIUExpenseReportProjectResult = mockPopulation.stream().map(i -> new DSExpenseReport4MD(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4getCount4PIUExpenseReportProject() {
        test4getCount4PIUExpenseReportProjectArg1 = new QueryRequest();
        test4getCount4PIUExpenseReportProjectResult = mockPopulation.size();
    }

    private static void setUpMockData4test4piuPIUExpenseReportProjectWithFilterFExpenseReportDates_NoFVars() {
        test4piuPIUExpenseReportProjectWithFilterFExpenseReportDates_NoFVarsArg1 = new QueryRequest();
        test4piuPIUExpenseReportProjectWithFilterFExpenseReportDates_NoFVarsArg1.addFilterRequest(new FilterRequest(ExpenseReportConstants.FILTER_NAME_FEXPENSEREPORTDATES,new ArrayList<>()));
        test4piuPIUExpenseReportProjectWithFilterFExpenseReportDates_NoFVarsResult = mockPopulation.stream().map(i -> new DSExpenseReport4MD(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4piuPIUExpenseReportProjectWithFilterFExpenseReportDates_WithFVars() {
        test4piuPIUExpenseReportProjectWithFilterFExpenseReportDates_WithFVarsArg1 = new QueryRequest();
        test4piuPIUExpenseReportProjectWithFilterFExpenseReportDates_WithFVarsArg1.addFilterRequest(new FilterRequest(ExpenseReportConstants.FILTER_NAME_FEXPENSEREPORTDATES,new ArrayList<>(Arrays.asList(new FilterVariableRequest(ExpenseReportConstants.VAR_NAME_FEXPENSEREPORTDATES_VINIDATE, Date.valueOf(Constants.DATE_DEFAULTVALUE)), new FilterVariableRequest(ExpenseReportConstants.VAR_NAME_FEXPENSEREPORTDATES_VFINALDATE, Date.valueOf(Constants.DATE_DEFAULTVALUE))))));
        test4piuPIUExpenseReportProjectWithFilterFExpenseReportDates_WithFVarsResult = mockPopulation.stream().map(i -> new DSExpenseReport4MD(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4piuPIUExpenseReportProjectWithFilterFExpenseReportAmount_NoFVars() {
        test4piuPIUExpenseReportProjectWithFilterFExpenseReportAmount_NoFVarsArg1 = new QueryRequest();
        test4piuPIUExpenseReportProjectWithFilterFExpenseReportAmount_NoFVarsArg1.addFilterRequest(new FilterRequest(ExpenseReportConstants.FILTER_NAME_FEXPENSEREPORTAMOUNT,new ArrayList<>()));
        test4piuPIUExpenseReportProjectWithFilterFExpenseReportAmount_NoFVarsResult = mockPopulation.stream().map(i -> new DSExpenseReport4MD(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4piuPIUExpenseReportProjectWithFilterFExpenseReportAmount_WithFVars() {
        test4piuPIUExpenseReportProjectWithFilterFExpenseReportAmount_WithFVarsArg1 = new QueryRequest();
        test4piuPIUExpenseReportProjectWithFilterFExpenseReportAmount_WithFVarsArg1.addFilterRequest(new FilterRequest(ExpenseReportConstants.FILTER_NAME_FEXPENSEREPORTAMOUNT,new ArrayList<>(Arrays.asList(new FilterVariableRequest(ExpenseReportConstants.VAR_NAME_FEXPENSEREPORTAMOUNT_VAMOUNT, Double.valueOf(0))))));
        test4piuPIUExpenseReportProjectWithFilterFExpenseReportAmount_WithFVarsResult = mockPopulation.stream().map(i -> new DSExpenseReport4MD(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4piuPIUExpenseReportProjectWithFilterFExpenseReportStatus_NoFVars() {
        test4piuPIUExpenseReportProjectWithFilterFExpenseReportStatus_NoFVarsArg1 = new QueryRequest();
        test4piuPIUExpenseReportProjectWithFilterFExpenseReportStatus_NoFVarsArg1.addFilterRequest(new FilterRequest(ExpenseReportConstants.FILTER_NAME_FEXPENSEREPORTSTATUS,new ArrayList<>()));
        test4piuPIUExpenseReportProjectWithFilterFExpenseReportStatus_NoFVarsResult = mockPopulation.stream().map(i -> new DSExpenseReport4MD(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4piuPIUExpenseReportProjectWithFilterFExpenseReportStatus_WithFVars() {
        test4piuPIUExpenseReportProjectWithFilterFExpenseReportStatus_WithFVarsArg1 = new QueryRequest();
        test4piuPIUExpenseReportProjectWithFilterFExpenseReportStatus_WithFVarsArg1.addFilterRequest(new FilterRequest(ExpenseReportConstants.FILTER_NAME_FEXPENSEREPORTSTATUS,new ArrayList<>(Arrays.asList(new FilterVariableRequest(ExpenseReportConstants.VAR_NAME_FEXPENSEREPORTSTATUS_VSTATUS, Long.valueOf(0))))));
        test4piuPIUExpenseReportProjectWithFilterFExpenseReportStatus_WithFVarsResult = mockPopulation.stream().map(i -> new DSExpenseReport4MD(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4newexpenseDefault() {
        test4newexpenseDefaultArg1 = new NewexpenseRequest();
    }

    private static void setUpMockData4test4newexpenseInitializedArguments() {
        test4newexpenseInitializedArgumentsArg1 = new NewexpenseRequest();
        test4newexpenseInitializedArgumentsArg1.setExpenseReportnewexpensepagrExpenseCurrency(new ExpenseCurrencyOid(""));
        test4newexpenseInitializedArgumentsArg1.setExpenseReportnewexpensepagrExpenseCurrencyInstance(new ExpenseCurrency(test4newexpenseInitializedArgumentsArg1.getExpenseReportnewexpensepagrExpenseCurrency()));
        test4newexpenseInitializedArgumentsArg1.setExpenseReportnewexpensepagrPaymentType(new PaymentTypeOid(""));
        test4newexpenseInitializedArgumentsArg1.setExpenseReportnewexpensepagrPaymentTypeInstance(new PaymentType(test4newexpenseInitializedArgumentsArg1.getExpenseReportnewexpensepagrPaymentType()));
        test4newexpenseInitializedArgumentsArg1.setExpenseReportnewexpensepagrProject(new ProjectOid(Long.valueOf(0)));
        test4newexpenseInitializedArgumentsArg1.setExpenseReportnewexpensepagrProjectInstance(new Project(test4newexpenseInitializedArgumentsArg1.getExpenseReportnewexpensepagrProject()));
        test4newexpenseInitializedArgumentsArg1.setExpenseReportnewexpensepagrEmployee(new EmployeeOid(""));
        test4newexpenseInitializedArgumentsArg1.setExpenseReportnewexpensepagrEmployeeInstance(new Employee(test4newexpenseInitializedArgumentsArg1.getExpenseReportnewexpensepagrEmployee()));
        test4newexpenseInitializedArgumentsArg1.setExpenseReportnewexpensepatrPresentDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        test4newexpenseInitializedArgumentsArg1.setExpenseReportnewexpensepatrCause("");
        test4newexpenseInitializedArgumentsArg1.setExpenseReportnewexpensepatrAdvances(Double.valueOf(0));
        test4newexpenseInitializedArgumentsArg1.setExpenseReportnewexpensepatrExchange(Double.valueOf(0));
    }

    private static void setUpMockData4test4newexpenseTxnDefault() {
        test4newexpenseTxnDefaultArg1 = new NewexpenseRequest();
        test4newexpenseTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4newexpenseTxnInitializedArguments() {
        test4newexpenseTxnInitializedArgumentsArg1 = new NewexpenseRequest();
        test4newexpenseTxnInitializedArgumentsArg1.setExpenseReportnewexpensepagrExpenseCurrency(new ExpenseCurrencyOid(""));
        test4newexpenseTxnInitializedArgumentsArg1.setExpenseReportnewexpensepagrExpenseCurrencyInstance(new ExpenseCurrency(test4newexpenseTxnInitializedArgumentsArg1.getExpenseReportnewexpensepagrExpenseCurrency()));
        test4newexpenseTxnInitializedArgumentsArg1.setExpenseReportnewexpensepagrPaymentType(new PaymentTypeOid(""));
        test4newexpenseTxnInitializedArgumentsArg1.setExpenseReportnewexpensepagrPaymentTypeInstance(new PaymentType(test4newexpenseTxnInitializedArgumentsArg1.getExpenseReportnewexpensepagrPaymentType()));
        test4newexpenseTxnInitializedArgumentsArg1.setExpenseReportnewexpensepagrProject(new ProjectOid(Long.valueOf(0)));
        test4newexpenseTxnInitializedArgumentsArg1.setExpenseReportnewexpensepagrProjectInstance(new Project(test4newexpenseTxnInitializedArgumentsArg1.getExpenseReportnewexpensepagrProject()));
        test4newexpenseTxnInitializedArgumentsArg1.setExpenseReportnewexpensepagrEmployee(new EmployeeOid(""));
        test4newexpenseTxnInitializedArgumentsArg1.setExpenseReportnewexpensepagrEmployeeInstance(new Employee(test4newexpenseTxnInitializedArgumentsArg1.getExpenseReportnewexpensepagrEmployee()));
        test4newexpenseTxnInitializedArgumentsArg1.setExpenseReportnewexpensepatrPresentDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        test4newexpenseTxnInitializedArgumentsArg1.setExpenseReportnewexpensepatrCause("");
        test4newexpenseTxnInitializedArgumentsArg1.setExpenseReportnewexpensepatrAdvances(Double.valueOf(0));
        test4newexpenseTxnInitializedArgumentsArg1.setExpenseReportnewexpensepatrExchange(Double.valueOf(0));
        test4newexpenseTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4newexpenseImplementationDefault() {
        test4newexpenseImplementationDefaultArg1 = new NewexpenseRequest();
        test4newexpenseImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4newexpenseImplementationInitializedArguments() {
        test4newexpenseImplementationInitializedArgumentsArg1 = new NewexpenseRequest();
        test4newexpenseImplementationInitializedArgumentsArg1.setExpenseReportnewexpensepagrExpenseCurrency(new ExpenseCurrencyOid(""));
        test4newexpenseImplementationInitializedArgumentsArg1.setExpenseReportnewexpensepagrExpenseCurrencyInstance(new ExpenseCurrency(test4newexpenseImplementationInitializedArgumentsArg1.getExpenseReportnewexpensepagrExpenseCurrency()));
        test4newexpenseImplementationInitializedArgumentsArg1.setExpenseReportnewexpensepagrPaymentType(new PaymentTypeOid(""));
        test4newexpenseImplementationInitializedArgumentsArg1.setExpenseReportnewexpensepagrPaymentTypeInstance(new PaymentType(test4newexpenseImplementationInitializedArgumentsArg1.getExpenseReportnewexpensepagrPaymentType()));
        test4newexpenseImplementationInitializedArgumentsArg1.setExpenseReportnewexpensepagrProject(new ProjectOid(Long.valueOf(0)));
        test4newexpenseImplementationInitializedArgumentsArg1.setExpenseReportnewexpensepagrProjectInstance(new Project(test4newexpenseImplementationInitializedArgumentsArg1.getExpenseReportnewexpensepagrProject()));
        test4newexpenseImplementationInitializedArgumentsArg1.setExpenseReportnewexpensepagrEmployee(new EmployeeOid(""));
        test4newexpenseImplementationInitializedArgumentsArg1.setExpenseReportnewexpensepagrEmployeeInstance(new Employee(test4newexpenseImplementationInitializedArgumentsArg1.getExpenseReportnewexpensepagrEmployee()));
        test4newexpenseImplementationInitializedArgumentsArg1.setExpenseReportnewexpensepatrPresentDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        test4newexpenseImplementationInitializedArgumentsArg1.setExpenseReportnewexpensepatrCause("");
        test4newexpenseImplementationInitializedArgumentsArg1.setExpenseReportnewexpensepatrAdvances(Double.valueOf(0));
        test4newexpenseImplementationInitializedArgumentsArg1.setExpenseReportnewexpensepatrExchange(Double.valueOf(0));
        test4newexpenseImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4delexpenseDefault() {
        test4delexpenseDefaultArg1 = new DelexpenseRequest();
    }

    private static void setUpMockData4test4delexpenseInitializedArguments() {
        test4delexpenseInitializedArgumentsArg1 = new DelexpenseRequest();
        test4delexpenseInitializedArgumentsArg1.setExpenseReportdelexpensepthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4delexpenseInitializedArgumentsArg1.setExpenseReportdelexpensepthisExpenseReportInstance(new ExpenseReport(test4delexpenseInitializedArgumentsArg1.getExpenseReportdelexpensepthisExpenseReport()));
    }

    private static void setUpMockData4test4delexpenseTxnDefault() {
        test4delexpenseTxnDefaultArg1 = new DelexpenseRequest();
        test4delexpenseTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4delexpenseTxnInitializedArguments() {
        test4delexpenseTxnInitializedArgumentsArg1 = new DelexpenseRequest();
        test4delexpenseTxnInitializedArgumentsArg1.setExpenseReportdelexpensepthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4delexpenseTxnInitializedArgumentsArg1.setExpenseReportdelexpensepthisExpenseReportInstance(new ExpenseReport(test4delexpenseTxnInitializedArgumentsArg1.getExpenseReportdelexpensepthisExpenseReport()));
        test4delexpenseTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4delexpenseImplementationDefault() {
        test4delexpenseImplementationDefaultArg1 = new DelexpenseRequest();
        test4delexpenseImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4delexpenseImplementationInitializedArguments() {
        test4delexpenseImplementationInitializedArgumentsArg1 = new DelexpenseRequest();
        test4delexpenseImplementationInitializedArgumentsArg1.setExpenseReportdelexpensepthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4delexpenseImplementationInitializedArgumentsArg1.setExpenseReportdelexpensepthisExpenseReportInstance(new ExpenseReport(test4delexpenseImplementationInitializedArgumentsArg1.getExpenseReportdelexpensepthisExpenseReport()));
        test4delexpenseImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4ecloseDefault() {
        test4ecloseDefaultArg1 = new EcloseRequest();
    }

    private static void setUpMockData4test4ecloseInitializedArguments() {
        test4ecloseInitializedArgumentsArg1 = new EcloseRequest();
        test4ecloseInitializedArgumentsArg1.setExpenseReporteclosepthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4ecloseInitializedArgumentsArg1.setExpenseReporteclosepthisExpenseReportInstance(new ExpenseReport(test4ecloseInitializedArgumentsArg1.getExpenseReporteclosepthisExpenseReport()));
    }

    private static void setUpMockData4test4ecloseTxnDefault() {
        test4ecloseTxnDefaultArg1 = new EcloseRequest();
        test4ecloseTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4ecloseTxnInitializedArguments() {
        test4ecloseTxnInitializedArgumentsArg1 = new EcloseRequest();
        test4ecloseTxnInitializedArgumentsArg1.setExpenseReporteclosepthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4ecloseTxnInitializedArgumentsArg1.setExpenseReporteclosepthisExpenseReportInstance(new ExpenseReport(test4ecloseTxnInitializedArgumentsArg1.getExpenseReporteclosepthisExpenseReport()));
        test4ecloseTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4ecloseImplementationDefault() {
        test4ecloseImplementationDefaultArg1 = new EcloseRequest();
        test4ecloseImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4ecloseImplementationInitializedArguments() {
        test4ecloseImplementationInitializedArgumentsArg1 = new EcloseRequest();
        test4ecloseImplementationInitializedArgumentsArg1.setExpenseReporteclosepthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4ecloseImplementationInitializedArgumentsArg1.setExpenseReporteclosepthisExpenseReportInstance(new ExpenseReport(test4ecloseImplementationInitializedArgumentsArg1.getExpenseReporteclosepthisExpenseReport()));
        test4ecloseImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4authorizeDefault() {
        test4authorizeDefaultArg1 = new AuthorizeRequest();
    }

    private static void setUpMockData4test4authorizeInitializedArguments() {
        test4authorizeInitializedArgumentsArg1 = new AuthorizeRequest();
        test4authorizeInitializedArgumentsArg1.setExpenseReportauthorizepthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4authorizeInitializedArgumentsArg1.setExpenseReportauthorizepthisExpenseReportInstance(new ExpenseReport(test4authorizeInitializedArgumentsArg1.getExpenseReportauthorizepthisExpenseReport()));
        test4authorizeInitializedArgumentsArg1.setExpenseReportauthorizepsDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        test4authorizeInitializedArgumentsArg1.setExpenseReportauthorizepsComments("");
    }

    private static void setUpMockData4test4authorizeTxnDefault() {
        test4authorizeTxnDefaultArg1 = new AuthorizeRequest();
        test4authorizeTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4authorizeTxnInitializedArguments() {
        test4authorizeTxnInitializedArgumentsArg1 = new AuthorizeRequest();
        test4authorizeTxnInitializedArgumentsArg1.setExpenseReportauthorizepthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4authorizeTxnInitializedArgumentsArg1.setExpenseReportauthorizepthisExpenseReportInstance(new ExpenseReport(test4authorizeTxnInitializedArgumentsArg1.getExpenseReportauthorizepthisExpenseReport()));
        test4authorizeTxnInitializedArgumentsArg1.setExpenseReportauthorizepsDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        test4authorizeTxnInitializedArgumentsArg1.setExpenseReportauthorizepsComments("");
        test4authorizeTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4authorizeImplementationDefault() {
        test4authorizeImplementationDefaultArg1 = new AuthorizeRequest();
        test4authorizeImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4authorizeImplementationInitializedArguments() {
        test4authorizeImplementationInitializedArgumentsArg1 = new AuthorizeRequest();
        test4authorizeImplementationInitializedArgumentsArg1.setExpenseReportauthorizepthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4authorizeImplementationInitializedArgumentsArg1.setExpenseReportauthorizepthisExpenseReportInstance(new ExpenseReport(test4authorizeImplementationInitializedArgumentsArg1.getExpenseReportauthorizepthisExpenseReport()));
        test4authorizeImplementationInitializedArgumentsArg1.setExpenseReportauthorizepsDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        test4authorizeImplementationInitializedArgumentsArg1.setExpenseReportauthorizepsComments("");
        test4authorizeImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4payDefault() {
        test4payDefaultArg1 = new PayRequest();
    }

    private static void setUpMockData4test4payInitializedArguments() {
        test4payInitializedArgumentsArg1 = new PayRequest();
        test4payInitializedArgumentsArg1.setExpenseReportpaypthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4payInitializedArgumentsArg1.setExpenseReportpaypthisExpenseReportInstance(new ExpenseReport(test4payInitializedArgumentsArg1.getExpenseReportpaypthisExpenseReport()));
        test4payInitializedArgumentsArg1.setExpenseReportpaypeDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        test4payInitializedArgumentsArg1.setExpenseReportpaypsComments("");
    }

    private static void setUpMockData4test4payTxnDefault() {
        test4payTxnDefaultArg1 = new PayRequest();
        test4payTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4payTxnInitializedArguments() {
        test4payTxnInitializedArgumentsArg1 = new PayRequest();
        test4payTxnInitializedArgumentsArg1.setExpenseReportpaypthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4payTxnInitializedArgumentsArg1.setExpenseReportpaypthisExpenseReportInstance(new ExpenseReport(test4payTxnInitializedArgumentsArg1.getExpenseReportpaypthisExpenseReport()));
        test4payTxnInitializedArgumentsArg1.setExpenseReportpaypeDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        test4payTxnInitializedArgumentsArg1.setExpenseReportpaypsComments("");
        test4payTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4payImplementationDefault() {
        test4payImplementationDefaultArg1 = new PayRequest();
        test4payImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4payImplementationInitializedArguments() {
        test4payImplementationInitializedArgumentsArg1 = new PayRequest();
        test4payImplementationInitializedArgumentsArg1.setExpenseReportpaypthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4payImplementationInitializedArgumentsArg1.setExpenseReportpaypthisExpenseReportInstance(new ExpenseReport(test4payImplementationInitializedArgumentsArg1.getExpenseReportpaypthisExpenseReport()));
        test4payImplementationInitializedArgumentsArg1.setExpenseReportpaypeDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        test4payImplementationInitializedArgumentsArg1.setExpenseReportpaypsComments("");
        test4payImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4rejectauthoDefault() {
        test4rejectauthoDefaultArg1 = new RejectauthoRequest();
    }

    private static void setUpMockData4test4rejectauthoInitializedArguments() {
        test4rejectauthoInitializedArgumentsArg1 = new RejectauthoRequest();
        test4rejectauthoInitializedArgumentsArg1.setExpenseReportrejectauthopthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4rejectauthoInitializedArgumentsArg1.setExpenseReportrejectauthopthisExpenseReportInstance(new ExpenseReport(test4rejectauthoInitializedArgumentsArg1.getExpenseReportrejectauthopthisExpenseReport()));
        test4rejectauthoInitializedArgumentsArg1.setExpenseReportrejectauthopeComments("");
    }

    private static void setUpMockData4test4rejectauthoTxnDefault() {
        test4rejectauthoTxnDefaultArg1 = new RejectauthoRequest();
        test4rejectauthoTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4rejectauthoTxnInitializedArguments() {
        test4rejectauthoTxnInitializedArgumentsArg1 = new RejectauthoRequest();
        test4rejectauthoTxnInitializedArgumentsArg1.setExpenseReportrejectauthopthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4rejectauthoTxnInitializedArgumentsArg1.setExpenseReportrejectauthopthisExpenseReportInstance(new ExpenseReport(test4rejectauthoTxnInitializedArgumentsArg1.getExpenseReportrejectauthopthisExpenseReport()));
        test4rejectauthoTxnInitializedArgumentsArg1.setExpenseReportrejectauthopeComments("");
        test4rejectauthoTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4rejectauthoImplementationDefault() {
        test4rejectauthoImplementationDefaultArg1 = new RejectauthoRequest();
        test4rejectauthoImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4rejectauthoImplementationInitializedArguments() {
        test4rejectauthoImplementationInitializedArgumentsArg1 = new RejectauthoRequest();
        test4rejectauthoImplementationInitializedArgumentsArg1.setExpenseReportrejectauthopthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4rejectauthoImplementationInitializedArgumentsArg1.setExpenseReportrejectauthopthisExpenseReportInstance(new ExpenseReport(test4rejectauthoImplementationInitializedArgumentsArg1.getExpenseReportrejectauthopthisExpenseReport()));
        test4rejectauthoImplementationInitializedArgumentsArg1.setExpenseReportrejectauthopeComments("");
        test4rejectauthoImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4rejectauthoCheckPreconditions() {
        rejectauthoCheckPreconditionsArg1 = new RejectauthoRequest();
        rejectauthoCheckPreconditionsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4rejectpaymentDefault() {
        test4rejectpaymentDefaultArg1 = new RejectpaymentRequest();
    }

    private static void setUpMockData4test4rejectpaymentInitializedArguments() {
        test4rejectpaymentInitializedArgumentsArg1 = new RejectpaymentRequest();
        test4rejectpaymentInitializedArgumentsArg1.setExpenseReportrejectpaymentpthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4rejectpaymentInitializedArgumentsArg1.setExpenseReportrejectpaymentpthisExpenseReportInstance(new ExpenseReport(test4rejectpaymentInitializedArgumentsArg1.getExpenseReportrejectpaymentpthisExpenseReport()));
        test4rejectpaymentInitializedArgumentsArg1.setExpenseReportrejectpaymentpeComments("");
    }

    private static void setUpMockData4test4rejectpaymentTxnDefault() {
        test4rejectpaymentTxnDefaultArg1 = new RejectpaymentRequest();
        test4rejectpaymentTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4rejectpaymentTxnInitializedArguments() {
        test4rejectpaymentTxnInitializedArgumentsArg1 = new RejectpaymentRequest();
        test4rejectpaymentTxnInitializedArgumentsArg1.setExpenseReportrejectpaymentpthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4rejectpaymentTxnInitializedArgumentsArg1.setExpenseReportrejectpaymentpthisExpenseReportInstance(new ExpenseReport(test4rejectpaymentTxnInitializedArgumentsArg1.getExpenseReportrejectpaymentpthisExpenseReport()));
        test4rejectpaymentTxnInitializedArgumentsArg1.setExpenseReportrejectpaymentpeComments("");
        test4rejectpaymentTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4rejectpaymentImplementationDefault() {
        test4rejectpaymentImplementationDefaultArg1 = new RejectpaymentRequest();
        test4rejectpaymentImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4rejectpaymentImplementationInitializedArguments() {
        test4rejectpaymentImplementationInitializedArgumentsArg1 = new RejectpaymentRequest();
        test4rejectpaymentImplementationInitializedArgumentsArg1.setExpenseReportrejectpaymentpthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4rejectpaymentImplementationInitializedArgumentsArg1.setExpenseReportrejectpaymentpthisExpenseReportInstance(new ExpenseReport(test4rejectpaymentImplementationInitializedArgumentsArg1.getExpenseReportrejectpaymentpthisExpenseReport()));
        test4rejectpaymentImplementationInitializedArgumentsArg1.setExpenseReportrejectpaymentpeComments("");
        test4rejectpaymentImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4insPaymentTypeDefault() {
        test4insPaymentTypeDefaultArg1 = new InsPaymentTypeRequest();
    }

    private static void setUpMockData4test4insPaymentTypeInitializedArguments() {
        test4insPaymentTypeInitializedArgumentsArg1 = new InsPaymentTypeRequest();
        test4insPaymentTypeInitializedArgumentsArg1.setExpenseReportInsPaymentTypepthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4insPaymentTypeInitializedArgumentsArg1.setExpenseReportInsPaymentTypepthisExpenseReportInstance(new ExpenseReport(test4insPaymentTypeInitializedArgumentsArg1.getExpenseReportInsPaymentTypepthisExpenseReport()));
        test4insPaymentTypeInitializedArgumentsArg1.setExpenseReportInsPaymentTypepevcPaymentType(new PaymentTypeOid(""));
        test4insPaymentTypeInitializedArgumentsArg1.setExpenseReportInsPaymentTypepevcPaymentTypeInstance(new PaymentType(test4insPaymentTypeInitializedArgumentsArg1.getExpenseReportInsPaymentTypepevcPaymentType()));
    }

    private static void setUpMockData4test4insPaymentTypeTxnDefault() {
        test4insPaymentTypeTxnDefaultArg1 = new InsPaymentTypeRequest();
        test4insPaymentTypeTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4insPaymentTypeTxnInitializedArguments() {
        test4insPaymentTypeTxnInitializedArgumentsArg1 = new InsPaymentTypeRequest();
        test4insPaymentTypeTxnInitializedArgumentsArg1.setExpenseReportInsPaymentTypepthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4insPaymentTypeTxnInitializedArgumentsArg1.setExpenseReportInsPaymentTypepthisExpenseReportInstance(new ExpenseReport(test4insPaymentTypeTxnInitializedArgumentsArg1.getExpenseReportInsPaymentTypepthisExpenseReport()));
        test4insPaymentTypeTxnInitializedArgumentsArg1.setExpenseReportInsPaymentTypepevcPaymentType(new PaymentTypeOid(""));
        test4insPaymentTypeTxnInitializedArgumentsArg1.setExpenseReportInsPaymentTypepevcPaymentTypeInstance(new PaymentType(test4insPaymentTypeTxnInitializedArgumentsArg1.getExpenseReportInsPaymentTypepevcPaymentType()));
        test4insPaymentTypeTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4insPaymentTypeImplementationDefault() {
        test4insPaymentTypeImplementationDefaultArg1 = new InsPaymentTypeRequest();
        test4insPaymentTypeImplementationDefaultArg2 = true;
        test4insPaymentTypeImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4insPaymentTypeImplementationInitializedArguments() {
        test4insPaymentTypeImplementationInitializedArgumentsArg1 = new InsPaymentTypeRequest();
        test4insPaymentTypeImplementationInitializedArgumentsArg1.setExpenseReportInsPaymentTypepthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4insPaymentTypeImplementationInitializedArgumentsArg1.setExpenseReportInsPaymentTypepthisExpenseReportInstance(new ExpenseReport(test4insPaymentTypeImplementationInitializedArgumentsArg1.getExpenseReportInsPaymentTypepthisExpenseReport()));
        test4insPaymentTypeImplementationInitializedArgumentsArg1.setExpenseReportInsPaymentTypepevcPaymentType(new PaymentTypeOid(""));
        test4insPaymentTypeImplementationInitializedArgumentsArg1.setExpenseReportInsPaymentTypepevcPaymentTypeInstance(new PaymentType(test4insPaymentTypeImplementationInitializedArgumentsArg1.getExpenseReportInsPaymentTypepevcPaymentType()));
        test4insPaymentTypeImplementationInitializedArgumentsArg2 = true;
        test4insPaymentTypeImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4delPaymentTypeDefault() {
        test4delPaymentTypeDefaultArg1 = new DelPaymentTypeRequest();
    }

    private static void setUpMockData4test4delPaymentTypeInitializedArguments() {
        test4delPaymentTypeInitializedArgumentsArg1 = new DelPaymentTypeRequest();
        test4delPaymentTypeInitializedArgumentsArg1.setExpenseReportDelPaymentTypepthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4delPaymentTypeInitializedArgumentsArg1.setExpenseReportDelPaymentTypepthisExpenseReportInstance(new ExpenseReport(test4delPaymentTypeInitializedArgumentsArg1.getExpenseReportDelPaymentTypepthisExpenseReport()));
        test4delPaymentTypeInitializedArgumentsArg1.setExpenseReportDelPaymentTypepevcPaymentType(new PaymentTypeOid(""));
        test4delPaymentTypeInitializedArgumentsArg1.setExpenseReportDelPaymentTypepevcPaymentTypeInstance(new PaymentType(test4delPaymentTypeInitializedArgumentsArg1.getExpenseReportDelPaymentTypepevcPaymentType()));
    }

    private static void setUpMockData4test4delPaymentTypeTxnDefault() {
        test4delPaymentTypeTxnDefaultArg1 = new DelPaymentTypeRequest();
        test4delPaymentTypeTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4delPaymentTypeTxnInitializedArguments() {
        test4delPaymentTypeTxnInitializedArgumentsArg1 = new DelPaymentTypeRequest();
        test4delPaymentTypeTxnInitializedArgumentsArg1.setExpenseReportDelPaymentTypepthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4delPaymentTypeTxnInitializedArgumentsArg1.setExpenseReportDelPaymentTypepthisExpenseReportInstance(new ExpenseReport(test4delPaymentTypeTxnInitializedArgumentsArg1.getExpenseReportDelPaymentTypepthisExpenseReport()));
        test4delPaymentTypeTxnInitializedArgumentsArg1.setExpenseReportDelPaymentTypepevcPaymentType(new PaymentTypeOid(""));
        test4delPaymentTypeTxnInitializedArgumentsArg1.setExpenseReportDelPaymentTypepevcPaymentTypeInstance(new PaymentType(test4delPaymentTypeTxnInitializedArgumentsArg1.getExpenseReportDelPaymentTypepevcPaymentType()));
        test4delPaymentTypeTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4delPaymentTypeImplementationDefault() {
        test4delPaymentTypeImplementationDefaultArg1 = new DelPaymentTypeRequest();
        test4delPaymentTypeImplementationDefaultArg2 = true;
        test4delPaymentTypeImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4delPaymentTypeImplementationInitializedArguments() {
        test4delPaymentTypeImplementationInitializedArgumentsArg1 = new DelPaymentTypeRequest();
        test4delPaymentTypeImplementationInitializedArgumentsArg1.setExpenseReportDelPaymentTypepthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4delPaymentTypeImplementationInitializedArgumentsArg1.setExpenseReportDelPaymentTypepthisExpenseReportInstance(new ExpenseReport(test4delPaymentTypeImplementationInitializedArgumentsArg1.getExpenseReportDelPaymentTypepthisExpenseReport()));
        test4delPaymentTypeImplementationInitializedArgumentsArg1.setExpenseReportDelPaymentTypepevcPaymentType(new PaymentTypeOid(""));
        test4delPaymentTypeImplementationInitializedArgumentsArg1.setExpenseReportDelPaymentTypepevcPaymentTypeInstance(new PaymentType(test4delPaymentTypeImplementationInitializedArgumentsArg1.getExpenseReportDelPaymentTypepevcPaymentType()));
        test4delPaymentTypeImplementationInitializedArgumentsArg2 = true;
        test4delPaymentTypeImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4cancelapproveDefault() {
        test4cancelapproveDefaultArg1 = new CancelapproveRequest();
    }

    private static void setUpMockData4test4cancelapproveInitializedArguments() {
        test4cancelapproveInitializedArgumentsArg1 = new CancelapproveRequest();
        test4cancelapproveInitializedArgumentsArg1.setExpenseReportcancelapprovepthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4cancelapproveInitializedArgumentsArg1.setExpenseReportcancelapprovepthisExpenseReportInstance(new ExpenseReport(test4cancelapproveInitializedArgumentsArg1.getExpenseReportcancelapprovepthisExpenseReport()));
    }

    private static void setUpMockData4test4cancelapproveTxnDefault() {
        test4cancelapproveTxnDefaultArg1 = new CancelapproveRequest();
        test4cancelapproveTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4cancelapproveTxnInitializedArguments() {
        test4cancelapproveTxnInitializedArgumentsArg1 = new CancelapproveRequest();
        test4cancelapproveTxnInitializedArgumentsArg1.setExpenseReportcancelapprovepthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4cancelapproveTxnInitializedArgumentsArg1.setExpenseReportcancelapprovepthisExpenseReportInstance(new ExpenseReport(test4cancelapproveTxnInitializedArgumentsArg1.getExpenseReportcancelapprovepthisExpenseReport()));
        test4cancelapproveTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4cancelapproveImplementationDefault() {
        test4cancelapproveImplementationDefaultArg1 = new CancelapproveRequest();
        test4cancelapproveImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4cancelapproveImplementationInitializedArguments() {
        test4cancelapproveImplementationInitializedArgumentsArg1 = new CancelapproveRequest();
        test4cancelapproveImplementationInitializedArgumentsArg1.setExpenseReportcancelapprovepthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4cancelapproveImplementationInitializedArgumentsArg1.setExpenseReportcancelapprovepthisExpenseReportInstance(new ExpenseReport(test4cancelapproveImplementationInitializedArgumentsArg1.getExpenseReportcancelapprovepthisExpenseReport()));
        test4cancelapproveImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4approveDefault() {
        test4approveDefaultArg1 = new ApproveRequest();
    }

    private static void setUpMockData4test4approveInitializedArguments() {
        test4approveInitializedArgumentsArg1 = new ApproveRequest();
        test4approveInitializedArgumentsArg1.setExpenseReportapprovepthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4approveInitializedArgumentsArg1.setExpenseReportapprovepthisExpenseReportInstance(new ExpenseReport(test4approveInitializedArgumentsArg1.getExpenseReportapprovepthisExpenseReport()));
    }

    private static void setUpMockData4test4approveTxnDefault() {
        test4approveTxnDefaultArg1 = new ApproveRequest();
        test4approveTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4approveTxnInitializedArguments() {
        test4approveTxnInitializedArgumentsArg1 = new ApproveRequest();
        test4approveTxnInitializedArgumentsArg1.setExpenseReportapprovepthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4approveTxnInitializedArgumentsArg1.setExpenseReportapprovepthisExpenseReportInstance(new ExpenseReport(test4approveTxnInitializedArgumentsArg1.getExpenseReportapprovepthisExpenseReport()));
        test4approveTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4approveImplementationDefault() {
        test4approveImplementationDefaultArg1 = new ApproveRequest();
        test4approveImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4approveImplementationInitializedArguments() {
        test4approveImplementationInitializedArgumentsArg1 = new ApproveRequest();
        test4approveImplementationInitializedArgumentsArg1.setExpenseReportapprovepthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4approveImplementationInitializedArgumentsArg1.setExpenseReportapprovepthisExpenseReportInstance(new ExpenseReport(test4approveImplementationInitializedArgumentsArg1.getExpenseReportapprovepthisExpenseReport()));
        test4approveImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceDefault() {
        test4editinstanceDefaultArg1 = new EditinstanceRequest();
    }

    private static void setUpMockData4test4editinstanceInitializedArguments() {
        test4editinstanceInitializedArgumentsArg1 = new EditinstanceRequest();
        test4editinstanceInitializedArgumentsArg1.setExpenseReporteditinstancepthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4editinstanceInitializedArgumentsArg1.setExpenseReporteditinstancepthisExpenseReportInstance(new ExpenseReport(test4editinstanceInitializedArgumentsArg1.getExpenseReporteditinstancepthisExpenseReport()));
        test4editinstanceInitializedArgumentsArg1.setExpenseReporteditinstancepCause("");
        test4editinstanceInitializedArgumentsArg1.setExpenseReporteditinstancepAdvances(Double.valueOf(0));
        test4editinstanceInitializedArgumentsArg1.setExpenseReporteditinstancepExchange(Double.valueOf(0));
    }

    private static void setUpMockData4test4editinstanceTxnDefault() {
        test4editinstanceTxnDefaultArg1 = new EditinstanceRequest();
        test4editinstanceTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceTxnInitializedArguments() {
        test4editinstanceTxnInitializedArgumentsArg1 = new EditinstanceRequest();
        test4editinstanceTxnInitializedArgumentsArg1.setExpenseReporteditinstancepthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4editinstanceTxnInitializedArgumentsArg1.setExpenseReporteditinstancepthisExpenseReportInstance(new ExpenseReport(test4editinstanceTxnInitializedArgumentsArg1.getExpenseReporteditinstancepthisExpenseReport()));
        test4editinstanceTxnInitializedArgumentsArg1.setExpenseReporteditinstancepCause("");
        test4editinstanceTxnInitializedArgumentsArg1.setExpenseReporteditinstancepAdvances(Double.valueOf(0));
        test4editinstanceTxnInitializedArgumentsArg1.setExpenseReporteditinstancepExchange(Double.valueOf(0));
        test4editinstanceTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceImplementationDefault() {
        test4editinstanceImplementationDefaultArg1 = new EditinstanceRequest();
        test4editinstanceImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceImplementationInitializedArguments() {
        test4editinstanceImplementationInitializedArgumentsArg1 = new EditinstanceRequest();
        test4editinstanceImplementationInitializedArgumentsArg1.setExpenseReporteditinstancepthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4editinstanceImplementationInitializedArgumentsArg1.setExpenseReporteditinstancepthisExpenseReportInstance(new ExpenseReport(test4editinstanceImplementationInitializedArgumentsArg1.getExpenseReporteditinstancepthisExpenseReport()));
        test4editinstanceImplementationInitializedArgumentsArg1.setExpenseReporteditinstancepCause("");
        test4editinstanceImplementationInitializedArgumentsArg1.setExpenseReporteditinstancepAdvances(Double.valueOf(0));
        test4editinstanceImplementationInitializedArgumentsArg1.setExpenseReporteditinstancepExchange(Double.valueOf(0));
        test4editinstanceImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4dummyDefault() {
        test4dummyDefaultArg1 = new DummyRequest();
    }

    private static void setUpMockData4test4dummyInitializedArguments() {
        test4dummyInitializedArgumentsArg1 = new DummyRequest();
        test4dummyInitializedArgumentsArg1.setExpenseReportdummypthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4dummyInitializedArgumentsArg1.setExpenseReportdummypthisExpenseReportInstance(new ExpenseReport(test4dummyInitializedArgumentsArg1.getExpenseReportdummypthisExpenseReport()));
    }

    private static void setUpMockData4test4dummyTxnDefault() {
        test4dummyTxnDefaultArg1 = new DummyRequest();
        test4dummyTxnDefaultResult = new DummyResponse();
    }

    private static void setUpMockData4test4dummyTxnInitializedArguments() {
        test4dummyTxnInitializedArgumentsArg1 = new DummyRequest();
        test4dummyTxnInitializedArgumentsArg1.setExpenseReportdummypthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4dummyTxnInitializedArgumentsArg1.setExpenseReportdummypthisExpenseReportInstance(new ExpenseReport(test4dummyTxnInitializedArgumentsArg1.getExpenseReportdummypthisExpenseReport()));
        test4dummyTxnInitializedArgumentsResult = new DummyResponse();
    }

    private static void setUpMockData4test4dummyImplementationDefault() {
        test4dummyImplementationDefaultArg1 = new DummyRequest();
        test4dummyImplementationDefaultResult = new DummyResponse();
    }

    private static void setUpMockData4test4dummyImplementationInitializedArguments() {
        test4dummyImplementationInitializedArgumentsArg1 = new DummyRequest();
        test4dummyImplementationInitializedArgumentsArg1.setExpenseReportdummypthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4dummyImplementationInitializedArgumentsArg1.setExpenseReportdummypthisExpenseReportInstance(new ExpenseReport(test4dummyImplementationInitializedArgumentsArg1.getExpenseReportdummypthisExpenseReport()));
        test4dummyImplementationInitializedArgumentsResult = new DummyResponse();
    }

    private static void setUpMockData4test4dELETEALLDefault() {
        test4dELETEALLDefaultArg1 = new DELETEALLRequest();
    }

    private static void setUpMockData4test4dELETEALLInitializedArguments() {
        test4dELETEALLInitializedArgumentsArg1 = new DELETEALLRequest();
        test4dELETEALLInitializedArgumentsArg1.setExpenseReportDELETEALLptpthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4dELETEALLInitializedArgumentsArg1.setExpenseReportDELETEALLptpthisExpenseReportInstance(new ExpenseReport(test4dELETEALLInitializedArgumentsArg1.getExpenseReportDELETEALLptpthisExpenseReport()));
    }

    private static void setUpMockData4test4dELETEALLTxnDefault() {
        test4dELETEALLTxnDefaultArg1 = new DELETEALLRequest();
        test4dELETEALLTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4dELETEALLTxnInitializedArguments() {
        test4dELETEALLTxnInitializedArgumentsArg1 = new DELETEALLRequest();
        test4dELETEALLTxnInitializedArgumentsArg1.setExpenseReportDELETEALLptpthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4dELETEALLTxnInitializedArgumentsArg1.setExpenseReportDELETEALLptpthisExpenseReportInstance(new ExpenseReport(test4dELETEALLTxnInitializedArgumentsArg1.getExpenseReportDELETEALLptpthisExpenseReport()));
        test4dELETEALLTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4dELETEALLImplementationDefault() {
        test4dELETEALLImplementationDefaultArg1 = new DELETEALLRequest();
        test4dELETEALLImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4dELETEALLImplementationInitializedArguments() {
        test4dELETEALLImplementationInitializedArgumentsArg1 = new DELETEALLRequest();
        test4dELETEALLImplementationInitializedArgumentsArg1.setExpenseReportDELETEALLptpthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4dELETEALLImplementationInitializedArgumentsArg1.setExpenseReportDELETEALLptpthisExpenseReportInstance(new ExpenseReport(test4dELETEALLImplementationInitializedArgumentsArg1.getExpenseReportDELETEALLptpthisExpenseReport()));
        test4dELETEALLImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4tPAYDefault() {
        test4tPAYDefaultArg1 = new TPAYRequest();
    }

    private static void setUpMockData4test4tPAYInitializedArguments() {
        test4tPAYInitializedArgumentsArg1 = new TPAYRequest();
        test4tPAYInitializedArgumentsArg1.setExpenseReportTPAYptpeDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        test4tPAYInitializedArgumentsArg1.setExpenseReportTPAYpsPayType(new PaymentTypeOid(""));
        test4tPAYInitializedArgumentsArg1.setExpenseReportTPAYpsPayTypeInstance(new PaymentType(test4tPAYInitializedArgumentsArg1.getExpenseReportTPAYpsPayType()));
        test4tPAYInitializedArgumentsArg1.setExpenseReportTPAYptpthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4tPAYInitializedArgumentsArg1.setExpenseReportTPAYptpthisExpenseReportInstance(new ExpenseReport(test4tPAYInitializedArgumentsArg1.getExpenseReportTPAYptpthisExpenseReport()));
        test4tPAYInitializedArgumentsArg1.setExpenseReportTPAYpsComments("");
    }

    private static void setUpMockData4test4tPAYTxnDefault() {
        test4tPAYTxnDefaultArg1 = new TPAYRequest();
        test4tPAYTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4tPAYTxnInitializedArguments() {
        test4tPAYTxnInitializedArgumentsArg1 = new TPAYRequest();
        test4tPAYTxnInitializedArgumentsArg1.setExpenseReportTPAYptpeDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        test4tPAYTxnInitializedArgumentsArg1.setExpenseReportTPAYpsPayType(new PaymentTypeOid(""));
        test4tPAYTxnInitializedArgumentsArg1.setExpenseReportTPAYpsPayTypeInstance(new PaymentType(test4tPAYTxnInitializedArgumentsArg1.getExpenseReportTPAYpsPayType()));
        test4tPAYTxnInitializedArgumentsArg1.setExpenseReportTPAYptpthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4tPAYTxnInitializedArgumentsArg1.setExpenseReportTPAYptpthisExpenseReportInstance(new ExpenseReport(test4tPAYTxnInitializedArgumentsArg1.getExpenseReportTPAYptpthisExpenseReport()));
        test4tPAYTxnInitializedArgumentsArg1.setExpenseReportTPAYpsComments("");
        test4tPAYTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4tPAYImplementationDefault() {
        test4tPAYImplementationDefaultArg1 = new TPAYRequest();
        test4tPAYImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4tPAYImplementationInitializedArguments() {
        test4tPAYImplementationInitializedArgumentsArg1 = new TPAYRequest();
        test4tPAYImplementationInitializedArgumentsArg1.setExpenseReportTPAYptpeDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        test4tPAYImplementationInitializedArgumentsArg1.setExpenseReportTPAYpsPayType(new PaymentTypeOid(""));
        test4tPAYImplementationInitializedArgumentsArg1.setExpenseReportTPAYpsPayTypeInstance(new PaymentType(test4tPAYImplementationInitializedArgumentsArg1.getExpenseReportTPAYpsPayType()));
        test4tPAYImplementationInitializedArgumentsArg1.setExpenseReportTPAYptpthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4tPAYImplementationInitializedArgumentsArg1.setExpenseReportTPAYptpthisExpenseReportInstance(new ExpenseReport(test4tPAYImplementationInitializedArgumentsArg1.getExpenseReportTPAYptpthisExpenseReport()));
        test4tPAYImplementationInitializedArgumentsArg1.setExpenseReportTPAYpsComments("");
        test4tPAYImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4tNEWDefault() {
        test4tNEWDefaultArg1 = new TNEWRequest();
    }

    private static void setUpMockData4test4tNEWInitializedArguments() {
        test4tNEWInitializedArgumentsArg1 = new TNEWRequest();
        test4tNEWInitializedArgumentsArg1.setExpenseReportTNEWptpagrEmployee(new EmployeeOid(""));
        test4tNEWInitializedArgumentsArg1.setExpenseReportTNEWptpagrEmployeeInstance(new Employee(test4tNEWInitializedArgumentsArg1.getExpenseReportTNEWptpagrEmployee()));
        test4tNEWInitializedArgumentsArg1.setExpenseReportTNEWptpagrExpenseCurrency(new ExpenseCurrencyOid("").toJson());
        test4tNEWInitializedArgumentsArg1.setExpenseReportTNEWptpagrExpenseCurrencyInstance(new ExpenseCurrency(new ExpenseCurrencyOid().fromJsonString(test4tNEWInitializedArgumentsArg1.getExpenseReportTNEWptpagrExpenseCurrency())));
        test4tNEWInitializedArgumentsArg1.setExpenseReportTNEWptpagrProject(new ProjectOid(Long.valueOf(0)));
        test4tNEWInitializedArgumentsArg1.setExpenseReportTNEWptpagrProjectInstance(new Project(test4tNEWInitializedArgumentsArg1.getExpenseReportTNEWptpagrProject()));
        test4tNEWInitializedArgumentsArg1.setExpenseReportTNEWptpatrPresentDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        test4tNEWInitializedArgumentsArg1.setExpenseReportTNEWptpatrCause("");
        test4tNEWInitializedArgumentsArg1.setExpenseReportTNEWptpatrAdvances(Double.valueOf(0));
    }

    private static void setUpMockData4test4tNEWTxnDefault() {
        test4tNEWTxnDefaultArg1 = new TNEWRequest();
        test4tNEWTxnDefaultResult = new TNEWResponse();
    }

    private static void setUpMockData4test4tNEWTxnInitializedArguments() {
        test4tNEWTxnInitializedArgumentsArg1 = new TNEWRequest();
        test4tNEWTxnInitializedArgumentsArg1.setExpenseReportTNEWptpagrEmployee(new EmployeeOid(""));
        test4tNEWTxnInitializedArgumentsArg1.setExpenseReportTNEWptpagrEmployeeInstance(new Employee(test4tNEWTxnInitializedArgumentsArg1.getExpenseReportTNEWptpagrEmployee()));
        test4tNEWTxnInitializedArgumentsArg1.setExpenseReportTNEWptpagrExpenseCurrency(new ExpenseCurrencyOid("").toJson());
        test4tNEWTxnInitializedArgumentsArg1.setExpenseReportTNEWptpagrExpenseCurrencyInstance(new ExpenseCurrency(new ExpenseCurrencyOid().fromJsonString(test4tNEWTxnInitializedArgumentsArg1.getExpenseReportTNEWptpagrExpenseCurrency())));
        test4tNEWTxnInitializedArgumentsArg1.setExpenseReportTNEWptpagrProject(new ProjectOid(Long.valueOf(0)));
        test4tNEWTxnInitializedArgumentsArg1.setExpenseReportTNEWptpagrProjectInstance(new Project(test4tNEWTxnInitializedArgumentsArg1.getExpenseReportTNEWptpagrProject()));
        test4tNEWTxnInitializedArgumentsArg1.setExpenseReportTNEWptpatrPresentDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        test4tNEWTxnInitializedArgumentsArg1.setExpenseReportTNEWptpatrCause("");
        test4tNEWTxnInitializedArgumentsArg1.setExpenseReportTNEWptpatrAdvances(Double.valueOf(0));
        test4tNEWTxnInitializedArgumentsResult = new TNEWResponse();
    }

    private static void setUpMockData4test4tNEWImplementationDefault() {
        test4tNEWImplementationDefaultArg1 = new TNEWRequest();
        test4tNEWImplementationDefaultResult = new TNEWResponse();
    }

    private static void setUpMockData4test4tNEWImplementationInitializedArguments() {
        test4tNEWImplementationInitializedArgumentsArg1 = new TNEWRequest();
        test4tNEWImplementationInitializedArgumentsArg1.setExpenseReportTNEWptpagrEmployee(new EmployeeOid(""));
        test4tNEWImplementationInitializedArgumentsArg1.setExpenseReportTNEWptpagrEmployeeInstance(new Employee(test4tNEWImplementationInitializedArgumentsArg1.getExpenseReportTNEWptpagrEmployee()));
        test4tNEWImplementationInitializedArgumentsArg1.setExpenseReportTNEWptpagrExpenseCurrency(new ExpenseCurrencyOid("").toJson());
        test4tNEWImplementationInitializedArgumentsArg1.setExpenseReportTNEWptpagrExpenseCurrencyInstance(new ExpenseCurrency(new ExpenseCurrencyOid().fromJsonString(test4tNEWImplementationInitializedArgumentsArg1.getExpenseReportTNEWptpagrExpenseCurrency())));
        test4tNEWImplementationInitializedArgumentsArg1.setExpenseReportTNEWptpagrProject(new ProjectOid(Long.valueOf(0)));
        test4tNEWImplementationInitializedArgumentsArg1.setExpenseReportTNEWptpagrProjectInstance(new Project(test4tNEWImplementationInitializedArgumentsArg1.getExpenseReportTNEWptpagrProject()));
        test4tNEWImplementationInitializedArgumentsArg1.setExpenseReportTNEWptpatrPresentDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        test4tNEWImplementationInitializedArgumentsArg1.setExpenseReportTNEWptpatrCause("");
        test4tNEWImplementationInitializedArgumentsArg1.setExpenseReportTNEWptpatrAdvances(Double.valueOf(0));
        test4tNEWImplementationInitializedArgumentsResult = new TNEWResponse();
    }

    private static void setUpMockData4test4tNEWCheckPreconditions() {
        tNEWCheckPreconditionsArg1 = new TNEWRequest();
        tNEWCheckPreconditionsResult = new TNEWResponse();
    }

    private static void setUpMockData4test4tREJECTPAYMENTDefault() {
        test4tREJECTPAYMENTDefaultArg1 = new TREJECTPAYMENTRequest();
    }

    private static void setUpMockData4test4tREJECTPAYMENTInitializedArguments() {
        test4tREJECTPAYMENTInitializedArgumentsArg1 = new TREJECTPAYMENTRequest();
        test4tREJECTPAYMENTInitializedArgumentsArg1.setExpenseReportTREJECTPAYMENTptthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4tREJECTPAYMENTInitializedArgumentsArg1.setExpenseReportTREJECTPAYMENTptthisExpenseReportInstance(new ExpenseReport(test4tREJECTPAYMENTInitializedArgumentsArg1.getExpenseReportTREJECTPAYMENTptthisExpenseReport()));
        test4tREJECTPAYMENTInitializedArgumentsArg1.setExpenseReportTREJECTPAYMENTptPaymentType(new PaymentTypeOid(""));
        test4tREJECTPAYMENTInitializedArgumentsArg1.setExpenseReportTREJECTPAYMENTptPaymentTypeInstance(new PaymentType(test4tREJECTPAYMENTInitializedArgumentsArg1.getExpenseReportTREJECTPAYMENTptPaymentType()));
        test4tREJECTPAYMENTInitializedArgumentsArg1.setExpenseReportTREJECTPAYMENTptComments("");
    }

    private static void setUpMockData4test4tREJECTPAYMENTTxnDefault() {
        test4tREJECTPAYMENTTxnDefaultArg1 = new TREJECTPAYMENTRequest();
        test4tREJECTPAYMENTTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4tREJECTPAYMENTTxnInitializedArguments() {
        test4tREJECTPAYMENTTxnInitializedArgumentsArg1 = new TREJECTPAYMENTRequest();
        test4tREJECTPAYMENTTxnInitializedArgumentsArg1.setExpenseReportTREJECTPAYMENTptthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4tREJECTPAYMENTTxnInitializedArgumentsArg1.setExpenseReportTREJECTPAYMENTptthisExpenseReportInstance(new ExpenseReport(test4tREJECTPAYMENTTxnInitializedArgumentsArg1.getExpenseReportTREJECTPAYMENTptthisExpenseReport()));
        test4tREJECTPAYMENTTxnInitializedArgumentsArg1.setExpenseReportTREJECTPAYMENTptPaymentType(new PaymentTypeOid(""));
        test4tREJECTPAYMENTTxnInitializedArgumentsArg1.setExpenseReportTREJECTPAYMENTptPaymentTypeInstance(new PaymentType(test4tREJECTPAYMENTTxnInitializedArgumentsArg1.getExpenseReportTREJECTPAYMENTptPaymentType()));
        test4tREJECTPAYMENTTxnInitializedArgumentsArg1.setExpenseReportTREJECTPAYMENTptComments("");
        test4tREJECTPAYMENTTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4tREJECTPAYMENTImplementationDefault() {
        test4tREJECTPAYMENTImplementationDefaultArg1 = new TREJECTPAYMENTRequest();
        test4tREJECTPAYMENTImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4tREJECTPAYMENTImplementationInitializedArguments() {
        test4tREJECTPAYMENTImplementationInitializedArgumentsArg1 = new TREJECTPAYMENTRequest();
        test4tREJECTPAYMENTImplementationInitializedArgumentsArg1.setExpenseReportTREJECTPAYMENTptthisExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        test4tREJECTPAYMENTImplementationInitializedArgumentsArg1.setExpenseReportTREJECTPAYMENTptthisExpenseReportInstance(new ExpenseReport(test4tREJECTPAYMENTImplementationInitializedArgumentsArg1.getExpenseReportTREJECTPAYMENTptthisExpenseReport()));
        test4tREJECTPAYMENTImplementationInitializedArgumentsArg1.setExpenseReportTREJECTPAYMENTptPaymentType(new PaymentTypeOid(""));
        test4tREJECTPAYMENTImplementationInitializedArgumentsArg1.setExpenseReportTREJECTPAYMENTptPaymentTypeInstance(new PaymentType(test4tREJECTPAYMENTImplementationInitializedArgumentsArg1.getExpenseReportTREJECTPAYMENTptPaymentType()));
        test4tREJECTPAYMENTImplementationInitializedArgumentsArg1.setExpenseReportTREJECTPAYMENTptComments("");
        test4tREJECTPAYMENTImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4tNEWFROMTEMPLATEDefault() {
        test4tNEWFROMTEMPLATEDefaultArg1 = new TNEWFROMTEMPLATERequest();
    }

    private static void setUpMockData4test4tNEWFROMTEMPLATEInitializedArguments() {
        test4tNEWFROMTEMPLATEInitializedArgumentsArg1 = new TNEWFROMTEMPLATERequest();
        test4tNEWFROMTEMPLATEInitializedArgumentsArg1.setExpenseReportTNEWFROMTEMPLATEptpagrEmployee(new EmployeeOid(""));
        test4tNEWFROMTEMPLATEInitializedArgumentsArg1.setExpenseReportTNEWFROMTEMPLATEptpagrEmployeeInstance(new Employee(test4tNEWFROMTEMPLATEInitializedArgumentsArg1.getExpenseReportTNEWFROMTEMPLATEptpagrEmployee()));
        test4tNEWFROMTEMPLATEInitializedArgumentsArg1.setExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency(new ExpenseCurrencyOid("").toJson());
        test4tNEWFROMTEMPLATEInitializedArgumentsArg1.setExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrencyInstance(new ExpenseCurrency(new ExpenseCurrencyOid().fromJsonString(test4tNEWFROMTEMPLATEInitializedArgumentsArg1.getExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency())));
        test4tNEWFROMTEMPLATEInitializedArgumentsArg1.setExpenseReportTNEWFROMTEMPLATEptpagrProject(new ProjectOid(Long.valueOf(0)));
        test4tNEWFROMTEMPLATEInitializedArgumentsArg1.setExpenseReportTNEWFROMTEMPLATEptpagrProjectInstance(new Project(test4tNEWFROMTEMPLATEInitializedArgumentsArg1.getExpenseReportTNEWFROMTEMPLATEptpagrProject()));
        test4tNEWFROMTEMPLATEInitializedArgumentsArg1.setExpenseReportTNEWFROMTEMPLATEptpatrPresentDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        test4tNEWFROMTEMPLATEInitializedArgumentsArg1.setExpenseReportTNEWFROMTEMPLATEptpatrCause("");
        test4tNEWFROMTEMPLATEInitializedArgumentsArg1.setExpenseReportTNEWFROMTEMPLATEptpatrAdvances(Double.valueOf(0));
        test4tNEWFROMTEMPLATEInitializedArgumentsArg1.setExpenseReportTNEWFROMTEMPLATEpTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4tNEWFROMTEMPLATEInitializedArgumentsArg1.setExpenseReportTNEWFROMTEMPLATEpTemplateInstance(new ERTemplate(test4tNEWFROMTEMPLATEInitializedArgumentsArg1.getExpenseReportTNEWFROMTEMPLATEpTemplate()));
    }

    private static void setUpMockData4test4tNEWFROMTEMPLATETxnDefault() {
        test4tNEWFROMTEMPLATETxnDefaultArg1 = new TNEWFROMTEMPLATERequest();
        test4tNEWFROMTEMPLATETxnDefaultResult = new TNEWFROMTEMPLATEResponse();
    }

    private static void setUpMockData4test4tNEWFROMTEMPLATETxnInitializedArguments() {
        test4tNEWFROMTEMPLATETxnInitializedArgumentsArg1 = new TNEWFROMTEMPLATERequest();
        test4tNEWFROMTEMPLATETxnInitializedArgumentsArg1.setExpenseReportTNEWFROMTEMPLATEptpagrEmployee(new EmployeeOid(""));
        test4tNEWFROMTEMPLATETxnInitializedArgumentsArg1.setExpenseReportTNEWFROMTEMPLATEptpagrEmployeeInstance(new Employee(test4tNEWFROMTEMPLATETxnInitializedArgumentsArg1.getExpenseReportTNEWFROMTEMPLATEptpagrEmployee()));
        test4tNEWFROMTEMPLATETxnInitializedArgumentsArg1.setExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency(new ExpenseCurrencyOid("").toJson());
        test4tNEWFROMTEMPLATETxnInitializedArgumentsArg1.setExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrencyInstance(new ExpenseCurrency(new ExpenseCurrencyOid().fromJsonString(test4tNEWFROMTEMPLATETxnInitializedArgumentsArg1.getExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency())));
        test4tNEWFROMTEMPLATETxnInitializedArgumentsArg1.setExpenseReportTNEWFROMTEMPLATEptpagrProject(new ProjectOid(Long.valueOf(0)));
        test4tNEWFROMTEMPLATETxnInitializedArgumentsArg1.setExpenseReportTNEWFROMTEMPLATEptpagrProjectInstance(new Project(test4tNEWFROMTEMPLATETxnInitializedArgumentsArg1.getExpenseReportTNEWFROMTEMPLATEptpagrProject()));
        test4tNEWFROMTEMPLATETxnInitializedArgumentsArg1.setExpenseReportTNEWFROMTEMPLATEptpatrPresentDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        test4tNEWFROMTEMPLATETxnInitializedArgumentsArg1.setExpenseReportTNEWFROMTEMPLATEptpatrCause("");
        test4tNEWFROMTEMPLATETxnInitializedArgumentsArg1.setExpenseReportTNEWFROMTEMPLATEptpatrAdvances(Double.valueOf(0));
        test4tNEWFROMTEMPLATETxnInitializedArgumentsArg1.setExpenseReportTNEWFROMTEMPLATEpTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4tNEWFROMTEMPLATETxnInitializedArgumentsArg1.setExpenseReportTNEWFROMTEMPLATEpTemplateInstance(new ERTemplate(test4tNEWFROMTEMPLATETxnInitializedArgumentsArg1.getExpenseReportTNEWFROMTEMPLATEpTemplate()));
        test4tNEWFROMTEMPLATETxnInitializedArgumentsResult = new TNEWFROMTEMPLATEResponse();
    }

    private static void setUpMockData4test4tNEWFROMTEMPLATEImplementationDefault() {
        test4tNEWFROMTEMPLATEImplementationDefaultArg1 = new TNEWFROMTEMPLATERequest();
        test4tNEWFROMTEMPLATEImplementationDefaultResult = new TNEWFROMTEMPLATEResponse();
    }

    private static void setUpMockData4test4tNEWFROMTEMPLATEImplementationInitializedArguments() {
        test4tNEWFROMTEMPLATEImplementationInitializedArgumentsArg1 = new TNEWFROMTEMPLATERequest();
        test4tNEWFROMTEMPLATEImplementationInitializedArgumentsArg1.setExpenseReportTNEWFROMTEMPLATEptpagrEmployee(new EmployeeOid(""));
        test4tNEWFROMTEMPLATEImplementationInitializedArgumentsArg1.setExpenseReportTNEWFROMTEMPLATEptpagrEmployeeInstance(new Employee(test4tNEWFROMTEMPLATEImplementationInitializedArgumentsArg1.getExpenseReportTNEWFROMTEMPLATEptpagrEmployee()));
        test4tNEWFROMTEMPLATEImplementationInitializedArgumentsArg1.setExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency(new ExpenseCurrencyOid("").toJson());
        test4tNEWFROMTEMPLATEImplementationInitializedArgumentsArg1.setExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrencyInstance(new ExpenseCurrency(new ExpenseCurrencyOid().fromJsonString(test4tNEWFROMTEMPLATEImplementationInitializedArgumentsArg1.getExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency())));
        test4tNEWFROMTEMPLATEImplementationInitializedArgumentsArg1.setExpenseReportTNEWFROMTEMPLATEptpagrProject(new ProjectOid(Long.valueOf(0)));
        test4tNEWFROMTEMPLATEImplementationInitializedArgumentsArg1.setExpenseReportTNEWFROMTEMPLATEptpagrProjectInstance(new Project(test4tNEWFROMTEMPLATEImplementationInitializedArgumentsArg1.getExpenseReportTNEWFROMTEMPLATEptpagrProject()));
        test4tNEWFROMTEMPLATEImplementationInitializedArgumentsArg1.setExpenseReportTNEWFROMTEMPLATEptpatrPresentDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        test4tNEWFROMTEMPLATEImplementationInitializedArgumentsArg1.setExpenseReportTNEWFROMTEMPLATEptpatrCause("");
        test4tNEWFROMTEMPLATEImplementationInitializedArgumentsArg1.setExpenseReportTNEWFROMTEMPLATEptpatrAdvances(Double.valueOf(0));
        test4tNEWFROMTEMPLATEImplementationInitializedArgumentsArg1.setExpenseReportTNEWFROMTEMPLATEpTemplate(new ERTemplateOid(Long.valueOf(0)));
        test4tNEWFROMTEMPLATEImplementationInitializedArgumentsArg1.setExpenseReportTNEWFROMTEMPLATEpTemplateInstance(new ERTemplate(test4tNEWFROMTEMPLATEImplementationInitializedArgumentsArg1.getExpenseReportTNEWFROMTEMPLATEpTemplate()));
        test4tNEWFROMTEMPLATEImplementationInitializedArgumentsResult = new TNEWFROMTEMPLATEResponse();
    }

    private static void setUpMockData4test4tNEWFROMTEMPLATECheckPreconditions() {
        tNEWFROMTEMPLATECheckPreconditionsArg1 = new TNEWFROMTEMPLATERequest();
        tNEWFROMTEMPLATECheckPreconditionsResult = new TNEWFROMTEMPLATEResponse();
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(instanceExpenseReportService, "expenseReportSrv", instanceExpenseReportService);

        when(mockExpenseCurrencyService.getByOIDWithHV(test4newexpenseInitializedArgumentsArg1.getExpenseReportnewexpensepagrExpenseCurrency())).thenReturn(test4newexpenseInitializedArgumentsArg1.getExpenseReportnewexpensepagrExpenseCurrencyInstance());

        when(mockPaymentTypeService.getByOIDWithHV(test4newexpenseInitializedArgumentsArg1.getExpenseReportnewexpensepagrPaymentType())).thenReturn(test4newexpenseInitializedArgumentsArg1.getExpenseReportnewexpensepagrPaymentTypeInstance());

        when(mockProjectService.getByOIDWithHV(test4newexpenseInitializedArgumentsArg1.getExpenseReportnewexpensepagrProject())).thenReturn(test4newexpenseInitializedArgumentsArg1.getExpenseReportnewexpensepagrProjectInstance());

        when(mockEmployeeService.getByOIDWithHV(test4newexpenseInitializedArgumentsArg1.getExpenseReportnewexpensepagrEmployee())).thenReturn(test4newexpenseInitializedArgumentsArg1.getExpenseReportnewexpensepagrEmployeeInstance());

        when(mockExpenseCurrencyService.getByOIDWithHV(test4newexpenseTxnInitializedArgumentsArg1.getExpenseReportnewexpensepagrExpenseCurrency())).thenReturn(test4newexpenseTxnInitializedArgumentsArg1.getExpenseReportnewexpensepagrExpenseCurrencyInstance());

        when(mockPaymentTypeService.getByOIDWithHV(test4newexpenseTxnInitializedArgumentsArg1.getExpenseReportnewexpensepagrPaymentType())).thenReturn(test4newexpenseTxnInitializedArgumentsArg1.getExpenseReportnewexpensepagrPaymentTypeInstance());

        when(mockProjectService.getByOIDWithHV(test4newexpenseTxnInitializedArgumentsArg1.getExpenseReportnewexpensepagrProject())).thenReturn(test4newexpenseTxnInitializedArgumentsArg1.getExpenseReportnewexpensepagrProjectInstance());

        when(mockEmployeeService.getByOIDWithHV(test4newexpenseTxnInitializedArgumentsArg1.getExpenseReportnewexpensepagrEmployee())).thenReturn(test4newexpenseTxnInitializedArgumentsArg1.getExpenseReportnewexpensepagrEmployeeInstance());

        when(mockExpenseReportService.getByOIDWithHV(test4delexpenseInitializedArgumentsArg1.getExpenseReportdelexpensepthisExpenseReport())).thenReturn(test4delexpenseInitializedArgumentsArg1.getExpenseReportdelexpensepthisExpenseReportInstance());

        when(mockExpenseReportService.getByOIDWithHV(test4delexpenseTxnInitializedArgumentsArg1.getExpenseReportdelexpensepthisExpenseReport())).thenReturn(test4delexpenseTxnInitializedArgumentsArg1.getExpenseReportdelexpensepthisExpenseReportInstance());

        when(mockExpenseReportService.getByOIDWithHV(test4ecloseInitializedArgumentsArg1.getExpenseReporteclosepthisExpenseReport())).thenReturn(test4ecloseInitializedArgumentsArg1.getExpenseReporteclosepthisExpenseReportInstance());

        when(mockExpenseReportService.getByOIDWithHV(test4ecloseTxnInitializedArgumentsArg1.getExpenseReporteclosepthisExpenseReport())).thenReturn(test4ecloseTxnInitializedArgumentsArg1.getExpenseReporteclosepthisExpenseReportInstance());

        when(mockExpenseReportService.getByOIDWithHV(test4authorizeInitializedArgumentsArg1.getExpenseReportauthorizepthisExpenseReport())).thenReturn(test4authorizeInitializedArgumentsArg1.getExpenseReportauthorizepthisExpenseReportInstance());

        when(mockExpenseReportService.getByOIDWithHV(test4authorizeTxnInitializedArgumentsArg1.getExpenseReportauthorizepthisExpenseReport())).thenReturn(test4authorizeTxnInitializedArgumentsArg1.getExpenseReportauthorizepthisExpenseReportInstance());

        when(mockExpenseReportService.getByOIDWithHV(test4payInitializedArgumentsArg1.getExpenseReportpaypthisExpenseReport())).thenReturn(test4payInitializedArgumentsArg1.getExpenseReportpaypthisExpenseReportInstance());

        when(mockExpenseReportService.getByOIDWithHV(test4payTxnInitializedArgumentsArg1.getExpenseReportpaypthisExpenseReport())).thenReturn(test4payTxnInitializedArgumentsArg1.getExpenseReportpaypthisExpenseReportInstance());

        when(mockExpenseReportService.getByOIDWithHV(test4rejectauthoInitializedArgumentsArg1.getExpenseReportrejectauthopthisExpenseReport())).thenReturn(test4rejectauthoInitializedArgumentsArg1.getExpenseReportrejectauthopthisExpenseReportInstance());

        when(mockExpenseReportService.getByOIDWithHV(test4rejectauthoTxnInitializedArgumentsArg1.getExpenseReportrejectauthopthisExpenseReport())).thenReturn(test4rejectauthoTxnInitializedArgumentsArg1.getExpenseReportrejectauthopthisExpenseReportInstance());

        when(mockExpenseReportService.getByOIDWithHV(test4rejectpaymentInitializedArgumentsArg1.getExpenseReportrejectpaymentpthisExpenseReport())).thenReturn(test4rejectpaymentInitializedArgumentsArg1.getExpenseReportrejectpaymentpthisExpenseReportInstance());

        when(mockExpenseReportService.getByOIDWithHV(test4rejectpaymentTxnInitializedArgumentsArg1.getExpenseReportrejectpaymentpthisExpenseReport())).thenReturn(test4rejectpaymentTxnInitializedArgumentsArg1.getExpenseReportrejectpaymentpthisExpenseReportInstance());

        when(mockExpenseReportService.getByOIDWithHV(test4insPaymentTypeInitializedArgumentsArg1.getExpenseReportInsPaymentTypepthisExpenseReport())).thenReturn(test4insPaymentTypeInitializedArgumentsArg1.getExpenseReportInsPaymentTypepthisExpenseReportInstance());

        when(mockPaymentTypeService.getByOIDWithHV(test4insPaymentTypeInitializedArgumentsArg1.getExpenseReportInsPaymentTypepevcPaymentType())).thenReturn(test4insPaymentTypeInitializedArgumentsArg1.getExpenseReportInsPaymentTypepevcPaymentTypeInstance());

        when(mockExpenseReportService.getByOIDWithHV(test4insPaymentTypeTxnInitializedArgumentsArg1.getExpenseReportInsPaymentTypepthisExpenseReport())).thenReturn(test4insPaymentTypeTxnInitializedArgumentsArg1.getExpenseReportInsPaymentTypepthisExpenseReportInstance());

        when(mockPaymentTypeService.getByOIDWithHV(test4insPaymentTypeTxnInitializedArgumentsArg1.getExpenseReportInsPaymentTypepevcPaymentType())).thenReturn(test4insPaymentTypeTxnInitializedArgumentsArg1.getExpenseReportInsPaymentTypepevcPaymentTypeInstance());

        when(mockExpenseReportService.getByOIDWithHV(test4delPaymentTypeInitializedArgumentsArg1.getExpenseReportDelPaymentTypepthisExpenseReport())).thenReturn(test4delPaymentTypeInitializedArgumentsArg1.getExpenseReportDelPaymentTypepthisExpenseReportInstance());

        when(mockPaymentTypeService.getByOIDWithHV(test4delPaymentTypeInitializedArgumentsArg1.getExpenseReportDelPaymentTypepevcPaymentType())).thenReturn(test4delPaymentTypeInitializedArgumentsArg1.getExpenseReportDelPaymentTypepevcPaymentTypeInstance());

        when(mockExpenseReportService.getByOIDWithHV(test4delPaymentTypeTxnInitializedArgumentsArg1.getExpenseReportDelPaymentTypepthisExpenseReport())).thenReturn(test4delPaymentTypeTxnInitializedArgumentsArg1.getExpenseReportDelPaymentTypepthisExpenseReportInstance());

        when(mockPaymentTypeService.getByOIDWithHV(test4delPaymentTypeTxnInitializedArgumentsArg1.getExpenseReportDelPaymentTypepevcPaymentType())).thenReturn(test4delPaymentTypeTxnInitializedArgumentsArg1.getExpenseReportDelPaymentTypepevcPaymentTypeInstance());

        when(mockExpenseReportService.getByOIDWithHV(test4cancelapproveInitializedArgumentsArg1.getExpenseReportcancelapprovepthisExpenseReport())).thenReturn(test4cancelapproveInitializedArgumentsArg1.getExpenseReportcancelapprovepthisExpenseReportInstance());

        when(mockExpenseReportService.getByOIDWithHV(test4cancelapproveTxnInitializedArgumentsArg1.getExpenseReportcancelapprovepthisExpenseReport())).thenReturn(test4cancelapproveTxnInitializedArgumentsArg1.getExpenseReportcancelapprovepthisExpenseReportInstance());

        when(mockExpenseReportService.getByOIDWithHV(test4approveInitializedArgumentsArg1.getExpenseReportapprovepthisExpenseReport())).thenReturn(test4approveInitializedArgumentsArg1.getExpenseReportapprovepthisExpenseReportInstance());

        when(mockExpenseReportService.getByOIDWithHV(test4approveTxnInitializedArgumentsArg1.getExpenseReportapprovepthisExpenseReport())).thenReturn(test4approveTxnInitializedArgumentsArg1.getExpenseReportapprovepthisExpenseReportInstance());

        when(mockExpenseReportService.getByOIDWithHV(test4editinstanceInitializedArgumentsArg1.getExpenseReporteditinstancepthisExpenseReport())).thenReturn(test4editinstanceInitializedArgumentsArg1.getExpenseReporteditinstancepthisExpenseReportInstance());

        when(mockExpenseReportService.getByOIDWithHV(test4editinstanceTxnInitializedArgumentsArg1.getExpenseReporteditinstancepthisExpenseReport())).thenReturn(test4editinstanceTxnInitializedArgumentsArg1.getExpenseReporteditinstancepthisExpenseReportInstance());

        when(mockExpenseReportService.getByOIDWithHV(test4dummyInitializedArgumentsArg1.getExpenseReportdummypthisExpenseReport())).thenReturn(test4dummyInitializedArgumentsArg1.getExpenseReportdummypthisExpenseReportInstance());

        when(mockExpenseReportService.getByOIDWithHV(test4dummyTxnInitializedArgumentsArg1.getExpenseReportdummypthisExpenseReport())).thenReturn(test4dummyTxnInitializedArgumentsArg1.getExpenseReportdummypthisExpenseReportInstance());

        when(mockExpenseReportService.getByOIDWithHV(test4dELETEALLInitializedArgumentsArg1.getExpenseReportDELETEALLptpthisExpenseReport())).thenReturn(test4dELETEALLInitializedArgumentsArg1.getExpenseReportDELETEALLptpthisExpenseReportInstance());

        when(mockExpenseReportService.getByOIDWithHV(test4dELETEALLTxnInitializedArgumentsArg1.getExpenseReportDELETEALLptpthisExpenseReport())).thenReturn(test4dELETEALLTxnInitializedArgumentsArg1.getExpenseReportDELETEALLptpthisExpenseReportInstance());

        when(mockPaymentTypeService.getByOIDWithHV(test4tPAYInitializedArgumentsArg1.getExpenseReportTPAYpsPayType())).thenReturn(test4tPAYInitializedArgumentsArg1.getExpenseReportTPAYpsPayTypeInstance());

        when(mockExpenseReportService.getByOIDWithHV(test4tPAYInitializedArgumentsArg1.getExpenseReportTPAYptpthisExpenseReport())).thenReturn(test4tPAYInitializedArgumentsArg1.getExpenseReportTPAYptpthisExpenseReportInstance());

        when(mockPaymentTypeService.getByOIDWithHV(test4tPAYTxnInitializedArgumentsArg1.getExpenseReportTPAYpsPayType())).thenReturn(test4tPAYTxnInitializedArgumentsArg1.getExpenseReportTPAYpsPayTypeInstance());

        when(mockExpenseReportService.getByOIDWithHV(test4tPAYTxnInitializedArgumentsArg1.getExpenseReportTPAYptpthisExpenseReport())).thenReturn(test4tPAYTxnInitializedArgumentsArg1.getExpenseReportTPAYptpthisExpenseReportInstance());

        when(mockEmployeeService.getByOIDWithHV(test4tNEWInitializedArgumentsArg1.getExpenseReportTNEWptpagrEmployee())).thenReturn(test4tNEWInitializedArgumentsArg1.getExpenseReportTNEWptpagrEmployeeInstance());

        when(mockExpenseCurrencyService.getByOIDWithHV(new ExpenseCurrencyOid().fromJsonString(test4tNEWInitializedArgumentsArg1.getExpenseReportTNEWptpagrExpenseCurrency()))).thenReturn(test4tNEWInitializedArgumentsArg1.getExpenseReportTNEWptpagrExpenseCurrencyInstance());

        when(mockProjectService.getByOIDWithHV(test4tNEWInitializedArgumentsArg1.getExpenseReportTNEWptpagrProject())).thenReturn(test4tNEWInitializedArgumentsArg1.getExpenseReportTNEWptpagrProjectInstance());

        when(mockEmployeeService.getByOIDWithHV(test4tNEWTxnInitializedArgumentsArg1.getExpenseReportTNEWptpagrEmployee())).thenReturn(test4tNEWTxnInitializedArgumentsArg1.getExpenseReportTNEWptpagrEmployeeInstance());

        when(mockExpenseCurrencyService.getByOIDWithHV(new ExpenseCurrencyOid().fromJsonString(test4tNEWTxnInitializedArgumentsArg1.getExpenseReportTNEWptpagrExpenseCurrency()))).thenReturn(test4tNEWTxnInitializedArgumentsArg1.getExpenseReportTNEWptpagrExpenseCurrencyInstance());

        when(mockProjectService.getByOIDWithHV(test4tNEWTxnInitializedArgumentsArg1.getExpenseReportTNEWptpagrProject())).thenReturn(test4tNEWTxnInitializedArgumentsArg1.getExpenseReportTNEWptpagrProjectInstance());

        when(mockExpenseReportService.getByOIDWithHV(test4tREJECTPAYMENTInitializedArgumentsArg1.getExpenseReportTREJECTPAYMENTptthisExpenseReport())).thenReturn(test4tREJECTPAYMENTInitializedArgumentsArg1.getExpenseReportTREJECTPAYMENTptthisExpenseReportInstance());

        when(mockPaymentTypeService.getByOIDWithHV(test4tREJECTPAYMENTInitializedArgumentsArg1.getExpenseReportTREJECTPAYMENTptPaymentType())).thenReturn(test4tREJECTPAYMENTInitializedArgumentsArg1.getExpenseReportTREJECTPAYMENTptPaymentTypeInstance());

        when(mockExpenseReportService.getByOIDWithHV(test4tREJECTPAYMENTTxnInitializedArgumentsArg1.getExpenseReportTREJECTPAYMENTptthisExpenseReport())).thenReturn(test4tREJECTPAYMENTTxnInitializedArgumentsArg1.getExpenseReportTREJECTPAYMENTptthisExpenseReportInstance());

        when(mockPaymentTypeService.getByOIDWithHV(test4tREJECTPAYMENTTxnInitializedArgumentsArg1.getExpenseReportTREJECTPAYMENTptPaymentType())).thenReturn(test4tREJECTPAYMENTTxnInitializedArgumentsArg1.getExpenseReportTREJECTPAYMENTptPaymentTypeInstance());

        when(mockEmployeeService.getByOIDWithHV(test4tNEWFROMTEMPLATEInitializedArgumentsArg1.getExpenseReportTNEWFROMTEMPLATEptpagrEmployee())).thenReturn(test4tNEWFROMTEMPLATEInitializedArgumentsArg1.getExpenseReportTNEWFROMTEMPLATEptpagrEmployeeInstance());

        when(mockExpenseCurrencyService.getByOIDWithHV(new ExpenseCurrencyOid().fromJsonString(test4tNEWFROMTEMPLATEInitializedArgumentsArg1.getExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency()))).thenReturn(test4tNEWFROMTEMPLATEInitializedArgumentsArg1.getExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrencyInstance());

        when(mockProjectService.getByOIDWithHV(test4tNEWFROMTEMPLATEInitializedArgumentsArg1.getExpenseReportTNEWFROMTEMPLATEptpagrProject())).thenReturn(test4tNEWFROMTEMPLATEInitializedArgumentsArg1.getExpenseReportTNEWFROMTEMPLATEptpagrProjectInstance());

        when(mockERTemplateService.getByOIDWithHV(test4tNEWFROMTEMPLATEInitializedArgumentsArg1.getExpenseReportTNEWFROMTEMPLATEpTemplate())).thenReturn(test4tNEWFROMTEMPLATEInitializedArgumentsArg1.getExpenseReportTNEWFROMTEMPLATEpTemplateInstance());

        when(mockEmployeeService.getByOIDWithHV(test4tNEWFROMTEMPLATETxnInitializedArgumentsArg1.getExpenseReportTNEWFROMTEMPLATEptpagrEmployee())).thenReturn(test4tNEWFROMTEMPLATETxnInitializedArgumentsArg1.getExpenseReportTNEWFROMTEMPLATEptpagrEmployeeInstance());

        when(mockExpenseCurrencyService.getByOIDWithHV(new ExpenseCurrencyOid().fromJsonString(test4tNEWFROMTEMPLATETxnInitializedArgumentsArg1.getExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency()))).thenReturn(test4tNEWFROMTEMPLATETxnInitializedArgumentsArg1.getExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrencyInstance());

        when(mockProjectService.getByOIDWithHV(test4tNEWFROMTEMPLATETxnInitializedArgumentsArg1.getExpenseReportTNEWFROMTEMPLATEptpagrProject())).thenReturn(test4tNEWFROMTEMPLATETxnInitializedArgumentsArg1.getExpenseReportTNEWFROMTEMPLATEptpagrProjectInstance());

        when(mockERTemplateService.getByOIDWithHV(test4tNEWFROMTEMPLATETxnInitializedArgumentsArg1.getExpenseReportTNEWFROMTEMPLATEpTemplate())).thenReturn(test4tNEWFROMTEMPLATETxnInitializedArgumentsArg1.getExpenseReportTNEWFROMTEMPLATEpTemplateInstance());

        when(mockRepository.findById(mockexpenseReportidExpenseRepor)).thenAnswer(new Answer<Optional<ExpenseReport>>(){
        	public Optional<ExpenseReport> answer(InvocationOnMock invocation) {
        		if (invocation.getArgument(0).equals(mockexpenseReportidExpenseRepor)) {
        			return mockExpenseReport;
                }
        		return Optional.empty();
        	}
        });
        when(mockRepository.save(any(ExpenseReport.class))).thenReturn(mockInstance1);
        when(mockRepository.solveQuery(any(SQLSelect.class))).thenReturn(mockPopulation);
        when(mockRepository.solveQuery(any(SQLSelect.class), anyInt(), anyInt())).thenReturn(mockPopulation);
    }
    
    @After
    public void tearDown() {
        instanceExpenseReportService = null;
    }

    @Test
    public void test4solveQuery() {
        assertEquals(test4solveQueryResult, instanceExpenseReportService.solveQuery(test4solveQueryArg1));
    }

    @Test
    public void test4get() {
        assertEquals(test4getResult, instanceExpenseReportService.get());
    }

    @Test
    public void test4getQueryRequest() {
        assertEquals(test4getQueryRequestResult, instanceExpenseReportService.get(test4getQueryRequestArg1));
    }

    @Test
    public void test4getDynamicPopulation() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationResult), getResult(TOTALITEMS, instanceExpenseReportService.getDynamic(test4getDynamicPopulationArg1)));
    }

    @Test
    public void test4getDynamicPopulationByFilterFExpenseReportAmount_NoFVars() {
        assertEquals(getResult(RESULTCODE, test4getDynamicPopulationByFilterFExpenseReportAmount_NoFVarsResult), getResult(RESULTCODE, instanceExpenseReportService.getDynamic(test4getDynamicPopulationByFilterFExpenseReportAmount_NoFVarsArg1)));
    }

    @Test
    public void test4getDynamicPopulationByFilterFExpenseReportAmount_WithFVars() {
        assertEquals(getResult(RESULTCODE, test4getDynamicPopulationByFilterFExpenseReportAmount_WithFVarsResult), getResult(RESULTCODE, instanceExpenseReportService.getDynamic(test4getDynamicPopulationByFilterFExpenseReportAmount_WithFVarsArg1)));
    }

    @Test
    public void test4getDynamicPopulationByFilterFExpenseReportDates_NoFVars() {
        assertEquals(getResult(RESULTCODE, test4getDynamicPopulationByFilterFExpenseReportDates_NoFVarsResult), getResult(RESULTCODE, instanceExpenseReportService.getDynamic(test4getDynamicPopulationByFilterFExpenseReportDates_NoFVarsArg1)));
    }

    @Test
    public void test4getDynamicPopulationByFilterFExpenseReportDates_WithFVars() {
        assertEquals(getResult(RESULTCODE, test4getDynamicPopulationByFilterFExpenseReportDates_WithFVarsResult), getResult(RESULTCODE, instanceExpenseReportService.getDynamic(test4getDynamicPopulationByFilterFExpenseReportDates_WithFVarsArg1)));
    }

    @Test
    public void test4getDynamicPopulationByFilterFExpenseReportStatus_NoFVars() {
        assertEquals(getResult(RESULTCODE, test4getDynamicPopulationByFilterFExpenseReportStatus_NoFVarsResult), getResult(RESULTCODE, instanceExpenseReportService.getDynamic(test4getDynamicPopulationByFilterFExpenseReportStatus_NoFVarsArg1)));
    }

    @Test
    public void test4getDynamicPopulationByFilterFExpenseReportStatus_WithFVars() {
        assertEquals(getResult(RESULTCODE, test4getDynamicPopulationByFilterFExpenseReportStatus_WithFVarsResult), getResult(RESULTCODE, instanceExpenseReportService.getDynamic(test4getDynamicPopulationByFilterFExpenseReportStatus_WithFVarsArg1)));
    }

    @Test
    public void test4getDynamicPopulationByFilterFByProject_NoFVars() {
        assertEquals(getResult(RESULTCODE, test4getDynamicPopulationByFilterFByProject_NoFVarsResult), getResult(RESULTCODE, instanceExpenseReportService.getDynamic(test4getDynamicPopulationByFilterFByProject_NoFVarsArg1)));
    }

    @Test
    public void test4getDynamicPopulationByFilterFByProject_WithFVars() {
        assertEquals(getResult(RESULTCODE, test4getDynamicPopulationByFilterFByProject_WithFVarsResult), getResult(RESULTCODE, instanceExpenseReportService.getDynamic(test4getDynamicPopulationByFilterFByProject_WithFVarsArg1)));
    }

    @Test
    public void test4getDynamicPopulationByFilterFByID_NoFVars() {
        assertEquals(getResult(RESULTCODE, test4getDynamicPopulationByFilterFByID_NoFVarsResult), getResult(RESULTCODE, instanceExpenseReportService.getDynamic(test4getDynamicPopulationByFilterFByID_NoFVarsArg1)));
    }

    @Test
    public void test4getDynamicPopulationByFilterFByID_WithFVars() {
        assertEquals(getResult(RESULTCODE, test4getDynamicPopulationByFilterFByID_WithFVarsResult), getResult(RESULTCODE, instanceExpenseReportService.getDynamic(test4getDynamicPopulationByFilterFByID_WithFVarsArg1)));
    }

    @Test
    public void test4getDynamicPopulationByOrderCriteriaOCExpenseReportDate() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationByOrderCriteriaOCExpenseReportDateResult), getResult(TOTALITEMS, instanceExpenseReportService.getDynamic(test4getDynamicPopulationByOrderCriteriaOCExpenseReportDateArg1)));
    }

    @Test
    public void test4getDynamicPopulationByOrderCriteriaOCExpenseReportAmount() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationByOrderCriteriaOCExpenseReportAmountResult), getResult(TOTALITEMS, instanceExpenseReportService.getDynamic(test4getDynamicPopulationByOrderCriteriaOCExpenseReportAmountArg1)));
    }

    @Test
    public void test4getDynamicPopulationFilterByOID() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationFilterByOIDResult), getResult(TOTALITEMS, instanceExpenseReportService.getDynamic(test4getDynamicPopulationFilterByOIDArg1)));
    }

    @Test
    public void test4getDynamicPreload4DSExpenseReport4MD() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPreload4DSExpenseReport4MDResult), getResult(TOTALITEMS, instanceExpenseReportService.getDynamic(test4getDynamicPreload4DSExpenseReport4MDArg1)));
    }

    @Test
    public void test4getDynamicPreload4DSExpenseReportSup() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPreload4DSExpenseReportSupResult), getResult(TOTALITEMS, instanceExpenseReportService.getDynamic(test4getDynamicPreload4DSExpenseReportSupArg1)));
    }

    @Test
    public void test4getDynamicPreload4DSExpenseReport4HAT() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPreload4DSExpenseReport4HATResult), getResult(TOTALITEMS, instanceExpenseReportService.getDynamic(test4getDynamicPreload4DSExpenseReport4HATArg1)));
    }

    @Test
    public void test4getByRelatedDynamic() {
        assertEquals(getResult(RESULTS_SIZE, test4getByRelatedDynamicResult), getResult(RESULTS_SIZE, instanceExpenseReportService.getByRelatedDynamic(test4getByRelatedDynamicArg1, test4getByRelatedDynamicArg2, test4getByRelatedDynamicArg3)));
    }

    @Test
    public void test4getById() {
        assertEquals(test4getByIdResult, instanceExpenseReportService.getById(test4getByIdArg1));
    }

    @Test
    public void test4getByRelated() {
        assertEquals(test4getByRelatedResult, instanceExpenseReportService.getByRelated(test4getByRelatedArg1, test4getByRelatedArg2));
    }

    @Test
    public void test4getInstancesByRelated() {
        assertEquals(test4getInstancesByRelatedResult, instanceExpenseReportService.getInstancesByRelated(test4getInstancesByRelatedArg1, test4getInstancesByRelatedArg2));
    }

    @Test
    public void test4getExpenseReportDynamic() {
        assertEquals(test4getExpenseReportDynamicResult.getResultCode(), instanceExpenseReportService.getExpenseReportDynamic(test4getExpenseReportDynamicArg1, test4getExpenseReportDynamicArg2).getResultCode());
    }

    @Test
    public void test4getSuppInfoWithoutInstance() {
        assertEquals(test4getSuppInfoWithoutInstanceResult, instanceExpenseReportService.getSuppInfo(test4getSuppInfoWithoutInstanceArg1, test4getSuppInfoWithoutInstanceArg2));
    }

    @Test
    public void test4getSuppInfoWithInstance() {
        instanceExpenseReportService.getSuppInfo(test4getSuppInfoWithInstanceArg1, test4getSuppInfoWithInstanceArg2);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4getSuppInfoWithDSDSExpenseReportSup() {
        instanceExpenseReportService.getSuppInfo(test4getSuppInfoWithDSDSExpenseReportSupArg1, test4getSuppInfoWithDSDSExpenseReportSupArg2);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4buildRelatedInstance4RoleExpenseLinesWithoutRemainingPath() {
        instanceExpenseReportService.buildRelatedInstance(test4buildRelatedInstance4RoleExpenseLinesWithoutRemainingPathArg1, test4buildRelatedInstance4RoleExpenseLinesWithoutRemainingPathArg2, test4buildRelatedInstance4RoleExpenseLinesWithoutRemainingPathArg3);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4buildRelatedInstance4RoleExpenseLinesWithRemainingPath() {
        instanceExpenseReportService.buildRelatedInstance(test4buildRelatedInstance4RoleExpenseLinesWithRemainingPathArg1, test4buildRelatedInstance4RoleExpenseLinesWithRemainingPathArg2, test4buildRelatedInstance4RoleExpenseLinesWithRemainingPathArg3);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4buildRelatedInstance4RoleEmployeeWithoutRemainingPath() {
        instanceExpenseReportService.buildRelatedInstance(test4buildRelatedInstance4RoleEmployeeWithoutRemainingPathArg1, test4buildRelatedInstance4RoleEmployeeWithoutRemainingPathArg2, test4buildRelatedInstance4RoleEmployeeWithoutRemainingPathArg3);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4buildRelatedInstance4RoleEmployeeWithRemainingPath() {
        instanceExpenseReportService.buildRelatedInstance(test4buildRelatedInstance4RoleEmployeeWithRemainingPathArg1, test4buildRelatedInstance4RoleEmployeeWithRemainingPathArg2, test4buildRelatedInstance4RoleEmployeeWithRemainingPathArg3);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4buildRelatedInstance4RoleExpenseCurrencyWithoutRemainingPath() {
        instanceExpenseReportService.buildRelatedInstance(test4buildRelatedInstance4RoleExpenseCurrencyWithoutRemainingPathArg1, test4buildRelatedInstance4RoleExpenseCurrencyWithoutRemainingPathArg2, test4buildRelatedInstance4RoleExpenseCurrencyWithoutRemainingPathArg3);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4buildRelatedInstance4RoleExpenseCurrencyWithRemainingPath() {
        instanceExpenseReportService.buildRelatedInstance(test4buildRelatedInstance4RoleExpenseCurrencyWithRemainingPathArg1, test4buildRelatedInstance4RoleExpenseCurrencyWithRemainingPathArg2, test4buildRelatedInstance4RoleExpenseCurrencyWithRemainingPathArg3);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4buildRelatedInstance4RolePaymentTypeWithoutRemainingPath() {
        instanceExpenseReportService.buildRelatedInstance(test4buildRelatedInstance4RolePaymentTypeWithoutRemainingPathArg1, test4buildRelatedInstance4RolePaymentTypeWithoutRemainingPathArg2, test4buildRelatedInstance4RolePaymentTypeWithoutRemainingPathArg3);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4buildRelatedInstance4RolePaymentTypeWithRemainingPath() {
        instanceExpenseReportService.buildRelatedInstance(test4buildRelatedInstance4RolePaymentTypeWithRemainingPathArg1, test4buildRelatedInstance4RolePaymentTypeWithRemainingPathArg2, test4buildRelatedInstance4RolePaymentTypeWithRemainingPathArg3);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4buildRelatedInstance4RoleProjectWithoutRemainingPath() {
        instanceExpenseReportService.buildRelatedInstance(test4buildRelatedInstance4RoleProjectWithoutRemainingPathArg1, test4buildRelatedInstance4RoleProjectWithoutRemainingPathArg2, test4buildRelatedInstance4RoleProjectWithoutRemainingPathArg3);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4buildRelatedInstance4RoleProjectWithRemainingPath() {
        instanceExpenseReportService.buildRelatedInstance(test4buildRelatedInstance4RoleProjectWithRemainingPathArg1, test4buildRelatedInstance4RoleProjectWithRemainingPathArg2, test4buildRelatedInstance4RoleProjectWithRemainingPathArg3);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4getDSExpenseReport4MD() {
        assertEquals(test4getDSExpenseReport4MDResult.getClass(), instanceExpenseReportService.getDSExpenseReport4MD(test4getDSExpenseReport4MDArg1, test4getDSExpenseReport4MDArg2, test4getDSExpenseReport4MDArg3).getClass());
    }

    @Test
    public void test4getPreloadDSExpenseReport4MD() {
        instanceExpenseReportService.getPreload(test4getPreloadDSExpenseReport4MDArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4getDSExpenseReportSup() {
        assertEquals(test4getDSExpenseReportSupResult.getClass(), instanceExpenseReportService.getDSExpenseReportSup(test4getDSExpenseReportSupArg1, test4getDSExpenseReportSupArg2, test4getDSExpenseReportSupArg3).getClass());
    }

    @Test
    public void test4getPreloadDSExpenseReportSup() {
        instanceExpenseReportService.getPreload(test4getPreloadDSExpenseReportSupArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4getDSExpenseReport4HAT() {
        assertEquals(test4getDSExpenseReport4HATResult.getClass(), instanceExpenseReportService.getDSExpenseReport4HAT(test4getDSExpenseReport4HATArg1, test4getDSExpenseReport4HATArg2, test4getDSExpenseReport4HATArg3).getClass());
    }

    @Test
    public void test4getPreloadDSExpenseReport4HAT() {
        instanceExpenseReportService.getPreload(test4getPreloadDSExpenseReport4HATArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4iIUExpenseReport() {
        assertEquals(test4iIUExpenseReportResult.getDSExpenseReport4MDIdExpenseRepor(), instanceExpenseReportService.iIUExpenseReport(test4iIUExpenseReportArg1).getDSExpenseReport4MDIdExpenseRepor());
    }

    @Test
    public void test4piuPIUExpenseReport() {
        instanceExpenseReportService.piuPIUExpenseReport(test4piuPIUExpenseReportArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4getCount4PIUExpenseReport() {
        instanceExpenseReportService.getCount4PIUExpenseReport(test4getCount4PIUExpenseReportArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4piuPIUExpenseReportWithFilterFByProject_NoFVars() {
        instanceExpenseReportService.piuPIUExpenseReport(test4piuPIUExpenseReportWithFilterFByProject_NoFVarsArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4piuPIUExpenseReportWithFilterFByProject_WithFVars() {
        instanceExpenseReportService.piuPIUExpenseReport(test4piuPIUExpenseReportWithFilterFByProject_WithFVarsArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4piuPIUExpenseReportWithFilterFExpenseReportAmount_NoFVars() {
        instanceExpenseReportService.piuPIUExpenseReport(test4piuPIUExpenseReportWithFilterFExpenseReportAmount_NoFVarsArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4piuPIUExpenseReportWithFilterFExpenseReportAmount_WithFVars() {
        instanceExpenseReportService.piuPIUExpenseReport(test4piuPIUExpenseReportWithFilterFExpenseReportAmount_WithFVarsArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4piuPIUExpenseReportWithFilterFExpenseReportStatus_NoFVars() {
        instanceExpenseReportService.piuPIUExpenseReport(test4piuPIUExpenseReportWithFilterFExpenseReportStatus_NoFVarsArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4piuPIUExpenseReportWithFilterFExpenseReportStatus_WithFVars() {
        instanceExpenseReportService.piuPIUExpenseReport(test4piuPIUExpenseReportWithFilterFExpenseReportStatus_WithFVarsArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4piuPIUExpenseReportToEmployee() {
        instanceExpenseReportService.piuPIUExpenseReportToEmployee(test4piuPIUExpenseReportToEmployeeArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4getCount4PIUExpenseReportToEmployee() {
        instanceExpenseReportService.getCount4PIUExpenseReportToEmployee(test4getCount4PIUExpenseReportToEmployeeArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4piuPIUExpenseReportToEmployeeWithFilterFExpenseReportDates_NoFVars() {
        instanceExpenseReportService.piuPIUExpenseReportToEmployee(test4piuPIUExpenseReportToEmployeeWithFilterFExpenseReportDates_NoFVarsArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4piuPIUExpenseReportToEmployeeWithFilterFExpenseReportDates_WithFVars() {
        instanceExpenseReportService.piuPIUExpenseReportToEmployee(test4piuPIUExpenseReportToEmployeeWithFilterFExpenseReportDates_WithFVarsArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4piuPIUExpenseReportProject() {
        instanceExpenseReportService.piuPIUExpenseReportProject(test4piuPIUExpenseReportProjectArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4getCount4PIUExpenseReportProject() {
        instanceExpenseReportService.getCount4PIUExpenseReportProject(test4getCount4PIUExpenseReportProjectArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4piuPIUExpenseReportProjectWithFilterFExpenseReportDates_NoFVars() {
        instanceExpenseReportService.piuPIUExpenseReportProject(test4piuPIUExpenseReportProjectWithFilterFExpenseReportDates_NoFVarsArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4piuPIUExpenseReportProjectWithFilterFExpenseReportDates_WithFVars() {
        instanceExpenseReportService.piuPIUExpenseReportProject(test4piuPIUExpenseReportProjectWithFilterFExpenseReportDates_WithFVarsArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4piuPIUExpenseReportProjectWithFilterFExpenseReportAmount_NoFVars() {
        instanceExpenseReportService.piuPIUExpenseReportProject(test4piuPIUExpenseReportProjectWithFilterFExpenseReportAmount_NoFVarsArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4piuPIUExpenseReportProjectWithFilterFExpenseReportAmount_WithFVars() {
        instanceExpenseReportService.piuPIUExpenseReportProject(test4piuPIUExpenseReportProjectWithFilterFExpenseReportAmount_WithFVarsArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4piuPIUExpenseReportProjectWithFilterFExpenseReportStatus_NoFVars() {
        instanceExpenseReportService.piuPIUExpenseReportProject(test4piuPIUExpenseReportProjectWithFilterFExpenseReportStatus_NoFVarsArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4piuPIUExpenseReportProjectWithFilterFExpenseReportStatus_WithFVars() {
        instanceExpenseReportService.piuPIUExpenseReportProject(test4piuPIUExpenseReportProjectWithFilterFExpenseReportStatus_WithFVarsArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4newexpenseDefault() {
        instanceExpenseReportService.newexpense(test4newexpenseDefaultArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4newexpenseInitializedArguments() {
        instanceExpenseReportService.newexpense(test4newexpenseInitializedArgumentsArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4newexpenseTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.newexpenseTxn(test4newexpenseTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4newexpenseTxnDefaultResult;
        }
        assertEquals(test4newexpenseTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4newexpenseTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.newexpenseTxn(test4newexpenseTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4newexpenseTxnInitializedArgumentsResult;
        }
        assertEquals(test4newexpenseTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4newexpenseImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.newexpenseImplementation(test4newexpenseImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4newexpenseImplementationDefaultResult;
        }
        assertEquals(test4newexpenseImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4newexpenseImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.newexpenseImplementation(test4newexpenseImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4newexpenseImplementationInitializedArgumentsResult;
        }
        assertEquals(test4newexpenseImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4delexpenseDefault() {
        instanceExpenseReportService.delexpense(test4delexpenseDefaultArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4delexpenseInitializedArguments() {
        instanceExpenseReportService.delexpense(test4delexpenseInitializedArgumentsArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4delexpenseTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.delexpenseTxn(test4delexpenseTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4delexpenseTxnDefaultResult;
        }
        assertEquals(test4delexpenseTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4delexpenseTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.delexpenseTxn(test4delexpenseTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4delexpenseTxnInitializedArgumentsResult;
        }
        assertEquals(test4delexpenseTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4delexpenseImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.delexpenseImplementation(test4delexpenseImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4delexpenseImplementationDefaultResult;
        }
        assertEquals(test4delexpenseImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4delexpenseImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.delexpenseImplementation(test4delexpenseImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4delexpenseImplementationInitializedArgumentsResult;
        }
        assertEquals(test4delexpenseImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4ecloseDefault() {
        instanceExpenseReportService.eclose(test4ecloseDefaultArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4ecloseInitializedArguments() {
        instanceExpenseReportService.eclose(test4ecloseInitializedArgumentsArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4ecloseTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.ecloseTxn(test4ecloseTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4ecloseTxnDefaultResult;
        }
        assertEquals(test4ecloseTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4ecloseTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.ecloseTxn(test4ecloseTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4ecloseTxnInitializedArgumentsResult;
        }
        assertEquals(test4ecloseTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4ecloseImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.ecloseImplementation(test4ecloseImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4ecloseImplementationDefaultResult;
        }
        assertEquals(test4ecloseImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4ecloseImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.ecloseImplementation(test4ecloseImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4ecloseImplementationInitializedArgumentsResult;
        }
        assertEquals(test4ecloseImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4authorizeDefault() {
        instanceExpenseReportService.authorize(test4authorizeDefaultArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4authorizeInitializedArguments() {
        instanceExpenseReportService.authorize(test4authorizeInitializedArgumentsArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4authorizeTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.authorizeTxn(test4authorizeTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4authorizeTxnDefaultResult;
        }
        assertEquals(test4authorizeTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4authorizeTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.authorizeTxn(test4authorizeTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4authorizeTxnInitializedArgumentsResult;
        }
        assertEquals(test4authorizeTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4authorizeImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.authorizeImplementation(test4authorizeImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4authorizeImplementationDefaultResult;
        }
        assertEquals(test4authorizeImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4authorizeImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.authorizeImplementation(test4authorizeImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4authorizeImplementationInitializedArgumentsResult;
        }
        assertEquals(test4authorizeImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4payDefault() {
        instanceExpenseReportService.pay(test4payDefaultArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4payInitializedArguments() {
        instanceExpenseReportService.pay(test4payInitializedArgumentsArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4payTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.payTxn(test4payTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4payTxnDefaultResult;
        }
        assertEquals(test4payTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4payTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.payTxn(test4payTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4payTxnInitializedArgumentsResult;
        }
        assertEquals(test4payTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4payImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.payImplementation(test4payImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4payImplementationDefaultResult;
        }
        assertEquals(test4payImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4payImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.payImplementation(test4payImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4payImplementationInitializedArgumentsResult;
        }
        assertEquals(test4payImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4rejectauthoDefault() {
        instanceExpenseReportService.rejectautho(test4rejectauthoDefaultArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4rejectauthoInitializedArguments() {
        instanceExpenseReportService.rejectautho(test4rejectauthoInitializedArgumentsArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4rejectauthoTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.rejectauthoTxn(test4rejectauthoTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4rejectauthoTxnDefaultResult;
        }
        assertEquals(test4rejectauthoTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4rejectauthoTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.rejectauthoTxn(test4rejectauthoTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4rejectauthoTxnInitializedArgumentsResult;
        }
        assertEquals(test4rejectauthoTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4rejectauthoImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.rejectauthoImplementation(test4rejectauthoImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4rejectauthoImplementationDefaultResult;
        }
        assertEquals(test4rejectauthoImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4rejectauthoImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.rejectauthoImplementation(test4rejectauthoImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4rejectauthoImplementationInitializedArgumentsResult;
        }
        assertEquals(test4rejectauthoImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4rejectauthoCheckPreconditions() {
        assertEquals(rejectauthoCheckPreconditionsResult.getResultCode(), instanceExpenseReportService.rejectauthoCheckPreconditions(rejectauthoCheckPreconditionsArg1).getResultCode());
    }

    @Test
    public void test4rejectpaymentDefault() {
        instanceExpenseReportService.rejectpayment(test4rejectpaymentDefaultArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4rejectpaymentInitializedArguments() {
        instanceExpenseReportService.rejectpayment(test4rejectpaymentInitializedArgumentsArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4rejectpaymentTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.rejectpaymentTxn(test4rejectpaymentTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4rejectpaymentTxnDefaultResult;
        }
        assertEquals(test4rejectpaymentTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4rejectpaymentTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.rejectpaymentTxn(test4rejectpaymentTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4rejectpaymentTxnInitializedArgumentsResult;
        }
        assertEquals(test4rejectpaymentTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4rejectpaymentImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.rejectpaymentImplementation(test4rejectpaymentImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4rejectpaymentImplementationDefaultResult;
        }
        assertEquals(test4rejectpaymentImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4rejectpaymentImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.rejectpaymentImplementation(test4rejectpaymentImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4rejectpaymentImplementationInitializedArgumentsResult;
        }
        assertEquals(test4rejectpaymentImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4insPaymentTypeDefault() {
        instanceExpenseReportService.insPaymentType(test4insPaymentTypeDefaultArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4insPaymentTypeInitializedArguments() {
        instanceExpenseReportService.insPaymentType(test4insPaymentTypeInitializedArgumentsArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4insPaymentTypeTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.insPaymentTypeTxn(test4insPaymentTypeTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4insPaymentTypeTxnDefaultResult;
        }
        assertEquals(test4insPaymentTypeTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4insPaymentTypeTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.insPaymentTypeTxn(test4insPaymentTypeTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4insPaymentTypeTxnInitializedArgumentsResult;
        }
        assertEquals(test4insPaymentTypeTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4insPaymentTypeImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.insPaymentTypeImplementation(test4insPaymentTypeImplementationDefaultArg1, test4insPaymentTypeImplementationDefaultArg2);
        } catch (ModelException e) {
            result = test4insPaymentTypeImplementationDefaultResult;
        }
        assertEquals(test4insPaymentTypeImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4insPaymentTypeImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.insPaymentTypeImplementation(test4insPaymentTypeImplementationInitializedArgumentsArg1, test4insPaymentTypeImplementationInitializedArgumentsArg2);
        } catch (Exception e) {
            result = test4insPaymentTypeImplementationInitializedArgumentsResult;
        }
        assertEquals(test4insPaymentTypeImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4delPaymentTypeDefault() {
        instanceExpenseReportService.delPaymentType(test4delPaymentTypeDefaultArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4delPaymentTypeInitializedArguments() {
        instanceExpenseReportService.delPaymentType(test4delPaymentTypeInitializedArgumentsArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4delPaymentTypeTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.delPaymentTypeTxn(test4delPaymentTypeTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4delPaymentTypeTxnDefaultResult;
        }
        assertEquals(test4delPaymentTypeTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4delPaymentTypeTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.delPaymentTypeTxn(test4delPaymentTypeTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4delPaymentTypeTxnInitializedArgumentsResult;
        }
        assertEquals(test4delPaymentTypeTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4delPaymentTypeImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.delPaymentTypeImplementation(test4delPaymentTypeImplementationDefaultArg1, test4delPaymentTypeImplementationDefaultArg2);
        } catch (ModelException e) {
            result = test4delPaymentTypeImplementationDefaultResult;
        }
        assertEquals(test4delPaymentTypeImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4delPaymentTypeImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.delPaymentTypeImplementation(test4delPaymentTypeImplementationInitializedArgumentsArg1, test4delPaymentTypeImplementationInitializedArgumentsArg2);
        } catch (Exception e) {
            result = test4delPaymentTypeImplementationInitializedArgumentsResult;
        }
        assertEquals(test4delPaymentTypeImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4cancelapproveDefault() {
        instanceExpenseReportService.cancelapprove(test4cancelapproveDefaultArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4cancelapproveInitializedArguments() {
        instanceExpenseReportService.cancelapprove(test4cancelapproveInitializedArgumentsArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4cancelapproveTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.cancelapproveTxn(test4cancelapproveTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4cancelapproveTxnDefaultResult;
        }
        assertEquals(test4cancelapproveTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4cancelapproveTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.cancelapproveTxn(test4cancelapproveTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4cancelapproveTxnInitializedArgumentsResult;
        }
        assertEquals(test4cancelapproveTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4cancelapproveImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.cancelapproveImplementation(test4cancelapproveImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4cancelapproveImplementationDefaultResult;
        }
        assertEquals(test4cancelapproveImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4cancelapproveImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.cancelapproveImplementation(test4cancelapproveImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4cancelapproveImplementationInitializedArgumentsResult;
        }
        assertEquals(test4cancelapproveImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4approveDefault() {
        instanceExpenseReportService.approve(test4approveDefaultArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4approveInitializedArguments() {
        instanceExpenseReportService.approve(test4approveInitializedArgumentsArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4approveTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.approveTxn(test4approveTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4approveTxnDefaultResult;
        }
        assertEquals(test4approveTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4approveTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.approveTxn(test4approveTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4approveTxnInitializedArgumentsResult;
        }
        assertEquals(test4approveTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4approveImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.approveImplementation(test4approveImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4approveImplementationDefaultResult;
        }
        assertEquals(test4approveImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4approveImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.approveImplementation(test4approveImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4approveImplementationInitializedArgumentsResult;
        }
        assertEquals(test4approveImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceDefault() {
        instanceExpenseReportService.editinstance(test4editinstanceDefaultArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4editinstanceInitializedArguments() {
        instanceExpenseReportService.editinstance(test4editinstanceInitializedArgumentsArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4editinstanceTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.editinstanceTxn(test4editinstanceTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4editinstanceTxnDefaultResult;
        }
        assertEquals(test4editinstanceTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.editinstanceTxn(test4editinstanceTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editinstanceTxnInitializedArgumentsResult;
        }
        assertEquals(test4editinstanceTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.editinstanceImplementation(test4editinstanceImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4editinstanceImplementationDefaultResult;
        }
        assertEquals(test4editinstanceImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.editinstanceImplementation(test4editinstanceImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editinstanceImplementationInitializedArgumentsResult;
        }
        assertEquals(test4editinstanceImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4dummyDefault() {
        instanceExpenseReportService.dummy(test4dummyDefaultArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4dummyInitializedArguments() {
        instanceExpenseReportService.dummy(test4dummyInitializedArgumentsArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4dummyTxnDefault() {
        DummyResponse result;
        try {
            result = instanceExpenseReportService.dummyTxn(test4dummyTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4dummyTxnDefaultResult;
        }
        assertEquals(test4dummyTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4dummyTxnInitializedArguments() {
        DummyResponse result;
        try {
            result = instanceExpenseReportService.dummyTxn(test4dummyTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4dummyTxnInitializedArgumentsResult;
        }
        assertEquals(test4dummyTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4dummyImplementationDefault() {
        DummyResponse result;
        try {
            result = instanceExpenseReportService.dummyImplementation(test4dummyImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4dummyImplementationDefaultResult;
        }
        assertEquals(test4dummyImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4dummyImplementationInitializedArguments() {
        DummyResponse result;
        try {
            result = instanceExpenseReportService.dummyImplementation(test4dummyImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4dummyImplementationInitializedArgumentsResult;
        }
        assertEquals(test4dummyImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4dELETEALLDefault() {
        instanceExpenseReportService.dELETEALL(test4dELETEALLDefaultArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4dELETEALLInitializedArguments() {
        instanceExpenseReportService.dELETEALL(test4dELETEALLInitializedArgumentsArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4dELETEALLTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.dELETEALLTxn(test4dELETEALLTxnDefaultArg1);
        } catch (ModelException | SystemException e) {
            result = test4dELETEALLTxnDefaultResult;
        }
        assertEquals(test4dELETEALLTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4dELETEALLTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.dELETEALLTxn(test4dELETEALLTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4dELETEALLTxnInitializedArgumentsResult;
        }
        assertEquals(test4dELETEALLTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4dELETEALLImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.dELETEALLImplementation(test4dELETEALLImplementationDefaultArg1);
        } catch (ModelException | SystemException e) {
            result = test4dELETEALLImplementationDefaultResult;
        }
        assertEquals(test4dELETEALLImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4dELETEALLImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.dELETEALLImplementation(test4dELETEALLImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4dELETEALLImplementationInitializedArgumentsResult;
        }
        assertEquals(test4dELETEALLImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tPAYDefault() {
        instanceExpenseReportService.tPAY(test4tPAYDefaultArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4tPAYInitializedArguments() {
        instanceExpenseReportService.tPAY(test4tPAYInitializedArgumentsArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4tPAYTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.tPAYTxn(test4tPAYTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4tPAYTxnDefaultResult;
        }
        assertEquals(test4tPAYTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tPAYTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.tPAYTxn(test4tPAYTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4tPAYTxnInitializedArgumentsResult;
        }
        assertEquals(test4tPAYTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tPAYImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.tPAYImplementation(test4tPAYImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4tPAYImplementationDefaultResult;
        }
        assertEquals(test4tPAYImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tPAYImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.tPAYImplementation(test4tPAYImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4tPAYImplementationInitializedArgumentsResult;
        }
        assertEquals(test4tPAYImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tNEWDefault() {
        instanceExpenseReportService.tNEW(test4tNEWDefaultArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4tNEWInitializedArguments() {
        instanceExpenseReportService.tNEW(test4tNEWInitializedArgumentsArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4tNEWTxnDefault() {
        TNEWResponse result;
        try {
            result = instanceExpenseReportService.tNEWTxn(test4tNEWTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4tNEWTxnDefaultResult;
        }
        assertEquals(test4tNEWTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tNEWTxnInitializedArguments() {
        TNEWResponse result;
        try {
            result = instanceExpenseReportService.tNEWTxn(test4tNEWTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4tNEWTxnInitializedArgumentsResult;
        }
        assertEquals(test4tNEWTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tNEWImplementationDefault() {
        TNEWResponse result;
        try {
            result = instanceExpenseReportService.tNEWImplementation(test4tNEWImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4tNEWImplementationDefaultResult;
        }
        assertEquals(test4tNEWImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tNEWImplementationInitializedArguments() {
        TNEWResponse result;
        try {
            result = instanceExpenseReportService.tNEWImplementation(test4tNEWImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4tNEWImplementationInitializedArgumentsResult;
        }
        assertEquals(test4tNEWImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tNEWCheckPreconditions() {
        assertEquals(tNEWCheckPreconditionsResult.getResultCode(), instanceExpenseReportService.tNEWCheckPreconditions(tNEWCheckPreconditionsArg1).getResultCode());
    }

    @Test
    public void test4tREJECTPAYMENTDefault() {
        instanceExpenseReportService.tREJECTPAYMENT(test4tREJECTPAYMENTDefaultArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4tREJECTPAYMENTInitializedArguments() {
        instanceExpenseReportService.tREJECTPAYMENT(test4tREJECTPAYMENTInitializedArgumentsArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4tREJECTPAYMENTTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.tREJECTPAYMENTTxn(test4tREJECTPAYMENTTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4tREJECTPAYMENTTxnDefaultResult;
        }
        assertEquals(test4tREJECTPAYMENTTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tREJECTPAYMENTTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.tREJECTPAYMENTTxn(test4tREJECTPAYMENTTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4tREJECTPAYMENTTxnInitializedArgumentsResult;
        }
        assertEquals(test4tREJECTPAYMENTTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tREJECTPAYMENTImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.tREJECTPAYMENTImplementation(test4tREJECTPAYMENTImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4tREJECTPAYMENTImplementationDefaultResult;
        }
        assertEquals(test4tREJECTPAYMENTImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tREJECTPAYMENTImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseReportService.tREJECTPAYMENTImplementation(test4tREJECTPAYMENTImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4tREJECTPAYMENTImplementationInitializedArgumentsResult;
        }
        assertEquals(test4tREJECTPAYMENTImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tNEWFROMTEMPLATEDefault() {
        instanceExpenseReportService.tNEWFROMTEMPLATE(test4tNEWFROMTEMPLATEDefaultArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4tNEWFROMTEMPLATEInitializedArguments() {
        instanceExpenseReportService.tNEWFROMTEMPLATE(test4tNEWFROMTEMPLATEInitializedArgumentsArg1);
        assertNotNull(instanceExpenseReportService);
    }

    @Test
    public void test4tNEWFROMTEMPLATETxnDefault() {
        TNEWFROMTEMPLATEResponse result;
        try {
            result = instanceExpenseReportService.tNEWFROMTEMPLATETxn(test4tNEWFROMTEMPLATETxnDefaultArg1);
        } catch (ModelException | SystemException e) {
            result = test4tNEWFROMTEMPLATETxnDefaultResult;
        }
        assertEquals(test4tNEWFROMTEMPLATETxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tNEWFROMTEMPLATETxnInitializedArguments() {
        TNEWFROMTEMPLATEResponse result;
        try {
            result = instanceExpenseReportService.tNEWFROMTEMPLATETxn(test4tNEWFROMTEMPLATETxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4tNEWFROMTEMPLATETxnInitializedArgumentsResult;
        }
        assertEquals(test4tNEWFROMTEMPLATETxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tNEWFROMTEMPLATEImplementationDefault() {
        TNEWFROMTEMPLATEResponse result;
        try {
            result = instanceExpenseReportService.tNEWFROMTEMPLATEImplementation(test4tNEWFROMTEMPLATEImplementationDefaultArg1);
        } catch (ModelException | SystemException e) {
            result = test4tNEWFROMTEMPLATEImplementationDefaultResult;
        }
        assertEquals(test4tNEWFROMTEMPLATEImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tNEWFROMTEMPLATEImplementationInitializedArguments() {
        TNEWFROMTEMPLATEResponse result;
        try {
            result = instanceExpenseReportService.tNEWFROMTEMPLATEImplementation(test4tNEWFROMTEMPLATEImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4tNEWFROMTEMPLATEImplementationInitializedArgumentsResult;
        }
        assertEquals(test4tNEWFROMTEMPLATEImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tNEWFROMTEMPLATECheckPreconditions() {
        assertEquals(tNEWFROMTEMPLATECheckPreconditionsResult.getResultCode(), instanceExpenseReportService.tNEWFROMTEMPLATECheckPreconditions(tNEWFROMTEMPLATECheckPreconditionsArg1).getResultCode());
    }
}
