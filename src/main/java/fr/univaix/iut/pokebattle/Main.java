package fr.univaix.iut.pokebattle;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	private static List<Attaque> attaques;

	public static void createDatabase() {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("pokebattlePU");
		EntityManager em = emf.createEntityManager();
		
		DAOPokemonJPA daopok = new DAOPokemonJPA(em);
		DAOAttaqueJPA daoattack = new DAOAttaqueJPA(em);
		
		Attaque attack1 = new Attaque();
		attack1.setNomAttaque("Ligotage");
		attack1.setPp(20);
		attack1.setPuissance(15);
		attack1.setPrecision(85);
		daoattack.insert(attack1);
		
		Attaque attack2 = new Attaque();
		attack2.setNomAttaque("Groz'Yeux");
		attack2.setPp(30);
		attack2.setPrecision(100);
		daoattack.insert(attack2);
		
		ArrayList<Attaque> attaques = new ArrayList<Attaque>();
		attaques.add(attack1);
		attaques.add((Attaque) attack2);
		
		Pokemon pok = new Pokemon();
		pok.setName("AboHotelBis");
		pok.setAttaques(attaques);
		pok.setType1(Type.POISON);
		pok.setColor("Violet");
		pok.setOwner(null);
		pok.setXP(0);
		pok.setLevel(1);
		pok.setPVMax(30);
		pok.setPVNow(30);
		pok.setHeight((float) 2.0);
		pok.setWeight((float) 6.9);
		daopok.insert(pok);
	
		
	}
}
