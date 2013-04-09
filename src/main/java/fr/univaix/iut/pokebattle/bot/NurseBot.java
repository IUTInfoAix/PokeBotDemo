package fr.univaix.iut.pokebattle.bot;

import twitter4j.TwitterException;
import fr.univaix.iut.pokebattle.smartcell.SmartCell;
import fr.univaix.iut.pokebattle.smartcell.Nurse.NursePVCell;
import fr.univaix.iut.pokebattle.smartcell.Nurse.NursePokeCenterCell;
import fr.univaix.iut.pokebattle.smartcell.Nurse.NurseWakeUpPokeCell;
import fr.univaix.iut.pokebattle.twitter.Tweet;

public class NurseBot implements Bot {
   
	 final SmartCell[] smartCells = new SmartCell[]{
			 new NursePVCell(),
			 new NursePokeCenterCell(),
			 new NurseWakeUpPokeCell(),
	 };
	 
    /**
     * Ask something to Bot, it will respond to you.
     *
     * @param question The question you ask.
     * @return An answer... or null if it doesn't get it.
     * @throws TwitterException 
     * @throws IllegalStateException 
     */
    @Override
    public String ask(Tweet question) throws IllegalStateException, TwitterException {
        for (SmartCell cell : smartCells) {
            String answer; 
            answer = cell.ask(question);
            if (answer != null)
                return answer;
        }
        return null;
    }

}