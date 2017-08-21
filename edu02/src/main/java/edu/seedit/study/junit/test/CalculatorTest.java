package edu.seedit.study.junit.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import edu.seedit.study.junit.Calculator;
import edu.seedit.study.junit.test.CalculatorTest.TestExForMock2;

public class CalculatorTest {

	public class TestExForMock2 extends RuntimeException {

		private final int ERR_CODE;

		TestExForMock2(String msg, int errCode) {
			super(msg);
			ERR_CODE = errCode;
		}

		TestExForMock2(String msg) {
			this(msg, 100);
		}

		public int getErrCode() {
			return ERR_CODE;
		}

	}

	public class TestExForMock1 extends RuntimeException {
		private final int ERR_CODE;

		TestExForMock1(String msg, int errCode) {
			super(msg);
			ERR_CODE = errCode;
		}

		TestExForMock1(String msg) {
			this(msg, 100);
		}

		public int getErrCode() {
			return ERR_CODE;
		}
	}

	private static final int TIME_OUT_LIMIT = 500;

	private static final int FIBO_ARRAY_LIMIT_NO = 37;

	private final static Logger logger = Logger.getLogger(CalculatorTest.class);

	Calculator calculator;

	private int fiboArrayLimitNo;

	@BeforeClass
	public static void classSetUp() {
		logger.info("===JUNIT TEST START===");
	}

	@AfterClass
	public static void classTearDown() {
		logger.info("====JUNIT TEST END====");
	}

	@Before
	public void setUp() {
		logger.info("======unit test begin======");
		calculator = new Calculator();
		logger.info("constructor is reset");
	}

	@After
	public void tearDown() {
		logger.info("=======unit test end=======");
	}

	/**
	 * @Method Name : testSum
	 * @작성일 : 2017. 1. 3.
	 * @작성자 : 조용근
	 * @변경이력 :
	 * @Method 설명 :두 인수의 합 테스트
	 */
	@Test(timeout = TIME_OUT_LIMIT)
	public void testSum() {
		logger.info("METHOD : SUM");
		int num1 = 10;
		int num2 = 20;
		assertEquals(30, calculator.sum(num1, num2));
		logger.info("SUM 1st arg : " + num1 + ", 2nd arg : " + num2);
		logger.info("SUM result : " + calculator.sum(num1, num2));
	}

	/**
	 * @Method Name : testFibo
	 * @작성일 : 2017. 1. 3.
	 * @작성자 : 조용근
	 * @변경이력 :
	 * @Method 설명 : 피보나치 수열 테스트
	 */
	@Test(timeout = TIME_OUT_LIMIT)
	public void testFibo() {
		logger.info("METHOD : FIBO");

		fiboArrayLimitNo = FIBO_ARRAY_LIMIT_NO;
		for (int fiboIndexNo = 1; fiboIndexNo <= fiboArrayLimitNo; fiboIndexNo++) {
			String fiboIndexNoForLog = "";
			if (fiboIndexNo < 10) {
				fiboIndexNoForLog = "00" + fiboIndexNo;
			} else if (fiboIndexNo < 100) {
				fiboIndexNoForLog = "0" + fiboIndexNo;
			}
			logger.info("fiboIndexNo [" + fiboIndexNoForLog + "] : " + calculator.fibo(fiboIndexNo));
		}
		assertEquals(89, calculator.fibo(11));
		assertEquals(1, calculator.fibo(2));
		assertEquals(calculator.fibo(1) + calculator.fibo(2), calculator.fibo(3));
		assertEquals(calculator.fibo(2) + calculator.fibo(3), calculator.fibo(4));
		assertEquals(55, calculator.fibo(10));
	}

	/**
	 * @Method Name : whenThenthrowtest
	 * @작성일 : 2017. 4. 17.
	 * @작성자 : 조용근
	 * @변경이력 :
	 * @Method 설명 : 목을 이용한 예외처리 테스트
	 */
	@Test(expected = TestExForMock1.class)
	public void whenThenthrowtest() {
		@SuppressWarnings("unchecked")
		Map<String, String> testMock = mock(Map.class);

		when(testMock.get("exParam1")).thenThrow(new TestExForMock1("MOCK1 TEST ERROR"));
		when(testMock.get("exParam2")).thenThrow(new TestExForMock2("MOCK2 TEST ERROR"));
		assertThat(testMock.get("exParam1"), is(TestExForMock1.class));
	}

	/**
	 * @Method Name : whenThenAnswerTest
	 * @작성일 : 2017. 4. 17.
	 * @작성자 : 조용근
	 * @변경이력 :
	 * @Method 설명 : 목을 이용한 모조 다오 생성 테스트
	 */
	@Test
	public void whenThenAnswerTest() {
		UserDAO userDAO = mock(UserDAO.class);

		when(userDAO.getUser("jyk")).thenAnswer(new Answer<User>() {
			@Override
			public User answer(InvocationOnMock invocation) throws Throwable {
				User user = new User();
				user.setUserId("jyk");
				user.setName("조용근");
				user.setAge(36);
				return user;
			}
		});

		User user = userDAO.getUser("jyk");
		assertThat("jyk", is(user.getUserId()));
		assertThat("조용근", is(user.getName()));
		assertThat(36, is(user.getAge()));
	}
}

class UserDAO {
	public User getUser(String userId) {
		return new User();
	}

	public List<User> getUsers() {
		List<User> user = null;
		return user;
	}
}

class User {
	private String userId;
	private String name;
	private int age;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
