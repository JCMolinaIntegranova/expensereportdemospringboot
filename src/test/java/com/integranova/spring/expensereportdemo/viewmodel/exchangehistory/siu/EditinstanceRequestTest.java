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
public class EditinstanceRequestTest {

    private EditinstanceRequest instanceEditinstanceRequest;

    // Default values
    private static ExchangeHistoryOid defValue4exchangeHistoryeditinstancepthisExchangeHistory = new ExchangeHistoryOid();
    private static ExchangeHistory defValue4exchangeHistoryeditinstancepthisExchangeHistoryInstance = new ExchangeHistory(new ExchangeHistoryOid("", Date.valueOf(Constants.DATE_DEFAULTVALUE)));
    private static Double defValue4exchangeHistoryeditinstancepoldValue = Double.valueOf(0);
    private static Double defValue4exchangeHistoryeditinstancepnewValue = Double.valueOf(0);


    // test4getExchangeHistoryeditinstancepthisExchangeHistory

    // test4setExchangeHistoryeditinstancepthisExchangeHistory
    private static ExchangeHistoryOid test4setExchangeHistoryeditinstancepthisExchangeHistoryArg1;

    // test4getExchangeHistoryeditinstancepoldValue

    // test4setExchangeHistoryeditinstancepoldValue
    private static Double test4setExchangeHistoryeditinstancepoldValueArg1;

    // test4getExchangeHistoryeditinstancepnewValue

    // test4setExchangeHistoryeditinstancepnewValue
    private static Double test4setExchangeHistoryeditinstancepnewValueArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getExchangeHistoryeditinstancepthisExchangeHistory();
        setUpMockData4test4setExchangeHistoryeditinstancepthisExchangeHistory();
        setUpMockData4test4getExchangeHistoryeditinstancepoldValue();
        setUpMockData4test4setExchangeHistoryeditinstancepoldValue();
        setUpMockData4test4getExchangeHistoryeditinstancepnewValue();
        setUpMockData4test4setExchangeHistoryeditinstancepnewValue();
    }

    private static void setUpMockData4test4getExchangeHistoryeditinstancepthisExchangeHistory() {
    }

    private static void setUpMockData4test4setExchangeHistoryeditinstancepthisExchangeHistory() {
        test4setExchangeHistoryeditinstancepthisExchangeHistoryArg1 = new ExchangeHistoryOid();
    }

    private static void setUpMockData4test4getExchangeHistoryeditinstancepoldValue() {
    }

    private static void setUpMockData4test4setExchangeHistoryeditinstancepoldValue() {
        test4setExchangeHistoryeditinstancepoldValueArg1 = Double.valueOf(0);
    }

    private static void setUpMockData4test4getExchangeHistoryeditinstancepnewValue() {
    }

    private static void setUpMockData4test4setExchangeHistoryeditinstancepnewValue() {
        test4setExchangeHistoryeditinstancepnewValueArg1 = Double.valueOf(0);
    }

    @Before
    public void setUp() {
        instanceEditinstanceRequest = new EditinstanceRequest();
        instanceEditinstanceRequest.setExchangeHistoryeditinstancepthisExchangeHistory(defValue4exchangeHistoryeditinstancepthisExchangeHistory);
        instanceEditinstanceRequest.setExchangeHistoryeditinstancepthisExchangeHistoryInstance(defValue4exchangeHistoryeditinstancepthisExchangeHistoryInstance);
        instanceEditinstanceRequest.setExchangeHistoryeditinstancepoldValue(defValue4exchangeHistoryeditinstancepoldValue);
        instanceEditinstanceRequest.setExchangeHistoryeditinstancepnewValue(defValue4exchangeHistoryeditinstancepnewValue);
    }

    @Test
    public void test4getExchangeHistoryeditinstancepthisExchangeHistory() {
        assertEquals(defValue4exchangeHistoryeditinstancepthisExchangeHistory, instanceEditinstanceRequest.getExchangeHistoryeditinstancepthisExchangeHistory());
    }

    @Test
    public void test4setExchangeHistoryeditinstancepthisExchangeHistory() {
        instanceEditinstanceRequest.setExchangeHistoryeditinstancepthisExchangeHistory(test4setExchangeHistoryeditinstancepthisExchangeHistoryArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test
    public void test4getExchangeHistoryeditinstancepoldValue() {
        assertEquals(defValue4exchangeHistoryeditinstancepoldValue, instanceEditinstanceRequest.getExchangeHistoryeditinstancepoldValue());
    }

    @Test
    public void test4setExchangeHistoryeditinstancepoldValue() {
        instanceEditinstanceRequest.setExchangeHistoryeditinstancepoldValue(test4setExchangeHistoryeditinstancepoldValueArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test
    public void test4getExchangeHistoryeditinstancepnewValue() {
        assertEquals(defValue4exchangeHistoryeditinstancepnewValue, instanceEditinstanceRequest.getExchangeHistoryeditinstancepnewValue());
    }

    @Test
    public void test4setExchangeHistoryeditinstancepnewValue() {
        instanceEditinstanceRequest.setExchangeHistoryeditinstancepnewValue(test4setExchangeHistoryeditinstancepnewValueArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceEditinstanceRequest = new EditinstanceRequest();
    	instanceEditinstanceRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceEditinstanceRequest.checkArguments();
    }
}
