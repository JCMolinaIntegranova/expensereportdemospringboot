package com.integranova.spring.expensereportdemo.viewmodel.exchangehistory.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.persistence.ExchangeHistory;
import com.integranova.spring.expensereportdemo.persistence.oid.ExchangeHistoryOid;
import java.sql.Date;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DeleteinstanceRequestTest {

    private DeleteinstanceRequest instanceDeleteinstanceRequest;

    // Default values
    private static ExchangeHistoryOid defValue4exchangeHistorydeleteinstancepthisExchangeHistory = new ExchangeHistoryOid();
    private static ExchangeHistory defValue4exchangeHistorydeleteinstancepthisExchangeHistoryInstance = new ExchangeHistory(new ExchangeHistoryOid("", Date.valueOf(Constants.DATE_DEFAULTVALUE)));


    // test4getExchangeHistorydeleteinstancepthisExchangeHistory

    // test4setExchangeHistorydeleteinstancepthisExchangeHistory
    private static ExchangeHistoryOid test4setExchangeHistorydeleteinstancepthisExchangeHistoryArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getExchangeHistorydeleteinstancepthisExchangeHistory();
        setUpMockData4test4setExchangeHistorydeleteinstancepthisExchangeHistory();
    }

    private static void setUpMockData4test4getExchangeHistorydeleteinstancepthisExchangeHistory() {
    }

    private static void setUpMockData4test4setExchangeHistorydeleteinstancepthisExchangeHistory() {
        test4setExchangeHistorydeleteinstancepthisExchangeHistoryArg1 = new ExchangeHistoryOid();
    }

    @Before
    public void setUp() {
        instanceDeleteinstanceRequest = new DeleteinstanceRequest();
        instanceDeleteinstanceRequest.setExchangeHistorydeleteinstancepthisExchangeHistory(defValue4exchangeHistorydeleteinstancepthisExchangeHistory);
        instanceDeleteinstanceRequest.setExchangeHistorydeleteinstancepthisExchangeHistoryInstance(defValue4exchangeHistorydeleteinstancepthisExchangeHistoryInstance);
    }

    @Test
    public void test4getExchangeHistorydeleteinstancepthisExchangeHistory() {
        assertEquals(defValue4exchangeHistorydeleteinstancepthisExchangeHistory, instanceDeleteinstanceRequest.getExchangeHistorydeleteinstancepthisExchangeHistory());
    }

    @Test
    public void test4setExchangeHistorydeleteinstancepthisExchangeHistory() {
        instanceDeleteinstanceRequest.setExchangeHistorydeleteinstancepthisExchangeHistory(test4setExchangeHistorydeleteinstancepthisExchangeHistoryArg1);
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
