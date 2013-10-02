package model;

public class Stat {

	private Joueur joueur;
	private boolean resultat;
	
	public Stat(Joueur joueur, Boolean resultat) {
            this.joueur = joueur;
            this.resultat = resultat;
	}

	public boolean getResultat() {
		return resultat;
	}

	public void setResultat(boolean resultat) {
		this.resultat = resultat;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
	
}
