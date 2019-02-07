package com.cts.news.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
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
public class SignupControllerTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(SignupControllerTest.class);
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void signupControllerTest() throws Exception {

		LOGGER.info("Start: inside signupControllerTest()");
		String TEST_DATA = "{\"name\":\"user\"" + "," + "\"language\":{\"id\":\"1\"}" + "," + "\"role\":{\"id\":\"2\"}"
				+ "," + "\"email\":\"use@gmail.com\"" + "," + "\"password\":\"password\"}";
		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/save").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.signupStatus").value(true))
				.andExpect(jsonPath("$.message").value("signup successfully"));

		LOGGER.info("End: signupControllerTest()");
	}

	@Test
	public void signupControllerTestrForNullObject() throws Exception {

		LOGGER.info("Start: inside signupControllerTestrForNullObject()");
		String TEST_DATA = "{}";
		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/save").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError()).andExpect(jsonPath("$.errorMessage").isNotEmpty());
		LOGGER.info("End: signupControllerTestForNullObject()");
	}

	@Test
	public void signupControllerTestForPreExistingEmailId() throws Exception {
		LOGGER.info("Start: inside signupControllerTestForPreExistingEmailId()");
		String TEST_DATA = "{\"name\":\"Vishal\"" + "," + "\"language\":{\"id\":\"1\"}" + ","
				+ "\"role\":{\"id\":\"2\"}" + "," + "\"email\":\"user@gmail.com\"" + "," + "\"password\":\"password\"}";
		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/save").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.message").value("Email Already Exist"));
		LOGGER.info("End: signupControllerTestForPreExistingEmailId()");
	}

	@Test
	public void signupControllerTestForNullName() throws Exception {

		LOGGER.info("Start: inside signupControllerTestrForNullName()");

		String TEST_DATA = "{\"password\":\"vishaln\"" + "," + "\"language\":{\"id\":\"1\"}" + ","
				+ "\"role\":{\"id\":\"2\"}" + "," + "\"email\":\"user1@gmail.com\"}";
		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/save").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.errorMessage").value("Invalid input format: User Name cannot be empty"));
		;
		LOGGER.info("End: signupControllerTestForNullName()");
	}

	@Test
	public void signupControllerTestForNullPassword() throws Exception {

		LOGGER.info("Start: inside signupControllerTestForNullPassword()");
		String TEST_DATA = "{\"name\":\"vishal\"" + "," + "\"language\":{\"id\":\"1\"}" + ","
				+ "\"role\":{\"id\":\"2\"}" + "," + "\"email\":\"user2@gmail.com\"}";

		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/save").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.errorMessage").value("Invalid input format: Password cannot be empty"));

		LOGGER.info("End: signupControllerTestForNullPassword()");
	}

	@Test
	public void signupControllerTestForNullEmail() throws Exception {

		LOGGER.info("Start: inside signupControllerTestForNullEmail()");
		String TEST_DATA = "{\"name\":\"vishal\"" + "," + "\"language\":{\"id\":\"1\"}" + ","
				+ "\"role\":{\"id\":\"2\"}" + "," + "\"password\":\"password\"}";
		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/save").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.errorMessage").value("Invalid input format: Email cannot be empty"));
		;
		LOGGER.info("End: signupControllerTestForNullEmail()");
	}

	@Test
	public void signupControllerTestInvalidPasswordFormat() throws Exception {

		LOGGER.info("Start: inside signupControllerTestForNullPassword()");

		String TEST_DATA = "{\"name\":\"Vishal\"" + "," + "\"language\":{\"id\":\"1\"}" + ","
				+ "\"role\":{\"id\":\"2\"}" + "," + "\"email\":\"user3@gmail.com\"" + "," + "\"password\":\"1\"}";

		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/save").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError()).andExpect(
						jsonPath("$.errorMessage").value("Invalid input format: Password must be 6 to 50 characters"));
		;
		LOGGER.info("End: signupControllerTestForPasswordSize()");
	}

	@Test
	public void signupControllerTestForInvalidNameFormat() throws Exception {

		LOGGER.info("Start: inside testUserControllerForNameSize()");

		String TEST_DATA = "{\"name\":\"Vishalgfhdsughudshgfuhsdihwghjdghjdgjnjdgdggruihsjfnsifhisofiosjafiosafjiosajfisojfisoafjisoafjisofjisfisjfiosjfisfnisjfiosfjisofjsfmnisjfisojfisfisjfiosjfiosjfskfisojfisojfisnfiosjfisjfisofisjfisojf\""
				+ "," + "\"language\":{\"id\":\"1\"}" + "," + "\"role\":{\"id\":\"2\"}" + ","
				+ "\"email\":\"user4@gmail.com\"" + "," + "\"password\":\"password\"}";
		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/save").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError()).andExpect(
						jsonPath("$.errorMessage").value("Invalid input format: Name must not exceed 70 characters"));
		LOGGER.info("End: signupControllerTestForNameSize()");
	}

	@Test
	public void testUserControllerInvalidEmailFormat() throws Exception {

		LOGGER.info("Start: inside signupControllerTestForEmailSize()");
		String TEST_DATA = "{\"name\":\"Vishalg\"" + "," + "\"language\":{\"id\":\"1\"}" + ","
				+ "\"role\":{\"id\":\"2\"}" + ","
				+ "\"email\":\"vgfysygfsyhgfyshgfyusgfhxzbcshgfyudsadcgfhfxchfgyugfyusgfhfhfhbcbdgdgfszfszfszdfdgxdgdzfszffsbcdzhjbsfyusgfuysgfusfjzhbchjbsfsfhsufhjncisfosjckzmdfijsfisdjfiodgfodjgidjgidjihdgfihdgihdfvndiisojdsfuihsdguindksnfiosiofnksfyusgfyusfbcshbcsybfyusfbyusbchzbcshyfbyusfbyusfbcshbcfbcyusfbgyusfbyusfyusfscbshfbsyfysfsbsfbsfbyuffbsfyufsfbzhfbsfyusfzhbfuszfuyfzfbgddghudghudghudhgusfhjnhjnbh@gmail.com\""
				+ "," + "\"password\":\"password\"}";

		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/save").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError()).andExpect(
						jsonPath("$.errorMessage").value("Invalid input format: Email must not exceed 255 characters"));
		LOGGER.info("End: signupControllerTestForEmailSize()");
	}

	@Test
	public void signupControllerTestForEmailPattern() throws Exception {

		LOGGER.info("Start: inside testUserControllerForEmailPattern()");
		String TEST_DATA = "{\"name\":\"Vishalg\"" + "," + "\"language\":{\"id\":\"1\"}" + ","
				+ "\"role\":{\"id\":\"2\"}" + "," + "\"email\":\"usergmail\"" + "," + "\"password\":\"password\"}";
		LOGGER.debug("test data:{}", TEST_DATA);
		mockMvc.perform(post("/save").content(TEST_DATA).contentType("application/json;charset=UTF-8"))
				.andExpect(status().is4xxClientError())
				.andExpect(jsonPath("$.errorMessage").value("Invalid input format: Email address is invalid"));
		LOGGER.info("End: signupControllerTestForEmailPattern()");
	}

}
