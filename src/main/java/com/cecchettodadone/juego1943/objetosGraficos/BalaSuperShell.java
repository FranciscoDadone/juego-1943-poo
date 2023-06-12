package com.cecchettodadone.juego1943.objetosGraficos;

import com.cecchettodadone.juego1943.Util;
import com.cecchettodadone.juego1943.audio.Sonido;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class BalaSuperShell extends Municion{


    BufferedImage img;

    public BalaSuperShell(int posX, int posY, double angulo) {
        super(posX, posY, angulo);

        img = Util.getImage("imagenes/juegos/juego1943/municion/bala_superShell/bala0.png");
        this.setImagen(img);
        this.setDimensiones(new Dimension(this.getImagen().getWidth()*2,this.getImagen().getHeight()*2));

        this.setDanio(20);
        this.setVelocidad(-650);

        Sonido.iniciar("fx/superShell");

    }

    double velocidadX = 0;
    double velocidadY = 0;
    @Override
    public void update(double delta) {
        velocidadX = velocidad * Math.cos(Math.toRadians(angulo));
        velocidadY = velocidad * Math.sin(Math.toRadians(angulo));
        setPosicion(this.getX() + velocidadX * delta, this.getY() + velocidadY * delta);
    }
}
