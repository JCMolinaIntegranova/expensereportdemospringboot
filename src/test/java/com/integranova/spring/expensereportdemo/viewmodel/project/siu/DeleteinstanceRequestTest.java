package com.integranova.spring.expensereportdemo.viewmodel.project.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.persistence.oid.ProjectOid;
import com.integranova.spring.expensereportdemo.persistence.Project;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DeleteinstanceRequestTest {

    private DeleteinstanceRequest instanceDeleteinstanceRequest;

    // Default values
    private static ProjectOid defValue4projectdeleteinstancepthisProject = new ProjectOid();
    private static Project defValue4projectdeleteinstancepthisProjectInstance = new Project(new ProjectOid(Long.valueOf(0)));


    // test4getProjectdeleteinstancepthisProject

    // test4setProjectdeleteinstancepthisProject
    private static ProjectOid test4setProjectdeleteinstancepthisProjectArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getProjectdeleteinstancepthisProject();
        setUpMockData4test4setProjectdeleteinstancepthisProject();
    }

    private static void setUpMockData4test4getProjectdeleteinstancepthisProject() {
    }

    private static void setUpMockData4test4setProjectdeleteinstancepthisProject() {
        test4setProjectdeleteinstancepthisProjectArg1 = new ProjectOid();
    }

    @Before
    public void setUp() {
        instanceDeleteinstanceRequest = new DeleteinstanceRequest();
        instanceDeleteinstanceRequest.setProjectdeleteinstancepthisProject(defValue4projectdeleteinstancepthisProject);
        instanceDeleteinstanceRequest.setProjectdeleteinstancepthisProjectInstance(defValue4projectdeleteinstancepthisProjectInstance);
    }

    @Test
    public void test4getProjectdeleteinstancepthisProject() {
        assertEquals(defValue4projectdeleteinstancepthisProject, instanceDeleteinstanceRequest.getProjectdeleteinstancepthisProject());
    }

    @Test
    public void test4setProjectdeleteinstancepthisProject() {
        instanceDeleteinstanceRequest.setProjectdeleteinstancepthisProject(test4setProjectdeleteinstancepthisProjectArg1);
        assertNotNull(instanceDeleteinstanceRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceDeleteinstanceRequest = new DeleteinstanceRequest();
    	instanceDeleteinstanceRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceDeleteinstanceRequest.checkArguments();
    }
}
