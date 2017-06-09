package com.example.ssm.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ssm.entities.Blog;
import com.example.ssm.inter.BlogMapper;

@Repository
public class BlogDao {

	@Autowired
	private BlogMapper blogMapper;
	
	public List<Blog> getBlogsByPage(Map<String,Integer> map) {
		return blogMapper.getBlogsByPage(map);
	}
	
}
