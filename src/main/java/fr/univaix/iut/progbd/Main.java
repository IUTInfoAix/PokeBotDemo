package fr.univaix.iut.progbd;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // Initializes the Entity manager

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattlePU");
        EntityManager em = emf.createEntityManager();

        /*em.getTransaction().begin();

        Pokemon pikachu = new Pokemon("Pikachu");
        pikachu.setType1(Type.ELECTRIC);
        em.persist(pikachu);

        em.getTransaction().commit();
        
        System.out.println(em.find(Pokemon.class, "Pikachu"));
        
        Thread.currentThread().sleep(10000);

        Pokemon msupp = em.find(Pokemon.class, "Pikachu");
        em.getTransaction().begin();
        em.remove(msupp);
        em.getTransaction().commit();

        em.close();
        emf.close();
        
        Owner paul = new Owner("Pikachu");
        em.persist(pikachu);

        em.getTransaction().commit();
        
        System.out.println(em.find(Owner.class, "Pikachu"));
        
        Thread.currentThread().sleep(10000);

        Owner msuppe = em.find(Owner.class, "Pikachu");
        em.getTransaction().begin();
        em.remove(msuppe);
        em.getTransaction().commit();

        em.close();
        emf.close();*/
        

    	
        
        //System.out.println(own.getNom_owner() + " a capturé " + poke.getName());
        
        em.close();
        emf.close();
        
    }
}