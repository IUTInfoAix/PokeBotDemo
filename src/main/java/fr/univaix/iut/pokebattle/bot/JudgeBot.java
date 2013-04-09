package fr.univaix.iut.pokebattle.bot;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.smartcell.JudgeCell.JudgeBattleCell;
import fr.univaix.iut.pokebattle.smartcell.JudgeCell.JudgeBotPVCell;
import fr.univaix.iut.pokebattle.smartcell.JudgeCell.JudgeBotWinnerCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;


public class JudgeBot implements Bot {
    /**
     * List of smartcell the questions go through to
     * find an answer.
     */

	private final SmartCell[] smartCells = new SmartCell[]{
    		new JudgeBotPVCell(),
    		new JudgeBotWinnerCell(),
    		new JudgeBattleCell(),
    };


	public SmartCell[] getSmartCells() {
		return smartCells;
	}


	/**
     * Ask something to Bot, it will respond to you.
     *
     * @param question The question you ask.
     * @return An answer... or null if it doesn't get it.
     * @throws TwitterException 
     * @throws IllegalStateException 
     */
    @Override
    public String ask(Tweet question) throws TwitterException {
        for (SmartCell cell : smartCells) {
            String answer; 
            answer = cell.ask(question);
            
            if ( answer != null && answer.equals("skip") ) 
            {
            	return null;
            }
            
            if (answer != null)
            {
                return answer;
            }
        }
        return null;
    }

}
