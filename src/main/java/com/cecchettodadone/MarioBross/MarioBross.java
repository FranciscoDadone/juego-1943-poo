package com.cecchettodadone.MarioBross;

import com.cecchettodadone.lanzador.Juego;

import javax.swing.*;

public class MarioBross extends Juego {

    public MarioBross() {
        setNombre("Mario Bross");
        setVersion("1.0");
        setDescripcion("Juego de un Fontanero");
        setDesarrolladores("Ramiro Cecchetto y Francisco Dadone");
        setImagenPortada(new ImageIcon(this.getClass().getResource("/MarioBross.png")));
    }

    @Override
    public void run() {

    }
}
