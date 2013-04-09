package fr.univaix.iut.pokebattle.bot;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class NurseBotTest {
    NurseBot nurseBot = new NurseBot();
    PokeBot	pokeBot = new PokeBot();

	@Test
	public void test() throws IllegalStateException, TwitterException {
        assertEquals("@GwenGoupix #stat #PV ?", nurseBot.ask(new Tweet("CloudDeLuna", "@JoelleBourgPalet #heal @GwenGoupix")));
	}
	
	@Test
	public void testPV() throws IllegalStateException, TwitterException {
        assertEquals("@JoelleBourgPalet #PV =0/100", pokeBot.ask(new Tweet("JoelleBourgPalet", "@GwenGoupix #stat #PV ?")));
	}
	
	@Test
	public void testHeal() throws IllegalStateException, TwitterException {
        assertEquals(" ", nurseBot.ask(new Tweet("@GwenGoupix", "@JoelleBourgPalet #PV =0/100")));
	}
	
	@Test
	public void testDringDring() throws IllegalStateException, TwitterException {
        assertEquals("@CloudDeLuna @GwenGoupix is restored to full health", nurseBot.ask(new Tweet("@PokeTimer", "@JoelleBourgPalet #DringDring #MaxHealth 100 @GwenGoupix @CloudDeLuna")));
	}

}
