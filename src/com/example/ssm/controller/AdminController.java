package com.example.ssm.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.ssm.entities.Book;
import com.example.ssm.entities.User;
import com.example.ssm.service.BookService;
import com.example.ssm.service.UserService;
import com.example.ssm.util.PageList;
import com.example.ssm.util.ResponseUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BookService bookService;
	
	/**
	 * 所有用户分页列表
	 * @param pageNum
	 * @param pageCount
	 * @param request
	 * @return
	 */
	@RequestMapping(value="users/{pageNum}/{pageCount}.action",method=RequestMethod.GET)
	public String getAllUsers(
			@PathVariable("pageNum") int pageNum,
			@PathVariable("pageCount") int pageCount, 
			HttpServletRequest request
		) {
		PageList<User> pageList = userService.getAllUsers(pageNum,pageCount);
		request.setAttribute("pageList", pageList);
		return "admin/users";
	}
	
	/**
	 * 所有图书分页列表
	 */
	@RequestMapping(value="books/{pageNum}/{rowCount}.action",method=RequestMethod.GET)
	public String getAllBooks(
			@PathVariable("pageNum") int pageNum,
			@PathVariable("rowCount") int rowCount, 
			HttpServletRequest request
			) {
		PageList<Book> pageList = bookService.getAllBooks(null,pageNum,rowCount);
		request.setAttribute("pageList", pageList);
		return "admin/books";
	}
	
	
	/**
	 * 关键字搜索书
	 * @param msg
	 * @param response
	 */
	@RequestMapping(value="books/{msg}.json",method=RequestMethod.GET)
	public void getBookByPointMsg(@PathVariable("msg") String msg,HttpServletResponse response) {
		Map<String,Object> map = bookService.getBookByPointMsg(msg);
		ResponseUtil.write(response, JSONObject.fromObject(map));
	}
	
	/**
	 * ID搜索图书信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="book/{id}.action",method=RequestMethod.GET)
	public void getBookById(@PathVariable("id") Integer id,HttpServletResponse response) {
		String result = bookService.findBookById(id);
		ResponseUtil.write(response, result);
	}
	
	@RequestMapping(value="book/add.html",method=RequestMethod.GET)
	public String toAddBookPage() {
		return "admin/add";
	}
	
	/**
	 * 添加图书
	 * @param book
	 * @param response
	 */
	@RequestMapping(value="book/add.action",method=RequestMethod.POST)
	public void addBook(@RequestBody Book book,HttpServletResponse response) {
		try {
			bookService.addBook(book);
			ResponseUtil.write(response, "SUCCESS");
		} catch(Exception e) {
			e.printStackTrace();
		}
		ResponseUtil.write(response, "ERROR");
	}
	
}
