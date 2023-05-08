package com.cecchettodadone.lanzador;

import javax.swing.*;
import java.awt.*;

public class SistemaDeJuego extends JFrame {

    public SistemaDeJuego() {
        this.setVisible(true);
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.DARK_GRAY);

        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(Color.DARK_GRAY);
        JLabel titulo = new JLabel("SISTEMA DE JUEGO");
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 40));
        panelTitulo.add(titulo);

        JPanel juego = new JPanel();
        this.add(juego, BorderLayout.CENTER);

        this.add(panelTitulo, BorderLayout.NORTH);
    }

}
