package com.integranova.spring.expensereportdemo.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.AssignmentConstants;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.persistence.oid.AssignmentOid;
import com.integranova.spring.expensereportdemo.persistence.oid.EmployeeOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ProjectOid;
import com.integranova.spring.expensereportdemo.repository.EmployeeJpaRepository;
import com.integranova.spring.expensereportdemo.repository.ProjectJpaRepository;
import com.integranova.spring.expensereportdemo.utils.Agent;
import java.sql.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssignmentTest {

    private static EmployeeJpaRepository mockEmployeeJpaRepository;

    private static ProjectJpaRepository mockProjectJpaRepository;

    private static Agent mockAgent;

    Assignment instanceAssignment;

    private static boolean TESTDERIVATIONS = false;

    private static Long VALUE_ASSIGNMENTASSIGNMENTID;
    private static Date VALUE_ASSIGNMENTFROMDATE;
    private static Date VALUE_ASSIGNMENTTODATE;
    private static Boolean VALUE_ASSIGNMENTISACTIVE;
    private static String VALUE_ASSIGNMENTDETAILS;
    private static Employee VALUE_EMPLOYEE;
    private static Project VALUE_PROJECT;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        VALUE_ASSIGNMENTASSIGNMENTID = Long.valueOf(0);
        VALUE_ASSIGNMENTFROMDATE = Date.valueOf(Constants.DATE_DEFAULTVALUE);
        VALUE_ASSIGNMENTTODATE = Date.valueOf(Constants.DATE_DEFAULTVALUE);
        VALUE_ASSIGNMENTISACTIVE = false;
        VALUE_ASSIGNMENTDETAILS = "assignmentDetails";
        VALUE_EMPLOYEE = new Employee(new EmployeeOid("employeeidEmployee"));
        VALUE_PROJECT = new Project(new ProjectOid(Long.valueOf(0)));
        mockEmployeeJpaRepository = mock(EmployeeJpaRepository.class);
        mockProjectJpaRepository = mock(ProjectJpaRepository.class);
        mockAgent = mock(Agent.class);
    }

    @Before
    public void setUp() throws SystemException {
        instanceAssignment = new Assignment();
        instanceAssignment.setEmployeeRepository(mockEmployeeJpaRepository);
        instanceAssignment.setProjectRepository(mockProjectJpaRepository);
        instanceAssignment.setAgent(mockAgent);
        instanceAssignment.setAssignmentAssignmentID(VALUE_ASSIGNMENTASSIGNMENTID);
        instanceAssignment.setAssignmentFromDate(VALUE_ASSIGNMENTFROMDATE);
        instanceAssignment.setAssignmentToDate(VALUE_ASSIGNMENTTODATE);
        instanceAssignment.add2Employee(VALUE_EMPLOYEE);
        instanceAssignment.add2Project(VALUE_PROJECT);
        when(mockAgent.isAnyFacetActive(anyString())).thenReturn(true);
    }

    @After
    public void tearDown() {
        instanceAssignment = null;
    }

    @Test
    public void testDefaultConstructor() {
        Assignment value = new Assignment();
        assertNotNull(value);
    }

    @Test
    public void testConstructor() {
        Assignment value = new Assignment(null);
        assertNotNull(value);
    }

    @Test
    public void testConstructor2() {
        Assignment value = new Assignment(new AssignmentOid());
        assertNotNull(value);
    }

    @Test
    public void testConstructor3() {
        Assignment value = new Assignment(new AssignmentOid(Long.valueOf(0)));
        assertNotNull(value);
    }

    @Test
    public void test4getAssignmentAssignmentID() {
        assertEquals(VALUE_ASSIGNMENTASSIGNMENTID.toString(), instanceAssignment.getAssignmentAssignmentID().toString());
    }

    @Test
    public void test4setAssignmentAssignmentID() {
        Long value = Long.valueOf(0);
        instanceAssignment.setAssignmentAssignmentID(value);
        assertEquals(value, instanceAssignment.getAssignmentAssignmentID());
    }

    @Test
    public void test4getAssignmentFromDate() {
        assertEquals(VALUE_ASSIGNMENTFROMDATE.toString(), instanceAssignment.getAssignmentFromDate().toString());
    }

    @Test
    public void test4setAssignmentFromDate() {
        Date value = Date.valueOf(Constants.DATE_DEFAULTVALUE);
        instanceAssignment.setAssignmentFromDate(value);
        assertEquals(value, instanceAssignment.getAssignmentFromDate());
    }

    @Test
    public void test4isModifiedAssignmentFromDate() {
        instanceAssignment = new Assignment();
        assertFalse(instanceAssignment.isModifiedAssignmentFromDate());
        instanceAssignment.setAssignmentFromDate(VALUE_ASSIGNMENTFROMDATE);
        assertTrue(instanceAssignment.isModifiedAssignmentFromDate());
    }

    @Test
    public void test4setModifiedAssignmentFromDate() {
        instanceAssignment.setModifiedAssignmentFromDate(true);
        assertTrue(instanceAssignment.isModifiedAssignmentFromDate());
    }

    @Test
    public void test4getAssignmentToDate() {
        assertEquals(VALUE_ASSIGNMENTTODATE.toString(), instanceAssignment.getAssignmentToDate().toString());
    }

    @Test
    public void test4setAssignmentToDate() {
        Date value = Date.valueOf(Constants.DATE_DEFAULTVALUE);
        instanceAssignment.setAssignmentToDate(value);
        assertEquals(value, instanceAssignment.getAssignmentToDate());
    }

    @Test
    public void test4isModifiedAssignmentToDate() {
        instanceAssignment = new Assignment();
        assertFalse(instanceAssignment.isModifiedAssignmentToDate());
        instanceAssignment.setAssignmentToDate(VALUE_ASSIGNMENTTODATE);
        assertTrue(instanceAssignment.isModifiedAssignmentToDate());
    }

    @Test
    public void test4setModifiedAssignmentToDate() {
        instanceAssignment.setModifiedAssignmentToDate(true);
        assertTrue(instanceAssignment.isModifiedAssignmentToDate());
    }

    @Test
    public void test4getAssignmentIsActive() throws SystemException {
        if (TESTDERIVATIONS) {
            assertEquals(VALUE_ASSIGNMENTISACTIVE.toString(), instanceAssignment.getAssignmentIsActive().toString());
        } else {
            instanceAssignment.getAssignmentIsActive();
            assertNotNull(instanceAssignment);
        }
    }

    @Test
    public void test4getAssignmentDetails() throws SystemException {
        if (TESTDERIVATIONS) {
            assertEquals(VALUE_ASSIGNMENTDETAILS.toString(), instanceAssignment.getAssignmentDetails().toString());
        } else {
            instanceAssignment.getAssignmentDetails();
            assertNotNull(instanceAssignment);
        }
    }

    @Test
    public void test4getEmployee() {
        assertEquals(VALUE_EMPLOYEE, instanceAssignment.getEmployee());
    }

    @Test
    public void test4getEmployee2() {
        instanceAssignment.add2Employee(null);
        assertTrue(instanceAssignment.getEmployee().isNull());
    }

    @Test
    public void test4getEmployee3() {
        Employee value = new Employee(new EmployeeOid("employeeidEmployee"));
        instanceAssignment.add2Employee(value);
        assertEquals(value, instanceAssignment.getEmployee());
    }

    @Test
    public void test4add2Employee() {
        Employee value = new Employee(new EmployeeOid("employeeidEmployee"));
        instanceAssignment.add2Employee(value);
        assertEquals(value, instanceAssignment.getEmployee());
    }

    @Test
    public void test4setEmployee() {
        instanceAssignment.add2Employee(VALUE_EMPLOYEE);
        assertEquals(VALUE_EMPLOYEE, instanceAssignment.getEmployee());
    }

    @Test
    public void test4isModifiedEmployee() {
        assertFalse(instanceAssignment.isModifiedEmployee());
    }

    @Test
    public void test4getProject() {
        assertEquals(VALUE_PROJECT, instanceAssignment.getProject());
    }

    @Test
    public void test4getProject2() {
        instanceAssignment.add2Project(null);
        assertTrue(instanceAssignment.getProject().isNull());
    }

    @Test
    public void test4getProject3() {
        Project value = new Project(new ProjectOid(Long.valueOf(0)));
        instanceAssignment.add2Project(value);
        assertEquals(value, instanceAssignment.getProject());
    }

    @Test
    public void test4add2Project() {
        Project value = new Project(new ProjectOid(Long.valueOf(0)));
        instanceAssignment.add2Project(value);
        assertEquals(value, instanceAssignment.getProject());
    }

    @Test
    public void test4setProject() {
        instanceAssignment.add2Project(VALUE_PROJECT);
        assertEquals(VALUE_PROJECT, instanceAssignment.getProject());
    }

    @Test
    public void test4isModifiedProject() {
        assertFalse(instanceAssignment.isModifiedProject());
    }

    @Test
    public void test4buildDSAssignmentDetails() {
        String result;
        try {
            result = instanceAssignment.buildDSAssignmentDetails().toString();	
        } catch (NullPointerException e) {
            result = "";
        }
        assertNotNull(result);
	}

    @Test
    public void test4buildDSAssignments() {
        String result;
        try {
            result = instanceAssignment.buildDSAssignments().toString();	
        } catch (NullPointerException e) {
            result = "";
        }
        assertNotNull(result);
	}

    @Test
    public void test4getValues() {
        assertNotNull(instanceAssignment.getValues());
    }

    @Test
    public void test4getAttribute() {
        assertNull(instanceAssignment.getAttribute(AssignmentConstants.ATTR_NAME_ASSIGNMENTASSIGNMENTID));
    }

    @Test
    public void test4getAttributeTypeRelated() {
        assertEquals(Constants.Type.STRING.getTypeName(), instanceAssignment.getAttributeTypeRelated(AssignmentConstants.ROLE_NAME_EMPLOYEE, ""));
        assertEquals(Constants.Type.STRING.getTypeName(), instanceAssignment.getAttributeTypeRelated(AssignmentConstants.ROLE_NAME_PROJECT, ""));
        assertEquals("", instanceAssignment.getAttributeTypeRelated("", ""));
    }

    @Test
    public void test4cleanDerivations() {
        instanceAssignment.cleanDerivations();
        assertNotNull(instanceAssignment);
    }

    @Test
    public void test4getOid() {
        assertEquals(instanceAssignment.getAssignmentAssignmentID(), instanceAssignment.getOid().getAssignmentAssignmentID());
    }

    @Test
    public void test4isVisible() {
        assertTrue(instanceAssignment.isVisible(AssignmentConstants.ATTR_NAME_ASSIGNMENTFROMDATE));
        assertTrue(instanceAssignment.isVisible(AssignmentConstants.ATTR_NAME_ASSIGNMENTTODATE));
        assertTrue(instanceAssignment.isVisible(AssignmentConstants.ATTR_NAME_ASSIGNMENTISACTIVE));
        assertTrue(instanceAssignment.isVisible(AssignmentConstants.ATTR_NAME_ASSIGNMENTDETAILS));
    }

    @Test
    public void test4IsAttributeVisible() {
        assertTrue(instanceAssignment.isAttributeVisible(AssignmentConstants.ATTR_NAME_ASSIGNMENTFROMDATE));
        assertTrue(instanceAssignment.isAttributeVisible(AssignmentConstants.ATTR_NAME_ASSIGNMENTTODATE));
        assertTrue(instanceAssignment.isAttributeVisible(AssignmentConstants.ATTR_NAME_ASSIGNMENTISACTIVE));
        assertTrue(instanceAssignment.isAttributeVisible(AssignmentConstants.ATTR_NAME_ASSIGNMENTDETAILS));
    }

    @Test
    public void test4getMethods() {
        assertTrue(instanceAssignment.getMethods().length > 0);
    }

    @Test
    public void test4getClassAttributeType() {
        assertNull(instanceAssignment.getClassAttributeType(""));
    }

    @Test
    public void test4getActiveFacets() {
        assertTrue(instanceAssignment.getActiveFacets().contains(Constants.ASSIGNMENT));
    }

    @Test
    public void test4getFacets() {
        assertTrue(instanceAssignment.getFacets().contains(Constants.ASSIGNMENT));
    }

    @Test
    public void test4checkHorizontalVisibility() {
        assertTrue(instanceAssignment.checkHorizontalVisibility(null));
    }
}
