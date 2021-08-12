package com.integranova.spring.expensereportdemo.viewmodel.assignment.ds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.persistence.Assignment;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DSAssignmentsTest {

    private DSAssignments instanceDSAssignments;

    // testDSAssignments
    private static Assignment testDSAssignmentsArg1;

    // testDSAssignments2
    private static Assignment testDSAssignments2Arg1;

    // testgetDSAssignmentsProjectDotProjectName

    // testsetDSAssignmentsProjectDotProjectName
    private static String testsetDSAssignmentsProjectDotProjectNameArg1;

    // testgetDSAssignmentsEmployeeDotEmpFullName

    // testsetDSAssignmentsEmployeeDotEmpFullName
    private static String testsetDSAssignmentsEmployeeDotEmpFullNameArg1;

    // testgetDSAssignmentsIsActive

    // testsetDSAssignmentsIsActive
    private static Boolean testsetDSAssignmentsIsActiveArg1;

    // testgetDSAssignmentsDetails

    // testsetDSAssignmentsDetails
    private static String testsetDSAssignmentsDetailsArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testDSAssignments();
        setUpMockData4testDSAssignments2();
        setUpMockData4testgetDSAssignmentsProjectDotProjectName();
        setUpMockData4testsetDSAssignmentsProjectDotProjectName();
        setUpMockData4testgetDSAssignmentsEmployeeDotEmpFullName();
        setUpMockData4testsetDSAssignmentsEmployeeDotEmpFullName();
        setUpMockData4testgetDSAssignmentsIsActive();
        setUpMockData4testsetDSAssignmentsIsActive();
        setUpMockData4testgetDSAssignmentsDetails();
        setUpMockData4testsetDSAssignmentsDetails();
    }

    private static void setUpMockData4testDSAssignments() {
        testDSAssignmentsArg1 = new Assignment();
    }

    private static void setUpMockData4testDSAssignments2() {
        testDSAssignments2Arg1 = null;
    }

    private static void setUpMockData4testgetDSAssignmentsProjectDotProjectName() {
    }

    private static void setUpMockData4testsetDSAssignmentsProjectDotProjectName() {
        testsetDSAssignmentsProjectDotProjectNameArg1 = "";
    }

    private static void setUpMockData4testgetDSAssignmentsEmployeeDotEmpFullName() {
    }

    private static void setUpMockData4testsetDSAssignmentsEmployeeDotEmpFullName() {
        testsetDSAssignmentsEmployeeDotEmpFullNameArg1 = "";
    }

    private static void setUpMockData4testgetDSAssignmentsIsActive() {
    }

    private static void setUpMockData4testsetDSAssignmentsIsActive() {
        testsetDSAssignmentsIsActiveArg1 = false;
    }

    private static void setUpMockData4testgetDSAssignmentsDetails() {
    }

    private static void setUpMockData4testsetDSAssignmentsDetails() {
        testsetDSAssignmentsDetailsArg1 = "";
    }

    @Before
    public void setUp() {
        instanceDSAssignments = new DSAssignments();
        instanceDSAssignments.setDSAssignmentsProjectDotProjectName("");
        instanceDSAssignments.setDSAssignmentsEmployeeDotEmpFullName("");
        instanceDSAssignments.setDSAssignmentsIsActive(false);
        instanceDSAssignments.setDSAssignmentsDetails("");
    }

    @Test
    public void testDSAssignments() {
        instanceDSAssignments = new DSAssignments(testDSAssignmentsArg1);
        assertNotNull(instanceDSAssignments);
    }

    @Test
    public void testDSAssignments2() {
        instanceDSAssignments = new DSAssignments(testDSAssignments2Arg1);
        assertNotNull(instanceDSAssignments);
    }

    @Test
    public void testgetDSAssignmentsProjectDotProjectName() {
        assertEquals("", instanceDSAssignments.getDSAssignmentsProjectDotProjectName());
    }

    @Test
    public void testsetDSAssignmentsProjectDotProjectName() {
        instanceDSAssignments.setDSAssignmentsProjectDotProjectName(testsetDSAssignmentsProjectDotProjectNameArg1);
        assertNotNull(instanceDSAssignments);
    }

    @Test
    public void testgetDSAssignmentsEmployeeDotEmpFullName() {
        assertEquals("", instanceDSAssignments.getDSAssignmentsEmployeeDotEmpFullName());
    }

    @Test
    public void testsetDSAssignmentsEmployeeDotEmpFullName() {
        instanceDSAssignments.setDSAssignmentsEmployeeDotEmpFullName(testsetDSAssignmentsEmployeeDotEmpFullNameArg1);
        assertNotNull(instanceDSAssignments);
    }

    @Test
    public void testgetDSAssignmentsIsActive() {
        assertEquals(false, instanceDSAssignments.getDSAssignmentsIsActive());
    }

    @Test
    public void testsetDSAssignmentsIsActive() {
        instanceDSAssignments.setDSAssignmentsIsActive(testsetDSAssignmentsIsActiveArg1);
        assertNotNull(instanceDSAssignments);
    }

    @Test
    public void testgetDSAssignmentsDetails() {
        assertEquals("", instanceDSAssignments.getDSAssignmentsDetails());
    }

    @Test
    public void testsetDSAssignmentsDetails() {
        instanceDSAssignments.setDSAssignmentsDetails(testsetDSAssignmentsDetailsArg1);
        assertNotNull(instanceDSAssignments);
    }
}
