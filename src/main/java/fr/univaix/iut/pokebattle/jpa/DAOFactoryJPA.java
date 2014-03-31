package fr.univaix.iut.pokebattle.jpa;

import javax.persistence.EntityManager;

public class DAOFactoryJPA {
    private static EntityManager entityManager;

    public static synchronized void setEntityManager(EntityManager entityManager){
        DAOFactoryJPA.entityManager = entityManager;
    }

    public static DAOPokemon createDAOPokemon(){
        return new DAOPokemonJPA(entityManager);
    }
}