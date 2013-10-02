package model;

public class Joueur {

	private String pseudo;
	private Forme forme;
	
	public Joueur(String pseudo, Forme forme) {
		// TODO Auto-generated constructor stub
		this.pseudo = pseudo;
		this.forme = forme;
	}
	
	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public Forme getForme() {
		return forme;
	}

	public void setForme(Forme forme) {
		this.forme = forme;
	}

}
