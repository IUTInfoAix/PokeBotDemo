package fr.univaix.iut.pokebattle.beans;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import com.google.gson.Gson;

public final class Pokedex {
	
	private static Pokedex pok = null;
	
    private Gson gson;
    private BufferedReader br;
    private DataObjectPokemon[] data;

	private Pokedex() {
		gson = new Gson();
		br = new BufferedReader(new InputStreamReader(
				Pokedex.class.getClassLoader().getResourceAsStream("pokedex.json")));
		data = gson.fromJson(br, DataObjectPokemon[].class);
	}
	
	public static Pokedex getInstance()
	{
		if (pok != null)
		{
			return pok;
		}
		pok = new Pokedex();
		return pok;
	}
	
	public DataObjectPokemon getPokemon (String pok)
	{		
        for (DataObjectPokemon  pokemon: data)
        {
        	if (pokemon.getNom().equals(pok))
        	{
        		return pokemon;
        	}
        }
		return null;
	}

	public DataObjectPokemon[] getData ()
	{		
		return data;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((br == null) ? 0 : br.hashCode());
		result = prime * result + Arrays.hashCode(data);
		result = prime * result + ((gson == null) ? 0 : gson.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		Pokedex other = (Pokedex) obj;
		if (br == null) {
			if (other.br != null)
			{
				return false;
			}
		} else if (!br.equals(other.br))
		{
			return false;
		}
		if (!Arrays.equals(data, other.data))
		{
			return false;
		}
		if (gson == null) {
			if (other.gson != null)
			{
				return false;
			}
		} else if (!gson.equals(other.gson))
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Pokedex [data=" + Arrays.toString(data) + "]";
	}
}
