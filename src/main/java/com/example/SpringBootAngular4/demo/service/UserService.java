package com.example.SpringBootAngular4.demo.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootAngular4.demo.domain.UserDomain;
import com.example.SpringBootAngular4.demo.repo.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<UserDomain> showAllList() {
		List<UserDomain> userList = new ArrayList<UserDomain>();
		userList = new ArrayList<UserDomain>();
		userRepository.findAll().forEach(userList :: add);
		return userList;
	}
	
	public UserDomain getUser(int id) {
		UserDomain userObj = new UserDomain();
		userObj = new UserDomain();
		userObj = userRepository.findOne((long) id);
		return userObj;
	}
	
	public List<UserDomain> addUser(UserDomain user) {
		List<UserDomain> userList = new ArrayList<UserDomain>();
		userList = new ArrayList<UserDomain>();
		System.out.println(user);
		userRepository.save(user);
		userRepository.findAll().forEach(userList :: add);
		return userList;
	}
	
	public List<UserDomain> updated(int id, String name, String comment, String password) {
		List<UserDomain> userList = new ArrayList<UserDomain>();
		UserDomain userObj = new UserDomain();
		userList = new ArrayList<UserDomain>();
		userObj = new UserDomain();
		userObj.setId(id);
		userObj.setName(name);
		userObj.setComment(comment);
		userObj.setPassword(password);
		userRepository.save(userObj);
		userRepository.findAll().forEach(userList :: add);
		return userList;
	}
	
	public List<UserDomain> deleteUser(int id) {
		List<UserDomain> userList = new ArrayList<UserDomain>();
		userList = new ArrayList<UserDomain>();
		userRepository.delete((long) id);
		userRepository.findAll().forEach(userList :: add);
		return userList;
	}
	
	public Object loginUser(UserDomain user) {
		UserDomain userObj = new UserDomain();
		userObj = new UserDomain();
		userObj = userRepository.findByName(user.getName());
		if(userObj.getPassword().equals(user.getPassword()))return userObj;
		else return "Failed Login";
	}
	
	public UserDomain getUserByName(String name) {
		UserDomain userObj = new UserDomain();
		userObj = new UserDomain();
		userObj = userRepository.findByName(name);
		return userObj;
	}
}
