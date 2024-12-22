package test.jauge;

import src.jauge.IJauge;

/**
 * Interface de test pour la création et la manipulation d'une jauge dans un environnement de test.
 */
public interface IJaugeTest {

    /**
     * Crée une instance de IJauge pour les tests.
     * Cette méthode est utilisée pour instancier un objet IJauge avec des valeurs de configuration spécifiques.
     *
     * @param vigieMin Valeur minimale de l'intervalle.
     * @param vigieMax Valeur maximale de l'intervalle.
     * @param depart   Valeur initiale de la jauge.
     * @return Une instance d'IJauge initialisée avec les valeurs spécifiées.
     */
    public IJauge creerJauge(long vigieMin, long vigieMax, long depart);

}
