package com.integranova.spring.expensereportdemo.viewmodel.project.ds;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.persistence.Project;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DSProjectSupTest {

    private DSProjectSup instanceDSProjectSup;

    // testDSProjectSup
    private static Project testDSProjectSupArg1;

    // testDSProjectSup2
    private static Project testDSProjectSup2Arg1;

    // testgetDSProjectSupProjectName

    // testsetDSProjectSupProjectName
    private static String testsetDSProjectSupProjectNameArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testDSProjectSup();
        setUpMockData4testDSProjectSup2();
        setUpMockData4testgetDSProjectSupProjectName();
        setUpMockData4testsetDSProjectSupProjectName();
    }

    private static void setUpMockData4testDSProjectSup() {
        testDSProjectSupArg1 = new Project();
    }

    private static void setUpMockData4testDSProjectSup2() {
        testDSProjectSup2Arg1 = null;
    }

    private static void setUpMockData4testgetDSProjectSupProjectName() {
    }

    private static void setUpMockData4testsetDSProjectSupProjectName() {
        testsetDSProjectSupProjectNameArg1 = "";
    }

    @Before
    public void setUp() {
        instanceDSProjectSup = new DSProjectSup();
        instanceDSProjectSup.setDSProjectSupProjectName("");
    }

    @Test
    public void testDSProjectSup() {
        instanceDSProjectSup = new DSProjectSup(testDSProjectSupArg1);
        assertNotNull(instanceDSProjectSup);
    }

    @Test
    public void testDSProjectSup2() {
        instanceDSProjectSup = new DSProjectSup(testDSProjectSup2Arg1);
        assertNotNull(instanceDSProjectSup);
    }

    @Test
    public void testgetDSProjectSupProjectName() {
        assertEquals("", instanceDSProjectSup.getDSProjectSupProjectName());
    }

    @Test
    public void testsetDSProjectSupProjectName() {
        instanceDSProjectSup.setDSProjectSupProjectName(testsetDSProjectSupProjectNameArg1);
        assertNotNull(instanceDSProjectSup);
    }
}
