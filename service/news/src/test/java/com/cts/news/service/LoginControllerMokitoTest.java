package com.cts.news.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.news.bean.AuthenticationStatus;
import com.cts.news.bean.User;
import com.cts.news.controller.LoginController;

public class LoginControllerMokitoTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginControllerMokitoTest.class);

	// private UserRepository userRepository;

	@Mock
	private LoginService loginService;
	@InjectMocks
	private LoginController loginController;

	@Before
	public void setUp() throws Exception {
		// Create a user object which is to be tested
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void successfullyLogin() {
		LOGGER.info("Start");
		User user = new User();
		user.setEmail("user");
		user.setPassword("123456");
		when(loginService.getUser(user.getEmail())).thenReturn(user);
		AuthenticationStatus status = loginController.authenticate(user).getBody();
		LOGGER.debug("status{}", status);
		assertEquals(true, status.isAuthenticated());
		LOGGER.info("End");

	}

	@Test
	public void unsuccessfullyLoginForNullEmail() {
		LOGGER.info("Start");
		User user = new User();
		user.setPassword("123456");
		when(loginService.getUser(user.getEmail())).thenReturn(null);
		AuthenticationStatus status = loginController.authenticate(user).getBody();
		LOGGER.debug("status{}", status);
		assertEquals(true, status.isAuthenticated() == false);
		LOGGER.info("End");

	}

	@Test
	public void unsuccessfullyLoginForNullPassword() {
		LOGGER.info("Start");
		User user = new User();
		user.setEmail("user");
		User actualUser = new User();
		actualUser.setEmail("vishal");
		actualUser.setPassword("password");
		when(loginService.getUser(user.getEmail())).thenReturn(actualUser);
		AuthenticationStatus status = loginController.authenticate(user).getBody();
		LOGGER.debug("status{}", status);
		;
		assertEquals(true, status.isAuthenticated() == false);
		LOGGER.info("End");

	}

}
