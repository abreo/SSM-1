package com.example.ssm.inter;

import java.util.List;
import java.util.Map;

import com.example.ssm.entities.User;

public interface UserMapper {

	List<User> getAllUsers(Map<String,Integer> map);
	
	public User getUserByUsernameAndPassword(Map<String,String> map);

}
