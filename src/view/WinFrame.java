/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Guigui
 */
class WinFrame extends JFrame{
    
    private MorpionView view;

    public WinFrame(MorpionView view) {
        super("Hell Yeah !");
        this.setLayout(new FlowLayout());
        this.view = view;
        
        init();
        
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(view.getGUI());
    }

    private void init() {
        this.add(new JLabel("C'est " + this.view.getModel().getCurrentJoueur().getPseudo() + " qui gagne !"));
        JButton ok = new JButton("Ok");
        ok.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                view.makeNotify("restartGame");
                view.saveStats();
                dispose();
            }
        });
        this.add(ok);
    }
    
    
    
}
