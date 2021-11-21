package br.edu.ifg.services;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifg.entities.Leilao;
import br.edu.ifg.entities.Status;
import br.edu.ifg.repositories.LeilaoRepository;

public class CadastraLeilao extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Leilao leilao = new Leilao(req.getParameter("cad-item"),
				Double.parseDouble(req.getParameter("cad-lanceMinimo")), 
				LeilaoService.getStatus(req.getParameter("cad-status")), 
				LocalDate.parse(req.getParameter("cad-dataExpiracao")));
				
		if(new LeilaoRepository().verifyDuplicity(leilao)) {
			req.setAttribute("errorMsg", "Este leilão já foi cadastrado! A duplicação de item em conjunto com lance mínimo não permitida!");
			req.getRequestDispatcher("/WEB-INF/pages/modules/error-page.jsp").forward(req, resp);
		}else {
		new LeilaoRepository().save(leilao);
		resp.sendRedirect(req.getContextPath().concat("/path?act=leilao-cad"));
		}
	}
	
}
