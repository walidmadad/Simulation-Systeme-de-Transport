package test.tec;

import org.junit.Test;
import src.tec.*;


public class PassagerStandardExceptionTest {

    @Test(expected = IllegalArgumentException.class)
    public void testInstanciationInvalide() {
        new PassagerStandard("test", -3);
        new PassagerStandard("", 10);
    }


    @Test(expected = IllegalStateException.class)
    public void testEtatPassagerIncoherent() throws UsagerInvalideException {
        PassagerStandard passager = new PassagerStandard("Jean", 3);
        Transport bus = new Autobus(2, 3);
        passager.monterDans(bus);
        passager.monterDans(bus);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testNouvelArretDestinationInvalide() throws UsagerInvalideException {

        Transport bus = new Autobus(10, 5);
        bus.allerArretSuivant(); // Arrêt 1
        bus.allerArretSuivant(); // Arrêt 2
        PassagerStandard passager = new PassagerStandard("Jean", 2);
        passager.monterDans(bus);
        bus.allerArretSuivant(); // Arrêt 3


    }
    @Test(expected = IllegalStateException.class)
    public void testPassagerStockerDeuxFois() throws UsagerInvalideException {
        PassagerStandard passager = new PassagerStandard("Jean", 3);
        Transport bus = new Autobus(10, 5);

        passager.monterDans(bus);
        passager.monterDans(bus);  // Devrait lever une exception
    }

    @Test(expected = UsagerInvalideException.class)
    public void testMonterDansTransportNonBus() throws UsagerInvalideException {
        PassagerStandard passager = new PassagerStandard("Jean", 1);
        Transport transportIncorrect = new Transport() {
            @Override
            public void allerArretSuivant() {
                // Méthode non utilisée pour ce test
            }
        };

        passager.monterDans(transportIncorrect);
    }

}

