package com.integranova.spring.expensereportdemo.viewmodel.assignment.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.persistence.Assignment;
import com.integranova.spring.expensereportdemo.persistence.oid.AssignmentOid;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DeleteAssignmentRequestTest {

    private DeleteAssignmentRequest instanceDeleteAssignmentRequest;

    // Default values
    private static AssignmentOid defValue4assignmentdeleteAssignmentpthisAssignment = new AssignmentOid();
    private static Assignment defValue4assignmentdeleteAssignmentpthisAssignmentInstance = new Assignment(new AssignmentOid(Long.valueOf(0)));


    // test4getAssignmentdeleteAssignmentpthisAssignment

    // test4setAssignmentdeleteAssignmentpthisAssignment
    private static AssignmentOid test4setAssignmentdeleteAssignmentpthisAssignmentArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getAssignmentdeleteAssignmentpthisAssignment();
        setUpMockData4test4setAssignmentdeleteAssignmentpthisAssignment();
    }

    private static void setUpMockData4test4getAssignmentdeleteAssignmentpthisAssignment() {
    }

    private static void setUpMockData4test4setAssignmentdeleteAssignmentpthisAssignment() {
        test4setAssignmentdeleteAssignmentpthisAssignmentArg1 = new AssignmentOid();
    }

    @Before
    public void setUp() {
        instanceDeleteAssignmentRequest = new DeleteAssignmentRequest();
        instanceDeleteAssignmentRequest.setAssignmentdeleteAssignmentpthisAssignment(defValue4assignmentdeleteAssignmentpthisAssignment);
        instanceDeleteAssignmentRequest.setAssignmentdeleteAssignmentpthisAssignmentInstance(defValue4assignmentdeleteAssignmentpthisAssignmentInstance);
    }

    @Test
    public void test4getAssignmentdeleteAssignmentpthisAssignment() {
        assertEquals(defValue4assignmentdeleteAssignmentpthisAssignment, instanceDeleteAssignmentRequest.getAssignmentdeleteAssignmentpthisAssignment());
    }

    @Test
    public void test4setAssignmentdeleteAssignmentpthisAssignment() {
        instanceDeleteAssignmentRequest.setAssignmentdeleteAssignmentpthisAssignment(test4setAssignmentdeleteAssignmentpthisAssignmentArg1);
        assertNotNull(instanceDeleteAssignmentRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceDeleteAssignmentRequest = new DeleteAssignmentRequest();
    	instanceDeleteAssignmentRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceDeleteAssignmentRequest.checkArguments();
    }
}
