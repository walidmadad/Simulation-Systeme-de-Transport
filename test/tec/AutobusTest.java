package test.tec;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import src.tec.Autobus;
import test.Faux.FauxPassager;

/**
 * Classe de test pour la classe {@link Autobus}.
 * Cette classe teste les fonctionnalités d'un autobus, telles que la gestion des places assises et debout,
 * la sortie des passagers, ainsi que le changement de position (assis à debout et inversement).
 * Les tests utilisent des instances de {@link FauxPassager} pour simuler les passagers.
 */
public class AutobusTest {

    /**
     * Instance d'autobus utilisée pour les tests.
     */
    private Autobus bus;

    /**
     * Méthode d'initialisation appelée avant chaque test.
     * Initialise un autobus avec 2 places assises et 3 places debout.
     *
     * @throws Exception en cas d'erreur d'initialisation.
     */
    @Before
    public void setUp() throws Exception {
        bus = new Autobus(2, 3);
    }

    /**
     * Méthode de nettoyage appelée après chaque test.
     * Libère les ressources utilisées.
     *
     * @throws Exception en cas d'erreur lors du nettoyage.
     */
    @After
    public void tearDown() throws Exception {
        bus = null;
    }

    /**
     * Test pour vérifier si des places assises sont disponibles.
     * Ajoute des passagers jusqu'à ce que toutes les places assises soient occupées.
     */
    @Test
    public void aPlaceAssise() {
        assertTrue(bus.aPlaceAssise());

        FauxPassager p1 = new FauxPassager();
        FauxPassager p2 = new FauxPassager();
        bus.demanderPlaceAssise(p1);
        bus.demanderPlaceAssise(p2);

        assertFalse(bus.aPlaceAssise());
    }

    /**
     * Test pour vérifier si des places debout sont disponibles.
     * Ajoute des passagers jusqu'à ce que toutes les places debout soient occupées.
     */
    @Test
    public void aPlaceDebout() {
        assertTrue(bus.aPlaceDebout());

        FauxPassager p1 = new FauxPassager();
        FauxPassager p2 = new FauxPassager();
        FauxPassager p3 = new FauxPassager();
        bus.demanderPlaceDebout(p1);
        bus.demanderPlaceDebout(p2);
        bus.demanderPlaceDebout(p3);

        assertFalse(bus.aPlaceDebout());
    }

    /**
     * Test pour la demande d'une place assise.
     * Vérifie que le passager est bien assis après la demande.
     */
    @Test
    public void demanderPlaceAssise() {
        FauxPassager passager = new FauxPassager();
        bus.demanderPlaceAssise(passager);
        assertTrue(passager.estAssis());
        assertTrue(bus.aPlaceAssise());
    }

    /**
     * Test pour la demande d'une place debout.
     * Vérifie que le passager est bien debout après la demande.
     */
    @Test
    public void demanderPlaceDebout() {
        FauxPassager passager = new FauxPassager();
        bus.demanderPlaceDebout(passager);
        assertTrue(passager.estDebout());
        assertTrue(bus.aPlaceDebout());
    }

    /**
     * Test pour la sortie d'un passager.
     * Vérifie que le passager sort correctement et que sa place est libérée.
     */
    @Test
    public void demanderSortie() {
        FauxPassager passager = new FauxPassager();
        bus.demanderPlaceAssise(passager);
        assertTrue(passager.estAssis());
        bus.demanderSortie(passager);
        assertTrue(passager.estDehors());
        assertTrue(bus.aPlaceAssise());
    }

    /**
     * Test pour changer un passager debout en assis.
     * Vérifie que le changement de position est correctement effectué.
     */
    @Test
    public void demanderChangerEnAssis() {
        FauxPassager passager = new FauxPassager();
        bus.demanderPlaceDebout(passager);
        assertTrue(passager.estDebout());
        bus.demanderChangerEnAssis(passager);
        assertTrue(passager.estAssis());
        assertTrue(bus.aPlaceDebout());
        assertTrue(bus.aPlaceAssise());
    }

    /**
     * Test pour changer un passager assis en debout.
     * Vérifie que le changement de position est correctement effectué.
     */
    @Test
    public void demanderChangerEnDebout() {
        FauxPassager passager = new FauxPassager();
        bus.demanderPlaceAssise(passager);
        assertTrue(passager.estAssis());
        bus.demanderChangerEnDebout(passager);
        assertTrue(passager.estDebout());
        assertTrue(bus.aPlaceAssise());
        assertTrue(bus.aPlaceDebout());
    }

    /**
     * Test pour le passage à l'arrêt suivant.
     * Vérifie que tous les passagers sont notifiés du nouvel arrêt.
     */
    @Test
    public void allerArretSuivant() {
        FauxPassager passager1 = new FauxPassager();
        FauxPassager passager2 = new FauxPassager();
        bus.demanderPlaceAssise(passager1);
        bus.demanderPlaceDebout(passager2);
        bus.allerArretSuivant();
        assertEquals(":nouvelArret 1:", passager1.message);
        assertEquals(":nouvelArret 1:", passager2.message);
    }

    @Test
    public void testAutobusConstructeurAvecUneSeuleValeur() {
        Autobus autobus = new Autobus(3); // Crée un autobus avec 3 places assises et 3 places debout

        // Vérification de l'état initial
        assertTrue(autobus.toString().contains("assis:0"));
        assertTrue(autobus.toString().contains("debout:0"));
    }

}
