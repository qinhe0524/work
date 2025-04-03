
package com.xk.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;


public class SessionListener  implements HttpSessionListener{
	
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		session.setMaxInactiveInterval(3600); 
	}

	public void sessionDestroyed(HttpSessionEvent se) {
	}
}
