package model;

public class Symbole {

	private int posX;
	private int posY;
	private Joueur joueur;
	
	public Symbole(int posX, int posY, Joueur joueur) {
		// TODO Auto-generated constructor stub
		this.posX = posX;
		this.posY = posY;
		this.joueur = joueur;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
	
	
	
}
