package com.integranova.spring.expensereportdemo.viewmodel.expensetype.ds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.persistence.ExpenseType;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DSExpenseTypeSupTest {

    private DSExpenseTypeSup instanceDSExpenseTypeSup;

    // testDSExpenseTypeSup
    private static ExpenseType testDSExpenseTypeSupArg1;

    // testDSExpenseTypeSup2
    private static ExpenseType testDSExpenseTypeSup2Arg1;

    // testgetDSExpenseTypeSupTyDescription

    // testsetDSExpenseTypeSupTyDescription
    private static String testsetDSExpenseTypeSupTyDescriptionArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testDSExpenseTypeSup();
        setUpMockData4testDSExpenseTypeSup2();
        setUpMockData4testgetDSExpenseTypeSupTyDescription();
        setUpMockData4testsetDSExpenseTypeSupTyDescription();
    }

    private static void setUpMockData4testDSExpenseTypeSup() {
        testDSExpenseTypeSupArg1 = new ExpenseType();
    }

    private static void setUpMockData4testDSExpenseTypeSup2() {
        testDSExpenseTypeSup2Arg1 = null;
    }

    private static void setUpMockData4testgetDSExpenseTypeSupTyDescription() {
    }

    private static void setUpMockData4testsetDSExpenseTypeSupTyDescription() {
        testsetDSExpenseTypeSupTyDescriptionArg1 = "";
    }

    @Before
    public void setUp() {
        instanceDSExpenseTypeSup = new DSExpenseTypeSup();
        instanceDSExpenseTypeSup.setDSExpenseTypeSupTyDescription("");
    }

    @Test
    public void testDSExpenseTypeSup() {
        instanceDSExpenseTypeSup = new DSExpenseTypeSup(testDSExpenseTypeSupArg1);
        assertNotNull(instanceDSExpenseTypeSup);
    }

    @Test
    public void testDSExpenseTypeSup2() {
        instanceDSExpenseTypeSup = new DSExpenseTypeSup(testDSExpenseTypeSup2Arg1);
        assertNotNull(instanceDSExpenseTypeSup);
    }

    @Test
    public void testgetDSExpenseTypeSupTyDescription() {
        assertEquals("", instanceDSExpenseTypeSup.getDSExpenseTypeSupTyDescription());
    }

    @Test
    public void testsetDSExpenseTypeSupTyDescription() {
        instanceDSExpenseTypeSup.setDSExpenseTypeSupTyDescription(testsetDSExpenseTypeSupTyDescriptionArg1);
        assertNotNull(instanceDSExpenseTypeSup);
    }
}
