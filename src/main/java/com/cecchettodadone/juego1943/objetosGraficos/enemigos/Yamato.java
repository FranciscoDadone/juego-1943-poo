package com.cecchettodadone.juego1943.objetosGraficos.enemigos;

import com.cecchettodadone.juego1943.Juego1943;
import com.cecchettodadone.juego1943.ObjetoGrafico;
import com.cecchettodadone.juego1943.Util;
import com.cecchettodadone.juego1943.objetosGraficos.Explosion;
import com.cecchettodadone.juego1943.objetosGraficos.Municion;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Yamato extends ObjetoGrafico {

    BufferedImage img = null;
    Explosion explosion = null;
    EstadoYamato estadoYamato;
    CanionYamatoSimple canionSimple = null;
    CanionYamatoPesado canionPesado = null;
    int vida = 1000;

    public Yamato() {
        img = Util.getImage("imagenes/juegos/juego1943/Yamato/yamato1.png");

        this.setImagen(img);
        this.setPosicion(Juego1943.getFrame().getWidth()/2, -img.getHeight());
        this.setDimensiones(new Dimension(111,470));

        estadoYamato = EstadoYamato.animacionInicio;


        canionSimple = new CanionYamatoSimple(this);
        canionPesado = new CanionYamatoPesado(this);
    }

    private void animacionInicio(double delta) {
        if (moverHaciaPunto(Juego1943.getFrame().getWidth()/2,Juego1943.getFrame().getHeight()/2,delta))
            estadoYamato = EstadoYamato.ataque;
    }

    double posAtaqueX = Juego1943.getFrame().getWidth()/4;
    double posAtaqueY = Juego1943.getFrame().getHeight()/3;
    int count = 0;
    private void atacar(double delta) {
        Random rand = new Random();

        if (moverHaciaPunto(posAtaqueX,posAtaqueY,delta)) {
            posAtaqueX = img.getWidth() + rand.nextDouble(Juego1943.getFrame().getWidth()-img.getWidth());
            posAtaqueY = img.getHeight() + rand.nextDouble(Juego1943.getFrame().getHeight()-img.getHeight()*1.2);
        }

    }

    public void recibirDanio(Municion municion) {
        vida -= municion.getDanio();
        explosion = new Explosion((int)municion.getX(),(int)municion.getY());
    }


    @Override
    public void update(double delta) {
        canionSimple.update(delta);
        canionPesado.update(delta);
        if (explosion != null)
            explosion.update(delta);

        this.setPosicion(Juego1943.getFrame().getWidth()/2,Juego1943.getFrame().getHeight()/2 - img.getHeight()/2);


        switch (estadoYamato) {
            case animacionInicio:
                animacionInicio(delta);
                break;
            case ataque:
                atacar(delta);
                break;

        }

    }

    @Override
    public void draw(Graphics2D g) {
        super.draw(g);
        if (explosion != null)
            explosion.draw(g);
        canionSimple.draw(g);
        canionPesado.draw(g);

    }

}
