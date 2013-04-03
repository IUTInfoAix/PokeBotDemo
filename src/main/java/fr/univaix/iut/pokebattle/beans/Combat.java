package fr.univaix.iut.pokebattle.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({
    @NamedQuery(name = Combat.GET_BY_NOM, query = "SELECT cb FROM Combat cb WHERE  ( cb.Poke_1 = :nom OR cb.Poke_2 = :nom )"),
})
public class Combat implements Serializable {
	
	private static final long serialVersionUID = 4828367638072896806L;

	public static final String GET_BY_NOM = "findCombatEnCoursByNom";
	
	@Id	
	@OneToOne 
	@JoinColumn( name = "POKE_1")
	private Pokemon Poke_1;
	@Id
	@OneToOne 
	@JoinColumn( name = "POKE_2")
	private Pokemon Poke_2;
	
	
	
	public Combat() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Combat(Pokemon poke_1, Pokemon poke_2) {
		super();
		Poke_1 = poke_1;
		Poke_2 = poke_2;
	}



	public Pokemon getPoke_1() {
		return Poke_1;
	}



	public void setPoke_1(Pokemon poke_1) {
		Poke_1 = poke_1;
	}



	public Pokemon getPoke_2() {
		return Poke_2;
	}



	public void setPoke_2(Pokemon poke_2) {
		Poke_2 = poke_2;
	}



	@Override
	public String toString() {
		return "Combat [Poke_1=" + Poke_1.getNom() + ", Poke_2=" + Poke_2.getNom() + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Poke_1 == null) ? 0 : Poke_1.hashCode());
		result = prime * result + ((Poke_2 == null) ? 0 : Poke_2.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Combat other = (Combat) obj;
		if (Poke_1 == null) {
			if (other.Poke_1 != null)
				return false;
		} else if (!Poke_1.equals(other.Poke_1))
			return false;
		if (Poke_2 == null) {
			if (other.Poke_2 != null)
				return false;
		} else if (!Poke_2.equals(other.Poke_2))
			return false;
		return true;
	}

	
	
	

	
}
