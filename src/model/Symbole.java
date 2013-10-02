package model;

/**
 * Classe representant un coup jouer sur la grille
 *
 * @author Oner
 */
public class Symbole {

    private int posX;
    private int posY;
    private Joueur joueur;

    public Symbole(int posX, int posY, Joueur joueur) {
        this.posX = posX;
        this.posY = posY;
        this.joueur = joueur;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public Joueur getJoueur() {
        return joueur;
    }
}
