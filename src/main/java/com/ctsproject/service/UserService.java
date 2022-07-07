package com.ctsproject.service;

import java.util.List;

import com.ctsproject.entity.User;


public interface UserService {
	public User saveUser(User user);
	public User updateUser(Long id,User user);
	public User findUserByUserName(String name);
	public String authen(String uName,String uPassword);
	public User getVerifiedUser(String name,String password);
	public List<User> getAllUsers();
	public User updateUserByName(String name,User user);
	public List<User> findByAuthStatusEqual(String auth); 
}
