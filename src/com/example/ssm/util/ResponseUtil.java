package com.example.ssm.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class ResponseUtil {
	public static void write(HttpServletResponse response,Object o) {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out= null;
		try {
			out=response.getWriter();
			out.println(o.toString());
			out.flush();
			out.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		 
		}
}
