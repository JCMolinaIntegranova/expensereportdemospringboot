package com.integranova.spring.expensereportdemo.viewmodel.expensereport.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.persistence.Employee;
import com.integranova.spring.expensereportdemo.persistence.ExpenseCurrency;
import com.integranova.spring.expensereportdemo.persistence.oid.EmployeeOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseCurrencyOid;
import com.integranova.spring.expensereportdemo.persistence.oid.PaymentTypeOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ProjectOid;
import com.integranova.spring.expensereportdemo.persistence.PaymentType;
import com.integranova.spring.expensereportdemo.persistence.Project;
import java.sql.Date;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class NewexpenseRequestTest {

    private NewexpenseRequest instanceNewexpenseRequest;

    // Default values
    private static ExpenseCurrencyOid defValue4expenseReportnewexpensepagrExpenseCurrency = new ExpenseCurrencyOid();
    private static ExpenseCurrency defValue4expenseReportnewexpensepagrExpenseCurrencyInstance = new ExpenseCurrency(new ExpenseCurrencyOid(""));
    private static PaymentTypeOid defValue4expenseReportnewexpensepagrPaymentType = new PaymentTypeOid();
    private static PaymentType defValue4expenseReportnewexpensepagrPaymentTypeInstance = new PaymentType(new PaymentTypeOid(""));
    private static ProjectOid defValue4expenseReportnewexpensepagrProject = new ProjectOid();
    private static Project defValue4expenseReportnewexpensepagrProjectInstance = new Project(new ProjectOid(Long.valueOf(0)));
    private static EmployeeOid defValue4expenseReportnewexpensepagrEmployee = new EmployeeOid();
    private static Employee defValue4expenseReportnewexpensepagrEmployeeInstance = new Employee(new EmployeeOid(""));
    private static Date defValue4expenseReportnewexpensepatrPresentDate = Date.valueOf(Constants.DATE_DEFAULTVALUE);
    private static String defValue4expenseReportnewexpensepatrCause = "";
    private static Double defValue4expenseReportnewexpensepatrAdvances = Double.valueOf(0);
    private static Double defValue4expenseReportnewexpensepatrExchange = Double.valueOf(0);


    // test4getExpenseReportnewexpensepagrExpenseCurrency

    // test4setExpenseReportnewexpensepagrExpenseCurrency
    private static ExpenseCurrencyOid test4setExpenseReportnewexpensepagrExpenseCurrencyArg1;

    // test4getExpenseReportnewexpensepagrPaymentType

    // test4setExpenseReportnewexpensepagrPaymentType
    private static PaymentTypeOid test4setExpenseReportnewexpensepagrPaymentTypeArg1;

    // test4getExpenseReportnewexpensepagrProject

    // test4setExpenseReportnewexpensepagrProject
    private static ProjectOid test4setExpenseReportnewexpensepagrProjectArg1;

    // test4getExpenseReportnewexpensepagrEmployee

    // test4setExpenseReportnewexpensepagrEmployee
    private static EmployeeOid test4setExpenseReportnewexpensepagrEmployeeArg1;

    // test4getExpenseReportnewexpensepatrPresentDate

    // test4setExpenseReportnewexpensepatrPresentDate
    private static Date test4setExpenseReportnewexpensepatrPresentDateArg1;

    // test4getExpenseReportnewexpensepatrCause

    // test4setExpenseReportnewexpensepatrCause
    private static String test4setExpenseReportnewexpensepatrCauseArg1;

    // test4getExpenseReportnewexpensepatrAdvances

    // test4setExpenseReportnewexpensepatrAdvances
    private static Double test4setExpenseReportnewexpensepatrAdvancesArg1;

    // test4getExpenseReportnewexpensepatrExchange

    // test4setExpenseReportnewexpensepatrExchange
    private static Double test4setExpenseReportnewexpensepatrExchangeArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getExpenseReportnewexpensepagrExpenseCurrency();
        setUpMockData4test4setExpenseReportnewexpensepagrExpenseCurrency();
        setUpMockData4test4getExpenseReportnewexpensepagrPaymentType();
        setUpMockData4test4setExpenseReportnewexpensepagrPaymentType();
        setUpMockData4test4getExpenseReportnewexpensepagrProject();
        setUpMockData4test4setExpenseReportnewexpensepagrProject();
        setUpMockData4test4getExpenseReportnewexpensepagrEmployee();
        setUpMockData4test4setExpenseReportnewexpensepagrEmployee();
        setUpMockData4test4getExpenseReportnewexpensepatrPresentDate();
        setUpMockData4test4setExpenseReportnewexpensepatrPresentDate();
        setUpMockData4test4getExpenseReportnewexpensepatrCause();
        setUpMockData4test4setExpenseReportnewexpensepatrCause();
        setUpMockData4test4getExpenseReportnewexpensepatrAdvances();
        setUpMockData4test4setExpenseReportnewexpensepatrAdvances();
        setUpMockData4test4getExpenseReportnewexpensepatrExchange();
        setUpMockData4test4setExpenseReportnewexpensepatrExchange();
    }

    private static void setUpMockData4test4getExpenseReportnewexpensepagrExpenseCurrency() {
    }

    private static void setUpMockData4test4setExpenseReportnewexpensepagrExpenseCurrency() {
        test4setExpenseReportnewexpensepagrExpenseCurrencyArg1 = new ExpenseCurrencyOid();
    }

    private static void setUpMockData4test4getExpenseReportnewexpensepagrPaymentType() {
    }

    private static void setUpMockData4test4setExpenseReportnewexpensepagrPaymentType() {
        test4setExpenseReportnewexpensepagrPaymentTypeArg1 = new PaymentTypeOid();
    }

    private static void setUpMockData4test4getExpenseReportnewexpensepagrProject() {
    }

    private static void setUpMockData4test4setExpenseReportnewexpensepagrProject() {
        test4setExpenseReportnewexpensepagrProjectArg1 = new ProjectOid();
    }

    private static void setUpMockData4test4getExpenseReportnewexpensepagrEmployee() {
    }

    private static void setUpMockData4test4setExpenseReportnewexpensepagrEmployee() {
        test4setExpenseReportnewexpensepagrEmployeeArg1 = new EmployeeOid();
    }

    private static void setUpMockData4test4getExpenseReportnewexpensepatrPresentDate() {
    }

    private static void setUpMockData4test4setExpenseReportnewexpensepatrPresentDate() {
        test4setExpenseReportnewexpensepatrPresentDateArg1 = Date.valueOf(Constants.DATE_DEFAULTVALUE);
    }

    private static void setUpMockData4test4getExpenseReportnewexpensepatrCause() {
    }

    private static void setUpMockData4test4setExpenseReportnewexpensepatrCause() {
        test4setExpenseReportnewexpensepatrCauseArg1 = "";
    }

    private static void setUpMockData4test4getExpenseReportnewexpensepatrAdvances() {
    }

    private static void setUpMockData4test4setExpenseReportnewexpensepatrAdvances() {
        test4setExpenseReportnewexpensepatrAdvancesArg1 = Double.valueOf(0);
    }

    private static void setUpMockData4test4getExpenseReportnewexpensepatrExchange() {
    }

    private static void setUpMockData4test4setExpenseReportnewexpensepatrExchange() {
        test4setExpenseReportnewexpensepatrExchangeArg1 = Double.valueOf(0);
    }

    @Before
    public void setUp() {
        instanceNewexpenseRequest = new NewexpenseRequest();
        instanceNewexpenseRequest.setExpenseReportnewexpensepagrExpenseCurrency(defValue4expenseReportnewexpensepagrExpenseCurrency);
        instanceNewexpenseRequest.setExpenseReportnewexpensepagrExpenseCurrencyInstance(defValue4expenseReportnewexpensepagrExpenseCurrencyInstance);
        instanceNewexpenseRequest.setExpenseReportnewexpensepagrPaymentType(defValue4expenseReportnewexpensepagrPaymentType);
        instanceNewexpenseRequest.setExpenseReportnewexpensepagrPaymentTypeInstance(defValue4expenseReportnewexpensepagrPaymentTypeInstance);
        instanceNewexpenseRequest.setExpenseReportnewexpensepagrProject(defValue4expenseReportnewexpensepagrProject);
        instanceNewexpenseRequest.setExpenseReportnewexpensepagrProjectInstance(defValue4expenseReportnewexpensepagrProjectInstance);
        instanceNewexpenseRequest.setExpenseReportnewexpensepagrEmployee(defValue4expenseReportnewexpensepagrEmployee);
        instanceNewexpenseRequest.setExpenseReportnewexpensepagrEmployeeInstance(defValue4expenseReportnewexpensepagrEmployeeInstance);
        instanceNewexpenseRequest.setExpenseReportnewexpensepatrPresentDate(defValue4expenseReportnewexpensepatrPresentDate);
        instanceNewexpenseRequest.setExpenseReportnewexpensepatrCause(defValue4expenseReportnewexpensepatrCause);
        instanceNewexpenseRequest.setExpenseReportnewexpensepatrAdvances(defValue4expenseReportnewexpensepatrAdvances);
        instanceNewexpenseRequest.setExpenseReportnewexpensepatrExchange(defValue4expenseReportnewexpensepatrExchange);
    }

    @Test
    public void test4getExpenseReportnewexpensepagrExpenseCurrency() {
        assertEquals(defValue4expenseReportnewexpensepagrExpenseCurrency, instanceNewexpenseRequest.getExpenseReportnewexpensepagrExpenseCurrency());
    }

    @Test
    public void test4setExpenseReportnewexpensepagrExpenseCurrency() {
        instanceNewexpenseRequest.setExpenseReportnewexpensepagrExpenseCurrency(test4setExpenseReportnewexpensepagrExpenseCurrencyArg1);
        assertNotNull(instanceNewexpenseRequest);
    }

    @Test
    public void test4getExpenseReportnewexpensepagrPaymentType() {
        assertEquals(defValue4expenseReportnewexpensepagrPaymentType, instanceNewexpenseRequest.getExpenseReportnewexpensepagrPaymentType());
    }

    @Test
    public void test4setExpenseReportnewexpensepagrPaymentType() {
        instanceNewexpenseRequest.setExpenseReportnewexpensepagrPaymentType(test4setExpenseReportnewexpensepagrPaymentTypeArg1);
        assertNotNull(instanceNewexpenseRequest);
    }

    @Test
    public void test4getExpenseReportnewexpensepagrProject() {
        assertEquals(defValue4expenseReportnewexpensepagrProject, instanceNewexpenseRequest.getExpenseReportnewexpensepagrProject());
    }

    @Test
    public void test4setExpenseReportnewexpensepagrProject() {
        instanceNewexpenseRequest.setExpenseReportnewexpensepagrProject(test4setExpenseReportnewexpensepagrProjectArg1);
        assertNotNull(instanceNewexpenseRequest);
    }

    @Test
    public void test4getExpenseReportnewexpensepagrEmployee() {
        assertEquals(defValue4expenseReportnewexpensepagrEmployee, instanceNewexpenseRequest.getExpenseReportnewexpensepagrEmployee());
    }

    @Test
    public void test4setExpenseReportnewexpensepagrEmployee() {
        instanceNewexpenseRequest.setExpenseReportnewexpensepagrEmployee(test4setExpenseReportnewexpensepagrEmployeeArg1);
        assertNotNull(instanceNewexpenseRequest);
    }

    @Test
    public void test4getExpenseReportnewexpensepatrPresentDate() {
        assertEquals(defValue4expenseReportnewexpensepatrPresentDate, instanceNewexpenseRequest.getExpenseReportnewexpensepatrPresentDate());
    }

    @Test
    public void test4setExpenseReportnewexpensepatrPresentDate() {
        instanceNewexpenseRequest.setExpenseReportnewexpensepatrPresentDate(test4setExpenseReportnewexpensepatrPresentDateArg1);
        assertNotNull(instanceNewexpenseRequest);
    }

    @Test
    public void test4getExpenseReportnewexpensepatrCause() {
        assertEquals(defValue4expenseReportnewexpensepatrCause, instanceNewexpenseRequest.getExpenseReportnewexpensepatrCause());
    }

    @Test
    public void test4setExpenseReportnewexpensepatrCause() {
        instanceNewexpenseRequest.setExpenseReportnewexpensepatrCause(test4setExpenseReportnewexpensepatrCauseArg1);
        assertNotNull(instanceNewexpenseRequest);
    }

    @Test
    public void test4getExpenseReportnewexpensepatrAdvances() {
        assertEquals(defValue4expenseReportnewexpensepatrAdvances, instanceNewexpenseRequest.getExpenseReportnewexpensepatrAdvances());
    }

    @Test
    public void test4setExpenseReportnewexpensepatrAdvances() {
        instanceNewexpenseRequest.setExpenseReportnewexpensepatrAdvances(test4setExpenseReportnewexpensepatrAdvancesArg1);
        assertNotNull(instanceNewexpenseRequest);
    }

    @Test
    public void test4getExpenseReportnewexpensepatrExchange() {
        assertEquals(defValue4expenseReportnewexpensepatrExchange, instanceNewexpenseRequest.getExpenseReportnewexpensepatrExchange());
    }

    @Test
    public void test4setExpenseReportnewexpensepatrExchange() {
        instanceNewexpenseRequest.setExpenseReportnewexpensepatrExchange(test4setExpenseReportnewexpensepatrExchangeArg1);
        assertNotNull(instanceNewexpenseRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceNewexpenseRequest = new NewexpenseRequest();
    	instanceNewexpenseRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceNewexpenseRequest.checkArguments();
    }
}
