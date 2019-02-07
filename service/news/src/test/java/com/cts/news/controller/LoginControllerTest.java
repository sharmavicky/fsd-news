package com.cts.news.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginControllerTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginControllerTest.class);
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void loginControllerTestForSuccess() throws Exception {
		LOGGER.info("Start: inside loginControllerTestForSuccess()");
		String TEST_DATA = "{\"email\":\"user@gmail.com\"" + "," + "\"password\":\"123456\"}";
		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/authenticate").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.authenticated").value(true));
		LOGGER.info("End: loginControllerTestForSuccess()");
	}

	@Test
	public void loginControllerTestForUnsuccessfullLogin() throws Exception {
		LOGGER.info("Start: inside loginControllerTestForUnsuccessfullLogin()");
		String TEST_DATA = "{\"email\":\"user@gmail.com\"" + "," + "\"password\":\"12345\"}";
		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/authenticate").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.authenticated").value(false));
		LOGGER.info("End: loginControllerTestForUnsuccessfullLogin()");
	}

	@Test
	public void loginControllerTestForNullEmail() throws Exception {
		LOGGER.info("Start: inside loginControllerTestForNullEmail()");
		String TEST_DATA = "{ \"password\":\"12345\"}";
		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/authenticate").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.authenticated").value(false));
		LOGGER.info("End: loginControllerTestForNullEmail()");
	}

	@Test
	public void loginControllerTestForNullPassword() throws Exception {

		LOGGER.info("Start: inside loginControllerTestForNullPassword()");
		String TEST_DATA = "{ \"email\":\"user@gmail.com\"}";
		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/authenticate").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.authenticated").value(false));
		LOGGER.info("End: loginControllerTestForNullPassword()");
	}
}
