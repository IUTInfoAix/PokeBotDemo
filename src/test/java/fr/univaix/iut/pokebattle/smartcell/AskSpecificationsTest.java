package fr.univaix.iut.pokebattle.smartcell;
import static org.junit.Assert.*;

import org.junit.Test;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class AskSpecificationsTest {
    AskSpecificationsCell cell = new AskSpecificationsCell();

    @Test
    public final void testAskLevel() {
       

        assertEquals("#level = 1", cell.ask(new Tweet(
                "CaptainObvious", "#STAT #LEVEL")));
    }

    @Test
    public final void testAskLevelColle() {
       

        assertEquals("#level = 1", cell.ask(new Tweet(
                "CaptainObvious", "#STAT#LEVEL")));
    }

    @Test
    public final void testAskLevelEspace() {
       

        assertEquals("#level = 1", cell.ask(new Tweet(
                "CaptainObvious", " #STAT #LEVEL")));
    }

    @Test
    public final void testAskLevelEspaceColle() {
       

        assertEquals("#level = 1", cell.ask(new Tweet(
                "CaptainObvious", " #STAT#LEVEL")));
    }

    @Test
    public final void testAskPV() {
       

        assertEquals("#PV = 100", cell.ask(new Tweet(
                "CaptainObvious", "#STAT #PV")));
    }

    @Test
    public final void testAskPVColle() {
       

        assertEquals("#PV = 100", cell.ask(new Tweet(
                "CaptainObvious", "#STAT#PV")));
    }

    @Test
    public final void testAskPVEspace() {
       

        assertEquals("#PV = 100", cell.ask(new Tweet(
                "CaptainObvious", " #STAT #PV")));
    }

    @Test
    public final void testAskPVEspaceColle() {
       

        assertEquals("#PV = 100", cell.ask(new Tweet(
                "CaptainObvious", " #STAT#PV")));
    }

    @Test
    public final void testAskXP() {
       

        assertEquals("#XP = 0", cell.ask(new Tweet(
                "CaptainObvious", "#STAT #XP")));
    }

    @Test
    public final void testAskXPColle() {
       

        assertEquals("#XP = 0", cell.ask(new Tweet(
                "CaptainObvious", "#STAT#XP")));
    }

    @Test
    public final void testAskXPEspace() {
       

        assertEquals("#XP = 0", cell.ask(new Tweet(
                "CaptainObvious", " #STAT #XP")));
    }

    @Test
    public final void testAskXPEspaceColle() {
       

        assertEquals("#XP = 0", cell.ask(new Tweet(
                "CaptainObvious", " #STAT#XP")));
    }
}
