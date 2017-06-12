package com.example.ssm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ssm.dao.BlogDao;
import com.example.ssm.dao.RedisDao;
import com.example.ssm.entities.Blog;
import com.example.ssm.util.PageList;
import com.example.ssm.util.RedisIdUtil;

@Service
public class BlogService {

	@Autowired
	private BlogDao blogDao;

	@Autowired
	private RedisDao redisDao;
	
	public PageList<Blog> getBlogs(int pageNum,int pageCount) {
		PageList<Blog> pageList = new PageList<>();
		pageList.setMaxCount(20);
		pageList.setRowCount(5);
		pageList.setPageNum(pageNum);
		Map<String,Integer> map = new HashMap<>();
		map.put("pageNum", (pageNum-1)*pageCount);
		map.put("pageCount", pageCount);
		List<Blog> blogs = blogDao.getBlogsByPage(map);
		getBlogsHints(blogs);
		pageList.setObjs(blogs);
		return pageList;
	}
	
	public void getBlogsHints(List<Blog> blogs) {
		for(int i=0;i<blogs.size();i++) {
			Blog blog = blogs.get(i);
			try {
				blog.setPV(Long.parseLong(redisDao.getHints(RedisIdUtil.getBlogId(blog.getId()))));
			} catch(Exception e) {
				e.printStackTrace();
				blog.setPV(0);
			}
		}
	}
	
	/**
	 * 为指定博客添加点击量
	 * @param id
	 */
	public long addHits(Integer id,int n) {
		String ids = RedisIdUtil.getBlogId(id);
		return redisDao.increment(ids, n);
	}
}
