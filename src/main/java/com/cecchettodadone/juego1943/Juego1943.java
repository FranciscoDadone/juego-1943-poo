package com.cecchettodadone.juego1943;

import com.cecchettodadone.lanzador.Juego;
import com.entropyinteractive.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Juego1943 extends Juego    {

    Avion player = new Avion();
    BufferedImage img_fondo = null;
    final double NAVE_DESPLAZAMIENTO = 150;

    public Juego1943 () {
        setNombre("1943");
        setDesarrolladores("Ramiro Cecchetto y Francisco Dadone");
        setVersion("1.0");
        setDescripcion("Juego de batalla");
        setImagenPortada(new ImageIcon(this.getClass().getResource("/imagenes/juegos/juego1943/juego1943.png")));
        setImplementado(true);
    }

    @Override
    public void run(double fps) {
        JGame jgame = new JGame("1943", 842/2,1683/2) {

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

                if (tecla.isKeyPressed(KeyEvent.VK_DOWN)) {
                    player.setPosicionY(player.getY() + NAVE_DESPLAZAMIENTO * v);
                }

                if (tecla.isKeyPressed(KeyEvent.VK_UP)) {
                    player.setPosicionY(player.getY() - NAVE_DESPLAZAMIENTO * v);
                }

                if (tecla.isKeyPressed(KeyEvent.VK_LEFT)) {
                    player.setPosicionX(player.getX() - NAVE_DESPLAZAMIENTO * v);
                }

                if (tecla.isKeyPressed(KeyEvent.VK_RIGHT)) {
                    player.setPosicionX(player.getX() + NAVE_DESPLAZAMIENTO * v);
                }

                player.update(v);

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

        new Thread(() -> jgame.run(1.0 / 60.0)).start();

    }
}

class Avion extends ObjetoGrafico{ }
