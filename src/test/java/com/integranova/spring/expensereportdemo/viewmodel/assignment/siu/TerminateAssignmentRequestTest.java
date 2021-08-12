package com.integranova.spring.expensereportdemo.viewmodel.assignment.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.persistence.Assignment;
import com.integranova.spring.expensereportdemo.persistence.oid.AssignmentOid;
import java.sql.Date;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TerminateAssignmentRequestTest {

    private TerminateAssignmentRequest instanceTerminateAssignmentRequest;

    // Default values
    private static AssignmentOid defValue4assignmentterminateAssignmentpthisAssignment = new AssignmentOid();
    private static Assignment defValue4assignmentterminateAssignmentpthisAssignmentInstance = new Assignment(new AssignmentOid(Long.valueOf(0)));
    private static Date defValue4assignmentterminateAssignmentpTerminationDate = Date.valueOf(Constants.DATE_DEFAULTVALUE);


    // test4getAssignmentterminateAssignmentpthisAssignment

    // test4setAssignmentterminateAssignmentpthisAssignment
    private static AssignmentOid test4setAssignmentterminateAssignmentpthisAssignmentArg1;

    // test4getAssignmentterminateAssignmentpTerminationDate

    // test4setAssignmentterminateAssignmentpTerminationDate
    private static Date test4setAssignmentterminateAssignmentpTerminationDateArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getAssignmentterminateAssignmentpthisAssignment();
        setUpMockData4test4setAssignmentterminateAssignmentpthisAssignment();
        setUpMockData4test4getAssignmentterminateAssignmentpTerminationDate();
        setUpMockData4test4setAssignmentterminateAssignmentpTerminationDate();
    }

    private static void setUpMockData4test4getAssignmentterminateAssignmentpthisAssignment() {
    }

    private static void setUpMockData4test4setAssignmentterminateAssignmentpthisAssignment() {
        test4setAssignmentterminateAssignmentpthisAssignmentArg1 = new AssignmentOid();
    }

    private static void setUpMockData4test4getAssignmentterminateAssignmentpTerminationDate() {
    }

    private static void setUpMockData4test4setAssignmentterminateAssignmentpTerminationDate() {
        test4setAssignmentterminateAssignmentpTerminationDateArg1 = Date.valueOf(Constants.DATE_DEFAULTVALUE);
    }

    @Before
    public void setUp() {
        instanceTerminateAssignmentRequest = new TerminateAssignmentRequest();
        instanceTerminateAssignmentRequest.setAssignmentterminateAssignmentpthisAssignment(defValue4assignmentterminateAssignmentpthisAssignment);
        instanceTerminateAssignmentRequest.setAssignmentterminateAssignmentpthisAssignmentInstance(defValue4assignmentterminateAssignmentpthisAssignmentInstance);
        instanceTerminateAssignmentRequest.setAssignmentterminateAssignmentpTerminationDate(defValue4assignmentterminateAssignmentpTerminationDate);
    }

    @Test
    public void test4getAssignmentterminateAssignmentpthisAssignment() {
        assertEquals(defValue4assignmentterminateAssignmentpthisAssignment, instanceTerminateAssignmentRequest.getAssignmentterminateAssignmentpthisAssignment());
    }

    @Test
    public void test4setAssignmentterminateAssignmentpthisAssignment() {
        instanceTerminateAssignmentRequest.setAssignmentterminateAssignmentpthisAssignment(test4setAssignmentterminateAssignmentpthisAssignmentArg1);
        assertNotNull(instanceTerminateAssignmentRequest);
    }

    @Test
    public void test4getAssignmentterminateAssignmentpTerminationDate() {
        assertEquals(defValue4assignmentterminateAssignmentpTerminationDate, instanceTerminateAssignmentRequest.getAssignmentterminateAssignmentpTerminationDate());
    }

    @Test
    public void test4setAssignmentterminateAssignmentpTerminationDate() {
        instanceTerminateAssignmentRequest.setAssignmentterminateAssignmentpTerminationDate(test4setAssignmentterminateAssignmentpTerminationDateArg1);
        assertNotNull(instanceTerminateAssignmentRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceTerminateAssignmentRequest = new TerminateAssignmentRequest();
    	instanceTerminateAssignmentRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceTerminateAssignmentRequest.checkArguments();
    }
}
