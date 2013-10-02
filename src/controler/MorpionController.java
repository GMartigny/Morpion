/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.util.Observable;
import java.util.Observer;

import model.Jeu;
import view.GUIView;

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

    	if(arg.equals("click")){
    		
    	}

    }


    
    public Jeu getJeu() {
		return jeu;
	}


}
