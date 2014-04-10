package fr.univaix.iut.pokebattle.bot;

import fr.univaix.iut.pokebattle.smartcell.*;
import fr.univaix.iut.pokebattle.twitter.Tweet;
import fr.univaix.iut.pokebattle.twitter.UpdateBioCell;
import twitter4j.Twitter;
import twitter4j.TwitterException;


public class PokeBot implements Bot {

    private UpdateBioCell updateBioCell;

    /**
     * List of smartcell the questions go through to
     * find an answer.
     */
    private final SmartCell[] smartCells = new SmartCell[]{
            new PokeTrollCell(),
    		new PokeDonneCarac(),
            new PokeAskOwnerCell(),
            new OwnAskPkmnAtkCell(),
            new CatchPokeWithoutOwner(),
            new LibPokeCell(),
            new PokeKOCell(),
            new PokemonCriesCell(),
    };

    /**
     * Ask something to Bot, it will respond to you.
     *
     * @param question The question you ask.
     * @return An answer... or null if it doesn't get it.
     */
    @Override
    public String ask(Tweet question) throws TwitterException {
        for (SmartCell cell : smartCells) {
            String answer = cell.ask(question);
            if (answer != null) {
                return answer;
            }
        }
        return null;
    }

    public void setTwitter(Twitter twitter) {
        this.updateBioCell = UpdateBioCell.getInstance();
        this.updateBioCell.setTwitter(twitter);
    }

}
