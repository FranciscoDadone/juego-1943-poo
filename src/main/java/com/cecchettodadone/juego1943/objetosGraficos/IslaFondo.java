package com.cecchettodadone.juego1943.objetosGraficos;

import com.cecchettodadone.juego1943.Juego1943;
import com.cecchettodadone.juego1943.ObjetoGrafico;
import com.cecchettodadone.juego1943.Util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class IslaFondo extends ObjetoGrafico {

    BufferedImage img;

    public IslaFondo() {
        img = Util.getImage("imagenes/juegos/juego1943/isla_fondo/isla.png");
        this.setImagen(img);

        this.setDimensiones(new Dimension(117*5,124*5));

        Random rand = new Random();
        this.setPosicion(rand.nextDouble(Juego1943.getFrame().getWidth()),-700);
        this.rotarImagen(rand.nextDouble(360));
    }

    double pos = 0;
    @Override
    public void update(double delta) {
        double pos = this.getY() + delta * 200.0;
        this.setPosicionY(pos);
    }
}
