package com.integranova.spring.expensereportdemo.viewmodel.globalservices.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GLOBALTESTRequestTest {

    private GLOBALTESTRequest instanceGLOBALTESTRequest;

    // Default values
    private static Double defValue4gLOBALTESTpTotExpenses = Double.valueOf(0);
    private static String defValue4gLOBALTESTpProjectName = "";
    private static String preconditionIdDefaultValue = "preconditionId";


    // test4getGLOBALTESTpTotExpenses

    // test4setGLOBALTESTpTotExpenses
    private static Double test4setGLOBALTESTpTotExpensesArg1;

    // test4getGLOBALTESTpProjectName

    // test4setGLOBALTESTpProjectName
    private static String test4setGLOBALTESTpProjectNameArg1;

    // testGetPreconditionId

    // testSetPreconditionId
    private static String testSetPreconditionIdArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getGLOBALTESTpTotExpenses();
        setUpMockData4test4setGLOBALTESTpTotExpenses();
        setUpMockData4test4getGLOBALTESTpProjectName();
        setUpMockData4test4setGLOBALTESTpProjectName();
        setUpMockData4testGetPreconditionId();
        setUpMockData4testSetPreconditionId();
    }

    private static void setUpMockData4test4getGLOBALTESTpTotExpenses() {
    }

    private static void setUpMockData4test4setGLOBALTESTpTotExpenses() {
        test4setGLOBALTESTpTotExpensesArg1 = Double.valueOf(0);
    }

    private static void setUpMockData4test4getGLOBALTESTpProjectName() {
    }

    private static void setUpMockData4test4setGLOBALTESTpProjectName() {
        test4setGLOBALTESTpProjectNameArg1 = "";
    }

    private static void setUpMockData4testGetPreconditionId() {
    }

    private static void setUpMockData4testSetPreconditionId() {
        testSetPreconditionIdArg1 = preconditionIdDefaultValue;
    }

    @Before
    public void setUp() {
        instanceGLOBALTESTRequest = new GLOBALTESTRequest();
        instanceGLOBALTESTRequest.setGLOBALTESTpTotExpenses(defValue4gLOBALTESTpTotExpenses);
        instanceGLOBALTESTRequest.setGLOBALTESTpProjectName(defValue4gLOBALTESTpProjectName);
        instanceGLOBALTESTRequest.setPreconditionId("preconditionId");
    }

    @Test
    public void test4getGLOBALTESTpTotExpenses() {
        assertEquals(defValue4gLOBALTESTpTotExpenses, instanceGLOBALTESTRequest.getGLOBALTESTpTotExpenses());
    }

    @Test
    public void test4setGLOBALTESTpTotExpenses() {
        instanceGLOBALTESTRequest.setGLOBALTESTpTotExpenses(test4setGLOBALTESTpTotExpensesArg1);
        assertNotNull(instanceGLOBALTESTRequest);
    }

    @Test
    public void test4getGLOBALTESTpProjectName() {
        assertEquals(defValue4gLOBALTESTpProjectName, instanceGLOBALTESTRequest.getGLOBALTESTpProjectName());
    }

    @Test
    public void test4setGLOBALTESTpProjectName() {
        instanceGLOBALTESTRequest.setGLOBALTESTpProjectName(test4setGLOBALTESTpProjectNameArg1);
        assertNotNull(instanceGLOBALTESTRequest);
    }

    @Test
    public void testGetPreconditionId() {
        assertEquals(preconditionIdDefaultValue, instanceGLOBALTESTRequest.getPreconditionId());
    }

    @Test
    public void testSetPreconditionId() {
        instanceGLOBALTESTRequest.setPreconditionId(testSetPreconditionIdArg1);
        assertNotNull(instanceGLOBALTESTRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceGLOBALTESTRequest = new GLOBALTESTRequest();
    	instanceGLOBALTESTRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceGLOBALTESTRequest.checkArguments();
    }
}
