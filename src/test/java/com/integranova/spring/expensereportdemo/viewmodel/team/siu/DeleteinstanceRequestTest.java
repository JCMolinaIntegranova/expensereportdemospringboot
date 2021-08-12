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
public class DeleteinstanceRequestTest {

    private DeleteinstanceRequest instanceDeleteinstanceRequest;

    // Default values
    private static TeamOid defValue4teamdeleteinstancepthisTeam = new TeamOid();
    private static Team defValue4teamdeleteinstancepthisTeamInstance = new Team(new TeamOid(Long.valueOf(0)));


    // test4getTeamdeleteinstancepthisTeam

    // test4setTeamdeleteinstancepthisTeam
    private static TeamOid test4setTeamdeleteinstancepthisTeamArg1;

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4test4getTeamdeleteinstancepthisTeam();
        setUpMockData4test4setTeamdeleteinstancepthisTeam();
    }

    private static void setUpMockData4test4getTeamdeleteinstancepthisTeam() {
    }

    private static void setUpMockData4test4setTeamdeleteinstancepthisTeam() {
        test4setTeamdeleteinstancepthisTeamArg1 = new TeamOid();
    }

    @Before
    public void setUp() {
        instanceDeleteinstanceRequest = new DeleteinstanceRequest();
        instanceDeleteinstanceRequest.setTeamdeleteinstancepthisTeam(defValue4teamdeleteinstancepthisTeam);
        instanceDeleteinstanceRequest.setTeamdeleteinstancepthisTeamInstance(defValue4teamdeleteinstancepthisTeamInstance);
    }

    @Test
    public void test4getTeamdeleteinstancepthisTeam() {
        assertEquals(defValue4teamdeleteinstancepthisTeam, instanceDeleteinstanceRequest.getTeamdeleteinstancepthisTeam());
    }

    @Test
    public void test4setTeamdeleteinstancepthisTeam() {
        instanceDeleteinstanceRequest.setTeamdeleteinstancepthisTeam(test4setTeamdeleteinstancepthisTeamArg1);
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
