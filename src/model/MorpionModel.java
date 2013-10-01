/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import view.GUIView;

/**
 *
 * @author Guigui
 */
public class MorpionModel extends Observable{
    
    private ArrayList<GUIView> listener;
    private HashMap data;

    public MorpionModel() {
    }

    public void listening(GUIView view) {
        //this.listener.add(view);
    }
    
    public void update(){
        for (GUIView each : listener) {
            each.refresh();
        }
    }
    
    public HashMap get(){
        return this.data;
    }
    
}
