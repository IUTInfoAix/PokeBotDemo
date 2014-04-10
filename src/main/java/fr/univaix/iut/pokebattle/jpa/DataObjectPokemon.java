package fr.univaix.iut.pokebattle.jpa;

import java.util.Arrays;

public class DataObjectPokemon {
    String nom;
    String espece;
    float taille;
    float poids;
    float fmratio;
    String effortval;
    String type1;
    String type2;
    int expval;
    int expmax;
    int captureval;
    String capspe1;
    String capspe2;
    String couleur;
    int forme;

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
                ", attaques=" + (attaques == null ? null : Arrays.asList(attaques)) +
                '}';
    }
}

