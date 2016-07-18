package com.amit.MovieFlix.repository;

import java.util.List;

import com.amit.MovieFlix.entity.User;

public interface UserRepository {
	
	public List<User> findAll();
	public User findOne(String id);
	public User findByEmail(String email);
	public User create(User user);
	public User update(User user);
	public void delete(User user);
}
