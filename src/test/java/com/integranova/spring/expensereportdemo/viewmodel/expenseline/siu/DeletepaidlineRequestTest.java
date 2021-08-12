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
public class DeletepaidlineRequestTest {

    private DeletepaidlineRequest instanceDeletepaidlineRequest;

    // Default values
    private static ExpenseLineOid defValue4expenseLinedeletepaidlinepthisExpenseLine = new ExpenseLineOid();
    private static ExpenseLine defValue4expenseLinedeletepaidlinepthisExpenseLineInstance = new ExpenseLine(new ExpenseLineOid(Long.valueOf(0), Long.valueOf(0)));


    // test4getExpenseLinedeletepaidlinepthisExpenseLine

    // test4setExpenseLinedeletepaidlinepthisExpenseLine
    private static ExpenseLineOid test4setExpenseLinedeletepaidlinepthisExpenseLineArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getExpenseLinedeletepaidlinepthisExpenseLine();
        setUpMockData4test4setExpenseLinedeletepaidlinepthisExpenseLine();
    }

    private static void setUpMockData4test4getExpenseLinedeletepaidlinepthisExpenseLine() {
    }

    private static void setUpMockData4test4setExpenseLinedeletepaidlinepthisExpenseLine() {
        test4setExpenseLinedeletepaidlinepthisExpenseLineArg1 = new ExpenseLineOid();
    }

    @Before
    public void setUp() {
        instanceDeletepaidlineRequest = new DeletepaidlineRequest();
        instanceDeletepaidlineRequest.setExpenseLinedeletepaidlinepthisExpenseLine(defValue4expenseLinedeletepaidlinepthisExpenseLine);
        instanceDeletepaidlineRequest.setExpenseLinedeletepaidlinepthisExpenseLineInstance(defValue4expenseLinedeletepaidlinepthisExpenseLineInstance);
    }

    @Test
    public void test4getExpenseLinedeletepaidlinepthisExpenseLine() {
        assertEquals(defValue4expenseLinedeletepaidlinepthisExpenseLine, instanceDeletepaidlineRequest.getExpenseLinedeletepaidlinepthisExpenseLine());
    }

    @Test
    public void test4setExpenseLinedeletepaidlinepthisExpenseLine() {
        instanceDeletepaidlineRequest.setExpenseLinedeletepaidlinepthisExpenseLine(test4setExpenseLinedeletepaidlinepthisExpenseLineArg1);
        assertNotNull(instanceDeletepaidlineRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceDeletepaidlineRequest = new DeletepaidlineRequest();
    	instanceDeletepaidlineRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceDeletepaidlineRequest.checkArguments();
    }
}
