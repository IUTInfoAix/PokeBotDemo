package fr.univaix.iut.pokebattle.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.jpa.Pokemon.Type;

public class Main {

    public static void main(String[] args) {
        // Initializes the Entity manager

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattlePU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Pokemon pikachu = new Pokemon("Pikachu");
        pikachu.setType1(Type.ELECTRIC);
        em.persist(pikachu);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}