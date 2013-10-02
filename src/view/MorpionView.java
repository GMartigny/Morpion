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
        if(arg.equals("Start")){
            this.gui.startDrawing();
        }
        else if(arg.equals("Drawing")){
            ArrayList symboles = this.getSymbolesFromModel();
            this.gui.refreshDrawing(symboles);
        }
        else if(arg.equals("Stats")){
            ArrayList stats = this.getStatsFromModel();
            this.gui.refreshStats(stats);
        }
    }
    
    public void makeNotify(String message){
        this.setChanged();
        this.notifyObservers(message);
    }
    
    // Récupération des symboles joués
    public ArrayList getSymbolesFromModel(){
        return this.jeu.getSymboles();
    }

    // Récupération des statistique
    public ArrayList getStatsFromModel() {
        return this.jeu.getStats();
    }

    public int getPosX(){
        // position du clic par rapport au hauteur max du canvas
        double posX = this.gui.getDrawing().getMousePosition().x;
        int maxX = this.gui.getDrawing().getWidth();
        return this.calculPos(posX, maxX);
    }

    public int getPosY(){
        // position du clic par rapport au hauteur max du canvas
        double posY = this.gui.getDrawing().getMousePosition().y;
        int maxY = this.gui.getDrawing().getHeight();
        return this.calculPos(posY, maxY);
    }
    
    public int calculPos(double pos, int max){
        return (int) pos / (max / 3);
    }
    
    
    public Jeu getModel(){
    	return this.jeu;
    }
    
    public GUIView getGUI(){
    	return this.gui;
    }
}
