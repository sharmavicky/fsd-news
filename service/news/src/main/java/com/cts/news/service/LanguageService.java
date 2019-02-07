package com.cts.news.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.news.bean.Language;
import com.cts.news.repository.LanguageRepository;

@Service
public class LanguageService {
	private static final Logger LOGGER = LoggerFactory.getLogger(LanguageService.class);
	private LanguageRepository LanguageRepository;

	@Autowired
	public void setLanguageRepository(LanguageRepository languageRepository) {
		LanguageRepository = languageRepository;
	}

	public List<Language> getLanguages() {
		LOGGER.info("Start");
		List<Language> languages = LanguageRepository.findAll();
		LOGGER.debug("languages{}", languages);
		LOGGER.info("End");
		return languages;

	}

}
