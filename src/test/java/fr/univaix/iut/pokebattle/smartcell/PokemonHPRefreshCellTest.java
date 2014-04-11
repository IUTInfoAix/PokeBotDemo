package fr.univaix.iut.pokebattle.smartcell;


import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import org.junit.Test;
import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class PokemonHPRefreshCellTest {

	PokeBot pkmn = new PokeBot();
	PokemonHPRefreshCell cell = new PokemonHPRefreshCell(pkmn.getPokeStats());
	
	@Test
	public void testWaitedOneHour() {
		pkmn.getPokeStats().setHPmax(100);
		pkmn.getPokeStats().setHPcurr(0);
		pkmn.getPokeStats().setLastDate(Calendar.getInstance().getTime());
		long before = pkmn.getPokeStats().getLastDate().getTime();
		long now = Calendar.getInstance().getTime().getTime()+61; // 61min plus tard
		System.out.println(now-before);
		System.out.println("HP:" + pkmn.getPokeStats().getHPcurr()+"/"+pkmn.getPokeStats().getHPmax());		
		assertEquals("next_cell",cell.ask(new Tweet("")));
		
		 
	}

}
