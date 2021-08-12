package com.integranova.spring.expensereportdemo.viewmodel.expenseline.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.persistence.ExpenseLine;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseLineOid;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DeletelineRequestTest {

    private DeletelineRequest instanceDeletelineRequest;

    // Default values
    private static ExpenseLineOid defValue4expenseLinedeletelinepthisExpenseLine = new ExpenseLineOid();
    private static ExpenseLine defValue4expenseLinedeletelinepthisExpenseLineInstance = new ExpenseLine(new ExpenseLineOid(Long.valueOf(0), Long.valueOf(0)));
    private static String preconditionIdDefaultValue = "preconditionId";


    // test4getExpenseLinedeletelinepthisExpenseLine

    // test4setExpenseLinedeletelinepthisExpenseLine
    private static ExpenseLineOid test4setExpenseLinedeletelinepthisExpenseLineArg1;

    // testGetPreconditionId

    // testSetPreconditionId
    private static String testSetPreconditionIdArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getExpenseLinedeletelinepthisExpenseLine();
        setUpMockData4test4setExpenseLinedeletelinepthisExpenseLine();
        setUpMockData4testGetPreconditionId();
        setUpMockData4testSetPreconditionId();
    }

    private static void setUpMockData4test4getExpenseLinedeletelinepthisExpenseLine() {
    }

    private static void setUpMockData4test4setExpenseLinedeletelinepthisExpenseLine() {
        test4setExpenseLinedeletelinepthisExpenseLineArg1 = new ExpenseLineOid();
    }

    private static void setUpMockData4testGetPreconditionId() {
    }

    private static void setUpMockData4testSetPreconditionId() {
        testSetPreconditionIdArg1 = preconditionIdDefaultValue;
    }

    @Before
    public void setUp() {
        instanceDeletelineRequest = new DeletelineRequest();
        instanceDeletelineRequest.setExpenseLinedeletelinepthisExpenseLine(defValue4expenseLinedeletelinepthisExpenseLine);
        instanceDeletelineRequest.setExpenseLinedeletelinepthisExpenseLineInstance(defValue4expenseLinedeletelinepthisExpenseLineInstance);
        instanceDeletelineRequest.setPreconditionId("preconditionId");
    }

    @Test
    public void test4getExpenseLinedeletelinepthisExpenseLine() {
        assertEquals(defValue4expenseLinedeletelinepthisExpenseLine, instanceDeletelineRequest.getExpenseLinedeletelinepthisExpenseLine());
    }

    @Test
    public void test4setExpenseLinedeletelinepthisExpenseLine() {
        instanceDeletelineRequest.setExpenseLinedeletelinepthisExpenseLine(test4setExpenseLinedeletelinepthisExpenseLineArg1);
        assertNotNull(instanceDeletelineRequest);
    }

    @Test
    public void testGetPreconditionId() {
        assertEquals(preconditionIdDefaultValue, instanceDeletelineRequest.getPreconditionId());
    }

    @Test
    public void testSetPreconditionId() {
        instanceDeletelineRequest.setPreconditionId(testSetPreconditionIdArg1);
        assertNotNull(instanceDeletelineRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceDeletelineRequest = new DeletelineRequest();
    	instanceDeletelineRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceDeletelineRequest.checkArguments();
    }
}
