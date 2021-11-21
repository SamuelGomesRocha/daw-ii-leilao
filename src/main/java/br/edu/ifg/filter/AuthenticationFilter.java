package br.edu.ifg.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import br.edu.ifg.services.Login;

public class AuthenticationFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		String usr = (String) request.getParameter("input-user");
		String pwd = (String) request.getParameter("input-password");
			
		System.out.println("auth data - usr: "+usr+" and pwd: "+pwd);
		if(usr==null && pwd == null) {
			usr = (String) request.getSession().getAttribute("userName");
			pwd = (String) request.getSession().getAttribute("userPassword");
		}
			
		if(Login.loginVerification(usr, pwd))
		chain.doFilter(req, resp);
			
		if(!Login.loginVerification(usr, pwd))
		req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
		}
}
