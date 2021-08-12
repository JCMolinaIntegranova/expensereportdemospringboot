package com.integranova.spring.expensereportdemo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.ExpenseCurrencyConstants;
import com.integranova.spring.expensereportdemo.persistence.ExpenseCurrency;
import com.integranova.spring.expensereportdemo.persistence.oid.ExchangeHistoryOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseCurrencyOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseReportOid;
import com.integranova.spring.expensereportdemo.repository.ExpenseCurrencyJpaRepository;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.ds.DSExpenseCurrency;
import com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.ds.DSExpenseCurrencySup;
import com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.CreateinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.DeleteinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.EditExchangeRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.EditinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.ResetExchangeRequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.TEDITEXCHANGERequest;
import com.integranova.spring.expensereportdemo.viewmodel.expensecurrency.siu.TNEWRequest;
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
public class ExpenseCurrencyServiceTest extends ClassTest {

    @InjectMocks
    private ExpenseCurrencyService instanceExpenseCurrencyService;
    
    @Mock
    private static ExpenseCurrencyJpaRepository mockRepository;
    
    @Mock
    private static ExpenseCurrencyService mockExpenseCurrencyService;
    
    @Mock
    private static ExchangeHistoryService mockExchangeHistoryService;
    
    @Mock
    private static ExpenseReportService mockExpenseReportService;

    private static ExpenseCurrency mockInstance1;
    
    private static ExpenseCurrency mockInstance2;

    private static List<ExpenseCurrency> mockPopulation;

    private static String mockexpenseCurrencyCurrencyCode;

    private static Optional<ExpenseCurrency> mockExpenseCurrency; 

    // test4solveQuery
    private static QueryRequest test4solveQueryArg1;
    private static List<Map<String, Object>> test4solveQueryResult;

    // test4get
    private static List<ExpenseCurrency> test4getResult;

    // test4getQueryRequest
    private static QueryRequest test4getQueryRequestArg1;
    private static List<ExpenseCurrency> test4getQueryRequestResult;

    // test4getDynamicPopulation
    private static QueryRequest test4getDynamicPopulationArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationResult;

    // test4getDynamicPopulationByOrderCriteriaOCExpenseCurrency
    private static QueryRequest test4getDynamicPopulationByOrderCriteriaOCExpenseCurrencyArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationByOrderCriteriaOCExpenseCurrencyResult;

    // test4getDynamicPopulationFilterByOID
    private static QueryRequest test4getDynamicPopulationFilterByOIDArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationFilterByOIDResult;

    // test4getDynamicPreload4DSExpenseCurrency
    private static QueryRequest test4getDynamicPreload4DSExpenseCurrencyArg1;
    private static PreloadResponseViewModel test4getDynamicPreload4DSExpenseCurrencyResult;

    // test4getDynamicPreload4DSExpenseCurrencySup
    private static QueryRequest test4getDynamicPreload4DSExpenseCurrencySupArg1;
    private static PreloadResponseViewModel test4getDynamicPreload4DSExpenseCurrencySupResult;

    // test4getByRelatedDynamic
    private static String test4getByRelatedDynamicArg1;
    private static String test4getByRelatedDynamicArg2;
    private static String test4getByRelatedDynamicArg3;
    private static PopulationResponseViewModel test4getByRelatedDynamicResult;

    // test4getById
    private static String test4getByIdArg1;
    private static ExpenseCurrency test4getByIdResult;

    // test4getByRelated
    private static ExpenseCurrency test4getByRelatedArg1;
    private static String test4getByRelatedArg2;
    private static List<ExpenseCurrency> test4getByRelatedResult;

    // test4getInstancesByRelated
    private static ExpenseCurrency test4getInstancesByRelatedArg1;
    private static String test4getInstancesByRelatedArg2;
    private static List<ExpenseCurrency> test4getInstancesByRelatedResult;

    // test4getExpenseCurrencyDynamic
    private static ExpenseCurrencyOid test4getExpenseCurrencyDynamicArg1;
    private static String test4getExpenseCurrencyDynamicArg2;
    private static InstanceResponseViewModel test4getExpenseCurrencyDynamicResult;

    // test4getSuppInfoWithoutInstance
    private static ExpenseCurrencyOid test4getSuppInfoWithoutInstanceArg1;
    private static String test4getSuppInfoWithoutInstanceArg2;
    private static String test4getSuppInfoWithoutInstanceResult;

    // test4getSuppInfoWithInstance
    private static ExpenseCurrencyOid test4getSuppInfoWithInstanceArg1;
    private static String test4getSuppInfoWithInstanceArg2;

    // test4getSuppInfoWithDSDSExpenseCurrencySup
    private static ExpenseCurrencyOid test4getSuppInfoWithDSDSExpenseCurrencySupArg1;
    private static String test4getSuppInfoWithDSDSExpenseCurrencySupArg2;

    // test4buildRelatedInstance4RoleExpenseReportsWithoutRemainingPath
    private static String test4buildRelatedInstance4RoleExpenseReportsWithoutRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleExpenseReportsWithoutRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleExpenseReportsWithoutRemainingPathArg3;

    // test4buildRelatedInstance4RoleExpenseReportsWithRemainingPath
    private static String test4buildRelatedInstance4RoleExpenseReportsWithRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleExpenseReportsWithRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleExpenseReportsWithRemainingPathArg3;

    // test4buildRelatedInstance4RoleExchangeHistoryItemsWithoutRemainingPath
    private static String test4buildRelatedInstance4RoleExchangeHistoryItemsWithoutRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleExchangeHistoryItemsWithoutRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleExchangeHistoryItemsWithoutRemainingPathArg3;

    // test4buildRelatedInstance4RoleExchangeHistoryItemsWithRemainingPath
    private static String test4buildRelatedInstance4RoleExchangeHistoryItemsWithRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleExchangeHistoryItemsWithRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleExchangeHistoryItemsWithRemainingPathArg3;

    // test4getDSExpenseCurrency
    private static String test4getDSExpenseCurrencyArg1;
    private static String test4getDSExpenseCurrencyArg2;
    private static String test4getDSExpenseCurrencyArg3;
    private static DSExpenseCurrency test4getDSExpenseCurrencyResult;

    // test4getPreloadDSExpenseCurrency
    private static QueryRequest test4getPreloadDSExpenseCurrencyArg1;
    private static List<PreloadViewModel> test4getPreloadDSExpenseCurrencyResult;

    // test4getDSExpenseCurrencySup
    private static String test4getDSExpenseCurrencySupArg1;
    private static String test4getDSExpenseCurrencySupArg2;
    private static String test4getDSExpenseCurrencySupArg3;
    private static DSExpenseCurrencySup test4getDSExpenseCurrencySupResult;

    // test4getPreloadDSExpenseCurrencySup
    private static QueryRequest test4getPreloadDSExpenseCurrencySupArg1;
    private static List<PreloadViewModel> test4getPreloadDSExpenseCurrencySupResult;

    // test4iIUExpenseCurrency
    private static ExpenseCurrencyOid test4iIUExpenseCurrencyArg1;
    private static DSExpenseCurrency test4iIUExpenseCurrencyResult;

    // test4piuPIUExpenseCurrency
    private static QueryRequest test4piuPIUExpenseCurrencyArg1;
    private static List<DSExpenseCurrency> test4piuPIUExpenseCurrencyResult;

    // test4getCount4PIUExpenseCurrency
    private static QueryRequest test4getCount4PIUExpenseCurrencyArg1;
    private static int test4getCount4PIUExpenseCurrencyResult;

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

    // test4resetExchangeDefault
    private static ResetExchangeRequest test4resetExchangeDefaultArg1;

    // test4resetExchangeInitializedArguments
    private static ResetExchangeRequest test4resetExchangeInitializedArgumentsArg1;

    // test4resetExchangeTxnDefault
    private static ResetExchangeRequest test4resetExchangeTxnDefaultArg1;
    private static ServiceResponse test4resetExchangeTxnDefaultResult;

    // test4resetExchangeTxnInitializedArguments
    private static ResetExchangeRequest test4resetExchangeTxnInitializedArgumentsArg1;
    private static ServiceResponse test4resetExchangeTxnInitializedArgumentsResult;

    // test4resetExchangeImplementationDefault
    private static ResetExchangeRequest test4resetExchangeImplementationDefaultArg1;
    private static ServiceResponse test4resetExchangeImplementationDefaultResult;

    // test4resetExchangeImplementationInitializedArguments
    private static ResetExchangeRequest test4resetExchangeImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4resetExchangeImplementationInitializedArgumentsResult;

    // test4editExchangeDefault
    private static EditExchangeRequest test4editExchangeDefaultArg1;

    // test4editExchangeInitializedArguments
    private static EditExchangeRequest test4editExchangeInitializedArgumentsArg1;

    // test4editExchangeTxnDefault
    private static EditExchangeRequest test4editExchangeTxnDefaultArg1;
    private static ServiceResponse test4editExchangeTxnDefaultResult;

    // test4editExchangeTxnInitializedArguments
    private static EditExchangeRequest test4editExchangeTxnInitializedArgumentsArg1;
    private static ServiceResponse test4editExchangeTxnInitializedArgumentsResult;

    // test4editExchangeImplementationDefault
    private static EditExchangeRequest test4editExchangeImplementationDefaultArg1;
    private static ServiceResponse test4editExchangeImplementationDefaultResult;

    // test4editExchangeImplementationInitializedArguments
    private static EditExchangeRequest test4editExchangeImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4editExchangeImplementationInitializedArgumentsResult;

    // test4tNEWDefault
    private static TNEWRequest test4tNEWDefaultArg1;

    // test4tNEWInitializedArguments
    private static TNEWRequest test4tNEWInitializedArgumentsArg1;

    // test4tNEWTxnDefault
    private static TNEWRequest test4tNEWTxnDefaultArg1;
    private static ServiceResponse test4tNEWTxnDefaultResult;

    // test4tNEWTxnInitializedArguments
    private static TNEWRequest test4tNEWTxnInitializedArgumentsArg1;
    private static ServiceResponse test4tNEWTxnInitializedArgumentsResult;

    // test4tNEWImplementationDefault
    private static TNEWRequest test4tNEWImplementationDefaultArg1;
    private static ServiceResponse test4tNEWImplementationDefaultResult;

    // test4tNEWImplementationInitializedArguments
    private static TNEWRequest test4tNEWImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4tNEWImplementationInitializedArgumentsResult;

    // test4tEDITEXCHANGEDefault
    private static TEDITEXCHANGERequest test4tEDITEXCHANGEDefaultArg1;

    // test4tEDITEXCHANGEInitializedArguments
    private static TEDITEXCHANGERequest test4tEDITEXCHANGEInitializedArgumentsArg1;

    // test4tEDITEXCHANGETxnDefault
    private static TEDITEXCHANGERequest test4tEDITEXCHANGETxnDefaultArg1;
    private static ServiceResponse test4tEDITEXCHANGETxnDefaultResult;

    // test4tEDITEXCHANGETxnInitializedArguments
    private static TEDITEXCHANGERequest test4tEDITEXCHANGETxnInitializedArgumentsArg1;
    private static ServiceResponse test4tEDITEXCHANGETxnInitializedArgumentsResult;

    // test4tEDITEXCHANGEImplementationDefault
    private static TEDITEXCHANGERequest test4tEDITEXCHANGEImplementationDefaultArg1;
    private static ServiceResponse test4tEDITEXCHANGEImplementationDefaultResult;

    // test4tEDITEXCHANGEImplementationInitializedArguments
    private static TEDITEXCHANGERequest test4tEDITEXCHANGEImplementationInitializedArgumentsArg1;
    private static ServiceResponse test4tEDITEXCHANGEImplementationInitializedArgumentsResult;

    @BeforeClass
    public static void setUpClass() throws SystemException {
        setUpMockData();
    }

    private static void setUpMockData() throws SystemException {
        mockexpenseCurrencyCurrencyCode = "";
        mockInstance1 = new ExpenseCurrency();
        mockInstance2 = new ExpenseCurrency();
        mockPopulation = new ArrayList<>(Arrays.asList(mockInstance1, mockInstance2));
        mockExpenseCurrency = Optional.of(new ExpenseCurrency(new ExpenseCurrencyOid(mockexpenseCurrencyCurrencyCode)));
        setUpMockData4test4solveQuery();
        setUpMockData4test4get();
        setUpMockData4test4getQueryRequest();
        setUpMockData4test4getDynamicPopulation();
        setUpMockData4test4getDynamicPopulationByOrderCriteriaOCExpenseCurrency();
        setUpMockData4test4getDynamicPopulationFilterByOID();
        setUpMockData4test4getDynamicPreload4DSExpenseCurrency();
        setUpMockData4test4getDynamicPreload4DSExpenseCurrencySup();
        setUpMockData4test4getByRelatedDynamic();
        setUpMockData4test4getById();
        setUpMockData4test4getByRelated();
        setUpMockData4test4getInstancesByRelated();
        setUpMockData4test4getExpenseCurrencyDynamic();
        setUpMockData4test4getSuppInfoWithoutInstance();
        setUpMockData4test4getSuppInfoWithInstance();
        setUpMockData4test4getSuppInfoWithDSDSExpenseCurrencySup();
        setUpMockData4test4buildRelatedInstance4RoleExpenseReportsWithoutRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleExpenseReportsWithRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleExchangeHistoryItemsWithoutRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleExchangeHistoryItemsWithRemainingPath();
        setUpMockData4test4getDSExpenseCurrency();
        setUpMockData4test4getPreloadDSExpenseCurrency();
        setUpMockData4test4getDSExpenseCurrencySup();
        setUpMockData4test4getPreloadDSExpenseCurrencySup();
        setUpMockData4test4iIUExpenseCurrency();
        setUpMockData4test4piuPIUExpenseCurrency();
        setUpMockData4test4getCount4PIUExpenseCurrency();
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
        setUpMockData4test4resetExchangeDefault();
        setUpMockData4test4resetExchangeInitializedArguments();
        setUpMockData4test4resetExchangeTxnDefault();
        setUpMockData4test4resetExchangeTxnInitializedArguments();
        setUpMockData4test4resetExchangeImplementationDefault();
        setUpMockData4test4resetExchangeImplementationInitializedArguments();
        setUpMockData4test4editExchangeDefault();
        setUpMockData4test4editExchangeInitializedArguments();
        setUpMockData4test4editExchangeTxnDefault();
        setUpMockData4test4editExchangeTxnInitializedArguments();
        setUpMockData4test4editExchangeImplementationDefault();
        setUpMockData4test4editExchangeImplementationInitializedArguments();
        setUpMockData4test4tNEWDefault();
        setUpMockData4test4tNEWInitializedArguments();
        setUpMockData4test4tNEWTxnDefault();
        setUpMockData4test4tNEWTxnInitializedArguments();
        setUpMockData4test4tNEWImplementationDefault();
        setUpMockData4test4tNEWImplementationInitializedArguments();
        setUpMockData4test4tEDITEXCHANGEDefault();
        setUpMockData4test4tEDITEXCHANGEInitializedArguments();
        setUpMockData4test4tEDITEXCHANGETxnDefault();
        setUpMockData4test4tEDITEXCHANGETxnInitializedArguments();
        setUpMockData4test4tEDITEXCHANGEImplementationDefault();
        setUpMockData4test4tEDITEXCHANGEImplementationInitializedArguments();
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
        test4getDynamicPopulationArg1.setDisplaySetItems("expenseCurrencyCurrencyCode");
        test4getDynamicPopulationResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationByOrderCriteriaOCExpenseCurrency() {
        test4getDynamicPopulationByOrderCriteriaOCExpenseCurrencyArg1 = new QueryRequest();
        test4getDynamicPopulationByOrderCriteriaOCExpenseCurrencyArg1.setDisplaySetItems("expenseCurrencyCurrencyCode");
        test4getDynamicPopulationByOrderCriteriaOCExpenseCurrencyArg1.setOrderCriteriaName("OCExpenseCurrency");
        test4getDynamicPopulationByOrderCriteriaOCExpenseCurrencyResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationFilterByOID() {
        test4getDynamicPopulationFilterByOIDArg1 = new QueryRequest();
        test4getDynamicPopulationFilterByOIDArg1.setDisplaySetItems("expenseCurrencyCurrencyCode");
        test4getDynamicPopulationFilterByOIDArg1.addFilterRequest(new FilterRequest(Constants.FILTER_BY_OID,new ArrayList<>(Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_OID_FVAR_OID, new ExpenseCurrencyOid(""))))));
        test4getDynamicPopulationFilterByOIDResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPreload4DSExpenseCurrency() {
        test4getDynamicPreload4DSExpenseCurrencyArg1 = new QueryRequest();
        test4getDynamicPreload4DSExpenseCurrencyArg1.setDisplaySetName(ExpenseCurrencyConstants.DSDSEXPENSECURRENCY);
        test4getDynamicPreload4DSExpenseCurrencyResult = new PreloadResponseViewModel(mockPopulation.stream().map(i -> ExpenseCurrencyService.buildPreloadViewModel(i, test4getDynamicPreload4DSExpenseCurrencyArg1.getDisplaySetName())).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPreload4DSExpenseCurrencySup() {
        test4getDynamicPreload4DSExpenseCurrencySupArg1 = new QueryRequest();
        test4getDynamicPreload4DSExpenseCurrencySupArg1.setDisplaySetName(ExpenseCurrencyConstants.DSDSEXPENSECURRENCYSUP);
        test4getDynamicPreload4DSExpenseCurrencySupResult = new PreloadResponseViewModel(mockPopulation.stream().map(i -> ExpenseCurrencyService.buildPreloadViewModel(i, test4getDynamicPreload4DSExpenseCurrencySupArg1.getDisplaySetName())).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getByRelatedDynamic() {
        test4getByRelatedDynamicArg1 = "";
        test4getByRelatedDynamicArg2 = "";
        test4getByRelatedDynamicArg3 = "";
        test4getByRelatedDynamicResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getById() {
        test4getByIdArg1 = "";
        test4getByIdResult = mockExpenseCurrency.get();
    }

    private static void setUpMockData4test4getByRelated() {
        test4getByRelatedArg1 = new ExpenseCurrency();
        test4getByRelatedArg2 = "";
        test4getByRelatedResult = mockPopulation;
    }

    private static void setUpMockData4test4getInstancesByRelated() {
        test4getInstancesByRelatedArg1 = new ExpenseCurrency();
        test4getInstancesByRelatedArg2 = "";
        test4getInstancesByRelatedResult = mockPopulation;
    }

    private static void setUpMockData4test4getExpenseCurrencyDynamic() {
        test4getExpenseCurrencyDynamicArg1 = new ExpenseCurrencyOid();
        test4getExpenseCurrencyDynamicArg2 = "";
        test4getExpenseCurrencyDynamicResult = new InstanceResponseViewModel();
    }

    private static void setUpMockData4test4getSuppInfoWithoutInstance() {
        test4getSuppInfoWithoutInstanceArg1 = new ExpenseCurrencyOid();
        test4getSuppInfoWithoutInstanceArg2 = "";
        test4getSuppInfoWithoutInstanceResult = "";
    }

    private static void setUpMockData4test4getSuppInfoWithInstance() {
        test4getSuppInfoWithInstanceArg1 = new ExpenseCurrencyOid("");
        test4getSuppInfoWithInstanceArg2 = "";
    }

    private static void setUpMockData4test4getSuppInfoWithDSDSExpenseCurrencySup() {
        test4getSuppInfoWithDSDSExpenseCurrencySupArg1 = new ExpenseCurrencyOid("");
        test4getSuppInfoWithDSDSExpenseCurrencySupArg2 = ExpenseCurrencyConstants.DSDSEXPENSECURRENCYSUP;
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleExpenseReportsWithoutRemainingPath() {
        test4buildRelatedInstance4RoleExpenseReportsWithoutRemainingPathArg1 = new ExpenseReportOid(Long.valueOf(0)).toJson();
        test4buildRelatedInstance4RoleExpenseReportsWithoutRemainingPathArg2 = ExpenseCurrencyConstants.ROLE_NAME_EXPENSEREPORTS;
        test4buildRelatedInstance4RoleExpenseReportsWithoutRemainingPathArg3 = "";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleExpenseReportsWithRemainingPath() {
        test4buildRelatedInstance4RoleExpenseReportsWithRemainingPathArg1 = new ExpenseReportOid(Long.valueOf(0)).toJson();
        test4buildRelatedInstance4RoleExpenseReportsWithRemainingPathArg2 = ExpenseCurrencyConstants.ROLE_NAME_EXPENSEREPORTS;
        test4buildRelatedInstance4RoleExpenseReportsWithRemainingPathArg3 = "dummy";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleExchangeHistoryItemsWithoutRemainingPath() {
        test4buildRelatedInstance4RoleExchangeHistoryItemsWithoutRemainingPathArg1 = new ExchangeHistoryOid("", Date.valueOf(Constants.DATE_DEFAULTVALUE)).toJson();
        test4buildRelatedInstance4RoleExchangeHistoryItemsWithoutRemainingPathArg2 = ExpenseCurrencyConstants.ROLE_NAME_EXCHANGEHISTORYITEMS;
        test4buildRelatedInstance4RoleExchangeHistoryItemsWithoutRemainingPathArg3 = "";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleExchangeHistoryItemsWithRemainingPath() {
        test4buildRelatedInstance4RoleExchangeHistoryItemsWithRemainingPathArg1 = new ExchangeHistoryOid("", Date.valueOf(Constants.DATE_DEFAULTVALUE)).toJson();
        test4buildRelatedInstance4RoleExchangeHistoryItemsWithRemainingPathArg2 = ExpenseCurrencyConstants.ROLE_NAME_EXCHANGEHISTORYITEMS;
        test4buildRelatedInstance4RoleExchangeHistoryItemsWithRemainingPathArg3 = "dummy";
    }

    private static void setUpMockData4test4getDSExpenseCurrency() {
        test4getDSExpenseCurrencyArg1 = "";
        test4getDSExpenseCurrencyArg2 = "";
        test4getDSExpenseCurrencyArg3 = "";
        test4getDSExpenseCurrencyResult = new DSExpenseCurrency();
    }

    private static void setUpMockData4test4getPreloadDSExpenseCurrency() {
        test4getPreloadDSExpenseCurrencyArg1 = new QueryRequest();
        test4getPreloadDSExpenseCurrencyArg1.setDisplaySetName(ExpenseCurrencyConstants.DSDSEXPENSECURRENCY);
        test4getPreloadDSExpenseCurrencyResult = mockPopulation.stream().map(i -> ExpenseCurrencyService.buildPreloadViewModel(i, test4getPreloadDSExpenseCurrencyArg1.getDisplaySetName())).collect(Collectors.toList());
    }

    private static void setUpMockData4test4getDSExpenseCurrencySup() {
        test4getDSExpenseCurrencySupArg1 = "";
        test4getDSExpenseCurrencySupArg2 = "";
        test4getDSExpenseCurrencySupArg3 = "";
        test4getDSExpenseCurrencySupResult = new DSExpenseCurrencySup();
    }

    private static void setUpMockData4test4getPreloadDSExpenseCurrencySup() {
        test4getPreloadDSExpenseCurrencySupArg1 = new QueryRequest();
        test4getPreloadDSExpenseCurrencySupArg1.setDisplaySetName(ExpenseCurrencyConstants.DSDSEXPENSECURRENCYSUP);
        test4getPreloadDSExpenseCurrencySupResult = mockPopulation.stream().map(i -> ExpenseCurrencyService.buildPreloadViewModel(i, test4getPreloadDSExpenseCurrencySupArg1.getDisplaySetName())).collect(Collectors.toList());
    }

    private static void setUpMockData4test4iIUExpenseCurrency() {
        test4iIUExpenseCurrencyArg1 = new ExpenseCurrencyOid();
        test4iIUExpenseCurrencyResult = new DSExpenseCurrency();
    }

    private static void setUpMockData4test4piuPIUExpenseCurrency() {
        test4piuPIUExpenseCurrencyArg1 = new QueryRequest();
        test4piuPIUExpenseCurrencyResult = mockPopulation.stream().map(i -> new DSExpenseCurrency(i)).collect(Collectors.toList());
    }

    private static void setUpMockData4test4getCount4PIUExpenseCurrency() {
        test4getCount4PIUExpenseCurrencyArg1 = new QueryRequest();
        test4getCount4PIUExpenseCurrencyResult = mockPopulation.size();
    }

    private static void setUpMockData4test4createinstanceDefault() {
        test4createinstanceDefaultArg1 = new CreateinstanceRequest();
    }

    private static void setUpMockData4test4createinstanceInitializedArguments() {
        test4createinstanceInitializedArgumentsArg1 = new CreateinstanceRequest();
        test4createinstanceInitializedArgumentsArg1.setExpenseCurrencycreateinstancepatrCurrencyName("");
        test4createinstanceInitializedArgumentsArg1.setExpenseCurrencycreateinstancepatrCurrencyCode("");
        test4createinstanceInitializedArgumentsArg1.setExpenseCurrencycreateinstancepatrCurAcronym("");
        test4createinstanceInitializedArgumentsArg1.setExpenseCurrencycreateinstancepatrExchange(Double.valueOf(0));
    }

    private static void setUpMockData4test4createinstanceTxnDefault() {
        test4createinstanceTxnDefaultArg1 = new CreateinstanceRequest();
        test4createinstanceTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4createinstanceTxnInitializedArguments() {
        test4createinstanceTxnInitializedArgumentsArg1 = new CreateinstanceRequest();
        test4createinstanceTxnInitializedArgumentsArg1.setExpenseCurrencycreateinstancepatrCurrencyName("");
        test4createinstanceTxnInitializedArgumentsArg1.setExpenseCurrencycreateinstancepatrCurrencyCode("");
        test4createinstanceTxnInitializedArgumentsArg1.setExpenseCurrencycreateinstancepatrCurAcronym("");
        test4createinstanceTxnInitializedArgumentsArg1.setExpenseCurrencycreateinstancepatrExchange(Double.valueOf(0));
        test4createinstanceTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4createinstanceImplementationDefault() {
        test4createinstanceImplementationDefaultArg1 = new CreateinstanceRequest();
        test4createinstanceImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4createinstanceImplementationInitializedArguments() {
        test4createinstanceImplementationInitializedArgumentsArg1 = new CreateinstanceRequest();
        test4createinstanceImplementationInitializedArgumentsArg1.setExpenseCurrencycreateinstancepatrCurrencyName("");
        test4createinstanceImplementationInitializedArgumentsArg1.setExpenseCurrencycreateinstancepatrCurrencyCode("");
        test4createinstanceImplementationInitializedArgumentsArg1.setExpenseCurrencycreateinstancepatrCurAcronym("");
        test4createinstanceImplementationInitializedArgumentsArg1.setExpenseCurrencycreateinstancepatrExchange(Double.valueOf(0));
        test4createinstanceImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceDefault() {
        test4deleteinstanceDefaultArg1 = new DeleteinstanceRequest();
    }

    private static void setUpMockData4test4deleteinstanceInitializedArguments() {
        test4deleteinstanceInitializedArgumentsArg1 = new DeleteinstanceRequest();
        test4deleteinstanceInitializedArgumentsArg1.setExpenseCurrencydeleteinstancepthisExpenseCurrency(new ExpenseCurrencyOid(""));
        test4deleteinstanceInitializedArgumentsArg1.setExpenseCurrencydeleteinstancepthisExpenseCurrencyInstance(new ExpenseCurrency(test4deleteinstanceInitializedArgumentsArg1.getExpenseCurrencydeleteinstancepthisExpenseCurrency()));
    }

    private static void setUpMockData4test4deleteinstanceTxnDefault() {
        test4deleteinstanceTxnDefaultArg1 = new DeleteinstanceRequest();
        test4deleteinstanceTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceTxnInitializedArguments() {
        test4deleteinstanceTxnInitializedArgumentsArg1 = new DeleteinstanceRequest();
        test4deleteinstanceTxnInitializedArgumentsArg1.setExpenseCurrencydeleteinstancepthisExpenseCurrency(new ExpenseCurrencyOid(""));
        test4deleteinstanceTxnInitializedArgumentsArg1.setExpenseCurrencydeleteinstancepthisExpenseCurrencyInstance(new ExpenseCurrency(test4deleteinstanceTxnInitializedArgumentsArg1.getExpenseCurrencydeleteinstancepthisExpenseCurrency()));
        test4deleteinstanceTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceImplementationDefault() {
        test4deleteinstanceImplementationDefaultArg1 = new DeleteinstanceRequest();
        test4deleteinstanceImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceImplementationInitializedArguments() {
        test4deleteinstanceImplementationInitializedArgumentsArg1 = new DeleteinstanceRequest();
        test4deleteinstanceImplementationInitializedArgumentsArg1.setExpenseCurrencydeleteinstancepthisExpenseCurrency(new ExpenseCurrencyOid(""));
        test4deleteinstanceImplementationInitializedArgumentsArg1.setExpenseCurrencydeleteinstancepthisExpenseCurrencyInstance(new ExpenseCurrency(test4deleteinstanceImplementationInitializedArgumentsArg1.getExpenseCurrencydeleteinstancepthisExpenseCurrency()));
        test4deleteinstanceImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceDefault() {
        test4editinstanceDefaultArg1 = new EditinstanceRequest();
    }

    private static void setUpMockData4test4editinstanceInitializedArguments() {
        test4editinstanceInitializedArgumentsArg1 = new EditinstanceRequest();
        test4editinstanceInitializedArgumentsArg1.setExpenseCurrencyeditinstancepthisExpenseCurrency(new ExpenseCurrencyOid(""));
        test4editinstanceInitializedArgumentsArg1.setExpenseCurrencyeditinstancepthisExpenseCurrencyInstance(new ExpenseCurrency(test4editinstanceInitializedArgumentsArg1.getExpenseCurrencyeditinstancepthisExpenseCurrency()));
        test4editinstanceInitializedArgumentsArg1.setExpenseCurrencyeditinstancepCurrencyName("");
        test4editinstanceInitializedArgumentsArg1.setExpenseCurrencyeditinstancepCurAcronym("");
        test4editinstanceInitializedArgumentsArg1.setExpenseCurrencyeditinstancepExchange(Double.valueOf(0));
    }

    private static void setUpMockData4test4editinstanceTxnDefault() {
        test4editinstanceTxnDefaultArg1 = new EditinstanceRequest();
        test4editinstanceTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceTxnInitializedArguments() {
        test4editinstanceTxnInitializedArgumentsArg1 = new EditinstanceRequest();
        test4editinstanceTxnInitializedArgumentsArg1.setExpenseCurrencyeditinstancepthisExpenseCurrency(new ExpenseCurrencyOid(""));
        test4editinstanceTxnInitializedArgumentsArg1.setExpenseCurrencyeditinstancepthisExpenseCurrencyInstance(new ExpenseCurrency(test4editinstanceTxnInitializedArgumentsArg1.getExpenseCurrencyeditinstancepthisExpenseCurrency()));
        test4editinstanceTxnInitializedArgumentsArg1.setExpenseCurrencyeditinstancepCurrencyName("");
        test4editinstanceTxnInitializedArgumentsArg1.setExpenseCurrencyeditinstancepCurAcronym("");
        test4editinstanceTxnInitializedArgumentsArg1.setExpenseCurrencyeditinstancepExchange(Double.valueOf(0));
        test4editinstanceTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceImplementationDefault() {
        test4editinstanceImplementationDefaultArg1 = new EditinstanceRequest();
        test4editinstanceImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceImplementationInitializedArguments() {
        test4editinstanceImplementationInitializedArgumentsArg1 = new EditinstanceRequest();
        test4editinstanceImplementationInitializedArgumentsArg1.setExpenseCurrencyeditinstancepthisExpenseCurrency(new ExpenseCurrencyOid(""));
        test4editinstanceImplementationInitializedArgumentsArg1.setExpenseCurrencyeditinstancepthisExpenseCurrencyInstance(new ExpenseCurrency(test4editinstanceImplementationInitializedArgumentsArg1.getExpenseCurrencyeditinstancepthisExpenseCurrency()));
        test4editinstanceImplementationInitializedArgumentsArg1.setExpenseCurrencyeditinstancepCurrencyName("");
        test4editinstanceImplementationInitializedArgumentsArg1.setExpenseCurrencyeditinstancepCurAcronym("");
        test4editinstanceImplementationInitializedArgumentsArg1.setExpenseCurrencyeditinstancepExchange(Double.valueOf(0));
        test4editinstanceImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4resetExchangeDefault() {
        test4resetExchangeDefaultArg1 = new ResetExchangeRequest();
    }

    private static void setUpMockData4test4resetExchangeInitializedArguments() {
        test4resetExchangeInitializedArgumentsArg1 = new ResetExchangeRequest();
        test4resetExchangeInitializedArgumentsArg1.setExpenseCurrencyresetExchangepthisExpenseCurrency(new ExpenseCurrencyOid(""));
        test4resetExchangeInitializedArgumentsArg1.setExpenseCurrencyresetExchangepthisExpenseCurrencyInstance(new ExpenseCurrency(test4resetExchangeInitializedArgumentsArg1.getExpenseCurrencyresetExchangepthisExpenseCurrency()));
    }

    private static void setUpMockData4test4resetExchangeTxnDefault() {
        test4resetExchangeTxnDefaultArg1 = new ResetExchangeRequest();
        test4resetExchangeTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4resetExchangeTxnInitializedArguments() {
        test4resetExchangeTxnInitializedArgumentsArg1 = new ResetExchangeRequest();
        test4resetExchangeTxnInitializedArgumentsArg1.setExpenseCurrencyresetExchangepthisExpenseCurrency(new ExpenseCurrencyOid(""));
        test4resetExchangeTxnInitializedArgumentsArg1.setExpenseCurrencyresetExchangepthisExpenseCurrencyInstance(new ExpenseCurrency(test4resetExchangeTxnInitializedArgumentsArg1.getExpenseCurrencyresetExchangepthisExpenseCurrency()));
        test4resetExchangeTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4resetExchangeImplementationDefault() {
        test4resetExchangeImplementationDefaultArg1 = new ResetExchangeRequest();
        test4resetExchangeImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4resetExchangeImplementationInitializedArguments() {
        test4resetExchangeImplementationInitializedArgumentsArg1 = new ResetExchangeRequest();
        test4resetExchangeImplementationInitializedArgumentsArg1.setExpenseCurrencyresetExchangepthisExpenseCurrency(new ExpenseCurrencyOid(""));
        test4resetExchangeImplementationInitializedArgumentsArg1.setExpenseCurrencyresetExchangepthisExpenseCurrencyInstance(new ExpenseCurrency(test4resetExchangeImplementationInitializedArgumentsArg1.getExpenseCurrencyresetExchangepthisExpenseCurrency()));
        test4resetExchangeImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editExchangeDefault() {
        test4editExchangeDefaultArg1 = new EditExchangeRequest();
    }

    private static void setUpMockData4test4editExchangeInitializedArguments() {
        test4editExchangeInitializedArgumentsArg1 = new EditExchangeRequest();
        test4editExchangeInitializedArgumentsArg1.setExpenseCurrencyeditExchangepthisExpenseCurrency(new ExpenseCurrencyOid(""));
        test4editExchangeInitializedArgumentsArg1.setExpenseCurrencyeditExchangepthisExpenseCurrencyInstance(new ExpenseCurrency(test4editExchangeInitializedArgumentsArg1.getExpenseCurrencyeditExchangepthisExpenseCurrency()));
        test4editExchangeInitializedArgumentsArg1.setExpenseCurrencyeditExchangepExchange(Double.valueOf(0));
    }

    private static void setUpMockData4test4editExchangeTxnDefault() {
        test4editExchangeTxnDefaultArg1 = new EditExchangeRequest();
        test4editExchangeTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editExchangeTxnInitializedArguments() {
        test4editExchangeTxnInitializedArgumentsArg1 = new EditExchangeRequest();
        test4editExchangeTxnInitializedArgumentsArg1.setExpenseCurrencyeditExchangepthisExpenseCurrency(new ExpenseCurrencyOid(""));
        test4editExchangeTxnInitializedArgumentsArg1.setExpenseCurrencyeditExchangepthisExpenseCurrencyInstance(new ExpenseCurrency(test4editExchangeTxnInitializedArgumentsArg1.getExpenseCurrencyeditExchangepthisExpenseCurrency()));
        test4editExchangeTxnInitializedArgumentsArg1.setExpenseCurrencyeditExchangepExchange(Double.valueOf(0));
        test4editExchangeTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editExchangeImplementationDefault() {
        test4editExchangeImplementationDefaultArg1 = new EditExchangeRequest();
        test4editExchangeImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editExchangeImplementationInitializedArguments() {
        test4editExchangeImplementationInitializedArgumentsArg1 = new EditExchangeRequest();
        test4editExchangeImplementationInitializedArgumentsArg1.setExpenseCurrencyeditExchangepthisExpenseCurrency(new ExpenseCurrencyOid(""));
        test4editExchangeImplementationInitializedArgumentsArg1.setExpenseCurrencyeditExchangepthisExpenseCurrencyInstance(new ExpenseCurrency(test4editExchangeImplementationInitializedArgumentsArg1.getExpenseCurrencyeditExchangepthisExpenseCurrency()));
        test4editExchangeImplementationInitializedArgumentsArg1.setExpenseCurrencyeditExchangepExchange(Double.valueOf(0));
        test4editExchangeImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4tNEWDefault() {
        test4tNEWDefaultArg1 = new TNEWRequest();
    }

    private static void setUpMockData4test4tNEWInitializedArguments() {
        test4tNEWInitializedArgumentsArg1 = new TNEWRequest();
        test4tNEWInitializedArgumentsArg1.setExpenseCurrencyTNEWpCurrencyName("");
        test4tNEWInitializedArgumentsArg1.setExpenseCurrencyTNEWpCurrencyCode("");
        test4tNEWInitializedArgumentsArg1.setExpenseCurrencyTNEWpCurAcronym("");
        test4tNEWInitializedArgumentsArg1.setExpenseCurrencyTNEWpExchange(Double.valueOf(0));
    }

    private static void setUpMockData4test4tNEWTxnDefault() {
        test4tNEWTxnDefaultArg1 = new TNEWRequest();
        test4tNEWTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4tNEWTxnInitializedArguments() {
        test4tNEWTxnInitializedArgumentsArg1 = new TNEWRequest();
        test4tNEWTxnInitializedArgumentsArg1.setExpenseCurrencyTNEWpCurrencyName("");
        test4tNEWTxnInitializedArgumentsArg1.setExpenseCurrencyTNEWpCurrencyCode("");
        test4tNEWTxnInitializedArgumentsArg1.setExpenseCurrencyTNEWpCurAcronym("");
        test4tNEWTxnInitializedArgumentsArg1.setExpenseCurrencyTNEWpExchange(Double.valueOf(0));
        test4tNEWTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4tNEWImplementationDefault() {
        test4tNEWImplementationDefaultArg1 = new TNEWRequest();
        test4tNEWImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4tNEWImplementationInitializedArguments() {
        test4tNEWImplementationInitializedArgumentsArg1 = new TNEWRequest();
        test4tNEWImplementationInitializedArgumentsArg1.setExpenseCurrencyTNEWpCurrencyName("");
        test4tNEWImplementationInitializedArgumentsArg1.setExpenseCurrencyTNEWpCurrencyCode("");
        test4tNEWImplementationInitializedArgumentsArg1.setExpenseCurrencyTNEWpCurAcronym("");
        test4tNEWImplementationInitializedArgumentsArg1.setExpenseCurrencyTNEWpExchange(Double.valueOf(0));
        test4tNEWImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4tEDITEXCHANGEDefault() {
        test4tEDITEXCHANGEDefaultArg1 = new TEDITEXCHANGERequest();
    }

    private static void setUpMockData4test4tEDITEXCHANGEInitializedArguments() {
        test4tEDITEXCHANGEInitializedArgumentsArg1 = new TEDITEXCHANGERequest();
        test4tEDITEXCHANGEInitializedArgumentsArg1.setExpenseCurrencyTEDITEXCHANGEpthisExpenseCurrency(new ExpenseCurrencyOid(""));
        test4tEDITEXCHANGEInitializedArgumentsArg1.setExpenseCurrencyTEDITEXCHANGEpthisExpenseCurrencyInstance(new ExpenseCurrency(test4tEDITEXCHANGEInitializedArgumentsArg1.getExpenseCurrencyTEDITEXCHANGEpthisExpenseCurrency()));
        test4tEDITEXCHANGEInitializedArgumentsArg1.setExpenseCurrencyTEDITEXCHANGEpExchange(Double.valueOf(0));
    }

    private static void setUpMockData4test4tEDITEXCHANGETxnDefault() {
        test4tEDITEXCHANGETxnDefaultArg1 = new TEDITEXCHANGERequest();
        test4tEDITEXCHANGETxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4tEDITEXCHANGETxnInitializedArguments() {
        test4tEDITEXCHANGETxnInitializedArgumentsArg1 = new TEDITEXCHANGERequest();
        test4tEDITEXCHANGETxnInitializedArgumentsArg1.setExpenseCurrencyTEDITEXCHANGEpthisExpenseCurrency(new ExpenseCurrencyOid(""));
        test4tEDITEXCHANGETxnInitializedArgumentsArg1.setExpenseCurrencyTEDITEXCHANGEpthisExpenseCurrencyInstance(new ExpenseCurrency(test4tEDITEXCHANGETxnInitializedArgumentsArg1.getExpenseCurrencyTEDITEXCHANGEpthisExpenseCurrency()));
        test4tEDITEXCHANGETxnInitializedArgumentsArg1.setExpenseCurrencyTEDITEXCHANGEpExchange(Double.valueOf(0));
        test4tEDITEXCHANGETxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4tEDITEXCHANGEImplementationDefault() {
        test4tEDITEXCHANGEImplementationDefaultArg1 = new TEDITEXCHANGERequest();
        test4tEDITEXCHANGEImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4tEDITEXCHANGEImplementationInitializedArguments() {
        test4tEDITEXCHANGEImplementationInitializedArgumentsArg1 = new TEDITEXCHANGERequest();
        test4tEDITEXCHANGEImplementationInitializedArgumentsArg1.setExpenseCurrencyTEDITEXCHANGEpthisExpenseCurrency(new ExpenseCurrencyOid(""));
        test4tEDITEXCHANGEImplementationInitializedArgumentsArg1.setExpenseCurrencyTEDITEXCHANGEpthisExpenseCurrencyInstance(new ExpenseCurrency(test4tEDITEXCHANGEImplementationInitializedArgumentsArg1.getExpenseCurrencyTEDITEXCHANGEpthisExpenseCurrency()));
        test4tEDITEXCHANGEImplementationInitializedArgumentsArg1.setExpenseCurrencyTEDITEXCHANGEpExchange(Double.valueOf(0));
        test4tEDITEXCHANGEImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(instanceExpenseCurrencyService, "expenseCurrencySrv", instanceExpenseCurrencyService);

        when(mockExpenseCurrencyService.getByOIDWithHV(test4deleteinstanceInitializedArgumentsArg1.getExpenseCurrencydeleteinstancepthisExpenseCurrency())).thenReturn(test4deleteinstanceInitializedArgumentsArg1.getExpenseCurrencydeleteinstancepthisExpenseCurrencyInstance());

        when(mockExpenseCurrencyService.getByOIDWithHV(test4deleteinstanceTxnInitializedArgumentsArg1.getExpenseCurrencydeleteinstancepthisExpenseCurrency())).thenReturn(test4deleteinstanceTxnInitializedArgumentsArg1.getExpenseCurrencydeleteinstancepthisExpenseCurrencyInstance());

        when(mockExpenseCurrencyService.getByOIDWithHV(test4editinstanceInitializedArgumentsArg1.getExpenseCurrencyeditinstancepthisExpenseCurrency())).thenReturn(test4editinstanceInitializedArgumentsArg1.getExpenseCurrencyeditinstancepthisExpenseCurrencyInstance());

        when(mockExpenseCurrencyService.getByOIDWithHV(test4editinstanceTxnInitializedArgumentsArg1.getExpenseCurrencyeditinstancepthisExpenseCurrency())).thenReturn(test4editinstanceTxnInitializedArgumentsArg1.getExpenseCurrencyeditinstancepthisExpenseCurrencyInstance());

        when(mockExpenseCurrencyService.getByOIDWithHV(test4resetExchangeInitializedArgumentsArg1.getExpenseCurrencyresetExchangepthisExpenseCurrency())).thenReturn(test4resetExchangeInitializedArgumentsArg1.getExpenseCurrencyresetExchangepthisExpenseCurrencyInstance());

        when(mockExpenseCurrencyService.getByOIDWithHV(test4resetExchangeTxnInitializedArgumentsArg1.getExpenseCurrencyresetExchangepthisExpenseCurrency())).thenReturn(test4resetExchangeTxnInitializedArgumentsArg1.getExpenseCurrencyresetExchangepthisExpenseCurrencyInstance());

        when(mockExpenseCurrencyService.getByOIDWithHV(test4editExchangeInitializedArgumentsArg1.getExpenseCurrencyeditExchangepthisExpenseCurrency())).thenReturn(test4editExchangeInitializedArgumentsArg1.getExpenseCurrencyeditExchangepthisExpenseCurrencyInstance());

        when(mockExpenseCurrencyService.getByOIDWithHV(test4editExchangeTxnInitializedArgumentsArg1.getExpenseCurrencyeditExchangepthisExpenseCurrency())).thenReturn(test4editExchangeTxnInitializedArgumentsArg1.getExpenseCurrencyeditExchangepthisExpenseCurrencyInstance());

        when(mockExpenseCurrencyService.getByOIDWithHV(test4tEDITEXCHANGEInitializedArgumentsArg1.getExpenseCurrencyTEDITEXCHANGEpthisExpenseCurrency())).thenReturn(test4tEDITEXCHANGEInitializedArgumentsArg1.getExpenseCurrencyTEDITEXCHANGEpthisExpenseCurrencyInstance());

        when(mockExpenseCurrencyService.getByOIDWithHV(test4tEDITEXCHANGETxnInitializedArgumentsArg1.getExpenseCurrencyTEDITEXCHANGEpthisExpenseCurrency())).thenReturn(test4tEDITEXCHANGETxnInitializedArgumentsArg1.getExpenseCurrencyTEDITEXCHANGEpthisExpenseCurrencyInstance());

        when(mockRepository.findById(mockexpenseCurrencyCurrencyCode)).thenAnswer(new Answer<Optional<ExpenseCurrency>>(){
        	public Optional<ExpenseCurrency> answer(InvocationOnMock invocation) {
        		if (invocation.getArgument(0).equals(mockexpenseCurrencyCurrencyCode)) {
        			return mockExpenseCurrency;
                }
        		return Optional.empty();
        	}
        });
        when(mockRepository.save(any(ExpenseCurrency.class))).thenReturn(mockInstance1);
        when(mockRepository.solveQuery(any(SQLSelect.class))).thenReturn(mockPopulation);
        when(mockRepository.solveQuery(any(SQLSelect.class), anyInt(), anyInt())).thenReturn(mockPopulation);
    }
    
    @After
    public void tearDown() {
        instanceExpenseCurrencyService = null;
    }

    @Test
    public void test4solveQuery() {
        assertEquals(test4solveQueryResult, instanceExpenseCurrencyService.solveQuery(test4solveQueryArg1));
    }

    @Test
    public void test4get() {
        assertEquals(test4getResult, instanceExpenseCurrencyService.get());
    }

    @Test
    public void test4getQueryRequest() {
        assertEquals(test4getQueryRequestResult, instanceExpenseCurrencyService.get(test4getQueryRequestArg1));
    }

    @Test
    public void test4getDynamicPopulation() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationResult), getResult(TOTALITEMS, instanceExpenseCurrencyService.getDynamic(test4getDynamicPopulationArg1)));
    }

    @Test
    public void test4getDynamicPopulationByOrderCriteriaOCExpenseCurrency() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationByOrderCriteriaOCExpenseCurrencyResult), getResult(TOTALITEMS, instanceExpenseCurrencyService.getDynamic(test4getDynamicPopulationByOrderCriteriaOCExpenseCurrencyArg1)));
    }

    @Test
    public void test4getDynamicPopulationFilterByOID() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationFilterByOIDResult), getResult(TOTALITEMS, instanceExpenseCurrencyService.getDynamic(test4getDynamicPopulationFilterByOIDArg1)));
    }

    @Test
    public void test4getDynamicPreload4DSExpenseCurrency() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPreload4DSExpenseCurrencyResult), getResult(TOTALITEMS, instanceExpenseCurrencyService.getDynamic(test4getDynamicPreload4DSExpenseCurrencyArg1)));
    }

    @Test
    public void test4getDynamicPreload4DSExpenseCurrencySup() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPreload4DSExpenseCurrencySupResult), getResult(TOTALITEMS, instanceExpenseCurrencyService.getDynamic(test4getDynamicPreload4DSExpenseCurrencySupArg1)));
    }

    @Test
    public void test4getByRelatedDynamic() {
        assertEquals(getResult(RESULTS_SIZE, test4getByRelatedDynamicResult), getResult(RESULTS_SIZE, instanceExpenseCurrencyService.getByRelatedDynamic(test4getByRelatedDynamicArg1, test4getByRelatedDynamicArg2, test4getByRelatedDynamicArg3)));
    }

    @Test
    public void test4getById() {
        assertEquals(test4getByIdResult, instanceExpenseCurrencyService.getById(test4getByIdArg1));
    }

    @Test
    public void test4getByRelated() {
        assertEquals(test4getByRelatedResult, instanceExpenseCurrencyService.getByRelated(test4getByRelatedArg1, test4getByRelatedArg2));
    }

    @Test
    public void test4getInstancesByRelated() {
        assertEquals(test4getInstancesByRelatedResult, instanceExpenseCurrencyService.getInstancesByRelated(test4getInstancesByRelatedArg1, test4getInstancesByRelatedArg2));
    }

    @Test
    public void test4getExpenseCurrencyDynamic() {
        assertEquals(test4getExpenseCurrencyDynamicResult.getResultCode(), instanceExpenseCurrencyService.getExpenseCurrencyDynamic(test4getExpenseCurrencyDynamicArg1, test4getExpenseCurrencyDynamicArg2).getResultCode());
    }

    @Test
    public void test4getSuppInfoWithoutInstance() {
        assertEquals(test4getSuppInfoWithoutInstanceResult, instanceExpenseCurrencyService.getSuppInfo(test4getSuppInfoWithoutInstanceArg1, test4getSuppInfoWithoutInstanceArg2));
    }

    @Test
    public void test4getSuppInfoWithInstance() {
        instanceExpenseCurrencyService.getSuppInfo(test4getSuppInfoWithInstanceArg1, test4getSuppInfoWithInstanceArg2);
        assertNotNull(instanceExpenseCurrencyService);
    }

    @Test
    public void test4getSuppInfoWithDSDSExpenseCurrencySup() {
        instanceExpenseCurrencyService.getSuppInfo(test4getSuppInfoWithDSDSExpenseCurrencySupArg1, test4getSuppInfoWithDSDSExpenseCurrencySupArg2);
        assertNotNull(instanceExpenseCurrencyService);
    }

    @Test
    public void test4buildRelatedInstance4RoleExpenseReportsWithoutRemainingPath() {
        instanceExpenseCurrencyService.buildRelatedInstance(test4buildRelatedInstance4RoleExpenseReportsWithoutRemainingPathArg1, test4buildRelatedInstance4RoleExpenseReportsWithoutRemainingPathArg2, test4buildRelatedInstance4RoleExpenseReportsWithoutRemainingPathArg3);
        assertNotNull(instanceExpenseCurrencyService);
    }

    @Test
    public void test4buildRelatedInstance4RoleExpenseReportsWithRemainingPath() {
        instanceExpenseCurrencyService.buildRelatedInstance(test4buildRelatedInstance4RoleExpenseReportsWithRemainingPathArg1, test4buildRelatedInstance4RoleExpenseReportsWithRemainingPathArg2, test4buildRelatedInstance4RoleExpenseReportsWithRemainingPathArg3);
        assertNotNull(instanceExpenseCurrencyService);
    }

    @Test
    public void test4buildRelatedInstance4RoleExchangeHistoryItemsWithoutRemainingPath() {
        instanceExpenseCurrencyService.buildRelatedInstance(test4buildRelatedInstance4RoleExchangeHistoryItemsWithoutRemainingPathArg1, test4buildRelatedInstance4RoleExchangeHistoryItemsWithoutRemainingPathArg2, test4buildRelatedInstance4RoleExchangeHistoryItemsWithoutRemainingPathArg3);
        assertNotNull(instanceExpenseCurrencyService);
    }

    @Test
    public void test4buildRelatedInstance4RoleExchangeHistoryItemsWithRemainingPath() {
        instanceExpenseCurrencyService.buildRelatedInstance(test4buildRelatedInstance4RoleExchangeHistoryItemsWithRemainingPathArg1, test4buildRelatedInstance4RoleExchangeHistoryItemsWithRemainingPathArg2, test4buildRelatedInstance4RoleExchangeHistoryItemsWithRemainingPathArg3);
        assertNotNull(instanceExpenseCurrencyService);
    }

    @Test
    public void test4getDSExpenseCurrency() {
        assertEquals(test4getDSExpenseCurrencyResult.getClass(), instanceExpenseCurrencyService.getDSExpenseCurrency(test4getDSExpenseCurrencyArg1, test4getDSExpenseCurrencyArg2, test4getDSExpenseCurrencyArg3).getClass());
    }

    @Test
    public void test4getPreloadDSExpenseCurrency() {
        instanceExpenseCurrencyService.getPreload(test4getPreloadDSExpenseCurrencyArg1);
        assertNotNull(instanceExpenseCurrencyService);
    }

    @Test
    public void test4getDSExpenseCurrencySup() {
        assertEquals(test4getDSExpenseCurrencySupResult.getClass(), instanceExpenseCurrencyService.getDSExpenseCurrencySup(test4getDSExpenseCurrencySupArg1, test4getDSExpenseCurrencySupArg2, test4getDSExpenseCurrencySupArg3).getClass());
    }

    @Test
    public void test4getPreloadDSExpenseCurrencySup() {
        instanceExpenseCurrencyService.getPreload(test4getPreloadDSExpenseCurrencySupArg1);
        assertNotNull(instanceExpenseCurrencyService);
    }

    @Test
    public void test4iIUExpenseCurrency() {
        assertEquals(test4iIUExpenseCurrencyResult.getDSExpenseCurrencyCurrencyCode(), instanceExpenseCurrencyService.iIUExpenseCurrency(test4iIUExpenseCurrencyArg1).getDSExpenseCurrencyCurrencyCode());
    }

    @Test
    public void test4piuPIUExpenseCurrency() {
        instanceExpenseCurrencyService.piuPIUExpenseCurrency(test4piuPIUExpenseCurrencyArg1);
        assertNotNull(instanceExpenseCurrencyService);
    }

    @Test
    public void test4getCount4PIUExpenseCurrency() {
        instanceExpenseCurrencyService.getCount4PIUExpenseCurrency(test4getCount4PIUExpenseCurrencyArg1);
        assertNotNull(instanceExpenseCurrencyService);
    }

    @Test
    public void test4createinstanceDefault() {
        instanceExpenseCurrencyService.createinstance(test4createinstanceDefaultArg1);
        assertNotNull(instanceExpenseCurrencyService);
    }

    @Test
    public void test4createinstanceInitializedArguments() {
        instanceExpenseCurrencyService.createinstance(test4createinstanceInitializedArgumentsArg1);
        assertNotNull(instanceExpenseCurrencyService);
    }

    @Test
    public void test4createinstanceTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseCurrencyService.createinstanceTxn(test4createinstanceTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4createinstanceTxnDefaultResult;
        }
        assertEquals(test4createinstanceTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4createinstanceTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseCurrencyService.createinstanceTxn(test4createinstanceTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4createinstanceTxnInitializedArgumentsResult;
        }
        assertEquals(test4createinstanceTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4createinstanceImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseCurrencyService.createinstanceImplementation(test4createinstanceImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4createinstanceImplementationDefaultResult;
        }
        assertEquals(test4createinstanceImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4createinstanceImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseCurrencyService.createinstanceImplementation(test4createinstanceImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4createinstanceImplementationInitializedArgumentsResult;
        }
        assertEquals(test4createinstanceImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceDefault() {
        instanceExpenseCurrencyService.deleteinstance(test4deleteinstanceDefaultArg1);
        assertNotNull(instanceExpenseCurrencyService);
    }

    @Test
    public void test4deleteinstanceInitializedArguments() {
        instanceExpenseCurrencyService.deleteinstance(test4deleteinstanceInitializedArgumentsArg1);
        assertNotNull(instanceExpenseCurrencyService);
    }

    @Test
    public void test4deleteinstanceTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseCurrencyService.deleteinstanceTxn(test4deleteinstanceTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4deleteinstanceTxnDefaultResult;
        }
        assertEquals(test4deleteinstanceTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseCurrencyService.deleteinstanceTxn(test4deleteinstanceTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4deleteinstanceTxnInitializedArgumentsResult;
        }
        assertEquals(test4deleteinstanceTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseCurrencyService.deleteinstanceImplementation(test4deleteinstanceImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4deleteinstanceImplementationDefaultResult;
        }
        assertEquals(test4deleteinstanceImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseCurrencyService.deleteinstanceImplementation(test4deleteinstanceImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4deleteinstanceImplementationInitializedArgumentsResult;
        }
        assertEquals(test4deleteinstanceImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceDefault() {
        instanceExpenseCurrencyService.editinstance(test4editinstanceDefaultArg1);
        assertNotNull(instanceExpenseCurrencyService);
    }

    @Test
    public void test4editinstanceInitializedArguments() {
        instanceExpenseCurrencyService.editinstance(test4editinstanceInitializedArgumentsArg1);
        assertNotNull(instanceExpenseCurrencyService);
    }

    @Test
    public void test4editinstanceTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseCurrencyService.editinstanceTxn(test4editinstanceTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4editinstanceTxnDefaultResult;
        }
        assertEquals(test4editinstanceTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseCurrencyService.editinstanceTxn(test4editinstanceTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editinstanceTxnInitializedArgumentsResult;
        }
        assertEquals(test4editinstanceTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseCurrencyService.editinstanceImplementation(test4editinstanceImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4editinstanceImplementationDefaultResult;
        }
        assertEquals(test4editinstanceImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseCurrencyService.editinstanceImplementation(test4editinstanceImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editinstanceImplementationInitializedArgumentsResult;
        }
        assertEquals(test4editinstanceImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4resetExchangeDefault() {
        instanceExpenseCurrencyService.resetExchange(test4resetExchangeDefaultArg1);
        assertNotNull(instanceExpenseCurrencyService);
    }

    @Test
    public void test4resetExchangeInitializedArguments() {
        instanceExpenseCurrencyService.resetExchange(test4resetExchangeInitializedArgumentsArg1);
        assertNotNull(instanceExpenseCurrencyService);
    }

    @Test
    public void test4resetExchangeTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseCurrencyService.resetExchangeTxn(test4resetExchangeTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4resetExchangeTxnDefaultResult;
        }
        assertEquals(test4resetExchangeTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4resetExchangeTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseCurrencyService.resetExchangeTxn(test4resetExchangeTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4resetExchangeTxnInitializedArgumentsResult;
        }
        assertEquals(test4resetExchangeTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4resetExchangeImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseCurrencyService.resetExchangeImplementation(test4resetExchangeImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4resetExchangeImplementationDefaultResult;
        }
        assertEquals(test4resetExchangeImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4resetExchangeImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseCurrencyService.resetExchangeImplementation(test4resetExchangeImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4resetExchangeImplementationInitializedArgumentsResult;
        }
        assertEquals(test4resetExchangeImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editExchangeDefault() {
        instanceExpenseCurrencyService.editExchange(test4editExchangeDefaultArg1);
        assertNotNull(instanceExpenseCurrencyService);
    }

    @Test
    public void test4editExchangeInitializedArguments() {
        instanceExpenseCurrencyService.editExchange(test4editExchangeInitializedArgumentsArg1);
        assertNotNull(instanceExpenseCurrencyService);
    }

    @Test
    public void test4editExchangeTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseCurrencyService.editExchangeTxn(test4editExchangeTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4editExchangeTxnDefaultResult;
        }
        assertEquals(test4editExchangeTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editExchangeTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseCurrencyService.editExchangeTxn(test4editExchangeTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editExchangeTxnInitializedArgumentsResult;
        }
        assertEquals(test4editExchangeTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editExchangeImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseCurrencyService.editExchangeImplementation(test4editExchangeImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4editExchangeImplementationDefaultResult;
        }
        assertEquals(test4editExchangeImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editExchangeImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseCurrencyService.editExchangeImplementation(test4editExchangeImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editExchangeImplementationInitializedArgumentsResult;
        }
        assertEquals(test4editExchangeImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tNEWDefault() {
        instanceExpenseCurrencyService.tNEW(test4tNEWDefaultArg1);
        assertNotNull(instanceExpenseCurrencyService);
    }

    @Test
    public void test4tNEWInitializedArguments() {
        instanceExpenseCurrencyService.tNEW(test4tNEWInitializedArgumentsArg1);
        assertNotNull(instanceExpenseCurrencyService);
    }

    @Test
    public void test4tNEWTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseCurrencyService.tNEWTxn(test4tNEWTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4tNEWTxnDefaultResult;
        }
        assertEquals(test4tNEWTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tNEWTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseCurrencyService.tNEWTxn(test4tNEWTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4tNEWTxnInitializedArgumentsResult;
        }
        assertEquals(test4tNEWTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tNEWImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseCurrencyService.tNEWImplementation(test4tNEWImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4tNEWImplementationDefaultResult;
        }
        assertEquals(test4tNEWImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tNEWImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseCurrencyService.tNEWImplementation(test4tNEWImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4tNEWImplementationInitializedArgumentsResult;
        }
        assertEquals(test4tNEWImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tEDITEXCHANGEDefault() {
        instanceExpenseCurrencyService.tEDITEXCHANGE(test4tEDITEXCHANGEDefaultArg1);
        assertNotNull(instanceExpenseCurrencyService);
    }

    @Test
    public void test4tEDITEXCHANGEInitializedArguments() {
        instanceExpenseCurrencyService.tEDITEXCHANGE(test4tEDITEXCHANGEInitializedArgumentsArg1);
        assertNotNull(instanceExpenseCurrencyService);
    }

    @Test
    public void test4tEDITEXCHANGETxnDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseCurrencyService.tEDITEXCHANGETxn(test4tEDITEXCHANGETxnDefaultArg1);
        } catch (ModelException e) {
            result = test4tEDITEXCHANGETxnDefaultResult;
        }
        assertEquals(test4tEDITEXCHANGETxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tEDITEXCHANGETxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseCurrencyService.tEDITEXCHANGETxn(test4tEDITEXCHANGETxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4tEDITEXCHANGETxnInitializedArgumentsResult;
        }
        assertEquals(test4tEDITEXCHANGETxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tEDITEXCHANGEImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceExpenseCurrencyService.tEDITEXCHANGEImplementation(test4tEDITEXCHANGEImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4tEDITEXCHANGEImplementationDefaultResult;
        }
        assertEquals(test4tEDITEXCHANGEImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4tEDITEXCHANGEImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExpenseCurrencyService.tEDITEXCHANGEImplementation(test4tEDITEXCHANGEImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4tEDITEXCHANGEImplementationInitializedArgumentsResult;
        }
        assertEquals(test4tEDITEXCHANGEImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }
}
