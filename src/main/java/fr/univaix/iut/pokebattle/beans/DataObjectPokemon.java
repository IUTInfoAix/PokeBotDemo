package fr.univaix.iut.pokebattle.beans;

import java.util.Arrays;

public class DataObjectPokemon {
	private String nom;
	private String espece;
	private float taille;
	private float poids;
	private float fmratio;
	private String effortval;
	private String type1;
	private String type2;
	private int expval;
	private int expmax;
	private int captureval;
	private String capspe1;
	private String capspe2;
	private String couleur;
	private int forme;

    DataObjectAttack[] attaques;

    public DataObjectPokemon(){
    }

    public DataObjectPokemon(String nom, String espece, float taille, float poids, 
                             float fmratio, String effortval,
                             String type1, String type2, int expval, int expmax, 
                             int captureval, String capspe1,
                             String capspe2, String couleur, int forme, 
                             DataObjectAttack[] attaques) {
        this.nom = nom;
        this.espece = espece;
        this.taille = taille;
        this.poids = poids;
        this.fmratio = fmratio;
        this.effortval = effortval;
        this.type1 = type1;
        this.type2 = type2;
        this.expval = expval;
        this.expmax = expmax;
        this.captureval = captureval;
        this.capspe1 = capspe1;
        this.capspe2 = capspe2;
        this.couleur = couleur;
        this.forme = forme;
        this.attaques = attaques;
    }

    public String getNom() {
		return nom;
	}

	public String getEspece() {
		return espece;
	}

	public float getTaille() {
		return taille;
	}

	public float getPoids() {
		return poids;
	}

	public float getFmratio() {
		return fmratio;
	}

	public String getEffortval() {
		return effortval;
	}

	public String getType1() {
		return type1;
	}

	public String getType2() {
		return type2;
	}

	public int getExpval() {
		return expval;
	}

	public int getExpmax() {
		return expmax;
	}

	public int getCaptureval() {
		return captureval;
	}

	public String getCapspe1() {
		return capspe1;
	}

	public String getCapspe2() {
		return capspe2;
	}

	public String getCouleur() {
		return couleur;
	}

	public int getForme() {
		return forme;
	}

	public DataObjectAttack[] getAttaques() {
		return attaques;
	}

	@Override
    public String toString() {
        return "DataObjectPokemon{" +
                "nom='" + nom + '\'' +
                ", espece='" + espece + '\'' +
                ", taille=" + taille +
                ", poids=" + poids +
                ", fmratio=" + fmratio +
                ", effortval='" + effortval + '\'' +
                ", type1='" + type1 + '\'' +
                ", type2='" + type2 + '\'' +
                ", expval=" + expval +
                ", expmax=" + expmax +
                ", captureval=" + captureval +
                ", capspe1='" + capspe1 + '\'' +
                ", capspe2='" + capspe2 + '\'' +
                ", couleur='" + couleur + '\'' +
                ", forme=" + forme +
                ", \nattaques=" + (attaques == null ? null : Arrays.asList(attaques)) +
                "}\n";
    }
}