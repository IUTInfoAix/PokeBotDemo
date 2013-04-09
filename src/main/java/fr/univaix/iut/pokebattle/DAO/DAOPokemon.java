 package fr.univaix.iut.pokebattle.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.univaix.iut.pokebattle.beans.Pokemon;


public class DAOPokemon {

	
	private EntityManager entityManager;
	
	public DAOPokemon(EntityManager em) {
		this.entityManager = em;
	}
	
	public Pokemon getByNom ( String Nom )
	{
		
		try{	
			
			TypedQuery<Pokemon> query = entityManager.createNamedQuery(Pokemon.FIND_BY_NOM , Pokemon.class);
			query.setParameter("nom", Nom);
			return query.getSingleResult();
		}
		
		catch(Exception ex)
		{
			return null;
		}
		
	}
	
	public List<Pokemon> findByRace ( String Race )
	{
		
		try{	
			
			TypedQuery<Pokemon> query = entityManager.createNamedQuery(Pokemon.FIND_BY_RACE , Pokemon.class);
			query.setParameter("race", Race);
			return query.getResultList();
			
		}
		
		catch(Exception ex)
		{
			return null;
		}
		
	}
	
	public List<Pokemon> findAll ()
	{
		
		try{	
			
			TypedQuery<Pokemon> query = entityManager.createNamedQuery(Pokemon.FIND_ALL , Pokemon.class);
			return query.getResultList();
			
		}
		
		catch(java.util.NoSuchElementException ex)
		{
			return null;
		}
		
	}
	
	public int countByRace ( String Race )
	{
		
		try{	
			
			TypedQuery<Pokemon> query = entityManager.createNamedQuery(Pokemon.COUNT_POKE_PER_RACE , Pokemon.class);
			query.setParameter("race", Race);
			return query.getFirstResult();
			
		}
		
		catch(Exception ex)
		{
			return 0;
		}
		
	}
	
	
}