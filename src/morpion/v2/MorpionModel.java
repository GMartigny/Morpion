/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package morpion.v2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Guigui
 */
class MorpionModel {
    
    private ArrayList<MorpionView> listener;
    private HashMap data;

    public MorpionModel() {
    }

    public void listening(MorpionView view) {
        //this.listener.add(view);
    }
    
    public void update(){
        for (MorpionView each : listener) {
            each.refresh();
        }
    }
    
    public HashMap get(){
        return this.data;
    }
    
}
