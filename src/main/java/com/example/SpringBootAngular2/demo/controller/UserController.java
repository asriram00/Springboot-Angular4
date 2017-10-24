package com.example.SpringBootAngular2.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootAngular2.demo.domain.UserDomain;
import com.example.SpringBootAngular2.demo.service.UserService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/users")
	public List<UserDomain> showallUser() {
		//ArrayList<UserDomain> userList =  new ArrayList<UserDomain>();
		return userService.showAllList();
	}
	
	@RequestMapping(value="/user/{id}")
	public UserDomain getUser(@PathVariable("id") int id ) {
		//ArrayList<UserDomain> userList =  new ArrayList<UserDomain>();
		
		return userService.getUser(id);
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/register")
	public List<UserDomain> addUser(@RequestBody UserDomain user ) {
		//ArrayList<UserDomain> userList =  new ArrayList<UserDomain>();
		System.out.println("Hello user--------->"+ user);
		return userService.addUser(user);
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/login")
	public Object loginUser(@RequestBody UserDomain user) {
		//ArrayList<UserDomain> userList =  new ArrayList<UserDomain>();
		System.out.println("Hello user--------->"+ user.getName());
		return userService.loginUser(user);
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/logout")
	public String logoutUser() {
		
		
		return "Logged out";
		
	}
	
}
