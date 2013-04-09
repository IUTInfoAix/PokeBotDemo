package fr.univaix.iut.pokebattle.beans;

import java.io.Serializable;

import javax.persistence.Column;
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
	private int PV;
	private String XP;
	@Column( name = "ATTS")
    private int attack;
	@Column( name = "DEFS")
    private int defense;
	@Column( name = "ATTSPE")
    private int attackSpecial;
	@Column( name = "DEFSPE")
    private int defenseSpecial;
	@Column( name = "VIT")
    private int speed;
	
	
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
	public int getPV() {
		return PV;
	}
	public void setPV(int pV) {
		PV = pV;
	}	
	public String getXP() {
		return XP;
	}
	public void setXP(String xP) {
		XP = xP;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public int getAttackSpecial() {
		return attackSpecial;
	}
	public void setAttackSpecial(int attackSpecial) {
		this.attackSpecial = attackSpecial;
	}
	public int getDefenseSpecial() {
		return defenseSpecial;
	}
	public void setDefenseSpecial(int defenseSpecial) {
		this.defenseSpecial = defenseSpecial;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public String toString() {
		return "Pokemon [Nom=" + Nom + ", Race=" + Race + ", Niveau=" + Niveau
				+ ", PV=" + PV + ", XP=" + XP + ", attack=" + attack
				+ ", defense=" + defense + ", attackSpecial=" + attackSpecial
				+ ", defenseSpecial=" + defenseSpecial + ", speed=" + speed
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Niveau == null) ? 0 : Niveau.hashCode());
		result = prime * result + ((Nom == null) ? 0 : Nom.hashCode());
		result = prime * result + PV;
		result = prime * result + ((Race == null) ? 0 : Race.hashCode());
		result = prime * result + ((XP == null) ? 0 : XP.hashCode());
		result = prime * result + attack;
		result = prime * result + attackSpecial;
		result = prime * result + defense;
		result = prime * result + defenseSpecial;
		result = prime * result + speed;
		return result;
	}

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
		Pokemon other = (Pokemon) obj;
		if (Niveau == null) {
			if (other.Niveau != null)
			{
				return false;
			}
		} else if (!Niveau.equals(other.Niveau))
		{
			return false;
		}
		if (Nom == null) {
			if (other.Nom != null)
			{
				return false;
			}
		} else if (!Nom.equals(other.Nom))
		{
			return false;
		}
		if (PV != other.PV)
		{
			return false;
		}
		if (Race == null) {
			if (other.Race != null)
			{
				return false;
			}
		} else if (!Race.equals(other.Race))
		{
			return false;
		}
		if (XP == null) {
			if (other.XP != null)
			{
				return false;
			}
		} else if (!XP.equals(other.XP))
		{
			return false;
		}
		if (attack != other.attack)
		{
			return false;
		}
		if (attackSpecial != other.attackSpecial)
		{
			return false;
		}
		if (defense != other.defense)
		{
			return false;
		}
		if (defenseSpecial != other.defenseSpecial)
		{
			return false;
		}
		if (speed != other.speed)
		{
			return false;
		}
		return true;
	}

}