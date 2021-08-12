package com.integranova.spring.expensereportdemo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.exception.ModelException;
import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.ExchangeHistoryConstants;
import com.integranova.spring.expensereportdemo.persistence.ExchangeHistory;
import com.integranova.spring.expensereportdemo.persistence.ExpenseCurrency;
import com.integranova.spring.expensereportdemo.persistence.oid.ExchangeHistoryOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseCurrencyOid;
import com.integranova.spring.expensereportdemo.repository.ExchangeHistoryJpaRepository;
import com.integranova.spring.expensereportdemo.sqlutils.SQLSelect;
import com.integranova.spring.expensereportdemo.viewmodel.exchangehistory.siu.CreateinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.exchangehistory.siu.DeleteinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.exchangehistory.siu.EditinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.FilterRequest;
import com.integranova.spring.expensereportdemo.viewmodel.FilterVariableRequest;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationResponseViewModel;
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
public class ExchangeHistoryServiceTest extends ClassTest {

    @InjectMocks
    private ExchangeHistoryService instanceExchangeHistoryService;
    
    @Mock
    private static ExchangeHistoryJpaRepository mockRepository;
    
    @Mock
    private static ExchangeHistoryService mockExchangeHistoryService;
    
    @Mock
    private static ExpenseCurrencyService mockExpenseCurrencyService;

    private static ExchangeHistory mockInstance1;
    
    private static ExchangeHistory mockInstance2;

    private static List<ExchangeHistory> mockPopulation;

    private static String mockexpenseCurrencyCurrencyCode;

    private static Date mockexchangeHistoryentryDate;

    private static ExchangeHistoryOid mockExchangeHistoryOid;

    private static Optional<ExchangeHistory> mockExchangeHistory; 

    // test4solveQuery
    private static QueryRequest test4solveQueryArg1;
    private static List<Map<String, Object>> test4solveQueryResult;

    // test4get
    private static List<ExchangeHistory> test4getResult;

    // test4getQueryRequest
    private static QueryRequest test4getQueryRequestArg1;
    private static List<ExchangeHistory> test4getQueryRequestResult;

    // test4getDynamicPopulation
    private static QueryRequest test4getDynamicPopulationArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationResult;

    // test4getDynamicPopulationFilterByOID
    private static QueryRequest test4getDynamicPopulationFilterByOIDArg1;
    private static PopulationResponseViewModel test4getDynamicPopulationFilterByOIDResult;

    // test4getByRelatedDynamic
    private static String test4getByRelatedDynamicArg1;
    private static String test4getByRelatedDynamicArg2;
    private static String test4getByRelatedDynamicArg3;
    private static PopulationResponseViewModel test4getByRelatedDynamicResult;

    // test4getById
    private static String test4getByIdArg1;
    private static Date test4getByIdArg2;
    private static ExchangeHistory test4getByIdResult;

    // test4getByRelated
    private static ExchangeHistory test4getByRelatedArg1;
    private static String test4getByRelatedArg2;
    private static List<ExchangeHistory> test4getByRelatedResult;

    // test4getInstancesByRelated
    private static ExchangeHistory test4getInstancesByRelatedArg1;
    private static String test4getInstancesByRelatedArg2;
    private static List<ExchangeHistory> test4getInstancesByRelatedResult;

    // test4getExchangeHistoryDynamic
    private static ExchangeHistoryOid test4getExchangeHistoryDynamicArg1;
    private static String test4getExchangeHistoryDynamicArg2;
    private static InstanceResponseViewModel test4getExchangeHistoryDynamicResult;

    // test4getSuppInfoWithoutInstance
    private static ExchangeHistoryOid test4getSuppInfoWithoutInstanceArg1;
    private static String test4getSuppInfoWithoutInstanceArg2;
    private static String test4getSuppInfoWithoutInstanceResult;

    // test4getSuppInfoWithInstance
    private static ExchangeHistoryOid test4getSuppInfoWithInstanceArg1;
    private static String test4getSuppInfoWithInstanceArg2;

    // test4buildRelatedInstance4RoleExpenseCurrencyWithoutRemainingPath
    private static String test4buildRelatedInstance4RoleExpenseCurrencyWithoutRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleExpenseCurrencyWithoutRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleExpenseCurrencyWithoutRemainingPathArg3;

    // test4buildRelatedInstance4RoleExpenseCurrencyWithRemainingPath
    private static String test4buildRelatedInstance4RoleExpenseCurrencyWithRemainingPathArg1;
    private static String test4buildRelatedInstance4RoleExpenseCurrencyWithRemainingPathArg2;
    private static String test4buildRelatedInstance4RoleExpenseCurrencyWithRemainingPathArg3;

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
        mockexpenseCurrencyCurrencyCode = "";
        mockexchangeHistoryentryDate = Date.valueOf(Constants.DATE_DEFAULTVALUE);
        mockInstance1 = new ExchangeHistory();
        mockInstance2 = new ExchangeHistory();
        mockPopulation = new ArrayList<>(Arrays.asList(mockInstance1, mockInstance2));
        mockExchangeHistoryOid = new ExchangeHistoryOid(mockexpenseCurrencyCurrencyCode, mockexchangeHistoryentryDate);
        mockExchangeHistory = Optional.of(new ExchangeHistory(new ExchangeHistoryOid(mockexpenseCurrencyCurrencyCode,mockexchangeHistoryentryDate)));
        setUpMockData4test4solveQuery();
        setUpMockData4test4get();
        setUpMockData4test4getQueryRequest();
        setUpMockData4test4getDynamicPopulation();
        setUpMockData4test4getDynamicPopulationFilterByOID();
        setUpMockData4test4getByRelatedDynamic();
        setUpMockData4test4getById();
        setUpMockData4test4getByRelated();
        setUpMockData4test4getInstancesByRelated();
        setUpMockData4test4getExchangeHistoryDynamic();
        setUpMockData4test4getSuppInfoWithoutInstance();
        setUpMockData4test4getSuppInfoWithInstance();
        setUpMockData4test4buildRelatedInstance4RoleExpenseCurrencyWithoutRemainingPath();
        setUpMockData4test4buildRelatedInstance4RoleExpenseCurrencyWithRemainingPath();
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
        test4getDynamicPopulationArg1.setDisplaySetItems("expenseCurrencyCurrencyCode");
        test4getDynamicPopulationResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getDynamicPopulationFilterByOID() {
        test4getDynamicPopulationFilterByOIDArg1 = new QueryRequest();
        test4getDynamicPopulationFilterByOIDArg1.setDisplaySetItems("expenseCurrencyCurrencyCode");
        test4getDynamicPopulationFilterByOIDArg1.addFilterRequest(new FilterRequest(Constants.FILTER_BY_OID,new ArrayList<>(Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_OID_FVAR_OID, new ExchangeHistoryOid("", Date.valueOf(Constants.DATE_DEFAULTVALUE)))))));
        test4getDynamicPopulationFilterByOIDResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getByRelatedDynamic() {
        test4getByRelatedDynamicArg1 = "";
        test4getByRelatedDynamicArg2 = "";
        test4getByRelatedDynamicArg3 = "";
        test4getByRelatedDynamicResult = new PopulationResponseViewModel(mockPopulation.stream().map(i -> AbstractService.buildDynamicObject(i, "")).collect(Collectors.toList()));
    }

    private static void setUpMockData4test4getById() {
        test4getByIdArg1 = "";
        test4getByIdArg2 = Date.valueOf(Constants.DATE_DEFAULTVALUE);
        test4getByIdResult = mockExchangeHistory.get();
    }

    private static void setUpMockData4test4getByRelated() {
        test4getByRelatedArg1 = new ExchangeHistory();
        test4getByRelatedArg2 = "";
        test4getByRelatedResult = mockPopulation;
    }

    private static void setUpMockData4test4getInstancesByRelated() {
        test4getInstancesByRelatedArg1 = new ExchangeHistory();
        test4getInstancesByRelatedArg2 = "";
        test4getInstancesByRelatedResult = mockPopulation;
    }

    private static void setUpMockData4test4getExchangeHistoryDynamic() {
        test4getExchangeHistoryDynamicArg1 = new ExchangeHistoryOid();
        test4getExchangeHistoryDynamicArg2 = "";
        test4getExchangeHistoryDynamicResult = new InstanceResponseViewModel();
    }

    private static void setUpMockData4test4getSuppInfoWithoutInstance() {
        test4getSuppInfoWithoutInstanceArg1 = new ExchangeHistoryOid();
        test4getSuppInfoWithoutInstanceArg2 = "";
        test4getSuppInfoWithoutInstanceResult = "";
    }

    private static void setUpMockData4test4getSuppInfoWithInstance() {
        test4getSuppInfoWithInstanceArg1 = new ExchangeHistoryOid("", Date.valueOf(Constants.DATE_DEFAULTVALUE));
        test4getSuppInfoWithInstanceArg2 = "";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleExpenseCurrencyWithoutRemainingPath() {
        test4buildRelatedInstance4RoleExpenseCurrencyWithoutRemainingPathArg1 = new ExpenseCurrencyOid("").toJson();
        test4buildRelatedInstance4RoleExpenseCurrencyWithoutRemainingPathArg2 = ExchangeHistoryConstants.ROLE_NAME_EXPENSECURRENCY;
        test4buildRelatedInstance4RoleExpenseCurrencyWithoutRemainingPathArg3 = "";
    }

    private static void setUpMockData4test4buildRelatedInstance4RoleExpenseCurrencyWithRemainingPath() {
        test4buildRelatedInstance4RoleExpenseCurrencyWithRemainingPathArg1 = new ExpenseCurrencyOid("").toJson();
        test4buildRelatedInstance4RoleExpenseCurrencyWithRemainingPathArg2 = ExchangeHistoryConstants.ROLE_NAME_EXPENSECURRENCY;
        test4buildRelatedInstance4RoleExpenseCurrencyWithRemainingPathArg3 = "dummy";
    }

    private static void setUpMockData4test4createinstanceDefault() {
        test4createinstanceDefaultArg1 = new CreateinstanceRequest();
    }

    private static void setUpMockData4test4createinstanceInitializedArguments() {
        test4createinstanceInitializedArgumentsArg1 = new CreateinstanceRequest();
        test4createinstanceInitializedArgumentsArg1.setExchangeHistorycreateinstancepagrExpenseCurrency(new ExpenseCurrencyOid(""));
        test4createinstanceInitializedArgumentsArg1.setExchangeHistorycreateinstancepagrExpenseCurrencyInstance(new ExpenseCurrency(test4createinstanceInitializedArgumentsArg1.getExchangeHistorycreateinstancepagrExpenseCurrency()));
        test4createinstanceInitializedArgumentsArg1.setExchangeHistorycreateinstancepatroldValue(Double.valueOf(0));
        test4createinstanceInitializedArgumentsArg1.setExchangeHistorycreateinstancepatrnewValue(Double.valueOf(0));
    }

    private static void setUpMockData4test4createinstanceTxnDefault() {
        test4createinstanceTxnDefaultArg1 = new CreateinstanceRequest();
        test4createinstanceTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4createinstanceTxnInitializedArguments() {
        test4createinstanceTxnInitializedArgumentsArg1 = new CreateinstanceRequest();
        test4createinstanceTxnInitializedArgumentsArg1.setExchangeHistorycreateinstancepagrExpenseCurrency(new ExpenseCurrencyOid(""));
        test4createinstanceTxnInitializedArgumentsArg1.setExchangeHistorycreateinstancepagrExpenseCurrencyInstance(new ExpenseCurrency(test4createinstanceTxnInitializedArgumentsArg1.getExchangeHistorycreateinstancepagrExpenseCurrency()));
        test4createinstanceTxnInitializedArgumentsArg1.setExchangeHistorycreateinstancepatroldValue(Double.valueOf(0));
        test4createinstanceTxnInitializedArgumentsArg1.setExchangeHistorycreateinstancepatrnewValue(Double.valueOf(0));
        test4createinstanceTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4createinstanceImplementationDefault() {
        test4createinstanceImplementationDefaultArg1 = new CreateinstanceRequest();
        test4createinstanceImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4createinstanceImplementationInitializedArguments() {
        test4createinstanceImplementationInitializedArgumentsArg1 = new CreateinstanceRequest();
        test4createinstanceImplementationInitializedArgumentsArg1.setExchangeHistorycreateinstancepagrExpenseCurrency(new ExpenseCurrencyOid(""));
        test4createinstanceImplementationInitializedArgumentsArg1.setExchangeHistorycreateinstancepagrExpenseCurrencyInstance(new ExpenseCurrency(test4createinstanceImplementationInitializedArgumentsArg1.getExchangeHistorycreateinstancepagrExpenseCurrency()));
        test4createinstanceImplementationInitializedArgumentsArg1.setExchangeHistorycreateinstancepatroldValue(Double.valueOf(0));
        test4createinstanceImplementationInitializedArgumentsArg1.setExchangeHistorycreateinstancepatrnewValue(Double.valueOf(0));
        test4createinstanceImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceDefault() {
        test4deleteinstanceDefaultArg1 = new DeleteinstanceRequest();
    }

    private static void setUpMockData4test4deleteinstanceInitializedArguments() {
        test4deleteinstanceInitializedArgumentsArg1 = new DeleteinstanceRequest();
        test4deleteinstanceInitializedArgumentsArg1.setExchangeHistorydeleteinstancepthisExchangeHistory(new ExchangeHistoryOid("", Date.valueOf(Constants.DATE_DEFAULTVALUE)));
        test4deleteinstanceInitializedArgumentsArg1.setExchangeHistorydeleteinstancepthisExchangeHistoryInstance(new ExchangeHistory(test4deleteinstanceInitializedArgumentsArg1.getExchangeHistorydeleteinstancepthisExchangeHistory()));
    }

    private static void setUpMockData4test4deleteinstanceTxnDefault() {
        test4deleteinstanceTxnDefaultArg1 = new DeleteinstanceRequest();
        test4deleteinstanceTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceTxnInitializedArguments() {
        test4deleteinstanceTxnInitializedArgumentsArg1 = new DeleteinstanceRequest();
        test4deleteinstanceTxnInitializedArgumentsArg1.setExchangeHistorydeleteinstancepthisExchangeHistory(new ExchangeHistoryOid("", Date.valueOf(Constants.DATE_DEFAULTVALUE)));
        test4deleteinstanceTxnInitializedArgumentsArg1.setExchangeHistorydeleteinstancepthisExchangeHistoryInstance(new ExchangeHistory(test4deleteinstanceTxnInitializedArgumentsArg1.getExchangeHistorydeleteinstancepthisExchangeHistory()));
        test4deleteinstanceTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceImplementationDefault() {
        test4deleteinstanceImplementationDefaultArg1 = new DeleteinstanceRequest();
        test4deleteinstanceImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4deleteinstanceImplementationInitializedArguments() {
        test4deleteinstanceImplementationInitializedArgumentsArg1 = new DeleteinstanceRequest();
        test4deleteinstanceImplementationInitializedArgumentsArg1.setExchangeHistorydeleteinstancepthisExchangeHistory(new ExchangeHistoryOid("", Date.valueOf(Constants.DATE_DEFAULTVALUE)));
        test4deleteinstanceImplementationInitializedArgumentsArg1.setExchangeHistorydeleteinstancepthisExchangeHistoryInstance(new ExchangeHistory(test4deleteinstanceImplementationInitializedArgumentsArg1.getExchangeHistorydeleteinstancepthisExchangeHistory()));
        test4deleteinstanceImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceDefault() {
        test4editinstanceDefaultArg1 = new EditinstanceRequest();
    }

    private static void setUpMockData4test4editinstanceInitializedArguments() {
        test4editinstanceInitializedArgumentsArg1 = new EditinstanceRequest();
        test4editinstanceInitializedArgumentsArg1.setExchangeHistoryeditinstancepthisExchangeHistory(new ExchangeHistoryOid("", Date.valueOf(Constants.DATE_DEFAULTVALUE)));
        test4editinstanceInitializedArgumentsArg1.setExchangeHistoryeditinstancepthisExchangeHistoryInstance(new ExchangeHistory(test4editinstanceInitializedArgumentsArg1.getExchangeHistoryeditinstancepthisExchangeHistory()));
        test4editinstanceInitializedArgumentsArg1.setExchangeHistoryeditinstancepoldValue(Double.valueOf(0));
        test4editinstanceInitializedArgumentsArg1.setExchangeHistoryeditinstancepnewValue(Double.valueOf(0));
    }

    private static void setUpMockData4test4editinstanceTxnDefault() {
        test4editinstanceTxnDefaultArg1 = new EditinstanceRequest();
        test4editinstanceTxnDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceTxnInitializedArguments() {
        test4editinstanceTxnInitializedArgumentsArg1 = new EditinstanceRequest();
        test4editinstanceTxnInitializedArgumentsArg1.setExchangeHistoryeditinstancepthisExchangeHistory(new ExchangeHistoryOid("", Date.valueOf(Constants.DATE_DEFAULTVALUE)));
        test4editinstanceTxnInitializedArgumentsArg1.setExchangeHistoryeditinstancepthisExchangeHistoryInstance(new ExchangeHistory(test4editinstanceTxnInitializedArgumentsArg1.getExchangeHistoryeditinstancepthisExchangeHistory()));
        test4editinstanceTxnInitializedArgumentsArg1.setExchangeHistoryeditinstancepoldValue(Double.valueOf(0));
        test4editinstanceTxnInitializedArgumentsArg1.setExchangeHistoryeditinstancepnewValue(Double.valueOf(0));
        test4editinstanceTxnInitializedArgumentsResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceImplementationDefault() {
        test4editinstanceImplementationDefaultArg1 = new EditinstanceRequest();
        test4editinstanceImplementationDefaultResult = new ServiceResponse();
    }

    private static void setUpMockData4test4editinstanceImplementationInitializedArguments() {
        test4editinstanceImplementationInitializedArgumentsArg1 = new EditinstanceRequest();
        test4editinstanceImplementationInitializedArgumentsArg1.setExchangeHistoryeditinstancepthisExchangeHistory(new ExchangeHistoryOid("", Date.valueOf(Constants.DATE_DEFAULTVALUE)));
        test4editinstanceImplementationInitializedArgumentsArg1.setExchangeHistoryeditinstancepthisExchangeHistoryInstance(new ExchangeHistory(test4editinstanceImplementationInitializedArgumentsArg1.getExchangeHistoryeditinstancepthisExchangeHistory()));
        test4editinstanceImplementationInitializedArgumentsArg1.setExchangeHistoryeditinstancepoldValue(Double.valueOf(0));
        test4editinstanceImplementationInitializedArgumentsArg1.setExchangeHistoryeditinstancepnewValue(Double.valueOf(0));
        test4editinstanceImplementationInitializedArgumentsResult = new ServiceResponse();
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ReflectionTestUtils.setField(instanceExchangeHistoryService, "exchangeHistorySrv", instanceExchangeHistoryService);

        when(mockExpenseCurrencyService.getByOIDWithHV(test4createinstanceInitializedArgumentsArg1.getExchangeHistorycreateinstancepagrExpenseCurrency())).thenReturn(test4createinstanceInitializedArgumentsArg1.getExchangeHistorycreateinstancepagrExpenseCurrencyInstance());

        when(mockExpenseCurrencyService.getByOIDWithHV(test4createinstanceTxnInitializedArgumentsArg1.getExchangeHistorycreateinstancepagrExpenseCurrency())).thenReturn(test4createinstanceTxnInitializedArgumentsArg1.getExchangeHistorycreateinstancepagrExpenseCurrencyInstance());

        when(mockExchangeHistoryService.getByOIDWithHV(test4deleteinstanceInitializedArgumentsArg1.getExchangeHistorydeleteinstancepthisExchangeHistory())).thenReturn(test4deleteinstanceInitializedArgumentsArg1.getExchangeHistorydeleteinstancepthisExchangeHistoryInstance());

        when(mockExchangeHistoryService.getByOIDWithHV(test4deleteinstanceTxnInitializedArgumentsArg1.getExchangeHistorydeleteinstancepthisExchangeHistory())).thenReturn(test4deleteinstanceTxnInitializedArgumentsArg1.getExchangeHistorydeleteinstancepthisExchangeHistoryInstance());

        when(mockExchangeHistoryService.getByOIDWithHV(test4editinstanceInitializedArgumentsArg1.getExchangeHistoryeditinstancepthisExchangeHistory())).thenReturn(test4editinstanceInitializedArgumentsArg1.getExchangeHistoryeditinstancepthisExchangeHistoryInstance());

        when(mockExchangeHistoryService.getByOIDWithHV(test4editinstanceTxnInitializedArgumentsArg1.getExchangeHistoryeditinstancepthisExchangeHistory())).thenReturn(test4editinstanceTxnInitializedArgumentsArg1.getExchangeHistoryeditinstancepthisExchangeHistoryInstance());

        when(mockRepository.findById(mockExchangeHistoryOid)).thenAnswer(new Answer<Optional<ExchangeHistory>>(){
        	public Optional<ExchangeHistory> answer(InvocationOnMock invocation) {
        		if (invocation.getArgument(0).equals(mockExchangeHistoryOid)) {
        			return mockExchangeHistory;
                }
        		return Optional.empty();
        	}
        });
        when(mockRepository.save(any(ExchangeHistory.class))).thenReturn(mockInstance1);
        when(mockRepository.solveQuery(any(SQLSelect.class))).thenReturn(mockPopulation);
        when(mockRepository.solveQuery(any(SQLSelect.class), anyInt(), anyInt())).thenReturn(mockPopulation);
    }
    
    @After
    public void tearDown() {
        instanceExchangeHistoryService = null;
    }

    @Test
    public void test4solveQuery() {
        assertEquals(test4solveQueryResult, instanceExchangeHistoryService.solveQuery(test4solveQueryArg1));
    }

    @Test
    public void test4get() {
        assertEquals(test4getResult, instanceExchangeHistoryService.get());
    }

    @Test
    public void test4getQueryRequest() {
        assertEquals(test4getQueryRequestResult, instanceExchangeHistoryService.get(test4getQueryRequestArg1));
    }

    @Test
    public void test4getDynamicPopulation() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationResult), getResult(TOTALITEMS, instanceExchangeHistoryService.getDynamic(test4getDynamicPopulationArg1)));
    }

    @Test
    public void test4getDynamicPopulationFilterByOID() {
        assertEquals(getResult(TOTALITEMS, test4getDynamicPopulationFilterByOIDResult), getResult(TOTALITEMS, instanceExchangeHistoryService.getDynamic(test4getDynamicPopulationFilterByOIDArg1)));
    }

    @Test
    public void test4getByRelatedDynamic() {
        assertEquals(getResult(RESULTS_SIZE, test4getByRelatedDynamicResult), getResult(RESULTS_SIZE, instanceExchangeHistoryService.getByRelatedDynamic(test4getByRelatedDynamicArg1, test4getByRelatedDynamicArg2, test4getByRelatedDynamicArg3)));
    }

    @Test
    public void test4getById() {
        assertEquals(test4getByIdResult, instanceExchangeHistoryService.getById(test4getByIdArg1, test4getByIdArg2));
    }

    @Test
    public void test4getByRelated() {
        assertEquals(test4getByRelatedResult, instanceExchangeHistoryService.getByRelated(test4getByRelatedArg1, test4getByRelatedArg2));
    }

    @Test
    public void test4getInstancesByRelated() {
        assertEquals(test4getInstancesByRelatedResult, instanceExchangeHistoryService.getInstancesByRelated(test4getInstancesByRelatedArg1, test4getInstancesByRelatedArg2));
    }

    @Test
    public void test4getExchangeHistoryDynamic() {
        assertEquals(test4getExchangeHistoryDynamicResult.getResultCode(), instanceExchangeHistoryService.getExchangeHistoryDynamic(test4getExchangeHistoryDynamicArg1, test4getExchangeHistoryDynamicArg2).getResultCode());
    }

    @Test
    public void test4getSuppInfoWithoutInstance() {
        assertEquals(test4getSuppInfoWithoutInstanceResult, instanceExchangeHistoryService.getSuppInfo(test4getSuppInfoWithoutInstanceArg1, test4getSuppInfoWithoutInstanceArg2));
    }

    @Test
    public void test4getSuppInfoWithInstance() {
        instanceExchangeHistoryService.getSuppInfo(test4getSuppInfoWithInstanceArg1, test4getSuppInfoWithInstanceArg2);
        assertNotNull(instanceExchangeHistoryService);
    }

    @Test
    public void test4buildRelatedInstance4RoleExpenseCurrencyWithoutRemainingPath() {
        instanceExchangeHistoryService.buildRelatedInstance(test4buildRelatedInstance4RoleExpenseCurrencyWithoutRemainingPathArg1, test4buildRelatedInstance4RoleExpenseCurrencyWithoutRemainingPathArg2, test4buildRelatedInstance4RoleExpenseCurrencyWithoutRemainingPathArg3);
        assertNotNull(instanceExchangeHistoryService);
    }

    @Test
    public void test4buildRelatedInstance4RoleExpenseCurrencyWithRemainingPath() {
        instanceExchangeHistoryService.buildRelatedInstance(test4buildRelatedInstance4RoleExpenseCurrencyWithRemainingPathArg1, test4buildRelatedInstance4RoleExpenseCurrencyWithRemainingPathArg2, test4buildRelatedInstance4RoleExpenseCurrencyWithRemainingPathArg3);
        assertNotNull(instanceExchangeHistoryService);
    }

    @Test
    public void test4createinstanceDefault() {
        instanceExchangeHistoryService.createinstance(test4createinstanceDefaultArg1);
        assertNotNull(instanceExchangeHistoryService);
    }

    @Test
    public void test4createinstanceInitializedArguments() {
        instanceExchangeHistoryService.createinstance(test4createinstanceInitializedArgumentsArg1);
        assertNotNull(instanceExchangeHistoryService);
    }

    @Test
    public void test4createinstanceTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceExchangeHistoryService.createinstanceTxn(test4createinstanceTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4createinstanceTxnDefaultResult;
        }
        assertEquals(test4createinstanceTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4createinstanceTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExchangeHistoryService.createinstanceTxn(test4createinstanceTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4createinstanceTxnInitializedArgumentsResult;
        }
        assertEquals(test4createinstanceTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4createinstanceImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceExchangeHistoryService.createinstanceImplementation(test4createinstanceImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4createinstanceImplementationDefaultResult;
        }
        assertEquals(test4createinstanceImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4createinstanceImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExchangeHistoryService.createinstanceImplementation(test4createinstanceImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4createinstanceImplementationInitializedArgumentsResult;
        }
        assertEquals(test4createinstanceImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceDefault() {
        instanceExchangeHistoryService.deleteinstance(test4deleteinstanceDefaultArg1);
        assertNotNull(instanceExchangeHistoryService);
    }

    @Test
    public void test4deleteinstanceInitializedArguments() {
        instanceExchangeHistoryService.deleteinstance(test4deleteinstanceInitializedArgumentsArg1);
        assertNotNull(instanceExchangeHistoryService);
    }

    @Test
    public void test4deleteinstanceTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceExchangeHistoryService.deleteinstanceTxn(test4deleteinstanceTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4deleteinstanceTxnDefaultResult;
        }
        assertEquals(test4deleteinstanceTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExchangeHistoryService.deleteinstanceTxn(test4deleteinstanceTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4deleteinstanceTxnInitializedArgumentsResult;
        }
        assertEquals(test4deleteinstanceTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceExchangeHistoryService.deleteinstanceImplementation(test4deleteinstanceImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4deleteinstanceImplementationDefaultResult;
        }
        assertEquals(test4deleteinstanceImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4deleteinstanceImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExchangeHistoryService.deleteinstanceImplementation(test4deleteinstanceImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4deleteinstanceImplementationInitializedArgumentsResult;
        }
        assertEquals(test4deleteinstanceImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceDefault() {
        instanceExchangeHistoryService.editinstance(test4editinstanceDefaultArg1);
        assertNotNull(instanceExchangeHistoryService);
    }

    @Test
    public void test4editinstanceInitializedArguments() {
        instanceExchangeHistoryService.editinstance(test4editinstanceInitializedArgumentsArg1);
        assertNotNull(instanceExchangeHistoryService);
    }

    @Test
    public void test4editinstanceTxnDefault() {
        ServiceResponse result;
        try {
            result = instanceExchangeHistoryService.editinstanceTxn(test4editinstanceTxnDefaultArg1);
        } catch (ModelException e) {
            result = test4editinstanceTxnDefaultResult;
        }
        assertEquals(test4editinstanceTxnDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceTxnInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExchangeHistoryService.editinstanceTxn(test4editinstanceTxnInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editinstanceTxnInitializedArgumentsResult;
        }
        assertEquals(test4editinstanceTxnInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceImplementationDefault() {
        ServiceResponse result;
        try {
            result = instanceExchangeHistoryService.editinstanceImplementation(test4editinstanceImplementationDefaultArg1);
        } catch (ModelException e) {
            result = test4editinstanceImplementationDefaultResult;
        }
        assertEquals(test4editinstanceImplementationDefaultResult.getResultCode(), result.getResultCode());
    }

    @Test
    public void test4editinstanceImplementationInitializedArguments() {
        ServiceResponse result;
        try {
            result = instanceExchangeHistoryService.editinstanceImplementation(test4editinstanceImplementationInitializedArgumentsArg1);
        } catch (Exception e) {
            result = test4editinstanceImplementationInitializedArgumentsResult;
        }
        assertEquals(test4editinstanceImplementationInitializedArgumentsResult.getResultCode(), result.getResultCode());
    }
}
