package fr.univaix.iut.pokebattle.smartcell;

import fr.univaix.iut.pokebattle.twitter.Tweet;

public class AttacksValidityCell implements SmartCell {

	@Override
	public String ask(Tweet question) {
		
		// 	ex :
		// 	pcreux: "@bulbizare1 #attack #charge @pikachuNyanNian /cc @nedseb @viviane"
		//  bulbizare1: "@pikachuNyanNian #attack #charge /cc @nedseb @pcreux @viviane"
		//
		//	nedseb: "@pikachuNyanNian #attack #grumpycat @bulbizare1 /cc @pcreux @viviane"
		//	pikachuNyanNian: "@nedseb  o_O ? /cc @pcreux @viviane @bulbizare1"
		//
		//  viviane: "@bulbizare1 -0pv /cc @pcreux"
		//	viviane: "@pikachuNyanNian -10pv /cc @nedseb"


		
		if(question.getText().contains("#Attack"))
		{	
			String alias = question.getText();
			String[] alias2 = alias.split(" ");
			String attaque = alias2[2];
			attaque = attaque.substring(1, attaque.length()); // on retire le '#'
//			if (/* attaque = wrong */ )
//			{
//				String answer = "@" + question.getScreenName() + " o_O ? /cc " + alias2[5] 
//								    + alias2[6] + alias2[4];
//				return answer;
//			}
//			if (/* attaque = right */)
//			{
//				String answer = "@" + alias2[3] + " " + alias2[1] + alias2[2] 
//									+ alias2[4] + alias2[5] + "@" + question.getScreenName()
//									+ alias2[6];
//				return answer;
//			}
			
		}
		return null;
	}
}