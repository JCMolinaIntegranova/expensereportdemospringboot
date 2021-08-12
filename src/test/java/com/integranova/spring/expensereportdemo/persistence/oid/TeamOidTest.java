package com.integranova.spring.expensereportdemo.persistence.oid;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.integranova.spring.expensereportdemo.global.Constants;
import com.integranova.spring.expensereportdemo.global.TeamConstants;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TeamOidTest {

    private TeamOid instanceTeamOid;

    private static List<Object> VALUE_ARRAYLISTVALUES;
    private static Long VALUE_TEAMID;
	
    @BeforeClass
    public static void setUpClass() {
        setUpMockData();
    }
	
    public static void setUpMockData() {
        VALUE_ARRAYLISTVALUES = new ArrayList<>();
        VALUE_TEAMID = Long.valueOf(0);
        VALUE_ARRAYLISTVALUES.add(VALUE_TEAMID);
    }

    @Before
    public void setUp() {
        instanceTeamOid = new TeamOid();
        instanceTeamOid.setTeamid(VALUE_TEAMID);
    }

    @After
    public void tearDown() {
        instanceTeamOid = null;
    }

    @Test
    public void testDefaultConstructor() {
        instanceTeamOid = new TeamOid();
        assertNotNull(instanceTeamOid);
    }

    @Test
    public void testConstructor() {
        instanceTeamOid = new TeamOid(VALUE_TEAMID);
        assertNotNull(instanceTeamOid);
    }
    
    @Test
    public void testConstructor2() {
        List<Object> oidFields = new ArrayList<>();
        oidFields.add(VALUE_TEAMID);
        instanceTeamOid = new TeamOid(oidFields);
        assertNotNull(instanceTeamOid);
    }

    @Test
    public void test4getTeamid() {
        assertEquals(VALUE_TEAMID.toString(), instanceTeamOid.getTeamid().toString());
    }

    @Test
    public void test4Equals2() {
        assertFalse(instanceTeamOid.equals(null));
    }

    @Test
    public void test4Equals3() {
        assertFalse(instanceTeamOid.equals(new Object()));
    }

    @Test
    public void test4Equals() {
        assertTrue(instanceTeamOid.equals(instanceTeamOid));
    }

    @Test
    public void test4hashCode() {
        assertNotNull(instanceTeamOid.hashCode());
    }

    @Test
    public void test4hashCode2() {
        instanceTeamOid.setTeamid(null);
        assertTrue(instanceTeamOid.hashCode() > 0);
    }

    @Test
    public void test4getDefinitionClass() {
        assertEquals(TeamConstants.CLASS_NAME, instanceTeamOid.getDefinitionClass());
    }

    @Test
    public void test4toString() {
        assertFalse(instanceTeamOid.toString().isEmpty());
    }

    @Test
    public void test4toJsonString() {
        assertFalse(instanceTeamOid.toJson().isEmpty());
    }

    @Test
    public void test4fromJsonString() {
        String jsonString = "{";
        jsonString += "\"" + TeamConstants.ATTR_NAME_TEAMID + "\" : " + instanceTeamOid.getTeamid().toString();
        jsonString += "}";
        instanceTeamOid.fromJsonString(jsonString);
        assertNotNull(instanceTeamOid);
    }

    @Test
    public void test4getValue() {
        assertNotNull(instanceTeamOid.getValue());
    }
    
    @Test
    public void test4getKeys() {
        assertEquals(TeamConstants.ATTR_NAME_TEAMID, instanceTeamOid.getKeys()[0]);
    }

    @Test
    public void test4getDataTypes() {
        assertEquals(Constants.Type.AUTONUMERIC.getTypeName(), instanceTeamOid.getDataTypes()[0]);
    }

    @Test
    public void test4compareToRS() {
        assertTrue(instanceTeamOid.compareToRS(VALUE_ARRAYLISTVALUES.toArray()));
    }

    @Test
    public void test4compareToRS2() {
        assertTrue(instanceTeamOid.compareToRS(null));
    }

    @Test
    public void test4compareToRS3() {
        Object[] values = VALUE_ARRAYLISTVALUES.toArray();
        values[0] = null;
        assertTrue(instanceTeamOid.compareToRS(values));
    }
}
