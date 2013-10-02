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
    private int gridSize;

    public DrawingCanvas() {
        this.symboles = new ArrayList<Symbole>();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D gra = (Graphics2D) g;

        gra.setStroke(new BasicStroke(4));
        for (int i = 1; i < this.gridSize; i++) {
            gra.drawLine(this.getWidth() / gridSize * i, 0, this.getWidth() / gridSize * i, this.getHeight()); // ligne verticale
            gra.drawLine(0, this.getHeight() / gridSize * i, this.getWidth(), this.getHeight() / gridSize * i); // ligne horyzontale
        }

        for (Symbole symbole : symboles) {
            this.drawShape(gra, symbole.getJoueur().getForme().getType(), symbole.getPosX(), symbole.getPosY());
        }
    }

    public void setSymboleList(ArrayList<Symbole> symboles) {
        this.symboles = symboles;
    }

    private void drawShape(Graphics2D gra, TypeForme type, int posX, int posY) {
        int partX = this.getWidth() / gridSize;
        int partY = this.getHeight() / gridSize;

        int x = posX * partX;
        int y = posY * partY;

        int b = 20;

        if (type == TypeForme.croix) {
            gra.drawLine(x + b, y + b, x + partX - b, y + partY - b);
            gra.drawLine(x + b, y + partY - b, x + partX - b, y + b);
        } else if (type == TypeForme.rond) {
            gra.drawOval(x + b, y + b, partX - 2 * b, partY - 2 * b);
        }
    }

    void setGridSize(int gridSize) {
        this.gridSize = gridSize;
    }
}
