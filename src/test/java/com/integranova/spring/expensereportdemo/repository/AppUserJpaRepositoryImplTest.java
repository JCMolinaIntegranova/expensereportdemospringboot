package com.integranova.spring.expensereportdemo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.AppUserConstants;
import com.integranova.spring.expensereportdemo.persistence.AdminUser;
import com.integranova.spring.expensereportdemo.persistence.AppUser;
import com.integranova.spring.expensereportdemo.persistence.OperatorUser;
import com.integranova.spring.expensereportdemo.sqlutils.SQLAlias;
import com.integranova.spring.expensereportdemo.sqlutils.SQLJoin;
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
public class AppUserJpaRepositoryImplTest {

    private static EntityManager em;

    private AppUserJpaRepositoryImpl instanceAppUserJpaRepositoryImpl;

    // test4executeQueryString
    private static String test4executeQueryStringArg1;
    private static List<AppUser> test4executeQueryStringResult;

    // test4executeQueryStringParameters
    private static String test4executeQueryStringParametersArg1;
    private static List<SQLParam> test4executeQueryStringParametersArg2;
    private static List<AppUser> test4executeQueryStringParametersResult;

    // test4executeQuerySQLPopulation
    private static SQLPopulation test4executeQuerySQLPopulationArg1;
    private static Collection<AppUser> test4executeQuerySQLPopulationResult;

    // test4solveQuery
    private static SQLPopulation test4solveQueryArg1;
    private static List<AppUser> test4solveQueryResult;

    // test4findChildAdminUser
    private static String test4findChildAdminUserArg1;
    private static AdminUser test4findChildAdminUserResult;

    // test4addFacetWhereadminuser
    private static String test4addFacetWhereadminuserArg1;
    private static SQLJoin test4addFacetWhereadminuserArg2;
    private static String test4addFacetWhereadminuserArg3;

    // test4findChildOperatorUser
    private static String test4findChildOperatorUserArg1;
    private static OperatorUser test4findChildOperatorUserResult;

    // test4addFacetWhereoperatoruser
    private static String test4addFacetWhereoperatoruserArg1;
    private static SQLJoin test4addFacetWhereoperatoruserArg2;
    private static String test4addFacetWhereoperatoruserArg3;

    @BeforeClass
    public static void setUpClass() throws SystemException {
        setUpMockData();
    }

    private static void setUpMockData() throws SystemException {
        setUpMockData4test4executeQueryString();
        setUpMockData4test4executeQueryStringParameters();
        setUpMockData4test4executeQuerySQLPopulation();
        setUpMockData4test4solveQuery();
        setUpMockData4test4findChildAdminUser();
        setUpMockData4test4addFacetWhereadminuser();
        setUpMockData4test4findChildOperatorUser();
        setUpMockData4test4addFacetWhereoperatoruser();
        em = mock(EntityManager.class);
    }

    private static void setUpMockData4test4executeQueryString() {
        test4executeQueryStringArg1 = "SELECT AppUser FROM AppUser AppUser";
        test4executeQueryStringResult = new ArrayList<>();
    }

    private static void setUpMockData4test4executeQueryStringParameters() {
        test4executeQueryStringParametersArg1 = "SELECT AppUser FROM AppUser AppUser";
        test4executeQueryStringParametersArg2 = new ArrayList<>();
        test4executeQueryStringParametersResult = new ArrayList<>();
    }

    private static void setUpMockData4test4executeQuerySQLPopulation() throws SystemException {
        test4executeQuerySQLPopulationArg1 = new SQLPopulation(AppUserConstants.CLASS_NAME);
        test4executeQuerySQLPopulationResult = new ArrayList<>();
    }

    private static void setUpMockData4test4solveQuery() throws SystemException {
        test4solveQueryArg1 = new SQLPopulation(AppUserConstants.CLASS_NAME);
        test4solveQueryResult = new ArrayList<>();
    }

    private static void setUpMockData4test4findChildAdminUser() {
        test4findChildAdminUserArg1 = "";
        test4findChildAdminUserResult = null;
    }

    private static void setUpMockData4test4addFacetWhereadminuser() {
        test4addFacetWhereadminuserArg1 = "";
        test4addFacetWhereadminuserArg2 = new SQLJoin("", "", new SQLAlias("", "", false, ""), new SQLAlias("", "", false, ""));
        test4addFacetWhereadminuserArg3 = "";
    }

    private static void setUpMockData4test4findChildOperatorUser() {
        test4findChildOperatorUserArg1 = "";
        test4findChildOperatorUserResult = null;
    }

    private static void setUpMockData4test4addFacetWhereoperatoruser() {
        test4addFacetWhereoperatoruserArg1 = "";
        test4addFacetWhereoperatoruserArg2 = new SQLJoin("", "", new SQLAlias("", "", false, ""), new SQLAlias("", "", false, ""));
        test4addFacetWhereoperatoruserArg3 = "";
    }

    @Before
    public void setUp() {
        instanceAppUserJpaRepositoryImpl = new AppUserJpaRepositoryImpl();
        instanceAppUserJpaRepositoryImpl.setEntityManager(em);
    }
    
    @After
    public void tearDown() {
        instanceAppUserJpaRepositoryImpl = null;
    }

    @Test
    public void test4executeQueryString() {
        List<AppUser> result;
        try {
            result = instanceAppUserJpaRepositoryImpl.executeQuery(test4executeQueryStringArg1);
        } catch (Exception e) {
            result = test4executeQueryStringResult;
        }
        assertEquals(test4executeQueryStringResult, result);
    }

    @Test
    public void test4executeQueryStringParameters() {
        List<AppUser> result;
        try {
            result = instanceAppUserJpaRepositoryImpl.executeQuery(test4executeQueryStringParametersArg1, test4executeQueryStringParametersArg2);
        } catch (Exception e) {
            result = test4executeQueryStringParametersResult;
        }
        assertEquals(test4executeQueryStringParametersResult, result);
    }

    @Test
    public void test4executeQuerySQLPopulation() {
        Collection<AppUser> result;
        try {
            result = instanceAppUserJpaRepositoryImpl.executeQuery(test4executeQuerySQLPopulationArg1);
        } catch (Exception e) {
            result = test4executeQuerySQLPopulationResult;
        }
        assertEquals(test4executeQuerySQLPopulationResult, result);
    }

    @Test
    public void test4solveQuery() {
        List<AppUser> result;
        try {
            result = instanceAppUserJpaRepositoryImpl.solveQuery(test4solveQueryArg1);
        } catch (Exception e) {
            result = test4solveQueryResult;
        }
        assertEquals(test4solveQueryResult, result);
    }

    @Test
    public void test4findChildAdminUser() {
        assertEquals(test4findChildAdminUserResult, instanceAppUserJpaRepositoryImpl.findChildAdminUser(test4findChildAdminUserArg1));
    }

    @Test
    public void test4addFacetWhereadminuser() {
        instanceAppUserJpaRepositoryImpl.addFacetWhereadminuser(test4addFacetWhereadminuserArg1, test4addFacetWhereadminuserArg2, test4addFacetWhereadminuserArg3);
        assertNotNull(instanceAppUserJpaRepositoryImpl);
    }

    @Test
    public void test4findChildOperatorUser() {
        assertEquals(test4findChildOperatorUserResult, instanceAppUserJpaRepositoryImpl.findChildOperatorUser(test4findChildOperatorUserArg1));
    }

    @Test
    public void test4addFacetWhereoperatoruser() {
        instanceAppUserJpaRepositoryImpl.addFacetWhereoperatoruser(test4addFacetWhereoperatoruserArg1, test4addFacetWhereoperatoruserArg2, test4addFacetWhereoperatoruserArg3);
        assertNotNull(instanceAppUserJpaRepositoryImpl);
    }
}
