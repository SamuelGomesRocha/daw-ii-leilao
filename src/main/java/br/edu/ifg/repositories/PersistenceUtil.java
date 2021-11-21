package br.edu.ifg.repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersistenceUtil {

	protected static EntityManagerFactory emf = null;
	protected static EntityManager entityManager = null;
    protected static EntityTransaction transaction = null;
	
    protected static void start() {
		emf = Persistence.createEntityManagerFactory("daw_ii_leilao");
		entityManager = emf.createEntityManager();
		transaction = entityManager.getTransaction();
	}
    
    
    protected static void close() {
    	entityManager.close();
    	emf.close();
    }
    
}
