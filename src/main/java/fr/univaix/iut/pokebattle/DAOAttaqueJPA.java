package fr.univaix.iut.pokebattle;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

public class DAOAttaqueJPA implements DAOAttaque {

	   private EntityManager entityManager;

	    public DAOAttaqueJPA(EntityManager entityManager) {  
	        this.entityManager = entityManager;
	    }

	    public List<Attaque> findByType(String type) {
	        TypedQuery<Attaque> query = entityManager.createNamedQuery(Attaque.FIND_BY_TYPE, Attaque.class);
	        query.setParameter("ftype", type);
	        return query.getResultList();
	    }
	    
	    @Override
	    public boolean delete(Attaque obj) {  
	        try {
	            EntityTransaction tx = entityManager.getTransaction();
	            tx.begin();
	            entityManager.remove(obj);
	            tx.commit();
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    @Override
	    public List<Attaque> findAll() {
	        TypedQuery<Attaque> query = entityManager.createNamedQuery(Attaque.FIND_ALL, Attaque.class);
	        return query.getResultList();
	    }

	    @Override
	    public Attaque getById(String id) {
	        return entityManager.find(Attaque.class, id);
	    }

	    @Override
	    public Attaque insert(Attaque obj) {
	        EntityTransaction tx = entityManager.getTransaction();
	        tx.begin();
	        entityManager.persist(obj);
	        tx.commit();
	        return entityManager.find(Attaque.class, obj.getNomAttaque());
	    }

	    @Override
	    public boolean update(Attaque obj) {
	        try {
	            EntityTransaction tx = entityManager.getTransaction();
	            tx.begin();
	            entityManager.merge(obj);
	            tx.commit();
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }

	
}