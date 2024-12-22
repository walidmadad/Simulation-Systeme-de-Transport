package test.Faux;

import src.tec.Bus;
import src.tec.Transport;
import src.tec.Passager;

public class FauxBusVide implements Bus, Transport {
  public String message = "???";

  public boolean aPlaceAssise() {
    return true;
  }

  public boolean aPlaceDebout() {
    return true;
  }

  public void demanderPlaceAssise(Passager p) {
    message = ":demanderPlaceAssise:";
    p.accepterPlaceAssise();
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
    p.accepterPlaceAssise();
  }

  public void demanderSortie(Passager p) {
    message = ":demanderSortie:";
    p.accepterSortie();
  }

  public void allerArretSuivant() { //throws UsagerInvalideException {
  }
}
