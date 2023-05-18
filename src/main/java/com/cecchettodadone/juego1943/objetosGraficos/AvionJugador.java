package com.cecchettodadone.juego1943.objetosGraficos;

import com.cecchettodadone.juego1943.ObjetoGrafico;
import com.cecchettodadone.juego1943.Util;
import com.entropyinteractive.Keyboard;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class AvionJugador extends ObjetoGrafico {
    private final double NAVE_DESPLAZAMIENTO = 300;
    private int doblandoTmr = 0;
    private BufferedImage avion, avionDoblandoDerecha1, avionDoblandoIzquierda1, avionDoblandoDerecha2, avionDoblandoIzquierda2;

    public AvionJugador (int x, int y) {
        avion = Util.getImage("imagenes/juegos/juego1943/avion_jugador/avion.png");
        avionDoblandoDerecha1 = Util.getImage("imagenes/juegos/juego1943/avion_jugador/avion_doblando_derecha1.png");
        avionDoblandoDerecha2 = Util.getImage("imagenes/juegos/juego1943/avion_jugador/avion_doblando_derecha2.png");
        avionDoblandoIzquierda1 = Util.getImage("imagenes/juegos/juego1943/avion_jugador/avion_doblando_izquierda1.png");
        avionDoblandoIzquierda2 = Util.getImage("imagenes/juegos/juego1943/avion_jugador/avion_doblando_izquierda2.png");

        this.setImagen(avion);
        this.setPosicion(x / 2, y / 2);
        this.setDimensiones(new Dimension(75, 48));
    }

    @Override
    public void update(double delta, Keyboard teclado) {
        if (!this.getImagen().equals(avion)) this.setImagen(avion);

        if (teclado.isKeyPressed(KeyEvent.VK_DOWN)) {
            this.setPosicionY(this.getY() + NAVE_DESPLAZAMIENTO * delta);
        }

        if (teclado.isKeyPressed(KeyEvent.VK_UP)) {
            this.setPosicionY(this.getY() - NAVE_DESPLAZAMIENTO * delta);
        }

        if (teclado.isKeyPressed(KeyEvent.VK_LEFT)) {
            this.setPosicionX(this.getX() - NAVE_DESPLAZAMIENTO * delta);
            this.setImagen(avionDoblandoIzquierda1);
        }

        if (teclado.isKeyPressed(KeyEvent.VK_RIGHT)) {
            this.setPosicionX(this.getX() + NAVE_DESPLAZAMIENTO * delta);
            this.setImagen(avionDoblandoDerecha1);
        }
    }
}
