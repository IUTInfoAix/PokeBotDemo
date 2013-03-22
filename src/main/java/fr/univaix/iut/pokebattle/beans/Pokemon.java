package fr.univaix.iut.pokebattle.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name = Pokemon.FIND_BY_NOM, query = "SELECT poke FROM Pokemon poke WHERE poke.Nom = :nom"),
    @NamedQuery(name = Pokemon.FIND_BY_RACE, query = "SELECT poke FROM Pokemon poke WHERE poke.Race = :race"),
    @NamedQuery(name = Pokemon.COUNT_POKE_PER_RACE, query = "SELECT COUNT(poke.Nom) FROM Pokemon poke WHERE poke.Race = :race"),
    @NamedQuery(name = Pokemon.FIND_ALL, query = "SELECT poke FROM Pokemon poke "),
})

public class Pokemon implements Serializable{
	
	private static final long serialVersionUID = 1318904490487933271L;
	
	public static final String FIND_BY_NOM = "findBynom";
	public static final String FIND_BY_RACE = "findByRace";
	public static final String COUNT_POKE_PER_RACE = "CountPokemonPerRace";
	public static final String FIND_ALL = "findAllPoke";
	
	@Id
    @JoinColumn ( name = "Nom")
	private String Nom;
	private String Race;
	private String Niveau;
	private String PV;
	
	
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getRace() {
		return Race;
	}
	public void setRace(String race) {
		Race = race;
	}
	public String getNiveau() {
		return Niveau;
	}
	public void setNiveau(String niveau) {
		Niveau = niveau;
	}
	public String getPV() {
		return PV;
	}
	public void setPV(String pV) {
		PV = pV;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Niveau == null) ? 0 : Niveau.hashCode());
		result = prime * result + ((Nom == null) ? 0 : Nom.hashCode());
		result = prime * result + ((PV == null) ? 0 : PV.hashCode());
		result = prime * result + ((Race == null) ? 0 : Race.hashCode());
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
		Pokemon other = (Pokemon) obj;
		if (Niveau == null) {
			if (other.Niveau != null)
				return false;
		} else if (!Niveau.equals(other.Niveau))
			return false;
		if (Nom == null) {
			if (other.Nom != null)
				return false;
		} else if (!Nom.equals(other.Nom))
			return false;
		if (PV == null) {
			if (other.PV != null)
				return false;
		} else if (!PV.equals(other.PV))
			return false;
		if (Race == null) {
			if (other.Race != null)
				return false;
		} else if (!Race.equals(other.Race))
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return "Pokemon [Nom=" + Nom + ", Race=" + Race + ", Niveau=" + Niveau
				+ ", PV=" + PV + "]";
	}
	
	

}
