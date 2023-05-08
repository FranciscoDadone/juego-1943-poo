package com.cecchettodadone.lanzador;

import com.cecchettodadone.juego1943.Juego1943;
import com.cecchettodadone.lanzador.gui.RecuadroJuego;

import javax.swing.*;
import java.awt.*;

public class SistemaDeJuego extends JFrame {

    public SistemaDeJuego() {
        this.setVisible(true);
//        this.setSize(new Dimension(800,800)); // Toolkit.getDefaultToolkit().getScreenSize()
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
        juegos.add(new RecuadroJuego(new Juego1943()));
//        juegos.add(new RecuadroJuego());
//        juegos.add(new RecuadroJuego());
//        juegos.add(new RecuadroJuego());

        this.add(juegos, BorderLayout.CENTER);


        this.add(panelTitulo, BorderLayout.NORTH);
        this.pack();
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
    }

}
