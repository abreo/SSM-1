package com.example.ssm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ssm.dao.UserDao;
import com.example.ssm.entities.User;
import com.example.ssm.util.PageList;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public PageList<User> getAllUsers(int pageNum,int pageCount) {
		List<User> users =  userDao.getAllUsers((pageNum-1)*pageCount,pageCount);
		PageList<User> pageList = new PageList<>();
		pageList.setMaxCount(userDao.getUserCount());
		pageList.setPageNum(pageNum);
		pageList.setObjs(users);
		return pageList;
	}
	
	public User login(String username,String password) {
		Map<String,String> map = new HashMap<>();
		map.put("username", username);
		map.put("password", password);
		return userDao.getUserByUsernameAndPassword(map);
	}
}
