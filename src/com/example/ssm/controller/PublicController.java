package com.example.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.ssm.util.ResponseUtil;

@Controller
@RequestMapping("public")
public class PublicController {
	
	@RequestMapping(value="index.html",method=RequestMethod.GET)
	public String toMainPage() {
		return "blank";
	}
	
	@RequestMapping(value="page.html",method=RequestMethod.GET)
	public void gotoPage(HttpServletRequest request,HttpServletResponse response) {
		String aimUrl = (String) request.getSession().getAttribute("LOGIN_TO_URL");
		if(null == aimUrl) {
			ResponseUtil.write(response, 1);
		} else {
			request.setAttribute("LOGIN_TO_URL", aimUrl);
			request.getSession().setAttribute("LOGIN_TO_URL", null);
			ResponseUtil.write(response, aimUrl);
		}
		
	}

}
