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
	
	
	public Jeu() {
		// TODO Auto-generated constructor stub
		this.jeu = new ArrayList<Symbole>();
                this.stats = new ArrayList<Stat>();
		this.etat = Etat.start;
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
	
	
	public ArrayList<Symbole> getSymboles(){
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
		this.setChanged(); //valider les changements du controlleur
		
		if(this.verifierGagner(posX, posY)){
                        Joueur winner = this.getCurrentJoueur();
                        this.toggleCurrentJoueur();
                        Joueur looser = this.getCurrentJoueur();
                        this.addStat(new Stat(winner, looser));
			this.notifyObservers("Gagne");
		}else{
                        this.toggleCurrentJoueur();
                        this.notifyObservers("Drawing");
		}
		
		
		
	}


	public Joueur getCurrentJoueur() {
		return currentJoueur;
	}

	
	public void setCurrentJoueur(Joueur currentJoueur) {
		this.currentJoueur = currentJoueur;
	}
	
	
	public void toggleCurrentJoueur(){
		// passer la main au joueur suivant
		if (this.currentJoueur.equals(joueur1)) {
			this.setCurrentJoueur(joueur2);
		}else{
			this.setCurrentJoueur(joueur1);
		}
	}


	public void demarrerJeu() {
		// TODO Auto-generated method stub
		this.etat = Etat.actif;
		this.currentJoueur = this.joueur1;
		this.setChanged(); //valider les changements du controlleur
		this.notifyObservers("Start");
	}
	
	public Symbole getSymbole(int posX, int posY){
		for (Symbole symb : this.jeu) {
			if(symb.getPosX() == posX && symb.getPosY() == posY){
				return symb;
			}
		}
		return null;
	}

	public Boolean verifierGagner(int posX, int posY){
		boolean winLigne = true;
		boolean winColon = true;
		boolean winCross = true;
		int temp;
		Symbole symbole;
		for (int i = 0; i < 3; i++) {
                    String out = "ok";
                    symbole = this.getSymbole(posX, i);
                    if(symbole == null){
                        out = "null";
                        winColon = false;
                    }
                    else if(!symbole.getJoueur().getForme().equals(this.currentJoueur.getForme())){
                        out = "different";
                        winColon = false;
                    }
                    System.out.println(out);
                    
//			temp = i;
//			symbole = this.getSymbole(posX, i);
//			if (symbole != null && symbole.getJoueur().getForme().equals(this.getCurrentJoueur().getForme())) {
//				trouve = true;
//			}
//                        
//			symbole = this.getSymbole(i, posY);
//			if (symbole != null && symbole.getJoueur().getForme().equals(this.getCurrentJoueur().getForme())) {
//				trouve = true;
//			}
//                        
//			symbole = this.getSymbole(i, i);
//			if (symbole != null && symbole.getJoueur().getForme().equals(this.getCurrentJoueur().getForme())) {
//				trouve = true;
//			}
//                       
//			symbole = this.getSymbole(i, 2-i);
//			if (symbole != null && symbole.getJoueur().getForme().equals(this.getCurrentJoueur().getForme())) {
//				trouve = true;
//			}
			
		}
                boolean win = winColon;
		System.out.println(win);
		return win;
		
	}

    public void addStat(Stat stat) {
        this.stats.add(stat);
    }
	
	

}
