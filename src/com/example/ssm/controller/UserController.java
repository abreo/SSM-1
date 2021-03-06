package com.example.ssm.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.ssm.entities.Permission;
import com.example.ssm.entities.Role;
import com.example.ssm.entities.User;
import com.example.ssm.service.UserService;
import com.example.ssm.util.ResponseUtil;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="login.html",method=RequestMethod.GET)
	public String loginPage() {
		return "redirect:/login.html";
	}
	
	@RequestMapping(value="login.action",method=RequestMethod.POST)
	public void login(
			String username,String password,
			HttpServletRequest request,HttpServletResponse response
		) {
//		GenericObjectPoolConfig config = new GenericObjectPoolConfig();
//		JedisPool pool = new JedisPool(config,"192.168.45.128",6379);
//		Jedis jedis = pool.getResource();
//		System.out.println(jedis.toString());
		User user = userService.login(username, password);
		if(user != null) {
			Set<String> urls = new HashSet<>();
			Set<Role> roles = user.getRoles();
			if(roles!= null && roles.size() > 0) {
				for(Role role : roles) {
					Set<Permission> permissions = role.getPermissions();
					if(permissions != null && permissions.size() > 0) {
						for(Permission p : permissions) {
							urls.add(p.getUrl());
						}
					}
				}
			}
			request.getSession().setAttribute("PERMISSIONS", urls);
			request.getSession().setAttribute("loginUser", user);
			ResponseUtil.write(response, 1);
		} else {
			ResponseUtil.write(response, 0);
		}
	}
	
	@RequestMapping(value="logout.action",method=RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		try {
			request.getSession().setAttribute("loginUser", null);
			request.getSession().invalidate();
			return "redirect:/login.html";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", "数据异常！");
			return "error";
		}
	}
	
	
}
