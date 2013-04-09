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
    @NamedQuery(name = Combat.GET_BY_NOM, query = "SELECT cb FROM Combat cb WHERE  ( cb.poke_1 = :nom OR cb.poke_2 = :nom )"),
    @NamedQuery(name = Combat.GET_BY_OWNER, query = "SELECT cb FROM Combat cb WHERE  ( cb.owner_1 = :nom OR cb.owner_2 = :nom )"),
    @NamedQuery(name = Combat.GET_MAX_NUM_CB, query = "SELECT MAX(cb.idCombat) FROM Combat cb"),
})
public class Combat implements Serializable {
	
	private static final long serialVersionUID = 4828367638072896806L;

	public static final String GET_BY_NOM = "findCombatEnCoursByPokemon";
	public static final String GET_BY_OWNER = "findCombatEnCoursByOwner";
	public static final String GET_MAX_NUM_CB = "findMaxNumCB";
	
	
	@Id 
	@Column( name = "NUM_CB")
	private int idCombat ;
	
	
	@OneToOne 
	@JoinColumn( name = "POKE_1")
	private Pokemon poke_1;
	

	private String owner_1;

	@OneToOne 
	@JoinColumn( name = "POKE_2")
	private Pokemon poke_2;
	 
	private String owner_2;
	
	
	public Combat() {
		super();
	}
	

	public Combat(int idCombatt, Pokemon poke_1e, String owner_1e, Pokemon poke_2e,
			String owner_2e) {
		super();
		idCombat = idCombatt;
		poke_1 = poke_1e;
		owner_1 = owner_1e;
		poke_2 = poke_2e;
		owner_2 = owner_2e;
	}


	public Pokemon getPoke_1() {
		return poke_1;
	}


	public void setPoke_1(Pokemon poke_1e) {
		poke_1 = poke_1e;
	}

	

	public Pokemon getPoke_2() {
		return poke_2;
	}


	public void setPoke_2(Pokemon poke_2e) {
		poke_2 = poke_2e;
	}


	public String getOwner_1() {
		return owner_1;
	}


	public void setOwner_1(String owner_1e) {
		owner_1 = owner_1e;
	}


	public String getOwner_2() {
		return owner_2;
	}


	public void setOwner_2(String owner_2e) {
		owner_2 = owner_2e;
	}


	public int getIdCombat() {
		return idCombat;
	}


	public void setIdCombat(int idCombatt) {
		idCombat = idCombatt;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCombat;
		result = prime * result + ((owner_1 == null) ? 0 : owner_1.hashCode());
		result = prime * result + ((owner_2 == null) ? 0 : owner_2.hashCode());
		result = prime * result + ((poke_1 == null) ? 0 : poke_1.hashCode());
		result = prime * result + ((poke_2 == null) ? 0 : poke_2.hashCode());
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
		if (idCombat != other.idCombat)
			return false;
		if (owner_1 == null) {
			if (other.owner_1 != null)
				return false;
		} else if (!owner_1.equals(other.owner_1))
			return false;
		if (owner_2 == null) {
			if (other.owner_2 != null)
				return false;
		} else if (!owner_2.equals(other.owner_2))
			return false;
		if (poke_1 == null) {
			if (other.poke_1 != null)
				return false;
		} else if (!poke_1.equals(other.poke_1))
			return false;
		if (poke_2 == null) {
			if (other.poke_2 != null)
				return false;
		} else if (!poke_2.equals(other.poke_2))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Combat [IdCombat=" + idCombat + ", Poke_1=" + poke_1.getNom()
				+ ", Owner_1=" + owner_1 + ", Poke_2=" + poke_2.getNom() + ", Owner_2="
				+ owner_2 + "]";
	}


	
	
}