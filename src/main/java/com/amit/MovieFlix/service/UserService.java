package com.amit.MovieFlix.service;

import java.util.List;

import com.amit.MovieFlix.entity.User;

public interface UserService {
	
	public List<User> findAll();
	public User create(User user);
	public User findOne(String id);
	public User update(String id, User user);
	public void delete(String id);
	public boolean login(String email, String password);

}
