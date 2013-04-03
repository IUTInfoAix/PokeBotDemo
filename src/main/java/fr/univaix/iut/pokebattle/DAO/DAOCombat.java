package fr.univaix.iut.pokebattle.DAO;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.univaix.iut.pokebattle.beans.Combat;
import fr.univaix.iut.pokebattle.beans.Pokemon;


public class DAOCombat {

	private EntityManager entityManager;
	
	public DAOCombat(EntityManager em) {
		this.entityManager = em;
	}
	
	
	public Combat getByPokemon ( Pokemon Pokemon){
		try 
		{

			TypedQuery<Combat> query = entityManager.createNamedQuery(Combat.GET_BY_NOM , Combat.class);
			query.setParameter("nom", Pokemon );
			return query.getSingleResult();
			
		}

		catch (java.util.NoSuchElementException Exc)
		{
			return null;
		}
	}
	
	public Pokemon insert (Pokemon pokemon)
	{
		EntityTransaction entT = entityManager.getTransaction();
		entT.begin();
		entityManager.persist(pokemon);
		entT.commit();
		return entityManager.find(Pokemon.class, pokemon.getNom());
	}
	
	public boolean delete (Pokemon pokemon)
	{
		try {
			EntityTransaction entT = entityManager.getTransaction();
			entT.begin();
			entityManager.remove(pokemon);
			entT.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	
	
}
