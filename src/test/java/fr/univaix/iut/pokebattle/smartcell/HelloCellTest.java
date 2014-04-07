package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univaix.iut.pokebattle.bot.PokeBot;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class HelloCellTest {
	
	HelloCell cell = new HelloCell();
    
    
    @Test
    public void testAskHelloFromFollower() throws CloneNotSupportedException {

        assertEquals("@Tristan Hi @Tristan, I am Abo.", cell.ask(new Tweet("Tristan", "Hi, how are you ?")));

    }
    
    @Test
    public void testAskJustHelloFromFollower() throws CloneNotSupportedException {

        assertEquals("@Tristan Hi @Tristan, I am Abo.", cell.ask(new Tweet("Tristan", "Hello")));

    }
    
    @Test
    public void testAskJustHiFromFollower() throws CloneNotSupportedException {

        assertEquals("@Tristan Hi @Tristan, I am Abo.", cell.ask(new Tweet("Tristan", "Hi")));

    }
    
    @Test
    public void testAskHelloFromNoOne() throws CloneNotSupportedException {
        
        assertEquals("Hi, I am Abo.", cell.ask(new Tweet("Hi, how are you ?")));

    }

}
