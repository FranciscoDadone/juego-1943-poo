package com.cecchettodadone.juego1943;

import com.cecchettodadone.lanzador.Juego;
import com.entropyinteractive.JGame;
import com.entropyinteractive.Keyboard;
import com.entropyinteractive.Log;

import javax.imageio.ImageIO;
import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import javax.print.attribute.standard.MediaSize;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class Juego1943 extends Juego {

    Avion player = new Avion();
    BufferedImage img_fondo = null;
    final double NAVE_DESPLAZAMIENTO = 150.0;

    double fps;
    public Juego1943 () {
        setNombre("1943");
        setDesarrolladores("Ramiro Cecchetto y Francisco Dadone");
        setVersion("1.0");
        setDescripcion("Juego de batalla");
        setImagenPortada(new ImageIcon(this.getClass().getResource("/imagenes/juego1943.png")));
        setImplementado(true);
    }

    @Override
    public void run(double fps) {
        JGame jgame = new JGame("1943", 800, 600) {

            @Override
            public void gameStartup() {
                try {

                    img_fondo = ImageIO.read(getClass().getClassLoader().getResourceAsStream("imagenes/fondo.jpg"));
                    player.setImagen(ImageIO.read(getClass().getClassLoader().getResourceAsStream("imagenes/PrimerAvion.png")));
                    player.setPosicion(getWidth()/2,getHeight()/2);

                } catch (Exception e) {
                    System.out.println(e);
                }

            }

            @Override
            public void gameUpdate(double v) {

                System.out.println(getKeyboard());
                /*
                if (tecla.isKeyPressed(KeyEvent.VK_UP)) {
                    player.setPosiciony(player.getY() - NAVE_DESPLAZAMIENTO * fps);
                }

                if (tecla.isKeyPressed(KeyEvent.VK_DOWN)) {
                    player.setPosiciony(player.getY() + NAVE_DESPLAZAMIENTO * fps);
                }

                if (tecla.isKeyPressed(KeyEvent.VK_LEFT)) {
                    player.setPosicionX(player.getX() - NAVE_DESPLAZAMIENTO * fps);
                }

                if (tecla.isKeyPressed(KeyEvent.VK_RIGHT)) {
                    player.setPosicionX(player.getX() + NAVE_DESPLAZAMIENTO * fps);
                }

                 */

                player.update(fps);

            }

            @Override
            public void gameDraw(Graphics2D g) {
                g.drawImage(img_fondo,0,0,null);
                player.draw(g);



            }

            @Override
            public void gameShutdown() {
                Log.info(getClass().getSimpleName(), "Shutting down game");
            }
        };
        jgame.run(fps);

    }

}

class Avion {

    BufferedImage imagen = null;
    private Point2D.Double posicion  = new Point2D.Double();

    public Avion() {}

    public void setImagen(BufferedImage imagen) {
        this.imagen = imagen;
    }

    public void setPosicion(double x,double y) {
        this.posicion.x = x;
        this.posicion.y = y;
    }
    public void setPosicionX(double x) {
        posicion.x = x;
    }
    public void setPosiciony(double y) {
        posicion.y = y;
    }

    public double getX(){
        return posicion.getX();
    }

    public double getY(){
        return posicion.getY();
    }

    public void update (double delta) {}

    public void draw(Graphics2D g) {
        g.drawImage(imagen,(int)posicion.getX(),(int)posicion.getY(),null);
    }

}
