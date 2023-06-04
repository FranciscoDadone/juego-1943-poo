package com.cecchettodadone.juego1943.objetosGraficos.bonus;

import com.cecchettodadone.juego1943.Util;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Pow extends Bonus implements  Bonusable{
    private BufferedImage img1, img2;

    public Pow(int posX, int posY) {

        img1 = Util.getImage("imagenes/juegos/juego1943/bonus/pow/pow1.png");
        img2 = Util.getImage("imagenes/juegos/juego1943/bonus/pow/pow2.png");

        this.setPosicion(posX,posY);
        this.setDimensiones(new Dimension(16*2,12*2));
    }

    int counter = 0;
    @Override
    public void update(double delta) {

        double posicion = getY() + delta * 100;
        this.setPosicion(getX(),posicion);

        if ((int)(counter * delta)%2 == 0)
            setImagen(img1);
        else
            setImagen(img2);
        counter += 5;

    }

    @Override
    public void action() {

    }
}
