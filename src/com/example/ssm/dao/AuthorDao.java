package com.example.ssm.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ssm.inter.AuthorMapper;

@Repository
public class AuthorDao {

	@Autowired
	private AuthorMapper authorMapper;
	
	public List<Map<String,Object>> getAuthorByPointMsg(String msg) {
		return authorMapper.getAuthorByPointMsg(msg); 
		
	}
	
}
