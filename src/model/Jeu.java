package model;

import java.util.ArrayList;
import java.util.Observable;

public class Jeu extends Observable {

    private ArrayList<Symbole> jeu;
    private ArrayList<Stat> stats;
    private int taille;
    private Joueur joueur1;
    private Joueur joueur2;
    private Joueur currentJoueur;

    public Jeu() {
        // TODO Auto-generated constructor stub
        this.stats = new ArrayList<Stat>();
    }

    public int getTaille() {
        return taille;
    }

    public Joueur getJoueur1() {
        return joueur1;
    }

    public void setJoueur1(Joueur joueur1) {
        this.joueur1 = joueur1;
    }

    public Joueur getJoueur2() {
        return joueur2;
    }

    public void setJoueur2(Joueur joueur2) {
        this.joueur2 = joueur2;
    }

    public ArrayList<Symbole> getSymboles() {
        return this.jeu;
    }

    public ArrayList<Stat> getStats() {
        return this.stats;

    }

    public void addSymbole(Joueur joueur, int posX, int posY) {
        if (this.getSymbole(posX, posY) == null) { //eviter d'avoir deux symbole dans la meme case

            this.jeu.add(new Symbole(posX, posY, joueur));
            this.setChanged();

            if (this.verifierGagner(posX, posY)) {
                Joueur winner = this.getCurrentJoueur();
                Joueur looser = this.getNotCurrentJoueur();
                this.addStat(new Stat(winner, looser));
                this.notifyObservers("Gagne");
            } else {
                this.toggleCurrentJoueur();
                this.notifyObservers("Drawing");
            }


        }
    }

    public Joueur getCurrentJoueur() {
        return currentJoueur;
    }

    public void setCurrentJoueur(Joueur currentJoueur) {
        this.currentJoueur = currentJoueur;
    }

    public void toggleCurrentJoueur() {
        // passer la main au joueur suivant
        if (this.currentJoueur.equals(joueur1)) {
            this.setCurrentJoueur(joueur2);
        } else {
            this.setCurrentJoueur(joueur1);
        }
    }

    public void demarrerJeu(int taille) {
        this.jeu = new ArrayList<Symbole>();
        this.taille = taille;
        this.currentJoueur = this.joueur1;
        this.setChanged(); //valider les changements du controlleur
        this.notifyObservers("Start");
    }

    public void redemarrerJeu() {
        this.jeu = new ArrayList<Symbole>();
        this.currentJoueur = this.joueur1;
        this.setChanged(); //valider les changements du controlleur
        this.notifyObservers("Drawing");
    }

    public Symbole getSymbole(int posX, int posY) {
        for (Symbole symb : this.jeu) {
            if (symb.getPosX() == posX && symb.getPosY() == posY) {
                return symb;
            }
        }
        return null;
    }

    public Boolean verifierGagner(int posX, int posY) {
        boolean winLigne = true;
        boolean winColon = true;
        boolean winCross1 = true;
        boolean winCross2 = true;

        Symbole symbole;
        Forme playedForme = this.currentJoueur.getForme();
        Forme otherForme;

        for (int i = 0; i < this.taille; i++) {

            symbole = this.getSymbole(i, posY);
            if (symbole == null) {
                winLigne = false;
            } else if (!symbole.getJoueur().getForme().equals(playedForme)) {
                winLigne = false;
            }

            symbole = this.getSymbole(posX, i);
            if (symbole == null) {
                winColon = false;
            } else if (!symbole.getJoueur().getForme().equals(playedForme)) {
                winColon = false;
            }

            symbole = this.getSymbole(i, i);
            if (symbole == null) {
                winCross1 = false;
            } else if (!symbole.getJoueur().getForme().equals(playedForme)) {
                winCross1 = false;
            }

            symbole = this.getSymbole(i, 2 - i);
            if (symbole == null) {
                winCross2 = false;
            } else if (!symbole.getJoueur().getForme().equals(playedForme)) {
                winCross2 = false;
            }

        }
        boolean win = winColon || winLigne || winCross1 || winCross2;
        return win;

    }

    public void addStat(Stat stat) {
        this.stats.add(stat);
        if (7 < this.stats.size()) {
            this.stats.remove(0);
        }
    }

    private Joueur getNotCurrentJoueur() {
        if (this.currentJoueur.equals(this.joueur1)) {
            return this.joueur2;
        } else {
            return this.joueur1;
        }
    }
}
