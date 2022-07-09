package com.ctsproject.service;

import com.ctsproject.entity.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ctsproject.dao.*;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public User updateUser(Long id, User user) {
		User  u =userRepository.findById(id).get();

		u.setAuthStatus(user.getAuthStatus());	
		return userRepository.save(u);
	}
	
	@Override
	public User findUserByUserName(String name) {
		return userRepository.findUserByUserName(name);
	}

	@Override
	public String authen(String uName, String uPassword) {
		User u=userRepository.findUserByUserName(uName);
		String res="notok";
		if(u!=null) {
		String pass=u.getPassword();
		if(pass.equals(uPassword))
		res="ok";
		else 
	    res="notok";
		}
		System.out.println(res);
		return res;
	}
	
	@Override
	public User getVerifiedUser(String name,String password){
		User u=userRepository.findUserByUserName(name);
		return u;
	}
	
	@Override
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}

	@Override
	public User updateUserByName(String name, User user) {
		User u= userRepository.findUserByUserName(name);
		u.setAuthStatus("accepted");	
		return userRepository.save(u);
	}
	
	@Override
	public List<User> findByAuthStatusEqual(String auth){
		return userRepository.findByAuthStatusEquals(auth);
	}
	
	

}
