package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.twitter.Tweet;
import fr.univaix.iut.progbd.DAOOwner;
import fr.univaix.iut.progbd.DAOOwnerJPA;
import fr.univaix.iut.progbd.DAOPokemonJPA;
import fr.univaix.iut.progbd.Owner;
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
         	System.out.println("tests");
         	Owner pokeOwner = poke.getOwner_poke();

         	System.out.println("Qui est lowner ?" + pokeOwner);
			//check good owner
			if( pokeOwner != null )
			{
				String pokeOwnerName = pokeOwner.getNom_owner();
				String answer ="@" + ownerAsk + " @" + pokeOwnerName + " is my owner";
				System.out.println("Owner :" + answer);
				em.close();
	            emf.close();
				return  answer;
			}
			else 
			{
				System.out.println("Aucun Owner");
				
				// Pseudo-code :
				// DAOOwner dao = new DAOOwaner(em)
				
				// Owner newOwner = dao.getById(owernAsk);
				// if newOwner == null
				//   newOwner = dao.create
				// poke.setOwner(newOwner);
				
				DAOOwnerJPA daoOwner = new DAOOwnerJPA(em);
				Owner ownerExist = em.find(Owner.class, ownerAsk);
				if(ownerExist == null)
				{
					Owner own = new Owner(ownerAsk);
					daoOwner.insert(own);
					poke.setOwner_poke(own);
				}
				else
					poke.setOwner_poke(ownerExist);

		
				String pokeOwn = poke.getOwner_poke().getNom_owner();
				String answer = "@" + ownerAsk + " @" + pokeOwn + " is my owner";
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
