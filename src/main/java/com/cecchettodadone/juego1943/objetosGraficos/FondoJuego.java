package com.cecchettodadone.juego1943.objetosGraficos;

import com.cecchettodadone.juego1943.Juego1943;
import com.cecchettodadone.juego1943.ObjetoGrafico;
import com.cecchettodadone.juego1943.Util;
import com.entropyinteractive.Keyboard;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FondoJuego extends ObjetoGrafico {

    private BufferedImage img1, img2, img3, img4, img5, img6, img7, img8, img21, img22, img23, img24;

    private final int TILE_SIZE = 100;

    public FondoJuego () {
        img1 = Util.getImage("imagenes/juegos/juego1943/fondo/fondo1.png");
        img2 = Util.getImage("imagenes/juegos/juego1943/fondo/fondo2.png");
        img3 = Util.getImage("imagenes/juegos/juego1943/fondo/fondo3.png");
        img4 = Util.getImage("imagenes/juegos/juego1943/fondo/fondo4.png");
        img5 = Util.getImage("imagenes/juegos/juego1943/fondo/fondo5.png");
        img6 = Util.getImage("imagenes/juegos/juego1943/fondo/fondo6.png");
        img7 = Util.getImage("imagenes/juegos/juego1943/fondo/fondo7.png");
        img8 = Util.getImage("imagenes/juegos/juego1943/fondo/fondo8.png");

        img21 = Util.getImage("imagenes/juegos/juego1943/fondo2/fondo1.png");
        img22 = Util.getImage("imagenes/juegos/juego1943/fondo2/fondo2.png");
        img23 = Util.getImage("imagenes/juegos/juego1943/fondo2/fondo3.png");
        img24 = Util.getImage("imagenes/juegos/juego1943/fondo2/fondo4.png");



        int frameWidth = Juego1943.getFrame().getWidth();
        int frameHeight = Juego1943.getFrame().getHeight();
        BufferedImage fondo = new BufferedImage(frameWidth, frameHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics g = fondo.getGraphics();

//        int xOffset = 200;
//        g.drawImage(img1, xOffset, 0, TILE_SIZE, TILE_SIZE, null);
//        g.drawImage(img2, xOffset + TILE_SIZE, 0, TILE_SIZE, TILE_SIZE, null);
//        g.drawImage(img3, xOffset + TILE_SIZE * 2, 0, TILE_SIZE, TILE_SIZE, null);
//        g.drawImage(img4, xOffset + TILE_SIZE * 3, 0, TILE_SIZE, TILE_SIZE, null);
//
//        g.drawImage(img5, xOffset, 0 + TILE_SIZE, TILE_SIZE, TILE_SIZE, null);
//        g.drawImage(img6, xOffset + TILE_SIZE, 0 + TILE_SIZE, TILE_SIZE, TILE_SIZE, null);
//        g.drawImage(img7,  xOffset + TILE_SIZE * 2, 0 + TILE_SIZE, TILE_SIZE, TILE_SIZE, null);
//        g.drawImage(img8, xOffset + TILE_SIZE * 3, 0 + TILE_SIZE, TILE_SIZE, TILE_SIZE, null);
//
//
//
//        g.drawImage(img1, 0, TILE_SIZE * 2, TILE_SIZE, TILE_SIZE, null);
//        g.drawImage(img2, 0 + TILE_SIZE, TILE_SIZE * 2, TILE_SIZE, TILE_SIZE, null);
//        g.drawImage(img3, 0 + TILE_SIZE * 2, TILE_SIZE * 2, TILE_SIZE, TILE_SIZE, null);
//        g.drawImage(img4, 0 + TILE_SIZE * 3, TILE_SIZE * 2, TILE_SIZE, TILE_SIZE, null);
//
//        g.drawImage(img5, 0, TILE_SIZE * 2 + TILE_SIZE, TILE_SIZE, TILE_SIZE, null);
//        g.drawImage(img6, TILE_SIZE, TILE_SIZE * 2 + TILE_SIZE, TILE_SIZE, TILE_SIZE, null);
//        g.drawImage(img7, TILE_SIZE * 2, TILE_SIZE * 2 + TILE_SIZE, TILE_SIZE, TILE_SIZE, null);
//        g.drawImage(img8, TILE_SIZE * 3, TILE_SIZE * 2 + TILE_SIZE, TILE_SIZE, TILE_SIZE, null);



//        for (int altura = 0; altura < frameHeight; altura += TILE_SIZE * 2) {
//            for (int anchura = 0; anchura < frameWidth; anchura += TILE_SIZE * 4) {
//                g.drawImage(img1, anchura, altura, TILE_SIZE, TILE_SIZE, null);
//                g.drawImage(img2, anchura + TILE_SIZE, altura, TILE_SIZE, TILE_SIZE, null);
//                g.drawImage(img3, anchura + TILE_SIZE * 2, altura, TILE_SIZE, TILE_SIZE, null);
//                g.drawImage(img4, anchura + TILE_SIZE * 3, altura, TILE_SIZE, TILE_SIZE, null);
//
//                g.drawImage(img5, anchura, altura + TILE_SIZE, TILE_SIZE, TILE_SIZE, null);
//                g.drawImage(img6, anchura + TILE_SIZE, altura + TILE_SIZE, TILE_SIZE, TILE_SIZE, null);
//                g.drawImage(img7, anchura + TILE_SIZE * 2, altura + TILE_SIZE, TILE_SIZE, TILE_SIZE, null);
//                g.drawImage(img8, anchura + TILE_SIZE * 3, altura + TILE_SIZE, TILE_SIZE, TILE_SIZE, null);
//            }
//        }


        for (int altura = 0; altura < frameHeight; altura += TILE_SIZE * 2) {
            for (int anchura = 0; anchura < frameWidth; anchura += TILE_SIZE * 2) {
                g.drawImage(img21, anchura, altura, TILE_SIZE, TILE_SIZE, null);
                g.drawImage(img22, anchura + TILE_SIZE, altura, TILE_SIZE, TILE_SIZE, null);

                g.drawImage(img23, anchura, altura + TILE_SIZE, TILE_SIZE, TILE_SIZE, null);
                g.drawImage(img24, anchura + TILE_SIZE, altura + TILE_SIZE, TILE_SIZE, TILE_SIZE, null);
            }
        }

        g.dispose();

        this.setPosicion(0, 0);
        this.setImagen(fondo);
    }
    @Override
    public void update(double delta) {

    }
}
