package com.cecchettodadone.juego1943.objetosGraficos;

import com.cecchettodadone.juego1943.ObjetoGrafico;

import java.awt.*;
import java.awt.image.BufferedImage;
import com.cecchettodadone.juego1943.Util;

public class PortaAviones extends ObjetoGrafico {
    private BufferedImage barco ;

    public PortaAviones(int posX, int posY) {
        barco = Util.getImage("imagenes/juegos/juego1943/barcos/barco.png");

        this.setImagen(barco);
        this.setPosicion(posX,posY);
        this.setDimensiones(new Dimension(59*4,241*4));
    }

    @Override
    public void update(double delta) {

    }
}
