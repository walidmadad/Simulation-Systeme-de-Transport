package test.Faux;


import src.tec.Bus;
import src.tec.Passager;
import src.tec.Transport;

public class FauxPassager implements Passager {
  static final byte DEHORS = 0;
  static final byte ASSIS  = 1;
  static final byte DEBOUT = 2;
  byte status = DEHORS;


  public String message ="???";

  public String nom() {
    return null;
  }

  @Override
  public boolean estDehors() {
    return status == DEHORS;
  }

  @Override
  public boolean estAssis() {
    return status == ASSIS;
  }

  @Override
  public boolean estDebout() {return status == DEBOUT;}

  public void accepterSortie() {
    message = ":accepterSortie:";
    this.status = DEHORS ;
  }

  public void accepterPlaceAssise() {
    message = ":accepterPlaceAssise:";
    this.status = ASSIS ;
  }

  public void accepterPlaceDebout() {
    message = ":accepterPlaceDebout:";
    this.status = DEBOUT ;
  }

  public void nouvelArret(Bus bus, int numeroArret) {
    message = ":nouvelArret " + numeroArret + ":";
  }

  public void monterDans(Transport t) { // throws UsagerInvalideException {
  }
}
