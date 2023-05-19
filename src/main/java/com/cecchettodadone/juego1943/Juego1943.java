package com.cecchettodadone.juego1943;

import com.cecchettodadone.juego1943.configuracion.Configurador;
import com.cecchettodadone.juego1943.configuracion.Menu;
import com.cecchettodadone.juego1943.objetosGraficos.AvionJugador;
import com.cecchettodadone.juego1943.objetosGraficos.FondoJuego;
import com.cecchettodadone.lanzador.Juego;
import com.entropyinteractive.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Juego1943 extends Juego {
    private AvionJugador avionJugador;
    private FondoJuego fondoJuego;
    private static JGame frame;


    public Juego1943() {
        setNombre("1943");
        setDesarrolladores("Ramiro Cecchetto y Francisco Dadone");
        setVersion("1.0");
        setDescripcion("Juego de batalla");
        setImagenPortada(new ImageIcon(this.getClass().getResource("/imagenes/juegos/juego1943/juego1943.png")));
        setImplementado(true);
    }

    public static void main(String args[]) {
        new Juego1943().run(60);
    }

    public void run(){
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
            }

            @Override
            public void gameUpdate(double v) {
                avionJugador.update(v);
                fondoJuego.update(v);
            }

            @Override
            public void gameDraw(Graphics2D g) {
                fondoJuego.draw(g);
                avionJugador.draw(g);
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
