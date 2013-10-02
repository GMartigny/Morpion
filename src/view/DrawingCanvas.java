/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author Guigui
 */
class DrawingCanvas extends JPanel {

    public DrawingCanvas() {
    }
    
    public void paintComponent(Graphics2D g){
        System.out.println("Drawing");
        super.paintComponent(g);
        
        g.drawLine(this.HEIGHT/3, 0, this.HEIGHT/3, this.WIDTH);
    }
}
