package fr.univaix.iut.pokebattle.DAO;

import javax.persistence.EntityManager;

public class DAOFactory {
	
	private EntityManager entityManager;

	public DAOFactory(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public DAOOwner createDAOOwner() {
		return new DAOOwner(entityManager);
	}
	
	public DAOPokemon createDAOPokemon() {
		return new DAOPokemon(entityManager);
	}
	
	public DAOAttacks createDAOAttacks() {
		return new DAOAttacks(entityManager);
	}
	
	public DAOCombat createDAOCombat() {
		return new DAOCombat(entityManager);

	}

}