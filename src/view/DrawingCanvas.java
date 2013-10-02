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
        
        gra.setStroke(new BasicStroke(4));
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
        int partX = this.getWidth()/3;
        int partY = this.getHeight()/3;
        
        int x = posX*partX;
        int y = posY*partY;
        
        int b = 20;
        
        if(type == TypeForme.croix){
            gra.drawLine(x+b, y+b, x+partX-b, y+partY-b);
            gra.drawLine(x+b, y+partY-b, x+partX-b, y+b);
        }
        else if(type == TypeForme.rond){
            gra.drawOval(x+b, y+b, partX-2*b, partY-2*b);
        }
    }
    
    
    
}
