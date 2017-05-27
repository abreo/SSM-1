package com.example.ssm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ssm.dao.PressDao;

@Service
public class PressService {

	@Autowired
	private PressDao pressDao;
	
	
	public Map<String,Object> getPressesByPointMsg(String msg) {
		List<Map<String,Object>> maps = pressDao.getPressesByPointMsg("%" + msg + "%");
		Map<String,Object> map = new HashMap<>();
		map.put("message", maps);
		return map;
	}
	
}
