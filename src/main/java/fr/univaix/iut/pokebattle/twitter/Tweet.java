package fr.univaix.iut.pokebattle.twitter;

import java.util.ArrayList;

public class Tweet {
    private String text;
    private String screenName;
    private ArrayList<String> hashTag = new ArrayList<String>();

    public Tweet(final String text) {
        this.text = text;
        // parcours le tweet
        for (int i = 0; i < text.length(); i++) {
            // s'arrete si il croise un hashtag
            if (text.charAt(i) == '#') {
                String hashtag = new String("");
                // vérifie si le caractere met fin au hashtag
                for ( ; Character.isLetterOrDigit(text.charAt(++i));) {
                    hashtag += text.charAt(i);
                    if (i >= text.length() - 1) {
                        break;
                    }

                }
                hashTag.add(hashtag);
            }
        }
    }

    public Tweet(final String nom, final String text) {
        this.screenName = nom;
        this.text = text;

     // parcours le tweet
        for (int i = 0; i < text.length(); i++) {
            // s'arrete si il croise un hashtag
            if (text.charAt(i) == '#') {
                String hashtag = new String("");
                // vérifie si le caractere met fin au hashtag
                for ( ; Character.isLetterOrDigit(text.charAt(++i));) {
                    hashtag += text.charAt(i);
                    if (i >= text.length() - 1) {
                        break;
                    }
                }
                hashTag.add(hashtag);
            }
        }
    }

    public final String getScreenName() {
        return screenName;
    }

    public final String getText() {
        return text;
    }

    public final String getHashTag(final int i) {
        return hashTag.get(i);
    }
}
