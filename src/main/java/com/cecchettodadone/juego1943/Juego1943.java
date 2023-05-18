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
    Mapa mapa = new Mapa();
    final double NAVE_DESPLAZAMIENTO = 150;

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
        JGame jgame = new JGame("1943", 842/2, 1683/2) { //842 x 1683

            @Override
            public void gameStartup() {
                try {
                    BufferedImage mapaImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("imagenes/fondo.jpg"));
                    double escala = getHeight() / (double) mapaImage.getHeight(); // Calcular escala en función de la altura del frame
                    int nuevoAncho = (int) (mapaImage.getWidth() * escala); // Calcular nuevo ancho manteniendo la proporción
                    int nuevoAlto = getHeight(); // Mantener la altura original del frame
                    BufferedImage mapaResized = resizeImage(mapaImage, nuevoAncho, nuevoAlto);

                    mapa.setImagen(mapaResized);
                    mapa.setSize(getWidth(), getHeight());
                    player.setImagen(ImageIO.read(getClass().getClassLoader().getResourceAsStream("imagenes/PrimerAvion.png")));
                    player.setPosicion(getWidth() / 2, getHeight() / 2);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

            @Override
            public void gameUpdate(double v) {

                Keyboard tecla = this.getKeyboard();

                boolean moverArriba = tecla.isKeyPressed(KeyEvent.VK_UP);       //Lo hice asi para que la velocidad
                boolean moverAbajo = tecla.isKeyPressed(KeyEvent.VK_DOWN);      //en diagonal sea igual que para
                boolean moverIzquierda = tecla.isKeyPressed(KeyEvent.VK_LEFT);  //algun lado
                boolean moverDerecha = tecla.isKeyPressed(KeyEvent.VK_RIGHT);

                double velocidadX = 0;
                double velocidadY = 0;

                if (moverArriba && !moverAbajo) {
                    velocidadY = -NAVE_DESPLAZAMIENTO;
                }

                if (moverAbajo && !moverArriba) {
                    velocidadY = NAVE_DESPLAZAMIENTO;
                }

                if (moverIzquierda && !moverDerecha) {
                    velocidadX = -NAVE_DESPLAZAMIENTO;
                }

                if (moverDerecha && !moverIzquierda) {
                    velocidadX = NAVE_DESPLAZAMIENTO;
                }


                if (velocidadX != 0 && velocidadY != 0) {
                    double magnitud = Math.sqrt(velocidadX * velocidadX + velocidadY * velocidadY);
                    velocidadX = (int) (velocidadX / magnitud * NAVE_DESPLAZAMIENTO);
                    velocidadY = (int) (velocidadY / magnitud * NAVE_DESPLAZAMIENTO);
                }

                player.setPosicionX(player.getX() + velocidadX * v);
                player.setPosicionY(player.getY() + velocidadY * v);

                player.update(v);

            }

            @Override
            public void gameDraw(Graphics2D g) {

                mapa.draw(g);
                player.draw(g);

            }

            private BufferedImage resizeImage(BufferedImage originalImage, int newWidth, int newHeight) {
                BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = resizedImage.createGraphics();
                g2d.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
                g2d.dispose();
                return resizedImage;
            }

            @Override
            public void gameShutdown() {
                Log.info(getClass().getSimpleName(), "Shutting down game");
            }
        };

        jgame.getFrame().setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        new Thread() {
            public void run() {
                jgame.run(1.0 / 60.0);
            }
        }.start();


    }
}

class Avion extends ObjetoGrafico{ }
