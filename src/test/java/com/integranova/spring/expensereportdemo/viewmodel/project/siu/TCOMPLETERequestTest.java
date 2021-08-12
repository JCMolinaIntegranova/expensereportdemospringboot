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
public class TCOMPLETERequestTest {

    private TCOMPLETERequest instanceTCOMPLETERequest;

    // Default values
    private static ProjectOid defValue4projectTCOMPLETEpthisProject = new ProjectOid();
    private static Project defValue4projectTCOMPLETEpthisProjectInstance = new Project(new ProjectOid(Long.valueOf(0)));
    private static Date defValue4projectTCOMPLETEpCompletionDate = Date.valueOf(Constants.DATE_DEFAULTVALUE);


    // test4getProjectTCOMPLETEpthisProject

    // test4setProjectTCOMPLETEpthisProject
    private static ProjectOid test4setProjectTCOMPLETEpthisProjectArg1;

    // test4getProjectTCOMPLETEpCompletionDate

    // test4setProjectTCOMPLETEpCompletionDate
    private static Date test4setProjectTCOMPLETEpCompletionDateArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getProjectTCOMPLETEpthisProject();
        setUpMockData4test4setProjectTCOMPLETEpthisProject();
        setUpMockData4test4getProjectTCOMPLETEpCompletionDate();
        setUpMockData4test4setProjectTCOMPLETEpCompletionDate();
    }

    private static void setUpMockData4test4getProjectTCOMPLETEpthisProject() {
    }

    private static void setUpMockData4test4setProjectTCOMPLETEpthisProject() {
        test4setProjectTCOMPLETEpthisProjectArg1 = new ProjectOid();
    }

    private static void setUpMockData4test4getProjectTCOMPLETEpCompletionDate() {
    }

    private static void setUpMockData4test4setProjectTCOMPLETEpCompletionDate() {
        test4setProjectTCOMPLETEpCompletionDateArg1 = Date.valueOf(Constants.DATE_DEFAULTVALUE);
    }

    @Before
    public void setUp() {
        instanceTCOMPLETERequest = new TCOMPLETERequest();
        instanceTCOMPLETERequest.setProjectTCOMPLETEpthisProject(defValue4projectTCOMPLETEpthisProject);
        instanceTCOMPLETERequest.setProjectTCOMPLETEpthisProjectInstance(defValue4projectTCOMPLETEpthisProjectInstance);
        instanceTCOMPLETERequest.setProjectTCOMPLETEpCompletionDate(defValue4projectTCOMPLETEpCompletionDate);
    }

    @Test
    public void test4getProjectTCOMPLETEpthisProject() {
        assertEquals(defValue4projectTCOMPLETEpthisProject, instanceTCOMPLETERequest.getProjectTCOMPLETEpthisProject());
    }

    @Test
    public void test4setProjectTCOMPLETEpthisProject() {
        instanceTCOMPLETERequest.setProjectTCOMPLETEpthisProject(test4setProjectTCOMPLETEpthisProjectArg1);
        assertNotNull(instanceTCOMPLETERequest);
    }

    @Test
    public void test4getProjectTCOMPLETEpCompletionDate() {
        assertEquals(defValue4projectTCOMPLETEpCompletionDate, instanceTCOMPLETERequest.getProjectTCOMPLETEpCompletionDate());
    }

    @Test
    public void test4setProjectTCOMPLETEpCompletionDate() {
        instanceTCOMPLETERequest.setProjectTCOMPLETEpCompletionDate(test4setProjectTCOMPLETEpCompletionDateArg1);
        assertNotNull(instanceTCOMPLETERequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceTCOMPLETERequest = new TCOMPLETERequest();
    	instanceTCOMPLETERequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceTCOMPLETERequest.checkArguments();
    }
}
