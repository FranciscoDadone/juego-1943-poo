package com.cecchettodadone.juego1943.objetosGraficos;

import com.cecchettodadone.juego1943.Juego1943;
import com.cecchettodadone.juego1943.objetosGraficos.enemigos.Ataque;
import com.cecchettodadone.juego1943.objetosGraficos.enemigos.AvionEnemigoRojo;
import com.cecchettodadone.juego1943.objetosGraficos.enemigos.AvionEnemigoVerde;

import java.util.ArrayList;
import java.util.Random;

public class GrupoDeAviones {

    public static ArrayList<AvionEnemigoVerde> getFormacionTriangulo (int x, int y) {
        ArrayList<AvionEnemigoVerde> aviones = new ArrayList<>();

        aviones.add(new AvionEnemigoVerde(x, y));
        aviones.add(new AvionEnemigoVerde(x + 100, y + 100));
        aviones.add(new AvionEnemigoVerde(x + 200, y + 200));
        aviones.add(new AvionEnemigoVerde(x + 300, y + 100));
        aviones.add(new AvionEnemigoVerde(x + 400, y));

        return aviones;
    }

    public static ArrayList<AvionEnemigoVerde> getFormacionFila (int x, int y) {
        ArrayList<AvionEnemigoVerde> aviones = new ArrayList<>();

        for (int i = 0; i < new Random().nextInt(8) + 2; i++) {
            aviones.add(new AvionEnemigoVerde(x, (y - 400) + 80 * i));
        }

        return aviones;
    }

    public static ArrayList<AvionEnemigoRojo> getFormacionTrianguloRojoIzquierda (int y) {
        ArrayList<AvionEnemigoRojo> aviones = new ArrayList<>();

        aviones.add(new AvionEnemigoRojo(0, y, Ataque.DE_IZQUIERDA));
        aviones.add(new AvionEnemigoRojo(50, y + 50, Ataque.DE_IZQUIERDA));
        aviones.add(new AvionEnemigoRojo(100, y + 100, Ataque.DE_IZQUIERDA));
        aviones.add(new AvionEnemigoRojo(50, y + 150, Ataque.DE_IZQUIERDA));
        aviones.add(new AvionEnemigoRojo(0, y + 200, Ataque.DE_IZQUIERDA));

        return aviones;
    }

    public static ArrayList<AvionEnemigoRojo> getFormacionTrianguloRojoDerecha (int y) {
        ArrayList<AvionEnemigoRojo> aviones = new ArrayList<>();

        int w = Juego1943.getFrame().getWidth() + 100;

        aviones.add(new AvionEnemigoRojo(w, y, Ataque.DE_DERECHA));
        aviones.add(new AvionEnemigoRojo(w - 50, y + 50, Ataque.DE_DERECHA));
        aviones.add(new AvionEnemigoRojo(w - 100, y + 100, Ataque.DE_DERECHA));
        aviones.add(new AvionEnemigoRojo(w - 50, y + 150, Ataque.DE_DERECHA));
        aviones.add(new AvionEnemigoRojo(w, y + 200, Ataque.DE_DERECHA));

        return aviones;
    }

}
