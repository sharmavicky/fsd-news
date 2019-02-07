package com.cts.news.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.news.bean.Role;
import com.cts.news.bean.SignupStatus;
import com.cts.news.bean.User;
import com.cts.news.repository.UserRepository;

@Service
public class SignupService {
	private static final Logger LOGGER = LoggerFactory.getLogger(SignupService.class);
	private UserRepository userRepository;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional
	public SignupStatus saveUser(User user) {
		LOGGER.info("Start");
		SignupStatus signupStatus = new SignupStatus();
		signupStatus.setSignupStatus(false);

		User actualUser = userRepository.findByEmail(user.getEmail());
		if (actualUser == null) {
			Role role = new Role();
			role.setId(2);
			user.setRole(role);
			userRepository.save(user);
			signupStatus.setSignupStatus(true);
			signupStatus.setMessage("signup successfully");
		} else {
			signupStatus.setSignupStatus(false);
			signupStatus.setMessage("Email Already Exist");
		}
		return signupStatus;
	}

}
