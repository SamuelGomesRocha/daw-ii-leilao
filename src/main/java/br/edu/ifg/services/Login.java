package br.edu.ifg.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifg.entities.User;
import br.edu.ifg.repositories.UserRepository;


public class Login extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("estou no login");
		
		String userName = req.getParameter("input-user");
		String userPassword = req.getParameter("input-password");
		System.out.println("user name: "+userName+"   -  user password: "+userPassword);
		
		
		if(loginVerification(userName, userPassword)) {
			req.getSession().setAttribute("userName", userName);
			req.getSession().setAttribute("userPassword", userPassword);
			req.getSession().setAttribute("userAccess",""+new UserRepository().getAccess(userName, userPassword));
			req.getRequestDispatcher("/path?act=home").forward(req, resp);
			System.out.println("eita ");
		}
		
		
		
		
		if(!loginVerification(userName, userPassword))
		req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
	
}
	
	public static boolean loginVerification(String usr, String pwd) {
		boolean verify = false;
		
		if(usr == null || pwd == null) {
			verify = false;
		}else {
		for(User u : new UserRepository().list()) {
			if(usr.equals(u.getUserName()) && pwd.equals(u.getPassword())) {
				verify = true;
				break;
			}
		}
		}
		return verify;
		}
	
	}
