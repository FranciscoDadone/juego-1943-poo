package com.cecchettodadone.juego1943;


import com.cecchettodadone.juego1943.ObjetoGrafico;
import com.cecchettodadone.lanzador.Juego;
import com.entropyinteractive.*;
import javax.imageio.ImageIO;
import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import javax.print.attribute.standard.MediaSize;
import javax.swing.*;
import java.awt.*;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.security.Key;
import java.util.LinkedList;

public class Juego1943 extends Juego    {

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

                Keyboard tecla = this.getKeyboard();
//                Keyboard tecla = new Keyboard();
                System.out.println(tecla);

                if (tecla.isKeyPressed(KeyEvent.VK_UP)) {
                    player.setPosicionY(player.getY() - NAVE_DESPLAZAMIENTO * fps);
                }

                if (tecla.isKeyPressed(KeyEvent.VK_DOWN)) {
                    player.setPosicionY(player.getY() + NAVE_DESPLAZAMIENTO * fps);
                }

                if (tecla.isKeyPressed(KeyEvent.VK_LEFT)) {
                    player.setPosicionX(player.getX() - NAVE_DESPLAZAMIENTO * fps);
                }

                if (tecla.isKeyPressed(KeyEvent.VK_RIGHT)) {
                    player.setPosicionX(player.getX() + NAVE_DESPLAZAMIENTO * fps);
                }

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

class Avion extends ObjetoGrafico{ }
