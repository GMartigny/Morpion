package model;

/**
 * Classe representant un joueur
 *
 * @author Oner
 */
public class Joueur {

    private String pseudo;
    private Forme forme;

    public Joueur(String pseudo, Forme forme) {
        this.pseudo = pseudo;
        this.forme = forme;
    }

    public String getPseudo() {
        return pseudo;
    }

    public Forme getForme() {
        return forme;
    }
    
    @Override
    public String toString(){
        return this.pseudo + "[" + this.forme + "]";
    }
}
