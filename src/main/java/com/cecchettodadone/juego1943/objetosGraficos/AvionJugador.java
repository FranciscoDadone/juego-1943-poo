package com.cecchettodadone.juego1943.objetosGraficos;

import com.cecchettodadone.juego1943.Juego1943;
import com.cecchettodadone.juego1943.ObjetoGrafico;
import com.cecchettodadone.juego1943.Util;
import com.entropyinteractive.Keyboard;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class AvionJugador extends ObjetoGrafico {
    private final int NAVE_DESPLAZAMIENTO_NORMAL = 300;
    private int desplazamiento = NAVE_DESPLAZAMIENTO_NORMAL;
    private final int SEGUNDA_IMG_DOBLANDO_TMR = (int)Util.FRAME_RATE / 2;
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

        if (teclado.isKeyPressed(KeyEvent.VK_DOWN)) {
            this.setPosicionY(this.getY() + desplazamiento * delta);
        }

        if (teclado.isKeyPressed(KeyEvent.VK_UP)) {
            this.setPosicionY(this.getY() - desplazamiento * delta);
        }

        if (teclado.isKeyPressed(KeyEvent.VK_LEFT)) {
            this.setPosicionX(this.getX() - desplazamiento * delta);
            this.setImagen(avionDoblandoIzquierda1);
            doblandoTmr++;
            if (desplazamiento < 600) desplazamiento += 10;
            if (doblandoTmr >= SEGUNDA_IMG_DOBLANDO_TMR) {
                this.setImagen(avionDoblandoIzquierda2);
            }
        }

        if (teclado.isKeyPressed(KeyEvent.VK_RIGHT)) {
            this.setPosicionX(this.getX() + desplazamiento * delta);
            this.setImagen(avionDoblandoDerecha1);
            doblandoTmr++;
            if (desplazamiento < 600) desplazamiento += 10;
            if (doblandoTmr >= SEGUNDA_IMG_DOBLANDO_TMR) this.setImagen(avionDoblandoDerecha2);
        }

        if (!teclado.isKeyPressed(KeyEvent.VK_RIGHT) && !teclado.isKeyPressed(KeyEvent.VK_LEFT)) {
            this.setImagen(avion);
            doblandoTmr = 0;
            desplazamiento = NAVE_DESPLAZAMIENTO_NORMAL;
        }


        // Colisión contra las paredes del frame
        if (this.getX() + this.getDimensiones().getWidth() > Juego1943.getFrame().getWidth()) {
            this.setPosicionX(Juego1943.getFrame().getWidth() - this.getDimensiones().getWidth());
        }
        if (this.getX() <= 0) {
            this.setPosicionX(0);
        }
    }
}
