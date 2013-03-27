package fr.univaix.iut.progbd;

import java.util.Collection;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = Owner.FIND_ALL, query = "SELECT o FROM Owner o"),
        @NamedQuery(name = Owner.FIND_BY_NAME, query = "SELECT o FROM Owner o WHERE o.nom_owner = :fname")
})
public class Owner {
    public static final String FIND_BY_NAME = "findOwnerByName";
    public static final String FIND_ALL = "findAllOwner";
    
    @Id 
    private String nom_owner;  

    
	protected Owner() {

    }
    public Owner(String name) {
        this.nom_owner = name;
    }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nom_owner == null) ? 0 : nom_owner.hashCode());
		return result;
	}

	public String getNom_owner() {
		return nom_owner;
	}


	public void setNom_owner(String nom_owner) {
		this.nom_owner = nom_owner;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Owner other = (Owner) obj;
		if (nom_owner == null) {
			if (other.nom_owner != null)
				return false;
		} else if (!nom_owner.equals(other.nom_owner))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Owner [nom_owner=" + nom_owner + "]";
	}

}