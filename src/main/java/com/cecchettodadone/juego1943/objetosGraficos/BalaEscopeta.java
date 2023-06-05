package com.cecchettodadone.juego1943.objetosGraficos;

import com.cecchettodadone.juego1943.Util;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BalaEscopeta extends Municion{

    private BufferedImage img1 = Util.getImage("imagenes/juegos/juego1943/municion/escopeta/escopeta1.png");
    private BufferedImage img2 = Util.getImage("imagenes/juegos/juego1943/municion/escopeta/escopeta2.png");
    public BalaEscopeta(int posX, int posY, double angulo, boolean alcance) {
        super(posX, posY, Util.getImage("imagenes/juegos/juego1943/municion/escopeta/escopeta1.png"), new Dimension(14*2,6*2), angulo);
        this.setImagen(img1);
        this.setPosicion(posX, posY);
        this.angulo = angulo;
        this.alcance = alcance;

        setDanio(13);
        setVelocidad(-650);
    }


    int count,countAnimacion = 0;
    @Override
    public void update(double delta) {

        this.setImagen(img1);
        double velocidadX = velocidad * Math.cos(Math.toRadians(angulo));
        double velocidadY = velocidad * Math.sin(Math.toRadians(angulo));
        setPosicion(this.getX() + velocidadX * delta, this.getY() + velocidadY * delta);

        if (alcance) {
            if ((int)(count * delta) == 1) {
                this.setDimension(new Dimension(0, 0));
            }
            count += 2;
        }

        if (((int)(countAnimacion*delta)%2 == 0)) {
            this.setImagen(img2);
        }

        countAnimacion += 5;

    }
}
