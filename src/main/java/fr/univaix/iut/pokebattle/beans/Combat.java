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
    @NamedQuery(name = Combat.GET_BY_OWNER, query = "SELECT cb FROM Combat cb WHERE  ( cb.Owner_1 = :nom OR cb.Owner_2 = :nom )"),
    @NamedQuery(name = Combat.GET_MAX_NUM_CB, query = "SELECT MAX(cb.IdCombat) FROM Combat cb"),
})
public class Combat implements Serializable {
	
	private static final long serialVersionUID = 4828367638072896806L;

	public static final String GET_BY_NOM = "findCombatEnCoursByPokemon";
	public static final String GET_BY_OWNER = "findCombatEnCoursByOwner";
	public static final String GET_MAX_NUM_CB = "findMaxNumCB";
	
	
	@Id 
	@Column( name = "NUM_CB")
	private int IdCombat ;
	
	
	@OneToOne 
	@JoinColumn( name = "POKE_1")
	private Pokemon Poke_1;
	

	private String Owner_1;

	@OneToOne 
	@JoinColumn( name = "POKE_2")
	private Pokemon Poke_2;
	 
	private String Owner_2;
	
	
	public Combat() {
		super();
	}
	

	public Combat(int idCombat, Pokemon poke_1, String owner_1, Pokemon poke_2,
			String owner_2) {
		super();
		IdCombat = idCombat;
		Poke_1 = poke_1;
		Owner_1 = owner_1;
		Poke_2 = poke_2;
		Owner_2 = owner_2;
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


	public String getOwner_1() {
		return Owner_1;
	}


	public void setOwner_1(String owner_1) {
		Owner_1 = owner_1;
	}


	public String getOwner_2() {
		return Owner_2;
	}


	public void setOwner_2(String owner_2) {
		Owner_2 = owner_2;
	}


	public int getIdCombat() {
		return IdCombat;
	}


	public void setIdCombat(int idCombat) {
		IdCombat = idCombat;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + IdCombat;
		result = prime * result + ((Owner_1 == null) ? 0 : Owner_1.hashCode());
		result = prime * result + ((Owner_2 == null) ? 0 : Owner_2.hashCode());
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
		if (IdCombat != other.IdCombat)
			return false;
		if (Owner_1 == null) {
			if (other.Owner_1 != null)
				return false;
		} else if (!Owner_1.equals(other.Owner_1))
			return false;
		if (Owner_2 == null) {
			if (other.Owner_2 != null)
				return false;
		} else if (!Owner_2.equals(other.Owner_2))
			return false;
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


	@Override
	public String toString() {
		return "Combat [IdCombat=" + IdCombat + ", Poke_1=" + Poke_1.getNom()
				+ ", Owner_1=" + Owner_1 + ", Poke_2=" + Poke_2.getNom() + ", Owner_2="
				+ Owner_2 + "]";
	}


	
	
}