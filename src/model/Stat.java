package model;

public class Stat {

	private Joueur joueur;
	private boolean resultat;
	
	public Stat(Joueur joueur, Boolean resultat) {
		// TODO Auto-generated constructor stub
		this.setJoueur(joueur);
		this.setResultat(resultat);
	}

	public boolean isResultat() {
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
