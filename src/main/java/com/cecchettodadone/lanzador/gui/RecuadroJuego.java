package com.cecchettodadone.lanzador.gui;

import com.cecchettodadone.lanzador.Juego;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class RecuadroJuego extends JPanel {

    public RecuadroJuego (Juego juego) {
        this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5, true));
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(400, 450));

        JPanel tituloPanel = new JPanel();
        JLabel titulo = new JLabel(juego.getNombre());
        titulo.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 10));
        tituloPanel.add(titulo);


        JPanel abajo = new JPanel();
        abajo.setLayout(new BoxLayout(abajo, BoxLayout.Y_AXIS));
        abajo.add(new JLabel("Descripción: " + juego.getDescripcion()));
        abajo.add(new JLabel("Desarrolladores: " + juego.getDesarrolladores()));
        abajo.add(new JLabel("Versión: " + juego.getVersion()));

        JPanel foto = new JPanel();
        JButton btn = new JButton(juego.getImagenPortada());
        foto.add(btn);
//        foto.setPreferredSize(new Dimension(100,100));
        this.add(tituloPanel, BorderLayout.PAGE_START);

        this.add(foto, BorderLayout.CENTER);
        this.add(abajo, BorderLayout.PAGE_END);
    }

}
