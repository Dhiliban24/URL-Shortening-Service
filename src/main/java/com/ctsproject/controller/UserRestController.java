package com.ctsproject.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.ctsproject.entity.User;
import com.ctsproject.service.UserService;

@RestController
@RequestMapping("/url")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class UserRestController {
	
	@Autowired
	UserService userService;

	@GetMapping("/")
	public String msg() 
	{
		return "url Shortner";
	}
	
	@PostMapping("/adduser")
	public User saveEmp(@RequestBody User user) {
		System.out.println(user);
		return userService.saveUser(user);
	}
	
	@PutMapping("/updateUserById")
	public User updateUser(@RequestBody User user)
	{
		return userService.updateUser(user.getId(),user);
		
	}
	
	@PostMapping("/validateuser")
	public ResponseEntity<String> getUser(@RequestBody User user) {
	System.out.println(user);
	String result=userService.authen(user.getUserName(), user.getPassword());
	return new ResponseEntity<>(result,HttpStatus.OK);
		//return userService.saveUser(user);
	}
	
	@GetMapping("/validateveruser")
	public User getVerUser(@RequestBody User user) {
	System.out.println(user);
	User us=userService.findUserByUserName(user.getUserName());
	return us;
	}
	
	@GetMapping("/getallusers")
	public List<User> getUsers(){
		return userService.findByAuthStatusEqual("Notaccepted");
	}
	
	@PutMapping("/updateUserByName")
	public User updateUserUsingName(@RequestBody User user)
	{
		return userService.updateUserByName(user.getUserName(),user);
		
	}
	
	
}
