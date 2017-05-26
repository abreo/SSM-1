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
	
	/**
	 * 分页获取所有用户
	 * @param pageNum
	 * @param pageCount
	 * @return
	 */
	public List<User> getAllUsers(int pageNum,int pageCount) {
		Map<String,Integer> map = new HashMap<>();
		map.put("pageNum", pageNum);
		map.put("pageCount", pageCount);
		return userMapper.getAllUsers(map);
	}
	
	/**
	 * 登录通过用户名密码获取用户信息
	 * @param map
	 * @return
	 */
	public User getUserByUsernameAndPassword(Map<String,String> map) {
		return userMapper.getUserByUsernameAndPassword(map);
	}
	
	/**
	 * 获取用户数量
	 * @return
	 */
	public int getUserCount() {
		return userMapper.getUserCount();
	}

}
