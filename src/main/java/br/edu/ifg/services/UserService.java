package br.edu.ifg.services;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;

import br.edu.ifg.entities.Leilao;
import br.edu.ifg.entities.Status;
import br.edu.ifg.entities.User;

public class UserService {

	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	public static boolean maior18Verify(User user) {
		boolean maior18Verify = false;
		Long dezoitoAnos = (long) 567648000000l;
		String format = sdf.format(new java.util.Date());
		System.out.println("SQLDATE: "+user.getDataNasc().toString()+" DATE SDF"+ format);
		String dataSQL = user.getDataNasc().toString()+" 00:00:00";
		
		long atualMillis = LocalDateTime.parse(
				format.replace(" ", "T")
				.replace("/", "-")
				).atZone(
						ZoneId.of( "America/Sao_Paulo" )
				).toInstant().toEpochMilli();
		
		long sqlMillis = LocalDateTime.parse(
				dataSQL.replace(" ", "T")
				.replace("/", "-")
				).atZone(
						ZoneId.of( "America/Sao_Paulo" )
				).toInstant().toEpochMilli();
		
		System.out.println("ATUAL: "+atualMillis);
		System.out.println("NASC: "+sqlMillis);
		System.out.println("UM MENOS O OUTRO: "+(atualMillis - sqlMillis));
		System.out.println("18 years: "+ dezoitoAnos);
		
		if((atualMillis - sqlMillis) >= dezoitoAnos) {
			maior18Verify = true;
		}
		
		return maior18Verify;
	}
	
}
