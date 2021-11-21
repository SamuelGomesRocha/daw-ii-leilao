package br.edu.ifg.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifg.entities.User;
import br.edu.ifg.repositories.UserRepository;

public class ProfileRender extends HttpServlet{

	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String usr = (String) req.getSession().getAttribute("userName");
		String pwd = (String) req.getSession().getAttribute("userPassword");
		User user = new UserRepository().get(new UserRepository().getID(usr, pwd));
		
		
		req.setAttribute("val-cpf", user.getCpf());
		req.setAttribute("alt-nome", user.getNome());
		req.setAttribute("alt-email", user.getEmail());
		req.setAttribute("alt-telefone", user.getTelefone());
		req.setAttribute("alt-user", user.getUserName());
		req.setAttribute("alt-password", user.getPassword());
		
		req.getRequestDispatcher("/WEB-INF/pages/modules/user/perfil.jsp").forward(req, resp);
		
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String usr = (String) req.getSession().getAttribute("userName");
		String pwd = (String) req.getSession().getAttribute("userPassword");
		User user = new UserRepository().get(new UserRepository().getID(usr, pwd));
		
		System.out.println("Aqui está, id e cpf: "+user.getIdUser()+"=----="+req.getParameter("alt-cpf") );
		
		new UserRepository().update(new User(
				user.getIdUser(), req.getParameter("alt-cpf"), req.getParameter("alt-nome"),
				req.getParameter("alt-email"), req.getParameter("alt-telefone"), 
				req.getParameter("alt-user"), req.getParameter("alt-password"), user.getAcesso()));
		req.getRequestDispatcher("/WEB-INF/pages/modules/user/alteradoComSucesso.jsp").forward(req, resp);
	}
	
}
