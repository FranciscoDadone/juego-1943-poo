package com.cecchettodadone.lanzador.gui;

import com.cecchettodadone.lanzador.Juego;
import com.cecchettodadone.lanzador.SistemaDeJuego;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class RecuadroJuego extends JPanel implements ActionListener {

    public RecuadroJuego (Juego juego, SistemaDeJuego sistemaDeJuego) {
        this.juego = juego;
        this.sistemaDeJuego = sistemaDeJuego;
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
        btn = new JButton(juego.getImagenPortada());
        btn.addActionListener(this);
        foto.add(btn);
        this.add(tituloPanel, BorderLayout.PAGE_START);

        this.add(foto, BorderLayout.CENTER);
        this.add(abajo, BorderLayout.PAGE_END);

    }

    private JButton btn;
    private Juego juego;

    private SistemaDeJuego sistemaDeJuego;


    @Override
    public void actionPerformed(ActionEvent e) {
        if (juego.isImplementado())
            sistemaDeJuego.setVisible(false);
        if (!e.getSource().equals(btn)) return;
            juego.run(1/60);
    }
}
