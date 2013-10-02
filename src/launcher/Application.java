/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package launcher;

import controler.MorpionController;
import javax.swing.SwingUtilities;
import model.Forme;
import model.Jeu;
import model.Joueur;
import model.Stat;
import model.TypeForme;
import view.MorpionView;

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
                Jeu jeu = new Jeu();
                
                MorpionView view = new MorpionView("Morpion", jeu);
                jeu.addObserver(view);
                
                MorpionController controler = new MorpionController(view);
                view.addObserver(controler);
            }
        });
    }
}
