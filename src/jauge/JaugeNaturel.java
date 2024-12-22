package src.jauge;

/**
 * Implémentation de la jauge avec des entiers naturels.
 * La jauge utilise un intervalle défini par une vigie minimale et une vigie maximale.
 * Elle peut être dans trois états : bleu, vert ou rouge, en fonction de sa valeur.
 */
public class JaugeNaturel implements src.jauge.IJauge {
    private long valeur;
    private final long min;
    private final long max;

    /**
     * Construit une instance de JaugeNaturel avec les valeurs de vigie minimale, maximale
     * et la valeur de départ.
     *
     * @param vigieMin Valeur minimale de l'intervalle.
     * @param vigieMax Valeur maximale de l'intervalle.
     * @param depart   Valeur initiale de la jauge.
     */
    public JaugeNaturel(long vigieMin, long vigieMax, long depart) {
        if (vigieMin > vigieMax) {
            throw new IllegalArgumentException("Le vigieMin doit être inférieur ou égal à vigieMax");
        }
        if (depart < vigieMin || depart > vigieMax) {
            throw new IllegalArgumentException("Le niveau de départ doit être compris entre vigieMin et vigieMax");
        }
        valeur = depart;
        min = vigieMin;
        max = vigieMax;
    }

    /**
     * Vérifie si la jauge est rouge, c'est-à-dire si sa valeur est supérieure ou égale à la vigie maximale.
     *
     * @return true si la jauge est rouge, sinon false.
     */
    public boolean estRouge() {
        return valeur >= max;
    }

    /**
     * Vérifie si la jauge est verte, c'est-à-dire si sa valeur est comprise entre les vigies min et max.
     *
     * @return true si la jauge est verte, sinon false.
     */
    public boolean estVert() {
        return valeur > min && valeur < max;
    }

    /**
     * Vérifie si la jauge est bleue, c'est-à-dire si sa valeur est inférieure ou égale à la vigie minimale.
     *
     * @return true si la jauge est bleue, sinon false.
     */
    public boolean estBleu() {
        return valeur <= min;
    }

    /**
     * Incrémente la valeur de la jauge d'une unité.
     */
    public void incrementer() {
        valeur++;
    }

    /**
     * Décrémente la valeur de la jauge d'une unité.
     */
    public void decrementer() {
        valeur--;
    }

    /**
     * Retourne une représentation sous forme de chaîne de caractères de l'état de la jauge.
     *
     * @return La représentation sous forme de chaîne de caractères.
     */
    @Override
    public String toString() {
        return "<" + valeur + " [" + min + "," + max + "]>";
    }
}
