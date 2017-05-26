package com.example.ssm.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

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
import com.example.ssm.util.ResponseUtil;

import net.sf.json.JSONObject;

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
	
	/**
	 * 關鍵字搜索書
	 * @param msg
	 * @param response
	 */
	@RequestMapping(value="books/{msg}.json",method=RequestMethod.GET)
	public void getBookByPointMsg(@PathVariable("msg") String msg,HttpServletResponse response) {
		try {
			msg=new String(msg.getBytes("iso8859-1"),"UTF-8");
			Map<String,Object> map = bookService.getBookByPointMsg(msg);
			ResponseUtil.write(response, JSONObject.fromObject(map));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
