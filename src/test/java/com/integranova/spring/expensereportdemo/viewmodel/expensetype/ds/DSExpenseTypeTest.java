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
public class DSExpenseTypeTest {

    private DSExpenseType instanceDSExpenseType;

    // testDSExpenseType
    private static ExpenseType testDSExpenseTypeArg1;

    // testDSExpenseType2
    private static ExpenseType testDSExpenseType2Arg1;

    // testgetDSExpenseTypeTypeCode

    // testsetDSExpenseTypeTypeCode
    private static String testsetDSExpenseTypeTypeCodeArg1;

    // testgetDSExpenseTypePrice

    // testsetDSExpenseTypePrice
    private static Double testsetDSExpenseTypePriceArg1;

    // testgetDSExpenseTypeTyDescription

    // testsetDSExpenseTypeTyDescription
    private static String testsetDSExpenseTypeTyDescriptionArg1;

    // testgetDSExpenseTypeFixedPrice

    // testsetDSExpenseTypeFixedPrice
    private static Boolean testsetDSExpenseTypeFixedPriceArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testDSExpenseType();
        setUpMockData4testDSExpenseType2();
        setUpMockData4testgetDSExpenseTypeTypeCode();
        setUpMockData4testsetDSExpenseTypeTypeCode();
        setUpMockData4testgetDSExpenseTypePrice();
        setUpMockData4testsetDSExpenseTypePrice();
        setUpMockData4testgetDSExpenseTypeTyDescription();
        setUpMockData4testsetDSExpenseTypeTyDescription();
        setUpMockData4testgetDSExpenseTypeFixedPrice();
        setUpMockData4testsetDSExpenseTypeFixedPrice();
    }

    private static void setUpMockData4testDSExpenseType() {
        testDSExpenseTypeArg1 = new ExpenseType();
    }

    private static void setUpMockData4testDSExpenseType2() {
        testDSExpenseType2Arg1 = null;
    }

    private static void setUpMockData4testgetDSExpenseTypeTypeCode() {
    }

    private static void setUpMockData4testsetDSExpenseTypeTypeCode() {
        testsetDSExpenseTypeTypeCodeArg1 = "";
    }

    private static void setUpMockData4testgetDSExpenseTypePrice() {
    }

    private static void setUpMockData4testsetDSExpenseTypePrice() {
        testsetDSExpenseTypePriceArg1 = Double.valueOf(0);
    }

    private static void setUpMockData4testgetDSExpenseTypeTyDescription() {
    }

    private static void setUpMockData4testsetDSExpenseTypeTyDescription() {
        testsetDSExpenseTypeTyDescriptionArg1 = "";
    }

    private static void setUpMockData4testgetDSExpenseTypeFixedPrice() {
    }

    private static void setUpMockData4testsetDSExpenseTypeFixedPrice() {
        testsetDSExpenseTypeFixedPriceArg1 = false;
    }

    @Before
    public void setUp() {
        instanceDSExpenseType = new DSExpenseType();
        instanceDSExpenseType.setDSExpenseTypeTypeCode("");
        instanceDSExpenseType.setDSExpenseTypePrice(Double.valueOf(0));
        instanceDSExpenseType.setDSExpenseTypeTyDescription("");
        instanceDSExpenseType.setDSExpenseTypeFixedPrice(false);
    }

    @Test
    public void testDSExpenseType() {
        instanceDSExpenseType = new DSExpenseType(testDSExpenseTypeArg1);
        assertNotNull(instanceDSExpenseType);
    }

    @Test
    public void testDSExpenseType2() {
        instanceDSExpenseType = new DSExpenseType(testDSExpenseType2Arg1);
        assertNotNull(instanceDSExpenseType);
    }

    @Test
    public void testgetDSExpenseTypeTypeCode() {
        assertEquals("", instanceDSExpenseType.getDSExpenseTypeTypeCode());
    }

    @Test
    public void testsetDSExpenseTypeTypeCode() {
        instanceDSExpenseType.setDSExpenseTypeTypeCode(testsetDSExpenseTypeTypeCodeArg1);
        assertNotNull(instanceDSExpenseType);
    }

    @Test
    public void testgetDSExpenseTypePrice() {
        assertEquals(Double.valueOf(0), instanceDSExpenseType.getDSExpenseTypePrice());
    }

    @Test
    public void testsetDSExpenseTypePrice() {
        instanceDSExpenseType.setDSExpenseTypePrice(testsetDSExpenseTypePriceArg1);
        assertNotNull(instanceDSExpenseType);
    }

    @Test
    public void testgetDSExpenseTypeTyDescription() {
        assertEquals("", instanceDSExpenseType.getDSExpenseTypeTyDescription());
    }

    @Test
    public void testsetDSExpenseTypeTyDescription() {
        instanceDSExpenseType.setDSExpenseTypeTyDescription(testsetDSExpenseTypeTyDescriptionArg1);
        assertNotNull(instanceDSExpenseType);
    }

    @Test
    public void testgetDSExpenseTypeFixedPrice() {
        assertEquals(false, instanceDSExpenseType.getDSExpenseTypeFixedPrice());
    }

    @Test
    public void testsetDSExpenseTypeFixedPrice() {
        instanceDSExpenseType.setDSExpenseTypeFixedPrice(testsetDSExpenseTypeFixedPriceArg1);
        assertNotNull(instanceDSExpenseType);
    }
}
