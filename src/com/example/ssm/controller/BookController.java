package com.example.ssm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.ssm.service.BookService;

@Controller
@RequestMapping("book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="book/{id}",method=RequestMethod.GET)
	public String getBookById(@PathVariable("id") Integer id,HttpServletRequest request) {
		request.setAttribute("book", bookService.getBookById(id));
		return "book";
	}
	
}
