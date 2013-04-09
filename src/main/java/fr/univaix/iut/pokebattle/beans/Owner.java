package fr.univaix.iut.pokebattle.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({
    @NamedQuery(name = Owner.FIND_BY_PRENOM, query = "SELECT ow FROM Owner ow WHERE ow.prenom = :prenom"),
    @NamedQuery(name = Owner.FIND_BY_POKEMON, query = "SELECT ow FROM Owner ow WHERE ow.pokemon = :pokemon"),
    @NamedQuery(name = Owner.COUNT_POKE, query = "SELECT COUNT(ow.pokemon) FROM Owner ow WHERE ow.prenom = :prenom"),
    @NamedQuery(name = Owner.FIND_ALL, query = "SELECT ow FROM Owner ow "),
})
public class Owner implements Serializable{

	private static final long serialVersionUID = 8869596535250990885L;
	
	public static final String FIND_BY_PRENOM = "findByPrenom";
	public static final String FIND_BY_POKEMON = "findByPokemon";
	public static final String COUNT_POKE = "CountPokemon";
	public static final String FIND_ALL = "findAll";
	
	@Id 
	@OneToOne 
	@JoinColumn( name = "POKEMON")
	private Pokemon pokemon; 
	
	private String prenom; 

	
	public Owner() {
		super();
	}
	
	public Owner(Pokemon pokemonn, String prenomm) {
		super();
		pokemon = pokemonn;
		prenom = prenomm;
	}
	
	public Pokemon getPokemon() {
		return pokemon;
	}

	public void setPokemon(Pokemon pokemonn) {
		pokemon = pokemonn;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenomm) {
		prenom = prenomm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pokemon == null) ? 0 : pokemon.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
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
		}		Owner other = (Owner) obj;
		if (pokemon == null) {
			if (other.pokemon != null)
			{
				return false;
			}
		} else if (!pokemon.equals(other.pokemon))
		{
			return false;
		}
		if (prenom == null) {
			if (other.prenom != null)
			{
				return false;
			}
		} else if (!prenom.equals(other.prenom))
		{
			return false;
		}
		return true;
	}

	//////////////////////////////ATTENTION A L'OBJET POKEMON ///////////////////////////////////////////////
	@Override
	public String toString() {
		return "Owner [Pokemon=" + pokemon.getNom() + ", Prenom=" + prenom + "]";
	}
	
	
	
	
}
