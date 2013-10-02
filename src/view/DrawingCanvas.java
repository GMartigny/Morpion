/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.ArrayList;
import javax.swing.JPanel;
import model.Symbole;

/**
 *
 * @author Guigui
 */
class DrawingCanvas extends JPanel {

    public DrawingCanvas() {
    }
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D gra = (Graphics2D)g;
        super.paintComponent(gra);
        
        gra.setStroke(new BasicStroke(5));
        gra.drawLine(this.getWidth()/3, 0, this.getWidth()/3, this.getHeight());
        gra.drawLine(2*this.getWidth()/3, 0, 2*this.getWidth()/3, this.getHeight());
        gra.drawLine(0, this.getHeight()/3, this.getWidth(), this.getHeight()/3);
        gra.drawLine(0, 2*this.getHeight()/3, this.getWidth(), 2*this.getHeight()/3);
    }
    
    public void paintSymboles(ArrayList<Symbole> symboles){
        
    }
}
