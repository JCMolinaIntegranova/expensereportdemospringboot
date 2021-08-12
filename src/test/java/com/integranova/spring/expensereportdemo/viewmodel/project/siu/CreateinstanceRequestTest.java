package com.integranova.spring.expensereportdemo.viewmodel.project.siu;

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
public class CreateinstanceRequestTest {

    private CreateinstanceRequest instanceCreateinstanceRequest;

    // Default values
    private static TeamOid defValue4projectcreateinstancepagrTeam = new TeamOid();
    private static Team defValue4projectcreateinstancepagrTeamInstance = new Team(new TeamOid(Long.valueOf(0)));
    private static String defValue4projectcreateinstancepatrProjectName = "";
    private static String defValue4projectcreateinstancepatrProDescription = "";


    // test4getProjectcreateinstancepagrTeam

    // test4setProjectcreateinstancepagrTeam
    private static TeamOid test4setProjectcreateinstancepagrTeamArg1;

    // test4getProjectcreateinstancepatrProjectName

    // test4setProjectcreateinstancepatrProjectName
    private static String test4setProjectcreateinstancepatrProjectNameArg1;

    // test4getProjectcreateinstancepatrProDescription

    // test4setProjectcreateinstancepatrProDescription
    private static String test4setProjectcreateinstancepatrProDescriptionArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getProjectcreateinstancepagrTeam();
        setUpMockData4test4setProjectcreateinstancepagrTeam();
        setUpMockData4test4getProjectcreateinstancepatrProjectName();
        setUpMockData4test4setProjectcreateinstancepatrProjectName();
        setUpMockData4test4getProjectcreateinstancepatrProDescription();
        setUpMockData4test4setProjectcreateinstancepatrProDescription();
    }

    private static void setUpMockData4test4getProjectcreateinstancepagrTeam() {
    }

    private static void setUpMockData4test4setProjectcreateinstancepagrTeam() {
        test4setProjectcreateinstancepagrTeamArg1 = new TeamOid();
    }

    private static void setUpMockData4test4getProjectcreateinstancepatrProjectName() {
    }

    private static void setUpMockData4test4setProjectcreateinstancepatrProjectName() {
        test4setProjectcreateinstancepatrProjectNameArg1 = "";
    }

    private static void setUpMockData4test4getProjectcreateinstancepatrProDescription() {
    }

    private static void setUpMockData4test4setProjectcreateinstancepatrProDescription() {
        test4setProjectcreateinstancepatrProDescriptionArg1 = "";
    }

    @Before
    public void setUp() {
        instanceCreateinstanceRequest = new CreateinstanceRequest();
        instanceCreateinstanceRequest.setProjectcreateinstancepagrTeam(defValue4projectcreateinstancepagrTeam);
        instanceCreateinstanceRequest.setProjectcreateinstancepagrTeamInstance(defValue4projectcreateinstancepagrTeamInstance);
        instanceCreateinstanceRequest.setProjectcreateinstancepatrProjectName(defValue4projectcreateinstancepatrProjectName);
        instanceCreateinstanceRequest.setProjectcreateinstancepatrProDescription(defValue4projectcreateinstancepatrProDescription);
    }

    @Test
    public void test4getProjectcreateinstancepagrTeam() {
        assertEquals(defValue4projectcreateinstancepagrTeam, instanceCreateinstanceRequest.getProjectcreateinstancepagrTeam());
    }

    @Test
    public void test4setProjectcreateinstancepagrTeam() {
        instanceCreateinstanceRequest.setProjectcreateinstancepagrTeam(test4setProjectcreateinstancepagrTeamArg1);
        assertNotNull(instanceCreateinstanceRequest);
    }

    @Test
    public void test4getProjectcreateinstancepatrProjectName() {
        assertEquals(defValue4projectcreateinstancepatrProjectName, instanceCreateinstanceRequest.getProjectcreateinstancepatrProjectName());
    }

    @Test
    public void test4setProjectcreateinstancepatrProjectName() {
        instanceCreateinstanceRequest.setProjectcreateinstancepatrProjectName(test4setProjectcreateinstancepatrProjectNameArg1);
        assertNotNull(instanceCreateinstanceRequest);
    }

    @Test
    public void test4getProjectcreateinstancepatrProDescription() {
        assertEquals(defValue4projectcreateinstancepatrProDescription, instanceCreateinstanceRequest.getProjectcreateinstancepatrProDescription());
    }

    @Test
    public void test4setProjectcreateinstancepatrProDescription() {
        instanceCreateinstanceRequest.setProjectcreateinstancepatrProDescription(test4setProjectcreateinstancepatrProDescriptionArg1);
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
