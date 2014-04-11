package fr.univaix.iut.pokebattle.func;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchExtractor {


	// Extrait les mots précédés du caractère donné en paramètre
	// Ex: # pour les hashtags, @ pour les users
	// 
	public String[] matchExtract (String txt, String charr) {

		String regexp = charr + "(\\w+)" ;
		int indexhash = 0;
		String[] reslist = new String[10];
		Pattern pattern = Pattern.compile(regexp);
		Matcher matcher = pattern.matcher(txt);

		while (matcher.find() && indexhash < 10) {
			reslist[indexhash++] = matcher.group();

		}			
		return reslist;

	}
}
