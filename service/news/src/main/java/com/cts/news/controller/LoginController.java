package com.cts.news.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.news.bean.AuthenticationStatus;
import com.cts.news.bean.User;
import com.cts.news.jwt.security.JwtGenerator;
import com.cts.news.service.LoginService;

@RestController
public class LoginController {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	private LoginService loginService;
	
	@Autowired
	private JwtGenerator jwtGenerator;

	@Autowired
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationStatus> authenticate(@RequestBody User user) {
		LOGGER.info("Start");
		LOGGER.debug("User :{}", user);
		AuthenticationStatus status = new AuthenticationStatus();
		status.setAuthenticated(false);
		status.setAdmin(false);
		LOGGER.debug("status :{}", status);
		String email = user.getEmail();
		String password = user.getPassword();
		User actualUser = loginService.getUser(email);
		System.out.println(actualUser);
		LOGGER.debug("actualUser :{}", actualUser);

		if (actualUser != null) {
			String actualPassword = actualUser.getPassword();
			LOGGER.debug("actualPassword :{}", actualPassword);
			if (email.equals("admin") && password.equals(actualPassword)) {
				status.setUser(actualUser);
				status.setAdmin(true);
				status.setAuthenticated(true);
				status.setToken(jwtGenerator.generate(actualUser));
			} else {
				status.setUser(actualUser);
				String actualEmail = user.getEmail();
				status.setAuthenticated(actualEmail.equals(email));
				status.setAuthenticated(actualPassword.equals(password));
				status.setToken(jwtGenerator.generate(actualUser));
			}
			status.setMessage("Login Successfull");

		}

		if (actualUser == null) {
			status.setMessage("Invalid user name and password");

		}

		LOGGER.debug("status: {}", status);
		LOGGER.info("End");

		return new ResponseEntity<AuthenticationStatus>(status, HttpStatus.OK);

	}

}
