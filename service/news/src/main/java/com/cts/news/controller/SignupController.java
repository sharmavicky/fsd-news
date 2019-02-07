package com.cts.news.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.news.bean.SignupStatus;
import com.cts.news.bean.User;
import com.cts.news.service.SignupService;

@RestController

public class SignupController extends NewsController {
	private static final Logger LOGGER = LoggerFactory.getLogger(SignupController.class);
	private SignupService signupService;

	@Autowired
	public void setSignupService(SignupService signupService) {
		this.signupService = signupService;
	}

	@PostMapping("/save")
	public SignupStatus save(@RequestBody User user) {
		LOGGER.info("Start");
		SignupStatus signupStatus = signupService.saveUser(user);
		LOGGER.info("End");
		return signupStatus;

	}

}
