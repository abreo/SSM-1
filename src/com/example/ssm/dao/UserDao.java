package com.example.ssm.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ssm.entities.User;
import com.example.ssm.inter.UserMapper;

@Repository
public class UserDao {

	@Autowired
	private UserMapper userMapper;
	
	public List<User> getAllUsers(int pageNum,int pageCount) {
		Map<String,Integer> map = new HashMap<>();
		map.put("pageNum", pageNum);
		map.put("pageCount", pageCount);
		return userMapper.getAllUsers(map);
	}
	public User getUserByUsernameAndPassword(Map<String,String> map) {
		return userMapper.getUserByUsernameAndPassword(map);
	}

}
