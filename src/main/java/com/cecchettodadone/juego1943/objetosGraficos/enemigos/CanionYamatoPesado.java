package com.cecchettodadone.juego1943.objetosGraficos.enemigos;

import com.cecchettodadone.juego1943.Juego1943;
import com.cecchettodadone.juego1943.ObjetoGrafico;
import com.cecchettodadone.juego1943.Util;
import com.cecchettodadone.juego1943.objetosGraficos.AvionJugador;
import com.cecchettodadone.juego1943.objetosGraficos.BalaYamato;

import java.awt.*;
import java.awt.image.BufferedImage;

public class CanionYamatoPesado extends ObjetoGrafico {


    BufferedImage[] img = new BufferedImage[16];
    Yamato yamato;
    AvionJugador avion = Juego1943.avion;

    public CanionYamatoPesado(Yamato yamato) {

        for (int i=0 ; i<img.length ; i++)
            img[i] = Util.getImage("imagenes/juegos/juego1943/Yamato/canion_pesado/pesado" +i+".png");


        this.yamato = yamato;
        this.setDimensiones(new Dimension((int)(22*1.5),(int)(25*1.5)));
    }

    private double calcularAngulo() {
        if (avion == null) return 0;
        double deltaX = (avion.getX() + avion.getImagen().getWidth()*0.7) - this.getX();
        double deltaY = (avion.getY() + avion.getImagen().getHeight()*0.6) - this.getY();

        double radianes = Math.atan2(deltaY, deltaX);
        double angulo = Math.toDegrees(radianes);

        if (angulo < 0) {
            angulo += 360;
        }

        return angulo;
    }

    private void disparar() {
        Juego1943.municionesEnemigo.add(new BalaYamato((int)this.getX(),(int)this.getY(),calcularAngulo()));
    }

    int count = 0;
    @Override
    public void update(double delta) {

        this.setPosicion(yamato.getX() + yamato.img.getWidth()*0.25,yamato.getY() + yamato.img.getHeight()*0.7);

        this.setImagen(img[((int)Util.map((float)calcularAngulo(),0,360,0,15))]);

        if ((int)(count*delta) == 1) {
            disparar();
            count = 0;
        }

        count += 2;

    }
}
