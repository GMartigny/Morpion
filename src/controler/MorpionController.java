/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.util.Observable;
import java.util.Observer;

import model.Jeu;
import model.Joueur;
import view.GUIView;
import view.MorpionView;

/**
 *
 * @author Guigui
 */
public class MorpionController implements Observer{
    
    GUIView view;
    private Jeu jeu;
    
    public MorpionController(Jeu jeu) {
    	this.jeu = jeu;
    }

    @Override
    public void update(Observable o, Object arg) {
    	MorpionView ob = (MorpionView)o;
    	//récupérer la case cliquée et le joueur qui a cliqué
	    	int posX = ob.getPosX();
	    	int posY = ob.getPosY();
	    	Joueur joueur = jeu.getCurrentJoueur();
    	
    	//Au click, on ajoute le symbole dans le model "jeu"
	    	if(arg.equals("click")){    		
	    		jeu.addSymbole(joueur, posX, posY);
	    	}	

    }
    
    public Jeu getJeu() {
		return jeu;
	}
    
    


}
