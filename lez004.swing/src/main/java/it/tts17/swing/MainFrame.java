/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tts17.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.plaf.RootPaneUI;

/**
 *
 * @author tss
 */
public class MainFrame extends JFrame {

    private JLabel welcome;
    private JButton cmd;

    public MainFrame(String titolo) {
        super(titolo);
        initGrafica();
    }

    private void initGrafica() {
        this.setSize(500, 200);
        this.setLocation(100, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //cambiare layout manager
        this.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));

        //label
        welcome = new JLabel("Benvenuto in Swing ....");
        welcome.setFont(new Font("monospaced", Font.BOLD, 24));
        this.getContentPane().add(welcome);

        //button
        cmd = new JButton("INVIO");
        cmd.setPreferredSize(new Dimension(400, 100));
        cmd.setFont(new Font("monospaced", Font.ITALIC, 14));
        this.getContentPane().add(cmd);

        cmd.addActionListener(new AscoltaInvio());
    }

    class AscoltaInvio implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            welcome.setForeground(Color.red);
            cmd.setBackground(Color.YELLOW);
            cmd.setForeground(Color.BLUE);
            JOptionPane.showMessageDialog(rootPane, "Click !!!");
            
        }
    }
}
