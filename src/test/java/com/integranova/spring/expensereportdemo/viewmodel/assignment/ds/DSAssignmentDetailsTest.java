package com.integranova.spring.expensereportdemo.viewmodel.assignment.ds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.persistence.Assignment;
import java.sql.Date;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DSAssignmentDetailsTest {

    private DSAssignmentDetails instanceDSAssignmentDetails;

    // testDSAssignmentDetails
    private static Assignment testDSAssignmentDetailsArg1;

    // testDSAssignmentDetails2
    private static Assignment testDSAssignmentDetails2Arg1;

    // testgetDSAssignmentDetailsProjectDotProjectName

    // testsetDSAssignmentDetailsProjectDotProjectName
    private static String testsetDSAssignmentDetailsProjectDotProjectNameArg1;

    // testgetDSAssignmentDetailsProjectDotProDescription

    // testsetDSAssignmentDetailsProjectDotProDescription
    private static String testsetDSAssignmentDetailsProjectDotProDescriptionArg1;

    // testgetDSAssignmentDetailsEmployeeDotEmpFullName

    // testsetDSAssignmentDetailsEmployeeDotEmpFullName
    private static String testsetDSAssignmentDetailsEmployeeDotEmpFullNameArg1;

    // testgetDSAssignmentDetailsFromDate

    // testsetDSAssignmentDetailsFromDate
    private static Date testsetDSAssignmentDetailsFromDateArg1;

    // testgetDSAssignmentDetailsToDate

    // testsetDSAssignmentDetailsToDate
    private static Date testsetDSAssignmentDetailsToDateArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testDSAssignmentDetails();
        setUpMockData4testDSAssignmentDetails2();
        setUpMockData4testgetDSAssignmentDetailsProjectDotProjectName();
        setUpMockData4testsetDSAssignmentDetailsProjectDotProjectName();
        setUpMockData4testgetDSAssignmentDetailsProjectDotProDescription();
        setUpMockData4testsetDSAssignmentDetailsProjectDotProDescription();
        setUpMockData4testgetDSAssignmentDetailsEmployeeDotEmpFullName();
        setUpMockData4testsetDSAssignmentDetailsEmployeeDotEmpFullName();
        setUpMockData4testgetDSAssignmentDetailsFromDate();
        setUpMockData4testsetDSAssignmentDetailsFromDate();
        setUpMockData4testgetDSAssignmentDetailsToDate();
        setUpMockData4testsetDSAssignmentDetailsToDate();
    }

    private static void setUpMockData4testDSAssignmentDetails() {
        testDSAssignmentDetailsArg1 = new Assignment();
    }

    private static void setUpMockData4testDSAssignmentDetails2() {
        testDSAssignmentDetails2Arg1 = null;
    }

    private static void setUpMockData4testgetDSAssignmentDetailsProjectDotProjectName() {
    }

    private static void setUpMockData4testsetDSAssignmentDetailsProjectDotProjectName() {
        testsetDSAssignmentDetailsProjectDotProjectNameArg1 = "";
    }

    private static void setUpMockData4testgetDSAssignmentDetailsProjectDotProDescription() {
    }

    private static void setUpMockData4testsetDSAssignmentDetailsProjectDotProDescription() {
        testsetDSAssignmentDetailsProjectDotProDescriptionArg1 = "";
    }

    private static void setUpMockData4testgetDSAssignmentDetailsEmployeeDotEmpFullName() {
    }

    private static void setUpMockData4testsetDSAssignmentDetailsEmployeeDotEmpFullName() {
        testsetDSAssignmentDetailsEmployeeDotEmpFullNameArg1 = "";
    }

    private static void setUpMockData4testgetDSAssignmentDetailsFromDate() {
    }

    private static void setUpMockData4testsetDSAssignmentDetailsFromDate() {
        testsetDSAssignmentDetailsFromDateArg1 = Date.valueOf(Constants.DATE_DEFAULTVALUE);
    }

    private static void setUpMockData4testgetDSAssignmentDetailsToDate() {
    }

    private static void setUpMockData4testsetDSAssignmentDetailsToDate() {
        testsetDSAssignmentDetailsToDateArg1 = Date.valueOf(Constants.DATE_DEFAULTVALUE);
    }

    @Before
    public void setUp() {
        instanceDSAssignmentDetails = new DSAssignmentDetails();
        instanceDSAssignmentDetails.setDSAssignmentDetailsProjectDotProjectName("");
        instanceDSAssignmentDetails.setDSAssignmentDetailsProjectDotProDescription("");
        instanceDSAssignmentDetails.setDSAssignmentDetailsEmployeeDotEmpFullName("");
        instanceDSAssignmentDetails.setDSAssignmentDetailsFromDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
        instanceDSAssignmentDetails.setDSAssignmentDetailsToDate(Date.valueOf(Constants.DATE_DEFAULTVALUE));
    }

    @Test
    public void testDSAssignmentDetails() {
        instanceDSAssignmentDetails = new DSAssignmentDetails(testDSAssignmentDetailsArg1);
        assertNotNull(instanceDSAssignmentDetails);
    }

    @Test
    public void testDSAssignmentDetails2() {
        instanceDSAssignmentDetails = new DSAssignmentDetails(testDSAssignmentDetails2Arg1);
        assertNotNull(instanceDSAssignmentDetails);
    }

    @Test
    public void testgetDSAssignmentDetailsProjectDotProjectName() {
        assertEquals("", instanceDSAssignmentDetails.getDSAssignmentDetailsProjectDotProjectName());
    }

    @Test
    public void testsetDSAssignmentDetailsProjectDotProjectName() {
        instanceDSAssignmentDetails.setDSAssignmentDetailsProjectDotProjectName(testsetDSAssignmentDetailsProjectDotProjectNameArg1);
        assertNotNull(instanceDSAssignmentDetails);
    }

    @Test
    public void testgetDSAssignmentDetailsProjectDotProDescription() {
        assertEquals("", instanceDSAssignmentDetails.getDSAssignmentDetailsProjectDotProDescription());
    }

    @Test
    public void testsetDSAssignmentDetailsProjectDotProDescription() {
        instanceDSAssignmentDetails.setDSAssignmentDetailsProjectDotProDescription(testsetDSAssignmentDetailsProjectDotProDescriptionArg1);
        assertNotNull(instanceDSAssignmentDetails);
    }

    @Test
    public void testgetDSAssignmentDetailsEmployeeDotEmpFullName() {
        assertEquals("", instanceDSAssignmentDetails.getDSAssignmentDetailsEmployeeDotEmpFullName());
    }

    @Test
    public void testsetDSAssignmentDetailsEmployeeDotEmpFullName() {
        instanceDSAssignmentDetails.setDSAssignmentDetailsEmployeeDotEmpFullName(testsetDSAssignmentDetailsEmployeeDotEmpFullNameArg1);
        assertNotNull(instanceDSAssignmentDetails);
    }

    @Test
    public void testgetDSAssignmentDetailsFromDate() {
        assertEquals(Date.valueOf(Constants.DATE_DEFAULTVALUE), instanceDSAssignmentDetails.getDSAssignmentDetailsFromDate());
    }

    @Test
    public void testsetDSAssignmentDetailsFromDate() {
        instanceDSAssignmentDetails.setDSAssignmentDetailsFromDate(testsetDSAssignmentDetailsFromDateArg1);
        assertNotNull(instanceDSAssignmentDetails);
    }

    @Test
    public void testgetDSAssignmentDetailsToDate() {
        assertEquals(Date.valueOf(Constants.DATE_DEFAULTVALUE), instanceDSAssignmentDetails.getDSAssignmentDetailsToDate());
    }

    @Test
    public void testsetDSAssignmentDetailsToDate() {
        instanceDSAssignmentDetails.setDSAssignmentDetailsToDate(testsetDSAssignmentDetailsToDateArg1);
        assertNotNull(instanceDSAssignmentDetails);
    }
}
