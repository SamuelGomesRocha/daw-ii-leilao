package br.edu.ifg.services;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifg.entities.Acesso;
import br.edu.ifg.entities.User;
import br.edu.ifg.repositories.UserRepository;


public class CadastraUser extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/pages/modules/user/cadastro-user.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User usr = new User(req.getParameter("cad-cpf"),
				req.getParameter("cad-nome"), req.getParameter("cad-email"), 
				req.getParameter("cad-telefone"), req.getParameter("cad-user"),
				req.getParameter("cad-password"), LocalDate.parse(req.getParameter("cad-dataNasc".replace('/', '-'))) 
				,Acesso.PROPONENTE);
		
		System.out.println("Texto: "+Validate.validationUser(usr));
		
		if(!new UserRepository().verifyDuplicity(usr)) {
		if(UserService.maior18Verify(usr)) {
		if(Validate.validationUser(usr).equals("")) {
			new UserRepository().save(usr);
			resp.sendRedirect(req.getContextPath().concat("/cadastra-user"));
		}else {
			req.setAttribute("errorMsg", Validate.validationUser(usr));
			req.getRequestDispatcher("/WEB-INF/pages/modules/error-page.jsp").forward(req, resp);
		}
		} else {
			req.setAttribute("errorMsg", "Os usuários deste site devem ter mais de 18 anos");
			req.getRequestDispatcher("/WEB-INF/pages/modules/error-page.jsp").forward(req, resp);
		}
		}else {
			req.setAttribute("errorMsg", "Este usuário já foi cadastrado! A duplicação de CPF ou UserName não permitida!");
			req.getRequestDispatcher("/WEB-INF/pages/modules/error-page.jsp").forward(req, resp);
		}
		
	}
	
}
