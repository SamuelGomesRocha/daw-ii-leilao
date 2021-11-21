package br.edu.ifg.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifg.entities.User;
import br.edu.ifg.repositories.UserRepository;

public class ListaUsers extends HttpServlet{

	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> users = new UserRepository().list();
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/pages/modules/user/users.jsp");
		req.setAttribute("users", users);
		dispatcher.forward(req, resp);
	}
}
