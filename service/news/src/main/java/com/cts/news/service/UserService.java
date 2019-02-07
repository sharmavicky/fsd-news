package com.cts.news.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.news.bean.User;
import com.cts.news.repository.UserRepository;

@Service
public class UserService {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	private UserRepository UserRepository;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		UserRepository = userRepository;
	}

	@Transactional
	public User getUser(String email) {
		LOGGER.info("Start");
		LOGGER.info("End");
		User user = UserRepository.findByEmail(email);
		LOGGER.debug("email {}", user);
		if (user.getRole().getId() == 2) {
			return user;
		} else {
			return null;
		}

	}

	@Transactional
	public User changeStatus(String email) {
		LOGGER.info("Start");
		User user = UserRepository.findByEmail(email);
		if (user.isBlacklist()) {
			user.setBlacklist(false);
		
		} else {
			user.setBlacklist(true);
		}
		LOGGER.debug("email {}", email);
		LOGGER.info("End");
		return user;
	}
}
