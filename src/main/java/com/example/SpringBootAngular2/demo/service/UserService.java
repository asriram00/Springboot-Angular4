package com.example.SpringBootAngular2.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootAngular2.demo.domain.UserDomain;
import com.example.SpringBootAngular2.demo.repo.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	List<UserDomain> userList = new ArrayList<UserDomain>();
	
	UserDomain userObj = new UserDomain();
	

	public List<UserDomain> showAllList() {
		userList = new ArrayList<UserDomain>();
		userRepository.findAll().forEach(userList :: add);
		return userList;
	}
	
	public UserDomain getUser(int id) {
		userObj = new UserDomain();
		userObj = userRepository.findOne((long) id);
		return userObj;
	}
	
	public List<UserDomain> addUser(UserDomain user) {
		userList = new ArrayList<UserDomain>();
		System.out.println(user);
		userRepository.save(user);
		userRepository.findAll().forEach(userList :: add);
		return userList;
	}
	
	public List<UserDomain> updated(int id, String name, String comment, String password) {
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
		userList = new ArrayList<UserDomain>();
		userRepository.delete((long) id);
		userRepository.findAll().forEach(userList :: add);
		return userList;
	}
	
	public Object loginUser(UserDomain user) {
		userObj = new UserDomain();
		userObj = userRepository.findByName(user.getName());
		System.out.println(userObj.getName()+""+userObj.getPassword());
		if(userObj.getPassword().equals(user.getPassword()))return userObj;
		else return "Failed Login";
	}
	
	public UserDomain getUserByName(String name) {
		userObj = new UserDomain();
		userObj = userRepository.findByName(name);
		return userObj;
	}
}
