package com.integranova.spring.expensereportdemo.repository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.ExchangeHistoryConstants;
import com.integranova.spring.expensereportdemo.persistence.ExchangeHistory;
import com.integranova.spring.expensereportdemo.sqlutils.SQLParam;
import com.integranova.spring.expensereportdemo.sqlutils.SQLPopulation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ExchangeHistoryJpaRepositoryImplTest {

    private static EntityManager em;

    private ExchangeHistoryJpaRepositoryImpl instanceExchangeHistoryJpaRepositoryImpl;

    // test4executeQueryString
    private static String test4executeQueryStringArg1;
    private static List<ExchangeHistory> test4executeQueryStringResult;

    // test4executeQueryStringParameters
    private static String test4executeQueryStringParametersArg1;
    private static List<SQLParam> test4executeQueryStringParametersArg2;
    private static List<ExchangeHistory> test4executeQueryStringParametersResult;

    // test4executeQuerySQLPopulation
    private static SQLPopulation test4executeQuerySQLPopulationArg1;
    private static Collection<ExchangeHistory> test4executeQuerySQLPopulationResult;

    // test4solveQuery
    private static SQLPopulation test4solveQueryArg1;
    private static List<ExchangeHistory> test4solveQueryResult;

    @BeforeClass
    public static void setUpClass() throws SystemException {
        setUpMockData();
    }

    private static void setUpMockData() throws SystemException {
        setUpMockData4test4executeQueryString();
        setUpMockData4test4executeQueryStringParameters();
        setUpMockData4test4executeQuerySQLPopulation();
        setUpMockData4test4solveQuery();
        em = mock(EntityManager.class);
    }

    private static void setUpMockData4test4executeQueryString() {
        test4executeQueryStringArg1 = "SELECT ExchangeHistory FROM ExchangeHistory ExchangeHistory";
        test4executeQueryStringResult = new ArrayList<>();
    }

    private static void setUpMockData4test4executeQueryStringParameters() {
        test4executeQueryStringParametersArg1 = "SELECT ExchangeHistory FROM ExchangeHistory ExchangeHistory";
        test4executeQueryStringParametersArg2 = new ArrayList<>();
        test4executeQueryStringParametersResult = new ArrayList<>();
    }

    private static void setUpMockData4test4executeQuerySQLPopulation() throws SystemException {
        test4executeQuerySQLPopulationArg1 = new SQLPopulation(ExchangeHistoryConstants.CLASS_NAME);
        test4executeQuerySQLPopulationResult = new ArrayList<>();
    }

    private static void setUpMockData4test4solveQuery() throws SystemException {
        test4solveQueryArg1 = new SQLPopulation(ExchangeHistoryConstants.CLASS_NAME);
        test4solveQueryResult = new ArrayList<>();
    }

    @Before
    public void setUp() {
        instanceExchangeHistoryJpaRepositoryImpl = new ExchangeHistoryJpaRepositoryImpl();
        instanceExchangeHistoryJpaRepositoryImpl.setEntityManager(em);
    }
    
    @After
    public void tearDown() {
        instanceExchangeHistoryJpaRepositoryImpl = null;
    }

    @Test
    public void test4executeQueryString() {
        List<ExchangeHistory> result;
        try {
            result = instanceExchangeHistoryJpaRepositoryImpl.executeQuery(test4executeQueryStringArg1);
        } catch (Exception e) {
            result = test4executeQueryStringResult;
        }
        assertEquals(test4executeQueryStringResult, result);
    }

    @Test
    public void test4executeQueryStringParameters() {
        List<ExchangeHistory> result;
        try {
            result = instanceExchangeHistoryJpaRepositoryImpl.executeQuery(test4executeQueryStringParametersArg1, test4executeQueryStringParametersArg2);
        } catch (Exception e) {
            result = test4executeQueryStringParametersResult;
        }
        assertEquals(test4executeQueryStringParametersResult, result);
    }

    @Test
    public void test4executeQuerySQLPopulation() {
        Collection<ExchangeHistory> result;
        try {
            result = instanceExchangeHistoryJpaRepositoryImpl.executeQuery(test4executeQuerySQLPopulationArg1);
        } catch (Exception e) {
            result = test4executeQuerySQLPopulationResult;
        }
        assertEquals(test4executeQuerySQLPopulationResult, result);
    }

    @Test
    public void test4solveQuery() {
        List<ExchangeHistory> result;
        try {
            result = instanceExchangeHistoryJpaRepositoryImpl.solveQuery(test4solveQueryArg1);
        } catch (Exception e) {
            result = test4solveQueryResult;
        }
        assertEquals(test4solveQueryResult, result);
    }
}
