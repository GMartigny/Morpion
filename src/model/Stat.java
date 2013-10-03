package model;

/**
 * Classe representant une statistique pour l'historique
 *
 * @author Oner
 */
public class Stat {

    private Joueur gagnant;
    private Joueur perdant;
    private boolean egalite;

    public Stat(Joueur gagnant, Joueur perdant) {
        this.gagnant = gagnant;
        this.perdant = perdant;
        this.egalite = false;
    }

    public Stat(Joueur j1, Joueur j2, boolean equal) {
        this.gagnant = j1;
        this.perdant = j2;
        this.egalite = equal;
    }

    @Override
    public String toString() {
        if (this.egalite) {
            return "Egalité entre " + this.gagnant + " et " + this.perdant;
        } else {
            return this.gagnant + " à vaincu " + this.perdant;
        }
    }
}
