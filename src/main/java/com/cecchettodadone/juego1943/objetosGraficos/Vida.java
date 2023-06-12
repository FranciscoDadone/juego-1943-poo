package com.cecchettodadone.juego1943.objetosGraficos;

import com.cecchettodadone.juego1943.Juego1943;
import com.cecchettodadone.juego1943.ObjetoGrafico;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Vida extends ObjetoGrafico {
    private double cantidadVida;
    private BufferedImage vida;
    private Graphics gVida;
    private int widthFondo = Juego1943.getFrame().getWidth() / 5;
    private int width = widthFondo - 6;

    public Vida () {
        this.cantidadVida = 100;
        this.setPosicion(10, Juego1943.getFrame().getHeight() - 60);
    }
    @Override
    public void update(double delta) {

        if (this.cantidadVida > 100)
            this.setCantidadVida(100);

        vida = new BufferedImage(widthFondo, 20, BufferedImage.TYPE_INT_ARGB);

        BufferedImage fondo = new BufferedImage(widthFondo, 20, BufferedImage.TYPE_INT_ARGB);
        Graphics gFondo = fondo.getGraphics();
        gFondo.setColor(Color.DARK_GRAY);
        gFondo.fillRect(0,0,widthFondo,30);

        gVida = vida.getGraphics();
        gVida.drawImage(fondo, 0, 0, widthFondo, 30, null);

        int wRojo = width / 4;
        int wNaranja = width / 4;
        int wAmarillo = width / 2;

        if (cantidadVida > 50) {
            wAmarillo *= (cantidadVida - 50) / 50;
        } else {
            wAmarillo = 0;
            if (cantidadVida > 25) {
                wNaranja *= (cantidadVida - 25) / 25;
            } else {
                wNaranja = 0;
                wRojo *= cantidadVida / 25;
            }
        }

        BufferedImage rojo = new BufferedImage(width / 4, 14, BufferedImage.TYPE_INT_ARGB);
        Graphics gRojo = rojo.getGraphics();
        gRojo.setColor(Color.RED);
        gRojo.fillRect(0, 0, width / 4, 14);
        gVida.drawImage(rojo, 3, 3, wRojo, 14, null);

        BufferedImage naranja = new BufferedImage(width / 4, 14, BufferedImage.TYPE_INT_ARGB);
        Graphics gNaranja = naranja.getGraphics();
        gNaranja.setColor(Color.ORANGE);
        gNaranja.fillRect(0, 0, width / 4, 14);
        gVida.drawImage(naranja, 3 + (width / 4), 3, wNaranja, 14, null);

        BufferedImage amarillo = new BufferedImage(width / 2, 14, BufferedImage.TYPE_INT_ARGB);
        Graphics gAmarillo = amarillo.getGraphics();
        gAmarillo.setColor(Color.YELLOW);
        gAmarillo.fillRect(0, 0, width / 2, 14);
        gVida.drawImage(amarillo, width / 2, 3, wAmarillo, 14, null);

        if (cantidadVida == 0) {
            Juego1943.objetosGraficos.add(new Texto("Game over!", 100, 100, 100, 1000, 300));
            Juego1943.enPausa = true;
        }

        this.setImagen(vida);
    }

    public double getCantidadVida() {
        return cantidadVida;
    }

    public void bajarVida(int valor) {
        setCantidadVida(getCantidadVida()-valor);
    }
    public void subirVida(int valor) {
        setCantidadVida(getCantidadVida()+valor);
    }

    public void setCantidadVida(double cantidadVida) {
        this.cantidadVida = cantidadVida;
    }
}
