package com.cts.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.news.bean.Article;

@Repository
public interface ArticleRepository  extends JpaRepository<Article , Integer>{

	Article findBytitle(String title);
	
	

}
