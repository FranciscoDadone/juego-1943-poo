package com.cecchettodadone.juego1943.objetosGraficos.bonus;

import com.cecchettodadone.juego1943.Util;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Escopeta extends Bonus{

    private BufferedImage img1, img2, img3, img4;

    public Escopeta(int posX, int posY) {

        img1 = Util.getImage("imagenes/juegos/juego1943/bonus/escopeta/escopeta1.png");
        img2 = Util.getImage("imagenes/juegos/juego1943/bonus/escopeta/escopeta2.png");
        img3 = Util.getImage("imagenes/juegos/juego1943/bonus/escopeta/escopeta3.png");
        img4 = Util.getImage("imagenes/juegos/juego1943/bonus/escopeta/escopeta4.png");

        this.setPosicion(posX, posY);
        this.setDimensiones(new Dimension(16*3,10*3));
    }

    int counter = 0;
    @Override
    public void update(double delta) {
        double posicion = getY() + delta * 100;
        this.setPosicion(getX(), posicion);

        switch ((int)(counter * delta)) {
            case 0:
                setImagen(img1);
                break;
            case 1:
                setImagen(img2);
                break;
            case 2:
                setImagen(img2);
                break;
            case 3:
                setImagen(img3);
                break;
        }

        if ((int)(counter * delta) == 4)
            counter = 0;
        else
            counter += 14;
    }
}














