package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.*;
import fr.univaix.iut.pokebattle.twitter.Tweet;
import org.junit.Test;
import fr.univaix.iut.pokebattle.bot.PokeBot;

public class PokemonStatsCellTest {

	PokeBot pkmn = new PokeBot();
	
	public void setStat() {
		pkmn.getPokeStats().setName("Forkachu");
		pkmn.getPokeStats().setOwner("Rwog");
		pkmn.getPokeStats().setRace("Pikachu");
		pkmn.getPokeStats().setXp(42);
		pkmn.getPokeStats().setLevel(2);
		pkmn.getPokeStats().setHPmax(50);
		pkmn.getPokeStats().setHPcurr(10);
	}

	@Test
	public void testAskStatLevel(){
		setStat();
		assertEquals("@testuser #level=2", pkmn.ask(new Tweet("testuser", "@forkachu #stat #level ?")));
	}
	
	@Test
	public void testAskStatXP(){
		setStat();
		assertEquals("@testuser #XP=42", pkmn.ask(new Tweet("testuser", "@forkachu #stat #XP ?")));
	}
	
	@Test
	public void testAskStatHP(){
		setStat();
		assertEquals("@testuser #PV=10/50", pkmn.ask(new Tweet("testuser", "@forkachu #stat #PV ?")));
	}
	
	@Test
	public void testAskMultipleStats(){
		setStat();
		assertEquals("@testuser #level=2 #PV=10/50", pkmn.ask(new Tweet("testuser", "@forkachu #stat #level #PV ?")));
	}
	
	@Test
	public void testAskMultipleStats2(){
		setStat();
		assertEquals("@testuser #level=2 #PV=10/50", pkmn.ask(new Tweet("testuser", "@forkachu #stat #level #PV ?")));
	}
	
	@Test
	public void testAskMultipleStats3(){
		setStat();
		assertEquals("@testuser #PV=10/50 #XP=42", pkmn.ask(new Tweet("testuser", "@forkachu #XP #stat #PV ?")));
	}
	
	
}
