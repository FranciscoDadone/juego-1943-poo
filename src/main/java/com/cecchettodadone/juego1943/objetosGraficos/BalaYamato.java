package com.cecchettodadone.juego1943.objetosGraficos;

import com.cecchettodadone.juego1943.Juego1943;
import com.cecchettodadone.juego1943.Util;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BalaYamato extends Municion{


    BufferedImage img1, img2, img3, img4;

    public BalaYamato(int posX, int posY, double angulo) {
        super(posX, posY, new Dimension(30, 30), angulo);

        img1 = Util.getImage("imagenes/juegos/juego1943/municion/bala_yamato/bala1.png");
        img2 = Util.getImage("imagenes/juegos/juego1943/municion/bala_yamato/bala2.png");
        img3 = Util.getImage("imagenes/juegos/juego1943/municion/bala_yamato/bala3.png");
        img4 = Util.getImage("imagenes/juegos/juego1943/municion/bala_yamato/bala4.png");

        this.setPosicion(posX, posY);
        this.setVelocidad(700);

    }


    int count = 0;
    @Override
    public void update(double delta) {

        double velocidadX = velocidad * Math.cos(Math.toRadians(angulo));
        double velocidadY = velocidad * Math.sin(Math.toRadians(angulo));
        setPosicion(this.getX() + velocidadX * delta, this.getY() + velocidadY * delta);


        switch ((int)(count*delta)) {
            case 0:
                this.setImagen(img1);
                break;
            case 1:
                this.setImagen(img2);
                break;
            case 2:
                this.setImagen(img3);
                break;
            case 3:
                this.setImagen(img3);
                count = 0;
                break;
        }
        count += 1;

        //this.setDimension(new Dimension(this.getImagen().getWidth(),this.getImg().getHeight()));

    }
}
