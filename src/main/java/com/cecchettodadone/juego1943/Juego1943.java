package com.cecchettodadone.juego1943;

import com.cecchettodadone.juego1943.configuracion.Configurador;
import com.cecchettodadone.juego1943.configuracion.Menu;
import com.cecchettodadone.juego1943.objetosGraficos.AvionEnemigo;
import com.cecchettodadone.juego1943.objetosGraficos.AvionJugador;
import com.cecchettodadone.juego1943.objetosGraficos.FondoJuego;
import com.cecchettodadone.lanzador.Juego;
import com.entropyinteractive.*;
import com.sun.jdi.event.MethodEntryEvent;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Juego1943 extends Juego {
    private AvionJugador avionJugador;
    private AvionEnemigo enemigo;
    private FondoJuego fondoJuego;
    private static JGame frame;
    public static ArrayList<ObjetoGrafico> objetosGraficos = new ArrayList<>();


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
                fondoJuego = new FondoJuego();
                avionJugador = new AvionJugador(this.getWidth() / 2, this.getHeight() / 2);
                enemigo = new AvionEnemigo(this.getWidth() / 2, this.getHeight() / 2);

                objetosGraficos.add(fondoJuego);
                objetosGraficos.add(avionJugador);
                objetosGraficos.add(enemigo);
            }

            @Override
            public void gameUpdate(double v) {
                for (int i = 0; i < objetosGraficos.size(); i++) {
                    objetosGraficos.get(i).update(v);
                    if (objetosGraficos.get(i).getY() < -500) objetosGraficos.remove(i);
                }
            }

            @Override
            public void gameDraw(Graphics2D g) {
//                fondoJuego.draw(g);
//                avionJugador.draw(g);
//                enemigo.draw(g);
                objetosGraficos.forEach((obj) -> {
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
