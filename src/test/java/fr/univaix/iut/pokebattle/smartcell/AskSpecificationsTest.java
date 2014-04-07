package fr.univaix.iut.pokebattle.smartcell;
import static org.junit.Assert.*;

import org.junit.Test;

import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class AskSpecificationsTest {
	AskSpecificationsCell cell = new AskSpecificationsCell();
	
	@Test
	public void TestAskPV(){
		PokeBot pokeBot = new PokeBot();
		
		assertEquals("#level = 1", cell.ask(new Tweet("CaptainObvious", "@AboHotel #stat #level")));
	}
}
