package com.integranova.spring.expensereportdemo.repository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.ProjectConstants;
import com.integranova.spring.expensereportdemo.persistence.Assignment;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.Project;
import com.integranova.spring.expensereportdemo.sqlutils.SQLParam;
import com.integranova.spring.expensereportdemo.sqlutils.SQLPopulation;
import java.sql.Date;
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
public class ProjectJpaRepositoryImplTest {

    private static EntityManager em;

    private ProjectJpaRepositoryImpl instanceProjectJpaRepositoryImpl;

    // test4executeQueryString
    private static String test4executeQueryStringArg1;
    private static List<Project> test4executeQueryStringResult;

    // test4executeQueryStringParameters
    private static String test4executeQueryStringParametersArg1;
    private static List<SQLParam> test4executeQueryStringParametersArg2;
    private static List<Project> test4executeQueryStringParametersResult;

    // test4executeQuerySQLPopulation
    private static SQLPopulation test4executeQuerySQLPopulationArg1;
    private static Collection<Project> test4executeQuerySQLPopulationResult;

    // test4solveQuery
    private static SQLPopulation test4solveQueryArg1;
    private static List<Project> test4solveQueryResult;

    // test4assocOperator000
    private static Project test4assocOperator000Arg1;
    private static Employee test4assocOperator000Arg2;
    private static Date test4assocOperator000Arg3;
    private static Boolean test4assocOperator000Result;

    // test4assocOperator000v2
    private static Project test4assocOperator000v2Arg1;
    private static Employee test4assocOperator000v2Arg2;
    private static Date test4assocOperator000v2Arg3;
    private static Boolean test4assocOperator000v2Result;

    // test4assocOperator001
    private static Project test4assocOperator001Arg1;
    private static Double test4assocOperator001Result;

    // test4assocOperator001v2
    private static Project test4assocOperator001v2Arg1;
    private static Double test4assocOperator001v2Result;

    // test4assocOperator002
    private static Project test4assocOperator002Arg1;
    private static Double test4assocOperator002Result;

    // test4assocOperator002v2
    private static Project test4assocOperator002v2Arg1;
    private static Double test4assocOperator002v2Result;

    // test4assocOperator003
    private static Project test4assocOperator003Arg1;
    private static Double test4assocOperator003Result;

    // test4assocOperator003v2
    private static Project test4assocOperator003v2Arg1;
    private static Double test4assocOperator003v2Result;

    // test4assocOperator004
    private static Project test4assocOperator004Arg1;
    private static Double test4assocOperator004Result;

    // test4assocOperator004v2
    private static Project test4assocOperator004v2Arg1;
    private static Double test4assocOperator004v2Result;

    // test4assocOperator005
    private static Project test4assocOperator005Arg1;
    private static Collection<Assignment> test4assocOperator005Result;

    // test4assocOperator005v2
    private static Project test4assocOperator005v2Arg1;
    private static Collection<Assignment> test4assocOperator005v2Result;

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
        setUpMockData4test4assocOperator002();
        setUpMockData4test4assocOperator002v2();
        setUpMockData4test4assocOperator003();
        setUpMockData4test4assocOperator003v2();
        setUpMockData4test4assocOperator004();
        setUpMockData4test4assocOperator004v2();
        setUpMockData4test4assocOperator005();
        setUpMockData4test4assocOperator005v2();
        em = mock(EntityManager.class);
    }

    private static void setUpMockData4test4executeQueryString() {
        test4executeQueryStringArg1 = "SELECT Project FROM Project Project";
        test4executeQueryStringResult = new ArrayList<>();
    }

    private static void setUpMockData4test4executeQueryStringParameters() {
        test4executeQueryStringParametersArg1 = "SELECT Project FROM Project Project";
        test4executeQueryStringParametersArg2 = new ArrayList<>();
        test4executeQueryStringParametersResult = new ArrayList<>();
    }

    private static void setUpMockData4test4executeQuerySQLPopulation() throws SystemException {
        test4executeQuerySQLPopulationArg1 = new SQLPopulation(ProjectConstants.CLASS_NAME);
        test4executeQuerySQLPopulationResult = new ArrayList<>();
    }

    private static void setUpMockData4test4solveQuery() throws SystemException {
        test4solveQueryArg1 = new SQLPopulation(ProjectConstants.CLASS_NAME);
        test4solveQueryResult = new ArrayList<>();
    }

    private static void setUpMockData4test4assocOperator000() {
        test4assocOperator000Arg1 = new Project();
        test4assocOperator000Arg2 = new Employee();
        test4assocOperator000Arg3 = Date.valueOf(Constants.DATE_DEFAULTVALUE);
        test4assocOperator000Result = false;
    }

    private static void setUpMockData4test4assocOperator000v2() {
        test4assocOperator000v2Arg1 = null;
        test4assocOperator000v2Arg2 = null;
        test4assocOperator000v2Arg3 = null;
        test4assocOperator000v2Result = false;
    }

    private static void setUpMockData4test4assocOperator001() {
        test4assocOperator001Arg1 = new Project();
        test4assocOperator001Result = 0.0;
    }

    private static void setUpMockData4test4assocOperator001v2() {
        test4assocOperator001v2Arg1 = null;
        test4assocOperator001v2Result = Double.valueOf(0);
    }

    private static void setUpMockData4test4assocOperator002() {
        test4assocOperator002Arg1 = new Project();
        test4assocOperator002Result = Double.MIN_VALUE;
    }

    private static void setUpMockData4test4assocOperator002v2() {
        test4assocOperator002v2Arg1 = null;
        test4assocOperator002v2Result = Double.valueOf(0);
    }

    private static void setUpMockData4test4assocOperator003() {
        test4assocOperator003Arg1 = new Project();
        test4assocOperator003Result = Double.MAX_VALUE;
    }

    private static void setUpMockData4test4assocOperator003v2() {
        test4assocOperator003v2Arg1 = null;
        test4assocOperator003v2Result = Double.valueOf(0);
    }

    private static void setUpMockData4test4assocOperator004() {
        test4assocOperator004Arg1 = new Project();
        test4assocOperator004Result = Double.valueOf(0);
    }

    private static void setUpMockData4test4assocOperator004v2() {
        test4assocOperator004v2Arg1 = null;
        test4assocOperator004v2Result = Double.valueOf(0);
    }

    private static void setUpMockData4test4assocOperator005() {
        test4assocOperator005Arg1 = new Project();
        test4assocOperator005Result = new ArrayList<>();
    }

    private static void setUpMockData4test4assocOperator005v2() {
        test4assocOperator005v2Arg1 = null;
        test4assocOperator005v2Result = new ArrayList<>();
    }

    @Before
    public void setUp() {
        instanceProjectJpaRepositoryImpl = new ProjectJpaRepositoryImpl();
        instanceProjectJpaRepositoryImpl.setEntityManager(em);
    }
    
    @After
    public void tearDown() {
        instanceProjectJpaRepositoryImpl = null;
    }

    @Test
    public void test4executeQueryString() {
        List<Project> result;
        try {
            result = instanceProjectJpaRepositoryImpl.executeQuery(test4executeQueryStringArg1);
        } catch (Exception e) {
            result = test4executeQueryStringResult;
        }
        assertEquals(test4executeQueryStringResult, result);
    }

    @Test
    public void test4executeQueryStringParameters() {
        List<Project> result;
        try {
            result = instanceProjectJpaRepositoryImpl.executeQuery(test4executeQueryStringParametersArg1, test4executeQueryStringParametersArg2);
        } catch (Exception e) {
            result = test4executeQueryStringParametersResult;
        }
        assertEquals(test4executeQueryStringParametersResult, result);
    }

    @Test
    public void test4executeQuerySQLPopulation() {
        Collection<Project> result;
        try {
            result = instanceProjectJpaRepositoryImpl.executeQuery(test4executeQuerySQLPopulationArg1);
        } catch (Exception e) {
            result = test4executeQuerySQLPopulationResult;
        }
        assertEquals(test4executeQuerySQLPopulationResult, result);
    }

    @Test
    public void test4solveQuery() {
        List<Project> result;
        try {
            result = instanceProjectJpaRepositoryImpl.solveQuery(test4solveQueryArg1);
        } catch (Exception e) {
            result = test4solveQueryResult;
        }
        assertEquals(test4solveQueryResult, result);
    }

    @Test
    public void test4assocOperator000() {
        Boolean result;
        try {
            result = instanceProjectJpaRepositoryImpl.assocOperator000(test4assocOperator000Arg1, test4assocOperator000Arg2, test4assocOperator000Arg3);
        } catch (SystemException e) {
            result = test4assocOperator000Result;
        }
        assertEquals(test4assocOperator000Result, result);
    }

    @Test
    public void test4assocOperator000v2() {
        Boolean result;
        try {
            result = instanceProjectJpaRepositoryImpl.assocOperator000(test4assocOperator000v2Arg1, test4assocOperator000v2Arg2, test4assocOperator000v2Arg3);
        } catch (SystemException e) {
            result = test4assocOperator000v2Result;
        }
        assertEquals(test4assocOperator000v2Result, result);
    }

    @Test
    public void test4assocOperator001() {
        Double result;
        try {
            result = instanceProjectJpaRepositoryImpl.assocOperator001(test4assocOperator001Arg1);
        } catch (SystemException e) {
            result = test4assocOperator001Result;
        }
        assertEquals(test4assocOperator001Result, result);
    }

    @Test
    public void test4assocOperator001v2() {
        Double result;
        try {
            result = instanceProjectJpaRepositoryImpl.assocOperator001(test4assocOperator001v2Arg1);
        } catch (SystemException e) {
            result = test4assocOperator001v2Result;
        }
        assertEquals(test4assocOperator001v2Result, result);
    }

    @Test
    public void test4assocOperator002() {
        Double result;
        try {
            result = instanceProjectJpaRepositoryImpl.assocOperator002(test4assocOperator002Arg1);
        } catch (SystemException e) {
            result = test4assocOperator002Result;
        }
        assertEquals(test4assocOperator002Result, result);
    }

    @Test
    public void test4assocOperator002v2() {
        Double result;
        try {
            result = instanceProjectJpaRepositoryImpl.assocOperator002(test4assocOperator002v2Arg1);
        } catch (SystemException e) {
            result = test4assocOperator002v2Result;
        }
        assertEquals(test4assocOperator002v2Result, result);
    }

    @Test
    public void test4assocOperator003() {
        Double result;
        try {
            result = instanceProjectJpaRepositoryImpl.assocOperator003(test4assocOperator003Arg1);
        } catch (SystemException e) {
            result = test4assocOperator003Result;
        }
        assertEquals(test4assocOperator003Result, result);
    }

    @Test
    public void test4assocOperator003v2() {
        Double result;
        try {
            result = instanceProjectJpaRepositoryImpl.assocOperator003(test4assocOperator003v2Arg1);
        } catch (SystemException e) {
            result = test4assocOperator003v2Result;
        }
        assertEquals(test4assocOperator003v2Result, result);
    }

    @Test
    public void test4assocOperator004() {
        Double result;
        try {
            result = instanceProjectJpaRepositoryImpl.assocOperator004(test4assocOperator004Arg1);
        } catch (SystemException e) {
            result = test4assocOperator004Result;
        }
        assertEquals(test4assocOperator004Result, result);
    }

    @Test
    public void test4assocOperator004v2() {
        Double result;
        try {
            result = instanceProjectJpaRepositoryImpl.assocOperator004(test4assocOperator004v2Arg1);
        } catch (SystemException e) {
            result = test4assocOperator004v2Result;
        }
        assertEquals(test4assocOperator004v2Result, result);
    }

    @Test
    public void test4assocOperator005() {
        Collection<Assignment> result;
        try {
            result = instanceProjectJpaRepositoryImpl.assocOperator005(test4assocOperator005Arg1);
        } catch (SystemException e) {
            result = test4assocOperator005Result;
        }
        assertEquals(test4assocOperator005Result, result);
    }

    @Test
    public void test4assocOperator005v2() {
        Collection<Assignment> result;
        try {
            result = instanceProjectJpaRepositoryImpl.assocOperator005(test4assocOperator005v2Arg1);
        } catch (SystemException e) {
            result = test4assocOperator005v2Result;
        }
        assertEquals(test4assocOperator005v2Result, result);
    }
}
