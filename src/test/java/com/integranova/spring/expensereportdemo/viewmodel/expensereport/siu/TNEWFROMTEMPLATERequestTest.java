package com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.ERTemplate;
import com.integranova.spring.expensereportdemo.persistence.ExpenseCurrency;
import com.integranova.spring.expensereportdemo.persistence.oid.EmployeeOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ERTemplateOid;
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
public class TNEWFROMTEMPLATERequestTest {

    private TNEWFROMTEMPLATERequest instanceTNEWFROMTEMPLATERequest;

    // Default values
    private static EmployeeOid defValue4expenseReportTNEWFROMTEMPLATEptpagrEmployee = new EmployeeOid();
    private static Employee defValue4expenseReportTNEWFROMTEMPLATEptpagrEmployeeInstance = new Employee(new EmployeeOid(""));
    private static String defValue4expenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency = "";
    private static ExpenseCurrency defValue4expenseReportTNEWFROMTEMPLATEptpagrExpenseCurrencyInstance = new ExpenseCurrency(new ExpenseCurrencyOid(""));
    private static ProjectOid defValue4expenseReportTNEWFROMTEMPLATEptpagrProject = new ProjectOid();
    private static Project defValue4expenseReportTNEWFROMTEMPLATEptpagrProjectInstance = new Project(new ProjectOid(Long.valueOf(0)));
    private static Date defValue4expenseReportTNEWFROMTEMPLATEptpatrPresentDate = Date.valueOf(Constants.DATE_DEFAULTVALUE);
    private static String defValue4expenseReportTNEWFROMTEMPLATEptpatrCause = "";
    private static Double defValue4expenseReportTNEWFROMTEMPLATEptpatrAdvances = Double.valueOf(0);
    private static ERTemplateOid defValue4expenseReportTNEWFROMTEMPLATEpTemplate = new ERTemplateOid();
    private static ERTemplate defValue4expenseReportTNEWFROMTEMPLATEpTemplateInstance = new ERTemplate(new ERTemplateOid(Long.valueOf(0)));
    private static String preconditionIdDefaultValue = "preconditionId";


    // test4getExpenseReportTNEWFROMTEMPLATEptpagrEmployee

    // test4setExpenseReportTNEWFROMTEMPLATEptpagrEmployee
    private static EmployeeOid test4setExpenseReportTNEWFROMTEMPLATEptpagrEmployeeArg1;

    // test4getExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency

    // test4setExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency
    private static String test4setExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrencyArg1;

    // test4getExpenseReportTNEWFROMTEMPLATEptpagrProject

    // test4setExpenseReportTNEWFROMTEMPLATEptpagrProject
    private static ProjectOid test4setExpenseReportTNEWFROMTEMPLATEptpagrProjectArg1;

    // test4getExpenseReportTNEWFROMTEMPLATEptpatrPresentDate

    // test4setExpenseReportTNEWFROMTEMPLATEptpatrPresentDate
    private static Date test4setExpenseReportTNEWFROMTEMPLATEptpatrPresentDateArg1;

    // test4getExpenseReportTNEWFROMTEMPLATEptpatrCause

    // test4setExpenseReportTNEWFROMTEMPLATEptpatrCause
    private static String test4setExpenseReportTNEWFROMTEMPLATEptpatrCauseArg1;

    // test4getExpenseReportTNEWFROMTEMPLATEptpatrAdvances

    // test4setExpenseReportTNEWFROMTEMPLATEptpatrAdvances
    private static Double test4setExpenseReportTNEWFROMTEMPLATEptpatrAdvancesArg1;

    // test4getExpenseReportTNEWFROMTEMPLATEpTemplate

    // test4setExpenseReportTNEWFROMTEMPLATEpTemplate
    private static ERTemplateOid test4setExpenseReportTNEWFROMTEMPLATEpTemplateArg1;

    // testGetPreconditionId

    // testSetPreconditionId
    private static String testSetPreconditionIdArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getExpenseReportTNEWFROMTEMPLATEptpagrEmployee();
        setUpMockData4test4setExpenseReportTNEWFROMTEMPLATEptpagrEmployee();
        setUpMockData4test4getExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency();
        setUpMockData4test4setExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency();
        setUpMockData4test4getExpenseReportTNEWFROMTEMPLATEptpagrProject();
        setUpMockData4test4setExpenseReportTNEWFROMTEMPLATEptpagrProject();
        setUpMockData4test4getExpenseReportTNEWFROMTEMPLATEptpatrPresentDate();
        setUpMockData4test4setExpenseReportTNEWFROMTEMPLATEptpatrPresentDate();
        setUpMockData4test4getExpenseReportTNEWFROMTEMPLATEptpatrCause();
        setUpMockData4test4setExpenseReportTNEWFROMTEMPLATEptpatrCause();
        setUpMockData4test4getExpenseReportTNEWFROMTEMPLATEptpatrAdvances();
        setUpMockData4test4setExpenseReportTNEWFROMTEMPLATEptpatrAdvances();
        setUpMockData4test4getExpenseReportTNEWFROMTEMPLATEpTemplate();
        setUpMockData4test4setExpenseReportTNEWFROMTEMPLATEpTemplate();
        setUpMockData4testGetPreconditionId();
        setUpMockData4testSetPreconditionId();
    }

    private static void setUpMockData4test4getExpenseReportTNEWFROMTEMPLATEptpagrEmployee() {
    }

    private static void setUpMockData4test4setExpenseReportTNEWFROMTEMPLATEptpagrEmployee() {
        test4setExpenseReportTNEWFROMTEMPLATEptpagrEmployeeArg1 = new EmployeeOid();
    }

    private static void setUpMockData4test4getExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency() {
    }

    private static void setUpMockData4test4setExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency() {
        test4setExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrencyArg1 = "";
    }

    private static void setUpMockData4test4getExpenseReportTNEWFROMTEMPLATEptpagrProject() {
    }

    private static void setUpMockData4test4setExpenseReportTNEWFROMTEMPLATEptpagrProject() {
        test4setExpenseReportTNEWFROMTEMPLATEptpagrProjectArg1 = new ProjectOid();
    }

    private static void setUpMockData4test4getExpenseReportTNEWFROMTEMPLATEptpatrPresentDate() {
    }

    private static void setUpMockData4test4setExpenseReportTNEWFROMTEMPLATEptpatrPresentDate() {
        test4setExpenseReportTNEWFROMTEMPLATEptpatrPresentDateArg1 = Date.valueOf(Constants.DATE_DEFAULTVALUE);
    }

    private static void setUpMockData4test4getExpenseReportTNEWFROMTEMPLATEptpatrCause() {
    }

    private static void setUpMockData4test4setExpenseReportTNEWFROMTEMPLATEptpatrCause() {
        test4setExpenseReportTNEWFROMTEMPLATEptpatrCauseArg1 = "";
    }

    private static void setUpMockData4test4getExpenseReportTNEWFROMTEMPLATEptpatrAdvances() {
    }

    private static void setUpMockData4test4setExpenseReportTNEWFROMTEMPLATEptpatrAdvances() {
        test4setExpenseReportTNEWFROMTEMPLATEptpatrAdvancesArg1 = Double.valueOf(0);
    }

    private static void setUpMockData4test4getExpenseReportTNEWFROMTEMPLATEpTemplate() {
    }

    private static void setUpMockData4test4setExpenseReportTNEWFROMTEMPLATEpTemplate() {
        test4setExpenseReportTNEWFROMTEMPLATEpTemplateArg1 = new ERTemplateOid();
    }

    private static void setUpMockData4testGetPreconditionId() {
    }

    private static void setUpMockData4testSetPreconditionId() {
        testSetPreconditionIdArg1 = preconditionIdDefaultValue;
    }

    @Before
    public void setUp() {
        instanceTNEWFROMTEMPLATERequest = new TNEWFROMTEMPLATERequest();
        instanceTNEWFROMTEMPLATERequest.setExpenseReportTNEWFROMTEMPLATEptpagrEmployee(defValue4expenseReportTNEWFROMTEMPLATEptpagrEmployee);
        instanceTNEWFROMTEMPLATERequest.setExpenseReportTNEWFROMTEMPLATEptpagrEmployeeInstance(defValue4expenseReportTNEWFROMTEMPLATEptpagrEmployeeInstance);
        instanceTNEWFROMTEMPLATERequest.setExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency(defValue4expenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency);
        instanceTNEWFROMTEMPLATERequest.setExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrencyInstance(defValue4expenseReportTNEWFROMTEMPLATEptpagrExpenseCurrencyInstance);
        instanceTNEWFROMTEMPLATERequest.setExpenseReportTNEWFROMTEMPLATEptpagrProject(defValue4expenseReportTNEWFROMTEMPLATEptpagrProject);
        instanceTNEWFROMTEMPLATERequest.setExpenseReportTNEWFROMTEMPLATEptpagrProjectInstance(defValue4expenseReportTNEWFROMTEMPLATEptpagrProjectInstance);
        instanceTNEWFROMTEMPLATERequest.setExpenseReportTNEWFROMTEMPLATEptpatrPresentDate(defValue4expenseReportTNEWFROMTEMPLATEptpatrPresentDate);
        instanceTNEWFROMTEMPLATERequest.setExpenseReportTNEWFROMTEMPLATEptpatrCause(defValue4expenseReportTNEWFROMTEMPLATEptpatrCause);
        instanceTNEWFROMTEMPLATERequest.setExpenseReportTNEWFROMTEMPLATEptpatrAdvances(defValue4expenseReportTNEWFROMTEMPLATEptpatrAdvances);
        instanceTNEWFROMTEMPLATERequest.setExpenseReportTNEWFROMTEMPLATEpTemplate(defValue4expenseReportTNEWFROMTEMPLATEpTemplate);
        instanceTNEWFROMTEMPLATERequest.setExpenseReportTNEWFROMTEMPLATEpTemplateInstance(defValue4expenseReportTNEWFROMTEMPLATEpTemplateInstance);
        instanceTNEWFROMTEMPLATERequest.setPreconditionId("preconditionId");
    }

    @Test
    public void test4getExpenseReportTNEWFROMTEMPLATEptpagrEmployee() {
        assertEquals(defValue4expenseReportTNEWFROMTEMPLATEptpagrEmployee, instanceTNEWFROMTEMPLATERequest.getExpenseReportTNEWFROMTEMPLATEptpagrEmployee());
    }

    @Test
    public void test4setExpenseReportTNEWFROMTEMPLATEptpagrEmployee() {
        instanceTNEWFROMTEMPLATERequest.setExpenseReportTNEWFROMTEMPLATEptpagrEmployee(test4setExpenseReportTNEWFROMTEMPLATEptpagrEmployeeArg1);
        assertNotNull(instanceTNEWFROMTEMPLATERequest);
    }

    @Test
    public void test4getExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency() {
        assertEquals(defValue4expenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency, instanceTNEWFROMTEMPLATERequest.getExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency());
    }

    @Test
    public void test4setExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency() {
        instanceTNEWFROMTEMPLATERequest.setExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrency(test4setExpenseReportTNEWFROMTEMPLATEptpagrExpenseCurrencyArg1);
        assertNotNull(instanceTNEWFROMTEMPLATERequest);
    }

    @Test
    public void test4getExpenseReportTNEWFROMTEMPLATEptpagrProject() {
        assertEquals(defValue4expenseReportTNEWFROMTEMPLATEptpagrProject, instanceTNEWFROMTEMPLATERequest.getExpenseReportTNEWFROMTEMPLATEptpagrProject());
    }

    @Test
    public void test4setExpenseReportTNEWFROMTEMPLATEptpagrProject() {
        instanceTNEWFROMTEMPLATERequest.setExpenseReportTNEWFROMTEMPLATEptpagrProject(test4setExpenseReportTNEWFROMTEMPLATEptpagrProjectArg1);
        assertNotNull(instanceTNEWFROMTEMPLATERequest);
    }

    @Test
    public void test4getExpenseReportTNEWFROMTEMPLATEptpatrPresentDate() {
        assertEquals(defValue4expenseReportTNEWFROMTEMPLATEptpatrPresentDate, instanceTNEWFROMTEMPLATERequest.getExpenseReportTNEWFROMTEMPLATEptpatrPresentDate());
    }

    @Test
    public void test4setExpenseReportTNEWFROMTEMPLATEptpatrPresentDate() {
        instanceTNEWFROMTEMPLATERequest.setExpenseReportTNEWFROMTEMPLATEptpatrPresentDate(test4setExpenseReportTNEWFROMTEMPLATEptpatrPresentDateArg1);
        assertNotNull(instanceTNEWFROMTEMPLATERequest);
    }

    @Test
    public void test4getExpenseReportTNEWFROMTEMPLATEptpatrCause() {
        assertEquals(defValue4expenseReportTNEWFROMTEMPLATEptpatrCause, instanceTNEWFROMTEMPLATERequest.getExpenseReportTNEWFROMTEMPLATEptpatrCause());
    }

    @Test
    public void test4setExpenseReportTNEWFROMTEMPLATEptpatrCause() {
        instanceTNEWFROMTEMPLATERequest.setExpenseReportTNEWFROMTEMPLATEptpatrCause(test4setExpenseReportTNEWFROMTEMPLATEptpatrCauseArg1);
        assertNotNull(instanceTNEWFROMTEMPLATERequest);
    }

    @Test
    public void test4getExpenseReportTNEWFROMTEMPLATEptpatrAdvances() {
        assertEquals(defValue4expenseReportTNEWFROMTEMPLATEptpatrAdvances, instanceTNEWFROMTEMPLATERequest.getExpenseReportTNEWFROMTEMPLATEptpatrAdvances());
    }

    @Test
    public void test4setExpenseReportTNEWFROMTEMPLATEptpatrAdvances() {
        instanceTNEWFROMTEMPLATERequest.setExpenseReportTNEWFROMTEMPLATEptpatrAdvances(test4setExpenseReportTNEWFROMTEMPLATEptpatrAdvancesArg1);
        assertNotNull(instanceTNEWFROMTEMPLATERequest);
    }

    @Test
    public void test4getExpenseReportTNEWFROMTEMPLATEpTemplate() {
        assertEquals(defValue4expenseReportTNEWFROMTEMPLATEpTemplate, instanceTNEWFROMTEMPLATERequest.getExpenseReportTNEWFROMTEMPLATEpTemplate());
    }

    @Test
    public void test4setExpenseReportTNEWFROMTEMPLATEpTemplate() {
        instanceTNEWFROMTEMPLATERequest.setExpenseReportTNEWFROMTEMPLATEpTemplate(test4setExpenseReportTNEWFROMTEMPLATEpTemplateArg1);
        assertNotNull(instanceTNEWFROMTEMPLATERequest);
    }

    @Test
    public void testGetPreconditionId() {
        assertEquals(preconditionIdDefaultValue, instanceTNEWFROMTEMPLATERequest.getPreconditionId());
    }

    @Test
    public void testSetPreconditionId() {
        instanceTNEWFROMTEMPLATERequest.setPreconditionId(testSetPreconditionIdArg1);
        assertNotNull(instanceTNEWFROMTEMPLATERequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceTNEWFROMTEMPLATERequest = new TNEWFROMTEMPLATERequest();
    	instanceTNEWFROMTEMPLATERequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceTNEWFROMTEMPLATERequest.checkArguments();
    }
}
