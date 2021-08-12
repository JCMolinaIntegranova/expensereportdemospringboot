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
public class EditAssignmentRequestTest {

    private EditAssignmentRequest instanceEditAssignmentRequest;

    // Default values
    private static AssignmentOid defValue4assignmenteditAssignmentpthisAssignment = new AssignmentOid();
    private static Assignment defValue4assignmenteditAssignmentpthisAssignmentInstance = new Assignment(new AssignmentOid(Long.valueOf(0)));
    private static Date defValue4assignmenteditAssignmentpFromDate = Date.valueOf(Constants.DATE_DEFAULTVALUE);


    // test4getAssignmenteditAssignmentpthisAssignment

    // test4setAssignmenteditAssignmentpthisAssignment
    private static AssignmentOid test4setAssignmenteditAssignmentpthisAssignmentArg1;

    // test4getAssignmenteditAssignmentpFromDate

    // test4setAssignmenteditAssignmentpFromDate
    private static Date test4setAssignmenteditAssignmentpFromDateArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getAssignmenteditAssignmentpthisAssignment();
        setUpMockData4test4setAssignmenteditAssignmentpthisAssignment();
        setUpMockData4test4getAssignmenteditAssignmentpFromDate();
        setUpMockData4test4setAssignmenteditAssignmentpFromDate();
    }

    private static void setUpMockData4test4getAssignmenteditAssignmentpthisAssignment() {
    }

    private static void setUpMockData4test4setAssignmenteditAssignmentpthisAssignment() {
        test4setAssignmenteditAssignmentpthisAssignmentArg1 = new AssignmentOid();
    }

    private static void setUpMockData4test4getAssignmenteditAssignmentpFromDate() {
    }

    private static void setUpMockData4test4setAssignmenteditAssignmentpFromDate() {
        test4setAssignmenteditAssignmentpFromDateArg1 = Date.valueOf(Constants.DATE_DEFAULTVALUE);
    }

    @Before
    public void setUp() {
        instanceEditAssignmentRequest = new EditAssignmentRequest();
        instanceEditAssignmentRequest.setAssignmenteditAssignmentpthisAssignment(defValue4assignmenteditAssignmentpthisAssignment);
        instanceEditAssignmentRequest.setAssignmenteditAssignmentpthisAssignmentInstance(defValue4assignmenteditAssignmentpthisAssignmentInstance);
        instanceEditAssignmentRequest.setAssignmenteditAssignmentpFromDate(defValue4assignmenteditAssignmentpFromDate);
    }

    @Test
    public void test4getAssignmenteditAssignmentpthisAssignment() {
        assertEquals(defValue4assignmenteditAssignmentpthisAssignment, instanceEditAssignmentRequest.getAssignmenteditAssignmentpthisAssignment());
    }

    @Test
    public void test4setAssignmenteditAssignmentpthisAssignment() {
        instanceEditAssignmentRequest.setAssignmenteditAssignmentpthisAssignment(test4setAssignmenteditAssignmentpthisAssignmentArg1);
        assertNotNull(instanceEditAssignmentRequest);
    }

    @Test
    public void test4getAssignmenteditAssignmentpFromDate() {
        assertEquals(defValue4assignmenteditAssignmentpFromDate, instanceEditAssignmentRequest.getAssignmenteditAssignmentpFromDate());
    }

    @Test
    public void test4setAssignmenteditAssignmentpFromDate() {
        instanceEditAssignmentRequest.setAssignmenteditAssignmentpFromDate(test4setAssignmenteditAssignmentpFromDateArg1);
        assertNotNull(instanceEditAssignmentRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceEditAssignmentRequest = new EditAssignmentRequest();
    	instanceEditAssignmentRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceEditAssignmentRequest.checkArguments();
    }
}
