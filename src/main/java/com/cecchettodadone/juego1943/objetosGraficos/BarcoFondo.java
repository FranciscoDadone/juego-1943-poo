package com.cecchettodadone.juego1943.objetosGraficos;

import com.cecchettodadone.juego1943.Juego1943;
import com.cecchettodadone.juego1943.ObjetoGrafico;
import com.cecchettodadone.juego1943.Util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class BarcoFondo extends ObjetoGrafico {

    BufferedImage img;
    public BarcoFondo() {
        Random rand = new Random();

        img = Util.getImage("imagenes/juegos/juego1943/barquitos_fondo/barco"+rand.nextInt(2)+".png");
        this.setImagen(img);

        this.setDimensiones(new Dimension(this.getImagen().getWidth()*3,this.getImagen().getHeight()*3));
        this.setPosicion(rand.nextDouble(Juego1943.getFrame().getWidth()),-100);
    }

    @Override
    public void update(double delta) {
        moverHaciaPunto(getX(),Juego1943.getFrame().getHeight()+getImagen().getHeight(),delta);
    }
}
