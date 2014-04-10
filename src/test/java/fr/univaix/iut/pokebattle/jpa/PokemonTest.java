package fr.univaix.iut.pokebattle.jpa;

import fr.univaix.iut.pokebattle.smartcell.PokeKOCell;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by guillaume on 10/04/14.
 */
public class PokemonTest {

    Pokemon pokemon = new Pokemon("Ronflaix");

    @Test
    public void testName() throws Exception {
        assertEquals("Ronflaix", pokemon.getName());
    }

    @Test
    public void testType1() throws Exception {
        pokemon.setType1(Pokemon.Type.NORMAL);
        assertEquals(Pokemon.Type.NORMAL, pokemon.getType1());
    }

    @Test
    public void testType2() throws Exception {
        pokemon.setType2(Pokemon.Type.GROUND);
        assertEquals(Pokemon.Type.GROUND, pokemon.getType2());
    }

    @Test
    public void testBaseHP() throws Exception {
        pokemon.setBaseHP(160);
        assertEquals(160, pokemon.getBaseHP());
    }

    @Test
    public void testAttack() throws Exception {
        pokemon.setAttack(160);
        assertEquals(160, pokemon.getAttack());
    }

    @Test
    public void testDefense() throws Exception {
        pokemon.setDefense(222);
        assertEquals(222, pokemon.getDefense());
    }

    @Test
    public void testAttackSpecial() throws Exception {
        pokemon.setAttackSpecial(666);
        assertEquals(666, pokemon.getAttackSpecial());
    }

    @Test
    public void testDefenseSpecial() throws Exception {
        pokemon.setDefenseSpecial(69);
        assertEquals(69, pokemon.getDefenseSpecial());
    }

    @Test
    public void testSpeed() throws Exception {
        pokemon.setSpeed(25);
        assertEquals(25, pokemon.getSpeed());
    }

    @Test
    public void testEleveur() throws Exception {
        pokemon.setEleveur("nedseb");
        assertEquals("nedseb", pokemon.getEleveur());
    }

    @Test
    public void testLevel() throws Exception {
        pokemon.setLevel(42);
        assertEquals(42, pokemon.getLevel());
    }

    @Test
    public void testXP() throws Exception {
        pokemon.setXP(55);
        assertEquals(55, pokemon.getXP());
    }

    @Test
    public void testPV() throws Exception {
        pokemon.setPV(100);
        assertEquals(100, pokemon.getPV());
    }

    @Test
    public void testEquals() throws Exception {
        Pokemon pikachu = new Pokemon("Pikachu");
        Pokemon ronflaix = new Pokemon("Ronflaix");
        assertEquals(false, pokemon.equals(pikachu));
        assertEquals(true, pokemon.equals(ronflaix));
    }

    @Test
    public void testToString() throws Exception {
        assertEquals("Pokemon{name='Ronflaix', types1=null, types2=null, baseHP=0, attack=0, defense=0, attackSpecial=0, defenseSpecial=0, speed=0, eleveur=null}", pokemon.toString());
    }
}
