package com.cecchettodadone.juego1943.objetosGraficos.enemigos;

import com.cecchettodadone.juego1943.Juego1943;
import com.cecchettodadone.juego1943.Util;
import com.cecchettodadone.juego1943.objetosGraficos.Avion;
import com.cecchettodadone.juego1943.objetosGraficos.BalaEscopeta;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class AvionEnemigoVerde extends Avion {

    private BufferedImage avion, img0, img1, img2, img3, img4, img5, img6, img7;
    EstadoAvionVerde estado = EstadoAvionVerde.ingreso;


    public AvionEnemigoVerde(int posX, int posY) {
        avion = Util.getImage("imagenes/juegos/juego1943/avion_enemigo1/enemigo.png");

        img0 = Util.getImage("imagenes/juegos/juego1943/avion_enemigo1/animacion_avion_verde/animacion0.png");
        img1 = Util.getImage("imagenes/juegos/juego1943/avion_enemigo1/animacion_avion_verde/animacion1.png");
        img2 = Util.getImage("imagenes/juegos/juego1943/avion_enemigo1/animacion_avion_verde/animacion2.png");
        img3 = Util.getImage("imagenes/juegos/juego1943/avion_enemigo1/animacion_avion_verde/animacion3.png");
        img4 = Util.getImage("imagenes/juegos/juego1943/avion_enemigo1/animacion_avion_verde/animacion4.png");
        img5 = Util.getImage("imagenes/juegos/juego1943/avion_enemigo1/animacion_avion_verde/animacion5.png");
        img6 = Util.getImage("imagenes/juegos/juego1943/avion_enemigo1/animacion_avion_verde/animacion6.png");
        img7 = Util.getImage("imagenes/juegos/juego1943/avion_enemigo1/animacion_avion_verde/animacion7.png");

        this.setImagen(avion);
        this.setPosicion(posX, posY);
        this.setDimensiones(new Dimension(75,48));
//        this.setDimensiones(new Dimension(44,40));
        setDesplazamiento(400);
    }

    private void ingreso(double delta) {
        if (moverHaciaPunto(this.getX(),Juego1943.getFrame().getHeight()-this.getImagen().getHeight()*5,delta))
            estado = EstadoAvionVerde.animacion;
    }

    int count = 0;
    private void animacion (double delta) {
        if (moverHaciaPunto(this.getX(),Juego1943.getFrame().getHeight()/3.5,delta)) {
            estado = EstadoAvionVerde.ataque;
        } else {

            switch ((int)(count*delta)) {
                case 0:
                    this.setImagen(img0);
                    break;
                case 1:
                    this.setImagen(img1);
                    break;
                case 2:
                    this.setImagen(img2);
                    break;
                case 3:
                    this.setImagen(img3);
                    break;
                case 4:
                    this.setImagen(img4);
                    break;
                case 5:
                    this.setImagen(img5);
                    break;
                case 6:
                    this.setImagen(img6);
                    break;
                case 7:
                    this.setImagen(img7);
                    break;
                case 8:
                    this.setImagen(avion);
                    break;
            }
            count += 5;

        }
    }

    double posAtaqueX = Juego1943.getFrame().getWidth()/2;
    double posAtaqueY = Juego1943.getFrame().getHeight()/2;
    private void ataque(double delta) {
        Random rand = new Random();

        if (moverHaciaPunto(posAtaqueX, posAtaqueY, delta)) {
            posAtaqueX = this.getImagen().getWidth() + rand.nextDouble(Juego1943.getFrame().getWidth() - this.getImagen().getWidth());
            posAtaqueY = this.getImagen().getHeight() + rand.nextDouble(Juego1943.getFrame().getHeight() - this.getImagen().getHeight() * 1.2);
            disparar();
        }
    }

    private void disparar() {
        if (Juego1943.avion.getY() > (int)this.getY()) {
            Juego1943.municionesEnemigo.add(new BalaEscopeta((int)this.getX(),(int)this.getY(),270,true));
            Juego1943.municionesEnemigo.add(new BalaEscopeta((int)this.getX(),(int)this.getY(),225,true));
            Juego1943.municionesEnemigo.add(new BalaEscopeta((int)this.getX(),(int)this.getY(),315,true));
        } else {
            Juego1943.municionesEnemigo.add(new BalaEscopeta((int)this.getX(),(int)this.getY(),90,true));
            Juego1943.municionesEnemigo.add(new BalaEscopeta((int)this.getX(),(int)this.getY(),45,true));
            Juego1943.municionesEnemigo.add(new BalaEscopeta((int)this.getX(),(int)this.getY(),135,true));
        }
    }


        @Override
    public void update(double delta) {

        this.setDimensiones(new Dimension(this.getImagen().getWidth()*3,this.getImagen().getHeight()*3));

        switch (estado) {
            case ingreso:
                ingreso(delta);
                break;
            case animacion:
                animacion(delta);
                break;
            case ataque:
                ataque(delta);
                break;
        }

    }
}
