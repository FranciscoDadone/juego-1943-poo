package com.cecchettodadone.juego1943.objetosGraficos.enemigos;

import com.cecchettodadone.juego1943.Util;
import com.cecchettodadone.juego1943.objetosGraficos.Avion;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AvionEnemigoVerde extends Avion {

    private BufferedImage avion;

    public AvionEnemigoVerde(int posX, int posY) {
        avion = Util.getImage("imagenes/juegos/juego1943/avion_enemigo1/enemigo.png");

        this.setImagen(avion);
        this.setPosicion(posX, posY);
        this.setDimensiones(new Dimension(75,48));
//        this.setDimensiones(new Dimension(44,40));
        setDesplazamiento(400);
    }

    @Override
    public void update(double delta) {
        setPosicionY(getY() + getDesplazamiento() * delta);
    }
}
