package fr.univaix.iut.pokebattle.smartcell.PokeCell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univaix.iut.pokebattle.DAO.DAOCombat;
import fr.univaix.iut.pokebattle.DAO.DAOFactory;
import fr.univaix.iut.pokebattle.DAO.DAOOwner;
import fr.univaix.iut.pokebattle.DAO.DAOPokemon;
import fr.univaix.iut.pokebattle.beans.Combat;
import fr.univaix.iut.pokebattle.beans.Owner;
import fr.univaix.iut.pokebattle.beans.Pokemon;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonKOCell implements SmartCell {

	@Override
	public String ask(Tweet question){
		if (question.getText().contains("pv")) 
		{
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pokemon");
			EntityManager em = emf.createEntityManager();
			
			DAOFactory daof = new DAOFactory(em);
			
			DAOPokemon daoPoke = daof.createDAOPokemon();
			DAOCombat daocombat = daof.createDAOCombat();
			
			String[] phrase = question.getText().split(" ");
			Pokemon Poke = daoPoke.getByNom(phrase[0]);
			Combat Cb = daocombat.getByPokemon(Poke);
			Pokemon poke1 = Cb.getPoke_1();
			Pokemon poke2 = Cb.getPoke_2();
			
			
			
			DAOOwner daoow = daof.createDAOOwner();
			Owner ow1 = daoow.getByPokemon(poke1);
			Owner ow2 = daoow.getByPokemon(poke2);
			
			
			int PVPoke = Poke.getPV();
			System.out.println(PVPoke);
			
			if (PVPoke == 0 || PVPoke < 0 )
			{
				return "#KO /cc @" + question.getScreenName() + " " 
			+ (Poke.equals(poke1) ? ow2.getPrenom() : ow1.getPrenom()) + " " + (Poke.equals(poke1) ? ow1.getPrenom() : ow2.getPrenom()) ;
			}
			else
			{
				return null;
			}
		}
		return null;
	}
}
