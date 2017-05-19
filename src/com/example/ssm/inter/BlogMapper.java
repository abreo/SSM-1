package com.example.ssm.inter;

import java.util.List;

import com.example.ssm.entities.Blog;

public interface BlogMapper {

	List<Blog> getAllBlogs(int pageNum , int rowCount);
	
}
