package fr.univaix.iut.pokebattle.pokemon;

import javax.persistence.*;


@Entity
public class Pokemon {
    public enum Type {
        NORMAL,
        FIRE,
        FIGHTING,
        WATER,
        FLYING,
        GRASS,
        POISON,
        ELECTRIC,
        GROUND,
        PSYCHIC,
        ROCK,
        ICE,
        BUG,
        DRAGON,
        GHOST,
        DARK,
        STEEL
    }

    @Id
    private String name;

    @Enumerated(EnumType.STRING)
    private Type type1;

    @Enumerated(EnumType.STRING)
    private Type type2;

    private int baseHP;
    private int attack;
    private int defense;
    private int attackSpecial;
    private int defenseSpecial;
    private int speed;

    protected Pokemon () {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType1() {
        return type1;
    }

    public void setType1(Type type1) {
        this.type1 = type1;
    }

    public Type getType2() {
        return type2;
    }

    public void setType2(Type type2) {
        this.type2 = type2;
    }

    public int getBaseHP() {
        return baseHP;
    }

    public void setBaseHP(int baseHP) {
        this.baseHP = baseHP;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pokemon)) return false;

        Pokemon pokemon = (Pokemon) o;

        if (attack != pokemon.attack) return false;
        if (attackSpecial != pokemon.attackSpecial) return false;
        if (baseHP != pokemon.baseHP) return false;
        if (defense != pokemon.defense) return false;
        if (defenseSpecial != pokemon.defenseSpecial) return false;
        if (speed != pokemon.speed) return false;
        if (!name.equals(pokemon.name)) return false;
        if (type1 != pokemon.type1) return false;
        if (type2 != pokemon.type2) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + type1.hashCode();
        result = 31 * result + type2.hashCode();
        result = 31 * result + baseHP;
        result = 31 * result + attack;
        result = 31 * result + defense;
        result = 31 * result + attackSpecial;
        result = 31 * result + defenseSpecial;
        result = 31 * result + speed;
        return result;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", type1=" + type1 +
                ", type2=" + type2 +
                ", baseHP=" + baseHP +
                ", attack=" + attack +
                ", defense=" + defense +
                ", attackSpecial=" + attackSpecial +
                ", defenseSpecial=" + defenseSpecial +
                ", speed=" + speed +
                '}';
    }
}
