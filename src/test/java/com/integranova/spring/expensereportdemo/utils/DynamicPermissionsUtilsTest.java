package com.integranova.spring.expensereportdemo.utils;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.Silent.class)
public class DynamicPermissionsUtilsTest {

	@Test
	public void test4Constructor() {
		DynamicPermissionsUtils instance = new DynamicPermissionsUtils("", "");
		instance.getUserId();
		instance.getVisibleHATNodesForUser();
		instance.getVisibleIUsForUser();
		assertNotNull(instance);
	}

	@Test
	public void test4ConstructorForRoleAppUser() {
		DynamicPermissionsUtils instance = new DynamicPermissionsUtils("AppUser", "AppUser");
		instance.getUserId();
		instance.getVisibleHATNodesForUser();
		instance.getVisibleIUsForUser();
		assertNotNull(instance);
	}

	@Test
	public void test4ConstructorForRoleAdminUser() {
		DynamicPermissionsUtils instance = new DynamicPermissionsUtils("AdminUser", "AdminUser");
		instance.getUserId();
		instance.getVisibleHATNodesForUser();
		instance.getVisibleIUsForUser();
		assertNotNull(instance);
	}

	@Test
	public void test4ConstructorForRoleOperatorUser() {
		DynamicPermissionsUtils instance = new DynamicPermissionsUtils("OperatorUser", "OperatorUser");
		instance.getUserId();
		instance.getVisibleHATNodesForUser();
		instance.getVisibleIUsForUser();
		assertNotNull(instance);
	}
}
