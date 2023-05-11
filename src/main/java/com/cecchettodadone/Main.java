package com.cecchettodadone;

import com.cecchettodadone.lanzador.SistemaDeJuego;

public class Main {
    public static void main(String[] args) {
        System.out.println("asd");
        new SistemaDeJuego().run(1.0 / 60.0);
        System.exit(0);
    }
}
