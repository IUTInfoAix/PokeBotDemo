package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class WhenKOCell implements SmartCell {

	@Override
	public String ask(Tweet tweet) {
		
		/*  pcreux: "@bulbizare1 #attack #charge @pikachuNyanNian /cc @nedseb @viviane"
			bulbizare1: "@pikachuNyanNian #attack #charge /cc @nedseb @pcreux @viviane"

			nedseb: "@pikachuNyanNian #attack #foudre @bulbizare1 /cc @pcreux @viviane"
			pikachuNyanNian: "@bulbizare1 #attack #foudre /cc @nedseb @pcreux @viviane"

			viviane: "@bulbizare1 -10pv /cc @pcreux"
			viviane: "@pikachuNyanNian -10pv /cc @nedseb"
		
			bulbizare1: "#KO /cc @viviane @nedseb @pcreux" */

		String texte = tweet.getText();
		String[] tabMots = texte.split(" ");
		
		//if(tabMots[0] est un poké et que ses PV <= 0)
		{	
			String pokeKO = tabMots[0];
			
			String answer = "#KO /cc " /* + @JUGE + */+ " "
					/* + "@DRESSEURVAINQUEUR" + "@PRORIOPOKEKO"*/ ;
			return answer;
		}
		
		//return null;
	}

}
