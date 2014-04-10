package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.twitter.Tweet;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokeTrollCellTest {

    PokeTrollCell cell = new PokeTrollCell();
    @Test
    public void testAsk() throws Exception {
        assertEquals("@slydevis Trolol http://www.dailymotion.com/video/xtczcf_gandalf-epic-sax-guy_fun",
                cell.ask(new Tweet("slydevis", "@Ronflaix Troll")));
    }
}
