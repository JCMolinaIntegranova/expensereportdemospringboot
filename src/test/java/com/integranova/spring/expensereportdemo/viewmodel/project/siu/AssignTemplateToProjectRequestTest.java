package com.integranova.spring.expensereportdemo.viewmodel.project.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.persistence.ERTemplate;
import com.integranova.spring.expensereportdemo.persistence.oid.ERTemplateOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ProjectOid;
import com.integranova.spring.expensereportdemo.persistence.Project;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssignTemplateToProjectRequestTest {

    private AssignTemplateToProjectRequest instanceAssignTemplateToProjectRequest;

    // Default values
    private static ProjectOid defValue4projectassignTemplateToProjectpthisProject = new ProjectOid();
    private static Project defValue4projectassignTemplateToProjectpthisProjectInstance = new Project(new ProjectOid(Long.valueOf(0)));
    private static ERTemplateOid defValue4projectassignTemplateToProjectpevcERTemplate = new ERTemplateOid();
    private static ERTemplate defValue4projectassignTemplateToProjectpevcERTemplateInstance = new ERTemplate(new ERTemplateOid(Long.valueOf(0)));


    // test4getProjectassignTemplateToProjectpthisProject

    // test4setProjectassignTemplateToProjectpthisProject
    private static ProjectOid test4setProjectassignTemplateToProjectpthisProjectArg1;

    // test4getProjectassignTemplateToProjectpevcERTemplate

    // test4setProjectassignTemplateToProjectpevcERTemplate
    private static ERTemplateOid test4setProjectassignTemplateToProjectpevcERTemplateArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getProjectassignTemplateToProjectpthisProject();
        setUpMockData4test4setProjectassignTemplateToProjectpthisProject();
        setUpMockData4test4getProjectassignTemplateToProjectpevcERTemplate();
        setUpMockData4test4setProjectassignTemplateToProjectpevcERTemplate();
    }

    private static void setUpMockData4test4getProjectassignTemplateToProjectpthisProject() {
    }

    private static void setUpMockData4test4setProjectassignTemplateToProjectpthisProject() {
        test4setProjectassignTemplateToProjectpthisProjectArg1 = new ProjectOid();
    }

    private static void setUpMockData4test4getProjectassignTemplateToProjectpevcERTemplate() {
    }

    private static void setUpMockData4test4setProjectassignTemplateToProjectpevcERTemplate() {
        test4setProjectassignTemplateToProjectpevcERTemplateArg1 = new ERTemplateOid();
    }

    @Before
    public void setUp() {
        instanceAssignTemplateToProjectRequest = new AssignTemplateToProjectRequest();
        instanceAssignTemplateToProjectRequest.setProjectassignTemplateToProjectpthisProject(defValue4projectassignTemplateToProjectpthisProject);
        instanceAssignTemplateToProjectRequest.setProjectassignTemplateToProjectpthisProjectInstance(defValue4projectassignTemplateToProjectpthisProjectInstance);
        instanceAssignTemplateToProjectRequest.setProjectassignTemplateToProjectpevcERTemplate(defValue4projectassignTemplateToProjectpevcERTemplate);
        instanceAssignTemplateToProjectRequest.setProjectassignTemplateToProjectpevcERTemplateInstance(defValue4projectassignTemplateToProjectpevcERTemplateInstance);
    }

    @Test
    public void test4getProjectassignTemplateToProjectpthisProject() {
        assertEquals(defValue4projectassignTemplateToProjectpthisProject, instanceAssignTemplateToProjectRequest.getProjectassignTemplateToProjectpthisProject());
    }

    @Test
    public void test4setProjectassignTemplateToProjectpthisProject() {
        instanceAssignTemplateToProjectRequest.setProjectassignTemplateToProjectpthisProject(test4setProjectassignTemplateToProjectpthisProjectArg1);
        assertNotNull(instanceAssignTemplateToProjectRequest);
    }

    @Test
    public void test4getProjectassignTemplateToProjectpevcERTemplate() {
        assertEquals(defValue4projectassignTemplateToProjectpevcERTemplate, instanceAssignTemplateToProjectRequest.getProjectassignTemplateToProjectpevcERTemplate());
    }

    @Test
    public void test4setProjectassignTemplateToProjectpevcERTemplate() {
        instanceAssignTemplateToProjectRequest.setProjectassignTemplateToProjectpevcERTemplate(test4setProjectassignTemplateToProjectpevcERTemplateArg1);
        assertNotNull(instanceAssignTemplateToProjectRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceAssignTemplateToProjectRequest = new AssignTemplateToProjectRequest();
    	instanceAssignTemplateToProjectRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceAssignTemplateToProjectRequest.checkArguments();
    }
}
