package DAO;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import beans.Owner;

public class DAOOwner {

	private EntityManager entityManager;
	
	public DAOOwner(EntityManager em) {
		this.entityManager = em;
	}
	
	public List<Owner> findByPrenom ( String Prenom ){
			
		TypedQuery<Owner> query = entityManager.createNamedQuery(Owner.FIND_BY_PRENOM , Owner.class);
		query.setParameter("prenom", Prenom);
		return query.getResultList();

	}
	
	public Owner getByPokemon ( String Pokemon ){

		TypedQuery<Owner> query = entityManager.createNamedQuery(Owner.FIND_BY_POKEMON , Owner.class);
		query.setParameter("pokemon", Pokemon);
		return query.getSingleResult();


	}

	public int computeNbPoke( String Prenom ){
		
		TypedQuery<Owner> query = entityManager.createNamedQuery(Owner.COUNT_POKE , Owner.class);
		query.setParameter("prenom", Prenom);
		return query.getFirstResult();
		
	}
	
	
}
