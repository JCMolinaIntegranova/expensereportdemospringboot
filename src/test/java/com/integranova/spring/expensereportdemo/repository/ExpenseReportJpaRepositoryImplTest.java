package com.integranova.spring.expensereportdemo.repository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.ExpenseReportConstants;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.ERLTemplate;
import com.integranova.spring.expensereportdemo.persistence.ERTemplate;
import com.integranova.spring.expensereportdemo.persistence.ExpenseLine;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
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
public class ExpenseReportJpaRepositoryImplTest {

    private static EntityManager em;

    private ExpenseReportJpaRepositoryImpl instanceExpenseReportJpaRepositoryImpl;

    // test4executeQueryString
    private static String test4executeQueryStringArg1;
    private static List<ExpenseReport> test4executeQueryStringResult;

    // test4executeQueryStringParameters
    private static String test4executeQueryStringParametersArg1;
    private static List<SQLParam> test4executeQueryStringParametersArg2;
    private static List<ExpenseReport> test4executeQueryStringParametersResult;

    // test4executeQuerySQLPopulation
    private static SQLPopulation test4executeQuerySQLPopulationArg1;
    private static Collection<ExpenseReport> test4executeQuerySQLPopulationResult;

    // test4solveQuery
    private static SQLPopulation test4solveQueryArg1;
    private static List<ExpenseReport> test4solveQueryResult;

    // test4assocOperator000
    private static ExpenseReport test4assocOperator000Arg1;
    private static Double test4assocOperator000Result;

    // test4assocOperator000v2
    private static ExpenseReport test4assocOperator000v2Arg1;
    private static Double test4assocOperator000v2Result;

    // test4assocOperator001
    private static Project test4assocOperator001Arg1;
    private static Employee test4assocOperator001Arg2;
    private static Date test4assocOperator001Arg3;
    private static Boolean test4assocOperator001Result;

    // test4assocOperator001v2
    private static Project test4assocOperator001v2Arg1;
    private static Employee test4assocOperator001v2Arg2;
    private static Date test4assocOperator001v2Arg3;
    private static Boolean test4assocOperator001v2Result;

    // test4assocOperator002
    private static Project test4assocOperator002Arg1;
    private static Employee test4assocOperator002Arg2;
    private static Boolean test4assocOperator002Result;

    // test4assocOperator002v2
    private static Project test4assocOperator002v2Arg1;
    private static Employee test4assocOperator002v2Arg2;
    private static Boolean test4assocOperator002v2Result;

    // test4assocOperator003
    private static Project test4assocOperator003Arg1;
    private static Employee test4assocOperator003Arg2;
    private static Date test4assocOperator003Arg3;
    private static Boolean test4assocOperator003Result;

    // test4assocOperator003v2
    private static Project test4assocOperator003v2Arg1;
    private static Employee test4assocOperator003v2Arg2;
    private static Date test4assocOperator003v2Arg3;
    private static Boolean test4assocOperator003v2Result;

    // test4assocOperator004
    private static Project test4assocOperator004Arg1;
    private static Employee test4assocOperator004Arg2;
    private static Boolean test4assocOperator004Result;

    // test4assocOperator004v2
    private static Project test4assocOperator004v2Arg1;
    private static Employee test4assocOperator004v2Arg2;
    private static Boolean test4assocOperator004v2Result;

    // test4assocOperator005
    private static Project test4assocOperator005Arg1;
    private static ERTemplate test4assocOperator005Arg2;
    private static Boolean test4assocOperator005Result;

    // test4assocOperator005v2
    private static Project test4assocOperator005v2Arg1;
    private static ERTemplate test4assocOperator005v2Arg2;
    private static Boolean test4assocOperator005v2Result;

    // test4assocOperator006
    private static ExpenseReport test4assocOperator006Arg1;
    private static Collection<ExpenseLine> test4assocOperator006Result;

    // test4assocOperator006v2
    private static ExpenseReport test4assocOperator006v2Arg1;
    private static Collection<ExpenseLine> test4assocOperator006v2Result;

    // test4assocOperator007
    private static ERTemplate test4assocOperator007Arg1;
    private static Collection<ERLTemplate> test4assocOperator007Result;

    // test4assocOperator007v2
    private static ERTemplate test4assocOperator007v2Arg1;
    private static Collection<ERLTemplate> test4assocOperator007v2Result;

    // test4assocOperator008
    private static ERTemplate test4assocOperator008Arg1;
    private static Long test4assocOperator008Result;

    // test4assocOperator008v2
    private static ERTemplate test4assocOperator008v2Arg1;
    private static Long test4assocOperator008v2Result;

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
        setUpMockData4test4assocOperator006();
        setUpMockData4test4assocOperator006v2();
        setUpMockData4test4assocOperator007();
        setUpMockData4test4assocOperator007v2();
        setUpMockData4test4assocOperator008();
        setUpMockData4test4assocOperator008v2();
        em = mock(EntityManager.class);
    }

    private static void setUpMockData4test4executeQueryString() {
        test4executeQueryStringArg1 = "SELECT ExpenseReport FROM ExpenseReport ExpenseReport";
        test4executeQueryStringResult = new ArrayList<>();
    }

    private static void setUpMockData4test4executeQueryStringParameters() {
        test4executeQueryStringParametersArg1 = "SELECT ExpenseReport FROM ExpenseReport ExpenseReport";
        test4executeQueryStringParametersArg2 = new ArrayList<>();
        test4executeQueryStringParametersResult = new ArrayList<>();
    }

    private static void setUpMockData4test4executeQuerySQLPopulation() throws SystemException {
        test4executeQuerySQLPopulationArg1 = new SQLPopulation(ExpenseReportConstants.CLASS_NAME);
        test4executeQuerySQLPopulationResult = new ArrayList<>();
    }

    private static void setUpMockData4test4solveQuery() throws SystemException {
        test4solveQueryArg1 = new SQLPopulation(ExpenseReportConstants.CLASS_NAME);
        test4solveQueryResult = new ArrayList<>();
    }

    private static void setUpMockData4test4assocOperator000() {
        test4assocOperator000Arg1 = new ExpenseReport();
        test4assocOperator000Result = 0.0;
    }

    private static void setUpMockData4test4assocOperator000v2() {
        test4assocOperator000v2Arg1 = null;
        test4assocOperator000v2Result = Double.valueOf(0);
    }

    private static void setUpMockData4test4assocOperator001() {
        test4assocOperator001Arg1 = new Project();
        test4assocOperator001Arg2 = new Employee();
        test4assocOperator001Arg3 = Date.valueOf(Constants.DATE_DEFAULTVALUE);
        test4assocOperator001Result = false;
    }

    private static void setUpMockData4test4assocOperator001v2() {
        test4assocOperator001v2Arg1 = null;
        test4assocOperator001v2Arg2 = null;
        test4assocOperator001v2Arg3 = null;
        test4assocOperator001v2Result = false;
    }

    private static void setUpMockData4test4assocOperator002() {
        test4assocOperator002Arg1 = new Project();
        test4assocOperator002Arg2 = new Employee();
        test4assocOperator002Result = false;
    }

    private static void setUpMockData4test4assocOperator002v2() {
        test4assocOperator002v2Arg1 = null;
        test4assocOperator002v2Arg2 = null;
        test4assocOperator002v2Result = false;
    }

    private static void setUpMockData4test4assocOperator003() {
        test4assocOperator003Arg1 = new Project();
        test4assocOperator003Arg2 = new Employee();
        test4assocOperator003Arg3 = Date.valueOf(Constants.DATE_DEFAULTVALUE);
        test4assocOperator003Result = false;
    }

    private static void setUpMockData4test4assocOperator003v2() {
        test4assocOperator003v2Arg1 = null;
        test4assocOperator003v2Arg2 = null;
        test4assocOperator003v2Arg3 = null;
        test4assocOperator003v2Result = false;
    }

    private static void setUpMockData4test4assocOperator004() {
        test4assocOperator004Arg1 = new Project();
        test4assocOperator004Arg2 = new Employee();
        test4assocOperator004Result = false;
    }

    private static void setUpMockData4test4assocOperator004v2() {
        test4assocOperator004v2Arg1 = null;
        test4assocOperator004v2Arg2 = null;
        test4assocOperator004v2Result = false;
    }

    private static void setUpMockData4test4assocOperator005() {
        test4assocOperator005Arg1 = new Project();
        test4assocOperator005Arg2 = new ERTemplate();
        test4assocOperator005Result = false;
    }

    private static void setUpMockData4test4assocOperator005v2() {
        test4assocOperator005v2Arg1 = null;
        test4assocOperator005v2Arg2 = null;
        test4assocOperator005v2Result = false;
    }

    private static void setUpMockData4test4assocOperator006() {
        test4assocOperator006Arg1 = new ExpenseReport();
        test4assocOperator006Result = new ArrayList<>();
    }

    private static void setUpMockData4test4assocOperator006v2() {
        test4assocOperator006v2Arg1 = null;
        test4assocOperator006v2Result = new ArrayList<>();
    }

    private static void setUpMockData4test4assocOperator007() {
        test4assocOperator007Arg1 = new ERTemplate();
        test4assocOperator007Result = new ArrayList<>();
    }

    private static void setUpMockData4test4assocOperator007v2() {
        test4assocOperator007v2Arg1 = null;
        test4assocOperator007v2Result = new ArrayList<>();
    }

    private static void setUpMockData4test4assocOperator008() {
        test4assocOperator008Arg1 = new ERTemplate();
        test4assocOperator008Result = Long.valueOf(0);
    }

    private static void setUpMockData4test4assocOperator008v2() {
        test4assocOperator008v2Arg1 = null;
        test4assocOperator008v2Result = Long.valueOf(0);
    }

    @Before
    public void setUp() {
        instanceExpenseReportJpaRepositoryImpl = new ExpenseReportJpaRepositoryImpl();
        instanceExpenseReportJpaRepositoryImpl.setEntityManager(em);
    }
    
    @After
    public void tearDown() {
        instanceExpenseReportJpaRepositoryImpl = null;
    }

    @Test
    public void test4executeQueryString() {
        List<ExpenseReport> result;
        try {
            result = instanceExpenseReportJpaRepositoryImpl.executeQuery(test4executeQueryStringArg1);
        } catch (Exception e) {
            result = test4executeQueryStringResult;
        }
        assertEquals(test4executeQueryStringResult, result);
    }

    @Test
    public void test4executeQueryStringParameters() {
        List<ExpenseReport> result;
        try {
            result = instanceExpenseReportJpaRepositoryImpl.executeQuery(test4executeQueryStringParametersArg1, test4executeQueryStringParametersArg2);
        } catch (Exception e) {
            result = test4executeQueryStringParametersResult;
        }
        assertEquals(test4executeQueryStringParametersResult, result);
    }

    @Test
    public void test4executeQuerySQLPopulation() {
        Collection<ExpenseReport> result;
        try {
            result = instanceExpenseReportJpaRepositoryImpl.executeQuery(test4executeQuerySQLPopulationArg1);
        } catch (Exception e) {
            result = test4executeQuerySQLPopulationResult;
        }
        assertEquals(test4executeQuerySQLPopulationResult, result);
    }

    @Test
    public void test4solveQuery() {
        List<ExpenseReport> result;
        try {
            result = instanceExpenseReportJpaRepositoryImpl.solveQuery(test4solveQueryArg1);
        } catch (Exception e) {
            result = test4solveQueryResult;
        }
        assertEquals(test4solveQueryResult, result);
    }

    @Test
    public void test4assocOperator000() {
        Double result;
        try {
            result = instanceExpenseReportJpaRepositoryImpl.assocOperator000(test4assocOperator000Arg1);
        } catch (SystemException e) {
            result = test4assocOperator000Result;
        }
        assertEquals(test4assocOperator000Result, result);
    }

    @Test
    public void test4assocOperator000v2() {
        Double result;
        try {
            result = instanceExpenseReportJpaRepositoryImpl.assocOperator000(test4assocOperator000v2Arg1);
        } catch (SystemException e) {
            result = test4assocOperator000v2Result;
        }
        assertEquals(test4assocOperator000v2Result, result);
    }

    @Test
    public void test4assocOperator001() {
        Boolean result;
        try {
            result = instanceExpenseReportJpaRepositoryImpl.assocOperator001(test4assocOperator001Arg1, test4assocOperator001Arg2, test4assocOperator001Arg3);
        } catch (SystemException e) {
            result = test4assocOperator001Result;
        }
        assertEquals(test4assocOperator001Result, result);
    }

    @Test
    public void test4assocOperator001v2() {
        Boolean result;
        try {
            result = instanceExpenseReportJpaRepositoryImpl.assocOperator001(test4assocOperator001v2Arg1, test4assocOperator001v2Arg2, test4assocOperator001v2Arg3);
        } catch (SystemException e) {
            result = test4assocOperator001v2Result;
        }
        assertEquals(test4assocOperator001v2Result, result);
    }

    @Test
    public void test4assocOperator002() {
        Boolean result;
        try {
            result = instanceExpenseReportJpaRepositoryImpl.assocOperator002(test4assocOperator002Arg1, test4assocOperator002Arg2);
        } catch (SystemException e) {
            result = test4assocOperator002Result;
        }
        assertEquals(test4assocOperator002Result, result);
    }

    @Test
    public void test4assocOperator002v2() {
        Boolean result;
        try {
            result = instanceExpenseReportJpaRepositoryImpl.assocOperator002(test4assocOperator002v2Arg1, test4assocOperator002v2Arg2);
        } catch (SystemException e) {
            result = test4assocOperator002v2Result;
        }
        assertEquals(test4assocOperator002v2Result, result);
    }

    @Test
    public void test4assocOperator003() {
        Boolean result;
        try {
            result = instanceExpenseReportJpaRepositoryImpl.assocOperator003(test4assocOperator003Arg1, test4assocOperator003Arg2, test4assocOperator003Arg3);
        } catch (SystemException e) {
            result = test4assocOperator003Result;
        }
        assertEquals(test4assocOperator003Result, result);
    }

    @Test
    public void test4assocOperator003v2() {
        Boolean result;
        try {
            result = instanceExpenseReportJpaRepositoryImpl.assocOperator003(test4assocOperator003v2Arg1, test4assocOperator003v2Arg2, test4assocOperator003v2Arg3);
        } catch (SystemException e) {
            result = test4assocOperator003v2Result;
        }
        assertEquals(test4assocOperator003v2Result, result);
    }

    @Test
    public void test4assocOperator004() {
        Boolean result;
        try {
            result = instanceExpenseReportJpaRepositoryImpl.assocOperator004(test4assocOperator004Arg1, test4assocOperator004Arg2);
        } catch (SystemException e) {
            result = test4assocOperator004Result;
        }
        assertEquals(test4assocOperator004Result, result);
    }

    @Test
    public void test4assocOperator004v2() {
        Boolean result;
        try {
            result = instanceExpenseReportJpaRepositoryImpl.assocOperator004(test4assocOperator004v2Arg1, test4assocOperator004v2Arg2);
        } catch (SystemException e) {
            result = test4assocOperator004v2Result;
        }
        assertEquals(test4assocOperator004v2Result, result);
    }

    @Test
    public void test4assocOperator005() {
        Boolean result;
        try {
            result = instanceExpenseReportJpaRepositoryImpl.assocOperator005(test4assocOperator005Arg1, test4assocOperator005Arg2);
        } catch (SystemException e) {
            result = test4assocOperator005Result;
        }
        assertEquals(test4assocOperator005Result, result);
    }

    @Test
    public void test4assocOperator005v2() {
        Boolean result;
        try {
            result = instanceExpenseReportJpaRepositoryImpl.assocOperator005(test4assocOperator005v2Arg1, test4assocOperator005v2Arg2);
        } catch (SystemException e) {
            result = test4assocOperator005v2Result;
        }
        assertEquals(test4assocOperator005v2Result, result);
    }

    @Test
    public void test4assocOperator006() {
        Collection<ExpenseLine> result;
        try {
            result = instanceExpenseReportJpaRepositoryImpl.assocOperator006(test4assocOperator006Arg1);
        } catch (SystemException e) {
            result = test4assocOperator006Result;
        }
        assertEquals(test4assocOperator006Result, result);
    }

    @Test
    public void test4assocOperator006v2() {
        Collection<ExpenseLine> result;
        try {
            result = instanceExpenseReportJpaRepositoryImpl.assocOperator006(test4assocOperator006v2Arg1);
        } catch (SystemException e) {
            result = test4assocOperator006v2Result;
        }
        assertEquals(test4assocOperator006v2Result, result);
    }

    @Test
    public void test4assocOperator007() {
        Collection<ERLTemplate> result;
        try {
            result = instanceExpenseReportJpaRepositoryImpl.assocOperator007(test4assocOperator007Arg1);
        } catch (SystemException e) {
            result = test4assocOperator007Result;
        }
        assertEquals(test4assocOperator007Result, result);
    }

    @Test
    public void test4assocOperator007v2() {
        Collection<ERLTemplate> result;
        try {
            result = instanceExpenseReportJpaRepositoryImpl.assocOperator007(test4assocOperator007v2Arg1);
        } catch (SystemException e) {
            result = test4assocOperator007v2Result;
        }
        assertEquals(test4assocOperator007v2Result, result);
    }

    @Test
    public void test4assocOperator008() {
        Long result;
        try {
            result = instanceExpenseReportJpaRepositoryImpl.assocOperator008(test4assocOperator008Arg1);
        } catch (SystemException e) {
            result = test4assocOperator008Result;
        }
        assertEquals(test4assocOperator008Result, result);
    }

    @Test
    public void test4assocOperator008v2() {
        Long result;
        try {
            result = instanceExpenseReportJpaRepositoryImpl.assocOperator008(test4assocOperator008v2Arg1);
        } catch (SystemException e) {
            result = test4assocOperator008v2Result;
        }
        assertEquals(test4assocOperator008v2Result, result);
    }
}
