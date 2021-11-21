package br.edu.ifg.repositories;

import br.edu.ifg.entities.Acesso;
import br.edu.ifg.entities.User;

public class Tester{

	public static void main(String[] args) {
		
		UserRepository newUser = new UserRepository();
		newUser.save(new User("000.000.000-00", "Admin", "admin@gmail.com",
				"(62) 99999-9999", "admin", "admin", Acesso.ADMIN));
		
		System.out.println(newUser.list().toString());
	
	}
	
}
