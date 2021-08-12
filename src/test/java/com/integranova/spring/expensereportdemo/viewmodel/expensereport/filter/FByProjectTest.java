package com.integranova.spring.expensereportdemo.viewmodel.expensereport.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.persistence.oid.ProjectOid;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FByProjectTest {

    private FByProject instanceFByProject;

    // testgetVfProject

    // testsetVfProject
    private static ProjectOid testsetVfProjectArg1;

    // testbuildFilterRequest

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testgetVfProject();
        setUpMockData4testsetVfProject();
        setUpMockData4testbuildFilterRequest();
    }

    private static void setUpMockData4testgetVfProject() {
    }

    private static void setUpMockData4testsetVfProject() {
        testsetVfProjectArg1 = new ProjectOid();
    }

    private static void setUpMockData4testbuildFilterRequest() {
    }

    @Before
    public void setUp() {
        instanceFByProject = new FByProject();
        instanceFByProject.setVfProject(new ProjectOid());
    }

    @Test
    public void testgetVfProject() {
        assertEquals(new ProjectOid(), instanceFByProject.getVfProject());
    }

    @Test
    public void testsetVfProject() {
        instanceFByProject.setVfProject(testsetVfProjectArg1);
        assertNotNull(instanceFByProject);
    }

    @Test
    public void testbuildFilterRequest() {
        instanceFByProject.buildFilterRequest();
        assertNotNull(instanceFByProject);
    }
}
