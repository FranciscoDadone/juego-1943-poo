package com.cecchettodadone.juego1943.objetosGraficos.enemigos;

import com.cecchettodadone.juego1943.Juego1943;
import com.cecchettodadone.juego1943.ObjetoGrafico;
import com.cecchettodadone.juego1943.Util;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Yamato extends ObjetoGrafico {

    BufferedImage img = null;

    public Yamato(int posX, int posY) {
        img = Util.getImage("imagenes/juegos/juego1943/Yamato/yamato1.png");

        this.setImagen(img);
        this.setPosicion(posX, posY);
        this.setDimensiones(new Dimension(111,470));
    }

    @Override
    public void update(double delta) {

    }
}
