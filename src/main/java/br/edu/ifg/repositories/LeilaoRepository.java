package br.edu.ifg.repositories;

import java.util.List;

import javax.persistence.Query;

import br.edu.ifg.entities.Leilao;
import br.edu.ifg.entities.Row;
import br.edu.ifg.entities.User;
import br.edu.ifg.interfaces.Repository;
import br.edu.ifg.services.LeilaoService;

public class LeilaoRepository extends PersistenceUtil implements Repository<Leilao, Long>{

	@Override
	public void save(Leilao l) {
		start();
		transaction.begin();
		entityManager.persist(l);
		transaction.commit();
		close();	
	}

	public void update(Leilao l) {
		start();
		transaction.begin();
		entityManager.merge(l);
		transaction.commit();
		close();	
	}
	
	@Override
	public void remove(Leilao l) {
		start();
		transaction.begin();
		entityManager.remove(entityManager.contains(l) ? l : entityManager.merge(l));
		transaction.commit();
		close();
		
	}

	@Override
	public Leilao get(Long id) {
		start();
		Leilao leilaoResult = null;
		for(Leilao l : list()) {
			if(id.equals(l.getIdLeilao())) {
				leilaoResult = l;
				break;
			}
		}
		close();
		return leilaoResult;
	}

	@Override
	public List<Leilao> list() {
		start();
		Query q = entityManager.createQuery("SELECT l FROM LEILAO l");
		List<Leilao> resultList = q.getResultList();
		close();
		return resultList;
	}
	
	
	//"true" para duplicado e "false" para não duplicado
	public boolean verifyDuplicity(Leilao leilao) {
		boolean verify = false;
		
			for(Leilao l : list()) {
				if(l.getItem().equals(leilao.getItem()) &&
				   l.getLanceMinimo().equals(leilao.getLanceMinimo()))
					verify = true;
			}
		
		return verify;
	}

}
