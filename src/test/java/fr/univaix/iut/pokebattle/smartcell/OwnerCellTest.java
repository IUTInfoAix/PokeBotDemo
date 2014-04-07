package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class OwnerCellTest {

	OwnerCell cell = new OwnerCell();

    
    @Test
    public void testAskNoOwner() throws CloneNotSupportedException {
        
        
        assertEquals("@Tristan I don't have owner.", cell.ask(new Tweet("Tristan", "Do you have an owner ?")));

    }
    
    @Test
    public void testASkOwner() throws CloneNotSupportedException {
        assertEquals("@Tristan My owner is @CaptainObvious.", cell.ask(new Tweet("Tristan", "Do you have an owner ?")));

    }

}
