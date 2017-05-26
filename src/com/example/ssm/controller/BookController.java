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
import com.example.ssm.util.PageList;

@Controller
@RequestMapping("book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="{id}",method=RequestMethod.GET)
	public String getBookById(@PathVariable("id") Integer id,HttpServletRequest request) {
		request.setAttribute("book", bookService.getBookById(id));
		return "book/book";
	}
	
	/**
	 * ��ȡ�Լ���ͼ��
	 * �����¼�û�
	 * 5����ҳ
	 */
	@RequestMapping(value="books/{pageNum}/{rowCount}.action",method=RequestMethod.GET)
	public String getAllMyBooks(
			@PathVariable("pageNum") int pageNum , 
			@PathVariable("rowCount") int rowCount, 
			HttpServletRequest request) 
		{
		PageList<Book> pageList = bookService.getAllBooks(((User)request.getSession().getAttribute("loginUser")).getId(),pageNum,rowCount);
		request.setAttribute("pageList", pageList);
		return "book/books";
	}
	
	
	
	
}
