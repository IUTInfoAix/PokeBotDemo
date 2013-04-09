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
    @NamedQuery(name = Owner.FIND_BY_PRENOM, query = "SELECT ow FROM Owner ow WHERE ow.Prenom = :prenom"),
    @NamedQuery(name = Owner.FIND_BY_POKEMON, query = "SELECT ow FROM Owner ow WHERE ow.Pokemon = :pokemon"),
    @NamedQuery(name = Owner.COUNT_POKE, query = "SELECT COUNT(ow.Pokemon) FROM Owner ow WHERE ow.Prenom = :prenom"),
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
	private Pokemon Pokemon; 
	
	private String Prenom; 

	
	public Owner() {
		super();
	}
	
	public Owner(Pokemon pokemon, String prenom) {
		super();
		Pokemon = pokemon;
		Prenom = prenom;
	}
	
	public Pokemon getPokemon() {
		return Pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		Pokemon = pokemon;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Pokemon == null) ? 0 : Pokemon.hashCode());
		result = prime * result + ((Prenom == null) ? 0 : Prenom.hashCode());
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
		if (Pokemon == null) {
			if (other.Pokemon != null)
			{
				return false;
			}
		} else if (!Pokemon.equals(other.Pokemon))
		{
			return false;
		}
		if (Prenom == null) {
			if (other.Prenom != null)
			{
				return false;
			}
		} else if (!Prenom.equals(other.Prenom))
		{
			return false;
		}
		return true;
	}

	//////////////////////////////ATTENTION A L'OBJET POKEMON ///////////////////////////////////////////////
	@Override
	public String toString() {
		return "Owner [Pokemon=" + Pokemon.getNom() + ", Prenom=" + Prenom + "]";
	}
	
	
	
	
}
