package com.cecchettodadone.juego1943.objetosGraficos;

import com.cecchettodadone.juego1943.Util;

import java.awt.*;

public class Bala extends Municion {

    private double angulo;

    public Bala(int posX, int posY, double angulo) {
        super(posX, posY, Util.getImage("imagenes/juegos/juego1943/municion/municion.png"), new Dimension(10, 35));
        setDanio(10);
        setVelocidad(-700);
        this.angulo = angulo;
    }

    public void action() {

    }

    @Override
    public void update(double delta) {
        double velocidadX = velocidad * Math.cos(Math.toRadians(angulo));
        double velocidadY = velocidad * Math.sin(Math.toRadians(angulo));
        setPosicion(this.getX() + velocidadX * delta, this.getY() + velocidadY * delta);
    }

}
