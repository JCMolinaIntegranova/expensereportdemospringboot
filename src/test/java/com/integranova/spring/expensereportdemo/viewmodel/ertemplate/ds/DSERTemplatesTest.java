package com.integranova.spring.expensereportdemo.viewmodel.ertemplate.ds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.persistence.ERTemplate;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DSERTemplatesTest {

    private DSERTemplates instanceDSERTemplates;

    // testDSERTemplates
    private static ERTemplate testDSERTemplatesArg1;

    // testDSERTemplates2
    private static ERTemplate testDSERTemplates2Arg1;

    // testgetDSERTemplatesId

    // testsetDSERTemplatesId
    private static Long testsetDSERTemplatesIdArg1;

    // testgetDSERTemplatesName

    // testsetDSERTemplatesName
    private static String testsetDSERTemplatesNameArg1;

    // testgetDSERTemplatesEnabled

    // testsetDSERTemplatesEnabled
    private static Boolean testsetDSERTemplatesEnabledArg1;

    // testgetDSERTemplatesTotal

    // testsetDSERTemplatesTotal
    private static Double testsetDSERTemplatesTotalArg1;

    // testgetDSERTemplatesDescription

    // testsetDSERTemplatesDescription
    private static String testsetDSERTemplatesDescriptionArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testDSERTemplates();
        setUpMockData4testDSERTemplates2();
        setUpMockData4testgetDSERTemplatesId();
        setUpMockData4testsetDSERTemplatesId();
        setUpMockData4testgetDSERTemplatesName();
        setUpMockData4testsetDSERTemplatesName();
        setUpMockData4testgetDSERTemplatesEnabled();
        setUpMockData4testsetDSERTemplatesEnabled();
        setUpMockData4testgetDSERTemplatesTotal();
        setUpMockData4testsetDSERTemplatesTotal();
        setUpMockData4testgetDSERTemplatesDescription();
        setUpMockData4testsetDSERTemplatesDescription();
    }

    private static void setUpMockData4testDSERTemplates() {
        testDSERTemplatesArg1 = new ERTemplate();
    }

    private static void setUpMockData4testDSERTemplates2() {
        testDSERTemplates2Arg1 = null;
    }

    private static void setUpMockData4testgetDSERTemplatesId() {
    }

    private static void setUpMockData4testsetDSERTemplatesId() {
        testsetDSERTemplatesIdArg1 = Long.valueOf(0);
    }

    private static void setUpMockData4testgetDSERTemplatesName() {
    }

    private static void setUpMockData4testsetDSERTemplatesName() {
        testsetDSERTemplatesNameArg1 = "";
    }

    private static void setUpMockData4testgetDSERTemplatesEnabled() {
    }

    private static void setUpMockData4testsetDSERTemplatesEnabled() {
        testsetDSERTemplatesEnabledArg1 = false;
    }

    private static void setUpMockData4testgetDSERTemplatesTotal() {
    }

    private static void setUpMockData4testsetDSERTemplatesTotal() {
        testsetDSERTemplatesTotalArg1 = Double.valueOf(0);
    }

    private static void setUpMockData4testgetDSERTemplatesDescription() {
    }

    private static void setUpMockData4testsetDSERTemplatesDescription() {
        testsetDSERTemplatesDescriptionArg1 = "";
    }

    @Before
    public void setUp() {
        instanceDSERTemplates = new DSERTemplates();
        instanceDSERTemplates.setDSERTemplatesId(Long.valueOf(0));
        instanceDSERTemplates.setDSERTemplatesName("");
        instanceDSERTemplates.setDSERTemplatesEnabled(false);
        instanceDSERTemplates.setDSERTemplatesTotal(Double.valueOf(0));
        instanceDSERTemplates.setDSERTemplatesDescription("");
    }

    @Test
    public void testDSERTemplates() {
        instanceDSERTemplates = new DSERTemplates(testDSERTemplatesArg1);
        assertNotNull(instanceDSERTemplates);
    }

    @Test
    public void testDSERTemplates2() {
        instanceDSERTemplates = new DSERTemplates(testDSERTemplates2Arg1);
        assertNotNull(instanceDSERTemplates);
    }

    @Test
    public void testgetDSERTemplatesId() {
        assertEquals(Long.valueOf(0), instanceDSERTemplates.getDSERTemplatesId());
    }

    @Test
    public void testsetDSERTemplatesId() {
        instanceDSERTemplates.setDSERTemplatesId(testsetDSERTemplatesIdArg1);
        assertNotNull(instanceDSERTemplates);
    }

    @Test
    public void testgetDSERTemplatesName() {
        assertEquals("", instanceDSERTemplates.getDSERTemplatesName());
    }

    @Test
    public void testsetDSERTemplatesName() {
        instanceDSERTemplates.setDSERTemplatesName(testsetDSERTemplatesNameArg1);
        assertNotNull(instanceDSERTemplates);
    }

    @Test
    public void testgetDSERTemplatesEnabled() {
        assertEquals(false, instanceDSERTemplates.getDSERTemplatesEnabled());
    }

    @Test
    public void testsetDSERTemplatesEnabled() {
        instanceDSERTemplates.setDSERTemplatesEnabled(testsetDSERTemplatesEnabledArg1);
        assertNotNull(instanceDSERTemplates);
    }

    @Test
    public void testgetDSERTemplatesTotal() {
        assertEquals(Double.valueOf(0), instanceDSERTemplates.getDSERTemplatesTotal());
    }

    @Test
    public void testsetDSERTemplatesTotal() {
        instanceDSERTemplates.setDSERTemplatesTotal(testsetDSERTemplatesTotalArg1);
        assertNotNull(instanceDSERTemplates);
    }

    @Test
    public void testgetDSERTemplatesDescription() {
        assertEquals("", instanceDSERTemplates.getDSERTemplatesDescription());
    }

    @Test
    public void testsetDSERTemplatesDescription() {
        instanceDSERTemplates.setDSERTemplatesDescription(testsetDSERTemplatesDescriptionArg1);
        assertNotNull(instanceDSERTemplates);
    }
}
