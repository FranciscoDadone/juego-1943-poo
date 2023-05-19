package com.cecchettodadone.juego1943.configuracion;

import com.cecchettodadone.juego1943.ObjetoGrafico;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame {

    PanelImagen panelImagen = new PanelImagen();

    public Menu() {
        this.setVisible(true);
        this.setTitle("1943");
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(496, 680));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);

        Border marco = BorderFactory.createLineBorder(Color.BLACK,2);

        //ImageIcon jugar = new ImageIcon(getClass().getResource("/imagenes/juegos/juego1943/menu/jugar.png"));
        JButton btn = new JButton("Jugar");
        btn.setSize(new Dimension(150,50));
        btn.setLocation(50,400);
        btn.setContentAreaFilled(false);
        //btn.setBorderPainted(false);
        btn.setFont(new Font("Arial",Font.BOLD,20));
        btn.setForeground(Color.BLACK);
        btn.setBorder(marco);



        btn.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setForeground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn.setForeground(Color.BLACK);
            }
        });

        JButton btn1 = new JButton("Configuracion");
        btn1.setSize(new Dimension(150,50));
        btn1.setLocation(300,400);
        btn1.setContentAreaFilled(false);
        //btn.setBorderPainted(false);
        btn1.setFont(new Font("Arial",Font.BOLD,20));
        btn1.setForeground(Color.BLACK);
        btn1.setBorder(marco);

        btn1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btn1.setForeground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btn1.setForeground(Color.BLACK);
            }
        });

        this.add(btn1);
        this.add(btn);
        this.add(panelImagen);
    }

}

