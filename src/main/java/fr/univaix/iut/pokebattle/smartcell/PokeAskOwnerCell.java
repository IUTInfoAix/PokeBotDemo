package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.jpa.DAOFactoryJPA;
import fr.univaix.iut.pokebattle.jpa.DAOPokemon;
import fr.univaix.iut.pokebattle.jpa.Pokemon;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokeAskOwnerCell implements SmartCell {

    Pokemon poke;
	
    public String getNomPoke(String str)
    {
        String tmp = "";
        for(int i = 0; i < str.length();++i)
        {
            if(str.charAt(i) == ' ') break;
            if(str.charAt(i) == '@') ++i;
            tmp += str.charAt(i);
        }
        return tmp;
    }

    public Pokemon RecupInfo(String texte) {
        String nom = getNomPoke(texte);
        DAOPokemon dao = DAOFactoryJPA.createDAOPokemon();
        Pokemon poke = dao.getById(nom);
        return poke;
    }
	@Override
	public String ask(Tweet question) {
		if(question.getText().contains("Owner?")){
            poke = RecupInfo(question.getText());
            if(poke.getEleveur() != null) {
               String answer = "@" + question.getScreenName() + " @" + poke.getEleveur() + " is my owner";
              return answer;
            }
            else {
                String answer = "@" + question.getScreenName() + " No owner";
                return answer;
            }
		}
		return null;
	}
}











