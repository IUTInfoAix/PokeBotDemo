package fr.univaix.iut.pokebattle.DAO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.junit.Test;

import scala.App;

import com.google.gson.Gson;

import fr.univaix.iut.pokebattle.beans.DataObjectPokemon;

public class DAOAttacksTest {

	@Test
	public void test() {
		
        Gson gson = new Gson();

        BufferedReader br = new BufferedReader(new InputStreamReader(
        									App.class.getClassLoader().getResourceAsStream("pokedex.json")));
        
        //convert the json string back to object
        DataObjectPokemon[] pokeObj = gson.fromJson(br, DataObjectPokemon[].class);
        for (DataObjectPokemon i : pokeObj)
        	if (i.getNom().equals("Goupix"))
        		System.out.println(i);
	}

}
