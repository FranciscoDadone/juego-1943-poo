package com.cecchettodadone.juego1943.objetosGraficos;

import com.cecchettodadone.juego1943.Util;

import java.awt.*;

public class Bala extends Municion {

    private double angulo;
    private boolean alcance;

    public Bala(int posX, int posY, double angulo, boolean alcance) {
        super(posX, posY, Util.getImage("imagenes/juegos/juego1943/municion/municion.png"), new Dimension(10, 35));
        setDanio(10);
        setVelocidad(-700);
        this.alcance = alcance;
        this.angulo = angulo;
    }

    public void action() {

    }

    double count = 0;
    @Override
    public void update(double delta) {
        double velocidadX = velocidad * Math.cos(Math.toRadians(angulo));
        double velocidadY = velocidad * Math.sin(Math.toRadians(angulo));
        setPosicion(this.getX() + velocidadX * delta, this.getY() + velocidadY * delta);
        if (alcance) {
            if ((int) (count * delta) == 1) {
                this.setDimension(new Dimension(0, 0));
            }
            count += 2;
        }
    }

}
