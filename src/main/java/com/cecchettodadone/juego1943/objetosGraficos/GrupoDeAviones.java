package com.cecchettodadone.juego1943.objetosGraficos;

import java.util.ArrayList;
import java.util.Random;

public class GrupoDeAviones {

    public static ArrayList<AvionEnemigo> getFormacionTriangulo (int x, int y) {
        ArrayList<AvionEnemigo> aviones = new ArrayList<>();

        aviones.add(new AvionEnemigo(x, y));
        aviones.add(new AvionEnemigo(x + 100, y + 100));
        aviones.add(new AvionEnemigo(x + 200, y + 200));
        aviones.add(new AvionEnemigo(x + 300, y + 100));
        aviones.add(new AvionEnemigo(x + 400, y));

        return aviones;
    }

    public static ArrayList<AvionEnemigo> getFormacionFila (int x, int y) {
        ArrayList<AvionEnemigo> aviones = new ArrayList<>();

        for (int i = 0; i < new Random().nextInt(8) + 2; i++) {
            aviones.add(new AvionEnemigo(x, (y - 400) + 80 * i));
        }

        return aviones;
    }

}
