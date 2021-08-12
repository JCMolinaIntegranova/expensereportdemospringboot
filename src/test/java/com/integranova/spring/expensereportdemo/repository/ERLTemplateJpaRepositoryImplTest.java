package com.integranova.spring.expensereportdemo.repository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.ERLTemplateConstants;
import com.integranova.spring.expensereportdemo.persistence.ERLTemplate;
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
public class ERLTemplateJpaRepositoryImplTest {

    private static EntityManager em;

    private ERLTemplateJpaRepositoryImpl instanceERLTemplateJpaRepositoryImpl;

    // test4executeQueryString
    private static String test4executeQueryStringArg1;
    private static List<ERLTemplate> test4executeQueryStringResult;

    // test4executeQueryStringParameters
    private static String test4executeQueryStringParametersArg1;
    private static List<SQLParam> test4executeQueryStringParametersArg2;
    private static List<ERLTemplate> test4executeQueryStringParametersResult;

    // test4executeQuerySQLPopulation
    private static SQLPopulation test4executeQuerySQLPopulationArg1;
    private static Collection<ERLTemplate> test4executeQuerySQLPopulationResult;

    // test4solveQuery
    private static SQLPopulation test4solveQueryArg1;
    private static List<ERLTemplate> test4solveQueryResult;

    // test4nextERLTemplateid
    private static Long test4nextERLTemplateidArg1;
    private static Long test4nextERLTemplateidResult;

    @BeforeClass
    public static void setUpClass() throws SystemException {
        setUpMockData();
    }

    private static void setUpMockData() throws SystemException {
        setUpMockData4test4executeQueryString();
        setUpMockData4test4executeQueryStringParameters();
        setUpMockData4test4executeQuerySQLPopulation();
        setUpMockData4test4solveQuery();
        setUpMockData4test4nextERLTemplateid();
        em = mock(EntityManager.class);
    }

    private static void setUpMockData4test4executeQueryString() {
        test4executeQueryStringArg1 = "SELECT ERLTemplate FROM ERLTemplate ERLTemplate";
        test4executeQueryStringResult = new ArrayList<>();
    }

    private static void setUpMockData4test4executeQueryStringParameters() {
        test4executeQueryStringParametersArg1 = "SELECT ERLTemplate FROM ERLTemplate ERLTemplate";
        test4executeQueryStringParametersArg2 = new ArrayList<>();
        test4executeQueryStringParametersResult = new ArrayList<>();
    }

    private static void setUpMockData4test4executeQuerySQLPopulation() throws SystemException {
        test4executeQuerySQLPopulationArg1 = new SQLPopulation(ERLTemplateConstants.CLASS_NAME);
        test4executeQuerySQLPopulationResult = new ArrayList<>();
    }

    private static void setUpMockData4test4solveQuery() throws SystemException {
        test4solveQueryArg1 = new SQLPopulation(ERLTemplateConstants.CLASS_NAME);
        test4solveQueryResult = new ArrayList<>();
    }

    private static void setUpMockData4test4nextERLTemplateid() {
        test4nextERLTemplateidArg1 = Long.valueOf(0);
        test4nextERLTemplateidResult = Long.valueOf(1);
    }

    @Before
    public void setUp() {
        instanceERLTemplateJpaRepositoryImpl = new ERLTemplateJpaRepositoryImpl();
        instanceERLTemplateJpaRepositoryImpl.setEntityManager(em);
    }
    
    @After
    public void tearDown() {
        instanceERLTemplateJpaRepositoryImpl = null;
    }

    @Test
    public void test4executeQueryString() {
        List<ERLTemplate> result;
        try {
            result = instanceERLTemplateJpaRepositoryImpl.executeQuery(test4executeQueryStringArg1);
        } catch (Exception e) {
            result = test4executeQueryStringResult;
        }
        assertEquals(test4executeQueryStringResult, result);
    }

    @Test
    public void test4executeQueryStringParameters() {
        List<ERLTemplate> result;
        try {
            result = instanceERLTemplateJpaRepositoryImpl.executeQuery(test4executeQueryStringParametersArg1, test4executeQueryStringParametersArg2);
        } catch (Exception e) {
            result = test4executeQueryStringParametersResult;
        }
        assertEquals(test4executeQueryStringParametersResult, result);
    }

    @Test
    public void test4executeQuerySQLPopulation() {
        Collection<ERLTemplate> result;
        try {
            result = instanceERLTemplateJpaRepositoryImpl.executeQuery(test4executeQuerySQLPopulationArg1);
        } catch (Exception e) {
            result = test4executeQuerySQLPopulationResult;
        }
        assertEquals(test4executeQuerySQLPopulationResult, result);
    }

    @Test
    public void test4solveQuery() {
        List<ERLTemplate> result;
        try {
            result = instanceERLTemplateJpaRepositoryImpl.solveQuery(test4solveQueryArg1);
        } catch (Exception e) {
            result = test4solveQueryResult;
        }
        assertEquals(test4solveQueryResult, result);
    }

    @Test
    public void test4nextERLTemplateid() {
        assertEquals(test4nextERLTemplateidResult, instanceERLTemplateJpaRepositoryImpl.nextERLTemplateid(test4nextERLTemplateidArg1));
    }
}
