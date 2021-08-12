package com.integranova.spring.expensereportdemo.viewmodel.assignment.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.persistence.oid.ProjectOid;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FAssignmentsTest {

    private FAssignments instanceFAssignments;

    // testgetVProject

    // testsetVProject
    private static ProjectOid testsetVProjectArg1;

    // testgetVName

    // testsetVName
    private static String testsetVNameArg1;

    // testgetVSurname

    // testsetVSurname
    private static String testsetVSurnameArg1;

    // testgetVActive

    // testsetVActive
    private static Boolean testsetVActiveArg1;

    // testbuildFilterRequest

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testgetVProject();
        setUpMockData4testsetVProject();
        setUpMockData4testgetVName();
        setUpMockData4testsetVName();
        setUpMockData4testgetVSurname();
        setUpMockData4testsetVSurname();
        setUpMockData4testgetVActive();
        setUpMockData4testsetVActive();
        setUpMockData4testbuildFilterRequest();
    }

    private static void setUpMockData4testgetVProject() {
    }

    private static void setUpMockData4testsetVProject() {
        testsetVProjectArg1 = new ProjectOid();
    }

    private static void setUpMockData4testgetVName() {
    }

    private static void setUpMockData4testsetVName() {
        testsetVNameArg1 = "";
    }

    private static void setUpMockData4testgetVSurname() {
    }

    private static void setUpMockData4testsetVSurname() {
        testsetVSurnameArg1 = "";
    }

    private static void setUpMockData4testgetVActive() {
    }

    private static void setUpMockData4testsetVActive() {
        testsetVActiveArg1 = false;
    }

    private static void setUpMockData4testbuildFilterRequest() {
    }

    @Before
    public void setUp() {
        instanceFAssignments = new FAssignments();
        instanceFAssignments.setVProject(new ProjectOid());
        instanceFAssignments.setVName("");
        instanceFAssignments.setVSurname("");
        instanceFAssignments.setVActive(false);
    }

    @Test
    public void testgetVProject() {
        assertEquals(new ProjectOid(), instanceFAssignments.getVProject());
    }

    @Test
    public void testsetVProject() {
        instanceFAssignments.setVProject(testsetVProjectArg1);
        assertNotNull(instanceFAssignments);
    }

    @Test
    public void testgetVName() {
        assertEquals("", instanceFAssignments.getVName());
    }

    @Test
    public void testsetVName() {
        instanceFAssignments.setVName(testsetVNameArg1);
        assertNotNull(instanceFAssignments);
    }

    @Test
    public void testgetVSurname() {
        assertEquals("", instanceFAssignments.getVSurname());
    }

    @Test
    public void testsetVSurname() {
        instanceFAssignments.setVSurname(testsetVSurnameArg1);
        assertNotNull(instanceFAssignments);
    }

    @Test
    public void testgetVActive() {
        assertEquals(false, instanceFAssignments.getVActive());
    }

    @Test
    public void testsetVActive() {
        instanceFAssignments.setVActive(testsetVActiveArg1);
        assertNotNull(instanceFAssignments);
    }

    @Test
    public void testbuildFilterRequest() {
        instanceFAssignments.buildFilterRequest();
        assertNotNull(instanceFAssignments);
    }
}
