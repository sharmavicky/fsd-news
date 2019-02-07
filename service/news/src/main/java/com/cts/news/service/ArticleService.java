package com.cts.news.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.news.bean.Article;
import com.cts.news.bean.User;
import com.cts.news.repository.ArticleRepository;
import com.cts.news.repository.UserRepository;

@Service
public class ArticleService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ArticleService.class);

	private ArticleRepository articleRepository;

	@Autowired
	public void setArticleRepository(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}

	/*
	 * @Transactional public void saveArticle(Article article) {
	 * LOGGER.info("Start"); LOGGER.debug("saveArticle {}", article);
	 * articleRepository.save(article);
	 * 
	 * LOGGER.info("End");
	 * 
	 * }
	 */
	private UserRepository userRepository;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional
	public void saveArticle(User user) {
		LOGGER.info("Start");
		Article article = user.getArticle().get(0);
		String title = article.getTitle();
		Article actualArticle = articleRepository.findBytitle(title);
		LOGGER.debug("article  {}", article);
		User actualUser = userRepository.findById(user.getId());
		if (actualArticle == null) {
			actualArticle = articleRepository.save(article);

		}
		LOGGER.debug("id {}", actualArticle.getId());
		LOGGER.debug("article  {}", article);
		if (actualArticle.getId() != 0) {
			LOGGER.debug("users fav article  {}", actualUser.getArticle());
			// actualUser.getArticle().add(actualArticle);
			List<Article> articles = actualUser.getArticle();
			for (Article article1 : articles) {
				if (article1.getId() == actualArticle.getId()) {
					articles.remove(article1);
				}
			}
			actualUser.getArticle().add(actualArticle);
			userRepository.save(actualUser);

		} /*
			 * else { LOGGER.debug("users fav article  {}",
			 * actualUser.getArticle()); actualUser.getArticle().add(article);
			 * userRepository.save(actualUser); }
			 */

		LOGGER.info("End");
	}

	@Transactional
	public User getUser(int id) {
		return userRepository.findById(id);

	}

	public void deleteArticle(User user) {
		LOGGER.info("Start");
		User actualUser = userRepository.findById(user.getId());
		String title1 = user.getArticle().get(0).getTitle();
		LOGGER.debug(title1);
		List<Article> articles = actualUser.getArticle();

		for (int i = 0; i < articles.size(); i++) {
			if (articles.get(i).getTitle().equals(title1)) {
				articles.remove(articles.get(i));
				actualUser.setArticle(articles);
			}
		}
		LOGGER.info("End");
		userRepository.save(actualUser);

	}
}
