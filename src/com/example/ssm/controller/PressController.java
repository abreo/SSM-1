package com.example.ssm.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.ssm.service.PressService;
import com.example.ssm.util.ResponseUtil;

import net.sf.json.JSONObject;

@Controller
@RequestMapping("press")
public class PressController {
	
	@Autowired
	private PressService pressService;

	@RequestMapping(value="presses/{msg}.json",method=RequestMethod.GET)
	public void getPressByPointKey(@PathVariable("msg") String msg,HttpServletResponse response)  {
		try {
			Map<String,Object> map = pressService.getPressesByPointMsg(msg);
			ResponseUtil.write(response, JSONObject.fromObject(map));
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
}
