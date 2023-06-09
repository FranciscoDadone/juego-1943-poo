package com.cecchettodadone.juego1943.objetosGraficos.bonus;

import com.cecchettodadone.juego1943.Juego1943;
import com.cecchettodadone.juego1943.Util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

public class Escopeta extends Bonus implements Bonusable{

    private BufferedImage img1, img2, img3, img4;

    public Escopeta(int posX, int posY) {

        img1 = Util.getImage("imagenes/juegos/juego1943/bonus/escopeta/escopeta1.png");
        img2 = Util.getImage("imagenes/juegos/juego1943/bonus/escopeta/escopeta2.png");
        img3 = Util.getImage("imagenes/juegos/juego1943/bonus/escopeta/escopeta3.png");
        img4 = Util.getImage("imagenes/juegos/juego1943/bonus/escopeta/escopeta4.png");

        this.setPosicion(posX, posY);
        this.setDimensiones(new Dimension(16*3,10*3));
    }

    int counter = 0;
    @Override
    public void update(double delta) {
        double posicion = getY() + delta * 100;
        this.setPosicion(getX(), posicion);

        switch ((int)(counter * delta)) {
            case 0:
                setImagen(img1);
                break;
            case 1:
                setImagen(img2);
                break;
            case 2:
                setImagen(img2);
                break;
            case 3:
                setImagen(img3);
                break;
        }

        if ((int)(counter * delta) == 4)
            counter = 0;
        else
            counter += 14;
    }

    int tiempo = 0;
    @Override
    public void action() {
        Timer timer = new Timer();

        if (timer != null)
            timer.cancel();

        Juego1943.avion.setEscopeta(true);
        Juego1943.avion.setAlcance(true);
        Juego1943.avion.setTiroAncho(true);

        if (Juego1943.avion.isEscopeta() && Juego1943.avion.isAlcance() && Juego1943.avion.isTiroAncho())
            tiempo = 20000;
        else
            tiempo = 10000;

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Juego1943.avion.setAlcance(false);
                Juego1943.avion.setEscopeta(false);
                Juego1943.avion.setTiroAncho(false);
            }
        }, 10000);
    }
}














