package com.cecchettodadone.juego1943;

import com.cecchettodadone.lanzador.Juego;
import com.entropyinteractive.JGame;

import javax.swing.*;
import java.awt.*;

public class Juego1943 extends Juego {
    public Juego1943 () {
        setNombre("1943");
        setDesarrolladores("Ramiro Cecchetto y Francisco Dadone");
        setVersion("1.0");
        setDescripcion("Juego de batalla");
        setImagenPortada(new ImageIcon(this.getClass().getResource("/juego1943.png")));
    }

    @Override
    public void run() {
        new JGame("1943", 800, 800) {
            @Override
            public void gameStartup() {

            }

            @Override
            public void gameUpdate(double v) {

            }

            @Override
            public void gameDraw(Graphics2D graphics2D) {

            }

            @Override
            public void gameShutdown() {

            }
        };
    }
}
