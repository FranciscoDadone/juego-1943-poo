package com.cecchettodadone.juego1943;

import com.entropyinteractive.Keyboard;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public abstract class ObjetoGrafico {

    BufferedImage imagen = null;
    private Point2D.Double posicion  = new Point2D.Double();
    private Dimension dimensiones;

    public abstract void update (double delta);

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

    public Dimension getDimensiones () {
        return this.dimensiones;
    }
    public Rectangle getRectagle () {
        return new Rectangle((int)this.getX(), (int)this.getY(), this.getDimensiones().width, this.getDimensiones().height);
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

    public void rotarImagen(double grados) {
        BufferedImage imagenRotada = new BufferedImage(imagen.getWidth(), imagen.getHeight(), BufferedImage.TYPE_INT_ARGB);

        Graphics2D g = imagenRotada.createGraphics();

        AffineTransform at = new AffineTransform();
        at.setToRotation(Math.toRadians(grados), imagen.getWidth() / 2, imagen.getHeight() / 2);
        g.drawImage(imagen, at, null);
        g.dispose();

        double radianes = Math.toRadians(grados);
        double seno = Math.abs(Math.sin(radianes));
        double coseno = Math.abs(Math.cos(radianes));
        int anchoRotado = (int) Math.round(imagen.getWidth() * coseno + imagen.getHeight() * seno);
        int altoRotado = (int) Math.round(imagen.getWidth() * seno + imagen.getHeight() * coseno);

        BufferedImage imagenAjustada = new BufferedImage(anchoRotado, altoRotado, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gAjustado = imagenAjustada.createGraphics();
        gAjustado.drawImage(imagenRotada, (anchoRotado - imagenRotada.getWidth()) / 2, (altoRotado - imagenRotada.getHeight()) / 2, null);
        gAjustado.dispose();

        this.imagen = imagenAjustada;
    }


    double centroX = 0;
    double centroY = 0;
    public boolean moverHaciaPunto(double x, double y, double delta) {
        double deltaX = x - centroX;
        double deltaY = y - centroY;
        double distancia = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

        double angulo = Math.atan2(deltaY, deltaX);

        double distanciaMovimiento = 200 * delta; //200 es la velocidad

        if (distanciaMovimiento >= distancia) {
            this.setPosicion(x - imagen.getWidth() / 2, y - imagen.getHeight() / 2);
            return true;
        } else {
            double movimientoX = distanciaMovimiento * Math.cos(angulo);
            double movimientoY = distanciaMovimiento * Math.sin(angulo);

            centroX += movimientoX;
            centroY += movimientoY;
            this.setPosicion(centroX - imagen.getWidth() / 2, centroY - imagen.getHeight() / 2);
            return false;
        }
    }




    public void draw(Graphics2D g) {
        if (this.dimensiones != null) g.drawImage(imagen, (int) posicion.getX(), (int) posicion.getY(), this.dimensiones.width, this.dimensiones.height, null);
        else g.drawImage(imagen,(int)posicion.getX(),(int)posicion.getY(),null);
    }
}
