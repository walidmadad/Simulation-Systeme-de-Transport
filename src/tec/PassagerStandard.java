package src.tec;

import src.etatPassager.EtatPassager;

/**
 * Classe représentant un passager standard dans le système de transport.
 * Un passager standard a un nom, une priorité, et un état (dehors, assis, ou debout).
 */
public class PassagerStandard implements Usager, Passager {

    /**
     * Nom du passager.
     */
    private String nom;

    /**
     * Niveau de priorité du passager. Utilisé pour déterminer son comportement dans le système.
     */
    private int priorite;

    /**
     * État actuel du passager (dehors, assis, debout).
     */
    private EtatPassager etat;

    /**
     * Constructeur pour la classe PassagerStandard.
     *
     * @param nom Le nom du passager.
     * @param priorite La priorité du passager.
     */
    public PassagerStandard(String nom, int priorite) {
        if (priorite < 0 || nom.equals("")) {
            throw new IllegalArgumentException("La priorité doit être positive.");
        }
        this.nom = nom;
        this.priorite = priorite;
        this.etat = new EtatPassager(EtatPassager.Etat.DEHORS);
    }


    public PassagerStandard(int destination) {
        this("PassagerStandard" + destination, destination); // Réutilisation du premier constructeur
    }

    /**
     * Retourne le nom du passager.
     *
     * @return Le nom du passager.
     */
    @Override
    public String nom() {
        return nom;
    }

    /**
     * Indique si le passager est à l'extérieur du véhicule.
     *
     * @return {@code true} si le passager est dehors, {@code false} sinon.
     */
    @Override
    public boolean estDehors() {
        return etat.estExterieur();
    }

    /**
     * Indique si le passager est assis dans le véhicule.
     *
     * @return {@code true} si le passager est assis, {@code false} sinon.
     */
    @Override
    public boolean estAssis() {
        return etat.estAssis();
    }

    /**
     * Indique si le passager est debout dans le véhicule.
     *
     * @return {@code true} si le passager est debout, {@code false} sinon.
     */
    @Override
    public boolean estDebout() {
        return etat.estDebout();
    }

    /**
     * Accepte la sortie du véhicule pour ce passager.
     * Change l'état du passager pour refléter qu'il est à l'extérieur.
     */
    @Override
    public void accepterSortie() {
        // Implémentation de la sortie du véhicule
        etat = new EtatPassager(EtatPassager.Etat.DEHORS);
    }

    /**
     * Accepte une place assise pour ce passager.
     * Change l'état du passager pour refléter qu'il est assis.
     */
    @Override
    public void accepterPlaceAssise() {
        // Implémentation pour accepter une place assise
        etat = new EtatPassager(EtatPassager.Etat.ASSIS);
    }

    /**
     * Accepte une place debout pour ce passager.
     * Change l'état du passager pour refléter qu'il est debout.
     */
    @Override
    public void accepterPlaceDebout() {
        // Implémentation pour accepter une place debout
        etat = new EtatPassager(EtatPassager.Etat.DEBOUT);
    }

    /**
     * Réagit à un nouvel arrêt de bus.
     *
     * @param bus Le bus dans lequel le passager se trouve.
     * @param numeroArret Le numéro de l'arrêt actuel.
     */
    @Override
    public void nouvelArret(Bus bus, int numeroArret) {
        if (numeroArret > priorite) {
            throw new IllegalArgumentException("La destination ne peut pas être inférieure à l'arrêt actuel.");
        }
        // Implémentation pour réagir à un nouvel arrêt
        if (priorite == numeroArret) {
            accepterSortie();
            bus.demanderSortie(this);
        }
    }


    /**
     * Permet au passager de monter dans un transport.
     *
     * @param t Le transport dans lequel le passager monte.
     * @throws UsagerInvalideException Si le passager ne peut pas monter dans le transport.
     */
    @Override
    public void monterDans(Transport t) throws UsagerInvalideException {
        // Implémentation pour monter dans un transport
        if (!(t instanceof Bus)) {
            throw new UsagerInvalideException("Transport non supporté.");
        }
        Bus bus = (Bus) t;
        if (bus.aPlaceAssise()) {
            bus.demanderPlaceAssise(this);
        } else if (bus.aPlaceDebout()) {
            bus.demanderPlaceDebout(this);
        } else {
            throw new UsagerInvalideException("Pas de place disponible.");
        }

    }
    @Override
    public String toString() {
        return nom + " " + etat;
    }
}
