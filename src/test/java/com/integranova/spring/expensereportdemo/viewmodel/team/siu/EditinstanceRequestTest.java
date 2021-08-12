package com.integranova.spring.expensereportdemo.viewmodel.team.siu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.integranova.spring.expensereportdemo.exception.NotNullArgumentException;
import com.integranova.spring.expensereportdemo.persistence.oid.TeamOid;
import com.integranova.spring.expensereportdemo.persistence.Team;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EditinstanceRequestTest {

    private EditinstanceRequest instanceEditinstanceRequest;

    // Default values
    private static TeamOid defValue4teameditinstancepthisTeam = new TeamOid();
    private static Team defValue4teameditinstancepthisTeamInstance = new Team(new TeamOid(Long.valueOf(0)));
    private static String defValue4teameditinstancepname = "";
    private static Long defValue4teameditinstancepmaxEmployees = Long.valueOf(0);


    // test4getTeameditinstancepthisTeam

    // test4setTeameditinstancepthisTeam
    private static TeamOid test4setTeameditinstancepthisTeamArg1;

    // test4getTeameditinstancepname

    // test4setTeameditinstancepname
    private static String test4setTeameditinstancepnameArg1;

    // test4getTeameditinstancepmaxEmployees

    // test4setTeameditinstancepmaxEmployees
    private static Long test4setTeameditinstancepmaxEmployeesArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getTeameditinstancepthisTeam();
        setUpMockData4test4setTeameditinstancepthisTeam();
        setUpMockData4test4getTeameditinstancepname();
        setUpMockData4test4setTeameditinstancepname();
        setUpMockData4test4getTeameditinstancepmaxEmployees();
        setUpMockData4test4setTeameditinstancepmaxEmployees();
    }

    private static void setUpMockData4test4getTeameditinstancepthisTeam() {
    }

    private static void setUpMockData4test4setTeameditinstancepthisTeam() {
        test4setTeameditinstancepthisTeamArg1 = new TeamOid();
    }

    private static void setUpMockData4test4getTeameditinstancepname() {
    }

    private static void setUpMockData4test4setTeameditinstancepname() {
        test4setTeameditinstancepnameArg1 = "";
    }

    private static void setUpMockData4test4getTeameditinstancepmaxEmployees() {
    }

    private static void setUpMockData4test4setTeameditinstancepmaxEmployees() {
        test4setTeameditinstancepmaxEmployeesArg1 = Long.valueOf(0);
    }

    @Before
    public void setUp() {
        instanceEditinstanceRequest = new EditinstanceRequest();
        instanceEditinstanceRequest.setTeameditinstancepthisTeam(defValue4teameditinstancepthisTeam);
        instanceEditinstanceRequest.setTeameditinstancepthisTeamInstance(defValue4teameditinstancepthisTeamInstance);
        instanceEditinstanceRequest.setTeameditinstancepname(defValue4teameditinstancepname);
        instanceEditinstanceRequest.setTeameditinstancepmaxEmployees(defValue4teameditinstancepmaxEmployees);
    }

    @Test
    public void test4getTeameditinstancepthisTeam() {
        assertEquals(defValue4teameditinstancepthisTeam, instanceEditinstanceRequest.getTeameditinstancepthisTeam());
    }

    @Test
    public void test4setTeameditinstancepthisTeam() {
        instanceEditinstanceRequest.setTeameditinstancepthisTeam(test4setTeameditinstancepthisTeamArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test
    public void test4getTeameditinstancepname() {
        assertEquals(defValue4teameditinstancepname, instanceEditinstanceRequest.getTeameditinstancepname());
    }

    @Test
    public void test4setTeameditinstancepname() {
        instanceEditinstanceRequest.setTeameditinstancepname(test4setTeameditinstancepnameArg1);
        assertNotNull(instanceEditinstanceRequest);
    }

    @Test
    public void test4getTeameditinstancepmaxEmployees() {
        assertEquals(defValue4teameditinstancepmaxEmployees, instanceEditinstanceRequest.getTeameditinstancepmaxEmployees());
    }

    @Test
    public void test4setTeameditinstancepmaxEmployees() {
        instanceEditinstanceRequest.setTeameditinstancepmaxEmployees(test4setTeameditinstancepmaxEmployeesArg1);
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
