/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package morpion.v2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;

/**
 *
 * @author Guigui
 */
class MorpionView extends JFrame{
    
    private MorpionModel model;

    public MorpionView(String nom, MorpionModel model) {
        super(nom);
        this.model = model;
        init();
        model.listening(this);
    }
    
    private void init(){
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        JMenuBar menu = new JMenuBar();
            JMenu jeu = new JMenu("Jeu");
                JMenuItem surrender = new JMenuItem("Abandonner");
                surrender.addActionListener(null);
                jeu.add(surrender);
                
                JSeparator line = new JSeparator();
                jeu.add(line);
                
                JMenuItem quit = new JMenuItem("Quitter");
                quit.addActionListener(null);
                jeu.add(quit);
            menu.add(jeu);
            JMenu joueur = new JMenu("Joueur");
                JMenuItem pseudo = new JMenuItem("Pseudo");
                pseudo.addActionListener(null);
                joueur.add(pseudo);
                
                JMenuItem stats = new JMenuItem("Stats");
                stats.addActionListener(null);
                joueur.add(stats);
            menu.add(joueur);
        mainPanel.add(menu, BorderLayout.NORTH);
        
        this.add(mainPanel);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setMinimumSize(new Dimension(300, 300));
        this.setLocation(700, 300);
        this.pack();
    }
    
    public void refresh(){
        
    }
    
}
