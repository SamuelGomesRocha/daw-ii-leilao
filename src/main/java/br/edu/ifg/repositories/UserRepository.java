package br.edu.ifg.repositories;


import java.util.List;

import javax.persistence.Query;

import br.edu.ifg.entities.Acesso;
import br.edu.ifg.entities.Leilao;
import br.edu.ifg.entities.User;
import br.edu.ifg.interfaces.Repository;

public class UserRepository extends PersistenceUtil implements Repository<User, Long> {

	public void save(User u) {
		start();
		transaction.begin();
		entityManager.persist(u);
		transaction.commit();
		close();		
	}

	public void update(User u) {
		start();
		transaction.begin();
		entityManager.merge(u);
		transaction.commit();
		close();
	}
	
	public void remove(User u) {
		start();
		transaction.begin();
		entityManager.remove(entityManager.contains(u) ? u : entityManager.merge(u));
		transaction.commit();
		close();
	}

	public User get(Long id) {
		start();
		User resultUser = null;
		for(User u : list()) {
			if(id.equals(u.getIdUser())) {
				resultUser = u;
				break;
			}
		}
		close();
		return resultUser;
		
	}

	public List<User> list() {
		start();
		Query q = entityManager.createQuery("SELECT u FROM USER u");
		List<User> resultList = q.getResultList();
		close();
		return resultList;
	
	}

	public Acesso getAccess(String usr, String pwd) {
		start();
		Acesso access = null;
		for(User u : list()) {
			if(u.getUserName().equals(usr) && u.getPassword().equals(pwd)) {
				access = u.getAcesso();
			}
		}
		close();
		return access;
	}
	
	public Long getID(String usr, String pwd) {
		start();
		Long id = null;
		for(User u : list()) {
			if(u.getUserName().equals(usr) && u.getPassword().equals(pwd)) {
				id = u.getIdUser();
			}
		}
		close();
		return id;
	}
	
	//"true" para duplicado e "false" para não duplicado
		public boolean verifyDuplicity(User user) {
			boolean verify = false;
			
				for(User u : list()) {
					if(u.getCpf().equals(user.getCpf()) ||
					   u.getUserName().equals(user.getUserName()))
						verify = true;
				}
			
			return verify;
		}

}
