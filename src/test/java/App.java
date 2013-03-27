import com.google.gson.Gson;

import fr.univaix.iut.pokebattle.beans.DataObjectPokemon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.junit.Test;

public class App 
{
	@Test
	public void test() {
        Gson gson = new Gson();

        BufferedReader br = new BufferedReader(new InputStreamReader(
        									App.class.getClassLoader().getResourceAsStream("pokedex.json")));
        
        //convert the json string back to object
        DataObjectPokemon[] pokeObj = gson.fromJson(br, DataObjectPokemon[].class);

        //System.out.println(Arrays.toString(pokeObj));
        
        for (DataObjectPokemon i : pokeObj)
        	if (i.getNom().equals("Bulbizarre"))
        		System.out.println(i);
	}

}