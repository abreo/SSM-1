package com.example.ssm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ssm.dao.BlogDao;
import com.example.ssm.entities.Blog;
import com.example.ssm.util.PageList;

@Service
public class BlogService {

	@Autowired
	private BlogDao blogDao;
	
	public PageList<Blog> getBlogs(int pageNum,int pageCount) {
		PageList<Blog> pageList = new PageList<>();
		pageList.setMaxCount(20);
		pageList.setRowCount(5);
		pageList.setPageNum(pageNum);
		Map<String,Integer> map = new HashMap<>();
		map.put("pageNum", (pageNum-1)*pageCount);
		map.put("pageCount", pageCount);
		List<Blog> blogs = blogDao.getBlogsByPage(map);
		pageList.setObjs(blogs);
		return pageList;
	}
}
