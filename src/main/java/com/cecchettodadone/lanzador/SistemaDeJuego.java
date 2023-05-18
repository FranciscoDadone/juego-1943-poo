package com.cecchettodadone.lanzador;

import com.cecchettodadone.MarioBross.MarioBross;
import com.cecchettodadone.juego1943.Juego1943;
import com.cecchettodadone.lanzador.gui.RecuadroJuego;
import com.entropyinteractive.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import java.awt.*;
import java.awt.event.*; //eventos

import java.awt.image.*;  //imagenes
import javax.imageio.*; //imagenes

import java.awt.Graphics2D;

import java.awt.geom.*; //Point2d
import java.util.LinkedList;

import java.util.*;
import java.text.*;




public class SistemaDeJuego extends JFrame {

    public  SistemaDeJuego() {
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.DARK_GRAY);

        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(Color.DARK_GRAY);
        JLabel titulo = new JLabel("SISTEMA DE JUEGO");
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        panelTitulo.add(titulo);

        JPanel juegos = new JPanel();
        juegos.setLayout(new FlowLayout());

        // Juegos
        juegos.add(new RecuadroJuego(new Juego1943(),this));
        juegos.add(new RecuadroJuego(new MarioBross(),this));



        this.add(juegos, BorderLayout.CENTER);


        this.add(panelTitulo, BorderLayout.NORTH);
        this.pack();
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
    }

}
