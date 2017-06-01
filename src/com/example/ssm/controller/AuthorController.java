package com.example.ssm.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.ssm.service.AuthorService;
import com.example.ssm.util.ResponseUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("author")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;

	@RequestMapping(value="authors/{msg}.json",method=RequestMethod.GET)
	public void getAuthorByPointMsg(@PathVariable("msg") String msg,HttpServletResponse response) {
		try {
//			msg=new String(msg.getBytes("iso8859-1"),"UTF-8");
			Map<String,Object> map = authorService.getAuthorByPointMsg(msg);
			ResponseUtil.write(response, JSONObject.fromObject(map));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
