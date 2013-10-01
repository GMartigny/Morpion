/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package launcher;

import view.MorpionView;
import controler.MorpionController;
import javax.swing.SwingUtilities;
import model.MorpionModel;
import view.GUIView;

/**
 *
 * @author Guigui
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // connection au serveur
        
        // lancement de l'appli
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                MorpionModel model = new MorpionModel();
                MorpionView view = new MorpionView("Morpion", model);
                model.addObserver(view);
                MorpionController controler = new MorpionController();
                view.addObserver(controler);
            }
        });
    }
}
