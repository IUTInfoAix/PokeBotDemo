package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import twitter4j.TwitterException;

import fr.univaix.iut.pokebattle.smartcell.JudgeCell.JudgeBotWinnerCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;


public class JudgeBotWinnerCellTest {

	@Test
	public void test() throws IllegalStateException, TwitterException {
		
		JudgeBotWinnerCell cell = new JudgeBotWinnerCell();
		
		assertEquals("@Smogogo13 #win", cell.ask(new Tweet("GwenGoupix", "#KO /cc @Kyiio @cybsip @CloudDeLuna")));
	}

}
