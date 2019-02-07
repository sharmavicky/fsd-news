package com.cts.news.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cts.news.bean.User;
import com.cts.news.repository.UserRepository;

public class UserServiceMokitoTest {
	
	
	@Mock
	private UserRepository userRepository;
	
	@InjectMocks
	private UserService userService;
	@Before
	public void setUp() throws Exception {
		// Create a user object which is to be tested
		MockitoAnnotations.initMocks(this);
	}

	/*@Test
	public void changeStatusTest(){
		
		User user=new User();
		user.setEmail("user@gmail.com");
		user.setBlacklist(true);
		when(userService.changeStatus(user.getEmail())).thenReturn(user);
		verify(userRepository, times(1)).findByEmail(user.getEmail());
		verify(userService, times(1)).changeStatus(user.getEmail());
		
	}*/
	

}
