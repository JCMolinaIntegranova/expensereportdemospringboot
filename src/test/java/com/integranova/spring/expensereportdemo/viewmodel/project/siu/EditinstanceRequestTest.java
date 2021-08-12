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
public class EditinstanceRequestTest {

    private EditinstanceRequest instanceEditinstanceRequest;

    // Default values
    private static ProjectOid defValue4projecteditinstancepthisProject = new ProjectOid();
    private static Project defValue4projecteditinstancepthisProjectInstance = new Project(new ProjectOid(Long.valueOf(0)));
    private static String defValue4projecteditinstancepProjectName = "";
    private static String defValue4projecteditinstancepProDescription = "";


    // test4getProjecteditinstancepthisProject

    // test4setProjecteditinstancepthisProject
    private static ProjectOid test4setProjecteditinstancepthisProjectArg1;

    // test4getProjecteditinstancepProjectName

    // test4setProjecteditinstancepProjectName
    private static String test4setProjecteditinstancepProjectNameArg1;

    // test4getProjecteditinstancepProDescription

    // test4setProjecteditinstancepProDescription
    private static String test4setProjecteditinstancepProDescriptionArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getProjecteditinstancepthisProject();
        setUpMockData4test4setProjecteditinstancepthisProject();
        setUpMockData4test4getProjecteditinstancepProjectName();
        setUpMockData4test4setProjecteditinstancepProjectName();
        setUpMockData4test4getProjecteditinstancepProDescription();
        setUpMockData4test4setProjecteditinstancepProDescription();
    }

    private static void setUpMockData4test4getProjecteditinstancepthisProject() {
    }

    private static void setUpMockData4test4setProjecteditinstancepthisProject() {
        test4setProjecteditinstancepthisProjectArg1 = new ProjectOid();
    }

    private static void setUpMockData4test4getProjecteditinstancepProjectName() {
    }

    private static void setUpMockData4test4setProjecteditinstancepProjectName() {
        test4setProjecteditinstancepProjectNameArg1 = "";
    }

    private static void setUpMockData4test4getProjecteditinstancepProDescription() {
    }

    private static void setUpMockData4test4setProjecteditinstancepProDescription() {
        test4setProjecteditinstancepProDescriptionArg1 = "";
    }

    @Before
    public void setUp() {
        instanceEditinstanceRequest = new EditinstanceRequest();
        instanceEditinstanceRequest.setProjecteditinstancepthisProject(defValue4projecteditinstancepthisProject);
        instanceEditinstanceRequest.setProjecteditinstancepthisProjectInstance(defValue4projecteditinstancepthisProjectInstance);
        instanceEditinstanceRequest.setProjecteditinstancepProjectName(defValue4projecteditinstancepProjectName);
        instanceEditinstanceRequest.setProjecteditinstancepProDescription(defValue4projecteditinstancepProDescription);
    }

    @Test
    public void test4getProjecteditinstancepthisProject() {
        assertEquals(defValue4projecteditinstancepthisProject, instanceEditinstanceRequest.getProjecteditinstancepthisProject());
    }

    @Test
    public void test4setProjecteditinstancepthisProject() {
        instanceEditinstanceRequest.setProjecteditinstancepthisProject(test4setProjecteditinstancepthisProjectArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test
    public void test4getProjecteditinstancepProjectName() {
        assertEquals(defValue4projecteditinstancepProjectName, instanceEditinstanceRequest.getProjecteditinstancepProjectName());
    }

    @Test
    public void test4setProjecteditinstancepProjectName() {
        instanceEditinstanceRequest.setProjecteditinstancepProjectName(test4setProjecteditinstancepProjectNameArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test
    public void test4getProjecteditinstancepProDescription() {
        assertEquals(defValue4projecteditinstancepProDescription, instanceEditinstanceRequest.getProjecteditinstancepProDescription());
    }

    @Test
    public void test4setProjecteditinstancepProDescription() {
        instanceEditinstanceRequest.setProjecteditinstancepProDescription(test4setProjecteditinstancepProDescriptionArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceEditinstanceRequest = new EditinstanceRequest();
    	instanceEditinstanceRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceEditinstanceRequest.checkArguments();
    }
}
