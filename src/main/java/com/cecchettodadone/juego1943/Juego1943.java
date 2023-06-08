package com.cecchettodadone.juego1943;

import com.cecchettodadone.juego1943.configuracion.Menu;
import com.cecchettodadone.juego1943.objetosGraficos.*;
import com.cecchettodadone.juego1943.objetosGraficos.bonus.Ametralladora;
import com.cecchettodadone.juego1943.objetosGraficos.bonus.Bonus;
import com.cecchettodadone.juego1943.objetosGraficos.enemigos.Ataque;
import com.cecchettodadone.juego1943.objetosGraficos.enemigos.AvionEnemigoRojo;
import com.cecchettodadone.juego1943.objetosGraficos.enemigos.AvionEnemigoVerde;
import com.cecchettodadone.juego1943.objetosGraficos.enemigos.Yamato;
import com.cecchettodadone.lanzador.Juego;
import com.entropyinteractive.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

public class Juego1943 extends Juego {
    private static JGame frame;
    public static ArrayList<ObjetoGrafico> objetosGraficos = new ArrayList<>();
    public static ArrayList<Municion> municiones = new ArrayList<>();
    public static ArrayList<Municion> municionesEnemigo = new ArrayList<>();
    public static ArrayList<ObjetoGrafico> enemigos = new ArrayList<>();
    public static ArrayList<Nivel> niveles = new ArrayList<>();

    public static ArrayList<Bonus> bonus = new ArrayList<>();
    public static Vida vidaJugador;
    public static Yamato yamato = null;
    private final int FREQ_ENEMIGOS_NORMALES_MS = 2000;
    public static AvionJugador avion;
    public static Nivel nivelActual;

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
                File[] nivelesArr = Util.getFile("niveles").listFiles();
                for (File nivel: nivelesArr) {
                    niveles.add(new Nivel(nivel.getName()));
                }

                nivelActual = niveles.get(0);

                objetosGraficos.add(new FondoJuego());

                avion = new AvionJugador(this.getWidth() / 2, this.getHeight() / 2);
                vidaJugador = new Vida();
                objetosGraficos.add(vidaJugador);

                objetosGraficos.add(new TiempoJuego());
            }

            int counter = 0;
            int c = 0;
            int contadorBonus = 0;

            @Override
            public void gameUpdate(double v) {
                c++;
                vidaJugador.setCantidadVida((vidaJugador.getCantidadVida() - v * 10));
                if (vidaJugador.getCantidadVida() < 0) vidaJugador.setCantidadVida(100);

                for (int i = 0; i < objetosGraficos.size(); i++)
                    objetosGraficos.get(i).update(v);

                for (int i=0 ; i<bonus.size() ; i++)
                    bonus.get(i).update(v);

                avion.update(v);

                if (yamato != null)
                    yamato.update(v);

                boolean b = false;
                for (int i = 0; i < municiones.size(); i++) {
                    municiones.get(i).update(v);
                    ArrayList<ObjetoGrafico> aviones = new ArrayList<>();
                    for (int j = 0; j < enemigos.size(); j++) {
                        if (enemigos.get(j) instanceof GrupoDeAviones<?>) aviones = (ArrayList<ObjetoGrafico>) ((GrupoDeAviones<?>) enemigos.get(j)).getAviones();
                        else aviones.add(enemigos.get(j));

                        for (int k = 0; k < aviones.size(); k++) {
                            if (aviones.get(k).getRectagle().intersects(municiones.get(i).getRectagle())) {
                                municiones.get(i).setDimension(new Dimension(0,0));
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

                for (int i=0 ; i<municiones.size() ; i++) {
                    if (yamato!=null && municiones.get(i).getRectagle().intersects(yamato.getRectagle())) {
                        yamato.recibirDanio(municiones.get(i));
//                        exposiones.add(new Explosion((int)municiones.get(i).getX(),(int)municiones.get(i).getY()));
                        municiones.remove(i);
                    }
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

                            contadorBonus++;

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

                if (contadorBonus == 4){
                    contadorBonus = 0;
                    bonus.add(Bonus.getBonus());
                    //yamato = new Yamato();
                }

                for (int j = 0 ; j<bonus.size() ; j++) {

                    if (bonus.get(j).getY() > getHeight())
                        bonus.remove(j);

                    for (int i=0 ; i<municiones.size() ; i++) {
                        if (bonus.get(j).getRectagle().intersects(municiones.get(i).getRectagle())) {
                            bonus.add(Bonus.getBonus((int)bonus.get(j).getX(),(int)bonus.get(j).getY()));
                            bonus.remove(bonus.get(j));

                        }
                    }

                    if (avion.getRectagle().intersects(bonus.get(j).getRectagle())) {
                        Bonus.action(bonus.get(j));
                        bonus.remove(bonus.get(j));
                    }
                }



                if ((counter * v) * 1000 >= FREQ_ENEMIGOS_NORMALES_MS) {
                    counter = 0;
                    enemigos.add(new GrupoDeAviones<AvionEnemigoRojo>());
                }

                counter++;
            }

            @Override
            public void gameDraw(Graphics2D g) {
                objetosGraficos.forEach((obj) -> {
                    obj.draw(g);
                });

                if (yamato != null)
                    yamato.draw(g);

                avion.draw(g);

                municiones.forEach((obj) -> {
                    obj.draw(g);
                });
                municionesEnemigo.forEach((obj) -> {
                    obj.draw(g);
                });
                enemigos.forEach((obj) -> {
                    obj.draw(g);
                });
                bonus.forEach((obj) -> {
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