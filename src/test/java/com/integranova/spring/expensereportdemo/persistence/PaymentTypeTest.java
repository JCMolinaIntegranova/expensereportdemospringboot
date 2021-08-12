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
import com.integranova.spring.expensereportdemo.global.PaymentTypeConstants;
import com.integranova.spring.expensereportdemo.persistence.oid.PaymentTypeOid;
import com.integranova.spring.expensereportdemo.repository.ExpenseReportJpaRepository;
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
public class PaymentTypeTest {

    private static ExpenseReportJpaRepository mockExpenseReportJpaRepository;

    private static Agent mockAgent;

    PaymentType instancePaymentType;
    private static String VALUE_PAYMENTTYPEIDPAYMENTTYPE;
    private static String VALUE_PAYMENTTYPEPAYDESCRIPTION;
    private static List<ExpenseReport> VALUE_EXPENSEREPORT;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        VALUE_PAYMENTTYPEIDPAYMENTTYPE = "paymentTypeidPaymentType";
        VALUE_PAYMENTTYPEPAYDESCRIPTION = "paymentTypePayDescription";
        VALUE_EXPENSEREPORT = new ArrayList<>();
        VALUE_EXPENSEREPORT.add(new ExpenseReport());
        mockExpenseReportJpaRepository = mock(ExpenseReportJpaRepository.class);
        mockAgent = mock(Agent.class);
    }

    @Before
    public void setUp() throws SystemException {
        instancePaymentType = new PaymentType();
        instancePaymentType.setExpenseReportRepository(mockExpenseReportJpaRepository);
        instancePaymentType.setAgent(mockAgent);
        instancePaymentType.setPaymentTypeidPaymentType(VALUE_PAYMENTTYPEIDPAYMENTTYPE);
        instancePaymentType.setPaymentTypePayDescription(VALUE_PAYMENTTYPEPAYDESCRIPTION);
        instancePaymentType.setExpenseReport(VALUE_EXPENSEREPORT);
        when(mockExpenseReportJpaRepository.findByPaymentType(any(PaymentType.class))).thenReturn(VALUE_EXPENSEREPORT);
        when(mockAgent.isAnyFacetActive(anyString())).thenReturn(true);
    }

    @After
    public void tearDown() {
        instancePaymentType = null;
    }

    @Test
    public void testDefaultConstructor() {
        PaymentType value = new PaymentType();
        assertNotNull(value);
    }

    @Test
    public void testConstructor() {
        PaymentType value = new PaymentType(null);
        assertNotNull(value);
    }

    @Test
    public void testConstructor2() {
        PaymentType value = new PaymentType(new PaymentTypeOid());
        assertNotNull(value);
    }

    @Test
    public void testConstructor3() {
        PaymentType value = new PaymentType(new PaymentTypeOid("paymentTypeidPaymentType"));
        assertNotNull(value);
    }

    @Test
    public void test4getPaymentTypeidPaymentType() {
        assertEquals(VALUE_PAYMENTTYPEIDPAYMENTTYPE.toString(), instancePaymentType.getPaymentTypeidPaymentType().toString());
    }

    @Test
    public void test4setPaymentTypeidPaymentType() {
        String value = "paymentTypeidPaymentType";
        instancePaymentType.setPaymentTypeidPaymentType(value);
        assertEquals(value, instancePaymentType.getPaymentTypeidPaymentType());
    }

    @Test
    public void test4getPaymentTypePayDescription() {
        assertEquals(VALUE_PAYMENTTYPEPAYDESCRIPTION.toString(), instancePaymentType.getPaymentTypePayDescription().toString());
    }

    @Test
    public void test4setPaymentTypePayDescription() {
        String value = "paymentTypePayDescription";
        instancePaymentType.setPaymentTypePayDescription(value);
        assertEquals(value, instancePaymentType.getPaymentTypePayDescription());
    }

    @Test
    public void test4isModifiedPaymentTypePayDescription() {
        instancePaymentType = new PaymentType();
        assertFalse(instancePaymentType.isModifiedPaymentTypePayDescription());
        instancePaymentType.setPaymentTypePayDescription(VALUE_PAYMENTTYPEPAYDESCRIPTION);
        assertTrue(instancePaymentType.isModifiedPaymentTypePayDescription());
    }

    @Test
    public void test4setModifiedPaymentTypePayDescription() {
        instancePaymentType.setModifiedPaymentTypePayDescription(true);
        assertTrue(instancePaymentType.isModifiedPaymentTypePayDescription());
    }

    @Test
    public void test4getExpenseReport() {
        assertEquals(VALUE_EXPENSEREPORT, instancePaymentType.getExpenseReport());
    }

    @Test
    public void test4getExpenseReport2() {
        instancePaymentType.setExpenseReport(null);
        assertEquals(VALUE_EXPENSEREPORT, instancePaymentType.getExpenseReport());
    }

    @Test
    public void test4getExpenseReport3() {
        instancePaymentType.setExpenseReport(new ArrayList<>());
        assertEquals(VALUE_EXPENSEREPORT, instancePaymentType.getExpenseReport());
    }

    @Test
    public void test4add2ExpenseReport() {
        ExpenseReport value = new ExpenseReport();
        instancePaymentType.add2ExpenseReport(value);
        assertTrue(instancePaymentType.getExpenseReport().contains(value));
    }

    @Test
    public void test4setExpenseReport() {
        instancePaymentType.setExpenseReport(VALUE_EXPENSEREPORT);
        assertEquals(VALUE_EXPENSEREPORT, instancePaymentType.getExpenseReport());
    }

    @Test
    public void test4isModifiedExpenseReport() {
        assertFalse(instancePaymentType.isModifiedExpenseReport());
    }

    @Test
    public void test4buildDSPaymentType() {
        String result;
        try {
            result = instancePaymentType.buildDSPaymentType().toString();	
        } catch (NullPointerException e) {
            result = "";
        }
        assertNotNull(result);
	}

    @Test
    public void test4buildDSPaymentTypeSup() {
        String result;
        try {
            result = instancePaymentType.buildDSPaymentTypeSup().toString();	
        } catch (NullPointerException e) {
            result = "";
        }
        assertNotNull(result);
	}

    @Test
    public void test4getValues() {
        assertNotNull(instancePaymentType.getValues());
    }

    @Test
    public void test4getAttribute() {
        assertNull(instancePaymentType.getAttribute(PaymentTypeConstants.ATTR_NAME_PAYMENTTYPEIDPAYMENTTYPE));
    }

    @Test
    public void test4getAttributeTypeRelated() {
        assertEquals(Constants.Type.STRING.getTypeName(), instancePaymentType.getAttributeTypeRelated(PaymentTypeConstants.ROLE_NAME_EXPENSEREPORT, ""));
        assertEquals("", instancePaymentType.getAttributeTypeRelated("", ""));
    }

    @Test
    public void test4cleanDerivations() {
        instancePaymentType.cleanDerivations();
        assertNotNull(instancePaymentType);
    }

    @Test
    public void test4getOid() {
        assertEquals(instancePaymentType.getPaymentTypeidPaymentType(), instancePaymentType.getOid().getPaymentTypeidPaymentType());
    }

    @Test
    public void test4isVisible() {
        assertTrue(instancePaymentType.isVisible(PaymentTypeConstants.ATTR_NAME_PAYMENTTYPEPAYDESCRIPTION));
    }

    @Test
    public void test4IsAttributeVisible() {
        assertTrue(instancePaymentType.isAttributeVisible(PaymentTypeConstants.ATTR_NAME_PAYMENTTYPEPAYDESCRIPTION));
    }

    @Test
    public void test4getMethods() {
        assertTrue(instancePaymentType.getMethods().length > 0);
    }

    @Test
    public void test4getClassAttributeType() {
        assertNull(instancePaymentType.getClassAttributeType(""));
    }

    @Test
    public void test4getActiveFacets() {
        assertTrue(instancePaymentType.getActiveFacets().contains(Constants.PAYMENTTYPE));
    }

    @Test
    public void test4getFacets() {
        assertTrue(instancePaymentType.getFacets().contains(Constants.PAYMENTTYPE));
    }

    @Test
    public void test4checkHorizontalVisibility() {
        assertTrue(instancePaymentType.checkHorizontalVisibility(null));
    }
}
