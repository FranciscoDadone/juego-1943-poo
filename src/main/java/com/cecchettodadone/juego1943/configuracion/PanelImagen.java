package com.cecchettodadone.juego1943.configuracion;

import com.cecchettodadone.lanzador.gui.RecuadroJuego;

import javax.swing.*;
import java.awt.*;


class PanelImagen extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension dimension = this.getSize();
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/juegos/juego1943/menu/portada.png"));
        g.drawImage(icon.getImage(), 0, 0, dimension.width, dimension.height, null);
    }

}
