package src.tec;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant un autobus dans le système de transport.
 * Un autobus gère des places assises et debout pour les passagers
 * et avance à chaque arrêt tout en permettant aux passagers de monter, descendre,
 * ou changer de position.
 */
public class Autobus implements Bus, Transport {

    // Capacités de l'autobus pour les places assises et debout
    private int capaciteAssise;
    private int capaciteDebout;

    // Listes des passagers assis et debout
    private List<Passager> passagersAssis;
    private List<Passager> passagersDebout;

    // Numéro actuel de l'arrêt
    private int arretActuel;

    /**
     * Constructeur pour initialiser l'autobus avec un nombre de places assises et debout.
     *
     * @param capaciteAssise Nombre de places assises.
     * @param capaciteDebout Nombre de places debout.
     */
    public Autobus(int capaciteAssise, int capaciteDebout) {
        this.capaciteAssise = capaciteAssise;
        this.capaciteDebout = capaciteDebout;
        this.passagersAssis = new ArrayList<>();
        this.passagersDebout = new ArrayList<>();
        this.arretActuel = 0;
    }

    public Autobus(int nbPlace) {
        this(nbPlace, nbPlace); // Réutilisation du premier constructeur
    }

    /**
     * Vérifie s'il y a des places assises disponibles.
     *
     * @return true s'il y a des places assises, false sinon.
     */
    @Override
    public boolean aPlaceAssise() {
        return passagersAssis.size() < capaciteAssise;
    }

    /**
     * Vérifie s'il y a des places debout disponibles.
     *
     * @return true s'il y a des places debout, false sinon.
     */
    @Override
    public boolean aPlaceDebout() {
        return passagersDebout.size() < capaciteDebout;
    }

    /**
     * Demande une place assise pour un passager.
     *
     * @param p Le passager demandant une place assise.
     */
    @Override
    public void demanderPlaceAssise(Passager p) {
        if (p.estAssis()) {
            throw new IllegalStateException("Le passager est déjà assis.");
        }
        if (aPlaceAssise()) {
            passagersAssis.add(p);
            p.accepterPlaceAssise();
        }
    }

    /**
     * Demande une place debout pour un passager.
     *
     * @param p Le passager demandant une place debout.
     */
    @Override
    public void demanderPlaceDebout(Passager p) {
        if (aPlaceDebout()) {
            passagersDebout.add(p);
            p.accepterPlaceDebout();
        }
    }

    /**
     * Demande à changer en position debout pour un passager.
     *
     * @param p Le passager demandant à passer en debout.
     */
    @Override
    public void demanderChangerEnDebout(Passager p) {
        if (aPlaceDebout() && passagersAssis.contains(p)) {
            passagersAssis.remove(p);
            passagersDebout.add(p);
            p.accepterPlaceDebout();
        }
    }

    /**
     * Demande à changer en position assise pour un passager.
     *
     * @param p Le passager demandant à passer en assis.
     */
    @Override
    public void demanderChangerEnAssis(Passager p) {
        if (aPlaceAssise() && passagersDebout.contains(p)) {
            passagersDebout.remove(p);
            passagersAssis.add(p);
            p.accepterPlaceAssise();
        }
    }

    /**
     * Demande la sortie d'un passager du véhicule.
     *
     * @param p Le passager demandant à sortir.
     */
    @Override
    public void demanderSortie(Passager p) {
        if (passagersAssis.contains(p)) {
            passagersAssis.remove(p);
        } else if (passagersDebout.contains(p)) {
            passagersDebout.remove(p);
        }
        p.accepterSortie();
    }

    /**
     * Passe à l'arrêt suivant et notifie tous les passagers de l'arrêt actuel.
     */
    @Override
    public void allerArretSuivant() {
        arretActuel++;
        List<Passager> tousLesPassagers = new ArrayList<>();
        tousLesPassagers.addAll(passagersAssis);
        tousLesPassagers.addAll(passagersDebout);

        for (Passager passager : tousLesPassagers) {
            passager.nouvelArret(this, arretActuel);
        }
    }

    /**
     * Représente l'état actuel de l'autobus sous forme de chaîne de caractères.
     *
     * @return Une description de l'autobus incluant l'arrêt actuel et le nombre de passagers assis et debout.
     */
    @Override
    public String toString() {
        return "[arret:" + arretActuel + ", assis:" + passagersAssis.size() + ", debout:" + passagersDebout.size() + "]";
    }
}