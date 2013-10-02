/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Guigui
 */
public class GUIView extends JFrame{
    
    private MorpionView view;
    
    private DrawingCanvas drawing;
    private JTable tableauScore;
    private JTextField pseudo1;
    private JTextField pseudo2;
    private JPanel stats;

    public GUIView(String nom, MorpionView view) {
        super(nom);
        this.view = view;
        init();
    }
    
    private void init(){
        JPanel mainPanel = new JPanel(new BorderLayout());
        this.add(mainPanel);
        
        JPanel pseudos = new JPanel();
            JLabel j1 = new JLabel("Joueur 1 :");
            pseudos.add(j1);
            this.pseudo1 = new JTextField(15);
            pseudos.add(pseudo1);
            JLabel j2 = new JLabel("Joueur 2 :");
            pseudos.add(j2);
            this.pseudo2 = new JTextField(15);
            pseudos.add(pseudo2);
        mainPanel.add(pseudos, BorderLayout.NORTH);
        
        this.stats = new JPanel();
        stats.setPreferredSize(new Dimension(200, 20));
        mainPanel.add(stats, BorderLayout.EAST);
        
        this.drawing = new DrawingCanvas();
        drawing.setBackground(Color.WHITE);
        drawing.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                
            }
            
        });
        mainPanel.add(drawing);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setMinimumSize(new Dimension(800, 600));
        this.setLocation(700, 300);
        this.pack();
    }
    
    public DrawingCanvas getDrawing(){
        return this.drawing;
    }
    
    public void refreshDrawing(){
        ArrayList arr = this.view.getSymboleFromModel();
        for (Object symbol : arr) {
            
        }
    }
    
    public void refreshStats(){
        this.stats.removeAll();
        ArrayList allStats = this.view.getStatsFromModel();
        for (Object stats : allStats) {
            
        }
    }
    
}
