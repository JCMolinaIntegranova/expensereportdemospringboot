package com.integranova.spring.expensereportdemo.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.ApplicationContext;


@RunWith(MockitoJUnitRunner.Silent.class)
public class BeanUtilTest {

	@InjectMocks
	private static BeanUtil instanceBeanUtil;
	
	@Mock
	private static ApplicationContext mockApplicationContext;
	
	private static ApplicationContext test4setApplicationContextArg1;
	
    @BeforeClass
    public static void setUpClass() {
        setUpMockData();
    }
    
    private static void setUpMockData() {
    	setUpMockData4setApplicationContext();
    }
    
    private static void setUpMockData4setApplicationContext() {
    	test4setApplicationContextArg1 = mockApplicationContext;
    }
    
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
	
    @Test
	public void test4setApplicationContext() {
		
		instanceBeanUtil.setApplicationContext(test4setApplicationContextArg1);
		assertNotNull(instanceBeanUtil);
	}
    
    @Test
    public void test4getBean() {
    	BeanUtil.getBean(BeanUtil.class);
    	assertNotNull(instanceBeanUtil);
    }
    
    @Test
    public void test4getBean2() {
    	instanceBeanUtil.setApplicationContext(null);
    	BeanUtil.getBean(BeanUtil.class);
    	assertNotNull(instanceBeanUtil);
    }
}
