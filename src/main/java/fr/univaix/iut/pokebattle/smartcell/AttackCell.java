package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.twitter.Tweet;
import fr.univaix.iut.progbd.DAOPokemonJPA;
import fr.univaix.iut.progbd.Owner;
import fr.univaix.iut.progbd.Pokemon;

public class AttackCell implements SmartCell {
	
	private EntityManagerFactory emf; 
	private EntityManager em;

	public AttackCell() {
    	emf = Persistence.createEntityManagerFactory("pokebattlePU");
        em = emf.createEntityManager();
	}
	
	public String ask(Tweet tweet) {
		if(tweet.getText().contains("#attack"))
		{	
			// ask contains pcreux: "@pikachuNyanNian #attack #foudre @bulbizare1"
			// answer should contains : "pikachuNyanNian: "@bulbizare1 #attack #foudre! /cc @pcreux"
			
			System.out.println("AttackCell");
			
			String alias = tweet.getText();
			String[] alias2 = alias.split(" ");
			String pokemonAttacked = alias2[3];
			String attackName = alias2[2];
			String pokemon = alias2[0].toUpperCase();
         	pokemon = pokemon.substring(1, pokemon.length());
			String dresseur = tweet.getScreenName();
			
			
			/*check good owner*/
			DAOPokemonJPA dao = new DAOPokemonJPA(em);
         	Pokemon poke = dao.getById(pokemon);
         	Owner pokeOwnerObj = poke.getOwner_poke();
         	
         	String pokeOwner;
         	if(pokeOwnerObj != null)
         	{
         		pokeOwner = pokeOwnerObj.getNom_owner();
         		System.out.println("Le Pokemon a un dresseur :" + pokeOwner);
         		System.out.println(dresseur);
	         	if(pokeOwner.equals(dresseur))
	         	{
	         		System.out.println("Le Pokemon attaque a cause de son dresseur");
	         		return pokemonAttacked + " #attack " + attackName
					          + "! /cc " + "@" + pokeOwner;	
	         	}
	         	else
	         	{
	         		return "@" + tweet.getScreenName() + " @" + pokeOwner + " is my owner";
	         	}
         	}
         	else
         	{
         		System.out.println("Le Pokemon n'a pas de dresseur");
         		return "@" + dresseur + " @" + dresseur + " is my owner";
         	}
         		
		}
		System.out.println("WTF");
		em.close();
        emf.close();
		return null;
	}

}
