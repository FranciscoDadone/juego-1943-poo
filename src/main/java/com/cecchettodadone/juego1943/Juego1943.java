package com.cecchettodadone.juego1943;

import com.cecchettodadone.lanzador.Juego;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;

public class Juego1943 extends Juego {

    public Juego1943 () {
        setNombre("1943");
        setDesarrolladores("Ramiro Cecchetto y Francisco Dadone");
        setVersion("1.0");
        setDescripcion("Juego de batalla");
//        System.out.println(this.getClass().getResource("/juego1943.png"));
        setImagenPortada(new ImageIcon(this.getClass().getResource("/juego1943.png")));
    }

}
