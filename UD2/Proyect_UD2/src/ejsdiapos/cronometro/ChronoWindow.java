package ejsdiapos.cronometro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        setupUI();
        setupListeners();

        setVisible(true);

    }

    private void setupListeners() {
        buttonStart.addActionListener(e -> {

        });

        buttonPause.addActionListener(e -> {

        });
        buttonReset.addActionListener(e -> {

        });
    }

    private void setupUI() {
        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        EventQueue.invokeLater(ChronoWindow::new);
    }
}
