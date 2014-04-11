//package fr.univaix.iut.pokebattle.bot;
//
//import com.google.common.collect.Lists;
//import fr.univaix.iut.pokebattle.smartcell.SmartCell;
//import fr.univaix.iut.pokebattle.twitter.Tweet;
//
//import java.util.List;
//
//import twitter4j.Twitter;
//
//
//public class JudgeBot implements Bot {
//    /**
//     * List of smartcell the questions go through to
//     * find an answer.
//     */
//    private final List<SmartCell> smartCells = Lists.newArrayList();
//
//    /**
//     * Ask something to Bot, it will respond to you.
//     *
//     * @param question The question you ask.
//     * @return An answer... or null if it doesn't get it.
//     */
//    @Override
//    public String ask(Tweet question) {
//        for (SmartCell cell : smartCells) {
//            String answer = cell.ask(question);
//            if (answer != null) {
//                return answer;
//            }
//        }
//        return null;
//    }
//
//	@Override
//	public void setTwitter(Twitter twit) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void setStats() {
//		// TODO Auto-generated method stub
//		
//	}
//
//}
