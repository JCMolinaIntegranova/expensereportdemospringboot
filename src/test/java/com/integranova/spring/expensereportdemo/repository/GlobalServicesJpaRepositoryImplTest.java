package com.integranova.spring.expensereportdemo.repository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.persistence.ExpenseReport;
import com.integranova.spring.expensereportdemo.persistence.Project;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GlobalServicesJpaRepositoryImplTest {

    private static EntityManager em;

    private GlobalServicesJpaRepositoryImpl instanceGlobalServicesJpaRepositoryImpl;

    // test4assocOperator000
    private static Double test4assocOperator000Arg1;
    private static String test4assocOperator000Arg2;
    private static Collection<Project> test4assocOperator000Result;

    // test4assocOperator000v2
    private static Double test4assocOperator000v2Arg1;
    private static String test4assocOperator000v2Arg2;
    private static Collection<Project> test4assocOperator000v2Result;

    // test4assocOperator001
    private static Collection<ExpenseReport> test4assocOperator001Result;

    // test4assocOperator002
    private static Long test4assocOperator002Result;

    @BeforeClass
    public static void setUpClass() throws SystemException {
        setUpMockData();
    }

    private static void setUpMockData() throws SystemException {
        setUpMockData4test4assocOperator000();
        setUpMockData4test4assocOperator000v2();
        setUpMockData4test4assocOperator001();
        setUpMockData4test4assocOperator002();
        em = mock(EntityManager.class);
    }

    private static void setUpMockData4test4assocOperator000() {
        test4assocOperator000Arg1 = Double.valueOf(0);
        test4assocOperator000Arg2 = "";
        test4assocOperator000Result = new ArrayList<>();
    }

    private static void setUpMockData4test4assocOperator000v2() {
        test4assocOperator000v2Arg1 = null;
        test4assocOperator000v2Arg2 = null;
        test4assocOperator000v2Result = new ArrayList<>();
    }

    private static void setUpMockData4test4assocOperator001() {
        test4assocOperator001Result = new ArrayList<>();
    }

    private static void setUpMockData4test4assocOperator002() {
        test4assocOperator002Result = Long.valueOf(0);
    }

    @Before
    public void setUp() {
        instanceGlobalServicesJpaRepositoryImpl = new GlobalServicesJpaRepositoryImpl();
        instanceGlobalServicesJpaRepositoryImpl.setEntityManager(em);
    }
    
    @After
    public void tearDown() {
        instanceGlobalServicesJpaRepositoryImpl = null;
    }

    @Test
    public void test4assocOperator000() {
        Collection<Project> result;
        try {
            result = instanceGlobalServicesJpaRepositoryImpl.assocOperator000(test4assocOperator000Arg1, test4assocOperator000Arg2);
        } catch (SystemException e) {
            result = test4assocOperator000Result;
        }
        assertEquals(test4assocOperator000Result, result);
    }

    @Test
    public void test4assocOperator000v2() {
        Collection<Project> result;
        try {
            result = instanceGlobalServicesJpaRepositoryImpl.assocOperator000(test4assocOperator000v2Arg1, test4assocOperator000v2Arg2);
        } catch (SystemException e) {
            result = test4assocOperator000v2Result;
        }
        assertEquals(test4assocOperator000v2Result, result);
    }

    @Test
    public void test4assocOperator001() {
        Collection<ExpenseReport> result;
        try {
            result = instanceGlobalServicesJpaRepositoryImpl.assocOperator001();
        } catch (SystemException e) {
            result = test4assocOperator001Result;
        }
        assertEquals(test4assocOperator001Result, result);
    }

    @Test
    public void test4assocOperator002() {
        Long result;
        try {
            result = instanceGlobalServicesJpaRepositoryImpl.assocOperator002();
        } catch (SystemException e) {
            result = test4assocOperator002Result;
        }
        assertEquals(test4assocOperator002Result, result);
    }
}
