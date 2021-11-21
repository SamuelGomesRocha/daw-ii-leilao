package br.edu.ifg.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifg.entities.Leilao;
import br.edu.ifg.repositories.LeilaoRepository;

public class ListaLeiloes extends HttpServlet{

	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Leilao> leiloes = new LeilaoRepository().list();
		RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/pages/modules/leilao/leiloes.jsp");
		req.setAttribute("leiloes", leiloes);
		dispatcher.forward(req, resp);
	}	
}
