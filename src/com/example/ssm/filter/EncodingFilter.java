package com.example.ssm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodingFilter implements Filter {

	private FilterConfig filterConfig = null;

	// 编码方式，全局变量
	private String encoding = null;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		this.filterConfig = null;
		this.encoding = null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {  
		HttpServletRequest req = (HttpServletRequest) request;  
		HttpServletResponse res = (HttpServletResponse) response;  
			    
		System.out.println("请求地址："+req.getRequestURI().toString());  
		System.out.println("默认请求编码:"+req.getCharacterEncoding());  
			    
		//设置请求字符编码   
		request.setCharacterEncoding(encoding);   
		//设置响应字符编码  
		response.setCharacterEncoding(encoding);   
			       
		System.out.println("设置请求编码后:"+req.getCharacterEncoding());  
			       
		//如果是Get方式提交   
		if("get".equalsIgnoreCase(req.getMethod().trim().toString())){  
			//对请求进行包装,完成URL中参数的编码转换  
			req = new GetHttpServletRequestWrapper(req,encoding);  
		}  
			      
		//执行下一个过滤器  
		filterChain.doFilter(req, res);  
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		this.filterConfig = arg0;
		this.encoding = filterConfig.getInitParameter("encoding");
	}

}
