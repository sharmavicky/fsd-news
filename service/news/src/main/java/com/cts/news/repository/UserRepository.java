package com.cts.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.news.bean.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findById(int id);

	public User findByEmail(String email);

}
