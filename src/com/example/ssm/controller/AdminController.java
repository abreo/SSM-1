package com.example.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.ssm.entities.User;
import com.example.ssm.service.UserService;

@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="users/{pageNum}/{pageCount}.action",method=RequestMethod.GET)
	public String getAllUsers(
			@PathVariable("pageNum") int pageNum,
			@PathVariable("pageCount") int pageCount, 
			HttpServletRequest request
		) {
		List<User> users = userService.getAllUsers(pageNum,pageCount);
		request.setAttribute("users", users);
		return "admin/users";
	}
	
}
