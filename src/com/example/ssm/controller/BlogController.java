package com.example.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.ssm.entities.Blog;
import com.example.ssm.service.BlogService;
import com.example.ssm.util.PageList;
import com.example.ssm.util.ResponseUtil;

@Controller
@RequestMapping("blog")
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	@RequestMapping(value="blogs/{pageNum}/{pageCount}.action",method=RequestMethod.GET)
	public String gotoBlogsPage(HttpServletRequest req,@PathVariable("pageNum") int pageNum,@PathVariable("pageCount") int pageCount) {
		PageList<Blog> pageList = blogService.getBlogs(pageNum,pageCount);
		req.setAttribute("pageList", pageList);
		return "blog/blogs";
	}
	
	@RequestMapping(value="blog/{id}.action",method=RequestMethod.GET)
	public void addHits(@PathVariable("id") Integer id,HttpServletResponse response) {
		long result = blogService.addHits(id, 1);
		ResponseUtil.write(response, result);
	}
}
