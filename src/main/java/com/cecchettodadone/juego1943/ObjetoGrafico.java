package com.cecchettodadone.juego1943;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;

public abstract class ObjetoGrafico {

    BufferedImage imagen = null;

    private Point2D.Double posicion  = new Point2D.Double();

    public void update (double delta) {}

    public void setImagen(BufferedImage imagen) {
        this.imagen = imagen;
    }


    public void setPosicionX(double x) {
        this.posicion.x = x;
    }
    public void setPosicionY(double y) {
        this.posicion.y = y;
    }

    public void setPosicion(double x, double y) {
        this.posicion.x = x ;
        this.posicion.y = y ;
    }

    public double getX() {return this.posicion.x;}
    public double getY() {return this.posicion.y;}

    public void draw(Graphics2D g) {
        g.drawImage(imagen,(int)posicion.getX(),(int)posicion.getY(),null);
    }

}
