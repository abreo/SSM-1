package com.example.ssm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.ssm.dao.BookDao;
import com.example.ssm.entities.Book;
import com.example.ssm.util.PageList;

@Service
public class BookService {

	@Autowired
	private BookDao bookDao;

	public Book getBookById(Integer id) {
		return bookDao.getBookById(id);
	}
	
	/**
	 * 获取所有书（若传入人员Id，则搜索该用户的全部书）
	 * @param id
	 * @param pageNum
	 * @param rowCount
	 * @return
	 */
	public PageList<Book> getAllBooks(Integer id ,int pageNum,int rowCount) {
		Map<String,Object> map = new HashMap<>();
		map.put("id", id);
		map.put("pageNum", (pageNum-1)*rowCount);
		map.put("rowCount", rowCount);
		List<Book> books = bookDao.getAllBooks(map);
		PageList<Book> pageList = new PageList<>();
		pageList.setMaxCount(bookDao.getBookCount(id));
		pageList.setPageNum(pageNum);
		pageList.setObjs(books);
		return pageList;
	}
	
	/**
	 * 关键字搜索
	 * @param msg
	 * @param pageNum
	 * @param rowCount
	 * @return
	 */
	public PageList<Book> getBookByPointMsg(@PathVariable("msg") String msg,int pageNum,int rowCount) {
		Map<String,Object> map = new HashMap<>();
		map.put("msg", "%"+msg+"%");
		map.put("pageNum", (pageNum-1)*rowCount);
		map.put("rowCount", rowCount);
		List<Book> books = bookDao.getBooksByPointMsg(map);
		PageList<Book> pageList = new PageList<>();
		pageList.setMaxCount(bookDao.getBooksCountByPointMsg(map));
		pageList.setPageNum(pageNum);
		pageList.setObjs(books);
		return pageList;
	}
}

