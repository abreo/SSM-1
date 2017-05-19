package com.example.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="public")
public class PublicController {

	@RequestMapping(value="redis/try",method=RequestMethod.GET)
	public String toTryPage() {
		return "terminal";
	}
	
}
