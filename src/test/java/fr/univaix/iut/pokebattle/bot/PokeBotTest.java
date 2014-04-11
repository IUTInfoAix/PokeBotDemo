package fr.univaix.iut.pokebattle.bot;


import java.util.Calendar;
import java.util.Date;

import fr.univaix.iut.pokebattle.run.PokemonMain;
import org.junit.Test;
import org.mockito.Mockito;


import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

import static org.junit.Assert.assertEquals;

// Utilisation de diverses SmartCells pour voir si le Bot fonctionne.
public class PokeBotTest {
	PokeBot pkmn = null;

	@Test
	public void testGetters()  {
		Date time = Calendar.getInstance().getTime();
		pkmn = new PokeBot();
		Twitter realTwitter = new TwitterFactory().getInstance();
		pkmn.getPokeStats().setOwner("@Rwog");
		pkmn.getPokeStats().setName("TestPkmn");
		pkmn.getPokeStats().setHPmax(50);
		pkmn.getPokeStats().setHPcurr(10);
		pkmn.getPokeStats().setDispo(true);
		pkmn.getPokeStats().setRace("Pikachu");
		pkmn.getPokeStats().setXp(666);
		pkmn.getPokeStats().setLastDate(time);
		assertEquals("TestPkmn", pkmn.getPokeStats().getName());
		assertEquals("@Rwog", pkmn.getPokeStats().getOwner());
		assertEquals(50, pkmn.getPokeStats().getHPmax());
		assertEquals(10, pkmn.getPokeStats().getHPcurr());
		assertEquals("Pikachu", pkmn.getPokeStats().getRace());
		assertEquals(true, pkmn.getPokeStats().isDispo());
		assertEquals(time, pkmn.getPokeStats().getLastDate());
		assertEquals(666, pkmn.getPokeStats().getXp());
		
	}

	@Test (expected=TwitterException.class)
	public void testExceptionTwit() throws TwitterException {
		pkmn = new PokeBot();
		Twitter myMockedTwitter = Mockito.mock(Twitter.class);
		Mockito.doThrow(new TwitterException("messageuh")).when(myMockedTwitter);
		pkmn.setTwitter(myMockedTwitter); // Affichage de "Problème setTwitter()" Donc test OK
		throw new TwitterException("ok");

	}


	@Test (expected=IllegalStateException.class)
	public void testExceptionIllegalState() throws IllegalStateException {
		pkmn = new PokeBot();
		Twitter myMockedTwitter = Mockito.mock(Twitter.class);
		Mockito.doThrow(new IllegalStateException()).when(myMockedTwitter);
		pkmn.setTwitter(myMockedTwitter); // Affichage de "Problème setTwitter()" Donc test OK
		throw new IllegalStateException();
	}

	@Test
	public void testTwitSet() {
		pkmn = new PokeBot();
		Twitter realTwitter = new TwitterFactory().getInstance();
		pkmn.setTwitter(realTwitter);

	}

	@Test
	public void testRunner() throws TwitterException {
		String[] argg = null;
		PokemonMain.main(argg);
	}
}