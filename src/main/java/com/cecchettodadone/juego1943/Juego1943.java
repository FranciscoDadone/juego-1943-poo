package com.cecchettodadone.juego1943;

import com.cecchettodadone.lanzador.Juego;
import com.entropyinteractive.JGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public class Juego1943 extends Juego {

    Avion player = new Avion();

    BufferedImage img_fondo = null;
    public Juego1943 () {
        setNombre("1943");
        setDesarrolladores("Ramiro Cecchetto y Francisco Dadone");
        setVersion("1.0");
        setDescripcion("Juego de batalla");
        setImagenPortada(new ImageIcon(this.getClass().getResource("/imagenes/juego1943.png")));
    }

    @Override
    public void run() {
        new JGame("1943", 800, 800) {



            @Override
            public void gameStartup() {
                try {

                    img_fondo = ImageIO.read(getClass().getClassLoader().getResourceAsStream("imagenes/fondo.jpg"));
                    player.setImagen(ImageIO.read(getClass().getClassLoader().getResourceAsStream("imagenes/PrimerAvion.png")));


                } catch (Exception e) {
                    System.out.println(e);
                }

            }

            @Override
            public void gameUpdate(double v) {

            }

            @Override
            public void gameDraw(Graphics2D g) {
                g.drawImage(img_fondo,0,0,null);

            }

            @Override
            public void gameShutdown() {

            }
        };
    }
}

class Avion {

    BufferedImage imagen = null;

    private Point2D.Double posicion  = new Point2D.Double();

    public void setImagen(BufferedImage imagen) {
        this.imagen = imagen;
    }

    public void setPosicion(double x,double y) {
        this.posicion.x = x;
        this.posicion.y = y;
    }

    public void setPosicionX(double x) {
        this.posicion.x = x;
    }
    public void setPosiciony(double y) {
        this.posicion.y = y;
    }

    public void draw(Graphics2D g) {
        g.drawImage(imagen,(int)posicion.getX(),(int)posicion.getY(),null);
    }

}
