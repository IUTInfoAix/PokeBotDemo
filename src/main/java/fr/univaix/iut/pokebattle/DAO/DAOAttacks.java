package fr.univaix.iut.pokebattle.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.univaix.iut.pokebattle.beans.Attacks;
import fr.univaix.iut.pokebattle.beans.Pokemon;


public class DAOAttacks {

	private EntityManager entityManager;
	
	public DAOAttacks(EntityManager em) {
		this.entityManager = em;
	}
	
	public List<Attacks> findByPokemon ( Pokemon pokemon ){
		try{	
			
			TypedQuery<Attacks> query = entityManager.createNamedQuery(Attacks.FIND_BY_POKE , Attacks.class);
			query.setParameter("pokemon", pokemon);
			return query.getResultList();
			
		}
		
		catch(java.util.NoSuchElementException ex)
		{
			return null;
		}
	}
	
	public int computeNbAttacks( String pokemon ){
		try{
			
			TypedQuery<Attacks> query = entityManager.createNamedQuery(Attacks.COUNT_ATTA , Attacks.class);
			query.setParameter("pokemon", pokemon);
			return query.getFirstResult();
		}
		catch(java.util.NoSuchElementException ex)
		{
			return 0;
		}
	}
	
	public List<Attacks> findAll ( ){
		try{	
			
			TypedQuery<Attacks> query = entityManager.createNamedQuery(Attacks.FIND_ALL , Attacks.class);
			return query.getResultList();
			
		}
		
		catch(java.util.NoSuchElementException ex)
		{
			return null;
		}
	}
	
	
}
