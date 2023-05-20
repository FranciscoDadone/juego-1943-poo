package com.cecchettodadone.juego1943.configuracion;

import com.cecchettodadone.juego1943.Juego1943;
import com.cecchettodadone.lanzador.Juego;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame {

    PanelImagen panelImagen = new PanelImagen();

    Configurador confi;

    public Menu(Juego1943 juego) {
        this.setVisible(true);
        this.setTitle("1943");
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(496, 680));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        Border marco = BorderFactory.createLineBorder(Color.BLACK,2);

        //ImageIcon jugar = new ImageIcon(getClass().getResource("/imagenes/juegos/juego1943/menu/jugar.png"));
        JButton jugar = new JButton("Jugar");
        jugar.setSize(new Dimension(150,50));
        jugar.setLocation(50,400);
        jugar.setContentAreaFilled(false);
        //btn.setBorderPainted(false);
        jugar.setFont(new Font("Arial",Font.BOLD,20));
        jugar.setForeground(Color.BLACK);
        jugar.setBorder(marco);



        jugar.addMouseListener(new MouseListener() {
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
                jugar.setForeground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jugar.setForeground(Color.BLACK);
            }
        });

        JButton confis = new JButton("Configuracion");
        confis.setSize(new Dimension(150,50));
        confis.setLocation(300,400);
        confis.setContentAreaFilled(false);
        //btn.setBorderPainted(false);
        confis.setFont(new Font("Arial",Font.BOLD,20));
        confis.setForeground(Color.BLACK);
        confis.setBorder(marco);

        confis.addMouseListener(new MouseListener() {
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
                confis.setForeground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                confis.setForeground(Color.BLACK);
            }
        });

        this.add(jugar);
        this.add(confis);
        this.add(panelImagen);


        jugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                juego.run(1/60);

            }
        });

        confis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confi = new Configurador();
            }
        });

    }

}

