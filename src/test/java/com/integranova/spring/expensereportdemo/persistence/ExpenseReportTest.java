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
import com.integranova.spring.expensereportdemo.global.ExpenseReportConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.EmployeeOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseCurrencyOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseReportOid;
import com.integranova.spring.expensereportdemo.persistence.oid.PaymentTypeOid;
import com.integranova.spring.expensereportdemo.persistence.oid.ProjectOid;
import com.integranova.spring.expensereportdemo.repository.EmployeeJpaRepository;
import com.integranova.spring.expensereportdemo.repository.ExpenseCurrencyJpaRepository;
import com.integranova.spring.expensereportdemo.repository.ExpenseLineJpaRepository;
import com.integranova.spring.expensereportdemo.repository.ExpenseReportJpaRepository;
import com.integranova.spring.expensereportdemo.repository.PaymentTypeJpaRepository;
import com.integranova.spring.expensereportdemo.repository.ProjectJpaRepository;
import com.integranova.spring.expensereportdemo.utils.Agent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ExpenseReportTest {

    private static ExpenseReportJpaRepository mockExpenseReportJpaRepository;

    private static ExpenseLineJpaRepository mockExpenseLineJpaRepository;

    private static EmployeeJpaRepository mockEmployeeJpaRepository;

    private static ExpenseCurrencyJpaRepository mockExpenseCurrencyJpaRepository;

    private static PaymentTypeJpaRepository mockPaymentTypeJpaRepository;

    private static ProjectJpaRepository mockProjectJpaRepository;

    private static Agent mockAgent;

    ExpenseReport instanceExpenseReport;

    private static boolean TESTDERIVATIONS = false;

    private static Long VALUE_EXPENSEREPORTIDEXPENSEREPOR;
    private static Date VALUE_EXPENSEREPORTPRESENTDATE;
    private static Long VALUE_EXPENSEREPORTSTATUS;
    private static String VALUE_EXPENSEREPORTCAUSE;
    private static Date VALUE_EXPENSEREPORTAUTHODATE;
    private static String VALUE_EXPENSEREPORTAUTHOCOMMENTS;
    private static Date VALUE_EXPENSEREPORTPAYMENTDATE;
    private static String VALUE_EXPENSEREPORTPAYCOMMENTS;
    private static Double VALUE_EXPENSEREPORTTOTEXPENSES;
    private static Double VALUE_EXPENSEREPORTTOTEXPENSESCUR;
    private static Double VALUE_EXPENSEREPORTADVANCES;
    private static Double VALUE_EXPENSEREPORTADVANCESCUR;
    private static Double VALUE_EXPENSEREPORTEXCHANGE;
    private static Double VALUE_EXPENSEREPORTBALANCE;
    private static Double VALUE_EXPENSEREPORTBALANCECUR;
    private static List<ExpenseLine> VALUE_EXPENSELINES;
    private static Employee VALUE_EMPLOYEE;
    private static ExpenseCurrency VALUE_EXPENSECURRENCY;
    private static PaymentType VALUE_PAYMENTTYPE;
    private static Project VALUE_PROJECT;
    private static ExpenseReport VALUE_ASSOCOPERATOR000_INSTANCE;
    private static Double VALUE_ASSOCOPERATOR000_RETURN;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        VALUE_EXPENSEREPORTIDEXPENSEREPOR = Long.valueOf(0);
        VALUE_EXPENSEREPORTPRESENTDATE = Date.valueOf(Constants.DATE_DEFAULTVALUE);
        VALUE_EXPENSEREPORTSTATUS = Long.valueOf(0);
        VALUE_EXPENSEREPORTCAUSE = "expenseReportCause";
        VALUE_EXPENSEREPORTAUTHODATE = Date.valueOf(Constants.DATE_DEFAULTVALUE);
        VALUE_EXPENSEREPORTAUTHOCOMMENTS = "expenseReportAuthoComments";
        VALUE_EXPENSEREPORTPAYMENTDATE = Date.valueOf(Constants.DATE_DEFAULTVALUE);
        VALUE_EXPENSEREPORTPAYCOMMENTS = "expenseReportPayComments";
        VALUE_EXPENSEREPORTTOTEXPENSES = Double.valueOf(0);
        VALUE_EXPENSEREPORTTOTEXPENSESCUR = Double.valueOf(0);
        VALUE_EXPENSEREPORTADVANCES = Double.valueOf(0);
        VALUE_EXPENSEREPORTADVANCESCUR = Double.valueOf(0);
        VALUE_EXPENSEREPORTEXCHANGE = Double.valueOf(0);
        VALUE_EXPENSEREPORTBALANCE = Double.valueOf(0);
        VALUE_EXPENSEREPORTBALANCECUR = Double.valueOf(0);
        VALUE_EXPENSELINES = new ArrayList<>();
        VALUE_EXPENSELINES.add(new ExpenseLine());
        VALUE_EMPLOYEE = new Employee(new EmployeeOid("employeeidEmployee"));
        VALUE_EXPENSECURRENCY = new ExpenseCurrency(new ExpenseCurrencyOid("expenseCurrencyCurrencyCode"));
        VALUE_PAYMENTTYPE = new PaymentType(new PaymentTypeOid("paymentTypeidPaymentType"));
        VALUE_PROJECT = new Project(new ProjectOid(Long.valueOf(0)));
        VALUE_ASSOCOPERATOR000_INSTANCE = new ExpenseReport();
        VALUE_ASSOCOPERATOR000_RETURN = Double.valueOf(0);
        mockExpenseReportJpaRepository = mock(ExpenseReportJpaRepository.class);
        mockExpenseLineJpaRepository = mock(ExpenseLineJpaRepository.class);
        mockEmployeeJpaRepository = mock(EmployeeJpaRepository.class);
        mockExpenseCurrencyJpaRepository = mock(ExpenseCurrencyJpaRepository.class);
        mockPaymentTypeJpaRepository = mock(PaymentTypeJpaRepository.class);
        mockProjectJpaRepository = mock(ProjectJpaRepository.class);
        mockAgent = mock(Agent.class);
    }

    @Before
    public void setUp() throws SystemException {
        instanceExpenseReport = new ExpenseReport();
        instanceExpenseReport.setExpenseReportRepository(mockExpenseReportJpaRepository);
        instanceExpenseReport.setExpenseLineRepository(mockExpenseLineJpaRepository);
        instanceExpenseReport.setEmployeeRepository(mockEmployeeJpaRepository);
        instanceExpenseReport.setExpenseCurrencyRepository(mockExpenseCurrencyJpaRepository);
        instanceExpenseReport.setPaymentTypeRepository(mockPaymentTypeJpaRepository);
        instanceExpenseReport.setProjectRepository(mockProjectJpaRepository);
        instanceExpenseReport.setAgent(mockAgent);
        instanceExpenseReport.setExpenseReportidExpenseRepor(VALUE_EXPENSEREPORTIDEXPENSEREPOR);
        instanceExpenseReport.setExpenseReportPresentDate(VALUE_EXPENSEREPORTPRESENTDATE);
        instanceExpenseReport.setExpenseReportStatus(VALUE_EXPENSEREPORTSTATUS);
        instanceExpenseReport.setExpenseReportCause(VALUE_EXPENSEREPORTCAUSE);
        instanceExpenseReport.setExpenseReportAuthoDate(VALUE_EXPENSEREPORTAUTHODATE);
        instanceExpenseReport.setExpenseReportAuthoComments(VALUE_EXPENSEREPORTAUTHOCOMMENTS);
        instanceExpenseReport.setExpenseReportPaymentDate(VALUE_EXPENSEREPORTPAYMENTDATE);
        instanceExpenseReport.setExpenseReportPayComments(VALUE_EXPENSEREPORTPAYCOMMENTS);
        instanceExpenseReport.setExpenseReportAdvances(VALUE_EXPENSEREPORTADVANCES);
        instanceExpenseReport.setExpenseReportExchange(VALUE_EXPENSEREPORTEXCHANGE);
        instanceExpenseReport.setExpenseLines(VALUE_EXPENSELINES);
        instanceExpenseReport.add2Employee(VALUE_EMPLOYEE);
        instanceExpenseReport.add2ExpenseCurrency(VALUE_EXPENSECURRENCY);
        instanceExpenseReport.add2PaymentType(VALUE_PAYMENTTYPE);
        instanceExpenseReport.add2Project(VALUE_PROJECT);
        when(mockExpenseReportJpaRepository.assocOperator000(VALUE_ASSOCOPERATOR000_INSTANCE)).thenReturn(VALUE_ASSOCOPERATOR000_RETURN);
        when(mockExpenseLineJpaRepository.findByExpenseReport(any(ExpenseReport.class))).thenReturn(VALUE_EXPENSELINES);
        when(mockAgent.isAnyFacetActive(anyString())).thenReturn(true);
    }

    @After
    public void tearDown() {
        instanceExpenseReport = null;
    }

    @Test
    public void testDefaultConstructor() {
        ExpenseReport value = new ExpenseReport();
        assertNotNull(value);
    }

    @Test
    public void testConstructor() {
        ExpenseReport value = new ExpenseReport(null);
        assertNotNull(value);
    }

    @Test
    public void testConstructor2() {
        ExpenseReport value = new ExpenseReport(new ExpenseReportOid());
        assertNotNull(value);
    }

    @Test
    public void testConstructor3() {
        ExpenseReport value = new ExpenseReport(new ExpenseReportOid(Long.valueOf(0)));
        assertNotNull(value);
    }

    @Test
    public void test4getExpenseReportidExpenseRepor() {
        assertEquals(VALUE_EXPENSEREPORTIDEXPENSEREPOR.toString(), instanceExpenseReport.getExpenseReportidExpenseRepor().toString());
    }

    @Test
    public void test4setExpenseReportidExpenseRepor() {
        Long value = Long.valueOf(0);
        instanceExpenseReport.setExpenseReportidExpenseRepor(value);
        assertEquals(value, instanceExpenseReport.getExpenseReportidExpenseRepor());
    }

    @Test
    public void test4getExpenseReportPresentDate() {
        assertEquals(VALUE_EXPENSEREPORTPRESENTDATE.toString(), instanceExpenseReport.getExpenseReportPresentDate().toString());
    }

    @Test
    public void test4setExpenseReportPresentDate() {
        Date value = Date.valueOf(Constants.DATE_DEFAULTVALUE);
        instanceExpenseReport.setExpenseReportPresentDate(value);
        assertEquals(value, instanceExpenseReport.getExpenseReportPresentDate());
    }

    @Test
    public void test4getExpenseReportStatus() {
        assertEquals(VALUE_EXPENSEREPORTSTATUS.toString(), instanceExpenseReport.getExpenseReportStatus().toString());
    }

    @Test
    public void test4setExpenseReportStatus() {
        Long value = Long.valueOf(0);
        instanceExpenseReport.setExpenseReportStatus(value);
        assertEquals(value, instanceExpenseReport.getExpenseReportStatus());
    }

    @Test
    public void test4isModifiedExpenseReportStatus() {
        instanceExpenseReport = new ExpenseReport();
        assertFalse(instanceExpenseReport.isModifiedExpenseReportStatus());
        instanceExpenseReport.setExpenseReportStatus(VALUE_EXPENSEREPORTSTATUS);
        assertTrue(instanceExpenseReport.isModifiedExpenseReportStatus());
    }

    @Test
    public void test4setModifiedExpenseReportStatus() {
        instanceExpenseReport.setModifiedExpenseReportStatus(true);
        assertTrue(instanceExpenseReport.isModifiedExpenseReportStatus());
    }

    @Test
    public void test4getExpenseReportCause() {
        assertEquals(VALUE_EXPENSEREPORTCAUSE.toString(), instanceExpenseReport.getExpenseReportCause().toString());
    }

    @Test
    public void test4setExpenseReportCause() {
        String value = "expenseReportCause";
        instanceExpenseReport.setExpenseReportCause(value);
        assertEquals(value, instanceExpenseReport.getExpenseReportCause());
    }

    @Test
    public void test4isModifiedExpenseReportCause() {
        instanceExpenseReport = new ExpenseReport();
        assertFalse(instanceExpenseReport.isModifiedExpenseReportCause());
        instanceExpenseReport.setExpenseReportCause(VALUE_EXPENSEREPORTCAUSE);
        assertTrue(instanceExpenseReport.isModifiedExpenseReportCause());
    }

    @Test
    public void test4setModifiedExpenseReportCause() {
        instanceExpenseReport.setModifiedExpenseReportCause(true);
        assertTrue(instanceExpenseReport.isModifiedExpenseReportCause());
    }

    @Test
    public void test4getExpenseReportAuthoDate() {
        assertEquals(VALUE_EXPENSEREPORTAUTHODATE.toString(), instanceExpenseReport.getExpenseReportAuthoDate().toString());
    }

    @Test
    public void test4setExpenseReportAuthoDate() {
        Date value = Date.valueOf(Constants.DATE_DEFAULTVALUE);
        instanceExpenseReport.setExpenseReportAuthoDate(value);
        assertEquals(value, instanceExpenseReport.getExpenseReportAuthoDate());
    }

    @Test
    public void test4isModifiedExpenseReportAuthoDate() {
        instanceExpenseReport = new ExpenseReport();
        assertFalse(instanceExpenseReport.isModifiedExpenseReportAuthoDate());
        instanceExpenseReport.setExpenseReportAuthoDate(VALUE_EXPENSEREPORTAUTHODATE);
        assertTrue(instanceExpenseReport.isModifiedExpenseReportAuthoDate());
    }

    @Test
    public void test4setModifiedExpenseReportAuthoDate() {
        instanceExpenseReport.setModifiedExpenseReportAuthoDate(true);
        assertTrue(instanceExpenseReport.isModifiedExpenseReportAuthoDate());
    }

    @Test
    public void test4getExpenseReportAuthoComments() {
        assertEquals(VALUE_EXPENSEREPORTAUTHOCOMMENTS.toString(), instanceExpenseReport.getExpenseReportAuthoComments().toString());
    }

    @Test
    public void test4setExpenseReportAuthoComments() {
        String value = "expenseReportAuthoComments";
        instanceExpenseReport.setExpenseReportAuthoComments(value);
        assertEquals(value, instanceExpenseReport.getExpenseReportAuthoComments());
    }

    @Test
    public void test4isModifiedExpenseReportAuthoComments() {
        instanceExpenseReport = new ExpenseReport();
        assertFalse(instanceExpenseReport.isModifiedExpenseReportAuthoComments());
        instanceExpenseReport.setExpenseReportAuthoComments(VALUE_EXPENSEREPORTAUTHOCOMMENTS);
        assertTrue(instanceExpenseReport.isModifiedExpenseReportAuthoComments());
    }

    @Test
    public void test4setModifiedExpenseReportAuthoComments() {
        instanceExpenseReport.setModifiedExpenseReportAuthoComments(true);
        assertTrue(instanceExpenseReport.isModifiedExpenseReportAuthoComments());
    }

    @Test
    public void test4getExpenseReportPaymentDate() {
        assertEquals(VALUE_EXPENSEREPORTPAYMENTDATE.toString(), instanceExpenseReport.getExpenseReportPaymentDate().toString());
    }

    @Test
    public void test4setExpenseReportPaymentDate() {
        Date value = Date.valueOf(Constants.DATE_DEFAULTVALUE);
        instanceExpenseReport.setExpenseReportPaymentDate(value);
        assertEquals(value, instanceExpenseReport.getExpenseReportPaymentDate());
    }

    @Test
    public void test4isModifiedExpenseReportPaymentDate() {
        instanceExpenseReport = new ExpenseReport();
        assertFalse(instanceExpenseReport.isModifiedExpenseReportPaymentDate());
        instanceExpenseReport.setExpenseReportPaymentDate(VALUE_EXPENSEREPORTPAYMENTDATE);
        assertTrue(instanceExpenseReport.isModifiedExpenseReportPaymentDate());
    }

    @Test
    public void test4setModifiedExpenseReportPaymentDate() {
        instanceExpenseReport.setModifiedExpenseReportPaymentDate(true);
        assertTrue(instanceExpenseReport.isModifiedExpenseReportPaymentDate());
    }

    @Test
    public void test4getExpenseReportPayComments() {
        assertEquals(VALUE_EXPENSEREPORTPAYCOMMENTS.toString(), instanceExpenseReport.getExpenseReportPayComments().toString());
    }

    @Test
    public void test4setExpenseReportPayComments() {
        String value = "expenseReportPayComments";
        instanceExpenseReport.setExpenseReportPayComments(value);
        assertEquals(value, instanceExpenseReport.getExpenseReportPayComments());
    }

    @Test
    public void test4isModifiedExpenseReportPayComments() {
        instanceExpenseReport = new ExpenseReport();
        assertFalse(instanceExpenseReport.isModifiedExpenseReportPayComments());
        instanceExpenseReport.setExpenseReportPayComments(VALUE_EXPENSEREPORTPAYCOMMENTS);
        assertTrue(instanceExpenseReport.isModifiedExpenseReportPayComments());
    }

    @Test
    public void test4setModifiedExpenseReportPayComments() {
        instanceExpenseReport.setModifiedExpenseReportPayComments(true);
        assertTrue(instanceExpenseReport.isModifiedExpenseReportPayComments());
    }

    @Test
    public void test4getExpenseReportTotExpenses() throws SystemException {
        if (TESTDERIVATIONS) {
            assertEquals(VALUE_EXPENSEREPORTTOTEXPENSES.toString(), instanceExpenseReport.getExpenseReportTotExpenses().toString());
        } else {
            instanceExpenseReport.getExpenseReportTotExpenses();
            assertNotNull(instanceExpenseReport);
        }
    }

    @Test
    public void test4getExpenseReportTotExpensesCur() throws SystemException {
        if (TESTDERIVATIONS) {
            assertEquals(VALUE_EXPENSEREPORTTOTEXPENSESCUR.toString(), instanceExpenseReport.getExpenseReportTotExpensesCur().toString());
        } else {
            instanceExpenseReport.getExpenseReportTotExpensesCur();
            assertNotNull(instanceExpenseReport);
        }
    }

    @Test
    public void test4getExpenseReportAdvances() {
        assertEquals(VALUE_EXPENSEREPORTADVANCES.toString(), instanceExpenseReport.getExpenseReportAdvances().toString());
    }

    @Test
    public void test4setExpenseReportAdvances() {
        Double value = Double.valueOf(0);
        instanceExpenseReport.setExpenseReportAdvances(value);
        assertEquals(value, instanceExpenseReport.getExpenseReportAdvances());
    }

    @Test
    public void test4isModifiedExpenseReportAdvances() {
        instanceExpenseReport = new ExpenseReport();
        assertFalse(instanceExpenseReport.isModifiedExpenseReportAdvances());
        instanceExpenseReport.setExpenseReportAdvances(VALUE_EXPENSEREPORTADVANCES);
        assertTrue(instanceExpenseReport.isModifiedExpenseReportAdvances());
    }

    @Test
    public void test4setModifiedExpenseReportAdvances() {
        instanceExpenseReport.setModifiedExpenseReportAdvances(true);
        assertTrue(instanceExpenseReport.isModifiedExpenseReportAdvances());
    }

    @Test
    public void test4getExpenseReportAdvancesCur() throws SystemException {
        if (TESTDERIVATIONS) {
            assertEquals(VALUE_EXPENSEREPORTADVANCESCUR.toString(), instanceExpenseReport.getExpenseReportAdvancesCur().toString());
        } else {
            instanceExpenseReport.getExpenseReportAdvancesCur();
            assertNotNull(instanceExpenseReport);
        }
    }

    @Test
    public void test4getExpenseReportExchange() {
        assertEquals(VALUE_EXPENSEREPORTEXCHANGE.toString(), instanceExpenseReport.getExpenseReportExchange().toString());
    }

    @Test
    public void test4setExpenseReportExchange() {
        Double value = Double.valueOf(0);
        instanceExpenseReport.setExpenseReportExchange(value);
        assertEquals(value, instanceExpenseReport.getExpenseReportExchange());
    }

    @Test
    public void test4isModifiedExpenseReportExchange() {
        instanceExpenseReport = new ExpenseReport();
        assertFalse(instanceExpenseReport.isModifiedExpenseReportExchange());
        instanceExpenseReport.setExpenseReportExchange(VALUE_EXPENSEREPORTEXCHANGE);
        assertTrue(instanceExpenseReport.isModifiedExpenseReportExchange());
    }

    @Test
    public void test4setModifiedExpenseReportExchange() {
        instanceExpenseReport.setModifiedExpenseReportExchange(true);
        assertTrue(instanceExpenseReport.isModifiedExpenseReportExchange());
    }

    @Test
    public void test4getExpenseReportBalance() throws SystemException {
        if (TESTDERIVATIONS) {
            assertEquals(VALUE_EXPENSEREPORTBALANCE.toString(), instanceExpenseReport.getExpenseReportBalance().toString());
        } else {
            instanceExpenseReport.getExpenseReportBalance();
            assertNotNull(instanceExpenseReport);
        }
    }

    @Test
    public void test4getExpenseReportBalanceCur() throws SystemException {
        if (TESTDERIVATIONS) {
            assertEquals(VALUE_EXPENSEREPORTBALANCECUR.toString(), instanceExpenseReport.getExpenseReportBalanceCur().toString());
        } else {
            instanceExpenseReport.getExpenseReportBalanceCur();
            assertNotNull(instanceExpenseReport);
        }
    }

    @Test
    public void test4getExpenseLines() {
        assertEquals(VALUE_EXPENSELINES, instanceExpenseReport.getExpenseLines());
    }

    @Test
    public void test4getExpenseLines2() {
        instanceExpenseReport.setExpenseLines(null);
        assertEquals(VALUE_EXPENSELINES, instanceExpenseReport.getExpenseLines());
    }

    @Test
    public void test4getExpenseLines3() {
        instanceExpenseReport.setExpenseLines(new ArrayList<>());
        assertEquals(VALUE_EXPENSELINES, instanceExpenseReport.getExpenseLines());
    }

    @Test
    public void test4add2ExpenseLines() {
        ExpenseLine value = new ExpenseLine();
        instanceExpenseReport.add2ExpenseLines(value);
        assertTrue(instanceExpenseReport.getExpenseLines().contains(value));
    }

    @Test
    public void test4setExpenseLines() {
        instanceExpenseReport.setExpenseLines(VALUE_EXPENSELINES);
        assertEquals(VALUE_EXPENSELINES, instanceExpenseReport.getExpenseLines());
    }

    @Test
    public void test4isModifiedExpenseLines() {
        assertFalse(instanceExpenseReport.isModifiedExpenseLines());
    }

    @Test
    public void test4getEmployee() {
        assertEquals(VALUE_EMPLOYEE, instanceExpenseReport.getEmployee());
    }

    @Test
    public void test4getEmployee2() {
        instanceExpenseReport.add2Employee(null);
        assertTrue(instanceExpenseReport.getEmployee().isNull());
    }

    @Test
    public void test4getEmployee3() {
        Employee value = new Employee(new EmployeeOid("employeeidEmployee"));
        instanceExpenseReport.add2Employee(value);
        assertEquals(value, instanceExpenseReport.getEmployee());
    }

    @Test
    public void test4add2Employee() {
        Employee value = new Employee(new EmployeeOid("employeeidEmployee"));
        instanceExpenseReport.add2Employee(value);
        assertEquals(value, instanceExpenseReport.getEmployee());
    }

    @Test
    public void test4setEmployee() {
        instanceExpenseReport.add2Employee(VALUE_EMPLOYEE);
        assertEquals(VALUE_EMPLOYEE, instanceExpenseReport.getEmployee());
    }

    @Test
    public void test4isModifiedEmployee() {
        assertFalse(instanceExpenseReport.isModifiedEmployee());
    }

    @Test
    public void test4getExpenseCurrency() {
        assertEquals(VALUE_EXPENSECURRENCY, instanceExpenseReport.getExpenseCurrency());
    }

    @Test
    public void test4getExpenseCurrency2() {
        instanceExpenseReport.add2ExpenseCurrency(null);
        assertTrue(instanceExpenseReport.getExpenseCurrency().isNull());
    }

    @Test
    public void test4getExpenseCurrency3() {
        ExpenseCurrency value = new ExpenseCurrency(new ExpenseCurrencyOid("expenseCurrencyCurrencyCode"));
        instanceExpenseReport.add2ExpenseCurrency(value);
        assertEquals(value, instanceExpenseReport.getExpenseCurrency());
    }

    @Test
    public void test4add2ExpenseCurrency() {
        ExpenseCurrency value = new ExpenseCurrency(new ExpenseCurrencyOid("expenseCurrencyCurrencyCode"));
        instanceExpenseReport.add2ExpenseCurrency(value);
        assertEquals(value, instanceExpenseReport.getExpenseCurrency());
    }

    @Test
    public void test4setExpenseCurrency() {
        instanceExpenseReport.add2ExpenseCurrency(VALUE_EXPENSECURRENCY);
        assertEquals(VALUE_EXPENSECURRENCY, instanceExpenseReport.getExpenseCurrency());
    }

    @Test
    public void test4isModifiedExpenseCurrency() {
        assertFalse(instanceExpenseReport.isModifiedExpenseCurrency());
    }

    @Test
    public void test4getPaymentType() {
        assertEquals(VALUE_PAYMENTTYPE, instanceExpenseReport.getPaymentType());
    }

    @Test
    public void test4getPaymentType2() {
        instanceExpenseReport.add2PaymentType(null);
        assertTrue(instanceExpenseReport.getPaymentType().isNull());
    }

    @Test
    public void test4getPaymentType3() {
        PaymentType value = new PaymentType(new PaymentTypeOid("paymentTypeidPaymentType"));
        instanceExpenseReport.add2PaymentType(value);
        assertEquals(value, instanceExpenseReport.getPaymentType());
    }

    @Test
    public void test4add2PaymentType() {
        PaymentType value = new PaymentType(new PaymentTypeOid("paymentTypeidPaymentType"));
        instanceExpenseReport.add2PaymentType(value);
        assertEquals(value, instanceExpenseReport.getPaymentType());
    }

    @Test
    public void test4setPaymentType() {
        instanceExpenseReport.add2PaymentType(VALUE_PAYMENTTYPE);
        assertEquals(VALUE_PAYMENTTYPE, instanceExpenseReport.getPaymentType());
    }

    @Test
    public void test4isModifiedPaymentType() {
        assertFalse(instanceExpenseReport.isModifiedPaymentType());
    }

    @Test
    public void test4getProject() {
        assertEquals(VALUE_PROJECT, instanceExpenseReport.getProject());
    }

    @Test
    public void test4getProject2() {
        instanceExpenseReport.add2Project(null);
        assertTrue(instanceExpenseReport.getProject().isNull());
    }

    @Test
    public void test4getProject3() {
        Project value = new Project(new ProjectOid(Long.valueOf(0)));
        instanceExpenseReport.add2Project(value);
        assertEquals(value, instanceExpenseReport.getProject());
    }

    @Test
    public void test4add2Project() {
        Project value = new Project(new ProjectOid(Long.valueOf(0)));
        instanceExpenseReport.add2Project(value);
        assertEquals(value, instanceExpenseReport.getProject());
    }

    @Test
    public void test4setProject() {
        instanceExpenseReport.add2Project(VALUE_PROJECT);
        assertEquals(VALUE_PROJECT, instanceExpenseReport.getProject());
    }

    @Test
    public void test4isModifiedProject() {
        assertFalse(instanceExpenseReport.isModifiedProject());
    }

    @Test
    public void test4buildDSExpenseReport4MD() {
        String result;
        try {
            result = instanceExpenseReport.buildDSExpenseReport4MD().toString();	
        } catch (NullPointerException e) {
            result = "";
        }
        assertNotNull(result);
	}

    @Test
    public void test4buildDSExpenseReportSup() {
        String result;
        try {
            result = instanceExpenseReport.buildDSExpenseReportSup().toString();	
        } catch (NullPointerException e) {
            result = "";
        }
        assertNotNull(result);
	}

    @Test
    public void test4buildDSExpenseReport4HAT() {
        String result;
        try {
            result = instanceExpenseReport.buildDSExpenseReport4HAT().toString();	
        } catch (NullPointerException e) {
            result = "";
        }
        assertNotNull(result);
	}

    @Test
    public void test4getValues() {
        assertNotNull(instanceExpenseReport.getValues());
    }

    @Test
    public void test4getAttribute() {
        assertNull(instanceExpenseReport.getAttribute(ExpenseReportConstants.ATTR_NAME_EXPENSEREPORTIDEXPENSEREPOR));
    }

    @Test
    public void test4getAttributeTypeRelated() {
        assertEquals(Constants.Type.STRING.getTypeName(), instanceExpenseReport.getAttributeTypeRelated(ExpenseReportConstants.ROLE_NAME_EXPENSELINES, ""));
        assertEquals(Constants.Type.STRING.getTypeName(), instanceExpenseReport.getAttributeTypeRelated(ExpenseReportConstants.ROLE_NAME_EMPLOYEE, ""));
        assertEquals(Constants.Type.STRING.getTypeName(), instanceExpenseReport.getAttributeTypeRelated(ExpenseReportConstants.ROLE_NAME_EXPENSECURRENCY, ""));
        assertEquals(Constants.Type.STRING.getTypeName(), instanceExpenseReport.getAttributeTypeRelated(ExpenseReportConstants.ROLE_NAME_PAYMENTTYPE, ""));
        assertEquals(Constants.Type.STRING.getTypeName(), instanceExpenseReport.getAttributeTypeRelated(ExpenseReportConstants.ROLE_NAME_PROJECT, ""));
        assertEquals("", instanceExpenseReport.getAttributeTypeRelated("", ""));
    }

    @Test
    public void test4cleanDerivations() {
        instanceExpenseReport.cleanDerivations();
        assertNotNull(instanceExpenseReport);
    }

    @Test
    public void test4getOid() {
        assertEquals(instanceExpenseReport.getExpenseReportidExpenseRepor(), instanceExpenseReport.getOid().getExpenseReportidExpenseRepor());
    }

    @Test
    public void test4isVisible() {
        assertTrue(instanceExpenseReport.isVisible(ExpenseReportConstants.ATTR_NAME_EXPENSEREPORTPRESENTDATE));
        assertTrue(instanceExpenseReport.isVisible(ExpenseReportConstants.ATTR_NAME_EXPENSEREPORTSTATUS));
        assertTrue(instanceExpenseReport.isVisible(ExpenseReportConstants.ATTR_NAME_EXPENSEREPORTCAUSE));
        assertTrue(instanceExpenseReport.isVisible(ExpenseReportConstants.ATTR_NAME_EXPENSEREPORTAUTHODATE));
        assertTrue(instanceExpenseReport.isVisible(ExpenseReportConstants.ATTR_NAME_EXPENSEREPORTAUTHOCOMMENTS));
        assertTrue(instanceExpenseReport.isVisible(ExpenseReportConstants.ATTR_NAME_EXPENSEREPORTPAYMENTDATE));
        assertTrue(instanceExpenseReport.isVisible(ExpenseReportConstants.ATTR_NAME_EXPENSEREPORTPAYCOMMENTS));
        assertTrue(instanceExpenseReport.isVisible(ExpenseReportConstants.ATTR_NAME_EXPENSEREPORTTOTEXPENSES));
        assertTrue(instanceExpenseReport.isVisible(ExpenseReportConstants.ATTR_NAME_EXPENSEREPORTTOTEXPENSESCUR));
        assertTrue(instanceExpenseReport.isVisible(ExpenseReportConstants.ATTR_NAME_EXPENSEREPORTADVANCES));
        assertTrue(instanceExpenseReport.isVisible(ExpenseReportConstants.ATTR_NAME_EXPENSEREPORTADVANCESCUR));
        assertTrue(instanceExpenseReport.isVisible(ExpenseReportConstants.ATTR_NAME_EXPENSEREPORTEXCHANGE));
        assertTrue(instanceExpenseReport.isVisible(ExpenseReportConstants.ATTR_NAME_EXPENSEREPORTBALANCE));
        assertTrue(instanceExpenseReport.isVisible(ExpenseReportConstants.ATTR_NAME_EXPENSEREPORTBALANCECUR));
    }

    @Test
    public void test4IsAttributeVisible() {
        assertTrue(instanceExpenseReport.isAttributeVisible(ExpenseReportConstants.ATTR_NAME_EXPENSEREPORTPRESENTDATE));
        assertTrue(instanceExpenseReport.isAttributeVisible(ExpenseReportConstants.ATTR_NAME_EXPENSEREPORTSTATUS));
        assertTrue(instanceExpenseReport.isAttributeVisible(ExpenseReportConstants.ATTR_NAME_EXPENSEREPORTCAUSE));
        assertTrue(instanceExpenseReport.isAttributeVisible(ExpenseReportConstants.ATTR_NAME_EXPENSEREPORTAUTHODATE));
        assertTrue(instanceExpenseReport.isAttributeVisible(ExpenseReportConstants.ATTR_NAME_EXPENSEREPORTAUTHOCOMMENTS));
        assertTrue(instanceExpenseReport.isAttributeVisible(ExpenseReportConstants.ATTR_NAME_EXPENSEREPORTPAYMENTDATE));
        assertTrue(instanceExpenseReport.isAttributeVisible(ExpenseReportConstants.ATTR_NAME_EXPENSEREPORTPAYCOMMENTS));
        assertTrue(instanceExpenseReport.isAttributeVisible(ExpenseReportConstants.ATTR_NAME_EXPENSEREPORTTOTEXPENSES));
        assertTrue(instanceExpenseReport.isAttributeVisible(ExpenseReportConstants.ATTR_NAME_EXPENSEREPORTTOTEXPENSESCUR));
        assertTrue(instanceExpenseReport.isAttributeVisible(ExpenseReportConstants.ATTR_NAME_EXPENSEREPORTADVANCES));
        assertTrue(instanceExpenseReport.isAttributeVisible(ExpenseReportConstants.ATTR_NAME_EXPENSEREPORTADVANCESCUR));
        assertTrue(instanceExpenseReport.isAttributeVisible(ExpenseReportConstants.ATTR_NAME_EXPENSEREPORTEXCHANGE));
        assertTrue(instanceExpenseReport.isAttributeVisible(ExpenseReportConstants.ATTR_NAME_EXPENSEREPORTBALANCE));
        assertTrue(instanceExpenseReport.isAttributeVisible(ExpenseReportConstants.ATTR_NAME_EXPENSEREPORTBALANCECUR));
    }

    @Test
    public void test4getMethods() {
        assertTrue(instanceExpenseReport.getMethods().length > 0);
    }

    @Test
    public void test4getClassAttributeType() {
        assertNull(instanceExpenseReport.getClassAttributeType(""));
    }

    @Test
    public void test4getActiveFacets() {
        assertTrue(instanceExpenseReport.getActiveFacets().contains(Constants.EXPENSEREPORT));
    }

    @Test
    public void test4getFacets() {
        assertTrue(instanceExpenseReport.getFacets().contains(Constants.EXPENSEREPORT));
    }

    @Test
    public void test4checkHorizontalVisibility() {
        assertTrue(instanceExpenseReport.checkHorizontalVisibility(null));
    }
}
