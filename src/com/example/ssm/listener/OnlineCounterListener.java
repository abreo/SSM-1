package com.example.ssm.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnlineCounterListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		HttpSession session = arg0.getSession();
		ServletContext context = session.getServletContext();
		Integer count = (Integer) context.getAttribute("ONLINE_COUNT");
		if(null == count) {
			count = new Integer (1);
		} else {
			count ++;
		}
		context.setAttribute("OBLINE_COUNT", count);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		HttpSession session = arg0.getSession();
		ServletContext context = session.getServletContext();
		Integer count = (Integer) context.getAttribute("ONLINE_COUNT");
		if(null == count) {
			return ;
		} else {
			count --;
		}
		context.setAttribute("OBLINE_COUNT", count);
	}

}
