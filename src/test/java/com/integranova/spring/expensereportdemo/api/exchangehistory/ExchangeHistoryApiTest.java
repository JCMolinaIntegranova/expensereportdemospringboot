package com.integranova.spring.expensereportdemo.api.exchangehistory;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.api.exchangehistory.ExchangeHistoryApi;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.persistence.ExchangeHistory;
import com.integranova.spring.expensereportdemo.persistence.ExpenseCurrency;
import com.integranova.spring.expensereportdemo.persistence.oid.ExchangeHistoryOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseCurrencyOid;
import com.integranova.spring.expensereportdemo.service.ExchangeHistoryService;
import com.integranova.spring.expensereportdemo.viewmodel.exchangehistory.siu.CreateinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.exchangehistory.siu.DeleteinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.exchangehistory.siu.EditinstanceRequest;
import com.integranova.spring.expensereportdemo.viewmodel.InstanceResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PopulationResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.PreloadResponseViewModel;
import com.integranova.spring.expensereportdemo.viewmodel.QueryRequest;
import com.integranova.spring.expensereportdemo.viewmodel.ServiceResponse;
import java.sql.Date;
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
public class ExchangeHistoryApiTest {

    @Mock
    private ExchangeHistoryService mockExchangeHistoryService;

    @InjectMocks
    private ExchangeHistoryApi instanceExchangeHistoryApi;

    // testGetExchangeHistory
    private static String testGetExchangeHistoryArg1;
    private static Date testGetExchangeHistoryArg2;
    private static ExchangeHistory testGetExchangeHistoryResult;

    // testGetExchangeHistoryDynamic
    private static QueryRequest testGetExchangeHistoryDynamicArg1;
    private static ExchangeHistoryOid mockGetExchangeHistoryDynamicArg1;
    private static String mockGetExchangeHistoryDynamicArg2;
    private static InstanceResponseViewModel testGetExchangeHistoryDynamicResult;

    // testGetExchangeHistoryWithDisplaySetDynamic
    private static QueryRequest testGetExchangeHistoryWithDisplaySetDynamicArg1;
    private static PreloadResponseViewModel testGetExchangeHistoryWithDisplaySetDynamicResult;

    // testGetExchangeHistoryPopulationDynamic
    private static QueryRequest testGetExchangeHistoryPopulationDynamicArg1;
    private static PopulationResponseViewModel testGetExchangeHistoryPopulationDynamicResult;

    // testGetExchangeHistoryByExpenseCurrency
    private static ExpenseCurrencyOid testGetExchangeHistoryByExpenseCurrencyArg1;
    private static List<ExchangeHistory> testGetExchangeHistoryByExpenseCurrencyResult;

    // testExchangeHistoryCreateinstance
    private static CreateinstanceRequest testExchangeHistoryCreateinstanceArg1;
    private static ServiceResponse testExchangeHistoryCreateinstanceResult;

    // testExchangeHistoryDeleteinstance
    private static DeleteinstanceRequest testExchangeHistoryDeleteinstanceArg1;
    private static ServiceResponse testExchangeHistoryDeleteinstanceResult;

    // testExchangeHistoryEditinstance
    private static EditinstanceRequest testExchangeHistoryEditinstanceArg1;
    private static ServiceResponse testExchangeHistoryEditinstanceResult;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testGetExchangeHistory();
        setUpMockData4testGetExchangeHistoryDynamic();
        setUpMockData4testGetExchangeHistoryWithDisplaySetDynamic();
        setUpMockData4testGetExchangeHistoryPopulationDynamic();
        setUpMockData4testGetExchangeHistoryByExpenseCurrency();
        setUpMockData4testExchangeHistoryCreateinstance();
        setUpMockData4testExchangeHistoryDeleteinstance();
        setUpMockData4testExchangeHistoryEditinstance();
    }

    private static void setUpMockData4testGetExchangeHistory() {
        testGetExchangeHistoryArg1 = "";
        testGetExchangeHistoryArg2 = Date.valueOf(Constants.DATE_DEFAULTVALUE);
        testGetExchangeHistoryResult = new ExchangeHistory();
    }

    private static void setUpMockData4testGetExchangeHistoryDynamic() {
        mockGetExchangeHistoryDynamicArg1 = new ExchangeHistoryOid();
        mockGetExchangeHistoryDynamicArg2 = "";
        testGetExchangeHistoryDynamicArg1 = new QueryRequest();
        testGetExchangeHistoryDynamicResult = new InstanceResponseViewModel();
    }

    private static void setUpMockData4testGetExchangeHistoryWithDisplaySetDynamic() {
        testGetExchangeHistoryWithDisplaySetDynamicArg1 = new QueryRequest();
        testGetExchangeHistoryWithDisplaySetDynamicArg1.setDisplaySetName("testGetExchangeHistoryWithDisplaySetDynamicArg1");
        testGetExchangeHistoryWithDisplaySetDynamicResult = new PreloadResponseViewModel();
    }

    private static void setUpMockData4testGetExchangeHistoryPopulationDynamic() {
        testGetExchangeHistoryPopulationDynamicArg1 = new QueryRequest();
        testGetExchangeHistoryPopulationDynamicArg1.setDisplaySetName("testGetExchangeHistoryPopulationDynamicArg1");
        testGetExchangeHistoryPopulationDynamicResult = new PopulationResponseViewModel();
    }

    private static void setUpMockData4testGetExchangeHistoryByExpenseCurrency() {
        testGetExchangeHistoryByExpenseCurrencyArg1 = new ExpenseCurrencyOid();
        testGetExchangeHistoryByExpenseCurrencyResult = new ArrayList<>();
    }

    private static void setUpMockData4testExchangeHistoryCreateinstance() {
        testExchangeHistoryCreateinstanceArg1 = new CreateinstanceRequest();
        testExchangeHistoryCreateinstanceResult = new ServiceResponse();
    }

    private static void setUpMockData4testExchangeHistoryDeleteinstance() {
        testExchangeHistoryDeleteinstanceArg1 = new DeleteinstanceRequest();
        testExchangeHistoryDeleteinstanceResult = new ServiceResponse();
    }

    private static void setUpMockData4testExchangeHistoryEditinstance() {
        testExchangeHistoryEditinstanceArg1 = new EditinstanceRequest();
        testExchangeHistoryEditinstanceResult = new ServiceResponse();
    }

    @Before
    public void setUp() {

        when(mockExchangeHistoryService.getById(testGetExchangeHistoryArg1, testGetExchangeHistoryArg2)).thenReturn(testGetExchangeHistoryResult);

        when(mockExchangeHistoryService.getExchangeHistoryDynamic(mockGetExchangeHistoryDynamicArg1, mockGetExchangeHistoryDynamicArg2)).thenReturn(testGetExchangeHistoryDynamicResult);

        when(mockExchangeHistoryService.getDynamic(testGetExchangeHistoryWithDisplaySetDynamicArg1)).thenReturn(testGetExchangeHistoryWithDisplaySetDynamicResult);

        when(mockExchangeHistoryService.getDynamic(testGetExchangeHistoryPopulationDynamicArg1)).thenReturn(testGetExchangeHistoryPopulationDynamicResult);

        when(mockExchangeHistoryService.getInstancesByRelated(any(ExpenseCurrency.class), eq("ExpenseCurrency"))).thenReturn(testGetExchangeHistoryByExpenseCurrencyResult);

        when(mockExchangeHistoryService.createinstance(testExchangeHistoryCreateinstanceArg1)).thenReturn(testExchangeHistoryCreateinstanceResult);

        when(mockExchangeHistoryService.deleteinstance(testExchangeHistoryDeleteinstanceArg1)).thenReturn(testExchangeHistoryDeleteinstanceResult);

        when(mockExchangeHistoryService.editinstance(testExchangeHistoryEditinstanceArg1)).thenReturn(testExchangeHistoryEditinstanceResult);
    }

    @Test
    public void testGetExchangeHistory() {
        assertEquals(testGetExchangeHistoryResult, instanceExchangeHistoryApi.getExchangeHistory(testGetExchangeHistoryArg1, testGetExchangeHistoryArg2));
    }

    @Test
    public void testGetExchangeHistoryDynamic() {
        assertEquals(testGetExchangeHistoryDynamicResult, instanceExchangeHistoryApi.getExchangeHistoryDynamic(testGetExchangeHistoryDynamicArg1));
    }

    @Test
    public void testGetExchangeHistoryWithDisplaySetDynamic() {
        assertEquals(testGetExchangeHistoryWithDisplaySetDynamicResult, instanceExchangeHistoryApi.getExchangeHistoryWithDisplaySetDynamic(testGetExchangeHistoryWithDisplaySetDynamicArg1));
    }

    @Test
    public void testGetExchangeHistoryPopulationDynamic() {
        assertEquals(testGetExchangeHistoryPopulationDynamicResult, instanceExchangeHistoryApi.getExchangeHistoryPopulationDynamic(testGetExchangeHistoryPopulationDynamicArg1));
    }

    @Test
    public void testGetExchangeHistoryByExpenseCurrency() {
        assertEquals(testGetExchangeHistoryByExpenseCurrencyResult, instanceExchangeHistoryApi.getExchangeHistoryByExpenseCurrency(testGetExchangeHistoryByExpenseCurrencyArg1));
    }

    @Test
    public void testExchangeHistoryCreateinstance() {
        assertEquals(testExchangeHistoryCreateinstanceResult, instanceExchangeHistoryApi.exchangeHistoryCreateinstance(testExchangeHistoryCreateinstanceArg1));
    }

    @Test
    public void testExchangeHistoryDeleteinstance() {
        assertEquals(testExchangeHistoryDeleteinstanceResult, instanceExchangeHistoryApi.exchangeHistoryDeleteinstance(testExchangeHistoryDeleteinstanceArg1));
    }

    @Test
    public void testExchangeHistoryEditinstance() {
        assertEquals(testExchangeHistoryEditinstanceResult, instanceExchangeHistoryApi.exchangeHistoryEditinstance(testExchangeHistoryEditinstanceArg1));
    }
}
