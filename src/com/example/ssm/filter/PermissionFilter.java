package com.example.ssm.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.example.ssm.entities.Permission;
import com.example.ssm.entities.Role;
import com.example.ssm.entities.User;

public class PermissionFilter implements Filter {

	private static final String[] ALLOW_REQUEST = {
			"login.html","index.html","register.html",
			"login.action","index.action","register.action",
			".js",".css",".png",".jpg"
	} ;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) arg0;
		String url = request.getRequestURI().toString();
		if(notNeedLogin(url, request)) {
			arg2.doFilter(arg0, arg1);
		} else {
			User user = (User) request.getSession().getAttribute("loginUser");
			if(null == user) { //登錄資源，但未登錄
				request.getSession().setAttribute("LOGIN_TO_URL", url);
				request.getRequestDispatcher("/login.html").forward(arg0, arg1);
			} else {
				Set<String> permissions = (Set<String>) request.getSession().getAttribute("PERMISSIONS");
				if(permissions == null) {
					//重新查詢權限
					reGetPermission(user, request);
				} 
				if(hasPermission(url, permissions)) {
					arg2.doFilter(arg0, arg1);
				} else {
					request.getRequestDispatcher("/error/permission_denied.jsp").forward(arg0, arg1);
				}
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	private boolean notNeedLogin(String toUrl,HttpServletRequest request) {
		for(String url : ALLOW_REQUEST) {
			if(toUrl != null && toUrl.indexOf(url) >= 0) {
				return true;
			}
		}
		return false;
	}
	
	private boolean hasPermission(String toUrl ,Set<String> permissions) {
		for(String permission : permissions) {
			if(toUrl != null && toUrl.indexOf(permission) >= 0) {
				return true;
			}
		}
		return false;
	}
	
	public void reGetPermission(User user,HttpServletRequest request) {
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
		}
	}
	
    
	
}
