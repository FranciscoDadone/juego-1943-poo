package com.cecchettodadone.juego1943.objetosGraficos.bonus;

import com.cecchettodadone.juego1943.Juego1943;
import com.cecchettodadone.juego1943.Util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

public class SuperShell extends Bonus implements Bonusable{

    private BufferedImage img1, img2, img3, img4;

    public SuperShell(int posX, int posY) {

        img1 = Util.getImage("imagenes/juegos/juego1943/bonus/super_shell/super_shell1.png");
        img2 = Util.getImage("imagenes/juegos/juego1943/bonus/super_shell/super_shell2.png");
        img3 = Util.getImage("imagenes/juegos/juego1943/bonus/super_shell/super_shell3.png");
        img4 = Util.getImage("imagenes/juegos/juego1943/bonus/super_shell/super_shell4.png");

        this.setPosicion(posX, posY);
        this.setDimensiones(new Dimension(8*3,8*3));
    }

    int counter = 0;
    @Override
    public void update(double delta) {

        double posicion = getY() + delta * 100;
        this.setPosicion(getX(),posicion);

        switch ((int)(counter * delta)) {
            case 0:
                setImagen(img1);
                break;
            case 1:
                setImagen(img2);
                break;
            case 2:
                setImagen(img3);
                break;
            case 3:
                setImagen(img4);
                break;
        }
        counter += 7;

        if ((int)(counter * delta) == 4)
            counter = 0;
    }

    int tiempo = 0;
    @Override
    public void action() {
        Timer timer = new Timer();

        if (timer != null)
            timer.cancel();

        Juego1943.avion.setSuperShell(true);

        if (Juego1943.avion.isSuperShell())
            tiempo = 20000;
        else
            tiempo = 10000;

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Juego1943.avion.setSuperShell(false);
            }
        }, tiempo);


    }
}
