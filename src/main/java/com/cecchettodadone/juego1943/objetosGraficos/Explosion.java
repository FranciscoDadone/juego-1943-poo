package com.cecchettodadone.juego1943.objetosGraficos;

import com.cecchettodadone.juego1943.Juego1943;
import com.cecchettodadone.juego1943.ObjetoGrafico;
import com.cecchettodadone.juego1943.Util;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Explosion extends ObjetoGrafico {

    private BufferedImage img1, img2, img3, img4, img5;

    public Explosion (int posX, int posY) {
        img1 = Util.getImage("imagenes/juegos/juego1943/avion_jugador/explotando/avion_jugador_explotando12.png");
        img2 = Util.getImage("imagenes/juegos/juego1943/avion_jugador/explotando/avion_jugador_explotando13.png");
        img3 = Util.getImage("imagenes/juegos/juego1943/avion_jugador/explotando/avion_jugador_explotando14.png");
        img4 = Util.getImage("imagenes/juegos/juego1943/avion_jugador/explotando/avion_jugador_explotando15.png");
        img5 = Util.getImage("imagenes/juegos/juego1943/avion_jugador/explotando/avion_jugador_explotando16.png");

        this.setPosicion(posX, posY);
        this.setDimensiones(new Dimension(50,50));
    }

    int counter = 0;
    @Override
    public void update(double delta) {

        switch ((int)(counter * delta)) {
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
                this.setDimensiones(new Dimension(0,0));
        }

        counter += 10;
    }
}
