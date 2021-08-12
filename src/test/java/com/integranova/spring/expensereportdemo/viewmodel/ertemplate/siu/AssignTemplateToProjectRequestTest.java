package com.integranova.spring.expensereportdemo.viewmodel.ertemplate.siu;

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
    private static ERTemplateOid defValue4eRTemplateassignTemplateToProjectpthisERTemplate = new ERTemplateOid();
    private static ERTemplate defValue4eRTemplateassignTemplateToProjectpthisERTemplateInstance = new ERTemplate(new ERTemplateOid(Long.valueOf(0)));
    private static ProjectOid defValue4eRTemplateassignTemplateToProjectpevcProject = new ProjectOid();
    private static Project defValue4eRTemplateassignTemplateToProjectpevcProjectInstance = new Project(new ProjectOid(Long.valueOf(0)));


    // test4getERTemplateassignTemplateToProjectpthisERTemplate

    // test4setERTemplateassignTemplateToProjectpthisERTemplate
    private static ERTemplateOid test4setERTemplateassignTemplateToProjectpthisERTemplateArg1;

    // test4getERTemplateassignTemplateToProjectpevcProject

    // test4setERTemplateassignTemplateToProjectpevcProject
    private static ProjectOid test4setERTemplateassignTemplateToProjectpevcProjectArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getERTemplateassignTemplateToProjectpthisERTemplate();
        setUpMockData4test4setERTemplateassignTemplateToProjectpthisERTemplate();
        setUpMockData4test4getERTemplateassignTemplateToProjectpevcProject();
        setUpMockData4test4setERTemplateassignTemplateToProjectpevcProject();
    }

    private static void setUpMockData4test4getERTemplateassignTemplateToProjectpthisERTemplate() {
    }

    private static void setUpMockData4test4setERTemplateassignTemplateToProjectpthisERTemplate() {
        test4setERTemplateassignTemplateToProjectpthisERTemplateArg1 = new ERTemplateOid();
    }

    private static void setUpMockData4test4getERTemplateassignTemplateToProjectpevcProject() {
    }

    private static void setUpMockData4test4setERTemplateassignTemplateToProjectpevcProject() {
        test4setERTemplateassignTemplateToProjectpevcProjectArg1 = new ProjectOid();
    }

    @Before
    public void setUp() {
        instanceAssignTemplateToProjectRequest = new AssignTemplateToProjectRequest();
        instanceAssignTemplateToProjectRequest.setERTemplateassignTemplateToProjectpthisERTemplate(defValue4eRTemplateassignTemplateToProjectpthisERTemplate);
        instanceAssignTemplateToProjectRequest.setERTemplateassignTemplateToProjectpthisERTemplateInstance(defValue4eRTemplateassignTemplateToProjectpthisERTemplateInstance);
        instanceAssignTemplateToProjectRequest.setERTemplateassignTemplateToProjectpevcProject(defValue4eRTemplateassignTemplateToProjectpevcProject);
        instanceAssignTemplateToProjectRequest.setERTemplateassignTemplateToProjectpevcProjectInstance(defValue4eRTemplateassignTemplateToProjectpevcProjectInstance);
    }

    @Test
    public void test4getERTemplateassignTemplateToProjectpthisERTemplate() {
        assertEquals(defValue4eRTemplateassignTemplateToProjectpthisERTemplate, instanceAssignTemplateToProjectRequest.getERTemplateassignTemplateToProjectpthisERTemplate());
    }

    @Test
    public void test4setERTemplateassignTemplateToProjectpthisERTemplate() {
        instanceAssignTemplateToProjectRequest.setERTemplateassignTemplateToProjectpthisERTemplate(test4setERTemplateassignTemplateToProjectpthisERTemplateArg1);
        assertNotNull(instanceAssignTemplateToProjectRequest);
    }

    @Test
    public void test4getERTemplateassignTemplateToProjectpevcProject() {
        assertEquals(defValue4eRTemplateassignTemplateToProjectpevcProject, instanceAssignTemplateToProjectRequest.getERTemplateassignTemplateToProjectpevcProject());
    }

    @Test
    public void test4setERTemplateassignTemplateToProjectpevcProject() {
        instanceAssignTemplateToProjectRequest.setERTemplateassignTemplateToProjectpevcProject(test4setERTemplateassignTemplateToProjectpevcProjectArg1);
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
