package src.tec;

/**
 * Cette interface définit un des types abstraits fixant les interactions
 * avec les passagers. 
 * <p>
 * Un bus a un nombre détermine de places assises et de places debouts.
 * Les places assises (ou debout) ne sont pas repérables.
 * Le nombre de place assise et bebout est fixé à l'instanciation d'un bus.
 * <p>
 * Un bus authorise  un passager à entrer pour occuper soit une place debout
 * soit une place assise. Si l'entrée est acceptée le bus déclenche les 
 * modificateurs de passager (changement de l'état du passager).
 * <p>
 * A chaque arrêt, un bus permet aux passagers dans le bus soit de sortir,
 * soit de changer de place (d'assise en debout, ou l'inverse). 
 * Si la demande est acceptée, le bus déclenche les modificateurs 
 * de passager.
 */
public interface Bus {

  /**
   * vrai s'il existe des places assises.
   * @return vrai s'il existe des places assises
   */
  boolean aPlaceAssise();

  /**
   * vrai s'il existe des places debouts.
   * @return vrai s'il existe des places debouts
   */
  boolean aPlaceDebout();

  /**
   * Le passager entre dans ce bus en demandant une place assise.
   * L'état du passager est forcément dehors.
   * Cette méthode est appelée par Passager.
   * @param p le passager
   */
  void demanderPlaceAssise(Passager p);
  /**
   * Le passager entre dans ce bus en demandant une place debout.
   * L'état du passager est forcément dehors.
   * Cette méthode est appelée par passager. 
   * Elle change l'état du passager.
   * @param p le passager
   */
  void demanderPlaceDebout(Passager p);


  /**
   * Change un passager d'une place assise vers une place debout.
   * Elle change l'état du passager.
   * @param p le passager avec un état assis.
   */
  void demanderChangerEnDebout(Passager p);

  /**
   * Change un passager d'une place debout vers une place assise.
   * Elle change l'état du passager.
   * @param p le passager avec un état debout.
   */
  void demanderChangerEnAssis(Passager p);

  /**
   * Fait sortir un passager du bus.
   * Elle change l'état du passager.
   * @param p le passager avec un état soit assis soit debout.
   */
  void demanderSortie(Passager p);
}

