package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class HelloCellTest {

    HelloCell cell = new HelloCell();


    @Test
    public final void testAskHelloFromFollower()
                throws CloneNotSupportedException {
        assertEquals("@Tristan Hi @Tristan, I am Abo.", cell.ask(new Tweet("Tristan", "Hi, how are you ?")));

    }

    @Test
    public final void testAskJustHelloFromFollower()
            throws CloneNotSupportedException {
        assertEquals("@Tristan Hi @Tristan, I am Abo.", cell.ask(new Tweet("Tristan", "Hello")));

    }

    @Test
    public final void testAskJustHiFromFollower()
            throws CloneNotSupportedException {
        assertEquals("@Tristan Hi @Tristan, I am Abo.", cell.ask(new Tweet("Tristan", "Hi")));

    }

    @Test
    public void testAskHelloFromNoOne() throws CloneNotSupportedException {
        
        assertEquals("Hi, I am Abo.", cell.ask(new Tweet("Hi, how are you ?")));

    }

}
