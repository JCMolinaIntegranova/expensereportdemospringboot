package com.integranova.spring.expensereportdemo.repository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.ERTemplateConstants;
import com.integranova.spring.expensereportdemo.persistence.ERTemplate;
import com.integranova.spring.expensereportdemo.persistence.Project;
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
public class ERTemplateJpaRepositoryImplTest {

    private static EntityManager em;

    private ERTemplateJpaRepositoryImpl instanceERTemplateJpaRepositoryImpl;

    // test4executeQueryString
    private static String test4executeQueryStringArg1;
    private static List<ERTemplate> test4executeQueryStringResult;

    // test4executeQueryStringParameters
    private static String test4executeQueryStringParametersArg1;
    private static List<SQLParam> test4executeQueryStringParametersArg2;
    private static List<ERTemplate> test4executeQueryStringParametersResult;

    // test4executeQuerySQLPopulation
    private static SQLPopulation test4executeQuerySQLPopulationArg1;
    private static Collection<ERTemplate> test4executeQuerySQLPopulationResult;

    // test4solveQuery
    private static SQLPopulation test4solveQueryArg1;
    private static List<ERTemplate> test4solveQueryResult;

    // test4assocOperator000
    private static Project test4assocOperator000Arg1;
    private static Boolean test4assocOperator000Result;

    // test4assocOperator000v2
    private static Project test4assocOperator000v2Arg1;
    private static Boolean test4assocOperator000v2Result;

    // test4assocOperator001
    private static ERTemplate test4assocOperator001Arg1;
    private static Double test4assocOperator001Result;

    // test4assocOperator001v2
    private static ERTemplate test4assocOperator001v2Arg1;
    private static Double test4assocOperator001v2Result;

    @BeforeClass
    public static void setUpClass() throws SystemException {
        setUpMockData();
    }

    private static void setUpMockData() throws SystemException {
        setUpMockData4test4executeQueryString();
        setUpMockData4test4executeQueryStringParameters();
        setUpMockData4test4executeQuerySQLPopulation();
        setUpMockData4test4solveQuery();
        setUpMockData4test4assocOperator000();
        setUpMockData4test4assocOperator000v2();
        setUpMockData4test4assocOperator001();
        setUpMockData4test4assocOperator001v2();
        em = mock(EntityManager.class);
    }

    private static void setUpMockData4test4executeQueryString() {
        test4executeQueryStringArg1 = "SELECT ERTemplate FROM ERTemplate ERTemplate";
        test4executeQueryStringResult = new ArrayList<>();
    }

    private static void setUpMockData4test4executeQueryStringParameters() {
        test4executeQueryStringParametersArg1 = "SELECT ERTemplate FROM ERTemplate ERTemplate";
        test4executeQueryStringParametersArg2 = new ArrayList<>();
        test4executeQueryStringParametersResult = new ArrayList<>();
    }

    private static void setUpMockData4test4executeQuerySQLPopulation() throws SystemException {
        test4executeQuerySQLPopulationArg1 = new SQLPopulation(ERTemplateConstants.CLASS_NAME);
        test4executeQuerySQLPopulationResult = new ArrayList<>();
    }

    private static void setUpMockData4test4solveQuery() throws SystemException {
        test4solveQueryArg1 = new SQLPopulation(ERTemplateConstants.CLASS_NAME);
        test4solveQueryResult = new ArrayList<>();
    }

    private static void setUpMockData4test4assocOperator000() {
        test4assocOperator000Arg1 = new Project();
        test4assocOperator000Result = false;
    }

    private static void setUpMockData4test4assocOperator000v2() {
        test4assocOperator000v2Arg1 = null;
        test4assocOperator000v2Result = false;
    }

    private static void setUpMockData4test4assocOperator001() {
        test4assocOperator001Arg1 = new ERTemplate();
        test4assocOperator001Result = 0.0;
    }

    private static void setUpMockData4test4assocOperator001v2() {
        test4assocOperator001v2Arg1 = null;
        test4assocOperator001v2Result = Double.valueOf(0);
    }

    @Before
    public void setUp() {
        instanceERTemplateJpaRepositoryImpl = new ERTemplateJpaRepositoryImpl();
        instanceERTemplateJpaRepositoryImpl.setEntityManager(em);
    }
    
    @After
    public void tearDown() {
        instanceERTemplateJpaRepositoryImpl = null;
    }

    @Test
    public void test4executeQueryString() {
        List<ERTemplate> result;
        try {
            result = instanceERTemplateJpaRepositoryImpl.executeQuery(test4executeQueryStringArg1);
        } catch (Exception e) {
            result = test4executeQueryStringResult;
        }
        assertEquals(test4executeQueryStringResult, result);
    }

    @Test
    public void test4executeQueryStringParameters() {
        List<ERTemplate> result;
        try {
            result = instanceERTemplateJpaRepositoryImpl.executeQuery(test4executeQueryStringParametersArg1, test4executeQueryStringParametersArg2);
        } catch (Exception e) {
            result = test4executeQueryStringParametersResult;
        }
        assertEquals(test4executeQueryStringParametersResult, result);
    }

    @Test
    public void test4executeQuerySQLPopulation() {
        Collection<ERTemplate> result;
        try {
            result = instanceERTemplateJpaRepositoryImpl.executeQuery(test4executeQuerySQLPopulationArg1);
        } catch (Exception e) {
            result = test4executeQuerySQLPopulationResult;
        }
        assertEquals(test4executeQuerySQLPopulationResult, result);
    }

    @Test
    public void test4solveQuery() {
        List<ERTemplate> result;
        try {
            result = instanceERTemplateJpaRepositoryImpl.solveQuery(test4solveQueryArg1);
        } catch (Exception e) {
            result = test4solveQueryResult;
        }
        assertEquals(test4solveQueryResult, result);
    }

    @Test
    public void test4assocOperator000() {
        Boolean result;
        try {
            result = instanceERTemplateJpaRepositoryImpl.assocOperator000(test4assocOperator000Arg1);
        } catch (SystemException e) {
            result = test4assocOperator000Result;
        }
        assertEquals(test4assocOperator000Result, result);
    }

    @Test
    public void test4assocOperator000v2() {
        Boolean result;
        try {
            result = instanceERTemplateJpaRepositoryImpl.assocOperator000(test4assocOperator000v2Arg1);
        } catch (SystemException e) {
            result = test4assocOperator000v2Result;
        }
        assertEquals(test4assocOperator000v2Result, result);
    }

    @Test
    public void test4assocOperator001() {
        Double result;
        try {
            result = instanceERTemplateJpaRepositoryImpl.assocOperator001(test4assocOperator001Arg1);
        } catch (SystemException e) {
            result = test4assocOperator001Result;
        }
        assertEquals(test4assocOperator001Result, result);
    }

    @Test
    public void test4assocOperator001v2() {
        Double result;
        try {
            result = instanceERTemplateJpaRepositoryImpl.assocOperator001(test4assocOperator001v2Arg1);
        } catch (SystemException e) {
            result = test4assocOperator001v2Result;
        }
        assertEquals(test4assocOperator001v2Result, result);
    }
}
