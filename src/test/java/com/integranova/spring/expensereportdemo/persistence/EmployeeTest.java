package com.integranova.spring.expensereportdemo.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.integranova.spring.expensereportdemo.exception.SystemException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.EmployeeConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.EmployeeOid;
import com.integranova.spring.expensereportdemo.repository.AssignmentJpaRepository;
import com.integranova.spring.expensereportdemo.repository.EmployeeJpaRepository;
import com.integranova.spring.expensereportdemo.repository.ExpenseReportJpaRepository;
import com.integranova.spring.expensereportdemo.repository.TeamJpaRepository;
import com.integranova.spring.expensereportdemo.utils.Agent;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeTest {

    private static EmployeeJpaRepository mockEmployeeJpaRepository;

    private static ExpenseReportJpaRepository mockExpenseReportJpaRepository;

    private static AssignmentJpaRepository mockAssignmentJpaRepository;

    private static TeamJpaRepository mockTeamJpaRepository;

    private static Agent mockAgent;

    Employee instanceEmployee;

    private static boolean TESTDERIVATIONS = false;

    private static String VALUE_EMPLOYEEIDEMPLOYEE;
    private static String VALUE_EMPLOYEEEMPNAME;
    private static String VALUE_EMPLOYEEEMPSURNAME;
    private static String VALUE_EMPLOYEESITE;
    private static String VALUE_EMPLOYEEPHONENUMBERS;
    private static String VALUE_EMPLOYEEEMAIL;
    private static String VALUE_EMPLOYEEEMPFULLNAME;
    private static byte[] VALUE_EMPLOYEEPICTURE;
    private static Long VALUE_EMPLOYEENUMOFEXPREPORTS;
    private static List<ExpenseReport> VALUE_EXPENSEREPORTS;
    private static List<Assignment> VALUE_ASSIGNMENTS;
    private static List<Team> VALUE_TEAMS;
    private static Employee VALUE_ASSOCOPERATOR000_INSTANCE;
    private static Long VALUE_ASSOCOPERATOR000_RETURN;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        VALUE_EMPLOYEEIDEMPLOYEE = "employeeidEmployee";
        VALUE_EMPLOYEEEMPNAME = "employeeEmpName";
        VALUE_EMPLOYEEEMPSURNAME = "employeeEmpSurname";
        VALUE_EMPLOYEESITE = "employeeSite";
        VALUE_EMPLOYEEPHONENUMBERS = "employeePhoneNumbers";
        VALUE_EMPLOYEEEMAIL = "employeeemail";
        VALUE_EMPLOYEEEMPFULLNAME = "employeeEmpFullName";
        VALUE_EMPLOYEEPICTURE = "employeePicture".getBytes();
        VALUE_EMPLOYEENUMOFEXPREPORTS = Long.valueOf(0);
        VALUE_EXPENSEREPORTS = new ArrayList<>();
        VALUE_EXPENSEREPORTS.add(new ExpenseReport());
        VALUE_ASSIGNMENTS = new ArrayList<>();
        VALUE_ASSIGNMENTS.add(new Assignment());
        VALUE_TEAMS = new ArrayList<>();
        VALUE_TEAMS.add(new Team());
        VALUE_ASSOCOPERATOR000_INSTANCE = new Employee();
        VALUE_ASSOCOPERATOR000_RETURN = Long.valueOf(0);
        mockEmployeeJpaRepository = mock(EmployeeJpaRepository.class);
        mockExpenseReportJpaRepository = mock(ExpenseReportJpaRepository.class);
        mockAssignmentJpaRepository = mock(AssignmentJpaRepository.class);
        mockTeamJpaRepository = mock(TeamJpaRepository.class);
        mockAgent = mock(Agent.class);
    }

    @Before
    public void setUp() throws SystemException {
        instanceEmployee = new Employee();
        instanceEmployee.setEmployeeRepository(mockEmployeeJpaRepository);
        instanceEmployee.setExpenseReportRepository(mockExpenseReportJpaRepository);
        instanceEmployee.setAssignmentRepository(mockAssignmentJpaRepository);
        instanceEmployee.setTeamRepository(mockTeamJpaRepository);
        instanceEmployee.setAgent(mockAgent);
        instanceEmployee.setEmployeeidEmployee(VALUE_EMPLOYEEIDEMPLOYEE);
        instanceEmployee.setEmployeeEmpName(VALUE_EMPLOYEEEMPNAME);
        instanceEmployee.setEmployeeEmpSurname(VALUE_EMPLOYEEEMPSURNAME);
        instanceEmployee.setEmployeeSite(VALUE_EMPLOYEESITE);
        instanceEmployee.setEmployeePhoneNumbers(VALUE_EMPLOYEEPHONENUMBERS);
        instanceEmployee.setEmployeeemail(VALUE_EMPLOYEEEMAIL);
        instanceEmployee.setEmployeePicture(VALUE_EMPLOYEEPICTURE);
        instanceEmployee.setExpenseReports(VALUE_EXPENSEREPORTS);
        instanceEmployee.setAssignments(VALUE_ASSIGNMENTS);
        instanceEmployee.setTeams(VALUE_TEAMS);
        when(mockEmployeeJpaRepository.assocOperator000(VALUE_ASSOCOPERATOR000_INSTANCE)).thenReturn(VALUE_ASSOCOPERATOR000_RETURN);
        when(mockExpenseReportJpaRepository.findByEmployee(any(Employee.class))).thenReturn(VALUE_EXPENSEREPORTS);
        when(mockAssignmentJpaRepository.findByEmployee(any(Employee.class))).thenReturn(VALUE_ASSIGNMENTS);
        when(mockTeamJpaRepository.findByEmployees(any(Employee.class))).thenReturn(VALUE_TEAMS);
        when(mockAgent.isAnyFacetActive(anyString())).thenReturn(true);
    }

    @After
    public void tearDown() {
        instanceEmployee = null;
    }

    @Test
    public void testDefaultConstructor() {
        Employee value = new Employee();
        assertNotNull(value);
    }

    @Test
    public void testConstructor() {
        Employee value = new Employee(null);
        assertNotNull(value);
    }

    @Test
    public void testConstructor2() {
        Employee value = new Employee(new EmployeeOid());
        assertNotNull(value);
    }

    @Test
    public void testConstructor3() {
        Employee value = new Employee(new EmployeeOid("employeeidEmployee"));
        assertNotNull(value);
    }

    @Test
    public void test4getEmployeeidEmployee() {
        assertEquals(VALUE_EMPLOYEEIDEMPLOYEE.toString(), instanceEmployee.getEmployeeidEmployee().toString());
    }

    @Test
    public void test4setEmployeeidEmployee() {
        String value = "employeeidEmployee";
        instanceEmployee.setEmployeeidEmployee(value);
        assertEquals(value, instanceEmployee.getEmployeeidEmployee());
    }

    @Test
    public void test4getEmployeeEmpName() {
        assertEquals(VALUE_EMPLOYEEEMPNAME.toString(), instanceEmployee.getEmployeeEmpName().toString());
    }

    @Test
    public void test4setEmployeeEmpName() {
        String value = "employeeEmpName";
        instanceEmployee.setEmployeeEmpName(value);
        assertEquals(value, instanceEmployee.getEmployeeEmpName());
    }

    @Test
    public void test4isModifiedEmployeeEmpName() {
        instanceEmployee = new Employee();
        assertFalse(instanceEmployee.isModifiedEmployeeEmpName());
        instanceEmployee.setEmployeeEmpName(VALUE_EMPLOYEEEMPNAME);
        assertTrue(instanceEmployee.isModifiedEmployeeEmpName());
    }

    @Test
    public void test4setModifiedEmployeeEmpName() {
        instanceEmployee.setModifiedEmployeeEmpName(true);
        assertTrue(instanceEmployee.isModifiedEmployeeEmpName());
    }

    @Test
    public void test4getEmployeeEmpSurname() {
        assertEquals(VALUE_EMPLOYEEEMPSURNAME.toString(), instanceEmployee.getEmployeeEmpSurname().toString());
    }

    @Test
    public void test4setEmployeeEmpSurname() {
        String value = "employeeEmpSurname";
        instanceEmployee.setEmployeeEmpSurname(value);
        assertEquals(value, instanceEmployee.getEmployeeEmpSurname());
    }

    @Test
    public void test4isModifiedEmployeeEmpSurname() {
        instanceEmployee = new Employee();
        assertFalse(instanceEmployee.isModifiedEmployeeEmpSurname());
        instanceEmployee.setEmployeeEmpSurname(VALUE_EMPLOYEEEMPSURNAME);
        assertTrue(instanceEmployee.isModifiedEmployeeEmpSurname());
    }

    @Test
    public void test4setModifiedEmployeeEmpSurname() {
        instanceEmployee.setModifiedEmployeeEmpSurname(true);
        assertTrue(instanceEmployee.isModifiedEmployeeEmpSurname());
    }

    @Test
    public void test4getEmployeeSite() {
        assertEquals(VALUE_EMPLOYEESITE.toString(), instanceEmployee.getEmployeeSite().toString());
    }

    @Test
    public void test4setEmployeeSite() {
        String value = "employeeSite";
        instanceEmployee.setEmployeeSite(value);
        assertEquals(value, instanceEmployee.getEmployeeSite());
    }

    @Test
    public void test4isModifiedEmployeeSite() {
        instanceEmployee = new Employee();
        assertFalse(instanceEmployee.isModifiedEmployeeSite());
        instanceEmployee.setEmployeeSite(VALUE_EMPLOYEESITE);
        assertTrue(instanceEmployee.isModifiedEmployeeSite());
    }

    @Test
    public void test4setModifiedEmployeeSite() {
        instanceEmployee.setModifiedEmployeeSite(true);
        assertTrue(instanceEmployee.isModifiedEmployeeSite());
    }

    @Test
    public void test4getEmployeePhoneNumbers() {
        assertEquals(VALUE_EMPLOYEEPHONENUMBERS.toString(), instanceEmployee.getEmployeePhoneNumbers().toString());
    }

    @Test
    public void test4setEmployeePhoneNumbers() {
        String value = "employeePhoneNumbers";
        instanceEmployee.setEmployeePhoneNumbers(value);
        assertEquals(value, instanceEmployee.getEmployeePhoneNumbers());
    }

    @Test
    public void test4isModifiedEmployeePhoneNumbers() {
        instanceEmployee = new Employee();
        assertFalse(instanceEmployee.isModifiedEmployeePhoneNumbers());
        instanceEmployee.setEmployeePhoneNumbers(VALUE_EMPLOYEEPHONENUMBERS);
        assertTrue(instanceEmployee.isModifiedEmployeePhoneNumbers());
    }

    @Test
    public void test4setModifiedEmployeePhoneNumbers() {
        instanceEmployee.setModifiedEmployeePhoneNumbers(true);
        assertTrue(instanceEmployee.isModifiedEmployeePhoneNumbers());
    }

    @Test
    public void test4getEmployeeemail() {
        assertEquals(VALUE_EMPLOYEEEMAIL.toString(), instanceEmployee.getEmployeeemail().toString());
    }

    @Test
    public void test4setEmployeeemail() {
        String value = "employeeemail";
        instanceEmployee.setEmployeeemail(value);
        assertEquals(value, instanceEmployee.getEmployeeemail());
    }

    @Test
    public void test4isModifiedEmployeeemail() {
        instanceEmployee = new Employee();
        assertFalse(instanceEmployee.isModifiedEmployeeemail());
        instanceEmployee.setEmployeeemail(VALUE_EMPLOYEEEMAIL);
        assertTrue(instanceEmployee.isModifiedEmployeeemail());
    }

    @Test
    public void test4setModifiedEmployeeemail() {
        instanceEmployee.setModifiedEmployeeemail(true);
        assertTrue(instanceEmployee.isModifiedEmployeeemail());
    }

    @Test
    public void test4getEmployeeEmpFullName() throws SystemException {
        if (TESTDERIVATIONS) {
            assertEquals(VALUE_EMPLOYEEEMPFULLNAME.toString(), instanceEmployee.getEmployeeEmpFullName().toString());
        } else {
            instanceEmployee.getEmployeeEmpFullName();
            assertNotNull(instanceEmployee);
        }
    }

    @Test
    public void test4getEmployeePicture() {
        assertEquals(VALUE_EMPLOYEEPICTURE.toString(), instanceEmployee.getEmployeePicture().toString());
    }

    @Test
    public void test4setEmployeePicture() {
        byte[] value = "employeePicture".getBytes();
        instanceEmployee.setEmployeePicture(value);
        assertEquals(value, instanceEmployee.getEmployeePicture());
    }

    @Test
    public void test4isModifiedEmployeePicture() {
        instanceEmployee = new Employee();
        assertFalse(instanceEmployee.isModifiedEmployeePicture());
        instanceEmployee.setEmployeePicture(VALUE_EMPLOYEEPICTURE);
        assertTrue(instanceEmployee.isModifiedEmployeePicture());
    }

    @Test
    public void test4setModifiedEmployeePicture() {
        instanceEmployee.setModifiedEmployeePicture(true);
        assertTrue(instanceEmployee.isModifiedEmployeePicture());
    }

    @Test
    public void test4getEmployeeNumOfExpReports() throws SystemException {
        if (TESTDERIVATIONS) {
            assertEquals(VALUE_EMPLOYEENUMOFEXPREPORTS.toString(), instanceEmployee.getEmployeeNumOfExpReports().toString());
        } else {
            instanceEmployee.getEmployeeNumOfExpReports();
            assertNotNull(instanceEmployee);
        }
    }

    @Test
    public void test4getExpenseReports() {
        assertEquals(VALUE_EXPENSEREPORTS, instanceEmployee.getExpenseReports());
    }

    @Test
    public void test4getExpenseReports2() {
        instanceEmployee.setExpenseReports(null);
        assertEquals(VALUE_EXPENSEREPORTS, instanceEmployee.getExpenseReports());
    }

    @Test
    public void test4getExpenseReports3() {
        instanceEmployee.setExpenseReports(new ArrayList<>());
        assertEquals(VALUE_EXPENSEREPORTS, instanceEmployee.getExpenseReports());
    }

    @Test
    public void test4add2ExpenseReports() {
        ExpenseReport value = new ExpenseReport();
        instanceEmployee.add2ExpenseReports(value);
        assertTrue(instanceEmployee.getExpenseReports().contains(value));
    }

    @Test
    public void test4setExpenseReports() {
        instanceEmployee.setExpenseReports(VALUE_EXPENSEREPORTS);
        assertEquals(VALUE_EXPENSEREPORTS, instanceEmployee.getExpenseReports());
    }

    @Test
    public void test4isModifiedExpenseReports() {
        assertFalse(instanceEmployee.isModifiedExpenseReports());
    }

    @Test
    public void test4getAssignments() {
        assertEquals(VALUE_ASSIGNMENTS, instanceEmployee.getAssignments());
    }

    @Test
    public void test4getAssignments2() {
        instanceEmployee.setAssignments(null);
        assertEquals(VALUE_ASSIGNMENTS, instanceEmployee.getAssignments());
    }

    @Test
    public void test4getAssignments3() {
        instanceEmployee.setAssignments(new ArrayList<>());
        assertEquals(VALUE_ASSIGNMENTS, instanceEmployee.getAssignments());
    }

    @Test
    public void test4add2Assignments() {
        Assignment value = new Assignment();
        instanceEmployee.add2Assignments(value);
        assertTrue(instanceEmployee.getAssignments().contains(value));
    }

    @Test
    public void test4setAssignments() {
        instanceEmployee.setAssignments(VALUE_ASSIGNMENTS);
        assertEquals(VALUE_ASSIGNMENTS, instanceEmployee.getAssignments());
    }

    @Test
    public void test4isModifiedAssignments() {
        assertFalse(instanceEmployee.isModifiedAssignments());
    }

    @Test
    public void test4getTeams() {
        assertEquals(VALUE_TEAMS, instanceEmployee.getTeams());
    }

    @Test
    public void test4getTeams2() {
        instanceEmployee.setTeams(null);
        assertEquals(VALUE_TEAMS, instanceEmployee.getTeams());
    }

    @Test
    public void test4getTeams3() {
        instanceEmployee.setTeams(new ArrayList<>());
        assertEquals(VALUE_TEAMS, instanceEmployee.getTeams());
    }

    @Test
    public void test4add2Teams() {
        Team value = new Team();
        instanceEmployee.add2Teams(value);
        assertTrue(instanceEmployee.getTeams().contains(value));
    }

    @Test
    public void test4setTeams() {
        instanceEmployee.setTeams(VALUE_TEAMS);
        assertEquals(VALUE_TEAMS, instanceEmployee.getTeams());
    }

    @Test
    public void test4isModifiedTeams() {
        assertFalse(instanceEmployee.isModifiedTeams());
    }

    @Test
    public void test4buildDSEmployee() {
        String result;
        try {
            result = instanceEmployee.buildDSEmployee().toString();	
        } catch (NullPointerException e) {
            result = "";
        }
        assertNotNull(result);
	}

    @Test
    public void test4buildDSEmployeeSup() {
        String result;
        try {
            result = instanceEmployee.buildDSEmployeeSup().toString();	
        } catch (NullPointerException e) {
            result = "";
        }
        assertNotNull(result);
	}

    @Test
    public void test4getValues() {
        assertNotNull(instanceEmployee.getValues());
    }

    @Test
    public void test4getAttribute() {
        assertNull(instanceEmployee.getAttribute(EmployeeConstants.ATTR_NAME_EMPLOYEEIDEMPLOYEE));
    }

    @Test
    public void test4getAttributeTypeRelated() {
        assertEquals(Constants.Type.STRING.getTypeName(), instanceEmployee.getAttributeTypeRelated(EmployeeConstants.ROLE_NAME_EXPENSEREPORTS, ""));
        assertEquals(Constants.Type.STRING.getTypeName(), instanceEmployee.getAttributeTypeRelated(EmployeeConstants.ROLE_NAME_ASSIGNMENTS, ""));
        assertEquals(Constants.Type.STRING.getTypeName(), instanceEmployee.getAttributeTypeRelated(EmployeeConstants.ROLE_NAME_TEAMS, ""));
        assertEquals("", instanceEmployee.getAttributeTypeRelated("", ""));
    }

    @Test
    public void test4cleanDerivations() {
        instanceEmployee.cleanDerivations();
        assertNotNull(instanceEmployee);
    }

    @Test
    public void test4getOid() {
        assertEquals(instanceEmployee.getEmployeeidEmployee(), instanceEmployee.getOid().getEmployeeidEmployee());
    }

    @Test
    public void test4isVisible() {
        assertTrue(instanceEmployee.isVisible(EmployeeConstants.ATTR_NAME_EMPLOYEEEMPNAME));
        assertTrue(instanceEmployee.isVisible(EmployeeConstants.ATTR_NAME_EMPLOYEEEMPSURNAME));
        assertTrue(instanceEmployee.isVisible(EmployeeConstants.ATTR_NAME_EMPLOYEESITE));
        assertTrue(instanceEmployee.isVisible(EmployeeConstants.ATTR_NAME_EMPLOYEEPHONENUMBERS));
        assertTrue(instanceEmployee.isVisible(EmployeeConstants.ATTR_NAME_EMPLOYEEEMAIL));
        assertTrue(instanceEmployee.isVisible(EmployeeConstants.ATTR_NAME_EMPLOYEEEMPFULLNAME));
        assertTrue(instanceEmployee.isVisible(EmployeeConstants.ATTR_NAME_EMPLOYEEPICTURE));
        assertTrue(instanceEmployee.isVisible(EmployeeConstants.ATTR_NAME_EMPLOYEENUMOFEXPREPORTS));
    }

    @Test
    public void test4IsAttributeVisible() {
        assertTrue(instanceEmployee.isAttributeVisible(EmployeeConstants.ATTR_NAME_EMPLOYEEEMPNAME));
        assertTrue(instanceEmployee.isAttributeVisible(EmployeeConstants.ATTR_NAME_EMPLOYEEEMPSURNAME));
        assertTrue(instanceEmployee.isAttributeVisible(EmployeeConstants.ATTR_NAME_EMPLOYEESITE));
        assertTrue(instanceEmployee.isAttributeVisible(EmployeeConstants.ATTR_NAME_EMPLOYEEPHONENUMBERS));
        assertTrue(instanceEmployee.isAttributeVisible(EmployeeConstants.ATTR_NAME_EMPLOYEEEMAIL));
        assertTrue(instanceEmployee.isAttributeVisible(EmployeeConstants.ATTR_NAME_EMPLOYEEEMPFULLNAME));
        assertTrue(instanceEmployee.isAttributeVisible(EmployeeConstants.ATTR_NAME_EMPLOYEEPICTURE));
        assertTrue(instanceEmployee.isAttributeVisible(EmployeeConstants.ATTR_NAME_EMPLOYEENUMOFEXPREPORTS));
    }

    @Test
    public void test4getMethods() {
        assertTrue(instanceEmployee.getMethods().length > 0);
    }

    @Test
    public void test4getClassAttributeType() {
        assertNull(instanceEmployee.getClassAttributeType(""));
    }

    @Test
    public void test4getActiveFacets() {
        assertTrue(instanceEmployee.getActiveFacets().contains(Constants.EMPLOYEE));
    }

    @Test
    public void test4getFacets() {
        assertTrue(instanceEmployee.getFacets().contains(Constants.EMPLOYEE));
    }

    @Test
    public void test4checkHorizontalVisibility() {
        assertTrue(instanceEmployee.checkHorizontalVisibility(null));
    }
}
