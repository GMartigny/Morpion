package controler;

import java.util.Observable;
import java.util.Observer;
import model.Forme;
import model.Jeu;
import model.Joueur;
import model.TypeForme;
import view.MorpionView;

/**
 * Controleur du Morpion
 *
 * @author Guigui
 */
public class MorpionController implements Observer {

    private MorpionView view;
    private Jeu jeu;

    public MorpionController(MorpionView view) {
        this.jeu = view.getModel();
        this.view = view;
    }

    @Override
    public void update(Observable o, Object arg) {
        MorpionView ob = (MorpionView) o;


        //Au click, on ajoute le symbole dans le model "jeu"
        if (arg.equals("click")) {
            //recuperer la case cliquee et le joueur qui a clique
            int posX = ob.getPosX();
            int posY = ob.getPosY();
            Joueur joueur = jeu.getCurrentJoueur();

            jeu.addSymbole(joueur, posX, posY);
            this.view.getGUI().repaint();
        }

        // Le jeu demarre
        if (arg.equals("startGame")) {
            try {
                jeu.setJoueur1(new Joueur(ob.getGUI().getPseudo(1), new Forme(TypeForme.croix)));
                jeu.setJoueur2(new Joueur(ob.getGUI().getPseudo(2), new Forme(TypeForme.rond)));
                jeu.demarrerJeu(this.view.getGUI().getGridSize());

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // Redemarrage du jeu
        if (arg.equals("restartGame")) {
            try {
                jeu.redemarrerJeu();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
