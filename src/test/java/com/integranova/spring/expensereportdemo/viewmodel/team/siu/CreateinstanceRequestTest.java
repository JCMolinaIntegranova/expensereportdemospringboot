package com.integranova.spring.expensereportdemo.viewmodel.team.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CreateinstanceRequestTest {

    private CreateinstanceRequest instanceCreateinstanceRequest;

    // Default values
    private static String defValue4teamcreateinstancepatrname = "";
    private static Long defValue4teamcreateinstancepatrmaxEmployees = Long.valueOf(0);


    // test4getTeamcreateinstancepatrname

    // test4setTeamcreateinstancepatrname
    private static String test4setTeamcreateinstancepatrnameArg1;

    // test4getTeamcreateinstancepatrmaxEmployees

    // test4setTeamcreateinstancepatrmaxEmployees
    private static Long test4setTeamcreateinstancepatrmaxEmployeesArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getTeamcreateinstancepatrname();
        setUpMockData4test4setTeamcreateinstancepatrname();
        setUpMockData4test4getTeamcreateinstancepatrmaxEmployees();
        setUpMockData4test4setTeamcreateinstancepatrmaxEmployees();
    }

    private static void setUpMockData4test4getTeamcreateinstancepatrname() {
    }

    private static void setUpMockData4test4setTeamcreateinstancepatrname() {
        test4setTeamcreateinstancepatrnameArg1 = "";
    }

    private static void setUpMockData4test4getTeamcreateinstancepatrmaxEmployees() {
    }

    private static void setUpMockData4test4setTeamcreateinstancepatrmaxEmployees() {
        test4setTeamcreateinstancepatrmaxEmployeesArg1 = Long.valueOf(0);
    }

    @Before
    public void setUp() {
        instanceCreateinstanceRequest = new CreateinstanceRequest();
        instanceCreateinstanceRequest.setTeamcreateinstancepatrname(defValue4teamcreateinstancepatrname);
        instanceCreateinstanceRequest.setTeamcreateinstancepatrmaxEmployees(defValue4teamcreateinstancepatrmaxEmployees);
    }

    @Test
    public void test4getTeamcreateinstancepatrname() {
        assertEquals(defValue4teamcreateinstancepatrname, instanceCreateinstanceRequest.getTeamcreateinstancepatrname());
    }

    @Test
    public void test4setTeamcreateinstancepatrname() {
        instanceCreateinstanceRequest.setTeamcreateinstancepatrname(test4setTeamcreateinstancepatrnameArg1);
        assertNotNull(instanceCreateinstanceRequest);
    }

    @Test
    public void test4getTeamcreateinstancepatrmaxEmployees() {
        assertEquals(defValue4teamcreateinstancepatrmaxEmployees, instanceCreateinstanceRequest.getTeamcreateinstancepatrmaxEmployees());
    }

    @Test
    public void test4setTeamcreateinstancepatrmaxEmployees() {
        instanceCreateinstanceRequest.setTeamcreateinstancepatrmaxEmployees(test4setTeamcreateinstancepatrmaxEmployeesArg1);
        assertNotNull(instanceCreateinstanceRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceCreateinstanceRequest = new CreateinstanceRequest();
    	instanceCreateinstanceRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceCreateinstanceRequest.checkArguments();
    }
}
