package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import model.Stat;

/**
 * Frame principale avec fonction de dessins
 * et elements de l'IHM
 * 
 * @author Guigui
 */
public class GUIView extends JFrame {

    private MorpionView view;
    private DrawingCanvas drawing;
    private JTextField pseudo1;
    private JTextField pseudo2;
    private JPanel stats;
    private JPanel chooseGridSize;
    private int gridSize = 3;
    private JPanel mainPanel;
    private JPanel pseudos;

    public GUIView(String nom, MorpionView view) {
        super(nom);
        this.view = view;
        init();
    }

    private void init() {
        this.mainPanel = new JPanel(new BorderLayout());
        this.add(mainPanel);

        this.pseudos = new JPanel();
        JLabel j1 = new JLabel("Joueur 1 :");
        pseudos.add(j1);
        this.pseudo1 = new JTextField("Player", 15);
        pseudos.add(pseudo1);
        JLabel j2 = new JLabel("Joueur 2 :");
        pseudos.add(j2);
        this.pseudo2 = new JTextField("Challenger", 15);
        pseudos.add(pseudo2);
        mainPanel.add(pseudos, BorderLayout.NORTH);

        this.stats = new JPanel();
        stats.setLayout(new BoxLayout(stats, BoxLayout.Y_AXIS));
        stats.setPreferredSize(new Dimension(250, 20));
        mainPanel.add(stats, BorderLayout.EAST);

        this.drawing = new DrawingCanvas();
        drawing.setBackground(Color.WHITE);
        drawing.setCursor(new Cursor(Cursor.HAND_CURSOR));
        drawing.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                view.makeNotify("click");
            }
        });

        this.chooseGridSize = new JPanel();
        JRadioButton grid3 = new JRadioButton("3 x 3");
        grid3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gridSize = 3;
            }
        });
        grid3.setSelected(true);
        JRadioButton grid4 = new JRadioButton("4 x 4");
        grid4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gridSize = 4;
            }
        });

        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(grid3);
        radioGroup.add(grid4);

        chooseGridSize.add(new JLabel("Choisissez votre grille :"));
        chooseGridSize.add(grid3);
        chooseGridSize.add(grid4);
        JButton start = new JButton("Ok");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.makeNotify("startGame");
            }
        });
        chooseGridSize.add(start);

        mainPanel.add(chooseGridSize);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setMinimumSize(new Dimension(800, 600));
        this.setLocationRelativeTo(null);
        this.pack();
    }

    public DrawingCanvas getDrawing() {
        return this.drawing;
    }

    public String getPseudo(int num) throws Exception {
        switch (num) {
            case 1:
                return this.pseudo1.getText();
            case 2:
                return this.pseudo2.getText();
            default:
                throw new Exception("Unknown player's number");
        }
    }

    public int getGridSize() {
        return this.gridSize;
    }

    // Enleve les textfield et les radio pour le parametrage du depart
    public void startDrawing() {
        this.mainPanel.remove(this.pseudos);
        pseudos = new JPanel();
        try {
            pseudos.add(new JLabel(this.getPseudo(1) + " contre " + this.getPseudo(2)));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        this.mainPanel.add(this.pseudos, BorderLayout.NORTH);

        this.mainPanel.remove(this.chooseGridSize);
        drawing.setGridSize(this.getGridSize());
        mainPanel.add(this.drawing, BorderLayout.CENTER);
        this.pack();
    }

    public void refreshDrawing(ArrayList symboles) {
        this.drawing.setSymboleList(symboles);
        drawing.repaint();
    }

    public void refreshStats(ArrayList<Stat> allStats) {
        this.stats.removeAll();

        JPanel buf;

        for (Stat stat : allStats) {
            buf = new JPanel(new GridBagLayout());
            buf.setMaximumSize(new Dimension(240, 60));
            buf.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
            JLabel info = new JLabel(stat.toString());
            buf.add(info);

            this.stats.add(buf);

            JPanel spacer = new JPanel();
            spacer.setMaximumSize(new Dimension(1, 20));

            this.stats.add(spacer);
        }
        this.stats.revalidate();
    }
}
