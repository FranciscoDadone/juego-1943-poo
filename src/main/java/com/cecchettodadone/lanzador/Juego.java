package com.cecchettodadone.lanzador;

import javax.swing.*;

public abstract class Juego {
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesarrolladores() {
        return desarrolladores;
    }

    public void setDesarrolladores(String desarrolladores) {
        this.desarrolladores = desarrolladores;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ImageIcon getImagenPortada() {
        return imagenPortada;
    }

    public void setImagenPortada(ImageIcon imagenPortada) {
        this.imagenPortada = imagenPortada;
    }

    public abstract void run (double fps);

    private String nombre;
    private String desarrolladores;
    private String version;
    private String descripcion;
    private ImageIcon imagenPortada;

    public boolean isImplementado() {
        return implementado;
    }

    public void setImplementado(boolean implementado) {
        this.implementado = implementado;
    }

    private boolean implementado;

}
