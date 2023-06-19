package org.example;

import javax.swing.*;
import java.awt.*;

public class Grazie extends JFrame{
    private JTextArea textArea;

    public Grazie() {
        JLabel title = new JLabel("Grazie mille a tutti! :D", JLabel.CENTER);
        add(title, BorderLayout.NORTH);

        textArea = new JTextArea(40, 80);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        printThanks();
    }

    private void printThanks() {
        Font boldFont = new Font("Segoe Print", Font.BOLD,14);
        textArea.setFont(boldFont);
        new Thread(() -> {
            textArea.append("Grazie mille Giulia e Sara per averci tenuti aggiornati su tutto in questi mesi!\n");
            textArea.append("Grazie mille a Lorenzo e Marco che hanno avuto la pazienza e il piacere di condividere con noi la loro conoscenza!\n");
            textArea.append("Grazie mille ai colleghi che sono stati disponibili e hanno reso il tutto un'esperienza piacevole!\n");

            for (int i = 0; i < 997; i++) {
                try {
                    if (i <= 10){
                        Thread.sleep(1000);
                    } else {
                        Thread.sleep(20);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                textArea.append("Grazie! <3\n");
                textArea.setCaretPosition(textArea.getDocument().getLength());
            }
            textArea.append("Grazie mille non era solo un modo di dire :D\n");
        }).start();
    }
}
