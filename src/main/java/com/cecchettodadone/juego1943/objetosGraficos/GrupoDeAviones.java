package com.cecchettodadone.juego1943.objetosGraficos;

import com.cecchettodadone.juego1943.Juego1943;
import com.cecchettodadone.juego1943.ObjetoGrafico;
import com.cecchettodadone.juego1943.objetosGraficos.enemigos.Ataque;
import com.cecchettodadone.juego1943.objetosGraficos.enemigos.AvionEnemigoRojo;
import com.cecchettodadone.juego1943.objetosGraficos.enemigos.AvionEnemigoVerde;
import com.cecchettodadone.juego1943.objetosGraficos.enemigos.TipoAvion;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GrupoDeAviones<T> extends ObjetoGrafico {

    private ArrayList<T> aviones;
    private Random rand = new Random();

    public GrupoDeAviones () {
//        String [] enemigos = Juego1943.nivelActual.getPropiedades().get("enemigos");
        TipoAvion t = (rand.nextInt(2) > 0) ? TipoAvion.ROJO : TipoAvion.VERDE;
        switch (rand.nextInt(4)) {
            case 0:
                aviones = getFormacionTriangulo(rand.nextInt(Juego1943.getFrame().getWidth()), -100, t);
                break;
            case 1:
                aviones = getFormacionFila(rand.nextInt(Juego1943.getFrame().getWidth()), -100, t);
                break;
            case 2:
                aviones = getFormacionTrianguloIzquierda(rand.nextInt(Juego1943.getFrame().getHeight() / 2), t);
                break;
            case 3:
                aviones = getFormacionTrianguloDerecha(rand.nextInt(Juego1943.getFrame().getHeight() / 2), t);
                break;
        }

    }


    private ArrayList<T> getFormacionTriangulo (int x, int y, TipoAvion t) {
        ArrayList<T> aviones = new ArrayList<>();

        if (t == TipoAvion.ROJO) {
            aviones.add((T) new AvionEnemigoRojo(x, y, Ataque.DE_ARRIBA));
            aviones.add((T) new AvionEnemigoRojo(x + 100, y + 100, Ataque.DE_ARRIBA));
            aviones.add((T) new AvionEnemigoRojo(x + 200, y + 200, Ataque.DE_ARRIBA));
            aviones.add((T) new AvionEnemigoRojo(x + 300, y + 100, Ataque.DE_ARRIBA));
            aviones.add((T) new AvionEnemigoRojo(x + 400, y, Ataque.DE_ARRIBA));
        } else if (t == TipoAvion.VERDE) {
            aviones.add((T) new AvionEnemigoVerde(x, y));
            aviones.add((T) new AvionEnemigoVerde(x + 100, y + 100));
            aviones.add((T) new AvionEnemigoVerde(x + 200, y + 200));
            aviones.add((T) new AvionEnemigoVerde(x + 300, y + 100));
            aviones.add((T) new AvionEnemigoVerde(x + 400, y));
        }

        return aviones;
    }

    private ArrayList<T> getFormacionFila (int x, int y, TipoAvion t) {
        ArrayList<T> aviones = new ArrayList<>();

        for (int i = 0; i < new Random().nextInt(8) + 2; i++) {
            if (t == TipoAvion.ROJO) {
                aviones.add((T) new AvionEnemigoRojo(x, (y - 400) + 80 * i, Ataque.DE_ARRIBA));
            } else if (t == TipoAvion.VERDE) {
                aviones.add((T) new AvionEnemigoVerde(x, (y - 400) + 80 * i));
            }
        }

        return aviones;
    }

    private ArrayList<T> getFormacionTrianguloIzquierda (int y, TipoAvion t) {
        ArrayList<T> aviones = new ArrayList<>();
        if (t != TipoAvion.ROJO) return aviones;

        aviones.add((T) new AvionEnemigoRojo(0, y, Ataque.DE_IZQUIERDA));
        aviones.add((T) new AvionEnemigoRojo(50, y + 50, Ataque.DE_IZQUIERDA));
        aviones.add((T) new AvionEnemigoRojo(100, y + 100, Ataque.DE_IZQUIERDA));
        aviones.add((T) new AvionEnemigoRojo(50, y + 150, Ataque.DE_IZQUIERDA));
        aviones.add((T) new AvionEnemigoRojo(0, y + 200, Ataque.DE_IZQUIERDA));

        return aviones;
    }

    private ArrayList<T> getFormacionTrianguloDerecha (int y, TipoAvion t) {
        ArrayList<T> aviones = new ArrayList<>();
        if (t != TipoAvion.ROJO) return aviones;

        int w = Juego1943.getFrame().getWidth() + 100;

        aviones.add((T) new AvionEnemigoRojo(w, y, Ataque.DE_DERECHA));
        aviones.add((T) new AvionEnemigoRojo(w - 50, y + 50, Ataque.DE_DERECHA));
        aviones.add((T) new AvionEnemigoRojo(w - 100, y + 100, Ataque.DE_DERECHA));
        aviones.add((T) new AvionEnemigoRojo(w - 50, y + 150, Ataque.DE_DERECHA));
        aviones.add((T) new AvionEnemigoRojo(w, y + 200, Ataque.DE_DERECHA));

        return aviones;
    }

    public ArrayList<T> getAviones() {
        return aviones;
    }

    @Override
    public void update(double delta) {
        aviones.forEach((av) -> ((Avion)av).update(delta));
    }

    @Override
    public void draw (Graphics2D g) {
        aviones.forEach((av) -> ((Avion)av).draw(g));
    }
}
