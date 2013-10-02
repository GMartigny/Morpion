/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.util.Observable;
import java.util.Observer;
import view.GUIView;

/**
 *
 * @author Guigui
 */
public class MorpionController implements Observer{
    
    GUIView view;

    public MorpionController() {
            
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
