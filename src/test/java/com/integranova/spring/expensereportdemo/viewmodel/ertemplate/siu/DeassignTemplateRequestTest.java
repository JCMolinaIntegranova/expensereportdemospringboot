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
public class DeassignTemplateRequestTest {

    private DeassignTemplateRequest instanceDeassignTemplateRequest;

    // Default values
    private static ERTemplateOid defValue4eRTemplatedeassignTemplatepthisERTemplate = new ERTemplateOid();
    private static ERTemplate defValue4eRTemplatedeassignTemplatepthisERTemplateInstance = new ERTemplate(new ERTemplateOid(Long.valueOf(0)));
    private static ProjectOid defValue4eRTemplatedeassignTemplatepevcProject = new ProjectOid();
    private static Project defValue4eRTemplatedeassignTemplatepevcProjectInstance = new Project(new ProjectOid(Long.valueOf(0)));


    // test4getERTemplatedeassignTemplatepthisERTemplate

    // test4setERTemplatedeassignTemplatepthisERTemplate
    private static ERTemplateOid test4setERTemplatedeassignTemplatepthisERTemplateArg1;

    // test4getERTemplatedeassignTemplatepevcProject

    // test4setERTemplatedeassignTemplatepevcProject
    private static ProjectOid test4setERTemplatedeassignTemplatepevcProjectArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getERTemplatedeassignTemplatepthisERTemplate();
        setUpMockData4test4setERTemplatedeassignTemplatepthisERTemplate();
        setUpMockData4test4getERTemplatedeassignTemplatepevcProject();
        setUpMockData4test4setERTemplatedeassignTemplatepevcProject();
    }

    private static void setUpMockData4test4getERTemplatedeassignTemplatepthisERTemplate() {
    }

    private static void setUpMockData4test4setERTemplatedeassignTemplatepthisERTemplate() {
        test4setERTemplatedeassignTemplatepthisERTemplateArg1 = new ERTemplateOid();
    }

    private static void setUpMockData4test4getERTemplatedeassignTemplatepevcProject() {
    }

    private static void setUpMockData4test4setERTemplatedeassignTemplatepevcProject() {
        test4setERTemplatedeassignTemplatepevcProjectArg1 = new ProjectOid();
    }

    @Before
    public void setUp() {
        instanceDeassignTemplateRequest = new DeassignTemplateRequest();
        instanceDeassignTemplateRequest.setERTemplatedeassignTemplatepthisERTemplate(defValue4eRTemplatedeassignTemplatepthisERTemplate);
        instanceDeassignTemplateRequest.setERTemplatedeassignTemplatepthisERTemplateInstance(defValue4eRTemplatedeassignTemplatepthisERTemplateInstance);
        instanceDeassignTemplateRequest.setERTemplatedeassignTemplatepevcProject(defValue4eRTemplatedeassignTemplatepevcProject);
        instanceDeassignTemplateRequest.setERTemplatedeassignTemplatepevcProjectInstance(defValue4eRTemplatedeassignTemplatepevcProjectInstance);
    }

    @Test
    public void test4getERTemplatedeassignTemplatepthisERTemplate() {
        assertEquals(defValue4eRTemplatedeassignTemplatepthisERTemplate, instanceDeassignTemplateRequest.getERTemplatedeassignTemplatepthisERTemplate());
    }

    @Test
    public void test4setERTemplatedeassignTemplatepthisERTemplate() {
        instanceDeassignTemplateRequest.setERTemplatedeassignTemplatepthisERTemplate(test4setERTemplatedeassignTemplatepthisERTemplateArg1);
        assertNotNull(instanceDeassignTemplateRequest);
    }

    @Test
    public void test4getERTemplatedeassignTemplatepevcProject() {
        assertEquals(defValue4eRTemplatedeassignTemplatepevcProject, instanceDeassignTemplateRequest.getERTemplatedeassignTemplatepevcProject());
    }

    @Test
    public void test4setERTemplatedeassignTemplatepevcProject() {
        instanceDeassignTemplateRequest.setERTemplatedeassignTemplatepevcProject(test4setERTemplatedeassignTemplatepevcProjectArg1);
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
