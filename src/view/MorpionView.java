/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Observable;
import java.util.Observer;
import model.MorpionModel;

/**
 *
 * @author Guigui
 */
public class MorpionView extends Observable implements Observer{
    
    private GUIView gui;

    public MorpionView(String nom, MorpionModel model) {
        this.gui = new GUIView(nom, model);
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
