package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class OwnAskPkmnAttCellTest {

//	AskOwnerCell cell1 = new AskOwnerCell();
	OwnAskPkmnAtkCell cell = new OwnAskPkmnAtkCell();
	
/*	@Test
	public void AskOwnerTest() {
		assertEquals("@nedseb @nedseb is my owner", cell1.ask(new Tweet("@nedseb", "Owner?")));
	}*/
	
	@Test
	public void OwnerAskAtkTest() {
		assertEquals("@bulbizarre #attack #plaquage! /cc @nedseb", 
				cell.ask(new Tweet("nedseb", "#attack #plaquage @bulbizarre")));
	}
	
}
