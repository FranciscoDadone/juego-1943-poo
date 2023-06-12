package com.cecchettodadone.juego1943.objetosGraficos;

import com.cecchettodadone.juego1943.Util;
import com.cecchettodadone.juego1943.audio.Sonido;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BalaLaser extends Municion{

    BufferedImage img;

    public BalaLaser(int posX, int posY,double angulo) {
        super(posX, posY, angulo);

        img = Util.getImage("imagenes/juegos/juego1943/municion/laser/laser.png");
        this.setImagen(img);
        this.setDimensiones(new Dimension(this.getImagen().getWidth()*3,this.getImagen().getHeight()*2));

        Sonido.iniciar("fx/laser");

        this.setDanio(50);
        this.setVelocidad(-900);
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
