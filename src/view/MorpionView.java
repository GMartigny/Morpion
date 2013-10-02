/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import model.Jeu;

/**
 *
 * @author Guigui
 */
public class MorpionView extends Observable implements Observer{
    
    private GUIView gui;
    private Jeu jeu;

    public MorpionView(String nom, Jeu model) {
        this.jeu = model;
        this.gui = new GUIView(nom, this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(arg.equals("drawing")){
            this.gui.refreshDrawing();
        }
        else if(arg.equals("stats")){
            this.gui.refreshStats();
        }
    }
    
    public ArrayList getSymboleFromModel(){
        return this.jeu.getSymbole();
    }

    ArrayList getStatsFromModel() {
        return this.jeu.getStats();
    }

    
    //test git
}
