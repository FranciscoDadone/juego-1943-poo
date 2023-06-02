package com.cecchettodadone.juego1943;

import com.cecchettodadone.juego1943.configuracion.Menu;
import com.cecchettodadone.juego1943.objetosGraficos.*;
import com.cecchettodadone.juego1943.objetosGraficos.enemigos.Ataque;
import com.cecchettodadone.juego1943.objetosGraficos.enemigos.AvionEnemigoRojo;
import com.cecchettodadone.juego1943.objetosGraficos.enemigos.AvionEnemigoVerde;
import com.cecchettodadone.lanzador.Juego;
import com.entropyinteractive.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Juego1943 extends Juego {
    private static JGame frame;
    public static ArrayList<ObjetoGrafico> objetosGraficos = new ArrayList<>();
    public static ArrayList<Municion> municiones = new ArrayList<>();
    public static ArrayList<Municion> municionesEnemigo = new ArrayList<>();
    public static ArrayList<ObjetoGrafico> enemigos = new ArrayList<>();
    public static Vida vidaJugador;

    private final int FREQ_ENEMIGOS_NORMALES_MS = 2000;

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
        this.frame = new JGame("1943", screenSize.width, screenSize.height) {

            @Override
            public void gameStartup() {
                objetosGraficos.add(new FondoJuego());

                objetosGraficos.add(new PortaAviones(getWidth()/2,getHeight()/4));

                AvionJugador avion = new AvionJugador(this.getWidth() / 2, this.getHeight() / 2);
                objetosGraficos.add(avion);
                objetosGraficos.add(avion.getSombra());


                vidaJugador = new Vida();
                objetosGraficos.add(vidaJugador);
            }

            int counter = 0;
            int c = 0;
            @Override
            public void gameUpdate(double v) {
                c++;
                vidaJugador.setCantidadVida((vidaJugador.getCantidadVida() - v * 10));
                if (vidaJugador.getCantidadVida() < 0) vidaJugador.setCantidadVida(100);

                for (int i = 0; i < objetosGraficos.size(); i++) {
                    objetosGraficos.get(i).update(v);
                }

                boolean b = false;
                for (int i = 0; i < municiones.size(); i++) {
                    municiones.get(i).update(v);
                    ArrayList<ObjetoGrafico> aviones = new ArrayList<>();
                    for (int j = 0; j < enemigos.size(); j++) {
                        if (enemigos.get(j) instanceof GrupoDeAviones<?>) aviones = (ArrayList<ObjetoGrafico>) ((GrupoDeAviones<?>) enemigos.get(j)).getAviones();
                        else aviones.add(enemigos.get(j));

                        for (int k = 0; k < aviones.size(); k++) {
                            if (aviones.get(k).getRectagle().intersects(municiones.get(i).getRectagle())) {
                                objetosGraficos.add(new Explosion((int) aviones.get(k).getX(), (int) aviones.get(k).getY()));
                                if (enemigos.get(j) instanceof GrupoDeAviones<?>) {
                                    ((GrupoDeAviones<?>) enemigos.get(j)).getAviones().remove(aviones.get(k));
                                    break;
                                } else Juego1943.enemigos.remove(enemigos.get(j));
                                Juego1943.municiones.remove(municiones.get(i));
                                b = true;
                                break;
                            }
                        }
                    }
                    if (b) break;
                    if (municiones.get(i).getY() < -500) municiones.remove(i);
                }

                for (int i = 0; i < municionesEnemigo.size(); i++) {
                    municionesEnemigo.get(i).update(v);
                    if (municionesEnemigo.get(i).getY() < -500) municionesEnemigo.remove(i);
                }

                for (int i = 0; i < enemigos.size(); i++) {
                    enemigos.get(i).update(v);

                    if (enemigos.get(i) instanceof GrupoDeAviones<?>) {
                        ArrayList<?> aviones = ((GrupoDeAviones<?>) enemigos.get(i)).getAviones();
                        if (aviones.size() == 0) {
                            System.out.println("Eliminaste un grupo entero");
                            enemigos.remove(i);
                            continue;
                        }

                        for (Object a : aviones) {
                            if (((Avion) a).getY() < -500) {
                                enemigos.remove(i);
                                break;
                            }
                        }

                    }

                    if (enemigos.get(i).getY() < -500) enemigos.remove(i);
                }

                if ((counter * v) * 1000 >= FREQ_ENEMIGOS_NORMALES_MS) {
                    counter = 0;
                    enemigos.add(new GrupoDeAviones<>());
                }

                counter++;
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
