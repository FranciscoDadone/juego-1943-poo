package com.cecchettodadone.juego1943.objetosGraficos;

import com.cecchettodadone.juego1943.Util;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bala extends Municion {
    public Bala(int posX, int posY) {
        super(posX, posY, Util.getImage("imagenes/juegos/juego1943/municion/municion.png"), new Dimension(10, 35));
        setDanio(10);
        setVelocidad(-700);
    }

    @Override
    public void update(double delta) {
        setPosicion(this.getX(), this.getY() + velocidad * delta);
    }
}
