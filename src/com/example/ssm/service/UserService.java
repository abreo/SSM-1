package com.example.ssm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ssm.dao.UserDao;
import com.example.ssm.entities.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public List<User> getAllUsers(int pageNum,int pageCount) {
		return userDao.getAllUsers(pageNum,pageCount);
	}
	
	public User login(String username,String password) {
		Map<String,String> map = new HashMap<>();
		map.put("username", username);
		map.put("password", password);
		return userDao.getUserByUsernameAndPassword(map);
	}
}
