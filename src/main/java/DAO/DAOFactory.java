package DAO;

import javax.persistence.EntityManager;

public class DAOFactory {
	
	private EntityManager entityManager;

	public DAOFactory(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public DAOOwner createDAOOwner() {
		return new DAOOwner(entityManager);
	}

}