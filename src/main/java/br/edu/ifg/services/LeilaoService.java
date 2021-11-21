package br.edu.ifg.services;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.edu.ifg.entities.Row;
import br.edu.ifg.entities.Status;

public class LeilaoService {

	public static void setPossiblesStatus(Status atualStatus, HttpServletRequest req){
		List<Row> possiblesStatus = Arrays.asList(new Row(0, Status.INATIVO));
		
		if(atualStatus == Status.INATIVO) {
			possiblesStatus = Arrays.asList(new Row(0, Status.INATIVO), new Row(1, Status.ABERTO));
		}
		if(atualStatus == Status.ABERTO) {
			possiblesStatus = Arrays.asList(new Row(1, Status.ABERTO),
					new Row(2, Status.FINALIZADO));
		}
		
		if(atualStatus == Status.FINALIZADO) {
			possiblesStatus = Arrays.asList(new Row(2, Status.FINALIZADO));
		}

		req.getSession().setAttribute("possiblesStatus", possiblesStatus);
	}
	
	
	public static List<Row> getPossiblesStatus(Status atualStatus, HttpServletRequest req){
		List<Row> possiblesStatus = Arrays.asList(new Row(0, Status.INATIVO));
		
		if(atualStatus == Status.INATIVO) {
			possiblesStatus = Arrays.asList(new Row(0, Status.INATIVO), new Row(1, Status.ABERTO));
		}
		if(atualStatus == Status.ABERTO) {
			possiblesStatus = Arrays.asList(new Row(1, Status.ABERTO),
					new Row(2, Status.FINALIZADO));
		}
		
		if(atualStatus == Status.FINALIZADO) {
			possiblesStatus = Arrays.asList(new Row(2, Status.FINALIZADO));
		}

		return possiblesStatus;
	}
	
	
	public static Status getStatus(String sts) {
		Status resultStatus = Status.INATIVO;
		
		System.out.println("Meu deus o sts: "+sts);
		
		if(sts.equals("0")) resultStatus = Status.INATIVO;
		if(sts.equals("1")) resultStatus = Status.ABERTO;
		if(sts.equals("2")) resultStatus = Status.FINALIZADO;
		if(sts.equals("3")) resultStatus = Status.EXPIRADO;
		
		System.out.println("Agora o result status: "+ resultStatus);
		
		return resultStatus;
	}
	
	
}
