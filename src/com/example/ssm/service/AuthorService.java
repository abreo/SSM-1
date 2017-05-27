package com.example.ssm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ssm.dao.AuthorDao;

@Service
public class AuthorService {

	@Autowired
	private AuthorDao authorDao;
	
	public Map<String,Object> getAuthorByPointMsg(String msg) {
		List<Map<String,Object>> maps = authorDao.getAuthorByPointMsg("%" + msg + "%");
		Map<String,Object> map = new HashMap<>();
		map.put("message", maps);
		return map;
	}
	
}
