package com.integranova.spring.expensereportdemo.viewmodel.appuser.filter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FAppUsersTest {

    private FAppUsers instanceFAppUsers;

    // testgetVName

    // testsetVName
    private static String testsetVNameArg1;

    // testgetVSurname

    // testsetVSurname
    private static String testsetVSurnameArg1;

    // testgetVType

    // testsetVType
    private static String testsetVTypeArg1;

    // testbuildFilterRequest

    @BeforeClass
    public static void classSetUp() {
        setUpMockData();
    }

    private static void setUpMockData() {
        setUpMockData4testgetVName();
        setUpMockData4testsetVName();
        setUpMockData4testgetVSurname();
        setUpMockData4testsetVSurname();
        setUpMockData4testgetVType();
        setUpMockData4testsetVType();
        setUpMockData4testbuildFilterRequest();
    }

    private static void setUpMockData4testgetVName() {
    }

    private static void setUpMockData4testsetVName() {
        testsetVNameArg1 = "";
    }

    private static void setUpMockData4testgetVSurname() {
    }

    private static void setUpMockData4testsetVSurname() {
        testsetVSurnameArg1 = "";
    }

    private static void setUpMockData4testgetVType() {
    }

    private static void setUpMockData4testsetVType() {
        testsetVTypeArg1 = "";
    }

    private static void setUpMockData4testbuildFilterRequest() {
    }

    @Before
    public void setUp() {
        instanceFAppUsers = new FAppUsers();
        instanceFAppUsers.setVName("");
        instanceFAppUsers.setVSurname("");
        instanceFAppUsers.setVType("");
    }

    @Test
    public void testgetVName() {
        assertEquals("", instanceFAppUsers.getVName());
    }

    @Test
    public void testsetVName() {
        instanceFAppUsers.setVName(testsetVNameArg1);
        assertNotNull(instanceFAppUsers);
    }

    @Test
    public void testgetVSurname() {
        assertEquals("", instanceFAppUsers.getVSurname());
    }

    @Test
    public void testsetVSurname() {
        instanceFAppUsers.setVSurname(testsetVSurnameArg1);
        assertNotNull(instanceFAppUsers);
    }

    @Test
    public void testgetVType() {
        assertEquals("", instanceFAppUsers.getVType());
    }

    @Test
    public void testsetVType() {
        instanceFAppUsers.setVType(testsetVTypeArg1);
        assertNotNull(instanceFAppUsers);
    }

    @Test
    public void testbuildFilterRequest() {
        instanceFAppUsers.buildFilterRequest();
        assertNotNull(instanceFAppUsers);
    }
}
