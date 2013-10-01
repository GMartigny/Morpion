/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package morpion.v2;

import javax.swing.SwingUtilities;

/**
 *
 * @author Guigui
 */
public class MorpionV2 {

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
                MorpionController controller = new MorpionController();
            }
        });
    }
}
