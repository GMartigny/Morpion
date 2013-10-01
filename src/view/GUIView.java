/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.MorpionModel;

/**
 *
 * @author Guigui
 */
public class GUIView extends JFrame{
    
    private MorpionModel model;
    private JPanel drawing;
    private JTable tableauScore;

    public GUIView(String nom, MorpionModel model) {
        super(nom);
        this.model = model;
        init();
    }
    
    private void init(){
        JPanel mainPanel = new JPanel(new BorderLayout());
        this.add(mainPanel);
        
        JPanel pseudos = new JPanel();
            JLabel j1 = new JLabel("Joueur 1 :");
        mainPanel.add(pseudos, BorderLayout.NORTH);
        
        JPanel stats = new JPanel();
            this.tableauScore = new JTable(4, 1); // pas table
            stats.add(tableauScore);
            
        mainPanel.add(stats, BorderLayout.EAST);
        
        this.drawing = new JPanel();
        mainPanel.add(drawing);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setMinimumSize(new Dimension(400, 400));
        this.setLocation(700, 300);
        this.pack();
    }
    
    public void refresh(){
        
    }
    
}
