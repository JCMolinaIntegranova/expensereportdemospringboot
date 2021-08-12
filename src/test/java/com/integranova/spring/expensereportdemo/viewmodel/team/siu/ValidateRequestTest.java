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
public class ValidateRequestTest {

    private ValidateRequest instanceValidateRequest;

    // Default values
    private static TeamOid defValue4teamvalidatepthisTeam = new TeamOid();
    private static Team defValue4teamvalidatepthisTeamInstance = new Team(new TeamOid(Long.valueOf(0)));
    private static String preconditionIdDefaultValue = "preconditionId";


    // test4getTeamvalidatepthisTeam

    // test4setTeamvalidatepthisTeam
    private static TeamOid test4setTeamvalidatepthisTeamArg1;

    // testGetPreconditionId

    // testSetPreconditionId
    private static String testSetPreconditionIdArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getTeamvalidatepthisTeam();
        setUpMockData4test4setTeamvalidatepthisTeam();
        setUpMockData4testGetPreconditionId();
        setUpMockData4testSetPreconditionId();
    }

    private static void setUpMockData4test4getTeamvalidatepthisTeam() {
    }

    private static void setUpMockData4test4setTeamvalidatepthisTeam() {
        test4setTeamvalidatepthisTeamArg1 = new TeamOid();
    }

    private static void setUpMockData4testGetPreconditionId() {
    }

    private static void setUpMockData4testSetPreconditionId() {
        testSetPreconditionIdArg1 = preconditionIdDefaultValue;
    }

    @Before
    public void setUp() {
        instanceValidateRequest = new ValidateRequest();
        instanceValidateRequest.setTeamvalidatepthisTeam(defValue4teamvalidatepthisTeam);
        instanceValidateRequest.setTeamvalidatepthisTeamInstance(defValue4teamvalidatepthisTeamInstance);
        instanceValidateRequest.setPreconditionId("preconditionId");
    }

    @Test
    public void test4getTeamvalidatepthisTeam() {
        assertEquals(defValue4teamvalidatepthisTeam, instanceValidateRequest.getTeamvalidatepthisTeam());
    }

    @Test
    public void test4setTeamvalidatepthisTeam() {
        instanceValidateRequest.setTeamvalidatepthisTeam(test4setTeamvalidatepthisTeamArg1);
        assertNotNull(instanceValidateRequest);
    }

    @Test
    public void testGetPreconditionId() {
        assertEquals(preconditionIdDefaultValue, instanceValidateRequest.getPreconditionId());
    }

    @Test
    public void testSetPreconditionId() {
        instanceValidateRequest.setPreconditionId(testSetPreconditionIdArg1);
        assertNotNull(instanceValidateRequest);
    }

    @Test(expected=NotNullArgumentException.class)
    public void test4checkArgumentsForNullValues() throws NotNullArgumentException {
        instanceValidateRequest = new ValidateRequest();
    	instanceValidateRequest.checkArguments();
    }
    
    @Test()
    public void test4checkArgumentsForNonNullValues() throws NotNullArgumentException {
    	instanceValidateRequest.checkArguments();
    }
}
