package src.etatPassager;

/**
 * Cette classe représente l'état d'un passager dans un transport.
 * Il y a un état à l'exterieur du transport (dehors) et deux états à
 * l'intérieur (assis, debout).
 *
 * Les instances de cette classe sont des objets constants.
 **/
public class EtatPassager implements IEtatPassager {
  /**
   * Définit les trois états possible d'un passager dans un transport.
   */
  public enum Etat {
    /** passager assis à l'intérieur */ ASSIS,
    /** passager debout à l'intérieur */ DEBOUT,
    /** passager à l'extérieur */ DEHORS
  }

  private final Etat monEtat;

  /**
   * Construit une instance en précisant l'état du passager.
   *
   * @param e valeur de l'état.
   */
  public EtatPassager(Etat e) {
    monEtat = e;
  }

  /**
   * Le passager est-il à l'extérieur du transport ?
   *
   * @return vrai si instanciation avec DEHORS;
   */
  public boolean estExterieur() {
    return monEtat == Etat.DEHORS;
  }

  /**
   * Le passager est-il assis à l'intérieur du transport ?
   *
   * @return vrai si instanciation avec ASSIS;
   */
  public boolean estAssis() {
    return monEtat == Etat.ASSIS;
  }

  /**
   * Le passager est-il debout à l'intérieur du transport ?
   *
   * @return vrai si instanciation avec DEBOUT;
   */
  public boolean estDebout() {
    return monEtat == Etat.DEBOUT;
  }

  /**
   * Le passager est-il a l'intérieur du transport ?
   *
   * @return vrai si instanciation avec ASSIS ou DEBOUT.
   */
  public boolean estInterieur() {
    return monEtat == Etat.ASSIS || monEtat == Etat.DEBOUT;
  }

  @Override
  public String toString() {
    switch (monEtat) {
      case ASSIS:
        return "assis";
      case DEBOUT:
        return "debout";
      case DEHORS:
        return "dehors";
      default:
        return "inconnu";
    }
  }
}
