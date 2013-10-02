package model;

import java.util.ArrayList;
import java.util.Observable;

public class Jeu extends Observable {
	
	private ArrayList<Symbole> jeu;
	private ArrayList<Stat> stats;
	
	private Etat etat;
	private Joueur joueur1;
	private Joueur joueur2;
	
	private Joueur currentJoueur;
	
	
	public Jeu(Joueur joueur1, Joueur joueur2) {
		// TODO Auto-generated constructor stub
		this.etat = Etat.start;
		this.joueur1 = joueur1;
		this.currentJoueur = this.joueur1;
		this.joueur2 = joueur2;
	}
	

	public Jeu() {
		// TODO Auto-generated constructor stub
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
	
	
	public ArrayList<Symbole> getSymbole(){
		return this.jeu;
	}
	
	public ArrayList<Stat> getStats(){
		if(this.etat.equals(Etat.end)){
			return stats;
		}else{
			return null;
		}
		
	}

	public void addSymbole(Joueur joueur, int posX, int posY){
		jeu.add(new Symbole(posX, posY, joueur));
	}


	public Joueur getCurrentJoueur() {
		return currentJoueur;
	}

	
	public void setCurrentJoueur(Joueur currentJoueur) {
		this.currentJoueur = currentJoueur;
	}
	


}
