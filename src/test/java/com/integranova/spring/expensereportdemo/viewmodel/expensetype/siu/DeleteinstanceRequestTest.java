package com.integranova.spring.expensereportdemo.viewmodel.expensetype.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.persistence.ExpenseType;
import com.integranova.spring.expensereportdemo.persistence.oid.ExpenseTypeOid;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DeleteinstanceRequestTest {

    private DeleteinstanceRequest instanceDeleteinstanceRequest;

    // Default values
    private static ExpenseTypeOid defValue4expenseTypedeleteinstancepthisExpenseType = new ExpenseTypeOid();
    private static ExpenseType defValue4expenseTypedeleteinstancepthisExpenseTypeInstance = new ExpenseType(new ExpenseTypeOid(""));


    // test4getExpenseTypedeleteinstancepthisExpenseType

    // test4setExpenseTypedeleteinstancepthisExpenseType
    private static ExpenseTypeOid test4setExpenseTypedeleteinstancepthisExpenseTypeArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getExpenseTypedeleteinstancepthisExpenseType();
        setUpMockData4test4setExpenseTypedeleteinstancepthisExpenseType();
    }

    private static void setUpMockData4test4getExpenseTypedeleteinstancepthisExpenseType() {
    }

    private static void setUpMockData4test4setExpenseTypedeleteinstancepthisExpenseType() {
        test4setExpenseTypedeleteinstancepthisExpenseTypeArg1 = new ExpenseTypeOid();
    }

    @Before
    public void setUp() {
        instanceDeleteinstanceRequest = new DeleteinstanceRequest();
        instanceDeleteinstanceRequest.setExpenseTypedeleteinstancepthisExpenseType(defValue4expenseTypedeleteinstancepthisExpenseType);
        instanceDeleteinstanceRequest.setExpenseTypedeleteinstancepthisExpenseTypeInstance(defValue4expenseTypedeleteinstancepthisExpenseTypeInstance);
    }

    @Test
    public void test4getExpenseTypedeleteinstancepthisExpenseType() {
        assertEquals(defValue4expenseTypedeleteinstancepthisExpenseType, instanceDeleteinstanceRequest.getExpenseTypedeleteinstancepthisExpenseType());
    }

    @Test
    public void test4setExpenseTypedeleteinstancepthisExpenseType() {
        instanceDeleteinstanceRequest.setExpenseTypedeleteinstancepthisExpenseType(test4setExpenseTypedeleteinstancepthisExpenseTypeArg1);
        assertNotNull(instanceDeleteinstanceRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceDeleteinstanceRequest = new DeleteinstanceRequest();
    	instanceDeleteinstanceRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceDeleteinstanceRequest.checkArguments();
    }
}
