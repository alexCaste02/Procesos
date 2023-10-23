package ejsdiapos.cronometro;

import javax.swing.*;
import java.awt.*;

public class ChronoWindow extends JFrame {
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel botPanel;
    private JLabel clockLabel;
    private JButton buttonStart;
    private JButton buttonPause;
    private JButton buttonReset;
    private JTextArea textArea;

    public ChronoWindow() {

        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);


        setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(ChronoWindow::new);
    }
}
