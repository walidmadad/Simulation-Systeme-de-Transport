package test.Faux;

import src.tec.Bus;
import src.tec.Passager;
import src.tec.Transport;

public class FauxBusDebout implements Bus, Transport {
  public String message = "???";

  public boolean aPlaceAssise() {
    return false;
  }

  public boolean aPlaceDebout() {
    return true;
  }

  public void demanderPlaceAssise(Passager p) {
    message = ":demanderPlaceAssise:";
  }

  public void demanderPlaceDebout(Passager p) {
    message = ":demanderPlaceDebout:";
    p.accepterPlaceDebout();
  }

  public void demanderChangerEnDebout(Passager p) {
    message = ":demanderChangerEnDebout:";
    p.accepterPlaceDebout();
  }

  public void demanderChangerEnAssis(Passager p) {
    message = ":demanderChangerEnAssis:";
  }

  public void demanderSortie(Passager p) {
    message = ":demanderSortie:";
    p.accepterSortie();
  }

  public void allerArretSuivant() { //throws UsagerInvalideException {
  }
}
