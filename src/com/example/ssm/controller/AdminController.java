package com.example.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.ssm.entities.Book;
import com.example.ssm.entities.User;
import com.example.ssm.service.BookService;
import com.example.ssm.service.UserService;
import com.example.ssm.util.PageList;

@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BookService bookService;
	
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
	
	
	@RequestMapping(value="books/{msg}/{pageNum}/{rowCount}.json",method=RequestMethod.POST)
	public void getBookByPointMsg(
			@PathVariable("msg") String msg,@PathVariable("pageNum") int pageNum,
			@PathVariable("rowCount") int rowCount,HttpServletRequest request ,HttpServletResponse response) {
		PageList<Book> pageList = bookService.getBookByPointMsg(msg, pageNum, rowCount);
	}
}
