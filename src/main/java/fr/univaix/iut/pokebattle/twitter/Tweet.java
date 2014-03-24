package fr.univaix.iut.pokebattle.twitter;

import java.util.ArrayList;

public class Tweet {
    private String text;
    private String screenName;
    private ArrayList<String> hashTag = new ArrayList<String>();

    public Tweet(String text) {
        this.text = text;
    }

    public Tweet(String screenName, String text) {
    	this.screenName = screenName;
        this.text = text;
        
        for (int i = 0; i < text.length() ; i++) {							// parcours le tweet
        	if (text.charAt(i) == '#') 										// s'arrete si il croise un hashtag
        	{
        		String hashtag = new String("");
        		System.out.print(hashtag);
        		System.out.println(i);
        		for ( ; Character.isLetterOrDigit(text.charAt(++i)) && i < text.length(); )		// vérifie si le caractere met fin au hashtag
        		{
        			hashtag += text.charAt(i);
            		System.out.print(hashtag);
            		System.out.println(i);
        		}
        		hashtag += text.charAt(i);
        		System.out.print(hashtag);
        		System.out.println(i);
        		
        		hashTag.add(hashtag);
        	} 
        }
    }

    public String getScreenName() {
        return screenName;
    }

    public String getText() {
        return text;
    }

	public String getHashTag(int i) {
		return hashTag.get(i);
	}
}
