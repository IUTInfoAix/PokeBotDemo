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
    @NamedQuery(name = Pokemon.FIND_BY_NOM, query = "SELECT poke FROM Pokemon poke WHERE poke.nom = :nom"),
    @NamedQuery(name = Pokemon.FIND_BY_RACE, query = "SELECT poke FROM Pokemon poke WHERE poke.race = :race"),
    @NamedQuery(name = Pokemon.COUNT_POKE_PER_RACE, query = "SELECT COUNT(poke.nom) FROM Pokemon poke WHERE poke.race = :race"),
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
	private String nom;
	private String race;
	private String niveau;
	private int pV;
	private String xP;
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
		return nom;
	}
	public void setNom(String nomm) {
		nom = nomm;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String racee) {
		race = racee;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveauu) {
		niveau = niveauu;
	}
	public int getPV() {
		return pV;
	}
	public void setPV(int pVV) {
		pV = pVV;
	}	
	public String getXP() {
		return xP;
	}
	public void setXP(String xPP) {
		xP = xPP;
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
		return "Pokemon [Nom=" + nom + ", Race=" + race + ", Niveau=" + niveau
				+ ", PV=" + pV + ", XP=" + xP + ", attack=" + attack
				+ ", defense=" + defense + ", attackSpecial=" + attackSpecial
				+ ", defenseSpecial=" + defenseSpecial + ", speed=" + speed
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((niveau == null) ? 0 : niveau.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + pV;
		result = prime * result + ((race == null) ? 0 : race.hashCode());
		result = prime * result + ((xP == null) ? 0 : xP.hashCode());
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
		if (niveau == null) {
			if (other.niveau != null)
			{
				return false;
			}
		} else if (!niveau.equals(other.niveau))
		{
			return false;
		}
		if (nom == null) {
			if (other.nom != null)
			{
				return false;
			}
		} else if (!nom.equals(other.nom))
		{
			return false;
		}
		if (pV != other.pV)
		{
			return false;
		}
		if (race == null) {
			if (other.race != null)
			{
				return false;
			}
		} else if (!race.equals(other.race))
		{
			return false;
		}
		if (xP == null) {
			if (other.xP != null)
			{
				return false;
			}
		} else if (!xP.equals(other.xP))
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