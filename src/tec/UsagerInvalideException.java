package src.tec;

/** 
 * Cette exception est levée pour indiquer qu'un usager n'a pas pu être pris en compte
 * par un transport. 
 * <p>
 * Soit le transport ne contient pas cet usager. Soit l'état de l'usager (assis/debout/dehors) 
 * est incohérent avec sa demande au transport.
 */
public class UsagerInvalideException extends Exception {
  public final Usager quelUsager;
  public final Transport quelTransport;

  /**
   * Construit l'exception avec le message d'erreur fourni. Ce message est recupéré
   * par la methode getMessage() définie dans la classe Throwable. 
   */
  UsagerInvalideException(String message) {
    this(message, null, null);
  }

  /**
   * Construit l'exception avec le message d'erreur fourni en précisant l'usager 
   * et le transport en cause.
   */
  UsagerInvalideException(String message, Usager u, Transport t) {
      super(message);
      quelTransport = t;
      quelUsager = u;
  }
}
