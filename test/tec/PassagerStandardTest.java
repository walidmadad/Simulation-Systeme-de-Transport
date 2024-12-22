package test.tec;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import src.tec.*;
import test.Faux.FauxBusAssis;
import test.Faux.FauxBusDebout;
import test.Faux.FauxBusPlein;

import static org.junit.Assert.*;

/**
 * Classe de test pour la classe {@link PassagerStandard}.
 * Cette classe contient des tests unitaires pour vérifier
 * les fonctionnalités du PassagerStandard, telles que la gestion de l'état
 * du passager dans le bus (assis, debout, dehors) et les interactions avec
 * le bus simulé.
 */
public class PassagerStandardTest {

    private PassagerStandard passagerAssis;
    private PassagerStandard passagerDebout;
    private PassagerStandard passagerDehors;

    private FauxBusAssis fauxBusAssis;
    private FauxBusDebout fauxBusDebout;
    private FauxBusPlein fauxBusPlein;

    /**
     * Initialise plusieurs passagers et instances de bus factices avant chaque test.
     *
     * @throws Exception si une erreur d'initialisation survient.
     */
    @Before
    public void initialiser() throws Exception {
        passagerAssis = new PassagerStandard("Jean", 1);
        passagerDebout = new PassagerStandard("Marie", 2);
        passagerDehors = new PassagerStandard("Paul", 3);

        fauxBusAssis = new FauxBusAssis();
        fauxBusDebout = new FauxBusDebout();
        fauxBusPlein = new FauxBusPlein();
    }

    /**
     * Nettoie les instances de passagers et de bus après chaque test.
     *
     * @throws Exception si une erreur de nettoyage survient.
     */
    @After
    public void nettoyer() throws Exception {
        passagerAssis = null;
        passagerDebout = null;
        passagerDehors = null;

        fauxBusAssis = null;
        fauxBusDebout = null;
        fauxBusPlein = null;
    }

    /**
     * Vérifie que la méthode nom() retourne le nom correct du passager.
     */
    @Test
    public void nom() {
        assertEquals("Jean", passagerAssis.nom());
        assertEquals("Marie", passagerDebout.nom());
        assertEquals("Paul", passagerDehors.nom());
    }

    /**
     * Vérifie que la méthode estDehors() fonctionne correctement pour
     * déterminer si un passager est dehors.
     */
    @Test
    public void estDehors() {
        assertTrue(passagerAssis.estDehors());
        assertTrue(passagerDebout.estDehors());
        assertTrue(passagerDehors.estDehors());
    }

    /**
     * Vérifie que la méthode estAssis() fonctionne correctement après avoir
     * accepté une place assise.
     */
    @Test
    public void estAssis() {
        passagerAssis.accepterPlaceAssise();
        assertTrue(passagerAssis.estAssis());
        assertFalse(passagerAssis.estDebout());
        assertFalse(passagerAssis.estDehors());
    }

    /**
     * Vérifie que la méthode estDebout() fonctionne correctement après avoir
     * accepté une place debout.
     */
    @Test
    public void estDebout() {
        passagerDebout.accepterPlaceDebout();
        assertTrue(passagerDebout.estDebout());
        assertFalse(passagerDebout.estAssis());
        assertFalse(passagerDebout.estDehors());
    }

    /**
     * Vérifie que la méthode accepterSortie() permet à un passager
     * de sortir du bus.
     */
    @Test
    public void accepterSortie() {
        passagerAssis.accepterPlaceAssise();
        passagerAssis.accepterSortie();
        assertTrue(passagerAssis.estDehors());
    }

    /**
     * Vérifie que la méthode accepterPlaceAssise() permet à un passager
     * d'accepter une place assise.
     */
    @Test
    public void accepterPlaceAssise() {
        passagerDehors.accepterPlaceAssise();
        assertTrue(passagerDehors.estAssis());
        assertFalse(passagerDehors.estDebout());
        assertFalse(passagerDehors.estDehors());
    }

    /**
     * Vérifie que la méthode accepterPlaceDebout() permet à un passager
     * d'accepter une place debout.
     */
    @Test
    public void accepterPlaceDebout() {
        passagerDehors.accepterPlaceDebout();
        assertTrue(passagerDehors.estDebout());
        assertFalse(passagerDehors.estAssis());
        assertFalse(passagerDehors.estDehors());
    }

    /**
     * Vérifie que la méthode nouvelArret() notifie correctement un passager
     * lors d'un nouvel arrêt.
     */
    @Test
    public void nouvelArret() {
        passagerAssis.accepterPlaceAssise();
        passagerAssis.nouvelArret(fauxBusAssis, 1);
        assertTrue(passagerAssis.estDehors());
        assertEquals(":demanderSortie:", fauxBusAssis.message);
    }


    /**
     * Vérifie que la méthode monterDans() permet à un passager de monter dans un bus
     * et de gérer correctement les exceptions en cas de bus plein.
     */
    @Test
    public void monterDans() {
        try {
            // Le passager essaie de monter dans un bus avec une place assise disponible
            passagerDehors.monterDans(fauxBusAssis);
            assertTrue(passagerDehors.estAssis());
            assertEquals(":demanderPlaceAssise:", fauxBusAssis.message);

            // Le passager sort puis essaie de monter dans un bus avec une place debout disponible
            passagerDehors.accepterSortie();
            passagerDehors.monterDans(fauxBusDebout);
            assertTrue(passagerDehors.estDebout());
            assertEquals(":demanderPlaceDebout:", fauxBusDebout.message);

            // Le passager sort à nouveau pour tester un bus plein
            passagerDehors.accepterSortie();

            // Test pour un bus plein
            try {
                passagerDehors.monterDans(fauxBusPlein);
                fail("Une exception UsagerInvalideException était attendue pour un bus plein.");
            } catch (UsagerInvalideException e) {
                // Vérification réussie : l'exception a été lancée correctement
                assertTrue(passagerDehors.estDehors());
            }
        } catch (UsagerInvalideException e) {
            // Si une exception est levée ici, elle n'était pas attendue
            fail("Pas d'exception attendue ici.");
        }
    }

    @Test
    public void testPassagerStandardAvecDestination() {
        int destination = 5;
        PassagerStandard passager = new PassagerStandard(destination);

        // Test avec la méthode nom() qui retourne le nom du passager
        assertEquals("PassagerStandard5", passager.nom());

        // Test via la méthode toString() pour vérifier le nom et l'état
        assertTrue(passager.toString().contains("PassagerStandard5"));
        assertFalse(passager.toString().contains("DEHORS"));


    }
}
