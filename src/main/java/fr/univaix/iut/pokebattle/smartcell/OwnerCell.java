package fr.univaix.iut.pokebattle.smartcell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.DAOFactoryJPA;
import fr.univaix.iut.pokebattle.DAOPokemon;
import fr.univaix.iut.pokebattle.DAOPokemonJPA;
import fr.univaix.iut.pokebattle.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class OwnerCell implements SmartCell {

    public OwnerCell() { }

    @Override
    public String ask(Tweet question) {
    	
        DAOPokemon DAO = DAOFactoryJPA.createDAOPokemon();
        Pokemon pokemon = DAO.getById("AboHotelBis");;
        
        String asking = question.getText().toUpperCase();
        if (asking.contains("OWNER")) {
            if (pokemon.getOwner() != null) {
               String answer = "@" + question.getScreenName()
                       + " My owner is @"
                       + pokemon.getOwner() + ".";

               
               return answer;
            } else {
                return "@" + question.getScreenName() + " I don't have owner.";
            }
        }
        return null;
    }
}