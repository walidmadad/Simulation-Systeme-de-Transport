package src.tec;

/**
 * Cette interface définit le type manipulé par le programme principal.
 * <p> 
 * Suivant son caractère, l'usager choisit a la montée une place assise, 
 * debout ou reste dehors.
 * Le transport est chargé d'authoriser cette demande. Si le transport
 * refuse toute demande, le passager reste dehors.
 */
public interface Usager {
  /**
   * fournit le nom de l'usager.
   */
  String nom();

  /**
   * Fournit à l'usager le transport auquel il peut accéder.
   * Cette méthode réalise le caractère du passager à la montée.
   * 
   * @param t le transport dans lequel désire monter l'usager.
   * @throws si l'état de l'usager est incohérent par rapport à sa demande.
   */
  void monterDans(Transport t) throws UsagerInvalideException;
}

