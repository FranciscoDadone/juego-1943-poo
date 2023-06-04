package com.cecchettodadone.juego1943.objetosGraficos.bonus;

import com.cecchettodadone.juego1943.Util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.sql.Ref;

public class Refuerzo extends Bonus implements Bonusable{

    private BufferedImage img1, img2, img3, img4, img5, img6;

    public Refuerzo(int posX, int posY) {

        img1 = Util.getImage("imagenes/juegos/juego1943/bonus/refuerzo/refuerzo1.png");
        img2 = Util.getImage("imagenes/juegos/juego1943/bonus/refuerzo/refuerzo2.png");
        img3 = Util.getImage("imagenes/juegos/juego1943/bonus/refuerzo/refuerzo3.png");
        img4 = Util.getImage("imagenes/juegos/juego1943/bonus/refuerzo/refuerzo4.png");
        img5 = Util.getImage("imagenes/juegos/juego1943/bonus/refuerzo/refuerzo5.png");
        img6 = Util.getImage("imagenes/juegos/juego1943/bonus/refuerzo/refuerzo6.png");

        this.setPosicion(posX,posY);
        this.setDimensiones(new Dimension(16*2,15*2));
    }

    int counter = 0;
    @Override
    public void update(double delta) {

        double posicion = getY() + delta * 100;
        this.setPosicion(getX(), posicion);


        switch ((int)(counter * delta )) {
            case 0:
                setImagen(img1);
                break;
            case 1:
                setImagen(img2);
                break;
            case 2:
                setImagen(img3);
                break;
            case 3:
                setImagen(img4);
                break;
            case 4:
                setImagen(img5);
                break;
            case 5:
                setImagen(img6);
                break;
        }

        if ((int)(counter * delta ) == 6)
            counter = 0;
        else
            counter += 12;
    }

    @Override
    public void action() {

    }
}


