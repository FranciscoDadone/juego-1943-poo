package com.cecchettodadone.juego1943.objetosGraficos;

import com.cecchettodadone.juego1943.ObjetoGrafico;
import com.cecchettodadone.juego1943.Util;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Municion extends ObjetoGrafico {

    protected double velocidad;
    protected int direccion;
    protected int danio;
    protected BufferedImage img;

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public int getDanio() {
        return danio;
    }

    public void setDanio(int danio) {
        this.danio = danio;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public void setDimension(Dimension dim) {
        this.setDimensiones(dim);
    }

    public Municion (int posX, int posY, BufferedImage img, Dimension dim) {
        this.setImagen(img);
        this.setPosicion(posX, posY);
        this.setDimensiones(dim);
    }
}
