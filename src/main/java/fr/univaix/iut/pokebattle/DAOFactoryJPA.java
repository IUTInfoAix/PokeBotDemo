package fr.univaix.iut.pokebattle;

import javax.persistence.EntityManager;

public class DAOFactoryJPA {
	
	private static EntityManager entityManager;

	public static void setEntityManager(EntityManager entityManager) {
		DAOFactoryJPA.entityManager = entityManager;
	}

	public static DAOPokemon createDAOPokemon() {
		return new DAOPokemonJPA(entityManager);
	}

	public static DAOAttaque createDAOAttaque() {
		return new DAOAttaqueJPA(entityManager);
	}
}
