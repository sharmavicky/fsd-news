package com.cts.news.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cts.news.bean.User;
import com.cts.news.service.UserService;

@RestController
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/users/{email}")
	public User getUser(@PathVariable("email") String email) {
		LOGGER.info("Start");
		LOGGER.debug("email {}", email);
		LOGGER.info("End");
		return userService.getUser(email);

	}

	@GetMapping("/change/{email}")
	public User changeStatus(@PathVariable("email") String email) {
		LOGGER.info("Start");
		LOGGER.debug("email {}", email);
		LOGGER.info("End");
		return userService.changeStatus(email);

	}
}
