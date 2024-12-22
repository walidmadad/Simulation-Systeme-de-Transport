package test.Faux;

import src.tec.Bus;
import src.tec.Passager;
import src.tec.Transport;

public class FauxBusAssis implements Bus, Transport {
  public String message = "???";

  public boolean aPlaceAssise() {
    return true;
  }

  public boolean aPlaceDebout() {
    return false;
  }

  public void demanderPlaceAssise(Passager p) {
    message = ":demanderPlaceAssise:";
    p.accepterPlaceAssise();
  }

  public void demanderPlaceDebout(Passager p) {
    message = ":demanderPlaceDebout:";
  }

  public void demanderChangerEnDebout(Passager p) {
    message = ":demanderChangerEnDebout:";
  }

  public void demanderChangerEnAssis(Passager p) {
    message = ":demanderChangerEnAssis:";
    p.accepterPlaceAssise();
  }

  public void demanderSortie(Passager p) {
    message = ":demanderSortie:";
    p.accepterSortie();
  }

  public void allerArretSuivant() { //throws UsagerInvalideException {
  }
}
