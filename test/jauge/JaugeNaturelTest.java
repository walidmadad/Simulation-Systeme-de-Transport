package test.jauge;

import src.jauge.IJauge;
import src.jauge.JaugeNaturel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test de la classe jaugeNaturel. Vérifie les comportements de la jauge avec des entiers naturels et différents intervalles.
 */
public class JaugeNaturelTest implements IJaugeTest {

    IJauge jauge1, jauge2, inverse, egale;

    /**
     * Initialisation des différentes jauges utilisées pour les tests.
     */
    @Override
    public IJauge creerJauge(long vigieMin, long vigieMax, long depart) {
        return  new JaugeNaturel(vigieMin,vigieMax,depart);
    }


    @Before
    public void initialiser() throws Exception {
        jauge1 = creerJauge(-345, 67899, 100);
        jauge2 = creerJauge(100, 200, 102);
    }

    /**
     * Nettoyage des jauges après chaque test.
     */
    @After
    public void nettoyer() throws Exception {
        jauge1 = null;
        jauge2 = null;
    }

    @Test
    public void dansIntervalle() {
        assertFalse(jauge1.estBleu());
        assertTrue(jauge1.estVert());
        assertFalse(jauge1.estRouge());
    }


    /**
     * Teste le déplacement de la jauge, en incrémentant et décrémentant la valeur.
     */
    @Test
    public void testDeplacer() {
        jauge2.decrementer();
        jauge2.decrementer();
        assertTrue(jauge2.estBleu());
        assertFalse(jauge2.estVert());
        assertFalse(jauge2.estRouge());

        jauge2.incrementer();
        jauge2.incrementer();
        assertFalse(jauge2.estBleu());
        assertTrue(jauge2.estVert());
        assertFalse(jauge2.estRouge());
    }

    /**
     * Teste si la jauge est inférieure à l'intervalle de vigie.
     */
    @Test
    public void testInferieurIntervalle() {
        assertTrue(!jauge2.estBleu());
        assertTrue(jauge2.estVert());
        assertFalse(jauge2.estRouge());
    }

    /**
     * Teste si la jauge est supérieure à l'intervalle de vigie.
     */
    @Test
    public void testSuperieurIntervalle() {
        assertFalse(jauge1.estBleu());
        assertTrue(jauge1.estVert());
        assertFalse(jauge1.estRouge());


    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreationNonValide() {
        inverse = creerJauge(78, 13, 0);
        egale = creerJauge(-45, -45, -45);
    }


    @Test
    public void testExceptionControlee(){
        try {
            inverse = creerJauge(78, 13, 0);
        } catch (IllegalArgumentException e) {
            assertNull("La variable inverse doit être null car l'exception a été levée.", inverse);
        }

        try {
            egale = creerJauge(-45, -45, -45);
        } catch (IllegalArgumentException e) {
            assertNull("La variable egale doit être null car l'exception a été levée.", egale);
        }
    }

}
