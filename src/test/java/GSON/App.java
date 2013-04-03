package GSON;

import fr.univaix.iut.pokebattle.beans.DataObjectPokemon;
import fr.univaix.iut.pokebattle.beans.Pokedex;

import org.junit.Test;

public class App 
{
	@Test
	public void test() {
		
        Pokedex pok = Pokedex.getInstance();
        //convert the json string back to object
        DataObjectPokemon pokeObj = pok.getPokemon("Goupix");
        System.out.println(pokeObj);
	}
}