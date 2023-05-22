package com.cecchettodadone.juego1943.objetosGraficos;

import com.cecchettodadone.juego1943.Juego1943;
import com.cecchettodadone.juego1943.ObjetoGrafico;
import com.cecchettodadone.juego1943.Util;
import com.entropyinteractive.Keyboard;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class AvionJugador extends Avion {
    private final int SEGUNDA_IMG_DOBLANDO_TMR = (int)Util.FRAME_RATE / 2;
    private int doblandoTmr = 0;
    private BufferedImage avion, avionDoblandoDerecha1, avionDoblandoIzquierda1, avionDoblandoDerecha2, avionDoblandoIzquierda2;

    public AvionJugador (int posX, int posY) {
        super(posX, posY);
        setDesplazamiento(300);
        avion = Util.getImage("imagenes/juegos/juego1943/avion_jugador/avion.png");
        avionDoblandoDerecha1 = Util.getImage("imagenes/juegos/juego1943/avion_jugador/avion_doblando_derecha1.png");
        avionDoblandoDerecha2 = Util.getImage("imagenes/juegos/juego1943/avion_jugador/avion_doblando_derecha2.png");
        avionDoblandoIzquierda1 = Util.getImage("imagenes/juegos/juego1943/avion_jugador/avion_doblando_izquierda1.png");
        avionDoblandoIzquierda2 = Util.getImage("imagenes/juegos/juego1943/avion_jugador/avion_doblando_izquierda2.png");

        this.setImagen(avion);
        this.setPosicion(posX, posY);
        this.setDimensiones(new Dimension(75, 48));
    }

    @Override
    public void update(double delta) {
        Keyboard teclado = Juego1943.getFrame().getKeyboard();
        double velocidad = desplazamiento * delta; // Velocidad lineal

        double desplazamientoX = 0;
        double desplazamientoY = 0;

        if (teclado.isKeyPressed(KeyEvent.VK_DOWN)) desplazamientoY += velocidad;
        if (teclado.isKeyPressed(KeyEvent.VK_UP)) desplazamientoY -= velocidad;

        if (teclado.isKeyPressed(KeyEvent.VK_LEFT)) {
            desplazamientoX -= velocidad;
            this.setImagen(avionDoblandoIzquierda1);
            doblandoTmr++;
            if (desplazamiento < 1000) desplazamiento += 10;
            if (doblandoTmr >= SEGUNDA_IMG_DOBLANDO_TMR) {
                this.setImagen(avionDoblandoIzquierda2);
            }
        }

        if (teclado.isKeyPressed(KeyEvent.VK_RIGHT)) {
            desplazamientoX += velocidad;
            this.setImagen(avionDoblandoDerecha1);
            doblandoTmr++;
            if (desplazamiento < 1000) desplazamiento += 10;
            if (doblandoTmr >= SEGUNDA_IMG_DOBLANDO_TMR) this.setImagen(avionDoblandoDerecha2);
        }

        if (desplazamientoX != 0 && desplazamientoY != 0) {
            // Movimiento en diagonal
            double distanciaDiagonal = Math.sqrt(desplazamientoX * desplazamientoX + desplazamientoY * desplazamientoY);
            double factorNormalizacion = velocidad / distanciaDiagonal;
            desplazamientoX *= factorNormalizacion;
            desplazamientoY *= factorNormalizacion;
        }

        if (!teclado.isKeyPressed(KeyEvent.VK_RIGHT) && !teclado.isKeyPressed(KeyEvent.VK_LEFT)) {
            this.setImagen(avion);
            doblandoTmr = 0;
            desplazamiento = NAVE_DESPLAZAMIENTO_NORMAL;
        }

        this.setPosicionX(this.getX() + desplazamientoX);
        this.setPosicionY(this.getY() + desplazamientoY);

        // Colisión contra las paredes del frame
        if (this.getX() + this.getDimensiones().getWidth() > Juego1943.getFrame().getWidth()) {
            this.setPosicionX(Juego1943.getFrame().getWidth() - this.getDimensiones().getWidth());
        }
        if (this.getY() + this.getDimensiones().getHeight() * 2 > Juego1943.getFrame().getHeight()) {
            this.setPosicionY(Juego1943.getFrame().getHeight() - this.getDimensiones().getHeight() * 2);
        }
        
        if (this.getX() <= 0) this.setPosicionX(0);
        if (this.getY() <= this.getDimensiones().getHeight()) this.setPosicionY(this.getDimensiones().getHeight());

    }


}
