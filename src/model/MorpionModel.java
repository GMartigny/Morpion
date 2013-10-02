/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author Guigui
 */
public class MorpionModel extends Observable{
    
    private ArrayList data;

    public MorpionModel() {
        
    }

    public ArrayList getData() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    public void add(){
        
    }

    public ArrayList getSymbole() {
        return this.data;
    }

    public ArrayList getStats() {
        return this.data;
    }
}
