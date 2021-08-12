package com.integranova.spring.expensereportdemo.viewmodel.project.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.persistence.oid.ProjectOid;
import com.integranova.spring.expensereportdemo.persistence.Project;
import java.sql.Date;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MarkAsCompletedRequestTest {

    private MarkAsCompletedRequest instanceMarkAsCompletedRequest;

    // Default values
    private static ProjectOid defValue4projectmarkAsCompletedpthisProject = new ProjectOid();
    private static Project defValue4projectmarkAsCompletedpthisProjectInstance = new Project(new ProjectOid(Long.valueOf(0)));
    private static Date defValue4projectmarkAsCompletedpCompletionDate = Date.valueOf(Constants.DATE_DEFAULTVALUE);


    // test4getProjectmarkAsCompletedpthisProject

    // test4setProjectmarkAsCompletedpthisProject
    private static ProjectOid test4setProjectmarkAsCompletedpthisProjectArg1;

    // test4getProjectmarkAsCompletedpCompletionDate

    // test4setProjectmarkAsCompletedpCompletionDate
    private static Date test4setProjectmarkAsCompletedpCompletionDateArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getProjectmarkAsCompletedpthisProject();
        setUpMockData4test4setProjectmarkAsCompletedpthisProject();
        setUpMockData4test4getProjectmarkAsCompletedpCompletionDate();
        setUpMockData4test4setProjectmarkAsCompletedpCompletionDate();
    }

    private static void setUpMockData4test4getProjectmarkAsCompletedpthisProject() {
    }

    private static void setUpMockData4test4setProjectmarkAsCompletedpthisProject() {
        test4setProjectmarkAsCompletedpthisProjectArg1 = new ProjectOid();
    }

    private static void setUpMockData4test4getProjectmarkAsCompletedpCompletionDate() {
    }

    private static void setUpMockData4test4setProjectmarkAsCompletedpCompletionDate() {
        test4setProjectmarkAsCompletedpCompletionDateArg1 = Date.valueOf(Constants.DATE_DEFAULTVALUE);
    }

    @Before
    public void setUp() {
        instanceMarkAsCompletedRequest = new MarkAsCompletedRequest();
        instanceMarkAsCompletedRequest.setProjectmarkAsCompletedpthisProject(defValue4projectmarkAsCompletedpthisProject);
        instanceMarkAsCompletedRequest.setProjectmarkAsCompletedpthisProjectInstance(defValue4projectmarkAsCompletedpthisProjectInstance);
        instanceMarkAsCompletedRequest.setProjectmarkAsCompletedpCompletionDate(defValue4projectmarkAsCompletedpCompletionDate);
    }

    @Test
    public void test4getProjectmarkAsCompletedpthisProject() {
        assertEquals(defValue4projectmarkAsCompletedpthisProject, instanceMarkAsCompletedRequest.getProjectmarkAsCompletedpthisProject());
    }

    @Test
    public void test4setProjectmarkAsCompletedpthisProject() {
        instanceMarkAsCompletedRequest.setProjectmarkAsCompletedpthisProject(test4setProjectmarkAsCompletedpthisProjectArg1);
        assertNotNull(instanceMarkAsCompletedRequest);
    }

    @Test
    public void test4getProjectmarkAsCompletedpCompletionDate() {
        assertEquals(defValue4projectmarkAsCompletedpCompletionDate, instanceMarkAsCompletedRequest.getProjectmarkAsCompletedpCompletionDate());
    }

    @Test
    public void test4setProjectmarkAsCompletedpCompletionDate() {
        instanceMarkAsCompletedRequest.setProjectmarkAsCompletedpCompletionDate(test4setProjectmarkAsCompletedpCompletionDateArg1);
        assertNotNull(instanceMarkAsCompletedRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceMarkAsCompletedRequest = new MarkAsCompletedRequest();
    	instanceMarkAsCompletedRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceMarkAsCompletedRequest.checkArguments();
    }
}
