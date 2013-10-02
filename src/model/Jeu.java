package model;

import java.util.ArrayList;
import java.util.Observable;

public class Jeu extends Observable{
	
	private ArrayList<Symbole> jeu;
	private Etat etat;
	private Joueur joueur1;
	private Joueur joueur2;
	
	
	public Jeu(Joueur joueur1, Joueur joueur2) {
		// TODO Auto-generated constructor stub
		this.etat = Etat.start;
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
	}
	
	public Jeu(){
            
        }
	


	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
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

	public void finirJeu(){
		this.etat=Etat.end;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Forme forme1 = new Forme(TypeForme.croix);
		Forme forme2 = new Forme(TypeForme.rond);
		
		Joueur j1 = new Joueur("oner", forme1);
		Joueur j2 = new Joueur("guillaume", forme2);
		
		Jeu jeu = new Jeu(j1, j2);
		System.out.println(jeu.getEtat());
		jeu.finirJeu();
		System.out.println(jeu.getEtat());

	}

}
