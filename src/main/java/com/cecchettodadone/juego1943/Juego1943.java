package com.cecchettodadone.juego1943;

import com.cecchettodadone.juego1943.audio.Sonido;
import com.cecchettodadone.juego1943.configuracion.Menu;
import com.cecchettodadone.juego1943.objetosGraficos.*;
import com.cecchettodadone.juego1943.objetosGraficos.bonus.Bonus;
import com.cecchettodadone.juego1943.objetosGraficos.enemigos.AvionEnemigoRojo;
import com.cecchettodadone.juego1943.objetosGraficos.enemigos.Yamato;
import com.cecchettodadone.lanzador.Juego;
import com.entropyinteractive.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class Juego1943 extends Juego {
    private static JGame frame;
    public static ArrayList<ObjetoGrafico> objetosGraficos = new ArrayList<>();
    public static ArrayList<Municion> municiones = new ArrayList<>();
    public static ArrayList<Municion> municionesEnemigo = new ArrayList<>();

    public static ArrayList<ObjetoGrafico> enemigos = new ArrayList<>();
    public static ArrayList<Nivel> niveles = new ArrayList<>();

    public static ArrayList<Bonus> bonus = new ArrayList<>();
    public static Vida vidaJugador;
    public static Puntos puntosJugador;
    public static TiempoJuego tiempoJuego;
    public static Yamato yamato = null;
    private final int FREQ_ENEMIGOS_NORMALES_MS = 5000;
    private final int FRECUENCIA_ISLAS = 10000;
    private final int FRECUENCIA_BARQUITOS = 2000;
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
                //objetosGraficos.add(new IslaFondo());

                avion = new AvionJugador(this.getWidth() / 2, this.getHeight() / 2);
                vidaJugador = new Vida();
                puntosJugador = new Puntos();

                tiempoJuego = new TiempoJuego();
                objetosGraficos.add(tiempoJuego);
                //yamato = new Yamato();
            }

            int counterEnemigos = 0;
            int counterIslas = 0;
            int counterBarquitos = 0;
            int c = 0;
            int contadorBonus = 0;

            @Override
            public void gameUpdate(double v) {
                c++;

                for (int i = 0; i < objetosGraficos.size(); i++) {
                    objetosGraficos.get(i).update(v);
                    if (objetosGraficos.get(i).getY()  > this.getWidth())
                        objetosGraficos.remove(i);
                }


                for (int i = 0; i < bonus.size(); i++)
                    bonus.get(i).update(v);

                avion.update(v);

                vidaJugador.update(v);
                puntosJugador.update(v);

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
                                puntosJugador.agregarPuntos(1);
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

                for (int i = 0; i < municiones.size(); i++) {
                    if (yamato!=null && municiones.get(i).getRectagle().intersects(yamato.getRectagle())) {
                        yamato.recibirDanio(municiones.get(i));
                        municiones.remove(i);
                    }
                }

                for (int i = 0; i < municionesEnemigo.size(); i++) {
                    municionesEnemigo.get(i).update(v);


                    if (avion.getRectagle().intersects(municionesEnemigo.get(i).getRectagle())) {
                        vidaJugador.bajarVida(1);
                        objetosGraficos.add(new Explosion((int) avion.getX(), (int) avion.getY()));
                        municionesEnemigo.remove(municionesEnemigo.get(i));
                        return;
                    }

                    // Verificar si la munición se salió del marco
                    if (municionesEnemigo.get(i).getY() < -municionesEnemigo.get(i).getY()
                            || municionesEnemigo.get(i).getY() > screenSize.height
                            || municionesEnemigo.get(i).getX() < -municionesEnemigo.get(i).getX()
                            || municionesEnemigo.get(i).getX() > screenSize.width) {
                        municionesEnemigo.remove(i);
                    }
                }

                for (int i = 0; i < enemigos.size(); i++) {
                    enemigos.get(i).update(v);

                    if (enemigos.get(i) instanceof GrupoDeAviones<?>) {
                        ArrayList<?> aviones = ((GrupoDeAviones<?>) enemigos.get(i)).getAviones();
                        if (aviones.size() == 0) {

                            contadorBonus++;
                            puntosJugador.agregarPuntos(100);

                            enemigos.remove(i);
                            continue;
                        }

                        for (Object a : aviones) {
                            if (((Avion) a).getY() < -500) {
                                break;
                            }
                            if (avion.getRectagle().intersects(((Avion) a).getRectagle())) {
                                aviones.remove(a);
                                objetosGraficos.add(new Explosion((int)((Avion) a).getX(),(int)((Avion) a).getY()));
                                vidaJugador.bajarVida(2);
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

                for (int j = 0; j < bonus.size(); j++) {

                    if (bonus.get(j).getY() > getHeight()) {
                        bonus.remove(j);
                        break;
                    }

                    for (int i = 0; i < municiones.size(); i++) {
                        if (bonus.get(j).getRectagle().intersects(municiones.get(i).getRectagle())) {
                            bonus.add(Bonus.getBonus((int)bonus.get(j).getX(),(int)bonus.get(j).getY()));
                            bonus.remove(bonus.get(j));
                            break;
                        }
                    }

                    if (avion.getRectagle().intersects(bonus.get(j).getRectagle())) {
                        Bonus.action(bonus.get(j));
                        Sonido.iniciar("fx/bonus");
                        bonus.remove(bonus.get(j));
                    }
                }



                if ((counterEnemigos * v) * 1000 >= FREQ_ENEMIGOS_NORMALES_MS) {
                    counterEnemigos = 0;
                    enemigos.add(new GrupoDeAviones<AvionEnemigoRojo>());
                }
                counterEnemigos++;

                if ((counterIslas * v) * 1000 >= FRECUENCIA_ISLAS) {
                    counterIslas = 0;
                    objetosGraficos.add(new IslaFondo());
                }
                counterIslas++;

                if ((counterBarquitos * v) * 1000 >= FRECUENCIA_BARQUITOS) {
                    counterBarquitos = 0;
                    objetosGraficos.add(new BarcoFondo());
                }
                counterBarquitos++;

                if (tiempoJuego.getSegundos() == 0 && !nivelActual.aparecioBoss()) {
                    nivelActual.setAparecioBoss(true);
                    yamato = new Yamato();
                }
            }

            @Override
            public void gameDraw(Graphics2D g) {
                objetosGraficos.forEach((obj) -> {
                    obj.draw(g);
                });

                vidaJugador.draw(g);
                puntosJugador.draw(g);

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
