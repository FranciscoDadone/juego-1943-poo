package com.cecchettodadone.juego1943.objetosGraficos;

import com.cecchettodadone.juego1943.Util;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bala extends Municion {

    private double angulo;
    private boolean alcance;

    BufferedImage img;

    public Bala(int posX, int posY, double angulo, boolean alcance) {
        super(posX, posY,new Dimension(10, 35),angulo);

        switch ((int) angulo) {
            case 90:
                img  = Util.getImage("imagenes/juegos/juego1943/municion/normal/municion.png");
                break;
            case 135:
                img = Util.getImage("imagenes/juegos/juego1943/municion/normal/municion_derecha.png");
                break;
            case 45:
                img = Util.getImage("imagenes/juegos/juego1943/municion/normal/municion_izquierda.png");
                break;
        }

        System.out.println(angulo);

        this.setImagen(img);
        setDanio(10);
        setVelocidad(-700);
        this.alcance = alcance;
        this.angulo = angulo;
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
