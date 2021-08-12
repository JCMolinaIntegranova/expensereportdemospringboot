package com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.ExpenseCurrency;
import com.integranova.spring.expensereportdemo.persistence.oid.EmployeeOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseCurrencyOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ProjectOid;
import com.integranova.spring.expensereportdemo.persistence.Project;
import java.sql.Date;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TNEWRequestTest {

    private TNEWRequest instanceTNEWRequest;

    // Default values
    private static EmployeeOid defValue4expenseReportTNEWptpagrEmployee = new EmployeeOid();
    private static Employee defValue4expenseReportTNEWptpagrEmployeeInstance = new Employee(new EmployeeOid(""));
    private static String defValue4expenseReportTNEWptpagrExpenseCurrency = "";
    private static ExpenseCurrency defValue4expenseReportTNEWptpagrExpenseCurrencyInstance = new ExpenseCurrency(new ExpenseCurrencyOid(""));
    private static ProjectOid defValue4expenseReportTNEWptpagrProject = new ProjectOid();
    private static Project defValue4expenseReportTNEWptpagrProjectInstance = new Project(new ProjectOid(Long.valueOf(0)));
    private static Date defValue4expenseReportTNEWptpatrPresentDate = Date.valueOf(Constants.DATE_DEFAULTVALUE);
    private static String defValue4expenseReportTNEWptpatrCause = "";
    private static Double defValue4expenseReportTNEWptpatrAdvances = Double.valueOf(0);
    private static String preconditionIdDefaultValue = "preconditionId";


    // test4getExpenseReportTNEWptpagrEmployee

    // test4setExpenseReportTNEWptpagrEmployee
    private static EmployeeOid test4setExpenseReportTNEWptpagrEmployeeArg1;

    // test4getExpenseReportTNEWptpagrExpenseCurrency

    // test4setExpenseReportTNEWptpagrExpenseCurrency
    private static String test4setExpenseReportTNEWptpagrExpenseCurrencyArg1;

    // test4getExpenseReportTNEWptpagrProject

    // test4setExpenseReportTNEWptpagrProject
    private static ProjectOid test4setExpenseReportTNEWptpagrProjectArg1;

    // test4getExpenseReportTNEWptpatrPresentDate

    // test4setExpenseReportTNEWptpatrPresentDate
    private static Date test4setExpenseReportTNEWptpatrPresentDateArg1;

    // test4getExpenseReportTNEWptpatrCause

    // test4setExpenseReportTNEWptpatrCause
    private static String test4setExpenseReportTNEWptpatrCauseArg1;

    // test4getExpenseReportTNEWptpatrAdvances

    // test4setExpenseReportTNEWptpatrAdvances
    private static Double test4setExpenseReportTNEWptpatrAdvancesArg1;

    // testGetPreconditionId

    // testSetPreconditionId
    private static String testSetPreconditionIdArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getExpenseReportTNEWptpagrEmployee();
        setUpMockData4test4setExpenseReportTNEWptpagrEmployee();
        setUpMockData4test4getExpenseReportTNEWptpagrExpenseCurrency();
        setUpMockData4test4setExpenseReportTNEWptpagrExpenseCurrency();
        setUpMockData4test4getExpenseReportTNEWptpagrProject();
        setUpMockData4test4setExpenseReportTNEWptpagrProject();
        setUpMockData4test4getExpenseReportTNEWptpatrPresentDate();
        setUpMockData4test4setExpenseReportTNEWptpatrPresentDate();
        setUpMockData4test4getExpenseReportTNEWptpatrCause();
        setUpMockData4test4setExpenseReportTNEWptpatrCause();
        setUpMockData4test4getExpenseReportTNEWptpatrAdvances();
        setUpMockData4test4setExpenseReportTNEWptpatrAdvances();
        setUpMockData4testGetPreconditionId();
        setUpMockData4testSetPreconditionId();
    }

    private static void setUpMockData4test4getExpenseReportTNEWptpagrEmployee() {
    }

    private static void setUpMockData4test4setExpenseReportTNEWptpagrEmployee() {
        test4setExpenseReportTNEWptpagrEmployeeArg1 = new EmployeeOid();
    }

    private static void setUpMockData4test4getExpenseReportTNEWptpagrExpenseCurrency() {
    }

    private static void setUpMockData4test4setExpenseReportTNEWptpagrExpenseCurrency() {
        test4setExpenseReportTNEWptpagrExpenseCurrencyArg1 = "";
    }

    private static void setUpMockData4test4getExpenseReportTNEWptpagrProject() {
    }

    private static void setUpMockData4test4setExpenseReportTNEWptpagrProject() {
        test4setExpenseReportTNEWptpagrProjectArg1 = new ProjectOid();
    }

    private static void setUpMockData4test4getExpenseReportTNEWptpatrPresentDate() {
    }

    private static void setUpMockData4test4setExpenseReportTNEWptpatrPresentDate() {
        test4setExpenseReportTNEWptpatrPresentDateArg1 = Date.valueOf(Constants.DATE_DEFAULTVALUE);
    }

    private static void setUpMockData4test4getExpenseReportTNEWptpatrCause() {
    }

    private static void setUpMockData4test4setExpenseReportTNEWptpatrCause() {
        test4setExpenseReportTNEWptpatrCauseArg1 = "";
    }

    private static void setUpMockData4test4getExpenseReportTNEWptpatrAdvances() {
    }

    private static void setUpMockData4test4setExpenseReportTNEWptpatrAdvances() {
        test4setExpenseReportTNEWptpatrAdvancesArg1 = Double.valueOf(0);
    }

    private static void setUpMockData4testGetPreconditionId() {
    }

    private static void setUpMockData4testSetPreconditionId() {
        testSetPreconditionIdArg1 = preconditionIdDefaultValue;
    }

    @Before
    public void setUp() {
        instanceTNEWRequest = new TNEWRequest();
        instanceTNEWRequest.setExpenseReportTNEWptpagrEmployee(defValue4expenseReportTNEWptpagrEmployee);
        instanceTNEWRequest.setExpenseReportTNEWptpagrEmployeeInstance(defValue4expenseReportTNEWptpagrEmployeeInstance);
        instanceTNEWRequest.setExpenseReportTNEWptpagrExpenseCurrency(defValue4expenseReportTNEWptpagrExpenseCurrency);
        instanceTNEWRequest.setExpenseReportTNEWptpagrExpenseCurrencyInstance(defValue4expenseReportTNEWptpagrExpenseCurrencyInstance);
        instanceTNEWRequest.setExpenseReportTNEWptpagrProject(defValue4expenseReportTNEWptpagrProject);
        instanceTNEWRequest.setExpenseReportTNEWptpagrProjectInstance(defValue4expenseReportTNEWptpagrProjectInstance);
        instanceTNEWRequest.setExpenseReportTNEWptpatrPresentDate(defValue4expenseReportTNEWptpatrPresentDate);
        instanceTNEWRequest.setExpenseReportTNEWptpatrCause(defValue4expenseReportTNEWptpatrCause);
        instanceTNEWRequest.setExpenseReportTNEWptpatrAdvances(defValue4expenseReportTNEWptpatrAdvances);
        instanceTNEWRequest.setPreconditionId("preconditionId");
    }

    @Test
    public void test4getExpenseReportTNEWptpagrEmployee() {
        assertEquals(defValue4expenseReportTNEWptpagrEmployee, instanceTNEWRequest.getExpenseReportTNEWptpagrEmployee());
    }

    @Test
    public void test4setExpenseReportTNEWptpagrEmployee() {
        instanceTNEWRequest.setExpenseReportTNEWptpagrEmployee(test4setExpenseReportTNEWptpagrEmployeeArg1);
        assertNotNull(instanceTNEWRequest);
    }

    @Test
    public void test4getExpenseReportTNEWptpagrExpenseCurrency() {
        assertEquals(defValue4expenseReportTNEWptpagrExpenseCurrency, instanceTNEWRequest.getExpenseReportTNEWptpagrExpenseCurrency());
    }

    @Test
    public void test4setExpenseReportTNEWptpagrExpenseCurrency() {
        instanceTNEWRequest.setExpenseReportTNEWptpagrExpenseCurrency(test4setExpenseReportTNEWptpagrExpenseCurrencyArg1);
        assertNotNull(instanceTNEWRequest);
    }

    @Test
    public void test4getExpenseReportTNEWptpagrProject() {
        assertEquals(defValue4expenseReportTNEWptpagrProject, instanceTNEWRequest.getExpenseReportTNEWptpagrProject());
    }

    @Test
    public void test4setExpenseReportTNEWptpagrProject() {
        instanceTNEWRequest.setExpenseReportTNEWptpagrProject(test4setExpenseReportTNEWptpagrProjectArg1);
        assertNotNull(instanceTNEWRequest);
    }

    @Test
    public void test4getExpenseReportTNEWptpatrPresentDate() {
        assertEquals(defValue4expenseReportTNEWptpatrPresentDate, instanceTNEWRequest.getExpenseReportTNEWptpatrPresentDate());
    }

    @Test
    public void test4setExpenseReportTNEWptpatrPresentDate() {
        instanceTNEWRequest.setExpenseReportTNEWptpatrPresentDate(test4setExpenseReportTNEWptpatrPresentDateArg1);
        assertNotNull(instanceTNEWRequest);
    }

    @Test
    public void test4getExpenseReportTNEWptpatrCause() {
        assertEquals(defValue4expenseReportTNEWptpatrCause, instanceTNEWRequest.getExpenseReportTNEWptpatrCause());
    }

    @Test
    public void test4setExpenseReportTNEWptpatrCause() {
        instanceTNEWRequest.setExpenseReportTNEWptpatrCause(test4setExpenseReportTNEWptpatrCauseArg1);
        assertNotNull(instanceTNEWRequest);
    }

    @Test
    public void test4getExpenseReportTNEWptpatrAdvances() {
        assertEquals(defValue4expenseReportTNEWptpatrAdvances, instanceTNEWRequest.getExpenseReportTNEWptpatrAdvances());
    }

    @Test
    public void test4setExpenseReportTNEWptpatrAdvances() {
        instanceTNEWRequest.setExpenseReportTNEWptpatrAdvances(test4setExpenseReportTNEWptpatrAdvancesArg1);
        assertNotNull(instanceTNEWRequest);
    }

    @Test
    public void testGetPreconditionId() {
        assertEquals(preconditionIdDefaultValue, instanceTNEWRequest.getPreconditionId());
    }

    @Test
    public void testSetPreconditionId() {
        instanceTNEWRequest.setPreconditionId(testSetPreconditionIdArg1);
        assertNotNull(instanceTNEWRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceTNEWRequest = new TNEWRequest();
    	instanceTNEWRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceTNEWRequest.checkArguments();
    }
}
