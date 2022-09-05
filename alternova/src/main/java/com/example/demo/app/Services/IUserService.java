package com.example.demo.app.Services;

import java.util.List;

import com.example.demo.app.Entity.Jokes;
import com.example.demo.app.Entity.User;

public interface IUserService {

	public List<User> listUsers();

	public User findOne(Long id);
	public void save(User user);
	public void delete(Long id);
	
	public User findbyname(String name);
}
