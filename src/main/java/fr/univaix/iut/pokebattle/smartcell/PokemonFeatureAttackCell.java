package fr.univaix.iut.pokebattle.smartcell;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.DAO.DAOAttacks;
import fr.univaix.iut.pokebattle.DAO.DAOFactory;
import fr.univaix.iut.pokebattle.DAO.DAOPokemon;
import fr.univaix.iut.pokebattle.beans.Attacks;
import fr.univaix.iut.pokebattle.beans.DataObjectAttack;
import fr.univaix.iut.pokebattle.beans.DataObjectPokemon;
import fr.univaix.iut.pokebattle.beans.Pokedex;
import fr.univaix.iut.pokebattle.beans.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;


public class PokemonFeatureAttackCell implements SmartCell {
	
	 public String ask(Tweet question) {
	  	  
	  		if ( question.getText().contains("#statAttack")) 
	  		{
		  		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pokemon");
		  	      EntityManager em = emf.createEntityManager();
		  	      
		  	      String[] phrase = question.getText().split(" ");
		  	      
		  	      DAOFactory daoF = new DAOFactory(em);
		  	      
		  		  DAOPokemon daoPoke = daoF.createDAOPokemon();
				  Pokemon Poke = daoPoke.getByNom(phrase[0]);
				  
				  DAOAttacks daoAtt = daoF.createDAOAttacks();
				  List<Attacks> listAtt = daoAtt.findByPokemon(Poke);
				  
				  String [] var = phrase[3].split("#");
				  String attack = var[1];
				  Attacks att = null;
				  
				  boolean know = false;
				  
				  System.out.println("Test de la connaissance de : " + attack);
				  
				  for (Attacks i : listAtt)
				  {
					  if (i.getAttack().equals(attack))
					  {
						  know = true;
						  att = i;
						  break;
					  }
					  else
						  know = false;
				  }
				  if (know == false)
					  return "@" + question.getScreenName() + " O_o ?";
				  
				  System.out.println("le pokemon connaît l'attaque demandée");
				  
				  //Si on arrive là le pokemon connaît l'attaque demandée
				  
				  Pokedex pok = Pokedex.getInstance();
				  DataObjectPokemon pokemon = pok.getPokemon(Poke.getRace());
				  System.out.println(phrase[0]);
				  DataObjectAttack [] pokemonAttaques = pokemon.getAttaques();
				  DataObjectAttack currAttaque = null;
				  
				  for (DataObjectAttack i : pokemonAttaques)
					  if (i.getNom().equals(att.getAttack()))
						  currAttaque = i;
					  
				  if ( question.getText().contains("#PP")) 
			  	  { 
					  return "@" + question.getScreenName() + " " + att.getAttack() +  " #PP =" 
							  + att.getPP() + "/" + currAttaque.getPp();
			  	  }
			  
	  		}
	  
	 	return null;
	  	
	 }
}
	
