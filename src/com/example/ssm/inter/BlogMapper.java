package com.example.ssm.inter;

import java.util.List;
import java.util.Map;

import com.example.ssm.entities.Blog;

public interface BlogMapper {

	List<Blog> getBlogsByPage(Map<String,Integer> map);
	
}
