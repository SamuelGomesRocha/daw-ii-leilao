package br.edu.ifg.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifg.entities.Leilao;
import br.edu.ifg.entities.Status;
import br.edu.ifg.repositories.LeilaoRepository;
import br.edu.ifg.repositories.UserRepository;
import br.edu.ifg.services.CadastraLeilao;
import br.edu.ifg.services.LeilaoService;
import br.edu.ifg.services.ListaLeiloes;
import br.edu.ifg.services.ListaUsers;
import br.edu.ifg.services.ProfileRender;
import br.edu.ifg.services.UpdateLeilao;

@WebServlet(urlPatterns = "/path")
public class PathController extends HttpServlet{
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String act = req.getParameter("act");
		
		
		switch(act) {
			case "home":
				req.getRequestDispatcher("/WEB-INF/pages/modules/home.jsp").forward(req, resp);	
			break;
			case "logout":
				req.getSession().setAttribute("userName", null);
				req.getSession().setAttribute("userPassword", null);
				req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
			break;
			case "perfil":
			 new ProfileRender().doGet(req, resp);
			break;
			case "perfil-alt":
			 new ProfileRender().doPost(req, resp);
			break;
			case "leilao-cad":
				 LeilaoService.setPossiblesStatus(Status.INATIVO, req);
				 req.getRequestDispatcher("/WEB-INF/pages/modules/leilao/cadastro-leilao.jsp").forward(req, resp);
			break;
			case "cad-leilao":
			 new CadastraLeilao().doPost(req, resp);
			break;
			case "leiloes":
				new ListaLeiloes().service(req, resp);
			break;
			case "deletaLeilao":
				new LeilaoRepository().
				remove(new LeilaoRepository().get(
				Long.parseLong(req.getParameter("idLeilao").toString())));
				new ListaLeiloes().service(req, resp);
			break;
			case "users":
				new ListaUsers().service(req, resp);
			break;
			case "deletaUser":
				new UserRepository().
				remove(new UserRepository().get(
				Long.parseLong(req.getParameter("idUser").toString())));
				new ListaUsers().service(req, resp);
			break;
			case "updateLeilao":
				new UpdateLeilao().doGet(req, resp);
			break;
			case "alt-leilao":
				new UpdateLeilao().doPost(req, resp);
			break;	
		
		}
		
	}
	
	
}
