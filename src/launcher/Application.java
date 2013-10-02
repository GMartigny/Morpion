package launcher;

import controler.MorpionController;
import javax.swing.SwingUtilities;
import model.Jeu;
import view.MorpionView;

/**
 * Lanceur de l'application
 *
 * @author Guigui
 */
public class Application {

    public static void main(String[] args) {
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
