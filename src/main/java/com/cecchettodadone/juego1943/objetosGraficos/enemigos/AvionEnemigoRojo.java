package com.cecchettodadone.juego1943.objetosGraficos.enemigos;

import com.cecchettodadone.juego1943.Util;
import com.cecchettodadone.juego1943.objetosGraficos.Avion;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AvionEnemigoRojo extends Avion {
    private BufferedImage imgNormal, imgDerecha, imgDerecha45, imgDerechaAbajo45, imgAbajo, imgIzquierdaAbajo45, imgIzquierda, imgIzquierda45;
    private Ataque ataque;

    public AvionEnemigoRojo (int posX, int posY, Ataque ataque) {
        imgNormal = Util.getImage("imagenes/juegos/juego1943/avion_enemigo1/avion_enemigo_rojo1.png");
        imgDerecha = Util.getImage("imagenes/juegos/juego1943/avion_enemigo1/avion_enemigo_rojo3.png");
        imgDerecha45 = Util.getImage("imagenes/juegos/juego1943/avion_enemigo1/avion_enemigo_rojo2.png");
        imgDerechaAbajo45 = Util.getImage("imagenes/juegos/juego1943/avion_enemigo1/avion_enemigo_rojo4.png");
        imgAbajo = Util.getImage("imagenes/juegos/juego1943/avion_enemigo1/avion_enemigo_rojo5.png");
        imgIzquierdaAbajo45 = Util.getImage("imagenes/juegos/juego1943/avion_enemigo1/avion_enemigo_rojo6.png");
        imgIzquierda = Util.getImage("imagenes/juegos/juego1943/avion_enemigo1/avion_enemigo_rojo7.png");
        imgIzquierda45 = Util.getImage("imagenes/juegos/juego1943/avion_enemigo1/avion_enemigo_rojo8.png");

        this.ataque = ataque;
        this.setPosicion(posX, posY);
        this.setDimensiones(new Dimension(44,40));
        setDesplazamiento(400);
    }

    @Override
    public void update(double delta) {
        switch (ataque) {
            case DE_IZQUIERDA:
                setImagen(imgDerecha);
                setPosicionX(getX() + getDesplazamiento() * delta);
                break;
            case DE_DERECHA:
                setImagen(imgIzquierda);
                setPosicionX(getX() - getDesplazamiento() * delta);
                break;
            case DE_ARRIBA:
                setImagen(imgAbajo);
                setPosicionY(getY() + getDesplazamiento() * delta);
                break;
        }
    }
}
