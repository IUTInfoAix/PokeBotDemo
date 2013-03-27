package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.twitter.Tweet;
import fr.univaix.iut.progbd.Pokemon;

/**
 * Reply to all.
 */
public class PokemonCriesCell implements SmartCell {
    public String ask(Tweet tweet) {
        if (tweet.getScreenName() != null){
        	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pokebattlePU");
            EntityManager em = emf.createEntityManager();
            
            String[] alias = tweet.getText().split(" ");
        	String pokemon = alias[0].toUpperCase();
        	pokemon.substring(1, pokemon.length());

        	Pokemon poke = em.find(Pokemon.class, "CHENIPAN_PKWEM");
        	System.out.println(poke);
        	em.close();
            emf.close();
        	return "@nedseb"+ " Sala sala";// + poke.getCri();
        }
        else
        	return null;
    }
}