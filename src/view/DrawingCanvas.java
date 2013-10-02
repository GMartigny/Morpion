/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.Symbole;
import model.TypeForme;

/**
 *
 * @author Guigui
 */
public class DrawingCanvas extends JPanel {
    
    private ArrayList<Symbole> symboles;

    public DrawingCanvas() {
        this.symboles = new ArrayList<>();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D gra = (Graphics2D)g;
        
        gra.setStroke(new BasicStroke(5));
        gra.drawLine(this.getWidth()/3, 0, this.getWidth()/3, this.getHeight());
        gra.drawLine(2*this.getWidth()/3, 0, 2*this.getWidth()/3, this.getHeight());
        gra.drawLine(0, this.getHeight()/3, this.getWidth(), this.getHeight()/3);
        gra.drawLine(0, 2*this.getHeight()/3, this.getWidth(), 2*this.getHeight()/3);
        
        for (Symbole symbole : symboles) {
            this.drawShape(gra, symbole.getJoueur().getForme().getType(), symbole.getPosX(), symbole.getPosY());
        }
    }

    public void setSymboleList(ArrayList<Symbole> symboles) {
        this.symboles = symboles;
    }

    private void drawShape(Graphics2D gra, TypeForme type, int posX, int posY) {
        if(type == TypeForme.croix){
            gra.drawLine(posX+10, posY+10, (this.getWidth()/3)-10, (this.getHeight()/3)-10);
            gra.drawLine(posX+10, (this.getHeight()/3)-10, (this.getWidth()/3)-10, posY-10);
        }
        else if(type == TypeForme.rond){
            gra.drawOval(posX+10, posY+10, this.getWidth()/3, this.getHeight()/3);
        }
    }
    
    
    
}
