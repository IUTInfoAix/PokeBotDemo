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
	
	private EntityManagerFactory emf; 
	private EntityManager em;

	public PokemonCriesCell() {
    	emf = Persistence.createEntityManagerFactory("pokebattlePU");
        em = emf.createEntityManager();
	}
	
    public String ask(Tweet tweet) {
        if (tweet.getScreenName() != null){
            
            String[] alias = tweet.getText().split(" ");
        	String pokemon = alias[0].toUpperCase();
        	pokemon.substring(1, pokemon.length());
        
        	
        	Pokemon poke = em.find(Pokemon.class, "SALAMECHE_PKWEM");
        	System.out.println(poke);
        	String s = poke.getCri();
        	System.out.println(s);

            
        	String r = "@nedseb"+  " "+ poke.getCri();
        	
        	
        	em.close();
            emf.close();
            
            return r;
        }
        else
        	return null;
    }
}