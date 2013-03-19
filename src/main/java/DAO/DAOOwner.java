package DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import beans.Owner;

public class DAOOwner {

	private EntityManager entityManager;
	
	public DAOOwner(EntityManager em) {
		this.entityManager = em;
	}
	
	public List<String> findByPrenom ( String Prenom ){
		
		try{
			
		TypedQuery<Owner> query = entityManager.createNamedQuery(Owner.FIND_BY_PRENOM , Owner.class);
		List<Owner> LOwner = query.getResultList();
		Iterator<Owner> Iter = LOwner.iterator();
		ArrayList<String> LPokemon = new ArrayList<String>();
		
		while ( Iter.hasNext())
		{
			LPokemon.add(Iter.next().getPokemon());
		}
		return LPokemon;
		
		}
		catch( Exception Ex){
			return null;
		}

	}
	
	public String getByPokemon ( String Pokemon ){
		try{
			
		TypedQuery<Owner> query = entityManager.createNamedQuery(Owner.FIND_BY_POKEMON , Owner.class);
		List<Owner> LOwner = query.getResultList();
		Iterator<Owner> Iter = LOwner.iterator();
		if ( Iter.hasNext() )
			return Iter.next().getPrenom();
		else
			return null;
		}
		catch( Exception Ex){
			return null;
		}
	}

	public int computeNbPoke( String Prenom ){
		
		TypedQuery<Owner> query = entityManager.createNamedQuery(Owner.COUNT_POKE , Owner.class);
		return query.getFirstResult();
		
	}
	
	
}
