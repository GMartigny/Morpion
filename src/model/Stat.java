package model;

/**
 * Classe representant une statistique pour l'historique
 *
 * @author Oner
 */
public class Stat {

    private Joueur gagnant;
    private Joueur perdant;

    public Stat(Joueur gagnant, Joueur perdant) {
        this.gagnant = gagnant;
        this.perdant = perdant;
    }

    @Override
    public String toString() {
        return this.gagnant + " à vaincu " + this.perdant;
    }
}
