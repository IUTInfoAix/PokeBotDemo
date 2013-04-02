package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.twitter.Tweet;
import fr.univaix.iut.progbd.DAOPokemonJPA;
import fr.univaix.iut.progbd.Pokemon;

public class NoOwnerCatchCell implements SmartCell {
	
	private EntityManagerFactory emf; 
	private EntityManager em;

	public NoOwnerCatchCell() {
    	emf = Persistence.createEntityManagerFactory("pokebattlePU");
        em = emf.createEntityManager();
	}
	@Override
	public String ask(Tweet question) {
		if(question.getText().contains("Pokeball"))
		{	
			// ask contains pcreux: "pcreux: "@pikachuNyanNyan Pokeball!"
			// answer should contains : pikachuNyanNian: "@pcreux @pcreux is my owner"
			
			// Qui veux m'attraper ?
			String ownerAsk = question.getScreenName();
			
			// Quel Pokemon ?
			String[] alias = question.getText().split(" ");
         	String pokemon = alias[0].toUpperCase();
         	pokemon = pokemon.substring(1, pokemon.length());
         	
         	// check owner exist
         	DAOPokemonJPA dao = new DAOPokemonJPA(em);
         	Pokemon poke = dao.getById(pokemon);
         	String pokeOwner = poke.getOwner_poke().getNom_owner();
         	System.out.println("Qui est lowner ?" + pokeOwner);
			//check good owner
			if( pokeOwner != null )
			{
				String answer ="@" + ownerAsk + " @" + pokeOwner + " is my owner";
				System.out.println("Owner :" + answer);
				em.close();
	            emf.close();
				return  answer;
			}
			else 
			{
				poke.getOwner_poke().setNom_owner(ownerAsk);
				String answer = "@" + ownerAsk + " @" + ownerAsk + " is my owner";
				System.out.println("Nouvel owner :" + answer);
				em.close();
	            emf.close();
				return answer;

			}
		}
		em.close();
        emf.close();
		return null;
	}

}
