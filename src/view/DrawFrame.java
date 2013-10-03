package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Frame pop-up en cas d'égalité
 * 
 * @author Guigui
 */
class DrawFrame extends JFrame {

    private final MorpionView view;

    public DrawFrame(MorpionView view) {
        super("Et mince =/");

        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        this.setLayout(new FlowLayout());
        this.view = view;

        this.view.getGUI().setEnabled(false);

        init();
        
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(view.getGUI());
    }

    private void init() {
        this.add(new JLabel("Les deux joueurs font égalitées"));
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
