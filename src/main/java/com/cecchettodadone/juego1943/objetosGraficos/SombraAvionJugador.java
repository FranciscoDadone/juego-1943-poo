package com.cecchettodadone.juego1943.objetosGraficos;

import java.awt.*;
import java.awt.image.BufferedImage;

import com.cecchettodadone.juego1943.Util;

public class SombraAvionJugador extends Avion{

    private AvionJugador avion;
    private BufferedImage avionSombra, avionDerecha1, avionDerecha2, avionIzquierda1, avionIzquierda2;

    public SombraAvionJugador(AvionJugador avion){

        this.avion = avion;

        avionSombra = Util.getImage("imagenes/juegos/juego1943/avion_jugador/sombra/sombra_avion.png");

        avionDerecha1 = Util.getImage("imagenes/juegos/juego1943/avion_jugador/sombra/sombra_avion_doblando_derecha1.png");
        avionDerecha2 = Util.getImage("imagenes/juegos/juego1943/avion_jugador/sombra/sombra_avion_doblando_derecha2.png");

        avionIzquierda1 = Util.getImage("imagenes/juegos/juego1943/avion_jugador/sombra/sombra_avion_doblando_izquierda1.png");
        avionIzquierda2 = Util.getImage("imagenes/juegos/juego1943/avion_jugador/sombra/sombra_avion_doblando_izquierda2.png");

        this.setImagen(avionSombra);
        setPosicion(avion.getX()+50,avion.getY()+50);
        setDimensiones(new Dimension(75,48));

    }
    @Override
    public void update(double delta) {
        setPosicion(avion.getX()+50,avion.getY()+50);

        if (avion.getDirec() != null){
            switch (avion.getDirec()) {
                case adelante:
                    this.setImagen(avionSombra);
                    break;
                case izquierda1:
                    this.setImagen(avionIzquierda1);
                    break;
                case izquierda2:
                    this.setImagen(avionIzquierda2);
                    break;
                case derecha1:
                    this.setImagen(avionDerecha1);
                    break;
                case derecha2:
                    this.setImagen(avionDerecha2);
                    break;
            }
        }
    }
}
