package com.example.ssm.filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class GetHttpServletRequestWrapper extends HttpServletRequestWrapper {

	
	private String encoding = "UTF-8";  
	   
	 public GetHttpServletRequestWrapper(HttpServletRequest request) {  
	  super(request);  
	 }  
	   
	 public GetHttpServletRequestWrapper(HttpServletRequest request,String encoding) {  
	  super(request);  
	  this.encoding = encoding;  
	 }  
	   
	 @Override  
	 public String getParameter(String name) {  String param = super.getParameter(name);  
	  if(param == null){  
	   param = null;  
	  }else{  
	   param = encodingConvert(param);  
	  }  
	    
	  return param;  
	 }  
	   
	 /** 
	  * 对URL中的参数进行编码转换 
	  */  
	  public String encodingConvert(String param) {     
	         try {     
	             return new String(param.trim().getBytes("ISO-8859-1"), encoding);     
	         } catch (UnsupportedEncodingException e) {     
	             return param;     
	         }     
	     }  
}
