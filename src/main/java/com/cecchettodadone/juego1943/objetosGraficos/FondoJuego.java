package com.cecchettodadone.juego1943.objetosGraficos;

import com.cecchettodadone.juego1943.Juego1943;
import com.cecchettodadone.juego1943.ObjetoGrafico;
import com.cecchettodadone.juego1943.Util;
import java.awt.*;
import java.awt.image.BufferedImage;

public class FondoJuego extends ObjetoGrafico {

    private BufferedImage img21, img22, img23, img24, fondo;

    private final int TILE_SIZE = 100;
    private int frameWidth, frameHeight;
    private Graphics g;

    public FondoJuego () {
        img21 = Util.getImage("imagenes/juegos/juego1943/fondo2/fondo1.png");
        img22 = Util.getImage("imagenes/juegos/juego1943/fondo2/fondo2.png");
        img23 = Util.getImage("imagenes/juegos/juego1943/fondo2/fondo3.png");
        img24 = Util.getImage("imagenes/juegos/juego1943/fondo2/fondo4.png");

        frameWidth = Juego1943.getFrame().getWidth();
        frameHeight = Juego1943.getFrame().getHeight();
        fondo = new BufferedImage(frameWidth, frameHeight + (TILE_SIZE * 2), BufferedImage.TYPE_INT_ARGB);
        g = fondo.getGraphics();
        this.setPosicion(0, 0);
    }

    int counter = frameHeight;
    @Override
    public void update(double delta) {

        int altura = counter * TILE_SIZE * 2;

        for (int anchura = 0; anchura < frameWidth; anchura += TILE_SIZE * 2) {
            g.drawImage(img21, anchura, altura, TILE_SIZE, TILE_SIZE, null);
            g.drawImage(img22, anchura + TILE_SIZE, altura, TILE_SIZE, TILE_SIZE, null);

            g.drawImage(img23, anchura, altura + TILE_SIZE, TILE_SIZE, TILE_SIZE, null);
            g.drawImage(img24, anchura + TILE_SIZE, altura + TILE_SIZE, TILE_SIZE, TILE_SIZE, null);
        }

        double pos = this.getY() + delta * 200.0;
        if (pos > 0) pos = -TILE_SIZE * 2;
        setPosicion(0, pos);

        this.setImagen(fondo);
        counter++;
    }
}
