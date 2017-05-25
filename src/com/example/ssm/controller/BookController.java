package com.example.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.ssm.entities.Book;
import com.example.ssm.entities.User;
import com.example.ssm.service.BookService;

@Controller
@RequestMapping("book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="{id}",method=RequestMethod.GET)
	public String getBookById(@PathVariable("id") Integer id,HttpServletRequest request) {
		request.setAttribute("book", bookService.getBookById(id));
		return "book";
	}
	
	/**
	 * 获取自己的图书
	 * 必须登录用户
	 * 5条分页
	 */
	@RequestMapping(value="books.action",method=RequestMethod.GET)
	public String getAllMyBooks(HttpServletRequest request) {
		List<Book> books = bookService.getAllMyBooks(((User)request.getSession().getAttribute("loginUser")).getId());
		request.setAttribute("books", books);
		return "books";
	}
	
}
