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
public class DeassignTemplateRequestTest {

    private DeassignTemplateRequest instanceDeassignTemplateRequest;

    // Default values
    private static ProjectOid defValue4projectdeassignTemplatepthisProject = new ProjectOid();
    private static Project defValue4projectdeassignTemplatepthisProjectInstance = new Project(new ProjectOid(Long.valueOf(0)));
    private static ERTemplateOid defValue4projectdeassignTemplatepevcERTemplate = new ERTemplateOid();
    private static ERTemplate defValue4projectdeassignTemplatepevcERTemplateInstance = new ERTemplate(new ERTemplateOid(Long.valueOf(0)));


    // test4getProjectdeassignTemplatepthisProject

    // test4setProjectdeassignTemplatepthisProject
    private static ProjectOid test4setProjectdeassignTemplatepthisProjectArg1;

    // test4getProjectdeassignTemplatepevcERTemplate

    // test4setProjectdeassignTemplatepevcERTemplate
    private static ERTemplateOid test4setProjectdeassignTemplatepevcERTemplateArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getProjectdeassignTemplatepthisProject();
        setUpMockData4test4setProjectdeassignTemplatepthisProject();
        setUpMockData4test4getProjectdeassignTemplatepevcERTemplate();
        setUpMockData4test4setProjectdeassignTemplatepevcERTemplate();
    }

    private static void setUpMockData4test4getProjectdeassignTemplatepthisProject() {
    }

    private static void setUpMockData4test4setProjectdeassignTemplatepthisProject() {
        test4setProjectdeassignTemplatepthisProjectArg1 = new ProjectOid();
    }

    private static void setUpMockData4test4getProjectdeassignTemplatepevcERTemplate() {
    }

    private static void setUpMockData4test4setProjectdeassignTemplatepevcERTemplate() {
        test4setProjectdeassignTemplatepevcERTemplateArg1 = new ERTemplateOid();
    }

    @Before
    public void setUp() {
        instanceDeassignTemplateRequest = new DeassignTemplateRequest();
        instanceDeassignTemplateRequest.setProjectdeassignTemplatepthisProject(defValue4projectdeassignTemplatepthisProject);
        instanceDeassignTemplateRequest.setProjectdeassignTemplatepthisProjectInstance(defValue4projectdeassignTemplatepthisProjectInstance);
        instanceDeassignTemplateRequest.setProjectdeassignTemplatepevcERTemplate(defValue4projectdeassignTemplatepevcERTemplate);
        instanceDeassignTemplateRequest.setProjectdeassignTemplatepevcERTemplateInstance(defValue4projectdeassignTemplatepevcERTemplateInstance);
    }

    @Test
    public void test4getProjectdeassignTemplatepthisProject() {
        assertEquals(defValue4projectdeassignTemplatepthisProject, instanceDeassignTemplateRequest.getProjectdeassignTemplatepthisProject());
    }

    @Test
    public void test4setProjectdeassignTemplatepthisProject() {
        instanceDeassignTemplateRequest.setProjectdeassignTemplatepthisProject(test4setProjectdeassignTemplatepthisProjectArg1);
        assertNotNull(instanceDeassignTemplateRequest);
    }

    @Test
    public void test4getProjectdeassignTemplatepevcERTemplate() {
        assertEquals(defValue4projectdeassignTemplatepevcERTemplate, instanceDeassignTemplateRequest.getProjectdeassignTemplatepevcERTemplate());
    }

    @Test
    public void test4setProjectdeassignTemplatepevcERTemplate() {
        instanceDeassignTemplateRequest.setProjectdeassignTemplatepevcERTemplate(test4setProjectdeassignTemplatepevcERTemplateArg1);
        assertNotNull(instanceDeassignTemplateRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceDeassignTemplateRequest = new DeassignTemplateRequest();
    	instanceDeassignTemplateRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceDeassignTemplateRequest.checkArguments();
    }
}
