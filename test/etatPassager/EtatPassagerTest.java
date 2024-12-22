package test.etatPassager;

import src.etatPassager.EtatPassager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Classe de test pour la classe {@link EtatPassager}.
 * Cette classe vérifie le comportement de l'état d'un passager
 * en fonction des différentes situations possibles :
 * extérieur, assis ou debout.
 */
public class EtatPassagerTest {

    /**
     * Instances de la classe EtatPassager pour les différents tests.
     */
    EtatPassager passager;
    EtatPassager passager1;
    EtatPassager passager2;

    /**
     * Initialise les objets {@link EtatPassager} avant chaque test.
     * <ul>
     *     <li>{@code passager} : état initial "DEHORS"</li>
     *     <li>{@code passager1} : état initial "ASSIS"</li>
     *     <li>{@code passager2} : état initial "DEBOUT"</li>
     * </ul>
     */
    @Before
    public void initialiser() {
        passager = new EtatPassager(EtatPassager.Etat.DEHORS);
        passager1 = new EtatPassager(EtatPassager.Etat.ASSIS);
        passager2 = new EtatPassager(EtatPassager.Etat.DEBOUT);
    }

    /**
     * Nettoie les objets {@link EtatPassager} après chaque test.
     */
    @After
    public void nettoyer(){
        passager = null;
        passager1 = null;
        passager2 = null;
    }

    /**
     * Teste si le passager est correctement identifié comme étant à l'extérieur.
     * Vérifie que les méthodes {@code estAssis()} et {@code estDebout()} renvoient faux,
     * et que {@code estExterieur()} renvoie vrai.
     */
    @Test
    public void estExterieur() {
        assertFalse(passager.estAssis());
        assertFalse(passager.estDebout());
        assertTrue(passager.estExterieur());
    }

    /**
     * Teste si le passager est correctement identifié comme étant assis.
     * Vérifie que la méthode {@code estAssis()} renvoie vrai,
     * et que les méthodes {@code estDebout()} et {@code estExterieur()} renvoient faux.
     */
    @Test
    public void estAssis() {
        assertTrue(passager1.estAssis());
        assertFalse(passager1.estDebout());
        assertFalse(passager1.estExterieur());
    }

    /**
     * Teste si le passager est correctement identifié comme étant debout.
     * Vérifie que la méthode {@code estDebout()} renvoie vrai,
     * et que les méthodes {@code estAssis()} et {@code estExterieur()} renvoient faux.
     */
    @Test
    public void estDebout() {
        assertFalse(passager2.estAssis());
        assertTrue(passager2.estDebout());
        assertFalse(passager2.estExterieur());
    }

    /**
     * Teste si le passager est correctement identifié comme étant à l'intérieur.
     * Vérifie que la méthode {@code estInterieur()} renvoie les bonnes valeurs
     * en fonction de l'état du passager.
     */
    @Test
    public void estInterrieur() {
        assertFalse(passager.estInterieur());
        assertTrue(passager1.estInterieur());
        assertTrue(passager2.estInterieur());
    }
}
