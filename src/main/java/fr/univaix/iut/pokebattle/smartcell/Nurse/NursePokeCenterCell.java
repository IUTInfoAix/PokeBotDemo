package fr.univaix.iut.pokebattle.smartcell.Nurse;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import fr.univaix.iut.pokebattle.DAO.DAOFactory;
import fr.univaix.iut.pokebattle.DAO.DAOOwner;
import fr.univaix.iut.pokebattle.DAO.DAOPokemon;
import fr.univaix.iut.pokebattle.beans.Owner;
import fr.univaix.iut.pokebattle.beans.Pokemon;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class NursePokeCenterCell implements SmartCell {
	
	public String ask(Tweet question) throws IllegalStateException, TwitterException {	
		
		if ( question.getText().contains("#PV")) 
		{
			Twitter twitter = TwitterFactory.getSingleton();
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pokemon");
	        EntityManager em = emf.createEntityManager();
			DAOFactory daof = new DAOFactory(em);
			DAOOwner daoOwn = daof.createDAOOwner();
			DAOPokemon daoPoke = daof.createDAOPokemon();
			
			String[] phrase = question.getText().split(" ");
			
			String pokeName = question.getScreenName();
	
			Pokemon poke = daoPoke.getByNom(pokeName);
			Owner owner = daoOwn.getByPokemon(poke);
			
			if ( question.getText().contains("100/100"))
			{
				return pokeName + " full life /cc " + owner.getPrenom();
			}
					
			//Twitter twitter = question.getTwitter();
			
			String[] dieze = question.getText().split("#");
			System.out.println(dieze[1]);
			String[] egale = dieze[1].split("=");
			System.out.println(egale[1]);
			String[] nombre = egale[1].split("/");
			System.out.println(nombre[0]);
			System.out.println(nombre[1]);
			
			int timewu = (Integer.parseInt(nombre[1]) - Integer.parseInt(nombre[0]))/10;
			System.out.println(timewu);
			
			twitter.updateStatus("@PokeTimer #WakeMeUp 1 Min #MaxHealth " 
									+ nombre[1] 
											+ " " 
									+ pokeName + " " 
											+ owner.getPrenom() + " vv");			
	
		    return pokeName + " come in the #pokecenter /cc " + owner.getPrenom();

		}
		return null;

	}//ask ()


}
