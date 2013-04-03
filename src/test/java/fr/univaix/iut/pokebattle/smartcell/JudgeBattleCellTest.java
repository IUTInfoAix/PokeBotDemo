package fr.univaix.iut.pokebattle.smartcell;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import twitter4j.TwitterException;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class JudgeBattleCellTest {

	@Test
	public void test() throws IllegalStateException, TwitterException {
		
		JudgeBattleCell cell = new JudgeBattleCell();
		assertEquals( null ,cell.ask(new Tweet("cybsip","@CloudDeLuna #fight with @Smogogo13 /cc @Kyiio") ));
	}

}
