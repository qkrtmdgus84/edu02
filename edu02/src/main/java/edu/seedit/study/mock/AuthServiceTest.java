package edu.seedit.study.mock;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import edu.seedit.study.mock.AuthServiceTest.User;

public class AuthServiceTest {
	private static final String NO_USER_ID = "noUserId";
	private static final String USER_PASSWORD = "userPassword";

	public class User {
	}

	public class NonExistingUserException extends RuntimeException {
	}

	private AuthService authService;

	public class AuthService {

		public void authenticate(String id, String password) {
			if (id == null || id.isEmpty()) {
				throw new IllegalArgumentException();
			}
			if (password == null || password.isEmpty()) {
				throw new IllegalArgumentException();
			}
			User user = findUserById(id);
			if (user == null) {
				throw new NonExistingUserException();
			}
		}

		private User findUserById(String id) {
			return null;
		}

	}

	@Test
	public void whenUserNotFound_throwNonExistingUserEx() {
		assertExceptionThrown(NO_USER_ID, USER_PASSWORD, NonExistingUserException.class);
		for (int ids = 0; ids < 100; ids++) {
			assertExceptionThrown(NO_USER_ID + ids, USER_PASSWORD, NonExistingUserException.class);
		}
	}

	private void assertExceptionThrown(String id, String userPassword, Class<? extends Exception> type) {
		Exception thrownEx = null;
		try {
			authService.authenticate(id, userPassword);
		} catch (Exception e) {
			thrownEx = e;
		}
		assertThat(thrownEx, instanceOf(type));
	}

	@Test
	public void givenInvalidId() throws IllegalArgumentException {
		assertIllegalArgExThrown(null, USER_PASSWORD);
		assertIllegalArgExThrown("", USER_PASSWORD);
		assertIllegalArgExThrown("userId", null);
		assertIllegalArgExThrown("userId", "");
	}

	private void assertIllegalArgExThrown(String id, String password) {
		assertExceptionThrown(id, password, IllegalArgumentException.class);
	}

	@Before
	public void setUp() {
		authService = new AuthService();
	}

}
