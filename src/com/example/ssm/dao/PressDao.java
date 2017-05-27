package com.example.ssm.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ssm.inter.PressMapper;

@Repository
public class PressDao {

	@Autowired
	private PressMapper pressMapper;
	
	public List<Map<String,Object>> getPressesByPointMsg(String msg) {
		return pressMapper.getPressesByPointMsg(msg);
	}
}
