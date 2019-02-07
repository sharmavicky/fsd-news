package com.cts.news.service;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cts.news.repository.ArticleRepository;

public class ArticleServiceMokitoTest{

	@Mock
	private  ArticleRepository articleRepository;

	@InjectMocks
	private ArticleService articleService;
	
	
	@Before
	public void setUp() throws Exception {
		// Create a user object which is to be tested
		MockitoAnnotations.initMocks(this);
	}

	/*public void successfullysaveArticleTest(){
		
		
		
	}*/
}
