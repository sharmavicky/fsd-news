package com.cts.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.news.bean.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {

}
