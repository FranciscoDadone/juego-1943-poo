package com.cecchettodadone.juego1943;

import com.cecchettodadone.juego1943.configuracion.Configurador;
import com.cecchettodadone.juego1943.configuracion.Menu;
import com.cecchettodadone.juego1943.objetosGraficos.AvionEnemigo;
import com.cecchettodadone.juego1943.objetosGraficos.AvionJugador;
import com.cecchettodadone.juego1943.objetosGraficos.FondoJuego;
import com.cecchettodadone.juego1943.objetosGraficos.Municion;
import com.cecchettodadone.lanzador.Juego;
import com.entropyinteractive.*;
import com.sun.jdi.event.MethodEntryEvent;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Juego1943 extends Juego {
    private static JGame frame;
    public static ArrayList<ObjetoGrafico> objetosGraficos = new ArrayList<>();

    public static ArrayList<Municion> municiones = new ArrayList<>();
    public static ArrayList<Municion> municionesEnemigo = new ArrayList<>();
    public static ArrayList<AvionEnemigo> enemigos = new ArrayList<>();

    public Juego1943() {
        setNombre("1943");
        setDesarrolladores("Ramiro Cecchetto y Francisco Dadone");
        setVersion("1.0");
        setDescripcion("Juego de batalla");
        setImagenPortada(new ImageIcon(this.getClass().getResource("/imagenes/juegos/juego1943/juego1943.png")));
        setImplementado(true);
    }

    public void run() {
        new Menu(this);
    }

    @Override
    public void run(double fps) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.frame = new JGame("1943", screenSize.width,screenSize.height) {

            @Override
            public void gameStartup() {
                objetosGraficos.add(new FondoJuego());
                objetosGraficos.add(new AvionJugador(this.getWidth() / 2, this.getHeight() / 2));
                enemigos.add(new AvionEnemigo(this.getWidth() / 2, this.getHeight() / 2));
            }

            @Override
            public void gameUpdate(double v) {
                for (int i = 0; i < objetosGraficos.size(); i++) {
                    objetosGraficos.get(i).update(v);
                }

                for (int i = 0; i < municiones.size(); i++) {
                    municiones.get(i).update(v);
                    for (int j = 0; j < enemigos.size(); j++) {
                        if (enemigos.get(j).getRectagle().contains(municiones.get(i).getRectagle())) {
                            Juego1943.enemigos.remove(enemigos.get(j));
                        }
                    }
                    if (municiones.get(i).getY() < -500) municiones.remove(i);
                }

                for (int i = 0; i < municionesEnemigo.size(); i++) {
                    municionesEnemigo.get(i).update(v);
                    if (municionesEnemigo.get(i).getY() < -500) municionesEnemigo.remove(i);
                }

                for (int i = 0; i < enemigos.size(); i++) {
                    enemigos.get(i).update(v);
                    if (enemigos.get(i).getY() < -500) enemigos.remove(i);
                }
            }

            @Override
            public void gameDraw(Graphics2D g) {
                objetosGraficos.forEach((obj) -> {
                    obj.draw(g);
                });
                municiones.forEach((obj) -> {
                    obj.draw(g);
                });
                municionesEnemigo.forEach((obj) -> {
                    obj.draw(g);
                });
                enemigos.forEach((obj) -> {
                    obj.draw(g);
                });
            }

            @Override
            public void gameShutdown() {
                Log.info(getClass().getSimpleName(), "Shutting down game");
            }
        };
        frame.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        new Thread(() -> frame.run(1.0 / Util.FRAME_RATE)).start();
    }

    public static JGame getFrame () {
        return frame;
    }
}
