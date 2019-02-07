package com.cts.news.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.news.bean.User;
import com.cts.news.controller.SignupController;
import com.cts.news.repository.UserRepository;

@Service
public class LoginService {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginService.class);

	private UserRepository UserRepository;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		UserRepository = userRepository;
	}

	@Transactional
	public User getUser(String email) {
		LOGGER.info("Start");
		LOGGER.debug("email {}", email);
		LOGGER.info("End");
		return UserRepository.findByEmail(email);

	}

}
