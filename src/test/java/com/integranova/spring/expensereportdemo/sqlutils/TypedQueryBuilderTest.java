package com.integranova.spring.expensereportdemo.sqlutils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.integranova.spring.expensereportdemo.exception.SystemException;

@RunWith(MockitoJUnitRunner.Silent.class)
public class TypedQueryBuilderTest {

	private static EntityManager em;
	
	TypedQueryBuilder<Long> instanceLong;
	TypedQueryBuilder<Double> instanceDouble;
	TypedQueryBuilder<String> instanceString;
	TypedQueryBuilder<Boolean> instanceBoolean;
	TypedQueryBuilder<Date> instanceDate;
	TypedQueryBuilder<Time> instanceTime;
	TypedQueryBuilder<Timestamp> instanceTimestamp;
	
    
    @BeforeClass
    public static void setUpClass() throws SystemException {
        setUpMockData();
    }
    
    @SuppressWarnings("unchecked")
    private static void setUpMockData() {
    	em = mock(EntityManager.class);
    	when(em.createQuery(anyString(), any())).thenReturn(mock(TypedQuery.class));
    }
	
    @Before
    public void setUp() {
    	instanceLong = new TypedQueryBuilder<Long>(em, Long.class);
    	instanceDouble = new TypedQueryBuilder<Double>(em, Double.class);
    	instanceString = new TypedQueryBuilder<String>(em, String.class);
    	instanceBoolean = new TypedQueryBuilder<Boolean>(em, Boolean.class);
    	instanceDate = new TypedQueryBuilder<Date>(em, Date.class);
    	instanceTime = new TypedQueryBuilder<Time>(em, Time.class);
    	instanceTimestamp = new TypedQueryBuilder<Timestamp>(em, Timestamp.class);
    }
    
    @After
    public void tearDown() {
    	instanceLong = null;
    	instanceDouble = null;
    	instanceString = null;
    	instanceBoolean = null;
    	instanceDate = null;
    	instanceTime = null;
    	instanceTimestamp = null;
    }
	
	@Test
	public void test4Constructor4Long() {
		instanceLong = new TypedQueryBuilder<Long>(em, Long.class);
		assertNotNull(instanceLong);
	}
	
	@Test
	public void test4Constructor4Double() {
		instanceDouble = new TypedQueryBuilder<Double>(em, Double.class);
		assertNotNull(instanceDouble);
	}
	
	@Test
	public void test4Constructor4String() {
		instanceString = new TypedQueryBuilder<String>(em, String.class);
		assertNotNull(instanceString);
	}
	
	@Test
	public void test4Constructor4Boolean() {
		instanceBoolean = new TypedQueryBuilder<Boolean>(em, Boolean.class);
		assertNotNull(instanceBoolean);
	}
	
	@Test
	public void test4Constructor4Date() {
		instanceDate = new TypedQueryBuilder<Date>(em, Date.class);
		assertNotNull(instanceDate);
	}

	@Test
	public void test4Constructor4Time() {
		instanceTime = new TypedQueryBuilder<Time>(em, Time.class);
		assertNotNull(instanceTime);
	}
	
	@Test
	public void test4Constructor4Timestamp() {
		instanceTimestamp = new TypedQueryBuilder<Timestamp>(em, Timestamp.class);
		assertNotNull(instanceTimestamp);
	}
	
	@Test
	public void test4buildBoolean1() {
		try {
			instanceBoolean.build(new SQLSum(new SQLSelect(null), "SourceClass", "role.attribute"));
		} catch (SystemException e) {
			instanceBoolean = null;
		}
		assertNotNull(instanceBoolean);
	}
	
	@Test
	public void test4buildBoolean2() {
		try {
			instanceBoolean.build(new SQLPopulation("sourceEntityName"), 1, 0);
		} catch (SystemException e) {
			instanceBoolean = null;
		}
		assertNotNull(instanceBoolean);
	}
	
	@Test
	public void test4buildDate1() {
		try {
			instanceDate.build(new SQLSum(new SQLSelect(null), "SourceClass", "role.attribute"));
		} catch (SystemException e) {
			instanceDate = null;
		}
		assertNotNull(instanceDate);
	}
	
	@Test
	public void test4buildDate2() {
		try {
			instanceDate.build(new SQLPopulation("sourceEntityName"), 1, 0);
		} catch (SystemException e) {
			instanceDate = null;
		}
		assertNotNull(instanceDate);
	}
	
	@Test
	public void test4buildDouble1() {
		try {
			instanceDouble.build(new SQLSum(new SQLSelect(null), "SourceClass", "role.attribute"));
		} catch (SystemException e) {
			instanceDouble = null;
		}
		assertNotNull(instanceDouble);
	}
	
	@Test
	public void test4buildDouble2() {
		try {
			instanceDouble.build(new SQLPopulation("sourceEntityName"), 1, 0);
		} catch (SystemException e) {
			instanceDouble = null;
		}
		assertNotNull(instanceDouble);
	}
	
	@Test
	public void test4buildLong1() {
		try {
			instanceLong.build(new SQLSum(new SQLSelect(null), "SourceClass", "role.attribute"));
		} catch (SystemException e) {
			instanceLong = null;
		}
		assertNotNull(instanceLong);
	}
	
	@Test
	public void test4buildLong2() {
		try {
			instanceLong.build(new SQLPopulation("sourceEntityName"), 1, 0);
		} catch (SystemException e) {
			instanceLong = null;
		}
		assertNotNull(instanceLong);
	}

	@Test
	public void test4buildString1() {
		try {
			instanceString.build(new SQLSum(new SQLSelect(null), "SourceClass", "role.attribute"));
		} catch (SystemException e) {
			instanceString = null;
		}
		assertNotNull(instanceString);
	}
	
	@Test
	public void test4buildString2() {
		try {
			instanceString.build(new SQLPopulation("sourceEntityName"), 1, 0);
		} catch (SystemException e) {
			instanceString = null;
		}
		assertNotNull(instanceString);
	}
	
	@Test
	public void test4buildTime1() {
		try {
			instanceTime.build(new SQLSum(new SQLSelect(null), "SourceClass", "role.attribute"));
		} catch (SystemException e) {
			instanceTime = null;
		}
		assertNotNull(instanceTime);
	}
	
	@Test
	public void test4buildTime2() {
		try {
			instanceTime.build(new SQLPopulation("sourceEntityName"), 1, 0);
		} catch (SystemException e) {
			instanceTime = null;
		}
		assertNotNull(instanceTime);
	}
	
	@Test
	public void test4buildTimestamp1() {
		try {
			instanceTimestamp.build(new SQLSum(new SQLSelect(null), "SourceClass", "role.attribute"));
		} catch (SystemException e) {
			instanceTimestamp = null;
		}
		assertNotNull(instanceTimestamp);
	}
	
	@Test
	public void test4buildTimestamp2() {
		try {
			instanceTimestamp.build(new SQLPopulation("sourceEntityName"), 1, 0);
		} catch (SystemException e) {
			instanceTimestamp = null;
		}
		assertNotNull(instanceTimestamp);
	}
	@Test
	public void test4build4CountBoolean() {
		try {
			instanceBoolean.build4Count(new SQLPopulation("sourceEntityName"));
		} catch (SystemException e) {
			instanceBoolean = null;
		}
		assertNotNull(instanceBoolean);
	}
	
	@Test
	public void test4build4CountDate() {
		try {
			instanceDate.build4Count(new SQLPopulation("sourceEntityName"));
		} catch (SystemException e) {
			instanceDate = null;
		}
		assertNotNull(instanceDate);
	}
	
	@Test
	public void test4build4CountDouble() {
		try {
			instanceDouble.build4Count(new SQLPopulation("sourceEntityName"));
		} catch (SystemException e) {
			instanceDouble = null;
		}
		assertNotNull(instanceDouble);
	}
	
	@Test
	public void test4build4CountLong() {
		try {
			instanceLong.build4Count(new SQLPopulation("sourceEntityName"));
		} catch (SystemException e) {
			instanceLong = null;
		}
		assertNotNull(instanceLong);
	}

	@Test
	public void test4build4CountString() {
		try {
			instanceString.build4Count(new SQLPopulation("sourceEntityName"));
		} catch (SystemException e) {
			instanceString = null;
		}
		assertNotNull(instanceString);
	}
	
	@Test
	public void test4build4CountTime() {
		try {
			instanceTime.build4Count(new SQLPopulation("sourceEntityName"));
		} catch (SystemException e) {
			instanceTime = null;
		}
		assertNotNull(instanceTime);
	}
	
	@Test
	public void test4build4CountTimestamp() {
		try {
			instanceTimestamp.build4Count(new SQLPopulation("sourceEntityName"));
		} catch (SystemException e) {
			instanceTimestamp = null;
		}
		assertNotNull(instanceTimestamp);
	}
	
	@Test
	public void test4getSingleResultBoolean() {
		assertNotNull(instanceBoolean.getSingleResult());
	}
	
	@Test
	public void test4getSingleResultDate() {
		assertNotNull(instanceDate.getSingleResult());
	}
	
	@Test
	public void test4getSingleResultDouble() {
		assertNotNull(instanceDouble.getSingleResult());
	}
	
	@Test
	public void test4getSingleResultLong() {
		assertNotNull(instanceLong.getSingleResult());
	}
	
	@Test
	public void test4getSingleResultString() {
		assertNotNull(instanceString.getSingleResult());
	}
	
	@Test
	public void test4getSingleResultTime() {
		assertNotNull(instanceTime.getSingleResult());
	}
	
	@Test
	public void test4getSingleResultTimestamp() {
		assertNotNull(instanceTimestamp.getSingleResult());
	}
	
	@Test
	public void test4executeBoolean() {
		assertEquals(0, instanceBoolean.execute().size());
	}
	
	@Test
	public void test4executeDate() {
		assertEquals(0, instanceDate.execute().size());
	}
	
	@Test
	public void test4executeDouble() {
		assertEquals(0, instanceDouble.execute().size());
	}
	
	@Test
	public void test4executeLong() {
		assertEquals(0, instanceLong.execute().size());
	}
	
	@Test
	public void test4executeString() {
		assertEquals(0, instanceString.execute().size());
	}
	
	@Test
	public void test4executeTime() {
		assertEquals(0, instanceTime.execute().size());
	}
	
	@Test
	public void test4executeTimestamp() {
		assertEquals(0, instanceTimestamp.execute().size());
	}
}
