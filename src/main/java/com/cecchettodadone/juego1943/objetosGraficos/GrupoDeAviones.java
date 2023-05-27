package com.cecchettodadone.juego1943.objetosGraficos;

import java.util.ArrayList;

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

}
