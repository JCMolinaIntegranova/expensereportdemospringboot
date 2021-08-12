package com.integranova.spring.expensereportdemo.viewmodel.erltemplate.ds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.persistence.ERLTemplate;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DSTemplateLinesTest {

    private DSTemplateLines instanceDSTemplateLines;

    // testDSTemplateLines
    private static ERLTemplate testDSTemplateLinesArg1;

    // testDSTemplateLines2
    private static ERLTemplate testDSTemplateLines2Arg1;

    // testgetDSTemplateLinesId

    // testsetDSTemplateLinesId
    private static Long testsetDSTemplateLinesIdArg1;

    // testgetDSTemplateLinesUnits

    // testsetDSTemplateLinesUnits
    private static Double testsetDSTemplateLinesUnitsArg1;

    // testgetDSTemplateLinesDescription

    // testsetDSTemplateLinesDescription
    private static String testsetDSTemplateLinesDescriptionArg1;

    // testgetDSTemplateLinesPrice

    // testsetDSTemplateLinesPrice
    private static Double testsetDSTemplateLinesPriceArg1;

    // testgetDSTemplateLinesTotalLine

    // testsetDSTemplateLinesTotalLine
    private static Double testsetDSTemplateLinesTotalLineArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testDSTemplateLines();
        setUpMockData4testDSTemplateLines2();
        setUpMockData4testgetDSTemplateLinesId();
        setUpMockData4testsetDSTemplateLinesId();
        setUpMockData4testgetDSTemplateLinesUnits();
        setUpMockData4testsetDSTemplateLinesUnits();
        setUpMockData4testgetDSTemplateLinesDescription();
        setUpMockData4testsetDSTemplateLinesDescription();
        setUpMockData4testgetDSTemplateLinesPrice();
        setUpMockData4testsetDSTemplateLinesPrice();
        setUpMockData4testgetDSTemplateLinesTotalLine();
        setUpMockData4testsetDSTemplateLinesTotalLine();
    }

    private static void setUpMockData4testDSTemplateLines() {
        testDSTemplateLinesArg1 = new ERLTemplate();
    }

    private static void setUpMockData4testDSTemplateLines2() {
        testDSTemplateLines2Arg1 = null;
    }

    private static void setUpMockData4testgetDSTemplateLinesId() {
    }

    private static void setUpMockData4testsetDSTemplateLinesId() {
        testsetDSTemplateLinesIdArg1 = Long.valueOf(0);
    }

    private static void setUpMockData4testgetDSTemplateLinesUnits() {
    }

    private static void setUpMockData4testsetDSTemplateLinesUnits() {
        testsetDSTemplateLinesUnitsArg1 = Double.valueOf(0);
    }

    private static void setUpMockData4testgetDSTemplateLinesDescription() {
    }

    private static void setUpMockData4testsetDSTemplateLinesDescription() {
        testsetDSTemplateLinesDescriptionArg1 = "";
    }

    private static void setUpMockData4testgetDSTemplateLinesPrice() {
    }

    private static void setUpMockData4testsetDSTemplateLinesPrice() {
        testsetDSTemplateLinesPriceArg1 = Double.valueOf(0);
    }

    private static void setUpMockData4testgetDSTemplateLinesTotalLine() {
    }

    private static void setUpMockData4testsetDSTemplateLinesTotalLine() {
        testsetDSTemplateLinesTotalLineArg1 = Double.valueOf(0);
    }

    @Before
    public void setUp() {
        instanceDSTemplateLines = new DSTemplateLines();
        instanceDSTemplateLines.setDSTemplateLinesId(Long.valueOf(0));
        instanceDSTemplateLines.setDSTemplateLinesUnits(Double.valueOf(0));
        instanceDSTemplateLines.setDSTemplateLinesDescription("");
        instanceDSTemplateLines.setDSTemplateLinesPrice(Double.valueOf(0));
        instanceDSTemplateLines.setDSTemplateLinesTotalLine(Double.valueOf(0));
    }

    @Test
    public void testDSTemplateLines() {
        instanceDSTemplateLines = new DSTemplateLines(testDSTemplateLinesArg1);
        assertNotNull(instanceDSTemplateLines);
    }

    @Test
    public void testDSTemplateLines2() {
        instanceDSTemplateLines = new DSTemplateLines(testDSTemplateLines2Arg1);
        assertNotNull(instanceDSTemplateLines);
    }

    @Test
    public void testgetDSTemplateLinesId() {
        assertEquals(Long.valueOf(0), instanceDSTemplateLines.getDSTemplateLinesId());
    }

    @Test
    public void testsetDSTemplateLinesId() {
        instanceDSTemplateLines.setDSTemplateLinesId(testsetDSTemplateLinesIdArg1);
        assertNotNull(instanceDSTemplateLines);
    }

    @Test
    public void testgetDSTemplateLinesUnits() {
        assertEquals(Double.valueOf(0), instanceDSTemplateLines.getDSTemplateLinesUnits());
    }

    @Test
    public void testsetDSTemplateLinesUnits() {
        instanceDSTemplateLines.setDSTemplateLinesUnits(testsetDSTemplateLinesUnitsArg1);
        assertNotNull(instanceDSTemplateLines);
    }

    @Test
    public void testgetDSTemplateLinesDescription() {
        assertEquals("", instanceDSTemplateLines.getDSTemplateLinesDescription());
    }

    @Test
    public void testsetDSTemplateLinesDescription() {
        instanceDSTemplateLines.setDSTemplateLinesDescription(testsetDSTemplateLinesDescriptionArg1);
        assertNotNull(instanceDSTemplateLines);
    }

    @Test
    public void testgetDSTemplateLinesPrice() {
        assertEquals(Double.valueOf(0), instanceDSTemplateLines.getDSTemplateLinesPrice());
    }

    @Test
    public void testsetDSTemplateLinesPrice() {
        instanceDSTemplateLines.setDSTemplateLinesPrice(testsetDSTemplateLinesPriceArg1);
        assertNotNull(instanceDSTemplateLines);
    }

    @Test
    public void testgetDSTemplateLinesTotalLine() {
        assertEquals(Double.valueOf(0), instanceDSTemplateLines.getDSTemplateLinesTotalLine());
    }

    @Test
    public void testsetDSTemplateLinesTotalLine() {
        instanceDSTemplateLines.setDSTemplateLinesTotalLine(testsetDSTemplateLinesTotalLineArg1);
        assertNotNull(instanceDSTemplateLines);
    }
}
