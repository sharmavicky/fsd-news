package com.cts.news.service;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cts.news.bean.SignupStatus;
import com.cts.news.bean.User;
import com.cts.news.repository.UserRepository;

public class SignupServiceMokitoTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(SignupServiceMokitoTest.class);

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private SignupService signupService;

	@Before
	public void setUp() throws Exception {
		// Create a user object which is to be tested
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void SuccessfullSignupTest(){
		LOGGER.info("Start");
		SignupStatus expectedStatus= new SignupStatus();
		expectedStatus.setSignupStatus(true);
		expectedStatus.setMessage("signup successfully");
		User user = new User();
		user.setEmail("sh@gmail.com");
		when(userRepository.findByEmail(user.getEmail())).thenReturn(null);
		when(userRepository.save(user)).thenReturn(user);
		SignupStatus actualStatus= signupService.saveUser(user);
		assertEquals(true, expectedStatus.equals(actualStatus));
		LOGGER.debug("actualStatus :{}", actualStatus);
		verify(userRepository, times(1)).save(user);
		verify(userRepository, times(1)).findByEmail(user.getEmail());
		LOGGER.info("End: SuccessfullSignupTest()");
		
	}
	
	@Test
	public void unSuccessfullSignupTest(){
		LOGGER.info("Start");
		SignupStatus expectedStatus= new SignupStatus();
		expectedStatus.setSignupStatus(false);
		expectedStatus.setMessage("Email Already Exist");
		User user = new User();
		user.setEmail("sh@gmail.com");
		when(userRepository.findByEmail(user.getEmail())).thenReturn(user);
		when(userRepository.save(user)).thenReturn(user);
		SignupStatus actualStatus= signupService.saveUser(user);
		assertEquals(true, expectedStatus.equals(actualStatus));
		LOGGER.debug("actualStatus :{}", actualStatus);
		verify(userRepository, times(0)).save(user);
		verify(userRepository, times(1)).findByEmail(user.getEmail());
		LOGGER.info("End: unSuccessfullSignupTest()");
		
	}
	
	
	
}
