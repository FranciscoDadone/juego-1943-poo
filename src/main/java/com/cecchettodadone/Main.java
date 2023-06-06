package com.cecchettodadone;

import com.cecchettodadone.juego1943.Juego1943;
import com.cecchettodadone.juego1943.configuracion.Configurador;
import com.cecchettodadone.lanzador.SistemaDeJuego;


public class Main {
    public static void main(String[] args) {
//        new SistemaDeJuego();
        new Juego1943().run(1/60.0);
    }
}


