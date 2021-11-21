package br.edu.ifg.services;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifg.entities.Leilao;
import br.edu.ifg.entities.Row;
import br.edu.ifg.repositories.LeilaoRepository;

public class UpdateLeilao extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Olhe o idLeilao: "+ req.getParameter("idLeilao"));
		 
		Leilao leilao = new LeilaoRepository().get(Long.parseLong(req.getParameter("idLeilao")));
	
		System.out.println("Ó o leilao item: " + leilao.getItem());
		
		req.setAttribute("alt-item", leilao.getItem());
		req.setAttribute("alt-lanceMinimo", leilao.getLanceMinimo());
		req.setAttribute("alt-dataExpiracao", leilao.getDataExpiracao());
		LeilaoService.setPossiblesStatus(leilao.getStatus(), req);
		
		req.setAttribute("idLeilao", req.getParameter("idLeilao"));
		
		req.getRequestDispatcher("/WEB-INF/pages/modules/leilao/update-leilao.jsp").forward(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean val = false;
		Leilao leilao = new LeilaoRepository().get(Long.parseLong(req.getParameter("idLeilao")));
		List<Row> possiblesRows = LeilaoService.getPossiblesStatus(leilao.getStatus(), req);
		
		Leilao updatedLeilao = new Leilao(leilao.getIdLeilao(), req.getParameter("alt-item"),
				Double.parseDouble(req.getParameter("alt-lanceMinimo")), 
				LeilaoService.getStatus(req.getParameter("alt-status")), 
				LocalDate.parse(req.getParameter("alt-dataExpiracao")));
		
		for(Row r : possiblesRows) {
			if(updatedLeilao.getStatus().equals(r.getContext())) {
				val = true;
				break;
			}		
		}
		
		
		if(val == false) {
			String msg = "Status incorreto!";		
			req.setAttribute("errorMsg", msg);
			req.getRequestDispatcher("/WEB-INF/pages/modules/error-page.jsp").forward(req, resp);
		}else {
			new LeilaoRepository().update(updatedLeilao);
			resp.sendRedirect(req.getContextPath().concat("/path?act=leiloes"));
		}
		
	}
	
}
