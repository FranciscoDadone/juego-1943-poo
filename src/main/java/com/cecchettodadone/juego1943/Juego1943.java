package com.cecchettodadone.juego1943;

import com.cecchettodadone.juego1943.objetosGraficos.AvionJugador;
import com.cecchettodadone.lanzador.Juego;
import com.entropyinteractive.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Juego1943 extends Juego {
    private AvionJugador avionJugador;
    private BufferedImage img_fondo = null;
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

    @Override
    public void run(double fps) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.frame = new JGame("1943", screenSize.width,screenSize.height) {

            @Override
            public void gameStartup() {
                try {
                    img_fondo = ImageIO.read(getClass().getClassLoader().getResourceAsStream("imagenes/juegos/juego1943/fondo/fondo1.png"));
                } catch (Exception e) {
                    System.out.println(e);
                }
                avionJugador = new AvionJugador(this.getWidth(), this.getHeight());
            }

            @Override
            public void gameUpdate(double v) {
                Keyboard teclado = this.getKeyboard();
                avionJugador.update(v, teclado);
            }

            @Override
            public void gameDraw(Graphics2D g) {
                g.drawImage(img_fondo, 0, 0, 800, 600, null);
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
