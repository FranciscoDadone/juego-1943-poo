package com.cecchettodadone.juego1943;

import com.entropyinteractive.Keyboard;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public abstract class ObjetoGrafico {

    BufferedImage imagen = null;
    private Point2D.Double posicion  = new Point2D.Double();
    private Dimension dimensiones;

    public abstract void update (double delta, Keyboard teclado);

    public void setImagen(BufferedImage imagen) {
        this.imagen = imagen;
    }
    public BufferedImage getImagen () {
        return this.imagen;
    }


    public void setPosicionX(double x) {
        this.posicion.x = x;
    }
    public void setPosicionY(double y) {
        this.posicion.y = y;
    }

    public void setDimensiones(Dimension d) {
        this.dimensiones = d;
    }

    public void setDimensiones(int x, int y) {
        this.dimensiones = new Dimension(x, y);
    }

    public void setPosicion(double x, double y) {
        this.posicion.x = x ;
        this.posicion.y = y ;
    }

    public double getX() {return this.posicion.x;}
    public double getY() {return this.posicion.y;}

    public void draw(Graphics2D g) {
        if (this.dimensiones != null) g.drawImage(imagen, (int) posicion.getX(), (int) posicion.getY(), this.dimensiones.width, this.dimensiones.height, null);
        else g.drawImage(imagen,(int)posicion.getX(),(int)posicion.getY(),null);
    }

}
