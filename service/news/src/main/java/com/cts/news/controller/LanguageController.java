package com.cts.news.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.news.bean.Language;
import com.cts.news.service.LanguageService;

@RestController
public class LanguageController {
	private static final Logger LOGGER = LoggerFactory.getLogger(LanguageController.class);
	private LanguageService languageService;

	@Autowired
	public void setLanguageService(LanguageService languageService) {
		this.languageService = languageService;
	}

	@GetMapping("/list/languages")
	public List<Language> getLanguage() {
		LOGGER.info("Start");
		List<Language> languages = languageService.getLanguages();
		LOGGER.debug("language {}", languages);
		LOGGER.info("End");
		return languages;

	}
}
